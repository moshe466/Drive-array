package kotlinx.coroutines.internal;

/* loaded from: classes.dex */
public final class k extends nb.u implements Runnable, nb.h0 {

    /* renamed from: g, reason: collision with root package name */
    private final nb.u f11637g;

    /* renamed from: h, reason: collision with root package name */
    private final int f11638h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ nb.h0 f11639i;

    /* renamed from: j, reason: collision with root package name */
    private final p<Runnable> f11640j;

    /* renamed from: k, reason: collision with root package name */
    private final Object f11641k;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public k(nb.u uVar, int i10) {
        this.f11637g = uVar;
        this.f11638h = i10;
        nb.h0 h0Var = uVar instanceof nb.h0 ? (nb.h0) uVar : null;
        this.f11639i = h0Var == null ? nb.g0.a() : h0Var;
        this.f11640j = new p<>(false);
        this.f11641k = new Object();
    }

    private final boolean c0(Runnable runnable) {
        this.f11640j.a(runnable);
        return this.runningWorkers >= this.f11638h;
    }

    private final boolean d0() {
        synchronized (this.f11641k) {
            if (this.runningWorkers >= this.f11638h) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    @Override // nb.u
    public void c(p8.f fVar, Runnable runnable) {
        if (!c0(runnable) && d0()) {
            this.f11637g.c(this, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002a, code lost:
    
        r1 = r4.f11641k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002c, code lost:
    
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x002d, code lost:
    
        r4.runningWorkers--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0039, code lost:
    
        if (r4.f11640j.c() != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
    
        r4.runningWorkers++;
        r2 = l8.w.f11824a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003b, code lost:
    
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x003c, code lost:
    
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            kotlinx.coroutines.internal.p<java.lang.Runnable> r2 = r4.f11640j
            java.lang.Object r2 = r2.d()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            if (r2 == 0) goto L2a
            r2.run()     // Catch: java.lang.Throwable -> L10
            goto L16
        L10:
            r2 = move-exception
            p8.g r3 = p8.g.f13128f
            nb.y.a(r3, r2)
        L16:
            int r1 = r1 + 1
            r2 = 16
            if (r1 < r2) goto L2
            nb.u r2 = r4.f11637g
            boolean r2 = r2.a0(r4)
            if (r2 == 0) goto L2
            nb.u r0 = r4.f11637g
            r0.c(r4, r4)
            return
        L2a:
            java.lang.Object r1 = r4.f11641k
            monitor-enter(r1)
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + (-1)
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            kotlinx.coroutines.internal.p<java.lang.Runnable> r2 = r4.f11640j     // Catch: java.lang.Throwable -> L47
            int r2 = r2.c()     // Catch: java.lang.Throwable -> L47
            if (r2 != 0) goto L3d
            monitor-exit(r1)
            return
        L3d:
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + 1
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            l8.w r2 = l8.w.f11824a     // Catch: java.lang.Throwable -> L47
            monitor-exit(r1)
            goto L1
        L47:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.k.run():void");
    }
}
