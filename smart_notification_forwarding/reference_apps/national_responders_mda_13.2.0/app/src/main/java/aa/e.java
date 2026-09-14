package aa;

import bb.b0;
import bb.c0;
import bb.d0;
import bb.h1;
import bb.i0;
import bb.t0;
import bb.v0;
import bb.x0;
import bb.y;
import bb.y0;
import java.util.ArrayList;
import java.util.List;
import k9.h;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import l8.n;
import l8.t;
import m8.p;
import m8.r;
import n9.a1;
import y8.k;
import y8.l;

/* loaded from: classes.dex */
public final class e extends y0 {

    /* renamed from: b, reason: collision with root package name */
    public static final e f345b = new e();

    /* renamed from: c, reason: collision with root package name */
    private static final aa.a f346c;

    /* renamed from: d, reason: collision with root package name */
    private static final aa.a f347d;

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f348a;

        static {
            int[] iArr = new int[aa.b.valuesCustom().length];
            iArr[aa.b.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            iArr[aa.b.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            iArr[aa.b.INFLEXIBLE.ordinal()] = 3;
            f348a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends l implements x8.l<g, i0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ n9.e f349f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f350g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ i0 f351h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ aa.a f352i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(n9.e eVar, e eVar2, i0 i0Var, aa.a aVar) {
            super(1);
            this.f349f = eVar;
            this.f350g = eVar2;
            this.f351h = i0Var;
            this.f352i = aVar;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i0 h(g gVar) {
            n9.e a10;
            k.e(gVar, "kotlinTypeRefiner");
            n9.e eVar = this.f349f;
            if (!(eVar instanceof n9.e)) {
                eVar = null;
            }
            la.a h10 = eVar == null ? null : ra.a.h(eVar);
            if (h10 == null || (a10 = gVar.a(h10)) == null || k.a(a10, this.f349f)) {
                return null;
            }
            return (i0) this.f350g.k(this.f351h, a10, this.f352i).c();
        }
    }

    static {
        w9.k kVar = w9.k.COMMON;
        f346c = d.f(kVar, false, null, 3, null).g(aa.b.FLEXIBLE_LOWER_BOUND);
        f347d = d.f(kVar, false, null, 3, null).g(aa.b.FLEXIBLE_UPPER_BOUND);
    }

    private e() {
    }

    public static /* synthetic */ v0 j(e eVar, a1 a1Var, aa.a aVar, b0 b0Var, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            b0Var = d.c(a1Var, null, null, 3, null);
        }
        return eVar.i(a1Var, aVar, b0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n<i0, Boolean> k(i0 i0Var, n9.e eVar, aa.a aVar) {
        int n10;
        Boolean bool;
        List b10;
        if (!i0Var.W0().B().isEmpty()) {
            if (h.b0(i0Var)) {
                v0 v0Var = i0Var.V0().get(0);
                h1 c10 = v0Var.c();
                b0 b11 = v0Var.b();
                k.d(b11, "componentTypeProjection.type");
                b10 = p.b(new x0(c10, l(b11)));
                c0 c0Var = c0.f4165a;
                i0Var = c0.i(i0Var.u(), i0Var.W0(), b10, i0Var.X0(), null, 16, null);
            } else {
                if (!d0.a(i0Var)) {
                    ua.h J = eVar.J(this);
                    k.d(J, "declaration.getMemberScope(RawSubstitution)");
                    c0 c0Var2 = c0.f4165a;
                    kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u10 = i0Var.u();
                    t0 o10 = eVar.o();
                    k.d(o10, "declaration.typeConstructor");
                    List<a1> B = eVar.o().B();
                    k.d(B, "declaration.typeConstructor.parameters");
                    n10 = r.n(B, 10);
                    ArrayList arrayList = new ArrayList(n10);
                    for (a1 a1Var : B) {
                        k.d(a1Var, "parameter");
                        arrayList.add(j(this, a1Var, aVar, null, 4, null));
                    }
                    i0Var = c0.k(u10, o10, arrayList, i0Var.X0(), J, new b(eVar, this, i0Var, aVar));
                    bool = Boolean.TRUE;
                    return t.a(i0Var, bool);
                }
                i0Var = bb.t.j(k.j("Raw error type: ", i0Var.W0()));
                k.d(i0Var, "createErrorType(\"Raw error type: ${type.constructor}\")");
            }
        }
        bool = Boolean.FALSE;
        return t.a(i0Var, bool);
    }

    private final b0 l(b0 b0Var) {
        n9.h o10 = b0Var.W0().o();
        if (o10 instanceof a1) {
            return l(d.c((a1) o10, null, null, 3, null));
        }
        if (!(o10 instanceof n9.e)) {
            throw new IllegalStateException(k.j("Unexpected declaration kind: ", o10).toString());
        }
        n9.h o11 = y.d(b0Var).W0().o();
        if (!(o11 instanceof n9.e)) {
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + o11 + "\" while for lower it's \"" + o10 + '\"').toString());
        }
        n<i0, Boolean> k10 = k(y.c(b0Var), (n9.e) o10, f346c);
        i0 a10 = k10.a();
        boolean booleanValue = k10.b().booleanValue();
        n<i0, Boolean> k11 = k(y.d(b0Var), (n9.e) o11, f347d);
        i0 a11 = k11.a();
        boolean booleanValue2 = k11.b().booleanValue();
        if (booleanValue || booleanValue2) {
            return new f(a10, a11);
        }
        c0 c0Var = c0.f4165a;
        return c0.d(a10, a11);
    }

    @Override // bb.y0
    public boolean f() {
        return false;
    }

    public final v0 i(a1 a1Var, aa.a aVar, b0 b0Var) {
        k.e(a1Var, "parameter");
        k.e(aVar, "attr");
        k.e(b0Var, "erasedUpperBound");
        int i10 = a.f348a[aVar.c().ordinal()];
        if (i10 == 1) {
            return new x0(h1.INVARIANT, b0Var);
        }
        if (i10 != 2 && i10 != 3) {
            throw new l8.l();
        }
        if (!a1Var.v().getAllowsOutPosition()) {
            return new x0(h1.INVARIANT, ra.a.g(a1Var).H());
        }
        List<a1> B = b0Var.W0().B();
        k.d(B, "erasedUpperBound.constructor.parameters");
        return B.isEmpty() ^ true ? new x0(h1.OUT_VARIANCE, b0Var) : d.d(a1Var, aVar);
    }

    @Override // bb.y0
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public x0 e(b0 b0Var) {
        k.e(b0Var, "key");
        return new x0(l(b0Var));
    }
}
