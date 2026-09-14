package com.google.android.gms.common.util;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import t.C0690f;
import t.C0694j;

/* loaded from: classes.dex */
public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static boolean isEmpty(Collection<?> collection) {
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    @Deprecated
    public static <T> List<T> listOf() {
        return Collections.EMPTY_LIST;
    }

    public static <K, V> Map<K, V> mapOf(K k4, V v2, K k5, V v3, K k6, V v4) {
        Map zzb = zzb(3, false);
        zzb.put(k4, v2);
        zzb.put(k5, v3);
        zzb.put(k6, v4);
        return Collections.unmodifiableMap(zzb);
    }

    public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] kArr, V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length == length2) {
            if (length != 0) {
                if (length != 1) {
                    Map zzb = zzb(length, false);
                    for (int i = 0; i < kArr.length; i++) {
                        zzb.put(kArr[i], vArr[i]);
                    }
                    return Collections.unmodifiableMap(zzb);
                }
                return Collections.singletonMap(kArr[0], vArr[0]);
            }
            return Collections.EMPTY_MAP;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 44 + String.valueOf(length2).length());
        sb.append("Key and values array lengths not equal: ");
        sb.append(length);
        sb.append(" != ");
        sb.append(length2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static <T> Set<T> mutableSetOfWithSize(int i) {
        if (i == 0) {
            return new C0690f(0);
        }
        return zza(i, true);
    }

    @Deprecated
    public static <T> Set<T> setOf(T t3, T t4, T t5) {
        Set zza = zza(3, false);
        zza.add(t3);
        zza.add(t4);
        zza.add(t5);
        return Collections.unmodifiableSet(zza);
    }

    private static Set zza(int i, boolean z3) {
        int i3;
        float f4;
        if (true != z3) {
            i3 = UserVerificationMethods.USER_VERIFY_HANDPRINT;
        } else {
            i3 = 128;
        }
        if (i <= i3) {
            return new C0690f(i);
        }
        if (true != z3) {
            f4 = 1.0f;
        } else {
            f4 = 0.75f;
        }
        return new HashSet(i, f4);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [t.j, java.util.Map] */
    private static Map zzb(int i, boolean z3) {
        if (i <= 256) {
            return new C0694j(i);
        }
        return new HashMap(i, 1.0f);
    }

    @Deprecated
    public static <T> List<T> listOf(T t3) {
        return Collections.singletonList(t3);
    }

    @Deprecated
    public static <T> List<T> listOf(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.EMPTY_LIST;
        }
        if (length != 1) {
            return Collections.unmodifiableList(Arrays.asList(tArr));
        }
        return Collections.singletonList(tArr[0]);
    }

    public static <K, V> Map<K, V> mapOf(K k4, V v2, K k5, V v3, K k6, V v4, K k7, V v5, K k8, V v6, K k9, V v7) {
        Map zzb = zzb(6, false);
        zzb.put(k4, v2);
        zzb.put(k5, v3);
        zzb.put(k6, v4);
        zzb.put(k7, v5);
        zzb.put(k8, v6);
        zzb.put(k9, v7);
        return Collections.unmodifiableMap(zzb);
    }

    @Deprecated
    public static <T> Set<T> setOf(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.EMPTY_SET;
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t3 = tArr[0];
            T t4 = tArr[1];
            Set zza = zza(2, false);
            zza.add(t3);
            zza.add(t4);
            return Collections.unmodifiableSet(zza);
        }
        if (length == 3) {
            return setOf(tArr[0], tArr[1], tArr[2]);
        }
        if (length != 4) {
            Set zza2 = zza(length, false);
            Collections.addAll(zza2, tArr);
            return Collections.unmodifiableSet(zza2);
        }
        T t5 = tArr[0];
        T t6 = tArr[1];
        T t7 = tArr[2];
        T t8 = tArr[3];
        Set zza3 = zza(4, false);
        zza3.add(t5);
        zza3.add(t6);
        zza3.add(t7);
        zza3.add(t8);
        return Collections.unmodifiableSet(zza3);
    }
}
