package W2;

import P2.A;

/* loaded from: classes.dex */
public final class e extends h {

    /* renamed from: d, reason: collision with root package name */
    public static final e f2533d;

    /* JADX WARN: Type inference failed for: r0v0, types: [P2.A, W2.e, W2.h] */
    static {
        int i = l.f2542c;
        int i3 = l.f2543d;
        long j2 = l.f2544e;
        String str = l.f2540a;
        ?? a2 = new A();
        a2.f2535c = new c(i, i3, j2, str);
        f2533d = a2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // P2.A
    public final String toString() {
        return "Dispatchers.Default";
    }
}
