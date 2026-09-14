package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: androidx.lifecycle.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0294d {

    /* renamed from: c, reason: collision with root package name */
    public static final C0294d f3599c = new C0294d();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f3600a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f3601b = new HashMap();

    public static void b(HashMap hashMap, C0293c c0293c, EnumC0303m enumC0303m, Class cls) {
        EnumC0303m enumC0303m2 = (EnumC0303m) hashMap.get(c0293c);
        if (enumC0303m2 != null && enumC0303m != enumC0303m2) {
            throw new IllegalArgumentException("Method " + c0293c.f3598b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + enumC0303m2 + ", new value " + enumC0303m);
        }
        if (enumC0303m2 == null) {
            hashMap.put(c0293c, enumC0303m);
        }
    }

    public final C0292b a(Class cls, Method[] methodArr) {
        int i;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = this.f3600a;
        if (superclass != null) {
            C0292b c0292b = (C0292b) hashMap2.get(superclass);
            if (c0292b == null) {
                c0292b = a(superclass, null);
            }
            hashMap.putAll(c0292b.f3596b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            C0292b c0292b2 = (C0292b) hashMap2.get(cls2);
            if (c0292b2 == null) {
                c0292b2 = a(cls2, null);
            }
            for (Map.Entry entry : c0292b2.f3596b.entrySet()) {
                b(hashMap, (C0293c) entry.getKey(), (EnumC0303m) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e4) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e4);
            }
        }
        boolean z3 = false;
        for (Method method : methodArr) {
            D d2 = (D) method.getAnnotation(D.class);
            if (d2 != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length > 0) {
                    if (InterfaceC0309t.class.isAssignableFrom(parameterTypes[0])) {
                        i = 1;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                } else {
                    i = 0;
                }
                EnumC0303m value = d2.value();
                if (parameterTypes.length > 1) {
                    if (EnumC0303m.class.isAssignableFrom(parameterTypes[1])) {
                        if (value == EnumC0303m.ON_ANY) {
                            i = 2;
                        } else {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    b(hashMap, new C0293c(i, method), value, cls);
                    z3 = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0292b c0292b3 = new C0292b(hashMap);
        hashMap2.put(cls, c0292b3);
        this.f3601b.put(cls, Boolean.valueOf(z3));
        return c0292b3;
    }
}
