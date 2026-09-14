package P2;

import java.util.concurrent.ScheduledFuture;

/* loaded from: classes.dex */
public final class P implements Q {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f1624a;

    public P(ScheduledFuture scheduledFuture) {
        this.f1624a = scheduledFuture;
    }

    @Override // P2.Q
    public final void dispose() {
        this.f1624a.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.f1624a + ']';
    }
}
