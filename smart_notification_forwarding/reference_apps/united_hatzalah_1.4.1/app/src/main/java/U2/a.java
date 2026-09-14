package U2;

import F0.AbstractC0008a;
import F0.G1;
import P2.A;
import P2.B;
import P2.C;
import P2.C0171v;
import P2.E0;
import P2.F0;
import P2.G;
import P2.I0;
import P2.InterfaceC0157i0;
import P2.Z;
import a.AbstractC0228a;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.DiagnosticCoroutineContextException;
import kotlinx.coroutines.internal.ExceptionSuccessfullyProcessed;
import s2.C0681f;
import t2.C0704f;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final G1 f2337a;

    /* renamed from: b, reason: collision with root package name */
    public static final G1 f2338b;

    /* renamed from: c, reason: collision with root package name */
    public static final G1 f2339c;

    /* renamed from: d, reason: collision with root package name */
    public static final G1 f2340d;

    /* renamed from: e, reason: collision with root package name */
    public static final G1 f2341e;

    /* renamed from: f, reason: collision with root package name */
    public static final G1 f2342f;

    static {
        int i = 8;
        f2337a = new G1("NO_DECISION", i);
        f2338b = new G1("CLOSED", i);
        f2339c = new G1("UNDEFINED", i);
        f2340d = new G1("REUSABLE_CLAIMED", i);
        f2341e = new G1("CONDITION_FALSE", i);
        f2342f = new G1("NO_THREAD_ELEMENTS", i);
    }

    public static final Object a(s sVar, long j2, F2.p pVar) {
        while (true) {
            if (sVar.f2376c >= j2 && !sVar.d()) {
                return sVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d.f2345a;
            Object obj = atomicReferenceFieldUpdater.get(sVar);
            G1 g12 = f2338b;
            if (obj == g12) {
                return g12;
            }
            s sVar2 = (s) ((d) obj);
            if (sVar2 == null) {
                sVar2 = (s) pVar.invoke(Long.valueOf(sVar.f2376c + 1), sVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(sVar, null, sVar2)) {
                    if (atomicReferenceFieldUpdater.get(sVar) != null) {
                        break;
                    }
                }
                if (sVar.d()) {
                    sVar.e();
                }
            }
            sVar = sVar2;
        }
    }

    public static final s b(Object obj) {
        if (obj != f2338b) {
            return (s) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final void c(Throwable th, InterfaceC0768i interfaceC0768i) {
        Throwable runtimeException;
        Iterator it = f.f2348a.iterator();
        while (it.hasNext()) {
            try {
                ((C) it.next()).c(th);
            } catch (ExceptionSuccessfullyProcessed unused) {
                return;
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    E1.b.b(runtimeException, th);
                }
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, runtimeException);
            }
        }
        try {
            E1.b.b(th, new DiagnosticCoroutineContextException(interfaceC0768i));
        } catch (Throwable unused2) {
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }

    public static final boolean d(Object obj) {
        if (obj == f2338b) {
            return true;
        }
        return false;
    }

    public static final Object e(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static final void f(InterfaceC0768i interfaceC0768i, Object obj) {
        if (obj != f2342f) {
            if (obj instanceof x) {
                x xVar = (x) obj;
                E0[] e0Arr = xVar.f2386b;
                int length = e0Arr.length - 1;
                if (length < 0) {
                    return;
                }
                E0 e02 = e0Arr[length];
                kotlin.jvm.internal.j.b(null);
                Object obj2 = xVar.f2385a[length];
                throw null;
            }
            Object fold = interfaceC0768i.fold(null, v.f2380c);
            kotlin.jvm.internal.j.c(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            AbstractC0008a.z(fold);
            throw null;
        }
    }

    public static final void g(Object obj, InterfaceC0763d interfaceC0763d) {
        Object c0171v;
        I0 i02;
        if (interfaceC0763d instanceof g) {
            g gVar = (g) interfaceC0763d;
            A a2 = gVar.f2350d;
            Throwable a4 = C0681f.a(obj);
            if (a4 == null) {
                c0171v = obj;
            } else {
                c0171v = new C0171v(a4, false);
            }
            AbstractC0787c abstractC0787c = gVar.f2351e;
            abstractC0787c.getContext();
            if (a2.e()) {
                gVar.f2352f = c0171v;
                gVar.f1621c = 1;
                a2.d(abstractC0787c.getContext(), gVar);
                return;
            }
            Z a5 = F0.a();
            if (a5.f1638c >= 4294967296L) {
                gVar.f2352f = c0171v;
                gVar.f1621c = 1;
                C0704f c0704f = a5.f1640e;
                if (c0704f == null) {
                    c0704f = new C0704f();
                    a5.f1640e = c0704f;
                }
                c0704f.addLast(gVar);
                return;
            }
            a5.h(true);
            try {
                InterfaceC0157i0 interfaceC0157i0 = (InterfaceC0157i0) abstractC0787c.getContext().get(B.f1595b);
                if (interfaceC0157i0 != null && !interfaceC0157i0.isActive()) {
                    CancellationException cancellationException = interfaceC0157i0.getCancellationException();
                    gVar.a(c0171v, cancellationException);
                    gVar.resumeWith(AbstractC0228a.g(cancellationException));
                } else {
                    Object obj2 = gVar.f2353j;
                    InterfaceC0768i context = abstractC0787c.getContext();
                    Object l3 = l(context, obj2);
                    if (l3 != f2342f) {
                        i02 = G.y(abstractC0787c, context, l3);
                    } else {
                        i02 = null;
                    }
                    try {
                        abstractC0787c.resumeWith(obj);
                    } finally {
                        if (i02 == null || i02.S()) {
                            f(context, l3);
                        }
                    }
                }
                do {
                } while (a5.j());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        interfaceC0763d.resumeWith(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long i(long r22, long r24, long r26, java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: U2.a.i(long, long, long, java.lang.String):long");
    }

    public static int j(String str, int i, int i3) {
        int i4;
        if ((i3 & 8) != 0) {
            i4 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        } else {
            i4 = 2097150;
        }
        return (int) i(i, 1, i4, str);
    }

    public static final Object k(InterfaceC0768i interfaceC0768i) {
        Object fold = interfaceC0768i.fold(0, v.f2379b);
        kotlin.jvm.internal.j.b(fold);
        return fold;
    }

    public static final Object l(InterfaceC0768i interfaceC0768i, Object obj) {
        if (obj == null) {
            obj = k(interfaceC0768i);
        }
        if (obj == 0) {
            return f2342f;
        }
        if (obj instanceof Integer) {
            return interfaceC0768i.fold(new x(((Number) obj).intValue(), interfaceC0768i), v.f2381d);
        }
        AbstractC0008a.z(obj);
        throw null;
    }
}
