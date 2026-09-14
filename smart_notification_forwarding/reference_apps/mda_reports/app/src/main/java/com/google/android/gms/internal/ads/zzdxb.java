package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class zzdxb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> HashSet<T> a(int i) {
        return new HashSet<>(zzhk(i));
    }

    public static <T> List<T> zzhh(int i) {
        return i == 0 ? Collections.emptyList() : new ArrayList(i);
    }

    public static <K, V> LinkedHashMap<K, V> zzhj(int i) {
        return new LinkedHashMap<>(zzhk(i));
    }

    private static int zzhk(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }
}
