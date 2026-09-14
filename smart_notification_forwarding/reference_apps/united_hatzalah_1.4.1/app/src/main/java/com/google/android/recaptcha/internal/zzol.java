package com.google.android.recaptcha.internal;

import F0.AbstractC0008a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.google.firebase.remoteconfig.internal.Code;
import io.flutter.Build;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.tika.pipes.PipesConfigBase;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzol<T> implements zzow<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzps.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzoi zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzpl zzm;
    private final zzmp zzn;

    private zzol(int[] iArr, Object[] objArr, int i, int i3, zzoi zzoiVar, boolean z3, int[] iArr2, int i4, int i5, zzoo zzooVar, zznv zznvVar, zzpl zzplVar, zzmp zzmpVar, zzod zzodVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i3;
        this.zzi = zzoiVar instanceof zznd;
        boolean z4 = false;
        if (zzmpVar != null && (zzoiVar instanceof zzna)) {
            z4 = true;
        }
        this.zzh = z4;
        this.zzj = iArr2;
        this.zzk = i4;
        this.zzl = i5;
        this.zzm = zzplVar;
        this.zzn = zzmpVar;
        this.zzg = zzoiVar;
    }

    private final Object zzA(Object obj, int i) {
        zzow zzx = zzx(i);
        int zzu = zzu(i) & 1048575;
        if (!zzN(obj, i)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, zzu);
        if (zzQ(object)) {
            return object;
        }
        Object zze = zzx.zze();
        if (object != null) {
            zzx.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzB(Object obj, int i, int i3) {
        zzow zzx = zzx(i3);
        if (!zzR(obj, i, i3)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, zzu(i3) & 1048575);
        if (zzQ(object)) {
            return object;
        }
        Object zze = zzx.zze();
        if (object != null) {
            zzx.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzC(Class cls, String str) {
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

    private static void zzD(Object obj) {
        if (zzQ(obj)) {
        } else {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzE(Object obj, Object obj2, int i) {
        if (!zzN(obj2, i)) {
            return;
        }
        int zzu = zzu(i) & 1048575;
        Unsafe unsafe = zzb;
        long j2 = zzu;
        Object object = unsafe.getObject(obj2, j2);
        if (object != null) {
            zzow zzx = zzx(i);
            if (!zzN(obj, i)) {
                if (!zzQ(object)) {
                    unsafe.putObject(obj, j2, object);
                } else {
                    Object zze = zzx.zze();
                    zzx.zzg(zze, object);
                    unsafe.putObject(obj, j2, zze);
                }
                zzH(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j2);
            if (!zzQ(object2)) {
                Object zze2 = zzx.zze();
                zzx.zzg(zze2, object2);
                unsafe.putObject(obj, j2, zze2);
                object2 = zze2;
            }
            zzx.zzg(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
    }

    private final void zzF(Object obj, Object obj2, int i) {
        int i3 = this.zzc[i];
        if (!zzR(obj2, i3, i)) {
            return;
        }
        int zzu = zzu(i) & 1048575;
        Unsafe unsafe = zzb;
        long j2 = zzu;
        Object object = unsafe.getObject(obj2, j2);
        if (object != null) {
            zzow zzx = zzx(i);
            if (!zzR(obj, i3, i)) {
                if (!zzQ(object)) {
                    unsafe.putObject(obj, j2, object);
                } else {
                    Object zze = zzx.zze();
                    zzx.zzg(zze, object);
                    unsafe.putObject(obj, j2, zze);
                }
                zzI(obj, i3, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j2);
            if (!zzQ(object2)) {
                Object zze2 = zzx.zze();
                zzx.zzg(zze2, object2);
                unsafe.putObject(obj, j2, zze2);
                object2 = zze2;
            }
            zzx.zzg(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
    }

    private final void zzG(Object obj, int i, zzov zzovVar) {
        long j2 = i & 1048575;
        if (zzM(i)) {
            zzps.zzs(obj, j2, zzovVar.zzs());
        } else if (this.zzi) {
            zzps.zzs(obj, j2, zzovVar.zzr());
        } else {
            zzps.zzs(obj, j2, zzovVar.zzp());
        }
    }

    private final void zzH(Object obj, int i) {
        int zzr = zzr(i);
        long j2 = 1048575 & zzr;
        if (j2 == 1048575) {
            return;
        }
        zzps.zzq(obj, j2, (1 << (zzr >>> 20)) | zzps.zzc(obj, j2));
    }

    private final void zzI(Object obj, int i, int i3) {
        zzps.zzq(obj, zzr(i3) & 1048575, i);
    }

    private final void zzJ(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzu(i) & 1048575, obj2);
        zzH(obj, i);
    }

    private final void zzK(Object obj, int i, int i3, Object obj2) {
        zzb.putObject(obj, zzu(i3) & 1048575, obj2);
        zzI(obj, i, i3);
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        if (zzN(obj, i) == zzN(obj2, i)) {
            return true;
        }
        return false;
    }

    private static boolean zzM(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzN(Object obj, int i) {
        int zzr = zzr(i);
        long j2 = zzr & 1048575;
        if (j2 == 1048575) {
            int zzu = zzu(i);
            long j3 = zzu & 1048575;
            switch (zzt(zzu)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzps.zza(obj, j3)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(zzps.zzb(obj, j3)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (zzps.zzd(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (zzps.zzd(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (zzps.zzc(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (zzps.zzd(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (zzps.zzc(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return zzps.zzw(obj, j3);
                case 8:
                    Object zzf = zzps.zzf(obj, j3);
                    if (zzf instanceof String) {
                        if (((String) zzf).isEmpty()) {
                            return false;
                        }
                        return true;
                    }
                    if (zzf instanceof zzle) {
                        if (zzle.zzb.equals(zzf)) {
                            return false;
                        }
                        return true;
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (zzps.zzf(obj, j3) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (zzle.zzb.equals(zzps.zzf(obj, j3))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (zzps.zzc(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case Code.UNIMPLEMENTED /* 12 */:
                    if (zzps.zzc(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (zzps.zzc(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (zzps.zzd(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (zzps.zzc(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (zzps.zzd(obj, j3) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (zzps.zzf(obj, j3) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((zzps.zzc(obj, j2) & (1 << (zzr >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    private final boolean zzO(Object obj, int i, int i3, int i4, int i5) {
        if (i3 == 1048575) {
            return zzN(obj, i);
        }
        if ((i4 & i5) != 0) {
            return true;
        }
        return false;
    }

    private static boolean zzP(Object obj, int i, zzow zzowVar) {
        return zzowVar.zzl(zzps.zzf(obj, i & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zznd) {
            return ((zznd) obj).zzL();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i, int i3) {
        if (zzps.zzc(obj, zzr(i3) & 1048575) == i) {
            return true;
        }
        return false;
    }

    private static boolean zzS(Object obj, long j2) {
        return ((Boolean) zzps.zzf(obj, j2)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zzpy zzpyVar) {
        if (obj instanceof String) {
            zzpyVar.zzG(i, (String) obj);
        } else {
            zzpyVar.zzd(i, (zzle) obj);
        }
    }

    public static zzpm zzd(Object obj) {
        zznd zzndVar = (zznd) obj;
        zzpm zzpmVar = zzndVar.zzc;
        if (zzpmVar == zzpm.zzc()) {
            zzpm zzf = zzpm.zzf();
            zzndVar.zzc = zzf;
            return zzf;
        }
        return zzpmVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0274  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.recaptcha.internal.zzol zzm(java.lang.Class r31, com.google.android.recaptcha.internal.zzof r32, com.google.android.recaptcha.internal.zzoo r33, com.google.android.recaptcha.internal.zznv r34, com.google.android.recaptcha.internal.zzpl r35, com.google.android.recaptcha.internal.zzmp r36, com.google.android.recaptcha.internal.zzod r37) {
        /*
            Method dump skipped, instructions count: 1043
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzol.zzm(java.lang.Class, com.google.android.recaptcha.internal.zzof, com.google.android.recaptcha.internal.zzoo, com.google.android.recaptcha.internal.zznv, com.google.android.recaptcha.internal.zzpl, com.google.android.recaptcha.internal.zzmp, com.google.android.recaptcha.internal.zzod):com.google.android.recaptcha.internal.zzol");
    }

    private static double zzn(Object obj, long j2) {
        return ((Double) zzps.zzf(obj, j2)).doubleValue();
    }

    private static float zzo(Object obj, long j2) {
        return ((Float) zzps.zzf(obj, j2)).floatValue();
    }

    private static int zzp(Object obj, long j2) {
        return ((Integer) zzps.zzf(obj, j2)).intValue();
    }

    private final int zzq(int i) {
        if (i >= this.zze && i <= this.zzf) {
            return zzs(i, 0);
        }
        return -1;
    }

    private final int zzr(int i) {
        return this.zzc[i + 2];
    }

    private final int zzs(int i, int i3) {
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

    private static int zzt(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzu(int i) {
        return this.zzc[i + 1];
    }

    private static long zzv(Object obj, long j2) {
        return ((Long) zzps.zzf(obj, j2)).longValue();
    }

    private final zznh zzw(int i) {
        int i3 = i / 3;
        return (zznh) this.zzd[i3 + i3 + 1];
    }

    private final zzow zzx(int i) {
        Object[] objArr = this.zzd;
        int i3 = i / 3;
        int i4 = i3 + i3;
        zzow zzowVar = (zzow) objArr[i4];
        if (zzowVar != null) {
            return zzowVar;
        }
        zzow zzb2 = zzos.zza().zzb((Class) objArr[i4 + 1]);
        this.zzd[i4] = zzb2;
        return zzb2;
    }

    private final Object zzy(Object obj, int i, Object obj2, zzpl zzplVar, Object obj3) {
        int i3 = this.zzc[i];
        Object zzf = zzps.zzf(obj, zzu(i) & 1048575);
        if (zzf == null || zzw(i) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzz(int i) {
        int i3 = i / 3;
        return this.zzd[i3 + i3];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0050. Please report as an issue. */
    @Override // com.google.android.recaptcha.internal.zzow
    public final int zza(Object obj) {
        int i;
        int zzA;
        int zzB;
        int zzA2;
        int zzd;
        int zzA3;
        int zzh;
        int zzA4;
        int size;
        int zzl;
        int zzA5;
        int zzd2;
        boolean z3;
        int zzb2;
        int i3;
        int zzA6;
        int zzA7;
        int size2;
        int zzk;
        int zzA8;
        int size3;
        int zzi;
        int zzA9;
        int i4;
        int zze;
        int zzA10;
        int zzA11;
        int zzA12;
        int zzB2;
        zzol<T> zzolVar = this;
        Object obj2 = obj;
        Unsafe unsafe = zzb;
        int i5 = 1048575;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < zzolVar.zzc.length) {
            int zzu = zzolVar.zzu(i7);
            int zzt = zzt(zzu);
            int[] iArr = zzolVar.zzc;
            int i10 = iArr[i7];
            int i11 = iArr[i7 + 2];
            int i12 = i11 & i5;
            if (zzt <= 17) {
                if (i12 != i6) {
                    if (i12 == i5) {
                        i8 = 0;
                    } else {
                        i8 = unsafe.getInt(obj2, i12);
                    }
                    i6 = i12;
                }
                i = 1 << (i11 >>> 20);
            } else {
                i = 0;
            }
            int i13 = zzu & i5;
            if (zzt >= zzmu.zzJ.zza()) {
                zzmu.zzW.zza();
            }
            long j2 = i13;
            switch (zzt) {
                case 0:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        i9 = AbstractC0008a.d(i10 << 3, 8, i9);
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 1:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        i9 = AbstractC0008a.d(i10 << 3, 4, i9);
                    }
                    zzolVar = this;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 2:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        long j3 = unsafe.getLong(obj2, j2);
                        zzA = zzln.zzA(i10 << 3);
                        zzB = zzln.zzB(j3);
                        i9 += zzB + zzA;
                    }
                    zzolVar = this;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 3:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        long j4 = unsafe.getLong(obj2, j2);
                        zzA = zzln.zzA(i10 << 3);
                        zzB = zzln.zzB(j4);
                        i9 += zzB + zzA;
                    }
                    zzolVar = this;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 4:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        long j5 = unsafe.getInt(obj2, j2);
                        zzA = zzln.zzA(i10 << 3);
                        zzB = zzln.zzB(j5);
                        i9 += zzB + zzA;
                    }
                    zzolVar = this;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 5:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        i9 = AbstractC0008a.d(i10 << 3, 8, i9);
                    }
                    zzolVar = this;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 6:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        i9 = AbstractC0008a.d(i10 << 3, 4, i9);
                    }
                    zzolVar = this;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 7:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        i9 = AbstractC0008a.d(i10 << 3, 1, i9);
                    }
                    zzolVar = this;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 8:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        int i14 = i10 << 3;
                        Object object = unsafe.getObject(obj2, j2);
                        if (object instanceof zzle) {
                            zzA2 = zzln.zzA(i14);
                            zzd = ((zzle) object).zzd();
                            zzA3 = zzln.zzA(zzd);
                            i9 += zzA3 + zzd + zzA2;
                        } else {
                            zzA = zzln.zzA(i14);
                            zzB = zzln.zzz((String) object);
                            i9 += zzB + zzA;
                        }
                    }
                    zzolVar = this;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 9:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        zzh = zzoy.zzh(i10, unsafe.getObject(obj2, j2), zzolVar.zzx(i7));
                        i9 += zzh;
                        i7 += 3;
                        obj2 = obj;
                        i5 = 1048575;
                    } else {
                        i7 += 3;
                        obj2 = obj;
                        i5 = 1048575;
                    }
                case 10:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        zzle zzleVar = (zzle) unsafe.getObject(obj2, j2);
                        zzA2 = zzln.zzA(i10 << 3);
                        zzd = zzleVar.zzd();
                        zzA3 = zzln.zzA(zzd);
                        i9 += zzA3 + zzd + zzA2;
                    }
                    zzolVar = this;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 11:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        i9 = AbstractC0008a.d(unsafe.getInt(obj2, j2), zzln.zzA(i10 << 3), i9);
                    }
                    zzolVar = this;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case Code.UNIMPLEMENTED /* 12 */:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        long j6 = unsafe.getInt(obj2, j2);
                        zzA = zzln.zzA(i10 << 3);
                        zzB = zzln.zzB(j6);
                        i9 += zzB + zzA;
                    }
                    zzolVar = this;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 13:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        i9 = AbstractC0008a.d(i10 << 3, 4, i9);
                    }
                    zzolVar = this;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 14:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        i9 = AbstractC0008a.d(i10 << 3, 8, i9);
                    }
                    zzolVar = this;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 15:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        int i15 = unsafe.getInt(obj2, j2);
                        i9 = AbstractC0008a.d((i15 >> 31) ^ (i15 + i15), zzln.zzA(i10 << 3), i9);
                    }
                    zzolVar = this;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 16:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        long j7 = unsafe.getLong(obj2, j2);
                        zzA = zzln.zzA(i10 << 3);
                        zzB = zzln.zzB((j7 >> 63) ^ (j7 + j7));
                        i9 += zzB + zzA;
                    }
                    zzolVar = this;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 17:
                    if (zzolVar.zzO(obj2, i7, i6, i8, i)) {
                        i9 += zzln.zzw(i10, (zzoi) unsafe.getObject(obj2, j2), zzolVar.zzx(i7));
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    zzh = zzoy.zzd(i10, (List) unsafe.getObject(obj2, j2), false);
                    i9 += zzh;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 19:
                    zzh = zzoy.zzb(i10, (List) unsafe.getObject(obj2, j2), false);
                    i9 += zzh;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 20:
                    List list = (List) unsafe.getObject(obj2, j2);
                    int i16 = zzoy.zza;
                    if (list.size() != 0) {
                        zzA4 = (zzln.zzA(i10 << 3) * list.size()) + zzoy.zzg(list);
                        i9 += zzA4;
                        i7 += 3;
                        obj2 = obj;
                        i5 = 1048575;
                    }
                    zzA4 = 0;
                    i9 += zzA4;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 21:
                    List list2 = (List) unsafe.getObject(obj2, j2);
                    int i17 = zzoy.zza;
                    size = list2.size();
                    if (size != 0) {
                        zzl = zzoy.zzl(list2);
                        zzA5 = zzln.zzA(i10 << 3);
                        zzA4 = (zzA5 * size) + zzl;
                        i9 += zzA4;
                        i7 += 3;
                        obj2 = obj;
                        i5 = 1048575;
                    }
                    zzA4 = 0;
                    i9 += zzA4;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 22:
                    List list3 = (List) unsafe.getObject(obj2, j2);
                    int i18 = zzoy.zza;
                    size = list3.size();
                    if (size != 0) {
                        zzl = zzoy.zzf(list3);
                        zzA5 = zzln.zzA(i10 << 3);
                        zzA4 = (zzA5 * size) + zzl;
                        i9 += zzA4;
                        i7 += 3;
                        obj2 = obj;
                        i5 = 1048575;
                    }
                    zzA4 = 0;
                    i9 += zzA4;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 23:
                    zzd2 = zzoy.zzd(i10, (List) unsafe.getObject(obj2, j2), false);
                    i9 += zzd2;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 24:
                    z3 = false;
                    zzb2 = zzoy.zzb(i10, (List) unsafe.getObject(obj2, j2), false);
                    i9 += zzb2;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case Build.API_LEVELS.API_25 /* 25 */:
                    List list4 = (List) unsafe.getObject(obj2, j2);
                    int i19 = zzoy.zza;
                    int size4 = list4.size();
                    if (size4 != 0) {
                        zzd2 = size4 * (zzln.zzA(i10 << 3) + 1);
                        i9 += zzd2;
                        i7 += 3;
                        obj2 = obj;
                        i5 = 1048575;
                    }
                    zzd2 = 0;
                    i9 += zzd2;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case Build.API_LEVELS.API_26 /* 26 */:
                    List list5 = (List) unsafe.getObject(obj2, j2);
                    int i20 = zzoy.zza;
                    int size5 = list5.size();
                    if (size5 == 0) {
                        i3 = 0;
                    } else {
                        int zzA13 = zzln.zzA(i10 << 3) * size5;
                        if (list5 instanceof zznu) {
                            zznu zznuVar = (zznu) list5;
                            i3 = zzA13;
                            for (int i21 = 0; i21 < size5; i21++) {
                                Object zzc = zznuVar.zzc();
                                if (zzc instanceof zzle) {
                                    int zzd3 = ((zzle) zzc).zzd();
                                    i3 = AbstractC0008a.d(zzd3, zzd3, i3);
                                } else {
                                    i3 = zzln.zzz((String) zzc) + i3;
                                }
                            }
                        } else {
                            i3 = zzA13;
                            for (int i22 = 0; i22 < size5; i22++) {
                                Object obj3 = list5.get(i22);
                                if (obj3 instanceof zzle) {
                                    int zzd4 = ((zzle) obj3).zzd();
                                    i3 = AbstractC0008a.d(zzd4, zzd4, i3);
                                } else {
                                    i3 = zzln.zzz((String) obj3) + i3;
                                }
                            }
                        }
                    }
                    i9 += i3;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case Build.API_LEVELS.API_27 /* 27 */:
                    List list6 = (List) unsafe.getObject(obj2, j2);
                    zzow zzx = zzolVar.zzx(i7);
                    int i23 = zzoy.zza;
                    int size6 = list6.size();
                    if (size6 == 0) {
                        zzA6 = 0;
                    } else {
                        zzA6 = zzln.zzA(i10 << 3) * size6;
                        for (int i24 = 0; i24 < size6; i24++) {
                            Object obj4 = list6.get(i24);
                            if (obj4 instanceof zznt) {
                                int zza2 = ((zznt) obj4).zza();
                                zzA6 = AbstractC0008a.d(zza2, zza2, zzA6);
                            } else {
                                zzA6 = zzln.zzy((zzoi) obj4, zzx) + zzA6;
                            }
                        }
                    }
                    i9 += zzA6;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case Build.API_LEVELS.API_28 /* 28 */:
                    List list7 = (List) unsafe.getObject(obj2, j2);
                    int i25 = zzoy.zza;
                    int size7 = list7.size();
                    if (size7 == 0) {
                        zzA7 = 0;
                    } else {
                        zzA7 = zzln.zzA(i10 << 3) * size7;
                        for (int i26 = 0; i26 < list7.size(); i26++) {
                            int zzd5 = ((zzle) list7.get(i26)).zzd();
                            zzA7 = AbstractC0008a.d(zzd5, zzd5, zzA7);
                        }
                    }
                    i9 += zzA7;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case Build.API_LEVELS.API_29 /* 29 */:
                    List list8 = (List) unsafe.getObject(obj2, j2);
                    int i27 = zzoy.zza;
                    size2 = list8.size();
                    if (size2 != 0) {
                        zzk = zzoy.zzk(list8);
                        zzA8 = zzln.zzA(i10 << 3);
                        zzd2 = zzk + (zzA8 * size2);
                        i9 += zzd2;
                        i7 += 3;
                        obj2 = obj;
                        i5 = 1048575;
                    }
                    zzd2 = 0;
                    i9 += zzd2;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case Build.API_LEVELS.API_30 /* 30 */:
                    List list9 = (List) unsafe.getObject(obj2, j2);
                    int i28 = zzoy.zza;
                    size2 = list9.size();
                    if (size2 != 0) {
                        zzk = zzoy.zza(list9);
                        zzA8 = zzln.zzA(i10 << 3);
                        zzd2 = zzk + (zzA8 * size2);
                        i9 += zzd2;
                        i7 += 3;
                        obj2 = obj;
                        i5 = 1048575;
                    }
                    zzd2 = 0;
                    i9 += zzd2;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case Build.API_LEVELS.API_31 /* 31 */:
                    zzd2 = zzoy.zzb(i10, (List) unsafe.getObject(obj2, j2), false);
                    i9 += zzd2;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 32:
                    z3 = false;
                    zzb2 = zzoy.zzd(i10, (List) unsafe.getObject(obj2, j2), false);
                    i9 += zzb2;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case Build.API_LEVELS.API_33 /* 33 */:
                    List list10 = (List) unsafe.getObject(obj2, j2);
                    int i29 = zzoy.zza;
                    size3 = list10.size();
                    if (size3 != 0) {
                        zzi = zzoy.zzi(list10);
                        zzA9 = zzln.zzA(i10 << 3);
                        i4 = (zzA9 * size3) + zzi;
                        i9 += i4;
                        i7 += 3;
                        obj2 = obj;
                        i5 = 1048575;
                    }
                    i4 = 0;
                    i9 += i4;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case Build.API_LEVELS.API_34 /* 34 */:
                    List list11 = (List) unsafe.getObject(obj2, j2);
                    int i30 = zzoy.zza;
                    size3 = list11.size();
                    if (size3 != 0) {
                        zzi = zzoy.zzj(list11);
                        zzA9 = zzln.zzA(i10 << 3);
                        i4 = (zzA9 * size3) + zzi;
                        i9 += i4;
                        i7 += 3;
                        obj2 = obj;
                        i5 = 1048575;
                    }
                    i4 = 0;
                    i9 += i4;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case Build.API_LEVELS.API_35 /* 35 */:
                    zze = zzoy.zze((List) unsafe.getObject(obj2, j2));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i10 << 3);
                        zzA11 = zzln.zzA(zze);
                        i9 += zzA11 + zzA10 + zze;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case Build.API_LEVELS.API_36 /* 36 */:
                    zze = zzoy.zzc((List) unsafe.getObject(obj2, j2));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i10 << 3);
                        zzA11 = zzln.zzA(zze);
                        i9 += zzA11 + zzA10 + zze;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 37:
                    zze = zzoy.zzg((List) unsafe.getObject(obj2, j2));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i10 << 3);
                        zzA11 = zzln.zzA(zze);
                        i9 += zzA11 + zzA10 + zze;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 38:
                    zze = zzoy.zzl((List) unsafe.getObject(obj2, j2));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i10 << 3);
                        zzA11 = zzln.zzA(zze);
                        i9 += zzA11 + zzA10 + zze;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 39:
                    zze = zzoy.zzf((List) unsafe.getObject(obj2, j2));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i10 << 3);
                        zzA11 = zzln.zzA(zze);
                        i9 += zzA11 + zzA10 + zze;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 40:
                    zze = zzoy.zze((List) unsafe.getObject(obj2, j2));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i10 << 3);
                        zzA11 = zzln.zzA(zze);
                        i9 += zzA11 + zzA10 + zze;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 41:
                    zze = zzoy.zzc((List) unsafe.getObject(obj2, j2));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i10 << 3);
                        zzA11 = zzln.zzA(zze);
                        i9 += zzA11 + zzA10 + zze;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 42:
                    List list12 = (List) unsafe.getObject(obj2, j2);
                    int i31 = zzoy.zza;
                    zze = list12.size();
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i10 << 3);
                        zzA11 = zzln.zzA(zze);
                        i9 += zzA11 + zzA10 + zze;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 43:
                    zze = zzoy.zzk((List) unsafe.getObject(obj2, j2));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i10 << 3);
                        zzA11 = zzln.zzA(zze);
                        i9 += zzA11 + zzA10 + zze;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 44:
                    zze = zzoy.zza((List) unsafe.getObject(obj2, j2));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i10 << 3);
                        zzA11 = zzln.zzA(zze);
                        i9 += zzA11 + zzA10 + zze;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 45:
                    zze = zzoy.zzc((List) unsafe.getObject(obj2, j2));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i10 << 3);
                        zzA11 = zzln.zzA(zze);
                        i9 += zzA11 + zzA10 + zze;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 46:
                    zze = zzoy.zze((List) unsafe.getObject(obj2, j2));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i10 << 3);
                        zzA11 = zzln.zzA(zze);
                        i9 += zzA11 + zzA10 + zze;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 47:
                    zze = zzoy.zzi((List) unsafe.getObject(obj2, j2));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i10 << 3);
                        zzA11 = zzln.zzA(zze);
                        i9 += zzA11 + zzA10 + zze;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 48:
                    zze = zzoy.zzj((List) unsafe.getObject(obj2, j2));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i10 << 3);
                        zzA11 = zzln.zzA(zze);
                        i9 += zzA11 + zzA10 + zze;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 49:
                    List list13 = (List) unsafe.getObject(obj2, j2);
                    zzow zzx2 = zzolVar.zzx(i7);
                    int i32 = zzoy.zza;
                    int size8 = list13.size();
                    if (size8 != 0) {
                        int i33 = 0;
                        for (int i34 = 0; i34 < size8; i34++) {
                            i33 += zzln.zzw(i10, (zzoi) list13.get(i34), zzx2);
                        }
                        i4 = i33;
                        i9 += i4;
                        i7 += 3;
                        obj2 = obj;
                        i5 = 1048575;
                    }
                    i4 = 0;
                    i9 += i4;
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 50:
                    zzoc zzocVar = (zzoc) unsafe.getObject(obj2, j2);
                    if (!zzocVar.isEmpty()) {
                        Iterator it = zzocVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 51:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        i9 = AbstractC0008a.d(i10 << 3, 8, i9);
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 52:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        i9 = AbstractC0008a.d(i10 << 3, 4, i9);
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 53:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        long zzv = zzv(obj2, j2);
                        zzA12 = zzln.zzA(i10 << 3);
                        zzB2 = zzln.zzB(zzv);
                        i9 += zzB2 + zzA12;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 54:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        long zzv2 = zzv(obj2, j2);
                        zzA12 = zzln.zzA(i10 << 3);
                        zzB2 = zzln.zzB(zzv2);
                        i9 += zzB2 + zzA12;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 55:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        long zzp = zzp(obj2, j2);
                        zzA12 = zzln.zzA(i10 << 3);
                        zzB2 = zzln.zzB(zzp);
                        i9 += zzB2 + zzA12;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 56:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        i9 = AbstractC0008a.d(i10 << 3, 8, i9);
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 57:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        i9 = AbstractC0008a.d(i10 << 3, 4, i9);
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 58:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        i9 = AbstractC0008a.d(i10 << 3, 1, i9);
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 59:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        int i35 = i10 << 3;
                        Object object2 = unsafe.getObject(obj2, j2);
                        if (object2 instanceof zzle) {
                            zze = zzln.zzA(i35);
                            zzA10 = ((zzle) object2).zzd();
                            zzA11 = zzln.zzA(zzA10);
                            i9 += zzA11 + zzA10 + zze;
                        } else {
                            zzA12 = zzln.zzA(i35);
                            zzB2 = zzln.zzz((String) object2);
                            i9 += zzB2 + zzA12;
                        }
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        zzd2 = zzoy.zzh(i10, unsafe.getObject(obj2, j2), zzolVar.zzx(i7));
                        i9 += zzd2;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 61:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        zzle zzleVar2 = (zzle) unsafe.getObject(obj2, j2);
                        zze = zzln.zzA(i10 << 3);
                        zzA10 = zzleVar2.zzd();
                        zzA11 = zzln.zzA(zzA10);
                        i9 += zzA11 + zzA10 + zze;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 62:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        i9 = AbstractC0008a.d(zzp(obj2, j2), zzln.zzA(i10 << 3), i9);
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 63:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        long zzp2 = zzp(obj2, j2);
                        zzA12 = zzln.zzA(i10 << 3);
                        zzB2 = zzln.zzB(zzp2);
                        i9 += zzB2 + zzA12;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 64:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        i9 = AbstractC0008a.d(i10 << 3, 4, i9);
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        i9 = AbstractC0008a.d(i10 << 3, 8, i9);
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 66:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        int zzp3 = zzp(obj2, j2);
                        i9 = AbstractC0008a.d((zzp3 >> 31) ^ (zzp3 + zzp3), zzln.zzA(i10 << 3), i9);
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 67:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        long zzv3 = zzv(obj2, j2);
                        zzA12 = zzln.zzA(i10 << 3);
                        zzB2 = zzln.zzB((zzv3 >> 63) ^ (zzv3 + zzv3));
                        i9 += zzB2 + zzA12;
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                case 68:
                    if (zzolVar.zzR(obj2, i10, i7)) {
                        i9 += zzln.zzw(i10, (zzoi) unsafe.getObject(obj2, j2), zzolVar.zzx(i7));
                    }
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
                default:
                    i7 += 3;
                    obj2 = obj;
                    i5 = 1048575;
            }
        }
        int i36 = 0;
        int zza3 = ((zznd) obj).zzc.zza() + i9;
        if (zzolVar.zzh) {
            zzmt zzmtVar = ((zzna) obj).zzb;
            int zzc2 = zzmtVar.zza.zzc();
            for (int i37 = 0; i37 < zzc2; i37++) {
                Map.Entry zzg = zzmtVar.zza.zzg(i37);
                i36 += zzmt.zza((zzms) ((zzpa) zzg).zza(), zzg.getValue());
            }
            for (Map.Entry entry2 : zzmtVar.zza.zzd()) {
                i36 += zzmt.zza((zzms) entry2.getKey(), entry2.getValue());
            }
            return zza3 + i36;
        }
        return zza3;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001c. Please report as an issue. */
    @Override // com.google.android.recaptcha.internal.zzow
    public final int zzb(Object obj) {
        int i;
        long doubleToLongBits;
        int i3;
        int floatToIntBits;
        int zzc;
        int i4;
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzc.length; i6 += 3) {
            int zzu = zzu(i6);
            int[] iArr = this.zzc;
            int i7 = 1048575 & zzu;
            int zzt = zzt(zzu);
            int i8 = iArr[i6];
            long j2 = i7;
            int i9 = 37;
            switch (zzt) {
                case 0:
                    i = i5 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzps.zza(obj, j2));
                    byte[] bArr = zznl.zzb;
                    zzc = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i5 = i + zzc;
                    break;
                case 1:
                    i3 = i5 * 53;
                    floatToIntBits = Float.floatToIntBits(zzps.zzb(obj, j2));
                    i5 = floatToIntBits + i3;
                    break;
                case 2:
                    i = i5 * 53;
                    doubleToLongBits = zzps.zzd(obj, j2);
                    byte[] bArr2 = zznl.zzb;
                    zzc = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i5 = i + zzc;
                    break;
                case 3:
                    i = i5 * 53;
                    doubleToLongBits = zzps.zzd(obj, j2);
                    byte[] bArr3 = zznl.zzb;
                    zzc = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i5 = i + zzc;
                    break;
                case 4:
                    i = i5 * 53;
                    zzc = zzps.zzc(obj, j2);
                    i5 = i + zzc;
                    break;
                case 5:
                    i = i5 * 53;
                    doubleToLongBits = zzps.zzd(obj, j2);
                    byte[] bArr4 = zznl.zzb;
                    zzc = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i5 = i + zzc;
                    break;
                case 6:
                    i = i5 * 53;
                    zzc = zzps.zzc(obj, j2);
                    i5 = i + zzc;
                    break;
                case 7:
                    i3 = i5 * 53;
                    floatToIntBits = zznl.zza(zzps.zzw(obj, j2));
                    i5 = floatToIntBits + i3;
                    break;
                case 8:
                    i3 = i5 * 53;
                    floatToIntBits = ((String) zzps.zzf(obj, j2)).hashCode();
                    i5 = floatToIntBits + i3;
                    break;
                case 9:
                    i4 = i5 * 53;
                    Object zzf = zzps.zzf(obj, j2);
                    if (zzf != null) {
                        i9 = zzf.hashCode();
                    }
                    i5 = i4 + i9;
                    break;
                case 10:
                    i3 = i5 * 53;
                    floatToIntBits = zzps.zzf(obj, j2).hashCode();
                    i5 = floatToIntBits + i3;
                    break;
                case 11:
                    i = i5 * 53;
                    zzc = zzps.zzc(obj, j2);
                    i5 = i + zzc;
                    break;
                case Code.UNIMPLEMENTED /* 12 */:
                    i = i5 * 53;
                    zzc = zzps.zzc(obj, j2);
                    i5 = i + zzc;
                    break;
                case 13:
                    i = i5 * 53;
                    zzc = zzps.zzc(obj, j2);
                    i5 = i + zzc;
                    break;
                case 14:
                    i = i5 * 53;
                    doubleToLongBits = zzps.zzd(obj, j2);
                    byte[] bArr5 = zznl.zzb;
                    zzc = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i5 = i + zzc;
                    break;
                case 15:
                    i = i5 * 53;
                    zzc = zzps.zzc(obj, j2);
                    i5 = i + zzc;
                    break;
                case 16:
                    i = i5 * 53;
                    doubleToLongBits = zzps.zzd(obj, j2);
                    byte[] bArr6 = zznl.zzb;
                    zzc = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i5 = i + zzc;
                    break;
                case 17:
                    i4 = i5 * 53;
                    Object zzf2 = zzps.zzf(obj, j2);
                    if (zzf2 != null) {
                        i9 = zzf2.hashCode();
                    }
                    i5 = i4 + i9;
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
                    i3 = i5 * 53;
                    floatToIntBits = zzps.zzf(obj, j2).hashCode();
                    i5 = floatToIntBits + i3;
                    break;
                case 50:
                    i3 = i5 * 53;
                    floatToIntBits = zzps.zzf(obj, j2).hashCode();
                    i5 = floatToIntBits + i3;
                    break;
                case 51:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzn(obj, j2));
                        byte[] bArr7 = zznl.zzb;
                        zzc = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i5 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        floatToIntBits = Float.floatToIntBits(zzo(obj, j2));
                        i5 = floatToIntBits + i3;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        doubleToLongBits = zzv(obj, j2);
                        byte[] bArr8 = zznl.zzb;
                        zzc = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i5 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        doubleToLongBits = zzv(obj, j2);
                        byte[] bArr9 = zznl.zzb;
                        zzc = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i5 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        zzc = zzp(obj, j2);
                        i5 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        doubleToLongBits = zzv(obj, j2);
                        byte[] bArr10 = zznl.zzb;
                        zzc = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i5 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        zzc = zzp(obj, j2);
                        i5 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        floatToIntBits = zznl.zza(zzS(obj, j2));
                        i5 = floatToIntBits + i3;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        floatToIntBits = ((String) zzps.zzf(obj, j2)).hashCode();
                        i5 = floatToIntBits + i3;
                        break;
                    } else {
                        break;
                    }
                case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        floatToIntBits = zzps.zzf(obj, j2).hashCode();
                        i5 = floatToIntBits + i3;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        floatToIntBits = zzps.zzf(obj, j2).hashCode();
                        i5 = floatToIntBits + i3;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        zzc = zzp(obj, j2);
                        i5 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        zzc = zzp(obj, j2);
                        i5 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        zzc = zzp(obj, j2);
                        i5 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        doubleToLongBits = zzv(obj, j2);
                        byte[] bArr11 = zznl.zzb;
                        zzc = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i5 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        zzc = zzp(obj, j2);
                        i5 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        doubleToLongBits = zzv(obj, j2);
                        byte[] bArr12 = zznl.zzb;
                        zzc = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i5 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        floatToIntBits = zzps.zzf(obj, j2).hashCode();
                        i5 = floatToIntBits + i3;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = ((zznd) obj).zzc.hashCode() + (i5 * 53);
        if (this.zzh) {
            return (hashCode * 53) + ((zzna) obj).zzb.zza.hashCode();
        }
        return hashCode;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public final int zzc(java.lang.Object r31, byte[] r32, int r33, int r34, int r35, com.google.android.recaptcha.internal.zzkt r36) {
        /*
            Method dump skipped, instructions count: 3852
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzol.zzc(java.lang.Object, byte[], int, int, int, com.google.android.recaptcha.internal.zzkt):int");
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final Object zze() {
        return ((zznd) this.zzg).zzv();
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzf(Object obj) {
        if (zzQ(obj)) {
            if (obj instanceof zznd) {
                zznd zzndVar = (zznd) obj;
                zzndVar.zzJ(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                zzndVar.zza = 0;
                zzndVar.zzH();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzu = zzu(i);
                int i3 = 1048575 & zzu;
                int zzt = zzt(zzu);
                long j2 = i3;
                if (zzt != 9) {
                    if (zzt != 60 && zzt != 68) {
                        switch (zzt) {
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
                                ((zznk) zzps.zzf(obj, j2)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j2);
                                if (object != null) {
                                    ((zzoc) object).zzc();
                                    unsafe.putObject(obj, j2, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzR(obj, this.zzc[i], i)) {
                        zzx(i).zzf(zzb.getObject(obj, j2));
                    }
                }
                if (zzN(obj, i)) {
                    zzx(i).zzf(zzb.getObject(obj, j2));
                }
            }
            this.zzm.zzi(obj);
            if (this.zzh) {
                this.zzn.zza(obj);
            }
        }
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzu = zzu(i);
            int i3 = 1048575 & zzu;
            int[] iArr = this.zzc;
            int zzt = zzt(zzu);
            int i4 = iArr[i];
            long j2 = i3;
            switch (zzt) {
                case 0:
                    if (zzN(obj2, i)) {
                        zzps.zzo(obj, j2, zzps.zza(obj2, j2));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzN(obj2, i)) {
                        zzps.zzp(obj, j2, zzps.zzb(obj2, j2));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzN(obj2, i)) {
                        zzps.zzr(obj, j2, zzps.zzd(obj2, j2));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzN(obj2, i)) {
                        zzps.zzr(obj, j2, zzps.zzd(obj2, j2));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j2, zzps.zzc(obj2, j2));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzN(obj2, i)) {
                        zzps.zzr(obj, j2, zzps.zzd(obj2, j2));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j2, zzps.zzc(obj2, j2));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzN(obj2, i)) {
                        zzps.zzm(obj, j2, zzps.zzw(obj2, j2));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzN(obj2, i)) {
                        zzps.zzs(obj, j2, zzps.zzf(obj2, j2));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzE(obj, obj2, i);
                    break;
                case 10:
                    if (zzN(obj2, i)) {
                        zzps.zzs(obj, j2, zzps.zzf(obj2, j2));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j2, zzps.zzc(obj2, j2));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case Code.UNIMPLEMENTED /* 12 */:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j2, zzps.zzc(obj2, j2));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j2, zzps.zzc(obj2, j2));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzN(obj2, i)) {
                        zzps.zzr(obj, j2, zzps.zzd(obj2, j2));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j2, zzps.zzc(obj2, j2));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzN(obj2, i)) {
                        zzps.zzr(obj, j2, zzps.zzd(obj2, j2));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzE(obj, obj2, i);
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
                    zznk zznkVar = (zznk) zzps.zzf(obj, j2);
                    zznk zznkVar2 = (zznk) zzps.zzf(obj2, j2);
                    int size = zznkVar.size();
                    int size2 = zznkVar2.size();
                    if (size > 0 && size2 > 0) {
                        if (!zznkVar.zzc()) {
                            zznkVar = zznkVar.zzd(size2 + size);
                        }
                        zznkVar.addAll(zznkVar2);
                    }
                    if (size > 0) {
                        zznkVar2 = zznkVar;
                    }
                    zzps.zzs(obj, j2, zznkVar2);
                    break;
                case 50:
                    int i5 = zzoy.zza;
                    zzps.zzs(obj, j2, zzod.zzb(zzps.zzf(obj, j2), zzps.zzf(obj2, j2)));
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
                    if (zzR(obj2, i4, i)) {
                        zzps.zzs(obj, j2, zzps.zzf(obj2, j2));
                        zzI(obj, i4, i);
                        break;
                    } else {
                        break;
                    }
                case PipesConfigBase.DEFAULT_STALE_FETCHER_DELAY_SECONDS /* 60 */:
                    zzF(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case 67:
                    if (zzR(obj2, i4, i)) {
                        zzps.zzs(obj, j2, zzps.zzf(obj2, j2));
                        zzI(obj, i4, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzF(obj, obj2, i);
                    break;
            }
        }
        zzoy.zzq(this.zzm, obj, obj2);
        if (this.zzh) {
            zzoy.zzp(this.zzn, obj, obj2);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x01e3. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:282:0x0068. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:286:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x073f  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x072b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0750 A[LOOP:3: B:52:0x074c->B:54:0x0750, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x075f  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x071d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.recaptcha.internal.zzow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzh(java.lang.Object r13, com.google.android.recaptcha.internal.zzov r14, com.google.android.recaptcha.internal.zzmo r15) {
        /*
            Method dump skipped, instructions count: 2074
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzol.zzh(java.lang.Object, com.google.android.recaptcha.internal.zzov, com.google.android.recaptcha.internal.zzmo):void");
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzi(Object obj, byte[] bArr, int i, int i3, zzkt zzktVar) {
        zzc(obj, bArr, i, i3, 0, zzktVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:33:0x0099. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    @Override // com.google.android.recaptcha.internal.zzow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzj(java.lang.Object r21, com.google.android.recaptcha.internal.zzpy r22) {
        /*
            Method dump skipped, instructions count: 1522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzol.zzj(java.lang.Object, com.google.android.recaptcha.internal.zzpy):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01c0 A[SYNTHETIC] */
    @Override // com.google.android.recaptcha.internal.zzow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzk(java.lang.Object r8, java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 632
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzol.zzk(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final boolean zzl(Object obj) {
        int i;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i4 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i4];
            int i8 = iArr2[i7];
            int zzu = zzu(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i6) {
                if (i10 != 1048575) {
                    i5 = zzb.getInt(obj, i10);
                }
                i3 = i5;
                i = i10;
            } else {
                i = i6;
                i3 = i5;
            }
            Object obj2 = obj;
            if ((268435456 & zzu) != 0 && !zzO(obj2, i7, i, i3, i11)) {
                return false;
            }
            int zzt = zzt(zzu);
            if (zzt != 9 && zzt != 17) {
                if (zzt != 27) {
                    if (zzt != 60 && zzt != 68) {
                        if (zzt != 49) {
                            if (zzt == 50 && !((zzoc) zzps.zzf(obj2, zzu & 1048575)).isEmpty()) {
                                throw null;
                            }
                        }
                    } else if (zzR(obj2, i8, i7) && !zzP(obj2, zzu, zzx(i7))) {
                        return false;
                    }
                }
                List list = (List) zzps.zzf(obj2, zzu & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzow zzx = zzx(i7);
                    for (int i12 = 0; i12 < list.size(); i12++) {
                        if (!zzx.zzl(list.get(i12))) {
                            return false;
                        }
                    }
                }
            } else if (zzO(obj2, i7, i, i3, i11) && !zzP(obj2, zzu, zzx(i7))) {
                return false;
            }
            i4++;
            obj = obj2;
            i6 = i;
            i5 = i3;
        }
        Object obj3 = obj;
        if (this.zzh && !((zzna) obj3).zzb.zzk()) {
            return false;
        }
        return true;
    }
}
