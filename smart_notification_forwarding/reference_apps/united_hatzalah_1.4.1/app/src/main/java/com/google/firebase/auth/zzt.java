package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.internal.zzav;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzt implements zzav {
    private final /* synthetic */ FirebaseUser zza;
    private final /* synthetic */ FirebaseAuth zzb;

    public zzt(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.zza = firebaseUser;
        this.zzb = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzav
    public final void zza() {
        FirebaseUser firebaseUser;
        FirebaseUser firebaseUser2;
        firebaseUser = this.zzb.zzf;
        if (firebaseUser != null) {
            firebaseUser2 = this.zzb.zzf;
            if (firebaseUser2.getUid().equalsIgnoreCase(this.zza.getUid())) {
                this.zzb.zzh();
            }
        }
    }

    @Override // com.google.firebase.auth.internal.zzau
    public final void zza(Status status) {
        if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005) {
            this.zzb.signOut();
        }
    }
}
