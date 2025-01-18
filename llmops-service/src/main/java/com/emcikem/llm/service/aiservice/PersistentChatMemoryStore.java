package com.emcikem.llm.service.aiservice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emcikem.llm.dao.entity.LlmOpsChatHistoryDO;
import com.emcikem.llm.dao.mapper.LlmOpsChatHistoryDOMapper;
import com.emcikem.llm.service.convert.ChatMessageConvert;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

@Service
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
            return ChatMessageConvert.convert2ChatMessageListFromDO(records);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> messages) {
        // TODO: Implement updating all messages in the persistent store by memory ID.
        // ChatMessageSerializer.messageToJson(ChatMessage) and
        // ChatMessageSerializer.messagesToJson(List<ChatMessage>) helper methods can be used to
        // easily serialize chat messages into JSON.
    }

    @Override
    public void deleteMessages(Object memoryId) {
        // TODO: Implement deleting all messages in the persistent store by memory ID.
    }
}
