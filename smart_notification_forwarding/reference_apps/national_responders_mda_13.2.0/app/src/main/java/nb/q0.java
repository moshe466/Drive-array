package nb;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class q0 extends r0 implements h0 {

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f12418j = AtomicReferenceFieldUpdater.newUpdater(q0.class, Object.class, "_queue");

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f12419k = AtomicReferenceFieldUpdater.newUpdater(q0.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    /* loaded from: classes.dex */
    public static abstract class a implements Runnable, Comparable<a>, n0, kotlinx.coroutines.internal.h0 {

        /* renamed from: f, reason: collision with root package name */
        public long f12420f;

        /* renamed from: g, reason: collision with root package name */
        private Object f12421g;

        /* renamed from: h, reason: collision with root package name */
        private int f12422h;

        @Override // nb.n0
        public final synchronized void dispose() {
            kotlinx.coroutines.internal.b0 b0Var;
            kotlinx.coroutines.internal.b0 b0Var2;
            Object obj = this.f12421g;
            b0Var = t0.f12427a;
            if (obj == b0Var) {
                return;
            }
            b bVar = obj instanceof b ? (b) obj : null;
            if (bVar != null) {
                bVar.g(this);
            }
            b0Var2 = t0.f12427a;
            this.f12421g = b0Var2;
        }

        @Override // kotlinx.coroutines.internal.h0
        public int j() {
            return this.f12422h;
        }

        @Override // kotlinx.coroutines.internal.h0
        public void k(int i10) {
            this.f12422h = i10;
        }

        @Override // kotlinx.coroutines.internal.h0
        public void l(kotlinx.coroutines.internal.g0<?> g0Var) {
            kotlinx.coroutines.internal.b0 b0Var;
            Object obj = this.f12421g;
            b0Var = t0.f12427a;
            if (!(obj != b0Var)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.f12421g = g0Var;
        }

        @Override // kotlinx.coroutines.internal.h0
        public kotlinx.coroutines.internal.g0<?> o() {
            Object obj = this.f12421g;
            if (obj instanceof kotlinx.coroutines.internal.g0) {
                return (kotlinx.coroutines.internal.g0) obj;
            }
            return null;
        }

        @Override // java.lang.Comparable
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            long j10 = this.f12420f - aVar.f12420f;
            if (j10 > 0) {
                return 1;
            }
            return j10 < 0 ? -1 : 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0040 A[Catch: all -> 0x0048, TryCatch #0 {, blocks: (B:11:0x000d, B:19:0x0021, B:20:0x0037, B:22:0x0040, B:23:0x0042, B:27:0x0024, B:30:0x002e), top: B:10:0x000d, outer: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final synchronized int s(long r8, nb.q0.b r10, nb.q0 r11) {
            /*
                r7 = this;
                monitor-enter(r7)
                java.lang.Object r0 = r7.f12421g     // Catch: java.lang.Throwable -> L4b
                kotlinx.coroutines.internal.b0 r1 = nb.t0.b()     // Catch: java.lang.Throwable -> L4b
                if (r0 != r1) goto Lc
                r8 = 2
            La:
                monitor-exit(r7)
                return r8
            Lc:
                monitor-enter(r10)     // Catch: java.lang.Throwable -> L4b
                kotlinx.coroutines.internal.h0 r0 = r10.b()     // Catch: java.lang.Throwable -> L48
                nb.q0$a r0 = (nb.q0.a) r0     // Catch: java.lang.Throwable -> L48
                boolean r11 = nb.q0.p0(r11)     // Catch: java.lang.Throwable -> L48
                if (r11 == 0) goto L1d
                r8 = 1
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4b
                monitor-exit(r7)
                return r8
            L1d:
                r1 = 0
                if (r0 != 0) goto L24
            L21:
                r10.f12423b = r8     // Catch: java.lang.Throwable -> L48
                goto L37
            L24:
                long r3 = r0.f12420f     // Catch: java.lang.Throwable -> L48
                long r5 = r3 - r8
                int r11 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r11 < 0) goto L2d
                goto L2e
            L2d:
                r8 = r3
            L2e:
                long r3 = r10.f12423b     // Catch: java.lang.Throwable -> L48
                long r3 = r8 - r3
                int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r11 <= 0) goto L37
                goto L21
            L37:
                long r8 = r7.f12420f     // Catch: java.lang.Throwable -> L48
                long r3 = r10.f12423b     // Catch: java.lang.Throwable -> L48
                long r8 = r8 - r3
                int r11 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r11 >= 0) goto L42
                r7.f12420f = r3     // Catch: java.lang.Throwable -> L48
            L42:
                r10.a(r7)     // Catch: java.lang.Throwable -> L48
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4b
                r8 = 0
                goto La
            L48:
                r8 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4b
                throw r8     // Catch: java.lang.Throwable -> L4b
            L4b:
                r8 = move-exception
                monitor-exit(r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: nb.q0.a.s(long, nb.q0$b, nb.q0):int");
        }

        public final boolean t(long j10) {
            return j10 - this.f12420f >= 0;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f12420f + ']';
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends kotlinx.coroutines.internal.g0<a> {

        /* renamed from: b, reason: collision with root package name */
        public long f12423b;

        public b(long j10) {
            this.f12423b = j10;
        }
    }

    private final int A0(long j10, a aVar) {
        if (u0()) {
            return 1;
        }
        b bVar = (b) this._delayed;
        if (bVar == null) {
            f12419k.compareAndSet(this, null, new b(j10));
            Object obj = this._delayed;
            y8.k.b(obj);
            bVar = (b) obj;
        }
        return aVar.s(j10, bVar, this);
    }

    private final void B0(boolean z10) {
        this._isCompleted = z10 ? 1 : 0;
    }

    private final boolean C0(a aVar) {
        b bVar = (b) this._delayed;
        return (bVar == null ? null : bVar.e()) == aVar;
    }

    private final void q0() {
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        if (d0.a() && !u0()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12418j;
                b0Var = t0.f12428b;
                if (atomicReferenceFieldUpdater.compareAndSet(this, null, b0Var)) {
                    return;
                }
            } else {
                if (obj instanceof kotlinx.coroutines.internal.q) {
                    ((kotlinx.coroutines.internal.q) obj).d();
                    return;
                }
                b0Var2 = t0.f12428b;
                if (obj == b0Var2) {
                    return;
                }
                kotlinx.coroutines.internal.q qVar = new kotlinx.coroutines.internal.q(8, true);
                qVar.a((Runnable) obj);
                if (f12418j.compareAndSet(this, obj, qVar)) {
                    return;
                }
            }
        }
    }

    private final Runnable r0() {
        kotlinx.coroutines.internal.b0 b0Var;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.q) {
                kotlinx.coroutines.internal.q qVar = (kotlinx.coroutines.internal.q) obj;
                Object j10 = qVar.j();
                if (j10 != kotlinx.coroutines.internal.q.f11652h) {
                    return (Runnable) j10;
                }
                f12418j.compareAndSet(this, obj, qVar.i());
            } else {
                b0Var = t0.f12428b;
                if (obj == b0Var) {
                    return null;
                }
                if (f12418j.compareAndSet(this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean t0(Runnable runnable) {
        kotlinx.coroutines.internal.b0 b0Var;
        while (true) {
            Object obj = this._queue;
            if (u0()) {
                return false;
            }
            if (obj == null) {
                if (f12418j.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.q) {
                kotlinx.coroutines.internal.q qVar = (kotlinx.coroutines.internal.q) obj;
                int a10 = qVar.a(runnable);
                if (a10 == 0) {
                    return true;
                }
                if (a10 == 1) {
                    f12418j.compareAndSet(this, obj, qVar.i());
                } else if (a10 == 2) {
                    return false;
                }
            } else {
                b0Var = t0.f12428b;
                if (obj == b0Var) {
                    return false;
                }
                kotlinx.coroutines.internal.q qVar2 = new kotlinx.coroutines.internal.q(8, true);
                qVar2.a((Runnable) obj);
                qVar2.a(runnable);
                if (f12418j.compareAndSet(this, obj, qVar2)) {
                    return true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean u0() {
        return this._isCompleted;
    }

    private final void x0() {
        c.a();
        long nanoTime = System.nanoTime();
        while (true) {
            b bVar = (b) this._delayed;
            a i10 = bVar == null ? null : bVar.i();
            if (i10 == null) {
                return;
            } else {
                n0(nanoTime, i10);
            }
        }
    }

    @Override // nb.u
    public final void c(p8.f fVar, Runnable runnable) {
        s0(runnable);
    }

    @Override // nb.p0
    protected long f0() {
        long b10;
        kotlinx.coroutines.internal.b0 b0Var;
        if (super.f0() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.q)) {
                b0Var = t0.f12428b;
                return obj == b0Var ? Long.MAX_VALUE : 0L;
            }
            if (!((kotlinx.coroutines.internal.q) obj).g()) {
                return 0L;
            }
        }
        b bVar = (b) this._delayed;
        a e10 = bVar == null ? null : bVar.e();
        if (e10 == null) {
            return Long.MAX_VALUE;
        }
        long j10 = e10.f12420f;
        c.a();
        b10 = d9.f.b(j10 - System.nanoTime(), 0L);
        return b10;
    }

    @Override // nb.p0
    public void l0() {
        o1.f12412a.b();
        B0(true);
        q0();
        do {
        } while (w0() <= 0);
        x0();
    }

    public void s0(Runnable runnable) {
        if (t0(runnable)) {
            o0();
        } else {
            f0.f12371l.s0(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean v0() {
        kotlinx.coroutines.internal.b0 b0Var;
        if (!j0()) {
            return false;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof kotlinx.coroutines.internal.q) {
                return ((kotlinx.coroutines.internal.q) obj).g();
            }
            b0Var = t0.f12428b;
            if (obj != b0Var) {
                return false;
            }
        }
        return true;
    }

    public long w0() {
        a aVar;
        if (k0()) {
            return 0L;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.d()) {
            c.a();
            long nanoTime = System.nanoTime();
            do {
                synchronized (bVar) {
                    a b10 = bVar.b();
                    aVar = null;
                    if (b10 != null) {
                        a aVar2 = b10;
                        if (aVar2.t(nanoTime) ? t0(aVar2) : false) {
                            aVar = bVar.h(0);
                        }
                    }
                }
            } while (aVar != null);
        }
        Runnable r02 = r0();
        if (r02 == null) {
            return f0();
        }
        r02.run();
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void y0() {
        this._queue = null;
        this._delayed = null;
    }

    public final void z0(long j10, a aVar) {
        int A0 = A0(j10, aVar);
        if (A0 == 0) {
            if (C0(aVar)) {
                o0();
            }
        } else if (A0 == 1) {
            n0(j10, aVar);
        } else if (A0 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }
}
