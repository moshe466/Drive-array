package com.google.android.recaptcha.internal;

import F0.AbstractC0008a;
import com.google.android.gms.common.api.Api;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.tika.fork.ForkServer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlg extends zzli {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    public /* synthetic */ zzlg(InputStream inputStream, int i, zzlh zzlhVar) {
        super(null);
        this.zzl = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        byte[] bArr = zznl.zzb;
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final List zzJ(int i) {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i3 = 0;
            while (i3 < min) {
                int read = this.zze.read(bArr, i3, min - i3);
                if (read != -1) {
                    this.zzk += read;
                    i3 += read;
                } else {
                    throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzK() {
        int i = this.zzg + this.zzh;
        this.zzg = i;
        int i3 = this.zzk + i;
        int i4 = this.zzl;
        if (i3 <= i4) {
            this.zzh = 0;
            return;
        }
        int i5 = i3 - i4;
        this.zzh = i5;
        this.zzg = i - i5;
    }

    private final void zzL(int i) {
        if (!zzM(i)) {
            if (i > (Api.BaseClientBuilder.API_PRIORITY_OTHER - this.zzk) - this.zzi) {
                throw new zznn("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private final boolean zzM(int i) {
        int i3 = this.zzi;
        int i4 = i3 + i;
        int i5 = this.zzg;
        if (i4 > i5) {
            int i6 = this.zzk;
            if (i > (Api.BaseClientBuilder.API_PRIORITY_OTHER - i6) - i3 || i6 + i3 + i > this.zzl) {
                return false;
            }
            if (i3 > 0) {
                if (i5 > i3) {
                    byte[] bArr = this.zzf;
                    System.arraycopy(bArr, i3, bArr, 0, i5 - i3);
                }
                i6 = this.zzk + i3;
                this.zzk = i6;
                i5 = this.zzg - i3;
                this.zzg = i5;
                this.zzi = 0;
            }
            try {
                int read = this.zze.read(this.zzf, i5, Math.min(4096 - i5, (Api.BaseClientBuilder.API_PRIORITY_OTHER - i6) - i5));
                if (read != 0 && read >= -1 && read <= 4096) {
                    if (read <= 0) {
                        return false;
                    }
                    this.zzg += read;
                    zzK();
                    if (this.zzg >= i) {
                        return true;
                    }
                    return zzM(i);
                }
                throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
            } catch (zznn e4) {
                e4.zza();
                throw e4;
            }
        }
        throw new IllegalStateException(AbstractC0008a.j(i, "refillBuffer() called when ", " bytes were already available in buffer"));
    }

    private final byte[] zzN(int i, boolean z3) {
        byte[] zzO = zzO(i);
        if (zzO != null) {
            return zzO;
        }
        int i3 = this.zzi;
        int i4 = this.zzg;
        int i5 = i4 - i3;
        this.zzk += i4;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> zzJ = zzJ(i - i5);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, i3, bArr, 0, i5);
        for (byte[] bArr2 : zzJ) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i5, length);
            i5 += length;
        }
        return bArr;
    }

    private final byte[] zzO(int i) {
        if (i == 0) {
            return zznl.zzb;
        }
        int i3 = this.zzk;
        int i4 = this.zzi;
        int i5 = i3 + i4 + i;
        if ((-2147483647) + i5 <= 0) {
            int i6 = this.zzl;
            if (i5 <= i6) {
                int i7 = this.zzg - i4;
                int i8 = i - i7;
                if (i8 >= 4096) {
                    try {
                        if (i8 > this.zze.available()) {
                            return null;
                        }
                    } catch (zznn e4) {
                        e4.zza();
                        throw e4;
                    }
                }
                byte[] bArr = new byte[i];
                System.arraycopy(this.zzf, this.zzi, bArr, 0, i7);
                this.zzk += this.zzg;
                this.zzi = 0;
                this.zzg = 0;
                while (i7 < i) {
                    try {
                        int read = this.zze.read(bArr, i7, i - i7);
                        if (read != -1) {
                            this.zzk += read;
                            i7 += read;
                        } else {
                            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                        }
                    } catch (zznn e5) {
                        e5.zza();
                        throw e5;
                    }
                }
                return bArr;
            }
            zzB((i6 - i3) - i4);
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zznn("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final void zzA(int i) {
        this.zzl = i;
        zzK();
    }

    public final void zzB(int i) {
        int i3 = this.zzg;
        int i4 = this.zzi;
        int i5 = i3 - i4;
        if (i <= i5 && i >= 0) {
            this.zzi = i4 + i;
            return;
        }
        if (i >= 0) {
            int i6 = this.zzk;
            int i7 = i6 + i4;
            int i8 = this.zzl;
            if (i7 + i <= i8) {
                this.zzk = i7;
                this.zzg = 0;
                this.zzi = 0;
                while (i5 < i) {
                    try {
                        long j2 = i - i5;
                        try {
                            long skip = this.zze.skip(j2);
                            if (skip >= 0 && skip <= j2) {
                                if (skip == 0) {
                                    break;
                                } else {
                                    i5 += (int) skip;
                                }
                            } else {
                                throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                            }
                        } catch (zznn e4) {
                            e4.zza();
                            throw e4;
                        }
                    } catch (Throwable th) {
                        this.zzk += i5;
                        zzK();
                        throw th;
                    }
                }
                this.zzk += i5;
                zzK();
                if (i5 < i) {
                    int i9 = this.zzg;
                    int i10 = i9 - this.zzi;
                    this.zzi = i9;
                    zzL(1);
                    while (true) {
                        int i11 = i - i10;
                        int i12 = this.zzg;
                        if (i11 > i12) {
                            i10 += i12;
                            this.zzi = i12;
                            zzL(1);
                        } else {
                            this.zzi = i11;
                            return;
                        }
                    }
                }
            } else {
                zzB((i8 - i6) - i4);
                throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
        } else {
            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final boolean zzC() {
        if (this.zzi == this.zzg && !zzM(1)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final boolean zzD() {
        if (zzr() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final boolean zzE(int i) {
        int i3 = i & 7;
        int i4 = 0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            return false;
                        }
                        if (i3 == 5) {
                            zzB(4);
                            return true;
                        }
                        throw new zznm("Protocol message tag had invalid wire type.");
                    }
                    zzI();
                    zzz(((i >>> 3) << 3) | 4);
                    return true;
                }
                zzB(zzj());
                return true;
            }
            zzB(8);
            return true;
        }
        if (this.zzg - this.zzi >= 10) {
            while (i4 < 10) {
                byte[] bArr = this.zzf;
                int i5 = this.zzi;
                this.zzi = i5 + 1;
                if (bArr[i5] < 0) {
                    i4++;
                }
            }
            throw new zznn("CodedInputStream encountered a malformed varint.");
        }
        while (i4 < 10) {
            if (zza() < 0) {
                i4++;
            }
        }
        throw new zznn("CodedInputStream encountered a malformed varint.");
        return true;
    }

    public final byte zza() {
        if (this.zzi == this.zzg) {
            zzL(1);
        }
        byte[] bArr = this.zzf;
        int i = this.zzi;
        this.zzi = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final double zzb() {
        return Double.longBitsToDouble(zzq());
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final float zzc() {
        return Float.intBitsToFloat(zzi());
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zzd() {
        return this.zzk + this.zzi;
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zze(int i) {
        if (i >= 0) {
            int i3 = this.zzk + this.zzi + i;
            if (i3 >= 0) {
                int i4 = this.zzl;
                if (i3 <= i4) {
                    this.zzl = i3;
                    zzK();
                    return i4;
                }
                throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            throw new zznn("Failed to parse the message.");
        }
        throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zzf() {
        return zzj();
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zzg() {
        return zzi();
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zzh() {
        return zzj();
    }

    public final int zzi() {
        int i = this.zzi;
        if (this.zzg - i < 4) {
            zzL(4);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 4;
        int i3 = bArr[i] & ForkServer.ERROR;
        int i4 = bArr[i + 1] & ForkServer.ERROR;
        int i5 = bArr[i + 2] & ForkServer.ERROR;
        return ((bArr[i + 3] & ForkServer.ERROR) << 24) | (i4 << 8) | i3 | (i5 << 16);
    }

    public final int zzj() {
        int i;
        int i3 = this.zzi;
        int i4 = this.zzg;
        if (i4 != i3) {
            byte[] bArr = this.zzf;
            int i5 = i3 + 1;
            byte b4 = bArr[i3];
            if (b4 >= 0) {
                this.zzi = i5;
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
                this.zzi = i6;
                return i;
            }
        }
        return (int) zzs();
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zzk() {
        return zzi();
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zzl() {
        return zzli.zzF(zzj());
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zzm() {
        if (zzC()) {
            this.zzj = 0;
            return 0;
        }
        int zzj = zzj();
        this.zzj = zzj;
        if ((zzj >>> 3) != 0) {
            return zzj;
        }
        throw new zznn("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zzn() {
        return zzj();
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final long zzo() {
        return zzq();
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final long zzp() {
        return zzr();
    }

    public final long zzq() {
        int i = this.zzi;
        if (this.zzg - i < 8) {
            zzL(8);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 8;
        long j2 = bArr[i];
        long j3 = bArr[i + 2];
        long j4 = bArr[i + 3];
        return ((bArr[i + 6] & 255) << 48) | (j2 & 255) | ((bArr[i + 1] & 255) << 8) | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 7] & 255) << 56);
    }

    public final long zzr() {
        long j2;
        long j3;
        int i = this.zzi;
        int i3 = this.zzg;
        if (i3 != i) {
            byte[] bArr = this.zzf;
            int i4 = i + 1;
            byte b4 = bArr[i];
            if (b4 >= 0) {
                this.zzi = i4;
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
                    } else {
                        int i9 = i + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            long j4 = (-2080896) ^ i10;
                            i5 = i9;
                            j2 = j4;
                        } else {
                            i7 = i + 5;
                            long j5 = (bArr[i9] << 28) ^ i10;
                            if (j5 >= 0) {
                                j2 = j5 ^ 266354560;
                            } else {
                                i5 = i + 6;
                                long j6 = (bArr[i7] << 35) ^ j5;
                                if (j6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    int i11 = i + 7;
                                    long j7 = j6 ^ (bArr[i5] << 42);
                                    if (j7 >= 0) {
                                        j2 = j7 ^ 4363953127296L;
                                    } else {
                                        i5 = i + 8;
                                        j6 = j7 ^ (bArr[i11] << 49);
                                        if (j6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i11 = i + 9;
                                            long j8 = (j6 ^ (bArr[i5] << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                i5 = i + 10;
                                                if (bArr[i11] >= 0) {
                                                    j2 = j8;
                                                }
                                            } else {
                                                j2 = j8;
                                            }
                                        }
                                    }
                                    i5 = i11;
                                }
                                j2 = j6 ^ j3;
                            }
                        }
                    }
                    i5 = i7;
                }
                this.zzi = i5;
                return j2;
            }
        }
        return zzs();
    }

    public final long zzs() {
        long j2 = 0;
        for (int i = 0; i < 64; i += 7) {
            j2 |= (r3 & Byte.MAX_VALUE) << i;
            if ((zza() & 128) == 0) {
                return j2;
            }
        }
        throw new zznn("CodedInputStream encountered a malformed varint.");
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final long zzt() {
        return zzq();
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final long zzu() {
        return zzli.zzG(zzr());
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final long zzv() {
        return zzr();
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final zzle zzw() {
        int zzj = zzj();
        int i = this.zzg;
        int i3 = this.zzi;
        if (zzj <= i - i3 && zzj > 0) {
            zzle zzk = zzle.zzk(this.zzf, i3, zzj);
            this.zzi += zzj;
            return zzk;
        }
        if (zzj == 0) {
            return zzle.zzb;
        }
        if (zzj >= 0) {
            byte[] zzO = zzO(zzj);
            if (zzO != null) {
                return zzle.zzk(zzO, 0, zzO.length);
            }
            int i4 = this.zzi;
            int i5 = this.zzg;
            int i6 = i5 - i4;
            this.zzk += i5;
            this.zzi = 0;
            this.zzg = 0;
            List<byte[]> zzJ = zzJ(zzj - i6);
            byte[] bArr = new byte[zzj];
            System.arraycopy(this.zzf, i4, bArr, 0, i6);
            for (byte[] bArr2 : zzJ) {
                int length = bArr2.length;
                System.arraycopy(bArr2, 0, bArr, i6, length);
                i6 += length;
            }
            return new zzlc(bArr);
        }
        throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final String zzx() {
        int zzj = zzj();
        if (zzj > 0) {
            int i = this.zzg;
            int i3 = this.zzi;
            if (zzj <= i - i3) {
                String str = new String(this.zzf, i3, zzj, zznl.zza);
                this.zzi += zzj;
                return str;
            }
        }
        if (zzj == 0) {
            return "";
        }
        if (zzj >= 0) {
            if (zzj <= this.zzg) {
                zzL(zzj);
                String str2 = new String(this.zzf, this.zzi, zzj, zznl.zza);
                this.zzi += zzj;
                return str2;
            }
            return new String(zzN(zzj, false), zznl.zza);
        }
        throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final String zzy() {
        byte[] zzN;
        int zzj = zzj();
        int i = this.zzi;
        int i3 = this.zzg;
        if (zzj <= i3 - i && zzj > 0) {
            zzN = this.zzf;
            this.zzi = i + zzj;
        } else {
            if (zzj == 0) {
                return "";
            }
            if (zzj >= 0) {
                i = 0;
                if (zzj <= i3) {
                    zzL(zzj);
                    zzN = this.zzf;
                    this.zzi = zzj;
                } else {
                    zzN = zzN(zzj, false);
                }
            } else {
                throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
        }
        return zzpv.zzd(zzN, i, zzj);
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final void zzz(int i) {
        if (this.zzj == i) {
        } else {
            throw new zznn("Protocol message end-group tag did not match expected tag.");
        }
    }
}
