package com.google.firebase.crashlytics;

import r3.e;
import r3.h;

/* loaded from: classes.dex */
final /* synthetic */ class b implements h {

    /* renamed from: a, reason: collision with root package name */
    private final CrashlyticsRegistrar f7055a;

    private b(CrashlyticsRegistrar crashlyticsRegistrar) {
        this.f7055a = crashlyticsRegistrar;
    }

    public static h b(CrashlyticsRegistrar crashlyticsRegistrar) {
        return new b(crashlyticsRegistrar);
    }

    @Override // r3.h
    public Object a(e eVar) {
        c b10;
        b10 = this.f7055a.b(eVar);
        return b10;
    }
}
