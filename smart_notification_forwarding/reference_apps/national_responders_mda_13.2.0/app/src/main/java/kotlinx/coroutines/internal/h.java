package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import l8.o;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private static final int f11621a = f(Throwable.class, -1);

    /* renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.e f11622b;

    /* loaded from: classes.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int a10;
            a10 = o8.b.a(Integer.valueOf(((Constructor) t11).getParameterTypes().length), Integer.valueOf(((Constructor) t10).getParameterTypes().length));
            return a10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends y8.l implements x8.l {

        /* renamed from: f, reason: collision with root package name */
        public static final b f11623f = new b();

        b() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void h(Throwable th) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends y8.l implements x8.l<Throwable, Throwable> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Constructor f11624f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Constructor constructor) {
            super(1);
            this.f11624f = constructor;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Throwable h(Throwable th) {
            Object a10;
            Object newInstance;
            try {
                o.a aVar = l8.o.f11812f;
                newInstance = this.f11624f.newInstance(th.getMessage(), th);
            } catch (Throwable th2) {
                o.a aVar2 = l8.o.f11812f;
                a10 = l8.o.a(l8.p.a(th2));
            }
            if (newInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            }
            a10 = l8.o.a((Throwable) newInstance);
            if (l8.o.c(a10)) {
                a10 = null;
            }
            return (Throwable) a10;
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends y8.l implements x8.l<Throwable, Throwable> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Constructor f11625f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Constructor constructor) {
            super(1);
            this.f11625f = constructor;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Throwable h(Throwable th) {
            Object a10;
            Object newInstance;
            try {
                o.a aVar = l8.o.f11812f;
                newInstance = this.f11625f.newInstance(th);
            } catch (Throwable th2) {
                o.a aVar2 = l8.o.f11812f;
                a10 = l8.o.a(l8.p.a(th2));
            }
            if (newInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            }
            a10 = l8.o.a((Throwable) newInstance);
            if (l8.o.c(a10)) {
                a10 = null;
            }
            return (Throwable) a10;
        }
    }

    /* loaded from: classes.dex */
    public static final class e extends y8.l implements x8.l<Throwable, Throwable> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Constructor f11626f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Constructor constructor) {
            super(1);
            this.f11626f = constructor;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Throwable h(Throwable th) {
            Object a10;
            Object newInstance;
            try {
                o.a aVar = l8.o.f11812f;
                newInstance = this.f11626f.newInstance(th.getMessage());
            } catch (Throwable th2) {
                o.a aVar2 = l8.o.f11812f;
                a10 = l8.o.a(l8.p.a(th2));
            }
            if (newInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            }
            Throwable th3 = (Throwable) newInstance;
            th3.initCause(th);
            a10 = l8.o.a(th3);
            if (l8.o.c(a10)) {
                a10 = null;
            }
            return (Throwable) a10;
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends y8.l implements x8.l<Throwable, Throwable> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Constructor f11627f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Constructor constructor) {
            super(1);
            this.f11627f = constructor;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Throwable h(Throwable th) {
            Object a10;
            Object newInstance;
            try {
                o.a aVar = l8.o.f11812f;
                newInstance = this.f11627f.newInstance(new Object[0]);
            } catch (Throwable th2) {
                o.a aVar2 = l8.o.f11812f;
                a10 = l8.o.a(l8.p.a(th2));
            }
            if (newInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            }
            Throwable th3 = (Throwable) newInstance;
            th3.initCause(th);
            a10 = l8.o.a(th3);
            if (l8.o.c(a10)) {
                a10 = null;
            }
            return (Throwable) a10;
        }
    }

    static {
        kotlinx.coroutines.internal.e eVar;
        try {
            eVar = j.a() ? j0.f11634a : kotlinx.coroutines.internal.d.f11604a;
        } catch (Throwable unused) {
            eVar = j0.f11634a;
        }
        f11622b = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E extends Throwable> x8.l<Throwable, Throwable> b(Class<E> cls) {
        List G;
        b bVar = b.f11623f;
        if (f11621a != f(cls, 0)) {
            return bVar;
        }
        G = m8.k.G(cls.getConstructors(), new a());
        Iterator it = G.iterator();
        while (it.hasNext()) {
            x8.l<Throwable, Throwable> c10 = c((Constructor) it.next());
            if (c10 != null) {
                return c10;
            }
        }
        return bVar;
    }

    private static final x8.l<Throwable, Throwable> c(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new f(constructor);
        }
        if (length != 1) {
            if (length == 2 && y8.k.a(parameterTypes[0], String.class) && y8.k.a(parameterTypes[1], Throwable.class)) {
                return new c(constructor);
            }
            return null;
        }
        Class<?> cls = parameterTypes[0];
        if (y8.k.a(cls, Throwable.class)) {
            return new d(constructor);
        }
        if (y8.k.a(cls, String.class)) {
            return new e(constructor);
        }
        return null;
    }

    private static final int d(Class<?> cls, int i10) {
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                Field field = declaredFields[i11];
                i11++;
                if (!Modifier.isStatic(field.getModifiers())) {
                    i12++;
                }
            }
            i10 += i12;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i10;
    }

    static /* synthetic */ int e(Class cls, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return d(cls, i10);
    }

    private static final int f(Class<?> cls, int i10) {
        Object a10;
        w8.a.e(cls);
        try {
            o.a aVar = l8.o.f11812f;
            a10 = l8.o.a(Integer.valueOf(e(cls, 0, 1, null)));
        } catch (Throwable th) {
            o.a aVar2 = l8.o.f11812f;
            a10 = l8.o.a(l8.p.a(th));
        }
        Integer valueOf = Integer.valueOf(i10);
        if (l8.o.c(a10)) {
            a10 = valueOf;
        }
        return ((Number) a10).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends Throwable> E g(E e10) {
        Object a10;
        if (!(e10 instanceof nb.s)) {
            return (E) f11622b.a(e10.getClass()).h(e10);
        }
        try {
            o.a aVar = l8.o.f11812f;
            a10 = l8.o.a(((nb.s) e10).a());
        } catch (Throwable th) {
            o.a aVar2 = l8.o.f11812f;
            a10 = l8.o.a(l8.p.a(th));
        }
        if (l8.o.c(a10)) {
            a10 = null;
        }
        return (E) a10;
    }
}
