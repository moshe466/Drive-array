package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements Continuation, OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4330a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4331b;

    public /* synthetic */ l(Object obj, int i) {
        this.f4330a = i;
        this.f4331b = obj;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        switch (this.f4330a) {
            case 1:
                WakeLockHolder.completeWakefulIntent((Intent) this.f4331b);
                return;
            case 2:
                WithinAppServiceBinder.a((WithinAppServiceConnection.BindRequest) this.f4331b, task);
                return;
            default:
                ((ScheduledFuture) this.f4331b).cancel(false);
                return;
        }
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return GmsRpc.a((GmsRpc) this.f4331b, task);
    }
}
