package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Objects;

/* loaded from: classes.dex */
public enum e {
    FIELD(null, 1, null),
    FILE(null, 1, null),
    PROPERTY(null, 1, null),
    PROPERTY_GETTER("get"),
    PROPERTY_SETTER("set"),
    RECEIVER(0 == true ? 1 : 0, 1, null),
    CONSTRUCTOR_PARAMETER("param"),
    SETTER_PARAMETER("setparam"),
    PROPERTY_DELEGATE_FIELD("delegate");

    private final String renderName;

    e(String str) {
        if (str == null) {
            String name = name();
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            str = name.toLowerCase();
            y8.k.d(str, "(this as java.lang.String).toLowerCase()");
        }
        this.renderName = str;
    }

    /* synthetic */ e(String str, int i10, y8.g gVar) {
        this((i10 & 1) != 0 ? null : str);
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static e[] valuesCustom() {
        e[] valuesCustom = values();
        e[] eVarArr = new e[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, eVarArr, 0, valuesCustom.length);
        return eVarArr;
    }

    public final String getRenderName() {
        return this.renderName;
    }
}
