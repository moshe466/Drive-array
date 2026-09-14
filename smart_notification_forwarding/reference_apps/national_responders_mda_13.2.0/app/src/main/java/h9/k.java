package h9;

import h9.c;
import h9.d;
import h9.d0;
import i9.a;
import i9.e;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class k extends f<Object> implements y8.h<Object>, e9.e<Object>, h9.c {

    /* renamed from: l, reason: collision with root package name */
    static final /* synthetic */ e9.j[] f10595l = {y8.w.g(new y8.t(y8.w.b(k.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), y8.w.g(new y8.t(y8.w.b(k.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), y8.w.g(new y8.t(y8.w.b(k.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};

    /* renamed from: g, reason: collision with root package name */
    private final d0.a f10596g;

    /* renamed from: h, reason: collision with root package name */
    private final d0.b f10597h;

    /* renamed from: i, reason: collision with root package name */
    private final j f10598i;

    /* renamed from: j, reason: collision with root package name */
    private final String f10599j;

    /* renamed from: k, reason: collision with root package name */
    private final Object f10600k;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<i9.d<? extends Member>> {
        a() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i9.d<Member> b() {
            int n10;
            Object b10;
            i9.d w10;
            int n11;
            d g10 = h0.f10582b.g(k.this.p());
            if (g10 instanceof d.C0189d) {
                if (k.this.n()) {
                    Class<?> b11 = k.this.k().b();
                    List<e9.g> m10 = k.this.m();
                    n11 = m8.r.n(m10, 10);
                    ArrayList arrayList = new ArrayList(n11);
                    Iterator<T> it = m10.iterator();
                    while (it.hasNext()) {
                        String c10 = ((e9.g) it.next()).c();
                        y8.k.b(c10);
                        arrayList.add(c10);
                    }
                    return new i9.a(b11, arrayList, a.EnumC0200a.POSITIONAL_CALL, a.b.KOTLIN, null, 16, null);
                }
                b10 = k.this.k().f(((d.C0189d) g10).b());
            } else if (g10 instanceof d.e) {
                d.e eVar = (d.e) g10;
                b10 = k.this.k().j(eVar.c(), eVar.b());
            } else if (g10 instanceof d.c) {
                b10 = ((d.c) g10).b();
            } else {
                if (!(g10 instanceof d.b)) {
                    if (!(g10 instanceof d.a)) {
                        throw new l8.l();
                    }
                    List<Method> b12 = ((d.a) g10).b();
                    Class<?> b13 = k.this.k().b();
                    n10 = m8.r.n(b12, 10);
                    ArrayList arrayList2 = new ArrayList(n10);
                    for (Method method : b12) {
                        y8.k.d(method, "it");
                        arrayList2.add(method.getName());
                    }
                    return new i9.a(b13, arrayList2, a.EnumC0200a.POSITIONAL_CALL, a.b.JAVA, b12);
                }
                b10 = ((d.b) g10).b();
            }
            if (b10 instanceof Constructor) {
                k kVar = k.this;
                w10 = kVar.v((Constructor) b10, kVar.p());
            } else {
                if (!(b10 instanceof Method)) {
                    throw new b0("Could not compute caller for function: " + k.this.p() + " (member = " + b10 + ')');
                }
                Method method2 = (Method) b10;
                w10 = !Modifier.isStatic(method2.getModifiers()) ? k.this.w(method2) : k.this.p().u().e(k0.g()) != null ? k.this.x(method2) : k.this.y(method2);
            }
            return i9.h.c(w10, k.this.p(), false, 2, null);
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<i9.d<? extends Member>> {
        b() {
            super(0);
        }

        /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.reflect.Member, java.lang.Object] */
        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i9.d<Member> b() {
            GenericDeclaration genericDeclaration;
            int n10;
            int n11;
            i9.d dVar;
            d g10 = h0.f10582b.g(k.this.p());
            if (g10 instanceof d.e) {
                j k10 = k.this.k();
                d.e eVar = (d.e) g10;
                String c10 = eVar.c();
                String b10 = eVar.b();
                y8.k.b(k.this.j().c());
                genericDeclaration = k10.h(c10, b10, !Modifier.isStatic(r5.getModifiers()));
            } else if (g10 instanceof d.C0189d) {
                if (k.this.n()) {
                    Class<?> b11 = k.this.k().b();
                    List<e9.g> m10 = k.this.m();
                    n11 = m8.r.n(m10, 10);
                    ArrayList arrayList = new ArrayList(n11);
                    Iterator<T> it = m10.iterator();
                    while (it.hasNext()) {
                        String c11 = ((e9.g) it.next()).c();
                        y8.k.b(c11);
                        arrayList.add(c11);
                    }
                    return new i9.a(b11, arrayList, a.EnumC0200a.CALL_BY_NAME, a.b.KOTLIN, null, 16, null);
                }
                genericDeclaration = k.this.k().g(((d.C0189d) g10).b());
            } else {
                if (g10 instanceof d.a) {
                    List<Method> b12 = ((d.a) g10).b();
                    Class<?> b13 = k.this.k().b();
                    n10 = m8.r.n(b12, 10);
                    ArrayList arrayList2 = new ArrayList(n10);
                    for (Method method : b12) {
                        y8.k.d(method, "it");
                        arrayList2.add(method.getName());
                    }
                    return new i9.a(b13, arrayList2, a.EnumC0200a.CALL_BY_NAME, a.b.JAVA, b12);
                }
                genericDeclaration = null;
            }
            if (genericDeclaration instanceof Constructor) {
                k kVar = k.this;
                dVar = kVar.v((Constructor) genericDeclaration, kVar.p());
            } else if (genericDeclaration instanceof Method) {
                if (k.this.p().u().e(k0.g()) != null) {
                    n9.m d10 = k.this.p().d();
                    Objects.requireNonNull(d10, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    if (!((n9.e) d10).N()) {
                        dVar = k.this.x((Method) genericDeclaration);
                    }
                }
                dVar = k.this.y((Method) genericDeclaration);
            } else {
                dVar = null;
            }
            if (dVar != null) {
                return i9.h.b(dVar, k.this.p(), true);
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.a<n9.x> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f10604g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(0);
            this.f10604g = str;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final n9.x b() {
            return k.this.k().i(this.f10604g, k.this.f10599j);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(j jVar, String str, String str2, Object obj) {
        this(jVar, str, str2, null, obj);
        y8.k.e(jVar, "container");
        y8.k.e(str, "name");
        y8.k.e(str2, "signature");
    }

    private k(j jVar, String str, String str2, n9.x xVar, Object obj) {
        this.f10598i = jVar;
        this.f10599j = str2;
        this.f10600k = obj;
        this.f10596g = d0.c(xVar, new c(str));
        this.f10597h = d0.b(new a());
        d0.b(new b());
    }

    /* synthetic */ k(j jVar, String str, String str2, n9.x xVar, Object obj, int i10, y8.g gVar) {
        this(jVar, str, str2, xVar, (i10 & 16) != 0 ? y8.c.f15932l : obj);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k(h9.j r10, n9.x r11) {
        /*
            r9 = this;
            java.lang.String r0 = "container"
            y8.k.e(r10, r0)
            java.lang.String r0 = "descriptor"
            y8.k.e(r11, r0)
            la.e r0 = r11.c()
            java.lang.String r3 = r0.k()
            java.lang.String r0 = "descriptor.name.asString()"
            y8.k.d(r3, r0)
            h9.h0 r0 = h9.h0.f10582b
            h9.d r0 = r0.g(r11)
            java.lang.String r4 = r0.a()
            r6 = 0
            r7 = 16
            r8 = 0
            r1 = r9
            r2 = r10
            r5 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h9.k.<init>(h9.j, n9.x):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i9.e<Constructor<?>> v(Constructor<?> constructor, n9.x xVar) {
        return sa.a.f(xVar) ? o() ? new e.a(constructor, z()) : new e.b(constructor) : o() ? new e.c(constructor, z()) : new e.C0202e(constructor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e.h w(Method method) {
        return o() ? new e.h.a(method, z()) : new e.h.d(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e.h x(Method method) {
        return o() ? new e.h.b(method) : new e.h.C0205e(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e.h y(Method method) {
        return o() ? new e.h.c(method, z()) : new e.h.f(method);
    }

    private final Object z() {
        return i9.h.a(this.f10600k, p());
    }

    @Override // h9.f
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public n9.x p() {
        return (n9.x) this.f10596g.c(this, f10595l[0]);
    }

    @Override // x8.a
    public Object b() {
        return c.a.a(this);
    }

    @Override // e9.a
    public String c() {
        String k10 = p().c().k();
        y8.k.d(k10, "descriptor.name.asString()");
        return k10;
    }

    public boolean equals(Object obj) {
        k a10 = k0.a(obj);
        return a10 != null && y8.k.a(k(), a10.k()) && y8.k.a(c(), a10.c()) && y8.k.a(this.f10599j, a10.f10599j) && y8.k.a(this.f10600k, a10.f10600k);
    }

    @Override // x8.q
    public Object f(Object obj, Object obj2, Object obj3) {
        return c.a.d(this, obj, obj2, obj3);
    }

    @Override // x8.p
    public Object g(Object obj, Object obj2) {
        return c.a.c(this, obj, obj2);
    }

    @Override // x8.l
    public Object h(Object obj) {
        return c.a.b(this, obj);
    }

    public int hashCode() {
        return (((k().hashCode() * 31) + c().hashCode()) * 31) + this.f10599j.hashCode();
    }

    @Override // h9.f
    public i9.d<?> j() {
        return (i9.d) this.f10597h.c(this, f10595l[1]);
    }

    @Override // h9.f
    public j k() {
        return this.f10598i;
    }

    @Override // h9.f
    public boolean o() {
        return !y8.k.a(this.f10600k, y8.c.f15932l);
    }

    public String toString() {
        return g0.f10543b.d(p());
    }
}
