package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzaex implements zzafn<zzbdi> {
    @Override // com.google.android.gms.internal.ads.zzafn
    public final /* synthetic */ void zza(zzbdi zzbdiVar, Map map) {
        zzbdi zzbdiVar2 = zzbdiVar;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzayu.zzez("No label given for CSI tick.");
                return;
            }
            if (TextUtils.isEmpty(str4)) {
                zzayu.zzez("No timestamp given for CSI tick.");
                return;
            }
            try {
                long elapsedRealtime = com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime() + (Long.parseLong(str4) - com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis());
                if (TextUtils.isEmpty(str3)) {
                    str3 = "native:view_load";
                }
                zzbdiVar2.zzyq().zza(str2, str3, elapsedRealtime);
                return;
            } catch (NumberFormatException e) {
                zzayu.zzd("Malformed timestamp for CSI tick.", e);
                return;
            }
        }
        if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzayu.zzez("No value given for CSI experiment.");
                return;
            }
            zzaae zzqp = zzbdiVar2.zzyq().zzqp();
            if (zzqp == null) {
                zzayu.zzez("No ticker for WebView, dropping experiment ID.");
                return;
            } else {
                zzqp.zzh("e", str5);
                return;
            }
        }
        if ("extra".equals(str)) {
            String str6 = (String) map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzayu.zzez("No value given for CSI extra.");
                return;
            }
            if (TextUtils.isEmpty(str6)) {
                zzayu.zzez("No name given for CSI extra.");
                return;
            }
            zzaae zzqp2 = zzbdiVar2.zzyq().zzqp();
            if (zzqp2 == null) {
                zzayu.zzez("No ticker for WebView, dropping extra parameter.");
            } else {
                zzqp2.zzh(str6, str7);
            }
        }
    }
}
