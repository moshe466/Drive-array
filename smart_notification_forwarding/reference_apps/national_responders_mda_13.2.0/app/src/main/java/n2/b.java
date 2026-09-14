package n2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public interface b {
    ExecutorService a(ThreadFactory threadFactory, int i10);

    ScheduledExecutorService b(int i10, ThreadFactory threadFactory, int i11);
}
