package P2;

import kotlinx.coroutines.TimeoutCancellationException;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class G0 extends U2.r implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final long f1613e;

    public G0(long j2, AbstractC0787c abstractC0787c) {
        super(abstractC0787c, abstractC0787c.getContext());
        this.f1613e = j2;
    }

    @Override // P2.w0
    public final String F() {
        return super.F() + "(timeMillis=" + this.f1613e + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        G.k(this.f1641c);
        k(new TimeoutCancellationException("Timed out waiting for " + this.f1613e + " ms", this));
    }
}
