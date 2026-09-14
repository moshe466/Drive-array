package p4;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
final /* synthetic */ class c implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private static final c f13055a = new c();

    private c() {
    }

    public static ThreadFactory a() {
        return f13055a;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return d.e(runnable);
    }
}
