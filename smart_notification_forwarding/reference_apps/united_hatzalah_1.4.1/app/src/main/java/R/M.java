package R;

import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class M extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public int f1789a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1790b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ P f1791c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(P p, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f1791c = p;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        M m4 = new M(this.f1791c, interfaceC0763d);
        m4.f1790b = obj;
        return m4;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((M) create((c0) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f1789a;
        if (i != 0) {
            if (i == 1) {
                AbstractC0228a.C(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0228a.C(obj);
            c0 c0Var = (c0) this.f1790b;
            this.f1789a = 1;
            if (P.c(this.f1791c, c0Var, this) == enumC0779a) {
                return enumC0779a;
            }
        }
        return C0684i.f6340a;
    }
}
