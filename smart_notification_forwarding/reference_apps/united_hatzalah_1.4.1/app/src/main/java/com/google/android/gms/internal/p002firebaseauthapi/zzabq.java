package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* loaded from: classes.dex */
final class zzabq implements zzafn<zzagq> {
    private final /* synthetic */ zzaeg zza;
    private final /* synthetic */ zzabn zzb;

    public zzabq(zzabn zzabnVar, zzaeg zzaegVar) {
        this.zza = zzaegVar;
        this.zzb = zzabnVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzagq zzagqVar) {
        zzagq zzagqVar2 = zzagqVar;
        this.zzb.zza.zza(new zzahn(zzagqVar2.zzb(), zzagqVar2.zza(), Long.valueOf(zzahp.zza(zzagqVar2.zza())), "Bearer"), null, null, Boolean.FALSE, null, this.zza, this);
    }
}
