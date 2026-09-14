package S2;

import w2.InterfaceC0768i;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class c extends T2.d {

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC0793i f2165d;

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC0793i f2166e;

    /* JADX WARN: Multi-variable type inference failed */
    public c(F2.p pVar, InterfaceC0768i interfaceC0768i, int i, R2.a aVar) {
        super(interfaceC0768i, i, aVar);
        AbstractC0793i abstractC0793i = (AbstractC0793i) pVar;
        this.f2165d = abstractC0793i;
        this.f2166e = abstractC0793i;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Type inference failed for: r7v3, types: [y2.i, F2.p] */
    @Override // T2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(R2.p r6, w2.InterfaceC0763d r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof S2.C0202b
            if (r0 == 0) goto L13
            r0 = r7
            S2.b r0 = (S2.C0202b) r0
            int r1 = r0.f2164d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2164d = r1
            goto L1a
        L13:
            S2.b r0 = new S2.b
            y2.c r7 = (y2.AbstractC0787c) r7
            r0.<init>(r5, r7)
        L1a:
            java.lang.Object r7 = r0.f2162b
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f2164d
            s2.i r3 = s2.C0684i.f6340a
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            R2.p r6 = r0.f2161a
            a.AbstractC0228a.C(r7)
            goto L49
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            a.AbstractC0228a.C(r7)
            r0.f2161a = r6
            r0.f2164d = r4
            y2.i r7 = r5.f2165d
            java.lang.Object r7 = r7.invoke(r6, r0)
            if (r7 != r1) goto L45
            goto L46
        L45:
            r7 = r3
        L46:
            if (r7 != r1) goto L49
            return r1
        L49:
            R2.o r6 = (R2.o) r6
            R2.c r6 = r6.f2069d
            boolean r6 = r6.r()
            if (r6 == 0) goto L54
            return r3
        L54:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: S2.c.b(R2.p, w2.d):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [y2.i, F2.p] */
    @Override // T2.d
    public final T2.d c(InterfaceC0768i interfaceC0768i, int i, R2.a aVar) {
        return new c(this.f2166e, interfaceC0768i, i, aVar);
    }

    @Override // T2.d
    public final String toString() {
        return "block[" + this.f2165d + "] -> " + super.toString();
    }
}
