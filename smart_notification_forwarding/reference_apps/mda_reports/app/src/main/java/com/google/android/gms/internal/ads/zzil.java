package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzil implements zzic {
    private final /* synthetic */ zzij zzakx;

    private zzil(zzij zzijVar) {
        this.zzakx = zzijVar;
    }

    @Override // com.google.android.gms.internal.ads.zzic
    public final void zzc(int i, long j, long j2) {
        zzij.a(this.zzakx).zzb(i, j, j2);
        zzij.a(i, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzic
    public final void zzed() {
        zzij.l();
        zzij.a(this.zzakx, true);
    }

    @Override // com.google.android.gms.internal.ads.zzic
    public final void zzr(int i) {
        zzij.a(this.zzakx).zzs(i);
        zzij.a(i);
    }
}
