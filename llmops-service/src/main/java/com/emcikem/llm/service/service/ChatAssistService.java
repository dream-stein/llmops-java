package com.emcikem.llm.service.service;

import com.emcikem.llm.common.util.GsonUtil;
import com.emcikem.llm.common.vo.ChatVO;
import com.emcikem.llm.dao.entity.LlmOpsChatDialogDO;
import com.emcikem.llm.dao.mapper.LlmOpsChatDialogDOMapper;
import com.emcikem.llm.service.aiservice.Assistant;
import com.emcikem.llm.service.aiservice.factory.AssistantFactory;
import com.google.common.collect.Lists;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Create with Emcikem on 2025/1/20
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class ChatAssistService {

    @Resource
    private LlmOpsChatDialogDOMapper llmOpsChatDialogDOMapper;

    @Resource
    private AssistantFactory assistantFactory;

    public String chat(ChatVO chatVO) {
        // 1. 查询或者新建dialog
        LlmOpsChatDialogDO chatDialogDO = getOrQueryDialog(chatVO);
        // 2. 找到智能体
        Assistant assistant = assistantFactory.getAssistant(chatVO.getModelName());
        // 3. 和ai对话
        return assistant.chat(chatDialogDO.getId(), chatVO.getPrompt());
        // 4. 插入history数据
        // 5. 回写dialog数据

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
        LlmOpsChatDialogDO chatDialogDO = llmOpsChatDialogDOMapper.selectById(chatVO.getDialogId());
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
