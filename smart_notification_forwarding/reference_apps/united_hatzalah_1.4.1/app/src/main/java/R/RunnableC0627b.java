package r;

import android.os.Bundle;

/* renamed from: r.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0627b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6158a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f6159b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BinderC0632g f6160c;

    public /* synthetic */ RunnableC0627b(int i, Bundle bundle, BinderC0632g binderC0632g) {
        this.f6158a = i;
        this.f6160c = binderC0632g;
        this.f6159b = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6158a) {
            case 0:
                this.f6160c.f6182b.onUnminimized(this.f6159b);
                return;
            case 1:
                this.f6160c.f6182b.onMessageChannelReady(this.f6159b);
                return;
            case 2:
                this.f6160c.f6182b.onWarmupCompleted(this.f6159b);
                return;
            default:
                this.f6160c.f6182b.onMinimized(this.f6159b);
                return;
        }
    }
}
