package gb;

import gb.c;
import java.util.List;
import n9.x;

/* loaded from: classes.dex */
public abstract class a {
    public final c a(x xVar) {
        y8.k.e(xVar, "functionDescriptor");
        for (d dVar : b()) {
            if (dVar.b(xVar)) {
                return dVar.a(xVar);
            }
        }
        return c.a.f10342b;
    }

    public abstract List<d> b();
}
