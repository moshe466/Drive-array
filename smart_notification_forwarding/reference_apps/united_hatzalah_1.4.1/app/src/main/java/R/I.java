package R;

import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class I extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public int f1775a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC0793i f1776b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0178c f1777c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public I(F2.p pVar, C0178c c0178c, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f1776b = (AbstractC0793i) pVar;
        this.f1777c = c0178c;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [y2.i, F2.p] */
    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new I(this.f1776b, this.f1777c, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((I) create((P2.E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [y2.i, F2.p] */
    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f1775a;
        if (i != 0) {
            if (i == 1) {
                AbstractC0228a.C(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC0228a.C(obj);
        Object obj2 = this.f1777c.f1852b;
        this.f1775a = 1;
        Object invoke = this.f1776b.invoke(obj2, this);
        if (invoke == enumC0779a) {
            return enumC0779a;
        }
        return invoke;
    }
}
