package okhttp3.internal;

/* loaded from: classes3.dex */
public abstract class NamedRunnable implements Runnable {
    protected final String a;

    public NamedRunnable(String str, Object... objArr) {
        this.a = Util.format(str, objArr);
    }

    protected abstract void execute();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.a);
        try {
            execute();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
