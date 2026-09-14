package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.settings.SettingsProvider;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4218a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CrashlyticsCore f4219b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SettingsProvider f4220c;

    public /* synthetic */ d(CrashlyticsCore crashlyticsCore, SettingsProvider settingsProvider, int i) {
        this.f4218a = i;
        this.f4219b = crashlyticsCore;
        this.f4220c = settingsProvider;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4218a) {
            case 0:
                this.f4219b.lambda$doBackgroundInitializationAsync$0(this.f4220c);
                return;
            default:
                this.f4219b.lambda$finishInitSynchronously$9(this.f4220c);
                return;
        }
    }
}
