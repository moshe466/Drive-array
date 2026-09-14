package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;

/* loaded from: classes.dex */
public final class zzfl {
    final zzga a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfl(zzga zzgaVar) {
        this.a = zzgaVar;
    }

    @VisibleForTesting
    private final boolean zza() {
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.a.zzn());
            if (packageManager != null) {
                return packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
            }
            this.a.zzr().zzv().zza("Failed to retrieve Package Manager to check Play Store compatibility");
            return false;
        } catch (Exception e) {
            this.a.zzr().zzv().zza("Failed to retrieve Play Store version", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    @VisibleForTesting
    @WorkerThread
    public final Bundle a(String str, com.google.android.gms.internal.measurement.zzd zzdVar) {
        this.a.zzq().zzd();
        if (zzdVar == null) {
            this.a.zzr().zzi().zza("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle zza = zzdVar.zza(bundle);
            if (zza != null) {
                return zza;
            }
            this.a.zzr().zzf().zza("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e) {
            this.a.zzr().zzf().zza("Exception occurred while retrieving the Install Referrer", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void a(String str) {
        if (str == null || str.isEmpty()) {
            this.a.zzr().zzv().zza("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.a.zzq().zzd();
        if (!zza()) {
            this.a.zzr().zzv().zza("Install Referrer Reporter is not available");
            return;
        }
        this.a.zzr().zzv().zza("Install Referrer Reporter is initializing");
        zzfo zzfoVar = new zzfo(this, str);
        this.a.zzq().zzd();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.a.zzn().getPackageManager();
        if (packageManager == null) {
            this.a.zzr().zzi().zza("Failed to obtain Package Manager to verify binding conditions");
            return;
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.a.zzr().zzv().zza("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ResolveInfo resolveInfo = queryIntentServices.get(0);
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        if (serviceInfo != null) {
            String str2 = serviceInfo.packageName;
            if (resolveInfo.serviceInfo.name == null || !"com.android.vending".equals(str2) || !zza()) {
                this.a.zzr().zzv().zza("Play Store missing or incompatible. Version 8.3.73 or later required");
                return;
            }
            try {
                this.a.zzr().zzv().zza("Install Referrer Service is", ConnectionTracker.getInstance().bindService(this.a.zzn(), new Intent(intent), zzfoVar, 1) ? "available" : "not available");
            } catch (Exception e) {
                this.a.zzr().zzf().zza("Exception occurred while binding to Install Referrer Service", e.getMessage());
            }
        }
    }
}
