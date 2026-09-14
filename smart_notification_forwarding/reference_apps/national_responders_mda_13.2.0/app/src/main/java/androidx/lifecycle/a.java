package androidx.lifecycle;

import androidx.lifecycle.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
final class a {

    /* renamed from: c, reason: collision with root package name */
    static a f3186c = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, C0050a> f3187a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, Boolean> f3188b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    /* renamed from: androidx.lifecycle.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0050a {

        /* renamed from: a, reason: collision with root package name */
        final Map<h.b, List<b>> f3189a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        final Map<b, h.b> f3190b;

        C0050a(Map<b, h.b> map) {
            this.f3190b = map;
            for (Map.Entry<b, h.b> entry : map.entrySet()) {
                h.b value = entry.getValue();
                List<b> list = this.f3189a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f3189a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        private static void b(List<b> list, l lVar, h.b bVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(lVar, bVar, obj);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(l lVar, h.b bVar, Object obj) {
            b(this.f3189a.get(bVar), lVar, bVar, obj);
            b(this.f3189a.get(h.b.ON_ANY), lVar, bVar, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final int f3191a;

        /* renamed from: b, reason: collision with root package name */
        final Method f3192b;

        b(int i10, Method method) {
            this.f3191a = i10;
            this.f3192b = method;
            method.setAccessible(true);
        }

        void a(l lVar, h.b bVar, Object obj) {
            try {
                int i10 = this.f3191a;
                if (i10 == 0) {
                    this.f3192b.invoke(obj, new Object[0]);
                } else if (i10 == 1) {
                    this.f3192b.invoke(obj, lVar);
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    this.f3192b.invoke(obj, lVar, bVar);
                }
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException("Failed to call observer method", e11.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3191a == bVar.f3191a && this.f3192b.getName().equals(bVar.f3192b.getName());
        }

        public int hashCode() {
            return (this.f3191a * 31) + this.f3192b.getName().hashCode();
        }
    }

    a() {
    }

    private C0050a a(Class<?> cls, Method[] methodArr) {
        int i10;
        C0050a c10;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (c10 = c(superclass)) != null) {
            hashMap.putAll(c10.f3190b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, h.b> entry : c(cls2).f3190b.entrySet()) {
                e(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            s sVar = (s) method.getAnnotation(s.class);
            if (sVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i10 = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(l.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i10 = 1;
                }
                h.b value = sVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(h.b.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != h.b.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i10 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(hashMap, new b(i10, method), value, cls);
                z10 = true;
            }
        }
        C0050a c0050a = new C0050a(hashMap);
        this.f3187a.put(cls, c0050a);
        this.f3188b.put(cls, Boolean.valueOf(z10));
        return c0050a;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e10) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
        }
    }

    private void e(Map<b, h.b> map, b bVar, h.b bVar2, Class<?> cls) {
        h.b bVar3 = map.get(bVar);
        if (bVar3 == null || bVar2 == bVar3) {
            if (bVar3 == null) {
                map.put(bVar, bVar2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f3192b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + bVar3 + ", new value " + bVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0050a c(Class<?> cls) {
        C0050a c0050a = this.f3187a.get(cls);
        return c0050a != null ? c0050a : a(cls, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Class<?> cls) {
        Boolean bool = this.f3188b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b10 = b(cls);
        for (Method method : b10) {
            if (((s) method.getAnnotation(s.class)) != null) {
                a(cls, b10);
                return true;
            }
        }
        this.f3188b.put(cls, Boolean.FALSE);
        return false;
    }
}
