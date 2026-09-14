package p9;

import n9.v0;

/* loaded from: classes.dex */
public abstract class k extends j implements n9.n {

    /* renamed from: h, reason: collision with root package name */
    private final n9.m f13217h;

    /* renamed from: i, reason: collision with root package name */
    private final v0 f13218i;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(n9.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, la.e eVar, v0 v0Var) {
        super(gVar, eVar);
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
        this.f13217h = mVar;
        this.f13218i = v0Var;
    }

    private static /* synthetic */ void e0(int i10) {
        String str = (i10 == 4 || i10 == 5 || i10 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 5 || i10 == 6) ? 2 : 3];
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
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i10 == 4) {
            objArr[1] = "getOriginal";
        } else if (i10 == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i10 != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i10 != 4 && i10 != 5 && i10 != 6) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i10 != 4 && i10 != 5 && i10 != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // p9.j, n9.m
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public n9.p a() {
        n9.p pVar = (n9.p) super.a();
        if (pVar == null) {
            e0(4);
        }
        return pVar;
    }

    public n9.m d() {
        n9.m mVar = this.f13217h;
        if (mVar == null) {
            e0(5);
        }
        return mVar;
    }

    @Override // n9.p
    public v0 k() {
        v0 v0Var = this.f13218i;
        if (v0Var == null) {
            e0(6);
        }
        return v0Var;
    }
}
