package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4318a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f4319b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f4320c;

    public /* synthetic */ f(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource, int i) {
        this.f4318a = i;
        this.f4319b = firebaseMessaging;
        this.f4320c = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4318a) {
            case 0:
                this.f4319b.lambda$deleteToken$9(this.f4320c);
                return;
            case 1:
                this.f4319b.lambda$getToken$7(this.f4320c);
                return;
            default:
                this.f4319b.lambda$deleteToken$8(this.f4320c);
                return;
        }
    }
}
