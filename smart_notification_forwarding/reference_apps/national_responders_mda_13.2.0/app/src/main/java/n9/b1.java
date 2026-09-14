package n9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class b1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends y8.l implements x8.l<m, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f12261f = new a();

        a() {
            super(1);
        }

        public final boolean a(m mVar) {
            y8.k.e(mVar, "it");
            return mVar instanceof n9.a;
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(m mVar) {
            return Boolean.valueOf(a(mVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends y8.l implements x8.l<m, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f12262f = new b();

        b() {
            super(1);
        }

        public final boolean a(m mVar) {
            y8.k.e(mVar, "it");
            return !(mVar instanceof l);
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(m mVar) {
            return Boolean.valueOf(a(mVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends y8.l implements x8.l<m, lb.h<? extends a1>> {

        /* renamed from: f, reason: collision with root package name */
        public static final c f12263f = new c();

        c() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final lb.h<a1> h(m mVar) {
            lb.h<a1> A;
            y8.k.e(mVar, "it");
            List<a1> m10 = ((n9.a) mVar).m();
            y8.k.d(m10, "it as CallableDescriptor).typeParameters");
            A = m8.y.A(m10);
            return A;
        }
    }

    public static final n0 a(bb.b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        h o10 = b0Var.W0().o();
        return b(b0Var, o10 instanceof i ? (i) o10 : null, 0);
    }

    private static final n0 b(bb.b0 b0Var, i iVar, int i10) {
        if (iVar == null || bb.t.r(iVar)) {
            return null;
        }
        int size = iVar.B().size() + i10;
        if (iVar.m0()) {
            List<bb.v0> subList = b0Var.V0().subList(i10, size);
            m d10 = iVar.d();
            return new n0(iVar, subList, b(b0Var, d10 instanceof i ? (i) d10 : null, size));
        }
        if (size != b0Var.V0().size()) {
            na.d.E(iVar);
        }
        return new n0(iVar, b0Var.V0().subList(i10, b0Var.V0().size()), null);
    }

    private static final n9.c c(a1 a1Var, m mVar, int i10) {
        return new n9.c(a1Var, mVar, i10);
    }

    public static final List<a1> d(i iVar) {
        lb.h u10;
        lb.h l10;
        lb.h p10;
        List w10;
        List<a1> list;
        m mVar;
        List<a1> a02;
        int n10;
        List<a1> a03;
        bb.t0 o10;
        y8.k.e(iVar, "<this>");
        List<a1> B = iVar.B();
        y8.k.d(B, "declaredTypeParameters");
        if (!iVar.m0() && !(iVar.d() instanceof n9.a)) {
            return B;
        }
        u10 = lb.n.u(ra.a.m(iVar), a.f12261f);
        l10 = lb.n.l(u10, b.f12262f);
        p10 = lb.n.p(l10, c.f12263f);
        w10 = lb.n.w(p10);
        Iterator<m> it = ra.a.m(iVar).iterator();
        while (true) {
            list = null;
            if (!it.hasNext()) {
                mVar = null;
                break;
            }
            mVar = it.next();
            if (mVar instanceof e) {
                break;
            }
        }
        e eVar = (e) mVar;
        if (eVar != null && (o10 = eVar.o()) != null) {
            list = o10.B();
        }
        if (list == null) {
            list = m8.q.d();
        }
        if (w10.isEmpty() && list.isEmpty()) {
            List<a1> B2 = iVar.B();
            y8.k.d(B2, "declaredTypeParameters");
            return B2;
        }
        a02 = m8.y.a0(w10, list);
        n10 = m8.r.n(a02, 10);
        ArrayList arrayList = new ArrayList(n10);
        for (a1 a1Var : a02) {
            y8.k.d(a1Var, "it");
            arrayList.add(c(a1Var, iVar, B.size()));
        }
        a03 = m8.y.a0(B, arrayList);
        return a03;
    }
}
