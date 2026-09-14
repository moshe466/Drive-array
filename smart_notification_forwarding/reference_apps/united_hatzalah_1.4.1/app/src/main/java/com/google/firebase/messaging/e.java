package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements SuccessContinuation {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4316a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4317b;

    public /* synthetic */ e(String str, int i) {
        this.f4316a = i;
        this.f4317b = str;
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final Task then(Object obj) {
        Task lambda$subscribeToTopic$10;
        Task lambda$unsubscribeFromTopic$11;
        switch (this.f4316a) {
            case 0:
                lambda$subscribeToTopic$10 = FirebaseMessaging.lambda$subscribeToTopic$10(this.f4317b, (TopicsSubscriber) obj);
                return lambda$subscribeToTopic$10;
            default:
                lambda$unsubscribeFromTopic$11 = FirebaseMessaging.lambda$unsubscribeFromTopic$11(this.f4317b, (TopicsSubscriber) obj);
                return lambda$unsubscribeFromTopic$11;
        }
    }
}
