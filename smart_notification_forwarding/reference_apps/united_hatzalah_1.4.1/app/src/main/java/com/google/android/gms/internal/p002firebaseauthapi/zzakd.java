package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import com.google.android.gms.common.api.Api;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.tika.fork.ForkServer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzakd extends zzakb {
    private final InputStream zzd;
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    private final int zzaa() {
        int i;
        int i3 = this.zzh;
        int i4 = this.zzf;
        if (i4 != i3) {
            byte[] bArr = this.zze;
            int i5 = i3 + 1;
            byte b4 = bArr[i3];
            if (b4 >= 0) {
                this.zzh = i5;
                return b4;
            }
            if (i4 - i5 >= 9) {
                int i6 = i3 + 2;
                int i7 = (bArr[i5] << 7) ^ b4;
                if (i7 < 0) {
                    i = i7 ^ (-128);
                } else {
                    int i8 = i3 + 3;
                    int i9 = (bArr[i6] << 14) ^ i7;
                    if (i9 >= 0) {
                        i = i9 ^ 16256;
                    } else {
                        int i10 = i3 + 4;
                        int i11 = i9 ^ (bArr[i8] << 21);
                        if (i11 < 0) {
                            i = (-2080896) ^ i11;
                        } else {
                            i8 = i3 + 5;
                            byte b5 = bArr[i10];
                            int i12 = (i11 ^ (b5 << 28)) ^ 266354560;
                            if (b5 < 0) {
                                i10 = i3 + 6;
                                if (bArr[i8] < 0) {
                                    i8 = i3 + 7;
                                    if (bArr[i10] < 0) {
                                        i10 = i3 + 8;
                                        if (bArr[i8] < 0) {
                                            i8 = i3 + 9;
                                            if (bArr[i10] < 0) {
                                                int i13 = i3 + 10;
                                                if (bArr[i8] >= 0) {
                                                    i6 = i13;
                                                    i = i12;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i12;
                            }
                            i = i12;
                        }
                        i6 = i10;
                    }
                    i6 = i8;
                }
                this.zzh = i6;
                return i;
            }
        }
        return (int) zzm();
    }

    private final long zzab() {
        int i = this.zzh;
        if (this.zzf - i < 8) {
            zzg(8);
            i = this.zzh;
        }
        byte[] bArr = this.zze;
        this.zzh = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    private final long zzac() {
        long j2;
        long j3;
        long j4;
        int i = this.zzh;
        int i3 = this.zzf;
        if (i3 != i) {
            byte[] bArr = this.zze;
            int i4 = i + 1;
            byte b4 = bArr[i];
            if (b4 >= 0) {
                this.zzh = i4;
                return b4;
            }
            if (i3 - i4 >= 9) {
                int i5 = i + 2;
                int i6 = (bArr[i4] << 7) ^ b4;
                if (i6 < 0) {
                    j2 = i6 ^ (-128);
                } else {
                    int i7 = i + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        j2 = i8 ^ 16256;
                        i5 = i7;
                    } else {
                        int i9 = i + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            long j5 = (-2080896) ^ i10;
                            i5 = i9;
                            j2 = j5;
                        } else {
                            long j6 = i10;
                            i5 = i + 5;
                            long j7 = j6 ^ (bArr[i9] << 28);
                            if (j7 >= 0) {
                                j4 = 266354560;
                            } else {
                                int i11 = i + 6;
                                long j8 = j7 ^ (bArr[i5] << 35);
                                if (j8 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i5 = i + 7;
                                    j7 = j8 ^ (bArr[i11] << 42);
                                    if (j7 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i11 = i + 8;
                                        j8 = j7 ^ (bArr[i5] << 49);
                                        if (j8 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i5 = i + 9;
                                            long j9 = (j8 ^ (bArr[i11] << 56)) ^ 71499008037633920L;
                                            if (j9 < 0) {
                                                int i12 = i + 10;
                                                if (bArr[i5] >= 0) {
                                                    i5 = i12;
                                                }
                                            }
                                            j2 = j9;
                                        }
                                    }
                                }
                                j2 = j8 ^ j3;
                                i5 = i11;
                            }
                            j2 = j7 ^ j4;
                        }
                    }
                }
                this.zzh = i5;
                return j2;
            }
        }
        return zzm();
    }

    private final void zzad() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i3 = this.zzj + i;
        int i4 = this.zzk;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.zzg = i5;
            this.zzf = i - i5;
            return;
        }
        this.zzg = 0;
    }

    private final byte zzy() {
        if (this.zzh == this.zzf) {
            zzg(1);
        }
        byte[] bArr = this.zze;
        int i = this.zzh;
        this.zzh = i + 1;
        return bArr[i];
    }

    private final int zzz() {
        int i = this.zzh;
        if (this.zzf - i < 4) {
            zzg(4);
            i = this.zzh;
        }
        byte[] bArr = this.zze;
        this.zzh = i + 4;
        return ((bArr[i + 3] & ForkServer.ERROR) << 24) | (bArr[i] & ForkServer.ERROR) | ((bArr[i + 1] & ForkServer.ERROR) << 8) | ((bArr[i + 2] & ForkServer.ERROR) << 16);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final double zza() {
        return Double.longBitsToDouble(zzab());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final float zzb() {
        return Float.intBitsToFloat(zzz());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzc() {
        return this.zzj + this.zzh;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzd() {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zze() {
        return zzz();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzf() {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzg() {
        return zzz();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzh() {
        return zzakb.zze(zzaa());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzi() {
        if (zzt()) {
            this.zzi = 0;
            return 0;
        }
        int zzaa = zzaa();
        this.zzi = zzaa;
        if ((zzaa >>> 3) != 0) {
            return zzaa;
        }
        throw zzalf.zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzj() {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzk() {
        return zzab();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzl() {
        return zzac();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzm() {
        long j2 = 0;
        for (int i = 0; i < 64; i += 7) {
            j2 |= (r3 & Byte.MAX_VALUE) << i;
            if ((zzy() & 128) == 0) {
                return j2;
            }
        }
        throw zzalf.zze();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzn() {
        return zzab();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzo() {
        return zzakb.zza(zzac());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzp() {
        return zzac();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final zzajp zzq() {
        int zzaa = zzaa();
        int i = this.zzf;
        int i3 = this.zzh;
        if (zzaa <= i - i3 && zzaa > 0) {
            zzajp zza = zzajp.zza(this.zze, i3, zzaa);
            this.zzh += zzaa;
            return zza;
        }
        if (zzaa == 0) {
            return zzajp.zza;
        }
        if (zzaa >= 0) {
            byte[] zzj = zzj(zzaa);
            if (zzj != null) {
                return zzajp.zza(zzj);
            }
            int i4 = this.zzh;
            int i5 = this.zzf;
            int i6 = i5 - i4;
            this.zzj += i5;
            this.zzh = 0;
            this.zzf = 0;
            List<byte[]> zzf = zzf(zzaa - i6);
            byte[] bArr = new byte[zzaa];
            System.arraycopy(this.zze, i4, bArr, 0, i6);
            for (byte[] bArr2 : zzf) {
                System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
                i6 += bArr2.length;
            }
            return zzajp.zzb(bArr);
        }
        throw zzalf.zzf();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final String zzr() {
        int zzaa = zzaa();
        if (zzaa > 0) {
            int i = this.zzf;
            int i3 = this.zzh;
            if (zzaa <= i - i3) {
                String str = new String(this.zze, i3, zzaa, zzalb.zza);
                this.zzh += zzaa;
                return str;
            }
        }
        if (zzaa == 0) {
            return "";
        }
        if (zzaa >= 0) {
            if (zzaa <= this.zzf) {
                zzg(zzaa);
                String str2 = new String(this.zze, this.zzh, zzaa, zzalb.zza);
                this.zzh += zzaa;
                return str2;
            }
            return new String(zza(zzaa, false), zzalb.zza);
        }
        throw zzalf.zzf();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final String zzs() {
        byte[] zza;
        int zzaa = zzaa();
        int i = this.zzh;
        int i3 = this.zzf;
        if (zzaa <= i3 - i && zzaa > 0) {
            zza = this.zze;
            this.zzh = i + zzaa;
        } else {
            if (zzaa == 0) {
                return "";
            }
            if (zzaa >= 0) {
                i = 0;
                if (zzaa <= i3) {
                    zzg(zzaa);
                    zza = this.zze;
                    this.zzh = zzaa;
                } else {
                    zza = zza(zzaa, false);
                }
            } else {
                throw zzalf.zzf();
            }
        }
        return zzant.zzb(zza, i, zzaa);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final boolean zzt() {
        if (this.zzh == this.zzf && !zzi(1)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final boolean zzu() {
        if (zzac() != 0) {
            return true;
        }
        return false;
    }

    private zzakd(InputStream inputStream, int i) {
        super();
        this.zzk = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        zzalb.zza(inputStream, "input");
        this.zzd = inputStream;
        this.zze = new byte[4096];
        this.zzf = 0;
        this.zzh = 0;
        this.zzj = 0;
    }

    private static int zza(InputStream inputStream) {
        try {
            return inputStream.available();
        } catch (zzalf e4) {
            e4.zzk();
            throw e4;
        }
    }

    private final List<byte[]> zzf(int i) {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i3 = 0;
            while (i3 < min) {
                int read = this.zzd.read(bArr, i3, min - i3);
                if (read != -1) {
                    this.zzj += read;
                    i3 += read;
                } else {
                    throw zzalf.zzj();
                }
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzg(int i) {
        if (zzi(i)) {
            return;
        }
        if (i > (this.zzb - this.zzj) - this.zzh) {
            throw zzalf.zzi();
        }
        throw zzalf.zzj();
    }

    private final void zzh(int i) {
        int i3 = this.zzf;
        int i4 = this.zzh;
        if (i <= i3 - i4 && i >= 0) {
            this.zzh = i4 + i;
            return;
        }
        if (i >= 0) {
            int i5 = this.zzj;
            int i6 = i5 + i4 + i;
            int i7 = this.zzk;
            if (i6 <= i7) {
                this.zzj = i5 + i4;
                int i8 = i3 - i4;
                this.zzf = 0;
                this.zzh = 0;
                while (i8 < i) {
                    try {
                        long j2 = i - i8;
                        long zza = zza(this.zzd, j2);
                        if (zza >= 0 && zza <= j2) {
                            if (zza == 0) {
                                break;
                            } else {
                                i8 += (int) zza;
                            }
                        } else {
                            throw new IllegalStateException(String.valueOf(this.zzd.getClass()) + "#skip returned invalid result: " + zza + "\nThe InputStream implementation is buggy.");
                        }
                    } finally {
                        this.zzj += i8;
                        zzad();
                    }
                }
                if (i8 >= i) {
                    return;
                }
                int i9 = this.zzf;
                int i10 = i9 - this.zzh;
                this.zzh = i9;
                zzg(1);
                while (true) {
                    int i11 = i - i10;
                    int i12 = this.zzf;
                    if (i11 > i12) {
                        i10 += i12;
                        this.zzh = i12;
                        zzg(1);
                    } else {
                        this.zzh = i11;
                        return;
                    }
                }
            } else {
                zzh((i7 - i5) - i4);
                throw zzalf.zzj();
            }
        } else {
            throw zzalf.zzf();
        }
    }

    private final byte[] zzj(int i) {
        if (i == 0) {
            return zzalb.zzb;
        }
        if (i >= 0) {
            int i3 = this.zzj;
            int i4 = this.zzh;
            int i5 = i3 + i4 + i;
            if (i5 - this.zzb <= 0) {
                int i6 = this.zzk;
                if (i5 <= i6) {
                    int i7 = this.zzf - i4;
                    int i8 = i - i7;
                    if (i8 >= 4096 && i8 > zza(this.zzd)) {
                        return null;
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.zze, this.zzh, bArr, 0, i7);
                    this.zzj += this.zzf;
                    this.zzh = 0;
                    this.zzf = 0;
                    while (i7 < i) {
                        int zza = zza(this.zzd, bArr, i7, i - i7);
                        if (zza != -1) {
                            this.zzj += zza;
                            i7 += zza;
                        } else {
                            throw zzalf.zzj();
                        }
                    }
                    return bArr;
                }
                zzh((i6 - i3) - i4);
                throw zzalf.zzj();
            }
            throw zzalf.zzi();
        }
        throw zzalf.zzf();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final void zzb(int i) {
        if (this.zzi != i) {
            throw zzalf.zzb();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final void zzc(int i) {
        this.zzk = i;
        zzad();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final boolean zzd(int i) {
        int i3 = i & 7;
        int i4 = 0;
        if (i3 == 0) {
            if (this.zzf - this.zzh >= 10) {
                while (i4 < 10) {
                    byte[] bArr = this.zze;
                    int i5 = this.zzh;
                    this.zzh = i5 + 1;
                    if (bArr[i5] < 0) {
                        i4++;
                    }
                }
                throw zzalf.zze();
            }
            while (i4 < 10) {
                if (zzy() < 0) {
                    i4++;
                }
            }
            throw zzalf.zze();
            return true;
        }
        if (i3 == 1) {
            zzh(8);
            return true;
        }
        if (i3 == 2) {
            zzh(zzaa());
            return true;
        }
        if (i3 == 3) {
            zzx();
            zzb(((i >>> 3) << 3) | 4);
            return true;
        }
        if (i3 == 4) {
            zzw();
            return false;
        }
        if (i3 == 5) {
            zzh(4);
            return true;
        }
        throw zzalf.zza();
    }

    private final boolean zzi(int i) {
        do {
            int i3 = this.zzh;
            int i4 = i3 + i;
            int i5 = this.zzf;
            if (i4 > i5) {
                int i6 = this.zzb;
                int i7 = this.zzj;
                if (i > (i6 - i7) - i3 || i7 + i3 + i > this.zzk) {
                    return false;
                }
                if (i3 > 0) {
                    if (i5 > i3) {
                        byte[] bArr = this.zze;
                        System.arraycopy(bArr, i3, bArr, 0, i5 - i3);
                    }
                    this.zzj += i3;
                    this.zzf -= i3;
                    this.zzh = 0;
                }
                InputStream inputStream = this.zzd;
                byte[] bArr2 = this.zze;
                int i8 = this.zzf;
                int zza = zza(inputStream, bArr2, i8, Math.min(bArr2.length - i8, (this.zzb - this.zzj) - i8));
                if (zza == 0 || zza < -1 || zza > this.zze.length) {
                    throw new IllegalStateException(String.valueOf(this.zzd.getClass()) + "#read(byte[]) returned invalid result: " + zza + "\nThe InputStream implementation is buggy.");
                }
                if (zza <= 0) {
                    return false;
                }
                this.zzf += zza;
                zzad();
            } else {
                throw new IllegalStateException(AbstractC0008a.j(i, "refillBuffer() called when ", " bytes were already available in buffer"));
            }
        } while (this.zzf < i);
        return true;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zza(int i) {
        if (i >= 0) {
            int i3 = this.zzj + this.zzh + i;
            if (i3 >= 0) {
                int i4 = this.zzk;
                if (i3 <= i4) {
                    this.zzk = i3;
                    zzad();
                    return i4;
                }
                throw zzalf.zzj();
            }
            throw zzalf.zzi();
        }
        throw zzalf.zzf();
    }

    private static int zza(InputStream inputStream, byte[] bArr, int i, int i3) {
        try {
            return inputStream.read(bArr, i, i3);
        } catch (zzalf e4) {
            e4.zzk();
            throw e4;
        }
    }

    private static long zza(InputStream inputStream, long j2) {
        try {
            return inputStream.skip(j2);
        } catch (zzalf e4) {
            e4.zzk();
            throw e4;
        }
    }

    private final byte[] zza(int i, boolean z3) {
        byte[] zzj = zzj(i);
        if (zzj != null) {
            return zzj;
        }
        int i3 = this.zzh;
        int i4 = this.zzf;
        int i5 = i4 - i3;
        this.zzj += i4;
        this.zzh = 0;
        this.zzf = 0;
        List<byte[]> zzf = zzf(i - i5);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zze, i3, bArr, 0, i5);
        for (byte[] bArr2 : zzf) {
            System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
            i5 += bArr2.length;
        }
        return bArr;
    }
}
