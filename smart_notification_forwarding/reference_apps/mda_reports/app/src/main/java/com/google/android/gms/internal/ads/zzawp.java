package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;

@TargetApi(26)
/* loaded from: classes.dex */
public class zzawp extends zzawm {
    @Override // com.google.android.gms.internal.ads.zzawh
    public final zzte zza(Context context, TelephonyManager telephonyManager) {
        com.google.android.gms.ads.internal.zzq.zzkq();
        if (zzawb.zzq(context, "android.permission.ACCESS_NETWORK_STATE") && telephonyManager.isDataEnabled()) {
            return zzte.ENUM_TRUE;
        }
        return zzte.ENUM_FALSE;
    }
}
