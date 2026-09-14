package Y2;

import F0.G1;
import F2.l;
import P2.C0163m;
import P2.InterfaceC0162l;
import P2.K0;
import U2.s;
import s2.C0684i;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class c implements InterfaceC0162l, K0 {

    /* renamed from: a, reason: collision with root package name */
    public final C0163m f2709a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f2710b;

    public c(d dVar, C0163m c0163m) {
        this.f2710b = dVar;
        this.f2709a = c0163m;
    }

    @Override // P2.K0
    public final void b(s sVar, int i) {
        this.f2709a.b(sVar, i);
    }

    @Override // P2.InterfaceC0162l
    public final G1 e(Object obj, l lVar) {
        d dVar = this.f2710b;
        b bVar = new b(dVar, this, 1);
        G1 C3 = this.f2709a.C((C0684i) obj, bVar);
        if (C3 != null) {
            d.f2711g.set(dVar, null);
        }
        return C3;
    }

    @Override // P2.InterfaceC0162l
    public final void f(Object obj) {
        this.f2709a.f(obj);
    }

    @Override // w2.InterfaceC0763d
    public final InterfaceC0768i getContext() {
        return this.f2709a.f1674e;
    }

    @Override // w2.InterfaceC0763d
    public final void resumeWith(Object obj) {
        this.f2709a.resumeWith(obj);
    }
}
