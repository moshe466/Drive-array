package n9;

import java.util.Collection;
import java.util.List;
import n9.b;

/* loaded from: classes.dex */
public interface x extends b {

    /* loaded from: classes.dex */
    public interface a<D extends x> {
        a<D> a();

        a<D> b(s0 s0Var);

        D c();

        a<D> d(u uVar);

        a<D> e(bb.y0 y0Var);

        a<D> f(List<d1> list);

        a<D> g(List<a1> list);

        a<D> h(b bVar);

        a<D> i(a0 a0Var);

        a<D> j(la.e eVar);

        a<D> k(bb.b0 b0Var);

        a<D> l(m mVar);

        a<D> m();

        a<D> n();

        a<D> o(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar);

        a<D> p(s0 s0Var);

        a<D> q(b.a aVar);

        a<D> r();

        a<D> s(boolean z10);

        a<D> t();
    }

    boolean C0();

    x H();

    boolean N0();

    @Override // n9.b, n9.a, n9.m
    x a();

    @Override // n9.n, n9.m
    m d();

    x e(bb.a1 a1Var);

    @Override // n9.b, n9.a
    Collection<? extends x> g();

    boolean p0();

    boolean q0();

    boolean s0();

    boolean t0();

    boolean x();

    a<? extends x> y();
}
