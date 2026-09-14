package com.googlecode.androidilbc;

import ic.c;

/* loaded from: classes.dex */
public class Codec {

    /* renamed from: a, reason: collision with root package name */
    private static final Codec f7520a = new Codec();

    private Codec() {
        c.i(Codec.class.getSimpleName());
        System.loadLibrary("ilbc-codec");
        init(30);
    }

    public static Codec a() {
        return f7520a;
    }

    private native int init(int i10);

    public native int decode(byte[] bArr, int i10, int i11, byte[] bArr2, int i12);

    public native int encode(byte[] bArr, int i10, int i11, byte[] bArr2, int i12);
}
