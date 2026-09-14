package n8;

import java.util.Arrays;
import y8.k;

/* loaded from: classes.dex */
public final class b {
    public static final <E> E[] a(int i10) {
        if (i10 >= 0) {
            return (E[]) new Object[i10];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final <T> T[] b(T[] tArr, int i10) {
        k.e(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i10);
        k.d(tArr2, "copyOf(this, newSize)");
        k.c(tArr2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilderKt.copyOfUninitializedElements>");
        return tArr2;
    }

    public static final <E> void c(E[] eArr, int i10) {
        k.e(eArr, "<this>");
        eArr[i10] = null;
    }

    public static final <E> void d(E[] eArr, int i10, int i11) {
        k.e(eArr, "<this>");
        while (i10 < i11) {
            c(eArr, i10);
            i10++;
        }
    }
}
