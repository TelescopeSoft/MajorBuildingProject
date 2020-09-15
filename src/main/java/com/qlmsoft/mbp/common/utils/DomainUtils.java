package com.qlmsoft.mbp.common.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aaronhuang on 2020/09/15.
 */
public class DomainUtils {

    public static boolean matchDomain(String toVerifyUrl, String domain) {
        boolean result = false;
        String host = null;
        try {
            toVerifyUrl = toVerifyUrl.replaceAll("[\\\\#]", "/"); //替换掉反斜线和井号
            host = new URL(toVerifyUrl).getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (host != null) {
            if (host.endsWith(domain)) {
                result = true;
            } else {
                result = false;
            }
        }

        return result;
    }

    public static boolean matchDomainByUrl(String toVerifyUrl, String originUrl) {
        boolean result = false;
        String originHost = null;
        String host = null;
        try {
            toVerifyUrl = toVerifyUrl.replaceAll("[\\\\#]", "/"); //替换掉反斜线和井号
            host = new URL(toVerifyUrl).getHost();
            originHost = new URL(originUrl).getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            result = false;
        }
        if (host != null && originHost != null) {
            if (host.endsWith(originHost)) {
                result = true;
            } else {
                result = false;
            }
        }

        return result;
    }
}
