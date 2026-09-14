package h9;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class l0 {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<ClassLoader> f10608a;

    /* renamed from: b, reason: collision with root package name */
    private final int f10609b;

    public l0(ClassLoader classLoader) {
        y8.k.e(classLoader, "classLoader");
        this.f10608a = new WeakReference<>(classLoader);
        this.f10609b = System.identityHashCode(classLoader);
    }

    public final void a(ClassLoader classLoader) {
    }

    public boolean equals(Object obj) {
        return (obj instanceof l0) && this.f10608a.get() == ((l0) obj).f10608a.get();
    }

    public int hashCode() {
        return this.f10609b;
    }

    public String toString() {
        String classLoader;
        ClassLoader classLoader2 = this.f10608a.get();
        return (classLoader2 == null || (classLoader = classLoader2.toString()) == null) ? "<null>" : classLoader;
    }
}
