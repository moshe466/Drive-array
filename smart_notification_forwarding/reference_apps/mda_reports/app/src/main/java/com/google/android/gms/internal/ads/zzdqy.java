package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdqy extends zzdqw {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private int zzhik;
    private int zzhil;
    private int zzhin;
    private final boolean zzhip;
    private int zzhiq;

    private zzdqy(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzhin = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzhiq = this.pos;
        this.zzhip = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:
    
        if (r2[r3] >= 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzayu() {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.limit
            if (r1 == r0) goto L6b
            byte[] r2 = r5.buffer
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.pos = r3
            return r0
        L11:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6b
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L22
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L68
        L22:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L2f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2d:
            r1 = r3
            goto L68
        L2f:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L68
        L3d:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 < 0) goto L6b
        L68:
            r5.pos = r1
            return r0
        L6b:
            long r0 = r5.a()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdqy.zzayu():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b0, code lost:
    
        if (r2[r0] >= 0) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long zzayv() {
        /*
            Method dump skipped, instructions count: 186
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdqy.zzayv():long");
    }

    private final int zzayw() {
        int i = this.pos;
        if (this.limit - i < 4) {
            throw zzdse.a();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzayx() {
        int i = this.pos;
        if (this.limit - i < 8) {
            throw zzdse.a();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    private final void zzayy() {
        this.limit += this.zzhik;
        int i = this.limit;
        int i2 = i - this.zzhiq;
        int i3 = this.zzhin;
        if (i2 <= i3) {
            this.zzhik = 0;
        } else {
            this.zzhik = i2 - i3;
            this.limit = i - this.zzhik;
        }
    }

    private final byte zzayz() {
        int i = this.pos;
        if (i == this.limit) {
            throw zzdse.a();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 1;
        return bArr[i];
    }

    private final void zzfq(int i) {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i >= 0) {
            throw zzdse.a();
        }
        throw zzdse.b();
    }

    final long a() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((zzayz() & 128) == 0) {
                return j;
            }
        }
        throw zzdse.c();
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final double readDouble() {
        return Double.longBitsToDouble(zzayx());
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final float readFloat() {
        return Float.intBitsToFloat(zzayw());
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final String readString() {
        int zzayu = zzayu();
        if (zzayu > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzayu <= i - i2) {
                String str = new String(this.buffer, i2, zzayu, zzdrv.a);
                this.pos += zzayu;
                return str;
            }
        }
        if (zzayu == 0) {
            return "";
        }
        if (zzayu < 0) {
            throw zzdse.b();
        }
        throw zzdse.a();
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final int zzayc() {
        if (zzays()) {
            this.zzhil = 0;
            return 0;
        }
        this.zzhil = zzayu();
        int i = this.zzhil;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw zzdse.d();
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final long zzayd() {
        return zzayv();
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final long zzaye() {
        return zzayv();
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final int zzayf() {
        return zzayu();
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final long zzayg() {
        return zzayx();
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final int zzayh() {
        return zzayw();
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final boolean zzayi() {
        return zzayv() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final String zzayj() {
        int zzayu = zzayu();
        if (zzayu > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzayu <= i - i2) {
                String a = zzdva.a(this.buffer, i2, zzayu);
                this.pos += zzayu;
                return a;
            }
        }
        if (zzayu == 0) {
            return "";
        }
        if (zzayu <= 0) {
            throw zzdse.b();
        }
        throw zzdse.a();
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final zzdqk zzayk() {
        byte[] bArr;
        int zzayu = zzayu();
        if (zzayu > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzayu <= i - i2) {
                zzdqk zzi = zzdqk.zzi(this.buffer, i2, zzayu);
                this.pos += zzayu;
                return zzi;
            }
        }
        if (zzayu == 0) {
            return zzdqk.zzhhx;
        }
        if (zzayu > 0) {
            int i3 = this.limit;
            int i4 = this.pos;
            if (zzayu <= i3 - i4) {
                this.pos = zzayu + i4;
                bArr = Arrays.copyOfRange(this.buffer, i4, this.pos);
                return zzdqk.a(bArr);
            }
        }
        if (zzayu > 0) {
            throw zzdse.a();
        }
        if (zzayu != 0) {
            throw zzdse.b();
        }
        bArr = zzdrv.zzhng;
        return zzdqk.a(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final int zzayl() {
        return zzayu();
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final int zzaym() {
        return zzayu();
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final int zzayn() {
        return zzayw();
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final long zzayo() {
        return zzayx();
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final int zzayp() {
        return zzdqw.zzfl(zzayu());
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final long zzayq() {
        return zzdqw.zzff(zzayv());
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final boolean zzays() {
        return this.pos == this.limit;
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final int zzayt() {
        return this.pos - this.zzhiq;
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final void zzfh(int i) {
        if (this.zzhil != i) {
            throw zzdse.e();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final boolean zzfi(int i) {
        int zzayc;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.limit - this.pos < 10) {
                while (i3 < 10) {
                    if (zzayz() < 0) {
                        i3++;
                    }
                }
                throw zzdse.c();
            }
            while (i3 < 10) {
                byte[] bArr = this.buffer;
                int i4 = this.pos;
                this.pos = i4 + 1;
                if (bArr[i4] < 0) {
                    i3++;
                }
            }
            throw zzdse.c();
            return true;
        }
        if (i2 == 1) {
            zzfq(8);
            return true;
        }
        if (i2 == 2) {
            zzfq(zzayu());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzdse.f();
            }
            zzfq(4);
            return true;
        }
        do {
            zzayc = zzayc();
            if (zzayc == 0) {
                break;
            }
        } while (zzfi(zzayc));
        zzfh(((i >>> 3) << 3) | 4);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final int zzfj(int i) {
        if (i < 0) {
            throw zzdse.b();
        }
        int zzayt = i + zzayt();
        int i2 = this.zzhin;
        if (zzayt > i2) {
            throw zzdse.a();
        }
        this.zzhin = zzayt;
        zzayy();
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final void zzfk(int i) {
        this.zzhin = i;
        zzayy();
    }
}
