package com.google.android.gms.common.api.internal;

import a2.a;
import a2.f;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.Set;

/* loaded from: classes.dex */
public final class m2 extends x2.d implements f.b, f.c {

    /* renamed from: h, reason: collision with root package name */
    private static final a.AbstractC0006a f4915h = w2.e.f14903c;

    /* renamed from: a, reason: collision with root package name */
    private final Context f4916a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f4917b;

    /* renamed from: c, reason: collision with root package name */
    private final a.AbstractC0006a f4918c;

    /* renamed from: d, reason: collision with root package name */
    private final Set f4919d;

    /* renamed from: e, reason: collision with root package name */
    private final b2.e f4920e;

    /* renamed from: f, reason: collision with root package name */
    private w2.f f4921f;

    /* renamed from: g, reason: collision with root package name */
    private l2 f4922g;

    public m2(Context context, Handler handler, b2.e eVar) {
        a.AbstractC0006a abstractC0006a = f4915h;
        this.f4916a = context;
        this.f4917b = handler;
        this.f4920e = (b2.e) b2.p.l(eVar, "ClientSettings must not be null");
        this.f4919d = eVar.e();
        this.f4918c = abstractC0006a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void z0(m2 m2Var, x2.l lVar) {
        com.google.android.gms.common.a g10 = lVar.g();
        if (g10.t()) {
            b2.n0 n0Var = (b2.n0) b2.p.k(lVar.j());
            g10 = n0Var.g();
            if (g10.t()) {
                m2Var.f4922g.c(n0Var.j(), m2Var.f4919d);
                m2Var.f4921f.p();
            } else {
                String valueOf = String.valueOf(g10);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
            }
        }
        m2Var.f4922g.b(g10);
        m2Var.f4921f.p();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [w2.f, a2.a$f] */
    public final void A0(l2 l2Var) {
        w2.f fVar = this.f4921f;
        if (fVar != null) {
            fVar.p();
        }
        this.f4920e.j(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0006a abstractC0006a = this.f4918c;
        Context context = this.f4916a;
        Looper looper = this.f4917b.getLooper();
        b2.e eVar = this.f4920e;
        this.f4921f = abstractC0006a.c(context, looper, eVar, eVar.f(), this, this);
        this.f4922g = l2Var;
        Set set = this.f4919d;
        if (set == null || set.isEmpty()) {
            this.f4917b.post(new j2(this));
        } else {
            this.f4921f.s();
        }
    }

    public final void B0() {
        w2.f fVar = this.f4921f;
        if (fVar != null) {
            fVar.p();
        }
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void i(int i10) {
        this.f4921f.p();
    }

    @Override // com.google.android.gms.common.api.internal.o
    public final void n(com.google.android.gms.common.a aVar) {
        this.f4922g.b(aVar);
    }

    @Override // x2.f
    public final void o0(x2.l lVar) {
        this.f4917b.post(new k2(this, lVar));
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void p(Bundle bundle) {
        this.f4921f.u(this);
    }
}
