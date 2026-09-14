package R;

import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* renamed from: R.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0181f extends AbstractC0793i implements F2.l {

    /* renamed from: a, reason: collision with root package name */
    public int f1871a;

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(InterfaceC0763d interfaceC0763d) {
        return new AbstractC0793i(1, interfaceC0763d);
    }

    @Override // F2.l
    public final Object invoke(Object obj) {
        C0181f c0181f = (C0181f) create((InterfaceC0763d) obj);
        C0684i c0684i = C0684i.f6340a;
        c0181f.invokeSuspend(c0684i);
        return c0684i;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f1871a;
        if (i != 0) {
            if (i == 1) {
                AbstractC0228a.C(obj);
                return C0684i.f6340a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC0228a.C(obj);
        this.f1871a = 1;
        throw null;
    }
}
