package p9;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import n9.b;
import n9.d1;
import n9.o0;
import n9.p0;
import n9.r0;
import n9.v0;

/* loaded from: classes.dex */
public class d0 extends a0 implements r0 {

    /* renamed from: r, reason: collision with root package name */
    private d1 f13181r;

    /* renamed from: s, reason: collision with root package name */
    private final r0 f13182s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d0(p0 p0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, n9.a0 a0Var, n9.u uVar, boolean z10, boolean z11, boolean z12, b.a aVar, r0 r0Var, v0 v0Var) {
        super(a0Var, uVar, p0Var, gVar, la.e.u("<set-" + p0Var.c() + ">"), z10, z11, z12, aVar, v0Var);
        d0 d0Var;
        d0 d0Var2;
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
        if (r0Var != 0) {
            d0Var2 = this;
            d0Var = r0Var;
        } else {
            d0Var = this;
            d0Var2 = d0Var;
        }
        d0Var2.f13182s = d0Var;
    }

    public static k0 a1(r0 r0Var, bb.b0 b0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (r0Var == null) {
            e0(7);
        }
        if (b0Var == null) {
            e0(8);
        }
        if (gVar == null) {
            e0(9);
        }
        return new k0(r0Var, null, 0, gVar, la.e.u("<set-?>"), b0Var, false, false, false, null, v0.f12324a);
    }

    private static /* synthetic */ void e0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 10:
            case 11:
            case 12:
            case 13:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 9:
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
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i10) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i10) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i10) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // n9.m
    public <R, D> R J0(n9.o<R, D> oVar, D d10) {
        return oVar.b(this, d10);
    }

    @Override // p9.a0, p9.k, p9.j, n9.m
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public r0 a() {
        r0 r0Var = this.f13182s;
        if (r0Var == null) {
            e0(13);
        }
        return r0Var;
    }

    public void c1(d1 d1Var) {
        if (d1Var == null) {
            e0(6);
        }
        this.f13181r = d1Var;
    }

    @Override // n9.x, n9.b, n9.a
    public Collection<? extends r0> g() {
        Collection<o0> W0 = super.W0(false);
        if (W0 == null) {
            e0(10);
        }
        return W0;
    }

    @Override // n9.a
    public bb.b0 i() {
        bb.i0 Y = ra.a.g(this).Y();
        if (Y == null) {
            e0(12);
        }
        return Y;
    }

    @Override // n9.a
    public List<d1> l() {
        d1 d1Var = this.f13181r;
        if (d1Var == null) {
            throw new IllegalStateException();
        }
        List<d1> singletonList = Collections.singletonList(d1Var);
        if (singletonList == null) {
            e0(11);
        }
        return singletonList;
    }
}
