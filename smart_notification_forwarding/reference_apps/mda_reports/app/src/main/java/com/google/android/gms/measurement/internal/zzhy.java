package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.MainThread;
import com.google.android.gms.internal.measurement.zzkt;
import com.google.android.gms.internal.measurement.zzlk;

/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(14)
@MainThread
/* loaded from: classes.dex */
public final class zzhy implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzhb zza;

    private zzhy(zzhb zzhbVar) {
        this.zza = zzhbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhy(zzhb zzhbVar, zzhd zzhdVar) {
        this(zzhbVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009c A[Catch: Exception -> 0x01a7, TRY_ENTER, TryCatch #0 {Exception -> 0x01a7, blocks: (B:3:0x0006, B:6:0x0020, B:8:0x002e, B:14:0x009c, B:16:0x00aa, B:18:0x00bd, B:21:0x00c5, B:23:0x00cb, B:24:0x00de, B:25:0x00e5, B:28:0x00f5, B:31:0x0105, B:34:0x010d, B:36:0x0113, B:37:0x011e, B:41:0x0125, B:45:0x0146, B:46:0x015b, B:48:0x014c, B:49:0x0162, B:51:0x0168, B:53:0x016e, B:55:0x0174, B:57:0x017a, B:59:0x0182, B:63:0x018d, B:65:0x019b, B:67:0x01a1, B:71:0x003f, B:74:0x004c, B:76:0x0052, B:78:0x0058, B:80:0x005e, B:82:0x0064, B:83:0x0070, B:85:0x007c, B:86:0x0087, B:88:0x0091, B:89:0x0081), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f5 A[Catch: Exception -> 0x01a7, TRY_ENTER, TryCatch #0 {Exception -> 0x01a7, blocks: (B:3:0x0006, B:6:0x0020, B:8:0x002e, B:14:0x009c, B:16:0x00aa, B:18:0x00bd, B:21:0x00c5, B:23:0x00cb, B:24:0x00de, B:25:0x00e5, B:28:0x00f5, B:31:0x0105, B:34:0x010d, B:36:0x0113, B:37:0x011e, B:41:0x0125, B:45:0x0146, B:46:0x015b, B:48:0x014c, B:49:0x0162, B:51:0x0168, B:53:0x016e, B:55:0x0174, B:57:0x017a, B:59:0x0182, B:63:0x018d, B:65:0x019b, B:67:0x01a1, B:71:0x003f, B:74:0x004c, B:76:0x0052, B:78:0x0058, B:80:0x005e, B:82:0x0064, B:83:0x0070, B:85:0x007c, B:86:0x0087, B:88:0x0091, B:89:0x0081), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0124 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0125 A[Catch: Exception -> 0x01a7, TRY_LEAVE, TryCatch #0 {Exception -> 0x01a7, blocks: (B:3:0x0006, B:6:0x0020, B:8:0x002e, B:14:0x009c, B:16:0x00aa, B:18:0x00bd, B:21:0x00c5, B:23:0x00cb, B:24:0x00de, B:25:0x00e5, B:28:0x00f5, B:31:0x0105, B:34:0x010d, B:36:0x0113, B:37:0x011e, B:41:0x0125, B:45:0x0146, B:46:0x015b, B:48:0x014c, B:49:0x0162, B:51:0x0168, B:53:0x016e, B:55:0x0174, B:57:0x017a, B:59:0x0182, B:63:0x018d, B:65:0x019b, B:67:0x01a1, B:71:0x003f, B:74:0x004c, B:76:0x0052, B:78:0x0058, B:80:0x005e, B:82:0x0064, B:83:0x0070, B:85:0x007c, B:86:0x0087, B:88:0x0091, B:89:0x0081), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(boolean r18, android.net.Uri r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhy.zza(boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Uri data;
        try {
            try {
                this.zza.zzr().zzx().zza("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null && (data = intent.getData()) != null && data.isHierarchical()) {
                    this.zza.zzp();
                    String str = zzkm.a(intent) ? "gs" : "auto";
                    String queryParameter = data.getQueryParameter("referrer");
                    boolean z = bundle == null;
                    if (zzlk.zzb() && zzap.zzbz.zza(null).booleanValue()) {
                        this.zza.zzq().zza(new zzhx(this, z, data, str, queryParameter));
                    } else {
                        zza(z, data, str, queryParameter);
                    }
                }
            } catch (Exception e) {
                this.zza.zzr().zzf().zza("Throwable caught in onActivityCreated", e);
            }
        } finally {
            this.zza.zzi().zza(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzi().zzc(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @MainThread
    public final void onActivityPaused(Activity activity) {
        this.zza.zzi().zzb(activity);
        zzjo zzk = this.zza.zzk();
        zzk.zzq().zza(new zzjq(zzk, zzk.zzm().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @MainThread
    public final void onActivityResumed(Activity activity) {
        if (zzkt.zzb() && zzap.zzav.zza(null).booleanValue()) {
            this.zza.zzk().zzab();
            this.zza.zzi().zza(activity);
        } else {
            this.zza.zzi().zza(activity);
            this.zza.zzk().zzab();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzi().zzb(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
