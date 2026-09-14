package R2;

import F0.AbstractC0008a;
import s2.C0684i;
import w2.InterfaceC0763d;

/* loaded from: classes.dex */
public final class m extends c {

    /* renamed from: n, reason: collision with root package name */
    public final a f2065n;

    public m(int i, a aVar) {
        super(i);
        this.f2065n = aVar;
        if (aVar != a.f2018a) {
            if (i >= 1) {
            } else {
                throw new IllegalArgumentException(AbstractC0008a.j(i, "Buffered channel capacity must be at least 1, but ", " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + kotlin.jvm.internal.s.a(c.class).c() + " instead").toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b6, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object C(java.lang.Object r16, boolean r17) {
        /*
            r15 = this;
            R2.a r1 = r15.f2065n
            R2.a r2 = R2.a.f2020c
            s2.i r8 = s2.C0684i.f6340a
            if (r1 != r2) goto L17
            java.lang.Object r1 = super.b(r16)
            boolean r2 = r1 instanceof R2.i
            if (r2 == 0) goto L16
            boolean r2 = r1 instanceof R2.h
            if (r2 == 0) goto L15
            goto L16
        L15:
            return r8
        L16:
            return r1
        L17:
            F0.G1 r6 = R2.e.f2039d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = R2.c.f2029f
            java.lang.Object r1 = r1.get(r15)
            R2.k r1 = (R2.k) r1
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = R2.c.f2025b
            long r2 = r2.getAndIncrement(r15)
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r4 = r4 & r2
            r7 = 0
            boolean r7 = r15.q(r2, r7)
            int r9 = R2.e.f2037b
            long r10 = (long) r9
            long r2 = r4 / r10
            long r12 = r4 % r10
            int r12 = (int) r12
            long r13 = r1.f2376c
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 == 0) goto L53
            R2.k r2 = R2.c.a(r15, r2, r1)
            if (r2 != 0) goto L52
            if (r7 == 0) goto L21
            java.lang.Throwable r1 = r15.n()
            R2.h r2 = new R2.h
            r2.<init>(r1)
            return r2
        L52:
            r1 = r2
        L53:
            r0 = r15
            r3 = r16
            r2 = r12
            int r12 = R2.c.e(r0, r1, r2, r3, r4, r6, r7)
            if (r12 == 0) goto Lb7
            r3 = 1
            if (r12 == r3) goto Lb6
            r3 = 2
            if (r12 == r3) goto L90
            r2 = 3
            if (r12 == r2) goto L88
            r2 = 4
            if (r12 == r2) goto L71
            r2 = 5
            if (r12 == r2) goto L6d
            goto L21
        L6d:
            r1.b()
            goto L21
        L71:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = R2.c.f2026c
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L7e
            r1.b()
        L7e:
            java.lang.Throwable r1 = r15.n()
            R2.h r2 = new R2.h
            r2.<init>(r1)
            return r2
        L88:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "unexpected"
            r1.<init>(r2)
            throw r1
        L90:
            if (r7 == 0) goto L9f
            r1.i()
            java.lang.Throwable r1 = r15.n()
            R2.h r2 = new R2.h
            r2.<init>(r1)
            return r2
        L9f:
            boolean r3 = r6 instanceof P2.K0
            if (r3 == 0) goto La6
            P2.K0 r6 = (P2.K0) r6
            goto La7
        La6:
            r6 = 0
        La7:
            if (r6 == 0) goto Lae
            int r12 = r2 + r9
            r6.b(r1, r12)
        Lae:
            long r3 = r1.f2376c
            long r3 = r3 * r10
            long r1 = (long) r2
            long r3 = r3 + r1
            r15.i(r3)
        Lb6:
            return r8
        Lb7:
            r1.b()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: R2.m.C(java.lang.Object, boolean):java.lang.Object");
    }

    @Override // R2.c, R2.r
    public final Object b(Object obj) {
        return C(obj, false);
    }

    @Override // R2.c, R2.r
    public final Object d(Object obj, InterfaceC0763d interfaceC0763d) {
        if (!(C(obj, true) instanceof h)) {
            return C0684i.f6340a;
        }
        throw n();
    }

    @Override // R2.c
    public final boolean s() {
        if (this.f2065n == a.f2019b) {
            return true;
        }
        return false;
    }
}
