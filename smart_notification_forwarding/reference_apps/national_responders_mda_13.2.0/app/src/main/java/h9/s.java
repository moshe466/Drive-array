package h9;

import e9.i;
import h9.d0;
import h9.u;
import java.lang.reflect.Field;
import n9.p0;

/* loaded from: classes.dex */
public class s<T, V> extends u<V> implements e9.i<T, V> {

    /* renamed from: n, reason: collision with root package name */
    private final d0.b<a<T, V>> f10643n;

    /* renamed from: o, reason: collision with root package name */
    private final l8.h<Field> f10644o;

    /* loaded from: classes.dex */
    public static final class a<T, V> extends u.c<V> implements i.a<T, V> {

        /* renamed from: j, reason: collision with root package name */
        private final s<T, V> f10645j;

        /* JADX WARN: Multi-variable type inference failed */
        public a(s<T, ? extends V> sVar) {
            y8.k.e(sVar, "property");
            this.f10645j = sVar;
        }

        @Override // x8.l
        public V h(T t10) {
            return q().get(t10);
        }

        @Override // h9.u.a
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public s<T, V> q() {
            return this.f10645j;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<a<T, ? extends V>> {
        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a<T, V> b() {
            return new a<>(s.this);
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
            return s.this.p();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(j jVar, String str, String str2, Object obj) {
        super(jVar, str, str2, obj);
        l8.h<Field> a10;
        y8.k.e(jVar, "container");
        y8.k.e(str, "name");
        y8.k.e(str2, "signature");
        d0.b<a<T, V>> b10 = d0.b(new b());
        y8.k.d(b10, "ReflectProperties.lazy { Getter(this) }");
        this.f10643n = b10;
        a10 = l8.j.a(kotlin.b.PUBLICATION, new c());
        this.f10644o = a10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(j jVar, p0 p0Var) {
        super(jVar, p0Var);
        l8.h<Field> a10;
        y8.k.e(jVar, "container");
        y8.k.e(p0Var, "descriptor");
        d0.b<a<T, V>> b10 = d0.b(new b());
        y8.k.d(b10, "ReflectProperties.lazy { Getter(this) }");
        this.f10643n = b10;
        a10 = l8.j.a(kotlin.b.PUBLICATION, new c());
        this.f10644o = a10;
    }

    @Override // e9.i
    public V get(T t10) {
        return t().a(t10);
    }

    @Override // x8.l
    public V h(T t10) {
        return get(t10);
    }

    @Override // h9.u
    /* renamed from: x, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public a<T, V> u() {
        a<T, V> b10 = this.f10643n.b();
        y8.k.d(b10, "_getter()");
        return b10;
    }
}
