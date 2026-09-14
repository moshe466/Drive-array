package F;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class d implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f158a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f159b;

    public /* synthetic */ d(Object obj, int i) {
        this.f158a = i;
        this.f159b = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f158a) {
            case 0:
                Handler handler = (Handler) this.f159b;
                runnable.getClass();
                if (handler.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler + " is shutting down");
            case 1:
                Handler handler2 = (Handler) this.f159b;
                runnable.getClass();
                if (handler2.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler2 + " is shutting down");
            case 2:
                ((Handler) this.f159b).post(runnable);
                return;
            case 3:
                ((Handler) this.f159b).post(runnable);
                return;
            default:
                ((Executor) this.f159b).execute(new G.a(runnable, 10));
                return;
        }
    }

    public d(int i) {
        this.f158a = i;
        switch (i) {
            case 3:
                this.f159b = new Handler(Looper.getMainLooper());
                return;
            default:
                this.f159b = new Handler(Looper.getMainLooper());
                return;
        }
    }
}
