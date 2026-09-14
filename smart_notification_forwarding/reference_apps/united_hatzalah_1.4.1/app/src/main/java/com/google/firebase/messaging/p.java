package com.google.firebase.messaging;

import com.google.firebase.messaging.WithinAppServiceConnection;

/* loaded from: classes.dex */
public final /* synthetic */ class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4339a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4340b;

    public /* synthetic */ p(Object obj, int i) {
        this.f4339a = i;
        this.f4340b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4339a) {
            case 0:
                ((SharedPreferencesQueue) this.f4340b).syncState();
                return;
            default:
                WithinAppServiceConnection.BindRequest.b((WithinAppServiceConnection.BindRequest) this.f4340b);
                return;
        }
    }
}
