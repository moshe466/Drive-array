package com.google.android.gms.common.api.internal;

import android.app.Activity;

/* loaded from: classes.dex */
public final class c0 extends g3 {

    /* renamed from: k, reason: collision with root package name */
    private final l.b f4797k;

    /* renamed from: l, reason: collision with root package name */
    private final g f4798l;

    c0(k kVar, g gVar, com.google.android.gms.common.b bVar) {
        super(kVar, bVar);
        this.f4797k = new l.b();
        this.f4798l = gVar;
        this.f4772f.c("ConnectionlessLifecycleHelper", this);
    }

    public static void u(Activity activity, g gVar, b bVar) {
        k c10 = LifecycleCallback.c(activity);
        c0 c0Var = (c0) c10.i("ConnectionlessLifecycleHelper", c0.class);
        if (c0Var == null) {
            c0Var = new c0(c10, gVar, com.google.android.gms.common.b.p());
        }
        b2.p.l(bVar, "ApiKey cannot be null");
        c0Var.f4797k.add(bVar);
        gVar.c(c0Var);
    }

    private final void v() {
        if (this.f4797k.isEmpty()) {
            return;
        }
        this.f4798l.c(this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void h() {
        super.h();
        v();
    }

    @Override // com.google.android.gms.common.api.internal.g3, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void j() {
        super.j();
        v();
    }

    @Override // com.google.android.gms.common.api.internal.g3, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void k() {
        super.k();
        this.f4798l.d(this);
    }

    @Override // com.google.android.gms.common.api.internal.g3
    protected final void m(com.google.android.gms.common.a aVar, int i10) {
        this.f4798l.I(aVar, i10);
    }

    @Override // com.google.android.gms.common.api.internal.g3
    protected final void n() {
        this.f4798l.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final l.b t() {
        return this.f4797k;
    }
}
