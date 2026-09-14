package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class zzcmd extends zzcnd {
    private zzbte zzgam;
    private zzboz zzgan;

    public zzcmd(zzboq zzboqVar, zzbpd zzbpdVar, zzbpm zzbpmVar, zzbpw zzbpwVar, zzboz zzbozVar, zzbra zzbraVar, zzbtj zzbtjVar, zzbqj zzbqjVar, zzbte zzbteVar) {
        super(zzboqVar, zzbpdVar, zzbpmVar, zzbpwVar, zzbraVar, zzbqjVar, zzbtjVar);
        this.zzgam = zzbteVar;
        this.zzgan = zzbozVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcnd, com.google.android.gms.internal.ads.zzali
    public final void onVideoEnd() {
        this.zzgam.zzrt();
    }

    @Override // com.google.android.gms.internal.ads.zzcnd, com.google.android.gms.internal.ads.zzali
    public final void zza(zzasf zzasfVar) {
        this.zzgam.zza(new zzasd(zzasfVar.getType(), zzasfVar.getAmount()));
    }

    @Override // com.google.android.gms.internal.ads.zzcnd, com.google.android.gms.internal.ads.zzali
    public final void zzb(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzcnd, com.google.android.gms.internal.ads.zzali
    public final void zzb(zzasd zzasdVar) {
        this.zzgam.zza(zzasdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcnd, com.google.android.gms.internal.ads.zzali
    public final void zzco(int i) {
        this.zzgan.zzco(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcnd, com.google.android.gms.internal.ads.zzali
    public final void zzss() {
        this.zzgam.zzrs();
    }

    @Override // com.google.android.gms.internal.ads.zzcnd, com.google.android.gms.internal.ads.zzali
    public final void zzst() {
        this.zzgam.zzrt();
    }
}
