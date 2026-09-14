package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public enum zzdsg {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzdqk.class, zzdqk.class, zzdqk.zzhhx),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);

    private final Class<?> zzhnw;
    private final Class<?> zzhnx;
    private final Object zzhny;

    zzdsg(Class cls, Class cls2, Object obj) {
        this.zzhnw = cls;
        this.zzhnx = cls2;
        this.zzhny = obj;
    }

    public final Class<?> zzbat() {
        return this.zzhnx;
    }
}
