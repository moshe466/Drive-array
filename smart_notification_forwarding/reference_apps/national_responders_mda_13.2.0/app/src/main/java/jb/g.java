package jb;

import mb.r;

/* loaded from: classes.dex */
public final class g {
    public static final f a(String str) {
        boolean w10;
        boolean w11;
        boolean w12;
        boolean w13;
        y8.k.e(str, "value");
        w10 = r.w(str, "0x", false, 2, null);
        if (!w10) {
            w11 = r.w(str, "0X", false, 2, null);
            if (!w11) {
                w12 = r.w(str, "0b", false, 2, null);
                if (!w12) {
                    w13 = r.w(str, "0B", false, 2, null);
                    if (!w13) {
                        return new f(str, 10);
                    }
                }
                String substring = str.substring(2);
                y8.k.d(substring, "(this as java.lang.String).substring(startIndex)");
                return new f(substring, 2);
            }
        }
        String substring2 = str.substring(2);
        y8.k.d(substring2, "(this as java.lang.String).substring(startIndex)");
        return new f(substring2, 16);
    }
}
