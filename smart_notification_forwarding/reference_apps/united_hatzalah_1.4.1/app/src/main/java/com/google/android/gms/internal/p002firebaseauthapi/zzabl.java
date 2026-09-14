package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzabl implements zzafn<zzaiv> {
    private final /* synthetic */ zzaeg zza;
    private final /* synthetic */ zzaam zzb;

    public zzabl(zzaam zzaamVar, zzaeg zzaegVar) {
        this.zza = zzaegVar;
        this.zzb = zzaamVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzaiv zzaivVar) {
        zzaiv zzaivVar2 = zzaivVar;
        if (!zzaivVar2.zzl()) {
            zzaam.zza(this.zzb, zzaivVar2, this.zza, this);
        } else {
            this.zza.zza(new zzaaj(zzaivVar2.zzf(), zzaivVar2.zzk(), zzaivVar2.zzb()));
        }
    }
}
