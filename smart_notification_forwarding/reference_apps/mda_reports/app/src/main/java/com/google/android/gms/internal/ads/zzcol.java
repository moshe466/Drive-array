package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcol extends zzvl {
    private final zzcot zzgcq;

    public zzcol(Context context, zzbfx zzbfxVar, zzczw zzczwVar, zzbwz zzbwzVar, zzvh zzvhVar) {
        zzcov zzcovVar = new zzcov(zzbwzVar);
        zzcovVar.zzc(zzvhVar);
        this.zzgcq = new zzcot(new zzcpb(zzbfxVar, context, zzcovVar, zzczwVar), zzczwVar.zzaor());
    }

    @Override // com.google.android.gms.internal.ads.zzvm
    public final synchronized String getMediationAdapterClassName() {
        return this.zzgcq.getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzvm
    public final synchronized boolean isLoading() {
        return this.zzgcq.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzvm
    public final synchronized void zza(zzug zzugVar, int i) {
        this.zzgcq.zza(zzugVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzvm
    public final void zzb(zzug zzugVar) {
        this.zzgcq.zza(zzugVar, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzvm
    public final synchronized String zzka() {
        return this.zzgcq.zzka();
    }
}
