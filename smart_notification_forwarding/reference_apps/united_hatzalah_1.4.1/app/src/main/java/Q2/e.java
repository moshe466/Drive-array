package Q2;

import F0.AbstractC0008a;
import F0.RunnableC0091v;
import P2.A;
import P2.B;
import P2.C0158j;
import P2.C0163m;
import P2.G0;
import P2.InterfaceC0157i0;
import P2.L;
import P2.O;
import P2.Q;
import P2.z0;
import U2.n;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.j;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class e extends A implements L {

    /* renamed from: c, reason: collision with root package name */
    public final Handler f1732c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f1733d;

    /* renamed from: e, reason: collision with root package name */
    public final e f1734e;

    public e(Handler handler, boolean z3) {
        e eVar;
        this.f1732c = handler;
        this.f1733d = z3;
        if (z3) {
            eVar = this;
        } else {
            eVar = new e(handler, true);
        }
        this.f1734e = eVar;
    }

    @Override // P2.L
    public final Q a(long j2, final G0 g02, InterfaceC0768i interfaceC0768i) {
        if (j2 > 4611686018427387903L) {
            j2 = 4611686018427387903L;
        }
        if (this.f1732c.postDelayed(g02, j2)) {
            return new Q() { // from class: Q2.c
                @Override // P2.Q
                public final void dispose() {
                    e.this.f1732c.removeCallbacks(g02);
                }
            };
        }
        f(interfaceC0768i, g02);
        return z0.f1718a;
    }

    @Override // P2.L
    public final void b(long j2, C0163m c0163m) {
        RunnableC0091v runnableC0091v = new RunnableC0091v(4, c0163m, this);
        if (j2 > 4611686018427387903L) {
            j2 = 4611686018427387903L;
        }
        if (this.f1732c.postDelayed(runnableC0091v, j2)) {
            d dVar = new d(0, this, runnableC0091v);
            c0163m.getClass();
            c0163m.t(new C0158j(dVar));
            return;
        }
        f(c0163m.f1674e, runnableC0091v);
    }

    @Override // P2.A
    public final void d(InterfaceC0768i interfaceC0768i, Runnable runnable) {
        if (!this.f1732c.post(runnable)) {
            f(interfaceC0768i, runnable);
        }
    }

    @Override // P2.A
    public final boolean e() {
        if (this.f1733d && j.a(Looper.myLooper(), this.f1732c.getLooper())) {
            return false;
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.f1732c == this.f1732c && eVar.f1733d == this.f1733d) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final void f(InterfaceC0768i interfaceC0768i, Runnable runnable) {
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        InterfaceC0157i0 interfaceC0157i0 = (InterfaceC0157i0) interfaceC0768i.get(B.f1595b);
        if (interfaceC0157i0 != null) {
            interfaceC0157i0.cancel(cancellationException);
        }
        O.f1623b.d(interfaceC0768i, runnable);
    }

    public final int hashCode() {
        int i;
        int identityHashCode = System.identityHashCode(this.f1732c);
        if (this.f1733d) {
            i = 1231;
        } else {
            i = 1237;
        }
        return identityHashCode ^ i;
    }

    @Override // P2.A
    public final String toString() {
        e eVar;
        String str;
        W2.e eVar2 = O.f1622a;
        e eVar3 = n.f2372a;
        if (this == eVar3) {
            str = "Dispatchers.Main";
        } else {
            try {
                eVar = eVar3.f1734e;
            } catch (UnsupportedOperationException unused) {
                eVar = null;
            }
            if (this == eVar) {
                str = "Dispatchers.Main.immediate";
            } else {
                str = null;
            }
        }
        if (str == null) {
            String handler = this.f1732c.toString();
            if (this.f1733d) {
                return AbstractC0008a.n(handler, ".immediate");
            }
            return handler;
        }
        return str;
    }
}
