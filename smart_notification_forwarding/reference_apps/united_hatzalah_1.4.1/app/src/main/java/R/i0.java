package R;

import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class i0 extends AbstractC0793i implements F2.p {
    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new AbstractC0793i(2, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        i0 i0Var = (i0) create((S2.e) obj, (InterfaceC0763d) obj2);
        C0684i c0684i = C0684i.f6340a;
        i0Var.invokeSuspend(c0684i);
        return c0684i;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        AbstractC0228a.C(obj);
        return C0684i.f6340a;
    }
}
