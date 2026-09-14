package U;

import F2.p;
import R.InterfaceC0183h;
import w2.InterfaceC0763d;

/* loaded from: classes.dex */
public final class d implements InterfaceC0183h {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0183h f2313a;

    public d(InterfaceC0183h interfaceC0183h) {
        this.f2313a = interfaceC0183h;
    }

    @Override // R.InterfaceC0183h
    public final Object a(p pVar, InterfaceC0763d interfaceC0763d) {
        return this.f2313a.a(new c(pVar, null), interfaceC0763d);
    }

    @Override // R.InterfaceC0183h
    public final S2.d getData() {
        return this.f2313a.getData();
    }
}
