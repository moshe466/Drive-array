package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final /* synthetic */ class DisplayCallbacksImpl$$Lambda$11 implements Callable {
    private final TaskCompletionSource arg$1;

    private DisplayCallbacksImpl$$Lambda$11(TaskCompletionSource taskCompletionSource) {
        this.arg$1 = taskCompletionSource;
    }

    public static Callable lambdaFactory$(TaskCompletionSource taskCompletionSource) {
        return new DisplayCallbacksImpl$$Lambda$11(taskCompletionSource);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return DisplayCallbacksImpl.a(this.arg$1);
    }
}
