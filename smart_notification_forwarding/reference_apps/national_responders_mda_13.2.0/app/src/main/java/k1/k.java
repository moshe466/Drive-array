package k1;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class k implements Executor {

    /* renamed from: f, reason: collision with root package name */
    private final Executor f11172f;

    /* loaded from: classes.dex */
    static class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private final Runnable f11173f;

        a(Runnable runnable) {
            this.f11173f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f11173f.run();
            } catch (Exception e10) {
                n1.a.c("Executor", "Background execution failure.", e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Executor executor) {
        this.f11172f = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f11172f.execute(new a(runnable));
    }
}
