package e2;

import e2.a;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import o2.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements a.InterfaceC0149a {
    @Override // e2.a.InterfaceC0149a
    public final ScheduledExecutorService a() {
        h.a();
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }
}
