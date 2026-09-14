package x9;

import da.t;
import java.util.List;
import l8.n;
import n9.a;
import n9.a0;
import n9.b;
import n9.m;
import n9.p0;
import n9.r0;
import n9.u;
import n9.v0;
import p9.b0;
import p9.c0;
import p9.d0;

/* loaded from: classes.dex */
public class g extends b0 implements b {
    private final boolean F;
    private final n<a.InterfaceC0257a<?>, ?> G;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, a0 a0Var, u uVar, boolean z10, la.e eVar, v0 v0Var, p0 p0Var, b.a aVar, boolean z11, n<a.InterfaceC0257a<?>, ?> nVar) {
        super(mVar, p0Var, gVar, a0Var, uVar, z10, eVar, aVar, v0Var, false, false, false, false, false, false);
        if (mVar == null) {
            e0(0);
        }
        if (gVar == null) {
            e0(1);
        }
        if (a0Var == null) {
            e0(2);
        }
        if (uVar == null) {
            e0(3);
        }
        if (eVar == null) {
            e0(4);
        }
        if (v0Var == null) {
            e0(5);
        }
        if (aVar == null) {
            e0(6);
        }
        this.F = z11;
        this.G = nVar;
    }

    private static /* synthetic */ void e0(int i10) {
        String str = i10 != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 21 ? 3 : 2];
        switch (i10) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
        }
        if (i10 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i10 == 21) {
            throw new IllegalStateException(format);
        }
    }

    public static g m1(m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, a0 a0Var, u uVar, boolean z10, la.e eVar, v0 v0Var, boolean z11) {
        if (mVar == null) {
            e0(7);
        }
        if (gVar == null) {
            e0(8);
        }
        if (a0Var == null) {
            e0(9);
        }
        if (uVar == null) {
            e0(10);
        }
        if (eVar == null) {
            e0(11);
        }
        if (v0Var == null) {
            e0(12);
        }
        return new g(mVar, gVar, a0Var, uVar, z10, eVar, v0Var, null, b.a.DECLARATION, z11, null);
    }

    @Override // x9.b
    public b K0(bb.b0 b0Var, List<l> list, bb.b0 b0Var2, n<a.InterfaceC0257a<?>, ?> nVar) {
        c0 c0Var;
        d0 d0Var;
        if (list == null) {
            e0(19);
        }
        if (b0Var2 == null) {
            e0(20);
        }
        p0 a10 = a() == this ? null : a();
        g gVar = new g(d(), u(), p(), h(), P(), c(), k(), a10, r(), this.F, nVar);
        c0 t10 = t();
        if (t10 != null) {
            c0Var = r15;
            c0 c0Var2 = new c0(gVar, t10.u(), t10.p(), t10.h(), t10.B0(), t10.I(), t10.x(), r(), a10 == null ? null : a10.t(), t10.k());
            c0Var.Y0(t10.H());
            c0Var.b1(b0Var2);
        } else {
            c0Var = null;
        }
        r0 M0 = M0();
        if (M0 != null) {
            d0 d0Var2 = new d0(gVar, M0.u(), M0.p(), M0.h(), M0.B0(), M0.I(), M0.x(), r(), a10 == null ? null : a10.M0(), M0.k());
            d0Var2.Y0(d0Var2.H());
            d0Var2.c1(M0.l().get(0));
            d0Var = d0Var2;
        } else {
            d0Var = null;
        }
        gVar.f1(c0Var, d0Var, d0(), X());
        gVar.j1(g1());
        ab.j<pa.g<?>> jVar = this.f13230l;
        if (jVar != null) {
            gVar.V0(jVar);
        }
        gVar.r0(g());
        gVar.k1(b0Var2, m(), K(), b0Var == null ? null : na.c.f(this, b0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b()));
        return gVar;
    }

    @Override // p9.b0, n9.e1
    public boolean O() {
        bb.b0 b10 = b();
        return this.F && n9.j.a(b10) && (!t.i(b10) || k9.h.C0(b10));
    }

    @Override // p9.b0
    protected b0 Z0(m mVar, a0 a0Var, u uVar, p0 p0Var, b.a aVar, la.e eVar, v0 v0Var) {
        if (mVar == null) {
            e0(13);
        }
        if (a0Var == null) {
            e0(14);
        }
        if (uVar == null) {
            e0(15);
        }
        if (aVar == null) {
            e0(16);
        }
        if (eVar == null) {
            e0(17);
        }
        if (v0Var == null) {
            e0(18);
        }
        return new g(mVar, u(), a0Var, uVar, P(), eVar, v0Var, p0Var, aVar, this.F, this.G);
    }

    @Override // p9.l0, n9.a
    public boolean c0() {
        return false;
    }
}
