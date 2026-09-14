package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public enum zzip {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzdu.zza),
    ENUM(null),
    MESSAGE(null);

    private final Object zzj;

    zzip(Object obj) {
        this.zzj = obj;
    }
}
