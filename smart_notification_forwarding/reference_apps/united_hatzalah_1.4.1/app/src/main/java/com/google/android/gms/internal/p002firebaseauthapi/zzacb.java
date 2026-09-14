package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzao;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzacb implements zzafn<zzahn> {
    private final /* synthetic */ UserProfileChangeRequest zza;
    private final /* synthetic */ zzaeg zzb;
    private final /* synthetic */ zzaam zzc;

    public zzacb(zzaam zzaamVar, UserProfileChangeRequest userProfileChangeRequest, zzaeg zzaegVar) {
        this.zza = userProfileChangeRequest;
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
        zzaid zzaidVar = new zzaid();
        zzaidVar.zzd(zzahnVar2.zzc());
        if (this.zza.zzb() || this.zza.getDisplayName() != null) {
            zzaidVar.zzb(this.zza.getDisplayName());
        }
        if (this.zza.zzc() || this.zza.getPhotoUri() != null) {
            zzaidVar.zzg(this.zza.zza());
        }
        zzaam.zza(this.zzc, this.zzb, zzahnVar2, zzaidVar, this);
    }
}
