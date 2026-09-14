package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes.dex */
public final class zzbbt implements zzha {
    private int zzbep;
    private final zznp zzeci;
    private long zzecj;
    private long zzeck;
    private long zzecl;
    private long zzecm;
    private boolean zzecn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbt() {
        this(15000, 30000, 2500L, 5000L);
    }

    private zzbbt(int i, int i2, long j, long j2) {
        this.zzeci = new zznp(true, 65536);
        this.zzecj = 15000000L;
        this.zzeck = 30000000L;
        this.zzecl = 2500000L;
        this.zzecm = 5000000L;
    }

    @VisibleForTesting
    private final void zzk(boolean z) {
        this.zzbep = 0;
        this.zzecn = false;
        if (z) {
            this.zzeci.reset();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzha
    public final void onStopped() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzha
    public final void zza(zzhf[] zzhfVarArr, zzmr zzmrVar, zzng zzngVar) {
        this.zzbep = 0;
        for (int i = 0; i < zzhfVarArr.length; i++) {
            if (zzngVar.zzay(i) != null) {
                this.zzbep += zzoq.zzbl(zzhfVarArr[i].getTrackType());
            }
        }
        this.zzeci.zzba(this.zzbep);
    }

    @Override // com.google.android.gms.internal.ads.zzha
    public final synchronized boolean zzc(long j, boolean z) {
        long j2;
        j2 = z ? this.zzecm : this.zzecl;
        return j2 <= 0 || j >= j2;
    }

    public final synchronized void zzcx(int i) {
        this.zzecl = i * 1000;
    }

    public final synchronized void zzcy(int i) {
        this.zzecm = i * 1000;
    }

    public final synchronized void zzdc(int i) {
        this.zzecj = i * 1000;
    }

    public final synchronized void zzdd(int i) {
        this.zzeck = i * 1000;
    }

    @Override // com.google.android.gms.internal.ads.zzha
    public final synchronized boolean zzdt(long j) {
        boolean z = false;
        char c = j > this.zzeck ? (char) 0 : j < this.zzecj ? (char) 2 : (char) 1;
        boolean z2 = this.zzeci.zzii() >= this.zzbep;
        if (c == 2 || (c == 1 && this.zzecn && !z2)) {
            z = true;
        }
        this.zzecn = z;
        return this.zzecn;
    }

    @Override // com.google.android.gms.internal.ads.zzha
    public final void zzer() {
        zzk(false);
    }

    @Override // com.google.android.gms.internal.ads.zzha
    public final void zzes() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzha
    public final zznj zzet() {
        return this.zzeci;
    }
}
