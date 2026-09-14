package com.google.firebase.remoteconfig.internal.rollouts;

import com.google.firebase.remoteconfig.interop.rollouts.RolloutsState;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4369a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RolloutsStateSubscriber f4370b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RolloutsState f4371c;

    public /* synthetic */ a(RolloutsStateSubscriber rolloutsStateSubscriber, RolloutsState rolloutsState, int i) {
        this.f4369a = i;
        this.f4370b = rolloutsStateSubscriber;
        this.f4371c = rolloutsState;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4369a) {
            case 0:
                RolloutsStateSubscriptionsHandler.b(this.f4370b, this.f4371c);
                return;
            default:
                RolloutsStateSubscriptionsHandler.c(this.f4370b, this.f4371c);
                return;
        }
    }
}
