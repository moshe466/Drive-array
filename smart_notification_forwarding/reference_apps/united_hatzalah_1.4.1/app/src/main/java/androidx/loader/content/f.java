package androidx.loader.content;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class f implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3643a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f3644b;

    public f(int i) {
        this.f3643a = i;
        switch (i) {
            case 1:
                this.f3644b = new AtomicInteger(0);
                return;
            default:
                this.f3644b = new AtomicInteger(1);
                return;
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f3643a) {
            case 0:
                return new Thread(runnable, "ModernAsyncTask #" + this.f3644b.getAndIncrement());
            default:
                Thread thread = new Thread(runnable);
                thread.setName("arch_disk_io_" + this.f3644b.getAndIncrement());
                return thread;
        }
    }
}
