package h9;

import h9.d0;
import h9.u;
import n9.p0;

/* loaded from: classes.dex */
public final class o<D, E, V> extends t<D, E, V> {

    /* renamed from: p, reason: collision with root package name */
    private final d0.b<a<D, E, V>> f10614p;

    /* loaded from: classes.dex */
    public static final class a<D, E, V> extends u.d<V> implements x8.q {

        /* renamed from: j, reason: collision with root package name */
        private final o<D, E, V> f10615j;

        public a(o<D, E, V> oVar) {
            y8.k.e(oVar, "property");
            this.f10615j = oVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // x8.q
        public /* bridge */ /* synthetic */ Object f(Object obj, Object obj2, Object obj3) {
            u(obj, obj2, obj3);
            return l8.w.f11824a;
        }

        @Override // h9.u.a
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public o<D, E, V> q() {
            return this.f10615j;
        }

        public void u(D d10, E e10, V v10) {
            q().A(d10, e10, v10);
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<a<D, E, V>> {
        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a<D, E, V> b() {
            return new a<>(o.this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(j jVar, p0 p0Var) {
        super(jVar, p0Var);
        y8.k.e(jVar, "container");
        y8.k.e(p0Var, "descriptor");
        d0.b<a<D, E, V>> b10 = d0.b(new b());
        y8.k.d(b10, "ReflectProperties.lazy { Setter(this) }");
        this.f10614p = b10;
    }

    public void A(D d10, E e10, V v10) {
        z().a(d10, e10, v10);
    }

    public a<D, E, V> z() {
        a<D, E, V> b10 = this.f10614p.b();
        y8.k.d(b10, "_setter()");
        return b10;
    }
}
