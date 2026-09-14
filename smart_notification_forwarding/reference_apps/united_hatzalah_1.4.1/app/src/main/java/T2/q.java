package T2;

import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import y2.InterfaceC0788d;

/* loaded from: classes.dex */
public final class q implements InterfaceC0763d, InterfaceC0788d {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0763d f2302a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0768i f2303b;

    public q(InterfaceC0763d interfaceC0763d, InterfaceC0768i interfaceC0768i) {
        this.f2302a = interfaceC0763d;
        this.f2303b = interfaceC0768i;
    }

    @Override // y2.InterfaceC0788d
    public final InterfaceC0788d getCallerFrame() {
        InterfaceC0763d interfaceC0763d = this.f2302a;
        if (interfaceC0763d instanceof InterfaceC0788d) {
            return (InterfaceC0788d) interfaceC0763d;
        }
        return null;
    }

    @Override // w2.InterfaceC0763d
    public final InterfaceC0768i getContext() {
        return this.f2303b;
    }

    @Override // w2.InterfaceC0763d
    public final void resumeWith(Object obj) {
        this.f2302a.resumeWith(obj);
    }
}
