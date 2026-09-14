package com.google.android.gms.common.api.internal;

import a2.a;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class h0 implements a1 {

    /* renamed from: a, reason: collision with root package name */
    private final d1 f4871a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4872b = false;

    public h0(d1 d1Var) {
        this.f4871a = d1Var;
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final void a(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final void b(int i10) {
        this.f4871a.l(null);
        this.f4871a.f4825n.b(i10, this.f4872b);
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final void c() {
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final void d(com.google.android.gms.common.a aVar, a2.a aVar2, boolean z10) {
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final void e() {
        if (this.f4872b) {
            this.f4872b = false;
            this.f4871a.m(new g0(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final boolean f() {
        if (this.f4872b) {
            return false;
        }
        Set set = this.f4871a.f4824m.f5085w;
        if (set == null || set.isEmpty()) {
            this.f4871a.l(null);
            return true;
        }
        this.f4872b = true;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((s2) it.next()).f();
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final d g(d dVar) {
        try {
            this.f4871a.f4824m.f5086x.a(dVar);
            z0 z0Var = this.f4871a.f4824m;
            a.f fVar = (a.f) z0Var.f5077o.get(dVar.r());
            b2.p.l(fVar, "Appropriate Api was not requested.");
            if (fVar.a() || !this.f4871a.f4818g.containsKey(dVar.r())) {
                dVar.t(fVar);
            } else {
                dVar.v(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.f4871a.m(new f0(this, this));
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i() {
        if (this.f4872b) {
            this.f4872b = false;
            this.f4871a.f4824m.f5086x.b();
            f();
        }
    }
}
