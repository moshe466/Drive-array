package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzafy implements zzafn<Object> {
    private final zzafx zzcxu;

    private zzafy(zzafx zzafxVar) {
        this.zzcxu = zzafxVar;
    }

    public static void zza(zzbdi zzbdiVar, zzafx zzafxVar) {
        zzbdiVar.zza("/reward", new zzafy(zzafxVar));
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("action");
        if (!"grant".equals(str)) {
            if ("video_start".equals(str)) {
                this.zzcxu.zzrs();
                return;
            } else {
                if ("video_complete".equals(str)) {
                    this.zzcxu.zzrt();
                    return;
                }
                return;
            }
        }
        zzasd zzasdVar = null;
        try {
            int parseInt = Integer.parseInt(map.get("amount"));
            String str2 = map.get("type");
            if (!TextUtils.isEmpty(str2)) {
                zzasdVar = new zzasd(str2, parseInt);
            }
        } catch (NumberFormatException e) {
            zzayu.zzd("Unable to parse reward amount.", e);
        }
        this.zzcxu.zza(zzasdVar);
    }
}
