package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
public final class zzaog {
    private final zzbdi zzcza;
    private final boolean zzdfu;
    private final String zzdfv;

    public zzaog(zzbdi zzbdiVar, Map<String, String> map) {
        this.zzcza = zzbdiVar;
        this.zzdfv = map.get("forceOrientation");
        this.zzdfu = map.containsKey("allowOrientationChange") ? Boolean.parseBoolean(map.get("allowOrientationChange")) : true;
    }

    public final void execute() {
        int zzwo;
        if (this.zzcza == null) {
            zzayu.zzez("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.zzdfv)) {
            com.google.android.gms.ads.internal.zzq.zzks();
            zzwo = 7;
        } else if ("landscape".equalsIgnoreCase(this.zzdfv)) {
            com.google.android.gms.ads.internal.zzq.zzks();
            zzwo = 6;
        } else {
            zzwo = this.zzdfu ? -1 : com.google.android.gms.ads.internal.zzq.zzks().zzwo();
        }
        this.zzcza.setRequestedOrientation(zzwo);
    }
}
