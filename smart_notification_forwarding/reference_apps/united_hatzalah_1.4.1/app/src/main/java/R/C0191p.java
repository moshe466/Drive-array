package R;

import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* renamed from: R.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0191p extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f1930a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k0 f1931b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0191p(k0 k0Var, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f1931b = k0Var;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        C0191p c0191p = new C0191p(this.f1931b, interfaceC0763d);
        c0191p.f1930a = obj;
        return c0191p;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((C0191p) create((k0) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        boolean z3;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        AbstractC0228a.C(obj);
        k0 k0Var = (k0) this.f1930a;
        if ((k0Var instanceof C0178c) && k0Var.f1910a <= this.f1931b.f1910a) {
            z3 = true;
        } else {
            z3 = false;
        }
        return Boolean.valueOf(z3);
    }
}
