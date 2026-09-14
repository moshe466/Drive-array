package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.e0;
import nb.u;
import nb.u0;

/* loaded from: classes.dex */
public final class b extends u0 implements Executor {

    /* renamed from: g, reason: collision with root package name */
    public static final b f11686g = new b();

    /* renamed from: h, reason: collision with root package name */
    private static final u f11687h;

    static {
        int a10;
        int d10;
        m mVar = m.f11706g;
        a10 = d9.f.a(64, c0.a());
        d10 = e0.d("kotlinx.coroutines.io.parallelism", a10, 0, 0, 12, null);
        f11687h = mVar.b0(d10);
    }

    private b() {
    }

    @Override // nb.u
    public void c(p8.f fVar, Runnable runnable) {
        f11687h.c(fVar, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c(p8.g.f13128f, runnable);
    }

    @Override // nb.u
    public String toString() {
        return "Dispatchers.IO";
    }
}
