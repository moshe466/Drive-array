package com.google.firebase.encoders;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class EncodingException extends Exception {
    public EncodingException(@NonNull String str) {
        super(str);
    }

    public EncodingException(@NonNull String str, @NonNull Exception exc) {
        super(str, exc);
    }
}
