package p9;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import n9.a;
import n9.a1;
import n9.b;
import n9.d1;
import n9.s0;
import n9.u0;
import n9.v0;
import n9.x;

/* loaded from: classes.dex */
public class f0 extends p implements u0 {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(n9.m mVar, u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, la.e eVar, b.a aVar, v0 v0Var) {
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
    }

    private static /* synthetic */ void e0(int i10) {
        String str = (i10 == 13 || i10 == 17 || i10 == 18 || i10 == 23 || i10 == 24) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 13 || i10 == 17 || i10 == 18 || i10 == 23 || i10 == 24) ? 2 : 3];
        switch (i10) {
            case 1:
            case 6:
            case 21:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 8:
            case 20:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 22:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 15:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 16:
                objArr[0] = "visibility";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 19:
                objArr[0] = "newOwner";
                break;
        }
        if (i10 == 13 || i10 == 17) {
            objArr[1] = "initialize";
        } else if (i10 == 18) {
            objArr[1] = "getOriginal";
        } else if (i10 == 23) {
            objArr[1] = "copy";
        } else if (i10 != 24) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i10) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
                objArr[2] = "initialize";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                break;
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i10 != 13 && i10 != 17 && i10 != 18 && i10 != 23 && i10 != 24) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public static f0 w1(n9.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, la.e eVar, b.a aVar, v0 v0Var) {
        if (mVar == null) {
            e0(5);
        }
        if (gVar == null) {
            e0(6);
        }
        if (eVar == null) {
            e0(7);
        }
        if (aVar == null) {
            e0(8);
        }
        if (v0Var == null) {
            e0(9);
        }
        return new f0(mVar, null, gVar, eVar, aVar, v0Var);
    }

    @Override // p9.p
    protected p W0(n9.m mVar, n9.x xVar, b.a aVar, la.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, v0 v0Var) {
        if (mVar == null) {
            e0(19);
        }
        if (aVar == null) {
            e0(20);
        }
        if (gVar == null) {
            e0(21);
        }
        if (v0Var == null) {
            e0(22);
        }
        u0 u0Var = (u0) xVar;
        if (eVar == null) {
            eVar = c();
        }
        return new f0(mVar, u0Var, gVar, eVar, aVar, v0Var);
    }

    @Override // p9.p
    /* renamed from: v1, reason: merged with bridge method [inline-methods] */
    public u0 V0(n9.m mVar, n9.a0 a0Var, n9.u uVar, b.a aVar, boolean z10) {
        u0 u0Var = (u0) super.V0(mVar, a0Var, uVar, aVar, z10);
        if (u0Var == null) {
            e0(23);
        }
        return u0Var;
    }

    @Override // p9.p, p9.k, p9.j, n9.m
    /* renamed from: x1, reason: merged with bridge method [inline-methods] */
    public u0 a() {
        u0 u0Var = (u0) super.a();
        if (u0Var == null) {
            e0(18);
        }
        return u0Var;
    }

    @Override // p9.p, n9.x, n9.u0
    public x.a<? extends u0> y() {
        x.a y10 = super.y();
        if (y10 == null) {
            e0(24);
        }
        return y10;
    }

    @Override // p9.p
    /* renamed from: y1, reason: merged with bridge method [inline-methods] */
    public f0 c1(s0 s0Var, s0 s0Var2, List<? extends a1> list, List<d1> list2, bb.b0 b0Var, n9.a0 a0Var, n9.u uVar) {
        if (list == null) {
            e0(10);
        }
        if (list2 == null) {
            e0(11);
        }
        if (uVar == null) {
            e0(12);
        }
        f0 z12 = z1(s0Var, s0Var2, list, list2, b0Var, a0Var, uVar, null);
        if (z12 == null) {
            e0(13);
        }
        return z12;
    }

    public f0 z1(s0 s0Var, s0 s0Var2, List<? extends a1> list, List<d1> list2, bb.b0 b0Var, n9.a0 a0Var, n9.u uVar, Map<? extends a.InterfaceC0257a<?>, ?> map) {
        if (list == null) {
            e0(14);
        }
        if (list2 == null) {
            e0(15);
        }
        if (uVar == null) {
            e0(16);
        }
        super.c1(s0Var, s0Var2, list, list2, b0Var, a0Var, uVar);
        if (map != null && !map.isEmpty()) {
            this.H = new LinkedHashMap(map);
        }
        return this;
    }
}
