package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
interface Encoder<TValue, TContext> {
    void encode(@Nullable TValue tvalue, @NonNull TContext tcontext);
}
