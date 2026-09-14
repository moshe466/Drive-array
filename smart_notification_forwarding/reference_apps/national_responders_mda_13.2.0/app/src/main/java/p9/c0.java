package p9;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import n9.b;
import n9.d1;
import n9.o0;
import n9.p0;
import n9.q0;
import n9.v0;

/* loaded from: classes.dex */
public class c0 extends a0 implements q0 {

    /* renamed from: r, reason: collision with root package name */
    private bb.b0 f13173r;

    /* renamed from: s, reason: collision with root package name */
    private final q0 f13174s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c0(p0 p0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, n9.a0 a0Var, n9.u uVar, boolean z10, boolean z11, boolean z12, b.a aVar, q0 q0Var, v0 v0Var) {
        super(a0Var, uVar, p0Var, gVar, la.e.u("<get-" + p0Var.c() + ">"), z10, z11, z12, aVar, v0Var);
        c0 c0Var;
        c0 c0Var2;
        if (p0Var == null) {
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
        if (aVar == null) {
            e0(4);
        }
        if (v0Var == null) {
            e0(5);
        }
        if (q0Var != 0) {
            c0Var2 = this;
            c0Var = q0Var;
        } else {
            c0Var = this;
            c0Var2 = c0Var;
        }
        c0Var2.f13174s = c0Var;
    }

    private static /* synthetic */ void e0(int i10) {
        String str = (i10 == 6 || i10 == 7 || i10 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 6 || i10 == 7 || i10 == 8) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i10 == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i10 == 7) {
            objArr[1] = "getValueParameters";
        } else if (i10 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i10 != 6 && i10 != 7 && i10 != 8) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i10 != 6 && i10 != 7 && i10 != 8) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // n9.m
    public <R, D> R J0(n9.o<R, D> oVar, D d10) {
        return oVar.k(this, d10);
    }

    @Override // p9.a0, p9.k, p9.j, n9.m
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public q0 a() {
        q0 q0Var = this.f13174s;
        if (q0Var == null) {
            e0(8);
        }
        return q0Var;
    }

    public void b1(bb.b0 b0Var) {
        if (b0Var == null) {
            b0Var = y0().b();
        }
        this.f13173r = b0Var;
    }

    @Override // n9.x, n9.b, n9.a
    public Collection<? extends q0> g() {
        Collection<o0> W0 = super.W0(true);
        if (W0 == null) {
            e0(6);
        }
        return W0;
    }

    @Override // n9.a
    public bb.b0 i() {
        return this.f13173r;
    }

    @Override // n9.a
    public List<d1> l() {
        List<d1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            e0(7);
        }
        return emptyList;
    }
}
