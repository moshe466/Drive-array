package bc;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class a extends t {

    /* renamed from: h, reason: collision with root package name */
    private static final long f4285h;

    /* renamed from: i, reason: collision with root package name */
    private static final long f4286i;

    /* renamed from: j, reason: collision with root package name */
    static a f4287j;

    /* renamed from: e, reason: collision with root package name */
    private boolean f4288e;

    /* renamed from: f, reason: collision with root package name */
    private a f4289f;

    /* renamed from: g, reason: collision with root package name */
    private long f4290g;

    /* renamed from: bc.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0074a implements r {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ r f4291f;

        C0074a(r rVar) {
            this.f4291f = rVar;
        }

        @Override // bc.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a.this.k();
            try {
                try {
                    this.f4291f.close();
                    a.this.m(true);
                } catch (IOException e10) {
                    throw a.this.l(e10);
                }
            } catch (Throwable th) {
                a.this.m(false);
                throw th;
            }
        }

        @Override // bc.r
        public t e() {
            return a.this;
        }

        @Override // bc.r, java.io.Flushable
        public void flush() {
            a.this.k();
            try {
                try {
                    this.f4291f.flush();
                    a.this.m(true);
                } catch (IOException e10) {
                    throw a.this.l(e10);
                }
            } catch (Throwable th) {
                a.this.m(false);
                throw th;
            }
        }

        @Override // bc.r
        public void l(bc.c cVar, long j10) {
            u.b(cVar.f4298g, 0L, j10);
            while (true) {
                long j11 = 0;
                if (j10 <= 0) {
                    return;
                }
                o oVar = cVar.f4297f;
                while (true) {
                    if (j11 >= 65536) {
                        break;
                    }
                    j11 += oVar.f4330c - oVar.f4329b;
                    if (j11 >= j10) {
                        j11 = j10;
                        break;
                    }
                    oVar = oVar.f4333f;
                }
                a.this.k();
                try {
                    try {
                        this.f4291f.l(cVar, j11);
                        j10 -= j11;
                        a.this.m(true);
                    } catch (IOException e10) {
                        throw a.this.l(e10);
                    }
                } catch (Throwable th) {
                    a.this.m(false);
                    throw th;
                }
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f4291f + ")";
        }
    }

    /* loaded from: classes.dex */
    class b implements s {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ s f4293f;

        b(s sVar) {
            this.f4293f = sVar;
        }

        @Override // bc.s
        public long G(bc.c cVar, long j10) {
            a.this.k();
            try {
                try {
                    long G = this.f4293f.G(cVar, j10);
                    a.this.m(true);
                    return G;
                } catch (IOException e10) {
                    throw a.this.l(e10);
                }
            } catch (Throwable th) {
                a.this.m(false);
                throw th;
            }
        }

        @Override // bc.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            try {
                try {
                    this.f4293f.close();
                    a.this.m(true);
                } catch (IOException e10) {
                    throw a.this.l(e10);
                }
            } catch (Throwable th) {
                a.this.m(false);
                throw th;
            }
        }

        @Override // bc.s
        public t e() {
            return a.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f4293f + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Thread {
        c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0015, code lost:
        
            r1.t();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<bc.a> r0 = bc.a.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                bc.a r1 = bc.a.i()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                bc.a r2 = bc.a.f4287j     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                bc.a.f4287j = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.t()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: bc.a.c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f4285h = millis;
        f4286i = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    static a i() {
        a aVar = f4287j.f4289f;
        long nanoTime = System.nanoTime();
        if (aVar == null) {
            a.class.wait(f4285h);
            if (f4287j.f4289f != null || System.nanoTime() - nanoTime < f4286i) {
                return null;
            }
            return f4287j;
        }
        long p10 = aVar.p(nanoTime);
        if (p10 > 0) {
            long j10 = p10 / 1000000;
            a.class.wait(j10, (int) (p10 - (1000000 * j10)));
            return null;
        }
        f4287j.f4289f = aVar.f4289f;
        aVar.f4289f = null;
        return aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x000b, code lost:
    
        r1.f4289f = r3.f4289f;
        r3.f4289f = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
    
        r3 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized boolean j(bc.a r3) {
        /*
            java.lang.Class<bc.a> r0 = bc.a.class
            monitor-enter(r0)
            bc.a r1 = bc.a.f4287j     // Catch: java.lang.Throwable -> L19
        L5:
            if (r1 == 0) goto L17
            bc.a r2 = r1.f4289f     // Catch: java.lang.Throwable -> L19
            if (r2 != r3) goto L15
            bc.a r2 = r3.f4289f     // Catch: java.lang.Throwable -> L19
            r1.f4289f = r2     // Catch: java.lang.Throwable -> L19
            r1 = 0
            r3.f4289f = r1     // Catch: java.lang.Throwable -> L19
            r3 = 0
        L13:
            monitor-exit(r0)
            return r3
        L15:
            r1 = r2
            goto L5
        L17:
            r3 = 1
            goto L13
        L19:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: bc.a.j(bc.a):boolean");
    }

    private long p(long j10) {
        return this.f4290g - j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005a A[Catch: all -> 0x0065, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x0016, B:10:0x0022, B:11:0x002b, B:12:0x003a, B:13:0x0040, B:15:0x0044, B:17:0x004d, B:20:0x0050, B:22:0x005a, B:30:0x0034, B:31:0x005f, B:32:0x0064), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized void q(bc.a r6, long r7, boolean r9) {
        /*
            java.lang.Class<bc.a> r0 = bc.a.class
            monitor-enter(r0)
            bc.a r1 = bc.a.f4287j     // Catch: java.lang.Throwable -> L65
            if (r1 != 0) goto L16
            bc.a r1 = new bc.a     // Catch: java.lang.Throwable -> L65
            r1.<init>()     // Catch: java.lang.Throwable -> L65
            bc.a.f4287j = r1     // Catch: java.lang.Throwable -> L65
            bc.a$c r1 = new bc.a$c     // Catch: java.lang.Throwable -> L65
            r1.<init>()     // Catch: java.lang.Throwable -> L65
            r1.start()     // Catch: java.lang.Throwable -> L65
        L16:
            long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L65
            r3 = 0
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L2f
            if (r9 == 0) goto L2f
            long r3 = r6.c()     // Catch: java.lang.Throwable -> L65
            long r3 = r3 - r1
            long r7 = java.lang.Math.min(r7, r3)     // Catch: java.lang.Throwable -> L65
        L2b:
            long r7 = r7 + r1
            r6.f4290g = r7     // Catch: java.lang.Throwable -> L65
            goto L3a
        L2f:
            if (r5 == 0) goto L32
            goto L2b
        L32:
            if (r9 == 0) goto L5f
            long r7 = r6.c()     // Catch: java.lang.Throwable -> L65
            r6.f4290g = r7     // Catch: java.lang.Throwable -> L65
        L3a:
            long r7 = r6.p(r1)     // Catch: java.lang.Throwable -> L65
            bc.a r9 = bc.a.f4287j     // Catch: java.lang.Throwable -> L65
        L40:
            bc.a r3 = r9.f4289f     // Catch: java.lang.Throwable -> L65
            if (r3 == 0) goto L50
            long r3 = r3.p(r1)     // Catch: java.lang.Throwable -> L65
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 >= 0) goto L4d
            goto L50
        L4d:
            bc.a r9 = r9.f4289f     // Catch: java.lang.Throwable -> L65
            goto L40
        L50:
            bc.a r7 = r9.f4289f     // Catch: java.lang.Throwable -> L65
            r6.f4289f = r7     // Catch: java.lang.Throwable -> L65
            r9.f4289f = r6     // Catch: java.lang.Throwable -> L65
            bc.a r6 = bc.a.f4287j     // Catch: java.lang.Throwable -> L65
            if (r9 != r6) goto L5d
            r0.notify()     // Catch: java.lang.Throwable -> L65
        L5d:
            monitor-exit(r0)
            return
        L5f:
            java.lang.AssertionError r6 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L65
            r6.<init>()     // Catch: java.lang.Throwable -> L65
            throw r6     // Catch: java.lang.Throwable -> L65
        L65:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: bc.a.q(bc.a, long, boolean):void");
    }

    public final void k() {
        if (this.f4288e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long h10 = h();
        boolean e10 = e();
        if (h10 != 0 || e10) {
            this.f4288e = true;
            q(this, h10, e10);
        }
    }

    final IOException l(IOException iOException) {
        return !n() ? iOException : o(iOException);
    }

    final void m(boolean z10) {
        if (n() && z10) {
            throw o(null);
        }
    }

    public final boolean n() {
        if (!this.f4288e) {
            return false;
        }
        this.f4288e = false;
        return j(this);
    }

    protected IOException o(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final r r(r rVar) {
        return new C0074a(rVar);
    }

    public final s s(s sVar) {
        return new b(sVar);
    }

    protected void t() {
    }
}
