package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
class bi extends I1.p {

    /* renamed from: a, reason: collision with root package name */
    final TaskCompletionSource f3970a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ bn f3971b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(bn bnVar, TaskCompletionSource taskCompletionSource) {
        super("com.google.android.play.core.integrity.protocol.IExpressIntegrityServiceCallback");
        this.f3971b = bnVar;
        this.f3970a = taskCompletionSource;
    }

    @Override // I1.q
    public final void b(Bundle bundle) {
        this.f3971b.f3979a.d(this.f3970a);
    }

    @Override // I1.q
    public void c(Bundle bundle) {
        this.f3971b.f3979a.d(this.f3970a);
    }

    @Override // I1.q
    public final void d(Bundle bundle) {
        this.f3971b.f3979a.d(this.f3970a);
    }

    @Override // I1.q
    public void e(Bundle bundle) {
        this.f3971b.f3979a.d(this.f3970a);
    }
}
