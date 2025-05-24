package com.emcikem.llm.service.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create with Emcikem on 2025/5/24
 *
 * @author Emcikem
 * @version 1.0.0
 */
public class TextCleanUtil {

    public static String replace(String text, String patternStr, String replacement) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(replacement);
    }
}
