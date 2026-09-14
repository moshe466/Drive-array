package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y0 extends r1 {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference f5056a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y0(z0 z0Var) {
        this.f5056a = new WeakReference(z0Var);
    }

    @Override // com.google.android.gms.common.api.internal.r1
    public final void a() {
        z0 z0Var = (z0) this.f5056a.get();
        if (z0Var == null) {
            return;
        }
        z0.q(z0Var);
    }
}
