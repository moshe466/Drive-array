package R;

import w2.InterfaceC0766g;
import w2.InterfaceC0767h;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class o0 implements InterfaceC0766g {

    /* renamed from: a, reason: collision with root package name */
    public final o0 f1928a;

    /* renamed from: b, reason: collision with root package name */
    public final P f1929b;

    public o0(o0 o0Var, P p) {
        this.f1928a = o0Var;
        this.f1929b = p;
    }

    public final void a(P p) {
        if (this.f1929b != p) {
            o0 o0Var = this.f1928a;
            if (o0Var != null) {
                o0Var.a(p);
                return;
            }
            return;
        }
        throw new IllegalStateException("Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.");
    }

    @Override // w2.InterfaceC0768i
    public final Object fold(Object obj, F2.p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0766g get(InterfaceC0767h interfaceC0767h) {
        return T.b.v(this, interfaceC0767h);
    }

    @Override // w2.InterfaceC0766g
    public final InterfaceC0767h getKey() {
        return n0.f1926a;
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0768i minusKey(InterfaceC0767h interfaceC0767h) {
        return T.b.D(this, interfaceC0767h);
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0768i plus(InterfaceC0768i interfaceC0768i) {
        return T.b.F(this, interfaceC0768i);
    }
}
