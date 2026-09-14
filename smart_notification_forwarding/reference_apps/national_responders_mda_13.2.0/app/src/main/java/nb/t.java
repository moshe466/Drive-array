package nb;

/* loaded from: classes.dex */
public final class t {
    public static final String a(p8.f fVar) {
        a0 a0Var;
        String c10;
        if (!d0.b() || (a0Var = (a0) fVar.get(a0.f12359g)) == null) {
            return null;
        }
        b0 b0Var = (b0) fVar.get(b0.f12363g);
        String str = "coroutine";
        if (b0Var != null && (c10 = b0Var.c()) != null) {
            str = c10;
        }
        return str + '#' + a0Var.c();
    }

    public static final q1<?> b(r8.d dVar) {
        while (!(dVar instanceof j0) && (dVar = dVar.a()) != null) {
            if (dVar instanceof q1) {
                return (q1) dVar;
            }
        }
        return null;
    }

    public static final q1<?> c(p8.d<?> dVar, p8.f fVar, Object obj) {
        if (!(dVar instanceof r8.d)) {
            return null;
        }
        if (!(fVar.get(r1.f12425f) != null)) {
            return null;
        }
        q1<?> b10 = b((r8.d) dVar);
        if (b10 != null) {
            b10.o0(fVar, obj);
        }
        return b10;
    }
}
