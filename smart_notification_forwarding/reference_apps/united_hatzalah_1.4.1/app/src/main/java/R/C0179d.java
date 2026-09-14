package R;

import a.AbstractC0228a;
import java.util.List;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* renamed from: R.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0179d extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public int f1858a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1859b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f1860c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0179d(List list, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f1860c = list;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        C0179d c0179d = new C0179d(this.f1860c, interfaceC0763d);
        c0179d.f1859b = obj;
        return c0179d;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((C0179d) create((C0186k) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f1858a;
        if (i != 0) {
            if (i == 1) {
                AbstractC0228a.C(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0228a.C(obj);
            C0186k c0186k = (C0186k) this.f1859b;
            this.f1858a = 1;
            if (p3.h.b(this.f1860c, c0186k, this) == enumC0779a) {
                return enumC0779a;
            }
        }
        return C0684i.f6340a;
    }
}
