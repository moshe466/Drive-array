package m8;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends v {
    public static <T> List<T> w(List<T> list) {
        y8.k.e(list, "<this>");
        return new o0(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int x(List<?> list, int i10) {
        if (new d9.c(0, q.f(list)).t(i10)) {
            return q.f(list) - i10;
        }
        throw new IndexOutOfBoundsException("Element index " + i10 + " must be in range [" + new d9.c(0, q.f(list)) + "].");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int y(List<?> list, int i10) {
        if (new d9.c(0, list.size()).t(i10)) {
            return list.size() - i10;
        }
        throw new IndexOutOfBoundsException("Position index " + i10 + " must be in range [" + new d9.c(0, list.size()) + "].");
    }
}
