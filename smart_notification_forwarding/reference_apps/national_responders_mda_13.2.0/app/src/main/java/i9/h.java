package i9;

import bb.b0;
import h9.k0;
import java.lang.reflect.Method;
import n9.e1;
import n9.l;
import n9.m;
import n9.p0;
import n9.s0;
import y8.k;

/* loaded from: classes.dex */
public final class h {
    public static final Object a(Object obj, n9.b bVar) {
        b0 e10;
        Class<?> h10;
        Method f10;
        k.e(bVar, "descriptor");
        return (((bVar instanceof p0) && na.f.d((e1) bVar)) || (e10 = e(bVar)) == null || (h10 = h(e10)) == null || (f10 = f(h10, bVar)) == null) ? obj : f10.invoke(obj, new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0058, code lost:
    
        if (na.f.c(r0) != true) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0062, code lost:
    
        if (g(r6) == false) goto L57;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <M extends java.lang.reflect.Member> i9.d<M> b(i9.d<? extends M> r5, n9.b r6, boolean r7) {
        /*
            java.lang.String r0 = "$this$createInlineClassAwareCallerIfNeeded"
            y8.k.e(r5, r0)
            java.lang.String r0 = "descriptor"
            y8.k.e(r6, r0)
            boolean r0 = na.f.a(r6)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L64
            java.util.List r0 = r6.l()
            java.lang.String r3 = "descriptor.valueParameters"
            y8.k.d(r0, r3)
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L27
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L27
        L25:
            r0 = 0
            goto L4c
        L27:
            java.util.Iterator r0 = r0.iterator()
        L2b:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L25
            java.lang.Object r3 = r0.next()
            n9.d1 r3 = (n9.d1) r3
            java.lang.String r4 = "it"
            y8.k.d(r3, r4)
            bb.b0 r3 = r3.b()
            java.lang.String r4 = "it.type"
            y8.k.d(r3, r4)
            boolean r3 = na.f.c(r3)
            if (r3 == 0) goto L2b
            r0 = 1
        L4c:
            if (r0 != 0) goto L64
            bb.b0 r0 = r6.i()
            if (r0 == 0) goto L5a
            boolean r0 = na.f.c(r0)
            if (r0 == r2) goto L64
        L5a:
            boolean r0 = r5 instanceof i9.c
            if (r0 != 0) goto L65
            boolean r0 = g(r6)
            if (r0 == 0) goto L65
        L64:
            r1 = 1
        L65:
            if (r1 == 0) goto L6d
            i9.g r0 = new i9.g
            r0.<init>(r6, r5, r7)
            r5 = r0
        L6d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.h.b(i9.d, n9.b, boolean):i9.d");
    }

    public static /* synthetic */ d c(d dVar, n9.b bVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return b(dVar, bVar, z10);
    }

    public static final Method d(Class<?> cls, n9.b bVar) {
        k.e(cls, "$this$getBoxMethod");
        k.e(bVar, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", f(cls, bVar).getReturnType());
            k.d(declaredMethod, "getDeclaredMethod(\"box\" …d(descriptor).returnType)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new h9.b0("No box method found in inline class: " + cls + " (calling " + bVar + ')');
        }
    }

    private static final b0 e(n9.b bVar) {
        s0 U = bVar.U();
        s0 K = bVar.K();
        if (U != null) {
            return U.b();
        }
        if (K == null) {
            return null;
        }
        if (bVar instanceof l) {
            return K.b();
        }
        m d10 = bVar.d();
        if (!(d10 instanceof n9.e)) {
            d10 = null;
        }
        n9.e eVar = (n9.e) d10;
        if (eVar != null) {
            return eVar.s();
        }
        return null;
    }

    public static final Method f(Class<?> cls, n9.b bVar) {
        k.e(cls, "$this$getUnboxMethod");
        k.e(bVar, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", new Class[0]);
            k.d(declaredMethod, "getDeclaredMethod(\"unbox…FOR_INLINE_CLASS_MEMBERS)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new h9.b0("No unbox method found in inline class: " + cls + " (calling " + bVar + ')');
        }
    }

    private static final boolean g(n9.b bVar) {
        b0 e10 = e(bVar);
        return e10 != null && na.f.c(e10);
    }

    public static final Class<?> h(b0 b0Var) {
        k.e(b0Var, "$this$toInlineClass");
        return i(b0Var.W0().o());
    }

    public static final Class<?> i(m mVar) {
        if (!(mVar instanceof n9.e) || !na.f.b(mVar)) {
            return null;
        }
        n9.e eVar = (n9.e) mVar;
        Class<?> l10 = k0.l(eVar);
        if (l10 != null) {
            return l10;
        }
        throw new h9.b0("Class object for the class " + eVar.c() + " cannot be found (classId=" + ra.a.h((n9.h) mVar) + ')');
    }
}
