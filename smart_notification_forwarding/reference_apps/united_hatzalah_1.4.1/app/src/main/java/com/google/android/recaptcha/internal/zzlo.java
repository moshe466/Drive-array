package com.google.android.recaptcha.internal;

import java.util.List;

/* loaded from: classes.dex */
final class zzlo implements zzpy {
    private final zzln zza;

    private zzlo(zzln zzlnVar) {
        byte[] bArr = zznl.zzb;
        this.zza = zzlnVar;
        zzlnVar.zza = this;
    }

    public static zzlo zza(zzln zzlnVar) {
        zzlo zzloVar = zzlnVar.zza;
        if (zzloVar != null) {
            return zzloVar;
        }
        return new zzlo(zzlnVar);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzA(int i, List list, boolean z3) {
        int i3 = 0;
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            if (z3) {
                this.zza.zzr(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zznxVar.size(); i5++) {
                    zznxVar.zze(i5);
                    i4 += 8;
                }
                this.zza.zzt(i4);
                while (i3 < zznxVar.size()) {
                    this.zza.zzi(zznxVar.zze(i3));
                    i3++;
                }
                return;
            }
            while (i3 < zznxVar.size()) {
                this.zza.zzh(i, zznxVar.zze(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzr(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Long) list.get(i7)).getClass();
                i6 += 8;
            }
            this.zza.zzt(i6);
            while (i3 < list.size()) {
                this.zza.zzi(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzh(i, ((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzB(int i, int i3) {
        this.zza.zzs(i, (i3 >> 31) ^ (i3 + i3));
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzC(int i, List list, boolean z3) {
        int i3 = 0;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            if (z3) {
                this.zza.zzr(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zzneVar.size(); i5++) {
                    int zze = zzneVar.zze(i5);
                    i4 += zzln.zzA((zze >> 31) ^ (zze + zze));
                }
                this.zza.zzt(i4);
                while (i3 < zzneVar.size()) {
                    zzln zzlnVar = this.zza;
                    int zze2 = zzneVar.zze(i3);
                    zzlnVar.zzt((zze2 >> 31) ^ (zze2 + zze2));
                    i3++;
                }
                return;
            }
            while (i3 < zzneVar.size()) {
                zzln zzlnVar2 = this.zza;
                int zze3 = zzneVar.zze(i3);
                zzlnVar2.zzs(i, (zze3 >> 31) ^ (zze3 + zze3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzr(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                int intValue = ((Integer) list.get(i7)).intValue();
                i6 += zzln.zzA((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzt(i6);
            while (i3 < list.size()) {
                zzln zzlnVar3 = this.zza;
                int intValue2 = ((Integer) list.get(i3)).intValue();
                zzlnVar3.zzt((intValue2 >> 31) ^ (intValue2 + intValue2));
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            zzln zzlnVar4 = this.zza;
            int intValue3 = ((Integer) list.get(i3)).intValue();
            zzlnVar4.zzs(i, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i3++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzD(int i, long j2) {
        this.zza.zzu(i, (j2 >> 63) ^ (j2 + j2));
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzE(int i, List list, boolean z3) {
        int i3 = 0;
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            if (z3) {
                this.zza.zzr(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zznxVar.size(); i5++) {
                    long zze = zznxVar.zze(i5);
                    i4 += zzln.zzB((zze >> 63) ^ (zze + zze));
                }
                this.zza.zzt(i4);
                while (i3 < zznxVar.size()) {
                    zzln zzlnVar = this.zza;
                    long zze2 = zznxVar.zze(i3);
                    zzlnVar.zzv((zze2 >> 63) ^ (zze2 + zze2));
                    i3++;
                }
                return;
            }
            while (i3 < zznxVar.size()) {
                zzln zzlnVar2 = this.zza;
                long zze3 = zznxVar.zze(i3);
                zzlnVar2.zzu(i, (zze3 >> 63) ^ (zze3 + zze3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzr(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                long longValue = ((Long) list.get(i7)).longValue();
                i6 += zzln.zzB((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzt(i6);
            while (i3 < list.size()) {
                zzln zzlnVar3 = this.zza;
                long longValue2 = ((Long) list.get(i3)).longValue();
                zzlnVar3.zzv((longValue2 >> 63) ^ (longValue2 + longValue2));
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            zzln zzlnVar4 = this.zza;
            long longValue3 = ((Long) list.get(i3)).longValue();
            zzlnVar4.zzu(i, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i3++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    @Deprecated
    public final void zzF(int i) {
        this.zza.zzr(i, 3);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzG(int i, String str) {
        this.zza.zzp(i, str);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzH(int i, List list) {
        int i3 = 0;
        if (list instanceof zznu) {
            zznu zznuVar = (zznu) list;
            while (i3 < list.size()) {
                Object zzc = zznuVar.zzc();
                if (zzc instanceof String) {
                    this.zza.zzp(i, (String) zzc);
                } else {
                    this.zza.zze(i, (zzle) zzc);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzp(i, (String) list.get(i3));
            i3++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzI(int i, int i3) {
        this.zza.zzs(i, i3);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzJ(int i, List list, boolean z3) {
        int i3 = 0;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            if (z3) {
                this.zza.zzr(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zzneVar.size(); i5++) {
                    i4 += zzln.zzA(zzneVar.zze(i5));
                }
                this.zza.zzt(i4);
                while (i3 < zzneVar.size()) {
                    this.zza.zzt(zzneVar.zze(i3));
                    i3++;
                }
                return;
            }
            while (i3 < zzneVar.size()) {
                this.zza.zzs(i, zzneVar.zze(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzr(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzln.zzA(((Integer) list.get(i7)).intValue());
            }
            this.zza.zzt(i6);
            while (i3 < list.size()) {
                this.zza.zzt(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzs(i, ((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzK(int i, long j2) {
        this.zza.zzu(i, j2);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzL(int i, List list, boolean z3) {
        int i3 = 0;
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            if (z3) {
                this.zza.zzr(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zznxVar.size(); i5++) {
                    i4 += zzln.zzB(zznxVar.zze(i5));
                }
                this.zza.zzt(i4);
                while (i3 < zznxVar.size()) {
                    this.zza.zzv(zznxVar.zze(i3));
                    i3++;
                }
                return;
            }
            while (i3 < zznxVar.size()) {
                this.zza.zzu(i, zznxVar.zze(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzr(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzln.zzB(((Long) list.get(i7)).longValue());
            }
            this.zza.zzt(i6);
            while (i3 < list.size()) {
                this.zza.zzv(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzu(i, ((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzb(int i, boolean z3) {
        this.zza.zzd(i, z3);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzc(int i, List list, boolean z3) {
        int i3 = 0;
        if (list instanceof zzkv) {
            zzkv zzkvVar = (zzkv) list;
            if (z3) {
                this.zza.zzr(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zzkvVar.size(); i5++) {
                    zzkvVar.zzf(i5);
                    i4++;
                }
                this.zza.zzt(i4);
                while (i3 < zzkvVar.size()) {
                    this.zza.zzb(zzkvVar.zzf(i3) ? (byte) 1 : (byte) 0);
                    i3++;
                }
                return;
            }
            while (i3 < zzkvVar.size()) {
                this.zza.zzd(i, zzkvVar.zzf(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzr(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Boolean) list.get(i7)).getClass();
                i6++;
            }
            this.zza.zzt(i6);
            while (i3 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i3)).booleanValue() ? (byte) 1 : (byte) 0);
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzd(i, ((Boolean) list.get(i3)).booleanValue());
            i3++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzd(int i, zzle zzleVar) {
        this.zza.zze(i, zzleVar);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zze(int i, List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.zza.zze(i, (zzle) list.get(i3));
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzf(int i, double d2) {
        this.zza.zzh(i, Double.doubleToRawLongBits(d2));
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzg(int i, List list, boolean z3) {
        int i3 = 0;
        if (list instanceof zzmi) {
            zzmi zzmiVar = (zzmi) list;
            if (z3) {
                this.zza.zzr(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zzmiVar.size(); i5++) {
                    zzmiVar.zze(i5);
                    i4 += 8;
                }
                this.zza.zzt(i4);
                while (i3 < zzmiVar.size()) {
                    this.zza.zzi(Double.doubleToRawLongBits(zzmiVar.zze(i3)));
                    i3++;
                }
                return;
            }
            while (i3 < zzmiVar.size()) {
                this.zza.zzh(i, Double.doubleToRawLongBits(zzmiVar.zze(i3)));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzr(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Double) list.get(i7)).getClass();
                i6 += 8;
            }
            this.zza.zzt(i6);
            while (i3 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzh(i, Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
            i3++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    @Deprecated
    public final void zzh(int i) {
        this.zza.zzr(i, 4);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzi(int i, int i3) {
        this.zza.zzj(i, i3);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzj(int i, List list, boolean z3) {
        int i3 = 0;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            if (z3) {
                this.zza.zzr(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zzneVar.size(); i5++) {
                    i4 += zzln.zzB(zzneVar.zze(i5));
                }
                this.zza.zzt(i4);
                while (i3 < zzneVar.size()) {
                    this.zza.zzk(zzneVar.zze(i3));
                    i3++;
                }
                return;
            }
            while (i3 < zzneVar.size()) {
                this.zza.zzj(i, zzneVar.zze(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzr(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzln.zzB(((Integer) list.get(i7)).intValue());
            }
            this.zza.zzt(i6);
            while (i3 < list.size()) {
                this.zza.zzk(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzj(i, ((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzk(int i, int i3) {
        this.zza.zzf(i, i3);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzl(int i, List list, boolean z3) {
        int i3 = 0;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            if (z3) {
                this.zza.zzr(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zzneVar.size(); i5++) {
                    zzneVar.zze(i5);
                    i4 += 4;
                }
                this.zza.zzt(i4);
                while (i3 < zzneVar.size()) {
                    this.zza.zzg(zzneVar.zze(i3));
                    i3++;
                }
                return;
            }
            while (i3 < zzneVar.size()) {
                this.zza.zzf(i, zzneVar.zze(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzr(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Integer) list.get(i7)).getClass();
                i6 += 4;
            }
            this.zza.zzt(i6);
            while (i3 < list.size()) {
                this.zza.zzg(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzf(i, ((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzm(int i, long j2) {
        this.zza.zzh(i, j2);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzn(int i, List list, boolean z3) {
        int i3 = 0;
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            if (z3) {
                this.zza.zzr(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zznxVar.size(); i5++) {
                    zznxVar.zze(i5);
                    i4 += 8;
                }
                this.zza.zzt(i4);
                while (i3 < zznxVar.size()) {
                    this.zza.zzi(zznxVar.zze(i3));
                    i3++;
                }
                return;
            }
            while (i3 < zznxVar.size()) {
                this.zza.zzh(i, zznxVar.zze(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzr(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Long) list.get(i7)).getClass();
                i6 += 8;
            }
            this.zza.zzt(i6);
            while (i3 < list.size()) {
                this.zza.zzi(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzh(i, ((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzo(int i, float f4) {
        this.zza.zzf(i, Float.floatToRawIntBits(f4));
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzp(int i, List list, boolean z3) {
        int i3 = 0;
        if (list instanceof zzmv) {
            zzmv zzmvVar = (zzmv) list;
            if (z3) {
                this.zza.zzr(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zzmvVar.size(); i5++) {
                    zzmvVar.zze(i5);
                    i4 += 4;
                }
                this.zza.zzt(i4);
                while (i3 < zzmvVar.size()) {
                    this.zza.zzg(Float.floatToRawIntBits(zzmvVar.zze(i3)));
                    i3++;
                }
                return;
            }
            while (i3 < zzmvVar.size()) {
                this.zza.zzf(i, Float.floatToRawIntBits(zzmvVar.zze(i3)));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzr(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Float) list.get(i7)).getClass();
                i6 += 4;
            }
            this.zza.zzt(i6);
            while (i3 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzf(i, Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
            i3++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzq(int i, Object obj, zzow zzowVar) {
        zzln zzlnVar = this.zza;
        zzlnVar.zzr(i, 3);
        zzowVar.zzj((zzoi) obj, zzlnVar.zza);
        zzlnVar.zzr(i, 4);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzr(int i, int i3) {
        this.zza.zzj(i, i3);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzs(int i, List list, boolean z3) {
        int i3 = 0;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            if (z3) {
                this.zza.zzr(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zzneVar.size(); i5++) {
                    i4 += zzln.zzB(zzneVar.zze(i5));
                }
                this.zza.zzt(i4);
                while (i3 < zzneVar.size()) {
                    this.zza.zzk(zzneVar.zze(i3));
                    i3++;
                }
                return;
            }
            while (i3 < zzneVar.size()) {
                this.zza.zzj(i, zzneVar.zze(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzr(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzln.zzB(((Integer) list.get(i7)).intValue());
            }
            this.zza.zzt(i6);
            while (i3 < list.size()) {
                this.zza.zzk(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzj(i, ((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzt(int i, long j2) {
        this.zza.zzu(i, j2);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzu(int i, List list, boolean z3) {
        int i3 = 0;
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            if (z3) {
                this.zza.zzr(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zznxVar.size(); i5++) {
                    i4 += zzln.zzB(zznxVar.zze(i5));
                }
                this.zza.zzt(i4);
                while (i3 < zznxVar.size()) {
                    this.zza.zzv(zznxVar.zze(i3));
                    i3++;
                }
                return;
            }
            while (i3 < zznxVar.size()) {
                this.zza.zzu(i, zznxVar.zze(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzr(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzln.zzB(((Long) list.get(i7)).longValue());
            }
            this.zza.zzt(i6);
            while (i3 < list.size()) {
                this.zza.zzv(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzu(i, ((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzv(int i, Object obj, zzow zzowVar) {
        this.zza.zzm(i, (zzoi) obj, zzowVar);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzw(int i, Object obj) {
        if (obj instanceof zzle) {
            this.zza.zzo(i, (zzle) obj);
        } else {
            this.zza.zzn(i, (zzoi) obj);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzx(int i, int i3) {
        this.zza.zzf(i, i3);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzy(int i, List list, boolean z3) {
        int i3 = 0;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            if (z3) {
                this.zza.zzr(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zzneVar.size(); i5++) {
                    zzneVar.zze(i5);
                    i4 += 4;
                }
                this.zza.zzt(i4);
                while (i3 < zzneVar.size()) {
                    this.zza.zzg(zzneVar.zze(i3));
                    i3++;
                }
                return;
            }
            while (i3 < zzneVar.size()) {
                this.zza.zzf(i, zzneVar.zze(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzr(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Integer) list.get(i7)).getClass();
                i6 += 4;
            }
            this.zza.zzt(i6);
            while (i3 < list.size()) {
                this.zza.zzg(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzf(i, ((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzz(int i, long j2) {
        this.zza.zzh(i, j2);
    }
}
