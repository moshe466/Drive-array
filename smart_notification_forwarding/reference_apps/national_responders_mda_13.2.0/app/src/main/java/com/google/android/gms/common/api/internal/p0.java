package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class p0 extends x2.d {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference f4947a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p0(u0 u0Var) {
        this.f4947a = new WeakReference(u0Var);
    }

    @Override // x2.f
    public final void o0(x2.l lVar) {
        d1 d1Var;
        u0 u0Var = (u0) this.f4947a.get();
        if (u0Var == null) {
            return;
        }
        d1Var = u0Var.f4996a;
        d1Var.m(new o0(this, u0Var, u0Var, lVar));
    }
}
