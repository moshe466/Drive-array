package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class zzcds {
    private ConcurrentHashMap<String, String> zzfsq;

    public zzcds(zzcdv zzcdvVar) {
        this.zzfsq = zzcdvVar.zzalh();
    }

    public final void zzc(zzczt zzcztVar) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        String str;
        if (zzcztVar.zzgmi.zzgme.size() > 0) {
            int i = zzcztVar.zzgmi.zzgme.get(0).zzfjj;
            if (i == 1) {
                concurrentHashMap = this.zzfsq;
                str = "banner";
            } else if (i == 2) {
                concurrentHashMap = this.zzfsq;
                str = "interstitial";
            } else if (i == 3) {
                concurrentHashMap = this.zzfsq;
                str = "native_express";
            } else if (i == 4) {
                concurrentHashMap = this.zzfsq;
                str = "native_advanced";
            } else if (i != 5) {
                concurrentHashMap = this.zzfsq;
                str = EnvironmentCompat.MEDIA_UNKNOWN;
            } else {
                concurrentHashMap = this.zzfsq;
                str = "rewarded";
            }
            concurrentHashMap.put("ad_format", str);
            if (TextUtils.isEmpty(zzcztVar.zzgmi.zzgmf.zzbzo)) {
                return;
            }
            this.zzfsq.put("gqi", zzcztVar.zzgmi.zzgmf.zzbzo);
        }
    }

    public final void zzi(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zzfsq.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zzfsq.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }

    public final Map<String, String> zzqu() {
        return this.zzfsq;
    }
}
