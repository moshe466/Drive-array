package h9;

import h9.d0;
import h9.u;
import java.lang.reflect.Field;
import n9.p0;

/* loaded from: classes.dex */
public class t<D, E, V> extends u<V> implements x8.p {

    /* renamed from: n, reason: collision with root package name */
    private final d0.b<a<D, E, V>> f10648n;

    /* renamed from: o, reason: collision with root package name */
    private final l8.h<Field> f10649o;

    /* loaded from: classes.dex */
    public static final class a<D, E, V> extends u.c<V> implements x8.p {

        /* renamed from: j, reason: collision with root package name */
        private final t<D, E, V> f10650j;

        /* JADX WARN: Multi-variable type inference failed */
        public a(t<D, E, ? extends V> tVar) {
            y8.k.e(tVar, "property");
            this.f10650j = tVar;
        }

        @Override // x8.p
        public V g(D d10, E e10) {
            return q().x(d10, e10);
        }

        @Override // h9.u.a
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public t<D, E, V> q() {
            return this.f10650j;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<a<D, E, ? extends V>> {
        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a<D, E, V> b() {
            return new a<>(t.this);
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.a<Field> {
        c() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Field b() {
            return t.this.p();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(j jVar, p0 p0Var) {
        super(jVar, p0Var);
        l8.h<Field> a10;
        y8.k.e(jVar, "container");
        y8.k.e(p0Var, "descriptor");
        d0.b<a<D, E, V>> b10 = d0.b(new b());
        y8.k.d(b10, "ReflectProperties.lazy { Getter(this) }");
        this.f10648n = b10;
        a10 = l8.j.a(kotlin.b.PUBLICATION, new c());
        this.f10649o = a10;
    }

    @Override // x8.p
    public V g(D d10, E e10) {
        return x(d10, e10);
    }

    public V x(D d10, E e10) {
        return u().a(d10, e10);
    }

    @Override // h9.u
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public a<D, E, V> u() {
        a<D, E, V> b10 = this.f10648n.b();
        y8.k.d(b10, "_getter()");
        return b10;
    }
}
