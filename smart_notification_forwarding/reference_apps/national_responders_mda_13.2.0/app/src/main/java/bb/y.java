package bb;

/* loaded from: classes.dex */
public final class y {
    public static final v a(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        return (v) b0Var.Z0();
    }

    public static final boolean b(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        return b0Var.Z0() instanceof v;
    }

    public static final i0 c(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        g1 Z0 = b0Var.Z0();
        if (Z0 instanceof v) {
            return ((v) Z0).e1();
        }
        if (Z0 instanceof i0) {
            return (i0) Z0;
        }
        throw new l8.l();
    }

    public static final i0 d(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        g1 Z0 = b0Var.Z0();
        if (Z0 instanceof v) {
            return ((v) Z0).f1();
        }
        if (Z0 instanceof i0) {
            return (i0) Z0;
        }
        throw new l8.l();
    }
}
