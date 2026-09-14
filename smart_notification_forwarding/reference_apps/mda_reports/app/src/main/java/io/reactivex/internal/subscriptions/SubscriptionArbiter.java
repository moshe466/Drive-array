package io.reactivex.internal.subscriptions;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public class SubscriptionArbiter extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = -2189523197179400958L;
    Subscription a;
    long b;
    final AtomicReference<Subscription> c = new AtomicReference<>();
    final AtomicLong d = new AtomicLong();
    final AtomicLong e = new AtomicLong();
    volatile boolean f;
    protected boolean g;

    final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        b();
    }

    final void b() {
        Subscription subscription = null;
        long j = 0;
        int i = 1;
        do {
            Subscription subscription2 = this.c.get();
            if (subscription2 != null) {
                subscription2 = this.c.getAndSet(null);
            }
            long j2 = this.d.get();
            if (j2 != 0) {
                j2 = this.d.getAndSet(0L);
            }
            long j3 = this.e.get();
            if (j3 != 0) {
                j3 = this.e.getAndSet(0L);
            }
            Subscription subscription3 = this.a;
            if (this.f) {
                if (subscription3 != null) {
                    subscription3.cancel();
                    this.a = null;
                }
                if (subscription2 != null) {
                    subscription2.cancel();
                }
            } else {
                long j4 = this.b;
                if (j4 != Long.MAX_VALUE) {
                    j4 = BackpressureHelper.addCap(j4, j2);
                    if (j4 != Long.MAX_VALUE) {
                        long j5 = j4 - j3;
                        if (j5 < 0) {
                            SubscriptionHelper.reportMoreProduced(j5);
                            j5 = 0;
                        }
                        j4 = j5;
                    }
                    this.b = j4;
                }
                if (subscription2 != null) {
                    if (subscription3 != null) {
                        subscription3.cancel();
                    }
                    this.a = subscription2;
                    if (j4 != 0) {
                        j = BackpressureHelper.addCap(j, j4);
                        subscription = subscription2;
                    }
                } else if (subscription3 != null && j2 != 0) {
                    j = BackpressureHelper.addCap(j, j2);
                    subscription = subscription3;
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
        if (j != 0) {
            subscription.request(j);
        }
    }

    public void cancel() {
        if (this.f) {
            return;
        }
        this.f = true;
        a();
    }

    public final boolean isCancelled() {
        return this.f;
    }

    public final boolean isUnbounded() {
        return this.g;
    }

    public final void produced(long j) {
        if (this.g) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            BackpressureHelper.add(this.e, j);
            a();
            return;
        }
        long j2 = this.b;
        if (j2 != Long.MAX_VALUE) {
            long j3 = j2 - j;
            long j4 = 0;
            if (j3 < 0) {
                SubscriptionHelper.reportMoreProduced(j3);
            } else {
                j4 = j3;
            }
            this.b = j4;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        b();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (!SubscriptionHelper.validate(j) || this.g) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            BackpressureHelper.add(this.d, j);
            a();
            return;
        }
        long j2 = this.b;
        if (j2 != Long.MAX_VALUE) {
            long addCap = BackpressureHelper.addCap(j2, j);
            this.b = addCap;
            if (addCap == Long.MAX_VALUE) {
                this.g = true;
            }
        }
        Subscription subscription = this.a;
        if (decrementAndGet() != 0) {
            b();
        }
        if (subscription != null) {
            subscription.request(j);
        }
    }

    public final void setSubscription(Subscription subscription) {
        if (this.f) {
            subscription.cancel();
            return;
        }
        ObjectHelper.requireNonNull(subscription, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            Subscription andSet = this.c.getAndSet(subscription);
            if (andSet != null) {
                andSet.cancel();
            }
            a();
            return;
        }
        Subscription subscription2 = this.a;
        if (subscription2 != null) {
            subscription2.cancel();
        }
        this.a = subscription;
        long j = this.b;
        if (decrementAndGet() != 0) {
            b();
        }
        if (j != 0) {
            subscription.request(j);
        }
    }
}
