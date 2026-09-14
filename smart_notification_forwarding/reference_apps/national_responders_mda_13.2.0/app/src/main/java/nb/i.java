package nb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class i extends n {

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f12395c = AtomicIntegerFieldUpdater.newUpdater(i.class, "_resumed");
    private volatile /* synthetic */ int _resumed;

    public final boolean c() {
        return f12395c.compareAndSet(this, 0, 1);
    }
}
