package R;

import s2.C0684i;
import w2.InterfaceC0763d;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class H extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public int f1773a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ P f1774b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(P p, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f1774b = p;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new H(this.f1774b, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((H) create((P2.E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        if (r7 == r2) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        if (r0.h(r6) == r2) goto L22;
     */
    @Override // y2.AbstractC0785a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            R.P r0 = r6.f1774b
            F0.G1 r1 = r0.f1810h
            x2.a r2 = x2.EnumC0779a.f6740a
            int r3 = r6.f1773a
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L22
            if (r3 == r5) goto L1c
            if (r3 != r4) goto L14
            a.AbstractC0228a.C(r7)
            goto L45
        L14:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1c:
            a.AbstractC0228a.C(r7)     // Catch: java.lang.Throwable -> L20
            goto L3b
        L20:
            r7 = move-exception
            goto L48
        L22:
            a.AbstractC0228a.C(r7)
            R.k0 r7 = r1.l()
            boolean r7 = r7 instanceof R.b0
            if (r7 == 0) goto L32
            R.k0 r7 = r1.l()
            return r7
        L32:
            r6.f1773a = r5     // Catch: java.lang.Throwable -> L20
            java.lang.Object r7 = r0.h(r6)     // Catch: java.lang.Throwable -> L20
            if (r7 != r2) goto L3b
            goto L44
        L3b:
            r6.f1773a = r4
            r7 = 0
            java.lang.Object r7 = R.P.e(r0, r7, r6)
            if (r7 != r2) goto L45
        L44:
            return r2
        L45:
            R.k0 r7 = (R.k0) r7
            return r7
        L48:
            R.d0 r0 = new R.d0
            r1 = -1
            r0.<init>(r7, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: R.H.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
