package m9;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import k9.k;
import m8.q;
import y8.k;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f12055a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f12056b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f12057c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f12058d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f12059e;

    /* renamed from: f, reason: collision with root package name */
    private static final la.a f12060f;

    /* renamed from: g, reason: collision with root package name */
    private static final la.b f12061g;

    /* renamed from: h, reason: collision with root package name */
    private static final la.a f12062h;

    /* renamed from: i, reason: collision with root package name */
    private static final HashMap<la.c, la.a> f12063i;

    /* renamed from: j, reason: collision with root package name */
    private static final HashMap<la.c, la.a> f12064j;

    /* renamed from: k, reason: collision with root package name */
    private static final HashMap<la.c, la.b> f12065k;

    /* renamed from: l, reason: collision with root package name */
    private static final HashMap<la.c, la.b> f12066l;

    /* renamed from: m, reason: collision with root package name */
    private static final List<a> f12067m;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final la.a f12068a;

        /* renamed from: b, reason: collision with root package name */
        private final la.a f12069b;

        /* renamed from: c, reason: collision with root package name */
        private final la.a f12070c;

        public a(la.a aVar, la.a aVar2, la.a aVar3) {
            k.e(aVar, "javaClass");
            k.e(aVar2, "kotlinReadOnly");
            k.e(aVar3, "kotlinMutable");
            this.f12068a = aVar;
            this.f12069b = aVar2;
            this.f12070c = aVar3;
        }

        public final la.a a() {
            return this.f12068a;
        }

        public final la.a b() {
            return this.f12069b;
        }

        public final la.a c() {
            return this.f12070c;
        }

        public final la.a d() {
            return this.f12068a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return k.a(this.f12068a, aVar.f12068a) && k.a(this.f12069b, aVar.f12069b) && k.a(this.f12070c, aVar.f12070c);
        }

        public int hashCode() {
            return (((this.f12068a.hashCode() * 31) + this.f12069b.hashCode()) * 31) + this.f12070c.hashCode();
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.f12068a + ", kotlinReadOnly=" + this.f12069b + ", kotlinMutable=" + this.f12070c + ')';
        }
    }

    static {
        List<a> g10;
        c cVar = new c();
        f12055a = cVar;
        StringBuilder sb2 = new StringBuilder();
        l9.c cVar2 = l9.c.Function;
        sb2.append(cVar2.getPackageFqName().toString());
        sb2.append('.');
        sb2.append(cVar2.getClassNamePrefix());
        f12056b = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        l9.c cVar3 = l9.c.KFunction;
        sb3.append(cVar3.getPackageFqName().toString());
        sb3.append('.');
        sb3.append(cVar3.getClassNamePrefix());
        f12057c = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        l9.c cVar4 = l9.c.SuspendFunction;
        sb4.append(cVar4.getPackageFqName().toString());
        sb4.append('.');
        sb4.append(cVar4.getClassNamePrefix());
        f12058d = sb4.toString();
        StringBuilder sb5 = new StringBuilder();
        l9.c cVar5 = l9.c.KSuspendFunction;
        sb5.append(cVar5.getPackageFqName().toString());
        sb5.append('.');
        sb5.append(cVar5.getClassNamePrefix());
        f12059e = sb5.toString();
        la.a m10 = la.a.m(new la.b("kotlin.jvm.functions.FunctionN"));
        k.d(m10, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        f12060f = m10;
        la.b b10 = m10.b();
        k.d(b10, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        f12061g = b10;
        la.a m11 = la.a.m(new la.b("kotlin.reflect.KFunction"));
        k.d(m11, "topLevel(FqName(\"kotlin.reflect.KFunction\"))");
        f12062h = m11;
        k.d(la.a.m(new la.b("kotlin.reflect.KClass")), "topLevel(FqName(\"kotlin.reflect.KClass\"))");
        cVar.h(Class.class);
        f12063i = new HashMap<>();
        f12064j = new HashMap<>();
        f12065k = new HashMap<>();
        f12066l = new HashMap<>();
        la.a m12 = la.a.m(k.a.I);
        y8.k.d(m12, "topLevel(FqNames.iterable)");
        la.b bVar = k.a.Q;
        la.b h10 = m12.h();
        la.b h11 = m12.h();
        y8.k.d(h11, "kotlinReadOnly.packageFqName");
        la.b d10 = la.d.d(bVar, h11);
        int i10 = 0;
        la.a aVar = new la.a(h10, d10, false);
        la.a m13 = la.a.m(k.a.H);
        y8.k.d(m13, "topLevel(FqNames.iterator)");
        la.b bVar2 = k.a.P;
        la.b h12 = m13.h();
        la.b h13 = m13.h();
        y8.k.d(h13, "kotlinReadOnly.packageFqName");
        la.a aVar2 = new la.a(h12, la.d.d(bVar2, h13), false);
        la.a m14 = la.a.m(k.a.J);
        y8.k.d(m14, "topLevel(FqNames.collection)");
        la.b bVar3 = k.a.R;
        la.b h14 = m14.h();
        la.b h15 = m14.h();
        y8.k.d(h15, "kotlinReadOnly.packageFqName");
        la.a aVar3 = new la.a(h14, la.d.d(bVar3, h15), false);
        la.a m15 = la.a.m(k.a.K);
        y8.k.d(m15, "topLevel(FqNames.list)");
        la.b bVar4 = k.a.S;
        la.b h16 = m15.h();
        la.b h17 = m15.h();
        y8.k.d(h17, "kotlinReadOnly.packageFqName");
        la.a aVar4 = new la.a(h16, la.d.d(bVar4, h17), false);
        la.a m16 = la.a.m(k.a.M);
        y8.k.d(m16, "topLevel(FqNames.set)");
        la.b bVar5 = k.a.U;
        la.b h18 = m16.h();
        la.b h19 = m16.h();
        y8.k.d(h19, "kotlinReadOnly.packageFqName");
        la.a aVar5 = new la.a(h18, la.d.d(bVar5, h19), false);
        la.a m17 = la.a.m(k.a.L);
        y8.k.d(m17, "topLevel(FqNames.listIterator)");
        la.b bVar6 = k.a.T;
        la.b h20 = m17.h();
        la.b h21 = m17.h();
        y8.k.d(h21, "kotlinReadOnly.packageFqName");
        la.a aVar6 = new la.a(h20, la.d.d(bVar6, h21), false);
        la.b bVar7 = k.a.N;
        la.a m18 = la.a.m(bVar7);
        y8.k.d(m18, "topLevel(FqNames.map)");
        la.b bVar8 = k.a.V;
        la.b h22 = m18.h();
        la.b h23 = m18.h();
        y8.k.d(h23, "kotlinReadOnly.packageFqName");
        la.a aVar7 = new la.a(h22, la.d.d(bVar8, h23), false);
        la.a d11 = la.a.m(bVar7).d(k.a.O.g());
        y8.k.d(d11, "topLevel(FqNames.map).createNestedClassId(FqNames.mapEntry.shortName())");
        la.b bVar9 = k.a.W;
        la.b h24 = d11.h();
        la.b h25 = d11.h();
        y8.k.d(h25, "kotlinReadOnly.packageFqName");
        g10 = q.g(new a(cVar.h(Iterable.class), m12, aVar), new a(cVar.h(Iterator.class), m13, aVar2), new a(cVar.h(Collection.class), m14, aVar3), new a(cVar.h(List.class), m15, aVar4), new a(cVar.h(Set.class), m16, aVar5), new a(cVar.h(ListIterator.class), m17, aVar6), new a(cVar.h(Map.class), m18, aVar7), new a(cVar.h(Map.Entry.class), d11, new la.a(h24, la.d.d(bVar9, h25), false)));
        f12067m = g10;
        cVar.g(Object.class, k.a.f11253b);
        cVar.g(String.class, k.a.f11263g);
        cVar.g(CharSequence.class, k.a.f11261f);
        cVar.f(Throwable.class, k.a.f11285s);
        cVar.g(Cloneable.class, k.a.f11257d);
        cVar.g(Number.class, k.a.f11283q);
        cVar.f(Comparable.class, k.a.f11286t);
        cVar.g(Enum.class, k.a.f11284r);
        cVar.f(Annotation.class, k.a.f11292z);
        Iterator<a> it = g10.iterator();
        while (it.hasNext()) {
            f12055a.e(it.next());
        }
        sa.d[] values = sa.d.values();
        int length = values.length;
        int i11 = 0;
        while (i11 < length) {
            sa.d dVar = values[i11];
            i11++;
            c cVar6 = f12055a;
            la.a m19 = la.a.m(dVar.getWrapperFqName());
            y8.k.d(m19, "topLevel(jvmType.wrapperFqName)");
            k9.k kVar = k9.k.f11235a;
            k9.i primitiveType = dVar.getPrimitiveType();
            y8.k.d(primitiveType, "jvmType.primitiveType");
            la.a m20 = la.a.m(k9.k.c(primitiveType));
            y8.k.d(m20, "topLevel(StandardNames.getPrimitiveFqName(jvmType.primitiveType))");
            cVar6.b(m19, m20);
        }
        for (la.a aVar8 : k9.c.f11209a.a()) {
            c cVar7 = f12055a;
            la.a m21 = la.a.m(new la.b("kotlin.jvm.internal." + aVar8.j().k() + "CompanionObject"));
            y8.k.d(m21, "topLevel(FqName(\"kotlin.jvm.internal.\" + classId.shortClassName.asString() + \"CompanionObject\"))");
            la.a d12 = aVar8.d(la.g.f11861b);
            y8.k.d(d12, "classId.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)");
            cVar7.b(m21, d12);
        }
        int i12 = 0;
        while (true) {
            int i13 = i12 + 1;
            c cVar8 = f12055a;
            la.a m22 = la.a.m(new la.b(y8.k.j("kotlin.jvm.functions.Function", Integer.valueOf(i12))));
            y8.k.d(m22, "topLevel(FqName(\"kotlin.jvm.functions.Function$i\"))");
            k9.k kVar2 = k9.k.f11235a;
            cVar8.b(m22, k9.k.a(i12));
            cVar8.d(new la.b(y8.k.j(f12057c, Integer.valueOf(i12))), f12062h);
            if (i13 >= 23) {
                break;
            } else {
                i12 = i13;
            }
        }
        while (true) {
            int i14 = i10 + 1;
            l9.c cVar9 = l9.c.KSuspendFunction;
            String str = cVar9.getPackageFqName().toString() + '.' + cVar9.getClassNamePrefix();
            c cVar10 = f12055a;
            cVar10.d(new la.b(y8.k.j(str, Integer.valueOf(i10))), f12062h);
            if (i14 >= 22) {
                la.b l10 = k.a.f11255c.l();
                y8.k.d(l10, "nothing.toSafe()");
                cVar10.d(l10, cVar10.h(Void.class));
                return;
            }
            i10 = i14;
        }
    }

    private c() {
    }

    private final void b(la.a aVar, la.a aVar2) {
        c(aVar, aVar2);
        la.b b10 = aVar2.b();
        y8.k.d(b10, "kotlinClassId.asSingleFqName()");
        d(b10, aVar);
    }

    private final void c(la.a aVar, la.a aVar2) {
        HashMap<la.c, la.a> hashMap = f12063i;
        la.c j10 = aVar.b().j();
        y8.k.d(j10, "javaClassId.asSingleFqName().toUnsafe()");
        hashMap.put(j10, aVar2);
    }

    private final void d(la.b bVar, la.a aVar) {
        HashMap<la.c, la.a> hashMap = f12064j;
        la.c j10 = bVar.j();
        y8.k.d(j10, "kotlinFqNameUnsafe.toUnsafe()");
        hashMap.put(j10, aVar);
    }

    private final void e(a aVar) {
        la.a a10 = aVar.a();
        la.a b10 = aVar.b();
        la.a c10 = aVar.c();
        b(a10, b10);
        la.b b11 = c10.b();
        y8.k.d(b11, "mutableClassId.asSingleFqName()");
        d(b11, a10);
        la.b b12 = b10.b();
        y8.k.d(b12, "readOnlyClassId.asSingleFqName()");
        la.b b13 = c10.b();
        y8.k.d(b13, "mutableClassId.asSingleFqName()");
        HashMap<la.c, la.b> hashMap = f12065k;
        la.c j10 = c10.b().j();
        y8.k.d(j10, "mutableClassId.asSingleFqName().toUnsafe()");
        hashMap.put(j10, b12);
        HashMap<la.c, la.b> hashMap2 = f12066l;
        la.c j11 = b12.j();
        y8.k.d(j11, "readOnlyFqName.toUnsafe()");
        hashMap2.put(j11, b13);
    }

    private final void f(Class<?> cls, la.b bVar) {
        la.a h10 = h(cls);
        la.a m10 = la.a.m(bVar);
        y8.k.d(m10, "topLevel(kotlinFqName)");
        b(h10, m10);
    }

    private final void g(Class<?> cls, la.c cVar) {
        la.b l10 = cVar.l();
        y8.k.d(l10, "kotlinFqName.toSafe()");
        f(cls, l10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final la.a h(Class<?> cls) {
        la.a d10;
        String str;
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            d10 = la.a.m(new la.b(cls.getCanonicalName()));
            str = "topLevel(FqName(clazz.canonicalName))";
        } else {
            d10 = h(declaringClass).d(la.e.r(cls.getSimpleName()));
            str = "classId(outer).createNestedClassId(Name.identifier(clazz.simpleName))";
        }
        y8.k.d(d10, str);
        return d10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0026, code lost:
    
        r5 = mb.q.f(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean k(la.c r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r5 = r5.b()
            java.lang.String r0 = "kotlinFqName.asString()"
            y8.k.d(r5, r0)
            java.lang.String r0 = ""
            java.lang.String r5 = mb.i.Y(r5, r6, r0)
            int r6 = r5.length()
            r0 = 1
            r1 = 0
            if (r6 <= 0) goto L19
            r6 = 1
            goto L1a
        L19:
            r6 = 0
        L1a:
            if (r6 == 0) goto L37
            r6 = 48
            r2 = 2
            r3 = 0
            boolean r6 = mb.i.V(r5, r6, r1, r2, r3)
            if (r6 != 0) goto L37
            java.lang.Integer r5 = mb.i.f(r5)
            if (r5 == 0) goto L35
            int r5 = r5.intValue()
            r6 = 23
            if (r5 < r6) goto L35
            goto L36
        L35:
            r0 = 0
        L36:
            return r0
        L37:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.c.k(la.c, java.lang.String):boolean");
    }

    public final la.b i() {
        return f12061g;
    }

    public final List<a> j() {
        return f12067m;
    }

    public final boolean l(la.c cVar) {
        HashMap<la.c, la.b> hashMap = f12065k;
        Objects.requireNonNull(hashMap, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return hashMap.containsKey(cVar);
    }

    public final boolean m(la.c cVar) {
        HashMap<la.c, la.b> hashMap = f12066l;
        Objects.requireNonNull(hashMap, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return hashMap.containsKey(cVar);
    }

    public final la.a n(la.b bVar) {
        y8.k.e(bVar, "fqName");
        return f12063i.get(bVar.j());
    }

    public final la.a o(la.c cVar) {
        y8.k.e(cVar, "kotlinFqName");
        return (k(cVar, f12056b) || k(cVar, f12058d)) ? f12060f : (k(cVar, f12057c) || k(cVar, f12059e)) ? f12062h : f12064j.get(cVar);
    }

    public final la.b p(la.c cVar) {
        return f12065k.get(cVar);
    }

    public final la.b q(la.c cVar) {
        return f12066l.get(cVar);
    }
}
