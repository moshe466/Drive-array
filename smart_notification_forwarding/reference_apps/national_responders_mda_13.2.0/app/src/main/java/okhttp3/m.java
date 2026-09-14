package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.x;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: c, reason: collision with root package name */
    private Runnable f12783c;

    /* renamed from: d, reason: collision with root package name */
    private ExecutorService f12784d;

    /* renamed from: a, reason: collision with root package name */
    private int f12781a = 64;

    /* renamed from: b, reason: collision with root package name */
    private int f12782b = 5;

    /* renamed from: e, reason: collision with root package name */
    private final Deque<x.b> f12785e = new ArrayDeque();

    /* renamed from: f, reason: collision with root package name */
    private final Deque<x.b> f12786f = new ArrayDeque();

    /* renamed from: g, reason: collision with root package name */
    private final Deque<x> f12787g = new ArrayDeque();

    private <T> void d(Deque<T> deque, T t10) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t10)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f12783c;
        }
        if (g() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private boolean g() {
        int i10;
        boolean z10;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<x.b> it = this.f12785e.iterator();
            while (it.hasNext()) {
                x.b next = it.next();
                if (this.f12786f.size() >= this.f12781a) {
                    break;
                }
                if (i(next) < this.f12782b) {
                    it.remove();
                    arrayList.add(next);
                    this.f12786f.add(next);
                }
            }
            z10 = h() > 0;
        }
        int size = arrayList.size();
        for (i10 = 0; i10 < size; i10++) {
            ((x.b) arrayList.get(i10)).l(c());
        }
        return z10;
    }

    private int i(x.b bVar) {
        int i10 = 0;
        for (x.b bVar2 : this.f12786f) {
            if (!bVar2.m().f12886k && bVar2.n().equals(bVar.n())) {
                i10++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(x.b bVar) {
        synchronized (this) {
            this.f12785e.add(bVar);
        }
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(x xVar) {
        this.f12787g.add(xVar);
    }

    public synchronized ExecutorService c() {
        if (this.f12784d == null) {
            this.f12784d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), sb.c.G("OkHttp Dispatcher", false));
        }
        return this.f12784d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(x.b bVar) {
        d(this.f12786f, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(x xVar) {
        d(this.f12787g, xVar);
    }

    public synchronized int h() {
        return this.f12786f.size() + this.f12787g.size();
    }
}
