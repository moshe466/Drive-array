package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzamx {
    private static final zzano<?, ?> zza = new zzanq();

    public static int zza(int i, List<?> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzakg.zza(i, true) * size;
    }

    public static int zzb(int i, List<Integer> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzakg.zzi(i) * size) + zzb(list);
    }

    public static int zzc(int i, List<?> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzakg.zzc(i, 0) * size;
    }

    public static int zzd(int i, List<?> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzakg.zza(i, 0L) * size;
    }

    public static int zze(int i, List<Integer> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzakg.zzi(i) * size) + zze(list);
    }

    public static int zzf(int i, List<Long> list, boolean z3) {
        if (list.size() == 0) {
            return 0;
        }
        return (zzakg.zzi(i) * list.size()) + zzf(list);
    }

    public static int zzg(int i, List<Integer> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzakg.zzi(i) * size) + zzg(list);
    }

    public static int zzh(int i, List<Long> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzakg.zzi(i) * size) + zzh(list);
    }

    public static int zzi(int i, List<Integer> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzakg.zzi(i) * size) + zzi(list);
    }

    public static int zzj(int i, List<Long> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzakg.zzi(i) * size) + zzj(list);
    }

    public static void zzk(int i, List<Integer> list, zzaof zzaofVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzaofVar.zzk(i, list, z3);
        }
    }

    public static void zzl(int i, List<Long> list, zzaof zzaofVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzaofVar.zzl(i, list, z3);
        }
    }

    public static void zzm(int i, List<Integer> list, zzaof zzaofVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzaofVar.zzm(i, list, z3);
        }
    }

    public static void zzn(int i, List<Long> list, zzaof zzaofVar, boolean z3) {
        if (list != null && !list.isEmpty()) {
            zzaofVar.zzn(i, list, z3);
        }
    }

    public static int zza(List<?> list) {
        return list.size();
    }

    public static int zzc(List<?> list) {
        return list.size() << 2;
    }

    public static int zzd(List<?> list) {
        return list.size() << 3;
    }

    public static int zza(int i, List<zzajp> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzi = zzakg.zzi(i) * size;
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzi += zzakg.zza(list.get(i3));
        }
        return zzi;
    }

    public static int zzb(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzakz)) {
            int i3 = 0;
            while (i < size) {
                i3 += zzakg.zzc(list.get(i).intValue());
                i++;
            }
            return i3;
        }
        zzakz zzakzVar = (zzakz) list;
        int i4 = 0;
        while (i < size) {
            i4 += zzakg.zzc(zzakzVar.zzb(i));
            i++;
        }
        return i4;
    }

    public static void zzc(int i, List<Integer> list, zzaof zzaofVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzc(i, list, z3);
    }

    public static void zzd(int i, List<Integer> list, zzaof zzaofVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzd(i, list, z3);
    }

    public static int zze(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzakz)) {
            int i3 = 0;
            while (i < size) {
                i3 += zzakg.zze(list.get(i).intValue());
                i++;
            }
            return i3;
        }
        zzakz zzakzVar = (zzakz) list;
        int i4 = 0;
        while (i < size) {
            i4 += zzakg.zze(zzakzVar.zzb(i));
            i++;
        }
        return i4;
    }

    public static int zzf(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzalr)) {
            int i3 = 0;
            while (i < size) {
                i3 += zzakg.zzd(list.get(i).longValue());
                i++;
            }
            return i3;
        }
        zzalr zzalrVar = (zzalr) list;
        int i4 = 0;
        while (i < size) {
            i4 += zzakg.zzd(zzalrVar.zzb(i));
            i++;
        }
        return i4;
    }

    public static int zzg(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzakz)) {
            int i3 = 0;
            while (i < size) {
                i3 += zzakg.zzh(list.get(i).intValue());
                i++;
            }
            return i3;
        }
        zzakz zzakzVar = (zzakz) list;
        int i4 = 0;
        while (i < size) {
            i4 += zzakg.zzh(zzakzVar.zzb(i));
            i++;
        }
        return i4;
    }

    public static int zzh(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzalr)) {
            int i3 = 0;
            while (i < size) {
                i3 += zzakg.zzf(list.get(i).longValue());
                i++;
            }
            return i3;
        }
        zzalr zzalrVar = (zzalr) list;
        int i4 = 0;
        while (i < size) {
            i4 += zzakg.zzf(zzalrVar.zzb(i));
            i++;
        }
        return i4;
    }

    public static int zzi(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzakz)) {
            int i3 = 0;
            while (i < size) {
                i3 += zzakg.zzj(list.get(i).intValue());
                i++;
            }
            return i3;
        }
        zzakz zzakzVar = (zzakz) list;
        int i4 = 0;
        while (i < size) {
            i4 += zzakg.zzj(zzakzVar.zzb(i));
            i++;
        }
        return i4;
    }

    public static int zzj(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzalr)) {
            int i3 = 0;
            while (i < size) {
                i3 += zzakg.zzg(list.get(i).longValue());
                i++;
            }
            return i3;
        }
        zzalr zzalrVar = (zzalr) list;
        int i4 = 0;
        while (i < size) {
            i4 += zzakg.zzg(zzalrVar.zzb(i));
            i++;
        }
        return i4;
    }

    public static int zza(int i, List<zzamc> list, zzamv<?> zzamvVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzakg.zza(i, list.get(i4), zzamvVar);
        }
        return i3;
    }

    public static int zzb(int i, List<?> list, zzamv<?> zzamvVar) {
        int zza2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzi = zzakg.zzi(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzalk) {
                zza2 = zzakg.zza((zzalk) obj);
            } else {
                zza2 = zzakg.zza((zzamc) obj, zzamvVar);
            }
            zzi = zza2 + zzi;
        }
        return zzi;
    }

    public static void zze(int i, List<Long> list, zzaof zzaofVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zze(i, list, z3);
    }

    public static void zzf(int i, List<Float> list, zzaof zzaofVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzf(i, list, z3);
    }

    public static void zzg(int i, List<Integer> list, zzaof zzaofVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzg(i, list, z3);
    }

    public static void zzh(int i, List<Long> list, zzaof zzaofVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzh(i, list, z3);
    }

    public static void zzi(int i, List<Integer> list, zzaof zzaofVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzi(i, list, z3);
    }

    public static void zzj(int i, List<Long> list, zzaof zzaofVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzj(i, list, z3);
    }

    public static int zza(int i, Object obj, zzamv<?> zzamvVar) {
        if (obj instanceof zzalk) {
            return zzakg.zzb(i, (zzalk) obj);
        }
        return zzakg.zzb(i, (zzamc) obj, zzamvVar);
    }

    public static zzano<?, ?> zza() {
        return zza;
    }

    public static <UT, UB> UB zza(Object obj, int i, List<Integer> list, zzald zzaldVar, UB ub, zzano<UT, UB> zzanoVar) {
        if (zzaldVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                Integer num = list.get(i4);
                int intValue = num.intValue();
                if (zzaldVar.zza(intValue)) {
                    if (i4 != i3) {
                        list.set(i3, num);
                    }
                    i3++;
                } else {
                    ub = (UB) zza(obj, i, intValue, ub, zzanoVar);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
            return ub;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue2 = it.next().intValue();
            if (!zzaldVar.zza(intValue2)) {
                ub = (UB) zza(obj, i, intValue2, ub, zzanoVar);
                it.remove();
            }
        }
        return ub;
    }

    public static int zzb(int i, List<?> list) {
        int zza2;
        int zza3;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int zzi = zzakg.zzi(i) * size;
        if (!(list instanceof zzaln)) {
            while (i3 < size) {
                Object obj = list.get(i3);
                if (obj instanceof zzajp) {
                    zza2 = zzakg.zza((zzajp) obj);
                } else {
                    zza2 = zzakg.zza((String) obj);
                }
                zzi = zza2 + zzi;
                i3++;
            }
            return zzi;
        }
        zzaln zzalnVar = (zzaln) list;
        while (i3 < size) {
            Object zza4 = zzalnVar.zza(i3);
            if (zza4 instanceof zzajp) {
                zza3 = zzakg.zza((zzajp) zza4);
            } else {
                zza3 = zzakg.zza((String) zza4);
            }
            zzi = zza3 + zzi;
            i3++;
        }
        return zzi;
    }

    public static <UT, UB> UB zza(Object obj, int i, int i3, UB ub, zzano<UT, UB> zzanoVar) {
        if (ub == null) {
            ub = zzanoVar.zzc(obj);
        }
        zzanoVar.zzb(ub, i, i3);
        return ub;
    }

    public static void zzb(int i, List<Double> list, zzaof zzaofVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzb(i, list, z3);
    }

    public static <T, FT extends zzakt<FT>> void zza(zzakm<FT> zzakmVar, T t3, T t4) {
        zzakr<FT> zza2 = zzakmVar.zza(t4);
        if (zza2.zza.isEmpty()) {
            return;
        }
        zzakmVar.zzb(t3).zza(zza2);
    }

    public static void zzb(int i, List<?> list, zzaof zzaofVar, zzamv<?> zzamvVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzb(i, list, (zzamv) zzamvVar);
    }

    public static void zzb(int i, List<String> list, zzaof zzaofVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzb(i, list);
    }

    public static <T> void zza(zzalz zzalzVar, T t3, T t4, long j2) {
        zzanp.zza(t3, j2, zzalzVar.zza(zzanp.zze(t3, j2), zzanp.zze(t4, j2)));
    }

    public static <T, UT, UB> void zza(zzano<UT, UB> zzanoVar, T t3, T t4) {
        zzanoVar.zzc(t3, zzanoVar.zza(zzanoVar.zzd(t3), zzanoVar.zzd(t4)));
    }

    public static void zza(Class<?> cls) {
        zzaky.class.isAssignableFrom(cls);
    }

    public static void zza(int i, List<Boolean> list, zzaof zzaofVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zza(i, list, z3);
    }

    public static void zza(int i, List<zzajp> list, zzaof zzaofVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zza(i, list);
    }

    public static void zza(int i, List<?> list, zzaof zzaofVar, zzamv<?> zzamvVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zza(i, list, (zzamv) zzamvVar);
    }

    public static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
