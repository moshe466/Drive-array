package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class bk extends bi {

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ bn f3973c;

    /* renamed from: d, reason: collision with root package name */
    private final I1.y f3974d;

    /* renamed from: e, reason: collision with root package name */
    private final long f3975e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk(bn bnVar, TaskCompletionSource taskCompletionSource, long j2) {
        super(bnVar, taskCompletionSource);
        this.f3973c = bnVar;
        this.f3974d = new I1.y("OnRequestIntegrityTokenCallback");
        this.f3975e = j2;
    }

    @Override // com.google.android.play.core.integrity.bi, I1.q
    public final void c(Bundle bundle) {
        k kVar;
        String str;
        super.c(bundle);
        this.f3974d.b("onRequestExpressIntegrityToken", new Object[0]);
        kVar = this.f3973c.f3984f;
        ApiException a2 = kVar.a(bundle);
        if (a2 != null) {
            this.f3970a.trySetException(a2);
            return;
        }
        long j2 = bundle.getLong("request.token.sid");
        str = this.f3973c.f3981c;
        bj bjVar = new bj(this, str, j2);
        TaskCompletionSource taskCompletionSource = this.f3970a;
        b bVar = new b();
        bVar.b(bundle.getString("token"));
        bVar.a(bjVar);
        taskCompletionSource.trySetResult(bVar.c());
    }
}
