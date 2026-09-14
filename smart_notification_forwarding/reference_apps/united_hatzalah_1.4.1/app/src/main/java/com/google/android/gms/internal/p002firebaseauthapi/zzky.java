package com.google.android.gms.internal.p002firebaseauthapi;

import e0.a;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzky implements zzqc<zzbh, zzbh> {
    private static final zzky zza = new zzky();
    private static final zzpr<zzoe, zzbh> zzb = zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlb
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
        public final Object zza(zzbm zzbmVar) {
            return zzmm.zza((zzoe) zzbmVar);
        }
    }, zzoe.class, zzbh.class);

    public static void zzc() {
        zzoz.zza().zza(zza);
        zzoz.zza().zza(zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final Class<zzbh> zza() {
        return zzbh.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final Class<zzbh> zzb() {
        return zzbh.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final /* synthetic */ zzbh zza(zzoa zzoaVar, zzoj zzojVar, zzqb<zzbh> zzqbVar) {
        zzon zzonVar;
        zzaae zzc;
        zzpq zzpqVar = new zzpq();
        for (int i = 0; i < zzoaVar.zza(); i++) {
            zzod zza2 = zzoaVar.zza(i);
            if (zza2.zzc().equals(zzbo.zza)) {
                zzbh zza3 = zzqbVar.zza(zza2);
                zzbm zzb2 = zza2.zzb();
                if (zzb2 instanceof zzli) {
                    zzc = ((zzli) zzb2).zzh();
                } else if (zzb2 instanceof zzoe) {
                    zzc = ((zzoe) zzb2).zzc();
                } else {
                    throw new GeneralSecurityException(a.f("Cannot get output prefix for key of class ", zzb2.getClass().getName(), " with parameters ", String.valueOf(zzb2.zza())));
                }
                zzpqVar.zza(zzc, new zzla(zza3, zza2.zza()));
            }
        }
        if (!zzojVar.zza()) {
            zzonVar = zzov.zzb().zza().zza(zzoaVar, zzojVar, "hybrid_decrypt", "decrypt");
        } else {
            zzonVar = zzoq.zza;
        }
        return new zzld(zzpqVar.zza(), zzonVar);
    }

    public static void zza(zzpx zzpxVar) {
        zzpxVar.zza(zza);
    }
}
