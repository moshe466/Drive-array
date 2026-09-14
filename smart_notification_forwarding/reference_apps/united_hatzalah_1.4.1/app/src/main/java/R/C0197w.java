package R;

import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* renamed from: R.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0197w extends AbstractC0793i implements F2.l {

    /* renamed from: a, reason: collision with root package name */
    public int f1951a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ G f1952b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0197w(G g3, InterfaceC0763d interfaceC0763d) {
        super(1, interfaceC0763d);
        this.f1952b = g3;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(InterfaceC0763d interfaceC0763d) {
        return new C0197w(this.f1952b, interfaceC0763d);
    }

    @Override // F2.l
    public final Object invoke(Object obj) {
        return ((C0197w) create((InterfaceC0763d) obj)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f1951a;
        if (i != 0) {
            if (i == 1) {
                AbstractC0228a.C(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC0228a.C(obj);
        this.f1951a = 1;
        Object invoke = this.f1952b.invoke(this);
        if (invoke == enumC0779a) {
            return enumC0779a;
        }
        return invoke;
    }
}
