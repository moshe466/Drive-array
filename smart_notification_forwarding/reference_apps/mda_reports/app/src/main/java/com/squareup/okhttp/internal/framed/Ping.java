package com.squareup.okhttp.internal.framed;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class Ping {
    private final CountDownLatch latch = new CountDownLatch(1);
    private long sent = -1;
    private long received = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.received == -1) {
            long j = this.sent;
            if (j != -1) {
                this.received = j - 1;
                this.latch.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.received != -1 || this.sent == -1) {
            throw new IllegalStateException();
        }
        this.received = System.nanoTime();
        this.latch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.sent != -1) {
            throw new IllegalStateException();
        }
        this.sent = System.nanoTime();
    }

    public long roundTripTime() {
        this.latch.await();
        return this.received - this.sent;
    }

    public long roundTripTime(long j, TimeUnit timeUnit) {
        if (this.latch.await(j, timeUnit)) {
            return this.received - this.sent;
        }
        return -2L;
    }
}
