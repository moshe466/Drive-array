package p9;

import bb.a1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import n9.a;
import n9.b;
import n9.o0;
import n9.p0;
import n9.s0;
import n9.v0;

/* loaded from: classes.dex */
public abstract class a0 extends k implements o0 {

    /* renamed from: j, reason: collision with root package name */
    private boolean f13137j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f13138k;

    /* renamed from: l, reason: collision with root package name */
    private final n9.a0 f13139l;

    /* renamed from: m, reason: collision with root package name */
    private final p0 f13140m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f13141n;

    /* renamed from: o, reason: collision with root package name */
    private final b.a f13142o;

    /* renamed from: p, reason: collision with root package name */
    private n9.u f13143p;

    /* renamed from: q, reason: collision with root package name */
    private n9.x f13144q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(n9.a0 a0Var, n9.u uVar, p0 p0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, la.e eVar, boolean z10, boolean z11, boolean z12, b.a aVar, v0 v0Var) {
        super(p0Var.d(), gVar, eVar, v0Var);
        if (a0Var == null) {
            e0(0);
        }
        if (uVar == null) {
            e0(1);
        }
        if (p0Var == null) {
            e0(2);
        }
        if (gVar == null) {
            e0(3);
        }
        if (eVar == null) {
            e0(4);
        }
        if (v0Var == null) {
            e0(5);
        }
        this.f13144q = null;
        this.f13139l = a0Var;
        this.f13143p = uVar;
        this.f13140m = p0Var;
        this.f13137j = z10;
        this.f13138k = z11;
        this.f13141n = z12;
        this.f13142o = aVar;
    }

    private static /* synthetic */ void e0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                i11 = 2;
                break;
            case 7:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = "name";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 14:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i10) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getModality";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 12:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 13:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 14:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(format);
            case 7:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // n9.o0
    public boolean B0() {
        return this.f13137j;
    }

    @Override // n9.x
    public boolean C0() {
        return false;
    }

    @Override // n9.a
    public <V> V G(a.InterfaceC0257a<V> interfaceC0257a) {
        return null;
    }

    @Override // n9.x
    public n9.x H() {
        return this.f13144q;
    }

    @Override // n9.z
    public boolean H0() {
        return false;
    }

    @Override // n9.z
    public boolean I() {
        return this.f13138k;
    }

    @Override // n9.a
    public s0 K() {
        return y0().K();
    }

    @Override // n9.x
    public boolean N0() {
        return false;
    }

    @Override // n9.a
    public s0 U() {
        return y0().U();
    }

    @Override // n9.b
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public o0 V0(n9.m mVar, n9.a0 a0Var, n9.u uVar, b.a aVar, boolean z10) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // p9.k, p9.j, n9.m
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public abstract o0 a();

    /* JADX INFO: Access modifiers changed from: protected */
    public Collection<o0> W0(boolean z10) {
        ArrayList arrayList = new ArrayList(0);
        for (p0 p0Var : y0().g()) {
            n9.z t10 = z10 ? p0Var.t() : p0Var.M0();
            if (t10 != null) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public void X0(boolean z10) {
        this.f13137j = z10;
    }

    public void Y0(n9.x xVar) {
        this.f13144q = xVar;
    }

    public void Z0(n9.u uVar) {
        this.f13143p = uVar;
    }

    @Override // n9.a
    public boolean c0() {
        return false;
    }

    @Override // n9.x0
    public n9.x e(a1 a1Var) {
        if (a1Var == null) {
            e0(7);
        }
        throw new UnsupportedOperationException();
    }

    @Override // n9.q, n9.z
    public n9.u h() {
        n9.u uVar = this.f13143p;
        if (uVar == null) {
            e0(10);
        }
        return uVar;
    }

    @Override // n9.z
    public boolean l0() {
        return false;
    }

    @Override // n9.a
    public List<n9.a1> m() {
        List<n9.a1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            e0(8);
        }
        return emptyList;
    }

    @Override // n9.z
    public n9.a0 p() {
        n9.a0 a0Var = this.f13139l;
        if (a0Var == null) {
            e0(9);
        }
        return a0Var;
    }

    @Override // n9.x
    public boolean p0() {
        return false;
    }

    @Override // n9.x
    public boolean q0() {
        return false;
    }

    @Override // n9.b
    public b.a r() {
        b.a aVar = this.f13142o;
        if (aVar == null) {
            e0(6);
        }
        return aVar;
    }

    @Override // n9.b
    public void r0(Collection<? extends n9.b> collection) {
        if (collection == null) {
            e0(14);
        }
    }

    @Override // n9.x
    public boolean s0() {
        return false;
    }

    @Override // n9.x
    public boolean t0() {
        return false;
    }

    @Override // n9.x
    public boolean x() {
        return this.f13141n;
    }

    @Override // n9.o0
    public p0 y0() {
        p0 p0Var = this.f13140m;
        if (p0Var == null) {
            e0(12);
        }
        return p0Var;
    }
}
