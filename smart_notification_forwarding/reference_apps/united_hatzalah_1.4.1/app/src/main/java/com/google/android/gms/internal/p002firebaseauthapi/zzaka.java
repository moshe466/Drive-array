package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;
import org.apache.tika.fork.ForkServer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaka extends zzakb {
    private final byte[] zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    private final int zzaa() {
        int i;
        int i3 = this.zzg;
        int i4 = this.zze;
        if (i4 != i3) {
            byte[] bArr = this.zzd;
            int i5 = i3 + 1;
            byte b4 = bArr[i3];
            if (b4 >= 0) {
                this.zzg = i5;
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
                this.zzg = i6;
                return i;
            }
        }
        return (int) zzm();
    }

    private final long zzab() {
        int i = this.zzg;
        if (this.zze - i >= 8) {
            byte[] bArr = this.zzd;
            this.zzg = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }
        throw zzalf.zzj();
    }

    private final long zzac() {
        long j2;
        long j3;
        long j4;
        int i = this.zzg;
        int i3 = this.zze;
        if (i3 != i) {
            byte[] bArr = this.zzd;
            int i4 = i + 1;
            byte b4 = bArr[i];
            if (b4 >= 0) {
                this.zzg = i4;
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
                this.zzg = i5;
                return j2;
            }
        }
        return zzm();
    }

    private final void zzad() {
        int i = this.zze + this.zzf;
        this.zze = i;
        int i3 = i - this.zzh;
        int i4 = this.zzj;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.zzf = i5;
            this.zze = i - i5;
            return;
        }
        this.zzf = 0;
    }

    private final byte zzy() {
        int i = this.zzg;
        if (i != this.zze) {
            byte[] bArr = this.zzd;
            this.zzg = i + 1;
            return bArr[i];
        }
        throw zzalf.zzj();
    }

    private final int zzz() {
        int i = this.zzg;
        if (this.zze - i >= 4) {
            byte[] bArr = this.zzd;
            this.zzg = i + 4;
            return ((bArr[i + 3] & ForkServer.ERROR) << 24) | (bArr[i] & ForkServer.ERROR) | ((bArr[i + 1] & ForkServer.ERROR) << 8) | ((bArr[i + 2] & ForkServer.ERROR) << 16);
        }
        throw zzalf.zzj();
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
        return this.zzg - this.zzh;
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
        byte[] bArr;
        int zzaa = zzaa();
        if (zzaa > 0) {
            int i = this.zze;
            int i3 = this.zzg;
            if (zzaa <= i - i3) {
                zzajp zza = zzajp.zza(this.zzd, i3, zzaa);
                this.zzg += zzaa;
                return zza;
            }
        }
        if (zzaa == 0) {
            return zzajp.zza;
        }
        if (zzaa > 0) {
            int i4 = this.zze;
            int i5 = this.zzg;
            if (zzaa <= i4 - i5) {
                int i6 = zzaa + i5;
                this.zzg = i6;
                bArr = Arrays.copyOfRange(this.zzd, i5, i6);
                return zzajp.zzb(bArr);
            }
        }
        if (zzaa <= 0) {
            if (zzaa == 0) {
                bArr = zzalb.zzb;
                return zzajp.zzb(bArr);
            }
            throw zzalf.zzf();
        }
        throw zzalf.zzj();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final String zzr() {
        int zzaa = zzaa();
        if (zzaa > 0) {
            int i = this.zze;
            int i3 = this.zzg;
            if (zzaa <= i - i3) {
                String str = new String(this.zzd, i3, zzaa, zzalb.zza);
                this.zzg += zzaa;
                return str;
            }
        }
        if (zzaa == 0) {
            return "";
        }
        if (zzaa < 0) {
            throw zzalf.zzf();
        }
        throw zzalf.zzj();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final String zzs() {
        int zzaa = zzaa();
        if (zzaa > 0) {
            int i = this.zze;
            int i3 = this.zzg;
            if (zzaa <= i - i3) {
                String zzb = zzant.zzb(this.zzd, i3, zzaa);
                this.zzg += zzaa;
                return zzb;
            }
        }
        if (zzaa == 0) {
            return "";
        }
        if (zzaa <= 0) {
            throw zzalf.zzf();
        }
        throw zzalf.zzj();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final boolean zzt() {
        if (this.zzg == this.zze) {
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

    private zzaka(byte[] bArr, int i, int i3, boolean z3) {
        super();
        this.zzj = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzd = bArr;
        this.zze = i3 + i;
        this.zzg = i;
        this.zzh = i;
    }

    private final void zzf(int i) {
        if (i >= 0) {
            int i3 = this.zze;
            int i4 = this.zzg;
            if (i <= i3 - i4) {
                this.zzg = i4 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzalf.zzf();
        }
        throw zzalf.zzj();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zza(int i) {
        if (i >= 0) {
            int zzc = i + zzc();
            if (zzc >= 0) {
                int i3 = this.zzj;
                if (zzc <= i3) {
                    this.zzj = zzc;
                    zzad();
                    return i3;
                }
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
        this.zzj = i;
        zzad();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final boolean zzd(int i) {
        int i3 = i & 7;
        int i4 = 0;
        if (i3 == 0) {
            if (this.zze - this.zzg >= 10) {
                while (i4 < 10) {
                    byte[] bArr = this.zzd;
                    int i5 = this.zzg;
                    this.zzg = i5 + 1;
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
            zzf(8);
            return true;
        }
        if (i3 == 2) {
            zzf(zzaa());
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
            zzf(4);
            return true;
        }
        throw zzalf.zza();
    }
}
