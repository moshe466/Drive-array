package com.google.android.gms.common.api.internal;

import a2.a;
import android.os.Handler;
import android.util.Log;
import b2.c;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p1 implements c.InterfaceC0067c, l2 {

    /* renamed from: a, reason: collision with root package name */
    private final a.f f4948a;

    /* renamed from: b, reason: collision with root package name */
    private final b f4949b;

    /* renamed from: c, reason: collision with root package name */
    private b2.j f4950c = null;

    /* renamed from: d, reason: collision with root package name */
    private Set f4951d = null;

    /* renamed from: e, reason: collision with root package name */
    private boolean f4952e = false;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ g f4953f;

    public p1(g gVar, a.f fVar, b bVar) {
        this.f4953f = gVar;
        this.f4948a = fVar;
        this.f4949b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        b2.j jVar;
        if (!this.f4952e || (jVar = this.f4950c) == null) {
            return;
        }
        this.f4948a.n(jVar, this.f4951d);
    }

    @Override // b2.c.InterfaceC0067c
    public final void a(com.google.android.gms.common.a aVar) {
        Handler handler;
        handler = this.f4953f.f4858p;
        handler.post(new o1(this, aVar));
    }

    @Override // com.google.android.gms.common.api.internal.l2
    public final void b(com.google.android.gms.common.a aVar) {
        Map map;
        map = this.f4953f.f4854l;
        l1 l1Var = (l1) map.get(this.f4949b);
        if (l1Var != null) {
            l1Var.J(aVar);
        }
    }

    @Override // com.google.android.gms.common.api.internal.l2
    public final void c(b2.j jVar, Set set) {
        if (jVar == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            b(new com.google.android.gms.common.a(4));
        } else {
            this.f4950c = jVar;
            this.f4951d = set;
            h();
        }
    }
}
