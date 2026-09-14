package v9;

import java.util.HashMap;
import java.util.Map;
import n9.g0;
import n9.h1;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public static final n9.u f14805a;

    /* renamed from: b, reason: collision with root package name */
    public static final n9.u f14806b;

    /* renamed from: c, reason: collision with root package name */
    public static final n9.u f14807c;

    /* renamed from: d, reason: collision with root package name */
    private static final Map<h1, n9.u> f14808d;

    /* loaded from: classes.dex */
    static class a extends n9.r {
        a(h1 h1Var) {
            super(h1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // n9.u
        public boolean e(va.d dVar, n9.q qVar, n9.m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return u.d(qVar, mVar);
        }
    }

    /* loaded from: classes.dex */
    static class b extends n9.r {
        b(h1 h1Var) {
            super(h1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // n9.u
        public boolean e(va.d dVar, n9.q qVar, n9.m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return u.e(dVar, qVar, mVar);
        }
    }

    /* loaded from: classes.dex */
    static class c extends n9.r {
        c(h1 h1Var) {
            super(h1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // n9.u
        public boolean e(va.d dVar, n9.q qVar, n9.m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return u.e(dVar, qVar, mVar);
        }
    }

    static {
        a aVar = new a(q9.a.f13578c);
        f14805a = aVar;
        b bVar = new b(q9.c.f13580c);
        f14806b = bVar;
        c cVar = new c(q9.b.f13579c);
        f14807c = cVar;
        f14808d = new HashMap();
        f(aVar);
        f(bVar);
        f(cVar);
    }

    private static /* synthetic */ void a(int i10) {
        String str = (i10 == 5 || i10 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 5 || i10 == 6) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i10 == 5 || i10 == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i10 == 2 || i10 == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i10 == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i10 != 5 && i10 != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String format = String.format(str, objArr);
        if (i10 != 5 && i10 != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(n9.m mVar, n9.m mVar2) {
        if (mVar == null) {
            a(2);
        }
        if (mVar2 == null) {
            a(3);
        }
        g0 g0Var = (g0) na.d.r(mVar, g0.class, false);
        g0 g0Var2 = (g0) na.d.r(mVar2, g0.class, false);
        return (g0Var2 == null || g0Var == null || !g0Var.f().equals(g0Var2.f())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(va.d dVar, n9.q qVar, n9.m mVar) {
        if (qVar == null) {
            a(0);
        }
        if (mVar == null) {
            a(1);
        }
        if (d(na.d.M(qVar), mVar)) {
            return true;
        }
        return n9.t.f12301c.e(dVar, qVar, mVar);
    }

    private static void f(n9.u uVar) {
        f14808d.put(uVar.b(), uVar);
    }

    public static n9.u g(h1 h1Var) {
        if (h1Var == null) {
            a(4);
        }
        n9.u uVar = f14808d.get(h1Var);
        if (uVar != null) {
            return uVar;
        }
        n9.u j10 = n9.t.j(h1Var);
        if (j10 == null) {
            a(5);
        }
        return j10;
    }
}
