package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzabn implements zzafn<zzahn> {
    final /* synthetic */ zzaam zza;
    private final /* synthetic */ zzagr zzb;
    private final /* synthetic */ zzaeg zzc;

    public zzabn(zzaam zzaamVar, zzagr zzagrVar, zzaeg zzaegVar) {
        this.zzb = zzagrVar;
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
        zzaflVar.zza(this.zzb, new zzabq(this, this.zzc));
    }
}
