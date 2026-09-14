package p9;

/* loaded from: classes.dex */
public class q extends c {

    /* renamed from: i, reason: collision with root package name */
    private final n9.e f13287i;

    /* renamed from: j, reason: collision with root package name */
    private final va.c f13288j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(n9.e eVar) {
        super(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b());
        if (eVar == null) {
            e0(0);
        }
        this.f13287i = eVar;
        this.f13288j = new va.c(eVar, null);
    }

    private static /* synthetic */ void e0(int i10) {
        String str = (i10 == 1 || i10 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 1 || i10 == 2) ? 2 : 3];
        if (i10 == 1 || i10 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i10 != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i10 == 1) {
            objArr[1] = "getValue";
        } else if (i10 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String format = String.format(str, objArr);
        if (i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // n9.m
    public n9.m d() {
        n9.e eVar = this.f13287i;
        if (eVar == null) {
            e0(2);
        }
        return eVar;
    }

    @Override // n9.s0
    public va.d getValue() {
        va.c cVar = this.f13288j;
        if (cVar == null) {
            e0(1);
        }
        return cVar;
    }

    @Override // p9.j
    public String toString() {
        return "class " + this.f13287i.c() + "::this";
    }
}
