package com.google.android.recaptcha.internal;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;
import org.apache.tika.fork.ForkServer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlf extends zzli {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    public /* synthetic */ zzlf(byte[] bArr, int i, int i3, boolean z3, zzlh zzlhVar) {
        super(null);
        this.zzj = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zze = bArr;
        this.zzf = 0;
        this.zzh = 0;
    }

    private final void zzJ() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i3 = this.zzj;
        if (i <= i3) {
            this.zzg = 0;
            return;
        }
        int i4 = i - i3;
        this.zzg = i4;
        this.zzf = i - i4;
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final void zzA(int i) {
        this.zzj = i;
        zzJ();
    }

    public final void zzB(int i) {
        if (i >= 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (i <= i3 - i4) {
                this.zzh = i4 + i;
                return;
            }
        }
        if (i < 0) {
            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final boolean zzC() {
        return this.zzh == this.zzf;
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
        if (this.zzf - this.zzh >= 10) {
            while (i4 < 10) {
                byte[] bArr = this.zze;
                int i5 = this.zzh;
                this.zzh = i5 + 1;
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
        int i = this.zzh;
        if (i != this.zzf) {
            byte[] bArr = this.zze;
            this.zzh = i + 1;
            return bArr[i];
        }
        throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
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
        return this.zzh;
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final int zze(int i) {
        if (i >= 0) {
            int i3 = i + this.zzh;
            if (i3 >= 0) {
                int i4 = this.zzj;
                if (i3 <= i4) {
                    this.zzj = i3;
                    zzJ();
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
        int i = this.zzh;
        if (this.zzf - i >= 4) {
            byte[] bArr = this.zze;
            this.zzh = i + 4;
            int i3 = bArr[i] & ForkServer.ERROR;
            int i4 = bArr[i + 1] & ForkServer.ERROR;
            int i5 = bArr[i + 2] & ForkServer.ERROR;
            return ((bArr[i + 3] & ForkServer.ERROR) << 24) | (i4 << 8) | i3 | (i5 << 16);
        }
        throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final int zzj() {
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
            this.zzi = 0;
            return 0;
        }
        int zzj = zzj();
        this.zzi = zzj;
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
        int i = this.zzh;
        if (this.zzf - i >= 8) {
            byte[] bArr = this.zze;
            this.zzh = i + 8;
            long j2 = bArr[i];
            long j3 = bArr[i + 2];
            long j4 = bArr[i + 3];
            return ((bArr[i + 6] & 255) << 48) | (j2 & 255) | ((bArr[i + 1] & 255) << 8) | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 7] & 255) << 56);
        }
        throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final long zzr() {
        long j2;
        long j3;
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
                this.zzh = i5;
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
        if (zzj > 0) {
            int i = this.zzf;
            int i3 = this.zzh;
            if (zzj <= i - i3) {
                zzle zzk = zzle.zzk(this.zze, i3, zzj);
                this.zzh += zzj;
                return zzk;
            }
        }
        if (zzj != 0) {
            if (zzj > 0) {
                int i4 = this.zzf;
                int i5 = this.zzh;
                if (zzj <= i4 - i5) {
                    int i6 = zzj + i5;
                    this.zzh = i6;
                    return new zzlc(Arrays.copyOfRange(this.zze, i5, i6));
                }
            }
            if (zzj <= 0) {
                throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        return zzle.zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final String zzx() {
        int zzj = zzj();
        if (zzj > 0) {
            int i = this.zzf;
            int i3 = this.zzh;
            if (zzj <= i - i3) {
                String str = new String(this.zze, i3, zzj, zznl.zza);
                this.zzh += zzj;
                return str;
            }
        }
        if (zzj == 0) {
            return "";
        }
        if (zzj < 0) {
            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final String zzy() {
        int zzj = zzj();
        if (zzj > 0) {
            int i = this.zzf;
            int i3 = this.zzh;
            if (zzj <= i - i3) {
                String zzd = zzpv.zzd(this.zze, i3, zzj);
                this.zzh += zzj;
                return zzd;
            }
        }
        if (zzj == 0) {
            return "";
        }
        if (zzj <= 0) {
            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.recaptcha.internal.zzli
    public final void zzz(int i) {
        if (this.zzi == i) {
        } else {
            throw new zznn("Protocol message end-group tag did not match expected tag.");
        }
    }
}
