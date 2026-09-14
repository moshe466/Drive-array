package gb;

import n9.x;

/* loaded from: classes.dex */
public interface b {

    /* loaded from: classes.dex */
    public static final class a {
        public static String a(b bVar, x xVar) {
            y8.k.e(bVar, "this");
            y8.k.e(xVar, "functionDescriptor");
            if (bVar.b(xVar)) {
                return null;
            }
            return bVar.a();
        }
    }

    String a();

    boolean b(x xVar);

    String c(x xVar);
}
