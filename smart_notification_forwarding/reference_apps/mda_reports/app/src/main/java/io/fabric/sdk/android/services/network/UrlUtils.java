package io.fabric.sdk.android.services.network;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public final class UrlUtils {
    public static final String UTF8 = "UTF8";

    private UrlUtils() {
    }

    public static TreeMap<String, String> getQueryParams(String str, boolean z) {
        String str2;
        String str3;
        TreeMap<String, String> treeMap = new TreeMap<>();
        if (str == null) {
            return treeMap;
        }
        for (String str4 : str.split("&")) {
            String[] split = str4.split("=");
            if (split.length == 2) {
                if (z) {
                    str2 = urlDecode(split[0]);
                    str3 = urlDecode(split[1]);
                } else {
                    str2 = split[0];
                    str3 = split[1];
                }
                treeMap.put(str2, str3);
            } else if (!TextUtils.isEmpty(split[0])) {
                treeMap.put(z ? urlDecode(split[0]) : split[0], "");
            }
        }
        return treeMap;
    }

    public static TreeMap<String, String> getQueryParams(URI uri, boolean z) {
        return getQueryParams(uri.getRawQuery(), z);
    }

    public static String percentEncode(String str) {
        int i;
        String str2;
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String urlEncode = urlEncode(str);
        int length = urlEncode.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = urlEncode.charAt(i2);
            if (charAt == '*') {
                str2 = "%2A";
            } else if (charAt == '+') {
                str2 = "%20";
            } else {
                if (charAt == '%' && (i = i2 + 2) < length && urlEncode.charAt(i2 + 1) == '7' && urlEncode.charAt(i) == 'E') {
                    sb.append('~');
                    i2 = i;
                } else {
                    sb.append(charAt);
                }
                i2++;
            }
            sb.append(str2);
            i2++;
        }
        return sb.toString();
    }

    public static String urlDecode(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLDecoder.decode(str, UTF8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static String urlEncode(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, UTF8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
