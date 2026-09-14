package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbxo implements zzabw {
    private final /* synthetic */ zzbxz zzfns;
    private final /* synthetic */ ViewGroup zzfnt;
    private final /* synthetic */ zzbxj zzfnu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbxo(zzbxj zzbxjVar, zzbxz zzbxzVar, ViewGroup viewGroup) {
        this.zzfnu = zzbxjVar;
        this.zzfns = zzbxzVar;
        this.zzfnt = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzabw
    public final void zzc(MotionEvent motionEvent) {
        this.zzfns.onTouch(null, motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzabw
    public final void zzrd() {
        boolean zza;
        zzbxj zzbxjVar = this.zzfnu;
        zza = zzbxj.zza(this.zzfns, zzbxh.zzfna);
        if (zza) {
            this.zzfns.onClick(this.zzfnt);
        }
    }
}
