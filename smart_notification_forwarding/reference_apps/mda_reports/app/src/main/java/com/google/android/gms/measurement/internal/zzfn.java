package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes.dex */
final class zzfn implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzd zza;
    private final /* synthetic */ ServiceConnection zzb;
    private final /* synthetic */ zzfo zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfn(zzfo zzfoVar, com.google.android.gms.internal.measurement.zzd zzdVar, ServiceConnection serviceConnection) {
        this.zzc = zzfoVar;
        this.zza = zzdVar;
        this.zzb = serviceConnection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        zzey zzf;
        String str2;
        zzfo zzfoVar = this.zzc;
        zzfl zzflVar = zzfoVar.a;
        str = zzfoVar.zzb;
        com.google.android.gms.internal.measurement.zzd zzdVar = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        Bundle a = zzflVar.a(str, zzdVar);
        zzflVar.a.zzq().zzd();
        if (a != null) {
            long j = a.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j == 0) {
                zzf = zzflVar.a.zzr().zzf();
                str2 = "Service response is missing Install Referrer install timestamp";
            } else {
                String string = a.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzf = zzflVar.a.zzr().zzf();
                    str2 = "No referrer defined in install referrer response";
                } else {
                    zzflVar.a.zzr().zzx().zza("InstallReferrer API result", string);
                    zzkm zzi = zzflVar.a.zzi();
                    String valueOf = String.valueOf(string);
                    Bundle a2 = zzi.a(Uri.parse(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")));
                    if (a2 == null) {
                        zzf = zzflVar.a.zzr().zzf();
                        str2 = "No campaign params defined in install referrer result";
                    } else {
                        String string2 = a2.getString(FirebaseAnalytics.Param.MEDIUM);
                        if ((string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) ? false : true) {
                            long j2 = a.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j2 == 0) {
                                zzf = zzflVar.a.zzr().zzf();
                                str2 = "Install Referrer is missing click timestamp for ad campaign";
                            } else {
                                a2.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzflVar.a.zzc().zzi.zza()) {
                            zzflVar.a.zzu();
                            zzf = zzflVar.a.zzr().zzx();
                            str2 = "Campaign has already been logged";
                        } else {
                            zzflVar.a.zzc().zzi.zza(j);
                            zzflVar.a.zzu();
                            zzflVar.a.zzr().zzx().zza("Logging Install Referrer campaign from sdk with ", "referrer API");
                            a2.putString("_cis", "referrer API");
                            zzflVar.a.zzh().zza("auto", "_cmp", a2);
                        }
                    }
                }
            }
            zzf.zza(str2);
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzflVar.a.zzn(), serviceConnection);
        }
    }
}
