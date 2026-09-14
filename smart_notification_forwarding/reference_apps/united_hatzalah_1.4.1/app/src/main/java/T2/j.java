package T2;

import F0.G1;
import kotlin.jvm.internal.u;
import w2.C0769j;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import x2.EnumC0779a;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final G1 f2291a = new G1("NULL", 8);

    public static /* synthetic */ S2.d a(h hVar, Q2.e eVar, int i, R2.a aVar, int i3) {
        InterfaceC0768i interfaceC0768i = eVar;
        if ((i3 & 1) != 0) {
            interfaceC0768i = C0769j.f6733a;
        }
        if ((i3 & 2) != 0) {
            i = -3;
        }
        if ((i3 & 4) != 0) {
            aVar = R2.a.f2018a;
        }
        return hVar.a(interfaceC0768i, i, aVar);
    }

    public static final Object b(InterfaceC0768i interfaceC0768i, Object obj, Object obj2, F2.p pVar, InterfaceC0763d frame) {
        Object invoke;
        Object l3 = U2.a.l(interfaceC0768i, obj2);
        try {
            q qVar = new q(frame, interfaceC0768i);
            if (pVar == null) {
                invoke = m3.b.W(pVar, obj, qVar);
            } else {
                u.a(2, pVar);
                invoke = pVar.invoke(obj, qVar);
            }
            U2.a.f(interfaceC0768i, l3);
            if (invoke == EnumC0779a.f6740a) {
                kotlin.jvm.internal.j.e(frame, "frame");
            }
            return invoke;
        } catch (Throwable th) {
            U2.a.f(interfaceC0768i, l3);
            throw th;
        }
    }
}
