package z2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class n0 implements Executor {

    /* renamed from: f, reason: collision with root package name */
    private final Handler f16110f = new r2.a(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f16110f.post(runnable);
    }
}
