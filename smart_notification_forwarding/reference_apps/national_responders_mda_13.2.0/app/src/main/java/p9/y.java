package p9;

import bb.t0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import n9.a1;
import n9.v0;
import ua.h;

/* loaded from: classes.dex */
public class y extends g {

    /* renamed from: n, reason: collision with root package name */
    private final n9.f f13316n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f13317o;

    /* renamed from: p, reason: collision with root package name */
    private n9.a0 f13318p;

    /* renamed from: q, reason: collision with root package name */
    private n9.u f13319q;

    /* renamed from: r, reason: collision with root package name */
    private t0 f13320r;

    /* renamed from: s, reason: collision with root package name */
    private List<a1> f13321s;

    /* renamed from: t, reason: collision with root package name */
    private final Collection<bb.b0> f13322t;

    /* renamed from: u, reason: collision with root package name */
    private final ab.n f13323u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(n9.m mVar, n9.f fVar, boolean z10, boolean z11, la.e eVar, v0 v0Var, ab.n nVar) {
        super(nVar, mVar, eVar, v0Var, z11);
        if (mVar == null) {
            I0(0);
        }
        if (fVar == null) {
            I0(1);
        }
        if (eVar == null) {
            I0(2);
        }
        if (v0Var == null) {
            I0(3);
        }
        if (nVar == null) {
            I0(4);
        }
        this.f13322t = new ArrayList();
        this.f13323u = nVar;
        this.f13316n = fVar;
        this.f13317o = z10;
    }

    private static /* synthetic */ void I0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                i11 = 2;
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 9:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "supertype";
                break;
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 16:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 5:
                objArr[1] = "getAnnotations";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 7:
                objArr[1] = "getModality";
                break;
            case 8:
                objArr[1] = "getKind";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getTypeConstructor";
                break;
            case 13:
                objArr[1] = "getConstructors";
                break;
            case 15:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 17:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 18:
                objArr[1] = "getStaticScope";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i10) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 12:
                objArr[2] = "addSupertype";
                break;
            case 14:
                objArr[2] = "setTypeParameterDescriptors";
                break;
            case 16:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i10) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(format);
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // n9.e
    public n9.e A0() {
        return null;
    }

    @Override // n9.e, n9.i
    public List<a1> B() {
        List<a1> list = this.f13321s;
        if (list == null) {
            I0(15);
        }
        return list;
    }

    @Override // n9.z
    public boolean H0() {
        return false;
    }

    @Override // n9.e
    public boolean N() {
        return false;
    }

    @Override // n9.e
    public boolean R0() {
        return false;
    }

    public void V0() {
        this.f13320r = new bb.i(this, this.f13321s, this.f13322t, this.f13323u);
        Iterator<n9.d> it = q().iterator();
        while (it.hasNext()) {
            ((f) it.next()).r1(s());
        }
    }

    @Override // n9.e
    public boolean W() {
        return false;
    }

    @Override // n9.e
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public Set<n9.d> q() {
        Set<n9.d> emptySet = Collections.emptySet();
        if (emptySet == null) {
            I0(13);
        }
        return emptySet;
    }

    public void X0(n9.a0 a0Var) {
        if (a0Var == null) {
            I0(6);
        }
        this.f13318p = a0Var;
    }

    public void Y0(List<a1> list) {
        if (list == null) {
            I0(14);
        }
        if (this.f13321s == null) {
            this.f13321s = new ArrayList(list);
            return;
        }
        throw new IllegalStateException("Type parameters are already set for " + c());
    }

    public void Z0(n9.u uVar) {
        if (uVar == null) {
            I0(9);
        }
        this.f13319q = uVar;
    }

    @Override // n9.e
    public Collection<n9.e> g0() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            I0(19);
        }
        return emptyList;
    }

    @Override // n9.e, n9.q, n9.z
    public n9.u h() {
        n9.u uVar = this.f13319q;
        if (uVar == null) {
            I0(10);
        }
        return uVar;
    }

    @Override // n9.e
    public boolean j0() {
        return false;
    }

    @Override // n9.z
    public boolean l0() {
        return false;
    }

    @Override // n9.i
    public boolean m0() {
        return this.f13317o;
    }

    @Override // n9.h
    public t0 o() {
        t0 t0Var = this.f13320r;
        if (t0Var == null) {
            I0(11);
        }
        return t0Var;
    }

    @Override // n9.e, n9.z
    public n9.a0 p() {
        n9.a0 a0Var = this.f13318p;
        if (a0Var == null) {
            I0(7);
        }
        return a0Var;
    }

    @Override // n9.e
    public n9.f r() {
        n9.f fVar = this.f13316n;
        if (fVar == null) {
            I0(8);
        }
        return fVar;
    }

    public String toString() {
        return j.v0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b10 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b();
        if (b10 == null) {
            I0(5);
        }
        return b10;
    }

    @Override // p9.t
    public ua.h v0(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            I0(16);
        }
        h.b bVar = h.b.f14541b;
        if (bVar == null) {
            I0(17);
        }
        return bVar;
    }

    @Override // n9.e
    public n9.d w0() {
        return null;
    }

    @Override // n9.e
    public boolean x() {
        return false;
    }

    @Override // n9.e
    public ua.h x0() {
        h.b bVar = h.b.f14541b;
        if (bVar == null) {
            I0(18);
        }
        return bVar;
    }
}
