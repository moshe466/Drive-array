package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/* loaded from: classes.dex */
public final class zzafh<ResultT, CallbackT> implements zzaey<ResultT> {
    private final zzaex<ResultT, CallbackT> zza;
    private final TaskCompletionSource<ResultT> zzb;

    public zzafh(zzaex<ResultT, CallbackT> zzaexVar, TaskCompletionSource<ResultT> taskCompletionSource) {
        this.zza = zzaexVar;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaey
    public final void zza(ResultT resultt, Status status) {
        FirebaseUser firebaseUser;
        Preconditions.checkNotNull(this.zzb, "completion source cannot be null");
        if (status != null) {
            zzaex<ResultT, CallbackT> zzaexVar = this.zza;
            if (zzaexVar.zzq != null) {
                TaskCompletionSource<ResultT> taskCompletionSource = this.zzb;
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(zzaexVar.zzc);
                zzaex<ResultT, CallbackT> zzaexVar2 = this.zza;
                zzaaj zzaajVar = zzaexVar2.zzq;
                if (!"reauthenticateWithCredential".equals(zzaexVar2.zza()) && !"reauthenticateWithCredentialWithData".equals(this.zza.zza())) {
                    firebaseUser = null;
                } else {
                    firebaseUser = this.zza.zzd;
                }
                taskCompletionSource.setException(zzaei.zza(firebaseAuth, zzaajVar, firebaseUser));
                return;
            }
            AuthCredential authCredential = zzaexVar.zzn;
            if (authCredential != null) {
                this.zzb.setException(zzaei.zza(status, authCredential, zzaexVar.zzo, zzaexVar.zzp));
                return;
            } else {
                this.zzb.setException(zzaei.zza(status));
                return;
            }
        }
        this.zzb.setResult(resultt);
    }
}
