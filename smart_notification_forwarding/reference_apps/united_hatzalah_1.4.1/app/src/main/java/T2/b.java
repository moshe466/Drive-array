package T2;

import P2.E;
import P2.F;
import P2.G;
import S2.z;
import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class b extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public int f2274a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2275b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ S2.e f2276c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f2277d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(S2.e eVar, d dVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f2276c = eVar;
        this.f2277d = dVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        b bVar = new b(this.f2276c, this.f2277d, interfaceC0763d);
        bVar.f2275b = obj;
        return bVar;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((b) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f2274a;
        C0684i c0684i = C0684i.f6340a;
        if (i != 0) {
            if (i == 1) {
                AbstractC0228a.C(obj);
                return c0684i;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC0228a.C(obj);
        E e4 = (E) this.f2275b;
        d dVar = this.f2277d;
        InterfaceC0768i interfaceC0768i = dVar.f2281a;
        int i3 = dVar.f2282b;
        if (i3 == -3) {
            i3 = -2;
        }
        R2.a aVar = dVar.f2283c;
        F f4 = F.f1600c;
        F2.p cVar = new c(dVar, null);
        R2.o oVar = new R2.o(G.s(e4, interfaceC0768i), E1.b.a(i3, aVar, 4));
        oVar.R(f4, oVar, cVar);
        this.f2274a = 1;
        Object d2 = z.d(this.f2276c, oVar, true, this);
        if (d2 != enumC0779a) {
            d2 = c0684i;
        }
        if (d2 == enumC0779a) {
            return enumC0779a;
        }
        return c0684i;
    }
}
