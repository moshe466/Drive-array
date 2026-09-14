package T2;

import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class c extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public int f2278a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2279b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f2280c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f2280c = dVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        c cVar = new c(this.f2280c, interfaceC0763d);
        cVar.f2279b = obj;
        return cVar;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((c) create((R2.p) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f2278a;
        if (i != 0) {
            if (i == 1) {
                AbstractC0228a.C(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0228a.C(obj);
            R2.p pVar = (R2.p) this.f2279b;
            this.f2278a = 1;
            if (this.f2280c.b(pVar, this) == enumC0779a) {
                return enumC0779a;
            }
        }
        return C0684i.f6340a;
    }
}
