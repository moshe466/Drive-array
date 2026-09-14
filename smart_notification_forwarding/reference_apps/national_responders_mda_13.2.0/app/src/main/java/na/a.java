package na;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import m8.q;
import n9.a0;
import n9.g0;
import ua.k;

/* loaded from: classes.dex */
public final class a extends n {

    /* renamed from: a, reason: collision with root package name */
    public static final a f12329a = new a();

    private a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void b(n9.e eVar, LinkedHashSet<n9.e> linkedHashSet, ua.h hVar, boolean z10) {
        for (n9.m mVar : k.a.a(hVar, ua.d.f14519q, null, 2, null)) {
            if (mVar instanceof n9.e) {
                n9.e eVar2 = (n9.e) mVar;
                if (d.z(eVar2, eVar)) {
                    linkedHashSet.add(mVar);
                }
                if (z10) {
                    ua.h u02 = eVar2.u0();
                    y8.k.d(u02, "descriptor.unsubstitutedInnerClassesScope");
                    b(eVar, linkedHashSet, u02, z10);
                }
            }
        }
    }

    public Collection<n9.e> a(n9.e eVar, boolean z10) {
        n9.m mVar;
        n9.m mVar2;
        List d10;
        y8.k.e(eVar, "sealedClass");
        if (eVar.p() != a0.SEALED) {
            d10 = q.d();
            return d10;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z10) {
            Iterator<n9.m> it = ra.a.m(eVar).iterator();
            while (true) {
                if (!it.hasNext()) {
                    mVar = null;
                    break;
                }
                mVar = it.next();
                if (mVar instanceof g0) {
                    break;
                }
            }
            mVar2 = mVar;
        } else {
            mVar2 = eVar.d();
        }
        if (mVar2 instanceof g0) {
            b(eVar, linkedHashSet, ((g0) mVar2).A(), z10);
        }
        ua.h u02 = eVar.u0();
        y8.k.d(u02, "sealedClass.unsubstitutedInnerClassesScope");
        b(eVar, linkedHashSet, u02, true);
        return linkedHashSet;
    }
}
