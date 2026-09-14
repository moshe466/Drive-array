package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;
import l8.w;
import nb.d0;
import nb.e0;

/* loaded from: classes.dex */
public final class a implements Executor, Closeable {

    /* renamed from: m, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f11666m;

    /* renamed from: n, reason: collision with root package name */
    static final /* synthetic */ AtomicLongFieldUpdater f11667n;

    /* renamed from: o, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f11668o;

    /* renamed from: p, reason: collision with root package name */
    public static final b0 f11669p;
    private volatile /* synthetic */ int _isTerminated;
    volatile /* synthetic */ long controlState;

    /* renamed from: f, reason: collision with root package name */
    public final int f11670f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11671g;

    /* renamed from: h, reason: collision with root package name */
    public final long f11672h;

    /* renamed from: i, reason: collision with root package name */
    public final String f11673i;

    /* renamed from: j, reason: collision with root package name */
    public final kotlinx.coroutines.scheduling.d f11674j;

    /* renamed from: k, reason: collision with root package name */
    public final kotlinx.coroutines.scheduling.d f11675k;

    /* renamed from: l, reason: collision with root package name */
    public final y<c> f11676l;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* renamed from: kotlinx.coroutines.scheduling.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0243a {
        private C0243a() {
        }

        public /* synthetic */ C0243a(y8.g gVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11677a;

        static {
            int[] iArr = new int[d.values().length];
            iArr[d.PARKING.ordinal()] = 1;
            iArr[d.BLOCKING.ordinal()] = 2;
            iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            iArr[d.DORMANT.ordinal()] = 4;
            iArr[d.TERMINATED.ordinal()] = 5;
            f11677a = iArr;
        }
    }

    /* loaded from: classes.dex */
    public final class c extends Thread {

        /* renamed from: m, reason: collision with root package name */
        static final /* synthetic */ AtomicIntegerFieldUpdater f11678m = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: f, reason: collision with root package name */
        public final n f11679f;

        /* renamed from: g, reason: collision with root package name */
        public d f11680g;

        /* renamed from: h, reason: collision with root package name */
        private long f11681h;

        /* renamed from: i, reason: collision with root package name */
        private long f11682i;
        private volatile int indexInArray;

        /* renamed from: j, reason: collision with root package name */
        private int f11683j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f11684k;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        private c() {
            setDaemon(true);
            this.f11679f = new n();
            this.f11680g = d.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = a.f11669p;
            this.f11683j = b9.c.f4151f.b();
        }

        public c(int i10) {
            this();
            o(i10);
        }

        private final void b(int i10) {
            if (i10 == 0) {
                return;
            }
            a.f11667n.addAndGet(a.this, -2097152L);
            d dVar = this.f11680g;
            if (dVar != d.TERMINATED) {
                if (d0.a()) {
                    if (!(dVar == d.BLOCKING)) {
                        throw new AssertionError();
                    }
                }
                this.f11680g = d.DORMANT;
            }
        }

        private final void c(int i10) {
            if (i10 != 0 && s(d.BLOCKING)) {
                a.this.d0();
            }
        }

        private final void d(h hVar) {
            int b10 = hVar.f11696g.b();
            i(b10);
            c(b10);
            a.this.a0(hVar);
            b(b10);
        }

        private final h e(boolean z10) {
            h m10;
            h m11;
            if (z10) {
                boolean z11 = k(a.this.f11670f * 2) == 0;
                if (z11 && (m11 = m()) != null) {
                    return m11;
                }
                h h10 = this.f11679f.h();
                if (h10 != null) {
                    return h10;
                }
                if (!z11 && (m10 = m()) != null) {
                    return m10;
                }
            } else {
                h m12 = m();
                if (m12 != null) {
                    return m12;
                }
            }
            return t(false);
        }

        private final void i(int i10) {
            this.f11681h = 0L;
            if (this.f11680g == d.PARKING) {
                if (d0.a()) {
                    if (!(i10 == 1)) {
                        throw new AssertionError();
                    }
                }
                this.f11680g = d.BLOCKING;
            }
        }

        private final boolean j() {
            return this.nextParkedWorker != a.f11669p;
        }

        private final void l() {
            if (this.f11681h == 0) {
                this.f11681h = System.nanoTime() + a.this.f11672h;
            }
            LockSupport.parkNanos(a.this.f11672h);
            if (System.nanoTime() - this.f11681h >= 0) {
                this.f11681h = 0L;
                u();
            }
        }

        private final h m() {
            kotlinx.coroutines.scheduling.d dVar;
            if (k(2) == 0) {
                h d10 = a.this.f11674j.d();
                if (d10 != null) {
                    return d10;
                }
                dVar = a.this.f11675k;
            } else {
                h d11 = a.this.f11675k.d();
                if (d11 != null) {
                    return d11;
                }
                dVar = a.this.f11674j;
            }
            return dVar.d();
        }

        private final void n() {
            loop0: while (true) {
                boolean z10 = false;
                while (!a.this.D() && this.f11680g != d.TERMINATED) {
                    h f10 = f(this.f11684k);
                    if (f10 != null) {
                        this.f11682i = 0L;
                        d(f10);
                    } else {
                        this.f11684k = false;
                        if (this.f11682i == 0) {
                            r();
                        } else if (z10) {
                            s(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f11682i);
                            this.f11682i = 0L;
                        } else {
                            z10 = true;
                        }
                    }
                }
            }
            s(d.TERMINATED);
        }

        private final boolean q() {
            boolean z10;
            if (this.f11680g != d.CPU_ACQUIRED) {
                a aVar = a.this;
                while (true) {
                    long j10 = aVar.controlState;
                    if (((int) ((9223367638808264704L & j10) >> 42)) == 0) {
                        z10 = false;
                        break;
                    }
                    if (a.f11667n.compareAndSet(aVar, j10, j10 - 4398046511104L)) {
                        z10 = true;
                        break;
                    }
                }
                if (!z10) {
                    return false;
                }
                this.f11680g = d.CPU_ACQUIRED;
            }
            return true;
        }

        private final void r() {
            if (!j()) {
                a.this.N(this);
                return;
            }
            if (d0.a()) {
                if (!(this.f11679f.f() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (j() && this.workerCtl == -1 && !a.this.D() && this.f11680g != d.TERMINATED) {
                s(d.PARKING);
                Thread.interrupted();
                l();
            }
        }

        private final h t(boolean z10) {
            if (d0.a()) {
                if (!(this.f11679f.f() == 0)) {
                    throw new AssertionError();
                }
            }
            int i10 = (int) (a.this.controlState & 2097151);
            if (i10 < 2) {
                return null;
            }
            int k10 = k(i10);
            a aVar = a.this;
            long j10 = Long.MAX_VALUE;
            int i11 = 0;
            while (i11 < i10) {
                i11++;
                k10++;
                if (k10 > i10) {
                    k10 = 1;
                }
                c b10 = aVar.f11676l.b(k10);
                if (b10 != null && b10 != this) {
                    if (d0.a()) {
                        if (!(this.f11679f.f() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    n nVar = this.f11679f;
                    n nVar2 = b10.f11679f;
                    long k11 = z10 ? nVar.k(nVar2) : nVar.l(nVar2);
                    if (k11 == -1) {
                        return this.f11679f.h();
                    }
                    if (k11 > 0) {
                        j10 = Math.min(j10, k11);
                    }
                }
            }
            if (j10 == Long.MAX_VALUE) {
                j10 = 0;
            }
            this.f11682i = j10;
            return null;
        }

        private final void u() {
            a aVar = a.this;
            synchronized (aVar.f11676l) {
                if (aVar.D()) {
                    return;
                }
                if (((int) (aVar.controlState & 2097151)) <= aVar.f11670f) {
                    return;
                }
                if (f11678m.compareAndSet(this, -1, 1)) {
                    int g10 = g();
                    o(0);
                    aVar.O(this, g10, 0);
                    int andDecrement = (int) (a.f11667n.getAndDecrement(aVar) & 2097151);
                    if (andDecrement != g10) {
                        c b10 = aVar.f11676l.b(andDecrement);
                        y8.k.b(b10);
                        c cVar = b10;
                        aVar.f11676l.c(g10, cVar);
                        cVar.o(g10);
                        aVar.O(cVar, andDecrement, g10);
                    }
                    aVar.f11676l.c(andDecrement, null);
                    w wVar = w.f11824a;
                    this.f11680g = d.TERMINATED;
                }
            }
        }

        public final h f(boolean z10) {
            h d10;
            if (q()) {
                return e(z10);
            }
            if (!z10 || (d10 = this.f11679f.h()) == null) {
                d10 = a.this.f11675k.d();
            }
            return d10 == null ? t(true) : d10;
        }

        public final int g() {
            return this.indexInArray;
        }

        public final Object h() {
            return this.nextParkedWorker;
        }

        public final int k(int i10) {
            int i11 = this.f11683j;
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 ^ (i12 >> 17);
            int i14 = i13 ^ (i13 << 5);
            this.f11683j = i14;
            int i15 = i10 - 1;
            return (i15 & i10) == 0 ? i14 & i15 : (i14 & Integer.MAX_VALUE) % i10;
        }

        public final void o(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a.this.f11673i);
            sb2.append("-worker-");
            sb2.append(i10 == 0 ? "TERMINATED" : String.valueOf(i10));
            setName(sb2.toString());
            this.indexInArray = i10;
        }

        public final void p(Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            n();
        }

        public final boolean s(d dVar) {
            d dVar2 = this.f11680g;
            boolean z10 = dVar2 == d.CPU_ACQUIRED;
            if (z10) {
                a.f11667n.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f11680g = dVar;
            }
            return z10;
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    static {
        new C0243a(null);
        f11669p = new b0("NOT_IN_STACK");
        f11666m = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");
        f11667n = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");
        f11668o = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");
    }

    public a(int i10, int i11, long j10, String str) {
        this.f11670f = i10;
        this.f11671g = i11;
        this.f11672h = j10;
        this.f11673i = str;
        if (!(i10 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i10 + " should be at least 1").toString());
        }
        if (!(i11 >= i10)) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should be greater than or equals to core pool size " + i10).toString());
        }
        if (!(i11 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j10 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
        }
        this.f11674j = new kotlinx.coroutines.scheduling.d();
        this.f11675k = new kotlinx.coroutines.scheduling.d();
        this.parkedWorkersStack = 0L;
        this.f11676l = new y<>(i10 + 1);
        this.controlState = i10 << 42;
        this._isTerminated = 0;
    }

    private final int H(c cVar) {
        int g10;
        do {
            Object h10 = cVar.h();
            if (h10 == f11669p) {
                return -1;
            }
            if (h10 == null) {
                return 0;
            }
            cVar = (c) h10;
            g10 = cVar.g();
        } while (g10 == 0);
        return g10;
    }

    private final c M() {
        while (true) {
            long j10 = this.parkedWorkersStack;
            c b10 = this.f11676l.b((int) (2097151 & j10));
            if (b10 == null) {
                return null;
            }
            long j11 = (2097152 + j10) & (-2097152);
            int H = H(b10);
            if (H >= 0 && f11666m.compareAndSet(this, j10, H | j11)) {
                b10.p(f11669p);
                return b10;
            }
        }
    }

    private final boolean c(h hVar) {
        return (hVar.f11696g.b() == 1 ? this.f11675k : this.f11674j).a(hVar);
    }

    private final void c0(boolean z10) {
        long addAndGet = f11667n.addAndGet(this, 2097152L);
        if (z10 || h0() || f0(addAndGet)) {
            return;
        }
        h0();
    }

    private final int d() {
        int a10;
        int i10;
        synchronized (this.f11676l) {
            if (D()) {
                i10 = -1;
            } else {
                long j10 = this.controlState;
                int i11 = (int) (j10 & 2097151);
                a10 = d9.f.a(i11 - ((int) ((j10 & 4398044413952L) >> 21)), 0);
                if (a10 >= this.f11670f) {
                    return 0;
                }
                if (i11 >= this.f11671g) {
                    return 0;
                }
                int i12 = ((int) (this.controlState & 2097151)) + 1;
                if (!(i12 > 0 && this.f11676l.b(i12) == null)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                c cVar = new c(i12);
                this.f11676l.c(i12, cVar);
                if (!(i12 == ((int) (2097151 & f11667n.incrementAndGet(this))))) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                cVar.start();
                i10 = a10 + 1;
            }
            return i10;
        }
    }

    private final h e0(c cVar, h hVar, boolean z10) {
        if (cVar == null || cVar.f11680g == d.TERMINATED) {
            return hVar;
        }
        if (hVar.f11696g.b() == 0 && cVar.f11680g == d.BLOCKING) {
            return hVar;
        }
        cVar.f11684k = true;
        return cVar.f11679f.a(hVar, z10);
    }

    private final boolean f0(long j10) {
        int a10;
        a10 = d9.f.a(((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21)), 0);
        if (a10 < this.f11670f) {
            int d10 = d();
            if (d10 == 1 && this.f11670f > 1) {
                d();
            }
            if (d10 > 0) {
                return true;
            }
        }
        return false;
    }

    private final c g() {
        Thread currentThread = Thread.currentThread();
        c cVar = currentThread instanceof c ? (c) currentThread : null;
        if (cVar != null && y8.k.a(a.this, this)) {
            return cVar;
        }
        return null;
    }

    static /* synthetic */ boolean g0(a aVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = aVar.controlState;
        }
        return aVar.f0(j10);
    }

    private final boolean h0() {
        c M;
        do {
            M = M();
            if (M == null) {
                return false;
            }
        } while (!c.f11678m.compareAndSet(M, -1, 0));
        LockSupport.unpark(M);
        return true;
    }

    public static /* synthetic */ void v(a aVar, Runnable runnable, i iVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            iVar = l.f11704f;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        aVar.j(runnable, iVar, z10);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean D() {
        return this._isTerminated;
    }

    public final boolean N(c cVar) {
        long j10;
        long j11;
        int g10;
        if (cVar.h() != f11669p) {
            return false;
        }
        do {
            j10 = this.parkedWorkersStack;
            int i10 = (int) (2097151 & j10);
            j11 = (2097152 + j10) & (-2097152);
            g10 = cVar.g();
            if (d0.a()) {
                if (!(g10 != 0)) {
                    throw new AssertionError();
                }
            }
            cVar.p(this.f11676l.b(i10));
        } while (!f11666m.compareAndSet(this, j10, g10 | j11));
        return true;
    }

    public final void O(c cVar, int i10, int i11) {
        while (true) {
            long j10 = this.parkedWorkersStack;
            int i12 = (int) (2097151 & j10);
            long j11 = (2097152 + j10) & (-2097152);
            if (i12 == i10) {
                i12 = i11 == 0 ? H(cVar) : i11;
            }
            if (i12 >= 0 && f11666m.compareAndSet(this, j10, j11 | i12)) {
                return;
            }
        }
    }

    public final void a0(h hVar) {
        try {
            hVar.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void b0(long j10) {
        int i10;
        if (f11668o.compareAndSet(this, 0, 1)) {
            c g10 = g();
            synchronized (this.f11676l) {
                i10 = (int) (this.controlState & 2097151);
            }
            if (1 <= i10) {
                int i11 = 1;
                while (true) {
                    int i12 = i11 + 1;
                    c b10 = this.f11676l.b(i11);
                    y8.k.b(b10);
                    c cVar = b10;
                    if (cVar != g10) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j10);
                        }
                        d dVar = cVar.f11680g;
                        if (d0.a()) {
                            if (!(dVar == d.TERMINATED)) {
                                throw new AssertionError();
                            }
                        }
                        cVar.f11679f.g(this.f11675k);
                    }
                    if (i11 == i10) {
                        break;
                    } else {
                        i11 = i12;
                    }
                }
            }
            this.f11675k.b();
            this.f11674j.b();
            while (true) {
                h f10 = g10 == null ? null : g10.f(true);
                if (f10 == null && (f10 = this.f11674j.d()) == null && (f10 = this.f11675k.d()) == null) {
                    break;
                } else {
                    a0(f10);
                }
            }
            if (g10 != null) {
                g10.s(d.TERMINATED);
            }
            if (d0.a()) {
                if (!(((int) ((this.controlState & 9223367638808264704L) >> 42)) == this.f11670f)) {
                    throw new AssertionError();
                }
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b0(10000L);
    }

    public final void d0() {
        if (h0() || g0(this, 0L, 1, null)) {
            return;
        }
        h0();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        v(this, runnable, null, false, 6, null);
    }

    public final h f(Runnable runnable, i iVar) {
        long a10 = l.f11703e.a();
        if (!(runnable instanceof h)) {
            return new k(runnable, a10, iVar);
        }
        h hVar = (h) runnable;
        hVar.f11695f = a10;
        hVar.f11696g = iVar;
        return hVar;
    }

    public final void j(Runnable runnable, i iVar, boolean z10) {
        nb.c.a();
        h f10 = f(runnable, iVar);
        c g10 = g();
        h e02 = e0(g10, f10, z10);
        if (e02 != null && !c(e02)) {
            throw new RejectedExecutionException(y8.k.j(this.f11673i, " was terminated"));
        }
        boolean z11 = z10 && g10 != null;
        if (f10.f11696g.b() != 0) {
            c0(z11);
        } else {
            if (z11) {
                return;
            }
            d0();
        }
    }

    public String toString() {
        StringBuilder sb2;
        char c10;
        ArrayList arrayList = new ArrayList();
        int a10 = this.f11676l.a();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 1;
        while (i15 < a10) {
            int i16 = i15 + 1;
            c b10 = this.f11676l.b(i15);
            if (b10 != null) {
                int f10 = b10.f11679f.f();
                int i17 = b.f11677a[b10.f11680g.ordinal()];
                if (i17 != 1) {
                    if (i17 == 2) {
                        i11++;
                        sb2 = new StringBuilder();
                        sb2.append(f10);
                        c10 = 'b';
                    } else if (i17 == 3) {
                        i10++;
                        sb2 = new StringBuilder();
                        sb2.append(f10);
                        c10 = 'c';
                    } else if (i17 == 4) {
                        i13++;
                        if (f10 > 0) {
                            sb2 = new StringBuilder();
                            sb2.append(f10);
                            c10 = 'd';
                        }
                    } else if (i17 == 5) {
                        i14++;
                    }
                    sb2.append(c10);
                    arrayList.add(sb2.toString());
                } else {
                    i12++;
                }
            }
            i15 = i16;
        }
        long j10 = this.controlState;
        return this.f11673i + '@' + e0.b(this) + "[Pool Size {core = " + this.f11670f + ", max = " + this.f11671g + "}, Worker States {CPU = " + i10 + ", blocking = " + i11 + ", parked = " + i12 + ", dormant = " + i13 + ", terminated = " + i14 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f11674j.c() + ", global blocking queue size = " + this.f11675k.c() + ", Control State {created workers= " + ((int) (2097151 & j10)) + ", blocking tasks = " + ((int) ((4398044413952L & j10) >> 21)) + ", CPUs acquired = " + (this.f11670f - ((int) ((9223367638808264704L & j10) >> 42))) + "}]";
    }
}
