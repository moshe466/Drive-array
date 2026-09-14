package y2;

import P2.A;
import P2.C0163m;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.j;
import w2.C0764e;
import w2.InterfaceC0763d;
import w2.InterfaceC0765f;
import w2.InterfaceC0766g;
import w2.InterfaceC0768i;

/* renamed from: y2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0787c extends AbstractC0785a {
    private final InterfaceC0768i _context;
    private transient InterfaceC0763d intercepted;

    public AbstractC0787c(InterfaceC0763d interfaceC0763d, InterfaceC0768i interfaceC0768i) {
        super(interfaceC0763d);
        this._context = interfaceC0768i;
    }

    @Override // w2.InterfaceC0763d
    public InterfaceC0768i getContext() {
        InterfaceC0768i interfaceC0768i = this._context;
        j.b(interfaceC0768i);
        return interfaceC0768i;
    }

    public final InterfaceC0763d intercepted() {
        InterfaceC0763d interfaceC0763d;
        InterfaceC0763d interfaceC0763d2 = this.intercepted;
        if (interfaceC0763d2 == null) {
            InterfaceC0765f interfaceC0765f = (InterfaceC0765f) getContext().get(C0764e.f6732a);
            if (interfaceC0765f != null) {
                interfaceC0763d = new U2.g((A) interfaceC0765f, this);
            } else {
                interfaceC0763d = this;
            }
            this.intercepted = interfaceC0763d;
            return interfaceC0763d;
        }
        return interfaceC0763d2;
    }

    @Override // y2.AbstractC0785a
    public void releaseIntercepted() {
        C0163m c0163m;
        InterfaceC0763d interfaceC0763d = this.intercepted;
        if (interfaceC0763d != null && interfaceC0763d != this) {
            InterfaceC0766g interfaceC0766g = getContext().get(C0764e.f6732a);
            j.b(interfaceC0766g);
            U2.g gVar = (U2.g) interfaceC0763d;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = U2.g.f2349k;
            do {
            } while (atomicReferenceFieldUpdater.get(gVar) == U2.a.f2340d);
            Object obj = atomicReferenceFieldUpdater.get(gVar);
            if (obj instanceof C0163m) {
                c0163m = (C0163m) obj;
            } else {
                c0163m = null;
            }
            if (c0163m != null) {
                c0163m.n();
            }
        }
        this.intercepted = C0786b.f6761a;
    }

    public AbstractC0787c(InterfaceC0763d interfaceC0763d) {
        this(interfaceC0763d, interfaceC0763d != null ? interfaceC0763d.getContext() : null);
    }
}
