package h2;

import b2.p;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class c implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final String f10443a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f10444b = new AtomicInteger();

    /* renamed from: c, reason: collision with root package name */
    private final ThreadFactory f10445c = Executors.defaultThreadFactory();

    public c(String str) {
        p.l(str, "Name must not be null");
        this.f10443a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f10445c.newThread(new d(runnable, 0));
        newThread.setName(this.f10443a + "[" + this.f10444b.getAndIncrement() + "]");
        return newThread;
    }
}
