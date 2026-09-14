package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzao;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaaq implements zzafn<zzahn> {
    private final /* synthetic */ EmailAuthCredential zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzaeg zzc;
    private final /* synthetic */ zzaam zzd;

    public zzaaq(zzaam zzaamVar, EmailAuthCredential emailAuthCredential, String str, zzaeg zzaegVar) {
        this.zza = emailAuthCredential;
        this.zzb = str;
        this.zzc = zzaegVar;
        this.zzd = zzaamVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zzc.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzahn zzahnVar) {
        this.zzd.zza(new zzagp(this.zza, zzahnVar.zzc(), this.zzb), this.zzc);
    }
}
