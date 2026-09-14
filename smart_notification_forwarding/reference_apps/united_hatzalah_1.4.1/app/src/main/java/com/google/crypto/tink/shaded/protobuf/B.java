package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class B {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f4029a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f4030b;

    static {
        Charset.forName("US-ASCII");
        f4029a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f4030b = bArr;
        ByteBuffer.wrap(bArr);
        M1.d.h(bArr, 0, 0, false);
    }

    public static void a(Object obj, String str) {
        if (obj != null) {
        } else {
            throw new NullPointerException(str);
        }
    }

    public static int b(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }
}
