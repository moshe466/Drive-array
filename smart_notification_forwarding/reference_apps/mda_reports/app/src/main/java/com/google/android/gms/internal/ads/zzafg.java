package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
final class zzafg implements zzafn<zzbdi> {
    @Override // com.google.android.gms.internal.ads.zzafn
    public final /* synthetic */ void zza(zzbdi zzbdiVar, Map map) {
        zzbdi zzbdiVar2 = zzbdiVar;
        if (zzbdiVar2.zzaao() != null) {
            zzbdiVar2.zzaao().zzmm();
        }
        com.google.android.gms.ads.internal.overlay.zzc zzzw = zzbdiVar2.zzzw();
        if (zzzw != null) {
            zzzw.close();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzc zzzx = zzbdiVar2.zzzx();
        if (zzzx != null) {
            zzzx.close();
        } else {
            zzayu.zzez("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
