package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class zzaku {
    private static zzaku zzdbm;
    private AtomicBoolean zzdbn = new AtomicBoolean(false);

    @VisibleForTesting
    zzaku() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Context context) {
        zzzn.initialize(context);
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcil)).booleanValue() && zzn(context)) {
            zza(context, AppMeasurementSdk.getInstance(context));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Context context, String str) {
        boolean z;
        zzzn.initialize(context);
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcih)).booleanValue()) {
            if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcig)).booleanValue()) {
                z = false;
                Bundle bundle = new Bundle();
                bundle.putBoolean("measurementEnabled", z);
                zza(context, AppMeasurementSdk.getInstance(context, "FA-Ads", "am", str, bundle));
            }
        }
        z = true;
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("measurementEnabled", z);
        zza(context, AppMeasurementSdk.getInstance(context, "FA-Ads", "am", str, bundle2));
    }

    private static void zza(Context context, AppMeasurementSdk appMeasurementSdk) {
        try {
            ((zzbfs) zzayx.zza(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", zzakv.a)).zza(ObjectWrapper.wrap(context), new zzakr(appMeasurementSdk));
        } catch (RemoteException | zzayz | NullPointerException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    private static boolean zzn(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static zzaku zzsj() {
        if (zzdbm == null) {
            zzdbm = new zzaku();
        }
        return zzdbm;
    }

    @Nullable
    public final Thread zzc(final Context context, final String str) {
        if (!this.zzdbn.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new Runnable(this, context, str) { // from class: com.google.android.gms.internal.ads.zzakt
            private final Context zzcey;
            private final zzaku zzdbk;
            private final String zzdbl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdbk = this;
                this.zzcey = context;
                this.zzdbl = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzaku.a(this.zzcey, this.zzdbl);
            }
        });
        thread.start();
        return thread;
    }

    @Nullable
    public final Thread zzm(final Context context) {
        if (!this.zzdbn.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new Runnable(this, context) { // from class: com.google.android.gms.internal.ads.zzakw
            private final Context zzcey;
            private final zzaku zzdbk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdbk = this;
                this.zzcey = context;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzaku.a(this.zzcey);
            }
        });
        thread.start();
        return thread;
    }
}
