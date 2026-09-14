package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.StandardIntegrityManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class az implements StandardIntegrityManager {

    /* renamed from: a, reason: collision with root package name */
    private final bn f3947a;

    /* renamed from: b, reason: collision with root package name */
    private final bt f3948b;

    public az(bn bnVar, bt btVar) {
        this.f3947a = bnVar;
        this.f3948b = btVar;
    }

    public final /* synthetic */ Task a(StandardIntegrityManager.PrepareIntegrityTokenRequest prepareIntegrityTokenRequest, Long l3) {
        final long b4 = prepareIntegrityTokenRequest.b();
        final long longValue = l3.longValue();
        prepareIntegrityTokenRequest.a();
        final bt btVar = this.f3948b;
        final int i = 0;
        return Tasks.forResult(new StandardIntegrityManager.StandardIntegrityTokenProvider(b4, longValue, i) { // from class: com.google.android.play.core.integrity.bs

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f3993b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f3994c;

            @Override // com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenProvider
            public final Task request(StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest) {
                return bt.this.a(this.f3993b, this.f3994c, 0, standardIntegrityTokenRequest);
            }
        });
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager
    public final Task<StandardIntegrityManager.StandardIntegrityTokenProvider> prepareIntegrityToken(final StandardIntegrityManager.PrepareIntegrityTokenRequest prepareIntegrityTokenRequest) {
        long b4 = prepareIntegrityTokenRequest.b();
        prepareIntegrityTokenRequest.a();
        return this.f3947a.e(b4, 0).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.play.core.integrity.ay
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return az.this.a(prepareIntegrityTokenRequest, (Long) obj);
            }
        });
    }
}
