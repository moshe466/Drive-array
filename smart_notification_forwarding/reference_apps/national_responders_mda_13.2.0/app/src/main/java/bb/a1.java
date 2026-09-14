package bb;

import java.util.ArrayList;
import java.util.List;
import k9.k;

/* loaded from: classes.dex */
public class a1 {

    /* renamed from: b, reason: collision with root package name */
    public static final a1 f4159b = g(y0.f4281a);

    /* renamed from: a, reason: collision with root package name */
    private final y0 f4160a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements x8.l<la.b, Boolean> {
        a() {
        }

        private static /* synthetic */ void a(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
        }

        @Override // x8.l
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean h(la.b bVar) {
            if (bVar == null) {
                a(0);
            }
            return Boolean.valueOf(!bVar.equals(k.a.G));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4161a;

        static {
            int[] iArr = new int[d.values().length];
            f4161a = iArr;
            try {
                iArr[d.OUT_IN_IN_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4161a[d.IN_IN_OUT_POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4161a[d.NO_CONFLICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Exception {
        public c(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum d {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    protected a1(y0 y0Var) {
        if (y0Var == null) {
            a(6);
        }
        this.f4160a = y0Var;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:50:0x00f6. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:51:0x00f9. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:52:0x00fc. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0108 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0036 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x001d A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void a(int r13) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bb.a1.a(int):void");
    }

    private static void b(int i10, v0 v0Var, y0 y0Var) {
        if (i10 <= 100) {
            return;
        }
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + o(v0Var) + "; substitution: " + o(y0Var));
    }

    public static h1 c(h1 h1Var, v0 v0Var) {
        if (h1Var == null) {
            a(33);
        }
        if (v0Var == null) {
            a(34);
        }
        if (!v0Var.d()) {
            return d(h1Var, v0Var.c());
        }
        h1 h1Var2 = h1.OUT_VARIANCE;
        if (h1Var2 == null) {
            a(35);
        }
        return h1Var2;
    }

    public static h1 d(h1 h1Var, h1 h1Var2) {
        if (h1Var == null) {
            a(36);
        }
        if (h1Var2 == null) {
            a(37);
        }
        h1 h1Var3 = h1.INVARIANT;
        if (h1Var == h1Var3) {
            if (h1Var2 == null) {
                a(38);
            }
            return h1Var2;
        }
        if (h1Var2 == h1Var3) {
            if (h1Var == null) {
                a(39);
            }
            return h1Var;
        }
        if (h1Var == h1Var2) {
            if (h1Var2 == null) {
                a(40);
            }
            return h1Var2;
        }
        throw new AssertionError("Variance conflict: type parameter variance '" + h1Var + "' and projection kind '" + h1Var2 + "' cannot be combined");
    }

    private static d e(h1 h1Var, h1 h1Var2) {
        h1 h1Var3 = h1.IN_VARIANCE;
        return (h1Var == h1Var3 && h1Var2 == h1.OUT_VARIANCE) ? d.OUT_IN_IN_POSITION : (h1Var == h1.OUT_VARIANCE && h1Var2 == h1Var3) ? d.IN_IN_OUT_POSITION : d.NO_CONFLICT;
    }

    public static a1 f(b0 b0Var) {
        if (b0Var == null) {
            a(5);
        }
        return g(u0.h(b0Var.W0(), b0Var.V0()));
    }

    public static a1 g(y0 y0Var) {
        if (y0Var == null) {
            a(0);
        }
        return new a1(y0Var);
    }

    public static a1 h(y0 y0Var, y0 y0Var2) {
        if (y0Var == null) {
            a(2);
        }
        if (y0Var2 == null) {
            a(3);
        }
        return g(p.h(y0Var, y0Var2));
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.annotations.g i(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (gVar == null) {
            a(31);
        }
        return !gVar.r(k.a.G) ? gVar : new kotlin.reflect.jvm.internal.impl.descriptors.annotations.l(gVar, new a());
    }

    private static v0 l(b0 b0Var, v0 v0Var, n9.a1 a1Var, v0 v0Var2) {
        if (b0Var == null) {
            a(24);
        }
        if (v0Var == null) {
            a(25);
        }
        if (v0Var2 == null) {
            a(26);
        }
        if (!b0Var.u().r(k.a.G)) {
            if (v0Var == null) {
                a(27);
            }
            return v0Var;
        }
        t0 W0 = v0Var.b().W0();
        if (!(W0 instanceof kotlin.reflect.jvm.internal.impl.types.checker.j)) {
            return v0Var;
        }
        v0 a10 = ((kotlin.reflect.jvm.internal.impl.types.checker.j) W0).a();
        h1 c10 = a10.c();
        d e10 = e(v0Var2.c(), c10);
        d dVar = d.OUT_IN_IN_POSITION;
        return e10 == dVar ? new x0(a10.b()) : (a1Var != null && e(a1Var.v(), c10) == dVar) ? new x0(a10.b()) : v0Var;
    }

    private static String o(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (jb.c.a(th)) {
                throw th;
            }
            return "[Exception while computing toString(): " + th + "]";
        }
    }

    private v0 r(v0 v0Var, int i10) {
        b0 b10 = v0Var.b();
        h1 c10 = v0Var.c();
        if (b10.W0().A() instanceof n9.a1) {
            return v0Var;
        }
        i0 b11 = l0.b(b10);
        b0 p10 = b11 != null ? m().p(b11, h1.INVARIANT) : null;
        b0 b12 = z0.b(b10, s(b10.W0().B(), b10.V0(), i10), this.f4160a.d(b10.u()));
        if ((b12 instanceof i0) && (p10 instanceof i0)) {
            b12 = l0.j((i0) b12, (i0) p10);
        }
        return new x0(c10, b12);
    }

    private List<v0> s(List<n9.a1> list, List<v0> list2, int i10) {
        ArrayList arrayList = new ArrayList(list.size());
        boolean z10 = false;
        for (int i11 = 0; i11 < list.size(); i11++) {
            n9.a1 a1Var = list.get(i11);
            v0 v0Var = list2.get(i11);
            v0 u10 = u(v0Var, a1Var, i10 + 1);
            int i12 = b.f4161a[e(a1Var.v(), u10.c()).ordinal()];
            if (i12 == 1 || i12 == 2) {
                u10 = c1.s(a1Var);
            } else if (i12 == 3) {
                h1 v10 = a1Var.v();
                h1 h1Var = h1.INVARIANT;
                if (v10 != h1Var && !u10.d()) {
                    u10 = new x0(h1Var, u10.b());
                }
            }
            if (u10 != v0Var) {
                z10 = true;
            }
            arrayList.add(u10);
        }
        return !z10 ? list2 : arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private v0 u(v0 v0Var, n9.a1 a1Var, int i10) {
        if (v0Var == null) {
            a(17);
        }
        b(i10, v0Var, this.f4160a);
        if (v0Var.d()) {
            return v0Var;
        }
        b0 b10 = v0Var.b();
        if (b10 instanceof d1) {
            d1 d1Var = (d1) b10;
            g1 I0 = d1Var.I0();
            b0 e02 = d1Var.e0();
            v0 u10 = u(new x0(v0Var.c(), I0), a1Var, i10 + 1);
            return new x0(u10.c(), e1.d(u10.b().Z0(), p(e02, v0Var.c())));
        }
        if (!r.a(b10) && !(b10.Z0() instanceof h0)) {
            v0 e10 = this.f4160a.e(b10);
            v0 l10 = e10 != null ? l(b10, e10, a1Var, v0Var) : null;
            h1 c10 = v0Var.c();
            if (l10 == null && y.b(b10) && !s0.b(b10)) {
                v a10 = y.a(b10);
                int i11 = i10 + 1;
                v0 u11 = u(new x0(c10, a10.e1()), a1Var, i11);
                v0 u12 = u(new x0(c10, a10.f1()), a1Var, i11);
                return (u11.b() == a10.e1() && u12.b() == a10.f1()) ? v0Var : new x0(u11.c(), c0.d(z0.a(u11.b()), z0.a(u12.b())));
            }
            if (!k9.h.t0(b10) && !d0.a(b10)) {
                if (l10 != null) {
                    d e11 = e(c10, l10.c());
                    if (!oa.d.d(b10)) {
                        int i12 = b.f4161a[e11.ordinal()];
                        if (i12 == 1) {
                            throw new c("Out-projection in in-position");
                        }
                        if (i12 == 2) {
                            return new x0(h1.OUT_VARIANCE, b10.W0().w().I());
                        }
                    }
                    j a11 = s0.a(b10);
                    if (l10.d()) {
                        return l10;
                    }
                    b0 v02 = a11 != null ? a11.v0(l10.b()) : c1.q(l10.b(), b10.X0());
                    if (!b10.u().isEmpty()) {
                        v02 = eb.a.l(v02, new kotlin.reflect.jvm.internal.impl.descriptors.annotations.k(v02.u(), i(this.f4160a.d(b10.u()))));
                    }
                    if (e11 == d.NO_CONFLICT) {
                        c10 = d(c10, l10.c());
                    }
                    return new x0(c10, v02);
                }
                v0Var = r(v0Var, i10);
                if (v0Var == null) {
                    a(23);
                }
            }
        }
        return v0Var;
    }

    public y0 j() {
        y0 y0Var = this.f4160a;
        if (y0Var == null) {
            a(7);
        }
        return y0Var;
    }

    public boolean k() {
        return this.f4160a.f();
    }

    public a1 m() {
        y0 y0Var = this.f4160a;
        return ((y0Var instanceof z) && y0Var.b()) ? new a1(new z(((z) this.f4160a).i(), ((z) this.f4160a).h(), false)) : this;
    }

    public b0 n(b0 b0Var, h1 h1Var) {
        if (b0Var == null) {
            a(8);
        }
        if (h1Var == null) {
            a(9);
        }
        if (k()) {
            if (b0Var == null) {
                a(10);
            }
            return b0Var;
        }
        try {
            b0 b10 = u(new x0(h1Var, b0Var), null, 0).b();
            if (b10 == null) {
                a(11);
            }
            return b10;
        } catch (c e10) {
            i0 j10 = t.j(e10.getMessage());
            if (j10 == null) {
                a(12);
            }
            return j10;
        }
    }

    public b0 p(b0 b0Var, h1 h1Var) {
        if (b0Var == null) {
            a(13);
        }
        if (h1Var == null) {
            a(14);
        }
        v0 q10 = q(new x0(h1Var, j().g(b0Var, h1Var)));
        if (q10 == null) {
            return null;
        }
        return q10.b();
    }

    public v0 q(v0 v0Var) {
        if (v0Var == null) {
            a(15);
        }
        v0 t10 = t(v0Var);
        return (this.f4160a.a() || this.f4160a.b()) ? fb.b.c(t10, this.f4160a.b()) : t10;
    }

    public v0 t(v0 v0Var) {
        if (v0Var == null) {
            a(16);
        }
        if (k()) {
            return v0Var;
        }
        try {
            return u(v0Var, null, 0);
        } catch (c unused) {
            return null;
        }
    }
}
