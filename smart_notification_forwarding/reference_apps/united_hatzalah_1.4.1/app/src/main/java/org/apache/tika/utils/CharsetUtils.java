package org.apache.tika.utils;

import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.tika.metadata.OfficeOpenXMLCore;

/* loaded from: classes.dex */
public class CharsetUtils {
    private static final Map<String, Charset> COMMON_CHARSETS;
    private static Method getCharsetICU;
    private static Method isSupportedICU;
    private static final Pattern CHARSET_NAME_PATTERN = Pattern.compile("[ \\\"]*([^ >,;\\\"]+).*");
    private static final Pattern ISO_NAME_PATTERN = Pattern.compile(".*8859-(\\d+)");
    private static final Pattern CP_NAME_PATTERN = Pattern.compile("cp-(\\d+)");
    private static final Pattern WIN_NAME_PATTERN = Pattern.compile("win-?(\\d+)");

    static {
        HashMap hashMap = new HashMap();
        COMMON_CHARSETS = hashMap;
        Class<?> cls = null;
        getCharsetICU = null;
        isSupportedICU = null;
        initCommonCharsets("Big5", "EUC-JP", "EUC-KR", "x-EUC-TW", "GB18030", "IBM855", "IBM866", "ISO-2022-CN", "ISO-2022-JP", "ISO-2022-KR", "ISO-8859-1", "ISO-8859-2", "ISO-8859-3", "ISO-8859-4", "ISO-8859-5", "ISO-8859-6", "ISO-8859-7", "ISO-8859-8", "ISO-8859-9", "ISO-8859-11", "ISO-8859-13", "ISO-8859-15", "KOI8-R", "x-MacCyrillic", "SHIFT_JIS", "UTF-8", "UTF-16BE", "UTF-16LE", "windows-1251", "windows-1252", "windows-1253", "windows-1255");
        hashMap.put("iso-8851-1", (Charset) hashMap.get("iso-8859-1"));
        hashMap.put("windows", (Charset) hashMap.get("windows-1252"));
        hashMap.put("koi8r", (Charset) hashMap.get("koi8-r"));
        try {
            cls = CharsetUtils.class.getClassLoader().loadClass("com.ibm.icu.charset.CharsetICU");
        } catch (ClassNotFoundException unused) {
        }
        if (cls != null) {
            try {
                getCharsetICU = cls.getMethod("forNameICU", String.class);
                try {
                    isSupportedICU = cls.getMethod("isSupported", String.class);
                } catch (Throwable unused2) {
                }
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
    }

    public static String clean(String str) {
        try {
            return forName(str).name();
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static Charset forName(String str) {
        if (str != null) {
            Matcher matcher = CHARSET_NAME_PATTERN.matcher(str);
            if (matcher.matches()) {
                String group = matcher.group(1);
                String lowerCase = group.toLowerCase(Locale.ENGLISH);
                Map<String, Charset> map = COMMON_CHARSETS;
                Charset charset = map.get(lowerCase);
                if (charset != null) {
                    return charset;
                }
                if (!DevicePublicKeyStringDef.NONE.equals(lowerCase) && !"no".equals(lowerCase)) {
                    Matcher matcher2 = ISO_NAME_PATTERN.matcher(lowerCase);
                    Matcher matcher3 = CP_NAME_PATTERN.matcher(lowerCase);
                    Matcher matcher4 = WIN_NAME_PATTERN.matcher(lowerCase);
                    if (matcher2.matches()) {
                        group = e0.a.d("iso-8859-", matcher2.group(1));
                        charset = map.get(group);
                    } else if (matcher3.matches()) {
                        group = e0.a.d(OfficeOpenXMLCore.PREFIX, matcher3.group(1));
                        charset = map.get(group);
                    } else if (matcher4.matches()) {
                        group = e0.a.d("windows-", matcher4.group(1));
                        charset = map.get(group);
                    }
                    if (charset != null) {
                        return charset;
                    }
                    Method method = getCharsetICU;
                    if (method != null) {
                        try {
                            Charset charset2 = (Charset) method.invoke(null, group);
                            if (charset2 != null) {
                                return charset2;
                            }
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                        }
                    }
                    return Charset.forName(group);
                }
                throw new IllegalCharsetNameException(group);
            }
            throw new IllegalCharsetNameException(str);
        }
        throw new IllegalArgumentException();
    }

    private static Map<String, Charset> initCommonCharsets(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            try {
                Charset forName = Charset.forName(str);
                COMMON_CHARSETS.put(str.toLowerCase(Locale.ENGLISH), forName);
                Iterator<String> it = forName.aliases().iterator();
                while (it.hasNext()) {
                    COMMON_CHARSETS.put(it.next().toLowerCase(Locale.ENGLISH), forName);
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        return hashMap;
    }

    public static boolean isSupported(String str) {
        try {
            Method method = isSupportedICU;
            if (method != null && ((Boolean) method.invoke(null, str)).booleanValue()) {
                return true;
            }
            return Charset.isSupported(str);
        } catch (IllegalCharsetNameException | IllegalArgumentException | Exception unused) {
            return false;
        }
    }
}
