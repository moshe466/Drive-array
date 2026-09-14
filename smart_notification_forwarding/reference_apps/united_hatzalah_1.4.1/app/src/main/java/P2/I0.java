package P2;

import s2.C0679d;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class I0 extends U2.r {

    /* renamed from: e, reason: collision with root package name */
    public final ThreadLocal f1618e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public I0(w2.InterfaceC0763d r3, w2.InterfaceC0768i r4) {
        /*
            r2 = this;
            P2.J0 r0 = P2.J0.f1619a
            w2.g r1 = r4.get(r0)
            if (r1 != 0) goto Ld
            w2.i r0 = r4.plus(r0)
            goto Le
        Ld:
            r0 = r4
        Le:
            r2.<init>(r3, r0)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f1618e = r0
            w2.i r3 = r3.getContext()
            w2.e r0 = w2.C0764e.f6732a
            w2.g r3 = r3.get(r0)
            boolean r3 = r3 instanceof P2.A
            if (r3 != 0) goto L31
            r3 = 0
            java.lang.Object r3 = U2.a.l(r4, r3)
            U2.a.f(r4, r3)
            r2.T(r4, r3)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: P2.I0.<init>(w2.d, w2.i):void");
    }

    public final boolean S() {
        boolean z3;
        if (this.threadLocalIsSet && this.f1618e.get() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f1618e.remove();
        return !z3;
    }

    public final void T(InterfaceC0768i interfaceC0768i, Object obj) {
        this.threadLocalIsSet = true;
        this.f1618e.set(new C0679d(interfaceC0768i, obj));
    }

    @Override // U2.r, P2.w0
    public final void i(Object obj) {
        if (this.threadLocalIsSet) {
            C0679d c0679d = (C0679d) this.f1618e.get();
            if (c0679d != null) {
                U2.a.f((InterfaceC0768i) c0679d.f6332a, c0679d.f6333b);
            }
            this.f1618e.remove();
        }
        Object t3 = G.t(obj);
        InterfaceC0763d interfaceC0763d = this.f2374d;
        InterfaceC0768i context = interfaceC0763d.getContext();
        I0 i02 = null;
        Object l3 = U2.a.l(context, null);
        if (l3 != U2.a.f2342f) {
            i02 = G.y(interfaceC0763d, context, l3);
        }
        try {
            this.f2374d.resumeWith(t3);
            if (i02 != null && !i02.S()) {
                return;
            }
            U2.a.f(context, l3);
        } catch (Throwable th) {
            if (i02 == null || i02.S()) {
                U2.a.f(context, l3);
            }
            throw th;
        }
    }
}
