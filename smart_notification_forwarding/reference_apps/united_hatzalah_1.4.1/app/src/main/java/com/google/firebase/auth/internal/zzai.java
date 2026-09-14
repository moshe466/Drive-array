package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.MultiFactorSession;

/* loaded from: classes.dex */
final class zzai implements Continuation<GetTokenResult, Task<MultiFactorSession>> {
    private final /* synthetic */ zzaj zza;

    public zzai(zzaj zzajVar) {
        this.zza = zzajVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<MultiFactorSession> then(Task<GetTokenResult> task) {
        zzaf zzafVar;
        if (!task.isSuccessful()) {
            return Tasks.forException((Exception) Preconditions.checkNotNull(task.getException()));
        }
        String token = task.getResult().getToken();
        zzafVar = this.zza.zza;
        return Tasks.forResult(zzam.zza(token, zzafVar));
    }
}
