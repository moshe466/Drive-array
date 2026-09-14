package m8;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r0 extends q0 {
    public static <T> Set<T> b() {
        return c0.f12034f;
    }

    public static <T> LinkedHashSet<T> c(T... tArr) {
        int d10;
        y8.k.e(tArr, "elements");
        d10 = k0.d(tArr.length);
        return (LinkedHashSet) k.H(tArr, new LinkedHashSet(d10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> d(Set<? extends T> set) {
        Set<T> b10;
        Set<T> a10;
        y8.k.e(set, "<this>");
        int size = set.size();
        if (size == 0) {
            b10 = b();
            return b10;
        }
        if (size != 1) {
            return set;
        }
        a10 = q0.a(set.iterator().next());
        return a10;
    }

    public static <T> Set<T> e(T... tArr) {
        Set<T> b10;
        Set<T> a02;
        y8.k.e(tArr, "elements");
        if (tArr.length > 0) {
            a02 = k.a0(tArr);
            return a02;
        }
        b10 = b();
        return b10;
    }
}
