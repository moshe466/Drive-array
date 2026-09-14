package R2;

import F0.G1;
import P2.C0163m;
import P2.G;
import P2.K0;
import U2.t;
import a.AbstractC0228a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import x2.EnumC0779a;

/* loaded from: classes.dex */
public final class b implements K0 {

    /* renamed from: a, reason: collision with root package name */
    public Object f2022a = e.p;

    /* renamed from: b, reason: collision with root package name */
    public C0163m f2023b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f2024c;

    public b(c cVar) {
        this.f2024c = cVar;
    }

    public final Object a(S2.f fVar) {
        k kVar;
        Boolean bool;
        k kVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.f2030j;
        c cVar = this.f2024c;
        k kVar3 = (k) atomicReferenceFieldUpdater.get(cVar);
        while (!cVar.q(c.f2025b.get(cVar), true)) {
            long andIncrement = c.f2026c.getAndIncrement(cVar);
            long j2 = e.f2037b;
            long j3 = andIncrement / j2;
            int i = (int) (andIncrement % j2);
            if (kVar3.f2376c != j3) {
                kVar = cVar.k(j3, kVar3);
                if (kVar == null) {
                    continue;
                }
            } else {
                kVar = kVar3;
            }
            Object z3 = cVar.z(kVar, i, andIncrement, null);
            G1 g12 = e.f2047m;
            if (z3 != g12) {
                G1 g13 = e.f2049o;
                if (z3 == g13) {
                    if (andIncrement < cVar.o()) {
                        kVar.b();
                    }
                    kVar3 = kVar;
                } else if (z3 == e.f2048n) {
                    C0163m m4 = G.m(m3.b.z(fVar));
                    try {
                        this.f2023b = m4;
                        try {
                            Object z4 = cVar.z(kVar, i, andIncrement, this);
                            if (z4 == g12) {
                                b(kVar, i);
                            } else {
                                if (z4 == g13) {
                                    if (andIncrement < cVar.o()) {
                                        kVar.b();
                                    }
                                    k kVar4 = (k) c.f2030j.get(cVar);
                                    while (true) {
                                        if (cVar.q(c.f2025b.get(cVar), true)) {
                                            C0163m c0163m = this.f2023b;
                                            kotlin.jvm.internal.j.b(c0163m);
                                            this.f2023b = null;
                                            this.f2022a = e.f2046l;
                                            Throwable l3 = cVar.l();
                                            if (l3 == null) {
                                                c0163m.resumeWith(Boolean.FALSE);
                                            } else {
                                                c0163m.resumeWith(AbstractC0228a.g(l3));
                                            }
                                        } else {
                                            long andIncrement2 = c.f2026c.getAndIncrement(cVar);
                                            long j4 = e.f2037b;
                                            long j5 = andIncrement2 / j4;
                                            int i3 = (int) (andIncrement2 % j4);
                                            if (kVar4.f2376c != j5) {
                                                kVar2 = cVar.k(j5, kVar4);
                                                if (kVar2 == null) {
                                                }
                                            } else {
                                                kVar2 = kVar4;
                                            }
                                            Object z5 = cVar.z(kVar2, i3, andIncrement2, this);
                                            if (z5 == e.f2047m) {
                                                b(kVar2, i3);
                                                break;
                                            }
                                            if (z5 == e.f2049o) {
                                                if (andIncrement2 < cVar.o()) {
                                                    kVar2.b();
                                                }
                                                kVar4 = kVar2;
                                            } else if (z5 != e.f2048n) {
                                                kVar2.b();
                                                this.f2022a = z5;
                                                this.f2023b = null;
                                                bool = Boolean.TRUE;
                                            } else {
                                                throw new IllegalStateException("unexpected");
                                            }
                                        }
                                    }
                                } else {
                                    kVar.b();
                                    this.f2022a = z4;
                                    this.f2023b = null;
                                    bool = Boolean.TRUE;
                                }
                                m4.y(bool, null);
                            }
                            Object q3 = m4.q();
                            EnumC0779a enumC0779a = EnumC0779a.f6740a;
                            return q3;
                        } catch (Throwable th) {
                            th = th;
                            m4.x();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    kVar.b();
                    this.f2022a = z3;
                    return Boolean.TRUE;
                }
            } else {
                throw new IllegalStateException("unreachable");
            }
        }
        this.f2022a = e.f2046l;
        Throwable l4 = cVar.l();
        if (l4 == null) {
            return Boolean.FALSE;
        }
        int i4 = t.f2377a;
        throw l4;
    }

    @Override // P2.K0
    public final void b(U2.s sVar, int i) {
        C0163m c0163m = this.f2023b;
        if (c0163m != null) {
            c0163m.b(sVar, i);
        }
    }
}
