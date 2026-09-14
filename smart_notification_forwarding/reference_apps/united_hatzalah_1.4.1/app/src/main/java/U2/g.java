package U2;

import P2.A;
import P2.AbstractC0172w;
import P2.C0171v;
import P2.F0;
import P2.G;
import P2.N;
import P2.Z;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s2.C0681f;
import t2.C0704f;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import y2.AbstractC0787c;
import y2.InterfaceC0788d;

/* loaded from: classes.dex */
public final class g extends N implements InterfaceC0788d, InterfaceC0763d {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2349k = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* renamed from: d, reason: collision with root package name */
    public final A f2350d;

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC0787c f2351e;

    /* renamed from: f, reason: collision with root package name */
    public Object f2352f;

    /* renamed from: j, reason: collision with root package name */
    public final Object f2353j;

    public g(A a2, AbstractC0787c abstractC0787c) {
        super(-1);
        this.f2350d = a2;
        this.f2351e = abstractC0787c;
        this.f2352f = a.f2339c;
        this.f2353j = a.k(abstractC0787c.getContext());
    }

    @Override // P2.N
    public final void a(Object obj, CancellationException cancellationException) {
        if (!(obj instanceof AbstractC0172w)) {
            return;
        }
        ((AbstractC0172w) obj).getClass();
        throw null;
    }

    @Override // y2.InterfaceC0788d
    public final InterfaceC0788d getCallerFrame() {
        AbstractC0787c abstractC0787c = this.f2351e;
        if (abstractC0787c != null) {
            return abstractC0787c;
        }
        return null;
    }

    @Override // w2.InterfaceC0763d
    public final InterfaceC0768i getContext() {
        return this.f2351e.getContext();
    }

    @Override // P2.N
    public final Object i() {
        Object obj = this.f2352f;
        this.f2352f = a.f2339c;
        return obj;
    }

    @Override // w2.InterfaceC0763d
    public final void resumeWith(Object obj) {
        Object c0171v;
        AbstractC0787c abstractC0787c = this.f2351e;
        InterfaceC0768i context = abstractC0787c.getContext();
        Throwable a2 = C0681f.a(obj);
        if (a2 == null) {
            c0171v = obj;
        } else {
            c0171v = new C0171v(a2, false);
        }
        A a4 = this.f2350d;
        if (a4.e()) {
            this.f2352f = c0171v;
            this.f1621c = 0;
            a4.d(context, this);
            return;
        }
        Z a5 = F0.a();
        if (a5.f1638c >= 4294967296L) {
            this.f2352f = c0171v;
            this.f1621c = 0;
            C0704f c0704f = a5.f1640e;
            if (c0704f == null) {
                c0704f = new C0704f();
                a5.f1640e = c0704f;
            }
            c0704f.addLast(this);
            return;
        }
        a5.h(true);
        try {
            InterfaceC0768i context2 = abstractC0787c.getContext();
            Object l3 = a.l(context2, this.f2353j);
            try {
                abstractC0787c.resumeWith(obj);
                do {
                } while (a5.j());
            } finally {
                a.f(context2, l3);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f2350d + ", " + G.w(this.f2351e) + ']';
    }

    @Override // P2.N
    public final InterfaceC0763d c() {
        return this;
    }
}
