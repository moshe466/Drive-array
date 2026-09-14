package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4226a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CrashlyticsCore f4227b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f4228c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f4229d;

    public /* synthetic */ g(CrashlyticsCore crashlyticsCore, long j2, String str, int i) {
        this.f4226a = i;
        this.f4227b = crashlyticsCore;
        this.f4228c = j2;
        this.f4229d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4226a) {
            case 0:
                this.f4227b.lambda$log$2(this.f4228c, this.f4229d);
                return;
            default:
                this.f4227b.lambda$log$3(this.f4228c, this.f4229d);
                return;
        }
    }
}
