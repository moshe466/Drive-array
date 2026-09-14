package r9;

import ea.u;
import java.util.List;
import m8.q;
import n9.d0;
import n9.f0;
import n9.y0;
import u9.c;
import v9.r;
import w9.f;
import xa.k;
import y9.c;

/* loaded from: classes.dex */
public final class l {
    public static final ea.d a(d0 d0Var, ab.n nVar, f0 f0Var, y9.f fVar, ea.m mVar, ea.e eVar) {
        y8.k.e(d0Var, "module");
        y8.k.e(nVar, "storageManager");
        y8.k.e(f0Var, "notFoundClasses");
        y8.k.e(fVar, "lazyJavaPackageFragmentProvider");
        y8.k.e(mVar, "reflectKotlinClassFinder");
        y8.k.e(eVar, "deserializedDescriptorResolver");
        return new ea.d(nVar, d0Var, k.a.f15605a, new ea.f(mVar, eVar), new ea.b(d0Var, f0Var, nVar, mVar), fVar, f0Var, j.f13814b, c.a.f14494a, xa.i.f15582a.a(), kotlin.reflect.jvm.internal.impl.types.checker.l.f11584b.a());
    }

    public static final y9.f b(ClassLoader classLoader, d0 d0Var, ab.n nVar, f0 f0Var, ea.m mVar, ea.e eVar, y9.i iVar, u uVar) {
        List d10;
        y8.k.e(classLoader, "classLoader");
        y8.k.e(d0Var, "module");
        y8.k.e(nVar, "storageManager");
        y8.k.e(f0Var, "notFoundClasses");
        y8.k.e(mVar, "reflectKotlinClassFinder");
        y8.k.e(eVar, "deserializedDescriptorResolver");
        y8.k.e(iVar, "singleModuleClassResolver");
        y8.k.e(uVar, "packagePartProvider");
        jb.e eVar2 = jb.e.f11068j;
        v9.c cVar = new v9.c(nVar, eVar2);
        d dVar = new d(classLoader);
        w9.j jVar = w9.j.f15331a;
        y8.k.d(jVar, "DO_NOTHING");
        j jVar2 = j.f13814b;
        w9.g gVar = w9.g.f15324a;
        y8.k.d(gVar, "EMPTY");
        f.a aVar = f.a.f15323a;
        d10 = q.d();
        ta.b bVar = new ta.b(nVar, d10);
        m mVar2 = m.f13818a;
        y0.a aVar2 = y0.a.f12328a;
        c.a aVar3 = c.a.f14494a;
        k9.j jVar3 = new k9.j(d0Var, f0Var);
        c.a aVar4 = c.a.f15980a;
        return new y9.f(new y9.b(nVar, dVar, mVar, eVar, jVar, jVar2, gVar, aVar, bVar, mVar2, iVar, uVar, aVar2, aVar3, d0Var, jVar3, cVar, new da.l(cVar, eVar2, new da.d(aVar4)), r.a.f14801a, aVar4, kotlin.reflect.jvm.internal.impl.types.checker.l.f11584b.a(), eVar2));
    }
}
