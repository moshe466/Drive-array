package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: classes.dex */
public final class o7 {

    /* renamed from: a, reason: collision with root package name */
    static final Charset f5516a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f5517b;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f5517b = bArr;
        ByteBuffer.wrap(bArr);
        q6.b(bArr, 0, bArr.length, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    public static int b(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    public static int c(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T d(T t10) {
        Objects.requireNonNull(t10);
        return t10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object e(Object obj, Object obj2) {
        return ((y8) obj).d().N((y8) obj2).j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T f(T t10, String str) {
        Objects.requireNonNull(t10, str);
        return t10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(y8 y8Var) {
        if (!(y8Var instanceof v5)) {
            return false;
        }
        return false;
    }

    public static boolean h(byte[] bArr) {
        return qa.f(bArr);
    }

    public static String i(byte[] bArr) {
        return new String(bArr, f5516a);
    }

    public static int j(byte[] bArr) {
        int length = bArr.length;
        int a10 = a(length, bArr, 0, length);
        if (a10 == 0) {
            return 1;
        }
        return a10;
    }
}
