package com.google.android.gms.internal.ads;

import android.view.View;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzcnt implements com.google.android.gms.ads.internal.zze {

    @GuardedBy("this")
    private com.google.android.gms.ads.internal.zze zzgcb;

    public final synchronized void zza(com.google.android.gms.ads.internal.zze zzeVar) {
        this.zzgcb = zzeVar;
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final synchronized void zzg(View view) {
        if (this.zzgcb != null) {
            this.zzgcb.zzg(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final synchronized void zzjr() {
        if (this.zzgcb != null) {
            this.zzgcb.zzjr();
        }
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final synchronized void zzjs() {
        if (this.zzgcb != null) {
            this.zzgcb.zzjs();
        }
    }
}
