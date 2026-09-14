package na;

import java.util.Collection;
import n9.t;

/* loaded from: classes.dex */
public final class o {
    public static final n9.b a(Collection<? extends n9.b> collection) {
        Integer d10;
        y8.k.e(collection, "descriptors");
        collection.isEmpty();
        n9.b bVar = null;
        for (n9.b bVar2 : collection) {
            if (bVar == null || ((d10 = t.d(bVar.h(), bVar2.h())) != null && d10.intValue() < 0)) {
                bVar = bVar2;
            }
        }
        y8.k.b(bVar);
        return bVar;
    }
}
