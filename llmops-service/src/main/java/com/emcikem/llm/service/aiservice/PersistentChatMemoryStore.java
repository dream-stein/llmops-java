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
import org.apache.ibatis.executor.BatchResult;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
//            historyDO.setId(null);
            return historyDO;
        }).collect(Collectors.toList());
        llmOpsChatHistoryDOMapper.insert(historyList);
    }

    @Override
    public void deleteMessages(Object memoryId) {
        // TODO: Implement deleting all messages in the persistent store by memory ID.
    }
}
