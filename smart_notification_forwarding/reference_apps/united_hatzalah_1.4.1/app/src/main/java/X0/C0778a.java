package x0;

import F2.p;
import P2.E;
import R.C0193s;
import S2.d;
import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* renamed from: x0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0778a extends AbstractC0793i implements p {

    /* renamed from: a, reason: collision with root package name */
    public int f6737a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f6738b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ I.a f6739c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0778a(d dVar, I.a aVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f6738b = dVar;
        this.f6739c = aVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new C0778a(this.f6738b, this.f6739c, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((C0778a) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f6737a;
        if (i != 0) {
            if (i == 1) {
                AbstractC0228a.C(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0228a.C(obj);
            C0193s c0193s = new C0193s(this.f6739c, 2);
            this.f6737a = 1;
            if (this.f6738b.collect(c0193s, this) == enumC0779a) {
                return enumC0779a;
            }
        }
        return C0684i.f6340a;
    }
}
