package W2;

import F0.AbstractC0008a;
import F0.G1;
import P2.G;
import U2.q;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes.dex */
public final class c implements Executor, Closeable {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f2520k = AtomicLongFieldUpdater.newUpdater(c.class, "parkedWorkersStack$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f2521l = AtomicLongFieldUpdater.newUpdater(c.class, "controlState$volatile");

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2522m = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isTerminated$volatile");

    /* renamed from: n, reason: collision with root package name */
    public static final G1 f2523n = new G1("NOT_IN_STACK", 8);
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f2524a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2525b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2526c;
    private volatile /* synthetic */ long controlState$volatile;

    /* renamed from: d, reason: collision with root package name */
    public final String f2527d;

    /* renamed from: e, reason: collision with root package name */
    public final f f2528e;

    /* renamed from: f, reason: collision with root package name */
    public final f f2529f;

    /* renamed from: j, reason: collision with root package name */
    public final q f2530j;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    /* JADX WARN: Type inference failed for: r4v10, types: [W2.f, U2.k] */
    /* JADX WARN: Type inference failed for: r4v9, types: [W2.f, U2.k] */
    public c(int i, int i3, long j2, String str) {
        this.f2524a = i;
        this.f2525b = i3;
        this.f2526c = j2;
        this.f2527d = str;
        if (i >= 1) {
            if (i3 >= i) {
                if (i3 <= 2097150) {
                    if (j2 > 0) {
                        this.f2528e = new U2.k();
                        this.f2529f = new U2.k();
                        this.f2530j = new q((i + 1) * 2);
                        this.controlState$volatile = i << 42;
                        this._isTerminated$volatile = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
                }
                throw new IllegalArgumentException(AbstractC0008a.j(i3, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(AbstractC0008a.k("Max pool size ", i3, i, " should be greater than or equals to core pool size ").toString());
        }
        throw new IllegalArgumentException(AbstractC0008a.j(i, "Core pool size ", " should be at least 1").toString());
    }

    public final int a() {
        boolean z3;
        synchronized (this.f2530j) {
            try {
                if (f2522m.get(this) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f2521l;
                long j2 = atomicLongFieldUpdater.get(this);
                int i = (int) (j2 & 2097151);
                int i3 = i - ((int) ((j2 & 4398044413952L) >> 21));
                if (i3 < 0) {
                    i3 = 0;
                }
                if (i3 >= this.f2524a) {
                    return 0;
                }
                if (i >= this.f2525b) {
                    return 0;
                }
                int i4 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i4 > 0 && this.f2530j.b(i4) == null) {
                    a aVar = new a(this, i4);
                    this.f2530j.c(i4, aVar);
                    if (i4 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                        int i5 = i3 + 1;
                        aVar.start();
                        return i5;
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalArgumentException("Failed requirement.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Runnable runnable, j jVar) {
        i kVar;
        boolean z3;
        long j2;
        a aVar;
        boolean a2;
        b bVar;
        l.f2545f.getClass();
        long nanoTime = System.nanoTime();
        if (runnable instanceof i) {
            kVar = (i) runnable;
            kVar.f2536a = nanoTime;
            kVar.f2537b = jVar;
        } else {
            kVar = new k(runnable, nanoTime, jVar);
        }
        if (kVar.f2537b.f2538a == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2521l;
        if (z3) {
            j2 = atomicLongFieldUpdater.addAndGet(this, 2097152L);
        } else {
            j2 = 0;
        }
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof a) {
            aVar = (a) currentThread;
        } else {
            aVar = null;
        }
        if (aVar == null || !kotlin.jvm.internal.j.a(aVar.f2513k, this)) {
            aVar = null;
        }
        if (aVar != null && (bVar = aVar.f2508c) != b.f2518e && (kVar.f2537b.f2538a != 0 || bVar != b.f2515b)) {
            aVar.f2512j = true;
            n nVar = aVar.f2506a;
            nVar.getClass();
            kVar = (i) n.f2549b.getAndSet(nVar, kVar);
            if (kVar == null) {
                kVar = null;
            } else {
                AtomicReferenceArray atomicReferenceArray = nVar.f2553a;
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = n.f2550c;
                if (atomicIntegerFieldUpdater.get(nVar) - n.f2551d.get(nVar) != 127) {
                    if (kVar.f2537b.f2538a == 1) {
                        n.f2552e.incrementAndGet(nVar);
                    }
                    int i = atomicIntegerFieldUpdater.get(nVar) & 127;
                    while (atomicReferenceArray.get(i) != null) {
                        Thread.yield();
                    }
                    atomicReferenceArray.lazySet(i, kVar);
                    atomicIntegerFieldUpdater.incrementAndGet(nVar);
                    kVar = null;
                }
            }
        }
        if (kVar != null) {
            if (kVar.f2537b.f2538a == 1) {
                a2 = this.f2529f.a(kVar);
            } else {
                a2 = this.f2528e.a(kVar);
            }
            if (!a2) {
                throw new RejectedExecutionException(AbstractC0008a.u(new StringBuilder(), this.f2527d, " was terminated"));
            }
        }
        if (z3) {
            if (!e() && !d(j2)) {
                e();
                return;
            }
            return;
        }
        if (e() || d(atomicLongFieldUpdater.get(this))) {
            return;
        }
        e();
    }

    public final void c(a aVar, int i, int i3) {
        while (true) {
            long j2 = f2520k.get(this);
            int i4 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (i4 == i) {
                if (i3 == 0) {
                    Object c4 = aVar.c();
                    while (true) {
                        if (c4 == f2523n) {
                            i4 = -1;
                            break;
                        }
                        if (c4 == null) {
                            i4 = 0;
                            break;
                        }
                        a aVar2 = (a) c4;
                        int b4 = aVar2.b();
                        if (b4 != 0) {
                            i4 = b4;
                            break;
                        }
                        c4 = aVar2.c();
                    }
                } else {
                    i4 = i3;
                }
            }
            if (i4 >= 0) {
                if (f2520k.compareAndSet(this, j2, i4 | j3)) {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0088, code lost:
    
        if (r1 == null) goto L39;
     */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = W2.c.f2522m
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof W2.a
            r3 = 0
            if (r1 == 0) goto L17
            W2.a r0 = (W2.a) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            W2.c r1 = r0.f2513k
            boolean r1 = kotlin.jvm.internal.j.a(r1, r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            U2.q r1 = r8.f2530j
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = W2.c.f2521l     // Catch: java.lang.Throwable -> Lc3
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc3
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r1)
            if (r2 > r4) goto L78
            r1 = r2
        L36:
            U2.q r5 = r8.f2530j
            java.lang.Object r5 = r5.b(r1)
            kotlin.jvm.internal.j.b(r5)
            W2.a r5 = (W2.a) r5
            if (r5 == r0) goto L73
        L43:
            java.lang.Thread$State r6 = r5.getState()
            java.lang.Thread$State r7 = java.lang.Thread.State.TERMINATED
            if (r6 == r7) goto L54
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r6 = 10000(0x2710, double:4.9407E-320)
            r5.join(r6)
            goto L43
        L54:
            W2.n r5 = r5.f2506a
            W2.f r6 = r8.f2529f
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = W2.n.f2549b
            java.lang.Object r7 = r7.getAndSet(r5, r3)
            W2.i r7 = (W2.i) r7
            if (r7 == 0) goto L68
            r6.a(r7)
        L68:
            W2.i r7 = r5.a()
            if (r7 != 0) goto L6f
            goto L73
        L6f:
            r6.a(r7)
            goto L68
        L73:
            if (r1 == r4) goto L78
            int r1 = r1 + 1
            goto L36
        L78:
            W2.f r1 = r8.f2529f
            r1.b()
            W2.f r1 = r8.f2528e
            r1.b()
        L82:
            if (r0 == 0) goto L8a
            W2.i r1 = r0.a(r2)
            if (r1 != 0) goto Lb2
        L8a:
            W2.f r1 = r8.f2528e
            java.lang.Object r1 = r1.d()
            W2.i r1 = (W2.i) r1
            if (r1 != 0) goto Lb2
            W2.f r1 = r8.f2529f
            java.lang.Object r1 = r1.d()
            W2.i r1 = (W2.i) r1
            if (r1 != 0) goto Lb2
            if (r0 == 0) goto La5
            W2.b r1 = W2.b.f2518e
            r0.h(r1)
        La5:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = W2.c.f2520k
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = W2.c.f2521l
            r0.set(r8, r1)
            return
        Lb2:
            r1.run()     // Catch: java.lang.Throwable -> Lb6
            goto L82
        Lb6:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L82
        Lc3:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: W2.c.close():void");
    }

    public final boolean d(long j2) {
        int i = ((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i3 = this.f2524a;
        if (i < i3) {
            int a2 = a();
            if (a2 == 1 && i3 > 1) {
                a();
            }
            if (a2 > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean e() {
        G1 g12;
        int i;
        while (true) {
            long j2 = f2520k.get(this);
            a aVar = (a) this.f2530j.b((int) (2097151 & j2));
            if (aVar == null) {
                aVar = null;
            } else {
                long j3 = (2097152 + j2) & (-2097152);
                Object c4 = aVar.c();
                while (true) {
                    g12 = f2523n;
                    if (c4 == g12) {
                        i = -1;
                        break;
                    }
                    if (c4 == null) {
                        i = 0;
                        break;
                    }
                    a aVar2 = (a) c4;
                    i = aVar2.b();
                    if (i != 0) {
                        break;
                    }
                    c4 = aVar2.c();
                }
                if (i >= 0) {
                    if (f2520k.compareAndSet(this, j2, i | j3)) {
                        aVar.g(g12);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.f2505l.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable, l.f2546g);
    }

    public final String toString() {
        int i;
        ArrayList arrayList = new ArrayList();
        q qVar = this.f2530j;
        int a2 = qVar.a();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 1; i8 < a2; i8++) {
            a aVar = (a) qVar.b(i8);
            if (aVar != null) {
                n nVar = aVar.f2506a;
                nVar.getClass();
                if (n.f2549b.get(nVar) != null) {
                    i = (n.f2550c.get(nVar) - n.f2551d.get(nVar)) + 1;
                } else {
                    i = n.f2550c.get(nVar) - n.f2551d.get(nVar);
                }
                int ordinal = aVar.f2508c.ordinal();
                if (ordinal != 0) {
                    if (ordinal != 1) {
                        if (ordinal != 2) {
                            if (ordinal != 3) {
                                if (ordinal == 4) {
                                    i7++;
                                }
                            } else {
                                i6++;
                                if (i > 0) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(i);
                                    sb.append('d');
                                    arrayList.add(sb.toString());
                                }
                            }
                        } else {
                            i5++;
                        }
                    } else {
                        i4++;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(i);
                        sb2.append('b');
                        arrayList.add(sb2.toString());
                    }
                } else {
                    i3++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i);
                    sb3.append('c');
                    arrayList.add(sb3.toString());
                }
            }
        }
        long j2 = f2521l.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f2527d);
        sb4.append('@');
        sb4.append(G.l(this));
        sb4.append("[Pool Size {core = ");
        int i9 = this.f2524a;
        sb4.append(i9);
        sb4.append(", max = ");
        sb4.append(this.f2525b);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i3);
        sb4.append(", blocking = ");
        sb4.append(i4);
        sb4.append(", parked = ");
        sb4.append(i5);
        sb4.append(", dormant = ");
        sb4.append(i6);
        sb4.append(", terminated = ");
        sb4.append(i7);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f2528e.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f2529f.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j2));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j2) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i9 - ((int) ((j2 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
