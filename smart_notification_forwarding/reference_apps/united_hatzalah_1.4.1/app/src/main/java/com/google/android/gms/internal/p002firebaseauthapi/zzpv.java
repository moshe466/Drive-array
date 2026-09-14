package com.google.android.gms.internal.p002firebaseauthapi;

import e0.a;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzpv {
    private final Map<zzqa, zzpr<?, ?>> zza;
    private final Map<Class<?>, zzqc<?, ?>> zzb;

    public /* synthetic */ zzpv(zzpx zzpxVar, zzpz zzpzVar) {
        this(zzpxVar);
    }

    public static zzpx zza() {
        return new zzpx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public zzpv(zzpx zzpxVar) {
        Map map;
        Map map2;
        map = zzpxVar.zza;
        this.zza = new HashMap(map);
        map2 = zzpxVar.zzb;
        this.zzb = new HashMap(map2);
    }

    public static zzpx zza(zzpv zzpvVar) {
        return new zzpx(zzpvVar);
    }

    public final <KeyT extends zzbm, PrimitiveT> PrimitiveT zza(KeyT keyt, Class<PrimitiveT> cls) {
        zzqa zzqaVar = new zzqa(keyt.getClass(), cls);
        if (this.zza.containsKey(zzqaVar)) {
            return (PrimitiveT) this.zza.get(zzqaVar).zza(keyt);
        }
        throw new GeneralSecurityException(a.e("No PrimitiveConstructor for ", String.valueOf(zzqaVar), " available, see https://developers.google.com/tink/faq/registration_errors"));
    }

    public final <WrappedPrimitiveT> WrappedPrimitiveT zza(zzoa zzoaVar, zzoj zzojVar, Class<WrappedPrimitiveT> cls) {
        if (this.zzb.containsKey(cls)) {
            final zzqc<?, ?> zzqcVar = this.zzb.get(cls);
            return (WrappedPrimitiveT) zzqcVar.zza(zzoaVar, zzojVar, new zzqb() { // from class: com.google.android.gms.internal.firebase-auth-api.zzpy
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqb
                public final Object zza(zzod zzodVar) {
                    Object zza;
                    zza = zzpv.this.zza(zzodVar.zzb(), zzqcVar.zza());
                    return zza;
                }
            });
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(String.valueOf(cls)));
    }
}
