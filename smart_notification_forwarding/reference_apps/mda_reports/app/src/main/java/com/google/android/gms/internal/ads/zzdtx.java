package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* loaded from: classes.dex */
final class zzdtx extends InputStream {
    private int mark;
    private final /* synthetic */ zzdtt zzhqd;
    private zzdty zzhqe;
    private zzdqr zzhqf;
    private int zzhqg;
    private int zzhqh;
    private int zzhqi;

    public zzdtx(zzdtt zzdttVar) {
        this.zzhqd = zzdttVar;
        initialize();
    }

    private final void initialize() {
        this.zzhqe = new zzdty(this.zzhqd, null);
        this.zzhqf = (zzdqr) this.zzhqe.next();
        this.zzhqg = this.zzhqf.size();
        this.zzhqh = 0;
        this.zzhqi = 0;
    }

    private final void zzbbr() {
        if (this.zzhqf != null) {
            int i = this.zzhqh;
            int i2 = this.zzhqg;
            if (i == i2) {
                this.zzhqi += i2;
                this.zzhqh = 0;
                if (this.zzhqe.hasNext()) {
                    this.zzhqf = (zzdqr) this.zzhqe.next();
                    this.zzhqg = this.zzhqf.size();
                } else {
                    this.zzhqf = null;
                    this.zzhqg = 0;
                }
            }
        }
    }

    private final int zzl(byte[] bArr, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        while (true) {
            if (i4 <= 0) {
                break;
            }
            zzbbr();
            if (this.zzhqf != null) {
                int min = Math.min(this.zzhqg - this.zzhqh, i4);
                if (bArr != null) {
                    this.zzhqf.zza(bArr, this.zzhqh, i3, min);
                    i3 += min;
                }
                this.zzhqh += min;
                i4 -= min;
            } else if (i4 == i2) {
                return -1;
            }
        }
        return i2 - i4;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.zzhqd.size() - (this.zzhqi + this.zzhqh);
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.mark = this.zzhqi + this.zzhqh;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        zzbbr();
        zzdqr zzdqrVar = this.zzhqf;
        if (zzdqrVar == null) {
            return -1;
        }
        int i = this.zzhqh;
        this.zzhqh = i + 1;
        return zzdqrVar.zzfe(i) & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        return zzl(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        initialize();
        zzl(null, 0, this.mark);
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        if (j < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (j > 2147483647L) {
            j = 2147483647L;
        }
        return zzl(null, 0, (int) j);
    }
}
