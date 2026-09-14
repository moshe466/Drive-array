package m2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class l implements j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(k kVar) {
    }

    @Override // m2.j
    public final ExecutorService a(ThreadFactory threadFactory, int i10) {
        return b(1, threadFactory, 1);
    }

    @Override // m2.j
    public final ExecutorService b(int i10, ThreadFactory threadFactory, int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i10, i10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
}
