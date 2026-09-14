package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcdv {
    private final Executor executor;
    private final String packageName;
    private final zzayy zzduv;
    private final Context zzup;
    private final String zzcrj = zzaav.zzcsv.get();
    private final Map<String, String> zzfsw = new HashMap();

    public zzcdv(Executor executor, zzayy zzayyVar, Context context) {
        this.executor = executor;
        this.zzduv = zzayyVar;
        this.zzup = context;
        this.packageName = context.getPackageName();
        this.zzfsw.put("s", "gmob_sdk");
        this.zzfsw.put("v", ExifInterface.GPS_MEASUREMENT_3D);
        this.zzfsw.put("os", Build.VERSION.RELEASE);
        this.zzfsw.put(CommonUtils.SDK, Build.VERSION.SDK);
        Map<String, String> map = this.zzfsw;
        com.google.android.gms.ads.internal.zzq.zzkq();
        map.put("device", zzawb.zzwl());
        this.zzfsw.put(SettingsJsonConstants.APP_KEY, this.packageName);
        Map<String, String> map2 = this.zzfsw;
        com.google.android.gms.ads.internal.zzq.zzkq();
        map2.put("is_lite_sdk", zzawb.zzay(this.zzup) ? "1" : "0");
        this.zzfsw.put("e", TextUtils.join(",", zzzn.zzqh()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str) {
        this.zzduv.zzen(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            r3 = this;
            java.lang.String r0 = r3.zzcrj
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.net.Uri$Builder r0 = r0.buildUpon()
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L12:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L2e
            java.lang.Object r1 = r4.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r0.appendQueryParameter(r2, r1)
            goto L12
        L2e:
            android.net.Uri r4 = r0.build()
            java.lang.String r4 = r4.toString()
            com.google.android.gms.internal.ads.zzaan<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaav.zzcsw
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L59
            com.google.android.gms.internal.ads.zzzc<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzzn.zzcku
            com.google.android.gms.internal.ads.zzzj r1 = com.google.android.gms.internal.ads.zzve.zzoy()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L57
            goto L59
        L57:
            r0 = 0
            goto L5a
        L59:
            r0 = 1
        L5a:
            if (r0 == 0) goto L66
            java.util.concurrent.Executor r0 = r3.executor
            com.google.android.gms.internal.ads.zzcdy r1 = new com.google.android.gms.internal.ads.zzcdy
            r1.<init>(r3, r4)
            r0.execute(r1)
        L66:
            com.google.android.gms.internal.ads.zzavs.zzed(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdv.a(java.util.Map):void");
    }

    public final Map<String, String> zzalg() {
        return new HashMap(this.zzfsw);
    }

    public final ConcurrentHashMap<String, String> zzalh() {
        return new ConcurrentHashMap<>(this.zzfsw);
    }
}
