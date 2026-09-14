package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzafs implements zzafn<zzbdi> {
    private static final Map<String, Integer> zzcxr = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final com.google.android.gms.ads.internal.zzc zzcxo;
    private final zzaoe zzcxp;
    private final zzaon zzcxq;

    public zzafs(com.google.android.gms.ads.internal.zzc zzcVar, zzaoe zzaoeVar, zzaon zzaonVar) {
        this.zzcxo = zzcVar;
        this.zzcxp = zzaoeVar;
        this.zzcxq = zzaonVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final /* synthetic */ void zza(zzbdi zzbdiVar, Map map) {
        com.google.android.gms.ads.internal.zzc zzcVar;
        zzbdi zzbdiVar2 = zzbdiVar;
        int intValue = zzcxr.get((String) map.get("a")).intValue();
        if (intValue != 5 && intValue != 7 && (zzcVar = this.zzcxo) != null && !zzcVar.zzjq()) {
            this.zzcxo.zzbq(null);
            return;
        }
        if (intValue == 1) {
            this.zzcxp.zzg(map);
            return;
        }
        if (intValue == 3) {
            new zzaof(zzbdiVar2, map).execute();
            return;
        }
        if (intValue == 4) {
            new zzanz(zzbdiVar2, map).execute();
            return;
        }
        if (intValue == 5) {
            new zzaog(zzbdiVar2, map).execute();
            return;
        }
        if (intValue == 6) {
            this.zzcxp.zzac(true);
        } else if (intValue != 7) {
            zzayu.zzey("Unknown MRAID command called.");
        } else {
            this.zzcxq.zztj();
        }
    }
}
