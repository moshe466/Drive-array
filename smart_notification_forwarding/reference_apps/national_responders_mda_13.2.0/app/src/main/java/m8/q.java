package m8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends p {
    public static final <T> Collection<T> c(T[] tArr) {
        y8.k.e(tArr, "<this>");
        return new f(tArr, false);
    }

    public static <T> List<T> d() {
        return a0.f12025f;
    }

    public static d9.c e(Collection<?> collection) {
        y8.k.e(collection, "<this>");
        return new d9.c(0, collection.size() - 1);
    }

    public static final <T> int f(List<? extends T> list) {
        y8.k.e(list, "<this>");
        return list.size() - 1;
    }

    public static <T> List<T> g(T... tArr) {
        y8.k.e(tArr, "elements");
        return tArr.length > 0 ? g.c(tArr) : o.d();
    }

    public static <T> List<T> h(T t10) {
        return t10 != null ? o.b(t10) : o.d();
    }

    public static <T> List<T> i(T... tArr) {
        y8.k.e(tArr, "elements");
        return g.n(tArr);
    }

    public static <T> List<T> j(T... tArr) {
        y8.k.e(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new f(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> k(List<? extends T> list) {
        y8.k.e(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : o.b(list.get(0)) : o.d();
    }

    public static void l() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void m() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
