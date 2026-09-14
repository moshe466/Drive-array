package db;

/* loaded from: classes.dex */
public enum r {
    IN("in"),
    OUT("out"),
    INV("");

    private final String presentation;

    r(String str) {
        this.presentation = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static r[] valuesCustom() {
        r[] valuesCustom = values();
        r[] rVarArr = new r[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, rVarArr, 0, valuesCustom.length);
        return rVarArr;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.presentation;
    }
}
