package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class bl extends bi {

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ bn f3976c;

    /* renamed from: d, reason: collision with root package name */
    private final I1.y f3977d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(bn bnVar, TaskCompletionSource taskCompletionSource) {
        super(bnVar, taskCompletionSource);
        this.f3976c = bnVar;
        this.f3977d = new I1.y("OnWarmUpIntegrityTokenCallback");
    }

    @Override // com.google.android.play.core.integrity.bi, I1.q
    public final void e(Bundle bundle) {
        k kVar;
        super.e(bundle);
        this.f3977d.b("onWarmUpExpressIntegrityToken", new Object[0]);
        kVar = this.f3976c.f3984f;
        ApiException a2 = kVar.a(bundle);
        if (a2 != null) {
            this.f3970a.trySetException(a2);
        } else {
            this.f3970a.trySetResult(Long.valueOf(bundle.getLong("warm.up.sid")));
        }
    }
}
