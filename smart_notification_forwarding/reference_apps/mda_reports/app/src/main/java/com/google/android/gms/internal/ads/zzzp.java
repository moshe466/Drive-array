package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class zzzp {
    public static boolean zzcp(String str) {
        return zzf((String) zzve.zzoy().zzd(zzzn.zzcon), str);
    }

    private static boolean zzf(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e) {
                com.google.android.gms.ads.internal.zzq.zzku().zza(e, "NonagonUtil.isPatternMatched");
            }
        }
        return false;
    }
}
