package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
public abstract class q0 {

    /* renamed from: a, reason: collision with root package name */
    public static final E1.b f4147a;

    static {
        o0 o0Var;
        if (n0.f4140e && n0.f4139d && !AbstractC0331c.a()) {
            o0Var = new o0(1);
        } else {
            o0Var = new o0(0);
        }
        f4147a = o0Var;
    }

    public static int a(byte[] bArr, int i, int i3) {
        byte b4 = bArr[i - 1];
        int i4 = i3 - i;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    return d(b4, bArr[i], bArr[i + 1]);
                }
                throw new AssertionError();
            }
            return c(b4, bArr[i]);
        }
        if (b4 > -12) {
            return -1;
        }
        return b4;
    }

    public static int b(String str) {
        int length = str.length();
        int i = 0;
        int i3 = 0;
        while (i3 < length && str.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char charAt = str.charAt(i3);
            if (charAt < 2048) {
                i4 += (127 - charAt) >>> 31;
                i3++;
            } else {
                int length2 = str.length();
                while (i3 < length2) {
                    char charAt2 = str.charAt(i3);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(str, i3) >= 65536) {
                                i3++;
                            } else {
                                throw new p0(i3, length2);
                            }
                        }
                    }
                    i3++;
                }
                i4 += i;
            }
        }
        if (i4 >= length) {
            return i4;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i4 + 4294967296L));
    }

    public static int c(int i, int i3) {
        if (i > -12 || i3 > -65) {
            return -1;
        }
        return i ^ (i3 << 8);
    }

    public static int d(int i, int i3, int i4) {
        if (i > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return (i ^ (i3 << 8)) ^ (i4 << 16);
    }
}
