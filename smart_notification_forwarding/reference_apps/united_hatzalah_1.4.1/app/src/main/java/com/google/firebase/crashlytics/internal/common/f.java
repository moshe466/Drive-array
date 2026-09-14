package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4222a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CrashlyticsCore f4223b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4224c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f4225d;

    public /* synthetic */ f(CrashlyticsCore crashlyticsCore, String str, String str2, int i) {
        this.f4222a = i;
        this.f4223b = crashlyticsCore;
        this.f4224c = str;
        this.f4225d = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4222a) {
            case 0:
                CrashlyticsCore.g(this.f4223b, this.f4224c, this.f4225d);
                return;
            default:
                CrashlyticsCore.k(this.f4223b, this.f4224c, this.f4225d);
                return;
        }
    }
}
