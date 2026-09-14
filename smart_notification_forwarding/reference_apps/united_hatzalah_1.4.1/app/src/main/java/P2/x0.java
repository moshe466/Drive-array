package P2;

import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class x0 extends C0 {

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0763d f1714d;

    public x0(InterfaceC0768i interfaceC0768i, F2.p pVar) {
        super(interfaceC0768i, false);
        this.f1714d = m3.b.k(pVar, this, this);
    }

    @Override // P2.w0
    public final void J() {
        try {
            U2.a.g(C0684i.f6340a, m3.b.z(this.f1714d));
        } catch (Throwable th) {
            resumeWith(AbstractC0228a.g(th));
            throw th;
        }
    }
}
