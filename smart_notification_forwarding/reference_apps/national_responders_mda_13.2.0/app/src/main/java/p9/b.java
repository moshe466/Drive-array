package p9;

import bb.h1;
import n9.v0;
import n9.y0;

/* loaded from: classes.dex */
public abstract class b extends e {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ab.n nVar, n9.m mVar, la.e eVar, h1 h1Var, boolean z10, int i10, v0 v0Var, y0 y0Var) {
        super(nVar, mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), eVar, h1Var, z10, i10, v0Var, y0Var);
        if (nVar == null) {
            e0(0);
        }
        if (mVar == null) {
            e0(1);
        }
        if (eVar == null) {
            e0(2);
        }
        if (h1Var == null) {
            e0(3);
        }
        if (v0Var == null) {
            e0(4);
        }
        if (y0Var == null) {
            e0(5);
        }
    }

    private static /* synthetic */ void e0(int i10) {
        Object[] objArr = new Object[3];
        if (i10 == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i10 == 2) {
            objArr[0] = "name";
        } else if (i10 == 3) {
            objArr[0] = "variance";
        } else if (i10 == 4) {
            objArr[0] = "source";
        } else if (i10 != 5) {
            objArr[0] = "storageManager";
        } else {
            objArr[0] = "supertypeLoopChecker";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // p9.j
    public String toString() {
        Object[] objArr = new Object[3];
        String str = "";
        objArr[0] = a0() ? "reified " : "";
        if (v() != h1.INVARIANT) {
            str = v() + " ";
        }
        objArr[1] = str;
        objArr[2] = c();
        return String.format("%s%s%s", objArr);
    }
}
