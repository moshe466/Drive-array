package R;

import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* renamed from: R.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0192q extends AbstractC0793i implements F2.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1932a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f1933b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1934c;

    public /* synthetic */ C0192q(int i, InterfaceC0763d interfaceC0763d) {
        super(i, interfaceC0763d);
    }

    @Override // F2.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f1932a) {
            case 0:
                return new C0192q((P) this.f1934c, (InterfaceC0763d) obj3).invokeSuspend(C0684i.f6340a);
            default:
                ((Boolean) obj2).getClass();
                C0192q c0192q = new C0192q(3, (InterfaceC0763d) obj3);
                c0192q.f1934c = (S) obj;
                return c0192q.invokeSuspend(C0684i.f6340a);
        }
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1932a) {
            case 0:
                EnumC0779a enumC0779a = EnumC0779a.f6740a;
                int i = this.f1933b;
                if (i != 0) {
                    if (i == 1) {
                        AbstractC0228a.C(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    AbstractC0228a.C(obj);
                    P p = (P) this.f1934c;
                    this.f1933b = 1;
                    if (P.b(p, this) == enumC0779a) {
                        return enumC0779a;
                    }
                }
                return C0684i.f6340a;
            default:
                EnumC0779a enumC0779a2 = EnumC0779a.f6740a;
                int i3 = this.f1933b;
                if (i3 != 0) {
                    if (i3 == 1) {
                        AbstractC0228a.C(obj);
                        return obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC0228a.C(obj);
                S s3 = (S) this.f1934c;
                this.f1933b = 1;
                s3.getClass();
                Object a2 = S.a(s3, this);
                if (a2 == enumC0779a2) {
                    return enumC0779a2;
                }
                return a2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0192q(P p, InterfaceC0763d interfaceC0763d) {
        super(3, interfaceC0763d);
        this.f1934c = p;
    }
}
