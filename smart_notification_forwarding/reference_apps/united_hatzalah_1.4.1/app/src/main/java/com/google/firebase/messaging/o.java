package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public final /* synthetic */ class o implements Continuation, OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f4337a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4338b;

    public /* synthetic */ o(Object obj, Object obj2) {
        this.f4337a = obj;
        this.f4338b = obj2;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        EnhancedIntentService.b((EnhancedIntentService) this.f4337a, (Intent) this.f4338b, task);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return RequestDeduplicator.a((RequestDeduplicator) this.f4337a, (String) this.f4338b, task);
    }
}
