package T2;

import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class e extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public int f2284a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2285b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f2286c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f2286c = fVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        e eVar = new e(this.f2286c, interfaceC0763d);
        eVar.f2285b = obj;
        return eVar;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((e) create((S2.e) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f2284a;
        C0684i c0684i = C0684i.f6340a;
        if (i != 0) {
            if (i == 1) {
                AbstractC0228a.C(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0228a.C(obj);
            S2.e eVar = (S2.e) this.f2285b;
            this.f2284a = 1;
            Object collect = this.f2286c.f2287d.collect(eVar, this);
            if (collect != enumC0779a) {
                collect = c0684i;
            }
            if (collect == enumC0779a) {
                return enumC0779a;
            }
        }
        return c0684i;
    }
}
