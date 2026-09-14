package v9;

/* loaded from: classes.dex */
public enum a {
    METHOD_RETURN_TYPE("METHOD"),
    VALUE_PARAMETER("PARAMETER"),
    FIELD("FIELD"),
    TYPE_USE("TYPE_USE"),
    TYPE_PARAMETER_BOUNDS("TYPE_USE"),
    TYPE_PARAMETER("TYPE_PARAMETER");

    private final String javaTarget;

    a(String str) {
        this.javaTarget = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static a[] valuesCustom() {
        a[] valuesCustom = values();
        a[] aVarArr = new a[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, aVarArr, 0, valuesCustom.length);
        return aVarArr;
    }

    public final String getJavaTarget() {
        return this.javaTarget;
    }
}
