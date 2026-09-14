package U2;

import P2.E;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class e implements E {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0768i f2347a;

    public e(InterfaceC0768i interfaceC0768i) {
        this.f2347a = interfaceC0768i;
    }

    @Override // P2.E
    public final InterfaceC0768i a() {
        return this.f2347a;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.f2347a + ')';
    }
}
