package m8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p {
    public static final <T> Object[] a(T[] tArr, boolean z10) {
        y8.k.e(tArr, "<this>");
        if (z10 && y8.k.a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        y8.k.d(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    public static <T> List<T> b(T t10) {
        List<T> singletonList = Collections.singletonList(t10);
        y8.k.d(singletonList, "singletonList(element)");
        return singletonList;
    }
}
