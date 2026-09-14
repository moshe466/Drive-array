package m9;

import ab.n;
import ea.m;
import java.io.InputStream;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.checker.l;
import n9.d0;
import n9.f0;
import u9.c;
import xa.k;
import xa.p;
import xa.q;
import xa.t;

/* loaded from: classes.dex */
public final class h extends xa.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(n nVar, m mVar, d0 d0Var, f0 f0Var, o9.a aVar, o9.c cVar, k kVar, l lVar, ta.a aVar2) {
        super(nVar, mVar, d0Var);
        List g10;
        y8.k.e(nVar, "storageManager");
        y8.k.e(mVar, "finder");
        y8.k.e(d0Var, "moduleDescriptor");
        y8.k.e(f0Var, "notFoundClasses");
        y8.k.e(aVar, "additionalClassPartsProvider");
        y8.k.e(cVar, "platformDependentDeclarationFilter");
        y8.k.e(kVar, "deserializationConfiguration");
        y8.k.e(lVar, "kotlinTypeChecker");
        y8.k.e(aVar2, "samConversionResolver");
        xa.m mVar2 = new xa.m(this);
        ya.a aVar3 = ya.a.f16003m;
        xa.d dVar = new xa.d(d0Var, f0Var, aVar3);
        t.a aVar4 = t.a.f15631a;
        p pVar = p.f15625a;
        y8.k.d(pVar, "DO_NOTHING");
        c.a aVar5 = c.a.f14494a;
        q.a aVar6 = q.a.f15626a;
        g10 = m8.q.g(new l9.a(nVar, d0Var), new e(nVar, d0Var, null, 4, null));
        h(new xa.j(nVar, d0Var, kVar, mVar2, dVar, this, aVar4, pVar, aVar5, aVar6, g10, f0Var, xa.i.f15582a.a(), aVar, cVar, aVar3.e(), lVar, aVar2, null, 262144, null));
    }

    @Override // xa.a
    protected xa.n c(la.b bVar) {
        y8.k.e(bVar, "fqName");
        InputStream b10 = e().b(bVar);
        if (b10 == null) {
            return null;
        }
        return ya.c.f16005r.a(bVar, g(), f(), b10, false);
    }
}
