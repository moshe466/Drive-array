package U2;

import P2.AbstractC0140a;
import P2.G;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import y2.InterfaceC0788d;

/* loaded from: classes.dex */
public class r extends AbstractC0140a implements InterfaceC0788d {

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0763d f2374d;

    public r(InterfaceC0763d interfaceC0763d, InterfaceC0768i interfaceC0768i) {
        super(interfaceC0768i, true);
        this.f2374d = interfaceC0763d;
    }

    @Override // P2.w0
    public final boolean C() {
        return true;
    }

    @Override // y2.InterfaceC0788d
    public final InterfaceC0788d getCallerFrame() {
        InterfaceC0763d interfaceC0763d = this.f2374d;
        if (interfaceC0763d instanceof InterfaceC0788d) {
            return (InterfaceC0788d) interfaceC0763d;
        }
        return null;
    }

    @Override // P2.w0
    public void h(Object obj) {
        a.g(G.t(obj), m3.b.z(this.f2374d));
    }

    @Override // P2.w0
    public void i(Object obj) {
        this.f2374d.resumeWith(G.t(obj));
    }
}
