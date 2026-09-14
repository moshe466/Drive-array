package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzmh {
    private int length;
    private int[] zzamp;
    private long[] zzamq;
    private long[] zzams;
    private int[] zzawq;
    private int zzbbu = 1000;
    private int[] zzbbv;
    private zzjn[] zzbbw;
    private zzgw[] zzbbx;
    private int zzbby;
    private int zzbbz;
    private int zzbca;
    private long zzbcb;
    private long zzbcc;
    private boolean zzbcd;
    private boolean zzbce;
    private zzgw zzbcf;

    public zzmh() {
        int i = this.zzbbu;
        this.zzbbv = new int[i];
        this.zzamq = new long[i];
        this.zzams = new long[i];
        this.zzawq = new int[i];
        this.zzamp = new int[i];
        this.zzbbw = new zzjn[i];
        this.zzbbx = new zzgw[i];
        this.zzbcb = Long.MIN_VALUE;
        this.zzbcc = Long.MIN_VALUE;
        this.zzbce = true;
        this.zzbcd = true;
    }

    public final synchronized int zza(zzgy zzgyVar, zzis zzisVar, boolean z, boolean z2, zzgw zzgwVar, zzmk zzmkVar) {
        if (!zzhw()) {
            if (z2) {
                zzisVar.setFlags(4);
                return -4;
            }
            if (this.zzbcf == null || (!z && this.zzbcf == zzgwVar)) {
                return -3;
            }
            zzgyVar.zzafz = this.zzbcf;
            return -5;
        }
        if (!z && this.zzbbx[this.zzbbz] == zzgwVar) {
            if (zzisVar.zzcs == null) {
                return -3;
            }
            zzisVar.zzamd = this.zzams[this.zzbbz];
            zzisVar.setFlags(this.zzawq[this.zzbbz]);
            zzmkVar.size = this.zzamp[this.zzbbz];
            zzmkVar.zzauq = this.zzamq[this.zzbbz];
            zzmkVar.zzapt = this.zzbbw[this.zzbbz];
            this.zzbcb = Math.max(this.zzbcb, zzisVar.zzamd);
            this.length--;
            this.zzbbz++;
            this.zzbby++;
            if (this.zzbbz == this.zzbbu) {
                this.zzbbz = 0;
            }
            zzmkVar.zzbct = this.length > 0 ? this.zzamq[this.zzbbz] : zzmkVar.zzauq + zzmkVar.size;
            return -4;
        }
        zzgyVar.zzafz = this.zzbbx[this.zzbbz];
        return -5;
    }

    public final synchronized void zza(long j, int i, long j2, int i2, zzjn zzjnVar) {
        if (this.zzbcd) {
            if ((i & 1) == 0) {
                return;
            } else {
                this.zzbcd = false;
            }
        }
        zzoc.checkState(!this.zzbce);
        zzei(j);
        this.zzams[this.zzbca] = j;
        this.zzamq[this.zzbca] = j2;
        this.zzamp[this.zzbca] = i2;
        this.zzawq[this.zzbca] = i;
        this.zzbbw[this.zzbca] = zzjnVar;
        this.zzbbx[this.zzbca] = this.zzbcf;
        this.zzbbv[this.zzbca] = 0;
        this.length++;
        if (this.length != this.zzbbu) {
            this.zzbca++;
            if (this.zzbca == this.zzbbu) {
                this.zzbca = 0;
            }
            return;
        }
        int i3 = this.zzbbu + 1000;
        int[] iArr = new int[i3];
        long[] jArr = new long[i3];
        long[] jArr2 = new long[i3];
        int[] iArr2 = new int[i3];
        int[] iArr3 = new int[i3];
        zzjn[] zzjnVarArr = new zzjn[i3];
        zzgw[] zzgwVarArr = new zzgw[i3];
        int i4 = this.zzbbu - this.zzbbz;
        System.arraycopy(this.zzamq, this.zzbbz, jArr, 0, i4);
        System.arraycopy(this.zzams, this.zzbbz, jArr2, 0, i4);
        System.arraycopy(this.zzawq, this.zzbbz, iArr2, 0, i4);
        System.arraycopy(this.zzamp, this.zzbbz, iArr3, 0, i4);
        System.arraycopy(this.zzbbw, this.zzbbz, zzjnVarArr, 0, i4);
        System.arraycopy(this.zzbbx, this.zzbbz, zzgwVarArr, 0, i4);
        System.arraycopy(this.zzbbv, this.zzbbz, iArr, 0, i4);
        int i5 = this.zzbbz;
        System.arraycopy(this.zzamq, 0, jArr, i4, i5);
        System.arraycopy(this.zzams, 0, jArr2, i4, i5);
        System.arraycopy(this.zzawq, 0, iArr2, i4, i5);
        System.arraycopy(this.zzamp, 0, iArr3, i4, i5);
        System.arraycopy(this.zzbbw, 0, zzjnVarArr, i4, i5);
        System.arraycopy(this.zzbbx, 0, zzgwVarArr, i4, i5);
        System.arraycopy(this.zzbbv, 0, iArr, i4, i5);
        this.zzamq = jArr;
        this.zzams = jArr2;
        this.zzawq = iArr2;
        this.zzamp = iArr3;
        this.zzbbw = zzjnVarArr;
        this.zzbbx = zzgwVarArr;
        this.zzbbv = iArr;
        this.zzbbz = 0;
        this.zzbca = this.zzbbu;
        this.length = this.zzbbu;
        this.zzbbu = i3;
    }

    public final synchronized long zzd(long j, boolean z) {
        if (zzhw() && j >= this.zzams[this.zzbbz]) {
            if (j > this.zzbcc && !z) {
                return -1L;
            }
            int i = this.zzbbz;
            int i2 = -1;
            int i3 = 0;
            while (i != this.zzbca && this.zzams[i] <= j) {
                if ((this.zzawq[i] & 1) != 0) {
                    i2 = i3;
                }
                i = (i + 1) % this.zzbbu;
                i3++;
            }
            if (i2 == -1) {
                return -1L;
            }
            this.zzbbz = (this.zzbbz + i2) % this.zzbbu;
            this.zzbby += i2;
            this.length -= i2;
            return this.zzamq[this.zzbbz];
        }
        return -1L;
    }

    public final synchronized void zzei(long j) {
        this.zzbcc = Math.max(this.zzbcc, j);
    }

    public final synchronized boolean zzg(zzgw zzgwVar) {
        if (zzgwVar == null) {
            this.zzbce = true;
            return false;
        }
        this.zzbce = false;
        if (zzoq.zza(zzgwVar, this.zzbcf)) {
            return false;
        }
        this.zzbcf = zzgwVar;
        return true;
    }

    public final synchronized long zzhn() {
        return Math.max(this.zzbcb, this.zzbcc);
    }

    public final void zzht() {
        this.zzbby = 0;
        this.zzbbz = 0;
        this.zzbca = 0;
        this.length = 0;
        this.zzbcd = true;
    }

    public final void zzhu() {
        this.zzbcb = Long.MIN_VALUE;
        this.zzbcc = Long.MIN_VALUE;
    }

    public final int zzhv() {
        return this.zzbby + this.length;
    }

    public final synchronized boolean zzhw() {
        return this.length != 0;
    }

    public final synchronized zzgw zzhx() {
        if (this.zzbce) {
            return null;
        }
        return this.zzbcf;
    }

    public final synchronized long zzhy() {
        if (!zzhw()) {
            return -1L;
        }
        int i = ((this.zzbbz + this.length) - 1) % this.zzbbu;
        this.zzbbz = (this.zzbbz + this.length) % this.zzbbu;
        this.zzbby += this.length;
        this.length = 0;
        return this.zzamq[i] + this.zzamp[i];
    }
}
