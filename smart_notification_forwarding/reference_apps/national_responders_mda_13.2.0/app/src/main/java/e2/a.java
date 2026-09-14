package e2;

import java.util.concurrent.ScheduledExecutorService;

@Deprecated
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static InterfaceC0149a f9139a;

    /* renamed from: e2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0149a {
        @Deprecated
        ScheduledExecutorService a();
    }

    @Deprecated
    public static synchronized InterfaceC0149a a() {
        InterfaceC0149a interfaceC0149a;
        synchronized (a.class) {
            if (f9139a == null) {
                f9139a = new b();
            }
            interfaceC0149a = f9139a;
        }
        return interfaceC0149a;
    }
}
