package p9;

import bb.t0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import n9.a1;
import n9.v0;
import ua.h;

/* loaded from: classes.dex */
public class h extends g {

    /* renamed from: n, reason: collision with root package name */
    private final n9.a0 f13204n;

    /* renamed from: o, reason: collision with root package name */
    private final n9.f f13205o;

    /* renamed from: p, reason: collision with root package name */
    private final t0 f13206p;

    /* renamed from: q, reason: collision with root package name */
    private ua.h f13207q;

    /* renamed from: r, reason: collision with root package name */
    private Set<n9.d> f13208r;

    /* renamed from: s, reason: collision with root package name */
    private n9.d f13209s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(n9.m mVar, la.e eVar, n9.a0 a0Var, n9.f fVar, Collection<bb.b0> collection, v0 v0Var, boolean z10, ab.n nVar) {
        super(nVar, mVar, eVar, v0Var, z10);
        if (mVar == null) {
            I0(0);
        }
        if (eVar == null) {
            I0(1);
        }
        if (a0Var == null) {
            I0(2);
        }
        if (fVar == null) {
            I0(3);
        }
        if (collection == null) {
            I0(4);
        }
        if (v0Var == null) {
            I0(5);
        }
        if (nVar == null) {
            I0(6);
        }
        this.f13204n = a0Var;
        this.f13205o = fVar;
        this.f13206p = new bb.i(this, Collections.emptyList(), collection, nVar);
    }

    private static /* synthetic */ void I0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                i11 = 2;
                break;
            case 12:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i10) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i10) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(format);
            case 12:
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
        List<a1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            I0(18);
        }
        return emptyList;
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

    public final void V0(ua.h hVar, Set<n9.d> set, n9.d dVar) {
        if (hVar == null) {
            I0(7);
        }
        if (set == null) {
            I0(8);
        }
        this.f13207q = hVar;
        this.f13208r = set;
        this.f13209s = dVar;
    }

    @Override // n9.e
    public boolean W() {
        return false;
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
        n9.u uVar = n9.t.f12303e;
        if (uVar == null) {
            I0(17);
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
        return false;
    }

    @Override // n9.h
    public t0 o() {
        t0 t0Var = this.f13206p;
        if (t0Var == null) {
            I0(10);
        }
        return t0Var;
    }

    @Override // n9.e, n9.z
    public n9.a0 p() {
        n9.a0 a0Var = this.f13204n;
        if (a0Var == null) {
            I0(16);
        }
        return a0Var;
    }

    @Override // n9.e
    public Collection<n9.d> q() {
        Set<n9.d> set = this.f13208r;
        if (set == null) {
            I0(11);
        }
        return set;
    }

    @Override // n9.e
    public n9.f r() {
        n9.f fVar = this.f13205o;
        if (fVar == null) {
            I0(15);
        }
        return fVar;
    }

    public String toString() {
        return "class " + c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b10 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b();
        if (b10 == null) {
            I0(9);
        }
        return b10;
    }

    @Override // p9.t
    public ua.h v0(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            I0(12);
        }
        ua.h hVar = this.f13207q;
        if (hVar == null) {
            I0(13);
        }
        return hVar;
    }

    @Override // n9.e
    public n9.d w0() {
        return this.f13209s;
    }

    @Override // n9.e
    public boolean x() {
        return false;
    }

    @Override // n9.e
    public ua.h x0() {
        h.b bVar = h.b.f14541b;
        if (bVar == null) {
            I0(14);
        }
        return bVar;
    }
}
