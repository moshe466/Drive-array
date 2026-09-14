package k9;

import java.util.Set;
import m8.y;

/* loaded from: classes.dex */
public final class d {
    public static final boolean a(c cVar, n9.e eVar) {
        boolean B;
        y8.k.e(cVar, "<this>");
        y8.k.e(eVar, "classDescriptor");
        if (na.d.x(eVar)) {
            Set<la.a> b10 = cVar.b();
            la.a h10 = ra.a.h(eVar);
            B = y.B(b10, h10 == null ? null : h10.g());
            if (B) {
                return true;
            }
        }
        return false;
    }
}
