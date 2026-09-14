package s9;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m8.l0;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final List<e9.b<? extends Object>> f14146a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Class<? extends Object>, Class<? extends Object>> f14147b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends Object>, Class<? extends Object>> f14148c;

    /* renamed from: d, reason: collision with root package name */
    private static final Map<Class<? extends l8.c<?>>, Integer> f14149d;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.l<ParameterizedType, ParameterizedType> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f14150f = new a();

        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ParameterizedType h(ParameterizedType parameterizedType) {
            y8.k.e(parameterizedType, "it");
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType instanceof ParameterizedType) {
                return (ParameterizedType) ownerType;
            }
            return null;
        }
    }

    /* renamed from: s9.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0291b extends y8.l implements x8.l<ParameterizedType, lb.h<? extends Type>> {

        /* renamed from: f, reason: collision with root package name */
        public static final C0291b f14151f = new C0291b();

        C0291b() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final lb.h<Type> h(ParameterizedType parameterizedType) {
            lb.h<Type> k10;
            y8.k.e(parameterizedType, "it");
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            y8.k.d(actualTypeArguments, "it.actualTypeArguments");
            k10 = m8.k.k(actualTypeArguments);
            return k10;
        }
    }

    static {
        List<e9.b<? extends Object>> g10;
        int n10;
        Map<Class<? extends Object>, Class<? extends Object>> p10;
        int n11;
        Map<Class<? extends Object>, Class<? extends Object>> p11;
        List g11;
        int n12;
        Map<Class<? extends l8.c<?>>, Integer> p12;
        int i10 = 0;
        g10 = m8.q.g(y8.w.b(Boolean.TYPE), y8.w.b(Byte.TYPE), y8.w.b(Character.TYPE), y8.w.b(Double.TYPE), y8.w.b(Float.TYPE), y8.w.b(Integer.TYPE), y8.w.b(Long.TYPE), y8.w.b(Short.TYPE));
        f14146a = g10;
        n10 = m8.r.n(g10, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = g10.iterator();
        while (it.hasNext()) {
            e9.b bVar = (e9.b) it.next();
            arrayList.add(l8.t.a(w8.a.c(bVar), w8.a.d(bVar)));
        }
        p10 = l0.p(arrayList);
        f14147b = p10;
        List<e9.b<? extends Object>> list = f14146a;
        n11 = m8.r.n(list, 10);
        ArrayList arrayList2 = new ArrayList(n11);
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            e9.b bVar2 = (e9.b) it2.next();
            arrayList2.add(l8.t.a(w8.a.d(bVar2), w8.a.c(bVar2)));
        }
        p11 = l0.p(arrayList2);
        f14148c = p11;
        g11 = m8.q.g(x8.a.class, x8.l.class, x8.p.class, x8.q.class, x8.r.class, x8.s.class, x8.t.class, x8.u.class, x8.v.class, x8.w.class, x8.b.class, x8.c.class, x8.d.class, x8.e.class, x8.f.class, x8.g.class, x8.h.class, x8.i.class, x8.j.class, x8.k.class, x8.m.class, x8.n.class, x8.o.class);
        n12 = m8.r.n(g11, 10);
        ArrayList arrayList3 = new ArrayList(n12);
        for (Object obj : g11) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                m8.q.m();
            }
            arrayList3.add(l8.t.a((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        p12 = l0.p(arrayList3);
        f14149d = p12;
    }

    public static final Class<?> a(Class<?> cls) {
        y8.k.e(cls, "<this>");
        return Array.newInstance(cls, 0).getClass();
    }

    public static final la.a b(Class<?> cls) {
        y8.k.e(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException(y8.k.j("Can't compute ClassId for primitive type: ", cls));
        }
        if (cls.isArray()) {
            throw new IllegalArgumentException(y8.k.j("Can't compute ClassId for array type: ", cls));
        }
        if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
            String simpleName = cls.getSimpleName();
            y8.k.d(simpleName, "simpleName");
            if (!(simpleName.length() == 0)) {
                Class<?> declaringClass = cls.getDeclaringClass();
                la.a d10 = declaringClass == null ? null : b(declaringClass).d(la.e.r(cls.getSimpleName()));
                if (d10 == null) {
                    d10 = la.a.m(new la.b(cls.getName()));
                }
                y8.k.d(d10, "declaringClass?.classId?.createNestedClassId(Name.identifier(simpleName)) ?: ClassId.topLevel(FqName(name))");
                return d10;
            }
        }
        la.b bVar = new la.b(cls.getName());
        return new la.a(bVar.e(), la.b.k(bVar.g()), true);
    }

    public static final String c(Class<?> cls) {
        String t10;
        y8.k.e(cls, "<this>");
        if (y8.k.a(cls, Void.TYPE)) {
            return "V";
        }
        String name = a(cls).getName();
        y8.k.d(name, "createArrayType().name");
        String substring = name.substring(1);
        y8.k.d(substring, "(this as java.lang.String).substring(startIndex)");
        t10 = mb.r.t(substring, '.', '/', false, 4, null);
        return t10;
    }

    public static final List<Type> d(Type type) {
        lb.h f10;
        lb.h p10;
        List<Type> w10;
        List<Type> O;
        List<Type> d10;
        y8.k.e(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            d10 = m8.q.d();
            return d10;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() == null) {
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            y8.k.d(actualTypeArguments, "actualTypeArguments");
            O = m8.k.O(actualTypeArguments);
            return O;
        }
        f10 = lb.l.f(type, a.f14150f);
        p10 = lb.n.p(f10, C0291b.f14151f);
        w10 = lb.n.w(p10);
        return w10;
    }

    public static final Class<?> e(Class<?> cls) {
        y8.k.e(cls, "<this>");
        return f14147b.get(cls);
    }

    public static final ClassLoader f(Class<?> cls) {
        y8.k.e(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        y8.k.d(systemClassLoader, "getSystemClassLoader()");
        return systemClassLoader;
    }

    public static final Class<?> g(Class<?> cls) {
        y8.k.e(cls, "<this>");
        return f14148c.get(cls);
    }

    public static final boolean h(Class<?> cls) {
        y8.k.e(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
