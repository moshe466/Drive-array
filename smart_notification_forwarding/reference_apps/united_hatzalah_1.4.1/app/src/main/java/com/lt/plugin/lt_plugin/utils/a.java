package com.lt.plugin.lt_plugin.utils;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Continuation, OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirebaseHelper f4394a;

    public /* synthetic */ a(FirebaseHelper firebaseHelper) {
        this.f4394a = firebaseHelper;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        this.f4394a.lambda$registerToken$1(task);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        Object lambda$new$0;
        lambda$new$0 = this.f4394a.lambda$new$0(task);
        return lambda$new$0;
    }
}
