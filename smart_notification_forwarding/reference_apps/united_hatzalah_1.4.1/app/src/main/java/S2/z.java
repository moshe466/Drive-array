package S2;

import F0.G1;
import w2.C0769j;

/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final G1 f2245a;

    /* renamed from: b, reason: collision with root package name */
    public static final G1 f2246b;

    static {
        int i = 8;
        f2245a = new G1("NONE", i);
        f2246b = new G1("PENDING", i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(S2.B r4, R.C0192q r5, java.lang.Throwable r6, y2.AbstractC0787c r7) {
        /*
            boolean r0 = r7 instanceof S2.g
            if (r0 == 0) goto L13
            r0 = r7
            S2.g r0 = (S2.g) r0
            int r1 = r0.f2175c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2175c = r1
            goto L18
        L13:
            S2.g r0 = new S2.g
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f2174b
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f2175c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Throwable r6 = r0.f2173a
            a.AbstractC0228a.C(r7)     // Catch: java.lang.Throwable -> L29
            goto L41
        L29:
            r4 = move-exception
            goto L44
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            a.AbstractC0228a.C(r7)
            r0.f2173a = r6     // Catch: java.lang.Throwable -> L29
            r0.f2175c = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L29
            if (r4 != r1) goto L41
            return r1
        L41:
            s2.i r4 = s2.C0684i.f6340a
            return r4
        L44:
            if (r6 == 0) goto L4b
            if (r6 == r4) goto L4b
            E1.b.b(r4, r6)
        L4b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: S2.z.a(S2.B, R.q, java.lang.Throwable, y2.c):java.lang.Object");
    }

    public static final c b(F2.p pVar) {
        return new c(pVar, C0769j.f6733a, -2, R2.a.f2018a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlin.jvm.internal.r, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.Serializable c(S2.d r4, S2.e r5, y2.AbstractC0787c r6) {
        /*
            boolean r0 = r6 instanceof S2.m
            if (r0 == 0) goto L13
            r0 = r6
            S2.m r0 = (S2.m) r0
            int r1 = r0.f2199c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2199c = r1
            goto L18
        L13:
            S2.m r0 = new S2.m
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f2198b
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f2199c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.jvm.internal.r r4 = r0.f2197a
            a.AbstractC0228a.C(r6)     // Catch: java.lang.Throwable -> L29
            goto L4b
        L29:
            r5 = move-exception
            goto L4f
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            a.AbstractC0228a.C(r6)
            kotlin.jvm.internal.r r6 = new kotlin.jvm.internal.r
            r6.<init>()
            S2.o r2 = new S2.o     // Catch: java.lang.Throwable -> L4d
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L4d
            r0.f2197a = r6     // Catch: java.lang.Throwable -> L4d
            r0.f2199c = r3     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: java.lang.Throwable -> L4d
            if (r4 != r1) goto L4b
            return r1
        L4b:
            r4 = 0
            return r4
        L4d:
            r5 = move-exception
            r4 = r6
        L4f:
            java.lang.Object r4 = r4.f5312a
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            if (r4 == 0) goto L5b
            boolean r6 = r4.equals(r5)
            if (r6 != 0) goto L7d
        L5b:
            w2.i r6 = r0.getContext()
            P2.B r0 = P2.B.f1595b
            w2.g r6 = r6.get(r0)
            P2.i0 r6 = (P2.InterfaceC0157i0) r6
            if (r6 == 0) goto L7e
            boolean r0 = r6.isCancelled()
            if (r0 != 0) goto L70
            goto L7e
        L70:
            java.util.concurrent.CancellationException r6 = r6.getCancellationException()
            if (r6 == 0) goto L7e
            boolean r6 = r6.equals(r5)
            if (r6 != 0) goto L7d
            goto L7e
        L7d:
            throw r5
        L7e:
            if (r4 != 0) goto L81
            return r5
        L81:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L89
            E1.b.b(r4, r5)
            throw r4
        L89:
            E1.b.b(r5, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: S2.z.c(S2.d, S2.e, y2.c):java.io.Serializable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0094, code lost:
    
        if (r11 == r1) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007a A[Catch: all -> 0x0036, TryCatch #1 {all -> 0x0036, blocks: (B:12:0x002f, B:14:0x005e, B:20:0x0072, B:22:0x007a, B:24:0x0080, B:26:0x0086, B:28:0x0097, B:29:0x009f, B:30:0x00a0, B:31:0x00a7, B:39:0x0049, B:42:0x0054), top: B:7:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /* JADX WARN: Type inference failed for: r0v2, types: [S2.f, w2.d] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2, types: [S2.e] */
    /* JADX WARN: Type inference failed for: r2v3, types: [R2.b] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r9v4, types: [R2.q] */
    /* JADX WARN: Type inference failed for: r9v6, types: [R2.q] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0094 -> B:13:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(S2.e r8, R2.o r9, boolean r10, y2.AbstractC0787c r11) {
        /*
            Method dump skipped, instructions count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S2.z.d(S2.e, R2.o, boolean, y2.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlin.jvm.internal.r, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(S2.d r6, y2.AbstractC0787c r7) {
        /*
            boolean r0 = r7 instanceof S2.u
            if (r0 == 0) goto L13
            r0 = r7
            S2.u r0 = (S2.u) r0
            int r1 = r0.f2230d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2230d = r1
            goto L18
        L13:
            S2.u r0 = new S2.u
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f2229c
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f2230d
            F0.G1 r3 = T2.j.f2291a
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            S2.t r6 = r0.f2228b
            kotlin.jvm.internal.r r0 = r0.f2227a
            a.AbstractC0228a.C(r7)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L2d
            goto L5e
        L2d:
            r7 = move-exception
            goto L5a
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            a.AbstractC0228a.C(r7)
            kotlin.jvm.internal.r r7 = new kotlin.jvm.internal.r
            r7.<init>()
            r7.f5312a = r3
            S2.t r2 = new S2.t
            r5 = 0
            r2.<init>(r7, r5)
            r0.f2227a = r7     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            r0.f2228b = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            r0.f2230d = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            java.lang.Object r6 = r6.collect(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            if (r6 != r1) goto L54
            return r1
        L54:
            r0 = r7
            goto L5e
        L56:
            r6 = move-exception
            r0 = r7
            r7 = r6
            r6 = r2
        L5a:
            java.lang.Object r1 = r7.f5316a
            if (r1 != r6) goto L6b
        L5e:
            java.lang.Object r6 = r0.f5312a
            if (r6 == r3) goto L63
            return r6
        L63:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException
            java.lang.String r7 = "Expected at least one element"
            r6.<init>(r7)
            throw r6
        L6b:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: S2.z.e(S2.d, y2.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlin.jvm.internal.r, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(S2.d r5, w2.InterfaceC0763d r6) {
        /*
            boolean r0 = r6 instanceof S2.v
            if (r0 == 0) goto L13
            r0 = r6
            S2.v r0 = (S2.v) r0
            int r1 = r0.f2234d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2234d = r1
            goto L18
        L13:
            S2.v r0 = new S2.v
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f2233c
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f2234d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            S2.t r5 = r0.f2232b
            kotlin.jvm.internal.r r0 = r0.f2231a
            a.AbstractC0228a.C(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L2b
            goto L5a
        L2b:
            r6 = move-exception
            goto L56
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            a.AbstractC0228a.C(r6)
            kotlin.jvm.internal.r r6 = new kotlin.jvm.internal.r
            r6.<init>()
            S2.t r2 = new S2.t
            r4 = 1
            r2.<init>(r6, r4)
            r0.f2231a = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L52
            r0.f2232b = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L52
            r0.f2234d = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L52
            java.lang.Object r5 = r5.collect(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L52
            if (r5 != r1) goto L50
            return r1
        L50:
            r0 = r6
            goto L5a
        L52:
            r5 = move-exception
            r0 = r6
            r6 = r5
            r5 = r2
        L56:
            java.lang.Object r1 = r6.f5316a
            if (r1 != r5) goto L5d
        L5a:
            java.lang.Object r5 = r0.f5312a
            return r5
        L5d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: S2.z.f(S2.d, w2.d):java.lang.Object");
    }
}
