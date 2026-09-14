package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.l;

/* loaded from: classes.dex */
public final class y2 extends r2 {

    /* renamed from: c, reason: collision with root package name */
    public final l.a f5061c;

    public y2(l.a aVar, z2.m mVar) {
        super(4, mVar);
        this.f5061c = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.z2
    public final /* bridge */ /* synthetic */ void d(b0 b0Var, boolean z10) {
    }

    @Override // com.google.android.gms.common.api.internal.u1
    public final boolean f(l1 l1Var) {
        c2 c2Var = (c2) l1Var.x().get(this.f5061c);
        return c2Var != null && c2Var.f4800a.f();
    }

    @Override // com.google.android.gms.common.api.internal.u1
    public final z1.c[] g(l1 l1Var) {
        c2 c2Var = (c2) l1Var.x().get(this.f5061c);
        if (c2Var == null) {
            return null;
        }
        return c2Var.f4800a.c();
    }

    @Override // com.google.android.gms.common.api.internal.r2
    public final void h(l1 l1Var) {
        c2 c2Var = (c2) l1Var.x().remove(this.f5061c);
        if (c2Var == null) {
            this.f4972b.e(Boolean.FALSE);
        } else {
            c2Var.f4801b.b(l1Var.v(), this.f4972b);
            c2Var.f4800a.a();
        }
    }
}
