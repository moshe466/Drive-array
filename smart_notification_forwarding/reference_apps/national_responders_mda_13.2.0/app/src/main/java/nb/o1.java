package nb;

/* loaded from: classes.dex */
public final class o1 {

    /* renamed from: a, reason: collision with root package name */
    public static final o1 f12412a = new o1();

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<p0> f12413b = new ThreadLocal<>();

    private o1() {
    }

    public final p0 a() {
        ThreadLocal<p0> threadLocal = f12413b;
        p0 p0Var = threadLocal.get();
        if (p0Var != null) {
            return p0Var;
        }
        p0 a10 = s0.a();
        threadLocal.set(a10);
        return a10;
    }

    public final void b() {
        f12413b.set(null);
    }

    public final void c(p0 p0Var) {
        f12413b.set(p0Var);
    }
}
