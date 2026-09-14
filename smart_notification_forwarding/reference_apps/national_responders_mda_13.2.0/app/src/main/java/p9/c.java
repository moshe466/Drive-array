package p9;

import bb.a1;
import bb.h1;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import n9.d1;
import n9.s0;
import n9.v0;

/* loaded from: classes.dex */
public abstract class c extends j implements s0 {

    /* renamed from: h, reason: collision with root package name */
    private static final la.e f13172h = la.e.u("<this>");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        super(gVar, f13172h);
        if (gVar == null) {
            e0(0);
        }
    }

    private static /* synthetic */ void e0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "substitutor";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i10) {
            case 2:
                objArr[1] = "getTypeParameters";
                break;
            case 3:
                objArr[1] = "getType";
                break;
            case 4:
                objArr[1] = "getValueParameters";
                break;
            case 5:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 6:
                objArr[1] = "getVisibility";
                break;
            case 7:
                objArr[1] = "getOriginal";
                break;
            case 8:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i10) {
            case 1:
                objArr[2] = "substitute";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // p9.j, n9.m
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public n9.m0 a() {
        return this;
    }

    @Override // n9.m
    public <R, D> R J0(n9.o<R, D> oVar, D d10) {
        return oVar.a(this, d10);
    }

    @Override // n9.a
    public s0 K() {
        return null;
    }

    @Override // n9.a
    public s0 U() {
        return null;
    }

    @Override // n9.c1
    public bb.b0 b() {
        bb.b0 b10 = getValue().b();
        if (b10 == null) {
            e0(3);
        }
        return b10;
    }

    @Override // n9.a
    public boolean c0() {
        return false;
    }

    @Override // n9.x0
    public s0 e(a1 a1Var) {
        bb.b0 b10;
        h1 h1Var;
        if (a1Var == null) {
            e0(1);
        }
        if (a1Var.k()) {
            return this;
        }
        if (d() instanceof n9.e) {
            b10 = b();
            h1Var = h1.OUT_VARIANCE;
        } else {
            b10 = b();
            h1Var = h1.INVARIANT;
        }
        bb.b0 p10 = a1Var.p(b10, h1Var);
        if (p10 == null) {
            return null;
        }
        return p10 == b() ? this : new e0(d(), new va.g(p10), u());
    }

    @Override // n9.a
    public Collection<? extends n9.a> g() {
        Set emptySet = Collections.emptySet();
        if (emptySet == null) {
            e0(5);
        }
        return emptySet;
    }

    @Override // n9.q, n9.z
    public n9.u h() {
        n9.u uVar = n9.t.f12304f;
        if (uVar == null) {
            e0(6);
        }
        return uVar;
    }

    @Override // n9.a
    public bb.b0 i() {
        return b();
    }

    @Override // n9.p
    public v0 k() {
        v0 v0Var = v0.f12324a;
        if (v0Var == null) {
            e0(8);
        }
        return v0Var;
    }

    @Override // n9.a
    public List<d1> l() {
        List<d1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            e0(4);
        }
        return emptyList;
    }

    @Override // n9.a
    public List<n9.a1> m() {
        List<n9.a1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            e0(2);
        }
        return emptyList;
    }
}
