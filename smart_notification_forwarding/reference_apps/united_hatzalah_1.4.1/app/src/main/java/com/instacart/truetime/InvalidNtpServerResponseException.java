package com.instacart.truetime;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class InvalidNtpServerResponseException extends IOException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidNtpServerResponseException(String detailMessage) {
        super(detailMessage);
        j.e(detailMessage, "detailMessage");
    }

    public InvalidNtpServerResponseException(String str, String str2, float f4, float f5) {
        super(String.format(Locale.getDefault(), str, Arrays.copyOf(new Object[]{str2, Float.valueOf(f4), Float.valueOf(f5)}, 3)));
    }
}
