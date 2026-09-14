package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;
import org.apache.tika.fork.ForkServer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzajl {
    private static volatile int zza = 100;

    public static double zza(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzd(bArr, i));
    }

    public static float zzb(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzc(bArr, i));
    }

    public static int zzc(byte[] bArr, int i) {
        return ((bArr[i + 3] & ForkServer.ERROR) << 24) | (bArr[i] & ForkServer.ERROR) | ((bArr[i + 1] & ForkServer.ERROR) << 8) | ((bArr[i + 2] & ForkServer.ERROR) << 16);
    }

    public static int zzd(byte[] bArr, int i, zzajk zzajkVar) {
        int i3 = i + 1;
        long j2 = bArr[i];
        if (j2 >= 0) {
            zzajkVar.zzb = j2;
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
        zzajkVar.zzb = j3;
        return i4;
    }

    public static int zza(byte[] bArr, int i, zzajk zzajkVar) {
        int zzc = zzc(bArr, i, zzajkVar);
        int i3 = zzajkVar.zza;
        if (i3 >= 0) {
            if (i3 > bArr.length - zzc) {
                throw zzalf.zzj();
            }
            if (i3 == 0) {
                zzajkVar.zzc = zzajp.zza;
                return zzc;
            }
            zzajkVar.zzc = zzajp.zza(bArr, zzc, i3);
            return zzc + i3;
        }
        throw zzalf.zzf();
    }

    public static int zzb(zzamv<?> zzamvVar, int i, byte[] bArr, int i3, int i4, zzalc<?> zzalcVar, zzajk zzajkVar) {
        int zza2 = zza(zzamvVar, bArr, i3, i4, zzajkVar);
        zzalcVar.add(zzajkVar.zzc);
        while (zza2 < i4) {
            int zzc = zzc(bArr, zza2, zzajkVar);
            if (i != zzajkVar.zza) {
                break;
            }
            zza2 = zza(zzamvVar, bArr, zzc, i4, zzajkVar);
            zzalcVar.add(zzajkVar.zzc);
        }
        return zza2;
    }

    public static int zzc(byte[] bArr, int i, zzajk zzajkVar) {
        int i3 = i + 1;
        byte b4 = bArr[i];
        if (b4 >= 0) {
            zzajkVar.zza = b4;
            return i3;
        }
        return zza(b4, bArr, i3, zzajkVar);
    }

    public static long zzd(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public static int zzb(byte[] bArr, int i, zzajk zzajkVar) {
        int zzc = zzc(bArr, i, zzajkVar);
        int i3 = zzajkVar.zza;
        if (i3 < 0) {
            throw zzalf.zzf();
        }
        if (i3 == 0) {
            zzajkVar.zzc = "";
            return zzc;
        }
        zzajkVar.zzc = zzant.zzb(bArr, zzc, i3);
        return zzc + i3;
    }

    public static int zza(int i, byte[] bArr, int i3, int i4, Object obj, zzamc zzamcVar, zzano<zzann, zzann> zzanoVar, zzajk zzajkVar) {
        if (zzajkVar.zzd.zza(zzamcVar, i >>> 3) == null) {
            return zza(i, bArr, i3, i4, zzamg.zzc(obj), zzajkVar);
        }
        zzaky.zzb zzbVar = (zzaky.zzb) obj;
        zzbVar.zza();
        zzakr<zzaky.zze> zzakrVar = zzbVar.zzc;
        throw new NoSuchMethodError();
    }

    private static <T> int zza(zzamv<T> zzamvVar, byte[] bArr, int i, int i3, int i4, zzajk zzajkVar) {
        T zza2 = zzamvVar.zza();
        int zza3 = zza(zza2, zzamvVar, bArr, i, i3, i4, zzajkVar);
        zzamvVar.zzd(zza2);
        zzajkVar.zzc = zza2;
        return zza3;
    }

    public static int zza(zzamv<?> zzamvVar, int i, byte[] bArr, int i3, int i4, zzalc<Object> zzalcVar, zzajk zzajkVar) {
        int i5 = (i & (-8)) | 4;
        int zza2 = zza(zzamvVar, bArr, i3, i4, i5, zzajkVar);
        zzalcVar.add(zzajkVar.zzc);
        while (zza2 < i4) {
            int zzc = zzc(bArr, zza2, zzajkVar);
            if (i != zzajkVar.zza) {
                break;
            }
            zza2 = zza(zzamvVar, bArr, zzc, i4, i5, zzajkVar);
            zzalcVar.add(zzajkVar.zzc);
        }
        return zza2;
    }

    public static <T> int zza(zzamv<T> zzamvVar, byte[] bArr, int i, int i3, zzajk zzajkVar) {
        T zza2 = zzamvVar.zza();
        int zza3 = zza(zza2, zzamvVar, bArr, i, i3, zzajkVar);
        zzamvVar.zzd(zza2);
        zzajkVar.zzc = zza2;
        return zza3;
    }

    public static int zza(byte[] bArr, int i, zzalc<?> zzalcVar, zzajk zzajkVar) {
        zzakz zzakzVar = (zzakz) zzalcVar;
        int zzc = zzc(bArr, i, zzajkVar);
        int i3 = zzajkVar.zza + zzc;
        while (zzc < i3) {
            zzc = zzc(bArr, zzc, zzajkVar);
            zzakzVar.zzc(zzajkVar.zza);
        }
        if (zzc == i3) {
            return zzc;
        }
        throw zzalf.zzj();
    }

    public static int zza(int i, byte[] bArr, int i3, int i4, zzann zzannVar, zzajk zzajkVar) {
        if ((i >>> 3) == 0) {
            throw zzalf.zzc();
        }
        int i5 = i & 7;
        if (i5 == 0) {
            int zzd = zzd(bArr, i3, zzajkVar);
            zzannVar.zza(i, Long.valueOf(zzajkVar.zzb));
            return zzd;
        }
        if (i5 == 1) {
            zzannVar.zza(i, Long.valueOf(zzd(bArr, i3)));
            return i3 + 8;
        }
        if (i5 == 2) {
            int zzc = zzc(bArr, i3, zzajkVar);
            int i6 = zzajkVar.zza;
            if (i6 >= 0) {
                if (i6 > bArr.length - zzc) {
                    throw zzalf.zzj();
                }
                if (i6 == 0) {
                    zzannVar.zza(i, zzajp.zza);
                } else {
                    zzannVar.zza(i, zzajp.zza(bArr, zzc, i6));
                }
                return zzc + i6;
            }
            throw zzalf.zzf();
        }
        if (i5 != 3) {
            if (i5 == 5) {
                zzannVar.zza(i, Integer.valueOf(zzc(bArr, i3)));
                return i3 + 4;
            }
            throw zzalf.zzc();
        }
        zzann zzd2 = zzann.zzd();
        int i7 = (i & (-8)) | 4;
        int i8 = zzajkVar.zze + 1;
        zzajkVar.zze = i8;
        zza(i8);
        int i9 = 0;
        while (true) {
            if (i3 >= i4) {
                break;
            }
            int zzc2 = zzc(bArr, i3, zzajkVar);
            i9 = zzajkVar.zza;
            if (i9 == i7) {
                i3 = zzc2;
                break;
            }
            i3 = zza(i9, bArr, zzc2, i4, zzd2, zzajkVar);
        }
        zzajkVar.zze--;
        if (i3 <= i4 && i9 == i7) {
            zzannVar.zza(i, zzd2);
            return i3;
        }
        throw zzalf.zzg();
    }

    public static int zza(int i, byte[] bArr, int i3, zzajk zzajkVar) {
        int i4 = i & 127;
        int i5 = i3 + 1;
        byte b4 = bArr[i3];
        if (b4 >= 0) {
            zzajkVar.zza = i4 | (b4 << 7);
            return i5;
        }
        int i6 = i4 | ((b4 & Byte.MAX_VALUE) << 7);
        int i7 = i3 + 2;
        byte b5 = bArr[i5];
        if (b5 >= 0) {
            zzajkVar.zza = i6 | (b5 << 14);
            return i7;
        }
        int i8 = i6 | ((b5 & Byte.MAX_VALUE) << 14);
        int i9 = i3 + 3;
        byte b6 = bArr[i7];
        if (b6 >= 0) {
            zzajkVar.zza = i8 | (b6 << 21);
            return i9;
        }
        int i10 = i8 | ((b6 & Byte.MAX_VALUE) << 21);
        int i11 = i3 + 4;
        byte b7 = bArr[i9];
        if (b7 >= 0) {
            zzajkVar.zza = i10 | (b7 << 28);
            return i11;
        }
        int i12 = i10 | ((b7 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                zzajkVar.zza = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    public static int zza(int i, byte[] bArr, int i3, int i4, zzalc<?> zzalcVar, zzajk zzajkVar) {
        zzakz zzakzVar = (zzakz) zzalcVar;
        int zzc = zzc(bArr, i3, zzajkVar);
        zzakzVar.zzc(zzajkVar.zza);
        while (zzc < i4) {
            int zzc2 = zzc(bArr, zzc, zzajkVar);
            if (i != zzajkVar.zza) {
                break;
            }
            zzc = zzc(bArr, zzc2, zzajkVar);
            zzakzVar.zzc(zzajkVar.zza);
        }
        return zzc;
    }

    public static <T> int zza(Object obj, zzamv<T> zzamvVar, byte[] bArr, int i, int i3, int i4, zzajk zzajkVar) {
        int i5 = zzajkVar.zze + 1;
        zzajkVar.zze = i5;
        zza(i5);
        int zza2 = ((zzamg) zzamvVar).zza((zzamg) obj, bArr, i, i3, i4, zzajkVar);
        zzajkVar.zze--;
        zzajkVar.zzc = obj;
        return zza2;
    }

    public static <T> int zza(Object obj, zzamv<T> zzamvVar, byte[] bArr, int i, int i3, zzajk zzajkVar) {
        int i4 = i + 1;
        int i5 = bArr[i];
        if (i5 < 0) {
            i4 = zza(i5, bArr, i4, zzajkVar);
            i5 = zzajkVar.zza;
        }
        int i6 = i4;
        if (i5 >= 0 && i5 <= i3 - i6) {
            int i7 = zzajkVar.zze + 1;
            zzajkVar.zze = i7;
            zza(i7);
            int i8 = i6 + i5;
            zzamvVar.zza(obj, bArr, i6, i8, zzajkVar);
            zzajkVar.zze--;
            zzajkVar.zzc = obj;
            return i8;
        }
        throw zzalf.zzj();
    }

    public static int zza(int i, byte[] bArr, int i3, int i4, zzajk zzajkVar) {
        if ((i >>> 3) == 0) {
            throw zzalf.zzc();
        }
        int i5 = i & 7;
        if (i5 == 0) {
            return zzd(bArr, i3, zzajkVar);
        }
        if (i5 == 1) {
            return i3 + 8;
        }
        if (i5 == 2) {
            return zzc(bArr, i3, zzajkVar) + zzajkVar.zza;
        }
        if (i5 != 3) {
            if (i5 == 5) {
                return i3 + 4;
            }
            throw zzalf.zzc();
        }
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (i3 < i4) {
            i3 = zzc(bArr, i3, zzajkVar);
            i7 = zzajkVar.zza;
            if (i7 == i6) {
                break;
            }
            i3 = zza(i7, bArr, i3, i4, zzajkVar);
        }
        if (i3 > i4 || i7 != i6) {
            throw zzalf.zzg();
        }
        return i3;
    }

    private static void zza(int i) {
        if (i >= zza) {
            throw zzalf.zzh();
        }
    }
}
