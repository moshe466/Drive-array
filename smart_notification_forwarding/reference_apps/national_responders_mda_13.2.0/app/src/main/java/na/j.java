package na;

import bb.b0;
import bb.d0;
import bb.t0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.types.checker.f;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import l8.w;
import m8.y;
import n9.a0;
import n9.a1;
import n9.b;
import n9.d1;
import n9.o0;
import n9.p0;
import n9.q;
import n9.s0;
import n9.t;
import n9.u;
import n9.x;
import n9.z;
import na.e;
import x8.p;

/* loaded from: classes.dex */
public class j {

    /* renamed from: c, reason: collision with root package name */
    private static final List<na.e> f12340c;

    /* renamed from: d, reason: collision with root package name */
    public static final j f12341d;

    /* renamed from: e, reason: collision with root package name */
    private static final f.a f12342e;

    /* renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.g f12343a;

    /* renamed from: b, reason: collision with root package name */
    private final f.a f12344b;

    /* loaded from: classes.dex */
    static class a implements f.a {
        a() {
        }

        private static /* synthetic */ void b(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "a";
            } else {
                objArr[0] = "b";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.f.a
        public boolean a(t0 t0Var, t0 t0Var2) {
            if (t0Var == null) {
                b(0);
            }
            if (t0Var2 == null) {
                b(1);
            }
            return t0Var.equals(t0Var2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [D] */
    /* loaded from: classes.dex */
    public static class b<D> implements p<D, D, l8.n<n9.a, n9.a>> {
        b() {
        }

        /* JADX WARN: Incorrect types in method signature: (TD;TD;)Ll8/n<Ln9/a;Ln9/a;>; */
        @Override // x8.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public l8.n g(n9.a aVar, n9.a aVar2) {
            return new l8.n(aVar, aVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c implements x8.l<n9.b, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ n9.m f12345f;

        c(n9.m mVar) {
            this.f12345f = mVar;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean h(n9.b bVar) {
            return Boolean.valueOf(bVar.d() == this.f12345f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d implements x8.l<n9.b, n9.a> {
        d() {
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n9.b h(n9.b bVar) {
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e implements x8.l<n9.b, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ n9.e f12346f;

        e(n9.e eVar) {
            this.f12346f = eVar;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean h(n9.b bVar) {
            return Boolean.valueOf(!t.g(bVar.h()) && t.h(bVar, this.f12346f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f implements x8.l<n9.b, n9.a> {
        f() {
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n9.a h(n9.b bVar) {
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class g implements x8.l<n9.b, w> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ na.i f12347f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ n9.b f12348g;

        g(na.i iVar, n9.b bVar) {
            this.f12347f = iVar;
            this.f12348g = bVar;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public w h(n9.b bVar) {
            this.f12347f.b(this.f12348g, bVar);
            return w.f11824a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class h {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12349a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f12350b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f12351c;

        static {
            int[] iArr = new int[a0.valuesCustom().length];
            f12351c = iArr;
            try {
                iArr[a0.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12351c[a0.SEALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12351c[a0.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12351c[a0.ABSTRACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[i.a.values().length];
            f12350b = iArr2;
            try {
                iArr2[i.a.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12350b[i.a.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12350b[i.a.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[e.b.values().length];
            f12349a = iArr3;
            try {
                iArr3[e.b.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12349a[e.b.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f12349a[e.b.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f12349a[e.b.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: b, reason: collision with root package name */
        private static final i f12352b = new i(a.OVERRIDABLE, "SUCCESS");

        /* renamed from: a, reason: collision with root package name */
        private final a f12353a;

        /* loaded from: classes.dex */
        public enum a {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        public i(a aVar, String str) {
            if (aVar == null) {
                a(3);
            }
            if (str == null) {
                a(4);
            }
            this.f12353a = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0045  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static /* synthetic */ void a(int r10) {
            /*
                r0 = 4
                r1 = 3
                r2 = 2
                r3 = 1
                if (r10 == r3) goto Lf
                if (r10 == r2) goto Lf
                if (r10 == r1) goto Lf
                if (r10 == r0) goto Lf
                java.lang.String r4 = "@NotNull method %s.%s must not return null"
                goto L11
            Lf:
                java.lang.String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            L11:
                if (r10 == r3) goto L1b
                if (r10 == r2) goto L1b
                if (r10 == r1) goto L1b
                if (r10 == r0) goto L1b
                r5 = 2
                goto L1c
            L1b:
                r5 = 3
            L1c:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "success"
                java.lang.String r7 = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo"
                r8 = 0
                if (r10 == r3) goto L31
                if (r10 == r2) goto L31
                if (r10 == r1) goto L2e
                if (r10 == r0) goto L31
                r5[r8] = r7
                goto L35
            L2e:
                r5[r8] = r6
                goto L35
            L31:
                java.lang.String r9 = "debugMessage"
                r5[r8] = r9
            L35:
                switch(r10) {
                    case 1: goto L45;
                    case 2: goto L45;
                    case 3: goto L45;
                    case 4: goto L45;
                    case 5: goto L40;
                    case 6: goto L3b;
                    default: goto L38;
                }
            L38:
                r5[r3] = r6
                goto L47
            L3b:
                java.lang.String r6 = "getDebugMessage"
                r5[r3] = r6
                goto L47
            L40:
                java.lang.String r6 = "getResult"
                r5[r3] = r6
                goto L47
            L45:
                r5[r3] = r7
            L47:
                if (r10 == r3) goto L5a
                if (r10 == r2) goto L55
                if (r10 == r1) goto L50
                if (r10 == r0) goto L50
                goto L5e
            L50:
                java.lang.String r6 = "<init>"
                r5[r2] = r6
                goto L5e
            L55:
                java.lang.String r6 = "conflict"
                r5[r2] = r6
                goto L5e
            L5a:
                java.lang.String r6 = "incompatible"
                r5[r2] = r6
            L5e:
                java.lang.String r4 = java.lang.String.format(r4, r5)
                if (r10 == r3) goto L70
                if (r10 == r2) goto L70
                if (r10 == r1) goto L70
                if (r10 == r0) goto L70
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                r10.<init>(r4)
                goto L75
            L70:
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                r10.<init>(r4)
            L75:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: na.j.i.a(int):void");
        }

        public static i b(String str) {
            if (str == null) {
                a(2);
            }
            return new i(a.CONFLICT, str);
        }

        public static i d(String str) {
            if (str == null) {
                a(1);
            }
            return new i(a.INCOMPATIBLE, str);
        }

        public static i e() {
            i iVar = f12352b;
            if (iVar == null) {
                a(0);
            }
            return iVar;
        }

        public a c() {
            a aVar = this.f12353a;
            if (aVar == null) {
                a(5);
            }
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: na.j$j, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0259j extends kotlin.reflect.jvm.internal.impl.types.checker.a {

        /* renamed from: j, reason: collision with root package name */
        private final Map<t0, t0> f12354j;

        public C0259j(Map<t0, t0> map) {
            super(true, true, true, j.this.f12343a);
            this.f12354j = map;
        }

        private static /* synthetic */ void I0(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1 || i10 == 3) {
                objArr[0] = "b";
            } else {
                objArr[0] = "a";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverridingUtilTypeCheckerContext";
            if (i10 == 2 || i10 == 3) {
                objArr[2] = "areEqualTypeConstructorsByAxioms";
            } else {
                objArr[2] = "areEqualTypeConstructors";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean J0(t0 t0Var, t0 t0Var2) {
            if (t0Var == null) {
                I0(2);
            }
            if (t0Var2 == null) {
                I0(3);
            }
            if (j.this.f12344b.a(t0Var, t0Var2)) {
                return true;
            }
            Map<t0, t0> map = this.f12354j;
            if (map == null) {
                return false;
            }
            t0 t0Var3 = map.get(t0Var);
            t0 t0Var4 = this.f12354j.get(t0Var2);
            if (t0Var3 == null || !t0Var3.equals(t0Var2)) {
                return t0Var4 != null && t0Var4.equals(t0Var);
            }
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.a
        public boolean G0(t0 t0Var, t0 t0Var2) {
            if (t0Var == null) {
                I0(0);
            }
            if (t0Var2 == null) {
                I0(1);
            }
            return super.G0(t0Var, t0Var2) || J0(t0Var, t0Var2);
        }
    }

    static {
        List<na.e> n02;
        n02 = y.n0(ServiceLoader.load(na.e.class, na.e.class.getClassLoader()));
        f12340c = n02;
        a aVar = new a();
        f12342e = aVar;
        f12341d = new j(aVar, g.a.f11566a);
    }

    private j(f.a aVar, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (aVar == null) {
            a(4);
        }
        if (gVar == null) {
            a(5);
        }
        this.f12344b = aVar;
        this.f12343a = gVar;
    }

    public static i.a A(n9.a aVar, n9.a aVar2) {
        j jVar = f12341d;
        i.a c10 = jVar.G(aVar2, aVar, null).c();
        i.a c11 = jVar.G(aVar, aVar2, null).c();
        i.a aVar3 = i.a.OVERRIDABLE;
        if (c10 == aVar3 && c11 == aVar3) {
            return aVar3;
        }
        i.a aVar4 = i.a.CONFLICT;
        return (c10 == aVar4 || c11 == aVar4) ? aVar4 : i.a.INCOMPATIBLE;
    }

    private static a0 B(Collection<n9.b> collection, boolean z10, a0 a0Var) {
        if (collection == null) {
            a(91);
        }
        if (a0Var == null) {
            a(92);
        }
        a0 a0Var2 = a0.ABSTRACT;
        for (n9.b bVar : collection) {
            a0 p10 = (z10 && bVar.p() == a0.ABSTRACT) ? a0Var : bVar.p();
            if (p10.compareTo(a0Var2) < 0) {
                a0Var2 = p10;
            }
        }
        if (a0Var2 == null) {
            a(93);
        }
        return a0Var2;
    }

    public static Set<n9.b> C(n9.b bVar) {
        if (bVar == null) {
            a(13);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        h(bVar, linkedHashSet);
        return linkedHashSet;
    }

    private static boolean D(o0 o0Var, o0 o0Var2) {
        if (o0Var == null || o0Var2 == null) {
            return true;
        }
        return K(o0Var, o0Var2);
    }

    public static boolean E(n9.a aVar, n9.a aVar2) {
        if (aVar == null) {
            a(65);
        }
        if (aVar2 == null) {
            a(66);
        }
        b0 i10 = aVar.i();
        b0 i11 = aVar2.i();
        if (!K(aVar, aVar2)) {
            return false;
        }
        l8.n<kotlin.reflect.jvm.internal.impl.types.checker.m, kotlin.reflect.jvm.internal.impl.types.checker.a> n10 = f12341d.n(aVar.m(), aVar2.m());
        if (aVar instanceof x) {
            return J(aVar, i10, aVar2, i11, n10);
        }
        if (!(aVar instanceof p0)) {
            throw new IllegalArgumentException("Unexpected callable: " + aVar.getClass());
        }
        p0 p0Var = (p0) aVar;
        p0 p0Var2 = (p0) aVar2;
        if (D(p0Var.M0(), p0Var2.M0())) {
            return (p0Var.P() && p0Var2.P()) ? n10.c().e(n10.d(), i10.Z0(), i11.Z0()) : (p0Var.P() || !p0Var2.P()) && J(aVar, i10, aVar2, i11, n10);
        }
        return false;
    }

    private static boolean F(n9.a aVar, Collection<n9.a> collection) {
        if (aVar == null) {
            a(69);
        }
        if (collection == null) {
            a(70);
        }
        Iterator<n9.a> it = collection.iterator();
        while (it.hasNext()) {
            if (!E(aVar, it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean J(n9.a aVar, b0 b0Var, n9.a aVar2, b0 b0Var2, l8.n<kotlin.reflect.jvm.internal.impl.types.checker.m, kotlin.reflect.jvm.internal.impl.types.checker.a> nVar) {
        if (aVar == null) {
            a(71);
        }
        if (b0Var == null) {
            a(72);
        }
        if (aVar2 == null) {
            a(73);
        }
        if (b0Var2 == null) {
            a(74);
        }
        if (nVar == null) {
            a(75);
        }
        return nVar.c().f(nVar.d(), b0Var.Z0(), b0Var2.Z0());
    }

    private static boolean K(q qVar, q qVar2) {
        if (qVar == null) {
            a(67);
        }
        if (qVar2 == null) {
            a(68);
        }
        Integer d10 = t.d(qVar.h(), qVar2.h());
        return d10 == null || d10.intValue() >= 0;
    }

    public static boolean L(z zVar, z zVar2) {
        if (zVar == null) {
            a(55);
        }
        if (zVar2 == null) {
            a(56);
        }
        return !t.g(zVar2.h()) && t.h(zVar2, zVar);
    }

    public static <D extends n9.a> boolean M(D d10, D d11, boolean z10, boolean z11) {
        if (d10 == null) {
            a(11);
        }
        if (d11 == null) {
            a(12);
        }
        if (!d10.equals(d11) && na.b.f12330a.e(d10.a(), d11.a(), z10, z11)) {
            return true;
        }
        n9.a a10 = d11.a();
        Iterator it = na.d.d(d10).iterator();
        while (it.hasNext()) {
            if (na.b.f12330a.e(a10, (n9.a) it.next(), z10, z11)) {
                return true;
            }
        }
        return false;
    }

    public static void N(n9.b bVar, x8.l<n9.b, w> lVar) {
        u uVar;
        if (bVar == null) {
            a(105);
        }
        for (n9.b bVar2 : bVar.g()) {
            if (bVar2.h() == t.f12305g) {
                N(bVar2, lVar);
            }
        }
        if (bVar.h() != t.f12305g) {
            return;
        }
        u j10 = j(bVar);
        if (j10 == null) {
            if (lVar != null) {
                lVar.h(bVar);
            }
            uVar = t.f12303e;
        } else {
            uVar = j10;
        }
        if (bVar instanceof p9.b0) {
            ((p9.b0) bVar).l1(uVar);
            Iterator<o0> it = ((p0) bVar).D().iterator();
            while (it.hasNext()) {
                N(it.next(), j10 == null ? null : lVar);
            }
            return;
        }
        if (bVar instanceof p9.p) {
            ((p9.p) bVar).u1(uVar);
            return;
        }
        p9.a0 a0Var = (p9.a0) bVar;
        a0Var.Z0(uVar);
        if (uVar != a0Var.y0().h()) {
            a0Var.X0(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <H> H O(Collection<H> collection, x8.l<H, n9.a> lVar) {
        List V;
        if (collection == null) {
            a(76);
        }
        if (lVar == 0) {
            a(77);
        }
        if (collection.size() == 1) {
            H h10 = (H) m8.o.G(collection);
            if (h10 == null) {
                a(78);
            }
            return h10;
        }
        ArrayList arrayList = new ArrayList(2);
        V = y.V(collection, lVar);
        H h11 = (H) m8.o.G(collection);
        n9.a aVar = (n9.a) lVar.h(h11);
        for (H h12 : collection) {
            n9.a aVar2 = (n9.a) lVar.h(h12);
            if (F(aVar2, V)) {
                arrayList.add(h12);
            }
            if (E(aVar2, aVar) && !E(aVar, aVar2)) {
                h11 = h12;
            }
        }
        if (arrayList.isEmpty()) {
            if (h11 == null) {
                a(79);
            }
            return h11;
        }
        if (arrayList.size() == 1) {
            H h13 = (H) m8.o.G(arrayList);
            if (h13 == null) {
                a(80);
            }
            return h13;
        }
        H h14 = null;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!bb.y.b(((n9.a) lVar.h(next)).i())) {
                h14 = next;
                break;
            }
        }
        if (h14 != null) {
            return h14;
        }
        H h15 = (H) m8.o.G(arrayList);
        if (h15 == null) {
            a(82);
        }
        return h15;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:86:0x0246. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:87:0x0249. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:88:0x024c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:104:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x004c A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x002d A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0157 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x023a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0258 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void a(int r22) {
        /*
            Method dump skipped, instructions count: 1282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: na.j.a(int):void");
    }

    private static boolean d(Collection<n9.b> collection) {
        boolean z10;
        if (collection == null) {
            a(61);
        }
        if (collection.size() < 2) {
            return true;
        }
        z10 = y.z(collection, new c(collection.iterator().next().d()));
        return z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        r1.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean e(n9.a1 r5, n9.a1 r6, l8.n<kotlin.reflect.jvm.internal.impl.types.checker.m, kotlin.reflect.jvm.internal.impl.types.checker.a> r7) {
        /*
            r4 = this;
            if (r5 != 0) goto L7
            r0 = 47
            a(r0)
        L7:
            if (r6 != 0) goto Le
            r0 = 48
            a(r0)
        Le:
            if (r7 != 0) goto L15
            r0 = 49
            a(r0)
        L15:
            java.util.List r5 = r5.getUpperBounds()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List r6 = r6.getUpperBounds()
            r0.<init>(r6)
            int r6 = r5.size()
            int r1 = r0.size()
            r2 = 0
            if (r6 == r1) goto L2e
            return r2
        L2e:
            java.util.Iterator r5 = r5.iterator()
        L32:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L59
            java.lang.Object r6 = r5.next()
            bb.b0 r6 = (bb.b0) r6
            java.util.ListIterator r1 = r0.listIterator()
        L42:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L58
            java.lang.Object r3 = r1.next()
            bb.b0 r3 = (bb.b0) r3
            boolean r3 = r4.f(r6, r3, r7)
            if (r3 == 0) goto L42
            r1.remove()
            goto L32
        L58:
            return r2
        L59:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: na.j.e(n9.a1, n9.a1, l8.n):boolean");
    }

    private boolean f(b0 b0Var, b0 b0Var2, l8.n<kotlin.reflect.jvm.internal.impl.types.checker.m, kotlin.reflect.jvm.internal.impl.types.checker.a> nVar) {
        if (b0Var == null) {
            a(44);
        }
        if (b0Var2 == null) {
            a(45);
        }
        if (nVar == null) {
            a(46);
        }
        if (d0.a(b0Var) && d0.a(b0Var2)) {
            return true;
        }
        return nVar.c().e(nVar.d(), b0Var.Z0(), b0Var2.Z0());
    }

    private static i g(n9.a aVar, n9.a aVar2) {
        String str;
        if ((aVar.U() == null) != (aVar2.U() == null)) {
            str = "Receiver presence mismatch";
        } else {
            if (aVar.l().size() == aVar2.l().size()) {
                return null;
            }
            str = "Value parameter number mismatch";
        }
        return i.d(str);
    }

    private static void h(n9.b bVar, Set<n9.b> set) {
        if (bVar == null) {
            a(15);
        }
        if (set == null) {
            a(16);
        }
        if (bVar.r().isReal()) {
            set.add(bVar);
            return;
        }
        if (bVar.g().isEmpty()) {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + bVar);
        }
        Iterator<? extends n9.b> it = bVar.g().iterator();
        while (it.hasNext()) {
            h(it.next(), set);
        }
    }

    private static List<b0> i(n9.a aVar) {
        s0 U = aVar.U();
        ArrayList arrayList = new ArrayList();
        if (U != null) {
            arrayList.add(U.b());
        }
        Iterator<d1> it = aVar.l().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().b());
        }
        return arrayList;
    }

    private static u j(n9.b bVar) {
        if (bVar == null) {
            a(106);
        }
        Collection<? extends n9.b> g10 = bVar.g();
        u x10 = x(g10);
        if (x10 == null) {
            return null;
        }
        if (bVar.r() != b.a.FAKE_OVERRIDE) {
            return x10.f();
        }
        for (n9.b bVar2 : g10) {
            if (bVar2.p() != a0.ABSTRACT && !bVar2.h().equals(x10)) {
                return null;
            }
        }
        return x10;
    }

    public static j k(kotlin.reflect.jvm.internal.impl.types.checker.g gVar, f.a aVar) {
        if (gVar == null) {
            a(2);
        }
        if (aVar == null) {
            a(3);
        }
        return new j(aVar, gVar);
    }

    private static void l(Collection<n9.b> collection, n9.e eVar, na.i iVar) {
        if (collection == null) {
            a(83);
        }
        if (eVar == null) {
            a(84);
        }
        if (iVar == null) {
            a(85);
        }
        Collection<n9.b> w10 = w(eVar, collection);
        boolean isEmpty = w10.isEmpty();
        if (!isEmpty) {
            collection = w10;
        }
        n9.b V0 = ((n9.b) O(collection, new d())).V0(eVar, q(collection, eVar), isEmpty ? t.f12306h : t.f12305g, b.a.FAKE_OVERRIDE, false);
        iVar.d(V0, collection);
        iVar.a(V0);
    }

    private static void m(n9.e eVar, Collection<n9.b> collection, na.i iVar) {
        if (eVar == null) {
            a(62);
        }
        if (collection == null) {
            a(63);
        }
        if (iVar == null) {
            a(64);
        }
        if (d(collection)) {
            Iterator<n9.b> it = collection.iterator();
            while (it.hasNext()) {
                l(Collections.singleton(it.next()), eVar, iVar);
            }
        } else {
            LinkedList linkedList = new LinkedList(collection);
            while (!linkedList.isEmpty()) {
                l(t(o.a(linkedList), linkedList, iVar), eVar, iVar);
            }
        }
    }

    private l8.n<kotlin.reflect.jvm.internal.impl.types.checker.m, kotlin.reflect.jvm.internal.impl.types.checker.a> n(List<a1> list, List<a1> list2) {
        if (list == null) {
            a(40);
        }
        if (list2 == null) {
            a(41);
        }
        return new l8.n<>(new kotlin.reflect.jvm.internal.impl.types.checker.m(this.f12343a), o(list, list2));
    }

    private C0259j o(List<a1> list, List<a1> list2) {
        if (list == null) {
            a(42);
        }
        if (list2 == null) {
            a(43);
        }
        if (list.isEmpty()) {
            return new C0259j(null);
        }
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < list.size(); i10++) {
            hashMap.put(list.get(i10).o(), list2.get(i10).o());
        }
        return new C0259j(hashMap);
    }

    public static j p(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            a(1);
        }
        return new j(f12342e, gVar);
    }

    private static a0 q(Collection<n9.b> collection, n9.e eVar) {
        if (collection == null) {
            a(86);
        }
        if (eVar == null) {
            a(87);
        }
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        for (n9.b bVar : collection) {
            int i10 = h.f12351c[bVar.p().ordinal()];
            if (i10 == 1) {
                a0 a0Var = a0.FINAL;
                if (a0Var == null) {
                    a(88);
                }
                return a0Var;
            }
            if (i10 == 2) {
                throw new IllegalStateException("Member cannot have SEALED modality: " + bVar);
            }
            if (i10 == 3) {
                z11 = true;
            } else if (i10 == 4) {
                z12 = true;
            }
        }
        if (eVar.l0() && eVar.p() != a0.ABSTRACT && eVar.p() != a0.SEALED) {
            z10 = true;
        }
        if (z11 && !z12) {
            a0 a0Var2 = a0.OPEN;
            if (a0Var2 == null) {
                a(89);
            }
            return a0Var2;
        }
        if (!z11 && z12) {
            a0 p10 = z10 ? eVar.p() : a0.ABSTRACT;
            if (p10 == null) {
                a(90);
            }
            return p10;
        }
        HashSet hashSet = new HashSet();
        Iterator<n9.b> it = collection.iterator();
        while (it.hasNext()) {
            hashSet.addAll(C(it.next()));
        }
        return B(u(hashSet), z10, eVar.p());
    }

    private Collection<n9.b> r(n9.b bVar, Collection<? extends n9.b> collection, n9.e eVar, na.i iVar) {
        if (bVar == null) {
            a(57);
        }
        if (collection == null) {
            a(58);
        }
        if (eVar == null) {
            a(59);
        }
        if (iVar == null) {
            a(60);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        jb.j c10 = jb.j.c();
        for (n9.b bVar2 : collection) {
            i.a c11 = G(bVar2, bVar, eVar).c();
            boolean L = L(bVar, bVar2);
            int i10 = h.f12350b[c11.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    if (L) {
                        iVar.c(bVar2, bVar);
                    }
                }
            } else if (L) {
                c10.add(bVar2);
            }
            arrayList.add(bVar2);
        }
        iVar.d(bVar, c10);
        return arrayList;
    }

    public static <H> Collection<H> s(H h10, Collection<H> collection, x8.l<H, n9.a> lVar, x8.l<H, w> lVar2) {
        if (h10 == null) {
            a(97);
        }
        if (collection == null) {
            a(98);
        }
        if (lVar == null) {
            a(99);
        }
        if (lVar2 == null) {
            a(100);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h10);
        n9.a h11 = lVar.h(h10);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            n9.a h12 = lVar.h(next);
            if (h10 != next) {
                i.a A = A(h11, h12);
                if (A == i.a.OVERRIDABLE) {
                    arrayList.add(next);
                } else if (A == i.a.CONFLICT) {
                    lVar2.h(next);
                }
            }
            it.remove();
        }
        return arrayList;
    }

    private static Collection<n9.b> t(n9.b bVar, Queue<n9.b> queue, na.i iVar) {
        if (bVar == null) {
            a(102);
        }
        if (queue == null) {
            a(103);
        }
        if (iVar == null) {
            a(104);
        }
        return s(bVar, queue, new f(), new g(iVar, bVar));
    }

    public static <D extends n9.a> Set<D> u(Set<D> set) {
        if (set == null) {
            a(6);
        }
        return v(set, !set.isEmpty() && ra.a.q(ra.a.l(set.iterator().next())), null, new b());
    }

    public static <D> Set<D> v(Set<D> set, boolean z10, x8.a<?> aVar, p<? super D, ? super D, l8.n<n9.a, n9.a>> pVar) {
        if (set == null) {
            a(7);
        }
        if (pVar == null) {
            a(8);
        }
        if (set.size() <= 1) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (aVar != null) {
                aVar.b();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedHashSet.add(obj);
                    break;
                }
                l8.n<n9.a, n9.a> g10 = pVar.g(obj, (Object) it.next());
                n9.a a10 = g10.a();
                n9.a b10 = g10.b();
                if (!M(a10, b10, z10, true)) {
                    if (M(b10, a10, z10, true)) {
                        break;
                    }
                } else {
                    it.remove();
                }
            }
        }
        return linkedHashSet;
    }

    private static Collection<n9.b> w(n9.e eVar, Collection<n9.b> collection) {
        List F;
        if (eVar == null) {
            a(94);
        }
        if (collection == null) {
            a(95);
        }
        F = y.F(collection, new e(eVar));
        if (F == null) {
            a(96);
        }
        return F;
    }

    public static u x(Collection<? extends n9.b> collection) {
        u uVar;
        if (collection == null) {
            a(107);
        }
        if (collection.isEmpty()) {
            return t.f12309k;
        }
        Iterator<? extends n9.b> it = collection.iterator();
        loop0: while (true) {
            uVar = null;
            while (it.hasNext()) {
                u h10 = it.next().h();
                if (uVar != null) {
                    Integer d10 = t.d(h10, uVar);
                    if (d10 == null) {
                        break;
                    }
                    if (d10.intValue() > 0) {
                    }
                }
                uVar = h10;
            }
        }
        if (uVar == null) {
            return null;
        }
        Iterator<? extends n9.b> it2 = collection.iterator();
        while (it2.hasNext()) {
            Integer d11 = t.d(uVar, it2.next().h());
            if (d11 == null || d11.intValue() < 0) {
                return null;
            }
        }
        return uVar;
    }

    public static i z(n9.a aVar, n9.a aVar2) {
        boolean z10;
        String str;
        if (aVar == null) {
            a(38);
        }
        if (aVar2 == null) {
            a(39);
        }
        boolean z11 = aVar instanceof x;
        if ((z11 && !(aVar2 instanceof x)) || (((z10 = aVar instanceof p0)) && !(aVar2 instanceof p0))) {
            str = "Member kind mismatch";
        } else {
            if (!z11 && !z10) {
                throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + aVar);
            }
            if (aVar.c().equals(aVar2.c())) {
                i g10 = g(aVar, aVar2);
                if (g10 != null) {
                    return g10;
                }
                return null;
            }
            str = "Name mismatch";
        }
        return i.d(str);
    }

    public i G(n9.a aVar, n9.a aVar2, n9.e eVar) {
        if (aVar == null) {
            a(17);
        }
        if (aVar2 == null) {
            a(18);
        }
        i H = H(aVar, aVar2, eVar, false);
        if (H == null) {
            a(19);
        }
        return H;
    }

    public i H(n9.a aVar, n9.a aVar2, n9.e eVar, boolean z10) {
        if (aVar == null) {
            a(20);
        }
        if (aVar2 == null) {
            a(21);
        }
        i I = I(aVar, aVar2, z10);
        boolean z11 = I.c() == i.a.OVERRIDABLE;
        for (na.e eVar2 : f12340c) {
            if (eVar2.b() != e.a.CONFLICTS_ONLY && (!z11 || eVar2.b() != e.a.SUCCESS_ONLY)) {
                int i10 = h.f12349a[eVar2.a(aVar, aVar2, eVar).ordinal()];
                if (i10 == 1) {
                    z11 = true;
                } else {
                    if (i10 == 2) {
                        i b10 = i.b("External condition failed");
                        if (b10 == null) {
                            a(22);
                        }
                        return b10;
                    }
                    if (i10 == 3) {
                        i d10 = i.d("External condition");
                        if (d10 == null) {
                            a(23);
                        }
                        return d10;
                    }
                }
            }
        }
        if (!z11) {
            return I;
        }
        for (na.e eVar3 : f12340c) {
            if (eVar3.b() == e.a.CONFLICTS_ONLY) {
                int i11 = h.f12349a[eVar3.a(aVar, aVar2, eVar).ordinal()];
                if (i11 == 1) {
                    throw new IllegalStateException("Contract violation in " + eVar3.getClass().getName() + " condition. It's not supposed to end with success");
                }
                if (i11 == 2) {
                    i b11 = i.b("External condition failed");
                    if (b11 == null) {
                        a(25);
                    }
                    return b11;
                }
                if (i11 == 3) {
                    i d11 = i.d("External condition");
                    if (d11 == null) {
                        a(26);
                    }
                    return d11;
                }
            }
        }
        i e10 = i.e();
        if (e10 == null) {
            a(27);
        }
        return e10;
    }

    public i I(n9.a aVar, n9.a aVar2, boolean z10) {
        if (aVar == null) {
            a(28);
        }
        if (aVar2 == null) {
            a(29);
        }
        i z11 = z(aVar, aVar2);
        if (z11 != null) {
            return z11;
        }
        List<b0> i10 = i(aVar);
        List<b0> i11 = i(aVar2);
        List<a1> m10 = aVar.m();
        List<a1> m11 = aVar2.m();
        int i12 = 0;
        if (m10.size() != m11.size()) {
            while (i12 < i10.size()) {
                if (!kotlin.reflect.jvm.internal.impl.types.checker.f.f11565a.c(i10.get(i12), i11.get(i12))) {
                    i d10 = i.d("Type parameter number mismatch");
                    if (d10 == null) {
                        a(31);
                    }
                    return d10;
                }
                i12++;
            }
            i b10 = i.b("Type parameter number mismatch");
            if (b10 == null) {
                a(32);
            }
            return b10;
        }
        l8.n<kotlin.reflect.jvm.internal.impl.types.checker.m, kotlin.reflect.jvm.internal.impl.types.checker.a> n10 = n(m10, m11);
        for (int i13 = 0; i13 < m10.size(); i13++) {
            if (!e(m10.get(i13), m11.get(i13), n10)) {
                i d11 = i.d("Type parameter bounds mismatch");
                if (d11 == null) {
                    a(33);
                }
                return d11;
            }
        }
        for (int i14 = 0; i14 < i10.size(); i14++) {
            if (!f(i10.get(i14), i11.get(i14), n10)) {
                i d12 = i.d("Value parameter type mismatch");
                if (d12 == null) {
                    a(34);
                }
                return d12;
            }
        }
        if ((aVar instanceof x) && (aVar2 instanceof x) && ((x) aVar).q0() != ((x) aVar2).q0()) {
            i b11 = i.b("Incompatible suspendability");
            if (b11 == null) {
                a(35);
            }
            return b11;
        }
        if (z10) {
            b0 i15 = aVar.i();
            b0 i16 = aVar2.i();
            if (i15 != null && i16 != null) {
                if (d0.a(i16) && d0.a(i15)) {
                    i12 = 1;
                }
                if (i12 == 0 && !n10.c().f(n10.d(), i16.Z0(), i15.Z0())) {
                    i b12 = i.b("Return type mismatch");
                    if (b12 == null) {
                        a(36);
                    }
                    return b12;
                }
            }
        }
        i e10 = i.e();
        if (e10 == null) {
            a(37);
        }
        return e10;
    }

    public void y(la.e eVar, Collection<? extends n9.b> collection, Collection<? extends n9.b> collection2, n9.e eVar2, na.i iVar) {
        if (eVar == null) {
            a(50);
        }
        if (collection == null) {
            a(51);
        }
        if (collection2 == null) {
            a(52);
        }
        if (eVar2 == null) {
            a(53);
        }
        if (iVar == null) {
            a(54);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        Iterator<? extends n9.b> it = collection2.iterator();
        while (it.hasNext()) {
            linkedHashSet.removeAll(r(it.next(), collection, eVar2, iVar));
        }
        m(eVar2, linkedHashSet, iVar);
    }
}
