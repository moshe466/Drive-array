package bb;

/* loaded from: classes.dex */
public final class e1 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final b0 a(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        if (b0Var instanceof d1) {
            return ((d1) b0Var).e0();
        }
        return null;
    }

    public static final g1 b(g1 g1Var, b0 b0Var) {
        y8.k.e(g1Var, "<this>");
        y8.k.e(b0Var, "origin");
        return d(g1Var, a(b0Var));
    }

    public static final b0 c(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        b0 a10 = a(b0Var);
        return a10 == null ? b0Var : a10;
    }

    public static final g1 d(g1 g1Var, b0 b0Var) {
        y8.k.e(g1Var, "<this>");
        if (b0Var == null) {
            return g1Var;
        }
        if (g1Var instanceof i0) {
            return new k0((i0) g1Var, b0Var);
        }
        if (g1Var instanceof v) {
            return new x((v) g1Var, b0Var);
        }
        throw new l8.l();
    }
}
