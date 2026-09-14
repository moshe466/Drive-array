package a0;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    public static final ThreadLocal<a> f1g = new ThreadLocal<>();

    /* renamed from: d, reason: collision with root package name */
    private c f5d;

    /* renamed from: a, reason: collision with root package name */
    private final l.g<b, Long> f2a = new l.g<>();

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<b> f3b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final C0002a f4c = new C0002a();

    /* renamed from: e, reason: collision with root package name */
    long f6e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f7f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0002a {
        C0002a() {
        }

        void a() {
            a.this.f6e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.c(aVar.f6e);
            if (a.this.f3b.size() > 0) {
                a.this.e().a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(long j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final C0002a f9a;

        c(C0002a c0002a) {
            this.f9a = c0002a;
        }

        abstract void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends c {

        /* renamed from: b, reason: collision with root package name */
        private final Runnable f10b;

        /* renamed from: c, reason: collision with root package name */
        private final Handler f11c;

        /* renamed from: d, reason: collision with root package name */
        long f12d;

        /* renamed from: a0.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0003a implements Runnable {
            RunnableC0003a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f12d = SystemClock.uptimeMillis();
                d.this.f9a.a();
            }
        }

        d(C0002a c0002a) {
            super(c0002a);
            this.f12d = -1L;
            this.f10b = new RunnableC0003a();
            this.f11c = new Handler(Looper.myLooper());
        }

        @Override // a0.a.c
        void a() {
            this.f11c.postDelayed(this.f10b, Math.max(10 - (SystemClock.uptimeMillis() - this.f12d), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e extends c {

        /* renamed from: b, reason: collision with root package name */
        private final Choreographer f14b;

        /* renamed from: c, reason: collision with root package name */
        private final Choreographer.FrameCallback f15c;

        /* renamed from: a0.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class ChoreographerFrameCallbackC0004a implements Choreographer.FrameCallback {
            ChoreographerFrameCallbackC0004a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j10) {
                e.this.f9a.a();
            }
        }

        e(C0002a c0002a) {
            super(c0002a);
            this.f14b = Choreographer.getInstance();
            this.f15c = new ChoreographerFrameCallbackC0004a();
        }

        @Override // a0.a.c
        void a() {
            this.f14b.postFrameCallback(this.f15c);
        }
    }

    a() {
    }

    private void b() {
        if (this.f7f) {
            for (int size = this.f3b.size() - 1; size >= 0; size--) {
                if (this.f3b.get(size) == null) {
                    this.f3b.remove(size);
                }
            }
            this.f7f = false;
        }
    }

    public static a d() {
        ThreadLocal<a> threadLocal = f1g;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return threadLocal.get();
    }

    private boolean f(b bVar, long j10) {
        Long l10 = this.f2a.get(bVar);
        if (l10 == null) {
            return true;
        }
        if (l10.longValue() >= j10) {
            return false;
        }
        this.f2a.remove(bVar);
        return true;
    }

    public void a(b bVar, long j10) {
        if (this.f3b.size() == 0) {
            e().a();
        }
        if (!this.f3b.contains(bVar)) {
            this.f3b.add(bVar);
        }
        if (j10 > 0) {
            this.f2a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j10));
        }
    }

    void c(long j10) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i10 = 0; i10 < this.f3b.size(); i10++) {
            b bVar = this.f3b.get(i10);
            if (bVar != null && f(bVar, uptimeMillis)) {
                bVar.a(j10);
            }
        }
        b();
    }

    c e() {
        if (this.f5d == null) {
            this.f5d = Build.VERSION.SDK_INT >= 16 ? new e(this.f4c) : new d(this.f4c);
        }
        return this.f5d;
    }

    public void g(b bVar) {
        this.f2a.remove(bVar);
        int indexOf = this.f3b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f3b.set(indexOf, null);
            this.f7f = true;
        }
    }
}
