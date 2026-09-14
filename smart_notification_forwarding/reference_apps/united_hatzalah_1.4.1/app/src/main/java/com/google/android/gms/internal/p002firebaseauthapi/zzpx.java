package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzpx {
    private final Map<zzqa, zzpr<?, ?>> zza;
    private final Map<Class<?>, zzqc<?, ?>> zzb;

    public final <KeyT extends zzbm, PrimitiveT> zzpx zza(zzpr<KeyT, PrimitiveT> zzprVar) {
        if (zzprVar != null) {
            zzqa zzqaVar = new zzqa(zzprVar.zza(), zzprVar.zzb());
            if (this.zza.containsKey(zzqaVar)) {
                zzpr<?, ?> zzprVar2 = this.zza.get(zzqaVar);
                if (zzprVar2.equals(zzprVar) && zzprVar.equals(zzprVar2)) {
                    return this;
                }
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(String.valueOf(zzqaVar)));
            }
            this.zza.put(zzqaVar, zzprVar);
            return this;
        }
        throw new NullPointerException("primitive constructor must be non-null");
    }

    private zzpx() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    private zzpx(zzpv zzpvVar) {
        this.zza = new HashMap(zzpv.zzb(zzpvVar));
        this.zzb = new HashMap(zzpv.zzc(zzpvVar));
    }

    public final <InputPrimitiveT, WrapperPrimitiveT> zzpx zza(zzqc<InputPrimitiveT, WrapperPrimitiveT> zzqcVar) {
        if (zzqcVar != null) {
            Class<WrapperPrimitiveT> zzb = zzqcVar.zzb();
            if (this.zzb.containsKey(zzb)) {
                zzqc<?, ?> zzqcVar2 = this.zzb.get(zzb);
                if (zzqcVar2.equals(zzqcVar) && zzqcVar.equals(zzqcVar2)) {
                    return this;
                }
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(String.valueOf(zzb)));
            }
            this.zzb.put(zzb, zzqcVar);
            return this;
        }
        throw new NullPointerException("wrapper must be non-null");
    }

    public final zzpv zza() {
        return new zzpv(this);
    }
}
