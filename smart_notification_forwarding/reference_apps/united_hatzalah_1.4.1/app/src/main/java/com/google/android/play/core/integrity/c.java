package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder {

    /* renamed from: a, reason: collision with root package name */
    private long f3997a;

    /* renamed from: b, reason: collision with root package name */
    private byte f3998b;

    public final StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder a(int i) {
        this.f3998b = (byte) (this.f3998b | 2);
        return this;
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder
    public final StandardIntegrityManager.PrepareIntegrityTokenRequest build() {
        if (this.f3998b != 3) {
            StringBuilder sb = new StringBuilder();
            if ((this.f3998b & 1) == 0) {
                sb.append(" cloudProjectNumber");
            }
            if ((this.f3998b & 2) == 0) {
                sb.append(" webViewRequestMode");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new e(this.f3997a, 0, null);
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder
    public final StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder setCloudProjectNumber(long j2) {
        this.f3997a = j2;
        this.f3998b = (byte) (this.f3998b | 1);
        return this;
    }
}
