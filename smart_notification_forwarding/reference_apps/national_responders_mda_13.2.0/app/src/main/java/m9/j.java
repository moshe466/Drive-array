package m9;

import bb.i0;
import bb.u0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m8.l0;
import m8.r;
import m8.y;
import n9.a1;
import y8.k;

/* loaded from: classes.dex */
public final class j {
    public static final u0 a(n9.e eVar, n9.e eVar2) {
        int n10;
        int n11;
        List u02;
        Map p10;
        k.e(eVar, "from");
        k.e(eVar2, "to");
        eVar.B().size();
        eVar2.B().size();
        u0.a aVar = u0.f4270b;
        List<a1> B = eVar.B();
        k.d(B, "from.declaredTypeParameters");
        n10 = r.n(B, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = B.iterator();
        while (it.hasNext()) {
            arrayList.add(((a1) it.next()).o());
        }
        List<a1> B2 = eVar2.B();
        k.d(B2, "to.declaredTypeParameters");
        n11 = r.n(B2, 10);
        ArrayList arrayList2 = new ArrayList(n11);
        Iterator<T> it2 = B2.iterator();
        while (it2.hasNext()) {
            i0 s10 = ((a1) it2.next()).s();
            k.d(s10, "it.defaultType");
            arrayList2.add(eb.a.a(s10));
        }
        u02 = y.u0(arrayList, arrayList2);
        p10 = l0.p(u02);
        return u0.a.e(aVar, p10, false, 2, null);
    }
}
