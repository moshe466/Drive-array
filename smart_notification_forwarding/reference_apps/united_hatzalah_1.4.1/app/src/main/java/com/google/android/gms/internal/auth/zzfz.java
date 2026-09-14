package com.google.android.gms.internal.auth;

import F0.AbstractC0008a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.google.firebase.remoteconfig.internal.Code;
import io.flutter.Build;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.apache.tika.pipes.PipesConfigBase;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzfz<T> implements zzgh<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhi.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfw zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfk zzl;
    private final zzgy zzm;
    private final zzel zzn;
    private final zzgb zzo;
    private final zzfr zzp;

    private zzfz(int[] iArr, Object[] objArr, int i, int i3, zzfw zzfwVar, boolean z3, boolean z4, int[] iArr2, int i4, int i5, zzgb zzgbVar, zzfk zzfkVar, zzgy zzgyVar, zzel zzelVar, zzfr zzfrVar, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i3;
        this.zzh = z3;
        this.zzi = iArr2;
        this.zzj = i4;
        this.zzk = i5;
        this.zzo = zzgbVar;
        this.zzl = zzfkVar;
        this.zzm = zzgyVar;
        this.zzn = zzelVar;
        this.zzg = zzfwVar;
        this.zzp = zzfrVar;
    }

    private static Field zzA(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder y = AbstractC0008a.y("Field ", str, " for ", name, " not found. Known fields are ");
            y.append(arrays);
            throw new RuntimeException(y.toString());
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        long zzv = zzv(i) & 1048575;
        if (zzG(obj2, i)) {
            Object zzf = zzhi.zzf(obj, zzv);
            Object zzf2 = zzhi.zzf(obj2, zzv);
            if (zzf != null && zzf2 != null) {
                zzhi.zzp(obj, zzv, zzez.zzg(zzf, zzf2));
                zzD(obj, i);
            } else if (zzf2 != null) {
                zzhi.zzp(obj, zzv, zzf2);
                zzD(obj, i);
            }
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        Object obj3;
        int zzv = zzv(i);
        int i3 = this.zzc[i];
        long j2 = zzv & 1048575;
        if (zzJ(obj2, i3, i)) {
            if (zzJ(obj, i3, i)) {
                obj3 = zzhi.zzf(obj, j2);
            } else {
                obj3 = null;
            }
            Object zzf = zzhi.zzf(obj2, j2);
            if (obj3 != null && zzf != null) {
                zzhi.zzp(obj, j2, zzez.zzg(obj3, zzf));
                zzE(obj, i3, i);
            } else if (zzf != null) {
                zzhi.zzp(obj, j2, zzf);
                zzE(obj, i3, i);
            }
        }
    }

    private final void zzD(Object obj, int i) {
        int zzs = zzs(i);
        long j2 = 1048575 & zzs;
        if (j2 == 1048575) {
            return;
        }
        zzhi.zzn(obj, j2, (1 << (zzs >>> 20)) | zzhi.zzc(obj, j2));
    }

    private final void zzE(Object obj, int i, int i3) {
        zzhi.zzn(obj, zzs(i3) & 1048575, i);
    }

    private final boolean zzF(Object obj, Object obj2, int i) {
        if (zzG(obj, i) == zzG(obj2, i)) {
            return true;
        }
        return false;
    }

    private final boolean zzG(Object obj, int i) {
        int zzs = zzs(i);
        long j2 = zzs & 1048575;
        if (j2 == 1048575) {
            int zzv = zzv(i);
            long j3 = zzv & 1048575;
            switch (zzu(zzv)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzhi.zza(obj, j3)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(zzhi.zzb(obj, j3)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (zzhi.zzd(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (zzhi.zzd(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (zzhi.zzc(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (zzhi.zzd(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (zzhi.zzc(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return zzhi.zzt(obj, j3);
                case 8:
                    Object zzf = zzhi.zzf(obj, j3);
                    if (zzf instanceof String) {
                        if (((String) zzf).isEmpty()) {
                            return false;
                        }
                        return true;
                    }
                    if (zzf instanceof zzee) {
                        if (zzee.zzb.equals(zzf)) {
                            return false;
                        }
                        return true;
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (zzhi.zzf(obj, j3) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (zzee.zzb.equals(zzhi.zzf(obj, j3))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (zzhi.zzc(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case Code.UNIMPLEMENTED /* 12 */:
                    if (zzhi.zzc(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (zzhi.zzc(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (zzhi.zzd(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (zzhi.zzc(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (zzhi.zzd(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (zzhi.zzf(obj, j3) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((zzhi.zzc(obj, j2) & (1 << (zzs >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    private final boolean zzH(Object obj, int i, int i3, int i4, int i5) {
        if (i3 == 1048575) {
            return zzG(obj, i);
        }
        if ((i4 & i5) != 0) {
            return true;
        }
        return false;
    }

    private static boolean zzI(Object obj, int i, zzgh zzghVar) {
        return zzghVar.zzi(zzhi.zzf(obj, i & 1048575));
    }

    private final boolean zzJ(Object obj, int i, int i3) {
        if (zzhi.zzc(obj, zzs(i3) & 1048575) == i) {
            return true;
        }
        return false;
    }

    public static zzgz zzc(Object obj) {
        zzeu zzeuVar = (zzeu) obj;
        zzgz zzgzVar = zzeuVar.zzc;
        if (zzgzVar == zzgz.zza()) {
            zzgz zzc = zzgz.zzc();
            zzeuVar.zzc = zzc;
            return zzc;
        }
        return zzgzVar;
    }

    public static zzfz zzj(Class cls, zzft zzftVar, zzgb zzgbVar, zzfk zzfkVar, zzgy zzgyVar, zzel zzelVar, zzfr zzfrVar) {
        if (zzftVar instanceof zzgg) {
            return zzk((zzgg) zzftVar, zzgbVar, zzfkVar, zzgyVar, zzelVar, zzfrVar);
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0263  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.auth.zzfz zzk(com.google.android.gms.internal.auth.zzgg r34, com.google.android.gms.internal.auth.zzgb r35, com.google.android.gms.internal.auth.zzfk r36, com.google.android.gms.internal.auth.zzgy r37, com.google.android.gms.internal.auth.zzel r38, com.google.android.gms.internal.auth.zzfr r39) {
        /*
            Method dump skipped, instructions count: 985
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfz.zzk(com.google.android.gms.internal.auth.zzgg, com.google.android.gms.internal.auth.zzgb, com.google.android.gms.internal.auth.zzfk, com.google.android.gms.internal.auth.zzgy, com.google.android.gms.internal.auth.zzel, com.google.android.gms.internal.auth.zzfr):com.google.android.gms.internal.auth.zzfz");
    }

    private static int zzl(Object obj, long j2) {
        return ((Integer) zzhi.zzf(obj, j2)).intValue();
    }

    private final int zzm(Object obj, byte[] bArr, int i, int i3, int i4, long j2, zzds zzdsVar) {
        Unsafe unsafe = zzb;
        Object zzz = zzz(i4);
        Object object = unsafe.getObject(obj, j2);
        if (!((zzfq) object).zze()) {
            zzfq zzb2 = zzfq.zza().zzb();
            zzfr.zza(zzb2, object);
            unsafe.putObject(obj, j2, zzb2);
        }
        throw null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x001d. Please report as an issue. */
    private final int zzn(Object obj, byte[] bArr, int i, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, zzds zzdsVar) {
        Object object;
        Unsafe unsafe = zzb;
        long j3 = this.zzc[i9 + 2] & 1048575;
        switch (i8) {
            case 51:
                if (i6 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j2, Double.valueOf(Double.longBitsToDouble(zzdt.zzn(bArr, i))));
                unsafe.putInt(obj, j3, i5);
                return i + 8;
            case 52:
                if (i6 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j2, Float.valueOf(Float.intBitsToFloat(zzdt.zzb(bArr, i))));
                unsafe.putInt(obj, j3, i5);
                return i + 4;
            case 53:
            case 54:
                if (i6 != 0) {
                    return i;
                }
                int zzm = zzdt.zzm(bArr, i, zzdsVar);
                unsafe.putObject(obj, j2, Long.valueOf(zzdsVar.zzb));
                unsafe.putInt(obj, j3, i5);
                return zzm;
            case 55:
            case 62:
                if (i6 != 0) {
                    return i;
                }
                int zzj = zzdt.zzj(bArr, i, zzdsVar);
                unsafe.putObject(obj, j2, Integer.valueOf(zzdsVar.zza));
                unsafe.putInt(obj, j3, i5);
                return zzj;
            case 56:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                if (i6 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j2, Long.valueOf(zzdt.zzn(bArr, i)));
                unsafe.putInt(obj, j3, i5);
                return i + 8;
            case 57:
            case 64:
                if (i6 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j2, Integer.valueOf(zzdt.zzb(bArr, i)));
                unsafe.putInt(obj, j3, i5);
                return i + 4;
            case 58:
                if (i6 != 0) {
                    return i;
                }
                int zzm2 = zzdt.zzm(bArr, i, zzdsVar);
                unsafe.putObject(obj, j2, Boolean.valueOf(zzdsVar.zzb != 0));
                unsafe.putInt(obj, j3, i5);
                return zzm2;
            case 59:
                if (i6 != 2) {
                    return i;
                }
                int zzj2 = zzdt.zzj(bArr, i, zzdsVar);
                int i10 = zzdsVar.zza;
                if (i10 == 0) {
                    unsafe.putObject(obj, j2, "");
                } else {
                    if ((i7 & 536870912) != 0 && !zzhm.zzd(bArr, zzj2, zzj2 + i10)) {
                        throw zzfa.zzb();
                    }
                    unsafe.putObject(obj, j2, new String(bArr, zzj2, i10, zzez.zzb));
                    zzj2 += i10;
                }
                unsafe.putInt(obj, j3, i5);
                return zzj2;
            case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                if (i6 != 2) {
                    return i;
                }
                int zzd = zzdt.zzd(zzy(i9), bArr, i, i3, zzdsVar);
                object = unsafe.getInt(obj, j3) == i5 ? unsafe.getObject(obj, j2) : null;
                if (object == null) {
                    unsafe.putObject(obj, j2, zzdsVar.zzc);
                } else {
                    unsafe.putObject(obj, j2, zzez.zzg(object, zzdsVar.zzc));
                }
                unsafe.putInt(obj, j3, i5);
                return zzd;
            case 61:
                if (i6 != 2) {
                    return i;
                }
                int zza2 = zzdt.zza(bArr, i, zzdsVar);
                unsafe.putObject(obj, j2, zzdsVar.zzc);
                unsafe.putInt(obj, j3, i5);
                return zza2;
            case 63:
                if (i6 != 0) {
                    return i;
                }
                int zzj3 = zzdt.zzj(bArr, i, zzdsVar);
                int i11 = zzdsVar.zza;
                zzex zzx = zzx(i9);
                if (zzx != null && !zzx.zza()) {
                    zzc(obj).zzf(i4, Long.valueOf(i11));
                    return zzj3;
                }
                unsafe.putObject(obj, j2, Integer.valueOf(i11));
                unsafe.putInt(obj, j3, i5);
                return zzj3;
            case 66:
                if (i6 != 0) {
                    return i;
                }
                int zzj4 = zzdt.zzj(bArr, i, zzdsVar);
                unsafe.putObject(obj, j2, Integer.valueOf(zzei.zzb(zzdsVar.zza)));
                unsafe.putInt(obj, j3, i5);
                return zzj4;
            case 67:
                if (i6 != 0) {
                    return i;
                }
                int zzm3 = zzdt.zzm(bArr, i, zzdsVar);
                unsafe.putObject(obj, j2, Long.valueOf(zzei.zzc(zzdsVar.zzb)));
                unsafe.putInt(obj, j3, i5);
                return zzm3;
            case 68:
                if (i6 == 3) {
                    int zzc = zzdt.zzc(zzy(i9), bArr, i, i3, (i4 & (-8)) | 4, zzdsVar);
                    object = unsafe.getInt(obj, j3) == i5 ? unsafe.getObject(obj, j2) : null;
                    if (object == null) {
                        unsafe.putObject(obj, j2, zzdsVar.zzc);
                    } else {
                        unsafe.putObject(obj, j2, zzez.zzg(object, zzdsVar.zzc));
                    }
                    unsafe.putInt(obj, j3, i5);
                    return zzc;
                }
            default:
                return i;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0080. Please report as an issue. */
    private final int zzo(Object obj, byte[] bArr, int i, int i3, zzds zzdsVar) {
        int zzq;
        Unsafe unsafe;
        int i4;
        int i5;
        int i6;
        int i7;
        Object obj2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        zzfz<T> zzfzVar = this;
        Object obj3 = obj;
        byte[] bArr2 = bArr;
        int i14 = i3;
        zzds zzdsVar2 = zzdsVar;
        Unsafe unsafe2 = zzb;
        int i15 = -1;
        int i16 = i;
        int i17 = -1;
        int i18 = 0;
        int i19 = 0;
        int i20 = 1048575;
        while (i16 < i14) {
            int i21 = i16 + 1;
            int i22 = bArr2[i16];
            if (i22 < 0) {
                i21 = zzdt.zzk(i22, bArr2, i21, zzdsVar2);
                i22 = zzdsVar2.zza;
            }
            int i23 = i21;
            int i24 = i22 >>> 3;
            int i25 = i22 & 7;
            if (i24 > i17) {
                zzq = zzfzVar.zzr(i24, i18 / 3);
            } else {
                zzq = zzfzVar.zzq(i24);
            }
            if (zzq == i15) {
                unsafe = unsafe2;
                i4 = i22;
                i5 = i15;
                i6 = i24;
                i7 = 0;
                obj2 = obj3;
            } else {
                int[] iArr = zzfzVar.zzc;
                int i26 = iArr[zzq + 1];
                int zzu = zzu(i26);
                int i27 = i22;
                int i28 = zzq;
                long j2 = i26 & 1048575;
                if (zzu <= 17) {
                    int i29 = iArr[i28 + 2];
                    int i30 = 1 << (i29 >>> 20);
                    int i31 = i29 & 1048575;
                    if (i31 != i20) {
                        int i32 = 1048575;
                        if (i20 != 1048575) {
                            unsafe2.putInt(obj3, i20, i19);
                            i32 = 1048575;
                        }
                        if (i31 != i32) {
                            i19 = unsafe2.getInt(obj3, i31);
                        }
                        i20 = i31;
                    }
                    switch (zzu) {
                        case 0:
                            i13 = i28;
                            if (i25 != 1) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i24;
                                i7 = i13;
                                i5 = -1;
                                i4 = i27;
                                break;
                            } else {
                                zzhi.zzl(obj3, j2, Double.longBitsToDouble(zzdt.zzn(bArr2, i23)));
                                i16 = i23 + 8;
                                i19 |= i30;
                                i14 = i3;
                                i17 = i24;
                                i18 = i13;
                                i15 = -1;
                                break;
                            }
                        case 1:
                            i13 = i28;
                            if (i25 != 5) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i24;
                                i7 = i13;
                                i5 = -1;
                                i4 = i27;
                                break;
                            } else {
                                zzhi.zzm(obj3, j2, Float.intBitsToFloat(zzdt.zzb(bArr2, i23)));
                                i16 = i23 + 4;
                                i19 |= i30;
                                i14 = i3;
                                i17 = i24;
                                i18 = i13;
                                i15 = -1;
                                break;
                            }
                        case 2:
                        case 3:
                            i13 = i28;
                            if (i25 != 0) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i24;
                                i7 = i13;
                                i5 = -1;
                                i4 = i27;
                                break;
                            } else {
                                int zzm = zzdt.zzm(bArr2, i23, zzdsVar2);
                                Unsafe unsafe3 = unsafe2;
                                Object obj4 = obj3;
                                unsafe3.putLong(obj4, j2, zzdsVar2.zzb);
                                unsafe2 = unsafe3;
                                obj3 = obj4;
                                i19 |= i30;
                                i16 = zzm;
                                i17 = i24;
                                i18 = i13;
                                i15 = -1;
                                i14 = i3;
                                break;
                            }
                        case 4:
                        case 11:
                            i13 = i28;
                            if (i25 != 0) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i24;
                                i7 = i13;
                                i5 = -1;
                                i4 = i27;
                                break;
                            } else {
                                int zzj = zzdt.zzj(bArr2, i23, zzdsVar2);
                                unsafe2.putInt(obj3, j2, zzdsVar2.zza);
                                i19 |= i30;
                                i14 = i3;
                                i16 = zzj;
                                i17 = i24;
                                i18 = i13;
                                i15 = -1;
                                break;
                            }
                        case 5:
                        case 14:
                            i13 = i28;
                            if (i25 != 1) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i24;
                                i7 = i13;
                                i5 = -1;
                                i4 = i27;
                                break;
                            } else {
                                Unsafe unsafe4 = unsafe2;
                                Object obj5 = obj3;
                                unsafe4.putLong(obj5, j2, zzdt.zzn(bArr2, i23));
                                unsafe2 = unsafe4;
                                obj3 = obj5;
                                i16 = i23 + 8;
                                i19 |= i30;
                                i14 = i3;
                                i17 = i24;
                                i18 = i13;
                                i15 = -1;
                                break;
                            }
                        case 6:
                        case 13:
                            i13 = i28;
                            if (i25 != 5) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i24;
                                i7 = i13;
                                i5 = -1;
                                i4 = i27;
                                break;
                            } else {
                                unsafe2.putInt(obj3, j2, zzdt.zzb(bArr2, i23));
                                i16 = i23 + 4;
                                i19 |= i30;
                                i14 = i3;
                                i17 = i24;
                                i18 = i13;
                                i15 = -1;
                                break;
                            }
                        case 7:
                            i13 = i28;
                            if (i25 != 0) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i24;
                                i7 = i13;
                                i5 = -1;
                                i4 = i27;
                                break;
                            } else {
                                i16 = zzdt.zzm(bArr2, i23, zzdsVar2);
                                zzhi.zzk(obj3, j2, zzdsVar2.zzb != 0);
                                i19 |= i30;
                                i14 = i3;
                                i17 = i24;
                                i18 = i13;
                                i15 = -1;
                                break;
                            }
                        case 8:
                            i13 = i28;
                            if (i25 != 2) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i24;
                                i7 = i13;
                                i5 = -1;
                                i4 = i27;
                                break;
                            } else {
                                if ((536870912 & i26) == 0) {
                                    i16 = zzdt.zzg(bArr2, i23, zzdsVar2);
                                } else {
                                    i16 = zzdt.zzh(bArr2, i23, zzdsVar2);
                                }
                                unsafe2.putObject(obj3, j2, zzdsVar2.zzc);
                                i19 |= i30;
                                i17 = i24;
                                i18 = i13;
                                i15 = -1;
                                break;
                            }
                        case 9:
                            i13 = i28;
                            if (i25 != 2) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i24;
                                i7 = i13;
                                i5 = -1;
                                i4 = i27;
                                break;
                            } else {
                                i16 = zzdt.zzd(zzfzVar.zzy(i13), bArr2, i23, i14, zzdsVar2);
                                Object object = unsafe2.getObject(obj3, j2);
                                if (object == null) {
                                    unsafe2.putObject(obj3, j2, zzdsVar2.zzc);
                                } else {
                                    unsafe2.putObject(obj3, j2, zzez.zzg(object, zzdsVar2.zzc));
                                }
                                i19 |= i30;
                                i17 = i24;
                                i18 = i13;
                                i15 = -1;
                                break;
                            }
                        case 10:
                            i13 = i28;
                            if (i25 != 2) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i24;
                                i7 = i13;
                                i5 = -1;
                                i4 = i27;
                                break;
                            } else {
                                i16 = zzdt.zza(bArr2, i23, zzdsVar2);
                                unsafe2.putObject(obj3, j2, zzdsVar2.zzc);
                                i19 |= i30;
                                i17 = i24;
                                i18 = i13;
                                i15 = -1;
                                break;
                            }
                        case Code.UNIMPLEMENTED /* 12 */:
                            i13 = i28;
                            if (i25 != 0) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i24;
                                i7 = i13;
                                i5 = -1;
                                i4 = i27;
                                break;
                            } else {
                                i16 = zzdt.zzj(bArr2, i23, zzdsVar2);
                                unsafe2.putInt(obj3, j2, zzdsVar2.zza);
                                i19 |= i30;
                                i17 = i24;
                                i18 = i13;
                                i15 = -1;
                                break;
                            }
                        case 15:
                            i13 = i28;
                            if (i25 != 0) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i24;
                                i7 = i13;
                                i5 = -1;
                                i4 = i27;
                                break;
                            } else {
                                i16 = zzdt.zzj(bArr2, i23, zzdsVar2);
                                unsafe2.putInt(obj3, j2, zzei.zzb(zzdsVar2.zza));
                                i19 |= i30;
                                i17 = i24;
                                i18 = i13;
                                i15 = -1;
                                break;
                            }
                        case 16:
                            if (i25 != 0) {
                                i13 = i28;
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i24;
                                i7 = i13;
                                i5 = -1;
                                i4 = i27;
                                break;
                            } else {
                                int zzm2 = zzdt.zzm(bArr2, i23, zzdsVar2);
                                Unsafe unsafe5 = unsafe2;
                                Object obj6 = obj3;
                                i13 = i28;
                                unsafe5.putLong(obj6, j2, zzei.zzc(zzdsVar2.zzb));
                                unsafe2 = unsafe5;
                                obj3 = obj6;
                                i19 |= i30;
                                i16 = zzm2;
                                i17 = i24;
                                i18 = i13;
                                i15 = -1;
                                break;
                            }
                        default:
                            i13 = i28;
                            obj2 = obj3;
                            unsafe = unsafe2;
                            i6 = i24;
                            i7 = i13;
                            i5 = -1;
                            i4 = i27;
                            break;
                    }
                } else {
                    i7 = i28;
                    if (zzu != 27) {
                        i8 = i23;
                        Unsafe unsafe6 = unsafe2;
                        if (zzu <= 49) {
                            i9 = i19;
                            unsafe = unsafe6;
                            i5 = -1;
                            i11 = i20;
                            int zzp = zzfzVar.zzp(obj, bArr, i8, i3, i27, i24, i25, i7, i26, zzu, j2, zzdsVar);
                            i10 = i27;
                            i12 = i24;
                            if (zzp != i8) {
                                zzfzVar = this;
                                obj3 = obj;
                                zzdsVar2 = zzdsVar;
                                i16 = zzp;
                                i18 = i7;
                                i17 = i12;
                                i20 = i11;
                                i15 = i5;
                                i19 = i9;
                                unsafe2 = unsafe;
                                bArr2 = bArr;
                                i14 = i3;
                            } else {
                                obj2 = obj;
                                i23 = zzp;
                                i6 = i12;
                                i4 = i10;
                            }
                        } else {
                            i9 = i19;
                            unsafe = unsafe6;
                            i5 = -1;
                            i10 = i27;
                            i11 = i20;
                            i12 = i24;
                            if (zzu != 50) {
                                i6 = i12;
                                int zzn = zzn(obj, bArr, i8, i3, i10, i6, i25, i26, zzu, j2, i7, zzdsVar);
                                obj2 = obj;
                                i4 = i10;
                                i7 = i7;
                                if (zzn != i8) {
                                    zzfzVar = this;
                                    zzdsVar2 = zzdsVar;
                                    i17 = i6;
                                    i16 = zzn;
                                    i18 = i7;
                                    obj3 = obj2;
                                    i20 = i11;
                                    i15 = i5;
                                    i19 = i9;
                                    unsafe2 = unsafe;
                                    bArr2 = bArr;
                                    i14 = i3;
                                } else {
                                    i23 = zzn;
                                }
                            } else if (i25 == 2) {
                                int zzm3 = zzm(obj, bArr, i8, i3, i7, j2, zzdsVar);
                                i7 = i7;
                                if (zzm3 != i8) {
                                    zzfzVar = this;
                                    obj3 = obj;
                                    bArr2 = bArr;
                                    zzdsVar2 = zzdsVar;
                                    i16 = zzm3;
                                    i18 = i7;
                                    i17 = i12;
                                    i20 = i11;
                                    i15 = -1;
                                    i19 = i9;
                                    unsafe2 = unsafe;
                                    i14 = i3;
                                } else {
                                    obj2 = obj;
                                    i23 = zzm3;
                                    i6 = i12;
                                    i4 = i10;
                                }
                            } else {
                                i7 = i7;
                                obj2 = obj;
                                i23 = i8;
                                i6 = i12;
                                i4 = i10;
                            }
                        }
                    } else if (i25 == 2) {
                        zzey zzeyVar = (zzey) unsafe2.getObject(obj3, j2);
                        if (!zzeyVar.zzc()) {
                            int size = zzeyVar.size();
                            zzeyVar = zzeyVar.zzd(size == 0 ? 10 : size + size);
                            unsafe2.putObject(obj3, j2, zzeyVar);
                        }
                        int zze = zzdt.zze(zzfzVar.zzy(i7), i27, bArr2, i23, i3, zzeyVar, zzdsVar2);
                        bArr2 = bArr;
                        zzdsVar2 = zzdsVar;
                        i16 = zze;
                        i18 = i7;
                        unsafe2 = unsafe2;
                        i17 = i24;
                        i15 = -1;
                        obj3 = obj;
                        i14 = i3;
                    } else {
                        i8 = i23;
                        i11 = i20;
                        i9 = i19;
                        unsafe = unsafe2;
                        i12 = i24;
                        i5 = -1;
                        i10 = i27;
                        obj2 = obj;
                        i23 = i8;
                        i6 = i12;
                        i4 = i10;
                    }
                    i20 = i11;
                    i19 = i9;
                }
            }
            int zzi = zzdt.zzi(i4, bArr, i23, i3, zzc(obj2), zzdsVar);
            bArr2 = bArr;
            zzdsVar2 = zzdsVar;
            i17 = i6;
            i18 = i7;
            obj3 = obj2;
            i15 = i5;
            unsafe2 = unsafe;
            i14 = i3;
            i16 = zzi;
            zzfzVar = this;
        }
        Object obj7 = obj3;
        Unsafe unsafe7 = unsafe2;
        int i33 = i14;
        int i34 = i20;
        int i35 = i19;
        if (i34 != 1048575) {
            unsafe7.putInt(obj7, i34, i35);
        }
        if (i16 == i33) {
            return i16;
        }
        throw zzfa.zzd();
    }

    private final int zzp(Object obj, byte[] bArr, int i, int i3, int i4, int i5, int i6, int i7, long j2, int i8, long j3, zzds zzdsVar) {
        int zzl;
        Unsafe unsafe = zzb;
        zzey zzeyVar = (zzey) unsafe.getObject(obj, j3);
        if (!zzeyVar.zzc()) {
            int size = zzeyVar.size();
            zzeyVar = zzeyVar.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j3, zzeyVar);
        }
        zzey zzeyVar2 = zzeyVar;
        switch (i8) {
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
            case Build.API_LEVELS.API_35 /* 35 */:
                if (i6 == 2) {
                    zzej zzejVar = (zzej) zzeyVar2;
                    int zzj = zzdt.zzj(bArr, i, zzdsVar);
                    int i9 = zzdsVar.zza + zzj;
                    while (zzj < i9) {
                        zzejVar.zze(Double.longBitsToDouble(zzdt.zzn(bArr, zzj)));
                        zzj += 8;
                    }
                    if (zzj == i9) {
                        return zzj;
                    }
                    throw zzfa.zzf();
                }
                if (i6 == 1) {
                    zzej zzejVar2 = (zzej) zzeyVar2;
                    zzejVar2.zze(Double.longBitsToDouble(zzdt.zzn(bArr, i)));
                    int i10 = i + 8;
                    while (i10 < i3) {
                        int zzj2 = zzdt.zzj(bArr, i10, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return i10;
                        }
                        zzejVar2.zze(Double.longBitsToDouble(zzdt.zzn(bArr, zzj2)));
                        i10 = zzj2 + 8;
                    }
                    return i10;
                }
                return i;
            case 19:
            case Build.API_LEVELS.API_36 /* 36 */:
                if (i6 == 2) {
                    zzeq zzeqVar = (zzeq) zzeyVar2;
                    int zzj3 = zzdt.zzj(bArr, i, zzdsVar);
                    int i11 = zzdsVar.zza + zzj3;
                    while (zzj3 < i11) {
                        zzeqVar.zze(Float.intBitsToFloat(zzdt.zzb(bArr, zzj3)));
                        zzj3 += 4;
                    }
                    if (zzj3 == i11) {
                        return zzj3;
                    }
                    throw zzfa.zzf();
                }
                if (i6 == 5) {
                    zzeq zzeqVar2 = (zzeq) zzeyVar2;
                    zzeqVar2.zze(Float.intBitsToFloat(zzdt.zzb(bArr, i)));
                    int i12 = i + 4;
                    while (i12 < i3) {
                        int zzj4 = zzdt.zzj(bArr, i12, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return i12;
                        }
                        zzeqVar2.zze(Float.intBitsToFloat(zzdt.zzb(bArr, zzj4)));
                        i12 = zzj4 + 4;
                    }
                    return i12;
                }
                return i;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i6 == 2) {
                    zzfl zzflVar = (zzfl) zzeyVar2;
                    int zzj5 = zzdt.zzj(bArr, i, zzdsVar);
                    int i13 = zzdsVar.zza + zzj5;
                    while (zzj5 < i13) {
                        zzj5 = zzdt.zzm(bArr, zzj5, zzdsVar);
                        zzflVar.zze(zzdsVar.zzb);
                    }
                    if (zzj5 == i13) {
                        return zzj5;
                    }
                    throw zzfa.zzf();
                }
                if (i6 == 0) {
                    zzfl zzflVar2 = (zzfl) zzeyVar2;
                    int zzm = zzdt.zzm(bArr, i, zzdsVar);
                    zzflVar2.zze(zzdsVar.zzb);
                    while (zzm < i3) {
                        int zzj6 = zzdt.zzj(bArr, zzm, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return zzm;
                        }
                        zzm = zzdt.zzm(bArr, zzj6, zzdsVar);
                        zzflVar2.zze(zzdsVar.zzb);
                    }
                    return zzm;
                }
                return i;
            case 22:
            case Build.API_LEVELS.API_29 /* 29 */:
            case 39:
            case 43:
                if (i6 == 2) {
                    return zzdt.zzf(bArr, i, zzeyVar2, zzdsVar);
                }
                if (i6 == 0) {
                    return zzdt.zzl(i4, bArr, i, i3, zzeyVar2, zzdsVar);
                }
                return i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i6 == 2) {
                    zzfl zzflVar3 = (zzfl) zzeyVar2;
                    int zzj7 = zzdt.zzj(bArr, i, zzdsVar);
                    int i14 = zzdsVar.zza + zzj7;
                    while (zzj7 < i14) {
                        zzflVar3.zze(zzdt.zzn(bArr, zzj7));
                        zzj7 += 8;
                    }
                    if (zzj7 == i14) {
                        return zzj7;
                    }
                    throw zzfa.zzf();
                }
                if (i6 == 1) {
                    zzfl zzflVar4 = (zzfl) zzeyVar2;
                    zzflVar4.zze(zzdt.zzn(bArr, i));
                    int i15 = i + 8;
                    while (i15 < i3) {
                        int zzj8 = zzdt.zzj(bArr, i15, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return i15;
                        }
                        zzflVar4.zze(zzdt.zzn(bArr, zzj8));
                        i15 = zzj8 + 8;
                    }
                    return i15;
                }
                return i;
            case 24:
            case Build.API_LEVELS.API_31 /* 31 */:
            case 41:
            case 45:
                if (i6 == 2) {
                    zzev zzevVar = (zzev) zzeyVar2;
                    int zzj9 = zzdt.zzj(bArr, i, zzdsVar);
                    int i16 = zzdsVar.zza + zzj9;
                    while (zzj9 < i16) {
                        zzevVar.zze(zzdt.zzb(bArr, zzj9));
                        zzj9 += 4;
                    }
                    if (zzj9 == i16) {
                        return zzj9;
                    }
                    throw zzfa.zzf();
                }
                if (i6 == 5) {
                    zzev zzevVar2 = (zzev) zzeyVar2;
                    zzevVar2.zze(zzdt.zzb(bArr, i));
                    int i17 = i + 4;
                    while (i17 < i3) {
                        int zzj10 = zzdt.zzj(bArr, i17, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return i17;
                        }
                        zzevVar2.zze(zzdt.zzb(bArr, zzj10));
                        i17 = zzj10 + 4;
                    }
                    return i17;
                }
                return i;
            case Build.API_LEVELS.API_25 /* 25 */:
            case 42:
                if (i6 == 2) {
                    zzdu zzduVar = (zzdu) zzeyVar2;
                    int zzj11 = zzdt.zzj(bArr, i, zzdsVar);
                    int i18 = zzdsVar.zza + zzj11;
                    while (zzj11 < i18) {
                        zzj11 = zzdt.zzm(bArr, zzj11, zzdsVar);
                        zzduVar.zze(zzdsVar.zzb != 0);
                    }
                    if (zzj11 == i18) {
                        return zzj11;
                    }
                    throw zzfa.zzf();
                }
                if (i6 == 0) {
                    zzdu zzduVar2 = (zzdu) zzeyVar2;
                    int zzm2 = zzdt.zzm(bArr, i, zzdsVar);
                    zzduVar2.zze(zzdsVar.zzb != 0);
                    while (zzm2 < i3) {
                        int zzj12 = zzdt.zzj(bArr, zzm2, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return zzm2;
                        }
                        zzm2 = zzdt.zzm(bArr, zzj12, zzdsVar);
                        zzduVar2.zze(zzdsVar.zzb != 0);
                    }
                    return zzm2;
                }
                return i;
            case Build.API_LEVELS.API_26 /* 26 */:
                if (i6 == 2) {
                    if ((j2 & 536870912) == 0) {
                        int zzj13 = zzdt.zzj(bArr, i, zzdsVar);
                        int i19 = zzdsVar.zza;
                        if (i19 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i19 == 0) {
                            zzeyVar2.add("");
                        } else {
                            zzeyVar2.add(new String(bArr, zzj13, i19, zzez.zzb));
                            zzj13 += i19;
                        }
                        while (zzj13 < i3) {
                            int zzj14 = zzdt.zzj(bArr, zzj13, zzdsVar);
                            if (i4 != zzdsVar.zza) {
                                return zzj13;
                            }
                            zzj13 = zzdt.zzj(bArr, zzj14, zzdsVar);
                            int i20 = zzdsVar.zza;
                            if (i20 < 0) {
                                throw zzfa.zzc();
                            }
                            if (i20 == 0) {
                                zzeyVar2.add("");
                            } else {
                                zzeyVar2.add(new String(bArr, zzj13, i20, zzez.zzb));
                                zzj13 += i20;
                            }
                        }
                        return zzj13;
                    }
                    int zzj15 = zzdt.zzj(bArr, i, zzdsVar);
                    int i21 = zzdsVar.zza;
                    if (i21 < 0) {
                        throw zzfa.zzc();
                    }
                    if (i21 == 0) {
                        zzeyVar2.add("");
                    } else {
                        int i22 = zzj15 + i21;
                        if (zzhm.zzd(bArr, zzj15, i22)) {
                            zzeyVar2.add(new String(bArr, zzj15, i21, zzez.zzb));
                            zzj15 = i22;
                        } else {
                            throw zzfa.zzb();
                        }
                    }
                    while (zzj15 < i3) {
                        int zzj16 = zzdt.zzj(bArr, zzj15, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return zzj15;
                        }
                        zzj15 = zzdt.zzj(bArr, zzj16, zzdsVar);
                        int i23 = zzdsVar.zza;
                        if (i23 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i23 == 0) {
                            zzeyVar2.add("");
                        } else {
                            int i24 = zzj15 + i23;
                            if (zzhm.zzd(bArr, zzj15, i24)) {
                                zzeyVar2.add(new String(bArr, zzj15, i23, zzez.zzb));
                                zzj15 = i24;
                            } else {
                                throw zzfa.zzb();
                            }
                        }
                    }
                    return zzj15;
                }
                return i;
            case Build.API_LEVELS.API_27 /* 27 */:
                if (i6 == 2) {
                    return zzdt.zze(zzy(i7), i4, bArr, i, i3, zzeyVar2, zzdsVar);
                }
                return i;
            case Build.API_LEVELS.API_28 /* 28 */:
                if (i6 == 2) {
                    int zzj17 = zzdt.zzj(bArr, i, zzdsVar);
                    int i25 = zzdsVar.zza;
                    if (i25 >= 0) {
                        if (i25 > bArr.length - zzj17) {
                            throw zzfa.zzf();
                        }
                        if (i25 == 0) {
                            zzeyVar2.add(zzee.zzb);
                        } else {
                            zzeyVar2.add(zzee.zzk(bArr, zzj17, i25));
                            zzj17 += i25;
                        }
                        while (zzj17 < i3) {
                            int zzj18 = zzdt.zzj(bArr, zzj17, zzdsVar);
                            if (i4 != zzdsVar.zza) {
                                return zzj17;
                            }
                            zzj17 = zzdt.zzj(bArr, zzj18, zzdsVar);
                            int i26 = zzdsVar.zza;
                            if (i26 >= 0) {
                                if (i26 > bArr.length - zzj17) {
                                    throw zzfa.zzf();
                                }
                                if (i26 == 0) {
                                    zzeyVar2.add(zzee.zzb);
                                } else {
                                    zzeyVar2.add(zzee.zzk(bArr, zzj17, i26));
                                    zzj17 += i26;
                                }
                            } else {
                                throw zzfa.zzc();
                            }
                        }
                        return zzj17;
                    }
                    throw zzfa.zzc();
                }
                return i;
            case Build.API_LEVELS.API_30 /* 30 */:
            case 44:
                if (i6 != 2) {
                    if (i6 == 0) {
                        zzl = zzdt.zzl(i4, bArr, i, i3, zzeyVar2, zzdsVar);
                    }
                    return i;
                }
                zzl = zzdt.zzf(bArr, i, zzeyVar2, zzdsVar);
                zzeu zzeuVar = (zzeu) obj;
                zzgz zzgzVar = zzeuVar.zzc;
                if (zzgzVar == zzgz.zza()) {
                    zzgzVar = null;
                }
                Object zzd = zzgj.zzd(i5, zzeyVar2, zzx(i7), zzgzVar, this.zzm);
                if (zzd == null) {
                    return zzl;
                }
                zzeuVar.zzc = (zzgz) zzd;
                return zzl;
            case Build.API_LEVELS.API_33 /* 33 */:
            case 47:
                if (i6 == 2) {
                    zzev zzevVar3 = (zzev) zzeyVar2;
                    int zzj19 = zzdt.zzj(bArr, i, zzdsVar);
                    int i27 = zzdsVar.zza + zzj19;
                    while (zzj19 < i27) {
                        zzj19 = zzdt.zzj(bArr, zzj19, zzdsVar);
                        zzevVar3.zze(zzei.zzb(zzdsVar.zza));
                    }
                    if (zzj19 == i27) {
                        return zzj19;
                    }
                    throw zzfa.zzf();
                }
                if (i6 == 0) {
                    zzev zzevVar4 = (zzev) zzeyVar2;
                    int zzj20 = zzdt.zzj(bArr, i, zzdsVar);
                    zzevVar4.zze(zzei.zzb(zzdsVar.zza));
                    while (zzj20 < i3) {
                        int zzj21 = zzdt.zzj(bArr, zzj20, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return zzj20;
                        }
                        zzj20 = zzdt.zzj(bArr, zzj21, zzdsVar);
                        zzevVar4.zze(zzei.zzb(zzdsVar.zza));
                    }
                    return zzj20;
                }
                return i;
            case Build.API_LEVELS.API_34 /* 34 */:
            case 48:
                if (i6 == 2) {
                    zzfl zzflVar5 = (zzfl) zzeyVar2;
                    int zzj22 = zzdt.zzj(bArr, i, zzdsVar);
                    int i28 = zzdsVar.zza + zzj22;
                    while (zzj22 < i28) {
                        zzj22 = zzdt.zzm(bArr, zzj22, zzdsVar);
                        zzflVar5.zze(zzei.zzc(zzdsVar.zzb));
                    }
                    if (zzj22 == i28) {
                        return zzj22;
                    }
                    throw zzfa.zzf();
                }
                if (i6 == 0) {
                    zzfl zzflVar6 = (zzfl) zzeyVar2;
                    int zzm3 = zzdt.zzm(bArr, i, zzdsVar);
                    zzflVar6.zze(zzei.zzc(zzdsVar.zzb));
                    while (zzm3 < i3) {
                        int zzj23 = zzdt.zzj(bArr, zzm3, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return zzm3;
                        }
                        zzm3 = zzdt.zzm(bArr, zzj23, zzdsVar);
                        zzflVar6.zze(zzei.zzc(zzdsVar.zzb));
                    }
                    return zzm3;
                }
                return i;
            default:
                if (i6 == 3) {
                    zzgh zzy = zzy(i7);
                    int i29 = (i4 & (-8)) | 4;
                    int zzc = zzdt.zzc(zzy, bArr, i, i3, i29, zzdsVar);
                    zzgh zzghVar = zzy;
                    zzds zzdsVar2 = zzdsVar;
                    zzeyVar2.add(zzdsVar2.zzc);
                    while (zzc < i3) {
                        int zzj24 = zzdt.zzj(bArr, zzc, zzdsVar2);
                        if (i4 != zzdsVar2.zza) {
                            return zzc;
                        }
                        zzgh zzghVar2 = zzghVar;
                        zzds zzdsVar3 = zzdsVar2;
                        zzc = zzdt.zzc(zzghVar2, bArr, zzj24, i3, i29, zzdsVar3);
                        zzeyVar2.add(zzdsVar3.zzc);
                        zzghVar = zzghVar2;
                        zzdsVar2 = zzdsVar3;
                    }
                    return zzc;
                }
                return i;
        }
    }

    private final int zzq(int i) {
        if (i >= this.zze && i <= this.zzf) {
            return zzt(i, 0);
        }
        return -1;
    }

    private final int zzr(int i, int i3) {
        if (i >= this.zze && i <= this.zzf) {
            return zzt(i, i3);
        }
        return -1;
    }

    private final int zzs(int i) {
        return this.zzc[i + 2];
    }

    private final int zzt(int i, int i3) {
        int length = (this.zzc.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.zzc[i5];
            if (i == i6) {
                return i5;
            }
            if (i < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    private static int zzu(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzv(int i) {
        return this.zzc[i + 1];
    }

    private static long zzw(Object obj, long j2) {
        return ((Long) zzhi.zzf(obj, j2)).longValue();
    }

    private final zzex zzx(int i) {
        int i3 = i / 3;
        return (zzex) this.zzd[i3 + i3 + 1];
    }

    private final zzgh zzy(int i) {
        int i3 = i / 3;
        int i4 = i3 + i3;
        zzgh zzghVar = (zzgh) this.zzd[i4];
        if (zzghVar != null) {
            return zzghVar;
        }
        zzgh zzb2 = zzge.zza().zzb((Class) this.zzd[i4 + 1]);
        this.zzd[i4] = zzb2;
        return zzb2;
    }

    private final Object zzz(int i) {
        int i3 = i / 3;
        return this.zzd[i3 + i3];
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001a. Please report as an issue. */
    @Override // com.google.android.gms.internal.auth.zzgh
    public final int zza(Object obj) {
        int i;
        int zzc;
        int i3;
        int zzc2;
        int length = this.zzc.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int zzv = zzv(i5);
            int i6 = this.zzc[i5];
            long j2 = 1048575 & zzv;
            int i7 = 37;
            switch (zzu(zzv)) {
                case 0:
                    i = i4 * 53;
                    zzc = zzez.zzc(Double.doubleToLongBits(zzhi.zza(obj, j2)));
                    i4 = zzc + i;
                    break;
                case 1:
                    i = i4 * 53;
                    zzc = Float.floatToIntBits(zzhi.zzb(obj, j2));
                    i4 = zzc + i;
                    break;
                case 2:
                    i = i4 * 53;
                    zzc = zzez.zzc(zzhi.zzd(obj, j2));
                    i4 = zzc + i;
                    break;
                case 3:
                    i = i4 * 53;
                    zzc = zzez.zzc(zzhi.zzd(obj, j2));
                    i4 = zzc + i;
                    break;
                case 4:
                    i3 = i4 * 53;
                    zzc2 = zzhi.zzc(obj, j2);
                    i4 = i3 + zzc2;
                    break;
                case 5:
                    i = i4 * 53;
                    zzc = zzez.zzc(zzhi.zzd(obj, j2));
                    i4 = zzc + i;
                    break;
                case 6:
                    i3 = i4 * 53;
                    zzc2 = zzhi.zzc(obj, j2);
                    i4 = i3 + zzc2;
                    break;
                case 7:
                    i = i4 * 53;
                    zzc = zzez.zza(zzhi.zzt(obj, j2));
                    i4 = zzc + i;
                    break;
                case 8:
                    i = i4 * 53;
                    zzc = ((String) zzhi.zzf(obj, j2)).hashCode();
                    i4 = zzc + i;
                    break;
                case 9:
                    Object zzf = zzhi.zzf(obj, j2);
                    if (zzf != null) {
                        i7 = zzf.hashCode();
                    }
                    i4 = (i4 * 53) + i7;
                    break;
                case 10:
                    i = i4 * 53;
                    zzc = zzhi.zzf(obj, j2).hashCode();
                    i4 = zzc + i;
                    break;
                case 11:
                    i3 = i4 * 53;
                    zzc2 = zzhi.zzc(obj, j2);
                    i4 = i3 + zzc2;
                    break;
                case Code.UNIMPLEMENTED /* 12 */:
                    i3 = i4 * 53;
                    zzc2 = zzhi.zzc(obj, j2);
                    i4 = i3 + zzc2;
                    break;
                case 13:
                    i3 = i4 * 53;
                    zzc2 = zzhi.zzc(obj, j2);
                    i4 = i3 + zzc2;
                    break;
                case 14:
                    i = i4 * 53;
                    zzc = zzez.zzc(zzhi.zzd(obj, j2));
                    i4 = zzc + i;
                    break;
                case 15:
                    i3 = i4 * 53;
                    zzc2 = zzhi.zzc(obj, j2);
                    i4 = i3 + zzc2;
                    break;
                case 16:
                    i = i4 * 53;
                    zzc = zzez.zzc(zzhi.zzd(obj, j2));
                    i4 = zzc + i;
                    break;
                case 17:
                    Object zzf2 = zzhi.zzf(obj, j2);
                    if (zzf2 != null) {
                        i7 = zzf2.hashCode();
                    }
                    i4 = (i4 * 53) + i7;
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case Build.API_LEVELS.API_25 /* 25 */:
                case Build.API_LEVELS.API_26 /* 26 */:
                case Build.API_LEVELS.API_27 /* 27 */:
                case Build.API_LEVELS.API_28 /* 28 */:
                case Build.API_LEVELS.API_29 /* 29 */:
                case Build.API_LEVELS.API_30 /* 30 */:
                case Build.API_LEVELS.API_31 /* 31 */:
                case 32:
                case Build.API_LEVELS.API_33 /* 33 */:
                case Build.API_LEVELS.API_34 /* 34 */:
                case Build.API_LEVELS.API_35 /* 35 */:
                case Build.API_LEVELS.API_36 /* 36 */:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i4 * 53;
                    zzc = zzhi.zzf(obj, j2).hashCode();
                    i4 = zzc + i;
                    break;
                case 50:
                    i = i4 * 53;
                    zzc = zzhi.zzf(obj, j2).hashCode();
                    i4 = zzc + i;
                    break;
                case 51:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        zzc = zzez.zzc(Double.doubleToLongBits(((Double) zzhi.zzf(obj, j2)).doubleValue()));
                        i4 = zzc + i;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        zzc = Float.floatToIntBits(((Float) zzhi.zzf(obj, j2)).floatValue());
                        i4 = zzc + i;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        zzc = zzez.zzc(zzw(obj, j2));
                        i4 = zzc + i;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        zzc = zzez.zzc(zzw(obj, j2));
                        i4 = zzc + i;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzJ(obj, i6, i5)) {
                        i3 = i4 * 53;
                        zzc2 = zzl(obj, j2);
                        i4 = i3 + zzc2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        zzc = zzez.zzc(zzw(obj, j2));
                        i4 = zzc + i;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzJ(obj, i6, i5)) {
                        i3 = i4 * 53;
                        zzc2 = zzl(obj, j2);
                        i4 = i3 + zzc2;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        zzc = zzez.zza(((Boolean) zzhi.zzf(obj, j2)).booleanValue());
                        i4 = zzc + i;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        zzc = ((String) zzhi.zzf(obj, j2)).hashCode();
                        i4 = zzc + i;
                        break;
                    } else {
                        break;
                    }
                case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        zzc = zzhi.zzf(obj, j2).hashCode();
                        i4 = zzc + i;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        zzc = zzhi.zzf(obj, j2).hashCode();
                        i4 = zzc + i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzJ(obj, i6, i5)) {
                        i3 = i4 * 53;
                        zzc2 = zzl(obj, j2);
                        i4 = i3 + zzc2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzJ(obj, i6, i5)) {
                        i3 = i4 * 53;
                        zzc2 = zzl(obj, j2);
                        i4 = i3 + zzc2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzJ(obj, i6, i5)) {
                        i3 = i4 * 53;
                        zzc2 = zzl(obj, j2);
                        i4 = i3 + zzc2;
                        break;
                    } else {
                        break;
                    }
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        zzc = zzez.zzc(zzw(obj, j2));
                        i4 = zzc + i;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzJ(obj, i6, i5)) {
                        i3 = i4 * 53;
                        zzc2 = zzl(obj, j2);
                        i4 = i3 + zzc2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        zzc = zzez.zzc(zzw(obj, j2));
                        i4 = zzc + i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        zzc = zzhi.zzf(obj, j2).hashCode();
                        i4 = zzc + i;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return this.zzm.zza(obj).hashCode() + (i4 * 53);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:108:0x0088. Please report as an issue. */
    public final int zzb(Object obj, byte[] bArr, int i, int i3, int i4, zzds zzdsVar) {
        int i5;
        zzfz<T> zzfzVar;
        Unsafe unsafe;
        int i6;
        Object obj2;
        int zzq;
        int i7;
        int i8;
        int i9;
        int i10;
        byte[] bArr2;
        int i11;
        Unsafe unsafe2;
        int i12;
        zzds zzdsVar2;
        int zzj;
        int i13;
        boolean z3;
        int i14;
        zzds zzdsVar3;
        int i15;
        Object obj3;
        Unsafe unsafe3;
        byte[] bArr3;
        zzds zzdsVar4;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        zzfz<T> zzfzVar2 = this;
        Object obj4 = obj;
        byte[] bArr4 = bArr;
        int i22 = i3;
        zzds zzdsVar5 = zzdsVar;
        Unsafe unsafe4 = zzb;
        int i23 = -1;
        int i24 = i;
        int i25 = -1;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 1048575;
        while (true) {
            if (i24 < i22) {
                int i30 = i24 + 1;
                int i31 = bArr4[i24];
                if (i31 < 0) {
                    i30 = zzdt.zzk(i31, bArr4, i30, zzdsVar5);
                    i31 = zzdsVar5.zza;
                }
                int i32 = i31;
                int i33 = i30;
                int i34 = i32 >>> 3;
                int i35 = i32 & 7;
                if (i34 > i25) {
                    zzq = zzfzVar2.zzr(i34, i28 / 3);
                } else {
                    zzq = zzfzVar2.zzq(i34);
                }
                i28 = zzq;
                if (i28 == i23) {
                    i5 = i4;
                    zzfzVar = zzfzVar2;
                    i7 = i33;
                    i8 = i34;
                    unsafe = unsafe4;
                    i9 = i23;
                    i26 = i32;
                    i28 = 0;
                    i6 = 1048575;
                    obj2 = obj4;
                } else {
                    int[] iArr = zzfzVar2.zzc;
                    int i36 = iArr[i28 + 1];
                    int zzu = zzu(i36);
                    int i37 = i32;
                    long j2 = i36 & 1048575;
                    if (zzu <= 17) {
                        int i38 = iArr[i28 + 2];
                        int i39 = 1 << (i38 >>> 20);
                        int i40 = i38 & 1048575;
                        if (i40 != i29) {
                            i10 = 1048575;
                            if (i29 != 1048575) {
                                unsafe4.putInt(obj4, i29, i27);
                            }
                            i29 = i40;
                            i27 = unsafe4.getInt(obj4, i40);
                        } else {
                            i10 = 1048575;
                        }
                        switch (zzu) {
                            case 0:
                                bArr3 = bArr;
                                i11 = i10;
                                zzdsVar4 = zzdsVar;
                                obj3 = obj4;
                                unsafe3 = unsafe4;
                                i12 = i33;
                                i8 = i34;
                                if (i35 == 1) {
                                    zzhi.zzl(obj3, j2, Double.longBitsToDouble(zzdt.zzn(bArr3, i12)));
                                    i24 = i12 + 8;
                                    i27 |= i39;
                                    i22 = i3;
                                    unsafe4 = unsafe3;
                                    bArr4 = bArr3;
                                    zzdsVar5 = zzdsVar4;
                                    obj4 = obj3;
                                    i26 = i37;
                                    i25 = i8;
                                    i23 = -1;
                                    break;
                                } else {
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i26 = i37;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                    break;
                                }
                            case 1:
                                bArr3 = bArr;
                                i11 = i10;
                                zzdsVar4 = zzdsVar;
                                obj3 = obj4;
                                unsafe3 = unsafe4;
                                i12 = i33;
                                i8 = i34;
                                if (i35 == 5) {
                                    zzhi.zzm(obj3, j2, Float.intBitsToFloat(zzdt.zzb(bArr3, i12)));
                                    i24 = i12 + 4;
                                    i27 |= i39;
                                    i22 = i3;
                                    unsafe4 = unsafe3;
                                    bArr4 = bArr3;
                                    zzdsVar5 = zzdsVar4;
                                    obj4 = obj3;
                                    i26 = i37;
                                    i25 = i8;
                                    i23 = -1;
                                    break;
                                } else {
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i26 = i37;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                    break;
                                }
                            case 2:
                            case 3:
                                bArr3 = bArr;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i12 = i33;
                                i8 = i34;
                                zzdsVar4 = zzdsVar;
                                if (i35 != 0) {
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i26 = i37;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                    break;
                                } else {
                                    int zzm = zzdt.zzm(bArr3, i12, zzdsVar4);
                                    unsafe2.putLong(obj, j2, zzdsVar4.zzb);
                                    obj3 = obj;
                                    i27 |= i39;
                                    i22 = i3;
                                    unsafe4 = unsafe2;
                                    i24 = zzm;
                                    bArr4 = bArr3;
                                    zzdsVar5 = zzdsVar4;
                                    obj4 = obj3;
                                    i26 = i37;
                                    i25 = i8;
                                    i23 = -1;
                                    break;
                                }
                            case 4:
                            case 11:
                                bArr2 = bArr;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i12 = i33;
                                i8 = i34;
                                zzdsVar2 = zzdsVar;
                                if (i35 != 0) {
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i26 = i37;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                    break;
                                } else {
                                    zzj = zzdt.zzj(bArr2, i12, zzdsVar2);
                                    unsafe2.putInt(obj4, j2, zzdsVar2.zza);
                                    i27 |= i39;
                                    i22 = i3;
                                    unsafe4 = unsafe2;
                                    zzdsVar5 = zzdsVar2;
                                    i26 = i37;
                                    i25 = i8;
                                    i23 = -1;
                                    i24 = zzj;
                                    bArr4 = bArr2;
                                    break;
                                }
                            case 5:
                            case 14:
                                bArr2 = bArr;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i8 = i34;
                                zzdsVar2 = zzdsVar;
                                if (i35 == 1) {
                                    Object obj5 = obj4;
                                    unsafe2.putLong(obj5, j2, zzdt.zzn(bArr2, i33));
                                    unsafe2 = unsafe2;
                                    obj4 = obj5;
                                    zzj = i33 + 8;
                                    i27 |= i39;
                                    i22 = i3;
                                    unsafe4 = unsafe2;
                                    zzdsVar5 = zzdsVar2;
                                    i26 = i37;
                                    i25 = i8;
                                    i23 = -1;
                                    i24 = zzj;
                                    bArr4 = bArr2;
                                    break;
                                } else {
                                    i12 = i33;
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i26 = i37;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                    break;
                                }
                            case 6:
                            case 13:
                                bArr2 = bArr;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i13 = i33;
                                i8 = i34;
                                zzdsVar2 = zzdsVar;
                                if (i35 != 5) {
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i26 = i37;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                    break;
                                } else {
                                    unsafe2.putInt(obj4, j2, zzdt.zzb(bArr2, i13));
                                    zzj = i13 + 4;
                                    i27 |= i39;
                                    i22 = i3;
                                    unsafe4 = unsafe2;
                                    zzdsVar5 = zzdsVar2;
                                    i26 = i37;
                                    i25 = i8;
                                    i23 = -1;
                                    i24 = zzj;
                                    bArr4 = bArr2;
                                    break;
                                }
                            case 7:
                                bArr2 = bArr;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i13 = i33;
                                i8 = i34;
                                zzdsVar2 = zzdsVar;
                                if (i35 == 0) {
                                    zzj = zzdt.zzm(bArr2, i13, zzdsVar2);
                                    i37 = i37;
                                    if (zzdsVar2.zzb != 0) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    zzhi.zzk(obj4, j2, z3);
                                    i27 |= i39;
                                    i22 = i3;
                                    unsafe4 = unsafe2;
                                    zzdsVar5 = zzdsVar2;
                                    i26 = i37;
                                    i25 = i8;
                                    i23 = -1;
                                    i24 = zzj;
                                    bArr4 = bArr2;
                                    break;
                                } else {
                                    i37 = i37;
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i26 = i37;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                    break;
                                }
                            case 8:
                                bArr2 = bArr;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i14 = i37;
                                i13 = i33;
                                i8 = i34;
                                zzdsVar3 = zzdsVar;
                                if (i35 != 2) {
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i37 = i14;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i26 = i37;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                    break;
                                } else {
                                    if ((536870912 & i36) == 0) {
                                        zzj = zzdt.zzg(bArr2, i13, zzdsVar3);
                                    } else {
                                        zzj = zzdt.zzh(bArr2, i13, zzdsVar3);
                                    }
                                    unsafe2.putObject(obj4, j2, zzdsVar3.zzc);
                                    i27 |= i39;
                                    i22 = i3;
                                    i26 = i14;
                                    zzdsVar5 = zzdsVar3;
                                    i25 = i8;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = zzj;
                                    bArr4 = bArr2;
                                    break;
                                }
                            case 9:
                                bArr2 = bArr;
                                i15 = i3;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i14 = i37;
                                i13 = i33;
                                i8 = i34;
                                zzdsVar3 = zzdsVar;
                                if (i35 != 2) {
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i37 = i14;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i26 = i37;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                    break;
                                } else {
                                    zzj = zzdt.zzd(zzfzVar2.zzy(i28), bArr2, i13, i15, zzdsVar3);
                                    if ((i27 & i39) == 0) {
                                        unsafe2.putObject(obj4, j2, zzdsVar3.zzc);
                                    } else {
                                        unsafe2.putObject(obj4, j2, zzez.zzg(unsafe2.getObject(obj4, j2), zzdsVar3.zzc));
                                    }
                                    i27 |= i39;
                                    i26 = i14;
                                    i22 = i15;
                                    zzdsVar5 = zzdsVar3;
                                    i25 = i8;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = zzj;
                                    bArr4 = bArr2;
                                    break;
                                }
                            case 10:
                                bArr2 = bArr;
                                i15 = i3;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i14 = i37;
                                i13 = i33;
                                i8 = i34;
                                zzdsVar3 = zzdsVar;
                                if (i35 == 2) {
                                    zzj = zzdt.zza(bArr2, i13, zzdsVar3);
                                    unsafe2.putObject(obj4, j2, zzdsVar3.zzc);
                                    i27 |= i39;
                                    i26 = i14;
                                    i22 = i15;
                                    zzdsVar5 = zzdsVar3;
                                    i25 = i8;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = zzj;
                                    bArr4 = bArr2;
                                    break;
                                } else {
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i37 = i14;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i26 = i37;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                    break;
                                }
                            case Code.UNIMPLEMENTED /* 12 */:
                                bArr2 = bArr;
                                i15 = i3;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i13 = i33;
                                i8 = i34;
                                zzdsVar3 = zzdsVar;
                                if (i35 != 0) {
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i26 = i37;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                    break;
                                } else {
                                    zzj = zzdt.zzj(bArr2, i13, zzdsVar3);
                                    int i41 = zzdsVar3.zza;
                                    zzex zzx = zzfzVar2.zzx(i28);
                                    if (zzx == null || zzx.zza()) {
                                        i14 = i37;
                                        unsafe2.putInt(obj4, j2, i41);
                                        i27 |= i39;
                                        i26 = i14;
                                        i22 = i15;
                                        zzdsVar5 = zzdsVar3;
                                        i25 = i8;
                                        i23 = -1;
                                        unsafe4 = unsafe2;
                                        i24 = zzj;
                                        bArr4 = bArr2;
                                        break;
                                    } else {
                                        i14 = i37;
                                        zzc(obj4).zzf(i14, Long.valueOf(i41));
                                        i26 = i14;
                                        i22 = i15;
                                        zzdsVar5 = zzdsVar3;
                                        i25 = i8;
                                        i23 = -1;
                                        unsafe4 = unsafe2;
                                        i24 = zzj;
                                        bArr4 = bArr2;
                                    }
                                }
                                break;
                            case 15:
                                bArr2 = bArr;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i13 = i33;
                                i8 = i34;
                                zzdsVar2 = zzdsVar;
                                if (i35 == 0) {
                                    zzj = zzdt.zzj(bArr2, i13, zzdsVar2);
                                    unsafe2.putInt(obj4, j2, zzei.zzb(zzdsVar2.zza));
                                    i27 |= i39;
                                    unsafe4 = unsafe2;
                                    i22 = i3;
                                    zzdsVar5 = zzdsVar2;
                                    i26 = i37;
                                    i25 = i8;
                                    i23 = -1;
                                    i24 = zzj;
                                    bArr4 = bArr2;
                                    break;
                                } else {
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i26 = i37;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                    break;
                                }
                            case 16:
                                i11 = i10;
                                i13 = i33;
                                i8 = i34;
                                if (i35 != 0) {
                                    obj3 = obj4;
                                    unsafe3 = unsafe4;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i26 = i37;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                    break;
                                } else {
                                    int zzm2 = zzdt.zzm(bArr, i13, zzdsVar);
                                    Object obj6 = obj4;
                                    Unsafe unsafe5 = unsafe4;
                                    unsafe5.putLong(obj6, j2, zzei.zzc(zzdsVar.zzb));
                                    obj4 = obj6;
                                    i27 |= i39;
                                    unsafe4 = unsafe5;
                                    i24 = zzm2;
                                    bArr4 = bArr;
                                    i22 = i3;
                                    zzdsVar5 = zzdsVar;
                                    i26 = i37;
                                    i25 = i8;
                                    i23 = -1;
                                    break;
                                }
                            default:
                                if (i35 == 3) {
                                    i8 = i34;
                                    zzj = zzdt.zzc(zzfzVar2.zzy(i28), bArr, i33, i3, (i34 << 3) | 4, zzdsVar);
                                    bArr2 = bArr;
                                    if ((i27 & i39) == 0) {
                                        unsafe4.putObject(obj4, j2, zzdsVar.zzc);
                                    } else {
                                        unsafe4.putObject(obj4, j2, zzez.zzg(unsafe4.getObject(obj4, j2), zzdsVar.zzc));
                                    }
                                    i27 |= i39;
                                    zzdsVar5 = zzdsVar;
                                    i22 = i3;
                                    i26 = i37;
                                    i25 = i8;
                                    i23 = -1;
                                    i24 = zzj;
                                    bArr4 = bArr2;
                                    break;
                                } else {
                                    i11 = i10;
                                    i13 = i33;
                                    i8 = i34;
                                    obj3 = obj4;
                                    unsafe3 = unsafe4;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i26 = i37;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                    break;
                                }
                        }
                    } else {
                        obj3 = obj4;
                        Unsafe unsafe6 = unsafe4;
                        i8 = i34;
                        if (zzu == 27) {
                            if (i35 == 2) {
                                zzey zzeyVar = (zzey) unsafe6.getObject(obj3, j2);
                                if (!zzeyVar.zzc()) {
                                    int size = zzeyVar.size();
                                    if (size == 0) {
                                        i21 = 10;
                                    } else {
                                        i21 = size + size;
                                    }
                                    zzeyVar = zzeyVar.zzd(i21);
                                    unsafe6.putObject(obj3, j2, zzeyVar);
                                }
                                unsafe4 = unsafe6;
                                int zze = zzdt.zze(zzfzVar2.zzy(i28), i37, bArr, i33, i3, zzeyVar, zzdsVar);
                                bArr4 = bArr;
                                i22 = i3;
                                zzdsVar5 = zzdsVar;
                                i24 = zze;
                                obj4 = obj3;
                                i26 = i37;
                                i25 = i8;
                                i23 = -1;
                            } else {
                                i16 = i33;
                                i17 = i29;
                                i18 = i27;
                                i19 = i28;
                                i20 = i37;
                                i6 = 1048575;
                                i9 = -1;
                                unsafe = unsafe6;
                            }
                        } else if (zzu <= 49) {
                            int i42 = i29;
                            i18 = i27;
                            i6 = 1048575;
                            i9 = -1;
                            unsafe = unsafe6;
                            int zzp = zzfzVar2.zzp(obj3, bArr, i33, i3, i37, i8, i35, i28, i36, zzu, j2, zzdsVar);
                            i19 = i28;
                            if (zzp != i33) {
                                zzfzVar2 = this;
                                obj4 = obj;
                                bArr4 = bArr;
                                i29 = i42;
                                i22 = i3;
                                i24 = zzp;
                                i26 = i37;
                                i28 = i19;
                                i27 = i18;
                                unsafe4 = unsafe;
                                i23 = i9;
                                i25 = i8;
                                zzdsVar5 = zzdsVar;
                            } else {
                                zzfzVar = this;
                                obj2 = obj;
                                i29 = i42;
                                i7 = zzp;
                                i26 = i37;
                                i28 = i19;
                                i27 = i18;
                                i5 = i4;
                            }
                        } else {
                            i16 = i33;
                            i17 = i29;
                            i18 = i27;
                            i19 = i28;
                            i6 = 1048575;
                            i9 = -1;
                            i20 = i37;
                            unsafe = unsafe6;
                            if (zzu == 50) {
                                if (i35 == 2) {
                                    int zzm3 = zzm(obj, bArr, i16, i3, i19, j2, zzdsVar);
                                    if (zzm3 != i16) {
                                        zzfzVar2 = this;
                                        obj4 = obj;
                                        bArr4 = bArr;
                                        i29 = i17;
                                        i22 = i3;
                                        zzdsVar5 = zzdsVar;
                                        i24 = zzm3;
                                        i26 = i20;
                                        i28 = i19;
                                        i27 = i18;
                                        unsafe4 = unsafe;
                                        i23 = -1;
                                        i25 = i8;
                                    } else {
                                        obj2 = obj;
                                        i29 = i17;
                                        i5 = i4;
                                        i7 = zzm3;
                                        i26 = i20;
                                        i28 = i19;
                                        i27 = i18;
                                        zzfzVar = this;
                                    }
                                }
                            } else {
                                i26 = i20;
                                int zzn = zzn(obj, bArr, i16, i3, i26, i8, i35, i36, zzu, j2, i19, zzdsVar);
                                obj2 = obj;
                                zzfzVar = this;
                                if (zzn != i16) {
                                    bArr4 = bArr;
                                    i29 = i17;
                                    i22 = i3;
                                    zzfzVar2 = zzfzVar;
                                    i24 = zzn;
                                    obj4 = obj2;
                                    i28 = i19;
                                    i27 = i18;
                                    unsafe4 = unsafe;
                                    i23 = i9;
                                    i25 = i8;
                                    zzdsVar5 = zzdsVar;
                                } else {
                                    i29 = i17;
                                    i7 = zzn;
                                    i28 = i19;
                                    i27 = i18;
                                    i5 = i4;
                                }
                            }
                        }
                        zzfzVar = this;
                        obj2 = obj;
                        i29 = i17;
                        i5 = i4;
                        i7 = i16;
                        i26 = i20;
                        i28 = i19;
                        i27 = i18;
                    }
                }
                if (i26 == i5 && i5 != 0) {
                    i22 = i3;
                    i24 = i7;
                } else {
                    int i43 = i26;
                    int zzi = zzdt.zzi(i43, bArr, i7, i3, zzc(obj2), zzdsVar);
                    i26 = i43;
                    zzdsVar5 = zzdsVar;
                    i22 = i3;
                    zzfzVar2 = zzfzVar;
                    obj4 = obj2;
                    unsafe4 = unsafe;
                    i23 = i9;
                    i25 = i8;
                    i24 = zzi;
                    bArr4 = bArr;
                }
            } else {
                i5 = i4;
                zzfzVar = zzfzVar2;
                unsafe = unsafe4;
                i6 = 1048575;
                obj2 = obj4;
            }
        }
        if (i29 != i6) {
            unsafe.putInt(obj2, i29, i27);
        }
        for (int i44 = zzfzVar.zzj; i44 < zzfzVar.zzk; i44++) {
            int i45 = zzfzVar.zzi[i44];
            int i46 = zzfzVar.zzc[i45];
            Object zzf = zzhi.zzf(obj2, zzfzVar.zzv(i45) & i6);
            if (zzf != null && zzfzVar.zzx(i45) != null) {
                throw null;
            }
        }
        if (i5 == 0) {
            if (i24 != i22) {
                throw zzfa.zzd();
            }
        } else if (i24 > i22 || i26 != i5) {
            throw zzfa.zzd();
        }
        return i24;
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final Object zzd() {
        return ((zzeu) this.zzg).zzi(4, null, null);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zze(Object obj) {
        int i;
        int i3 = this.zzj;
        while (true) {
            i = this.zzk;
            if (i3 >= i) {
                break;
            }
            long zzv = zzv(this.zzi[i3]) & 1048575;
            Object zzf = zzhi.zzf(obj, zzv);
            if (zzf != null) {
                ((zzfq) zzf).zzc();
                zzhi.zzp(obj, zzv, zzf);
            }
            i3++;
        }
        int length = this.zzi.length;
        while (i < length) {
            this.zzl.zza(obj, this.zzi[i]);
            i++;
        }
        this.zzm.zze(obj);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zzf(Object obj, Object obj2) {
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzv = zzv(i);
            long j2 = 1048575 & zzv;
            int i3 = this.zzc[i];
            switch (zzu(zzv)) {
                case 0:
                    if (zzG(obj2, i)) {
                        zzhi.zzl(obj, j2, zzhi.zza(obj2, j2));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzG(obj2, i)) {
                        zzhi.zzm(obj, j2, zzhi.zzb(obj2, j2));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j2, zzhi.zzd(obj2, j2));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j2, zzhi.zzd(obj2, j2));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j2, zzhi.zzc(obj2, j2));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j2, zzhi.zzd(obj2, j2));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j2, zzhi.zzc(obj2, j2));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzG(obj2, i)) {
                        zzhi.zzk(obj, j2, zzhi.zzt(obj2, j2));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzG(obj2, i)) {
                        zzhi.zzp(obj, j2, zzhi.zzf(obj2, j2));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzG(obj2, i)) {
                        zzhi.zzp(obj, j2, zzhi.zzf(obj2, j2));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j2, zzhi.zzc(obj2, j2));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case Code.UNIMPLEMENTED /* 12 */:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j2, zzhi.zzc(obj2, j2));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j2, zzhi.zzc(obj2, j2));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j2, zzhi.zzd(obj2, j2));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j2, zzhi.zzc(obj2, j2));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j2, zzhi.zzd(obj2, j2));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzB(obj, obj2, i);
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case Build.API_LEVELS.API_25 /* 25 */:
                case Build.API_LEVELS.API_26 /* 26 */:
                case Build.API_LEVELS.API_27 /* 27 */:
                case Build.API_LEVELS.API_28 /* 28 */:
                case Build.API_LEVELS.API_29 /* 29 */:
                case Build.API_LEVELS.API_30 /* 30 */:
                case Build.API_LEVELS.API_31 /* 31 */:
                case 32:
                case Build.API_LEVELS.API_33 /* 33 */:
                case Build.API_LEVELS.API_34 /* 34 */:
                case Build.API_LEVELS.API_35 /* 35 */:
                case Build.API_LEVELS.API_36 /* 36 */:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzl.zzb(obj, obj2, j2);
                    break;
                case 50:
                    zzgj.zzi(this.zzp, obj, obj2, j2);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzJ(obj2, i3, i)) {
                        zzhi.zzp(obj, j2, zzhi.zzf(obj2, j2));
                        zzE(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case 67:
                    if (zzJ(obj2, i3, i)) {
                        zzhi.zzp(obj, j2, zzhi.zzf(obj2, j2));
                        zzE(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
        }
        zzgj.zzf(this.zzm, obj, obj2);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zzg(Object obj, byte[] bArr, int i, int i3, zzds zzdsVar) {
        if (this.zzh) {
            zzo(obj, bArr, i, i3, zzdsVar);
        } else {
            zzb(obj, bArr, i, i3, 0, zzdsVar);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c0 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.auth.zzgh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzh(java.lang.Object r9, java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfz.zzh(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final boolean zzi(Object obj) {
        int i;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i5 < this.zzj) {
            int i7 = this.zzi[i5];
            int i8 = this.zzc[i7];
            int zzv = zzv(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i6 = zzb.getInt(obj, i10);
                }
                i3 = i6;
                i = i10;
            } else {
                i = i4;
                i3 = i6;
            }
            Object obj2 = obj;
            if ((268435456 & zzv) != 0 && !zzH(obj2, i7, i, i3, i11)) {
                return false;
            }
            int zzu = zzu(zzv);
            if (zzu != 9 && zzu != 17) {
                if (zzu != 27) {
                    if (zzu != 60 && zzu != 68) {
                        if (zzu != 49) {
                            if (zzu == 50 && !((zzfq) zzhi.zzf(obj2, zzv & 1048575)).isEmpty()) {
                                throw null;
                            }
                        }
                    } else if (zzJ(obj2, i8, i7) && !zzI(obj2, zzv, zzy(i7))) {
                        return false;
                    }
                }
                List list = (List) zzhi.zzf(obj2, zzv & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgh zzy = zzy(i7);
                    for (int i12 = 0; i12 < list.size(); i12++) {
                        if (!zzy.zzi(list.get(i12))) {
                            return false;
                        }
                    }
                }
            } else if (zzH(obj2, i7, i, i3, i11) && !zzI(obj2, zzv, zzy(i7))) {
                return false;
            }
            i5++;
            obj = obj2;
            i4 = i;
            i6 = i3;
        }
        return true;
    }
}
