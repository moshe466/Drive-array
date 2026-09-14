package r8;

import java.lang.reflect.Method;
import y8.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f13796a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static final a f13797b = new a(null, null, null);

    /* renamed from: c, reason: collision with root package name */
    private static a f13798c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Method f13799a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f13800b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f13801c;

        public a(Method method, Method method2, Method method3) {
            this.f13799a = method;
            this.f13800b = method2;
            this.f13801c = method3;
        }
    }

    private h() {
    }

    private final a a(r8.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f13798c = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f13797b;
            f13798c = aVar3;
            return aVar3;
        }
    }

    public final String b(r8.a aVar) {
        k.e(aVar, "continuation");
        a aVar2 = f13798c;
        if (aVar2 == null) {
            aVar2 = a(aVar);
        }
        if (aVar2 == f13797b) {
            return null;
        }
        Method method = aVar2.f13799a;
        Object invoke = method != null ? method.invoke(aVar.getClass(), new Object[0]) : null;
        if (invoke == null) {
            return null;
        }
        Method method2 = aVar2.f13800b;
        Object invoke2 = method2 != null ? method2.invoke(invoke, new Object[0]) : null;
        if (invoke2 == null) {
            return null;
        }
        Method method3 = aVar2.f13801c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}
