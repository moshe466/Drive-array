package R;

import s2.C0684i;
import w2.InterfaceC0763d;
import y2.AbstractC0793i;

/* renamed from: R.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0200z extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public int f1964a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ P f1965b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0200z(P p, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f1965b = p;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new C0200z(this.f1965b, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((C0200z) create((P2.E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        if (r9 == r0) goto L23;
     */
    @Override // y2.AbstractC0785a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            x2.a r0 = x2.EnumC0779a.f6740a
            int r1 = r8.f1964a
            s2.i r2 = s2.C0684i.f6340a
            r3 = 2
            r4 = 1
            R.P r5 = r8.f1965b
            if (r1 == 0) goto L20
            if (r1 == r4) goto L1c
            if (r1 != r3) goto L14
            a.AbstractC0228a.C(r9)
            return r2
        L14:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1c:
            a.AbstractC0228a.C(r9)
            goto L36
        L20:
            a.AbstractC0228a.C(r9)
            K1.m r9 = r5.i
            r8.f1964a = r4
            java.lang.Object r9 = r9.f1104c
            P2.t r9 = (P2.C0169t) r9
            java.lang.Object r9 = r9.j(r8)
            if (r9 != r0) goto L32
            goto L33
        L32:
            r9 = r2
        L33:
            if (r9 != r0) goto L36
            goto L61
        L36:
            R.j0 r9 = r5.g()
            R.t r9 = r9.f1905c
            R2.a r1 = R2.a.f2019b
            boolean r6 = r9 instanceof T2.h
            r7 = 0
            if (r6 == 0) goto L4b
            T2.h r9 = (T2.h) r9
            r6 = 0
            S2.d r9 = T2.j.a(r9, r6, r7, r1, r4)
            goto L53
        L4b:
            T2.f r4 = new T2.f
            w2.j r6 = w2.C0769j.f6733a
            r4.<init>(r9, r6, r7, r1)
            r9 = r4
        L53:
            R.s r1 = new R.s
            r4 = 1
            r1.<init>(r5, r4)
            r8.f1964a = r3
            java.lang.Object r9 = r9.collect(r1, r8)
            if (r9 != r0) goto L62
        L61:
            return r0
        L62:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: R.C0200z.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
