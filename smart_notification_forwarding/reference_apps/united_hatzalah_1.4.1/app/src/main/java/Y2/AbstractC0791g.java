package y2;

import w2.C0769j;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;

/* renamed from: y2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0791g extends AbstractC0785a {
    public AbstractC0791g(InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        if (interfaceC0763d != null && interfaceC0763d.getContext() != C0769j.f6733a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // w2.InterfaceC0763d
    public final InterfaceC0768i getContext() {
        return C0769j.f6733a;
    }
}
