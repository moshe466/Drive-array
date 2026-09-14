package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzavs;
import com.google.android.gms.internal.ads.zzawb;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzve;
import com.google.android.gms.internal.ads.zzzn;

/* loaded from: classes.dex */
public final class zzb {
    private static boolean zza(Context context, Intent intent, zzt zztVar) {
        try {
            String valueOf = String.valueOf(intent.toURI());
            zzavs.zzed(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            com.google.android.gms.ads.internal.zzq.zzkq();
            zzawb.zza(context, intent);
            if (zztVar == null) {
                return true;
            }
            zztVar.zztv();
            return true;
        } catch (ActivityNotFoundException e) {
            zzayu.zzez(e.getMessage());
            return false;
        }
    }

    public static boolean zza(Context context, zzd zzdVar, zzt zztVar) {
        String str;
        int i = 0;
        if (zzdVar == null) {
            str = "No intent data for launcher overlay.";
        } else {
            zzzn.initialize(context);
            Intent intent = zzdVar.intent;
            if (intent != null) {
                return zza(context, intent, zztVar);
            }
            Intent intent2 = new Intent();
            if (!TextUtils.isEmpty(zzdVar.url)) {
                if (TextUtils.isEmpty(zzdVar.mimeType)) {
                    intent2.setData(Uri.parse(zzdVar.url));
                } else {
                    intent2.setDataAndType(Uri.parse(zzdVar.url), zzdVar.mimeType);
                }
                intent2.setAction("android.intent.action.VIEW");
                if (!TextUtils.isEmpty(zzdVar.packageName)) {
                    intent2.setPackage(zzdVar.packageName);
                }
                if (!TextUtils.isEmpty(zzdVar.zzdhf)) {
                    String[] split = zzdVar.zzdhf.split("/", 2);
                    if (split.length < 2) {
                        String valueOf = String.valueOf(zzdVar.zzdhf);
                        zzayu.zzez(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                        return false;
                    }
                    intent2.setClassName(split[0], split[1]);
                }
                String str2 = zzdVar.zzdhg;
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        i = Integer.parseInt(str2);
                    } catch (NumberFormatException unused) {
                        zzayu.zzez("Could not parse intent flags.");
                    }
                    intent2.addFlags(i);
                }
                if (((Boolean) zzve.zzoy().zzd(zzzn.zzcnk)).booleanValue()) {
                    intent2.addFlags(268435456);
                    intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
                } else {
                    if (((Boolean) zzve.zzoy().zzd(zzzn.zzcnj)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzq.zzkq();
                        zzawb.zzb(context, intent2);
                    }
                }
                return zza(context, intent2, zztVar);
            }
            str = "Open GMSG did not contain a URL.";
        }
        zzayu.zzez(str);
        return false;
    }
}
