package aa;

/* loaded from: classes.dex */
public enum b {
    INFLEXIBLE,
    FLEXIBLE_UPPER_BOUND,
    FLEXIBLE_LOWER_BOUND;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static b[] valuesCustom() {
        b[] valuesCustom = values();
        b[] bVarArr = new b[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, bVarArr, 0, valuesCustom.length);
        return bVarArr;
    }
}
