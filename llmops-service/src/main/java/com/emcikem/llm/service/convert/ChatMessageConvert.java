package com.emcikem.llm.service.convert;

import com.emcikem.llm.common.enums.ChatMessageRoleTypeEnum;
import com.emcikem.llm.dao.entity.LlmOpsChatHistoryDO;
import com.google.common.collect.Lists;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.UserMessage;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Create with Emcikem on 2025/1/18
 *
 * @author Emcikem
 * @version 1.0.0
 */
public class ChatMessageConvert {

    public static List<ChatMessage> convert2ChatMessageListFromDO(List<LlmOpsChatHistoryDO> historyDOList) {
        if (CollectionUtils.isEmpty(historyDOList)) {
            return Lists.newArrayList();
        }
        return historyDOList.stream().map(ChatMessageConvert::convert2ChatMessageFromDO).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static ChatMessage convert2ChatMessageFromDO(LlmOpsChatHistoryDO historyDO) {
        if (historyDO == null) {
            return null;
        }
        return ChatMessageDeserializer.messageFromJson(historyDO.getContent());
    }
}
