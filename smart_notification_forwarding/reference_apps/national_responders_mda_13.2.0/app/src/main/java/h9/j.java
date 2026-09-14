package h9;

import h9.d0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.SortedMap;
import n9.b;
import n9.p0;

/* loaded from: classes.dex */
public abstract class j implements y8.d {

    /* renamed from: h, reason: collision with root package name */
    public static final a f10587h = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Class<?> f10585f = y8.g.class;

    /* renamed from: g, reason: collision with root package name */
    private static final mb.f f10586g = new mb.f("<v#(\\d+)>");

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final mb.f a() {
            return j.f10586g;
        }
    }

    /* loaded from: classes.dex */
    public abstract class b {

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ e9.j[] f10588c = {y8.w.g(new y8.t(y8.w.b(b.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};

        /* renamed from: a, reason: collision with root package name */
        private final d0.a f10589a = d0.d(new a());

        /* loaded from: classes.dex */
        static final class a extends y8.l implements x8.a<r9.k> {
            a() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final r9.k b() {
                return c0.a(j.this.b());
            }
        }

        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final r9.k a() {
            return (r9.k) this.f10589a.c(this, f10588c[0]);
        }
    }

    /* loaded from: classes.dex */
    protected enum c {
        DECLARED,
        INHERITED;

        public final boolean accept(n9.b bVar) {
            y8.k.e(bVar, "member");
            b.a r10 = bVar.r();
            y8.k.d(r10, "member.kind");
            return r10.isReal() == (this == DECLARED);
        }
    }

    /* loaded from: classes.dex */
    static final class d extends y8.l implements x8.l<n9.x, CharSequence> {

        /* renamed from: f, reason: collision with root package name */
        public static final d f10592f = new d();

        d() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence h(n9.x xVar) {
            y8.k.e(xVar, "descriptor");
            return kotlin.reflect.jvm.internal.impl.renderer.c.f11500c.r(xVar) + " | " + h0.f10582b.g(xVar).a();
        }
    }

    /* loaded from: classes.dex */
    static final class e extends y8.l implements x8.l<p0, CharSequence> {

        /* renamed from: f, reason: collision with root package name */
        public static final e f10593f = new e();

        e() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence h(p0 p0Var) {
            y8.k.e(p0Var, "descriptor");
            return kotlin.reflect.jvm.internal.impl.renderer.c.f11500c.r(p0Var) + " | " + h0.f10582b.f(p0Var).a();
        }
    }

    /* loaded from: classes.dex */
    static final class f<T> implements Comparator<n9.u> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f10594a = new f();

        f() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(n9.u uVar, n9.u uVar2) {
            Integer d10 = n9.t.d(uVar, uVar2);
            if (d10 != null) {
                return d10.intValue();
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static final class g extends h9.a {
        g(j jVar, j jVar2) {
            super(jVar2);
        }

        @Override // p9.l, n9.o
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public h9.f<?> m(n9.l lVar, l8.w wVar) {
            y8.k.e(lVar, "descriptor");
            y8.k.e(wVar, "data");
            throw new IllegalStateException("No constructors should appear here: " + lVar);
        }
    }

    private final void e(List<Class<?>> list, String str, boolean z10) {
        list.addAll(r(str));
        int size = ((r5.size() + 32) - 1) / 32;
        for (int i10 = 0; i10 < size; i10++) {
            Class<?> cls = Integer.TYPE;
            y8.k.d(cls, "Integer.TYPE");
            list.add(cls);
        }
        Class cls2 = z10 ? f10585f : Object.class;
        y8.k.d(cls2, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(cls2);
    }

    private final List<Class<?>> r(String str) {
        boolean z10;
        int J;
        int i10;
        ArrayList arrayList = new ArrayList();
        int i11 = 1;
        while (str.charAt(i11) != ')') {
            int i12 = i11;
            while (str.charAt(i12) == '[') {
                i12++;
            }
            char charAt = str.charAt(i12);
            z10 = mb.s.z("VZCBSIFJD", charAt, false, 2, null);
            if (z10) {
                i10 = i12 + 1;
            } else {
                if (charAt != 'L') {
                    throw new b0("Unknown type prefix in the method signature: " + str);
                }
                J = mb.s.J(str, ';', i11, false, 4, null);
                i10 = J + 1;
            }
            arrayList.add(u(str, i11, i10));
            i11 = i10;
        }
        return arrayList;
    }

    private final Class<?> s(String str) {
        int J;
        J = mb.s.J(str, ')', 0, false, 6, null);
        return u(str, J + 1, str.length());
    }

    private final Method t(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z10) {
        Method t10;
        if (z10) {
            clsArr[0] = cls;
        }
        Method x10 = x(cls, str, clsArr, cls2);
        if (x10 != null) {
            return x10;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && (t10 = t(superclass, str, clsArr, cls2, z10)) != null) {
            return t10;
        }
        for (Class<?> cls3 : cls.getInterfaces()) {
            y8.k.d(cls3, "superInterface");
            Method t11 = t(cls3, str, clsArr, cls2, z10);
            if (t11 != null) {
                return t11;
            }
            if (z10) {
                Class<?> a10 = r9.e.a(s9.b.f(cls3), cls3.getName() + "$DefaultImpls");
                if (a10 != null) {
                    clsArr[0] = cls3;
                    Method x11 = x(a10, str, clsArr, cls2);
                    if (x11 != null) {
                        return x11;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    private final Class<?> u(String str, int i10, int i11) {
        String t10;
        Class<?> loadClass;
        String str2;
        char charAt = str.charAt(i10);
        if (charAt == 'F') {
            return Float.TYPE;
        }
        if (charAt == 'L') {
            ClassLoader f10 = s9.b.f(b());
            String substring = str.substring(i10 + 1, i11 - 1);
            y8.k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            t10 = mb.r.t(substring, '/', '.', false, 4, null);
            loadClass = f10.loadClass(t10);
            str2 = "jClass.safeClassLoader.l…d - 1).replace('/', '.'))";
        } else {
            if (charAt == 'S') {
                return Short.TYPE;
            }
            if (charAt != 'V') {
                if (charAt == 'I') {
                    return Integer.TYPE;
                }
                if (charAt == 'J') {
                    return Long.TYPE;
                }
                if (charAt == 'Z') {
                    return Boolean.TYPE;
                }
                if (charAt == '[') {
                    return s9.b.a(u(str, i10 + 1, i11));
                }
                switch (charAt) {
                    case 'B':
                        return Byte.TYPE;
                    case 'C':
                        return Character.TYPE;
                    case 'D':
                        return Double.TYPE;
                    default:
                        throw new b0("Unknown type prefix in the method signature: " + str);
                }
            }
            loadClass = Void.TYPE;
            str2 = "Void.TYPE";
        }
        y8.k.d(loadClass, str2);
        return loadClass;
    }

    private final Constructor<?> w(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Class[] clsArr = (Class[]) array;
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005a A[LOOP:0: B:9:0x0029->B:18:0x005a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.reflect.Method x(java.lang.Class<?> r7, java.lang.String r8, java.lang.Class<?>[] r9, java.lang.Class<?> r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = r9.length     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r9, r1)     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.Class[] r1 = (java.lang.Class[]) r1     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.reflect.Method r1 = r7.getDeclaredMethod(r8, r1)     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.String r2 = "result"
            y8.k.d(r1, r2)     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.Class r2 = r1.getReturnType()     // Catch: java.lang.NoSuchMethodException -> L5d
            boolean r2 = y8.k.a(r2, r10)     // Catch: java.lang.NoSuchMethodException -> L5d
            if (r2 == 0) goto L1d
            r0 = r1
            goto L5d
        L1d:
            java.lang.reflect.Method[] r7 = r7.getDeclaredMethods()     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.String r1 = "declaredMethods"
            y8.k.d(r7, r1)     // Catch: java.lang.NoSuchMethodException -> L5d
            int r1 = r7.length     // Catch: java.lang.NoSuchMethodException -> L5d
            r2 = 0
            r3 = 0
        L29:
            if (r3 >= r1) goto L5d
            r4 = r7[r3]     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.String r5 = "method"
            y8.k.d(r4, r5)     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.String r5 = r4.getName()     // Catch: java.lang.NoSuchMethodException -> L5d
            boolean r5 = y8.k.a(r5, r8)     // Catch: java.lang.NoSuchMethodException -> L5d
            if (r5 == 0) goto L55
            java.lang.Class r5 = r4.getReturnType()     // Catch: java.lang.NoSuchMethodException -> L5d
            boolean r5 = y8.k.a(r5, r10)     // Catch: java.lang.NoSuchMethodException -> L5d
            if (r5 == 0) goto L55
            java.lang.Class[] r5 = r4.getParameterTypes()     // Catch: java.lang.NoSuchMethodException -> L5d
            y8.k.b(r5)     // Catch: java.lang.NoSuchMethodException -> L5d
            boolean r5 = java.util.Arrays.equals(r5, r9)     // Catch: java.lang.NoSuchMethodException -> L5d
            if (r5 == 0) goto L55
            r5 = 1
            goto L56
        L55:
            r5 = 0
        L56:
            if (r5 == 0) goto L5a
            r0 = r4
            goto L5d
        L5a:
            int r3 = r3 + 1
            goto L29
        L5d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h9.j.x(java.lang.Class, java.lang.String, java.lang.Class[], java.lang.Class):java.lang.reflect.Method");
    }

    public final Constructor<?> f(String str) {
        y8.k.e(str, "desc");
        return w(b(), r(str));
    }

    public final Constructor<?> g(String str) {
        y8.k.e(str, "desc");
        Class<?> b10 = b();
        ArrayList arrayList = new ArrayList();
        e(arrayList, str, true);
        l8.w wVar = l8.w.f11824a;
        return w(b10, arrayList);
    }

    public final Method h(String str, String str2, boolean z10) {
        y8.k.e(str, "name");
        y8.k.e(str2, "desc");
        if (y8.k.a(str, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z10) {
            arrayList.add(b());
        }
        e(arrayList, str2, false);
        Class<?> p10 = p();
        String str3 = str + "$default";
        Object[] array = arrayList.toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return t(p10, str3, (Class[]) array, s(str2), z10);
    }

    public final n9.x i(String str, String str2) {
        Collection<n9.x> m10;
        String Q;
        y8.k.e(str, "name");
        y8.k.e(str2, "signature");
        if (y8.k.a(str, "<init>")) {
            m10 = m8.y.n0(l());
        } else {
            la.e r10 = la.e.r(str);
            y8.k.d(r10, "Name.identifier(name)");
            m10 = m(r10);
        }
        Collection<n9.x> collection = m10;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (y8.k.a(h0.f10582b.g((n9.x) obj).a(), str2)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 1) {
            return (n9.x) m8.o.d0(arrayList);
        }
        Q = m8.y.Q(collection, "\n", null, null, 0, null, d.f10592f, 30, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Function '");
        sb2.append(str);
        sb2.append("' (JVM signature: ");
        sb2.append(str2);
        sb2.append(") not resolved in ");
        sb2.append(this);
        sb2.append(':');
        sb2.append(Q.length() == 0 ? " no members found" : '\n' + Q);
        throw new b0(sb2.toString());
    }

    public final Method j(String str, String str2) {
        Method t10;
        y8.k.e(str, "name");
        y8.k.e(str2, "desc");
        if (y8.k.a(str, "<init>")) {
            return null;
        }
        Object[] array = r(str2).toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Class<?>[] clsArr = (Class[]) array;
        Class<?> s10 = s(str2);
        Method t11 = t(p(), str, clsArr, s10, false);
        if (t11 != null) {
            return t11;
        }
        if (!p().isInterface() || (t10 = t(Object.class, str, clsArr, s10, false)) == null) {
            return null;
        }
        return t10;
    }

    public final p0 k(String str, String str2) {
        Object d02;
        SortedMap g10;
        String Q;
        y8.k.e(str, "name");
        y8.k.e(str2, "signature");
        mb.d a10 = f10586g.a(str2);
        if (a10 != null) {
            String str3 = a10.b().a().a().get(1);
            p0 n10 = n(Integer.parseInt(str3));
            if (n10 != null) {
                return n10;
            }
            throw new b0("Local property #" + str3 + " not found in " + b());
        }
        la.e r10 = la.e.r(str);
        y8.k.d(r10, "Name.identifier(name)");
        Collection<p0> q10 = q(r10);
        ArrayList arrayList = new ArrayList();
        for (Object obj : q10) {
            if (y8.k.a(h0.f10582b.f((p0) obj).a(), str2)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            throw new b0("Property '" + str + "' (JVM signature: " + str2 + ") not resolved in " + this);
        }
        if (arrayList.size() != 1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj2 : arrayList) {
                n9.u h10 = ((p0) obj2).h();
                Object obj3 = linkedHashMap.get(h10);
                if (obj3 == null) {
                    obj3 = new ArrayList();
                    linkedHashMap.put(h10, obj3);
                }
                ((List) obj3).add(obj2);
            }
            g10 = m8.k0.g(linkedHashMap, f.f10594a);
            Collection values = g10.values();
            y8.k.d(values, "properties\n             …                }).values");
            List list = (List) m8.o.R(values);
            if (list.size() != 1) {
                la.e r11 = la.e.r(str);
                y8.k.d(r11, "Name.identifier(name)");
                Q = m8.y.Q(q(r11), "\n", null, null, 0, null, e.f10593f, 30, null);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Property '");
                sb2.append(str);
                sb2.append("' (JVM signature: ");
                sb2.append(str2);
                sb2.append(") not resolved in ");
                sb2.append(this);
                sb2.append(':');
                sb2.append(Q.length() == 0 ? " no members found" : '\n' + Q);
                throw new b0(sb2.toString());
            }
            y8.k.d(list, "mostVisibleProperties");
            d02 = m8.o.H(list);
        } else {
            d02 = m8.o.d0(arrayList);
        }
        return (p0) d02;
    }

    public abstract Collection<n9.l> l();

    public abstract Collection<n9.x> m(la.e eVar);

    public abstract p0 n(int i10);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0051 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x001e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Collection<h9.f<?>> o(ua.h r8, h9.j.c r9) {
        /*
            r7 = this;
            java.lang.String r0 = "scope"
            y8.k.e(r8, r0)
            java.lang.String r0 = "belonginess"
            y8.k.e(r9, r0)
            h9.j$g r0 = new h9.j$g
            r0.<init>(r7, r7)
            r1 = 0
            r2 = 3
            java.util.Collection r8 = ua.k.a.a(r8, r1, r1, r2, r1)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r8 = r8.iterator()
        L1e:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L55
            java.lang.Object r3 = r8.next()
            n9.m r3 = (n9.m) r3
            boolean r4 = r3 instanceof n9.b
            if (r4 == 0) goto L4e
            r4 = r3
            n9.b r4 = (n9.b) r4
            n9.u r5 = r4.h()
            n9.u r6 = n9.t.f12306h
            boolean r5 = y8.k.a(r5, r6)
            r5 = r5 ^ 1
            if (r5 == 0) goto L4e
            boolean r4 = r9.accept(r4)
            if (r4 == 0) goto L4e
            l8.w r4 = l8.w.f11824a
            java.lang.Object r3 = r3.J0(r0, r4)
            h9.f r3 = (h9.f) r3
            goto L4f
        L4e:
            r3 = r1
        L4f:
            if (r3 == 0) goto L1e
            r2.add(r3)
            goto L1e
        L55:
            java.util.List r8 = m8.o.n0(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: h9.j.o(ua.h, h9.j$c):java.util.Collection");
    }

    protected Class<?> p() {
        Class<?> g10 = s9.b.g(b());
        return g10 != null ? g10 : b();
    }

    public abstract Collection<p0> q(la.e eVar);
}
