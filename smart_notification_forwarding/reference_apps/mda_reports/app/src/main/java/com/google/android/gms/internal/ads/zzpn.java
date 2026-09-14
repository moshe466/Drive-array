package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzpn {
    private final String zzblx;
    private final JSONObject zzbly;
    private final String zzblz;
    private final String zzbma;
    private final boolean zzbmb = false;
    private final boolean zzbmc;

    public zzpn(String str, zzazb zzazbVar, String str2, JSONObject jSONObject, boolean z, boolean z2) {
        this.zzbma = zzazbVar.zzbma;
        this.zzbly = jSONObject;
        this.zzblz = str;
        this.zzblx = str2;
        this.zzbmc = z2;
    }

    public final String zzkj() {
        return this.zzblx;
    }

    public final String zzkk() {
        return this.zzbma;
    }

    public final JSONObject zzkl() {
        return this.zzbly;
    }

    public final String zzkm() {
        return this.zzblz;
    }

    public final boolean zzkn() {
        return this.zzbmc;
    }
}
