package p9;

import bb.a1;
import bb.c1;
import bb.h1;
import bb.t0;
import bb.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import n9.s0;
import n9.v0;

/* loaded from: classes.dex */
public class s extends t {

    /* renamed from: g, reason: collision with root package name */
    private final t f13296g;

    /* renamed from: h, reason: collision with root package name */
    private final a1 f13297h;

    /* renamed from: i, reason: collision with root package name */
    private a1 f13298i;

    /* renamed from: j, reason: collision with root package name */
    private List<n9.a1> f13299j;

    /* renamed from: k, reason: collision with root package name */
    private List<n9.a1> f13300k;

    /* renamed from: l, reason: collision with root package name */
    private t0 f13301l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements x8.l<n9.a1, Boolean> {
        a(s sVar) {
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean h(n9.a1 a1Var) {
            return Boolean.valueOf(!a1Var.Z());
        }
    }

    public s(t tVar, a1 a1Var) {
        this.f13296g = tVar;
        this.f13297h = a1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00de A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void I0(int r15) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p9.s.I0(int):void");
    }

    private a1 U0() {
        List<n9.a1> F;
        if (this.f13298i == null) {
            if (this.f13297h.k()) {
                this.f13298i = this.f13297h;
            } else {
                List<n9.a1> B = this.f13296g.o().B();
                this.f13299j = new ArrayList(B.size());
                this.f13298i = bb.o.b(B, this.f13297h.j(), this, this.f13299j);
                F = m8.y.F(this.f13299j, new a(this));
                this.f13300k = F;
            }
        }
        return this.f13298i;
    }

    @Override // n9.e
    public n9.e A0() {
        return this.f13296g.A0();
    }

    @Override // n9.e, n9.i
    public List<n9.a1> B() {
        U0();
        List<n9.a1> list = this.f13300k;
        if (list == null) {
            I0(29);
        }
        return list;
    }

    @Override // n9.e
    public ua.h E0() {
        ua.h v02 = v0(ra.a.k(na.d.g(this.f13296g)));
        if (v02 == null) {
            I0(12);
        }
        return v02;
    }

    @Override // n9.z
    public boolean H0() {
        return this.f13296g.H0();
    }

    @Override // n9.z
    public boolean I() {
        return this.f13296g.I();
    }

    @Override // n9.e
    public ua.h J(y0 y0Var) {
        if (y0Var == null) {
            I0(10);
        }
        ua.h e02 = e0(y0Var, ra.a.k(na.d.g(this)));
        if (e02 == null) {
            I0(11);
        }
        return e02;
    }

    @Override // n9.m
    public <R, D> R J0(n9.o<R, D> oVar, D d10) {
        return oVar.e(this, d10);
    }

    @Override // n9.e
    public boolean N() {
        return this.f13296g.N();
    }

    @Override // n9.e
    public boolean R0() {
        return this.f13296g.R0();
    }

    @Override // n9.e
    public s0 T0() {
        throw new UnsupportedOperationException();
    }

    @Override // n9.x0
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public n9.e e(a1 a1Var) {
        if (a1Var == null) {
            I0(22);
        }
        return a1Var.k() ? this : new s(this, a1.h(a1Var.j(), U0().j()));
    }

    @Override // n9.e
    public boolean W() {
        return this.f13296g.W();
    }

    @Override // n9.m
    public n9.e a() {
        n9.e a10 = this.f13296g.a();
        if (a10 == null) {
            I0(20);
        }
        return a10;
    }

    @Override // n9.e0
    public la.e c() {
        la.e c10 = this.f13296g.c();
        if (c10 == null) {
            I0(19);
        }
        return c10;
    }

    @Override // n9.e, n9.n, n9.m
    public n9.m d() {
        n9.m d10 = this.f13296g.d();
        if (d10 == null) {
            I0(21);
        }
        return d10;
    }

    @Override // p9.t
    public ua.h e0(y0 y0Var, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (y0Var == null) {
            I0(5);
        }
        if (gVar == null) {
            I0(6);
        }
        ua.h e02 = this.f13296g.e0(y0Var, gVar);
        if (!this.f13297h.k()) {
            return new ua.m(e02, U0());
        }
        if (e02 == null) {
            I0(7);
        }
        return e02;
    }

    @Override // n9.e
    public Collection<n9.e> g0() {
        Collection<n9.e> g02 = this.f13296g.g0();
        if (g02 == null) {
            I0(30);
        }
        return g02;
    }

    @Override // n9.e, n9.q, n9.z
    public n9.u h() {
        n9.u h10 = this.f13296g.h();
        if (h10 == null) {
            I0(26);
        }
        return h10;
    }

    @Override // n9.e
    public boolean j0() {
        return this.f13296g.j0();
    }

    @Override // n9.p
    public v0 k() {
        v0 v0Var = v0.f12324a;
        if (v0Var == null) {
            I0(28);
        }
        return v0Var;
    }

    @Override // n9.z
    public boolean l0() {
        return this.f13296g.l0();
    }

    @Override // n9.i
    public boolean m0() {
        return this.f13296g.m0();
    }

    @Override // n9.h
    public t0 o() {
        t0 o10 = this.f13296g.o();
        if (this.f13297h.k()) {
            if (o10 == null) {
                I0(0);
            }
            return o10;
        }
        if (this.f13301l == null) {
            a1 U0 = U0();
            Collection<bb.b0> x10 = o10.x();
            ArrayList arrayList = new ArrayList(x10.size());
            Iterator<bb.b0> it = x10.iterator();
            while (it.hasNext()) {
                arrayList.add(U0.p(it.next(), h1.INVARIANT));
            }
            this.f13301l = new bb.i(this, this.f13299j, arrayList, ab.f.f359e);
        }
        t0 t0Var = this.f13301l;
        if (t0Var == null) {
            I0(1);
        }
        return t0Var;
    }

    @Override // n9.e, n9.z
    public n9.a0 p() {
        n9.a0 p10 = this.f13296g.p();
        if (p10 == null) {
            I0(25);
        }
        return p10;
    }

    @Override // n9.e
    public Collection<n9.d> q() {
        Collection<n9.d> q10 = this.f13296g.q();
        ArrayList arrayList = new ArrayList(q10.size());
        for (n9.d dVar : q10) {
            arrayList.add(((n9.d) dVar.y().h(dVar.a()).i(dVar.p()).d(dVar.h()).q(dVar.r()).s(false).c()).e(U0()));
        }
        return arrayList;
    }

    @Override // n9.e
    public n9.f r() {
        n9.f r10 = this.f13296g.r();
        if (r10 == null) {
            I0(24);
        }
        return r10;
    }

    @Override // n9.e, n9.h
    public bb.i0 s() {
        bb.i0 j10 = bb.c0.j(u(), o(), c1.g(o().B()), false, E0());
        if (j10 == null) {
            I0(16);
        }
        return j10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u10 = this.f13296g.u();
        if (u10 == null) {
            I0(18);
        }
        return u10;
    }

    @Override // n9.e
    public ua.h u0() {
        ua.h u02 = this.f13296g.u0();
        if (u02 == null) {
            I0(27);
        }
        return u02;
    }

    @Override // p9.t
    public ua.h v0(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            I0(13);
        }
        ua.h v02 = this.f13296g.v0(gVar);
        if (!this.f13297h.k()) {
            return new ua.m(v02, U0());
        }
        if (v02 == null) {
            I0(14);
        }
        return v02;
    }

    @Override // n9.e
    public n9.d w0() {
        return this.f13296g.w0();
    }

    @Override // n9.e
    public boolean x() {
        return this.f13296g.x();
    }

    @Override // n9.e
    public ua.h x0() {
        ua.h x02 = this.f13296g.x0();
        if (x02 == null) {
            I0(15);
        }
        return x02;
    }
}
