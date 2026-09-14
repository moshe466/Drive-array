package R;

import a.AbstractC0228a;
import s2.C0679d;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class C extends AbstractC0793i implements F2.l {

    /* renamed from: a, reason: collision with root package name */
    public Throwable f1746a;

    /* renamed from: b, reason: collision with root package name */
    public int f1747b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ P f1748c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(P p, InterfaceC0763d interfaceC0763d) {
        super(1, interfaceC0763d);
        this.f1748c = p;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(InterfaceC0763d interfaceC0763d) {
        return new C(this.f1748c, interfaceC0763d);
    }

    @Override // F2.l
    public final Object invoke(Object obj) {
        return ((C) create((InterfaceC0763d) obj)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        k0 k0Var;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f1747b;
        P p = this.f1748c;
        try {
        } catch (Throwable th2) {
            j0 g3 = p.g();
            this.f1746a = th2;
            this.f1747b = 2;
            Integer a2 = g3.a();
            if (a2 != enumC0779a) {
                th = th2;
                obj = a2;
            }
        }
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    th = this.f1746a;
                    AbstractC0228a.C(obj);
                    k0Var = new d0(th, ((Number) obj).intValue());
                    return new C0679d(k0Var, Boolean.TRUE);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC0228a.C(obj);
        } else {
            AbstractC0228a.C(obj);
            this.f1747b = 1;
            obj = P.f(p, true, this);
            if (obj == enumC0779a) {
                return enumC0779a;
            }
        }
        k0Var = (k0) obj;
        return new C0679d(k0Var, Boolean.TRUE);
    }
}
