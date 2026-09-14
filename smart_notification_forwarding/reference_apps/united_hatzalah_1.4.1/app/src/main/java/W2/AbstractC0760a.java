package w2;

import F2.p;

/* renamed from: w2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0760a implements InterfaceC0766g {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0767h f6728a;

    public AbstractC0760a(InterfaceC0767h interfaceC0767h) {
        this.f6728a = interfaceC0767h;
    }

    @Override // w2.InterfaceC0768i
    public final Object fold(Object obj, p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // w2.InterfaceC0768i
    public /* bridge */ InterfaceC0766g get(InterfaceC0767h interfaceC0767h) {
        return T.b.v(this, interfaceC0767h);
    }

    @Override // w2.InterfaceC0766g
    public final InterfaceC0767h getKey() {
        return this.f6728a;
    }

    @Override // w2.InterfaceC0768i
    public /* bridge */ InterfaceC0768i minusKey(InterfaceC0767h interfaceC0767h) {
        return T.b.D(this, interfaceC0767h);
    }

    @Override // w2.InterfaceC0768i
    public final /* bridge */ InterfaceC0768i plus(InterfaceC0768i interfaceC0768i) {
        return T.b.F(this, interfaceC0768i);
    }
}
