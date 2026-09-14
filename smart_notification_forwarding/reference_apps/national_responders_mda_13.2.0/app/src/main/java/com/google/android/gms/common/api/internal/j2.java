package com.google.android.gms.common.api.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j2 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ m2 f4883f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j2(m2 m2Var) {
        this.f4883f = m2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l2 l2Var;
        l2Var = this.f4883f.f4922g;
        l2Var.b(new com.google.android.gms.common.a(4));
    }
}
