package R;

import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* renamed from: R.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0189n extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public int f1924a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ P f1925b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0189n(P p, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f1925b = p;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new C0189n(this.f1925b, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((C0189n) create((S2.e) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f1924a;
        if (i != 0) {
            if (i == 1) {
                AbstractC0228a.C(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0228a.C(obj);
            this.f1924a = 1;
            if (P.d(this.f1925b, this) == enumC0779a) {
                return enumC0779a;
            }
        }
        return C0684i.f6340a;
    }
}
