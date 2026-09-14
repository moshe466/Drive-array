package R2;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final class k extends U2.s {

    /* renamed from: e, reason: collision with root package name */
    public final c f2059e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f2060f;

    public k(long j2, k kVar, c cVar, int i) {
        super(j2, kVar, i);
        this.f2059e = cVar;
        this.f2060f = new AtomicReferenceArray(e.f2037b * 2);
    }

    @Override // U2.s
    public final int g() {
        return e.f2037b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0059, code lost:
    
        n(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x005c, code lost:
    
        if (r0 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x005e, code lost:
    
        kotlin.jvm.internal.j.b(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0061, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
    
        return;
     */
    @Override // U2.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(int r5, w2.InterfaceC0768i r6) {
        /*
            r4 = this;
            int r6 = R2.e.f2037b
            if (r5 < r6) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r5 = r5 - r6
        La:
            int r6 = r5 * 2
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r4.f2060f
            r1.get(r6)
        L11:
            java.lang.Object r6 = r4.l(r5)
            boolean r1 = r6 instanceof P2.K0
            R2.c r2 = r4.f2059e
            r3 = 0
            if (r1 != 0) goto L62
            boolean r1 = r6 instanceof R2.s
            if (r1 == 0) goto L21
            goto L62
        L21:
            F0.G1 r1 = R2.e.f2044j
            if (r6 == r1) goto L59
            F0.G1 r1 = R2.e.f2045k
            if (r6 != r1) goto L2a
            goto L59
        L2a:
            F0.G1 r1 = R2.e.f2042g
            if (r6 == r1) goto L11
            F0.G1 r1 = R2.e.f2041f
            if (r6 != r1) goto L33
            goto L11
        L33:
            F0.G1 r5 = R2.e.i
            if (r6 == r5) goto L7c
            F0.G1 r5 = R2.e.f2039d
            if (r6 != r5) goto L3c
            goto L7c
        L3c:
            F0.G1 r5 = R2.e.f2046l
            if (r6 != r5) goto L41
            goto L7c
        L41:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "unexpected state: "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L59:
            r4.n(r5, r3)
            if (r0 == 0) goto L7c
            kotlin.jvm.internal.j.b(r2)
            return
        L62:
            if (r0 == 0) goto L67
            F0.G1 r1 = R2.e.f2044j
            goto L69
        L67:
            F0.G1 r1 = R2.e.f2045k
        L69:
            boolean r6 = r4.k(r5, r6, r1)
            if (r6 == 0) goto L11
            r4.n(r5, r3)
            r6 = r0 ^ 1
            r4.m(r5, r6)
            if (r0 == 0) goto L7c
            kotlin.jvm.internal.j.b(r2)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: R2.k.h(int, w2.i):void");
    }

    public final boolean k(int i, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        int i3 = (i * 2) + 1;
        do {
            atomicReferenceArray = this.f2060f;
            if (atomicReferenceArray.compareAndSet(i3, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i3) == obj);
        return false;
    }

    public final Object l(int i) {
        return this.f2060f.get((i * 2) + 1);
    }

    public final void m(int i, boolean z3) {
        if (z3) {
            c cVar = this.f2059e;
            kotlin.jvm.internal.j.b(cVar);
            cVar.B((this.f2376c * e.f2037b) + i);
        }
        i();
    }

    public final void n(int i, Object obj) {
        this.f2060f.set(i * 2, obj);
    }

    public final void o(int i, Object obj) {
        this.f2060f.set((i * 2) + 1, obj);
    }
}
