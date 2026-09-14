package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class o {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f11643f = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_next");

    /* renamed from: g, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f11644g = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_prev");

    /* renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f11645h = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    /* loaded from: classes.dex */
    public static abstract class a extends c<o> {

        /* renamed from: b, reason: collision with root package name */
        public final o f11646b;

        /* renamed from: c, reason: collision with root package name */
        public o f11647c;

        public a(o oVar) {
            this.f11646b = oVar;
        }

        @Override // kotlinx.coroutines.internal.c
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(o oVar, Object obj) {
            boolean z10 = obj == null;
            o oVar2 = z10 ? this.f11646b : this.f11647c;
            if (oVar2 != null && o.f11643f.compareAndSet(oVar, this, oVar2) && z10) {
                o oVar3 = this.f11646b;
                o oVar4 = this.f11647c;
                y8.k.b(oVar4);
                oVar3.l(oVar4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        if (kotlinx.coroutines.internal.o.f11643f.compareAndSet(r3, r2, ((kotlinx.coroutines.internal.x) r4).f11664a) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlinx.coroutines.internal.o j(kotlinx.coroutines.internal.w r8) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.o r0 = (kotlinx.coroutines.internal.o) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.o.f11644g
            boolean r0 = r1.compareAndSet(r7, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r7.q()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r8) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.w
            if (r5 == 0) goto L38
            if (r8 == 0) goto L32
            r0 = r4
            kotlinx.coroutines.internal.w r0 = (kotlinx.coroutines.internal.w) r0
            boolean r0 = r8.b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            kotlinx.coroutines.internal.w r4 = (kotlinx.coroutines.internal.w) r4
            r4.c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.x
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.o.f11643f
            kotlinx.coroutines.internal.x r4 = (kotlinx.coroutines.internal.x) r4
            kotlinx.coroutines.internal.o r4 = r4.f11664a
            boolean r2 = r5.compareAndSet(r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.o r2 = (kotlinx.coroutines.internal.o) r2
            goto L7
        L52:
            r3 = r4
            kotlinx.coroutines.internal.o r3 = (kotlinx.coroutines.internal.o) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.o.j(kotlinx.coroutines.internal.w):kotlinx.coroutines.internal.o");
    }

    private final o k(o oVar) {
        while (oVar.q()) {
            oVar = (o) oVar._prev;
        }
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(o oVar) {
        o oVar2;
        do {
            oVar2 = (o) oVar._prev;
            if (m() != oVar) {
                return;
            }
        } while (!f11644g.compareAndSet(oVar, oVar2, this));
        if (q()) {
            oVar.j(null);
        }
    }

    private final x u() {
        x xVar = (x) this._removedRef;
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x(this);
        f11645h.lazySet(this, xVar2);
        return xVar2;
    }

    public final boolean c(o oVar) {
        f11644g.lazySet(oVar, this);
        f11643f.lazySet(oVar, this);
        while (m() == this) {
            if (f11643f.compareAndSet(this, this, oVar)) {
                oVar.l(this);
                return true;
            }
        }
        return false;
    }

    public final Object m() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof w)) {
                return obj;
            }
            ((w) obj).c(this);
        }
    }

    public final o o() {
        return n.b(m());
    }

    public final o p() {
        o j10 = j(null);
        return j10 == null ? k((o) this._prev) : j10;
    }

    public boolean q() {
        return m() instanceof x;
    }

    public boolean r() {
        return s() == null;
    }

    public final o s() {
        Object m10;
        o oVar;
        do {
            m10 = m();
            if (m10 instanceof x) {
                return ((x) m10).f11664a;
            }
            if (m10 == this) {
                return (o) m10;
            }
            oVar = (o) m10;
        } while (!f11643f.compareAndSet(this, m10, oVar.u()));
        oVar.j(null);
        return null;
    }

    public String toString() {
        return new y8.r(this) { // from class: kotlinx.coroutines.internal.o.b
            @Override // e9.h
            public Object get() {
                return nb.e0.a(this.f15934g);
            }
        } + '@' + nb.e0.b(this);
    }

    public final int v(o oVar, o oVar2, a aVar) {
        f11644g.lazySet(oVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11643f;
        atomicReferenceFieldUpdater.lazySet(oVar, oVar2);
        aVar.f11647c = oVar2;
        if (atomicReferenceFieldUpdater.compareAndSet(this, oVar2, aVar)) {
            return aVar.c(this) == null ? 1 : 2;
        }
        return 0;
    }
}
