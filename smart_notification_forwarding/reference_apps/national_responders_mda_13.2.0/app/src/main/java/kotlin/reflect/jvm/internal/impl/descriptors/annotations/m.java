package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

/* loaded from: classes.dex */
public enum m {
    RUNTIME,
    BINARY,
    SOURCE;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static m[] valuesCustom() {
        m[] valuesCustom = values();
        m[] mVarArr = new m[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, mVarArr, 0, valuesCustom.length);
        return mVarArr;
    }
}
