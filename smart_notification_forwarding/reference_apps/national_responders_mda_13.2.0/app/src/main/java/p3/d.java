package p3;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final /* synthetic */ class d implements Executor {

    /* renamed from: f, reason: collision with root package name */
    static final Executor f13052f = new d();

    private d() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
