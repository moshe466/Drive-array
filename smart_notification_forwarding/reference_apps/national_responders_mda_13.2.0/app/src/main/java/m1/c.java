package m1;

/* loaded from: classes.dex */
public final class c<T> implements b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f12009a;

    static {
        new c(null);
    }

    private c(T t10) {
        this.f12009a = t10;
    }

    public static <T> b<T> a(T t10) {
        return new c(d.c(t10, "instance cannot be null"));
    }

    @Override // k8.a
    public T get() {
        return this.f12009a;
    }
}
