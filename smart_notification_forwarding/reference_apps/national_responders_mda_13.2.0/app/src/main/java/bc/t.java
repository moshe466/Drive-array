package bc;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class t {

    /* renamed from: d, reason: collision with root package name */
    public static final t f4339d = new a();

    /* renamed from: a, reason: collision with root package name */
    private boolean f4340a;

    /* renamed from: b, reason: collision with root package name */
    private long f4341b;

    /* renamed from: c, reason: collision with root package name */
    private long f4342c;

    /* loaded from: classes.dex */
    final class a extends t {
        a() {
        }

        @Override // bc.t
        public t d(long j10) {
            return this;
        }

        @Override // bc.t
        public void f() {
        }

        @Override // bc.t
        public t g(long j10, TimeUnit timeUnit) {
            return this;
        }
    }

    public t a() {
        this.f4340a = false;
        return this;
    }

    public t b() {
        this.f4342c = 0L;
        return this;
    }

    public long c() {
        if (this.f4340a) {
            return this.f4341b;
        }
        throw new IllegalStateException("No deadline");
    }

    public t d(long j10) {
        this.f4340a = true;
        this.f4341b = j10;
        return this;
    }

    public boolean e() {
        return this.f4340a;
    }

    public void f() {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f4340a && this.f4341b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public t g(long j10, TimeUnit timeUnit) {
        if (j10 >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.f4342c = timeUnit.toNanos(j10);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + j10);
    }

    public long h() {
        return this.f4342c;
    }
}
