package kotlin.reflect.jvm.internal.impl.renderer;

import mb.r;

/* loaded from: classes.dex */
public enum m {
    PLAIN { // from class: kotlin.reflect.jvm.internal.impl.renderer.m.b
        @Override // kotlin.reflect.jvm.internal.impl.renderer.m
        public String escape(String str) {
            y8.k.e(str, "string");
            return str;
        }
    },
    HTML { // from class: kotlin.reflect.jvm.internal.impl.renderer.m.a
        @Override // kotlin.reflect.jvm.internal.impl.renderer.m
        public String escape(String str) {
            String u10;
            String u11;
            y8.k.e(str, "string");
            u10 = r.u(str, "<", "&lt;", false, 4, null);
            u11 = r.u(u10, ">", "&gt;", false, 4, null);
            return u11;
        }
    };

    /* synthetic */ m(y8.g gVar) {
        this();
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static m[] valuesCustom() {
        m[] valuesCustom = values();
        m[] mVarArr = new m[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, mVarArr, 0, valuesCustom.length);
        return mVarArr;
    }

    public abstract String escape(String str);
}
