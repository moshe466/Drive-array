package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class zzcbx implements zzbtk {
    private final zzbdi zzehp;

    private zzcbx(zzbdi zzbdiVar) {
        this.zzehp = zzbdiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbtk a(zzbdi zzbdiVar) {
        return new zzcbx(zzbdiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zzaib() {
        this.zzehp.destroy();
    }
}
