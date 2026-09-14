package androidx.loader.content;

import android.os.Binder;
import android.os.Process;
import androidx.core.os.OperationCanceledException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class g implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f3645a;

    public g(a aVar) {
        this.f3645a = aVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        a aVar = this.f3645a;
        AtomicBoolean atomicBoolean = aVar.f3638d;
        aVar.f3639e.set(true);
        Object obj = null;
        try {
            Process.setThreadPriority(10);
            try {
                obj = aVar.f3642k.onLoadInBackground();
            } catch (OperationCanceledException e4) {
                if (!atomicBoolean.get()) {
                    throw e4;
                }
            }
            Binder.flushPendingCommands();
            return obj;
        } catch (Throwable th) {
            try {
                atomicBoolean.set(true);
                throw th;
            } finally {
                aVar.a(null);
            }
        }
    }
}
