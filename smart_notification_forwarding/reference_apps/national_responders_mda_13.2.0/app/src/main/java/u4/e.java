package u4;

import com.google.firebase.installations.o;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
class e {

    /* renamed from: d, reason: collision with root package name */
    private static final long f14378d = TimeUnit.HOURS.toMillis(24);

    /* renamed from: e, reason: collision with root package name */
    private static final long f14379e = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: a, reason: collision with root package name */
    private final o f14380a = o.c();

    /* renamed from: b, reason: collision with root package name */
    private long f14381b;

    /* renamed from: c, reason: collision with root package name */
    private int f14382c;

    private synchronized long a(int i10) {
        if (c(i10)) {
            return (long) Math.min(Math.pow(2.0d, this.f14382c) + this.f14380a.e(), f14379e);
        }
        return f14378d;
    }

    private static boolean c(int i10) {
        return i10 == 429 || (i10 >= 500 && i10 < 600);
    }

    private static boolean d(int i10) {
        return (i10 >= 200 && i10 < 300) || i10 == 401 || i10 == 404;
    }

    private synchronized void e() {
        this.f14382c = 0;
    }

    public synchronized boolean b() {
        boolean z10;
        if (this.f14382c != 0) {
            z10 = this.f14380a.a() > this.f14381b;
        }
        return z10;
    }

    public synchronized void f(int i10) {
        if (d(i10)) {
            e();
            return;
        }
        this.f14382c++;
        this.f14381b = this.f14380a.a() + a(i10);
    }
}
