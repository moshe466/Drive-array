package T2;

import P2.C0173x;
import P2.G;
import s2.C0684i;
import w2.C0764e;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import x2.EnumC0779a;

/* loaded from: classes.dex */
public final class f extends d {

    /* renamed from: d, reason: collision with root package name */
    public final S2.d f2287d;

    public f(S2.d dVar, InterfaceC0768i interfaceC0768i, int i, R2.a aVar) {
        super(interfaceC0768i, i, aVar);
        this.f2287d = dVar;
    }

    @Override // T2.d
    public final Object b(R2.p pVar, InterfaceC0763d interfaceC0763d) {
        Object collect = this.f2287d.collect(new p(pVar), interfaceC0763d);
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        C0684i c0684i = C0684i.f6340a;
        if (collect != enumC0779a) {
            collect = c0684i;
        }
        if (collect == enumC0779a) {
            return collect;
        }
        return c0684i;
    }

    @Override // T2.d
    public final d c(InterfaceC0768i interfaceC0768i, int i, R2.a aVar) {
        return new f(this.f2287d, interfaceC0768i, i, aVar);
    }

    @Override // T2.d, S2.d
    public final Object collect(S2.e eVar, InterfaceC0763d interfaceC0763d) {
        InterfaceC0768i j2;
        int i = this.f2282b;
        C0684i c0684i = C0684i.f6340a;
        if (i == -3) {
            InterfaceC0768i context = interfaceC0763d.getContext();
            Boolean bool = Boolean.FALSE;
            C0173x c0173x = C0173x.f1712c;
            InterfaceC0768i interfaceC0768i = this.f2281a;
            if (!((Boolean) interfaceC0768i.fold(bool, c0173x)).booleanValue()) {
                j2 = context.plus(interfaceC0768i);
            } else {
                j2 = G.j(context, interfaceC0768i, false);
            }
            if (kotlin.jvm.internal.j.a(j2, context)) {
                Object collect = this.f2287d.collect(eVar, interfaceC0763d);
                EnumC0779a enumC0779a = EnumC0779a.f6740a;
                if (collect != enumC0779a) {
                    collect = c0684i;
                }
                if (collect == enumC0779a) {
                    return collect;
                }
            } else {
                C0764e c0764e = C0764e.f6732a;
                if (kotlin.jvm.internal.j.a(j2.get(c0764e), context.get(c0764e))) {
                    InterfaceC0768i context2 = interfaceC0763d.getContext();
                    if (!(eVar instanceof p)) {
                        eVar = new S2.q(eVar, context2);
                    }
                    Object b4 = j.b(j2, eVar, U2.a.k(j2), new e(this, null), interfaceC0763d);
                    if (b4 == EnumC0779a.f6740a) {
                        return b4;
                    }
                }
            }
            return c0684i;
        }
        Object collect2 = super.collect(eVar, interfaceC0763d);
        if (collect2 == EnumC0779a.f6740a) {
            return collect2;
        }
        return c0684i;
    }

    @Override // T2.d
    public final String toString() {
        return this.f2287d + " -> " + super.toString();
    }
}
