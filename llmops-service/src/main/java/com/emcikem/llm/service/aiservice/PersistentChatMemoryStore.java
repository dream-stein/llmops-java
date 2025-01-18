package com.emcikem.llm.service.aiservice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emcikem.llm.common.enums.ChatMessageRoleTypeEnum;
import com.emcikem.llm.common.util.GsonUtil;
import com.emcikem.llm.dao.entity.LlmOpsChatHistoryDO;
import com.emcikem.llm.dao.mapper.LlmOpsChatHistoryDOMapper;
import com.emcikem.llm.service.convert.ChatMessageConvert;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.BatchResult;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersistentChatMemoryStore implements ChatMemoryStore {

    @Resource
    private LlmOpsChatHistoryDOMapper llmOpsChatHistoryDOMapper;

    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        try {
            Long dialogId = (Long) memoryId;
            Page<LlmOpsChatHistoryDO> page = new Page<>(0, 20);
            QueryWrapper<LlmOpsChatHistoryDO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("dialog_id", dialogId)
                    .eq("tenant", "1")
                    .orderByDesc("id");

            Page<LlmOpsChatHistoryDO> historyPage = llmOpsChatHistoryDOMapper.selectPage(page, queryWrapper);
            List<LlmOpsChatHistoryDO> records = historyPage.getRecords();
            List<LlmOpsChatHistoryDO> collect = records.stream().map(record -> {
                return GsonUtil.parseList(record.getContent(), LlmOpsChatHistoryDO.class);
            }).flatMap(List::stream).collect(Collectors.toList());

            return ChatMessageConvert.convert2ChatMessageListFromDO(collect);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> messages) {
        List<LlmOpsChatHistoryDO> historyList = messages.stream().map(chatMessage -> {
            LlmOpsChatHistoryDO historyDO = new LlmOpsChatHistoryDO();
            if (chatMessage instanceof AiMessage) {
                historyDO.setRole(ChatMessageRoleTypeEnum.AI.getRole());
            } else if (chatMessage instanceof UserMessage) {
                historyDO.setRole(ChatMessageRoleTypeEnum.USER.getRole());
            }
            historyDO.setContent(ChatMessageSerializer.messageToJson(chatMessage));
            historyDO.setDialogId((Long) memoryId);
            historyDO.setTenant("1");
            historyDO.setCtime(new Date());
            historyDO.setToken(12L);
            historyDO.setCreator("122");
            return historyDO;
        }).collect(Collectors.toList());

        LlmOpsChatHistoryDO llmOpsChatHistoryDO = new LlmOpsChatHistoryDO();
        llmOpsChatHistoryDO.setContent(GsonUtil.toJSONString(historyList));
        llmOpsChatHistoryDO.setDialogId((Long) memoryId);
        llmOpsChatHistoryDO.setTenant("1");
        llmOpsChatHistoryDO.setCtime(new Date());
        llmOpsChatHistoryDO.setToken(12L);
        llmOpsChatHistoryDO.setCreator("122");
        llmOpsChatHistoryDO.setRole(1);

        // TODO:
//        List<LlmOpsChatHistoryDO> llmOpsChatHistoryDOS = historyList.subList(historyList.size() - 1, historyList.size());
        llmOpsChatHistoryDOMapper.insert(llmOpsChatHistoryDO);
    }

    @Override
    public void deleteMessages(Object memoryId) {
        log.info("delete");
        // TODO: Implement deleting all messages in the persistent store by memory ID.
    }
}
