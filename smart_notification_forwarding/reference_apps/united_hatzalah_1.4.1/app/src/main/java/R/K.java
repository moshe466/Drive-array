package R;

import F0.C0047j2;
import P2.C0169t;
import a.AbstractC0228a;
import java.util.concurrent.atomic.AtomicInteger;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class K extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public int f1783a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1784b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ P f1785c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractC0793i f1786d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public K(P p, F2.p pVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f1785c = p;
        this.f1786d = (AbstractC0793i) pVar;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [y2.i, F2.p] */
    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        K k4 = new K(this.f1785c, this.f1786d, interfaceC0763d);
        k4.f1784b = obj;
        return k4;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((K) create((P2.E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [y2.i, F2.p] */
    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f1783a;
        if (i != 0) {
            if (i == 1) {
                AbstractC0228a.C(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC0228a.C(obj);
        P2.E e4 = (P2.E) this.f1784b;
        C0169t a2 = P2.G.a();
        P p = this.f1785c;
        c0 c0Var = new c0(this.f1786d, a2, p.f1810h.l(), e4.a());
        K1.m mVar = p.f1813l;
        Object b4 = ((R2.c) mVar.f1104c).b(c0Var);
        Throwable th = null;
        if (b4 instanceof R2.h) {
            R2.h hVar = (R2.h) b4;
            if (hVar == null) {
                hVar = null;
            }
            if (hVar != null) {
                th = hVar.f2056a;
            }
            if (th == null) {
                throw new IllegalStateException("Channel was closed normally");
            }
            throw th;
        }
        if (!(b4 instanceof R2.i)) {
            if (((AtomicInteger) ((C0047j2) mVar.f1105d).f546b).getAndIncrement() == 0) {
                P2.G.r((P2.E) mVar.f1102a, null, new f0(mVar, null), 3);
            }
            this.f1783a = 1;
            Object j2 = a2.j(this);
            if (j2 == enumC0779a) {
                return enumC0779a;
            }
            return j2;
        }
        throw new IllegalStateException("Check failed.");
    }
}
