package p9;

/* loaded from: classes.dex */
public class e0 extends c {

    /* renamed from: i, reason: collision with root package name */
    private final n9.m f13197i;

    /* renamed from: j, reason: collision with root package name */
    private final va.d f13198j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(n9.m mVar, va.d dVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        super(gVar);
        if (mVar == null) {
            e0(0);
        }
        if (dVar == null) {
            e0(1);
        }
        if (gVar == null) {
            e0(2);
        }
        this.f13197i = mVar;
        this.f13198j = dVar;
    }

    private static /* synthetic */ void e0(int i10) {
        String str = (i10 == 3 || i10 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 3 || i10 == 4) ? 2 : 3];
        if (i10 == 1) {
            objArr[0] = "value";
        } else if (i10 == 2) {
            objArr[0] = "annotations";
        } else if (i10 == 3 || i10 == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else if (i10 != 5) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "newOwner";
        }
        if (i10 == 3) {
            objArr[1] = "getValue";
        } else if (i10 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i10 != 3 && i10 != 4) {
            if (i10 != 5) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String format = String.format(str, objArr);
        if (i10 != 3 && i10 != 4) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // n9.m
    public n9.m d() {
        n9.m mVar = this.f13197i;
        if (mVar == null) {
            e0(4);
        }
        return mVar;
    }

    @Override // n9.s0
    public va.d getValue() {
        va.d dVar = this.f13198j;
        if (dVar == null) {
            e0(3);
        }
        return dVar;
    }
}
