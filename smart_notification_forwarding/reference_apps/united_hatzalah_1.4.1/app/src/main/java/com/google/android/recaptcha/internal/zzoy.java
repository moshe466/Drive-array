package com.google.android.recaptcha.internal;

import F0.AbstractC0008a;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzoy {
    public static final /* synthetic */ int zza = 0;
    private static final zzpl zzb;

    static {
        int i = zzos.zza;
        zzb = new zzpn();
    }

    public static void zzA(int i, List list, zzpy zzpyVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzpyVar.zzA(i, list, z3);
        }
    }

    public static void zzB(int i, List list, zzpy zzpyVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzpyVar.zzC(i, list, z3);
        }
    }

    public static void zzC(int i, List list, zzpy zzpyVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzpyVar.zzE(i, list, z3);
        }
    }

    public static void zzD(int i, List list, zzpy zzpyVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzpyVar.zzJ(i, list, z3);
        }
    }

    public static void zzE(int i, List list, zzpy zzpyVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzpyVar.zzL(i, list, z3);
        }
    }

    public static boolean zzF(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    public static int zza(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            int i3 = 0;
            while (i < size) {
                i3 += zzln.zzB(zzneVar.zze(i));
                i++;
            }
            return i3;
        }
        int i4 = 0;
        while (i < size) {
            i4 += zzln.zzB(((Integer) list.get(i)).intValue());
            i++;
        }
        return i4;
    }

    public static int zzb(int i, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzln.zzA(i << 3) + 4) * size;
    }

    public static int zzc(List list) {
        return list.size() * 4;
    }

    public static int zzd(int i, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzln.zzA(i << 3) + 8) * size;
    }

    public static int zze(List list) {
        return list.size() * 8;
    }

    public static int zzf(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            int i3 = 0;
            while (i < size) {
                i3 += zzln.zzB(zzneVar.zze(i));
                i++;
            }
            return i3;
        }
        int i4 = 0;
        while (i < size) {
            i4 += zzln.zzB(((Integer) list.get(i)).intValue());
            i++;
        }
        return i4;
    }

    public static int zzg(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            int i3 = 0;
            while (i < size) {
                i3 += zzln.zzB(zznxVar.zze(i));
                i++;
            }
            return i3;
        }
        int i4 = 0;
        while (i < size) {
            i4 += zzln.zzB(((Long) list.get(i)).longValue());
            i++;
        }
        return i4;
    }

    public static int zzh(int i, Object obj, zzow zzowVar) {
        int i3 = i << 3;
        if (obj instanceof zznt) {
            int zzA = zzln.zzA(i3);
            int zza2 = ((zznt) obj).zza();
            return AbstractC0008a.d(zza2, zza2, zzA);
        }
        return zzln.zzy((zzoi) obj, zzowVar) + zzln.zzA(i3);
    }

    public static int zzi(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            int i3 = 0;
            while (i < size) {
                int zze = zzneVar.zze(i);
                i3 += zzln.zzA((zze >> 31) ^ (zze + zze));
                i++;
            }
            return i3;
        }
        int i4 = 0;
        while (i < size) {
            int intValue = ((Integer) list.get(i)).intValue();
            i4 += zzln.zzA((intValue >> 31) ^ (intValue + intValue));
            i++;
        }
        return i4;
    }

    public static int zzj(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            int i3 = 0;
            while (i < size) {
                long zze = zznxVar.zze(i);
                i3 += zzln.zzB((zze >> 63) ^ (zze + zze));
                i++;
            }
            return i3;
        }
        int i4 = 0;
        while (i < size) {
            long longValue = ((Long) list.get(i)).longValue();
            i4 += zzln.zzB((longValue >> 63) ^ (longValue + longValue));
            i++;
        }
        return i4;
    }

    public static int zzk(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            int i3 = 0;
            while (i < size) {
                i3 += zzln.zzA(zzneVar.zze(i));
                i++;
            }
            return i3;
        }
        int i4 = 0;
        while (i < size) {
            i4 += zzln.zzA(((Integer) list.get(i)).intValue());
            i++;
        }
        return i4;
    }

    public static int zzl(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            int i3 = 0;
            while (i < size) {
                i3 += zzln.zzB(zznxVar.zze(i));
                i++;
            }
            return i3;
        }
        int i4 = 0;
        while (i < size) {
            i4 += zzln.zzB(((Long) list.get(i)).longValue());
            i++;
        }
        return i4;
    }

    public static zzpl zzm() {
        return zzb;
    }

    public static Object zzn(Object obj, int i, List list, zznh zznhVar, Object obj2, zzpl zzplVar) {
        if (zznhVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                Integer num = (Integer) list.get(i4);
                int intValue = num.intValue();
                if (zznhVar.zza(intValue)) {
                    if (i4 != i3) {
                        list.set(i3, num);
                    }
                    i3++;
                } else {
                    obj2 = zzo(obj, i, intValue, obj2, zzplVar);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
            return obj2;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int intValue2 = ((Integer) it.next()).intValue();
            if (!zznhVar.zza(intValue2)) {
                obj2 = zzo(obj, i, intValue2, obj2, zzplVar);
                it.remove();
            }
        }
        return obj2;
    }

    public static Object zzo(Object obj, int i, int i3, Object obj2, zzpl zzplVar) {
        if (obj2 == null) {
            obj2 = zzplVar.zza(obj);
        }
        zzplVar.zzh(obj2, i, i3);
        return obj2;
    }

    public static void zzp(zzmp zzmpVar, Object obj, Object obj2) {
        zzmt zzmtVar = ((zzna) obj2).zzb;
        if (!zzmtVar.zza.isEmpty()) {
            ((zzna) obj).zzi().zzh(zzmtVar);
        }
    }

    public static void zzq(zzpl zzplVar, Object obj, Object obj2) {
        zznd zzndVar = (zznd) obj;
        zzpm zzpmVar = zzndVar.zzc;
        zzpm zzpmVar2 = ((zznd) obj2).zzc;
        if (!zzpm.zzc().equals(zzpmVar2)) {
            if (zzpm.zzc().equals(zzpmVar)) {
                zzpmVar = zzpm.zze(zzpmVar, zzpmVar2);
            } else {
                zzpmVar.zzd(zzpmVar2);
            }
        }
        zzndVar.zzc = zzpmVar;
    }

    public static void zzr(int i, List list, zzpy zzpyVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzpyVar.zzc(i, list, z3);
        }
    }

    public static void zzs(int i, List list, zzpy zzpyVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzpyVar.zzg(i, list, z3);
        }
    }

    public static void zzt(int i, List list, zzpy zzpyVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzpyVar.zzj(i, list, z3);
        }
    }

    public static void zzu(int i, List list, zzpy zzpyVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzpyVar.zzl(i, list, z3);
        }
    }

    public static void zzv(int i, List list, zzpy zzpyVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzpyVar.zzn(i, list, z3);
        }
    }

    public static void zzw(int i, List list, zzpy zzpyVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzpyVar.zzp(i, list, z3);
        }
    }

    public static void zzx(int i, List list, zzpy zzpyVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzpyVar.zzs(i, list, z3);
        }
    }

    public static void zzy(int i, List list, zzpy zzpyVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzpyVar.zzu(i, list, z3);
        }
    }

    public static void zzz(int i, List list, zzpy zzpyVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzpyVar.zzy(i, list, z3);
        }
    }
}
