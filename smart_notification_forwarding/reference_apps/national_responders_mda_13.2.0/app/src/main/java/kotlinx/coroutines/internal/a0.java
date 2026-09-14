package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import l8.o;

/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a */
    private static final String f11600a;

    static {
        Object a10;
        Object a11;
        try {
            o.a aVar = l8.o.f11812f;
            a10 = l8.o.a(Class.forName("r8.a").getCanonicalName());
        } catch (Throwable th) {
            o.a aVar2 = l8.o.f11812f;
            a10 = l8.o.a(l8.p.a(th));
        }
        if (l8.o.b(a10) != null) {
            a10 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f11600a = (String) a10;
        try {
            o.a aVar3 = l8.o.f11812f;
            a11 = l8.o.a(a0.class.getCanonicalName());
        } catch (Throwable th2) {
            o.a aVar4 = l8.o.f11812f;
            a11 = l8.o.a(l8.p.a(th2));
        }
        if (l8.o.b(a11) != null) {
            a11 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }

    public static final /* synthetic */ Throwable a(Throwable th, r8.d dVar) {
        return j(th, dVar);
    }

    public static final StackTraceElement b(String str) {
        return new StackTraceElement(y8.k.j("\b\b\b(", str), "\b", "\b", -1);
    }

    private static final <E extends Throwable> l8.n<E, StackTraceElement[]> c(E e10) {
        boolean z10;
        Throwable cause = e10.getCause();
        if (cause == null || !y8.k.a(cause.getClass(), e10.getClass())) {
            return l8.t.a(e10, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e10.getStackTrace();
        int length = stackTrace.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = false;
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i10];
            i10++;
            if (h(stackTraceElement)) {
                z10 = true;
                break;
            }
        }
        return z10 ? l8.t.a(cause, stackTrace) : l8.t.a(e10, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> E d(E e10, E e11, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(b("Coroutine boundary"));
        StackTraceElement[] stackTrace = e10.getStackTrace();
        int g10 = g(stackTrace, f11600a);
        int i10 = 0;
        if (g10 == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            e11.setStackTrace((StackTraceElement[]) array);
            return e11;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + g10];
        for (int i11 = 0; i11 < g10; i11++) {
            stackTraceElementArr[i11] = stackTrace[i11];
        }
        Iterator<StackTraceElement> it = arrayDeque.iterator();
        while (it.hasNext()) {
            int i12 = i10 + 1;
            stackTraceElementArr[i10 + g10] = it.next();
            i10 = i12;
        }
        e11.setStackTrace(stackTraceElementArr);
        return e11;
    }

    private static final ArrayDeque<StackTraceElement> e(r8.d dVar) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement e10 = dVar.e();
        if (e10 != null) {
            arrayDeque.add(e10);
        }
        while (true) {
            dVar = dVar.a();
            if (dVar == null) {
                return arrayDeque;
            }
            StackTraceElement e11 = dVar.e();
            if (e11 != null) {
                arrayDeque.add(e11);
            }
        }
    }

    private static final boolean f(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && y8.k.a(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && y8.k.a(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && y8.k.a(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    private static final int g(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            if (y8.k.a(str, stackTraceElementArr[i10].getClassName())) {
                return i10;
            }
            i10 = i11;
        }
        return -1;
    }

    public static final boolean h(StackTraceElement stackTraceElement) {
        boolean w10;
        w10 = mb.r.w(stackTraceElement.getClassName(), "\b\b\b", false, 2, null);
        return w10;
    }

    private static final void i(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            int i11 = i10 + 1;
            if (h(stackTraceElementArr[i10])) {
                break;
            } else {
                i10 = i11;
            }
        }
        int i12 = i10 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i12 > length2) {
            return;
        }
        while (true) {
            int i13 = length2 - 1;
            if (f(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i12) {
                return;
            } else {
                length2 = i13;
            }
        }
    }

    public static final <E extends Throwable> E j(E e10, r8.d dVar) {
        l8.n c10 = c(e10);
        Throwable th = (Throwable) c10.a();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) c10.b();
        Throwable k10 = k(th);
        if (k10 == null) {
            return e10;
        }
        ArrayDeque<StackTraceElement> e11 = e(dVar);
        if (e11.isEmpty()) {
            return e10;
        }
        if (th != e10) {
            i(stackTraceElementArr, e11);
        }
        return (E) d(th, k10, e11);
    }

    private static final <E extends Throwable> E k(E e10) {
        E e11 = (E) h.g(e10);
        if (e11 == null) {
            return null;
        }
        if ((e10 instanceof nb.s) || y8.k.a(e11.getMessage(), e10.getMessage())) {
            return e11;
        }
        return null;
    }

    public static final <E extends Throwable> E l(E e10) {
        E e11 = (E) e10.getCause();
        if (e11 != null && y8.k.a(e11.getClass(), e10.getClass())) {
            StackTraceElement[] stackTrace = e10.getStackTrace();
            int length = stackTrace.length;
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i10];
                i10++;
                if (h(stackTraceElement)) {
                    z10 = true;
                    break;
                }
            }
            if (z10) {
                return e11;
            }
        }
        return e10;
    }
}
