package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzduc {
    private static final Class<?> zzhqr = zzbca();
    private static final zzdus<?, ?> zzhqs = zzbq(false);
    private static final zzdus<?, ?> zzhqt = zzbq(true);
    private static final zzdus<?, ?> zzhqu = new zzduu();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, Object obj, zzdua zzduaVar) {
        return obj instanceof zzdsj ? zzdrb.zza(i, (zzdsj) obj) : zzdrb.b(i, (zzdte) obj, zzduaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzfz = zzdrb.zzfz(i) * size;
        if (list instanceof zzdsl) {
            zzdsl zzdslVar = (zzdsl) list;
            while (i2 < size) {
                Object zzgm = zzdslVar.zzgm(i2);
                zzfz += zzgm instanceof zzdqk ? zzdrb.zzbf((zzdqk) zzgm) : zzdrb.zzhh((String) zzgm);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                zzfz += obj instanceof zzdqk ? zzdrb.zzbf((zzdqk) obj) : zzdrb.zzhh((String) obj);
                i2++;
            }
        }
        return zzfz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list, zzdua zzduaVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzfz = zzdrb.zzfz(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            zzfz += obj instanceof zzdsj ? zzdrb.zza((zzdsj) obj) : zzdrb.a((zzdte) obj, zzduaVar);
        }
        return zzfz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return i(list) + (list.size() * zzdrb.zzfz(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdss) {
            zzdss zzdssVar = (zzdss) list;
            i = 0;
            while (i2 < size) {
                i += zzdrb.zzfl(zzdssVar.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdrb.zzfl(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, int i2, UB ub, zzdus<UT, UB> zzdusVar) {
        if (ub == null) {
            ub = zzdusVar.a();
        }
        zzdusVar.a((zzdus<UT, UB>) ub, i, i2);
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, List<Integer> list, zzdsa zzdsaVar, UB ub, zzdus<UT, UB> zzdusVar) {
        UB ub2;
        int intValue;
        if (zzdsaVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue2 = list.get(i3).intValue();
                if (zzdsaVar.zzf(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = (UB) a(i, intValue2, ub2, zzdusVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            loop1: while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    intValue = it.next().intValue();
                    if (!zzdsaVar.zzf(intValue)) {
                        break;
                    }
                }
                ub = (UB) a(i, intValue, ub2, zzdusVar);
                it.remove();
            }
        }
        return ub2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzdro<FT>> void a(zzdri<FT> zzdriVar, T t, T t2) {
        zzdrm<FT> a = zzdriVar.a(t2);
        if (a.a.isEmpty()) {
            return;
        }
        zzdriVar.b(t).zza(a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void a(zzdsx zzdsxVar, T t, T t2, long j) {
        zzduy.a(t, j, zzdsxVar.zze(zzduy.f(t, j), zzduy.f(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void a(zzdus<UT, UB> zzdusVar, T t, T t2) {
        zzdusVar.a(t, zzdusVar.c(zzdusVar.d(t), zzdusVar.d(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzdqk> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzfz = size * zzdrb.zzfz(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzfz += zzdrb.zzbf(list.get(i2));
        }
        return zzfz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzdte> list, zzdua zzduaVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzdrb.c(i, list.get(i3), zzduaVar);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return j(list) + (size * zzdrb.zzfz(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdrw) {
            zzdrw zzdrwVar = (zzdrw) list;
            i = 0;
            while (i2 < size) {
                i += zzdrb.zzgf(zzdrwVar.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdrb.zzgf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return a(list) + (size * zzdrb.zzfz(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdrw) {
            zzdrw zzdrwVar = (zzdrw) list;
            i = 0;
            while (i2 < size) {
                i += zzdrb.zzga(zzdrwVar.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdrb.zzga(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return b(list) + (size * zzdrb.zzfz(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdrw) {
            zzdrw zzdrwVar = (zzdrw) list;
            i = 0;
            while (i2 < size) {
                i += zzdrb.zzgb(zzdrwVar.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdrb.zzgb(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return c(list) + (size * zzdrb.zzfz(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdrw) {
            zzdrw zzdrwVar = (zzdrw) list;
            i = 0;
            while (i2 < size) {
                i += zzdrb.zzgc(zzdrwVar.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdrb.zzgc(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return d(list) + (size * zzdrb.zzfz(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return e(list) + (size * zzdrb.zzfz(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdrb.zzai(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(List<?> list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdrb.zzm(i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdss) {
            zzdss zzdssVar = (zzdss) list;
            i = 0;
            while (i2 < size) {
                i += zzdrb.zzfj(zzdssVar.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdrb.zzfj(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdrb.zzi(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdss) {
            zzdss zzdssVar = (zzdss) list;
            i = 0;
            while (i2 < size) {
                i += zzdrb.zzfk(zzdssVar.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdrb.zzfk(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void zza(int i, List<String> list, zzdvl zzdvlVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zza(i, list);
    }

    public static void zza(int i, List<?> list, zzdvl zzdvlVar, zzdua zzduaVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zza(i, list, zzduaVar);
    }

    public static void zza(int i, List<Double> list, zzdvl zzdvlVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zzg(i, list, z);
    }

    public static void zzb(int i, List<zzdqk> list, zzdvl zzdvlVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zzb(i, list);
    }

    public static void zzb(int i, List<?> list, zzdvl zzdvlVar, zzdua zzduaVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zzb(i, list, zzduaVar);
    }

    public static void zzb(int i, List<Float> list, zzdvl zzdvlVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zzf(i, list, z);
    }

    public static zzdus<?, ?> zzbbx() {
        return zzhqs;
    }

    public static zzdus<?, ?> zzbby() {
        return zzhqt;
    }

    public static zzdus<?, ?> zzbbz() {
        return zzhqu;
    }

    private static Class<?> zzbca() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzbcb() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static zzdus<?, ?> zzbq(boolean z) {
        try {
            Class<?> zzbcb = zzbcb();
            if (zzbcb == null) {
                return null;
            }
            return (zzdus) zzbcb.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzc(int i, List<Long> list, zzdvl zzdvlVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Long> list, zzdvl zzdvlVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzdvl zzdvlVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zzn(i, list, z);
    }

    public static void zzf(int i, List<Long> list, zzdvl zzdvlVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zze(i, list, z);
    }

    public static void zzg(int i, List<Long> list, zzdvl zzdvlVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zzl(i, list, z);
    }

    public static void zzh(int i, List<Integer> list, zzdvl zzdvlVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zza(i, list, z);
    }

    public static void zzi(int i, List<Integer> list, zzdvl zzdvlVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zzj(i, list, z);
    }

    public static void zzi(Class<?> cls) {
        Class<?> cls2;
        if (!zzdrt.class.isAssignableFrom(cls) && (cls2 = zzhqr) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzj(int i, List<Integer> list, zzdvl zzdvlVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zzm(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzdvl zzdvlVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zzb(i, list, z);
    }

    public static void zzl(int i, List<Integer> list, zzdvl zzdvlVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zzk(i, list, z);
    }

    public static void zzm(int i, List<Integer> list, zzdvl zzdvlVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zzh(i, list, z);
    }

    public static void zzn(int i, List<Boolean> list, zzdvl zzdvlVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdvlVar.zzi(i, list, z);
    }
}
