package sb;

/* loaded from: classes.dex */
public abstract class b implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    protected final String f14195f;

    public b(String str, Object... objArr) {
        this.f14195f = c.r(str, objArr);
    }

    protected abstract void k();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f14195f);
        try {
            k();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
