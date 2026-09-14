package bb;

import java.util.List;

/* loaded from: classes.dex */
public final class z0 {
    public static final i0 a(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        g1 Z0 = b0Var.Z0();
        i0 i0Var = Z0 instanceof i0 ? (i0) Z0 : null;
        if (i0Var != null) {
            return i0Var;
        }
        throw new IllegalStateException(y8.k.j("This is should be simple type: ", b0Var).toString());
    }

    public static final b0 b(b0 b0Var, List<? extends v0> list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        y8.k.e(b0Var, "<this>");
        y8.k.e(list, "newArguments");
        y8.k.e(gVar, "newAnnotations");
        return e(b0Var, list, gVar, null, 4, null);
    }

    public static final b0 c(b0 b0Var, List<? extends v0> list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, List<? extends v0> list2) {
        y8.k.e(b0Var, "<this>");
        y8.k.e(list, "newArguments");
        y8.k.e(gVar, "newAnnotations");
        y8.k.e(list2, "newArgumentsForUpperBound");
        if ((list.isEmpty() || list == b0Var.V0()) && gVar == b0Var.u()) {
            return b0Var;
        }
        g1 Z0 = b0Var.Z0();
        if (Z0 instanceof v) {
            c0 c0Var = c0.f4165a;
            v vVar = (v) Z0;
            return c0.d(d(vVar.e1(), list, gVar), d(vVar.f1(), list2, gVar));
        }
        if (Z0 instanceof i0) {
            return d((i0) Z0, list, gVar);
        }
        throw new l8.l();
    }

    public static final i0 d(i0 i0Var, List<? extends v0> list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        y8.k.e(i0Var, "<this>");
        y8.k.e(list, "newArguments");
        y8.k.e(gVar, "newAnnotations");
        if (list.isEmpty() && gVar == i0Var.u()) {
            return i0Var;
        }
        if (list.isEmpty()) {
            return i0Var.c1(gVar);
        }
        c0 c0Var = c0.f4165a;
        return c0.i(gVar, i0Var.W0(), list, i0Var.X0(), null, 16, null);
    }

    public static /* synthetic */ b0 e(b0 b0Var, List list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = b0Var.V0();
        }
        if ((i10 & 2) != 0) {
            gVar = b0Var.u();
        }
        if ((i10 & 4) != 0) {
            list2 = list;
        }
        return c(b0Var, list, gVar, list2);
    }

    public static /* synthetic */ i0 f(i0 i0Var, List list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = i0Var.V0();
        }
        if ((i10 & 2) != 0) {
            gVar = i0Var.u();
        }
        return d(i0Var, list, gVar);
    }
}
