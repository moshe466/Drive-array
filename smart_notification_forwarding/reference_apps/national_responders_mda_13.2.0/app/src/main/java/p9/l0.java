package p9;

import java.util.Collections;
import java.util.List;
import n9.a1;
import n9.d1;
import n9.e1;
import n9.s0;
import n9.v0;

/* loaded from: classes.dex */
public abstract class l0 extends k implements e1 {

    /* renamed from: j, reason: collision with root package name */
    protected bb.b0 f13228j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(n9.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, la.e eVar, bb.b0 b0Var, v0 v0Var) {
        super(mVar, gVar, eVar, v0Var);
        if (mVar == null) {
            e0(0);
        }
        if (gVar == null) {
            e0(1);
        }
        if (eVar == null) {
            e0(2);
        }
        if (v0Var == null) {
            e0(3);
        }
        this.f13228j = b0Var;
    }

    private static /* synthetic */ void e0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public s0 K() {
        return null;
    }

    public s0 U() {
        return null;
    }

    public void U0(bb.b0 b0Var) {
        this.f13228j = b0Var;
    }

    @Override // n9.c1
    public bb.b0 b() {
        bb.b0 b0Var = this.f13228j;
        if (b0Var == null) {
            e0(4);
        }
        return b0Var;
    }

    @Override // n9.a
    public boolean c0() {
        return false;
    }

    public bb.b0 i() {
        bb.b0 b10 = b();
        if (b10 == null) {
            e0(9);
        }
        return b10;
    }

    @Override // n9.a
    public List<d1> l() {
        List<d1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            e0(6);
        }
        return emptyList;
    }

    public List<a1> m() {
        List<a1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            e0(8);
        }
        return emptyList;
    }
}
