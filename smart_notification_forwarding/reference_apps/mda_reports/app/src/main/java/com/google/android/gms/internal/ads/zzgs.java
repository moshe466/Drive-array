package com.google.android.gms.internal.ads;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzgs {
    public final int index;
    private final zzhf[] zzacq;
    private final zznf zzacr;
    public final zzlz zzadn;
    public final Object zzado;
    public final zzmo[] zzadp;
    private final boolean[] zzadq;
    public final long zzadr;
    public int zzads;
    public long zzadt;
    public boolean zzadu;
    public boolean zzadv;
    public boolean zzadw;
    public zzgs zzadx;
    public zznh zzady;
    private final zzhe[] zzadz;
    private final zzha zzaea;
    private final zzmb zzaeb;
    private zznh zzaec;

    public zzgs(zzhf[] zzhfVarArr, zzhe[] zzheVarArr, long j, zznf zznfVar, zzha zzhaVar, zzmb zzmbVar, Object obj, int i, int i2, boolean z, long j2) {
        this.zzacq = zzhfVarArr;
        this.zzadz = zzheVarArr;
        this.zzadr = j;
        this.zzacr = zznfVar;
        this.zzaea = zzhaVar;
        this.zzaeb = zzmbVar;
        this.zzado = zzoc.checkNotNull(obj);
        this.index = i;
        this.zzads = i2;
        this.zzadu = z;
        this.zzadt = j2;
        this.zzadp = new zzmo[zzhfVarArr.length];
        this.zzadq = new boolean[zzhfVarArr.length];
        this.zzadn = zzmbVar.zza(i2, zzhaVar.zzet());
    }

    public final void release() {
        try {
            this.zzaeb.zzb(this.zzadn);
        } catch (RuntimeException e) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e);
        }
    }

    public final long zza(long j, boolean z, boolean[] zArr) {
        zzng zzngVar = this.zzady.zzbeg;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzngVar.length) {
                break;
            }
            boolean[] zArr2 = this.zzadq;
            if (z || !this.zzady.zza(this.zzaec, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long zza = this.zzadn.zza(zzngVar.zzie(), this.zzadq, this.zzadp, zArr, j);
        this.zzaec = this.zzady;
        this.zzadw = false;
        int i2 = 0;
        while (true) {
            zzmo[] zzmoVarArr = this.zzadp;
            if (i2 >= zzmoVarArr.length) {
                this.zzaea.zza(this.zzacq, this.zzady.zzbef, zzngVar);
                return zza;
            }
            if (zzmoVarArr[i2] != null) {
                zzoc.checkState(zzngVar.zzay(i2) != null);
                this.zzadw = true;
            } else {
                zzoc.checkState(zzngVar.zzay(i2) == null);
            }
            i2++;
        }
    }

    public final long zzb(long j, boolean z) {
        return zza(j, false, new boolean[this.zzacq.length]);
    }

    public final void zzc(int i, boolean z) {
        this.zzads = i;
        this.zzadu = z;
    }

    public final long zzef() {
        return this.zzadr - this.zzadt;
    }

    public final boolean zzeg() {
        if (this.zzadv) {
            return !this.zzadw || this.zzadn.zzhj() == Long.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzeh() {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zznf r0 = r6.zzacr
            com.google.android.gms.internal.ads.zzhe[] r1 = r6.zzadz
            com.google.android.gms.internal.ads.zzlz r2 = r6.zzadn
            com.google.android.gms.internal.ads.zzmr r2 = r2.zzhg()
            com.google.android.gms.internal.ads.zznh r0 = r0.zza(r1, r2)
            com.google.android.gms.internal.ads.zznh r1 = r6.zzaec
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L16
        L14:
            r1 = 0
            goto L28
        L16:
            r4 = 0
        L17:
            com.google.android.gms.internal.ads.zzng r5 = r0.zzbeg
            int r5 = r5.length
            if (r4 >= r5) goto L27
            boolean r5 = r0.zza(r1, r4)
            if (r5 != 0) goto L24
            goto L14
        L24:
            int r4 = r4 + 1
            goto L17
        L27:
            r1 = 1
        L28:
            if (r1 == 0) goto L2b
            return r3
        L2b:
            r6.zzady = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgs.zzeh():boolean");
    }
}
