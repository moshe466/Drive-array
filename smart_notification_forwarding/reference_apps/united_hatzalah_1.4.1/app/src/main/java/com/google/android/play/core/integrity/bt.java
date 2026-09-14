package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.StandardIntegrityManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bt {

    /* renamed from: a, reason: collision with root package name */
    private final bn f3995a;

    public bt(bn bnVar) {
        this.f3995a = bnVar;
    }

    public final /* synthetic */ Task a(long j2, long j3, int i, StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest) {
        return this.f3995a.d(standardIntegrityTokenRequest.a(), j2, j3, 0);
    }
}
