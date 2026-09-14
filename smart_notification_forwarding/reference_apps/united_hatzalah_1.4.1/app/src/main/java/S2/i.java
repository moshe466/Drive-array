package S2;

import R.C0192q;
import R.C0194t;

/* loaded from: classes.dex */
public final class i implements d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0194t f2181a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0192q f2182b;

    public i(C0194t c0194t, C0192q c0192q) {
        this.f2181a = c0194t;
        this.f2182b = c0192q;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // S2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(S2.e r9, w2.InterfaceC0763d r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof S2.h
            if (r0 == 0) goto L13
            r0 = r10
            S2.h r0 = (S2.h) r0
            int r1 = r0.f2177b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2177b = r1
            goto L18
        L13:
            S2.h r0 = new S2.h
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f2176a
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f2177b
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L50
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r9 = r0.f2179d
            T2.l r9 = (T2.l) r9
            a.AbstractC0228a.C(r10)     // Catch: java.lang.Throwable -> L32
            goto L7c
        L32:
            r10 = move-exception
            goto L86
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            java.lang.Object r9 = r0.f2179d
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            a.AbstractC0228a.C(r10)
            goto La0
        L44:
            S2.e r9 = r0.f2180e
            java.lang.Object r2 = r0.f2179d
            S2.i r2 = (S2.i) r2
            a.AbstractC0228a.C(r10)     // Catch: java.lang.Throwable -> L4e
            goto L63
        L4e:
            r9 = move-exception
            goto L8c
        L50:
            a.AbstractC0228a.C(r10)
            R.t r10 = r8.f2181a     // Catch: java.lang.Throwable -> L8a
            r0.f2179d = r8     // Catch: java.lang.Throwable -> L8a
            r0.f2180e = r9     // Catch: java.lang.Throwable -> L8a
            r0.f2177b = r5     // Catch: java.lang.Throwable -> L8a
            java.lang.Object r10 = r10.collect(r9, r0)     // Catch: java.lang.Throwable -> L8a
            if (r10 != r1) goto L62
            goto L9f
        L62:
            r2 = r8
        L63:
            T2.l r10 = new T2.l
            w2.i r4 = r0.getContext()
            r10.<init>(r9, r4)
            R.q r9 = r2.f2182b     // Catch: java.lang.Throwable -> L82
            r0.f2179d = r10     // Catch: java.lang.Throwable -> L82
            r0.f2180e = r6     // Catch: java.lang.Throwable -> L82
            r0.f2177b = r3     // Catch: java.lang.Throwable -> L82
            java.lang.Object r9 = r9.invoke(r10, r6, r0)     // Catch: java.lang.Throwable -> L82
            if (r9 != r1) goto L7b
            goto L9f
        L7b:
            r9 = r10
        L7c:
            r9.releaseIntercepted()
            s2.i r9 = s2.C0684i.f6340a
            return r9
        L82:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L86:
            r9.releaseIntercepted()
            throw r10
        L8a:
            r9 = move-exception
            r2 = r8
        L8c:
            S2.B r10 = new S2.B
            r10.<init>(r9)
            R.q r2 = r2.f2182b
            r0.f2179d = r9
            r0.f2180e = r6
            r0.f2177b = r4
            java.lang.Object r10 = S2.z.a(r10, r2, r9, r0)
            if (r10 != r1) goto La0
        L9f:
            return r1
        La0:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: S2.i.collect(S2.e, w2.d):java.lang.Object");
    }
}
