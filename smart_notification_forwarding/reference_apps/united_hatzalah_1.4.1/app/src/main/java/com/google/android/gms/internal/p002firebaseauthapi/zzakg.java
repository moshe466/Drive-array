package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import e0.a;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class zzakg extends zzajm {
    private static final Logger zza = Logger.getLogger(zzakg.class.getName());
    private static final boolean zzb = zzanp.zzc();
    zzakj zze;

    /* loaded from: classes.dex */
    public static abstract class zza extends zzakg {
        final byte[] zza;
        final int zzb;
        int zzc;
        int zzd;

        public zza(int i) {
            super();
            if (i >= 0) {
                byte[] bArr = new byte[Math.max(i, 20)];
                this.zza = bArr;
                this.zzb = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final int zza() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        public final void zzb(int i) {
            if (zzakg.zzb) {
                long j2 = this.zzc;
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.zza;
                    int i3 = this.zzc;
                    this.zzc = i3 + 1;
                    zzanp.zza(bArr, i3, (byte) (i | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.zza;
                int i4 = this.zzc;
                this.zzc = i4 + 1;
                zzanp.zza(bArr2, i4, (byte) i);
                this.zzd += (int) (this.zzc - j2);
                return;
            }
            while ((i & (-128)) != 0) {
                byte[] bArr3 = this.zza;
                int i5 = this.zzc;
                this.zzc = i5 + 1;
                bArr3[i5] = (byte) (i | 128);
                this.zzd++;
                i >>>= 7;
            }
            byte[] bArr4 = this.zza;
            int i6 = this.zzc;
            this.zzc = i6 + 1;
            bArr4[i6] = (byte) i;
            this.zzd++;
        }

        public final void zza(byte b4) {
            int i = this.zzc;
            this.zza[i] = b4;
            this.zzc = i + 1;
            this.zzd++;
        }

        public final void zza(int i) {
            int i3 = this.zzc;
            byte[] bArr = this.zza;
            bArr[i3] = (byte) i;
            bArr[i3 + 1] = (byte) (i >> 8);
            bArr[i3 + 2] = (byte) (i >> 16);
            bArr[i3 + 3] = i >> 24;
            this.zzc = i3 + 4;
            this.zzd += 4;
        }

        public final void zzb(long j2) {
            if (zzakg.zzb) {
                long j3 = this.zzc;
                while ((j2 & (-128)) != 0) {
                    byte[] bArr = this.zza;
                    int i = this.zzc;
                    this.zzc = i + 1;
                    zzanp.zza(bArr, i, (byte) (((int) j2) | 128));
                    j2 >>>= 7;
                }
                byte[] bArr2 = this.zza;
                int i3 = this.zzc;
                this.zzc = i3 + 1;
                zzanp.zza(bArr2, i3, (byte) j2);
                this.zzd += (int) (this.zzc - j3);
                return;
            }
            while ((j2 & (-128)) != 0) {
                byte[] bArr3 = this.zza;
                int i4 = this.zzc;
                this.zzc = i4 + 1;
                bArr3[i4] = (byte) (((int) j2) | 128);
                this.zzd++;
                j2 >>>= 7;
            }
            byte[] bArr4 = this.zza;
            int i5 = this.zzc;
            this.zzc = i5 + 1;
            bArr4[i5] = (byte) j2;
            this.zzd++;
        }

        public final void zza(long j2) {
            int i = this.zzc;
            byte[] bArr = this.zza;
            bArr[i] = (byte) j2;
            bArr[i + 1] = (byte) (j2 >> 8);
            bArr[i + 2] = (byte) (j2 >> 16);
            bArr[i + 3] = (byte) (j2 >> 24);
            bArr[i + 4] = (byte) (j2 >> 32);
            bArr[i + 5] = (byte) (j2 >> 40);
            bArr[i + 6] = (byte) (j2 >> 48);
            bArr[i + 7] = (byte) (j2 >> 56);
            this.zzc = i + 8;
            this.zzd += 8;
        }

        public final void zza(int i, int i3) {
            zzb((i << 3) | i3);
        }
    }

    /* loaded from: classes.dex */
    public static class zzb extends IOException {
        public zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        private zzb(String str, Throwable th) {
            super(a.d("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str), th);
        }

        public zzb(int i, int i3, int i4, Throwable th) {
            this(i, i3, i4, th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private zzb(long r3, long r5, int r7, java.lang.Throwable r8) {
            /*
                r2 = this;
                java.util.Locale r0 = java.util.Locale.US
                java.lang.String r0 = "Pos: "
                java.lang.String r1 = ", limit: "
                java.lang.StringBuilder r3 = F0.AbstractC0008a.x(r0, r1, r3)
                r3.append(r5)
                java.lang.String r4 = ", len: "
                r3.append(r4)
                r3.append(r7)
                java.lang.String r3 = r3.toString()
                r2.<init>(r3, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzakg.zzb.<init>(long, long, int, java.lang.Throwable):void");
        }
    }

    /* loaded from: classes.dex */
    public static class zzc extends zzakg {
        private final byte[] zza;
        private final int zzb;
        private int zzc;

        public zzc(byte[] bArr, int i, int i3) {
            super();
            if (bArr != null) {
                if (((bArr.length - i3) | i3) >= 0) {
                    this.zza = bArr;
                    this.zzc = 0;
                    this.zzb = i3;
                    return;
                }
                Locale locale = Locale.US;
                throw new IllegalArgumentException(AbstractC0008a.k("Array range is invalid. Buffer.length=", bArr.length, i3, ", offset=0, length="));
            }
            throw new NullPointerException("buffer");
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final int zza() {
            return this.zzb - this.zzc;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(byte b4) {
            int i = this.zzc;
            try {
                int i3 = i + 1;
                try {
                    this.zza[i] = b4;
                    this.zzc = i3;
                } catch (IndexOutOfBoundsException e4) {
                    e = e4;
                    i = i3;
                    throw new zzb(i, this.zzb, 1, (Throwable) e);
                }
            } catch (IndexOutOfBoundsException e5) {
                e = e5;
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc() {
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzd(int i, zzajp zzajpVar) {
            zzk(1, 3);
            zzl(2, i);
            zzc(3, zzajpVar);
            zzk(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzf(int i, long j2) {
            zzk(i, 1);
            zzh(j2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(int i, int i3) {
            zzk(i, 5);
            zzk(i3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzi(int i, int i3) {
            zzk(i, 0);
            zzl(i3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzj(long j2) {
            int i;
            int i3;
            int i4 = this.zzc;
            if (zzakg.zzb && zza() >= 10) {
                while ((j2 & (-128)) != 0) {
                    zzanp.zza(this.zza, i4, (byte) (((int) j2) | 128));
                    j2 >>>= 7;
                    i4++;
                }
                i = i4 + 1;
                zzanp.zza(this.zza, i4, (byte) j2);
            } else {
                while ((j2 & (-128)) != 0) {
                    try {
                        i3 = i4 + 1;
                    } catch (IndexOutOfBoundsException e4) {
                        e = e4;
                    }
                    try {
                        this.zza[i4] = (byte) (((int) j2) | 128);
                        j2 >>>= 7;
                        i4 = i3;
                    } catch (IndexOutOfBoundsException e5) {
                        e = e5;
                        i4 = i3;
                        throw new zzb(i4, this.zzb, 1, (Throwable) e);
                    }
                }
                i = i4 + 1;
                try {
                    this.zza[i4] = (byte) j2;
                } catch (IndexOutOfBoundsException e6) {
                    e = e6;
                    i4 = i;
                    throw new zzb(i4, this.zzb, 1, (Throwable) e);
                }
            }
            this.zzc = i;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzk(int i) {
            int i3 = this.zzc;
            try {
                byte[] bArr = this.zza;
                bArr[i3] = (byte) i;
                bArr[i3 + 1] = (byte) (i >> 8);
                bArr[i3 + 2] = (byte) (i >> 16);
                bArr[i3 + 3] = i >> 24;
                this.zzc = i3 + 4;
            } catch (IndexOutOfBoundsException e4) {
                throw new zzb(i3, this.zzb, 4, (Throwable) e4);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzl(int i) {
            if (i >= 0) {
                zzn(i);
            } else {
                zzj(i);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzn(int i) {
            int i3;
            int i4 = this.zzc;
            while ((i & (-128)) != 0) {
                try {
                    i3 = i4 + 1;
                    try {
                        this.zza[i4] = (byte) (i | 128);
                        i >>>= 7;
                        i4 = i3;
                    } catch (IndexOutOfBoundsException e4) {
                        e = e4;
                        i4 = i3;
                        throw new zzb(i4, this.zzb, 1, (Throwable) e);
                    }
                } catch (IndexOutOfBoundsException e5) {
                    e = e5;
                    throw new zzb(i4, this.zzb, 1, (Throwable) e);
                }
            }
            i3 = i4 + 1;
            this.zza[i4] = (byte) i;
            this.zzc = i3;
        }

        private final void zzc(byte[] bArr, int i, int i3) {
            try {
                System.arraycopy(bArr, i, this.zza, this.zzc, i3);
                this.zzc += i3;
            } catch (IndexOutOfBoundsException e4) {
                throw new zzb(this.zzc, this.zzb, i3, (Throwable) e4);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajm
        public final void zza(byte[] bArr, int i, int i3) {
            zzc(bArr, i, i3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(long j2) {
            int i = this.zzc;
            try {
                byte[] bArr = this.zza;
                bArr[i] = (byte) j2;
                bArr[i + 1] = (byte) (j2 >> 8);
                bArr[i + 2] = (byte) (j2 >> 16);
                bArr[i + 3] = (byte) (j2 >> 24);
                bArr[i + 4] = (byte) (j2 >> 32);
                bArr[i + 5] = (byte) (j2 >> 40);
                bArr[i + 6] = (byte) (j2 >> 48);
                bArr[i + 7] = (byte) (j2 >> 56);
                this.zzc = i + 8;
            } catch (IndexOutOfBoundsException e4) {
                throw new zzb(i, this.zzb, 8, (Throwable) e4);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzl(int i, int i3) {
            zzk(i, 0);
            zzn(i3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(int i, boolean z3) {
            zzk(i, 0);
            zzb(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc(int i, zzajp zzajpVar) {
            zzk(i, 2);
            zzb(zzajpVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(byte[] bArr, int i, int i3) {
            zzn(i3);
            zzc(bArr, 0, i3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc(int i, zzamc zzamcVar, zzamv zzamvVar) {
            zzk(i, 2);
            zzn(((zzajf) zzamcVar).zza(zzamvVar));
            zzamvVar.zza((zzamv) zzamcVar, (zzaof) this.zze);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzk(int i, int i3) {
            zzn((i << 3) | i3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(zzajp zzajpVar) {
            zzn(zzajpVar.zzb());
            zzajpVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc(zzamc zzamcVar) {
            zzn(zzamcVar.zzl());
            zzamcVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(zzamc zzamcVar, zzamv zzamvVar) {
            zzn(((zzajf) zzamcVar).zza(zzamvVar));
            zzamvVar.zza((zzamv) zzamcVar, (zzaof) this.zze);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(int i, zzamc zzamcVar) {
            zzk(1, 3);
            zzl(2, i);
            zzk(3, 2);
            zzc(zzamcVar);
            zzk(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(int i, long j2) {
            zzk(i, 0);
            zzj(j2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(int i, String str) {
            zzk(i, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(String str) {
            int i = this.zzc;
            try {
                int zzj = zzakg.zzj(str.length() * 3);
                int zzj2 = zzakg.zzj(str.length());
                if (zzj2 == zzj) {
                    int i3 = i + zzj2;
                    this.zzc = i3;
                    int zza = zzant.zza(str, this.zza, i3, zza());
                    this.zzc = i;
                    zzn((zza - i) - zzj2);
                    this.zzc = zza;
                    return;
                }
                zzn(zzant.zza(str));
                this.zzc = zzant.zza(str, this.zza, this.zzc, zza());
            } catch (zzanx e4) {
                this.zzc = i;
                zza(str, e4);
            } catch (IndexOutOfBoundsException e5) {
                throw new zzb(e5);
            }
        }
    }

    public static int zza(double d2) {
        return 8;
    }

    public static int zzb(int i, int i3) {
        return zzg(i3) + zzj(i << 3);
    }

    public static int zzc(long j2) {
        return 8;
    }

    public static int zzd(int i) {
        return 4;
    }

    public static int zze(long j2) {
        return 8;
    }

    public static int zzf(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int zzg(int i) {
        return 4;
    }

    public static int zzh(int i) {
        return zzj(zza(i));
    }

    public static int zzi(int i) {
        return zzj(i << 3);
    }

    public static int zzj(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public abstract int zza();

    public abstract void zzb(byte b4);

    public abstract void zzb(int i, zzamc zzamcVar);

    public abstract void zzb(int i, String str);

    public abstract void zzb(int i, boolean z3);

    public abstract void zzb(zzajp zzajpVar);

    public abstract void zzb(zzamc zzamcVar, zzamv zzamvVar);

    public abstract void zzb(String str);

    public abstract void zzb(byte[] bArr, int i, int i3);

    public abstract void zzc();

    public abstract void zzc(int i, zzajp zzajpVar);

    public abstract void zzc(int i, zzamc zzamcVar, zzamv zzamvVar);

    public abstract void zzc(zzamc zzamcVar);

    public abstract void zzd(int i, zzajp zzajpVar);

    public abstract void zzf(int i, long j2);

    public abstract void zzh(int i, int i3);

    public abstract void zzh(int i, long j2);

    public abstract void zzh(long j2);

    public abstract void zzi(int i, int i3);

    public abstract void zzj(long j2);

    public abstract void zzk(int i);

    public abstract void zzk(int i, int i3);

    public abstract void zzl(int i);

    public abstract void zzl(int i, int i3);

    public final void zzm(int i) {
        zzn(zza(i));
    }

    public abstract void zzn(int i);

    /* loaded from: classes.dex */
    public static final class zzd extends zza {
        private final OutputStream zzf;

        public zzd(OutputStream outputStream, int i) {
            super(i);
            if (outputStream != null) {
                this.zzf = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private final void zze() {
            this.zzf.write(this.zza, 0, this.zzc);
            this.zzc = 0;
        }

        private final void zzo(int i) {
            if (this.zzb - this.zzc < i) {
                zze();
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajm
        public final void zza(byte[] bArr, int i, int i3) {
            zzc(bArr, i, i3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(byte b4) {
            if (this.zzc == this.zzb) {
                zze();
            }
            zza(b4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc() {
            if (this.zzc > 0) {
                zze();
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzd(int i, zzajp zzajpVar) {
            zzk(1, 3);
            zzl(2, i);
            zzc(3, zzajpVar);
            zzk(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzf(int i, long j2) {
            zzo(18);
            zza(i, 1);
            zza(j2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(int i, int i3) {
            zzo(14);
            zza(i, 5);
            zza(i3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzi(int i, int i3) {
            zzo(20);
            zza(i, 0);
            if (i3 >= 0) {
                zzb(i3);
            } else {
                zzb(i3);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzj(long j2) {
            zzo(10);
            zzb(j2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzk(int i) {
            zzo(4);
            zza(i);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzl(int i) {
            if (i >= 0) {
                zzn(i);
            } else {
                zzj(i);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzn(int i) {
            zzo(5);
            zzb(i);
        }

        private final void zzc(byte[] bArr, int i, int i3) {
            int i4 = this.zzb;
            int i5 = this.zzc;
            if (i4 - i5 >= i3) {
                System.arraycopy(bArr, i, this.zza, i5, i3);
                this.zzc += i3;
            } else {
                int i6 = i4 - i5;
                System.arraycopy(bArr, i, this.zza, i5, i6);
                int i7 = i + i6;
                i3 -= i6;
                this.zzc = this.zzb;
                this.zzd += i6;
                zze();
                if (i3 <= this.zzb) {
                    System.arraycopy(bArr, i7, this.zza, 0, i3);
                    this.zzc = i3;
                } else {
                    this.zzf.write(bArr, i7, i3);
                }
            }
            this.zzd += i3;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzk(int i, int i3) {
            zzn((i << 3) | i3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzl(int i, int i3) {
            zzo(20);
            zza(i, 0);
            zzb(i3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(int i, boolean z3) {
            zzo(11);
            zza(i, 0);
            zza(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(long j2) {
            zzo(8);
            zza(j2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(int i, long j2) {
            zzo(20);
            zza(i, 0);
            zzb(j2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(byte[] bArr, int i, int i3) {
            zzn(i3);
            zzc(bArr, 0, i3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(zzajp zzajpVar) {
            zzn(zzajpVar.zzb());
            zzajpVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(zzamc zzamcVar, zzamv zzamvVar) {
            zzn(((zzajf) zzamcVar).zza(zzamvVar));
            zzamvVar.zza((zzamv) zzamcVar, (zzaof) this.zze);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(int i, zzamc zzamcVar) {
            zzk(1, 3);
            zzl(2, i);
            zzk(3, 2);
            zzc(zzamcVar);
            zzk(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc(int i, zzajp zzajpVar) {
            zzk(i, 2);
            zzb(zzajpVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc(int i, zzamc zzamcVar, zzamv zzamvVar) {
            zzk(i, 2);
            zzb(zzamcVar, zzamvVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(int i, String str) {
            zzk(i, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc(zzamc zzamcVar) {
            zzn(zzamcVar.zzl());
            zzamcVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(String str) {
            int zza;
            try {
                int length = str.length() * 3;
                int zzj = zzakg.zzj(length);
                int i = zzj + length;
                int i3 = this.zzb;
                if (i > i3) {
                    byte[] bArr = new byte[length];
                    int zza2 = zzant.zza(str, bArr, 0, length);
                    zzn(zza2);
                    zza(bArr, 0, zza2);
                    return;
                }
                if (i > i3 - this.zzc) {
                    zze();
                }
                int zzj2 = zzakg.zzj(str.length());
                int i4 = this.zzc;
                try {
                    if (zzj2 == zzj) {
                        int i5 = i4 + zzj2;
                        this.zzc = i5;
                        int zza3 = zzant.zza(str, this.zza, i5, this.zzb - i5);
                        this.zzc = i4;
                        zza = (zza3 - i4) - zzj2;
                        zzb(zza);
                        this.zzc = zza3;
                    } else {
                        zza = zzant.zza(str);
                        zzb(zza);
                        this.zzc = zzant.zza(str, this.zza, this.zzc, zza);
                    }
                    this.zzd += zza;
                } catch (zzanx e4) {
                    this.zzd -= this.zzc - i4;
                    this.zzc = i4;
                    throw e4;
                } catch (ArrayIndexOutOfBoundsException e5) {
                    throw new zzb(e5);
                }
            } catch (zzanx e6) {
                zza(str, e6);
            }
        }
    }

    private zzakg() {
    }

    public static int zza(float f4) {
        return 4;
    }

    public static int zzc(int i) {
        return zzg(i);
    }

    public static int zze(int i) {
        return zzg(i);
    }

    public static int zzf(int i, int i3) {
        return zzj(zza(i3)) + zzj(i << 3);
    }

    public static int zzg(int i, int i3) {
        return zzj(i3) + zzj(i << 3);
    }

    public final void zzi(long j2) {
        zzj(zza(j2));
    }

    public final void zzj(int i, int i3) {
        zzl(i, zza(i3));
    }

    private static int zza(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int zzb(int i, long j2) {
        return zzg(j2) + zzj(i << 3);
    }

    public static int zzc(int i, int i3) {
        return zzj(i << 3) + 4;
    }

    public static int zzd(int i, int i3) {
        return zzg(i3) + zzj(i << 3);
    }

    public static int zze(int i, int i3) {
        return zzj(i << 3) + 4;
    }

    public static int zza(boolean z3) {
        return 1;
    }

    public static int zzc(int i, long j2) {
        return zzj(i << 3) + 8;
    }

    public static int zze(int i, long j2) {
        return zzg(j2) + zzj(i << 3);
    }

    public static int zzf(long j2) {
        return zzg(zza(j2));
    }

    public static int zzg(long j2) {
        return (640 - (Long.numberOfLeadingZeros(j2) * 9)) >>> 6;
    }

    private static long zza(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    public static int zzb(int i, zzalk zzalkVar) {
        int zzj = zzj(i << 3);
        int zza2 = zzalkVar.zza();
        return zzj(zza2) + zza2 + zzj;
    }

    public static int zzd(long j2) {
        return zzg(j2);
    }

    public final void zzg(int i, long j2) {
        zzh(i, zza(j2));
    }

    public static int zza(int i, boolean z3) {
        return zzj(i << 3) + 1;
    }

    public static int zzd(int i, long j2) {
        return zzg(zza(j2)) + zzj(i << 3);
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzj(length) + length;
    }

    public static int zzb(int i, zzamc zzamcVar, zzamv zzamvVar) {
        return zza(zzamcVar, zzamvVar) + zzj(i << 3);
    }

    public static int zza(int i, zzajp zzajpVar) {
        int zzj = zzj(i << 3);
        int zzb2 = zzajpVar.zzb();
        return zzj(zzb2) + zzb2 + zzj;
    }

    public static int zzb(zzamc zzamcVar) {
        int zzl = zzamcVar.zzl();
        return zzj(zzl) + zzl;
    }

    public static int zza(zzajp zzajpVar) {
        int zzb2 = zzajpVar.zzb();
        return zzj(zzb2) + zzb2;
    }

    public static int zzb(int i, zzajp zzajpVar) {
        return zza(3, zzajpVar) + zzg(2, i) + (zzj(8) << 1);
    }

    public static int zza(int i, double d2) {
        return zzj(i << 3) + 8;
    }

    public static int zza(int i, long j2) {
        return zzj(i << 3) + 8;
    }

    public static zzakg zzb(byte[] bArr) {
        return new zzc(bArr, 0, bArr.length);
    }

    public static int zza(int i, float f4) {
        return zzj(i << 3) + 4;
    }

    @Deprecated
    public static int zza(int i, zzamc zzamcVar, zzamv zzamvVar) {
        return ((zzajf) zzamcVar).zza(zzamvVar) + (zzj(i << 3) << 1);
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    @Deprecated
    public static int zza(zzamc zzamcVar) {
        return zzamcVar.zzl();
    }

    public final void zzb(boolean z3) {
        zzb(z3 ? (byte) 1 : (byte) 0);
    }

    public static int zza(int i, zzalk zzalkVar) {
        return zzb(3, zzalkVar) + zzg(2, i) + (zzj(8) << 1);
    }

    public final void zzb(int i, double d2) {
        zzf(i, Double.doubleToRawLongBits(d2));
    }

    public final void zzb(double d2) {
        zzh(Double.doubleToRawLongBits(d2));
    }

    public final void zzb(int i, float f4) {
        zzh(i, Float.floatToRawIntBits(f4));
    }

    public static int zza(zzalk zzalkVar) {
        int zza2 = zzalkVar.zza();
        return zzj(zza2) + zza2;
    }

    public final void zzb(float f4) {
        zzk(Float.floatToRawIntBits(f4));
    }

    public static int zza(int i, zzamc zzamcVar) {
        return zzb(zzamcVar) + zzj(24) + zzg(2, i) + (zzj(8) << 1);
    }

    public static int zza(zzamc zzamcVar, zzamv zzamvVar) {
        int zza2 = ((zzajf) zzamcVar).zza(zzamvVar);
        return zzj(zza2) + zza2;
    }

    public static int zza(int i, String str) {
        return zza(str) + zzj(i << 3);
    }

    public static int zza(String str) {
        int length;
        try {
            length = zzant.zza(str);
        } catch (zzanx unused) {
            length = str.getBytes(zzalb.zza).length;
        }
        return zzj(length) + length;
    }

    public static zzakg zza(OutputStream outputStream, int i) {
        return new zzd(outputStream, i);
    }

    public final void zza(String str, zzanx zzanxVar) {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzanxVar);
        byte[] bytes = str.getBytes(zzalb.zza);
        try {
            zzn(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzb(e4);
        }
    }
}
