package P2;

import w2.InterfaceC0763d;

/* loaded from: classes.dex */
public final class n0 extends C0163m {

    /* renamed from: l, reason: collision with root package name */
    public final w0 f1677l;

    public n0(w0 w0Var, InterfaceC0763d interfaceC0763d) {
        super(1, interfaceC0763d);
        this.f1677l = w0Var;
    }

    @Override // P2.C0163m
    public final Throwable p(w0 w0Var) {
        Throwable b4;
        Object x3 = this.f1677l.x();
        if ((x3 instanceof p0) && (b4 = ((p0) x3).b()) != null) {
            return b4;
        }
        if (x3 instanceof C0171v) {
            return ((C0171v) x3).f1707a;
        }
        return w0Var.getCancellationException();
    }

    @Override // P2.C0163m
    public final String w() {
        return "AwaitContinuation";
    }
}
