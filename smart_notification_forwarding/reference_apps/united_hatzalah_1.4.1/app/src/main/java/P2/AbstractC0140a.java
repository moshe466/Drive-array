package P2;

import a.AbstractC0228a;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.coroutines.CompletionHandlerException;
import s2.C0681f;
import s2.C0684i;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import x2.EnumC0779a;
import y2.AbstractC0785a;

/* renamed from: P2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0140a extends w0 implements InterfaceC0763d, E {

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0768i f1641c;

    public AbstractC0140a(InterfaceC0768i interfaceC0768i, boolean z3) {
        super(z3);
        A((InterfaceC0157i0) interfaceC0768i.get(B.f1595b));
        this.f1641c = interfaceC0768i.plus(this);
    }

    @Override // P2.w0
    public final void I(Object obj) {
        boolean z3;
        if (obj instanceof C0171v) {
            C0171v c0171v = (C0171v) obj;
            Throwable th = c0171v.f1707a;
            if (C0171v.f1706b.get(c0171v) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            P(th, z3);
            return;
        }
        Q(obj);
    }

    public final void R(F f4, AbstractC0140a abstractC0140a, F2.p pVar) {
        Object invoke;
        int ordinal = f4.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        try {
                            InterfaceC0768i interfaceC0768i = this.f1641c;
                            Object l3 = U2.a.l(interfaceC0768i, null);
                            try {
                                if (!(pVar instanceof AbstractC0785a)) {
                                    invoke = m3.b.W(pVar, abstractC0140a, this);
                                } else {
                                    kotlin.jvm.internal.u.a(2, pVar);
                                    invoke = pVar.invoke(abstractC0140a, this);
                                }
                                U2.a.f(interfaceC0768i, l3);
                                if (invoke != EnumC0779a.f6740a) {
                                    resumeWith(invoke);
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                U2.a.f(interfaceC0768i, l3);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            resumeWith(AbstractC0228a.g(th2));
                            return;
                        }
                    }
                    throw new NoWhenBranchMatchedException();
                }
                kotlin.jvm.internal.j.e(pVar, "<this>");
                m3.b.z(m3.b.k(pVar, abstractC0140a, this)).resumeWith(C0684i.f6340a);
                return;
            }
            return;
        }
        T.b.I(pVar, abstractC0140a, this);
    }

    @Override // P2.E
    public final InterfaceC0768i a() {
        return this.f1641c;
    }

    @Override // w2.InterfaceC0763d
    public final InterfaceC0768i getContext() {
        return this.f1641c;
    }

    @Override // P2.w0
    public final String n() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // w2.InterfaceC0763d
    public final void resumeWith(Object obj) {
        Throwable a2 = C0681f.a(obj);
        if (a2 != null) {
            obj = new C0171v(a2, false);
        }
        Object E3 = E(obj);
        if (E3 == G.f1608e) {
            return;
        }
        i(E3);
    }

    @Override // P2.w0
    public final void z(CompletionHandlerException completionHandlerException) {
        G.n(completionHandlerException, this.f1641c);
    }

    public void Q(Object obj) {
    }

    public void P(Throwable th, boolean z3) {
    }
}
