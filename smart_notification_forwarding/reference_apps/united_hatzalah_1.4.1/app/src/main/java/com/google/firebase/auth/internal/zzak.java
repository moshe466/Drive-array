package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

/* loaded from: classes.dex */
final class zzak implements Continuation<AuthResult, Task<AuthResult>> {
    private final /* synthetic */ zzal zza;

    public zzak(zzal zzalVar) {
        this.zza = zzalVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<AuthResult> then(Task<AuthResult> task) {
        com.google.firebase.auth.zzc zzcVar;
        com.google.firebase.auth.zzc zzcVar2;
        com.google.firebase.auth.zzc zzcVar3;
        zzcVar = this.zza.zzd;
        if (zzcVar == null) {
            return task;
        }
        if (task.isSuccessful()) {
            AuthResult result = task.getResult();
            zzaf zzafVar = (zzaf) result.getUser();
            zzx zzxVar = (zzx) result.getAdditionalUserInfo();
            zzcVar3 = this.zza.zzd;
            return Tasks.forResult(new zzz(zzafVar, zzxVar, zzcVar3));
        }
        Exception exception = task.getException();
        if (exception instanceof FirebaseAuthUserCollisionException) {
            zzcVar2 = this.zza.zzd;
            ((FirebaseAuthUserCollisionException) exception).zza(zzcVar2);
        }
        return Tasks.forException(exception);
    }
}
