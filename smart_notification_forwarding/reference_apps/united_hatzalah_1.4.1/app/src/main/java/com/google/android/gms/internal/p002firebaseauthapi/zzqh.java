package com.google.android.gms.internal.p002firebaseauthapi;

import e0.a;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzqh {
    private final Map<zzqm, zznw<?, ?>> zza;
    private final Map<zzqj, zzns<?>> zzb;
    private final Map<zzqm, zzpk<?, ?>> zzc;
    private final Map<zzqj, zzpg<?>> zzd;

    public /* synthetic */ zzqh(zzqk zzqkVar, zzql zzqlVar) {
        this(zzqkVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public zzqh(zzqk zzqkVar) {
        Map map;
        Map map2;
        Map map3;
        Map map4;
        map = zzqkVar.zza;
        this.zza = new HashMap(map);
        map2 = zzqkVar.zzb;
        this.zzb = new HashMap(map2);
        map3 = zzqkVar.zzc;
        this.zzc = new HashMap(map3);
        map4 = zzqkVar.zzd;
        this.zzd = new HashMap(map4);
    }

    public final <SerializationT extends zzqi> zzbm zza(SerializationT serializationt, zzck zzckVar) {
        zzqj zzqjVar = new zzqj(serializationt.getClass(), serializationt.zzb());
        if (this.zzb.containsKey(zzqjVar)) {
            return this.zzb.get(zzqjVar).zza(serializationt, zzckVar);
        }
        throw new GeneralSecurityException(a.e("No Key Parser for requested key type ", String.valueOf(zzqjVar), " available"));
    }

    public final <SerializationT extends zzqi> boolean zzb(SerializationT serializationt) {
        return this.zzb.containsKey(new zzqj(serializationt.getClass(), serializationt.zzb()));
    }

    public final <SerializationT extends zzqi> boolean zzc(SerializationT serializationt) {
        return this.zzd.containsKey(new zzqj(serializationt.getClass(), serializationt.zzb()));
    }

    public final <SerializationT extends zzqi> zzce zza(SerializationT serializationt) {
        zzqj zzqjVar = new zzqj(serializationt.getClass(), serializationt.zzb());
        if (this.zzd.containsKey(zzqjVar)) {
            return this.zzd.get(zzqjVar).zza(serializationt);
        }
        throw new GeneralSecurityException(a.e("No Parameters Parser for requested key type ", String.valueOf(zzqjVar), " available"));
    }

    public final <KeyT extends zzbm, SerializationT extends zzqi> SerializationT zza(KeyT keyt, Class<SerializationT> cls, zzck zzckVar) {
        zzqm zzqmVar = new zzqm(keyt.getClass(), cls);
        if (this.zza.containsKey(zzqmVar)) {
            return (SerializationT) this.zza.get(zzqmVar).zza(keyt, zzckVar);
        }
        throw new GeneralSecurityException(a.e("No Key serializer for ", String.valueOf(zzqmVar), " available"));
    }

    public final <ParametersT extends zzce, SerializationT extends zzqi> SerializationT zza(ParametersT parameterst, Class<SerializationT> cls) {
        zzqm zzqmVar = new zzqm(parameterst.getClass(), cls);
        if (this.zzc.containsKey(zzqmVar)) {
            return (SerializationT) this.zzc.get(zzqmVar).zza(parameterst);
        }
        throw new GeneralSecurityException(a.e("No Key Format serializer for ", String.valueOf(zzqmVar), " available"));
    }
}
