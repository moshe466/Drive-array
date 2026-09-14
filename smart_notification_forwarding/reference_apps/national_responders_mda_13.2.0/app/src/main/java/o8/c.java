package o8;

import y8.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends b {
    public static <T extends Comparable<? super T>> T b(T t10, T t11) {
        k.e(t10, "a");
        k.e(t11, "b");
        return t10.compareTo(t11) >= 0 ? t10 : t11;
    }
}
