package androidx.core.os;

import android.os.Build;
import android.os.CancellationSignal;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2420a;

    /* renamed from: b, reason: collision with root package name */
    private b f2421b;

    /* renamed from: c, reason: collision with root package name */
    private Object f2422c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2423d;

    /* loaded from: classes.dex */
    static class a {
        static void a(Object obj) {
            ((CancellationSignal) obj).cancel();
        }

        static CancellationSignal b() {
            return new CancellationSignal();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    private void c() {
        while (this.f2423d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            if (this.f2420a) {
                return;
            }
            this.f2420a = true;
            this.f2423d = true;
            b bVar = this.f2421b;
            Object obj = this.f2422c;
            if (bVar != null) {
                try {
                    bVar.a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f2423d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                a.a(obj);
            }
            synchronized (this) {
                this.f2423d = false;
                notifyAll();
            }
        }
    }

    public void b(b bVar) {
        synchronized (this) {
            c();
            if (this.f2421b == bVar) {
                return;
            }
            this.f2421b = bVar;
            if (this.f2420a && bVar != null) {
                bVar.a();
            }
        }
    }
}
