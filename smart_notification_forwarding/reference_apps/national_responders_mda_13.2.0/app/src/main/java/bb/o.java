package bb;

import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class o {
    private static /* synthetic */ void a(int i10) {
        String str = i10 != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 4 ? 3 : 2];
        switch (i10) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i10 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i10 != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String format = String.format(str, objArr);
        if (i10 == 4) {
            throw new IllegalStateException(format);
        }
    }

    public static a1 b(List<n9.a1> list, y0 y0Var, n9.m mVar, List<n9.a1> list2) {
        if (list == null) {
            a(0);
        }
        if (y0Var == null) {
            a(1);
        }
        if (mVar == null) {
            a(2);
        }
        if (list2 == null) {
            a(3);
        }
        a1 c10 = c(list, y0Var, mVar, list2, null);
        if (c10 != null) {
            return c10;
        }
        throw new AssertionError("Substitution failed");
    }

    public static a1 c(List<n9.a1> list, y0 y0Var, n9.m mVar, List<n9.a1> list2, boolean[] zArr) {
        if (list == null) {
            a(5);
        }
        if (y0Var == null) {
            a(6);
        }
        if (mVar == null) {
            a(7);
        }
        if (list2 == null) {
            a(8);
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int i10 = 0;
        for (n9.a1 a1Var : list) {
            p9.j0 a12 = p9.j0.a1(mVar, a1Var.u(), a1Var.a0(), a1Var.v(), a1Var.c(), i10, n9.v0.f12324a, a1Var.M());
            hashMap.put(a1Var.o(), new x0(a12.s()));
            hashMap2.put(a1Var, a12);
            list2.add(a12);
            i10++;
        }
        a1 h10 = a1.h(y0Var, u0.i(hashMap));
        for (n9.a1 a1Var2 : list) {
            p9.j0 j0Var = (p9.j0) hashMap2.get(a1Var2);
            for (b0 b0Var : a1Var2.getUpperBounds()) {
                b0 p10 = h10.p(b0Var, h1.IN_VARIANCE);
                if (p10 == null) {
                    return null;
                }
                if (p10 != b0Var && zArr != null) {
                    zArr[0] = true;
                }
                j0Var.X0(p10);
            }
            j0Var.f1();
        }
        return h10;
    }
}
