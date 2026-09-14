package com.google.android.gms.internal.ads;

import org.json.JSONException;

/* loaded from: classes.dex */
public final class zzbom extends zzwz {
    private final String zzfhj;
    private final String zzfhk;

    public zzbom(zzczl zzczlVar, String str) {
        this.zzfhk = zzczlVar == null ? null : zzczlVar.zzfhk;
        String zzb = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) ? zzb(zzczlVar) : null;
        this.zzfhj = zzb == null ? str : zzb;
    }

    private static String zzb(zzczl zzczlVar) {
        try {
            return zzczlVar.zzglr.getString("class_name");
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final String getMediationAdapterClassName() {
        return this.zzfhj;
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final String zzpj() {
        return this.zzfhk;
    }
}
