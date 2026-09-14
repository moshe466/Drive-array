package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public abstract class zzgj implements zzhe, zzhf {
    private int index;
    private int state;
    private final int zzacf;
    private zzhh zzacg;
    private zzmo zzach;
    private long zzaci;
    private boolean zzacj = true;
    private boolean zzack;

    public zzgj(int i) {
        this.zzacf = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a() {
        return this.index;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(zzgy zzgyVar, zzis zzisVar, boolean z) {
        int zzb = this.zzach.zzb(zzgyVar, zzisVar, z);
        if (zzb == -4) {
            if (zzisVar.zzgb()) {
                this.zzacj = true;
                return this.zzack ? -4 : -3;
            }
            zzisVar.zzamd += this.zzaci;
        } else if (zzb == -5) {
            zzgw zzgwVar = zzgyVar.zzafz;
            long j = zzgwVar.zzaft;
            if (j != Long.MAX_VALUE) {
                zzgyVar.zzafz = zzgwVar.zzds(j + this.zzaci);
            }
        }
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(long j) {
        this.zzach.zzeh(j - this.zzaci);
    }

    protected void a(long j, boolean z) {
    }

    protected void a(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(zzgw[] zzgwVarArr, long j) {
    }

    protected void b() {
    }

    protected void c() {
    }

    protected void d() {
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void disable() {
        zzoc.checkState(this.state == 1);
        this.state = 0;
        this.zzach = null;
        this.zzack = false;
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzhh e() {
        return this.zzacg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean f() {
        return this.zzacj ? this.zzack : this.zzach.isReady();
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.gms.internal.ads.zzhe, com.google.android.gms.internal.ads.zzhf
    public final int getTrackType() {
        return this.zzacf;
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void start() {
        zzoc.checkState(this.state == 1);
        this.state = 2;
        b();
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void stop() {
        zzoc.checkState(this.state == 2);
        this.state = 1;
        c();
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    public void zza(int i, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zza(zzhh zzhhVar, zzgw[] zzgwVarArr, zzmo zzmoVar, long j, boolean z, long j2) {
        zzoc.checkState(this.state == 0);
        this.zzacg = zzhhVar;
        this.state = 1;
        a(z);
        zza(zzgwVarArr, zzmoVar, j2);
        a(j, z);
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zza(zzgw[] zzgwVarArr, zzmo zzmoVar, long j) {
        zzoc.checkState(!this.zzack);
        this.zzach = zzmoVar;
        this.zzacj = false;
        this.zzaci = j;
        a(zzgwVarArr, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zzdo(long j) {
        this.zzack = false;
        this.zzacj = false;
        a(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final zzhe zzdp() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public zzog zzdq() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final zzmo zzdr() {
        return this.zzach;
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final boolean zzds() {
        return this.zzacj;
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zzdt() {
        this.zzack = true;
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final boolean zzdu() {
        return this.zzack;
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zzdv() {
        this.zzach.zzhk();
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public int zzdw() {
        return 0;
    }
}
