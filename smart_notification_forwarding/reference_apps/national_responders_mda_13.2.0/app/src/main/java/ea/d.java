package ea;

import java.util.List;
import n9.d0;
import n9.f0;
import o9.a;
import o9.c;
import xa.t;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final xa.j f9294a;

    public d(ab.n nVar, d0 d0Var, xa.k kVar, f fVar, b bVar, y9.f fVar2, f0 f0Var, xa.p pVar, u9.c cVar, xa.i iVar, kotlin.reflect.jvm.internal.impl.types.checker.l lVar) {
        List d10;
        List d11;
        y8.k.e(nVar, "storageManager");
        y8.k.e(d0Var, "moduleDescriptor");
        y8.k.e(kVar, "configuration");
        y8.k.e(fVar, "classDataFinder");
        y8.k.e(bVar, "annotationAndConstantLoader");
        y8.k.e(fVar2, "packageFragmentProvider");
        y8.k.e(f0Var, "notFoundClasses");
        y8.k.e(pVar, "errorReporter");
        y8.k.e(cVar, "lookupTracker");
        y8.k.e(iVar, "contractDeserializer");
        y8.k.e(lVar, "kotlinTypeChecker");
        k9.h w10 = d0Var.w();
        m9.f fVar3 = w10 instanceof m9.f ? (m9.f) w10 : null;
        t.a aVar = t.a.f15631a;
        g gVar = g.f9305a;
        d10 = m8.q.d();
        o9.a P0 = fVar3 == null ? null : fVar3.P0();
        o9.a aVar2 = P0 == null ? a.C0266a.f12629a : P0;
        o9.c P02 = fVar3 != null ? fVar3.P0() : null;
        o9.c cVar2 = P02 == null ? c.b.f12631a : P02;
        kotlin.reflect.jvm.internal.impl.protobuf.g a10 = ka.h.f11321a.a();
        d11 = m8.q.d();
        this.f9294a = new xa.j(nVar, d0Var, kVar, fVar, bVar, fVar2, aVar, pVar, cVar, gVar, d10, f0Var, iVar, aVar2, cVar2, a10, lVar, new ta.b(nVar, d11), null, 262144, null);
    }

    public final xa.j a() {
        return this.f9294a;
    }
}
