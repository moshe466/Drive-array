package kotlinx.coroutines.scheduling;

/* loaded from: classes.dex */
public final class c extends f {

    /* renamed from: l, reason: collision with root package name */
    public static final c f11688l = new c();

    private c() {
        super(l.f11700b, l.f11701c, l.f11702d, "DefaultDispatcher");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // nb.u
    public String toString() {
        return "Dispatchers.Default";
    }
}
