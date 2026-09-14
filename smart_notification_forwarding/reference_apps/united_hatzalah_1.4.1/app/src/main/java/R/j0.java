package R;

import F0.C0047j2;
import java.util.concurrent.atomic.AtomicInteger;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public final Y2.d f1903a = Y2.e.a();

    /* renamed from: b, reason: collision with root package name */
    public final C0047j2 f1904b = new C0047j2(6);

    /* renamed from: c, reason: collision with root package name */
    public final C0194t f1905c = new C0194t((F2.p) new AbstractC0793i(2, null));

    /* JADX WARN: Type inference failed for: r3v3, types: [y2.i, F2.p] */
    public j0(String str) {
    }

    public final Integer a() {
        return new Integer(((AtomicInteger) this.f1904b.f546b).get());
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0054, code lost:
    
        if (r9.d(r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(F2.l r8, y2.AbstractC0787c r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof R.g0
            if (r0 == 0) goto L13
            r0 = r9
            R.g0 r0 = (R.g0) r0
            int r1 = r0.f1885e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1885e = r1
            goto L18
        L13:
            R.g0 r0 = new R.g0
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f1883c
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f1885e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L45
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r8 = r0.f1881a
            Y2.a r8 = (Y2.a) r8
            a.AbstractC0228a.C(r9)     // Catch: java.lang.Throwable -> L2f
            goto L67
        L2f:
            r9 = move-exception
            goto L71
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            Y2.d r8 = r0.f1882b
            java.lang.Object r2 = r0.f1881a
            F2.l r2 = (F2.l) r2
            a.AbstractC0228a.C(r9)
            r9 = r8
            r8 = r2
            goto L57
        L45:
            a.AbstractC0228a.C(r9)
            r0.f1881a = r8
            Y2.d r9 = r7.f1903a
            r0.f1882b = r9
            r0.f1885e = r4
            java.lang.Object r2 = r9.d(r0)
            if (r2 != r1) goto L57
            goto L63
        L57:
            r0.f1881a = r9     // Catch: java.lang.Throwable -> L6d
            r0.f1882b = r5     // Catch: java.lang.Throwable -> L6d
            r0.f1885e = r3     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r8 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L6d
            if (r8 != r1) goto L64
        L63:
            return r1
        L64:
            r6 = r9
            r9 = r8
            r8 = r6
        L67:
            Y2.d r8 = (Y2.d) r8
            r8.f(r5)
            return r9
        L6d:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L71:
            Y2.d r8 = (Y2.d) r8
            r8.f(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: R.j0.b(F2.l, y2.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(F2.p r7, y2.AbstractC0787c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof R.h0
            if (r0 == 0) goto L13
            r0 = r8
            R.h0 r0 = (R.h0) r0
            int r1 = r0.f1890e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1890e = r1
            goto L18
        L13:
            R.h0 r0 = new R.h0
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f1888c
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f1890e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            boolean r7 = r0.f1887b
            Y2.d r0 = r0.f1886a
            a.AbstractC0228a.C(r8)     // Catch: java.lang.Throwable -> L2c
            goto L53
        L2c:
            r8 = move-exception
            goto L5d
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            a.AbstractC0228a.C(r8)
            Y2.d r8 = r6.f1903a
            boolean r2 = r8.e()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L59
            r0.f1886a = r8     // Catch: java.lang.Throwable -> L59
            r0.f1887b = r2     // Catch: java.lang.Throwable -> L59
            r0.f1890e = r3     // Catch: java.lang.Throwable -> L59
            java.lang.Object r7 = r7.invoke(r5, r0)     // Catch: java.lang.Throwable -> L59
            if (r7 != r1) goto L50
            return r1
        L50:
            r0 = r8
            r8 = r7
            r7 = r2
        L53:
            if (r7 == 0) goto L58
            r0.f(r4)
        L58:
            return r8
        L59:
            r7 = move-exception
            r0 = r8
            r8 = r7
            r7 = r2
        L5d:
            if (r7 == 0) goto L62
            r0.f(r4)
        L62:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: R.j0.c(F2.p, y2.c):java.lang.Object");
    }
}
