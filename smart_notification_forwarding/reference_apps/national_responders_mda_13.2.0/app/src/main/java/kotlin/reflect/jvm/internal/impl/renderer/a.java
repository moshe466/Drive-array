package kotlin.reflect.jvm.internal.impl.renderer;

/* loaded from: classes.dex */
public enum a {
    NO_ARGUMENTS(false, false, 3, null),
    UNLESS_EMPTY(true, false, 2, null),
    ALWAYS_PARENTHESIZED(true, true);

    private final boolean includeAnnotationArguments;
    private final boolean includeEmptyAnnotationArguments;

    a(boolean z10, boolean z11) {
        this.includeAnnotationArguments = z10;
        this.includeEmptyAnnotationArguments = z11;
    }

    /* synthetic */ a(boolean z10, boolean z11, int i10, y8.g gVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? false : z11);
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static a[] valuesCustom() {
        a[] valuesCustom = values();
        a[] aVarArr = new a[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, aVarArr, 0, valuesCustom.length);
        return aVarArr;
    }

    public final boolean getIncludeAnnotationArguments() {
        return this.includeAnnotationArguments;
    }

    public final boolean getIncludeEmptyAnnotationArguments() {
        return this.includeEmptyAnnotationArguments;
    }
}
