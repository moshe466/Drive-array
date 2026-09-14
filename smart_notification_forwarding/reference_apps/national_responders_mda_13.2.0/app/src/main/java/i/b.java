package i;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: a, reason: collision with root package name */
    private final Object f10714a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final ExecutorService f10715b = Executors.newFixedThreadPool(4, new a(this));

    /* renamed from: c, reason: collision with root package name */
    private volatile Handler f10716c;

    /* loaded from: classes.dex */
    class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f10717a = new AtomicInteger(0);

        a(b bVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f10717a.getAndIncrement())));
            return thread;
        }
    }

    private static Handler d(Looper looper) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            return Handler.createAsync(looper);
        }
        if (i10 >= 16) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            } catch (InvocationTargetException unused2) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }

    @Override // i.c
    public void a(Runnable runnable) {
        this.f10715b.execute(runnable);
    }

    @Override // i.c
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // i.c
    public void c(Runnable runnable) {
        if (this.f10716c == null) {
            synchronized (this.f10714a) {
                if (this.f10716c == null) {
                    this.f10716c = d(Looper.getMainLooper());
                }
            }
        }
        this.f10716c.post(runnable);
    }
}
