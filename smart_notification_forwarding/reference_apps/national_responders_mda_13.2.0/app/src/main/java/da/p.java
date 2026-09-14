package da;

/* loaded from: classes.dex */
public enum p {
    FLEXIBLE_LOWER,
    FLEXIBLE_UPPER,
    INFLEXIBLE;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static p[] valuesCustom() {
        p[] valuesCustom = values();
        p[] pVarArr = new p[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, pVarArr, 0, valuesCustom.length);
        return pVarArr;
    }
}
