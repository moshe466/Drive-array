package com.google.android.gms.internal.fido;

import java.util.Comparator;
import java.util.SortedSet;

/* loaded from: classes.dex */
final class zzca {
    public static boolean zza(Comparator comparator, Iterable iterable) {
        Comparator comparator2;
        comparator.getClass();
        iterable.getClass();
        if (iterable instanceof SortedSet) {
            comparator2 = ((SortedSet) iterable).comparator();
            if (comparator2 == null) {
                comparator2 = zzbp.zza;
            }
        } else if (iterable instanceof zzbz) {
            comparator2 = ((zzbz) iterable).comparator();
        } else {
            return false;
        }
        return comparator.equals(comparator2);
    }
}
