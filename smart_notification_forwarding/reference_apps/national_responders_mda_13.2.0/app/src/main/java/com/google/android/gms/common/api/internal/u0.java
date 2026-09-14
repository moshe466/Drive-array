package com.google.android.gms.common.api.internal;

import a2.a;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class u0 implements a1 {

    /* renamed from: a, reason: collision with root package name */
    private final d1 f4996a;

    /* renamed from: b, reason: collision with root package name */
    private final Lock f4997b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f4998c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.gms.common.c f4999d;

    /* renamed from: e, reason: collision with root package name */
    private com.google.android.gms.common.a f5000e;

    /* renamed from: f, reason: collision with root package name */
    private int f5001f;

    /* renamed from: h, reason: collision with root package name */
    private int f5003h;

    /* renamed from: k, reason: collision with root package name */
    private w2.f f5006k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f5007l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f5008m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f5009n;

    /* renamed from: o, reason: collision with root package name */
    private b2.j f5010o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f5011p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f5012q;

    /* renamed from: r, reason: collision with root package name */
    private final b2.e f5013r;

    /* renamed from: s, reason: collision with root package name */
    private final Map f5014s;

    /* renamed from: t, reason: collision with root package name */
    private final a.AbstractC0006a f5015t;

    /* renamed from: g, reason: collision with root package name */
    private int f5002g = 0;

    /* renamed from: i, reason: collision with root package name */
    private final Bundle f5004i = new Bundle();

    /* renamed from: j, reason: collision with root package name */
    private final Set f5005j = new HashSet();

    /* renamed from: u, reason: collision with root package name */
    private final ArrayList f5016u = new ArrayList();

    public u0(d1 d1Var, b2.e eVar, Map map, com.google.android.gms.common.c cVar, a.AbstractC0006a abstractC0006a, Lock lock, Context context) {
        this.f4996a = d1Var;
        this.f5013r = eVar;
        this.f5014s = map;
        this.f4999d = cVar;
        this.f5015t = abstractC0006a;
        this.f4997b = lock;
        this.f4998c = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void A(u0 u0Var, x2.l lVar) {
        if (u0Var.n(0)) {
            com.google.android.gms.common.a g10 = lVar.g();
            if (!g10.t()) {
                if (!u0Var.p(g10)) {
                    u0Var.k(g10);
                    return;
                } else {
                    u0Var.h();
                    u0Var.m();
                    return;
                }
            }
            b2.n0 n0Var = (b2.n0) b2.p.k(lVar.j());
            com.google.android.gms.common.a g11 = n0Var.g();
            if (!g11.t()) {
                String valueOf = String.valueOf(g11);
                Log.wtf("GACConnecting", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
                u0Var.k(g11);
                return;
            }
            u0Var.f5009n = true;
            u0Var.f5010o = (b2.j) b2.p.k(n0Var.j());
            u0Var.f5011p = n0Var.l();
            u0Var.f5012q = n0Var.s();
            u0Var.m();
        }
    }

    private final void I() {
        ArrayList arrayList = this.f5016u;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((Future) arrayList.get(i10)).cancel(true);
        }
        this.f5016u.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        this.f5008m = false;
        this.f4996a.f4824m.f5078p = Collections.emptySet();
        for (a.c cVar : this.f5005j) {
            if (!this.f4996a.f4818g.containsKey(cVar)) {
                this.f4996a.f4818g.put(cVar, new com.google.android.gms.common.a(17, null));
            }
        }
    }

    private final void i(boolean z10) {
        w2.f fVar = this.f5006k;
        if (fVar != null) {
            if (fVar.a() && z10) {
                fVar.l();
            }
            fVar.p();
            this.f5010o = null;
        }
    }

    private final void j() {
        this.f4996a.j();
        e1.a().execute(new i0(this));
        w2.f fVar = this.f5006k;
        if (fVar != null) {
            if (this.f5011p) {
                fVar.d((b2.j) b2.p.k(this.f5010o), this.f5012q);
            }
            i(false);
        }
        Iterator it = this.f4996a.f4818g.keySet().iterator();
        while (it.hasNext()) {
            ((a.f) b2.p.k((a.f) this.f4996a.f4817f.get((a.c) it.next()))).p();
        }
        this.f4996a.f4825n.a(this.f5004i.isEmpty() ? null : this.f5004i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(com.google.android.gms.common.a aVar) {
        I();
        i(!aVar.s());
        this.f4996a.l(aVar);
        this.f4996a.f4825n.c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(com.google.android.gms.common.a aVar, a2.a aVar2, boolean z10) {
        int b10 = aVar2.c().b();
        if ((!z10 || aVar.s() || this.f4999d.c(aVar.g()) != null) && (this.f5000e == null || b10 < this.f5001f)) {
            this.f5000e = aVar;
            this.f5001f = b10;
        }
        this.f4996a.f4818g.put(aVar2.b(), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        if (this.f5003h != 0) {
            return;
        }
        if (!this.f5008m || this.f5009n) {
            ArrayList arrayList = new ArrayList();
            this.f5002g = 1;
            this.f5003h = this.f4996a.f4817f.size();
            for (a.c cVar : this.f4996a.f4817f.keySet()) {
                if (!this.f4996a.f4818g.containsKey(cVar)) {
                    arrayList.add((a.f) this.f4996a.f4817f.get(cVar));
                } else if (o()) {
                    j();
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.f5016u.add(e1.a().submit(new n0(this, arrayList)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n(int i10) {
        if (this.f5002g == i10) {
            return true;
        }
        this.f4996a.f4824m.o();
        "Unexpected callback in ".concat(toString());
        int i11 = this.f5003h;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mRemainingConnections=");
        sb2.append(i11);
        int i12 = this.f5002g;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("GoogleApiClient connecting is in step ");
        sb3.append(q(i12));
        sb3.append(" but received callback for step ");
        sb3.append(q(i10));
        new Exception();
        k(new com.google.android.gms.common.a(8, null));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o() {
        com.google.android.gms.common.a aVar;
        int i10 = this.f5003h - 1;
        this.f5003h = i10;
        if (i10 > 0) {
            return false;
        }
        if (i10 < 0) {
            this.f4996a.f4824m.o();
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            aVar = new com.google.android.gms.common.a(8, null);
        } else {
            aVar = this.f5000e;
            if (aVar == null) {
                return true;
            }
            this.f4996a.f4823l = this.f5001f;
        }
        k(aVar);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p(com.google.android.gms.common.a aVar) {
        return this.f5007l && !aVar.s();
    }

    private static final String q(int i10) {
        return i10 != 0 ? "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Set x(u0 u0Var) {
        b2.e eVar = u0Var.f5013r;
        if (eVar == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(eVar.e());
        Map i10 = u0Var.f5013r.i();
        for (a2.a aVar : i10.keySet()) {
            if (!u0Var.f4996a.f4818g.containsKey(aVar.b())) {
                hashSet.addAll(((b2.a0) i10.get(aVar)).f3914a);
            }
        }
        return hashSet;
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final void a(Bundle bundle) {
        if (n(1)) {
            if (bundle != null) {
                this.f5004i.putAll(bundle);
            }
            if (o()) {
                j();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final void b(int i10) {
        k(new com.google.android.gms.common.a(8, null));
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [w2.f, a2.a$f] */
    @Override // com.google.android.gms.common.api.internal.a1
    public final void c() {
        this.f4996a.f4818g.clear();
        this.f5008m = false;
        q0 q0Var = null;
        this.f5000e = null;
        this.f5002g = 0;
        this.f5007l = true;
        this.f5009n = false;
        this.f5011p = false;
        HashMap hashMap = new HashMap();
        boolean z10 = false;
        for (a2.a aVar : this.f5014s.keySet()) {
            a.f fVar = (a.f) b2.p.k((a.f) this.f4996a.f4817f.get(aVar.b()));
            z10 |= aVar.c().b() == 1;
            boolean booleanValue = ((Boolean) this.f5014s.get(aVar)).booleanValue();
            if (fVar.r()) {
                this.f5008m = true;
                if (booleanValue) {
                    this.f5005j.add(aVar.b());
                } else {
                    this.f5007l = false;
                }
            }
            hashMap.put(fVar, new j0(this, aVar, booleanValue));
        }
        if (z10) {
            this.f5008m = false;
        }
        if (this.f5008m) {
            b2.p.k(this.f5013r);
            b2.p.k(this.f5015t);
            this.f5013r.j(Integer.valueOf(System.identityHashCode(this.f4996a.f4824m)));
            r0 r0Var = new r0(this, q0Var);
            a.AbstractC0006a abstractC0006a = this.f5015t;
            Context context = this.f4998c;
            Looper h10 = this.f4996a.f4824m.h();
            b2.e eVar = this.f5013r;
            this.f5006k = abstractC0006a.c(context, h10, eVar, eVar.f(), r0Var, r0Var);
        }
        this.f5003h = this.f4996a.f4817f.size();
        this.f5016u.add(e1.a().submit(new m0(this, hashMap)));
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final void d(com.google.android.gms.common.a aVar, a2.a aVar2, boolean z10) {
        if (n(1)) {
            l(aVar, aVar2, z10);
            if (o()) {
                j();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final void e() {
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final boolean f() {
        I();
        i(true);
        this.f4996a.l(null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final d g(d dVar) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
