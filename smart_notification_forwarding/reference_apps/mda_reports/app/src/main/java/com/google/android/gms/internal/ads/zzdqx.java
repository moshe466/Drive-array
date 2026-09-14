package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class zzdqx extends zzdqw {
    private final byte[] buffer;
    private int pos;
    private int zzaif;
    private final InputStream zzhij;
    private int zzhik;
    private int zzhil;
    private int zzhim;
    private int zzhin;
    private zzdra zzhio;

    private zzdqx(InputStream inputStream, int i) {
        super();
        this.zzhin = Integer.MAX_VALUE;
        this.zzhio = null;
        zzdrv.a(inputStream, "input");
        this.zzhij = inputStream;
        this.buffer = new byte[i];
        this.zzaif = 0;
        this.pos = 0;
        this.zzhim = 0;
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
            int r1 = r5.zzaif
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdqx.zzayu():int");
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdqx.zzayv():long");
    }

    private final int zzayw() {
        int i = this.pos;
        if (this.zzaif - i < 4) {
            zzfm(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzayx() {
        int i = this.pos;
        if (this.zzaif - i < 8) {
            zzfm(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    private final void zzayy() {
        this.zzaif += this.zzhik;
        int i = this.zzhim;
        int i2 = this.zzaif;
        int i3 = i + i2;
        int i4 = this.zzhin;
        if (i3 <= i4) {
            this.zzhik = 0;
        } else {
            this.zzhik = i3 - i4;
            this.zzaif = i2 - this.zzhik;
        }
    }

    private final byte zzayz() {
        if (this.pos == this.zzaif) {
            zzfm(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final void zzfm(int i) {
        if (zzfn(i)) {
            return;
        }
        if (i <= (this.c - this.zzhim) - this.pos) {
            throw zzdse.a();
        }
        throw zzdse.g();
    }

    private final boolean zzfn(int i) {
        do {
            int i2 = this.pos;
            int i3 = i2 + i;
            int i4 = this.zzaif;
            if (i3 <= i4) {
                StringBuilder sb = new StringBuilder(77);
                sb.append("refillBuffer() called when ");
                sb.append(i);
                sb.append(" bytes were already available in buffer");
                throw new IllegalStateException(sb.toString());
            }
            int i5 = this.c;
            int i6 = this.zzhim;
            if (i > (i5 - i6) - i2 || i6 + i2 + i > this.zzhin) {
                return false;
            }
            if (i2 > 0) {
                if (i4 > i2) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                }
                this.zzhim += i2;
                this.zzaif -= i2;
                this.pos = 0;
            }
            InputStream inputStream = this.zzhij;
            byte[] bArr2 = this.buffer;
            int i7 = this.zzaif;
            int read = inputStream.read(bArr2, i7, Math.min(bArr2.length - i7, (this.c - this.zzhim) - i7));
            if (read == 0 || read < -1 || read > this.buffer.length) {
                String valueOf = String.valueOf(this.zzhij.getClass());
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 91);
                sb2.append(valueOf);
                sb2.append("#read(byte[]) returned invalid result: ");
                sb2.append(read);
                sb2.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb2.toString());
            }
            if (read <= 0) {
                return false;
            }
            this.zzaif += read;
            zzayy();
        } while (this.zzaif < i);
        return true;
    }

    private final byte[] zzfo(int i) {
        if (i == 0) {
            return zzdrv.zzhng;
        }
        if (i < 0) {
            throw zzdse.b();
        }
        int i2 = this.zzhim;
        int i3 = this.pos;
        int i4 = i2 + i3 + i;
        if (i4 - this.c > 0) {
            throw zzdse.g();
        }
        int i5 = this.zzhin;
        if (i4 > i5) {
            zzfq((i5 - i2) - i3);
            throw zzdse.a();
        }
        int i6 = this.zzaif - i3;
        int i7 = i - i6;
        if (i7 >= 4096 && i7 > this.zzhij.available()) {
            return null;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, this.pos, bArr, 0, i6);
        this.zzhim += this.zzaif;
        this.pos = 0;
        this.zzaif = 0;
        while (i6 < bArr.length) {
            int read = this.zzhij.read(bArr, i6, i - i6);
            if (read == -1) {
                throw zzdse.a();
            }
            this.zzhim += read;
            i6 += read;
        }
        return bArr;
    }

    private final List<byte[]> zzfp(int i) {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            byte[] bArr = new byte[Math.min(i, 4096)];
            int i2 = 0;
            while (i2 < bArr.length) {
                int read = this.zzhij.read(bArr, i2, bArr.length - i2);
                if (read == -1) {
                    throw zzdse.a();
                }
                this.zzhim += read;
                i2 += read;
            }
            i -= bArr.length;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzfq(int i) {
        int i2 = this.zzaif;
        int i3 = this.pos;
        if (i <= i2 - i3 && i >= 0) {
            this.pos = i3 + i;
            return;
        }
        if (i < 0) {
            throw zzdse.b();
        }
        int i4 = this.zzhim;
        int i5 = this.pos;
        int i6 = i4 + i5 + i;
        int i7 = this.zzhin;
        if (i6 > i7) {
            zzfq((i7 - i4) - i5);
            throw zzdse.a();
        }
        this.zzhim = i4 + i5;
        int i8 = this.zzaif - i5;
        this.zzaif = 0;
        this.pos = 0;
        while (i8 < i) {
            try {
                long j = i - i8;
                long skip = this.zzhij.skip(j);
                if (skip >= 0 && skip <= j) {
                    if (skip == 0) {
                        break;
                    } else {
                        i8 += (int) skip;
                    }
                } else {
                    String valueOf = String.valueOf(this.zzhij.getClass());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 92);
                    sb.append(valueOf);
                    sb.append("#skip returned invalid result: ");
                    sb.append(skip);
                    sb.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb.toString());
                }
            } finally {
                this.zzhim += i8;
                zzayy();
            }
        }
        if (i8 >= i) {
            return;
        }
        int i9 = this.zzaif;
        int i10 = i9 - this.pos;
        this.pos = i9;
        while (true) {
            zzfm(1);
            int i11 = i - i10;
            int i12 = this.zzaif;
            if (i11 <= i12) {
                this.pos = i11;
                return;
            } else {
                i10 += i12;
                this.pos = i12;
            }
        }
    }

    private final byte[] zzg(int i, boolean z) {
        byte[] zzfo = zzfo(i);
        if (zzfo != null) {
            return zzfo;
        }
        int i2 = this.pos;
        int i3 = this.zzaif;
        int i4 = i3 - i2;
        this.zzhim += i3;
        this.pos = 0;
        this.zzaif = 0;
        List<byte[]> zzfp = zzfp(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, i2, bArr, 0, i4);
        for (byte[] bArr2 : zzfp) {
            System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
            i4 += bArr2.length;
        }
        return bArr;
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
            int i = this.zzaif;
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
        if (zzayu > this.zzaif) {
            return new String(zzg(zzayu, false), zzdrv.a);
        }
        zzfm(zzayu);
        String str2 = new String(this.buffer, this.pos, zzayu, zzdrv.a);
        this.pos += zzayu;
        return str2;
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
        byte[] zzg;
        int zzayu = zzayu();
        int i = this.pos;
        int i2 = 0;
        if (zzayu <= this.zzaif - i && zzayu > 0) {
            zzg = this.buffer;
            this.pos = i + zzayu;
            i2 = i;
        } else {
            if (zzayu == 0) {
                return "";
            }
            if (zzayu <= this.zzaif) {
                zzfm(zzayu);
                zzg = this.buffer;
                this.pos = zzayu;
            } else {
                zzg = zzg(zzayu, false);
            }
        }
        return zzdva.a(zzg, i2, zzayu);
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final zzdqk zzayk() {
        int zzayu = zzayu();
        int i = this.zzaif;
        int i2 = this.pos;
        if (zzayu <= i - i2 && zzayu > 0) {
            zzdqk zzi = zzdqk.zzi(this.buffer, i2, zzayu);
            this.pos += zzayu;
            return zzi;
        }
        if (zzayu == 0) {
            return zzdqk.zzhhx;
        }
        byte[] zzfo = zzfo(zzayu);
        if (zzfo != null) {
            return zzdqk.zzu(zzfo);
        }
        int i3 = this.pos;
        int i4 = this.zzaif;
        int i5 = i4 - i3;
        this.zzhim += i4;
        this.pos = 0;
        this.zzaif = 0;
        List<byte[]> zzfp = zzfp(zzayu - i5);
        byte[] bArr = new byte[zzayu];
        System.arraycopy(this.buffer, i3, bArr, 0, i5);
        for (byte[] bArr2 : zzfp) {
            System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
            i5 += bArr2.length;
        }
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
        return this.pos == this.zzaif && !zzfn(1);
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final int zzayt() {
        return this.zzhim + this.pos;
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
            if (this.zzaif - this.pos < 10) {
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
        int i2 = i + this.zzhim + this.pos;
        int i3 = this.zzhin;
        if (i2 > i3) {
            throw zzdse.a();
        }
        this.zzhin = i2;
        zzayy();
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzdqw
    public final void zzfk(int i) {
        this.zzhin = i;
        zzayy();
    }
}
