package com.google.firebase.installations;

/* loaded from: classes.dex */
class j implements n {

    /* renamed from: a, reason: collision with root package name */
    private final o f7378a;

    /* renamed from: b, reason: collision with root package name */
    private final z2.m<l> f7379b;

    public j(o oVar, z2.m<l> mVar) {
        this.f7378a = oVar;
        this.f7379b = mVar;
    }

    @Override // com.google.firebase.installations.n
    public boolean a(t4.d dVar) {
        if (!dVar.k() || this.f7378a.f(dVar)) {
            return false;
        }
        this.f7379b.c(l.a().b(dVar.b()).d(dVar.c()).c(dVar.h()).a());
        return true;
    }

    @Override // com.google.firebase.installations.n
    public boolean b(Exception exc) {
        this.f7379b.d(exc);
        return true;
    }
}
