package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
final class aa implements IntegrityManager {

    /* renamed from: a, reason: collision with root package name */
    private final aj f3898a;

    public aa(aj ajVar) {
        this.f3898a = ajVar;
    }

    @Override // com.google.android.play.core.integrity.IntegrityManager
    public final Task<IntegrityTokenResponse> requestIntegrityToken(IntegrityTokenRequest integrityTokenRequest) {
        return this.f3898a.c(integrityTokenRequest);
    }
}
