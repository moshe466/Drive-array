package S2;

import R.C0191p;
import w2.InterfaceC0768i;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class q implements e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2212a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2213b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2214c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC0793i f2215d;

    public q(kotlin.jvm.internal.p pVar, e eVar, C0191p c0191p) {
        this.f2213b = pVar;
        this.f2214c = eVar;
        this.f2215d = c0191p;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    @Override // S2.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r8, w2.InterfaceC0763d r9) {
        /*
            r7 = this;
            int r0 = r7.f2212a
            switch(r0) {
                case 0: goto L1b;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r7.f2213b
            w2.i r0 = (w2.InterfaceC0768i) r0
            y2.i r1 = r7.f2215d
            T2.r r1 = (T2.r) r1
            java.lang.Object r2 = r7.f2214c
            java.lang.Object r8 = T2.j.b(r0, r8, r2, r1, r9)
            x2.a r9 = x2.EnumC0779a.f6740a
            if (r8 != r9) goto L18
            goto L1a
        L18:
            s2.i r8 = s2.C0684i.f6340a
        L1a:
            return r8
        L1b:
            boolean r0 = r9 instanceof S2.p
            if (r0 == 0) goto L2e
            r0 = r9
            S2.p r0 = (S2.p) r0
            int r1 = r0.f2211e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L2e
            int r1 = r1 - r2
            r0.f2211e = r1
            goto L33
        L2e:
            S2.p r0 = new S2.p
            r0.<init>(r7, r9)
        L33:
            java.lang.Object r9 = r0.f2209c
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f2211e
            r3 = 3
            r4 = 2
            s2.i r5 = s2.C0684i.f6340a
            r6 = 1
            if (r2 == 0) goto L5b
            if (r2 == r6) goto L46
            if (r2 == r4) goto L53
            if (r2 != r3) goto L4b
        L46:
            a.AbstractC0228a.C(r9)
        L49:
            r1 = r5
            goto La4
        L4b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L53:
            java.lang.Object r8 = r0.f2208b
            S2.q r2 = r0.f2207a
            a.AbstractC0228a.C(r9)
            goto L85
        L5b:
            a.AbstractC0228a.C(r9)
            java.lang.Object r9 = r7.f2213b
            kotlin.jvm.internal.p r9 = (kotlin.jvm.internal.p) r9
            boolean r9 = r9.f5310a
            if (r9 == 0) goto L73
            java.lang.Object r9 = r7.f2214c
            S2.e r9 = (S2.e) r9
            r0.f2211e = r6
            java.lang.Object r8 = r9.emit(r8, r0)
            if (r8 != r1) goto L49
            goto La4
        L73:
            y2.i r9 = r7.f2215d
            R.p r9 = (R.C0191p) r9
            r0.f2207a = r7
            r0.f2208b = r8
            r0.f2211e = r4
            java.lang.Object r9 = r9.invoke(r8, r0)
            if (r9 != r1) goto L84
            goto La4
        L84:
            r2 = r7
        L85:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L49
            java.lang.Object r9 = r2.f2213b
            kotlin.jvm.internal.p r9 = (kotlin.jvm.internal.p) r9
            r9.f5310a = r6
            java.lang.Object r9 = r2.f2214c
            S2.e r9 = (S2.e) r9
            r2 = 0
            r0.f2207a = r2
            r0.f2208b = r2
            r0.f2211e = r3
            java.lang.Object r8 = r9.emit(r8, r0)
            if (r8 != r1) goto L49
        La4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: S2.q.emit(java.lang.Object, w2.d):java.lang.Object");
    }

    public q(e eVar, InterfaceC0768i interfaceC0768i) {
        this.f2213b = interfaceC0768i;
        this.f2214c = U2.a.k(interfaceC0768i);
        this.f2215d = new T2.r(eVar, null);
    }
}
