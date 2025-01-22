package com.emcikem.llm.service.service;

import com.emcikem.llm.common.enums.ChatMessageRoleTypeEnum;
import com.emcikem.llm.common.enums.ChatModelEnum;
import com.emcikem.llm.common.util.GsonUtil;
import com.emcikem.llm.common.vo.ChatHistoryVO;
import com.emcikem.llm.common.vo.ChatVO;
import com.emcikem.llm.dao.entity.LlmOpsChatDialogDO;
import com.emcikem.llm.dao.entity.LlmOpsChatHistoryDO;
import com.emcikem.llm.dao.mapper.LlmOpsChatDialogDOMapper;
import com.emcikem.llm.dao.mapper.LlmOpsChatHistoryDOMapper;
import com.emcikem.llm.service.aiservice.Assistant;
import com.emcikem.llm.service.aiservice.factory.AssistantFactory;
import com.google.common.collect.Lists;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * Create with Emcikem on 2025/1/20
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
@Slf4j
public class ChatAssistService {

    @Resource
    private LlmOpsChatDialogDOMapper llmOpsChatDialogDOMapper;

    @Resource
    private LlmOpsChatHistoryDOMapper llmOpsChatHistoryDOMapper;

    @Resource
    private AssistantFactory assistantFactory;

    @Resource
    private ExecutorService historyPool;

    public String chat(ChatVO chatVO) {
        // 1. 查询或者新建dialog
        LlmOpsChatDialogDO chatDialogDO = getOrQueryDialog(chatVO);

        ChatModelEnum chatModelEnum = ChatModelEnum.findByModeId(chatVO.getModelType());
        // 2. 找到智能体
        Assistant assistant = assistantFactory.getAssistant(chatModelEnum.getModelName());
        // 3. 和ai对话
        String aiChat = assistant.chat(chatDialogDO.getId(), chatVO.getPrompt());
        // 4. 插入history数据&&回写dialog
        historyPool.submit(() -> insertHistory(chatVO, aiChat, chatDialogDO.getId()));
        return aiChat;
    }

    private void insertHistory(ChatVO chatVO, String aiChat, Long dialogId) {
        try {
            LlmOpsChatHistoryDO userHistory = buildUserHistory(chatVO, dialogId);
            LlmOpsChatHistoryDO aiHistory = buildAiHistory(chatVO, aiChat, dialogId);

            // TODO:变成batchInsert
            int userResult = llmOpsChatHistoryDOMapper.insertSelective(userHistory);
            int aiResult = llmOpsChatHistoryDOMapper.insertSelective(aiHistory);
            if (userResult < 1 || aiResult < 1) {
                throw new RuntimeException();
            }
        } catch (Exception ex) {
            log.error("insertHistory error, chatVO:{}, aiChat:{}, dialog:{}", chatVO, aiChat, dialogId, ex);
        }
    }

    private LlmOpsChatHistoryDO buildAiHistory(ChatVO chatVO, String aiChat, Long dialogId) {
        LlmOpsChatHistoryDO aiHistory = new LlmOpsChatHistoryDO();
        aiHistory.setRole(ChatMessageRoleTypeEnum.AI.getRole());
        aiHistory.setContent(GsonUtil.toJSONString(aiChat));
        aiHistory.setCtime(new Date());
        aiHistory.setCreator(String.valueOf(chatVO.getTenantId()));
        aiHistory.setTenantId(chatVO.getTenantId());
        aiHistory.setDialogId(dialogId);
        aiHistory.setToken(0L);
        return aiHistory;
    }

    private LlmOpsChatHistoryDO buildUserHistory(ChatVO chatVO, Long dialogId) {
        LlmOpsChatHistoryDO userHistory = new LlmOpsChatHistoryDO();
        userHistory.setRole(ChatMessageRoleTypeEnum.USER.getRole());
        userHistory.setContent(GsonUtil.toJSONString(chatVO.getPrompt()));
        userHistory.setCtime(new Date());
        userHistory.setCreator(String.valueOf(chatVO.getTenantId()));
        userHistory.setTenantId(chatVO.getTenantId());
        userHistory.setDialogId(dialogId);
        userHistory.setToken(0L);
        return userHistory;
    }

    private LlmOpsChatDialogDO getOrQueryDialog(ChatVO chatVO) {
        if (chatVO.getDialogId() == null) {
            // 新建
            LlmOpsChatDialogDO llmOpsChatDialogDO = buildCHatDialogDO(chatVO);
            int insert = llmOpsChatDialogDOMapper.insert(llmOpsChatDialogDO);
            if (insert <= 0) {
                throw new RuntimeException();
            }
            return llmOpsChatDialogDO;
        }
        LlmOpsChatDialogDO chatDialogDO = llmOpsChatDialogDOMapper.selectByPrimaryKey(chatVO.getDialogId());
        if (chatDialogDO == null) {
            throw new RuntimeException();
        }
        return chatDialogDO;
    }

    private LlmOpsChatDialogDO buildCHatDialogDO(ChatVO chatVO) {
        LlmOpsChatDialogDO chatDialogDO = new LlmOpsChatDialogDO();
        chatDialogDO.setTitle("新对话");
        chatDialogDO.setCtime(new Date());
        chatDialogDO.setUtime(new Date());
        chatDialogDO.setOperator(String.valueOf(chatVO.getTenantId()));
        chatDialogDO.setCreator(String.valueOf(chatVO.getTenantId()));
        chatDialogDO.setContent(GsonUtil.toJSONString(Lists.newArrayList()));
        chatDialogDO.setTenantId(chatVO.getTenantId());
        return chatDialogDO;
    }
}
