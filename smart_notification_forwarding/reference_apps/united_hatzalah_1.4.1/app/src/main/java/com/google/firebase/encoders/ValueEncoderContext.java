package com.google.firebase.encoders;

/* loaded from: classes.dex */
public interface ValueEncoderContext {
    ValueEncoderContext add(double d2);

    ValueEncoderContext add(float f4);

    ValueEncoderContext add(int i);

    ValueEncoderContext add(long j2);

    ValueEncoderContext add(String str);

    ValueEncoderContext add(boolean z3);

    ValueEncoderContext add(byte[] bArr);
}
