package com.emcikem.llm.service.util;

import com.emcikem.llm.service.constant.JieBaStopWord;
import com.google.common.collect.Lists;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Create with Emcikem on 2025/4/27
 *
 * @author Emcikem
 * @version 1.0.0
 */
public class JieBaUtil {

    /**
     * 输入文本，提取对应文本的关键词列表
     * @param text
     * @param maxKeyWordPreChunk
     * @return
     */
    public static List<String> extractKeyWords(String text, Integer maxKeyWordPreChunk) {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<SegToken> tokens = segmenter.process(text, JiebaSegmenter.SegMode.SEARCH);
        return tokens.stream().filter(x -> !JieBaStopWord.JIE_BA_STOP_WORD_SET.contains(x.word))
                .limit(maxKeyWordPreChunk)
                .map(x -> x.word)
                .toList();
    }

    public static void main(String[] args) {
        String text = "为了提倡社交产品的流量，让用户主动分享APP中的内容到社交平台来达到拉新和促活的目的，市场上的绝大多数APP都有第三发分享的功能，它是内容分发的最有效途径，并且大大降低了企";
        List<String> strings = extractKeyWords(text, 10);
        System.out.println(strings);
    }
}
