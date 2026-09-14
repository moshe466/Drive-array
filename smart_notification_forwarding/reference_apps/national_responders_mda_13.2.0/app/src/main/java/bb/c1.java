package bb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class c1 {

    /* renamed from: a, reason: collision with root package name */
    public static final i0 f4180a = t.p("DONT_CARE");

    /* renamed from: b, reason: collision with root package name */
    public static final i0 f4181b = t.j("Cannot be inferred");

    /* renamed from: c, reason: collision with root package name */
    public static final i0 f4182c = new a("NO_EXPECTED_TYPE");

    /* renamed from: d, reason: collision with root package name */
    public static final i0 f4183d = new a("UNIT_EXPECTED_TYPE");

    /* loaded from: classes.dex */
    public static class a extends m {

        /* renamed from: g, reason: collision with root package name */
        private final String f4184g;

        public a(String str) {
            this.f4184g = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x003e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static /* synthetic */ void i1(int r9) {
            /*
                r0 = 4
                r1 = 1
                if (r9 == r1) goto L9
                if (r9 == r0) goto L9
                java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
                goto Lb
            L9:
                java.lang.String r2 = "@NotNull method %s.%s must not return null"
            Lb:
                r3 = 3
                r4 = 2
                if (r9 == r1) goto L13
                if (r9 == r0) goto L13
                r5 = 3
                goto L14
            L13:
                r5 = 2
            L14:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType"
                r7 = 0
                if (r9 == r1) goto L30
                if (r9 == r4) goto L2b
                if (r9 == r3) goto L26
                if (r9 == r0) goto L30
                java.lang.String r8 = "newAnnotations"
                r5[r7] = r8
                goto L32
            L26:
                java.lang.String r8 = "kotlinTypeRefiner"
                r5[r7] = r8
                goto L32
            L2b:
                java.lang.String r8 = "delegate"
                r5[r7] = r8
                goto L32
            L30:
                r5[r7] = r6
            L32:
                java.lang.String r7 = "refine"
                if (r9 == r1) goto L3e
                if (r9 == r0) goto L3b
                r5[r1] = r6
                goto L42
            L3b:
                r5[r1] = r7
                goto L42
            L3e:
                java.lang.String r6 = "toString"
                r5[r1] = r6
            L42:
                if (r9 == r1) goto L56
                if (r9 == r4) goto L52
                if (r9 == r3) goto L4f
                if (r9 == r0) goto L56
                java.lang.String r3 = "replaceAnnotations"
                r5[r4] = r3
                goto L56
            L4f:
                r5[r4] = r7
                goto L56
            L52:
                java.lang.String r3 = "replaceDelegate"
                r5[r4] = r3
            L56:
                java.lang.String r2 = java.lang.String.format(r2, r5)
                if (r9 == r1) goto L64
                if (r9 == r0) goto L64
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                r9.<init>(r2)
                goto L69
            L64:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                r9.<init>(r2)
            L69:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: bb.c1.a.i1(int):void");
        }

        @Override // bb.g1
        /* renamed from: d1, reason: merged with bridge method [inline-methods] */
        public i0 a1(boolean z10) {
            throw new IllegalStateException(this.f4184g);
        }

        @Override // bb.g1
        /* renamed from: e1, reason: merged with bridge method [inline-methods] */
        public i0 c1(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
            if (gVar == null) {
                i1(0);
            }
            throw new IllegalStateException(this.f4184g);
        }

        @Override // bb.m
        protected i0 f1() {
            throw new IllegalStateException(this.f4184g);
        }

        @Override // bb.m
        public m h1(i0 i0Var) {
            if (i0Var == null) {
                i1(2);
            }
            throw new IllegalStateException(this.f4184g);
        }

        @Override // bb.m
        /* renamed from: j1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a g1(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            if (gVar == null) {
                i1(3);
            }
            return this;
        }

        @Override // bb.i0
        public String toString() {
            String str = this.f4184g;
            if (str == null) {
                i1(1);
            }
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void a(int r24) {
        /*
            Method dump skipped, instructions count: 776
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bb.c1.a(int):void");
    }

    public static boolean b(b0 b0Var) {
        if (b0Var == null) {
            a(28);
        }
        if (b0Var.X0()) {
            return true;
        }
        return y.b(b0Var) && b(y.a(b0Var).f1());
    }

    public static boolean c(b0 b0Var, x8.l<g1, Boolean> lVar) {
        if (lVar == null) {
            a(43);
        }
        return d(b0Var, lVar, null);
    }

    private static boolean d(b0 b0Var, x8.l<g1, Boolean> lVar, jb.j<b0> jVar) {
        if (lVar == null) {
            a(44);
        }
        if (b0Var == null) {
            return false;
        }
        g1 Z0 = b0Var.Z0();
        if (v(b0Var)) {
            return lVar.h(Z0).booleanValue();
        }
        if (jVar != null && jVar.contains(b0Var)) {
            return false;
        }
        if (lVar.h(Z0).booleanValue()) {
            return true;
        }
        if (jVar == null) {
            jVar = jb.j.c();
        }
        jVar.add(b0Var);
        v vVar = Z0 instanceof v ? (v) Z0 : null;
        if (vVar != null && (d(vVar.e1(), lVar, jVar) || d(vVar.f1(), lVar, jVar))) {
            return true;
        }
        if ((Z0 instanceof k) && d(((k) Z0).i1(), lVar, jVar)) {
            return true;
        }
        t0 W0 = b0Var.W0();
        if (W0 instanceof a0) {
            Iterator<b0> it = ((a0) W0).x().iterator();
            while (it.hasNext()) {
                if (d(it.next(), lVar, jVar)) {
                    return true;
                }
            }
            return false;
        }
        for (v0 v0Var : b0Var.V0()) {
            if (!v0Var.d()) {
                if (d(v0Var.b(), lVar, jVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static b0 e(b0 b0Var, b0 b0Var2, a1 a1Var) {
        if (b0Var == null) {
            a(20);
        }
        if (b0Var2 == null) {
            a(21);
        }
        if (a1Var == null) {
            a(22);
        }
        b0 p10 = a1Var.p(b0Var2, h1.INVARIANT);
        if (p10 != null) {
            return q(p10, b0Var.X0());
        }
        return null;
    }

    public static n9.e f(b0 b0Var) {
        if (b0Var == null) {
            a(30);
        }
        n9.h A = b0Var.W0().A();
        if (A instanceof n9.e) {
            return (n9.e) A;
        }
        return null;
    }

    public static List<v0> g(List<n9.a1> list) {
        List<v0> n02;
        if (list == null) {
            a(16);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<n9.a1> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new x0(it.next().s()));
        }
        n02 = m8.y.n0(arrayList);
        if (n02 == null) {
            a(17);
        }
        return n02;
    }

    public static List<b0> h(b0 b0Var) {
        if (b0Var == null) {
            a(18);
        }
        a1 f10 = a1.f(b0Var);
        Collection<b0> x10 = b0Var.W0().x();
        ArrayList arrayList = new ArrayList(x10.size());
        Iterator<b0> it = x10.iterator();
        while (it.hasNext()) {
            b0 e10 = e(b0Var, it.next(), f10);
            if (e10 != null) {
                arrayList.add(e10);
            }
        }
        return arrayList;
    }

    public static n9.a1 i(b0 b0Var) {
        if (b0Var == null) {
            a(62);
        }
        if (b0Var.W0().A() instanceof n9.a1) {
            return (n9.a1) b0Var.W0().A();
        }
        return null;
    }

    public static boolean j(b0 b0Var) {
        if (b0Var == null) {
            a(29);
        }
        if (b0Var.W0().A() instanceof n9.e) {
            return false;
        }
        Iterator<b0> it = h(b0Var).iterator();
        while (it.hasNext()) {
            if (l(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(b0 b0Var) {
        return b0Var != null && b0Var.W0() == f4180a.W0();
    }

    public static boolean l(b0 b0Var) {
        if (b0Var == null) {
            a(27);
        }
        if (b0Var.X0()) {
            return true;
        }
        if (y.b(b0Var) && l(y.a(b0Var).f1())) {
            return true;
        }
        if (l0.c(b0Var)) {
            return false;
        }
        if (m(b0Var)) {
            return j(b0Var);
        }
        t0 W0 = b0Var.W0();
        if (W0 instanceof a0) {
            Iterator<b0> it = W0.x().iterator();
            while (it.hasNext()) {
                if (l(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m(b0 b0Var) {
        if (b0Var == null) {
            a(59);
        }
        if (i(b0Var) != null) {
            return true;
        }
        b0Var.W0();
        return false;
    }

    public static b0 n(b0 b0Var) {
        if (b0Var == null) {
            a(2);
        }
        return p(b0Var, false);
    }

    public static b0 o(b0 b0Var) {
        if (b0Var == null) {
            a(1);
        }
        return p(b0Var, true);
    }

    public static b0 p(b0 b0Var, boolean z10) {
        if (b0Var == null) {
            a(3);
        }
        g1 a12 = b0Var.Z0().a1(z10);
        if (a12 == null) {
            a(4);
        }
        return a12;
    }

    public static b0 q(b0 b0Var, boolean z10) {
        if (b0Var == null) {
            a(8);
        }
        if (z10) {
            return o(b0Var);
        }
        if (b0Var == null) {
            a(9);
        }
        return b0Var;
    }

    public static i0 r(i0 i0Var, boolean z10) {
        if (i0Var == null) {
            a(5);
        }
        if (!z10) {
            if (i0Var == null) {
                a(7);
            }
            return i0Var;
        }
        i0 a12 = i0Var.a1(true);
        if (a12 == null) {
            a(6);
        }
        return a12;
    }

    public static v0 s(n9.a1 a1Var) {
        if (a1Var == null) {
            a(45);
        }
        return new n0(a1Var);
    }

    public static i0 t(t0 t0Var, ua.h hVar, x8.l<kotlin.reflect.jvm.internal.impl.types.checker.g, i0> lVar) {
        if (t0Var == null) {
            a(12);
        }
        if (hVar == null) {
            a(13);
        }
        if (lVar == null) {
            a(14);
        }
        i0 k10 = c0.k(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), t0Var, g(t0Var.B()), false, hVar, lVar);
        if (k10 == null) {
            a(15);
        }
        return k10;
    }

    public static i0 u(n9.h hVar, ua.h hVar2, x8.l<kotlin.reflect.jvm.internal.impl.types.checker.g, i0> lVar) {
        if (!t.r(hVar)) {
            return t(hVar.o(), hVar2, lVar);
        }
        i0 j10 = t.j("Unsubstituted type for " + hVar);
        if (j10 == null) {
            a(11);
        }
        return j10;
    }

    public static boolean v(b0 b0Var) {
        if (b0Var == null) {
            a(0);
        }
        return b0Var == f4182c || b0Var == f4183d;
    }
}
