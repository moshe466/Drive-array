package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzly implements zzmo {
    private final int track;
    private final /* synthetic */ zzlp zzbat;

    public zzly(zzlp zzlpVar, int i) {
        this.zzbat = zzlpVar;
        this.track = i;
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final boolean isReady() {
        return this.zzbat.a(this.track);
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final int zzb(zzgy zzgyVar, zzis zzisVar, boolean z) {
        return this.zzbat.a(this.track, zzgyVar, zzisVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzeh(long j) {
        this.zzbat.a(this.track, j);
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzhk() {
        this.zzbat.a();
    }
}
