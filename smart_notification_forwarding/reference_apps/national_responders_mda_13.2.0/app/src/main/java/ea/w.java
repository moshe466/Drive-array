package ea;

import bb.b0;
import java.util.Collection;

/* loaded from: classes.dex */
public interface w<T> {

    /* loaded from: classes.dex */
    public static final class a {
        public static <T> String a(w<? extends T> wVar, n9.e eVar) {
            y8.k.e(wVar, "this");
            y8.k.e(eVar, "classDescriptor");
            return null;
        }

        public static <T> b0 b(w<? extends T> wVar, b0 b0Var) {
            y8.k.e(wVar, "this");
            y8.k.e(b0Var, "kotlinType");
            return null;
        }

        public static <T> boolean c(w<? extends T> wVar) {
            y8.k.e(wVar, "this");
            return true;
        }
    }

    b0 a(b0 b0Var);

    boolean b();

    String c(n9.e eVar);

    String d(n9.e eVar);

    void e(b0 b0Var, n9.e eVar);

    T f(n9.e eVar);

    b0 g(Collection<b0> collection);
}
