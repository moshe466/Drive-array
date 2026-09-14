package x9;

import bb.b0;
import java.util.List;
import l8.n;
import n9.a;
import n9.b;
import n9.m;
import n9.v0;
import n9.x;

/* loaded from: classes.dex */
public class c extends p9.f implements b {
    private Boolean K;
    private Boolean L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected c(n9.e eVar, c cVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, b.a aVar, v0 v0Var) {
        super(eVar, cVar, gVar, z10, aVar, v0Var);
        if (eVar == null) {
            e0(0);
        }
        if (gVar == null) {
            e0(1);
        }
        if (aVar == null) {
            e0(2);
        }
        if (v0Var == null) {
            e0(3);
        }
        this.K = null;
        this.L = null;
    }

    public static c D1(n9.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, v0 v0Var) {
        if (eVar == null) {
            e0(4);
        }
        if (gVar == null) {
            e0(5);
        }
        if (v0Var == null) {
            e0(6);
        }
        return new c(eVar, null, gVar, z10, b.a.DECLARATION, v0Var);
    }

    private static /* synthetic */ void e0(int i10) {
        String str = (i10 == 11 || i10 == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 11 || i10 == 18) ? 2 : 3];
        switch (i10) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i10 == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i10 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i10 != 11 && i10 != 18) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    protected c C1(n9.e eVar, c cVar, b.a aVar, v0 v0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (eVar == null) {
            e0(12);
        }
        if (aVar == null) {
            e0(13);
        }
        if (v0Var == null) {
            e0(14);
        }
        if (gVar == null) {
            e0(15);
        }
        return new c(eVar, cVar, gVar, this.I, aVar, v0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p9.f
    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    public c W0(m mVar, x xVar, b.a aVar, la.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, v0 v0Var) {
        if (mVar == null) {
            e0(7);
        }
        if (aVar == null) {
            e0(8);
        }
        if (gVar == null) {
            e0(9);
        }
        if (v0Var == null) {
            e0(10);
        }
        if (aVar == b.a.DECLARATION || aVar == b.a.SYNTHESIZED) {
            c C1 = C1((n9.e) mVar, (c) xVar, aVar, v0Var, gVar);
            C1.j1(b1());
            C1.k1(c0());
            return C1;
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + mVar + "\nkind: " + aVar);
    }

    @Override // x9.b
    /* renamed from: F1, reason: merged with bridge method [inline-methods] */
    public c K0(b0 b0Var, List<l> list, b0 b0Var2, n<a.InterfaceC0257a<?>, ?> nVar) {
        if (list == null) {
            e0(16);
        }
        if (b0Var2 == null) {
            e0(17);
        }
        c W0 = W0(d(), null, r(), null, u(), k());
        W0.c1(b0Var == null ? null : na.c.f(W0, b0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b()), K(), m(), k.a(list, l(), W0), b0Var2, p(), h());
        if (nVar != null) {
            W0.f1(nVar.c(), nVar.d());
        }
        return W0;
    }

    @Override // p9.p
    public boolean b1() {
        return this.K.booleanValue();
    }

    @Override // p9.p, n9.a
    public boolean c0() {
        return this.L.booleanValue();
    }

    @Override // p9.p
    public void j1(boolean z10) {
        this.K = Boolean.valueOf(z10);
    }

    @Override // p9.p
    public void k1(boolean z10) {
        this.L = Boolean.valueOf(z10);
    }
}
