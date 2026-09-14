package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbzq {
    private final Executor zzfci;
    private final zzbst zzfkh;
    private final zzbjq zzfpx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbzq(Executor executor, zzbjq zzbjqVar, zzbst zzbstVar) {
        this.zzfci = executor;
        this.zzfkh = zzbstVar;
        this.zzfpx = zzbjqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzbdi zzbdiVar, Map map) {
        this.zzfpx.disable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(zzbdi zzbdiVar, Map map) {
        this.zzfpx.enable();
    }

    public final void zzl(final zzbdi zzbdiVar) {
        if (zzbdiVar == null) {
            return;
        }
        this.zzfkh.zzq(zzbdiVar.getView());
        this.zzfkh.zza(new zzps(zzbdiVar) { // from class: com.google.android.gms.internal.ads.zzbzp
            private final zzbdi zzehp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzehp = zzbdiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzps
            public final void zza(zzpt zzptVar) {
                zzbev zzaaa = this.zzehp.zzaaa();
                Rect rect = zzptVar.zzbob;
                zzaaa.zza(rect.left, rect.top, false);
            }
        }, this.zzfci);
        this.zzfkh.zza(new zzps(zzbdiVar) { // from class: com.google.android.gms.internal.ads.zzbzs
            private final zzbdi zzehp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzehp = zzbdiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzps
            public final void zza(zzpt zzptVar) {
                zzbdi zzbdiVar2 = this.zzehp;
                HashMap hashMap = new HashMap();
                hashMap.put("isVisible", zzptVar.zzbnq ? "1" : "0");
                zzbdiVar2.zza("onAdVisibilityChanged", hashMap);
            }
        }, this.zzfci);
        this.zzfkh.zza(this.zzfpx, this.zzfci);
        this.zzfpx.zzg(zzbdiVar);
        zzbdiVar.zza("/trackActiveViewUnit", new zzafn(this) { // from class: com.google.android.gms.internal.ads.zzbzr
            private final zzbzq zzfpy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfpy = this;
            }

            @Override // com.google.android.gms.internal.ads.zzafn
            public final void zza(Object obj, Map map) {
                this.zzfpy.b((zzbdi) obj, map);
            }
        });
        zzbdiVar.zza("/untrackActiveViewUnit", new zzafn(this) { // from class: com.google.android.gms.internal.ads.zzbzu
            private final zzbzq zzfpy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfpy = this;
            }

            @Override // com.google.android.gms.internal.ads.zzafn
            public final void zza(Object obj, Map map) {
                this.zzfpy.a((zzbdi) obj, map);
            }
        });
    }
}
