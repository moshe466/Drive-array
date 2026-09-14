package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqi;

/* loaded from: classes.dex */
public abstract class zzns<SerializationT extends zzqi> {
    private final zzaae zza;
    private final Class<SerializationT> zzb;

    public static <SerializationT extends zzqi> zzns<SerializationT> zza(zznu<SerializationT> zznuVar, zzaae zzaaeVar, Class<SerializationT> cls) {
        return new zznv(zzaaeVar, cls, zznuVar);
    }

    public abstract zzbm zza(SerializationT serializationt, zzck zzckVar);

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zzns(zzaae zzaaeVar, Class<SerializationT> cls) {
        this.zza = zzaaeVar;
        this.zzb = cls;
    }

    public final zzaae zza() {
        return this.zza;
    }
}
