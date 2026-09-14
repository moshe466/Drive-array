package w2;

import F0.AbstractC0008a;
import F2.p;
import java.io.Serializable;

/* renamed from: w2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0762c implements InterfaceC0768i, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0768i f6730a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0766g f6731b;

    public C0762c(InterfaceC0766g element, InterfaceC0768i left) {
        kotlin.jvm.internal.j.e(left, "left");
        kotlin.jvm.internal.j.e(element, "element");
        this.f6730a = left;
        this.f6731b = element;
    }

    public final boolean equals(Object obj) {
        boolean z3;
        if (this != obj) {
            if (obj instanceof C0762c) {
                C0762c c0762c = (C0762c) obj;
                c0762c.getClass();
                int i = 2;
                C0762c c0762c2 = c0762c;
                int i3 = 2;
                while (true) {
                    InterfaceC0768i interfaceC0768i = c0762c2.f6730a;
                    if (interfaceC0768i instanceof C0762c) {
                        c0762c2 = (C0762c) interfaceC0768i;
                    } else {
                        c0762c2 = null;
                    }
                    if (c0762c2 == null) {
                        break;
                    }
                    i3++;
                }
                C0762c c0762c3 = this;
                while (true) {
                    InterfaceC0768i interfaceC0768i2 = c0762c3.f6730a;
                    if (interfaceC0768i2 instanceof C0762c) {
                        c0762c3 = (C0762c) interfaceC0768i2;
                    } else {
                        c0762c3 = null;
                    }
                    if (c0762c3 == null) {
                        break;
                    }
                    i++;
                }
                if (i3 == i) {
                    C0762c c0762c4 = this;
                    while (true) {
                        InterfaceC0766g interfaceC0766g = c0762c4.f6731b;
                        if (!kotlin.jvm.internal.j.a(c0762c.get(interfaceC0766g.getKey()), interfaceC0766g)) {
                            z3 = false;
                            break;
                        }
                        InterfaceC0768i interfaceC0768i3 = c0762c4.f6730a;
                        if (interfaceC0768i3 instanceof C0762c) {
                            c0762c4 = (C0762c) interfaceC0768i3;
                        } else {
                            kotlin.jvm.internal.j.c(interfaceC0768i3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                            InterfaceC0766g interfaceC0766g2 = (InterfaceC0766g) interfaceC0768i3;
                            z3 = kotlin.jvm.internal.j.a(c0762c.get(interfaceC0766g2.getKey()), interfaceC0766g2);
                            break;
                        }
                    }
                    if (z3) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // w2.InterfaceC0768i
    public final Object fold(Object obj, p pVar) {
        return pVar.invoke(this.f6730a.fold(obj, pVar), this.f6731b);
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0766g get(InterfaceC0767h key) {
        kotlin.jvm.internal.j.e(key, "key");
        C0762c c0762c = this;
        while (true) {
            InterfaceC0766g interfaceC0766g = c0762c.f6731b.get(key);
            if (interfaceC0766g != null) {
                return interfaceC0766g;
            }
            InterfaceC0768i interfaceC0768i = c0762c.f6730a;
            if (interfaceC0768i instanceof C0762c) {
                c0762c = (C0762c) interfaceC0768i;
            } else {
                return interfaceC0768i.get(key);
            }
        }
    }

    public final int hashCode() {
        return this.f6731b.hashCode() + this.f6730a.hashCode();
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0768i minusKey(InterfaceC0767h key) {
        kotlin.jvm.internal.j.e(key, "key");
        InterfaceC0766g interfaceC0766g = this.f6731b;
        InterfaceC0766g interfaceC0766g2 = interfaceC0766g.get(key);
        InterfaceC0768i interfaceC0768i = this.f6730a;
        if (interfaceC0766g2 != null) {
            return interfaceC0768i;
        }
        InterfaceC0768i minusKey = interfaceC0768i.minusKey(key);
        if (minusKey == interfaceC0768i) {
            return this;
        }
        if (minusKey == C0769j.f6733a) {
            return interfaceC0766g;
        }
        return new C0762c(interfaceC0766g, minusKey);
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0768i plus(InterfaceC0768i context) {
        kotlin.jvm.internal.j.e(context, "context");
        if (context == C0769j.f6733a) {
            return this;
        }
        return (InterfaceC0768i) context.fold(this, new C0761b(1));
    }

    public final String toString() {
        return AbstractC0008a.s(new StringBuilder("["), (String) fold("", new C0761b(0)), ']');
    }
}
