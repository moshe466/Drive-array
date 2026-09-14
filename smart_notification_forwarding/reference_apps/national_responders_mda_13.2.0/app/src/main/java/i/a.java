package i;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f10711c;

    /* renamed from: a, reason: collision with root package name */
    private c f10712a;

    /* renamed from: b, reason: collision with root package name */
    private c f10713b;

    /* renamed from: i.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class ExecutorC0197a implements Executor {
        ExecutorC0197a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.d().c(runnable);
        }
    }

    /* loaded from: classes.dex */
    static class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.d().a(runnable);
        }
    }

    static {
        new ExecutorC0197a();
        new b();
    }

    private a() {
        i.b bVar = new i.b();
        this.f10713b = bVar;
        this.f10712a = bVar;
    }

    public static a d() {
        if (f10711c != null) {
            return f10711c;
        }
        synchronized (a.class) {
            if (f10711c == null) {
                f10711c = new a();
            }
        }
        return f10711c;
    }

    @Override // i.c
    public void a(Runnable runnable) {
        this.f10712a.a(runnable);
    }

    @Override // i.c
    public boolean b() {
        return this.f10712a.b();
    }

    @Override // i.c
    public void c(Runnable runnable) {
        this.f10712a.c(runnable);
    }
}
