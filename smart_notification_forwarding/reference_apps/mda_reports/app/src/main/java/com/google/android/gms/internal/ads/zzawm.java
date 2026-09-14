package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import io.fabric.sdk.android.services.common.AbstractSpiCall;

@TargetApi(24)
/* loaded from: classes.dex */
public class zzawm extends zzawn {
    @VisibleForTesting
    private static boolean zze(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    @Override // com.google.android.gms.internal.ads.zzawh
    public final boolean zza(Activity activity, Configuration configuration) {
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcns)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcnu)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzve.zzou();
        int zza = zzayk.zza(activity, configuration.screenHeightDp);
        int zza2 = zzayk.zza(activity, configuration.screenWidthDp);
        WindowManager windowManager = (WindowManager) activity.getApplicationContext().getSystemService("window");
        com.google.android.gms.ads.internal.zzq.zzkq();
        DisplayMetrics zza3 = zzawb.zza(windowManager);
        int i = zza3.heightPixels;
        int i2 = zza3.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", AbstractSpiCall.ANDROID_CLIENT_TYPE);
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        double d = activity.getResources().getDisplayMetrics().density;
        Double.isNaN(d);
        int round = ((int) Math.round(d + 0.5d)) * ((Integer) zzve.zzoy().zzd(zzzn.zzcnr)).intValue();
        return !(zze(i, zza + dimensionPixelSize, round) && zze(i2, zza2, round));
    }
}
