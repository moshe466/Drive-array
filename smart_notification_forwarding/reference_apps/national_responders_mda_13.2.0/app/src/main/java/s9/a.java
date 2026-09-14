package s9;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f14142a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static C0290a f14143b;

    /* renamed from: s9.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0290a {

        /* renamed from: a, reason: collision with root package name */
        private final Method f14144a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f14145b;

        public C0290a(Method method, Method method2) {
            this.f14144a = method;
            this.f14145b = method2;
        }

        public final Method a() {
            return this.f14145b;
        }

        public final Method b() {
            return this.f14144a;
        }
    }

    private a() {
    }

    public final C0290a a(Member member) {
        y8.k.e(member, "member");
        Class<?> cls = member.getClass();
        try {
            return new C0290a(cls.getMethod("getParameters", new Class[0]), b.f(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new C0290a(null, null);
        }
    }

    public final List<String> b(Member member) {
        Method a10;
        y8.k.e(member, "member");
        C0290a c0290a = f14143b;
        if (c0290a == null) {
            c0290a = a(member);
            f14143b = c0290a;
        }
        Method b10 = c0290a.b();
        if (b10 == null || (a10 = c0290a.a()) == null) {
            return null;
        }
        Object invoke = b10.invoke(member, new Object[0]);
        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) invoke;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object invoke2 = a10.invoke(obj, new Object[0]);
            Objects.requireNonNull(invoke2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) invoke2);
        }
        return arrayList;
    }
}
