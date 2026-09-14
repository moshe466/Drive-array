package F0;

import java.util.concurrent.ThreadFactory;
import org.apache.tika.concurrent.SimpleThreadPoolExecutor;

/* loaded from: classes.dex */
public final /* synthetic */ class B implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f170a;

    public /* synthetic */ B(int i) {
        this.f170a = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f170a) {
            case 0:
                Thread thread = new Thread(runnable);
                thread.setDaemon(true);
                return thread;
            default:
                return SimpleThreadPoolExecutor.a(runnable);
        }
    }
}
