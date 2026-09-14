package R;

import y2.AbstractC0793i;

/* renamed from: R.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0194t implements S2.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1940a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1941b;

    public C0194t(S2.k kVar) {
        this.f1941b = kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Type inference failed for: r7v6, types: [y2.i, F2.p] */
    @Override // S2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(S2.e r7, w2.InterfaceC0763d r8) {
        /*
            r6 = this;
            int r0 = r6.f1940a
            switch(r0) {
                case 0: goto L69;
                default: goto L5;
            }
        L5:
            boolean r0 = r8 instanceof S2.C0201a
            if (r0 == 0) goto L18
            r0 = r8
            S2.a r0 = (S2.C0201a) r0
            int r1 = r0.f2160d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L18
            int r1 = r1 - r2
            r0.f2160d = r1
            goto L1d
        L18:
            S2.a r0 = new S2.a
            r0.<init>(r6, r8)
        L1d:
            java.lang.Object r8 = r0.f2158b
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f2160d
            s2.i r3 = s2.C0684i.f6340a
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            T2.l r7 = r0.f2157a
            a.AbstractC0228a.C(r8)     // Catch: java.lang.Throwable -> L30
            goto L5a
        L30:
            r8 = move-exception
            goto L65
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            a.AbstractC0228a.C(r8)
            T2.l r8 = new T2.l
            w2.i r2 = r0.getContext()
            r8.<init>(r7, r2)
            r0.f2157a = r8     // Catch: java.lang.Throwable -> L63
            r0.f2160d = r4     // Catch: java.lang.Throwable -> L63
            java.lang.Object r7 = r6.f1941b     // Catch: java.lang.Throwable -> L63
            y2.i r7 = (y2.AbstractC0793i) r7     // Catch: java.lang.Throwable -> L63
            java.lang.Object r7 = r7.invoke(r8, r0)     // Catch: java.lang.Throwable -> L63
            if (r7 != r1) goto L55
            goto L56
        L55:
            r7 = r3
        L56:
            if (r7 != r1) goto L59
            goto L5e
        L59:
            r7 = r8
        L5a:
            r7.releaseIntercepted()
            r1 = r3
        L5e:
            return r1
        L5f:
            r5 = r8
            r8 = r7
            r7 = r5
            goto L65
        L63:
            r7 = move-exception
            goto L5f
        L65:
            r7.releaseIntercepted()
            throw r8
        L69:
            java.lang.Object r0 = r6.f1941b
            S2.k r0 = (S2.k) r0
            R.s r1 = new R.s
            r2 = 0
            r1.<init>(r7, r2)
            java.lang.Object r7 = r0.collect(r1, r8)
            x2.a r8 = x2.EnumC0779a.f6740a
            if (r7 != r8) goto L7c
            goto L7e
        L7c:
            s2.i r7 = s2.C0684i.f6340a
        L7e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: R.C0194t.collect(S2.e, w2.d):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0194t(F2.p pVar) {
        this.f1941b = (AbstractC0793i) pVar;
    }
}
