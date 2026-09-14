package ab;

/* loaded from: classes.dex */
class l<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f380a;

    /* renamed from: b, reason: collision with root package name */
    private final Thread f381b = Thread.currentThread();

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(T t10) {
        this.f380a = t10;
    }

    public T a() {
        if (b()) {
            return this.f380a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean b() {
        return this.f381b == Thread.currentThread();
    }
}
