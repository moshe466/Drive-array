package y8;

import h9.e0;

/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private static final x f15951a;

    /* renamed from: b, reason: collision with root package name */
    private static final e9.b[] f15952b;

    static {
        x xVar = null;
        try {
            xVar = (x) e0.class.newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (xVar == null) {
            xVar = new x();
        }
        f15951a = xVar;
        f15952b = new e9.b[0];
    }

    public static e9.e a(i iVar) {
        return f15951a.a(iVar);
    }

    public static e9.b b(Class cls) {
        return f15951a.b(cls);
    }

    public static e9.d c(Class cls) {
        return f15951a.c(cls, "");
    }

    public static e9.d d(Class cls, String str) {
        return f15951a.c(cls, str);
    }

    public static e9.f e(m mVar) {
        return f15951a.d(mVar);
    }

    public static e9.h f(q qVar) {
        return f15951a.e(qVar);
    }

    public static e9.i g(s sVar) {
        return f15951a.f(sVar);
    }

    public static String h(l lVar) {
        return f15951a.h(lVar);
    }
}
