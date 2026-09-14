package h9;

import h9.d0;
import h9.e;
import java.lang.reflect.Field;
import ka.e;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import n9.o0;
import n9.p0;
import n9.q0;
import n9.r0;

/* loaded from: classes.dex */
public abstract class u<V> extends h9.f<V> implements e9.j<V> {

    /* renamed from: m, reason: collision with root package name */
    private static final Object f10653m;

    /* renamed from: g, reason: collision with root package name */
    private final d0.b<Field> f10654g;

    /* renamed from: h, reason: collision with root package name */
    private final d0.a<p0> f10655h;

    /* renamed from: i, reason: collision with root package name */
    private final j f10656i;

    /* renamed from: j, reason: collision with root package name */
    private final String f10657j;

    /* renamed from: k, reason: collision with root package name */
    private final String f10658k;

    /* renamed from: l, reason: collision with root package name */
    private final Object f10659l;

    /* loaded from: classes.dex */
    public static abstract class a<PropertyType, ReturnType> extends h9.f<ReturnType> implements e9.e<ReturnType> {
        @Override // h9.f
        public j k() {
            return q().k();
        }

        @Override // h9.f
        public boolean o() {
            return q().o();
        }

        public abstract o0 p();

        public abstract u<PropertyType> q();
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(y8.g gVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c<V> extends a<V, V> {

        /* renamed from: i, reason: collision with root package name */
        static final /* synthetic */ e9.j[] f10660i = {y8.w.g(new y8.t(y8.w.b(c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), y8.w.g(new y8.t(y8.w.b(c.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};

        /* renamed from: g, reason: collision with root package name */
        private final d0.a f10661g = d0.d(new b());

        /* renamed from: h, reason: collision with root package name */
        private final d0.b f10662h = d0.b(new a());

        /* loaded from: classes.dex */
        static final class a extends y8.l implements x8.a<i9.d<?>> {
            a() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final i9.d<?> b() {
                return v.a(c.this, true);
            }
        }

        /* loaded from: classes.dex */
        static final class b extends y8.l implements x8.a<q0> {
            b() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final q0 b() {
                q0 t10 = c.this.q().p().t();
                return t10 != null ? t10 : na.c.b(c.this.q().p(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b());
            }
        }

        @Override // e9.a
        public String c() {
            return "<get-" + q().c() + '>';
        }

        @Override // h9.f
        public i9.d<?> j() {
            return (i9.d) this.f10662h.c(this, f10660i[1]);
        }

        @Override // h9.u.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public q0 p() {
            return (q0) this.f10661g.c(this, f10660i[0]);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d<V> extends a<V, l8.w> {

        /* renamed from: i, reason: collision with root package name */
        static final /* synthetic */ e9.j[] f10665i = {y8.w.g(new y8.t(y8.w.b(d.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), y8.w.g(new y8.t(y8.w.b(d.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};

        /* renamed from: g, reason: collision with root package name */
        private final d0.a f10666g = d0.d(new b());

        /* renamed from: h, reason: collision with root package name */
        private final d0.b f10667h = d0.b(new a());

        /* loaded from: classes.dex */
        static final class a extends y8.l implements x8.a<i9.d<?>> {
            a() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final i9.d<?> b() {
                return v.a(d.this, false);
            }
        }

        /* loaded from: classes.dex */
        static final class b extends y8.l implements x8.a<r0> {
            b() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final r0 b() {
                r0 M0 = d.this.q().p().M0();
                if (M0 != null) {
                    return M0;
                }
                p0 p10 = d.this.q().p();
                g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b;
                return na.c.c(p10, aVar.b(), aVar.b());
            }
        }

        @Override // e9.a
        public String c() {
            return "<set-" + q().c() + '>';
        }

        @Override // h9.f
        public i9.d<?> j() {
            return (i9.d) this.f10667h.c(this, f10665i[1]);
        }

        @Override // h9.u.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public r0 p() {
            return (r0) this.f10666g.c(this, f10665i[0]);
        }
    }

    /* loaded from: classes.dex */
    static final class e extends y8.l implements x8.a<p0> {
        e() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p0 b() {
            return u.this.k().k(u.this.c(), u.this.w());
        }
    }

    /* loaded from: classes.dex */
    static final class f extends y8.l implements x8.a<Field> {
        f() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Field b() {
            Class<?> enclosingClass;
            h9.e f10 = h0.f10582b.f(u.this.p());
            if (!(f10 instanceof e.c)) {
                if (f10 instanceof e.a) {
                    return ((e.a) f10).b();
                }
                if ((f10 instanceof e.b) || (f10 instanceof e.d)) {
                    return null;
                }
                throw new l8.l();
            }
            e.c cVar = (e.c) f10;
            p0 b10 = cVar.b();
            e.a d10 = ka.h.d(ka.h.f11321a, cVar.e(), cVar.d(), cVar.g(), false, 8, null);
            if (d10 == null) {
                return null;
            }
            if (v9.l.e(b10) || ka.h.f(cVar.e())) {
                enclosingClass = u.this.k().b().getEnclosingClass();
            } else {
                n9.m d11 = b10.d();
                enclosingClass = d11 instanceof n9.e ? k0.l((n9.e) d11) : u.this.k().b();
            }
            if (enclosingClass == null) {
                return null;
            }
            try {
                return enclosingClass.getDeclaredField(d10.c());
            } catch (NoSuchFieldException unused) {
                return null;
            }
        }
    }

    static {
        new b(null);
        f10653m = new Object();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u(j jVar, String str, String str2, Object obj) {
        this(jVar, str, str2, null, obj);
        y8.k.e(jVar, "container");
        y8.k.e(str, "name");
        y8.k.e(str2, "signature");
    }

    private u(j jVar, String str, String str2, p0 p0Var, Object obj) {
        this.f10656i = jVar;
        this.f10657j = str;
        this.f10658k = str2;
        this.f10659l = obj;
        d0.b<Field> b10 = d0.b(new f());
        y8.k.d(b10, "ReflectProperties.lazy {…y -> null\n        }\n    }");
        this.f10654g = b10;
        d0.a<p0> c10 = d0.c(p0Var, new e());
        y8.k.d(c10, "ReflectProperties.lazySo…or(name, signature)\n    }");
        this.f10655h = c10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public u(h9.j r8, n9.p0 r9) {
        /*
            r7 = this;
            java.lang.String r0 = "container"
            y8.k.e(r8, r0)
            java.lang.String r0 = "descriptor"
            y8.k.e(r9, r0)
            la.e r0 = r9.c()
            java.lang.String r3 = r0.k()
            java.lang.String r0 = "descriptor.name.asString()"
            y8.k.d(r3, r0)
            h9.h0 r0 = h9.h0.f10582b
            h9.e r0 = r0.f(r9)
            java.lang.String r4 = r0.a()
            java.lang.Object r6 = y8.c.f15932l
            r1 = r7
            r2 = r8
            r5 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h9.u.<init>(h9.j, n9.p0):void");
    }

    @Override // e9.a
    public String c() {
        return this.f10657j;
    }

    public boolean equals(Object obj) {
        u<?> b10 = k0.b(obj);
        return b10 != null && y8.k.a(k(), b10.k()) && y8.k.a(c(), b10.c()) && y8.k.a(this.f10658k, b10.f10658k) && y8.k.a(this.f10659l, b10.f10659l);
    }

    public int hashCode() {
        return (((k().hashCode() * 31) + c().hashCode()) * 31) + this.f10658k.hashCode();
    }

    @Override // h9.f
    public i9.d<?> j() {
        return u().j();
    }

    @Override // h9.f
    public j k() {
        return this.f10656i;
    }

    @Override // h9.f
    public boolean o() {
        return !y8.k.a(this.f10659l, y8.c.f15932l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Field p() {
        if (p().o0()) {
            return v();
        }
        return null;
    }

    public final Object q() {
        return i9.h.a(this.f10659l, p());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:12:?, code lost:
    
        return r2.get(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(java.lang.reflect.Field r2, java.lang.Object r3) {
        /*
            r1 = this;
            java.lang.Object r0 = h9.u.f10653m     // Catch: java.lang.IllegalAccessException -> L39
            if (r3 != r0) goto L30
            n9.p0 r0 = r1.p()     // Catch: java.lang.IllegalAccessException -> L39
            n9.s0 r0 = r0.U()     // Catch: java.lang.IllegalAccessException -> L39
            if (r0 == 0) goto Lf
            goto L30
        Lf:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch: java.lang.IllegalAccessException -> L39
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.IllegalAccessException -> L39
            r3.<init>()     // Catch: java.lang.IllegalAccessException -> L39
            r0 = 39
            r3.append(r0)     // Catch: java.lang.IllegalAccessException -> L39
            r3.append(r1)     // Catch: java.lang.IllegalAccessException -> L39
            java.lang.String r0 = "' is not an extension property and thus getExtensionDelegate() "
            r3.append(r0)     // Catch: java.lang.IllegalAccessException -> L39
            java.lang.String r0 = "is not going to work, use getDelegate() instead"
            r3.append(r0)     // Catch: java.lang.IllegalAccessException -> L39
            java.lang.String r3 = r3.toString()     // Catch: java.lang.IllegalAccessException -> L39
            r2.<init>(r3)     // Catch: java.lang.IllegalAccessException -> L39
            throw r2     // Catch: java.lang.IllegalAccessException -> L39
        L30:
            if (r2 == 0) goto L37
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.IllegalAccessException -> L39
            goto L38
        L37:
            r2 = 0
        L38:
            return r2
        L39:
            r2 = move-exception
            f9.b r3 = new f9.b
            r3.<init>(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: h9.u.r(java.lang.reflect.Field, java.lang.Object):java.lang.Object");
    }

    @Override // h9.f
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public p0 p() {
        p0 b10 = this.f10655h.b();
        y8.k.d(b10, "_descriptor()");
        return b10;
    }

    public String toString() {
        return g0.f10543b.g(p());
    }

    public abstract c<V> u();

    public final Field v() {
        return this.f10654g.b();
    }

    public final String w() {
        return this.f10658k;
    }
}
