package kotlin.reflect.jvm.internal.impl.renderer;

import bb.b0;
import bb.c1;
import bb.f1;
import bb.g1;
import bb.h1;
import bb.i0;
import bb.i1;
import bb.t;
import bb.t0;
import bb.v0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import k9.k;
import kotlin.reflect.jvm.internal.impl.renderer.c;
import l8.w;
import m8.p;
import m8.q;
import m8.y;
import mb.r;
import mb.s;
import n9.a0;
import n9.a1;
import n9.b;
import n9.b1;
import n9.d0;
import n9.d1;
import n9.e1;
import n9.f0;
import n9.g0;
import n9.l0;
import n9.n0;
import n9.o;
import n9.o0;
import n9.p0;
import n9.q0;
import n9.r0;
import n9.s0;
import n9.u;
import n9.v;
import n9.x;
import n9.z;
import n9.z0;
import pa.q;

/* loaded from: classes.dex */
public final class d extends kotlin.reflect.jvm.internal.impl.renderer.c implements kotlin.reflect.jvm.internal.impl.renderer.f {

    /* renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.renderer.g f11513d;

    /* renamed from: e, reason: collision with root package name */
    private final l8.h f11514e;

    /* loaded from: classes.dex */
    private final class a implements o<w, StringBuilder> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f11515a;

        /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public /* synthetic */ class C0238a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f11516a;

            static {
                int[] iArr = new int[l.valuesCustom().length];
                iArr[l.PRETTY.ordinal()] = 1;
                iArr[l.DEBUG.ordinal()] = 2;
                iArr[l.NONE.ordinal()] = 3;
                f11516a = iArr;
            }
        }

        public a(d dVar) {
            y8.k.e(dVar, "this$0");
            this.f11515a = dVar;
        }

        private final void t(o0 o0Var, StringBuilder sb2, String str) {
            int i10 = C0238a.f11516a[this.f11515a.n0().ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    return;
                }
                p(o0Var, sb2);
            } else {
                this.f11515a.T0(o0Var, sb2);
                sb2.append(y8.k.j(str, " for "));
                d dVar = this.f11515a;
                p0 y02 = o0Var.y0();
                y8.k.d(y02, "descriptor.correspondingProperty");
                dVar.A1(y02, sb2);
            }
        }

        public void A(d1 d1Var, StringBuilder sb2) {
            y8.k.e(d1Var, "descriptor");
            y8.k.e(sb2, "builder");
            this.f11515a.S1(d1Var, true, sb2, true);
        }

        @Override // n9.o
        public /* bridge */ /* synthetic */ w a(s0 s0Var, StringBuilder sb2) {
            x(s0Var, sb2);
            return w.f11824a;
        }

        @Override // n9.o
        public /* bridge */ /* synthetic */ w b(r0 r0Var, StringBuilder sb2) {
            w(r0Var, sb2);
            return w.f11824a;
        }

        @Override // n9.o
        public /* bridge */ /* synthetic */ w c(a1 a1Var, StringBuilder sb2) {
            z(a1Var, sb2);
            return w.f11824a;
        }

        @Override // n9.o
        public /* bridge */ /* synthetic */ w d(l0 l0Var, StringBuilder sb2) {
            s(l0Var, sb2);
            return w.f11824a;
        }

        @Override // n9.o
        public /* bridge */ /* synthetic */ w e(n9.e eVar, StringBuilder sb2) {
            n(eVar, sb2);
            return w.f11824a;
        }

        @Override // n9.o
        public /* bridge */ /* synthetic */ w f(x xVar, StringBuilder sb2) {
            p(xVar, sb2);
            return w.f11824a;
        }

        @Override // n9.o
        public /* bridge */ /* synthetic */ w g(d0 d0Var, StringBuilder sb2) {
            q(d0Var, sb2);
            return w.f11824a;
        }

        @Override // n9.o
        public /* bridge */ /* synthetic */ w h(g0 g0Var, StringBuilder sb2) {
            r(g0Var, sb2);
            return w.f11824a;
        }

        @Override // n9.o
        public /* bridge */ /* synthetic */ w i(z0 z0Var, StringBuilder sb2) {
            y(z0Var, sb2);
            return w.f11824a;
        }

        @Override // n9.o
        public /* bridge */ /* synthetic */ w j(p0 p0Var, StringBuilder sb2) {
            u(p0Var, sb2);
            return w.f11824a;
        }

        @Override // n9.o
        public /* bridge */ /* synthetic */ w k(q0 q0Var, StringBuilder sb2) {
            v(q0Var, sb2);
            return w.f11824a;
        }

        @Override // n9.o
        public /* bridge */ /* synthetic */ w l(d1 d1Var, StringBuilder sb2) {
            A(d1Var, sb2);
            return w.f11824a;
        }

        @Override // n9.o
        public /* bridge */ /* synthetic */ w m(n9.l lVar, StringBuilder sb2) {
            o(lVar, sb2);
            return w.f11824a;
        }

        public void n(n9.e eVar, StringBuilder sb2) {
            y8.k.e(eVar, "descriptor");
            y8.k.e(sb2, "builder");
            this.f11515a.Z0(eVar, sb2);
        }

        public void o(n9.l lVar, StringBuilder sb2) {
            y8.k.e(lVar, "constructorDescriptor");
            y8.k.e(sb2, "builder");
            this.f11515a.e1(lVar, sb2);
        }

        public void p(x xVar, StringBuilder sb2) {
            y8.k.e(xVar, "descriptor");
            y8.k.e(sb2, "builder");
            this.f11515a.i1(xVar, sb2);
        }

        public void q(d0 d0Var, StringBuilder sb2) {
            y8.k.e(d0Var, "descriptor");
            y8.k.e(sb2, "builder");
            this.f11515a.s1(d0Var, sb2, true);
        }

        public void r(g0 g0Var, StringBuilder sb2) {
            y8.k.e(g0Var, "descriptor");
            y8.k.e(sb2, "builder");
            this.f11515a.w1(g0Var, sb2);
        }

        public void s(l0 l0Var, StringBuilder sb2) {
            y8.k.e(l0Var, "descriptor");
            y8.k.e(sb2, "builder");
            this.f11515a.y1(l0Var, sb2);
        }

        public void u(p0 p0Var, StringBuilder sb2) {
            y8.k.e(p0Var, "descriptor");
            y8.k.e(sb2, "builder");
            this.f11515a.A1(p0Var, sb2);
        }

        public void v(q0 q0Var, StringBuilder sb2) {
            y8.k.e(q0Var, "descriptor");
            y8.k.e(sb2, "builder");
            t(q0Var, sb2, "getter");
        }

        public void w(r0 r0Var, StringBuilder sb2) {
            y8.k.e(r0Var, "descriptor");
            y8.k.e(sb2, "builder");
            t(r0Var, sb2, "setter");
        }

        public void x(s0 s0Var, StringBuilder sb2) {
            y8.k.e(s0Var, "descriptor");
            y8.k.e(sb2, "builder");
            sb2.append(s0Var.c());
        }

        public void y(z0 z0Var, StringBuilder sb2) {
            y8.k.e(z0Var, "descriptor");
            y8.k.e(sb2, "builder");
            this.f11515a.I1(z0Var, sb2);
        }

        public void z(a1 a1Var, StringBuilder sb2) {
            y8.k.e(a1Var, "descriptor");
            y8.k.e(sb2, "builder");
            this.f11515a.N1(a1Var, sb2, true);
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11517a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f11518b;

        static {
            int[] iArr = new int[m.valuesCustom().length];
            iArr[m.PLAIN.ordinal()] = 1;
            iArr[m.HTML.ordinal()] = 2;
            f11517a = iArr;
            int[] iArr2 = new int[k.valuesCustom().length];
            iArr2[k.ALL.ordinal()] = 1;
            iArr2[k.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            iArr2[k.NONE.ordinal()] = 3;
            f11518b = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends y8.l implements x8.l<v0, CharSequence> {
        c() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence h(v0 v0Var) {
            y8.k.e(v0Var, "it");
            if (v0Var.d()) {
                return "*";
            }
            d dVar = d.this;
            b0 b10 = v0Var.b();
            y8.k.d(b10, "it.type");
            String x10 = dVar.x(b10);
            if (v0Var.c() == h1.INVARIANT) {
                return x10;
            }
            return v0Var.c() + ' ' + x10;
        }
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0239d extends y8.l implements x8.a<d> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.d$d$a */
        /* loaded from: classes.dex */
        public static final class a extends y8.l implements x8.l<kotlin.reflect.jvm.internal.impl.renderer.f, w> {

            /* renamed from: f, reason: collision with root package name */
            public static final a f11521f = new a();

            a() {
                super(1);
            }

            public final void a(kotlin.reflect.jvm.internal.impl.renderer.f fVar) {
                List b10;
                Set<la.b> g10;
                y8.k.e(fVar, "<this>");
                Set<la.b> l10 = fVar.l();
                b10 = p.b(k.a.f11290x);
                g10 = m8.s0.g(l10, b10);
                fVar.e(g10);
                fVar.i(kotlin.reflect.jvm.internal.impl.renderer.a.ALWAYS_PARENTHESIZED);
            }

            @Override // x8.l
            public /* bridge */ /* synthetic */ w h(kotlin.reflect.jvm.internal.impl.renderer.f fVar) {
                a(fVar);
                return w.f11824a;
            }
        }

        C0239d() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d b() {
            return (d) d.this.z(a.f11521f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e extends y8.l implements x8.l<pa.g<?>, CharSequence> {
        e() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence h(pa.g<?> gVar) {
            y8.k.e(gVar, "it");
            return d.this.d1(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class f extends y8.l implements x8.l<d1, CharSequence> {

        /* renamed from: f, reason: collision with root package name */
        public static final f f11523f = new f();

        f() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence h(d1 d1Var) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class g extends y8.l implements x8.l<b0, CharSequence> {
        g() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence h(b0 b0Var) {
            d dVar = d.this;
            y8.k.d(b0Var, "it");
            return dVar.x(b0Var);
        }
    }

    public d(kotlin.reflect.jvm.internal.impl.renderer.g gVar) {
        l8.h b10;
        y8.k.e(gVar, "options");
        this.f11513d = gVar;
        gVar.l0();
        b10 = l8.j.b(new C0239d());
        this.f11514e = b10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1(p0 p0Var, StringBuilder sb2) {
        if (!A0()) {
            if (!z0()) {
                B1(p0Var, sb2);
                u h10 = p0Var.h();
                y8.k.d(h10, "property.visibility");
                V1(h10, sb2);
                boolean z10 = false;
                r1(sb2, g0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.CONST) && p0Var.O(), "const");
                n1(p0Var, sb2);
                q1(p0Var, sb2);
                v1(p0Var, sb2);
                if (g0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.LATEINIT) && p0Var.h0()) {
                    z10 = true;
                }
                r1(sb2, z10, "lateinit");
                m1(p0Var, sb2);
            }
            R1(this, p0Var, sb2, false, 4, null);
            List<a1> m10 = p0Var.m();
            y8.k.d(m10, "property.typeParameters");
            P1(m10, sb2, true);
            C1(p0Var, sb2);
        }
        s1(p0Var, sb2, true);
        sb2.append(": ");
        b0 b10 = p0Var.b();
        y8.k.d(b10, "property.type");
        sb2.append(x(b10));
        D1(p0Var, sb2);
        k1(p0Var, sb2);
        List<a1> m11 = p0Var.m();
        y8.k.d(m11, "property.typeParameters");
        W1(m11, sb2);
    }

    private final void B1(p0 p0Var, StringBuilder sb2) {
        if (g0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.ANNOTATIONS)) {
            X0(this, sb2, p0Var, null, 2, null);
            v d02 = p0Var.d0();
            if (d02 != null) {
                W0(sb2, d02, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e.FIELD);
            }
            v X = p0Var.X();
            if (X != null) {
                W0(sb2, X, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e.PROPERTY_DELEGATE_FIELD);
            }
            if (n0() == l.NONE) {
                q0 t10 = p0Var.t();
                if (t10 != null) {
                    W0(sb2, t10, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e.PROPERTY_GETTER);
                }
                r0 M0 = p0Var.M0();
                if (M0 == null) {
                    return;
                }
                W0(sb2, M0, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e.PROPERTY_SETTER);
                List<d1> l10 = M0.l();
                y8.k.d(l10, "setter.valueParameters");
                d1 d1Var = (d1) m8.o.d0(l10);
                y8.k.d(d1Var, "it");
                W0(sb2, d1Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e.SETTER_PARAMETER);
            }
        }
    }

    private final void C1(n9.a aVar, StringBuilder sb2) {
        s0 U = aVar.U();
        if (U != null) {
            W0(sb2, U, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e.RECEIVER);
            b0 b10 = U.b();
            y8.k.d(b10, "receiver.type");
            String x10 = x(b10);
            if (Y1(b10) && !c1.l(b10)) {
                x10 = '(' + x10 + ')';
            }
            sb2.append(x10);
            sb2.append(".");
        }
    }

    private final void D1(n9.a aVar, StringBuilder sb2) {
        s0 U;
        if (o0() && (U = aVar.U()) != null) {
            sb2.append(" on ");
            b0 b10 = U.b();
            y8.k.d(b10, "receiver.type");
            sb2.append(x(b10));
        }
    }

    private final void E1(StringBuilder sb2, i0 i0Var) {
        if (y8.k.a(i0Var, c1.f4181b) || c1.k(i0Var)) {
            sb2.append("???");
            return;
        }
        if (t.t(i0Var)) {
            if (!D0()) {
                sb2.append("???");
                return;
            }
            String eVar = ((t.f) i0Var.W0()).c().c().toString();
            y8.k.d(eVar, "type.constructor as UninferredParameterTypeConstructor).typeParameterDescriptor.name.toString()");
            sb2.append(g1(eVar));
            return;
        }
        if (bb.d0.a(i0Var)) {
            f1(sb2, i0Var);
        } else if (Y1(i0Var)) {
            j1(sb2, i0Var);
        } else {
            f1(sb2, i0Var);
        }
    }

    private final void F1(StringBuilder sb2) {
        int length = sb2.length();
        if (length == 0 || sb2.charAt(length - 1) != ' ') {
            sb2.append(' ');
        }
    }

    private final void G1(n9.e eVar, StringBuilder sb2) {
        if (K0() || k9.h.t0(eVar.s())) {
            return;
        }
        Collection<b0> x10 = eVar.o().x();
        y8.k.d(x10, "klass.typeConstructor.supertypes");
        if (x10.isEmpty()) {
            return;
        }
        if (x10.size() == 1 && k9.h.a0(x10.iterator().next())) {
            return;
        }
        F1(sb2);
        sb2.append(": ");
        y.O(x10, sb2, ", ", null, null, 0, null, new g(), 60, null);
    }

    private final void H1(x xVar, StringBuilder sb2) {
        r1(sb2, xVar.q0(), "suspend");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I1(z0 z0Var, StringBuilder sb2) {
        X0(this, sb2, z0Var, null, 2, null);
        u h10 = z0Var.h();
        y8.k.d(h10, "typeAlias.visibility");
        V1(h10, sb2);
        n1(z0Var, sb2);
        sb2.append(l1("typealias"));
        sb2.append(" ");
        s1(z0Var, sb2, true);
        List<a1> B = z0Var.B();
        y8.k.d(B, "typeAlias.declaredTypeParameters");
        P1(B, sb2, false);
        Y0(z0Var, sb2);
        sb2.append(" = ");
        sb2.append(x(z0Var.L()));
    }

    private final void L1(StringBuilder sb2, b0 b0Var, t0 t0Var) {
        n0 a10 = b1.a(b0Var);
        if (a10 != null) {
            z1(sb2, a10);
        } else {
            sb2.append(K1(t0Var));
            sb2.append(J1(b0Var.V0()));
        }
    }

    private final void M(StringBuilder sb2, n9.m mVar) {
        String c10;
        if ((mVar instanceof g0) || (mVar instanceof l0)) {
            return;
        }
        if (mVar instanceof d0) {
            sb2.append(" is a module");
            return;
        }
        n9.m d10 = mVar.d();
        if (d10 == null || (d10 instanceof d0)) {
            return;
        }
        sb2.append(" ");
        sb2.append(o1("defined in"));
        sb2.append(" ");
        la.c m10 = na.d.m(d10);
        y8.k.d(m10, "getFqName(containingDeclaration)");
        sb2.append(m10.e() ? "root package" : v(m10));
        if (I0() && (d10 instanceof g0) && (mVar instanceof n9.p) && (c10 = ((n9.p) mVar).k().a().c()) != null) {
            sb2.append(" ");
            sb2.append(o1("in file"));
            sb2.append(" ");
            sb2.append(c10);
        }
    }

    private final String M0() {
        return Q(">");
    }

    static /* synthetic */ void M1(d dVar, StringBuilder sb2, b0 b0Var, t0 t0Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            t0Var = b0Var.W0();
        }
        dVar.L1(sb2, b0Var, t0Var);
    }

    private final void N(StringBuilder sb2, List<? extends v0> list) {
        y.O(list, sb2, ", ", null, null, 0, null, new c(), 60, null);
    }

    private final boolean N0(b0 b0Var) {
        return k9.g.o(b0Var) || !b0Var.u().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N1(a1 a1Var, StringBuilder sb2, boolean z10) {
        if (z10) {
            sb2.append(Q0());
        }
        if (G0()) {
            sb2.append("/*");
            sb2.append(a1Var.j());
            sb2.append("*/ ");
        }
        r1(sb2, a1Var.a0(), "reified");
        String label = a1Var.v().getLabel();
        boolean z11 = true;
        r1(sb2, label.length() > 0, label);
        X0(this, sb2, a1Var, null, 2, null);
        s1(a1Var, sb2, z10);
        int size = a1Var.getUpperBounds().size();
        if ((size > 1 && !z10) || size == 1) {
            b0 next = a1Var.getUpperBounds().iterator().next();
            if (!k9.h.j0(next)) {
                sb2.append(" : ");
                y8.k.d(next, "upperBound");
                sb2.append(x(next));
            }
        } else if (z10) {
            for (b0 b0Var : a1Var.getUpperBounds()) {
                if (!k9.h.j0(b0Var)) {
                    if (z11) {
                        sb2.append(" : ");
                    } else {
                        sb2.append(" & ");
                    }
                    y8.k.d(b0Var, "upperBound");
                    sb2.append(x(b0Var));
                    z11 = false;
                }
            }
        }
        if (z10) {
            sb2.append(M0());
        }
    }

    private final String O() {
        int i10 = b.f11517a[B0().ordinal()];
        if (i10 == 1) {
            return Q("->");
        }
        if (i10 == 2) {
            return "&rarr;";
        }
        throw new l8.l();
    }

    private final a0 O0(z zVar) {
        if (zVar instanceof n9.e) {
            return ((n9.e) zVar).r() == n9.f.INTERFACE ? a0.ABSTRACT : a0.FINAL;
        }
        n9.m d10 = zVar.d();
        n9.e eVar = d10 instanceof n9.e ? (n9.e) d10 : null;
        if (eVar != null && (zVar instanceof n9.b)) {
            n9.b bVar = (n9.b) zVar;
            y8.k.d(bVar.g(), "this.overriddenDescriptors");
            if ((!r1.isEmpty()) && eVar.p() != a0.FINAL) {
                return a0.OPEN;
            }
            if (eVar.r() != n9.f.INTERFACE || y8.k.a(bVar.h(), n9.t.f12299a)) {
                return a0.FINAL;
            }
            a0 p10 = bVar.p();
            a0 a0Var = a0.ABSTRACT;
            return p10 == a0Var ? a0Var : a0.OPEN;
        }
        return a0.FINAL;
    }

    private final void O1(StringBuilder sb2, List<? extends a1> list) {
        Iterator<? extends a1> it = list.iterator();
        while (it.hasNext()) {
            N1(it.next(), sb2, false);
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
    }

    private final boolean P(String str, String str2) {
        String u10;
        boolean o10;
        u10 = r.u(str2, "?", "", false, 4, null);
        if (!y8.k.a(str, u10)) {
            o10 = r.o(str2, "?", false, 2, null);
            if (!o10 || !y8.k.a(y8.k.j(str, "?"), str2)) {
                if (!y8.k.a('(' + str + ")?", str2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean P0(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        return y8.k.a(cVar.f(), k.a.f11291y);
    }

    private final void P1(List<? extends a1> list, StringBuilder sb2, boolean z10) {
        if (!L0() && (!list.isEmpty())) {
            sb2.append(Q0());
            O1(sb2, list);
            sb2.append(M0());
            if (z10) {
                sb2.append(" ");
            }
        }
    }

    private final String Q(String str) {
        return B0().escape(str);
    }

    private final String Q0() {
        return Q("<");
    }

    private final void Q1(e1 e1Var, StringBuilder sb2, boolean z10) {
        if (z10 || !(e1Var instanceof d1)) {
            sb2.append(l1(e1Var.P() ? "var" : "val"));
            sb2.append(" ");
        }
    }

    private final boolean R0(n9.b bVar) {
        return !bVar.g().isEmpty();
    }

    static /* synthetic */ void R1(d dVar, e1 e1Var, StringBuilder sb2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        dVar.Q1(e1Var, sb2, z10);
    }

    private final void S0(StringBuilder sb2, bb.a aVar) {
        m B0 = B0();
        m mVar = m.HTML;
        if (B0 == mVar) {
            sb2.append("<font color=\"808080\"><i>");
        }
        sb2.append(" /* = ");
        u1(sb2, aVar.D0());
        sb2.append(" */");
        if (B0() == mVar) {
            sb2.append("</i></font>");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0095, code lost:
    
        if ((m() ? r10.k0() : ra.a.a(r10)) != false) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void S1(n9.d1 r10, boolean r11, java.lang.StringBuilder r12, boolean r13) {
        /*
            r9 = this;
            if (r13 == 0) goto L10
            java.lang.String r0 = "value-parameter"
            java.lang.String r0 = r9.l1(r0)
            r12.append(r0)
            java.lang.String r0 = " "
            r12.append(r0)
        L10:
            boolean r0 = r9.G0()
            if (r0 == 0) goto L27
            java.lang.String r0 = "/*"
            r12.append(r0)
            int r0 = r10.j()
            r12.append(r0)
        */
        //  java.lang.String r0 = "*/ "
        /*
            r12.append(r0)
        L27:
            r4 = 0
            r5 = 2
            r6 = 0
            r1 = r9
            r2 = r12
            r3 = r10
            X0(r1, r2, r3, r4, r5, r6)
            boolean r0 = r10.E()
            java.lang.String r1 = "crossinline"
            r9.r1(r12, r0, r1)
            boolean r0 = r10.G0()
            java.lang.String r1 = "noinline"
            r9.r1(r12, r0, r1)
            boolean r0 = r9.v0()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L6c
            n9.a r0 = r10.d()
            boolean r3 = r0 instanceof n9.d
            r4 = 0
            if (r3 == 0) goto L56
            n9.d r0 = (n9.d) r0
            goto L57
        L56:
            r0 = r4
        L57:
            if (r0 != 0) goto L5a
            goto L62
        L5a:
            boolean r0 = r0.S()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
        L62:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r0 = y8.k.a(r4, r0)
            if (r0 == 0) goto L6c
            r8 = 1
            goto L6d
        L6c:
            r8 = 0
        L6d:
            if (r8 == 0) goto L78
            boolean r0 = r9.R()
            java.lang.String r3 = "actual"
            r9.r1(r12, r0, r3)
        L78:
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r3.U1(r4, r5, r6, r7, r8)
            x8.l r11 = r9.X()
            if (r11 == 0) goto L98
            boolean r11 = r9.m()
            if (r11 == 0) goto L91
            boolean r11 = r10.k0()
            goto L95
        L91:
            boolean r11 = ra.a.a(r10)
        L95:
            if (r11 == 0) goto L98
            goto L99
        L98:
            r1 = 0
        L99:
            if (r1 == 0) goto Laf
            x8.l r11 = r9.X()
            y8.k.b(r11)
            java.lang.Object r10 = r11.h(r10)
            java.lang.String r11 = " = "
            java.lang.String r10 = y8.k.j(r11, r10)
            r12.append(r10)
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.d.S1(n9.d1, boolean, java.lang.StringBuilder, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0(o0 o0Var, StringBuilder sb2) {
        n1(o0Var, sb2);
    }

    private final void T1(Collection<? extends d1> collection, boolean z10, StringBuilder sb2) {
        boolean Z1 = Z1(z10);
        int size = collection.size();
        F0().b(size, sb2);
        int i10 = 0;
        for (d1 d1Var : collection) {
            F0().c(d1Var, i10, size, sb2);
            S1(d1Var, Z1, sb2, false);
            F0().a(d1Var, i10, size, sb2);
            i10++;
        }
        F0().d(size, sb2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void U0(n9.x r6, java.lang.StringBuilder r7) {
        /*
            r5 = this;
            boolean r0 = r6.t0()
            java.lang.String r1 = "functionDescriptor.overriddenDescriptors"
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L3a
            java.util.Collection r0 = r6.g()
            y8.k.d(r0, r1)
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L19
        L17:
            r0 = 1
            goto L30
        L19:
            java.util.Iterator r0 = r0.iterator()
        L1d:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L17
            java.lang.Object r4 = r0.next()
            n9.x r4 = (n9.x) r4
            boolean r4 = r4.t0()
            if (r4 == 0) goto L1d
            r0 = 0
        L30:
            if (r0 != 0) goto L38
            boolean r0 = r5.S()
            if (r0 == 0) goto L3a
        L38:
            r0 = 1
            goto L3b
        L3a:
            r0 = 0
        L3b:
            boolean r4 = r6.N0()
            if (r4 == 0) goto L70
            java.util.Collection r4 = r6.g()
            y8.k.d(r4, r1)
            boolean r1 = r4.isEmpty()
            if (r1 == 0) goto L50
        L4e:
            r1 = 1
            goto L67
        L50:
            java.util.Iterator r1 = r4.iterator()
        L54:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L4e
            java.lang.Object r4 = r1.next()
            n9.x r4 = (n9.x) r4
            boolean r4 = r4.N0()
            if (r4 == 0) goto L54
            r1 = 0
        L67:
            if (r1 != 0) goto L6f
            boolean r1 = r5.S()
            if (r1 == 0) goto L70
        L6f:
            r2 = 1
        L70:
            boolean r1 = r6.s0()
            java.lang.String r3 = "tailrec"
            r5.r1(r7, r1, r3)
            r5.H1(r6, r7)
            boolean r6 = r6.x()
            java.lang.String r1 = "inline"
            r5.r1(r7, r6, r1)
            java.lang.String r6 = "infix"
            r5.r1(r7, r2, r6)
            java.lang.String r6 = "operator"
            r5.r1(r7, r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.d.U0(n9.x, java.lang.StringBuilder):void");
    }

    private final void U1(e1 e1Var, boolean z10, StringBuilder sb2, boolean z11, boolean z12) {
        b0 b10 = e1Var.b();
        y8.k.d(b10, "variable.type");
        d1 d1Var = e1Var instanceof d1 ? (d1) e1Var : null;
        b0 R = d1Var != null ? d1Var.R() : null;
        b0 b0Var = R == null ? b10 : R;
        r1(sb2, R != null, "vararg");
        if (z12 || (z11 && !A0())) {
            Q1(e1Var, sb2, z12);
        }
        if (z10) {
            s1(e1Var, sb2, z11);
            sb2.append(": ");
        }
        sb2.append(x(b0Var));
        k1(e1Var, sb2);
        if (!G0() || R == null) {
            return;
        }
        sb2.append(" /*");
        sb2.append(x(b10));
        sb2.append("*/");
    }

    private final List<String> V0(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        n9.d w02;
        int n10;
        int n11;
        List a02;
        List<String> g02;
        int n12;
        Map<la.e, pa.g<?>> a10 = cVar.a();
        List list = null;
        n9.e f10 = s0() ? ra.a.f(cVar) : null;
        List<d1> l10 = (f10 == null || (w02 = f10.w0()) == null) ? null : w02.l();
        if (l10 != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : l10) {
                if (((d1) obj).k0()) {
                    arrayList.add(obj);
                }
            }
            n12 = m8.r.n(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(n12);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((d1) it.next()).c());
            }
            list = arrayList2;
        }
        if (list == null) {
            list = q.d();
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            y8.k.d((la.e) obj2, "it");
            if (!a10.containsKey(r5)) {
                arrayList3.add(obj2);
            }
        }
        n10 = m8.r.n(arrayList3, 10);
        ArrayList arrayList4 = new ArrayList(n10);
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(y8.k.j(((la.e) it2.next()).k(), " = ..."));
        }
        Set<Map.Entry<la.e, pa.g<?>>> entrySet = a10.entrySet();
        n11 = m8.r.n(entrySet, 10);
        ArrayList arrayList5 = new ArrayList(n11);
        Iterator<T> it3 = entrySet.iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            la.e eVar = (la.e) entry.getKey();
            pa.g<?> gVar = (pa.g) entry.getValue();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(eVar.k());
            sb2.append(" = ");
            sb2.append(!list.contains(eVar) ? d1(gVar) : "...");
            arrayList5.add(sb2.toString());
        }
        a02 = y.a0(arrayList4, arrayList5);
        g02 = y.g0(a02);
        return g02;
    }

    private final boolean V1(u uVar, StringBuilder sb2) {
        if (!g0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.VISIBILITY)) {
            return false;
        }
        if (h0()) {
            uVar = uVar.f();
        }
        if (!u0() && y8.k.a(uVar, n9.t.f12309k)) {
            return false;
        }
        sb2.append(l1(uVar.c()));
        sb2.append(" ");
        return true;
    }

    private final void W0(StringBuilder sb2, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e eVar) {
        boolean B;
        if (g0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.ANNOTATIONS)) {
            Set<la.b> l10 = aVar instanceof b0 ? l() : Z();
            x8.l<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, Boolean> T = T();
            for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar : aVar.u()) {
                B = y.B(l10, cVar.f());
                if (!B && !P0(cVar) && (T == null || T.h(cVar).booleanValue())) {
                    sb2.append(s(cVar, eVar));
                    if (Y()) {
                        sb2.append('\n');
                        y8.k.d(sb2, "append('\\n')");
                    } else {
                        sb2.append(" ");
                    }
                }
            }
        }
    }

    private final void W1(List<? extends a1> list, StringBuilder sb2) {
        List<b0> D;
        if (L0()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        for (a1 a1Var : list) {
            List<b0> upperBounds = a1Var.getUpperBounds();
            y8.k.d(upperBounds, "typeParameter.upperBounds");
            D = y.D(upperBounds, 1);
            for (b0 b0Var : D) {
                StringBuilder sb3 = new StringBuilder();
                la.e c10 = a1Var.c();
                y8.k.d(c10, "typeParameter.name");
                sb3.append(w(c10, false));
                sb3.append(" : ");
                y8.k.d(b0Var, "it");
                sb3.append(x(b0Var));
                arrayList.add(sb3.toString());
            }
        }
        if (!arrayList.isEmpty()) {
            sb2.append(" ");
            sb2.append(l1("where"));
            sb2.append(" ");
            y.O(arrayList, sb2, ", ", null, null, 0, null, null, e.j.H0, null);
        }
    }

    static /* synthetic */ void X0(d dVar, StringBuilder sb2, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            eVar = null;
        }
        dVar.W0(sb2, aVar, eVar);
    }

    private final String X1(String str, String str2, String str3, String str4, String str5) {
        boolean w10;
        boolean w11;
        w10 = r.w(str, str2, false, 2, null);
        if (w10) {
            w11 = r.w(str3, str4, false, 2, null);
            if (w11) {
                int length = str2.length();
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String substring = str.substring(length);
                y8.k.d(substring, "(this as java.lang.String).substring(startIndex)");
                int length2 = str4.length();
                Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
                String substring2 = str3.substring(length2);
                y8.k.d(substring2, "(this as java.lang.String).substring(startIndex)");
                String j10 = y8.k.j(str5, substring);
                if (y8.k.a(substring, substring2)) {
                    return j10;
                }
                if (P(substring, substring2)) {
                    return y8.k.j(j10, "!");
                }
            }
        }
        return null;
    }

    private final void Y0(n9.i iVar, StringBuilder sb2) {
        List<a1> B = iVar.B();
        y8.k.d(B, "classifier.declaredTypeParameters");
        List<a1> B2 = iVar.o().B();
        y8.k.d(B2, "classifier.typeConstructor.parameters");
        if (G0() && iVar.m0() && B2.size() > B.size()) {
            sb2.append(" /*captured type parameters: ");
            O1(sb2, B2.subList(B.size(), B2.size()));
            sb2.append("*/");
        }
    }

    private final boolean Y1(b0 b0Var) {
        boolean z10;
        if (!k9.g.m(b0Var)) {
            return false;
        }
        List<v0> V0 = b0Var.V0();
        if (!(V0 instanceof Collection) || !V0.isEmpty()) {
            Iterator<T> it = V0.iterator();
            while (it.hasNext()) {
                if (((v0) it.next()).d()) {
                    z10 = false;
                    break;
                }
            }
        }
        z10 = true;
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0(n9.e eVar, StringBuilder sb2) {
        n9.d w02;
        boolean z10 = eVar.r() == n9.f.ENUM_ENTRY;
        if (!A0()) {
            X0(this, sb2, eVar, null, 2, null);
            if (!z10) {
                u h10 = eVar.h();
                y8.k.d(h10, "klass.visibility");
                V1(h10, sb2);
            }
            if ((eVar.r() != n9.f.INTERFACE || eVar.p() != a0.ABSTRACT) && (!eVar.r().isSingleton() || eVar.p() != a0.FINAL)) {
                a0 p10 = eVar.p();
                y8.k.d(p10, "klass.modality");
                p1(p10, sb2, O0(eVar));
            }
            n1(eVar, sb2);
            r1(sb2, g0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.INNER) && eVar.m0(), "inner");
            r1(sb2, g0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.DATA) && eVar.R0(), "data");
            r1(sb2, g0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.INLINE) && eVar.x(), "inline");
            r1(sb2, g0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.VALUE) && eVar.j0(), "value");
            r1(sb2, g0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.FUN) && eVar.W(), "fun");
            a1(eVar, sb2);
        }
        if (na.d.x(eVar)) {
            c1(eVar, sb2);
        } else {
            if (!A0()) {
                F1(sb2);
            }
            s1(eVar, sb2, true);
        }
        if (z10) {
            return;
        }
        List<a1> B = eVar.B();
        y8.k.d(B, "klass.declaredTypeParameters");
        P1(B, sb2, false);
        Y0(eVar, sb2);
        if (!eVar.r().isSingleton() && V() && (w02 = eVar.w0()) != null) {
            sb2.append(" ");
            X0(this, sb2, w02, null, 2, null);
            u h11 = w02.h();
            y8.k.d(h11, "primaryConstructor.visibility");
            V1(h11, sb2);
            sb2.append(l1("constructor"));
            List<d1> l10 = w02.l();
            y8.k.d(l10, "primaryConstructor.valueParameters");
            T1(l10, w02.c0(), sb2);
        }
        G1(eVar, sb2);
        W1(B, sb2);
    }

    private final boolean Z1(boolean z10) {
        int i10 = b.f11518b[k0().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return false;
                }
                throw new l8.l();
            }
            if (z10) {
                return false;
            }
        }
        return true;
    }

    private final d a0() {
        return (d) this.f11514e.getValue();
    }

    private final void a1(n9.e eVar, StringBuilder sb2) {
        sb2.append(l1(kotlin.reflect.jvm.internal.impl.renderer.c.f11498a.a(eVar)));
    }

    private final void c1(n9.m mVar, StringBuilder sb2) {
        if (p0()) {
            if (A0()) {
                sb2.append("companion object");
            }
            F1(sb2);
            n9.m d10 = mVar.d();
            if (d10 != null) {
                sb2.append("of ");
                la.e c10 = d10.c();
                y8.k.d(c10, "containingDeclaration.name");
                sb2.append(w(c10, false));
            }
        }
        if (G0() || !y8.k.a(mVar.c(), la.g.f11861b)) {
            if (!A0()) {
                F1(sb2);
            }
            la.e c11 = mVar.c();
            y8.k.d(c11, "descriptor.name");
            sb2.append(w(c11, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d1(pa.g<?> gVar) {
        String S;
        String Q;
        if (gVar instanceof pa.b) {
            Q = y.Q(((pa.b) gVar).b(), ", ", "{", "}", 0, null, new e(), 24, null);
            return Q;
        }
        if (gVar instanceof pa.a) {
            S = s.S(kotlin.reflect.jvm.internal.impl.renderer.c.t(this, ((pa.a) gVar).b(), null, 2, null), "@");
            return S;
        }
        if (!(gVar instanceof pa.q)) {
            return gVar.toString();
        }
        q.b b10 = ((pa.q) gVar).b();
        if (b10 instanceof q.b.a) {
            return ((q.b.a) b10).a() + "::class";
        }
        if (!(b10 instanceof q.b.C0277b)) {
            throw new l8.l();
        }
        q.b.C0277b c0277b = (q.b.C0277b) b10;
        String b11 = c0277b.b().b().b();
        y8.k.d(b11, "classValue.classId.asSingleFqName().asString()");
        for (int i10 = 0; i10 < c0277b.a(); i10++) {
            b11 = "kotlin.Array<" + b11 + '>';
        }
        return y8.k.j(b11, "::class");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e1(n9.l r18, java.lang.StringBuilder r19) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.d.e1(n9.l, java.lang.StringBuilder):void");
    }

    private final void f1(StringBuilder sb2, b0 b0Var) {
        X0(this, sb2, b0Var, null, 2, null);
        if (bb.d0.a(b0Var)) {
            sb2.append(((b0Var instanceof f1) && m0()) ? ((f1) b0Var).f1() : (!(b0Var instanceof bb.s) || f0()) ? b0Var.W0().toString() : ((bb.s) b0Var).f1());
            sb2.append(J1(b0Var.V0()));
        } else {
            M1(this, sb2, b0Var, null, 2, null);
        }
        if (b0Var.X0()) {
            sb2.append("?");
        }
        if (bb.l0.c(b0Var)) {
            sb2.append("!!");
        }
    }

    private final String g1(String str) {
        int i10 = b.f11517a[B0().ordinal()];
        if (i10 == 1) {
            return str;
        }
        if (i10 != 2) {
            throw new l8.l();
        }
        return "<font color=red><b>" + str + "</b></font>";
    }

    private final String h1(List<la.e> list) {
        return Q(n.c(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1(x xVar, StringBuilder sb2) {
        if (!A0()) {
            if (!z0()) {
                X0(this, sb2, xVar, null, 2, null);
                u h10 = xVar.h();
                y8.k.d(h10, "function.visibility");
                V1(h10, sb2);
                q1(xVar, sb2);
                if (b0()) {
                    n1(xVar, sb2);
                }
                v1(xVar, sb2);
                if (b0()) {
                    U0(xVar, sb2);
                } else {
                    H1(xVar, sb2);
                }
                m1(xVar, sb2);
                if (G0()) {
                    if (xVar.p0()) {
                        sb2.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (xVar.C0()) {
                        sb2.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb2.append(l1("fun"));
            sb2.append(" ");
            List<a1> m10 = xVar.m();
            y8.k.d(m10, "function.typeParameters");
            P1(m10, sb2, true);
            C1(xVar, sb2);
        }
        s1(xVar, sb2, true);
        List<d1> l10 = xVar.l();
        y8.k.d(l10, "function.valueParameters");
        T1(l10, xVar.c0(), sb2);
        D1(xVar, sb2);
        b0 i10 = xVar.i();
        if (!J0() && (E0() || i10 == null || !k9.h.J0(i10))) {
            sb2.append(": ");
            sb2.append(i10 == null ? "[NULL]" : x(i10));
        }
        List<a1> m11 = xVar.m();
        y8.k.d(m11, "function.typeParameters");
        W1(m11, sb2);
    }

    private final void j1(StringBuilder sb2, b0 b0Var) {
        la.e eVar;
        int E;
        int E2;
        int length = sb2.length();
        X0(a0(), sb2, b0Var, null, 2, null);
        boolean z10 = true;
        boolean z11 = sb2.length() != length;
        boolean o10 = k9.g.o(b0Var);
        boolean X0 = b0Var.X0();
        b0 h10 = k9.g.h(b0Var);
        boolean z12 = X0 || (z11 && h10 != null);
        if (z12) {
            if (o10) {
                sb2.insert(length, '(');
            } else {
                if (z11) {
                    mb.u.k0(sb2);
                    E = s.E(sb2);
                    if (sb2.charAt(E - 1) != ')') {
                        E2 = s.E(sb2);
                        sb2.insert(E2, "()");
                    }
                }
                sb2.append("(");
            }
        }
        r1(sb2, o10, "suspend");
        if (h10 != null) {
            if ((!Y1(h10) || h10.X0()) && !N0(h10)) {
                z10 = false;
            }
            if (z10) {
                sb2.append("(");
            }
            t1(sb2, h10);
            if (z10) {
                sb2.append(")");
            }
            sb2.append(".");
        }
        sb2.append("(");
        int i10 = 0;
        for (v0 v0Var : k9.g.j(b0Var)) {
            int i11 = i10 + 1;
            if (i10 > 0) {
                sb2.append(", ");
            }
            if (l0()) {
                b0 b10 = v0Var.b();
                y8.k.d(b10, "typeProjection.type");
                eVar = k9.g.c(b10);
            } else {
                eVar = null;
            }
            if (eVar != null) {
                sb2.append(w(eVar, false));
                sb2.append(": ");
            }
            sb2.append(y(v0Var));
            i10 = i11;
        }
        sb2.append(") ");
        sb2.append(O());
        sb2.append(" ");
        t1(sb2, k9.g.i(b0Var));
        if (z12) {
            sb2.append(")");
        }
        if (X0) {
            sb2.append("?");
        }
    }

    private final void k1(e1 e1Var, StringBuilder sb2) {
        pa.g<?> F0;
        if (!e0() || (F0 = e1Var.F0()) == null) {
            return;
        }
        sb2.append(" = ");
        sb2.append(Q(d1(F0)));
    }

    private final String l1(String str) {
        int i10 = b.f11517a[B0().ordinal()];
        if (i10 == 1) {
            return str;
        }
        if (i10 != 2) {
            throw new l8.l();
        }
        if (U()) {
            return str;
        }
        return "<b>" + str + "</b>";
    }

    private final void m1(n9.b bVar, StringBuilder sb2) {
        if (g0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.MEMBER_KIND) && G0() && bVar.r() != b.a.DECLARATION) {
            sb2.append("/*");
            String name = bVar.r().name();
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = name.toLowerCase();
            y8.k.d(lowerCase, "(this as java.lang.String).toLowerCase()");
            sb2.append(lowerCase);
            sb2.append("*/ ");
        }
    }

    private final void n1(z zVar, StringBuilder sb2) {
        r1(sb2, zVar.I(), "external");
        r1(sb2, g0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.EXPECT) && zVar.l0(), "expect");
        r1(sb2, g0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.ACTUAL) && zVar.H0(), "actual");
    }

    private final void p1(a0 a0Var, StringBuilder sb2, a0 a0Var2) {
        if (t0() || a0Var != a0Var2) {
            boolean contains = g0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.MODALITY);
            String name = a0Var.name();
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = name.toLowerCase();
            y8.k.d(lowerCase, "(this as java.lang.String).toLowerCase()");
            r1(sb2, contains, lowerCase);
        }
    }

    private final void q1(n9.b bVar, StringBuilder sb2) {
        if (na.d.J(bVar) && bVar.p() == a0.FINAL) {
            return;
        }
        if (j0() == j.RENDER_OVERRIDE && bVar.p() == a0.OPEN && R0(bVar)) {
            return;
        }
        a0 p10 = bVar.p();
        y8.k.d(p10, "callable.modality");
        p1(p10, sb2, O0(bVar));
    }

    private final void r1(StringBuilder sb2, boolean z10, String str) {
        if (z10) {
            sb2.append(l1(str));
            sb2.append(" ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1(n9.m mVar, StringBuilder sb2, boolean z10) {
        la.e c10 = mVar.c();
        y8.k.d(c10, "descriptor.name");
        sb2.append(w(c10, z10));
    }

    private final void t1(StringBuilder sb2, b0 b0Var) {
        g1 Z0 = b0Var.Z0();
        bb.a aVar = Z0 instanceof bb.a ? (bb.a) Z0 : null;
        if (aVar == null) {
            u1(sb2, b0Var);
            return;
        }
        if (w0()) {
            u1(sb2, aVar.D0());
            return;
        }
        u1(sb2, aVar.i1());
        if (x0()) {
            S0(sb2, aVar);
        }
    }

    private final void u1(StringBuilder sb2, b0 b0Var) {
        if ((b0Var instanceof i1) && m() && !((i1) b0Var).b1()) {
            sb2.append("<Not computed yet>");
            return;
        }
        g1 Z0 = b0Var.Z0();
        if (Z0 instanceof bb.v) {
            sb2.append(((bb.v) Z0).g1(this, this));
        } else if (Z0 instanceof i0) {
            E1(sb2, (i0) Z0);
        }
    }

    private final void v1(n9.b bVar, StringBuilder sb2) {
        if (g0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.OVERRIDE) && R0(bVar) && j0() != j.RENDER_OPEN) {
            r1(sb2, true, "override");
            if (G0()) {
                sb2.append("/*");
                sb2.append(bVar.g().size());
                sb2.append("*/ ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1(g0 g0Var, StringBuilder sb2) {
        x1(g0Var.f(), "package-fragment", sb2);
        if (m()) {
            sb2.append(" in ");
            s1(g0Var.d(), sb2, false);
        }
    }

    private final void x1(la.b bVar, String str, StringBuilder sb2) {
        sb2.append(l1(str));
        la.c j10 = bVar.j();
        y8.k.d(j10, "fqName.toUnsafe()");
        String v10 = v(j10);
        if (v10.length() > 0) {
            sb2.append(" ");
            sb2.append(v10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y1(l0 l0Var, StringBuilder sb2) {
        x1(l0Var.f(), "package", sb2);
        if (m()) {
            sb2.append(" in context of ");
            s1(l0Var.n0(), sb2, false);
        }
    }

    private final void z1(StringBuilder sb2, n0 n0Var) {
        StringBuilder sb3;
        n0 c10 = n0Var.c();
        if (c10 == null) {
            sb3 = null;
        } else {
            z1(sb2, c10);
            sb2.append('.');
            la.e c11 = n0Var.b().c();
            y8.k.d(c11, "possiblyInnerType.classifierDescriptor.name");
            sb2.append(w(c11, false));
            sb3 = sb2;
        }
        if (sb3 == null) {
            t0 o10 = n0Var.b().o();
            y8.k.d(o10, "possiblyInnerType.classifierDescriptor.typeConstructor");
            sb2.append(K1(o10));
        }
        sb2.append(J1(n0Var.a()));
    }

    public boolean A0() {
        return this.f11513d.Z();
    }

    public m B0() {
        return this.f11513d.a0();
    }

    public x8.l<b0, b0> C0() {
        return this.f11513d.b0();
    }

    public boolean D0() {
        return this.f11513d.c0();
    }

    public boolean E0() {
        return this.f11513d.d0();
    }

    public c.l F0() {
        return this.f11513d.e0();
    }

    public boolean G0() {
        return this.f11513d.f0();
    }

    public boolean H0() {
        return this.f11513d.g0();
    }

    public boolean I0() {
        return this.f11513d.h0();
    }

    public boolean J0() {
        return this.f11513d.i0();
    }

    public String J1(List<? extends v0> list) {
        y8.k.e(list, "typeArguments");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Q0());
        N(sb2, list);
        sb2.append(M0());
        String sb3 = sb2.toString();
        y8.k.d(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public boolean K0() {
        return this.f11513d.j0();
    }

    public String K1(t0 t0Var) {
        y8.k.e(t0Var, "typeConstructor");
        n9.h o10 = t0Var.o();
        if (o10 instanceof a1 ? true : o10 instanceof n9.e ? true : o10 instanceof z0) {
            return b1(o10);
        }
        if (o10 == null) {
            return t0Var.toString();
        }
        throw new IllegalStateException(y8.k.j("Unexpected classifier: ", o10.getClass()).toString());
    }

    public boolean L0() {
        return this.f11513d.k0();
    }

    public boolean R() {
        return this.f11513d.s();
    }

    public boolean S() {
        return this.f11513d.t();
    }

    public x8.l<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, Boolean> T() {
        return this.f11513d.u();
    }

    public boolean U() {
        return this.f11513d.v();
    }

    public boolean V() {
        return this.f11513d.w();
    }

    public kotlin.reflect.jvm.internal.impl.renderer.b W() {
        return this.f11513d.x();
    }

    public x8.l<d1, String> X() {
        return this.f11513d.y();
    }

    public boolean Y() {
        return this.f11513d.z();
    }

    public Set<la.b> Z() {
        return this.f11513d.A();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void a(boolean z10) {
        this.f11513d.a(z10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void b(boolean z10) {
        this.f11513d.b(z10);
    }

    public boolean b0() {
        return this.f11513d.B();
    }

    public String b1(n9.h hVar) {
        y8.k.e(hVar, "klass");
        return t.r(hVar) ? hVar.o().toString() : W().a(hVar, this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void c(boolean z10) {
        this.f11513d.c(z10);
    }

    public boolean c0() {
        return this.f11513d.C();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void d(m mVar) {
        y8.k.e(mVar, "<set-?>");
        this.f11513d.d(mVar);
    }

    public boolean d0() {
        return this.f11513d.D();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void e(Set<la.b> set) {
        y8.k.e(set, "<set-?>");
        this.f11513d.e(set);
    }

    public boolean e0() {
        return this.f11513d.E();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void f(boolean z10) {
        this.f11513d.f(z10);
    }

    public boolean f0() {
        return this.f11513d.F();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void g(Set<? extends kotlin.reflect.jvm.internal.impl.renderer.e> set) {
        y8.k.e(set, "<set-?>");
        this.f11513d.g(set);
    }

    public Set<kotlin.reflect.jvm.internal.impl.renderer.e> g0() {
        return this.f11513d.G();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void h(k kVar) {
        y8.k.e(kVar, "<set-?>");
        this.f11513d.h(kVar);
    }

    public boolean h0() {
        return this.f11513d.H();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void i(kotlin.reflect.jvm.internal.impl.renderer.a aVar) {
        y8.k.e(aVar, "<set-?>");
        this.f11513d.i(aVar);
    }

    public final kotlin.reflect.jvm.internal.impl.renderer.g i0() {
        return this.f11513d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void j(boolean z10) {
        this.f11513d.j(z10);
    }

    public j j0() {
        return this.f11513d.I();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public boolean k() {
        return this.f11513d.k();
    }

    public k k0() {
        return this.f11513d.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public Set<la.b> l() {
        return this.f11513d.l();
    }

    public boolean l0() {
        return this.f11513d.K();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public boolean m() {
        return this.f11513d.m();
    }

    public boolean m0() {
        return this.f11513d.L();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public kotlin.reflect.jvm.internal.impl.renderer.a n() {
        return this.f11513d.n();
    }

    public l n0() {
        return this.f11513d.M();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void o(kotlin.reflect.jvm.internal.impl.renderer.b bVar) {
        y8.k.e(bVar, "<set-?>");
        this.f11513d.o(bVar);
    }

    public boolean o0() {
        return this.f11513d.N();
    }

    public String o1(String str) {
        y8.k.e(str, "message");
        int i10 = b.f11517a[B0().ordinal()];
        if (i10 == 1) {
            return str;
        }
        if (i10 != 2) {
            throw new l8.l();
        }
        return "<i>" + str + "</i>";
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void p(boolean z10) {
        this.f11513d.p(z10);
    }

    public boolean p0() {
        return this.f11513d.O();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void q(boolean z10) {
        this.f11513d.q(z10);
    }

    public boolean q0() {
        return this.f11513d.P();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public String r(n9.m mVar) {
        y8.k.e(mVar, "declarationDescriptor");
        StringBuilder sb2 = new StringBuilder();
        mVar.J0(new a(this), sb2);
        if (H0()) {
            M(sb2, mVar);
        }
        String sb3 = sb2.toString();
        y8.k.d(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public boolean r0() {
        return this.f11513d.Q();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public String s(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e eVar) {
        y8.k.e(cVar, "annotation");
        StringBuilder sb2 = new StringBuilder();
        sb2.append('@');
        if (eVar != null) {
            sb2.append(y8.k.j(eVar.getRenderName(), ":"));
        }
        b0 b10 = cVar.b();
        sb2.append(x(b10));
        if (c0()) {
            List<String> V0 = V0(cVar);
            if (d0() || (!V0.isEmpty())) {
                y.O(V0, sb2, ", ", "(", ")", 0, null, null, 112, null);
            }
        }
        if (G0() && (bb.d0.a(b10) || (b10.W0().o() instanceof f0.b))) {
            sb2.append(" /* annotation class not found */");
        }
        String sb3 = sb2.toString();
        y8.k.d(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public boolean s0() {
        return this.f11513d.R();
    }

    public boolean t0() {
        return this.f11513d.S();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public String u(String str, String str2, k9.h hVar) {
        String g02;
        String g03;
        boolean w10;
        y8.k.e(str, "lowerRendered");
        y8.k.e(str2, "upperRendered");
        y8.k.e(hVar, "builtIns");
        if (P(str, str2)) {
            w10 = r.w(str2, "(", false, 2, null);
            if (!w10) {
                return y8.k.j(str, "!");
            }
            return '(' + str + ")!";
        }
        kotlin.reflect.jvm.internal.impl.renderer.b W = W();
        n9.e w11 = hVar.w();
        y8.k.d(w11, "builtIns.collection");
        g02 = s.g0(W.a(w11, this), "Collection", null, 2, null);
        String X1 = X1(str, y8.k.j(g02, "Mutable"), str2, g02, g02 + "(Mutable)");
        if (X1 != null) {
            return X1;
        }
        String X12 = X1(str, y8.k.j(g02, "MutableMap.MutableEntry"), str2, y8.k.j(g02, "Map.Entry"), y8.k.j(g02, "(Mutable)Map.(Mutable)Entry"));
        if (X12 != null) {
            return X12;
        }
        kotlin.reflect.jvm.internal.impl.renderer.b W2 = W();
        n9.e j10 = hVar.j();
        y8.k.d(j10, "builtIns.array");
        g03 = s.g0(W2.a(j10, this), "Array", null, 2, null);
        String X13 = X1(str, y8.k.j(g03, Q("Array<")), str2, y8.k.j(g03, Q("Array<out ")), y8.k.j(g03, Q("Array<(out) ")));
        if (X13 != null) {
            return X13;
        }
        return '(' + str + ".." + str2 + ')';
    }

    public boolean u0() {
        return this.f11513d.T();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public String v(la.c cVar) {
        y8.k.e(cVar, "fqName");
        List<la.e> h10 = cVar.h();
        y8.k.d(h10, "fqName.pathSegments()");
        return h1(h10);
    }

    public boolean v0() {
        return this.f11513d.U();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public String w(la.e eVar, boolean z10) {
        y8.k.e(eVar, "name");
        String Q = Q(n.b(eVar));
        if (!U() || B0() != m.HTML || !z10) {
            return Q;
        }
        return "<b>" + Q + "</b>";
    }

    public boolean w0() {
        return this.f11513d.V();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public String x(b0 b0Var) {
        y8.k.e(b0Var, "type");
        StringBuilder sb2 = new StringBuilder();
        t1(sb2, C0().h(b0Var));
        String sb3 = sb2.toString();
        y8.k.d(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public boolean x0() {
        return this.f11513d.W();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public String y(v0 v0Var) {
        List<? extends v0> b10;
        y8.k.e(v0Var, "typeProjection");
        StringBuilder sb2 = new StringBuilder();
        b10 = p.b(v0Var);
        N(sb2, b10);
        String sb3 = sb2.toString();
        y8.k.d(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public boolean y0() {
        return this.f11513d.X();
    }

    public boolean z0() {
        return this.f11513d.Y();
    }
}
