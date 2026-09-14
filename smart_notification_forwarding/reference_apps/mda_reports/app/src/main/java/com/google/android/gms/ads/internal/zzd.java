package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaju;
import com.google.android.gms.internal.ads.zzajx;
import com.google.android.gms.internal.ads.zzajy;
import com.google.android.gms.internal.ads.zzakc;
import com.google.android.gms.internal.ads.zzavf;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzazd;
import com.google.android.gms.internal.ads.zzazh;
import com.google.android.gms.internal.ads.zzdgs;
import com.google.android.gms.internal.ads.zzdhe;
import com.google.android.gms.internal.ads.zzve;
import com.google.android.gms.internal.ads.zzzn;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzd {
    private long zzbkv = 0;
    private Context zzup;

    @VisibleForTesting
    private final void zza(Context context, zzazb zzazbVar, boolean z, @Nullable zzavf zzavfVar, String str, @Nullable String str2, @Nullable Runnable runnable) {
        if (zzq.zzkx().elapsedRealtime() - this.zzbkv < 5000) {
            zzayu.zzez("Not retrying to fetch app settings");
            return;
        }
        this.zzbkv = zzq.zzkx().elapsedRealtime();
        boolean z2 = true;
        if (zzavfVar != null) {
            if (!(zzq.zzkx().currentTimeMillis() - zzavfVar.zzvj() > ((Long) zzve.zzoy().zzd(zzzn.zzcmt)).longValue()) && zzavfVar.zzvk()) {
                z2 = false;
            }
        }
        if (z2) {
            if (context == null) {
                zzayu.zzez("Context not provided to fetch application settings");
                return;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                zzayu.zzez("App settings could not be fetched. Required parameters missing");
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.zzup = applicationContext;
            zzakc zzb = zzq.zzld().zzb(this.zzup, zzazbVar);
            zzajy<JSONObject> zzajyVar = zzajx.zzdaq;
            zzaju zza = zzb.zza("google.afma.config.fetchAppSettings", zzajyVar, zzajyVar);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                zzdhe zzi = zza.zzi(jSONObject);
                zzdhe zzb2 = zzdgs.zzb(zzi, zzf.a, zzazd.zzdwj);
                if (runnable != null) {
                    zzi.addListener(runnable, zzazd.zzdwj);
                }
                zzazh.zza(zzb2, "ConfigLoader.maybeFetchNewAppSettings");
            } catch (Exception e) {
                zzayu.zzc("Error requesting application settings", e);
            }
        }
    }

    public final void zza(Context context, zzazb zzazbVar, String str, zzavf zzavfVar) {
        zza(context, zzazbVar, false, zzavfVar, zzavfVar != null ? zzavfVar.zzvm() : null, str, null);
    }

    public final void zza(Context context, zzazb zzazbVar, String str, @Nullable Runnable runnable) {
        zza(context, zzazbVar, true, null, str, null, runnable);
    }
}
