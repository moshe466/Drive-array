package la;

/* loaded from: classes.dex */
enum h {
    BEGINNING,
    MIDDLE,
    AFTER_DOT;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static h[] valuesCustom() {
        h[] valuesCustom = values();
        h[] hVarArr = new h[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, hVarArr, 0, valuesCustom.length);
        return hVarArr;
    }
}
