package jb;

/* loaded from: classes.dex */
public enum h {
    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");

    public static final a Companion = new a(null);
    private final String description;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }
    }

    h(String str) {
        this.description = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static h[] valuesCustom() {
        h[] valuesCustom = values();
        h[] hVarArr = new h[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, hVarArr, 0, valuesCustom.length);
        return hVarArr;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean isIgnore() {
        return this == IGNORE;
    }

    public final boolean isWarning() {
        return this == WARN;
    }
}
