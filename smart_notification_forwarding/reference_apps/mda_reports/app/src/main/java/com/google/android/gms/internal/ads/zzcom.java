package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes.dex */
public final class zzcom extends zzvq {
    private zzvh zzblq;
    private final zzbfx zzfzz;
    private final Context zzgcr;

    @VisibleForTesting
    private final zzczw zzgcs = new zzczw();

    @VisibleForTesting
    private final zzbxb zzgct = new zzbxb();

    public zzcom(zzbfx zzbfxVar, Context context, String str) {
        this.zzfzz = zzbfxVar;
        this.zzgcs.zzgk(str);
        this.zzgcr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzgcs.zzb(publisherAdViewOptions);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(zzaby zzabyVar) {
        this.zzgcs.zzb(zzabyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(zzadi zzadiVar) {
        this.zzgct.zzb(zzadiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(zzadj zzadjVar) {
        this.zzgct.zzb(zzadjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(zzadu zzaduVar, zzuj zzujVar) {
        this.zzgct.zza(zzaduVar);
        this.zzgcs.zzd(zzujVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(zzadv zzadvVar) {
        this.zzgct.zzb(zzadvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(zzagz zzagzVar) {
        this.zzgcs.zzb(zzagzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(zzahh zzahhVar) {
        this.zzgct.zzb(zzahhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(String str, zzadp zzadpVar, zzado zzadoVar) {
        this.zzgct.zzb(str, zzadpVar, zzadoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zzb(zzvh zzvhVar) {
        this.zzblq = zzvhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zzb(zzwi zzwiVar) {
        this.zzgcs.zzc(zzwiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final zzvm zzpd() {
        zzbwz zzajw = this.zzgct.zzajw();
        this.zzgcs.zzb(zzajw.zzaju());
        this.zzgcs.zzc(zzajw.zzajv());
        zzczw zzczwVar = this.zzgcs;
        if (zzczwVar.zzjz() == null) {
            zzczwVar.zzd(zzuj.zzg(this.zzgcr));
        }
        return new zzcol(this.zzgcr, this.zzfzz, this.zzgcs, zzajw, this.zzblq);
    }
}
