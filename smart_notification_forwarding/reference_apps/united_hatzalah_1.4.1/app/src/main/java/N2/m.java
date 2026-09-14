package N2;

/* loaded from: classes.dex */
public abstract class m extends l {
    public static Integer F(String str) {
        boolean z3;
        int i;
        int i3;
        kotlin.jvm.internal.j.e(str, "<this>");
        int length = str.length();
        if (length != 0) {
            int i4 = 0;
            char charAt = str.charAt(0);
            int i5 = -2147483647;
            if (kotlin.jvm.internal.j.f(charAt, 48) < 0) {
                i = 1;
                if (length != 1) {
                    if (charAt != '+') {
                        if (charAt == '-') {
                            i5 = Integer.MIN_VALUE;
                            z3 = true;
                        } else {
                            return null;
                        }
                    } else {
                        z3 = false;
                    }
                } else {
                    return null;
                }
            } else {
                z3 = false;
                i = 0;
            }
            int i6 = -59652323;
            while (i < length) {
                int digit = Character.digit((int) str.charAt(i), 10);
                if (digit >= 0) {
                    if ((i4 < i6 && (i6 != -59652323 || i4 < (i6 = i5 / 10))) || (i3 = i4 * 10) < i5 + digit) {
                        return null;
                    }
                    i4 = i3 - digit;
                    i++;
                } else {
                    return null;
                }
            }
            if (z3) {
                return Integer.valueOf(i4);
            }
            return Integer.valueOf(-i4);
        }
        return null;
    }
}
