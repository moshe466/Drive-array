package h2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import o2.i;

/* loaded from: classes.dex */
public class a implements Executor {

    /* renamed from: f, reason: collision with root package name */
    private final Handler f10440f;

    public a(Looper looper) {
        this.f10440f = new i(looper);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f10440f.post(runnable);
    }
}
