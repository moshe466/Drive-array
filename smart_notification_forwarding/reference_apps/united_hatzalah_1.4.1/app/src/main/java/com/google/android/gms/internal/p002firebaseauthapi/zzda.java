package com.google.android.gms.internal.p002firebaseauthapi;

import e0.a;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzda implements zzqc<zzbe, zzbe> {
    private static final zzda zza = new zzda();
    private static final zzpr<zzoe, zzbe> zzb = zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzcz
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
        public final Object zza(zzbm zzbmVar) {
            return zzhz.zza((zzoe) zzbmVar);
        }
    }, zzoe.class, zzbe.class);

    public static void zzc() {
        zzoz.zza().zza(zza);
        zzoz.zza().zza(zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final Class<zzbe> zza() {
        return zzbe.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final Class<zzbe> zzb() {
        return zzbe.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final /* synthetic */ zzbe zza(zzoa zzoaVar, zzoj zzojVar, zzqb<zzbe> zzqbVar) {
        zzon zzonVar;
        zzon zzonVar2;
        zzaae zzc;
        zzpq zzpqVar = new zzpq();
        for (int i = 0; i < zzoaVar.zza(); i++) {
            zzod zza2 = zzoaVar.zza(i);
            if (zza2.zzc().equals(zzbo.zza)) {
                zzbm zzb2 = zza2.zzb();
                if (zzb2 instanceof zzcv) {
                    zzc = ((zzcv) zzb2).zzd();
                } else if (zzb2 instanceof zzoe) {
                    zzc = ((zzoe) zzb2).zzc();
                } else {
                    throw new GeneralSecurityException(a.f("Cannot get output prefix for key of class ", zzb2.getClass().getName(), " with parameters ", String.valueOf(zzb2.zza())));
                }
                zzpqVar.zza(zzc, new zzdc(zzqbVar.zza(zza2), zza2.zza()));
            }
        }
        if (!zzojVar.zza()) {
            zzoo zza3 = zzov.zzb().zza();
            zzon zza4 = zza3.zza(zzoaVar, zzojVar, "aead", "encrypt");
            zzonVar2 = zza3.zza(zzoaVar, zzojVar, "aead", "decrypt");
            zzonVar = zza4;
        } else {
            zzonVar = zzoq.zza;
            zzonVar2 = zzonVar;
        }
        return new zzdb(new zzdc(zzqbVar.zza(zzoaVar.zzc()), zzoaVar.zzc().zza()), zzpqVar.zza(), zzonVar, zzonVar2);
    }

    public static void zza(zzpx zzpxVar) {
        zzpxVar.zza(zza);
    }
}
