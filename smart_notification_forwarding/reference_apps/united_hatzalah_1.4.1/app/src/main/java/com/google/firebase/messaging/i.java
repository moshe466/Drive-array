package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.messaging.Store;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements SuccessContinuation, RequestDeduplicator.GetTokenRequest {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f4325a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4326b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Store.Token f4327c;

    public /* synthetic */ i(FirebaseMessaging firebaseMessaging, String str, Store.Token token) {
        this.f4325a = firebaseMessaging;
        this.f4326b = str;
        this.f4327c = token;
    }

    @Override // com.google.firebase.messaging.RequestDeduplicator.GetTokenRequest
    public Task start() {
        Task lambda$blockingGetToken$14;
        lambda$blockingGetToken$14 = this.f4325a.lambda$blockingGetToken$14(this.f4326b, this.f4327c);
        return lambda$blockingGetToken$14;
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        Task lambda$blockingGetToken$13;
        lambda$blockingGetToken$13 = this.f4325a.lambda$blockingGetToken$13(this.f4326b, this.f4327c, (String) obj);
        return lambda$blockingGetToken$13;
    }
}
