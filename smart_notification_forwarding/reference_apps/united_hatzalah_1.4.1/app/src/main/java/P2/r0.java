package P2;

import F0.G1;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class r0 extends U2.b {

    /* renamed from: b, reason: collision with root package name */
    public final m0 f1690b;

    /* renamed from: c, reason: collision with root package name */
    public y0 f1691c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w0 f1692d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f1693e;

    public r0(m0 m0Var, w0 w0Var, Object obj) {
        this.f1692d = w0Var;
        this.f1693e = obj;
        this.f1690b = m0Var;
    }

    @Override // U2.b
    public final void b(Object obj, Object obj2) {
        boolean z3;
        InterfaceC0147d0 interfaceC0147d0;
        U2.j jVar = (U2.j) obj;
        if (obj2 == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        m0 m0Var = this.f1690b;
        if (z3) {
            interfaceC0147d0 = m0Var;
        } else {
            interfaceC0147d0 = this.f1691c;
        }
        if (interfaceC0147d0 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = U2.j.f2360a;
            while (!atomicReferenceFieldUpdater.compareAndSet(jVar, this, interfaceC0147d0)) {
                if (atomicReferenceFieldUpdater.get(jVar) != this) {
                    return;
                }
            }
            if (z3) {
                y0 y0Var = this.f1691c;
                kotlin.jvm.internal.j.b(y0Var);
                m0Var.e(y0Var);
            }
        }
    }

    @Override // U2.b
    public final G1 c(Object obj) {
        if (this.f1692d.x() == this.f1693e) {
            return null;
        }
        return U2.a.f2341e;
    }
}
