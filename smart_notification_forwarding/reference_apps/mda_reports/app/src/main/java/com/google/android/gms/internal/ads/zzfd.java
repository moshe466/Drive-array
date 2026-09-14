package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzfd implements Callable {
    private final zzei zzuv;
    private final zzbs.zza.zzb zzzt;

    public zzfd(zzei zzeiVar, zzbs.zza.zzb zzbVar) {
        this.zzuv = zzeiVar;
        this.zzzt = zzbVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: zzcp, reason: merged with bridge method [inline-methods] */
    public final Void call() {
        if (this.zzuv.zzcg() != null) {
            this.zzuv.zzcg().get();
        }
        zzbs.zza zzcf = this.zzuv.zzcf();
        if (zzcf == null) {
            return null;
        }
        try {
            synchronized (this.zzzt) {
                zzbs.zza.zzb zzbVar = this.zzzt;
                byte[] byteArray = zzcf.toByteArray();
                zzbVar.zza(byteArray, 0, byteArray.length, zzdrg.zzazi());
            }
            return null;
        } catch (zzdse unused) {
            return null;
        }
    }
}
