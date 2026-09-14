package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import java.util.List;

/* loaded from: classes.dex */
public final class n4 {

    /* renamed from: a, reason: collision with root package name */
    final t4 f6248a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n4(t4 t4Var) {
        this.f6248a = t4Var;
    }

    private final boolean c() {
        try {
            i2.b a10 = i2.c.a(this.f6248a.i());
            if (a10 != null) {
                return a10.e("com.android.vending", 128).versionCode >= 80837300;
            }
            this.f6248a.h().N().a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e10) {
            this.f6248a.h().N().b("Failed to retrieve Play Store version for Install Referrer", e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle a(String str, com.google.android.gms.internal.measurement.l2 l2Var) {
        this.f6248a.e().c();
        if (l2Var == null) {
            this.f6248a.h().I().a("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle f10 = l2Var.f(bundle);
            if (f10 != null) {
                return f10;
            }
            this.f6248a.h().F().a("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e10) {
            this.f6248a.h().F().b("Exception occurred while retrieving the Install Referrer", e10.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(String str) {
        if (str == null || str.isEmpty()) {
            this.f6248a.h().J().a("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.f6248a.e().c();
        if (!c()) {
            this.f6248a.h().L().a("Install Referrer Reporter is not available");
            return;
        }
        m4 m4Var = new m4(this, str);
        this.f6248a.e().c();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.f6248a.i().getPackageManager();
        if (packageManager == null) {
            this.f6248a.h().J().a("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
            return;
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.f6248a.h().L().a("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
        if (serviceInfo != null) {
            String str2 = serviceInfo.packageName;
            if (serviceInfo.name == null || !"com.android.vending".equals(str2) || !c()) {
                this.f6248a.h().I().a("Play Store version 8.3.73 or higher required for Install Referrer");
                return;
            }
            try {
                this.f6248a.h().N().b("Install Referrer Service is", f2.a.b().a(this.f6248a.i(), new Intent(intent), m4Var, 1) ? "available" : "not available");
            } catch (Exception e10) {
                this.f6248a.h().F().b("Exception occurred while binding to Install Referrer Service", e10.getMessage());
            }
        }
    }
}
