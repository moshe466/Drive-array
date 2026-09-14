package p9;

import n9.v0;

/* loaded from: classes.dex */
public abstract class m0 extends l0 {

    /* renamed from: k, reason: collision with root package name */
    private final boolean f13229k;

    /* renamed from: l, reason: collision with root package name */
    protected ab.j<pa.g<?>> f13230l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(n9.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, la.e eVar, bb.b0 b0Var, boolean z10, v0 v0Var) {
        super(mVar, gVar, eVar, b0Var, v0Var);
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
        this.f13229k = z10;
    }

    private static /* synthetic */ void e0(int i10) {
        Object[] objArr = new Object[3];
        if (i10 == 1) {
            objArr[0] = "annotations";
        } else if (i10 == 2) {
            objArr[0] = "name";
        } else if (i10 == 3) {
            objArr[0] = "source";
        } else if (i10 != 4) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "compileTimeInitializer";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i10 != 4) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // n9.e1
    public pa.g<?> F0() {
        ab.j<pa.g<?>> jVar = this.f13230l;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    @Override // n9.e1
    public boolean P() {
        return this.f13229k;
    }

    public void V0(ab.j<pa.g<?>> jVar) {
        if (jVar == null) {
            e0(4);
        }
        this.f13230l = jVar;
    }
}
