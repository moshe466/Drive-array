package kotlin.reflect.jvm.internal.impl.renderer;

/* loaded from: classes.dex */
public enum k {
    ALL,
    ONLY_NON_SYNTHESIZED,
    NONE;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static k[] valuesCustom() {
        k[] valuesCustom = values();
        k[] kVarArr = new k[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, kVarArr, 0, valuesCustom.length);
        return kVarArr;
    }
}
