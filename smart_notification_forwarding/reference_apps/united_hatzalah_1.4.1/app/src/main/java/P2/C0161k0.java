package P2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: P2.k0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0161k0 extends w0 {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1669c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0161k0() {
        super(true);
        C0167q c0167q;
        C0167q c0167q2;
        boolean z3 = true;
        A(null);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = w0.f1710b;
        InterfaceC0166p interfaceC0166p = (InterfaceC0166p) atomicReferenceFieldUpdater.get(this);
        if (interfaceC0166p instanceof C0167q) {
            c0167q = (C0167q) interfaceC0166p;
        } else {
            c0167q = null;
        }
        if (c0167q != null) {
            w0 i = c0167q.i();
            while (!i.u()) {
                InterfaceC0166p interfaceC0166p2 = (InterfaceC0166p) atomicReferenceFieldUpdater.get(i);
                if (interfaceC0166p2 instanceof C0167q) {
                    c0167q2 = (C0167q) interfaceC0166p2;
                } else {
                    c0167q2 = null;
                }
                if (c0167q2 != null) {
                    i = c0167q2.i();
                }
            }
            this.f1669c = z3;
        }
        z3 = false;
        this.f1669c = z3;
    }

    @Override // P2.w0
    public final boolean u() {
        return this.f1669c;
    }

    @Override // P2.w0
    public final boolean v() {
        return true;
    }
}
