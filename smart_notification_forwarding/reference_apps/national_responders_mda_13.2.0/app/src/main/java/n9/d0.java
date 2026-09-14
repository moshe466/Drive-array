package n9;

import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public interface d0 extends m {

    /* loaded from: classes.dex */
    public static final class a {
        public static <R, D> R a(d0 d0Var, o<R, D> oVar, D d10) {
            y8.k.e(d0Var, "this");
            y8.k.e(oVar, "visitor");
            return oVar.g(d0Var, d10);
        }

        public static m b(d0 d0Var) {
            y8.k.e(d0Var, "this");
            return null;
        }
    }

    l0 C(la.b bVar);

    <T> T Q0(c0<T> c0Var);

    boolean V(d0 d0Var);

    List<d0> i0();

    k9.h w();

    Collection<la.b> z(la.b bVar, x8.l<? super la.e, Boolean> lVar);
}
