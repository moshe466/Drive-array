package Q2;

import F0.RunnableC0091v;
import F2.l;
import K1.m;
import P2.C0169t;
import P2.K0;
import R.L;
import R.c0;
import R2.h;
import R2.i;
import R2.j;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.jvm.internal.k;
import s2.C0684i;

/* loaded from: classes.dex */
public final class d extends k implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1729a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1730b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1731c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i, Object obj, Object obj2) {
        super(1);
        this.f1729a = i;
        this.f1730b = obj;
        this.f1731c = obj2;
    }

    @Override // F2.l
    public final Object invoke(Object obj) {
        Object hVar;
        K0 k02;
        C0684i c0684i;
        C0684i c0684i2;
        Throwable th;
        switch (this.f1729a) {
            case 0:
                ((e) this.f1730b).f1732c.removeCallbacks((RunnableC0091v) this.f1731c);
                return C0684i.f6340a;
            default:
                Throwable th2 = (Throwable) obj;
                ((L) this.f1730b).invoke(th2);
                R2.c cVar = (R2.c) ((m) this.f1731c).f1104c;
                cVar.g(th2, false);
                do {
                    cVar.getClass();
                    AtomicLongFieldUpdater atomicLongFieldUpdater = R2.c.f2026c;
                    long j2 = atomicLongFieldUpdater.get(cVar);
                    AtomicLongFieldUpdater atomicLongFieldUpdater2 = R2.c.f2025b;
                    long j3 = atomicLongFieldUpdater2.get(cVar);
                    if (cVar.q(j3, true)) {
                        hVar = new h(cVar.l());
                    } else {
                        long j4 = j3 & 1152921504606846975L;
                        i iVar = j.f2057b;
                        if (j2 < j4) {
                            Object obj2 = R2.e.f2045k;
                            R2.k kVar = (R2.k) R2.c.f2030j.get(cVar);
                            while (true) {
                                if (cVar.q(atomicLongFieldUpdater2.get(cVar), true)) {
                                    hVar = new h(cVar.l());
                                } else {
                                    long andIncrement = atomicLongFieldUpdater.getAndIncrement(cVar);
                                    long j5 = R2.e.f2037b;
                                    long j6 = andIncrement / j5;
                                    int i = (int) (andIncrement % j5);
                                    if (kVar.f2376c != j6) {
                                        R2.k k4 = cVar.k(j6, kVar);
                                        if (k4 == null) {
                                            continue;
                                        } else {
                                            kVar = k4;
                                        }
                                    }
                                    Object z3 = cVar.z(kVar, i, andIncrement, obj2);
                                    if (z3 == R2.e.f2047m) {
                                        if (obj2 instanceof K0) {
                                            k02 = (K0) obj2;
                                        } else {
                                            k02 = null;
                                        }
                                        if (k02 != null) {
                                            k02.b(kVar, i);
                                        }
                                        cVar.B(andIncrement);
                                        kVar.i();
                                    } else if (z3 == R2.e.f2049o) {
                                        if (andIncrement < cVar.o()) {
                                            kVar.b();
                                        }
                                    } else if (z3 != R2.e.f2048n) {
                                        kVar.b();
                                        hVar = z3;
                                    } else {
                                        throw new IllegalStateException("unexpected");
                                    }
                                }
                            }
                        }
                        hVar = iVar;
                    }
                    c0684i = null;
                    if (hVar instanceof i) {
                        hVar = null;
                    }
                    c0684i2 = C0684i.f6340a;
                    if (hVar != null) {
                        C0169t c0169t = ((c0) hVar).f1855b;
                        if (th2 == null) {
                            th = new CancellationException("DataStore scope was cancelled before updateData could complete");
                        } else {
                            th = th2;
                        }
                        c0169t.P(th);
                        c0684i = c0684i2;
                    }
                } while (c0684i != null);
                return c0684i2;
        }
    }
}
