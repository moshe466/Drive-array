package org.apache.tika.utils;

import java.util.List;

/* loaded from: classes.dex */
public class StringUtils {
    public static final String EMPTY = "";
    static int PAD_LIMIT = 10000;
    public static final String SPACE = " ";

    public static boolean isBlank(String str) {
        if (str != null) {
            int length = str.length();
            int i = 0;
            while (i < length) {
                int codePointAt = str.codePointAt(i);
                if (!Character.isWhitespace(codePointAt)) {
                    return false;
                }
                i += Character.charCount(codePointAt);
            }
            return true;
        }
        return true;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            return false;
        }
        return true;
    }

    public static String joinWith(String str, List<String> list) {
        if (list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str2 : list) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(str);
            }
            sb.append(str2);
            i = i3;
        }
        return sb.toString();
    }

    public static String leftPad(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = SPACE;
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= PAD_LIMIT) {
            return leftPad(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i3 = 0; i3 < length2; i3++) {
            cArr[i3] = charArray[i3 % length];
        }
        return new String(cArr).concat(str);
    }

    public static String repeat(char c4, int i) {
        if (i <= 0) {
            return "";
        }
        char[] cArr = new char[i];
        for (int i3 = i - 1; i3 >= 0; i3--) {
            cArr[i3] = c4;
        }
        return new String(cArr);
    }

    public static String repeat(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i <= 0) {
            return "";
        }
        int length = str.length();
        if (i == 1 || length == 0) {
            return str;
        }
        if (length == 1 && i <= PAD_LIMIT) {
            return repeat(str.charAt(0), i);
        }
        int i3 = length * i;
        if (length == 1) {
            return repeat(str.charAt(0), i);
        }
        if (length != 2) {
            StringBuilder sb = new StringBuilder(i3);
            for (int i4 = 0; i4 < i; i4++) {
                sb.append(str);
            }
            return sb.toString();
        }
        char charAt = str.charAt(0);
        char charAt2 = str.charAt(1);
        char[] cArr = new char[i3];
        for (int i5 = (i * 2) - 2; i5 >= 0; i5 -= 2) {
            cArr[i5] = charAt;
            cArr[i5 + 1] = charAt2;
        }
        return new String(cArr);
    }

    public static String leftPad(String str, int i, char c4) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > PAD_LIMIT) {
            return leftPad(str, i, String.valueOf(c4));
        }
        return repeat(c4, length).concat(str);
    }
}
