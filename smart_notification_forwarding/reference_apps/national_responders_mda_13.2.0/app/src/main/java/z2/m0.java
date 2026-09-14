package z2;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class m0 implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
