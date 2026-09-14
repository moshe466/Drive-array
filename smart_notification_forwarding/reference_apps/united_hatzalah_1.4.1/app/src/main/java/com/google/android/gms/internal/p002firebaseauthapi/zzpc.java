package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzpc {
    private static final zzpc zza = (zzpc) zzqo.zza(new zzqn() { // from class: com.google.android.gms.internal.firebase-auth-api.zzpb
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqn
        public final Object zza() {
            zzpc zzpcVar = new zzpc();
            zzpcVar.zza(zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzpe
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzny
                public final zzqi zza(zzbm zzbmVar, zzck zzckVar) {
                    return ((zzoe) zzbmVar).zza(zzckVar);
                }
            }, zzoe.class, zzqe.class));
            return zzpcVar;
        }
    });
    private final AtomicReference<zzqh> zzb = new AtomicReference<>(new zzqk().zza());

    public final <SerializationT extends zzqi> zzbm zza(SerializationT serializationt, zzck zzckVar) {
        return this.zzb.get().zza((zzqh) serializationt, zzckVar);
    }

    public final <SerializationT extends zzqi> boolean zzb(SerializationT serializationt) {
        return this.zzb.get().zzb((zzqh) serializationt);
    }

    public final <SerializationT extends zzqi> boolean zzc(SerializationT serializationt) {
        return this.zzb.get().zzc((zzqh) serializationt);
    }

    public final <SerializationT extends zzqi> zzce zza(SerializationT serializationt) {
        return this.zzb.get().zza((zzqh) serializationt);
    }

    public static zzpc zza() {
        return zza;
    }

    public final <KeyT extends zzbm, SerializationT extends zzqi> SerializationT zza(KeyT keyt, Class<SerializationT> cls, zzck zzckVar) {
        return (SerializationT) this.zzb.get().zza(keyt, cls, zzckVar);
    }

    public final <ParametersT extends zzce, SerializationT extends zzqi> SerializationT zza(ParametersT parameterst, Class<SerializationT> cls) {
        return (SerializationT) this.zzb.get().zza((zzqh) parameterst, (Class) cls);
    }

    public final synchronized <SerializationT extends zzqi> void zza(zzns<SerializationT> zznsVar) {
        this.zzb.set(new zzqk(this.zzb.get()).zza(zznsVar).zza());
    }

    public final synchronized <KeyT extends zzbm, SerializationT extends zzqi> void zza(zznw<KeyT, SerializationT> zznwVar) {
        this.zzb.set(new zzqk(this.zzb.get()).zza(zznwVar).zza());
    }

    public final synchronized <SerializationT extends zzqi> void zza(zzpg<SerializationT> zzpgVar) {
        this.zzb.set(new zzqk(this.zzb.get()).zza(zzpgVar).zza());
    }

    public final synchronized <ParametersT extends zzce, SerializationT extends zzqi> void zza(zzpk<ParametersT, SerializationT> zzpkVar) {
        this.zzb.set(new zzqk(this.zzb.get()).zza(zzpkVar).zza());
    }
}
