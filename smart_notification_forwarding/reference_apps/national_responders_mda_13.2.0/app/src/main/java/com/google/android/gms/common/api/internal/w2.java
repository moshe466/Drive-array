package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.l;

/* loaded from: classes.dex */
public final class w2 extends r2 {

    /* renamed from: c, reason: collision with root package name */
    public final c2 f5032c;

    public w2(c2 c2Var, z2.m mVar) {
        super(3, mVar);
        this.f5032c = c2Var;
    }

    @Override // com.google.android.gms.common.api.internal.z2
    public final /* bridge */ /* synthetic */ void d(b0 b0Var, boolean z10) {
    }

    @Override // com.google.android.gms.common.api.internal.u1
    public final boolean f(l1 l1Var) {
        return this.f5032c.f4800a.f();
    }

    @Override // com.google.android.gms.common.api.internal.u1
    public final z1.c[] g(l1 l1Var) {
        return this.f5032c.f4800a.c();
    }

    @Override // com.google.android.gms.common.api.internal.r2
    public final void h(l1 l1Var) {
        this.f5032c.f4800a.d(l1Var.v(), this.f4972b);
        l.a b10 = this.f5032c.f4800a.b();
        if (b10 != null) {
            l1Var.x().put(b10, this.f5032c);
        }
    }
}
