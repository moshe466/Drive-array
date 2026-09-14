package kotlin.reflect.jvm.internal.impl.types.checker;

import bb.b0;
import bb.c1;
import bb.h1;
import bb.t0;
import bb.u0;
import bb.v0;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class w {
    private static final b0 a(b0 b0Var) {
        return fb.b.a(b0Var).d();
    }

    private static final String b(t0 t0Var) {
        StringBuilder sb2 = new StringBuilder();
        c(y8.k.j("type: ", t0Var), sb2);
        c(y8.k.j("hashCode: ", Integer.valueOf(t0Var.hashCode())), sb2);
        c(y8.k.j("javaClass: ", t0Var.getClass().getCanonicalName()), sb2);
        for (n9.m A = t0Var.A(); A != null; A = A.d()) {
            c(y8.k.j("fqName: ", kotlin.reflect.jvm.internal.impl.renderer.c.f11499b.r(A)), sb2);
            c(y8.k.j("javaClass: ", A.getClass().getCanonicalName()), sb2);
        }
        String sb3 = sb2.toString();
        y8.k.d(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    private static final StringBuilder c(String str, StringBuilder sb2) {
        y8.k.e(str, "<this>");
        y8.k.e(sb2, "$this_anonymous");
        sb2.append(str);
        y8.k.d(sb2, "append(value)");
        sb2.append('\n');
        y8.k.d(sb2, "append('\\n')");
        return sb2;
    }

    public static final b0 d(b0 b0Var, b0 b0Var2, u uVar) {
        boolean z10;
        y8.k.e(b0Var, "subtype");
        y8.k.e(b0Var2, "supertype");
        y8.k.e(uVar, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new r(b0Var, null));
        t0 W0 = b0Var2.W0();
        while (!arrayDeque.isEmpty()) {
            r rVar = (r) arrayDeque.poll();
            b0 b10 = rVar.b();
            t0 W02 = b10.W0();
            if (uVar.a(W02, W0)) {
                boolean X0 = b10.X0();
                while (true) {
                    rVar = rVar.a();
                    if (rVar == null) {
                        break;
                    }
                    b0 b11 = rVar.b();
                    List<v0> V0 = b11.V0();
                    if (!(V0 instanceof Collection) || !V0.isEmpty()) {
                        Iterator<T> it = V0.iterator();
                        while (it.hasNext()) {
                            if (((v0) it.next()).c() != h1.INVARIANT) {
                                z10 = true;
                                break;
                            }
                        }
                    }
                    z10 = false;
                    if (z10) {
                        b0 n10 = oa.d.f(u0.f4270b.a(b11), false, 1, null).c().n(b10, h1.INVARIANT);
                        y8.k.d(n10, "TypeConstructorSubstitution.create(currentType)\n                            .wrapWithCapturingSubstitution().buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)");
                        b10 = a(n10);
                    } else {
                        b10 = u0.f4270b.a(b11).c().n(b10, h1.INVARIANT);
                        y8.k.d(b10, "{\n                    TypeConstructorSubstitution.create(currentType)\n                            .buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)\n                }");
                    }
                    X0 = X0 || b11.X0();
                }
                t0 W03 = b10.W0();
                if (uVar.a(W03, W0)) {
                    return c1.p(b10, X0);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + b(W03) + ", \n\nsupertype: " + b(W0) + " \n" + uVar.a(W03, W0));
            }
            for (b0 b0Var3 : W02.x()) {
                y8.k.d(b0Var3, "immediateSupertype");
                arrayDeque.add(new r(b0Var3, rVar));
            }
        }
        return null;
    }
}
