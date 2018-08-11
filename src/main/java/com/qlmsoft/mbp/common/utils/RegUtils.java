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

    public static Pattern APPROVE_NUM_PATTERN = Pattern
            .compile("(?<type>.*?)[\\[|【|(|（|〔](?<year>\\d{4})[\\]|】|)|）|〕](?<num>\\d{1,4})");

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

    public static List<String> abstractApproveNum(String approveNum){
        Matcher matcher = APPROVE_NUM_PATTERN.matcher(approveNum);
        String type = null;
        String year = null;
        String num = null;
        while (matcher.find()) {
            type = matcher.group("type");
            year = matcher.group("year");
            num =  matcher.group("num");
        }
        ArrayList<String> result = new ArrayList<String>();
        result.add(type);
        result.add(year);
        result.add(num);
        return result;
    }

}
