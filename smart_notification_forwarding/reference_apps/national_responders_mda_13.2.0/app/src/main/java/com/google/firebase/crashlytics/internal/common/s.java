package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f7231a;

    /* renamed from: b, reason: collision with root package name */
    private final o3.c f7232b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f7233c;

    /* renamed from: d, reason: collision with root package name */
    z2.m<Void> f7234d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f7235e;

    /* renamed from: f, reason: collision with root package name */
    private Boolean f7236f;

    /* renamed from: g, reason: collision with root package name */
    private z2.m<Void> f7237g;

    public s(o3.c cVar) {
        Object obj = new Object();
        this.f7233c = obj;
        this.f7234d = new z2.m<>();
        this.f7235e = false;
        this.f7237g = new z2.m<>();
        Context g10 = cVar.g();
        this.f7232b = cVar;
        this.f7231a = h.t(g10);
        Boolean b10 = b();
        this.f7236f = b10 == null ? a(g10) : b10;
        synchronized (obj) {
            if (d()) {
                this.f7234d.e(null);
            }
        }
    }

    private Boolean a(Context context) {
        Boolean f10 = f(context);
        if (f10 == null) {
            this.f7235e = false;
            return null;
        }
        this.f7235e = true;
        return Boolean.valueOf(Boolean.TRUE.equals(f10));
    }

    private Boolean b() {
        if (!this.f7231a.contains("firebase_crashlytics_collection_enabled")) {
            return null;
        }
        this.f7235e = false;
        return Boolean.valueOf(this.f7231a.getBoolean("firebase_crashlytics_collection_enabled", true));
    }

    private void e(boolean z10) {
        s3.b.f().b(String.format("Crashlytics automatic data collection %s by %s.", z10 ? "ENABLED" : "DISABLED", this.f7236f == null ? "global Firebase setting" : this.f7235e ? "firebase_crashlytics_collection_enabled manifest flag" : "API"));
    }

    private static Boolean f(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
        } catch (PackageManager.NameNotFoundException e10) {
            s3.b.f().c("Unable to get PackageManager. Falling through", e10);
            return null;
        }
    }

    public void c(boolean z10) {
        if (!z10) {
            throw new IllegalStateException("An invalid data collection token was used.");
        }
        this.f7237g.e(null);
    }

    public synchronized boolean d() {
        boolean booleanValue;
        Boolean bool = this.f7236f;
        booleanValue = bool != null ? bool.booleanValue() : this.f7232b.p();
        e(booleanValue);
        return booleanValue;
    }

    public z2.l<Void> g() {
        z2.l<Void> a10;
        synchronized (this.f7233c) {
            a10 = this.f7234d.a();
        }
        return a10;
    }

    public z2.l<Void> h() {
        return k0.h(this.f7237g.a(), g());
    }
}
