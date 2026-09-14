package ca;

import java.util.Iterator;

/* loaded from: classes.dex */
public interface d0 extends d {

    /* loaded from: classes.dex */
    public static final class a {
        public static ca.a a(d0 d0Var, la.b bVar) {
            Object obj;
            y8.k.e(d0Var, "this");
            y8.k.e(bVar, "fqName");
            Iterator<T> it = d0Var.u().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                la.a d10 = ((ca.a) next).d();
                if (y8.k.a(d10 != null ? d10.b() : null, bVar)) {
                    obj = next;
                    break;
                }
            }
            return (ca.a) obj;
        }
    }
}
