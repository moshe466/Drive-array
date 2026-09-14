package com.google.android.gms.internal.auth;

import org.apache.tika.fork.ForkServer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdt {
    public static int zza(byte[] bArr, int i, zzds zzdsVar) {
        int zzj = zzj(bArr, i, zzdsVar);
        int i3 = zzdsVar.zza;
        if (i3 >= 0) {
            if (i3 <= bArr.length - zzj) {
                if (i3 == 0) {
                    zzdsVar.zzc = zzee.zzb;
                    return zzj;
                }
                zzdsVar.zzc = zzee.zzk(bArr, zzj, i3);
                return zzj + i3;
            }
            throw zzfa.zzf();
        }
        throw zzfa.zzc();
    }

    public static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & ForkServer.ERROR) << 24) | (bArr[i] & ForkServer.ERROR) | ((bArr[i + 1] & ForkServer.ERROR) << 8) | ((bArr[i + 2] & ForkServer.ERROR) << 16);
    }

    public static int zzc(zzgh zzghVar, byte[] bArr, int i, int i3, int i4, zzds zzdsVar) {
        zzfz zzfzVar = (zzfz) zzghVar;
        Object zzd = zzfzVar.zzd();
        int zzb = zzfzVar.zzb(zzd, bArr, i, i3, i4, zzdsVar);
        zzfzVar.zze(zzd);
        zzdsVar.zzc = zzd;
        return zzb;
    }

    public static int zzd(zzgh zzghVar, byte[] bArr, int i, int i3, zzds zzdsVar) {
        int i4 = i + 1;
        int i5 = bArr[i];
        if (i5 < 0) {
            i4 = zzk(i5, bArr, i4, zzdsVar);
            i5 = zzdsVar.zza;
        }
        int i6 = i4;
        if (i5 >= 0 && i5 <= i3 - i6) {
            Object zzd = zzghVar.zzd();
            int i7 = i6 + i5;
            zzghVar.zzg(zzd, bArr, i6, i7, zzdsVar);
            zzghVar.zze(zzd);
            zzdsVar.zzc = zzd;
            return i7;
        }
        throw zzfa.zzf();
    }

    public static int zze(zzgh zzghVar, int i, byte[] bArr, int i3, int i4, zzey zzeyVar, zzds zzdsVar) {
        int zzd = zzd(zzghVar, bArr, i3, i4, zzdsVar);
        zzeyVar.add(zzdsVar.zzc);
        while (zzd < i4) {
            int zzj = zzj(bArr, zzd, zzdsVar);
            if (i != zzdsVar.zza) {
                break;
            }
            zzd = zzd(zzghVar, bArr, zzj, i4, zzdsVar);
            zzeyVar.add(zzdsVar.zzc);
        }
        return zzd;
    }

    public static int zzf(byte[] bArr, int i, zzey zzeyVar, zzds zzdsVar) {
        zzev zzevVar = (zzev) zzeyVar;
        int zzj = zzj(bArr, i, zzdsVar);
        int i3 = zzdsVar.zza + zzj;
        while (zzj < i3) {
            zzj = zzj(bArr, zzj, zzdsVar);
            zzevVar.zze(zzdsVar.zza);
        }
        if (zzj == i3) {
            return zzj;
        }
        throw zzfa.zzf();
    }

    public static int zzg(byte[] bArr, int i, zzds zzdsVar) {
        int zzj = zzj(bArr, i, zzdsVar);
        int i3 = zzdsVar.zza;
        if (i3 >= 0) {
            if (i3 == 0) {
                zzdsVar.zzc = "";
                return zzj;
            }
            zzdsVar.zzc = new String(bArr, zzj, i3, zzez.zzb);
            return zzj + i3;
        }
        throw zzfa.zzc();
    }

    public static int zzh(byte[] bArr, int i, zzds zzdsVar) {
        int zzj = zzj(bArr, i, zzdsVar);
        int i3 = zzdsVar.zza;
        if (i3 >= 0) {
            if (i3 == 0) {
                zzdsVar.zzc = "";
                return zzj;
            }
            zzdsVar.zzc = zzhm.zzb(bArr, zzj, i3);
            return zzj + i3;
        }
        throw zzfa.zzc();
    }

    public static int zzi(int i, byte[] bArr, int i3, int i4, zzgz zzgzVar, zzds zzdsVar) {
        if ((i >>> 3) != 0) {
            int i5 = i & 7;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 == 5) {
                                zzgzVar.zzf(i, Integer.valueOf(zzb(bArr, i3)));
                                return i3 + 4;
                            }
                            throw zzfa.zza();
                        }
                        int i6 = (i & (-8)) | 4;
                        zzgz zzc = zzgz.zzc();
                        int i7 = 0;
                        while (true) {
                            if (i3 >= i4) {
                                break;
                            }
                            int zzj = zzj(bArr, i3, zzdsVar);
                            i7 = zzdsVar.zza;
                            if (i7 == i6) {
                                i3 = zzj;
                                break;
                            }
                            i3 = zzi(i7, bArr, zzj, i4, zzc, zzdsVar);
                        }
                        if (i3 <= i4 && i7 == i6) {
                            zzgzVar.zzf(i, zzc);
                            return i3;
                        }
                        throw zzfa.zzd();
                    }
                    int zzj2 = zzj(bArr, i3, zzdsVar);
                    int i8 = zzdsVar.zza;
                    if (i8 >= 0) {
                        if (i8 <= bArr.length - zzj2) {
                            if (i8 == 0) {
                                zzgzVar.zzf(i, zzee.zzb);
                            } else {
                                zzgzVar.zzf(i, zzee.zzk(bArr, zzj2, i8));
                            }
                            return zzj2 + i8;
                        }
                        throw zzfa.zzf();
                    }
                    throw zzfa.zzc();
                }
                zzgzVar.zzf(i, Long.valueOf(zzn(bArr, i3)));
                return i3 + 8;
            }
            int zzm = zzm(bArr, i3, zzdsVar);
            zzgzVar.zzf(i, Long.valueOf(zzdsVar.zzb));
            return zzm;
        }
        throw zzfa.zza();
    }

    public static int zzj(byte[] bArr, int i, zzds zzdsVar) {
        int i3 = i + 1;
        byte b4 = bArr[i];
        if (b4 >= 0) {
            zzdsVar.zza = b4;
            return i3;
        }
        return zzk(b4, bArr, i3, zzdsVar);
    }

    public static int zzk(int i, byte[] bArr, int i3, zzds zzdsVar) {
        int i4 = i & 127;
        int i5 = i3 + 1;
        byte b4 = bArr[i3];
        if (b4 >= 0) {
            zzdsVar.zza = i4 | (b4 << 7);
            return i5;
        }
        int i6 = i4 | ((b4 & Byte.MAX_VALUE) << 7);
        int i7 = i3 + 2;
        byte b5 = bArr[i5];
        if (b5 >= 0) {
            zzdsVar.zza = i6 | (b5 << 14);
            return i7;
        }
        int i8 = i6 | ((b5 & Byte.MAX_VALUE) << 14);
        int i9 = i3 + 3;
        byte b6 = bArr[i7];
        if (b6 >= 0) {
            zzdsVar.zza = i8 | (b6 << 21);
            return i9;
        }
        int i10 = i8 | ((b6 & Byte.MAX_VALUE) << 21);
        int i11 = i3 + 4;
        byte b7 = bArr[i9];
        if (b7 >= 0) {
            zzdsVar.zza = i10 | (b7 << 28);
            return i11;
        }
        int i12 = i10 | ((b7 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] < 0) {
                i11 = i13;
            } else {
                zzdsVar.zza = i12;
                return i13;
            }
        }
    }

    public static int zzl(int i, byte[] bArr, int i3, int i4, zzey zzeyVar, zzds zzdsVar) {
        zzev zzevVar = (zzev) zzeyVar;
        int zzj = zzj(bArr, i3, zzdsVar);
        zzevVar.zze(zzdsVar.zza);
        while (zzj < i4) {
            int zzj2 = zzj(bArr, zzj, zzdsVar);
            if (i != zzdsVar.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzdsVar);
            zzevVar.zze(zzdsVar.zza);
        }
        return zzj;
    }

    public static int zzm(byte[] bArr, int i, zzds zzdsVar) {
        int i3 = i + 1;
        long j2 = bArr[i];
        if (j2 >= 0) {
            zzdsVar.zzb = j2;
            return i3;
        }
        int i4 = i + 2;
        byte b4 = bArr[i3];
        long j3 = (j2 & 127) | ((b4 & Byte.MAX_VALUE) << 7);
        int i5 = 7;
        while (b4 < 0) {
            int i6 = i4 + 1;
            i5 += 7;
            j3 |= (r10 & Byte.MAX_VALUE) << i5;
            b4 = bArr[i4];
            i4 = i6;
        }
        zzdsVar.zzb = j3;
        return i4;
    }

    public static long zzn(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }
}
