package h9;

import h9.d0;
import h9.u;
import n9.p0;

/* loaded from: classes.dex */
public final class l<V> extends r<V> {

    /* renamed from: p, reason: collision with root package name */
    private final d0.b<a<V>> f10606p;

    /* loaded from: classes.dex */
    public static final class a<R> extends u.d<R> implements x8.l {

        /* renamed from: j, reason: collision with root package name */
        private final l<R> f10607j;

        public a(l<R> lVar) {
            y8.k.e(lVar, "property");
            this.f10607j = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // x8.l
        public /* bridge */ /* synthetic */ Object h(Object obj) {
            u(obj);
            return l8.w.f11824a;
        }

        @Override // h9.u.a
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public l<R> q() {
            return this.f10607j;
        }

        public void u(R r10) {
            q().z(r10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(j jVar, p0 p0Var) {
        super(jVar, p0Var);
        y8.k.e(jVar, "container");
        y8.k.e(p0Var, "descriptor");
        d0.b<a<V>> b10 = d0.b(new m(this));
        y8.k.d(b10, "ReflectProperties.lazy { Setter(this) }");
        this.f10606p = b10;
    }

    public a<V> y() {
        a<V> b10 = this.f10606p.b();
        y8.k.d(b10, "_setter()");
        return b10;
    }

    public void z(V v10) {
        y().a(v10);
    }
}
