package h2;

import b2.p;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public class b implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final String f10441a;

    /* renamed from: b, reason: collision with root package name */
    private final ThreadFactory f10442b = Executors.defaultThreadFactory();

    public b(String str) {
        p.l(str, "Name must not be null");
        this.f10441a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f10442b.newThread(new d(runnable, 0));
        newThread.setName(this.f10441a);
        return newThread;
    }
}
