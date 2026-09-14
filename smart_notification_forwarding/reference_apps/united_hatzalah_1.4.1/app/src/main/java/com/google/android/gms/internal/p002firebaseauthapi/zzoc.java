package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzws;

/* loaded from: classes.dex */
public class zzoc<P> implements zzbl<P> {
    final String zza;
    final zzws.zza zzb;
    private final Class<P> zzc;

    public zzoc(String str, Class<P> cls, zzws.zza zzaVar, zzamp<? extends zzamc> zzampVar) {
        this.zza = str;
        this.zzc = cls;
        this.zzb = zzaVar;
    }

    public static <P> zzbl<P> zza(String str, Class<P> cls, zzws.zza zzaVar, zzamp<? extends zzamc> zzampVar) {
        return new zzoc(str, cls, zzaVar, zzampVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbl
    public final P zzb(zzajp zzajpVar) {
        return (P) zzoz.zza().zza(zzpc.zza().zza((zzpc) zzqe.zza(this.zza, zzajpVar, this.zzb, zzxu.RAW, null), zzbj.zza()), this.zzc);
    }

    public static <P> zzcg<P> zza(String str, Class<P> cls, zzamp<? extends zzamc> zzampVar) {
        return new zzof(str, cls, zzampVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbl
    public final zzws zza(zzajp zzajpVar) {
        zzqe zzqeVar = (zzqe) zzpc.zza().zza(zzos.zza().zza(zzpc.zza().zza((zzpc) zzqd.zza((zzww) ((zzaky) zzww.zza().zza(this.zza).zza(zzajpVar).zza(zzxu.RAW).zze()))), (Integer) null), zzqe.class, zzbj.zza());
        return (zzws) ((zzaky) zzws.zza().zza(zzqeVar.zzf()).zza(zzqeVar.zzd()).zza(zzqeVar.zza()).zze());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbl
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbl
    public final Class<P> zza() {
        return this.zzc;
    }
}
