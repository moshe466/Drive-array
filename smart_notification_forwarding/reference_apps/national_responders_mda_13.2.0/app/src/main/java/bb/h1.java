package bb;

/* loaded from: classes.dex */
public enum h1 {
    INVARIANT("", true, true, 0),
    IN_VARIANCE("in", true, false, -1),
    OUT_VARIANCE("out", false, true, 1);

    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;
    private final String label;
    private final int superpositionFactor;

    h1(String str, boolean z10, boolean z11, int i10) {
        this.label = str;
        this.allowsInPosition = z10;
        this.allowsOutPosition = z11;
        this.superpositionFactor = i10;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static h1[] valuesCustom() {
        h1[] valuesCustom = values();
        h1[] h1VarArr = new h1[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, h1VarArr, 0, valuesCustom.length);
        return h1VarArr;
    }

    public final boolean getAllowsOutPosition() {
        return this.allowsOutPosition;
    }

    public final String getLabel() {
        return this.label;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.label;
    }
}
