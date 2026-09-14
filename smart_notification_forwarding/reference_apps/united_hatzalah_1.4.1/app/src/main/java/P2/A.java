package P2;

import w2.AbstractC0760a;
import w2.C0764e;
import w2.InterfaceC0765f;
import w2.InterfaceC0766g;
import w2.InterfaceC0767h;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public abstract class A extends AbstractC0760a implements InterfaceC0765f {

    /* renamed from: b, reason: collision with root package name */
    public static final C0175z f1593b = new C0175z(C0764e.f6732a, C0174y.f1715a);

    public A() {
        super(C0764e.f6732a);
    }

    public abstract void d(InterfaceC0768i interfaceC0768i, Runnable runnable);

    public boolean e() {
        return !(this instanceof H0);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [F2.l, kotlin.jvm.internal.k] */
    @Override // w2.AbstractC0760a, w2.InterfaceC0768i
    public final InterfaceC0766g get(InterfaceC0767h key) {
        InterfaceC0766g interfaceC0766g;
        kotlin.jvm.internal.j.e(key, "key");
        if (key instanceof C0175z) {
            C0175z c0175z = (C0175z) key;
            InterfaceC0767h interfaceC0767h = this.f6728a;
            if ((interfaceC0767h == c0175z || c0175z.f1717b == interfaceC0767h) && (interfaceC0766g = (InterfaceC0766g) c0175z.f1716a.invoke(this)) != null) {
                return interfaceC0766g;
            }
        } else if (C0764e.f6732a == key) {
            return this;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (((w2.InterfaceC0766g) r3.f1716a.invoke(r2)) != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
    
        return w2.C0769j.f6733a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        if (w2.C0764e.f6732a == r3) goto L15;
     */
    /* JADX WARN: Type inference failed for: r3v3, types: [F2.l, kotlin.jvm.internal.k] */
    @Override // w2.AbstractC0760a, w2.InterfaceC0768i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final w2.InterfaceC0768i minusKey(w2.InterfaceC0767h r3) {
        /*
            r2 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.j.e(r3, r0)
            boolean r0 = r3 instanceof P2.C0175z
            if (r0 == 0) goto L20
            P2.z r3 = (P2.C0175z) r3
            w2.h r0 = r2.f6728a
            if (r0 == r3) goto L15
            w2.h r1 = r3.f1717b
            if (r1 != r0) goto L14
            goto L15
        L14:
            return r2
        L15:
            kotlin.jvm.internal.k r3 = r3.f1716a
            java.lang.Object r3 = r3.invoke(r2)
            w2.g r3 = (w2.InterfaceC0766g) r3
            if (r3 == 0) goto L27
            goto L24
        L20:
            w2.e r0 = w2.C0764e.f6732a
            if (r0 != r3) goto L27
        L24:
            w2.j r3 = w2.C0769j.f6733a
            return r3
        L27:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: P2.A.minusKey(w2.h):w2.i");
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + G.l(this);
    }
}
