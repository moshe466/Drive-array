package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.common.util.VisibleForTesting;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzavl {

    @VisibleForTesting
    private final String zzdrj;
    private final zzavu zzdrk;

    @VisibleForTesting
    private long zzdre = -1;

    @VisibleForTesting
    private long zzdrf = -1;

    @VisibleForTesting
    @GuardedBy("lock")
    private int zzdrg = -1;

    @VisibleForTesting
    int a = -1;

    @VisibleForTesting
    private long zzdri = 0;
    private final Object lock = new Object();

    @VisibleForTesting
    @GuardedBy("lock")
    private int zzdrl = 0;

    @VisibleForTesting
    @GuardedBy("lock")
    private int zzdrm = 0;

    public zzavl(String str, zzavu zzavuVar) {
        this.zzdrj = str;
        this.zzdrk = zzavuVar;
    }

    private static boolean zzam(Context context) {
        Context zzaa = zzarf.zzaa(context);
        int identifier = zzaa.getResources().getIdentifier("Theme.Translucent", "style", AbstractSpiCall.ANDROID_CLIENT_TYPE);
        if (identifier == 0) {
            zzayu.zzey("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == zzaa.getPackageManager().getActivityInfo(new ComponentName(zzaa.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzayu.zzey("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            zzayu.zzez("Fail to fetch AdActivity theme");
            zzayu.zzey("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public final void zza(zzug zzugVar, long j) {
        synchronized (this.lock) {
            long zzwb = this.zzdrk.zzwb();
            long currentTimeMillis = com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis();
            if (this.zzdrf == -1) {
                if (currentTimeMillis - zzwb > ((Long) zzve.zzoy().zzd(zzzn.zzcjc)).longValue()) {
                    this.a = -1;
                } else {
                    this.a = this.zzdrk.zzwc();
                }
                this.zzdrf = j;
                j = this.zzdrf;
            }
            this.zzdre = j;
            if (zzugVar == null || zzugVar.extras == null || zzugVar.extras.getInt("gw", 2) != 1) {
                this.zzdrg++;
                this.a++;
                if (this.a == 0) {
                    this.zzdri = 0L;
                    this.zzdrk.zzfa(currentTimeMillis);
                } else {
                    this.zzdri = currentTimeMillis - this.zzdrk.zzwd();
                }
            }
        }
    }

    public final Bundle zzo(Context context, String str) {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString("session_id", this.zzdrj);
            bundle.putLong("basets", this.zzdrf);
            bundle.putLong("currts", this.zzdre);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzdrg);
            bundle.putInt("preqs_in_session", this.a);
            bundle.putLong("time_in_session", this.zzdri);
            bundle.putInt("pclick", this.zzdrl);
            bundle.putInt("pimp", this.zzdrm);
            bundle.putBoolean("support_transparent_background", zzam(context));
        }
        return bundle;
    }

    public final void zzuv() {
        synchronized (this.lock) {
            this.zzdrm++;
        }
    }

    public final void zzuw() {
        synchronized (this.lock) {
            this.zzdrl++;
        }
    }
}
