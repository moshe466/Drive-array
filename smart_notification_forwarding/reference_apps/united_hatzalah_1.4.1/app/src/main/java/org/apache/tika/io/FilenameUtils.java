package org.apache.tika.io;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.tika.metadata.TikaCoreProperties;

/* loaded from: classes.dex */
public class FilenameUtils {
    private static final Pattern ASCII_NUMERIC;
    private static final HashSet<Character> RESERVED = new HashSet<>(38);
    public static final char[] RESERVED_FILENAME_CHARACTERS;

    static {
        char[] cArr = {0, 1, 2, 3, 4, 5, 6, 7, '\b', '\t', '\n', 11, '\f', '\r', 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, '?', ':', '*', '<', '>', '|'};
        RESERVED_FILENAME_CHARACTERS = cArr;
        for (char c4 : cArr) {
            RESERVED.add(Character.valueOf(c4));
        }
        ASCII_NUMERIC = Pattern.compile("\\A\\.(?i)[a-z0-9]{1,5}\\Z");
    }

    public static String getName(String str) {
        if (str != null && !str.isEmpty()) {
            String substring = str.substring(Math.max(str.lastIndexOf(TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER), Math.max(str.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING), str.lastIndexOf("\\"))) + 1);
            if (!substring.equals("..") && !substring.equals(".")) {
                return substring;
            }
        }
        return "";
    }

    public static String getSuffixFromPath(String str) {
        String name = getName(str);
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf > -1 && name.length() - lastIndexOf < 6) {
            String substring = name.substring(lastIndexOf);
            if (ASCII_NUMERIC.matcher(substring).matches()) {
                return substring;
            }
            return "";
        }
        return "";
    }

    public static String normalize(String str) {
        String str2;
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            for (char c4 : str.toCharArray()) {
                if (RESERVED.contains(Character.valueOf(c4))) {
                    sb.append('%');
                    if (c4 < 16) {
                        str2 = "0";
                    } else {
                        str2 = "";
                    }
                    sb.append(str2);
                    sb.append(Integer.toHexString(c4).toUpperCase(Locale.ROOT));
                } else {
                    sb.append(c4);
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("name cannot be null");
    }
}
