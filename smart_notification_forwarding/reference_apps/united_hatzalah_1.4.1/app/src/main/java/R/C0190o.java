package R;

import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* renamed from: R.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0190o extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f1927a;

    /* JADX WARN: Type inference failed for: r0v0, types: [R.o, y2.i, w2.d] */
    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        ?? abstractC0793i = new AbstractC0793i(2, interfaceC0763d);
        abstractC0793i.f1927a = obj;
        return abstractC0793i;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((C0190o) create((k0) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        AbstractC0228a.C(obj);
        return Boolean.valueOf(!(((k0) this.f1927a) instanceof b0));
    }
}
