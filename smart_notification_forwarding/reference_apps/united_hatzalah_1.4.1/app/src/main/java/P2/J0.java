package P2;

import w2.InterfaceC0766g;
import w2.InterfaceC0767h;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class J0 implements InterfaceC0766g, InterfaceC0767h {

    /* renamed from: a, reason: collision with root package name */
    public static final J0 f1619a = new Object();

    @Override // w2.InterfaceC0768i
    public final Object fold(Object obj, F2.p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0766g get(InterfaceC0767h interfaceC0767h) {
        return T.b.v(this, interfaceC0767h);
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0768i minusKey(InterfaceC0767h interfaceC0767h) {
        return T.b.D(this, interfaceC0767h);
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0768i plus(InterfaceC0768i interfaceC0768i) {
        return T.b.F(this, interfaceC0768i);
    }

    @Override // w2.InterfaceC0766g
    public final InterfaceC0767h getKey() {
        return this;
    }
}
