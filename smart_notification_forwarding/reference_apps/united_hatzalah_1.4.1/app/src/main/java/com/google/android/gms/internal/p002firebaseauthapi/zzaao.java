package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaao implements zzafn<zzaih> {
    private final /* synthetic */ zzaeg zza;
    private final /* synthetic */ zzaam zzb;

    public zzaao(zzaam zzaamVar, zzaeg zzaegVar) {
        this.zza = zzaegVar;
        this.zzb = zzaamVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzaih zzaihVar) {
        zzaih zzaihVar2 = zzaihVar;
        this.zzb.zza(new zzahn(zzaihVar2.zzc(), zzaihVar2.zzb(), Long.valueOf(zzaihVar2.zza()), "Bearer"), null, null, Boolean.TRUE, null, this.zza, this);
    }
}
