package com.google.android.gms.common.api.internal;

import a2.a;
import java.util.Map;

/* loaded from: classes.dex */
final class o1 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.common.a f4941f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ p1 f4942g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o1(p1 p1Var, com.google.android.gms.common.a aVar) {
        this.f4942g = p1Var;
        this.f4941f = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        b bVar;
        a.f fVar;
        a.f fVar2;
        a.f fVar3;
        a.f fVar4;
        p1 p1Var = this.f4942g;
        map = p1Var.f4953f.f4854l;
        bVar = p1Var.f4949b;
        l1 l1Var = (l1) map.get(bVar);
        if (l1Var == null) {
            return;
        }
        if (!this.f4941f.t()) {
            l1Var.I(this.f4941f, null);
            return;
        }
        this.f4942g.f4952e = true;
        fVar = this.f4942g.f4948a;
        if (fVar.r()) {
            this.f4942g.h();
            return;
        }
        try {
            p1 p1Var2 = this.f4942g;
            fVar3 = p1Var2.f4948a;
            fVar4 = p1Var2.f4948a;
            fVar3.n(null, fVar4.c());
        } catch (SecurityException unused) {
            fVar2 = this.f4942g.f4948a;
            fVar2.f("Failed to get service from broker.");
            l1Var.I(new com.google.android.gms.common.a(10), null);
        }
    }
}
