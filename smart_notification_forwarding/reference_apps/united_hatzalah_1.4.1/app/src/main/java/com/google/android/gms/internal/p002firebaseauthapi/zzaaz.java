package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaaz implements zzafn<zzajb> {
    private final /* synthetic */ zzaeg zza;
    private final /* synthetic */ zzaam zzb;

    public zzaaz(zzaam zzaamVar, zzaeg zzaegVar) {
        this.zza = zzaegVar;
        this.zzb = zzaamVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzajb zzajbVar) {
        zzajb zzajbVar2 = zzajbVar;
        this.zzb.zza(new zzahn(zzajbVar2.zzd(), zzajbVar2.zzb(), Long.valueOf(zzajbVar2.zza()), "Bearer"), null, null, Boolean.valueOf(zzajbVar2.zzf()), null, this.zza, this);
    }
}
