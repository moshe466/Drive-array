package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaap implements zzafn<zzago> {
    private final /* synthetic */ zzaeg zza;
    private final /* synthetic */ zzaam zzb;

    public zzaap(zzaam zzaamVar, zzaeg zzaegVar) {
        this.zza = zzaegVar;
        this.zzb = zzaamVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzago zzagoVar) {
        zzago zzagoVar2 = zzagoVar;
        if (zzagoVar2.zzf()) {
            this.zza.zza(new zzaaj(zzagoVar2.zzc(), zzagoVar2.zze(), null));
        } else {
            this.zzb.zza(new zzahn(zzagoVar2.zzd(), zzagoVar2.zzb(), Long.valueOf(zzagoVar2.zza()), "Bearer"), null, null, Boolean.valueOf(zzagoVar2.zzg()), null, this.zza, this);
        }
    }
}
