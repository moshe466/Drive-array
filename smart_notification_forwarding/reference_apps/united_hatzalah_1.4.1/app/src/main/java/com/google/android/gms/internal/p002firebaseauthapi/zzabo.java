package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import e0.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzabo implements zzafn<zzaij> {
    private final /* synthetic */ zzaig zza;
    private final /* synthetic */ zzaeg zzb;

    public zzabo(zzaam zzaamVar, zzaig zzaigVar, zzaeg zzaegVar) {
        this.zza = zzaigVar;
        this.zzb = zzaegVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zzb.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzaij zzaijVar) {
        zzaij zzaijVar2 = zzaijVar;
        zzaig zzaigVar = this.zza;
        if (zzaigVar instanceof zzaik) {
            this.zzb.zzb(zzaijVar2.zza());
        } else {
            if (zzaigVar instanceof zzaim) {
                this.zzb.zza(zzaijVar2);
                return;
            }
            throw new IllegalArgumentException(a.e("startMfaEnrollmentRequest must be an instance of either StartPhoneMfaEnrollmentRequest or StartTotpMfaEnrollmentRequest but was ", this.zza.getClass().getName(), "."));
        }
    }
}
