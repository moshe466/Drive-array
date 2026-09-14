package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: f, reason: collision with root package name */
    private final g f11352f;

    public b(g gVar) {
        if (gVar == null) {
            e0(0);
        }
        this.f11352f = gVar;
    }

    private static /* synthetic */ void e0(int i10) {
        String str = i10 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 1 ? 3 : 2];
        if (i10 != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i10 != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i10 != 1) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i10 == 1) {
            throw new IllegalStateException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public g u() {
        g gVar = this.f11352f;
        if (gVar == null) {
            e0(1);
        }
        return gVar;
    }
}
