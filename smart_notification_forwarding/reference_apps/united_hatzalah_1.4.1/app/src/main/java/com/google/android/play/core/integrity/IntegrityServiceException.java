package com.google.android.play.core.integrity;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import java.util.Locale;

/* loaded from: classes.dex */
public class IntegrityServiceException extends ApiException {

    /* renamed from: a, reason: collision with root package name */
    private final Throwable f3894a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntegrityServiceException(int i, Throwable th) {
        super(new Status(i, "Integrity API error (" + i + "): " + com.google.android.play.core.integrity.model.a.a(i) + "."));
        Locale locale = Locale.ROOT;
        if (i != 0) {
            this.f3894a = th;
            return;
        }
        throw new IllegalArgumentException("ErrorCode should not be 0.");
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable getCause() {
        return this.f3894a;
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}
