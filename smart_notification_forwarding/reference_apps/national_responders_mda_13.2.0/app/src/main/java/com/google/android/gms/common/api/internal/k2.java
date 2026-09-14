package com.google.android.gms.common.api.internal;

/* loaded from: classes.dex */
final class k2 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ x2.l f4888f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ m2 f4889g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k2(m2 m2Var, x2.l lVar) {
        this.f4889g = m2Var;
        this.f4888f = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m2.z0(this.f4889g, this.f4888f);
    }
}
