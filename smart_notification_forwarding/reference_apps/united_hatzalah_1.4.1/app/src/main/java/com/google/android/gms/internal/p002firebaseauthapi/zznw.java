package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzbm;
import com.google.android.gms.internal.p002firebaseauthapi.zzqi;

/* loaded from: classes.dex */
public abstract class zznw<KeyT extends zzbm, SerializationT extends zzqi> {
    private final Class<KeyT> zza;
    private final Class<SerializationT> zzb;

    public static <KeyT extends zzbm, SerializationT extends zzqi> zznw<KeyT, SerializationT> zza(zzny<KeyT, SerializationT> zznyVar, Class<KeyT> cls, Class<SerializationT> cls2) {
        return new zznz(cls, cls2, zznyVar);
    }

    public abstract SerializationT zza(KeyT keyt, zzck zzckVar);

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zznw(Class<KeyT> cls, Class<SerializationT> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final Class<KeyT> zza() {
        return this.zza;
    }
}
