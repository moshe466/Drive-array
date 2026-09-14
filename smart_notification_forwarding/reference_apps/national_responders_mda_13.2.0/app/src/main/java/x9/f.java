package x9;

import bb.b0;
import java.util.List;
import java.util.Map;
import l8.n;
import n9.a;
import n9.a0;
import n9.a1;
import n9.b;
import n9.d1;
import n9.m;
import n9.s0;
import n9.u;
import n9.u0;
import n9.v0;
import n9.x;
import p9.f0;

/* loaded from: classes.dex */
public class f extends f0 implements x9.b {
    public static final a.InterfaceC0257a<d1> K = new a();
    private b I;
    private final boolean J;

    /* loaded from: classes.dex */
    static class a implements a.InterfaceC0257a<d1> {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum b {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);

        public final boolean isStable;
        public final boolean isSynthesized;

        private static /* synthetic */ void $$$reportNull$$$0(int i10) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get"));
        }

        b(boolean z10, boolean z11) {
            this.isStable = z10;
            this.isSynthesized = z11;
        }

        public static b get(boolean z10, boolean z11) {
            b bVar = z10 ? z11 ? STABLE_SYNTHESIZED : STABLE_DECLARED : z11 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
            if (bVar == null) {
                $$$reportNull$$$0(0);
            }
            return bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected f(m mVar, u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, la.e eVar, b.a aVar, v0 v0Var, boolean z10) {
        super(mVar, u0Var, gVar, eVar, aVar, v0Var);
        if (mVar == null) {
            e0(0);
        }
        if (gVar == null) {
            e0(1);
        }
        if (eVar == null) {
            e0(2);
        }
        if (aVar == null) {
            e0(3);
        }
        if (v0Var == null) {
            e0(4);
        }
        this.I = null;
        this.J = z10;
    }

    public static f A1(m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, la.e eVar, v0 v0Var, boolean z10) {
        if (mVar == null) {
            e0(5);
        }
        if (gVar == null) {
            e0(6);
        }
        if (eVar == null) {
            e0(7);
        }
        if (v0Var == null) {
            e0(8);
        }
        return new f(mVar, null, gVar, eVar, b.a.DECLARATION, v0Var, z10);
    }

    private static /* synthetic */ void e0(int i10) {
        String str = (i10 == 12 || i10 == 17 || i10 == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 12 || i10 == 17 || i10 == 20) ? 2 : 3];
        switch (i10) {
            case 1:
            case 6:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 14:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 16:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "typeParameters";
                break;
            case 10:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
                objArr[0] = "visibility";
                break;
            case 12:
            case 17:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 18:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 19:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i10 == 12) {
            objArr[1] = "initialize";
        } else if (i10 == 17) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i10 != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i10) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
                objArr[2] = "initialize";
                break;
            case 12:
            case 17:
            case 20:
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 18:
            case 19:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i10 != 12 && i10 != 17 && i10 != 20) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p9.f0, p9.p
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public f W0(m mVar, x xVar, b.a aVar, la.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, v0 v0Var) {
        if (mVar == null) {
            e0(13);
        }
        if (aVar == null) {
            e0(14);
        }
        if (gVar == null) {
            e0(15);
        }
        if (v0Var == null) {
            e0(16);
        }
        u0 u0Var = (u0) xVar;
        if (eVar == null) {
            eVar = c();
        }
        f fVar = new f(mVar, u0Var, gVar, eVar, aVar, v0Var, this.J);
        fVar.D1(b1(), c0());
        return fVar;
    }

    @Override // x9.b
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public f K0(b0 b0Var, List<l> list, b0 b0Var2, n<a.InterfaceC0257a<?>, ?> nVar) {
        if (list == null) {
            e0(18);
        }
        if (b0Var2 == null) {
            e0(19);
        }
        f fVar = (f) y().f(k.a(list, l(), this)).k(b0Var2).p(b0Var == null ? null : na.c.f(this, b0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b())).a().n().c();
        if (nVar != null) {
            fVar.f1(nVar.c(), nVar.d());
        }
        if (fVar == null) {
            e0(20);
        }
        return fVar;
    }

    public void D1(boolean z10, boolean z11) {
        this.I = b.get(z10, z11);
    }

    @Override // p9.p
    public boolean b1() {
        return this.I.isStable;
    }

    @Override // p9.p, n9.a
    public boolean c0() {
        return this.I.isSynthesized;
    }

    @Override // p9.f0
    public f0 z1(s0 s0Var, s0 s0Var2, List<? extends a1> list, List<d1> list2, b0 b0Var, a0 a0Var, u uVar, Map<? extends a.InterfaceC0257a<?>, ?> map) {
        if (list == null) {
            e0(9);
        }
        if (list2 == null) {
            e0(10);
        }
        if (uVar == null) {
            e0(11);
        }
        f0 z12 = super.z1(s0Var, s0Var2, list, list2, b0Var, a0Var, uVar, map);
        q1(gb.i.f10360a.a(z12).a());
        if (z12 == null) {
            e0(12);
        }
        return z12;
    }
}
