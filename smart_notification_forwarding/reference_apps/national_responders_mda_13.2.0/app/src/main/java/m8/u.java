package m8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends t {
    public static final <T extends Comparable<? super T>> void p(List<T> list) {
        y8.k.e(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static <T> void q(List<T> list, Comparator<? super T> comparator) {
        y8.k.e(list, "<this>");
        y8.k.e(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
