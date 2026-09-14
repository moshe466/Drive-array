package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzabp implements zzafn<zzags> {
    private final /* synthetic */ zzaeg zza;
    private final /* synthetic */ zzaam zzb;

    public zzabp(zzaam zzaamVar, zzaeg zzaegVar) {
        this.zza = zzaegVar;
        this.zzb = zzaamVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzags zzagsVar) {
        zzags zzagsVar2 = zzagsVar;
        this.zzb.zza(new zzahn(zzagsVar2.zzb(), zzagsVar2.zza(), Long.valueOf(zzahp.zza(zzagsVar2.zza())), "Bearer"), null, null, Boolean.FALSE, null, this.zza, this);
    }
}
