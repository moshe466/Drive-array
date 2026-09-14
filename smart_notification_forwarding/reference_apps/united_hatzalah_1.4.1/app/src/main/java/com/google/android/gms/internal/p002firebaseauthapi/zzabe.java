package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzabe implements zzafn<zzahn> {
    final /* synthetic */ zzaam zza;
    private final /* synthetic */ zzaiy zzb;
    private final /* synthetic */ zzaeg zzc;

    public zzabe(zzaam zzaamVar, zzaiy zzaiyVar, zzaeg zzaegVar) {
        this.zzb = zzaiyVar;
        this.zzc = zzaegVar;
        this.zza = zzaamVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zzc.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzahn zzahnVar) {
        zzafl zzaflVar;
        this.zzb.zza(zzahnVar.zzc());
        zzaflVar = this.zza.zza;
        zzaflVar.zza(this.zzb, new zzabd(this, this.zzc, this));
    }
}
