package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class zzdrb extends zzdqh {
    private static final Logger logger = Logger.getLogger(zzdrb.class.getName());
    private static final boolean zzhiu = zzduy.a();
    zzdrf a;

    /* loaded from: classes.dex */
    static class zza extends zzdrb {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i3 = i + i2;
            if ((i | i2 | (bArr.length - i3)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            this.buffer = bArr;
            this.offset = i;
            this.position = i;
            this.limit = i3;
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        final void a(int i, zzdte zzdteVar, zzdua zzduaVar) {
            zzaa(i, 2);
            zzdqa zzdqaVar = (zzdqa) zzdteVar;
            int a = zzdqaVar.a();
            if (a == -1) {
                a = zzduaVar.zzax(zzdqaVar);
                zzdqaVar.a(a);
            }
            zzfw(a);
            zzduaVar.zza(zzdteVar, this.a);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public void flush() {
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void write(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zza(int i, zzdqk zzdqkVar) {
            zzaa(i, 2);
            zzbe(zzdqkVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zza(int i, zzdte zzdteVar) {
            zzaa(i, 2);
            zzg(zzdteVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzaa(int i, int i2) {
            zzfw((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzab(int i, int i2) {
            zzaa(i, 0);
            zzfv(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzac(int i, int i2) {
            zzaa(i, 0);
            zzfw(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzae(int i, int i2) {
            zzaa(i, 5);
            zzfy(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final int zzazc() {
            return this.limit - this.position;
        }

        public final int zzazf() {
            return this.position - this.offset;
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzb(int i, zzdqk zzdqkVar) {
            zzaa(1, 3);
            zzac(2, i);
            zza(3, zzdqkVar);
            zzaa(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzb(int i, zzdte zzdteVar) {
            zzaa(1, 3);
            zzac(2, i);
            zza(3, zzdteVar);
            zzaa(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzbe(zzdqk zzdqkVar) {
            zzfw(zzdqkVar.size());
            zzdqkVar.a(this);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzd(byte b) {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzf(int i, String str) {
            zzaa(i, 2);
            zzhg(str);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzfg(long j) {
            if (zzdrb.zzhiu && zzazc() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    zzduy.a(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                zzduy.a(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            }
            byte[] bArr4 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzfi(long j) {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) j;
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) (j >> 8);
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) (j >> 16);
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr4[i4] = (byte) (j >> 24);
                byte[] bArr5 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr5[i5] = (byte) (j >> 32);
                byte[] bArr6 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr6[i6] = (byte) (j >> 40);
                byte[] bArr7 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr7[i7] = (byte) (j >> 48);
                byte[] bArr8 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr8[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzfv(int i) {
            if (i >= 0) {
                zzfw(i);
            } else {
                zzfg(i);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzfw(int i) {
            if (!zzdrb.zzhiu || zzdqd.a() || zzazc() < 5) {
                while ((i & (-128)) != 0) {
                    try {
                        byte[] bArr = this.buffer;
                        int i2 = this.position;
                        this.position = i2 + 1;
                        bArr[i2] = (byte) ((i & 127) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e) {
                        throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                    }
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) i;
                return;
            }
            if ((i & (-128)) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzduy.a(bArr3, i4, (byte) i);
                return;
            }
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            zzduy.a(bArr4, i5, (byte) (i | 128));
            int i6 = i >>> 7;
            if ((i6 & (-128)) == 0) {
                byte[] bArr5 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                zzduy.a(bArr5, i7, (byte) i6);
                return;
            }
            byte[] bArr6 = this.buffer;
            int i8 = this.position;
            this.position = i8 + 1;
            zzduy.a(bArr6, i8, (byte) (i6 | 128));
            int i9 = i6 >>> 7;
            if ((i9 & (-128)) == 0) {
                byte[] bArr7 = this.buffer;
                int i10 = this.position;
                this.position = i10 + 1;
                zzduy.a(bArr7, i10, (byte) i9);
                return;
            }
            byte[] bArr8 = this.buffer;
            int i11 = this.position;
            this.position = i11 + 1;
            zzduy.a(bArr8, i11, (byte) (i9 | 128));
            int i12 = i9 >>> 7;
            if ((i12 & (-128)) == 0) {
                byte[] bArr9 = this.buffer;
                int i13 = this.position;
                this.position = i13 + 1;
                zzduy.a(bArr9, i13, (byte) i12);
                return;
            }
            byte[] bArr10 = this.buffer;
            int i14 = this.position;
            this.position = i14 + 1;
            zzduy.a(bArr10, i14, (byte) (i12 | 128));
            byte[] bArr11 = this.buffer;
            int i15 = this.position;
            this.position = i15 + 1;
            zzduy.a(bArr11, i15, (byte) (i12 >>> 7));
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzfy(int i) {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzg(int i, long j) {
            zzaa(i, 0);
            zzfg(j);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzg(zzdte zzdteVar) {
            zzfw(zzdteVar.zzazu());
            zzdteVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzh(int i, boolean z) {
            zzaa(i, 0);
            zzd(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzdqh
        public final void zzh(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzhg(String str) {
            int i = this.position;
            try {
                int zzgb = zzdrb.zzgb(str.length() * 3);
                int zzgb2 = zzdrb.zzgb(str.length());
                if (zzgb2 != zzgb) {
                    zzfw(zzdva.a(str));
                    this.position = zzdva.a(str, this.buffer, this.position, zzazc());
                    return;
                }
                this.position = i + zzgb2;
                int a = zzdva.a(str, this.buffer, this.position, zzazc());
                this.position = i;
                zzfw((a - i) - zzgb2);
                this.position = a;
            } catch (zzdve e) {
                this.position = i;
                a(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzi(int i, long j) {
            zzaa(i, 1);
            zzfi(j);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzk(byte[] bArr, int i, int i2) {
            zzfw(i2);
            write(bArr, 0, i2);
        }
    }

    /* loaded from: classes.dex */
    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        zzb(java.lang.String r3) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L11
                java.lang.String r3 = r1.concat(r3)
                goto L16
            L11:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L16:
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdrb.zzb.<init>(java.lang.String):void");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        zzb(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L11
                java.lang.String r3 = r1.concat(r3)
                goto L16
            L11:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L16:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdrb.zzb.<init>(java.lang.String, java.lang.Throwable):void");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class zzc extends zza {
        private final ByteBuffer zzhix;
        private int zzhiy;

        zzc(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.zzhix = byteBuffer;
            this.zzhiy = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.ads.zzdrb.zza, com.google.android.gms.internal.ads.zzdrb
        public final void flush() {
            this.zzhix.position(this.zzhiy + zzazf());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class zzd extends zzdrb {
        private final ByteBuffer zzako;
        private long zzamw;
        private final ByteBuffer zzhiz;
        private final long zzhja;
        private final long zzhjb;
        private final long zzhjc;
        private final long zzhjd;

        zzd(ByteBuffer byteBuffer) {
            super();
            this.zzhiz = byteBuffer;
            this.zzako = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzhja = zzduy.a(byteBuffer);
            this.zzhjb = this.zzhja + byteBuffer.position();
            this.zzhjc = this.zzhja + byteBuffer.limit();
            this.zzhjd = this.zzhjc - 10;
            this.zzamw = this.zzhjb;
        }

        private final void zzfp(long j) {
            this.zzako.position((int) (j - this.zzhja));
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        final void a(int i, zzdte zzdteVar, zzdua zzduaVar) {
            zzaa(i, 2);
            b(zzdteVar, zzduaVar);
        }

        final void b(zzdte zzdteVar, zzdua zzduaVar) {
            zzdqa zzdqaVar = (zzdqa) zzdteVar;
            int a = zzdqaVar.a();
            if (a == -1) {
                a = zzduaVar.zzax(zzdqaVar);
                zzdqaVar.a(a);
            }
            zzfw(a);
            zzduaVar.zza(zzdteVar, this.a);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void flush() {
            this.zzhiz.position((int) (this.zzamw - this.zzhja));
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void write(byte[] bArr, int i, int i2) {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = i2;
                long j2 = this.zzhjc - j;
                long j3 = this.zzamw;
                if (j2 >= j3) {
                    zzduy.a(bArr, i, j3, j);
                    this.zzamw += j;
                    return;
                }
            }
            if (bArr != null) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.zzamw), Long.valueOf(this.zzhjc), Integer.valueOf(i2)));
            }
            throw new NullPointerException("value");
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zza(int i, zzdqk zzdqkVar) {
            zzaa(i, 2);
            zzbe(zzdqkVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zza(int i, zzdte zzdteVar) {
            zzaa(i, 2);
            zzg(zzdteVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzaa(int i, int i2) {
            zzfw((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzab(int i, int i2) {
            zzaa(i, 0);
            zzfv(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzac(int i, int i2) {
            zzaa(i, 0);
            zzfw(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzae(int i, int i2) {
            zzaa(i, 5);
            zzfy(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final int zzazc() {
            return (int) (this.zzhjc - this.zzamw);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzb(int i, zzdqk zzdqkVar) {
            zzaa(1, 3);
            zzac(2, i);
            zza(3, zzdqkVar);
            zzaa(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzb(int i, zzdte zzdteVar) {
            zzaa(1, 3);
            zzac(2, i);
            zza(3, zzdteVar);
            zzaa(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzbe(zzdqk zzdqkVar) {
            zzfw(zzdqkVar.size());
            zzdqkVar.a(this);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzd(byte b) {
            long j = this.zzamw;
            if (j >= this.zzhjc) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j), Long.valueOf(this.zzhjc), 1));
            }
            this.zzamw = 1 + j;
            zzduy.a(j, b);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzf(int i, String str) {
            zzaa(i, 2);
            zzhg(str);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzfg(long j) {
            long j2;
            if (this.zzamw <= this.zzhjd) {
                while (true) {
                    long j3 = j & (-128);
                    j2 = this.zzamw;
                    if (j3 == 0) {
                        break;
                    }
                    this.zzamw = j2 + 1;
                    zzduy.a(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            } else {
                while (true) {
                    j2 = this.zzamw;
                    if (j2 >= this.zzhjc) {
                        throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j2), Long.valueOf(this.zzhjc), 1));
                    }
                    if ((j & (-128)) == 0) {
                        break;
                    }
                    this.zzamw = j2 + 1;
                    zzduy.a(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            }
            this.zzamw = 1 + j2;
            zzduy.a(j2, (byte) j);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzfi(long j) {
            this.zzako.putLong((int) (this.zzamw - this.zzhja), j);
            this.zzamw += 8;
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzfv(int i) {
            if (i >= 0) {
                zzfw(i);
            } else {
                zzfg(i);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzfw(int i) {
            long j;
            if (this.zzamw <= this.zzhjd) {
                while ((i & (-128)) != 0) {
                    long j2 = this.zzamw;
                    this.zzamw = j2 + 1;
                    zzduy.a(j2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                j = this.zzamw;
            } else {
                while (true) {
                    j = this.zzamw;
                    if (j >= this.zzhjc) {
                        throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j), Long.valueOf(this.zzhjc), 1));
                    }
                    if ((i & (-128)) == 0) {
                        break;
                    }
                    this.zzamw = j + 1;
                    zzduy.a(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
            }
            this.zzamw = 1 + j;
            zzduy.a(j, (byte) i);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzfy(int i) {
            this.zzako.putInt((int) (this.zzamw - this.zzhja), i);
            this.zzamw += 4;
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzg(int i, long j) {
            zzaa(i, 0);
            zzfg(j);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzg(zzdte zzdteVar) {
            zzfw(zzdteVar.zzazu());
            zzdteVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzh(int i, boolean z) {
            zzaa(i, 0);
            zzd(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzdqh
        public final void zzh(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzhg(String str) {
            long j = this.zzamw;
            try {
                int zzgb = zzdrb.zzgb(str.length() * 3);
                int zzgb2 = zzdrb.zzgb(str.length());
                if (zzgb2 != zzgb) {
                    int a = zzdva.a(str);
                    zzfw(a);
                    zzfp(this.zzamw);
                    zzdva.a(str, this.zzako);
                    this.zzamw += a;
                    return;
                }
                int i = ((int) (this.zzamw - this.zzhja)) + zzgb2;
                this.zzako.position(i);
                zzdva.a(str, this.zzako);
                int position = this.zzako.position() - i;
                zzfw(position);
                this.zzamw += position;
            } catch (zzdve e) {
                this.zzamw = j;
                zzfp(this.zzamw);
                a(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzb(e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzb(e3);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzi(int i, long j) {
            zzaa(i, 1);
            zzfi(j);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzk(byte[] bArr, int i, int i2) {
            zzfw(i2);
            write(bArr, 0, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class zze extends zzdrb {
        private final ByteBuffer zzako;
        private final int zzhiy;
        private final ByteBuffer zzhiz;

        zze(ByteBuffer byteBuffer) {
            super();
            this.zzhiz = byteBuffer;
            this.zzako = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzhiy = byteBuffer.position();
        }

        private final void zzhi(String str) {
            try {
                zzdva.a(str, this.zzako);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        final void a(int i, zzdte zzdteVar, zzdua zzduaVar) {
            zzaa(i, 2);
            b(zzdteVar, zzduaVar);
        }

        final void b(zzdte zzdteVar, zzdua zzduaVar) {
            zzdqa zzdqaVar = (zzdqa) zzdteVar;
            int a = zzdqaVar.a();
            if (a == -1) {
                a = zzduaVar.zzax(zzdqaVar);
                zzdqaVar.a(a);
            }
            zzfw(a);
            zzduaVar.zza(zzdteVar, this.a);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void flush() {
            this.zzhiz.position(this.zzako.position());
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void write(byte[] bArr, int i, int i2) {
            try {
                this.zzako.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(e);
            } catch (BufferOverflowException e2) {
                throw new zzb(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zza(int i, zzdqk zzdqkVar) {
            zzaa(i, 2);
            zzbe(zzdqkVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zza(int i, zzdte zzdteVar) {
            zzaa(i, 2);
            zzg(zzdteVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzaa(int i, int i2) {
            zzfw((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzab(int i, int i2) {
            zzaa(i, 0);
            zzfv(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzac(int i, int i2) {
            zzaa(i, 0);
            zzfw(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzae(int i, int i2) {
            zzaa(i, 5);
            zzfy(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final int zzazc() {
            return this.zzako.remaining();
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzb(int i, zzdqk zzdqkVar) {
            zzaa(1, 3);
            zzac(2, i);
            zza(3, zzdqkVar);
            zzaa(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzb(int i, zzdte zzdteVar) {
            zzaa(1, 3);
            zzac(2, i);
            zza(3, zzdteVar);
            zzaa(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzbe(zzdqk zzdqkVar) {
            zzfw(zzdqkVar.size());
            zzdqkVar.a(this);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzd(byte b) {
            try {
                this.zzako.put(b);
            } catch (BufferOverflowException e) {
                throw new zzb(e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzf(int i, String str) {
            zzaa(i, 2);
            zzhg(str);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzfg(long j) {
            while (((-128) & j) != 0) {
                try {
                    this.zzako.put((byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new zzb(e);
                }
            }
            this.zzako.put((byte) j);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzfi(long j) {
            try {
                this.zzako.putLong(j);
            } catch (BufferOverflowException e) {
                throw new zzb(e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzfv(int i) {
            if (i >= 0) {
                zzfw(i);
            } else {
                zzfg(i);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzfw(int i) {
            while ((i & (-128)) != 0) {
                try {
                    this.zzako.put((byte) ((i & 127) | 128));
                    i >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new zzb(e);
                }
            }
            this.zzako.put((byte) i);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzfy(int i) {
            try {
                this.zzako.putInt(i);
            } catch (BufferOverflowException e) {
                throw new zzb(e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzg(int i, long j) {
            zzaa(i, 0);
            zzfg(j);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzg(zzdte zzdteVar) {
            zzfw(zzdteVar.zzazu());
            zzdteVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzh(int i, boolean z) {
            zzaa(i, 0);
            zzd(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzdqh
        public final void zzh(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzhg(String str) {
            int position = this.zzako.position();
            try {
                int zzgb = zzdrb.zzgb(str.length() * 3);
                int zzgb2 = zzdrb.zzgb(str.length());
                if (zzgb2 != zzgb) {
                    zzfw(zzdva.a(str));
                    zzhi(str);
                    return;
                }
                int position2 = this.zzako.position() + zzgb2;
                this.zzako.position(position2);
                zzhi(str);
                int position3 = this.zzako.position();
                this.zzako.position(position);
                zzfw(position3 - position2);
                this.zzako.position(position3);
            } catch (zzdve e) {
                this.zzako.position(position);
                a(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzb(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzi(int i, long j) {
            zzaa(i, 1);
            zzfi(j);
        }

        @Override // com.google.android.gms.internal.ads.zzdrb
        public final void zzk(byte[] bArr, int i, int i2) {
            zzfw(i2);
            write(bArr, 0, i2);
        }
    }

    private zzdrb() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzdte zzdteVar, zzdua zzduaVar) {
        zzdqa zzdqaVar = (zzdqa) zzdteVar;
        int a = zzdqaVar.a();
        if (a == -1) {
            a = zzduaVar.zzax(zzdqaVar);
            zzdqaVar.a(a);
        }
        return zzgb(a) + a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, zzdte zzdteVar, zzdua zzduaVar) {
        return zzfz(i) + a(zzdteVar, zzduaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int c(int i, zzdte zzdteVar, zzdua zzduaVar) {
        int zzfz = zzfz(i) << 1;
        zzdqa zzdqaVar = (zzdqa) zzdteVar;
        int a = zzdqaVar.a();
        if (a == -1) {
            a = zzduaVar.zzax(zzdqaVar);
            zzdqaVar.a(a);
        }
        return zzfz + a;
    }

    public static int zza(int i, zzdsj zzdsjVar) {
        int zzfz = zzfz(i);
        int zzazu = zzdsjVar.zzazu();
        return zzfz + zzgb(zzazu) + zzazu;
    }

    public static int zza(zzdsj zzdsjVar) {
        int zzazu = zzdsjVar.zzazu();
        return zzgb(zzazu) + zzazu;
    }

    public static int zzaf(int i, int i2) {
        return zzfz(i) + zzga(i2);
    }

    public static int zzag(int i, int i2) {
        return zzfz(i) + zzgb(i2);
    }

    public static int zzah(int i, int i2) {
        return zzfz(i) + zzgb(zzgg(i2));
    }

    public static int zzai(int i, int i2) {
        return zzfz(i) + 4;
    }

    public static int zzaj(int i, int i2) {
        return zzfz(i) + 4;
    }

    public static int zzak(int i, int i2) {
        return zzfz(i) + zzga(i2);
    }

    public static int zzb(int i, float f) {
        return zzfz(i) + 4;
    }

    public static int zzb(int i, zzdsj zzdsjVar) {
        return (zzfz(1) << 1) + zzag(2, i) + zza(3, zzdsjVar);
    }

    public static int zzbf(zzdqk zzdqkVar) {
        int size = zzdqkVar.size();
        return zzgb(size) + size;
    }

    public static int zzbo(boolean z) {
        return 1;
    }

    public static int zzc(double d) {
        return 8;
    }

    public static int zzc(int i, double d) {
        return zzfz(i) + 8;
    }

    public static int zzc(int i, zzdqk zzdqkVar) {
        int zzfz = zzfz(i);
        int size = zzdqkVar.size();
        return zzfz + zzgb(size) + size;
    }

    public static int zzc(int i, zzdte zzdteVar) {
        return zzfz(i) + zzh(zzdteVar);
    }

    public static int zzd(int i, zzdqk zzdqkVar) {
        return (zzfz(1) << 1) + zzag(2, i) + zzc(3, zzdqkVar);
    }

    public static int zzd(int i, zzdte zzdteVar) {
        return (zzfz(1) << 1) + zzag(2, i) + zzc(3, zzdteVar);
    }

    public static int zzfj(long j) {
        return zzfk(j);
    }

    public static int zzfk(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int zzfl(long j) {
        return zzfk(zzfo(j));
    }

    public static int zzfm(long j) {
        return 8;
    }

    public static int zzfn(long j) {
        return 8;
    }

    private static long zzfo(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzfz(int i) {
        return zzgb(i << 3);
    }

    public static int zzg(float f) {
        return 4;
    }

    public static int zzg(int i, String str) {
        return zzfz(i) + zzhh(str);
    }

    public static int zzga(int i) {
        if (i >= 0) {
            return zzgb(i);
        }
        return 10;
    }

    public static int zzgb(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzgc(int i) {
        return zzgb(zzgg(i));
    }

    public static int zzgd(int i) {
        return 4;
    }

    public static int zzge(int i) {
        return 4;
    }

    public static int zzgf(int i) {
        return zzga(i);
    }

    private static int zzgg(int i) {
        return (i >> 31) ^ (i << 1);
    }

    @Deprecated
    public static int zzgh(int i) {
        return zzgb(i);
    }

    public static int zzh(zzdte zzdteVar) {
        int zzazu = zzdteVar.zzazu();
        return zzgb(zzazu) + zzazu;
    }

    public static int zzhh(String str) {
        int length;
        try {
            length = zzdva.a(str);
        } catch (zzdve unused) {
            length = str.getBytes(zzdrv.a).length;
        }
        return zzgb(length) + length;
    }

    public static int zzi(int i, boolean z) {
        return zzfz(i) + 1;
    }

    @Deprecated
    public static int zzi(zzdte zzdteVar) {
        return zzdteVar.zzazu();
    }

    public static int zzj(int i, long j) {
        return zzfz(i) + zzfk(j);
    }

    public static int zzk(int i, long j) {
        return zzfz(i) + zzfk(j);
    }

    public static int zzl(int i, long j) {
        return zzfz(i) + zzfk(zzfo(j));
    }

    public static int zzm(int i, long j) {
        return zzfz(i) + 8;
    }

    public static zzdrb zzm(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new zzc(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        }
        return zzduy.b() ? new zzd(byteBuffer) : new zze(byteBuffer);
    }

    public static int zzn(int i, long j) {
        return zzfz(i) + 8;
    }

    public static zzdrb zzw(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzx(byte[] bArr) {
        int length = bArr.length;
        return zzgb(length) + length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(int i, zzdte zzdteVar, zzdua zzduaVar);

    final void a(String str, zzdve zzdveVar) {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzdveVar);
        byte[] bytes = str.getBytes(zzdrv.a);
        try {
            zzfw(bytes.length);
            zzh(bytes, 0, bytes.length);
        } catch (zzb e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzb(e2);
        }
    }

    public abstract void flush();

    public abstract void write(byte[] bArr, int i, int i2);

    public final void zza(int i, float f) {
        zzae(i, Float.floatToRawIntBits(f));
    }

    public abstract void zza(int i, zzdqk zzdqkVar);

    public abstract void zza(int i, zzdte zzdteVar);

    public abstract void zzaa(int i, int i2);

    public abstract void zzab(int i, int i2);

    public abstract void zzac(int i, int i2);

    public final void zzad(int i, int i2) {
        zzac(i, zzgg(i2));
    }

    public abstract void zzae(int i, int i2);

    public abstract int zzazc();

    public final void zzazd() {
        if (zzazc() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzb(double d) {
        zzfi(Double.doubleToRawLongBits(d));
    }

    public final void zzb(int i, double d) {
        zzi(i, Double.doubleToRawLongBits(d));
    }

    public abstract void zzb(int i, zzdqk zzdqkVar);

    public abstract void zzb(int i, zzdte zzdteVar);

    public abstract void zzbe(zzdqk zzdqkVar);

    public final void zzbn(boolean z) {
        zzd(z ? (byte) 1 : (byte) 0);
    }

    public abstract void zzd(byte b);

    public final void zzf(float f) {
        zzfy(Float.floatToRawIntBits(f));
    }

    public abstract void zzf(int i, String str);

    public abstract void zzfg(long j);

    public final void zzfh(long j) {
        zzfg(zzfo(j));
    }

    public abstract void zzfi(long j);

    public abstract void zzfv(int i);

    public abstract void zzfw(int i);

    public final void zzfx(int i) {
        zzfw(zzgg(i));
    }

    public abstract void zzfy(int i);

    public abstract void zzg(int i, long j);

    public abstract void zzg(zzdte zzdteVar);

    public final void zzh(int i, long j) {
        zzg(i, zzfo(j));
    }

    public abstract void zzh(int i, boolean z);

    public abstract void zzhg(String str);

    public abstract void zzi(int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzk(byte[] bArr, int i, int i2);
}
