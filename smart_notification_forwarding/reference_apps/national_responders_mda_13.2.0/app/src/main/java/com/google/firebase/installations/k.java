package com.google.firebase.installations;

/* loaded from: classes.dex */
class k implements n {

    /* renamed from: a, reason: collision with root package name */
    final z2.m<String> f7380a;

    public k(z2.m<String> mVar) {
        this.f7380a = mVar;
    }

    @Override // com.google.firebase.installations.n
    public boolean a(t4.d dVar) {
        if (!dVar.l() && !dVar.k() && !dVar.i()) {
            return false;
        }
        this.f7380a.e(dVar.d());
        return true;
    }

    @Override // com.google.firebase.installations.n
    public boolean b(Exception exc) {
        return false;
    }
}
