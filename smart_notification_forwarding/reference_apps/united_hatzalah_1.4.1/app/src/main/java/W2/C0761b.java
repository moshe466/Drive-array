package w2;

import F2.p;

/* renamed from: w2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0761b implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6729a;

    public /* synthetic */ C0761b(int i) {
        this.f6729a = i;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        C0762c c0762c;
        switch (this.f6729a) {
            case 0:
                String acc = (String) obj;
                InterfaceC0766g element = (InterfaceC0766g) obj2;
                kotlin.jvm.internal.j.e(acc, "acc");
                kotlin.jvm.internal.j.e(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
            default:
                InterfaceC0768i acc2 = (InterfaceC0768i) obj;
                InterfaceC0766g element2 = (InterfaceC0766g) obj2;
                kotlin.jvm.internal.j.e(acc2, "acc");
                kotlin.jvm.internal.j.e(element2, "element");
                InterfaceC0768i minusKey = acc2.minusKey(element2.getKey());
                C0769j c0769j = C0769j.f6733a;
                if (minusKey != c0769j) {
                    C0764e c0764e = C0764e.f6732a;
                    InterfaceC0765f interfaceC0765f = (InterfaceC0765f) minusKey.get(c0764e);
                    if (interfaceC0765f == null) {
                        c0762c = new C0762c(element2, minusKey);
                    } else {
                        InterfaceC0768i minusKey2 = minusKey.minusKey(c0764e);
                        if (minusKey2 == c0769j) {
                            return new C0762c(interfaceC0765f, element2);
                        }
                        c0762c = new C0762c(interfaceC0765f, new C0762c(element2, minusKey2));
                    }
                    return c0762c;
                }
                return element2;
        }
    }
}
