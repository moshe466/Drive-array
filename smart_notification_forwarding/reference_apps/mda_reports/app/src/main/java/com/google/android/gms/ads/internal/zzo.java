package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzaar;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzug;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzo {
    private final String zzblt;
    private final Map<String, String> zzblu = new TreeMap();
    private String zzblv;
    private String zzblw;

    public zzo(String str) {
        this.zzblt = str;
    }

    public final String getQuery() {
        return this.zzblv;
    }

    public final void zza(zzug zzugVar, zzazb zzazbVar) {
        this.zzblv = zzugVar.zzccd.zzblv;
        Bundle bundle = zzugVar.zzccf;
        Bundle bundle2 = bundle != null ? bundle.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle2 == null) {
            return;
        }
        String str = zzaar.zzcsn.get();
        for (String str2 : bundle2.keySet()) {
            if (str.equals(str2)) {
                this.zzblw = bundle2.getString(str2);
            } else if (str2.startsWith("csa_")) {
                this.zzblu.put(str2.substring(4), bundle2.getString(str2));
            }
        }
        this.zzblu.put("SDKVersion", zzazbVar.zzbma);
    }

    public final String zzkg() {
        return this.zzblw;
    }

    public final String zzkh() {
        return this.zzblt;
    }

    public final Map<String, String> zzki() {
        return this.zzblu;
    }
}
