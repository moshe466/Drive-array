package androidx.loader.content;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: l, reason: collision with root package name */
    public static final ThreadPoolExecutor f3632l;

    /* renamed from: m, reason: collision with root package name */
    public static j f3633m;

    /* renamed from: n, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f3634n;

    /* renamed from: a, reason: collision with root package name */
    public final g f3635a;

    /* renamed from: b, reason: collision with root package name */
    public final h f3636b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f3637c = 1;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f3638d = new AtomicBoolean();

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f3639e = new AtomicBoolean();

    /* renamed from: f, reason: collision with root package name */
    public final CountDownLatch f3640f;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3641j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ b f3642k;

    static {
        f fVar = new f(0);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), fVar);
        f3632l = threadPoolExecutor;
        f3634n = threadPoolExecutor;
    }

    public a(b bVar) {
        this.f3642k = bVar;
        g gVar = new g(this);
        this.f3635a = gVar;
        this.f3636b = new h(this, gVar);
        this.f3640f = new CountDownLatch(1);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.loader.content.j, android.os.Handler] */
    public final void a(Object obj) {
        j jVar;
        synchronized (a.class) {
            try {
                if (f3633m == null) {
                    f3633m = new Handler(Looper.getMainLooper());
                }
                jVar = f3633m;
            } catch (Throwable th) {
                throw th;
            }
        }
        jVar.obtainMessage(1, new i(this, obj)).sendToTarget();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3641j = false;
        this.f3642k.executePendingTask();
    }
}
