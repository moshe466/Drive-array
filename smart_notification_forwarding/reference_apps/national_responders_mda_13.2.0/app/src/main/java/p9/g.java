package p9;

import n9.v0;

/* loaded from: classes.dex */
public abstract class g extends a {

    /* renamed from: k, reason: collision with root package name */
    private final n9.m f13199k;

    /* renamed from: l, reason: collision with root package name */
    private final v0 f13200l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f13201m;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(ab.n nVar, n9.m mVar, la.e eVar, v0 v0Var, boolean z10) {
        super(nVar, eVar);
        if (nVar == null) {
            I0(0);
        }
        if (mVar == null) {
            I0(1);
        }
        if (eVar == null) {
            I0(2);
        }
        if (v0Var == null) {
            I0(3);
        }
        this.f13199k = mVar;
        this.f13200l = v0Var;
        this.f13201m = z10;
    }

    private static /* synthetic */ void I0(int i10) {
        String str = (i10 == 4 || i10 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 5) ? 2 : 3];
        if (i10 == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i10 == 2) {
            objArr[0] = "name";
        } else if (i10 == 3) {
            objArr[0] = "source";
        } else if (i10 == 4 || i10 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i10 == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i10 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i10 != 4 && i10 != 5) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i10 != 4 && i10 != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public boolean I() {
        return this.f13201m;
    }

    @Override // n9.e, n9.n, n9.m
    public n9.m d() {
        n9.m mVar = this.f13199k;
        if (mVar == null) {
            I0(4);
        }
        return mVar;
    }

    @Override // n9.p
    public v0 k() {
        v0 v0Var = this.f13200l;
        if (v0Var == null) {
            I0(5);
        }
        return v0Var;
    }
}
