package n9;

/* loaded from: classes.dex */
public enum a0 {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;

    public static final a Companion = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final a0 a(boolean z10, boolean z11, boolean z12) {
            return z10 ? a0.SEALED : z11 ? a0.ABSTRACT : z12 ? a0.OPEN : a0.FINAL;
        }
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static a0[] valuesCustom() {
        a0[] valuesCustom = values();
        a0[] a0VarArr = new a0[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, a0VarArr, 0, valuesCustom.length);
        return a0VarArr;
    }
}
