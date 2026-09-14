package T2;

import P2.B;
import P2.InterfaceC0157i0;
import w2.InterfaceC0766g;
import w2.InterfaceC0767h;

/* loaded from: classes.dex */
public final class o extends kotlin.jvm.internal.k implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f2300a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(l lVar) {
        super(2);
        this.f2300a = lVar;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        int i;
        int intValue = ((Number) obj).intValue();
        InterfaceC0766g interfaceC0766g = (InterfaceC0766g) obj2;
        InterfaceC0767h key = interfaceC0766g.getKey();
        InterfaceC0766g interfaceC0766g2 = this.f2300a.f2294b.get(key);
        if (key != B.f1595b) {
            if (interfaceC0766g != interfaceC0766g2) {
                i = Integer.MIN_VALUE;
            } else {
                i = intValue + 1;
            }
            return Integer.valueOf(i);
        }
        InterfaceC0157i0 interfaceC0157i0 = (InterfaceC0157i0) interfaceC0766g2;
        InterfaceC0157i0 interfaceC0157i02 = (InterfaceC0157i0) interfaceC0766g;
        while (true) {
            if (interfaceC0157i02 == null) {
                interfaceC0157i02 = null;
                break;
            }
            if (interfaceC0157i02 == interfaceC0157i0 || !(interfaceC0157i02 instanceof U2.r)) {
                break;
            }
            interfaceC0157i02 = interfaceC0157i02.getParent();
        }
        if (interfaceC0157i02 == interfaceC0157i0) {
            if (interfaceC0157i0 != null) {
                intValue++;
            }
            return Integer.valueOf(intValue);
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + interfaceC0157i02 + ", expected child of " + interfaceC0157i0 + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }
}
