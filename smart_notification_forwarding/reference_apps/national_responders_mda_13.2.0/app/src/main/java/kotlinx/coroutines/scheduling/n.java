package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import nb.d0;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f11707b = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f11708c = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f11709d = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f11710e = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReferenceArray<h> f11711a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ h b(n nVar, h hVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return nVar.a(hVar, z10);
    }

    private final h c(h hVar) {
        if (hVar.f11696g.b() == 1) {
            f11710e.incrementAndGet(this);
        }
        if (e() == 127) {
            return hVar;
        }
        int i10 = this.producerIndex & 127;
        while (this.f11711a.get(i10) != null) {
            Thread.yield();
        }
        this.f11711a.lazySet(i10, hVar);
        f11708c.incrementAndGet(this);
        return null;
    }

    private final void d(h hVar) {
        if (hVar != null) {
            if (hVar.f11696g.b() == 1) {
                int decrementAndGet = f11710e.decrementAndGet(this);
                if (d0.a()) {
                    if (!(decrementAndGet >= 0)) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    private final h i() {
        h andSet;
        while (true) {
            int i10 = this.consumerIndex;
            if (i10 - this.producerIndex == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (f11709d.compareAndSet(this, i10, i10 + 1) && (andSet = this.f11711a.getAndSet(i11, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(d dVar) {
        h i10 = i();
        if (i10 == null) {
            return false;
        }
        dVar.a(i10);
        return true;
    }

    private final long m(n nVar, boolean z10) {
        h hVar;
        do {
            hVar = (h) nVar.lastScheduledTask;
            if (hVar == null) {
                return -2L;
            }
            if (z10) {
                if (!(hVar.f11696g.b() == 1)) {
                    return -2L;
                }
            }
            long a10 = l.f11703e.a() - hVar.f11695f;
            long j10 = l.f11699a;
            if (a10 < j10) {
                return j10 - a10;
            }
        } while (!f11707b.compareAndSet(nVar, hVar, null));
        b(this, hVar, false, 2, null);
        return -1L;
    }

    public final h a(h hVar, boolean z10) {
        if (z10) {
            return c(hVar);
        }
        h hVar2 = (h) f11707b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return c(hVar2);
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(d dVar) {
        h hVar = (h) f11707b.getAndSet(this, null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        do {
        } while (j(dVar));
    }

    public final h h() {
        h hVar = (h) f11707b.getAndSet(this, null);
        return hVar == null ? i() : hVar;
    }

    public final long k(n nVar) {
        if (d0.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        int i10 = nVar.producerIndex;
        AtomicReferenceArray<h> atomicReferenceArray = nVar.f11711a;
        for (int i11 = nVar.consumerIndex; i11 != i10; i11++) {
            int i12 = i11 & 127;
            if (nVar.blockingTasksInBuffer == 0) {
                break;
            }
            h hVar = atomicReferenceArray.get(i12);
            if (hVar != null) {
                if ((hVar.f11696g.b() == 1) && atomicReferenceArray.compareAndSet(i12, hVar, null)) {
                    f11710e.decrementAndGet(nVar);
                    b(this, hVar, false, 2, null);
                    return -1L;
                }
            }
        }
        return m(nVar, true);
    }

    public final long l(n nVar) {
        if (d0.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        h i10 = nVar.i();
        if (i10 == null) {
            return m(nVar, false);
        }
        h b10 = b(this, i10, false, 2, null);
        if (!d0.a()) {
            return -1L;
        }
        if (b10 == null) {
            return -1L;
        }
        throw new AssertionError();
    }
}
