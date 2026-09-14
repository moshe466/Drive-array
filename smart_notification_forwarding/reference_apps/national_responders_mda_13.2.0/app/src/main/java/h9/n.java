package h9;

import h9.d0;
import h9.u;
import n9.p0;

/* loaded from: classes.dex */
public final class n<T, V> extends s<T, V> implements e9.f<T, V> {

    /* renamed from: p, reason: collision with root package name */
    private final d0.b<a<T, V>> f10611p;

    /* loaded from: classes.dex */
    public static final class a<T, V> extends u.d<V> implements x8.p {

        /* renamed from: j, reason: collision with root package name */
        private final n<T, V> f10612j;

        public a(n<T, V> nVar) {
            y8.k.e(nVar, "property");
            this.f10612j = nVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // x8.p
        public /* bridge */ /* synthetic */ Object g(Object obj, Object obj2) {
            u(obj, obj2);
            return l8.w.f11824a;
        }

        @Override // h9.u.a
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public n<T, V> q() {
            return this.f10612j;
        }

        public void u(T t10, V v10) {
            q().z(t10, v10);
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<a<T, V>> {
        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a<T, V> b() {
            return new a<>(n.this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(j jVar, String str, String str2, Object obj) {
        super(jVar, str, str2, obj);
        y8.k.e(jVar, "container");
        y8.k.e(str, "name");
        y8.k.e(str2, "signature");
        d0.b<a<T, V>> b10 = d0.b(new b());
        y8.k.d(b10, "ReflectProperties.lazy { Setter(this) }");
        this.f10611p = b10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(j jVar, p0 p0Var) {
        super(jVar, p0Var);
        y8.k.e(jVar, "container");
        y8.k.e(p0Var, "descriptor");
        d0.b<a<T, V>> b10 = d0.b(new b());
        y8.k.d(b10, "ReflectProperties.lazy { Setter(this) }");
        this.f10611p = b10;
    }

    public a<T, V> y() {
        a<T, V> b10 = this.f10611p.b();
        y8.k.d(b10, "_setter()");
        return b10;
    }

    public void z(T t10, V v10) {
        y().a(t10, v10);
    }
}
