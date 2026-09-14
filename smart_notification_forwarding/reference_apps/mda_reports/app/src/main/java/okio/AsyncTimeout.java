package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class AsyncTimeout extends Timeout {
    private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    private static final int TIMEOUT_WRITE_SIZE = 65536;

    @Nullable
    static AsyncTimeout a;
    private boolean inQueue;

    @Nullable
    private AsyncTimeout next;
    private long timeoutAt;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Watchdog extends Thread {
        Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0015, code lost:
        
            r1.a();
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
                java.lang.Class<okio.AsyncTimeout> r0 = okio.AsyncTimeout.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                okio.AsyncTimeout r1 = okio.AsyncTimeout.b()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                okio.AsyncTimeout r2 = okio.AsyncTimeout.a     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                okio.AsyncTimeout.a = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.a()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L1d
            L1c:
                throw r1
            L1d:
                goto L1c
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.Watchdog.run():void");
        }
    }

    @Nullable
    static AsyncTimeout b() {
        AsyncTimeout asyncTimeout = a.next;
        long nanoTime = System.nanoTime();
        if (asyncTimeout == null) {
            AsyncTimeout.class.wait(IDLE_TIMEOUT_MILLIS);
            if (a.next != null || System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return a;
        }
        long remainingNanos = asyncTimeout.remainingNanos(nanoTime);
        if (remainingNanos > 0) {
            long j = remainingNanos / 1000000;
            AsyncTimeout.class.wait(j, (int) (remainingNanos - (1000000 * j)));
            return null;
        }
        a.next = asyncTimeout.next;
        asyncTimeout.next = null;
        return asyncTimeout;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x000b, code lost:
    
        r1.next = r3.next;
        r3.next = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
    
        r3 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized boolean cancelScheduledTimeout(okio.AsyncTimeout r3) {
        /*
            java.lang.Class<okio.AsyncTimeout> r0 = okio.AsyncTimeout.class
            monitor-enter(r0)
            okio.AsyncTimeout r1 = okio.AsyncTimeout.a     // Catch: java.lang.Throwable -> L1a
        L5:
            if (r1 == 0) goto L18
            okio.AsyncTimeout r2 = r1.next     // Catch: java.lang.Throwable -> L1a
            if (r2 != r3) goto L15
            okio.AsyncTimeout r2 = r3.next     // Catch: java.lang.Throwable -> L1a
            r1.next = r2     // Catch: java.lang.Throwable -> L1a
            r1 = 0
            r3.next = r1     // Catch: java.lang.Throwable -> L1a
            r3 = 0
        L13:
            monitor-exit(r0)
            return r3
        L15:
            okio.AsyncTimeout r1 = r1.next     // Catch: java.lang.Throwable -> L1a
            goto L5
        L18:
            r3 = 1
            goto L13
        L1a:
            r3 = move-exception
            monitor-exit(r0)
            goto L1e
        L1d:
            throw r3
        L1e:
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.cancelScheduledTimeout(okio.AsyncTimeout):boolean");
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005e A[Catch: all -> 0x0069, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x0016, B:10:0x0022, B:11:0x002b, B:12:0x003c, B:13:0x0042, B:15:0x0046, B:17:0x0051, B:20:0x0054, B:22:0x005e, B:31:0x0036, B:32:0x0063, B:33:0x0068), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized void scheduleTimeout(okio.AsyncTimeout r6, long r7, boolean r9) {
        /*
            java.lang.Class<okio.AsyncTimeout> r0 = okio.AsyncTimeout.class
            monitor-enter(r0)
            okio.AsyncTimeout r1 = okio.AsyncTimeout.a     // Catch: java.lang.Throwable -> L69
            if (r1 != 0) goto L16
            okio.AsyncTimeout r1 = new okio.AsyncTimeout     // Catch: java.lang.Throwable -> L69
            r1.<init>()     // Catch: java.lang.Throwable -> L69
            okio.AsyncTimeout.a = r1     // Catch: java.lang.Throwable -> L69
            okio.AsyncTimeout$Watchdog r1 = new okio.AsyncTimeout$Watchdog     // Catch: java.lang.Throwable -> L69
            r1.<init>()     // Catch: java.lang.Throwable -> L69
            r1.start()     // Catch: java.lang.Throwable -> L69
        L16:
            long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L69
            r3 = 0
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L2f
            if (r9 == 0) goto L2f
            long r3 = r6.deadlineNanoTime()     // Catch: java.lang.Throwable -> L69
            long r3 = r3 - r1
            long r7 = java.lang.Math.min(r7, r3)     // Catch: java.lang.Throwable -> L69
        L2b:
            long r7 = r7 + r1
            r6.timeoutAt = r7     // Catch: java.lang.Throwable -> L69
            goto L3c
        L2f:
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L34
            goto L2b
        L34:
            if (r9 == 0) goto L63
            long r7 = r6.deadlineNanoTime()     // Catch: java.lang.Throwable -> L69
            r6.timeoutAt = r7     // Catch: java.lang.Throwable -> L69
        L3c:
            long r7 = r6.remainingNanos(r1)     // Catch: java.lang.Throwable -> L69
            okio.AsyncTimeout r9 = okio.AsyncTimeout.a     // Catch: java.lang.Throwable -> L69
        L42:
            okio.AsyncTimeout r3 = r9.next     // Catch: java.lang.Throwable -> L69
            if (r3 == 0) goto L54
            okio.AsyncTimeout r3 = r9.next     // Catch: java.lang.Throwable -> L69
            long r3 = r3.remainingNanos(r1)     // Catch: java.lang.Throwable -> L69
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 >= 0) goto L51
            goto L54
        L51:
            okio.AsyncTimeout r9 = r9.next     // Catch: java.lang.Throwable -> L69
            goto L42
        L54:
            okio.AsyncTimeout r7 = r9.next     // Catch: java.lang.Throwable -> L69
            r6.next = r7     // Catch: java.lang.Throwable -> L69
            r9.next = r6     // Catch: java.lang.Throwable -> L69
            okio.AsyncTimeout r6 = okio.AsyncTimeout.a     // Catch: java.lang.Throwable -> L69
            if (r9 != r6) goto L61
            r0.notify()     // Catch: java.lang.Throwable -> L69
        L61:
            monitor-exit(r0)
            return
        L63:
            java.lang.AssertionError r6 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L69
            r6.<init>()     // Catch: java.lang.Throwable -> L69
            throw r6     // Catch: java.lang.Throwable -> L69
        L69:
            r6 = move-exception
            monitor-exit(r0)
            goto L6d
        L6c:
            throw r6
        L6d:
            goto L6c
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.scheduleTimeout(okio.AsyncTimeout, long, boolean):void");
    }

    final IOException a(IOException iOException) {
        return !exit() ? iOException : b(iOException);
    }

    protected void a() {
    }

    final void a(boolean z) {
        if (exit() && z) {
            throw b(null);
        }
    }

    protected IOException b(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final void enter() {
        if (this.inQueue) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            this.inQueue = true;
            scheduleTimeout(this, timeoutNanos, hasDeadline);
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    public final Sink sink(final Sink sink) {
        return new Sink() { // from class: okio.AsyncTimeout.1
            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                AsyncTimeout.this.enter();
                try {
                    try {
                        sink.close();
                        AsyncTimeout.this.a(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.a(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.a(false);
                    throw th;
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() {
                AsyncTimeout.this.enter();
                try {
                    try {
                        sink.flush();
                        AsyncTimeout.this.a(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.a(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.a(false);
                    throw th;
                }
            }

            @Override // okio.Sink
            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ")";
            }

            @Override // okio.Sink
            public void write(Buffer buffer, long j) {
                Util.checkOffsetAndCount(buffer.b, 0L, j);
                while (true) {
                    long j2 = 0;
                    if (j <= 0) {
                        return;
                    }
                    Segment segment = buffer.a;
                    while (true) {
                        if (j2 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                            break;
                        }
                        j2 += segment.c - segment.b;
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                        segment = segment.f;
                    }
                    AsyncTimeout.this.enter();
                    try {
                        try {
                            sink.write(buffer, j2);
                            j -= j2;
                            AsyncTimeout.this.a(true);
                        } catch (IOException e) {
                            throw AsyncTimeout.this.a(e);
                        }
                    } catch (Throwable th) {
                        AsyncTimeout.this.a(false);
                        throw th;
                    }
                }
            }
        };
    }

    public final Source source(final Source source) {
        return new Source() { // from class: okio.AsyncTimeout.2
            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    try {
                        source.close();
                        AsyncTimeout.this.a(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.a(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.a(false);
                    throw th;
                }
            }

            @Override // okio.Source
            public long read(Buffer buffer, long j) {
                AsyncTimeout.this.enter();
                try {
                    try {
                        long read = source.read(buffer, j);
                        AsyncTimeout.this.a(true);
                        return read;
                    } catch (IOException e) {
                        throw AsyncTimeout.this.a(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.a(false);
                    throw th;
                }
            }

            @Override // okio.Source
            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ")";
            }
        };
    }
}
