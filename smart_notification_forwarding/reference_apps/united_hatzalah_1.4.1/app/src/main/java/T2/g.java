package T2;

import w2.InterfaceC0766g;
import w2.InterfaceC0767h;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class g implements InterfaceC0768i {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f2288a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0768i f2289b;

    public g(Throwable th, InterfaceC0768i interfaceC0768i) {
        this.f2288a = th;
        this.f2289b = interfaceC0768i;
    }

    @Override // w2.InterfaceC0768i
    public final Object fold(Object obj, F2.p pVar) {
        return this.f2289b.fold(obj, pVar);
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0766g get(InterfaceC0767h interfaceC0767h) {
        return this.f2289b.get(interfaceC0767h);
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0768i minusKey(InterfaceC0767h interfaceC0767h) {
        return this.f2289b.minusKey(interfaceC0767h);
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0768i plus(InterfaceC0768i interfaceC0768i) {
        return this.f2289b.plus(interfaceC0768i);
    }
}
