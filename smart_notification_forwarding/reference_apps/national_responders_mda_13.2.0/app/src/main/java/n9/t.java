package n9;

import gb.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import n9.g1;

/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public static final u f12299a;

    /* renamed from: b, reason: collision with root package name */
    public static final u f12300b;

    /* renamed from: c, reason: collision with root package name */
    public static final u f12301c;

    /* renamed from: d, reason: collision with root package name */
    public static final u f12302d;

    /* renamed from: e, reason: collision with root package name */
    public static final u f12303e;

    /* renamed from: f, reason: collision with root package name */
    public static final u f12304f;

    /* renamed from: g, reason: collision with root package name */
    public static final u f12305g;

    /* renamed from: h, reason: collision with root package name */
    public static final u f12306h;

    /* renamed from: i, reason: collision with root package name */
    public static final u f12307i;

    /* renamed from: j, reason: collision with root package name */
    private static final Map<u, Integer> f12308j;

    /* renamed from: k, reason: collision with root package name */
    public static final u f12309k;

    /* renamed from: l, reason: collision with root package name */
    private static final va.d f12310l;

    /* renamed from: m, reason: collision with root package name */
    public static final va.d f12311m;

    /* renamed from: n, reason: collision with root package name */
    @Deprecated
    public static final va.d f12312n;

    /* renamed from: o, reason: collision with root package name */
    private static final gb.g f12313o;

    /* renamed from: p, reason: collision with root package name */
    private static final Map<h1, u> f12314p;

    /* loaded from: classes.dex */
    static class a implements va.d {
        a() {
        }

        @Override // va.d
        public bb.b0 b() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* loaded from: classes.dex */
    static class b implements va.d {
        b() {
        }

        @Override // va.d
        public bb.b0 b() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* loaded from: classes.dex */
    static class c implements va.d {
        c() {
        }

        @Override // va.d
        public bb.b0 b() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* loaded from: classes.dex */
    static class d extends r {
        d(h1 h1Var) {
            super(h1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "what";
            } else if (i10 != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean h(m mVar) {
            if (mVar == null) {
                g(0);
            }
            return na.d.j(mVar) != w0.f12327a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [n9.m, n9.q] */
        /* JADX WARN: Type inference failed for: r5v1, types: [n9.m] */
        /* JADX WARN: Type inference failed for: r5v2, types: [n9.m] */
        /* JADX WARN: Type inference failed for: r5v4, types: [n9.m] */
        @Override // n9.u
        public boolean e(va.d dVar, q qVar, m mVar) {
            if (qVar == 0) {
                g(1);
            }
            if (mVar == null) {
                g(2);
            }
            if (na.d.J(qVar) && h(mVar)) {
                return t.f(qVar, mVar);
            }
            if (qVar instanceof n9.l) {
                n9.i d10 = ((n9.l) qVar).d();
                if (na.d.G(d10) && na.d.J(d10) && (mVar instanceof n9.l) && na.d.J(mVar.d()) && t.f(qVar, mVar)) {
                    return true;
                }
            }
            while (qVar != 0) {
                qVar = qVar.d();
                if (((qVar instanceof n9.e) && !na.d.x(qVar)) || (qVar instanceof g0)) {
                    break;
                }
            }
            if (qVar == 0) {
                return false;
            }
            while (mVar != null) {
                if (qVar == mVar) {
                    return true;
                }
                if (mVar instanceof g0) {
                    return (qVar instanceof g0) && qVar.f().equals(((g0) mVar).f()) && na.d.b(mVar, qVar);
                }
                mVar = mVar.d();
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class e extends r {
        e(h1 h1Var) {
            super(h1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // n9.u
        public boolean e(va.d dVar, q qVar, m mVar) {
            m q10;
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            if (t.f12299a.e(dVar, qVar, mVar)) {
                if (dVar == t.f12311m) {
                    return true;
                }
                if (dVar != t.f12310l && (q10 = na.d.q(qVar, n9.e.class)) != null && (dVar instanceof va.f)) {
                    return ((va.f) dVar).n().a().equals(q10.a());
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class f extends r {
        f(h1 h1Var) {
            super(h1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "from";
            } else if (i10 == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i10 != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i10 == 2 || i10 == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean h(va.d dVar, q qVar, n9.e eVar) {
            if (qVar == null) {
                g(2);
            }
            if (eVar == null) {
                g(3);
            }
            if (dVar == t.f12312n) {
                return false;
            }
            if (!(qVar instanceof n9.b) || (qVar instanceof n9.l) || dVar == t.f12311m) {
                return true;
            }
            if (dVar == t.f12310l || dVar == null) {
                return false;
            }
            bb.b0 a10 = dVar instanceof va.e ? ((va.e) dVar).a() : dVar.b();
            return na.d.I(a10, eVar) || bb.r.a(a10);
        }

        @Override // n9.u
        public boolean e(va.d dVar, q qVar, m mVar) {
            n9.e eVar;
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            n9.e eVar2 = (n9.e) na.d.q(qVar, n9.e.class);
            n9.e eVar3 = (n9.e) na.d.r(mVar, n9.e.class, false);
            if (eVar3 == null) {
                return false;
            }
            if (eVar2 != null && na.d.x(eVar2) && (eVar = (n9.e) na.d.q(eVar2, n9.e.class)) != null && na.d.H(eVar3, eVar)) {
                return true;
            }
            q M = na.d.M(qVar);
            n9.e eVar4 = (n9.e) na.d.q(M, n9.e.class);
            if (eVar4 == null) {
                return false;
            }
            if (na.d.H(eVar3, eVar4) && h(dVar, M, eVar3)) {
                return true;
            }
            return e(dVar, qVar, eVar3.d());
        }
    }

    /* loaded from: classes.dex */
    static class g extends r {
        g(h1 h1Var) {
            super(h1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // n9.u
        public boolean e(va.d dVar, q qVar, m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            if (na.d.g(mVar).V(na.d.g(qVar))) {
                return t.f12313o.a(qVar, mVar);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class h extends r {
        h(h1 h1Var) {
            super(h1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // n9.u
        public boolean e(va.d dVar, q qVar, m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class i extends r {
        i(h1 h1Var) {
            super(h1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // n9.u
        public boolean e(va.d dVar, q qVar, m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }
    }

    /* loaded from: classes.dex */
    static class j extends r {
        j(h1 h1Var) {
            super(h1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // n9.u
        public boolean e(va.d dVar, q qVar, m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            throw new IllegalStateException("Visibility is unknown yet");
        }
    }

    /* loaded from: classes.dex */
    static class k extends r {
        k(h1 h1Var) {
            super(h1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // n9.u
        public boolean e(va.d dVar, q qVar, m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class l extends r {
        l(h1 h1Var) {
            super(h1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // n9.u
        public boolean e(va.d dVar, q qVar, m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return false;
        }
    }

    static {
        Set e10;
        d dVar = new d(g1.e.f12285c);
        f12299a = dVar;
        e eVar = new e(g1.f.f12286c);
        f12300b = eVar;
        f fVar = new f(g1.g.f12287c);
        f12301c = fVar;
        g gVar = new g(g1.b.f12282c);
        f12302d = gVar;
        h hVar = new h(g1.h.f12288c);
        f12303e = hVar;
        i iVar = new i(g1.d.f12284c);
        f12304f = iVar;
        j jVar = new j(g1.a.f12281c);
        f12305g = jVar;
        k kVar = new k(g1.c.f12283c);
        f12306h = kVar;
        l lVar = new l(g1.i.f12289c);
        f12307i = lVar;
        e10 = m8.r0.e(dVar, eVar, gVar, iVar);
        Collections.unmodifiableSet(e10);
        HashMap e11 = jb.a.e(4);
        e11.put(eVar, 0);
        e11.put(dVar, 0);
        e11.put(gVar, 1);
        e11.put(fVar, 1);
        e11.put(hVar, 2);
        f12308j = Collections.unmodifiableMap(e11);
        f12309k = hVar;
        f12310l = new a();
        f12311m = new b();
        f12312n = new c();
        Iterator it = ServiceLoader.load(gb.g.class, gb.g.class.getClassLoader()).iterator();
        f12313o = it.hasNext() ? (gb.g) it.next() : g.a.f10357a;
        f12314p = new HashMap();
        i(dVar);
        i(eVar);
        i(fVar);
        i(gVar);
        i(hVar);
        i(iVar);
        i(jVar);
        i(kVar);
        i(lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void a(int r8) {
        /*
            r0 = 16
            if (r8 == r0) goto L7
            java.lang.String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L9
        L7:
            java.lang.String r1 = "@NotNull method %s.%s must not return null"
        L9:
            r2 = 3
            r3 = 2
            if (r8 == r0) goto Lf
            r4 = 3
            goto L10
        Lf:
            r4 = 2
        L10:
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities"
            r6 = 1
            r7 = 0
            if (r8 == r6) goto L3a
            if (r8 == r2) goto L3a
            r2 = 5
            if (r8 == r2) goto L3a
            r2 = 7
            if (r8 == r2) goto L3a
            switch(r8) {
                case 9: goto L3a;
                case 10: goto L35;
                case 11: goto L30;
                case 12: goto L35;
                case 13: goto L30;
                case 14: goto L2b;
                case 15: goto L2b;
                case 16: goto L28;
                default: goto L23;
            }
        L23:
            java.lang.String r2 = "what"
            r4[r7] = r2
            goto L3e
        L28:
            r4[r7] = r5
            goto L3e
        L2b:
            java.lang.String r2 = "visibility"
            r4[r7] = r2
            goto L3e
        L30:
            java.lang.String r2 = "second"
            r4[r7] = r2
            goto L3e
        L35:
            java.lang.String r2 = "first"
            r4[r7] = r2
            goto L3e
        L3a:
            java.lang.String r2 = "from"
            r4[r7] = r2
        L3e:
            java.lang.String r2 = "toDescriptorVisibility"
            if (r8 == r0) goto L45
            r4[r6] = r5
            goto L47
        L45:
            r4[r6] = r2
        L47:
            switch(r8) {
                case 2: goto L70;
                case 3: goto L70;
                case 4: goto L6b;
                case 5: goto L6b;
                case 6: goto L66;
                case 7: goto L66;
                case 8: goto L61;
                case 9: goto L61;
                case 10: goto L5c;
                case 11: goto L5c;
                case 12: goto L57;
                case 13: goto L57;
                case 14: goto L52;
                case 15: goto L4f;
                case 16: goto L74;
                default: goto L4a;
            }
        L4a:
            java.lang.String r2 = "isVisible"
            r4[r3] = r2
            goto L74
        L4f:
            r4[r3] = r2
            goto L74
        L52:
            java.lang.String r2 = "isPrivate"
            r4[r3] = r2
            goto L74
        L57:
            java.lang.String r2 = "compare"
            r4[r3] = r2
            goto L74
        L5c:
            java.lang.String r2 = "compareLocal"
            r4[r3] = r2
            goto L74
        L61:
            java.lang.String r2 = "findInvisibleMember"
            r4[r3] = r2
            goto L74
        L66:
            java.lang.String r2 = "inSameFile"
            r4[r3] = r2
            goto L74
        L6b:
            java.lang.String r2 = "isVisibleWithAnyReceiver"
            r4[r3] = r2
            goto L74
        L70:
            java.lang.String r2 = "isVisibleIgnoringReceiver"
            r4[r3] = r2
        L74:
            java.lang.String r1 = java.lang.String.format(r1, r4)
            if (r8 == r0) goto L80
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r1)
            goto L85
        L80:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
        L85:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: n9.t.a(int):void");
    }

    public static Integer d(u uVar, u uVar2) {
        if (uVar == null) {
            a(12);
        }
        if (uVar2 == null) {
            a(13);
        }
        Integer a10 = uVar.a(uVar2);
        if (a10 != null) {
            return a10;
        }
        Integer a11 = uVar2.a(uVar);
        if (a11 != null) {
            return Integer.valueOf(-a11.intValue());
        }
        return null;
    }

    public static q e(va.d dVar, q qVar, m mVar) {
        q e10;
        if (qVar == null) {
            a(8);
        }
        if (mVar == null) {
            a(9);
        }
        m a10 = qVar.a();
        while (true) {
            q qVar2 = (q) a10;
            if (qVar2 == null || qVar2.h() == f12304f) {
                break;
            }
            if (!qVar2.h().e(dVar, qVar2, mVar)) {
                return qVar2;
            }
            a10 = na.d.q(qVar2, q.class);
        }
        if (!(qVar instanceof p9.h0) || (e10 = e(dVar, ((p9.h0) qVar).b0(), mVar)) == null) {
            return null;
        }
        return e10;
    }

    public static boolean f(m mVar, m mVar2) {
        if (mVar == null) {
            a(6);
        }
        if (mVar2 == null) {
            a(7);
        }
        w0 j10 = na.d.j(mVar2);
        if (j10 != w0.f12327a) {
            return j10.equals(na.d.j(mVar));
        }
        return false;
    }

    public static boolean g(u uVar) {
        if (uVar == null) {
            a(14);
        }
        return uVar == f12299a || uVar == f12300b;
    }

    public static boolean h(q qVar, m mVar) {
        if (qVar == null) {
            a(2);
        }
        if (mVar == null) {
            a(3);
        }
        return e(f12311m, qVar, mVar) == null;
    }

    private static void i(u uVar) {
        f12314p.put(uVar.b(), uVar);
    }

    public static u j(h1 h1Var) {
        if (h1Var == null) {
            a(15);
        }
        u uVar = f12314p.get(h1Var);
        if (uVar != null) {
            return uVar;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + h1Var);
    }
}
