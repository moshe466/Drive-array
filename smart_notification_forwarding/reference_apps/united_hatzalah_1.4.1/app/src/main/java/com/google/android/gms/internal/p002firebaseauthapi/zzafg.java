package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class zzafg {
    zzaef zza;
    Executor zzb;

    public final <ResultT> Task<ResultT> zza(final zzafi<ResultT> zzafiVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.firebase-auth-api.zzafj
            @Override // java.lang.Runnable
            public final void run() {
                zzafiVar.zza(taskCompletionSource, zzafg.this.zza);
            }
        });
        return taskCompletionSource.getTask();
    }
}
