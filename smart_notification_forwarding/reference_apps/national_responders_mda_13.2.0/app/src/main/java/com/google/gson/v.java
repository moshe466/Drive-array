package com.google.gson;

import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class v implements w {
    private static final /* synthetic */ v[] $VALUES;
    public static final v BIG_DECIMAL;
    public static final v DOUBLE;
    public static final v LAZILY_PARSED_NUMBER;
    public static final v LONG_OR_DOUBLE;

    /* loaded from: classes.dex */
    enum a extends v {
        a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // com.google.gson.v, com.google.gson.w
        public Double readNumber(f5.a aVar) {
            return Double.valueOf(aVar.d0());
        }
    }

    static {
        a aVar = new a("DOUBLE", 0);
        DOUBLE = aVar;
        v vVar = new v("LAZILY_PARSED_NUMBER", 1) { // from class: com.google.gson.v.b
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.v, com.google.gson.w
            public Number readNumber(f5.a aVar2) {
                return new z4.g(aVar2.k0());
            }
        };
        LAZILY_PARSED_NUMBER = vVar;
        v vVar2 = new v("LONG_OR_DOUBLE", 2) { // from class: com.google.gson.v.c
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.v, com.google.gson.w
            public Number readNumber(f5.a aVar2) {
                String k02 = aVar2.k0();
                try {
                    try {
                        return Long.valueOf(Long.parseLong(k02));
                    } catch (NumberFormatException e10) {
                        throw new o("Cannot parse " + k02 + "; at path " + aVar2.M(), e10);
                    }
                } catch (NumberFormatException unused) {
                    Double valueOf = Double.valueOf(k02);
                    if ((!valueOf.isInfinite() && !valueOf.isNaN()) || aVar2.O()) {
                        return valueOf;
                    }
                    throw new f5.d("JSON forbids NaN and infinities: " + valueOf + "; at path " + aVar2.M());
                }
            }
        };
        LONG_OR_DOUBLE = vVar2;
        v vVar3 = new v("BIG_DECIMAL", 3) { // from class: com.google.gson.v.d
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.v, com.google.gson.w
            public BigDecimal readNumber(f5.a aVar2) {
                String k02 = aVar2.k0();
                try {
                    return new BigDecimal(k02);
                } catch (NumberFormatException e10) {
                    throw new o("Cannot parse " + k02 + "; at path " + aVar2.M(), e10);
                }
            }
        };
        BIG_DECIMAL = vVar3;
        $VALUES = new v[]{aVar, vVar, vVar2, vVar3};
    }

    private v(String str, int i10) {
    }

    /* synthetic */ v(String str, int i10, a aVar) {
        this(str, i10);
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) $VALUES.clone();
    }

    @Override // com.google.gson.w
    public abstract /* synthetic */ Number readNumber(f5.a aVar);
}
