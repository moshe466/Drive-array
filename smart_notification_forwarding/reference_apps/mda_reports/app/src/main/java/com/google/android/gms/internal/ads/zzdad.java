package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzdad {
    public static void zzc(Throwable th, String str) {
        int zzd = zzcfb.zzd(th);
        StringBuilder sb = new StringBuilder(31);
        sb.append("Ad failed to load : ");
        sb.append(zzd);
        zzayu.zzey(sb.toString());
        zzavs.zza(str, th);
        if (zzcfb.zzd(th) == 3) {
            return;
        }
        com.google.android.gms.ads.internal.zzq.zzku().zzb(th, str);
    }

    public static void zze(Context context, boolean z) {
        String sb;
        if (z) {
            sb = "This request is sent from a test device.";
        } else {
            zzve.zzou();
            String zzbi = zzayk.zzbi(context);
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzbi).length() + 71);
            sb2.append("Use AdRequest.Builder.addTestDevice(\"");
            sb2.append(zzbi);
            sb2.append("\") to get test ads on this device.");
            sb = sb2.toString();
        }
        zzayu.zzey(sb);
    }
}
