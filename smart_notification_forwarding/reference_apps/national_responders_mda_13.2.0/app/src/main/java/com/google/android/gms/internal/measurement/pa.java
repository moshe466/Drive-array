package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class pa {
    /* JADX INFO: Access modifiers changed from: private */
    public static void f(byte b10, byte b11, byte b12, byte b13, char[] cArr, int i10) {
        if (o(b11) || (((b10 << 28) + (b11 + 112)) >> 30) != 0 || o(b12) || o(b13)) {
            throw x7.f();
        }
        int i11 = ((b10 & 7) << 18) | ((b11 & 63) << 12) | ((b12 & 63) << 6) | (b13 & 63);
        cArr[i10] = (char) ((i11 >>> 10) + 55232);
        cArr[i10 + 1] = (char) ((i11 & 1023) + 56320);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(byte b10, byte b11, byte b12, char[] cArr, int i10) {
        if (o(b11) || ((b10 == -32 && b11 < -96) || ((b10 == -19 && b11 >= -96) || o(b12)))) {
            throw x7.f();
        }
        cArr[i10] = (char) (((b10 & 15) << 12) | ((b11 & 63) << 6) | (b12 & 63));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(byte b10, byte b11, char[] cArr, int i10) {
        if (b10 < -62 || o(b11)) {
            throw x7.f();
        }
        cArr[i10] = (char) (((b10 & 31) << 6) | (b11 & 63));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(byte b10, char[] cArr, int i10) {
        cArr[i10] = (char) b10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(byte b10) {
        return b10 >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m(byte b10) {
        return b10 < -32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(byte b10) {
        return b10 < -16;
    }

    private static boolean o(byte b10) {
        return b10 > -65;
    }
}
