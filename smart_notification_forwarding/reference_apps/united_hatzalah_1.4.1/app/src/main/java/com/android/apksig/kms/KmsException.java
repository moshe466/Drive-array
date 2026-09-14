package com.android.apksig.kms;

/* loaded from: classes.dex */
public class KmsException extends RuntimeException {
    @Override // java.lang.Throwable
    public final String getMessage() {
        return "KMS null threw exception: " + super.getMessage();
    }
}
