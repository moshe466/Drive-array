package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Continuation, SuccessContinuation {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirebaseRemoteConfig f4346a;

    public /* synthetic */ a(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.f4346a = firebaseRemoteConfig;
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        Task lambda$fetchAndActivate$1;
        lambda$fetchAndActivate$1 = this.f4346a.lambda$fetchAndActivate$1((Void) obj);
        return lambda$fetchAndActivate$1;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        boolean processActivatePutTask;
        processActivatePutTask = this.f4346a.processActivatePutTask(task);
        return Boolean.valueOf(processActivatePutTask);
    }
}
