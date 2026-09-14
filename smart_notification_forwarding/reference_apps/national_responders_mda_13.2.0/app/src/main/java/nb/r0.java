package nb;

import java.util.concurrent.locks.LockSupport;
import nb.q0;

/* loaded from: classes.dex */
public abstract class r0 extends p0 {
    protected abstract Thread m0();

    /* JADX INFO: Access modifiers changed from: protected */
    public void n0(long j10, q0.a aVar) {
        f0.f12371l.z0(j10, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o0() {
        Thread m02 = m0();
        if (Thread.currentThread() != m02) {
            c.a();
            LockSupport.unpark(m02);
        }
    }
}
