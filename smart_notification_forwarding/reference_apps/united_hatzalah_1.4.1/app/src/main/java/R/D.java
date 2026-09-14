package R;

import a.AbstractC0228a;
import s2.C0679d;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class D extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public Throwable f1749a;

    /* renamed from: b, reason: collision with root package name */
    public int f1750b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ boolean f1751c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ P f1752d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f1753e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(P p, int i, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f1752d = p;
        this.f1753e = i;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        D d2 = new D(this.f1752d, this.f1753e, interfaceC0763d);
        d2.f1751c = ((Boolean) obj).booleanValue();
        return d2;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        return ((D) create(bool, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        int i;
        boolean z3;
        k0 k0Var;
        boolean z4;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        boolean z5 = this.f1750b;
        P p = this.f1752d;
        try {
        } catch (Throwable th2) {
            if (z5 != 0) {
                j0 g3 = p.g();
                this.f1749a = th2;
                this.f1751c = z5;
                this.f1750b = 2;
                Integer a2 = g3.a();
                if (a2 != enumC0779a) {
                    z3 = z5;
                    th = th2;
                    obj = a2;
                }
            } else {
                boolean z6 = z5;
                th = th2;
                i = this.f1753e;
                z3 = z6;
            }
        }
        if (z5 != 0) {
            if (z5 != 1) {
                if (z5 == 2) {
                    z3 = this.f1751c;
                    th = this.f1749a;
                    AbstractC0228a.C(obj);
                    i = ((Number) obj).intValue();
                    d0 d0Var = new d0(th, i);
                    z4 = z3;
                    k0Var = d0Var;
                    return new C0679d(k0Var, Boolean.valueOf(z4));
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z7 = this.f1751c;
            AbstractC0228a.C(obj);
            z5 = z7;
        } else {
            AbstractC0228a.C(obj);
            boolean z8 = this.f1751c;
            this.f1751c = z8;
            this.f1750b = 1;
            obj = P.f(p, z8, this);
            z5 = z8;
            if (obj == enumC0779a) {
                return enumC0779a;
            }
        }
        k0Var = (k0) obj;
        z4 = z5;
        return new C0679d(k0Var, Boolean.valueOf(z4));
    }
}
