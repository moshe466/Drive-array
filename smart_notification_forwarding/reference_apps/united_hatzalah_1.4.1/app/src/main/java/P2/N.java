package P2;

import java.util.concurrent.CancellationException;
import w2.InterfaceC0763d;

/* loaded from: classes.dex */
public abstract class N extends W2.i {

    /* renamed from: c, reason: collision with root package name */
    public int f1621c;

    public N(int i) {
        super(0L, W2.l.f2546g);
        this.f1621c = i;
    }

    public abstract void a(Object obj, CancellationException cancellationException);

    public abstract InterfaceC0763d c();

    public Throwable d(Object obj) {
        C0171v c0171v;
        if (obj instanceof C0171v) {
            c0171v = (C0171v) obj;
        } else {
            c0171v = null;
        }
        if (c0171v == null) {
            return null;
        }
        return c0171v.f1707a;
    }

    public final void h(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            E1.b.b(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.j.b(th);
        G.n(new Error("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th), c().getContext());
    }

    public abstract Object i();

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
    
        r7 = (P2.InterfaceC0157i0) r7.get(P2.B.f1595b);
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r13 = this;
            s2.i r0 = s2.C0684i.f6340a
            W2.j r1 = r13.f2537b
            w2.d r2 = r13.c()     // Catch: java.lang.Throwable -> L25
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>"
            kotlin.jvm.internal.j.c(r2, r3)     // Catch: java.lang.Throwable -> L25
            U2.g r2 = (U2.g) r2     // Catch: java.lang.Throwable -> L25
            y2.c r3 = r2.f2351e     // Catch: java.lang.Throwable -> L25
            java.lang.Object r2 = r2.f2353j     // Catch: java.lang.Throwable -> L25
            w2.i r4 = r3.getContext()     // Catch: java.lang.Throwable -> L25
            java.lang.Object r2 = U2.a.l(r4, r2)     // Catch: java.lang.Throwable -> L25
            F0.G1 r5 = U2.a.f2342f     // Catch: java.lang.Throwable -> L25
            r6 = 0
            if (r2 == r5) goto L28
            P2.I0 r5 = P2.G.y(r3, r4, r2)     // Catch: java.lang.Throwable -> L25
            goto L29
        L25:
            r2 = move-exception
            goto L9f
        L28:
            r5 = r6
        L29:
            w2.i r7 = r3.getContext()     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r8 = r13.i()     // Catch: java.lang.Throwable -> L4c
            java.lang.Throwable r9 = r13.d(r8)     // Catch: java.lang.Throwable -> L4c
            if (r9 != 0) goto L4e
            int r10 = r13.f1621c     // Catch: java.lang.Throwable -> L4c
            r11 = 1
            if (r10 == r11) goto L41
            r12 = 2
            if (r10 != r12) goto L40
            goto L41
        L40:
            r11 = 0
        L41:
            if (r11 == 0) goto L4e
            P2.B r10 = P2.B.f1595b     // Catch: java.lang.Throwable -> L4c
            w2.g r7 = r7.get(r10)     // Catch: java.lang.Throwable -> L4c
            P2.i0 r7 = (P2.InterfaceC0157i0) r7     // Catch: java.lang.Throwable -> L4c
            goto L4f
        L4c:
            r3 = move-exception
            goto L93
        L4e:
            r7 = r6
        L4f:
            if (r7 == 0) goto L66
            boolean r10 = r7.isActive()     // Catch: java.lang.Throwable -> L4c
            if (r10 != 0) goto L66
            java.util.concurrent.CancellationException r7 = r7.getCancellationException()     // Catch: java.lang.Throwable -> L4c
            r13.a(r8, r7)     // Catch: java.lang.Throwable -> L4c
            s2.e r7 = a.AbstractC0228a.g(r7)     // Catch: java.lang.Throwable -> L4c
            r3.resumeWith(r7)     // Catch: java.lang.Throwable -> L4c
            goto L77
        L66:
            if (r9 == 0) goto L70
            s2.e r7 = a.AbstractC0228a.g(r9)     // Catch: java.lang.Throwable -> L4c
            r3.resumeWith(r7)     // Catch: java.lang.Throwable -> L4c
            goto L77
        L70:
            java.lang.Object r7 = r13.g(r8)     // Catch: java.lang.Throwable -> L4c
            r3.resumeWith(r7)     // Catch: java.lang.Throwable -> L4c
        L77:
            if (r5 == 0) goto L7f
            boolean r3 = r5.S()     // Catch: java.lang.Throwable -> L25
            if (r3 == 0) goto L82
        L7f:
            U2.a.f(r4, r2)     // Catch: java.lang.Throwable -> L25
        L82:
            r1.getClass()     // Catch: java.lang.Throwable -> L86
            goto L8b
        L86:
            r0 = move-exception
            s2.e r0 = a.AbstractC0228a.g(r0)
        L8b:
            java.lang.Throwable r0 = s2.C0681f.a(r0)
            r13.h(r6, r0)
            goto Laf
        L93:
            if (r5 == 0) goto L9b
            boolean r5 = r5.S()     // Catch: java.lang.Throwable -> L25
            if (r5 == 0) goto L9e
        L9b:
            U2.a.f(r4, r2)     // Catch: java.lang.Throwable -> L25
        L9e:
            throw r3     // Catch: java.lang.Throwable -> L25
        L9f:
            r1.getClass()     // Catch: java.lang.Throwable -> La3
            goto La8
        La3:
            r0 = move-exception
            s2.e r0 = a.AbstractC0228a.g(r0)
        La8:
            java.lang.Throwable r0 = s2.C0681f.a(r0)
            r13.h(r2, r0)
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: P2.N.run():void");
    }

    public Object g(Object obj) {
        return obj;
    }
}
