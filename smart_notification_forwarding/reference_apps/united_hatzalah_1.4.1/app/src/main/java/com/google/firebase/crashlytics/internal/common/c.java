package com.google.firebase.crashlytics.internal.common;

import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4215a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4216b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4217c;

    public /* synthetic */ c(int i, Object obj, Object obj2) {
        this.f4215a = i;
        this.f4216b = obj;
        this.f4217c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4215a) {
            case 0:
                CrashlyticsController.b((CrashlyticsController) this.f4216b, (String) this.f4217c);
                return;
            case 1:
                CrashlyticsCore.h((CrashlyticsCore) this.f4216b, (Map) this.f4217c);
                return;
            case 2:
                CrashlyticsCore.c((CrashlyticsCore) this.f4216b, (Throwable) this.f4217c);
                return;
            default:
                CrashlyticsCore.d((CrashlyticsCore) this.f4216b, (String) this.f4217c);
                return;
        }
    }
}
