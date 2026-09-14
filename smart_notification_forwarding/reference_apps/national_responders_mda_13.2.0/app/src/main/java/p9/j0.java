package p9;

import bb.h1;
import java.util.ArrayList;
import java.util.List;
import n9.a1;
import n9.v0;
import n9.y0;

/* loaded from: classes.dex */
public class j0 extends e {

    /* renamed from: p, reason: collision with root package name */
    private final x8.l<bb.b0, Void> f13214p;

    /* renamed from: q, reason: collision with root package name */
    private final List<bb.b0> f13215q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f13216r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private j0(n9.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, h1 h1Var, la.e eVar, int i10, v0 v0Var, x8.l<bb.b0, Void> lVar, y0 y0Var, ab.n nVar) {
        super(nVar, mVar, gVar, eVar, h1Var, z10, i10, v0Var, y0Var);
        if (mVar == null) {
            e0(19);
        }
        if (gVar == null) {
            e0(20);
        }
        if (h1Var == null) {
            e0(21);
        }
        if (eVar == null) {
            e0(22);
        }
        if (v0Var == null) {
            e0(23);
        }
        if (y0Var == null) {
            e0(24);
        }
        if (nVar == null) {
            e0(25);
        }
        this.f13215q = new ArrayList(1);
        this.f13216r = false;
        this.f13214p = lVar;
    }

    private void Y0() {
        if (this.f13216r) {
            return;
        }
        throw new IllegalStateException("Type parameter descriptor is not initialized: " + e1());
    }

    private void Z0() {
        if (this.f13216r) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: " + e1());
        }
    }

    public static j0 a1(n9.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, h1 h1Var, la.e eVar, int i10, v0 v0Var, ab.n nVar) {
        if (mVar == null) {
            e0(6);
        }
        if (gVar == null) {
            e0(7);
        }
        if (h1Var == null) {
            e0(8);
        }
        if (eVar == null) {
            e0(9);
        }
        if (v0Var == null) {
            e0(10);
        }
        if (nVar == null) {
            e0(11);
        }
        return b1(mVar, gVar, z10, h1Var, eVar, i10, v0Var, null, y0.a.f12328a, nVar);
    }

    public static j0 b1(n9.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, h1 h1Var, la.e eVar, int i10, v0 v0Var, x8.l<bb.b0, Void> lVar, y0 y0Var, ab.n nVar) {
        if (mVar == null) {
            e0(12);
        }
        if (gVar == null) {
            e0(13);
        }
        if (h1Var == null) {
            e0(14);
        }
        if (eVar == null) {
            e0(15);
        }
        if (v0Var == null) {
            e0(16);
        }
        if (y0Var == null) {
            e0(17);
        }
        if (nVar == null) {
            e0(18);
        }
        return new j0(mVar, gVar, z10, h1Var, eVar, i10, v0Var, lVar, y0Var, nVar);
    }

    public static a1 c1(n9.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, h1 h1Var, la.e eVar, int i10, ab.n nVar) {
        if (mVar == null) {
            e0(0);
        }
        if (gVar == null) {
            e0(1);
        }
        if (h1Var == null) {
            e0(2);
        }
        if (eVar == null) {
            e0(3);
        }
        if (nVar == null) {
            e0(4);
        }
        j0 a12 = a1(mVar, gVar, z10, h1Var, eVar, i10, v0.f12324a, nVar);
        a12.X0(ra.a.g(mVar).y());
        a12.f1();
        return a12;
    }

    private void d1(bb.b0 b0Var) {
        if (bb.d0.a(b0Var)) {
            return;
        }
        this.f13215q.add(b0Var);
    }

    private static /* synthetic */ void e0(int i10) {
        String str = (i10 == 5 || i10 == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 5 || i10 == 28) ? 2 : 3];
        switch (i10) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        if (i10 == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i10 != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i10) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String format = String.format(str, objArr);
        if (i10 != 5 && i10 != 28) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    private String e1() {
        return c() + " declared in " + na.d.m(d());
    }

    @Override // p9.e
    protected void V0(bb.b0 b0Var) {
        if (b0Var == null) {
            e0(27);
        }
        x8.l<bb.b0, Void> lVar = this.f13214p;
        if (lVar == null) {
            return;
        }
        lVar.h(b0Var);
    }

    @Override // p9.e
    protected List<bb.b0> W0() {
        Y0();
        List<bb.b0> list = this.f13215q;
        if (list == null) {
            e0(28);
        }
        return list;
    }

    public void X0(bb.b0 b0Var) {
        if (b0Var == null) {
            e0(26);
        }
        Z0();
        d1(b0Var);
    }

    public void f1() {
        Z0();
        this.f13216r = true;
    }
}
