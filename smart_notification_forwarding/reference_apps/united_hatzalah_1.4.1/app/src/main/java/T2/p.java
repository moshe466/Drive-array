package T2;

import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;

/* loaded from: classes.dex */
public final class p implements S2.e {

    /* renamed from: a, reason: collision with root package name */
    public final R2.r f2301a;

    public p(R2.p pVar) {
        this.f2301a = pVar;
    }

    @Override // S2.e
    public final Object emit(Object obj, InterfaceC0763d interfaceC0763d) {
        Object d2 = this.f2301a.d(obj, interfaceC0763d);
        if (d2 == EnumC0779a.f6740a) {
            return d2;
        }
        return C0684i.f6340a;
    }
}
