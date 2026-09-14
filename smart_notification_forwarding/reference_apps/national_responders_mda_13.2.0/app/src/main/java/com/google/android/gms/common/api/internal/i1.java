package com.google.android.gms.common.api.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i1 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f4875f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ l1 f4876g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i1(l1 l1Var, int i10) {
        this.f4876g = l1Var;
        this.f4875f = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4876g.h(this.f4875f);
    }
}
