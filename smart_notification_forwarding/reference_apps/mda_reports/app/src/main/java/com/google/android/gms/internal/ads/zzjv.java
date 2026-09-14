package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzjv implements zzju {
    private final /* synthetic */ zzjt zzapn;

    private zzjv(zzjt zzjtVar) {
        this.zzapn = zzjtVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzjv(zzjt zzjtVar, zzjw zzjwVar) {
        this(zzjtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzju
    public final void zza(int i, double d) {
        this.zzapn.a(i, d);
    }

    @Override // com.google.android.gms.internal.ads.zzju
    public final void zza(int i, int i2, zzjg zzjgVar) {
        this.zzapn.a(i, i2, zzjgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzju
    public final void zza(int i, String str) {
        this.zzapn.a(i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzju
    public final int zzah(int i) {
        return zzjt.b(i);
    }

    @Override // com.google.android.gms.internal.ads.zzju
    public final boolean zzai(int i) {
        return zzjt.c(i);
    }

    @Override // com.google.android.gms.internal.ads.zzju
    public final void zzaj(int i) {
        this.zzapn.a(i);
    }

    @Override // com.google.android.gms.internal.ads.zzju
    public final void zzc(int i, long j) {
        this.zzapn.a(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzju
    public final void zzd(int i, long j, long j2) {
        this.zzapn.a(i, j, j2);
    }
}
