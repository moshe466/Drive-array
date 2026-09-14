package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4313a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4314b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4315c;

    public /* synthetic */ d(int i, Object obj, Object obj2) {
        this.f4313a = i;
        this.f4314b = obj;
        this.f4315c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4313a) {
            case 0:
                FcmLifecycleCallbacks.a((FcmLifecycleCallbacks) this.f4314b, (Intent) this.f4315c);
                return;
            default:
                ImageDownload.a((ImageDownload) this.f4314b, (TaskCompletionSource) this.f4315c);
                return;
        }
    }
}
