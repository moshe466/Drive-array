package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public interface ValueEncoderContext {
    @NonNull
    ValueEncoderContext add(double d);

    @NonNull
    ValueEncoderContext add(int i);

    @NonNull
    ValueEncoderContext add(long j);

    @NonNull
    ValueEncoderContext add(@Nullable String str);

    @NonNull
    ValueEncoderContext add(boolean z);

    @NonNull
    ValueEncoderContext add(@NonNull byte[] bArr);
}
