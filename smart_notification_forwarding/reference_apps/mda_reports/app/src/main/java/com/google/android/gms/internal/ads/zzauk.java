package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes.dex */
public final class zzauk {
    @VisibleForTesting
    private static Uri zza(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i = indexOf + 1;
        return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + "&" + str.substring(i));
    }

    public static String zzb(Uri uri, Context context) {
        String zzag;
        if (com.google.android.gms.ads.internal.zzq.zzlo().zzab(context) && (zzag = com.google.android.gms.ads.internal.zzq.zzlo().zzag(context)) != null) {
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcic)).booleanValue()) {
                String str = (String) zzve.zzoy().zzd(zzzn.zzcid);
                String uri2 = uri.toString();
                if (uri2.contains(str)) {
                    com.google.android.gms.ads.internal.zzq.zzlo().zzh(context, zzag);
                    return uri2.replace(str, zzag);
                }
            } else if (TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
                uri = zza(uri.toString(), "fbs_aeid", zzag);
                com.google.android.gms.ads.internal.zzq.zzlo().zzh(context, zzag);
            }
            return uri.toString();
        }
        return uri.toString();
    }

    public static String zzb(String str, Context context, boolean z) {
        String zzag;
        if ((((Boolean) zzve.zzoy().zzd(zzzn.zzcik)).booleanValue() && !z) || !com.google.android.gms.ads.internal.zzq.zzlo().zzab(context) || TextUtils.isEmpty(str) || (zzag = com.google.android.gms.ads.internal.zzq.zzlo().zzag(context)) == null) {
            return str;
        }
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcic)).booleanValue()) {
            if (str.contains("fbs_aeid")) {
                return str;
            }
            if (com.google.android.gms.ads.internal.zzq.zzkq().zzek(str)) {
                com.google.android.gms.ads.internal.zzq.zzlo().zzh(context, zzag);
                return zza(str, "fbs_aeid", zzag).toString();
            }
            if (!com.google.android.gms.ads.internal.zzq.zzkq().zzel(str)) {
                return str;
            }
            com.google.android.gms.ads.internal.zzq.zzlo().zzi(context, zzag);
            return zza(str, "fbs_aeid", zzag).toString();
        }
        CharSequence charSequence = (String) zzve.zzoy().zzd(zzzn.zzcid);
        if (!str.contains(charSequence)) {
            return str;
        }
        if (com.google.android.gms.ads.internal.zzq.zzkq().zzek(str)) {
            com.google.android.gms.ads.internal.zzq.zzlo().zzh(context, zzag);
            return str.replace(charSequence, zzag);
        }
        if (!com.google.android.gms.ads.internal.zzq.zzkq().zzel(str)) {
            return str;
        }
        com.google.android.gms.ads.internal.zzq.zzlo().zzi(context, zzag);
        return str.replace(charSequence, zzag);
    }
}
