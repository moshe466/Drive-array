package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzavg extends zzavo {
    private final /* synthetic */ zzave zzdqw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavg(zzave zzaveVar) {
        this.zzdqw = zzaveVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavo
    public final void zztu() {
        Context context;
        zzazb zzazbVar;
        Object obj;
        zzzu zzzuVar;
        context = this.zzdqw.zzup;
        zzazbVar = this.zzdqw.zzbll;
        zzzr zzzrVar = new zzzr(context, zzazbVar.zzbma);
        obj = this.zzdqw.lock;
        synchronized (obj) {
            try {
                com.google.android.gms.ads.internal.zzq.zzkz();
                zzzuVar = this.zzdqw.zzdqj;
                zzzw.zza(zzzuVar, zzzrVar);
            } catch (IllegalArgumentException e) {
                zzayu.zzd("Cannot config CSI reporter.", e);
            }
        }
    }
}
