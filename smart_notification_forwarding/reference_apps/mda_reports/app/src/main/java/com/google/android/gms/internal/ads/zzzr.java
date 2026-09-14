package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public final class zzzr {
    private String zzbma;
    private String zzcrj = zzaav.zzcsv.get();
    private Map<String, String> zzcrk = new LinkedHashMap();
    private Context zzup;

    public zzzr(Context context, String str) {
        this.zzup = null;
        this.zzbma = null;
        this.zzup = context;
        this.zzbma = str;
        this.zzcrk.put("s", "gmob_sdk");
        this.zzcrk.put("v", ExifInterface.GPS_MEASUREMENT_3D);
        this.zzcrk.put("os", Build.VERSION.RELEASE);
        this.zzcrk.put(CommonUtils.SDK, Build.VERSION.SDK);
        Map<String, String> map = this.zzcrk;
        com.google.android.gms.ads.internal.zzq.zzkq();
        map.put("device", zzawb.zzwl());
        this.zzcrk.put(SettingsJsonConstants.APP_KEY, context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        Map<String, String> map2 = this.zzcrk;
        com.google.android.gms.ads.internal.zzq.zzkq();
        map2.put("is_lite_sdk", zzawb.zzay(context) ? "1" : "0");
        Future<zzaqt> zzx = com.google.android.gms.ads.internal.zzq.zzlb().zzx(this.zzup);
        try {
            this.zzcrk.put("network_coarse", Integer.toString(zzx.get().zzdmo));
            this.zzcrk.put("network_fine", Integer.toString(zzx.get().zzdmp));
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzq.zzku().zza(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context a() {
        return this.zzup;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b() {
        return this.zzbma;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        return this.zzcrj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> d() {
        return this.zzcrk;
    }
}
