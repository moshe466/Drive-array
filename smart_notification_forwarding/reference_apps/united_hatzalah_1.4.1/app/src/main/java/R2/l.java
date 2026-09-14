package R2;

import P2.E;
import a.AbstractC0228a;
import s2.C0680e;
import s2.C0681f;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class l extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public int f2061a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2062b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f2063c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2064d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(r rVar, Object obj, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f2063c = rVar;
        this.f2064d = obj;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        l lVar = new l(this.f2063c, this.f2064d, interfaceC0763d);
        lVar.f2062b = obj;
        return lVar;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((l) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Object g3;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f2061a;
        Object obj2 = C0684i.f6340a;
        try {
            if (i != 0) {
                if (i == 1) {
                    AbstractC0228a.C(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                AbstractC0228a.C(obj);
                r rVar = this.f2063c;
                Object obj3 = this.f2064d;
                this.f2061a = 1;
                if (rVar.d(obj3, this) == enumC0779a) {
                    return enumC0779a;
                }
            }
            g3 = obj2;
        } catch (Throwable th) {
            g3 = AbstractC0228a.g(th);
        }
        if (g3 instanceof C0680e) {
            obj2 = new h(C0681f.a(g3));
        }
        return new j(obj2);
    }
}
