package y1;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final /* synthetic */ class d0 implements Executor {

    /* renamed from: f, reason: collision with root package name */
    static final Executor f15851f = new d0();

    private d0() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
