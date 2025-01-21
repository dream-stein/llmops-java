package com.emcikem.llm.service.aiservice;

import com.emcikem.llm.dao.entity.LlmOpsChatDialogDO;
import com.emcikem.llm.dao.mapper.LlmOpsChatDialogDOMapper;
import com.google.common.collect.Lists;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class PersistentChatMemoryStore implements ChatMemoryStore {
    @Resource
    private LlmOpsChatDialogDOMapper llmOpsChatDialogDOMapper;

    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        try {
            Long dialogId = (Long) memoryId;
            LlmOpsChatDialogDO llmOpsChatDialogDO = llmOpsChatDialogDOMapper.selectByPrimaryKey(dialogId);
            if (llmOpsChatDialogDO == null) {
                return Lists.newArrayList();
            }
            String content = llmOpsChatDialogDO.getContent();
            return ChatMessageDeserializer.messagesFromJson(content);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> messages) {
        try {
            // 每次删除第一次日志
//            messages = messages.subList(1, messages.size());
            Long dialogId = (Long) memoryId;
            LlmOpsChatDialogDO chatDialogDO = new LlmOpsChatDialogDO();
            chatDialogDO.setId(dialogId);
            chatDialogDO.setUtime(new Date());
            chatDialogDO.setContent(ChatMessageSerializer.messagesToJson(messages));

            llmOpsChatDialogDOMapper.updateByPrimaryKey(chatDialogDO);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteMessages(Object memoryId) {
        log.info("delete");
        // TODO: Implement deleting all messages in the persistent store by memory ID.
    }
}
