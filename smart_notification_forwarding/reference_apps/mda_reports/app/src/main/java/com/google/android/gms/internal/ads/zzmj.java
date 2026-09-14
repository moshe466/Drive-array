package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class zzmj implements zzjo {
    private final zznj zzazv;
    private final int zzbch;
    private zzmm zzbcl;
    private zzmm zzbcm;
    private zzgw zzbcn;
    private boolean zzbco;
    private zzgw zzbcp;
    private long zzbcq;
    private int zzbcr;
    private zzml zzbcs;
    private final zzmh zzbci = new zzmh();
    private final zzmk zzbcj = new zzmk();
    private final zzoj zzanv = new zzoj(32);
    private final AtomicInteger zzbck = new AtomicInteger();

    public zzmj(zznj zznjVar) {
        this.zzazv = zznjVar;
        this.zzbch = zznjVar.zzig();
        int i = this.zzbch;
        this.zzbcr = i;
        this.zzbcl = new zzmm(0L, i);
        this.zzbcm = this.zzbcl;
    }

    private final void zza(long j, byte[] bArr, int i) {
        zzej(j);
        int i2 = 0;
        while (i2 < i) {
            int i3 = (int) (j - this.zzbcl.zzbcu);
            int min = Math.min(i - i2, this.zzbch - i3);
            zznk zznkVar = this.zzbcl.zzbcw;
            System.arraycopy(zznkVar.data, zznkVar.zzaz(i3), bArr, i2, min);
            j += min;
            i2 += min;
            if (j == this.zzbcl.zzaum) {
                this.zzazv.zza(zznkVar);
                this.zzbcl = this.zzbcl.zzic();
            }
        }
    }

    private final int zzau(int i) {
        if (this.zzbcr == this.zzbch) {
            this.zzbcr = 0;
            zzmm zzmmVar = this.zzbcm;
            if (zzmmVar.zzbcv) {
                this.zzbcm = zzmmVar.zzbcx;
            }
            zzmm zzmmVar2 = this.zzbcm;
            zznk zzif = this.zzazv.zzif();
            zzmm zzmmVar3 = new zzmm(this.zzbcm.zzaum, this.zzbch);
            zzmmVar2.zzbcw = zzif;
            zzmmVar2.zzbcx = zzmmVar3;
            zzmmVar2.zzbcv = true;
        }
        return Math.min(i, this.zzbch - this.zzbcr);
    }

    private final void zzej(long j) {
        while (true) {
            zzmm zzmmVar = this.zzbcl;
            if (j < zzmmVar.zzaum) {
                return;
            }
            this.zzazv.zza(zzmmVar.zzbcw);
            this.zzbcl = this.zzbcl.zzic();
        }
    }

    private final void zzht() {
        this.zzbci.zzht();
        zzmm zzmmVar = this.zzbcl;
        if (zzmmVar.zzbcv) {
            zzmm zzmmVar2 = this.zzbcm;
            boolean z = zzmmVar2.zzbcv;
            zznk[] zznkVarArr = new zznk[(z ? 1 : 0) + (((int) (zzmmVar2.zzbcu - zzmmVar.zzbcu)) / this.zzbch)];
            for (int i = 0; i < zznkVarArr.length; i++) {
                zznkVarArr[i] = zzmmVar.zzbcw;
                zzmmVar = zzmmVar.zzic();
            }
            this.zzazv.zza(zznkVarArr);
        }
        this.zzbcl = new zzmm(0L, this.zzbch);
        this.zzbcm = this.zzbcl;
        this.zzbcq = 0L;
        this.zzbcr = this.zzbch;
        this.zzazv.zzm();
    }

    private final boolean zzia() {
        return this.zzbck.compareAndSet(0, 1);
    }

    private final void zzib() {
        if (this.zzbck.compareAndSet(1, 0)) {
            return;
        }
        zzht();
    }

    public final void disable() {
        if (this.zzbck.getAndSet(2) == 0) {
            zzht();
        }
    }

    public final int zza(zzgy zzgyVar, zzis zzisVar, boolean z, boolean z2, long j) {
        int i;
        int zza = this.zzbci.zza(zzgyVar, zzisVar, z, z2, this.zzbcn, this.zzbcj);
        if (zza == -5) {
            this.zzbcn = zzgyVar.zzafz;
            return -5;
        }
        if (zza != -4) {
            if (zza == -3) {
                return -3;
            }
            throw new IllegalStateException();
        }
        if (!zzisVar.zzgb()) {
            if (zzisVar.zzamd < j) {
                zzisVar.zzw(Integer.MIN_VALUE);
            }
            if (zzisVar.zzgd()) {
                zzmk zzmkVar = this.zzbcj;
                long j2 = zzmkVar.zzauq;
                this.zzanv.reset(1);
                zza(j2, this.zzanv.data, 1);
                long j3 = j2 + 1;
                byte b = this.zzanv.data[0];
                boolean z3 = (b & 128) != 0;
                int i2 = b & Byte.MAX_VALUE;
                zzio zzioVar = zzisVar.zzamc;
                if (zzioVar.iv == null) {
                    zzioVar.iv = new byte[16];
                }
                zza(j3, zzisVar.zzamc.iv, i2);
                long j4 = j3 + i2;
                if (z3) {
                    this.zzanv.reset(2);
                    zza(j4, this.zzanv.data, 2);
                    j4 += 2;
                    i = this.zzanv.readUnsignedShort();
                } else {
                    i = 1;
                }
                int[] iArr = zzisVar.zzamc.numBytesOfClearData;
                if (iArr == null || iArr.length < i) {
                    iArr = new int[i];
                }
                int[] iArr2 = iArr;
                int[] iArr3 = zzisVar.zzamc.numBytesOfEncryptedData;
                if (iArr3 == null || iArr3.length < i) {
                    iArr3 = new int[i];
                }
                int[] iArr4 = iArr3;
                if (z3) {
                    int i3 = i * 6;
                    this.zzanv.reset(i3);
                    zza(j4, this.zzanv.data, i3);
                    j4 += i3;
                    this.zzanv.zzbe(0);
                    for (int i4 = 0; i4 < i; i4++) {
                        iArr2[i4] = this.zzanv.readUnsignedShort();
                        iArr4[i4] = this.zzanv.zzis();
                    }
                } else {
                    iArr2[0] = 0;
                    iArr4[0] = zzmkVar.size - ((int) (j4 - zzmkVar.zzauq));
                }
                zzjn zzjnVar = zzmkVar.zzapt;
                zzio zzioVar2 = zzisVar.zzamc;
                zzioVar2.set(i, iArr2, iArr4, zzjnVar.zzand, zzioVar2.iv, zzjnVar.zzanc);
                long j5 = zzmkVar.zzauq;
                int i5 = (int) (j4 - j5);
                zzmkVar.zzauq = j5 + i5;
                zzmkVar.size -= i5;
            }
            zzisVar.zzy(this.zzbcj.size);
            zzmk zzmkVar2 = this.zzbcj;
            long j6 = zzmkVar2.zzauq;
            ByteBuffer byteBuffer = zzisVar.zzcs;
            int i6 = zzmkVar2.size;
            zzej(j6);
            while (i6 > 0) {
                int i7 = (int) (j6 - this.zzbcl.zzbcu);
                int min = Math.min(i6, this.zzbch - i7);
                zznk zznkVar = this.zzbcl.zzbcw;
                byteBuffer.put(zznkVar.data, zznkVar.zzaz(i7), min);
                j6 += min;
                i6 -= min;
                if (j6 == this.zzbcl.zzaum) {
                    this.zzazv.zza(zznkVar);
                    this.zzbcl = this.zzbcl.zzic();
                }
            }
            zzej(this.zzbcj.zzbct);
        }
        return -4;
    }

    @Override // com.google.android.gms.internal.ads.zzjo
    public final int zza(zzjg zzjgVar, int i, boolean z) {
        if (!zzia()) {
            int zzab = zzjgVar.zzab(i);
            if (zzab != -1) {
                return zzab;
            }
            throw new EOFException();
        }
        try {
            int zzau = zzau(i);
            zznk zznkVar = this.zzbcm.zzbcw;
            int read = zzjgVar.read(zznkVar.data, zznkVar.zzaz(this.zzbcr), zzau);
            if (read == -1) {
                throw new EOFException();
            }
            this.zzbcr += read;
            this.zzbcq += read;
            return read;
        } finally {
            zzib();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjo
    public final void zza(long j, int i, int i2, int i3, zzjn zzjnVar) {
        if (!zzia()) {
            this.zzbci.zzei(j);
            return;
        }
        try {
            this.zzbci.zza(j, i, this.zzbcq - i2, i2, zzjnVar);
        } finally {
            zzib();
        }
    }

    public final void zza(zzml zzmlVar) {
        this.zzbcs = zzmlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzjo
    public final void zza(zzoj zzojVar, int i) {
        if (!zzia()) {
            zzojVar.zzbf(i);
            return;
        }
        while (i > 0) {
            int zzau = zzau(i);
            zznk zznkVar = this.zzbcm.zzbcw;
            zzojVar.zze(zznkVar.data, zznkVar.zzaz(this.zzbcr), zzau);
            this.zzbcr += zzau;
            this.zzbcq += zzau;
            i -= zzau;
        }
        zzib();
    }

    @Override // com.google.android.gms.internal.ads.zzjo
    public final void zze(zzgw zzgwVar) {
        zzgw zzgwVar2 = zzgwVar == null ? null : zzgwVar;
        boolean zzg = this.zzbci.zzg(zzgwVar2);
        this.zzbcp = zzgwVar;
        this.zzbco = false;
        zzml zzmlVar = this.zzbcs;
        if (zzmlVar == null || !zzg) {
            return;
        }
        zzmlVar.zzf(zzgwVar2);
    }

    public final boolean zze(long j, boolean z) {
        long zzd = this.zzbci.zzd(j, z);
        if (zzd == -1) {
            return false;
        }
        zzej(zzd);
        return true;
    }

    public final long zzhn() {
        return this.zzbci.zzhn();
    }

    public final int zzhv() {
        return this.zzbci.zzhv();
    }

    public final boolean zzhw() {
        return this.zzbci.zzhw();
    }

    public final zzgw zzhx() {
        return this.zzbci.zzhx();
    }

    public final void zzhz() {
        long zzhy = this.zzbci.zzhy();
        if (zzhy != -1) {
            zzej(zzhy);
        }
    }

    public final void zzk(boolean z) {
        int andSet = this.zzbck.getAndSet(z ? 0 : 2);
        zzht();
        this.zzbci.zzhu();
        if (andSet == 2) {
            this.zzbcn = null;
        }
    }
}
