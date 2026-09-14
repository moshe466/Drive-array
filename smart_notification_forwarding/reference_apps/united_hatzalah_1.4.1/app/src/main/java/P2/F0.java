package P2;

/* loaded from: classes.dex */
public abstract class F0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f1603a = new ThreadLocal();

    public static Z a() {
        ThreadLocal threadLocal = f1603a;
        Z z3 = (Z) threadLocal.get();
        if (z3 == null) {
            C0156i c0156i = new C0156i(Thread.currentThread());
            threadLocal.set(c0156i);
            return c0156i;
        }
        return z3;
    }
}
