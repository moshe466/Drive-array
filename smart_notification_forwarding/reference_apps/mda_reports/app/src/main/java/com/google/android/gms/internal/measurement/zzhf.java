package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzhf {
    private static final Class<?> zza = zzd();
    private static final zzhv<?, ?> zzb = zza(false);
    private static final zzhv<?, ?> zzc = zza(true);
    private static final zzhv<?, ?> zzd = new zzhx();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, Object obj, zzhd zzhdVar) {
        return obj instanceof zzft ? zzen.zza(i, (zzft) obj) : zzen.b(i, (zzgo) obj, zzhdVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zze = zzen.zze(i) * size;
        if (list instanceof zzfv) {
            zzfv zzfvVar = (zzfv) list;
            while (i2 < size) {
                Object zzb2 = zzfvVar.zzb(i2);
                zze += zzb2 instanceof zzdu ? zzen.zzb((zzdu) zzb2) : zzen.zzb((String) zzb2);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                zze += obj instanceof zzdu ? zzen.zzb((zzdu) obj) : zzen.zzb((String) obj);
                i2++;
            }
        }
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list, zzhd zzhdVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzen.zze(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            zze += obj instanceof zzft ? zzen.zza((zzft) obj) : zzen.a((zzgo) obj, zzhdVar);
        }
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * zzen.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgc) {
            zzgc zzgcVar = (zzgc) list;
            i = 0;
            while (i2 < size) {
                i += zzen.zzd(zzgcVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzen.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, int i2, UB ub, zzhv<UT, UB> zzhvVar) {
        if (ub == null) {
            ub = zzhvVar.a();
        }
        zzhvVar.a((zzhv<UT, UB>) ub, i, i2);
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, List<Integer> list, zzfk zzfkVar, UB ub, zzhv<UT, UB> zzhvVar) {
        UB ub2;
        int intValue;
        if (zzfkVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue2 = list.get(i3).intValue();
                if (zzfkVar.zza(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = (UB) a(i, intValue2, ub2, zzhvVar);
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
                    if (!zzfkVar.zza(intValue)) {
                        break;
                    }
                }
                ub = (UB) a(i, intValue, ub2, zzhvVar);
                it.remove();
            }
        }
        return ub2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzey<FT>> void a(zzes<FT> zzesVar, T t, T t2) {
        zzew<FT> a = zzesVar.a(t2);
        if (a.a.isEmpty()) {
            return;
        }
        zzesVar.b(t).zza(a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void a(zzgh zzghVar, T t, T t2, long j) {
        zzib.a(t, j, zzghVar.zza(zzib.f(t, j), zzib.f(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void a(zzhv<UT, UB> zzhvVar, T t, T t2) {
        zzhvVar.a(t, zzhvVar.c(zzhvVar.b(t), zzhvVar.b(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzdu> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = size * zzen.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzen.zzb(list.get(i2));
        }
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzgo> list, zzhd zzhdVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzen.c(i, list.get(i3), zzhdVar);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return b(list) + (size * zzen.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgc) {
            zzgc zzgcVar = (zzgc) list;
            i = 0;
            while (i2 < size) {
                i += zzen.zze(zzgcVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzen.zze(list.get(i2).longValue());
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
        return c(list) + (size * zzen.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgc) {
            zzgc zzgcVar = (zzgc) list;
            i = 0;
            while (i2 < size) {
                i += zzen.zzf(zzgcVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzen.zzf(list.get(i2).longValue());
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
        return d(list) + (size * zzen.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfg) {
            zzfg zzfgVar = (zzfg) list;
            i = 0;
            while (i2 < size) {
                i += zzen.zzk(zzfgVar.zzc(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzen.zzk(list.get(i2).intValue());
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
        return e(list) + (size * zzen.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfg) {
            zzfg zzfgVar = (zzfg) list;
            i = 0;
            while (i2 < size) {
                i += zzen.zzf(zzfgVar.zzc(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzen.zzf(list.get(i2).intValue());
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
        return f(list) + (size * zzen.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfg) {
            zzfg zzfgVar = (zzfg) list;
            i = 0;
            while (i2 < size) {
                i += zzen.zzg(zzfgVar.zzc(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzen.zzg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g(list) + (size * zzen.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfg) {
            zzfg zzfgVar = (zzfg) list;
            i = 0;
            while (i2 < size) {
                i += zzen.zzh(zzfgVar.zzc(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzen.zzh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzen.zzi(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzen.zzg(i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzen.zzb(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(List<?> list) {
        return list.size();
    }

    public static zzhv<?, ?> zza() {
        return zzb;
    }

    private static zzhv<?, ?> zza(boolean z) {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzhv) zze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zza(int i, List<String> list, zzis zzisVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zza(i, list);
    }

    public static void zza(int i, List<?> list, zzis zzisVar, zzhd zzhdVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zza(i, list, zzhdVar);
    }

    public static void zza(int i, List<Double> list, zzis zzisVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzg(i, list, z);
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzfd.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static zzhv<?, ?> zzb() {
        return zzc;
    }

    public static void zzb(int i, List<zzdu> list, zzis zzisVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzb(i, list);
    }

    public static void zzb(int i, List<?> list, zzis zzisVar, zzhd zzhdVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzb(i, list, zzhdVar);
    }

    public static void zzb(int i, List<Float> list, zzis zzisVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzf(i, list, z);
    }

    public static zzhv<?, ?> zzc() {
        return zzd;
    }

    public static void zzc(int i, List<Long> list, zzis zzisVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzc(i, list, z);
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzd(int i, List<Long> list, zzis zzisVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzd(i, list, z);
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zze(int i, List<Long> list, zzis zzisVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzn(i, list, z);
    }

    public static void zzf(int i, List<Long> list, zzis zzisVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zze(i, list, z);
    }

    public static void zzg(int i, List<Long> list, zzis zzisVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzl(i, list, z);
    }

    public static void zzh(int i, List<Integer> list, zzis zzisVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zza(i, list, z);
    }

    public static void zzi(int i, List<Integer> list, zzis zzisVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzj(i, list, z);
    }

    public static void zzj(int i, List<Integer> list, zzis zzisVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzm(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzis zzisVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzb(i, list, z);
    }

    public static void zzl(int i, List<Integer> list, zzis zzisVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzk(i, list, z);
    }

    public static void zzm(int i, List<Integer> list, zzis zzisVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzh(i, list, z);
    }

    public static void zzn(int i, List<Boolean> list, zzis zzisVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzi(i, list, z);
    }
}
