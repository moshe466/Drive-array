package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcbq implements com.google.android.gms.ads.internal.zzi {
    private final /* synthetic */ zzcbn zzfri;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcbq(zzcbn zzcbnVar) {
        this.zzfri = zzcbnVar;
    }

    @Override // com.google.android.gms.ads.internal.zzi
    public final void zzjv() {
        zzbqp zzbqpVar;
        zzbqpVar = this.zzfri.zzfre;
        zzbqpVar.onPause();
    }

    @Override // com.google.android.gms.ads.internal.zzi
    public final void zzjw() {
        zzbqp zzbqpVar;
        zzbqpVar = this.zzfri.zzfre;
        zzbqpVar.onResume();
    }
}
