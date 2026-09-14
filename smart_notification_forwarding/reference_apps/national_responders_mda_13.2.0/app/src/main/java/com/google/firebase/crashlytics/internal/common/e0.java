package com.google.firebase.crashlytics.internal.common;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class e0 implements z2.c {

    /* renamed from: a, reason: collision with root package name */
    private final g0 f7081a;

    private e0(g0 g0Var) {
        this.f7081a = g0Var;
    }

    public static z2.c b(g0 g0Var) {
        return new e0(g0Var);
    }

    @Override // z2.c
    public Object a(z2.l lVar) {
        boolean h10;
        h10 = this.f7081a.h(lVar);
        return Boolean.valueOf(h10);
    }
}
