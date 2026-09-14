package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzacd implements zzafn<zzahn> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzaeg zzb;
    private final /* synthetic */ zzaam zzc;

    public zzacd(zzaam zzaamVar, String str, zzaeg zzaegVar) {
        this.zza = str;
        this.zzb = zzaegVar;
        this.zzc = zzaamVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zzb.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzahn zzahnVar) {
        zzahn zzahnVar2 = zzahnVar;
        String zzc = zzahnVar2.zzc();
        zzaid zzaidVar = new zzaid();
        zzaidVar.zzd(zzc).zzf(this.zza);
        zzaam.zza(this.zzc, this.zzb, zzahnVar2, zzaidVar, this);
    }
}
