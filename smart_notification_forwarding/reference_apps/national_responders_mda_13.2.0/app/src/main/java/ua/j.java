package ua;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import m8.v;

/* loaded from: classes.dex */
public final class j {
    public static final Set<la.e> a(Iterable<? extends h> iterable) {
        y8.k.e(iterable, "<this>");
        HashSet hashSet = new HashSet();
        Iterator<? extends h> it = iterable.iterator();
        while (it.hasNext()) {
            Set<la.e> f10 = it.next().f();
            if (f10 == null) {
                return null;
            }
            v.r(hashSet, f10);
        }
        return hashSet;
    }
}
