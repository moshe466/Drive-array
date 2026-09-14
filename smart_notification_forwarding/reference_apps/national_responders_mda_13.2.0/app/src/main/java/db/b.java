package db;

/* loaded from: classes.dex */
public enum b {
    FOR_SUBTYPING,
    FOR_INCORPORATION,
    FROM_EXPRESSION;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static b[] valuesCustom() {
        b[] valuesCustom = values();
        b[] bVarArr = new b[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, bVarArr, 0, valuesCustom.length);
        return bVarArr;
    }
}
