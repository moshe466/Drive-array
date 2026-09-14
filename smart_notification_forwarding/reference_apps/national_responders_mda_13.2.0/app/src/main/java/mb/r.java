package mb;

import java.util.Locale;
import m8.g0;

/* loaded from: classes.dex */
public class r extends q {
    public static String k(String str) {
        y8.k.e(str, "<this>");
        Locale locale = Locale.getDefault();
        y8.k.d(locale, "getDefault()");
        return l(str, locale);
    }

    public static final String l(String str, Locale locale) {
        y8.k.e(str, "<this>");
        y8.k.e(locale, "locale");
        if (!(str.length() > 0)) {
            return str;
        }
        char charAt = str.charAt(0);
        if (!Character.isLowerCase(charAt)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        char titleCase = Character.toTitleCase(charAt);
        if (titleCase != Character.toUpperCase(charAt)) {
            sb2.append(titleCase);
        } else {
            String substring = str.substring(0, 1);
            y8.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            y8.k.c(substring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = substring.toUpperCase(locale);
            y8.k.d(upperCase, "this as java.lang.String).toUpperCase(locale)");
            sb2.append(upperCase);
        }
        String substring2 = str.substring(1);
        y8.k.d(substring2, "this as java.lang.String).substring(startIndex)");
        sb2.append(substring2);
        String sb3 = sb2.toString();
        y8.k.d(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public static String m(String str) {
        y8.k.e(str, "<this>");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        String substring = str.substring(0, 1);
        y8.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        y8.k.c(substring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = substring.toLowerCase();
        y8.k.d(lowerCase, "this as java.lang.String).toLowerCase()");
        sb2.append(lowerCase);
        String substring2 = str.substring(1);
        y8.k.d(substring2, "this as java.lang.String).substring(startIndex)");
        sb2.append(substring2);
        return sb2.toString();
    }

    public static final boolean n(String str, String str2, boolean z10) {
        y8.k.e(str, "<this>");
        y8.k.e(str2, "suffix");
        return !z10 ? str.endsWith(str2) : p(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean o(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return n(str, str2, z10);
    }

    public static final boolean p(String str, int i10, String str2, int i11, int i12, boolean z10) {
        y8.k.e(str, "<this>");
        y8.k.e(str2, "other");
        return !z10 ? str.regionMatches(i10, str2, i11, i12) : str.regionMatches(z10, i10, str2, i11, i12);
    }

    public static String q(CharSequence charSequence, int i10) {
        y8.k.e(charSequence, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i10 + '.').toString());
        }
        if (i10 == 0) {
            return "";
        }
        if (i10 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                cArr[i11] = charAt;
            }
            return new String(cArr);
        }
        StringBuilder sb2 = new StringBuilder(charSequence.length() * i10);
        g0 it = new d9.c(1, i10).iterator();
        while (it.hasNext()) {
            it.b();
            sb2.append(charSequence);
        }
        String sb3 = sb2.toString();
        y8.k.d(sb3, "{\n                    va…tring()\n                }");
        return sb3;
    }

    public static final String r(String str, char c10, char c11, boolean z10) {
        String sb2;
        String str2;
        y8.k.e(str, "<this>");
        if (z10) {
            StringBuilder sb3 = new StringBuilder(str.length());
            for (int i10 = 0; i10 < str.length(); i10++) {
                char charAt = str.charAt(i10);
                if (b.d(charAt, c10, z10)) {
                    charAt = c11;
                }
                sb3.append(charAt);
            }
            sb2 = sb3.toString();
            str2 = "StringBuilder(capacity).…builderAction).toString()";
        } else {
            sb2 = str.replace(c10, c11);
            str2 = "this as java.lang.String…replace(oldChar, newChar)";
        }
        y8.k.d(sb2, str2);
        return sb2;
    }

    public static final String s(String str, String str2, String str3, boolean z10) {
        int a10;
        y8.k.e(str, "<this>");
        y8.k.e(str2, "oldValue");
        y8.k.e(str3, "newValue");
        int i10 = 0;
        int G = s.G(str, str2, 0, z10);
        if (G < 0) {
            return str;
        }
        int length = str2.length();
        a10 = d9.f.a(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb2 = new StringBuilder(length2);
        do {
            sb2.append((CharSequence) str, i10, G);
            sb2.append(str3);
            i10 = G + length;
            if (G >= str.length()) {
                break;
            }
            G = s.G(str, str2, G + a10, z10);
        } while (G > 0);
        sb2.append((CharSequence) str, i10, str.length());
        String sb3 = sb2.toString();
        y8.k.d(sb3, "stringBuilder.append(this, i, length).toString()");
        return sb3;
    }

    public static /* synthetic */ String t(String str, char c10, char c11, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return r(str, c10, c11, z10);
    }

    public static /* synthetic */ String u(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return s(str, str2, str3, z10);
    }

    public static final boolean v(String str, String str2, boolean z10) {
        y8.k.e(str, "<this>");
        y8.k.e(str2, "prefix");
        return !z10 ? str.startsWith(str2) : p(str, 0, str2, 0, str2.length(), z10);
    }

    public static /* synthetic */ boolean w(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return v(str, str2, z10);
    }
}
