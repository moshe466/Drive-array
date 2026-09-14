package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public final class v2 extends z2 {

    /* renamed from: b, reason: collision with root package name */
    protected final d f5028b;

    public v2(int i10, d dVar) {
        super(i10);
        this.f5028b = (d) b2.p.l(dVar, "Null methods are not runnable.");
    }

    @Override // com.google.android.gms.common.api.internal.z2
    public final void a(Status status) {
        try {
            this.f5028b.v(status);
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.common.api.internal.z2
    public final void b(Exception exc) {
        try {
            this.f5028b.v(new Status(10, exc.getClass().getSimpleName() + ": " + exc.getLocalizedMessage()));
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.common.api.internal.z2
    public final void c(l1 l1Var) {
        try {
            this.f5028b.t(l1Var.v());
        } catch (RuntimeException e10) {
            b(e10);
        }
    }

    @Override // com.google.android.gms.common.api.internal.z2
    public final void d(b0 b0Var, boolean z10) {
        b0Var.c(this.f5028b, z10);
    }
}
