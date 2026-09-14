package k9;

import bb.b0;
import bb.c0;
import bb.h1;
import bb.i0;
import bb.t;
import bb.t0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import m8.p;
import m8.r;
import n9.a0;
import n9.a1;
import n9.d0;
import n9.u;
import n9.v0;
import p9.j0;
import p9.y;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static final y f11293a;

    /* renamed from: b, reason: collision with root package name */
    private static final y f11294b;

    static {
        List<a1> b10;
        List<a1> b11;
        d0 q10 = t.q();
        y8.k.d(q10, "getErrorModule()");
        p9.m mVar = new p9.m(q10, k.f11239e);
        n9.f fVar = n9.f.INTERFACE;
        la.e g10 = k.f11240f.g();
        v0 v0Var = v0.f12324a;
        ab.n nVar = ab.f.f359e;
        y yVar = new y(mVar, fVar, false, false, g10, v0Var, nVar);
        a0 a0Var = a0.ABSTRACT;
        yVar.X0(a0Var);
        u uVar = n9.t.f12303e;
        yVar.Z0(uVar);
        g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b12 = aVar.b();
        h1 h1Var = h1.IN_VARIANCE;
        b10 = p.b(j0.c1(yVar, b12, false, h1Var, la.e.r("T"), 0, nVar));
        yVar.Y0(b10);
        yVar.V0();
        f11293a = yVar;
        d0 q11 = t.q();
        y8.k.d(q11, "getErrorModule()");
        y yVar2 = new y(new p9.m(q11, k.f11238d), fVar, false, false, k.f11241g.g(), v0Var, nVar);
        yVar2.X0(a0Var);
        yVar2.Z0(uVar);
        b11 = p.b(j0.c1(yVar2, aVar.b(), false, h1Var, la.e.r("T"), 0, nVar));
        yVar2.Y0(b11);
        yVar2.V0();
        f11294b = yVar2;
    }

    public static final boolean a(la.b bVar, boolean z10) {
        return y8.k.a(bVar, z10 ? k.f11241g : k.f11240f);
    }

    public static final i0 b(b0 b0Var, boolean z10) {
        int n10;
        List b10;
        List b02;
        i0 a10;
        y8.k.e(b0Var, "suspendFunType");
        g.o(b0Var);
        h e10 = eb.a.e(b0Var);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u10 = b0Var.u();
        b0 h10 = g.h(b0Var);
        List<bb.v0> j10 = g.j(b0Var);
        n10 = r.n(j10, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = j10.iterator();
        while (it.hasNext()) {
            arrayList.add(((bb.v0) it.next()).b());
        }
        c0 c0Var = c0.f4165a;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b11 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b();
        t0 o10 = (z10 ? f11294b : f11293a).o();
        y8.k.d(o10, "if (isReleaseCoroutines) FAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE.typeConstructor\n                    else FAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL.typeConstructor");
        b10 = p.b(eb.a.a(g.i(b0Var)));
        b02 = m8.y.b0(arrayList, c0.i(b11, o10, b10, false, null, 16, null));
        i0 I = eb.a.e(b0Var).I();
        y8.k.d(I, "suspendFunType.builtIns.nullableAnyType");
        a10 = g.a(e10, u10, h10, b02, null, I, (r14 & 64) != 0 ? false : false);
        return a10.a1(b0Var.X0());
    }
}
