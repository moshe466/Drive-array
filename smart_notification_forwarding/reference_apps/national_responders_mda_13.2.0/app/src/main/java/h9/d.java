package h9;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import ka.e;

/* loaded from: classes.dex */
public abstract class d {

    /* loaded from: classes.dex */
    public static final class a extends d {

        /* renamed from: a, reason: collision with root package name */
        private final List<Method> f10504a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<?> f10505b;

        /* renamed from: h9.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0188a<T> implements Comparator<T> {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                int a10;
                Method method = (Method) t10;
                y8.k.d(method, "it");
                String name = method.getName();
                Method method2 = (Method) t11;
                y8.k.d(method2, "it");
                a10 = o8.b.a(name, method2.getName());
                return a10;
            }
        }

        /* loaded from: classes.dex */
        static final class b extends y8.l implements x8.l<Method, CharSequence> {

            /* renamed from: f, reason: collision with root package name */
            public static final b f10506f = new b();

            b() {
                super(1);
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CharSequence h(Method method) {
                y8.k.d(method, "it");
                Class<?> returnType = method.getReturnType();
                y8.k.d(returnType, "it.returnType");
                return s9.b.c(returnType);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class<?> cls) {
            super(null);
            List<Method> G;
            y8.k.e(cls, "jClass");
            this.f10505b = cls;
            Method[] declaredMethods = cls.getDeclaredMethods();
            y8.k.d(declaredMethods, "jClass.declaredMethods");
            G = m8.k.G(declaredMethods, new C0188a());
            this.f10504a = G;
        }

        @Override // h9.d
        public String a() {
            String Q;
            Q = m8.y.Q(this.f10504a, "", "<init>(", ")V", 0, null, b.f10506f, 24, null);
            return Q;
        }

        public final List<Method> b() {
            return this.f10504a;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends d {

        /* renamed from: a, reason: collision with root package name */
        private final Constructor<?> f10507a;

        /* loaded from: classes.dex */
        static final class a extends y8.l implements x8.l<Class<?>, CharSequence> {

            /* renamed from: f, reason: collision with root package name */
            public static final a f10508f = new a();

            a() {
                super(1);
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CharSequence h(Class<?> cls) {
                y8.k.d(cls, "it");
                return s9.b.c(cls);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Constructor<?> constructor) {
            super(null);
            y8.k.e(constructor, "constructor");
            this.f10507a = constructor;
        }

        @Override // h9.d
        public String a() {
            String y10;
            Class<?>[] parameterTypes = this.f10507a.getParameterTypes();
            y8.k.d(parameterTypes, "constructor.parameterTypes");
            y10 = m8.k.y(parameterTypes, "", "<init>(", ")V", 0, null, a.f10508f, 24, null);
            return y10;
        }

        public final Constructor<?> b() {
            return this.f10507a;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends d {

        /* renamed from: a, reason: collision with root package name */
        private final Method f10509a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Method method) {
            super(null);
            y8.k.e(method, "method");
            this.f10509a = method;
        }

        @Override // h9.d
        public String a() {
            String b10;
            b10 = i0.b(this.f10509a);
            return b10;
        }

        public final Method b() {
            return this.f10509a;
        }
    }

    /* renamed from: h9.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0189d extends d {

        /* renamed from: a, reason: collision with root package name */
        private final String f10510a;

        /* renamed from: b, reason: collision with root package name */
        private final e.b f10511b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0189d(e.b bVar) {
            super(null);
            y8.k.e(bVar, "signature");
            this.f10511b = bVar;
            this.f10510a = bVar.a();
        }

        @Override // h9.d
        public String a() {
            return this.f10510a;
        }

        public final String b() {
            return this.f10511b.b();
        }
    }

    /* loaded from: classes.dex */
    public static final class e extends d {

        /* renamed from: a, reason: collision with root package name */
        private final String f10512a;

        /* renamed from: b, reason: collision with root package name */
        private final e.b f10513b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(e.b bVar) {
            super(null);
            y8.k.e(bVar, "signature");
            this.f10513b = bVar;
            this.f10512a = bVar.a();
        }

        @Override // h9.d
        public String a() {
            return this.f10512a;
        }

        public final String b() {
            return this.f10513b.b();
        }

        public final String c() {
            return this.f10513b.c();
        }
    }

    private d() {
    }

    public /* synthetic */ d(y8.g gVar) {
        this();
    }

    public abstract String a();
}
