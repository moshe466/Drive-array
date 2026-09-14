package hb;

import d9.c;
import java.util.Iterator;
import java.util.Objects;
import mb.r;
import mb.s;
import y8.k;

/* loaded from: classes.dex */
public final class a {
    public static final String a(String str) {
        k.e(str, "<this>");
        boolean z10 = false;
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' <= charAt && charAt <= 'z') {
            z10 = true;
        }
        if (!z10) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        String substring = str.substring(1);
        k.d(substring, "(this as java.lang.String).substring(startIndex)");
        return String.valueOf(upperCase) + substring;
    }

    public static final String b(String str) {
        k.e(str, "<this>");
        boolean z10 = false;
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('A' <= charAt && charAt <= 'Z') {
            z10 = true;
        }
        if (!z10) {
            return str;
        }
        char lowerCase = Character.toLowerCase(charAt);
        String substring = str.substring(1);
        k.d(substring, "(this as java.lang.String).substring(startIndex)");
        return String.valueOf(lowerCase) + substring;
    }

    public static final String c(String str, boolean z10) {
        String m10;
        c D;
        Integer num;
        k.e(str, "<this>");
        if ((str.length() == 0) || !d(str, 0, z10)) {
            return str;
        }
        if (str.length() == 1 || !d(str, 1, z10)) {
            if (z10) {
                return b(str);
            }
            m10 = r.m(str);
            return m10;
        }
        D = s.D(str);
        Iterator<Integer> it = D.iterator();
        while (true) {
            if (!it.hasNext()) {
                num = null;
                break;
            }
            num = it.next();
            if (!d(str, num.intValue(), z10)) {
                break;
            }
        }
        Integer num2 = num;
        if (num2 == null) {
            return e(str, z10);
        }
        int intValue = num2.intValue() - 1;
        String substring = str.substring(0, intValue);
        k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String e10 = e(substring, z10);
        String substring2 = str.substring(intValue);
        k.d(substring2, "(this as java.lang.String).substring(startIndex)");
        return k.j(e10, substring2);
    }

    private static final boolean d(String str, int i10, boolean z10) {
        char charAt = str.charAt(i10);
        return z10 ? 'A' <= charAt && charAt <= 'Z' : Character.isUpperCase(charAt);
    }

    private static final String e(String str, boolean z10) {
        if (z10) {
            return f(str);
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase();
        k.d(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    public static final String f(String str) {
        k.e(str, "<this>");
        StringBuilder sb2 = new StringBuilder(str.length());
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            char charAt = str.charAt(i10);
            i10++;
            if ('A' <= charAt && charAt <= 'Z') {
                charAt = Character.toLowerCase(charAt);
            }
            sb2.append(charAt);
        }
        String sb3 = sb2.toString();
        k.d(sb3, "builder.toString()");
        return sb3;
    }
}
