package com.google.android.recaptcha.internal;

import P2.J;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final class zzas {
    public static final Task zza(J j2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(new CancellationTokenSource().getToken());
        j2.invokeOnCompletion(new zzar(taskCompletionSource, j2));
        return taskCompletionSource.getTask();
    }
}
