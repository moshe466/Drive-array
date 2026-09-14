package T2;

import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class r extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public int f2304a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2305b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ S2.e f2306c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(S2.e eVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f2306c = eVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        r rVar = new r(this.f2306c, interfaceC0763d);
        rVar.f2305b = obj;
        return rVar;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((r) create(obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f2304a;
        if (i != 0) {
            if (i == 1) {
                AbstractC0228a.C(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0228a.C(obj);
            Object obj2 = this.f2305b;
            this.f2304a = 1;
            if (this.f2306c.emit(obj2, this) == enumC0779a) {
                return enumC0779a;
            }
        }
        return C0684i.f6340a;
    }
}
