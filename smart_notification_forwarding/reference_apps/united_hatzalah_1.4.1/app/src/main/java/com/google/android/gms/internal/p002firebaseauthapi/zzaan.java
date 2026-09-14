package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaan implements zzafn<zzaiz> {
    private final /* synthetic */ zzaeg zza;
    private final /* synthetic */ zzaam zzb;

    public zzaan(zzaam zzaamVar, zzaeg zzaegVar) {
        this.zza = zzaegVar;
        this.zzb = zzaamVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzaiz zzaizVar) {
        zzaiz zzaizVar2 = zzaizVar;
        if (zzaizVar2.zzf()) {
            this.zza.zza(new zzaaj(zzaizVar2.zzc(), zzaizVar2.zze(), null));
        } else {
            this.zzb.zza(new zzahn(zzaizVar2.zzd(), zzaizVar2.zzb(), Long.valueOf(zzaizVar2.zza()), "Bearer"), null, null, Boolean.FALSE, null, this.zza, this);
        }
    }
}
