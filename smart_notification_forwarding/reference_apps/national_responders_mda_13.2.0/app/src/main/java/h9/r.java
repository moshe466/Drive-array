package h9;

import h9.d0;
import h9.u;
import n9.p0;

/* loaded from: classes.dex */
public class r<V> extends u<V> implements e9.h<V> {

    /* renamed from: n, reason: collision with root package name */
    private final d0.b<a<V>> f10638n;

    /* renamed from: o, reason: collision with root package name */
    private final l8.h<Object> f10639o;

    /* loaded from: classes.dex */
    public static final class a<R> extends u.c<R> implements x8.a {

        /* renamed from: j, reason: collision with root package name */
        private final r<R> f10640j;

        /* JADX WARN: Multi-variable type inference failed */
        public a(r<? extends R> rVar) {
            y8.k.e(rVar, "property");
            this.f10640j = rVar;
        }

        @Override // x8.a
        public R b() {
            return q().get();
        }

        @Override // h9.u.a
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public r<R> q() {
            return this.f10640j;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<a<? extends V>> {
        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a<V> b() {
            return new a<>(r.this);
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.a<Object> {
        c() {
            super(0);
        }

        @Override // x8.a
        public final Object b() {
            r rVar = r.this;
            return rVar.r(rVar.p(), r.this.q());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(j jVar, String str, String str2, Object obj) {
        super(jVar, str, str2, obj);
        l8.h<Object> a10;
        y8.k.e(jVar, "container");
        y8.k.e(str, "name");
        y8.k.e(str2, "signature");
        d0.b<a<V>> b10 = d0.b(new b());
        y8.k.d(b10, "ReflectProperties.lazy { Getter(this) }");
        this.f10638n = b10;
        a10 = l8.j.a(kotlin.b.PUBLICATION, new c());
        this.f10639o = a10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(j jVar, p0 p0Var) {
        super(jVar, p0Var);
        l8.h<Object> a10;
        y8.k.e(jVar, "container");
        y8.k.e(p0Var, "descriptor");
        d0.b<a<V>> b10 = d0.b(new b());
        y8.k.d(b10, "ReflectProperties.lazy { Getter(this) }");
        this.f10638n = b10;
        a10 = l8.j.a(kotlin.b.PUBLICATION, new c());
        this.f10639o = a10;
    }

    @Override // x8.a
    public V b() {
        return get();
    }

    @Override // e9.h
    public V get() {
        return u().a(new Object[0]);
    }

    @Override // h9.u
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public a<V> u() {
        a<V> b10 = this.f10638n.b();
        y8.k.d(b10, "_getter()");
        return b10;
    }
}
