package com.google.android.gms.gass;

import android.content.Context;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.ads.zzbs;

@ShowFirstParty
/* loaded from: classes.dex */
public final class zzc {
    public static zzbs.zza zzj(Context context, String str, String str2) {
        return new zze(context, str, str2).zzdn(AdShield2Logger.EVENTID_CLICK_SIGNALS);
    }
}
