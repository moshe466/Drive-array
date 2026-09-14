package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaij;
import com.google.android.gms.internal.p002firebaseauthapi.zzaip;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.internal.zzcc;
import e0.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzv implements Continuation<zzaij, Task<TotpSecret>> {
    private final /* synthetic */ FirebaseAuth zza;

    public zzv(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<TotpSecret> then(Task<zzaij> task) {
        if (!task.isSuccessful()) {
            return Tasks.forException((Exception) Preconditions.checkNotNull(task.getException()));
        }
        zzaij result = task.getResult();
        if (result instanceof zzaip) {
            zzaip zzaipVar = (zzaip) result;
            return Tasks.forResult(new zzcc(Preconditions.checkNotEmpty(zzaipVar.zzf()), Preconditions.checkNotEmpty(zzaipVar.zze()), zzaipVar.zzc(), zzaipVar.zzb(), zzaipVar.zzd(), Preconditions.checkNotEmpty(zzaipVar.zza()), this.zza));
        }
        throw new IllegalArgumentException(a.e("Response should be an instance of StartTotpMfaEnrollmentResponse but was ", result.getClass().getName(), "."));
    }
}
