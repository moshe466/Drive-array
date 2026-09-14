package com.google.android.gms.internal.p002firebaseauthapi;

/* loaded from: classes.dex */
public final class zzlc implements zzqc<zzbk, zzbk> {
    private static final zzlc zza = new zzlc();
    private static final zzpr<zzoe, zzbk> zzb = zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlf
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
        public final Object zza(zzbm zzbmVar) {
            return zzmo.zza((zzoe) zzbmVar);
        }
    }, zzoe.class, zzbk.class);

    public static void zzc() {
        zzoz.zza().zza(zza);
        zzoz.zza().zza(zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final Class<zzbk> zza() {
        return zzbk.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final Class<zzbk> zzb() {
        return zzbk.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final /* synthetic */ zzbk zza(zzoa zzoaVar, zzoj zzojVar, zzqb<zzbk> zzqbVar) {
        zzon zzonVar;
        if (!zzojVar.zza()) {
            zzonVar = zzov.zzb().zza().zza(zzoaVar, zzojVar, "hybrid_encrypt", "encrypt");
        } else {
            zzonVar = zzoq.zza;
        }
        zzod zzc = zzoaVar.zzc();
        return new zzlh(new zzle(zzqbVar.zza(zzc), zzc.zza()), zzonVar);
    }

    public static void zza(zzpx zzpxVar) {
        zzpxVar.zza(zza);
    }
}
