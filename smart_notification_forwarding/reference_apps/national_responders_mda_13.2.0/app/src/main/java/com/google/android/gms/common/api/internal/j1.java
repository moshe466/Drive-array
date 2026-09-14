package com.google.android.gms.common.api.internal;

import a2.a;

/* loaded from: classes.dex */
final class j1 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ k1 f4882f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j1(k1 k1Var) {
        this.f4882f = k1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.f fVar;
        a.f fVar2;
        l1 l1Var = this.f4882f.f4887a;
        fVar = l1Var.f4900b;
        fVar2 = l1Var.f4900b;
        fVar.f(fVar2.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
