package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class zznp implements zznj {
    private final boolean zzbel;
    private final int zzbem;
    private final byte[] zzben;
    private final zznk[] zzbeo;
    private int zzbep;
    private int zzbeq;
    private int zzber;
    private zznk[] zzbes;

    public zznp(boolean z, int i) {
        this(true, 65536, 0);
    }

    private zznp(boolean z, int i, int i2) {
        zzoc.checkArgument(true);
        zzoc.checkArgument(true);
        this.zzbel = true;
        this.zzbem = 65536;
        this.zzber = 0;
        this.zzbes = new zznk[100];
        this.zzben = null;
        this.zzbeo = new zznk[1];
    }

    public final synchronized void reset() {
        if (this.zzbel) {
            zzba(0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznj
    public final synchronized void zza(zznk zznkVar) {
        this.zzbeo[0] = zznkVar;
        zza(this.zzbeo);
    }

    @Override // com.google.android.gms.internal.ads.zznj
    public final synchronized void zza(zznk[] zznkVarArr) {
        boolean z;
        if (this.zzber + zznkVarArr.length >= this.zzbes.length) {
            this.zzbes = (zznk[]) Arrays.copyOf(this.zzbes, Math.max(this.zzbes.length << 1, this.zzber + zznkVarArr.length));
        }
        for (zznk zznkVar : zznkVarArr) {
            if (zznkVar.data != null && zznkVar.data.length != this.zzbem) {
                z = false;
                zzoc.checkArgument(z);
                zznk[] zznkVarArr2 = this.zzbes;
                int i = this.zzber;
                this.zzber = i + 1;
                zznkVarArr2[i] = zznkVar;
            }
            z = true;
            zzoc.checkArgument(z);
            zznk[] zznkVarArr22 = this.zzbes;
            int i2 = this.zzber;
            this.zzber = i2 + 1;
            zznkVarArr22[i2] = zznkVar;
        }
        this.zzbeq -= zznkVarArr.length;
        notifyAll();
    }

    public final synchronized void zzba(int i) {
        boolean z = i < this.zzbep;
        this.zzbep = i;
        if (z) {
            zzm();
        }
    }

    @Override // com.google.android.gms.internal.ads.zznj
    public final synchronized zznk zzif() {
        zznk zznkVar;
        this.zzbeq++;
        if (this.zzber > 0) {
            zznk[] zznkVarArr = this.zzbes;
            int i = this.zzber - 1;
            this.zzber = i;
            zznkVar = zznkVarArr[i];
            this.zzbes[this.zzber] = null;
        } else {
            zznkVar = new zznk(new byte[this.zzbem], 0);
        }
        return zznkVar;
    }

    @Override // com.google.android.gms.internal.ads.zznj
    public final int zzig() {
        return this.zzbem;
    }

    public final synchronized int zzii() {
        return this.zzbeq * this.zzbem;
    }

    @Override // com.google.android.gms.internal.ads.zznj
    public final synchronized void zzm() {
        int max = Math.max(0, zzoq.zzf(this.zzbep, this.zzbem) - this.zzbeq);
        if (max >= this.zzber) {
            return;
        }
        Arrays.fill(this.zzbes, max, this.zzber, (Object) null);
        this.zzber = max;
    }
}
