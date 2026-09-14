package m9;

import ab.m;
import ab.n;
import bb.a1;
import bb.b0;
import bb.e0;
import bb.i0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import jb.b;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import m8.o;
import m8.p;
import m8.q;
import m8.r;
import m8.r0;
import m9.f;
import n9.a0;
import n9.b;
import n9.d0;
import n9.d1;
import n9.f0;
import n9.s;
import n9.u0;
import n9.v0;
import n9.x;
import na.j;
import p9.z;
import ua.h;
import y8.t;
import y8.v;
import y8.w;

/* loaded from: classes.dex */
public final class g implements o9.a, o9.c {

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f12094h = {w.g(new t(w.b(g.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), w.g(new t(w.b(g.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), w.g(new t(w.b(g.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};

    /* renamed from: a, reason: collision with root package name */
    private final d0 f12095a;

    /* renamed from: b, reason: collision with root package name */
    private final m9.d f12096b;

    /* renamed from: c, reason: collision with root package name */
    private final ab.i f12097c;

    /* renamed from: d, reason: collision with root package name */
    private final b0 f12098d;

    /* renamed from: e, reason: collision with root package name */
    private final ab.i f12099e;

    /* renamed from: f, reason: collision with root package name */
    private final ab.a<la.b, n9.e> f12100f;

    /* renamed from: g, reason: collision with root package name */
    private final ab.i f12101g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum a {
        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] valuesCustom = values();
            a[] aVarArr = new a[valuesCustom.length];
            System.arraycopy(valuesCustom, 0, aVarArr, 0, valuesCustom.length);
            return aVarArr;
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12102a;

        static {
            int[] iArr = new int[a.valuesCustom().length];
            iArr[a.HIDDEN.ordinal()] = 1;
            iArr[a.NOT_CONSIDERED.ordinal()] = 2;
            iArr[a.DROP.ordinal()] = 3;
            iArr[a.VISIBLE.ordinal()] = 4;
            f12102a = iArr;
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.a<i0> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f12104g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(n nVar) {
            super(0);
            this.f12104g = nVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i0 b() {
            return n9.w.c(g.this.s().a(), m9.e.f12072d.a(), new f0(this.f12104g, g.this.s().a())).s();
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends z {
        d(d0 d0Var, la.b bVar) {
            super(d0Var, bVar);
        }

        @Override // n9.g0
        /* renamed from: U0, reason: merged with bridge method [inline-methods] */
        public h.b A() {
            return h.b.f14541b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e extends y8.l implements x8.a<b0> {
        e() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b0 b() {
            i0 i10 = g.this.f12095a.w().i();
            y8.k.d(i10, "moduleDescriptor.builtIns.anyType");
            return i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class f extends y8.l implements x8.a<n9.e> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ z9.f f12106f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ n9.e f12107g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(z9.f fVar, n9.e eVar) {
            super(0);
            this.f12106f = fVar;
            this.f12107g = eVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final n9.e b() {
            z9.f fVar = this.f12106f;
            w9.g gVar = w9.g.f15324a;
            y8.k.d(gVar, "EMPTY");
            return fVar.Y0(gVar, this.f12107g);
        }
    }

    /* renamed from: m9.g$g, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0252g extends y8.l implements x8.l<ua.h, Collection<? extends u0>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ la.e f12108f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0252g(la.e eVar) {
            super(1);
            this.f12108f = eVar;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<u0> h(ua.h hVar) {
            y8.k.e(hVar, "it");
            return hVar.b(this.f12108f, u9.d.FROM_BUILTINS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class h implements b.c<n9.e> {
        h() {
        }

        @Override // jb.b.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<n9.e> a(n9.e eVar) {
            Collection<b0> x10 = eVar.o().x();
            y8.k.d(x10, "it.typeConstructor.supertypes");
            g gVar = g.this;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = x10.iterator();
            while (it.hasNext()) {
                n9.h o10 = ((b0) it.next()).W0().o();
                n9.h a10 = o10 == null ? null : o10.a();
                n9.e eVar2 = a10 instanceof n9.e ? (n9.e) a10 : null;
                z9.f p10 = eVar2 != null ? gVar.p(eVar2) : null;
                if (p10 != null) {
                    arrayList.add(p10);
                }
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class i extends b.AbstractC0222b<n9.e, a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12110a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ v<a> f12111b;

        i(String str, v<a> vVar) {
            this.f12110a = str;
            this.f12111b = vVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0044 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0046 A[ORIG_RETURN, RETURN] */
        @Override // jb.b.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean c(n9.e r3) {
            /*
                r2 = this;
                java.lang.String r0 = "javaClassDescriptor"
                y8.k.e(r3, r0)
                ea.v r0 = ea.v.f9330a
                java.lang.String r1 = r2.f12110a
                java.lang.String r3 = ea.s.a(r0, r3, r1)
                m9.i r0 = m9.i.f12115a
                java.util.Set r1 = r0.e()
                boolean r1 = r1.contains(r3)
                if (r1 == 0) goto L20
                y8.v<m9.g$a> r3 = r2.f12111b
                m9.g$a r0 = m9.g.a.HIDDEN
            L1d:
                r3.f15950f = r0
                goto L3e
            L20:
                java.util.Set r1 = r0.h()
                boolean r1 = r1.contains(r3)
                if (r1 == 0) goto L2f
                y8.v<m9.g$a> r3 = r2.f12111b
                m9.g$a r0 = m9.g.a.VISIBLE
                goto L1d
            L2f:
                java.util.Set r0 = r0.c()
                boolean r3 = r0.contains(r3)
                if (r3 == 0) goto L3e
                y8.v<m9.g$a> r3 = r2.f12111b
                m9.g$a r0 = m9.g.a.DROP
                goto L1d
            L3e:
                y8.v<m9.g$a> r3 = r2.f12111b
                T r3 = r3.f15950f
                if (r3 != 0) goto L46
                r3 = 1
                goto L47
            L46:
                r3 = 0
            L47:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: m9.g.i.c(n9.e):boolean");
        }

        @Override // jb.b.d
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public a a() {
            a aVar = this.f12111b.f15950f;
            return aVar == null ? a.NOT_CONSIDERED : aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class j implements b.c<n9.b> {

        /* renamed from: a, reason: collision with root package name */
        public static final j f12112a = new j();

        j() {
        }

        @Override // jb.b.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<n9.b> a(n9.b bVar) {
            return bVar.a().g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class k extends y8.l implements x8.l<n9.b, Boolean> {
        k() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean h(n9.b bVar) {
            return Boolean.valueOf(bVar.r() == b.a.DECLARATION && g.this.f12096b.d((n9.e) bVar.d()));
        }
    }

    /* loaded from: classes.dex */
    static final class l extends y8.l implements x8.a<kotlin.reflect.jvm.internal.impl.descriptors.annotations.g> {
        l() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b() {
            List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> b10;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.c b11 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.b(g.this.f12095a.w(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null);
            g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b;
            b10 = p.b(b11);
            return aVar.a(b10);
        }
    }

    public g(d0 d0Var, n nVar, x8.a<f.b> aVar) {
        y8.k.e(d0Var, "moduleDescriptor");
        y8.k.e(nVar, "storageManager");
        y8.k.e(aVar, "settingsComputation");
        this.f12095a = d0Var;
        this.f12096b = m9.d.f12071a;
        this.f12097c = nVar.a(aVar);
        this.f12098d = k(nVar);
        this.f12099e = nVar.a(new c(nVar));
        this.f12100f = nVar.f();
        this.f12101g = nVar.a(new l());
    }

    private final u0 j(za.d dVar, u0 u0Var) {
        x.a<? extends u0> y10 = u0Var.y();
        y10.l(dVar);
        y10.d(n9.t.f12303e);
        y10.k(dVar.s());
        y10.b(dVar.T0());
        u0 c10 = y10.c();
        y8.k.b(c10);
        return c10;
    }

    private final b0 k(n nVar) {
        List b10;
        Set<n9.d> b11;
        d dVar = new d(this.f12095a, new la.b("java.io"));
        b10 = p.b(new e0(nVar, new e()));
        p9.h hVar = new p9.h(dVar, la.e.r("Serializable"), a0.ABSTRACT, n9.f.INTERFACE, b10, v0.f12324a, false, nVar);
        h.b bVar = h.b.f14541b;
        b11 = r0.b();
        hVar.V0(bVar, b11, null);
        i0 s10 = hVar.s();
        y8.k.d(s10, "mockSerializableClass.defaultType");
        return s10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e7, code lost:
    
        if (t(r3, r10) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.Collection<n9.u0> l(n9.e r10, x8.l<? super ua.h, ? extends java.util.Collection<? extends n9.u0>> r11) {
        /*
            r9 = this;
            z9.f r0 = r9.p(r10)
            if (r0 != 0) goto Lb
            java.util.List r10 = m8.o.d()
            return r10
        Lb:
            m9.d r1 = r9.f12096b
            la.b r2 = ra.a.i(r0)
            m9.b$a r3 = m9.b.f12053f
            k9.h r3 = r3.a()
            java.util.Collection r1 = r1.i(r2, r3)
            java.lang.Object r2 = m8.o.T(r1)
            n9.e r2 = (n9.e) r2
            if (r2 != 0) goto L28
            java.util.List r10 = m8.o.d()
            return r10
        L28:
            jb.j$b r3 = jb.j.f11086h
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = m8.o.n(r1, r5)
            r4.<init>(r5)
            java.util.Iterator r1 = r1.iterator()
        L39:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L4d
            java.lang.Object r5 = r1.next()
            n9.e r5 = (n9.e) r5
            la.b r5 = ra.a.i(r5)
            r4.add(r5)
            goto L39
        L4d:
            jb.j r1 = r3.b(r4)
            m9.d r3 = r9.f12096b
            boolean r10 = r3.d(r10)
            ab.a<la.b, n9.e> r3 = r9.f12100f
            la.b r4 = ra.a.i(r0)
            m9.g$f r5 = new m9.g$f
            r5.<init>(r0, r2)
            java.lang.Object r0 = r3.a(r4, r5)
            n9.e r0 = (n9.e) r0
            ua.h r0 = r0.E0()
            java.lang.String r2 = "fakeJavaClassDescriptor.unsubstitutedMemberScope"
            y8.k.d(r0, r2)
            java.lang.Object r11 = r11.h(r0)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r11 = r11.iterator()
        L80:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto Lef
            java.lang.Object r2 = r11.next()
            r3 = r2
            n9.u0 r3 = (n9.u0) r3
            n9.b$a r4 = r3.r()
            n9.b$a r5 = n9.b.a.DECLARATION
            r6 = 1
            r7 = 0
            if (r4 == r5) goto L99
        L97:
            r6 = 0
            goto Le9
        L99:
            n9.u r4 = r3.h()
            boolean r4 = r4.d()
            if (r4 != 0) goto La4
            goto L97
        La4:
            boolean r4 = k9.h.k0(r3)
            if (r4 == 0) goto Lab
            goto L97
        Lab:
            java.util.Collection r4 = r3.g()
            java.lang.String r5 = "analogueMember.overriddenDescriptors"
            y8.k.d(r4, r5)
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto Lbc
        Lba:
            r4 = 0
            goto Le0
        Lbc:
            java.util.Iterator r4 = r4.iterator()
        Lc0:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto Lba
            java.lang.Object r5 = r4.next()
            n9.x r5 = (n9.x) r5
            n9.m r5 = r5.d()
            java.lang.String r8 = "it.containingDeclaration"
            y8.k.d(r5, r8)
            la.b r5 = ra.a.i(r5)
            boolean r5 = r1.contains(r5)
            if (r5 == 0) goto Lc0
            r4 = 1
        Le0:
            if (r4 == 0) goto Le3
            goto L97
        Le3:
            boolean r3 = r9.t(r3, r10)
            if (r3 != 0) goto L97
        Le9:
            if (r6 == 0) goto L80
            r0.add(r2)
            goto L80
        Lef:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.g.l(n9.e, x8.l):java.util.Collection");
    }

    private final i0 m() {
        return (i0) m.a(this.f12099e, this, f12094h[1]);
    }

    private static final boolean n(n9.l lVar, a1 a1Var, n9.l lVar2) {
        return na.j.A(lVar, lVar2.e(a1Var)) == j.i.a.OVERRIDABLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final z9.f p(n9.e eVar) {
        if (k9.h.Z(eVar) || !k9.h.I0(eVar)) {
            return null;
        }
        la.c j10 = ra.a.j(eVar);
        if (!j10.f()) {
            return null;
        }
        la.a o10 = m9.c.f12055a.o(j10);
        la.b b10 = o10 == null ? null : o10.b();
        if (b10 == null) {
            return null;
        }
        n9.e a10 = s.a(s().a(), b10, u9.d.FROM_BUILTINS);
        if (a10 instanceof z9.f) {
            return (z9.f) a10;
        }
        return null;
    }

    private final a q(x xVar) {
        List b10;
        n9.e eVar = (n9.e) xVar.d();
        String c10 = ea.t.c(xVar, false, false, 3, null);
        v vVar = new v();
        b10 = p.b(eVar);
        Object b11 = jb.b.b(b10, new h(), new i(c10, vVar));
        y8.k.d(b11, "private fun FunctionDescriptor.getJdkMethodStatus(): JDKMemberStatus {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n        var result: JDKMemberStatus? = null\n        return DFS.dfs<ClassDescriptor, JDKMemberStatus>(\n            listOf(owner),\n            {\n                // Search through mapped supertypes to determine that Set.toArray should be invisible, while we have only\n                // Collection.toArray there explicitly\n                // Note, that we can't find j.u.Collection.toArray within overriddenDescriptors of j.u.Set.toArray\n                it.typeConstructor.supertypes.mapNotNull {\n                    (it.constructor.declarationDescriptor?.original as? ClassDescriptor)?.getJavaAnalogue()\n                }\n            },\n            object : DFS.AbstractNodeHandler<ClassDescriptor, JDKMemberStatus>() {\n                override fun beforeChildren(javaClassDescriptor: ClassDescriptor): Boolean {\n                    val signature = SignatureBuildingComponents.signature(javaClassDescriptor, jvmDescriptor)\n                    when (signature) {\n                        in HIDDEN_METHOD_SIGNATURES -> result = JDKMemberStatus.HIDDEN\n                        in VISIBLE_METHOD_SIGNATURES -> result = JDKMemberStatus.VISIBLE\n                        in DROP_LIST_METHOD_SIGNATURES -> result = JDKMemberStatus.DROP\n                    }\n\n                    return result == null\n                }\n\n                override fun result() = result ?: JDKMemberStatus.NOT_CONSIDERED\n            })\n    }");
        return (a) b11;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g r() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.annotations.g) m.a(this.f12101g, this, f12094h[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final f.b s() {
        return (f.b) m.a(this.f12097c, this, f12094h[0]);
    }

    private final boolean t(u0 u0Var, boolean z10) {
        List b10;
        if (z10 ^ m9.i.f12115a.f().contains(ea.s.a(ea.v.f9330a, (n9.e) u0Var.d(), ea.t.c(u0Var, false, false, 3, null)))) {
            return true;
        }
        b10 = p.b(u0Var);
        Boolean e10 = jb.b.e(b10, j.f12112a, new k());
        y8.k.d(e10, "private fun SimpleFunctionDescriptor.isMutabilityViolation(isMutable: Boolean): Boolean {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n\n        if ((SignatureBuildingComponents.signature(owner, jvmDescriptor) in MUTABLE_METHOD_SIGNATURES) xor isMutable) return true\n\n        return DFS.ifAny<CallableMemberDescriptor>(\n            listOf(this),\n            { it.original.overriddenDescriptors }\n        ) { overridden ->\n            overridden.kind == CallableMemberDescriptor.Kind.DECLARATION &&\n                    j2kClassMapper.isMutable(overridden.containingDeclaration as ClassDescriptor)\n        }\n    }");
        return e10.booleanValue();
    }

    private final boolean u(n9.l lVar, n9.e eVar) {
        if (lVar.l().size() == 1) {
            List<d1> l10 = lVar.l();
            y8.k.d(l10, "valueParameters");
            n9.h o10 = ((d1) o.d0(l10)).b().W0().o();
            if (y8.k.a(o10 == null ? null : ra.a.j(o10), ra.a.j(eVar))) {
                return true;
            }
        }
        return false;
    }

    @Override // o9.a
    public Collection<n9.d> a(n9.e eVar) {
        List d10;
        int n10;
        boolean z10;
        List d11;
        List d12;
        y8.k.e(eVar, "classDescriptor");
        if (eVar.r() != n9.f.CLASS || !s().b()) {
            d10 = q.d();
            return d10;
        }
        z9.f p10 = p(eVar);
        if (p10 == null) {
            d12 = q.d();
            return d12;
        }
        n9.e h10 = m9.d.h(this.f12096b, ra.a.i(p10), m9.b.f12053f.a(), null, 4, null);
        if (h10 == null) {
            d11 = q.d();
            return d11;
        }
        a1 c10 = m9.j.a(h10, p10).c();
        List<n9.d> q10 = p10.q();
        ArrayList<n9.d> arrayList = new ArrayList();
        Iterator<T> it = q10.iterator();
        while (true) {
            boolean z11 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            n9.d dVar = (n9.d) next;
            if (dVar.h().d()) {
                Collection<n9.d> q11 = h10.q();
                y8.k.d(q11, "defaultKotlinVersion.constructors");
                if (!q11.isEmpty()) {
                    for (n9.d dVar2 : q11) {
                        y8.k.d(dVar2, "it");
                        if (n(dVar2, c10, dVar)) {
                            z10 = false;
                            break;
                        }
                    }
                }
                z10 = true;
                if (z10 && !u(dVar, eVar) && !k9.h.k0(dVar) && !m9.i.f12115a.d().contains(ea.s.a(ea.v.f9330a, p10, ea.t.c(dVar, false, false, 3, null)))) {
                    z11 = true;
                }
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        n10 = r.n(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(n10);
        for (n9.d dVar3 : arrayList) {
            x.a<? extends x> y10 = dVar3.y();
            y10.l(eVar);
            y10.k(eVar.s());
            y10.n();
            y10.e(c10.j());
            if (!m9.i.f12115a.g().contains(ea.s.a(ea.v.f9330a, p10, ea.t.c(dVar3, false, false, 3, null)))) {
                y10.o(r());
            }
            x c11 = y10.c();
            Objects.requireNonNull(c11, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
            arrayList2.add((n9.d) c11);
        }
        return arrayList2;
    }

    @Override // o9.c
    public boolean c(n9.e eVar, u0 u0Var) {
        y8.k.e(eVar, "classDescriptor");
        y8.k.e(u0Var, "functionDescriptor");
        z9.f p10 = p(eVar);
        if (p10 == null || !u0Var.u().r(o9.d.a())) {
            return true;
        }
        if (!s().b()) {
            return false;
        }
        String c10 = ea.t.c(u0Var, false, false, 3, null);
        z9.g E0 = p10.E0();
        la.e c11 = u0Var.c();
        y8.k.d(c11, "functionDescriptor.name");
        Collection<u0> b10 = E0.b(c11, u9.d.FROM_BUILTINS);
        if (!(b10 instanceof Collection) || !b10.isEmpty()) {
            Iterator<T> it = b10.iterator();
            while (it.hasNext()) {
                if (y8.k.a(ea.t.c((u0) it.next(), false, false, 3, null), c10)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // o9.a
    public Collection<b0> d(n9.e eVar) {
        List d10;
        List b10;
        List g10;
        y8.k.e(eVar, "classDescriptor");
        la.c j10 = ra.a.j(eVar);
        m9.i iVar = m9.i.f12115a;
        if (iVar.i(j10)) {
            i0 m10 = m();
            y8.k.d(m10, "cloneableType");
            g10 = q.g(m10, this.f12098d);
            return g10;
        }
        if (iVar.j(j10)) {
            b10 = p.b(this.f12098d);
            return b10;
        }
        d10 = q.d();
        return d10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f7, code lost:
    
        if (r2 != 3) goto L42;
     */
    @Override // o9.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Collection<n9.u0> e(la.e r7, n9.e r8) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.g.e(la.e, n9.e):java.util.Collection");
    }

    @Override // o9.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Set<la.e> b(n9.e eVar) {
        Set<la.e> b10;
        z9.g E0;
        Set<la.e> b11;
        y8.k.e(eVar, "classDescriptor");
        if (!s().b()) {
            b11 = r0.b();
            return b11;
        }
        z9.f p10 = p(eVar);
        Set<la.e> set = null;
        if (p10 != null && (E0 = p10.E0()) != null) {
            set = E0.c();
        }
        if (set != null) {
            return set;
        }
        b10 = r0.b();
        return b10;
    }
}
