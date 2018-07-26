package com.qlmsoft.mbp.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aaronhuang on 2018/7/25.
 */
public class RegUtils {

    public static Pattern EXPROPRIATION_INFO_VIEW_PATTERN = Pattern
            .compile("(?<=checkReplyFile\\(\\')[^\\'\\)]+");

    public static String abstractStringByPattern(String input, Pattern pattern) {
        String result = null;
        Matcher matter = pattern.matcher(input);
        while (matter.find()) {
            result = matter.group();
        }
        return result;
    }

    public static String abstractStringByPattern(String input, String patternStr) {
        String result = null;
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matter = pattern.matcher(input);
        while (matter.find()) {
            result = matter.group();
        }
        return result;
    }

    public static List<String> abstractListByPattern(String input, String patternStr) {
        List<String> result = new ArrayList<String>();
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matter = pattern.matcher(input);
        while (matter.find()) {
            result.add(matter.group());
        }
        return result;
    }

}
