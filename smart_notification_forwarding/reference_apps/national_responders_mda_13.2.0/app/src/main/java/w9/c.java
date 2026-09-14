package w9;

import java.util.Map;
import k9.k;
import l8.t;
import m8.l0;
import v9.y;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f15310a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static final la.e f15311b;

    /* renamed from: c, reason: collision with root package name */
    private static final la.e f15312c;

    /* renamed from: d, reason: collision with root package name */
    private static final la.e f15313d;

    /* renamed from: e, reason: collision with root package name */
    private static final Map<la.b, la.b> f15314e;

    /* renamed from: f, reason: collision with root package name */
    private static final Map<la.b, la.b> f15315f;

    static {
        Map<la.b, la.b> k10;
        Map<la.b, la.b> k11;
        la.e r10 = la.e.r("message");
        y8.k.d(r10, "identifier(\"message\")");
        f15311b = r10;
        la.e r11 = la.e.r("allowedTargets");
        y8.k.d(r11, "identifier(\"allowedTargets\")");
        f15312c = r11;
        la.e r12 = la.e.r("value");
        y8.k.d(r12, "identifier(\"value\")");
        f15313d = r12;
        la.b bVar = k.a.A;
        la.b bVar2 = y.f14815c;
        la.b bVar3 = k.a.D;
        la.b bVar4 = y.f14816d;
        la.b bVar5 = k.a.E;
        la.b bVar6 = y.f14819g;
        la.b bVar7 = k.a.F;
        la.b bVar8 = y.f14818f;
        k10 = l0.k(t.a(bVar, bVar2), t.a(bVar3, bVar4), t.a(bVar5, bVar6), t.a(bVar7, bVar8));
        f15314e = k10;
        k11 = l0.k(t.a(bVar2, bVar), t.a(bVar4, bVar3), t.a(y.f14817e, k.a.f11287u), t.a(bVar6, bVar5), t.a(bVar8, bVar7));
        f15315f = k11;
    }

    private c() {
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.annotations.c f(c cVar, ca.a aVar, y9.g gVar, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return cVar.e(aVar, gVar, z10);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a(la.b bVar, ca.d dVar, y9.g gVar) {
        ca.a e10;
        y8.k.e(bVar, "kotlinName");
        y8.k.e(dVar, "annotationOwner");
        y8.k.e(gVar, "c");
        if (y8.k.a(bVar, k.a.f11287u)) {
            la.b bVar2 = y.f14817e;
            y8.k.d(bVar2, "DEPRECATED_ANNOTATION");
            ca.a e11 = dVar.e(bVar2);
            if (e11 != null || dVar.v()) {
                return new e(e11, gVar);
            }
        }
        la.b bVar3 = f15314e.get(bVar);
        if (bVar3 == null || (e10 = dVar.e(bVar3)) == null) {
            return null;
        }
        return f(this, e10, gVar, false, 4, null);
    }

    public final la.e b() {
        return f15311b;
    }

    public final la.e c() {
        return f15313d;
    }

    public final la.e d() {
        return f15312c;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c e(ca.a aVar, y9.g gVar, boolean z10) {
        y8.k.e(aVar, "annotation");
        y8.k.e(gVar, "c");
        la.a d10 = aVar.d();
        if (y8.k.a(d10, la.a.m(y.f14815c))) {
            return new i(aVar, gVar);
        }
        if (y8.k.a(d10, la.a.m(y.f14816d))) {
            return new h(aVar, gVar);
        }
        if (y8.k.a(d10, la.a.m(y.f14819g))) {
            return new b(gVar, aVar, k.a.E);
        }
        if (y8.k.a(d10, la.a.m(y.f14818f))) {
            return new b(gVar, aVar, k.a.F);
        }
        if (y8.k.a(d10, la.a.m(y.f14817e))) {
            return null;
        }
        return new z9.e(gVar, aVar, z10);
    }
}
