package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/* renamed from: androidx.lifecycle.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0312w {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f3624a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f3625b = new HashMap();

    public static void a(Constructor constructor, InterfaceC0308s interfaceC0308s) {
        try {
            kotlin.jvm.internal.j.d(constructor.newInstance(interfaceC0308s), "{\n            constructo…tance(`object`)\n        }");
            throw new ClassCastException();
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException(e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
    }

    public static int b(Class cls) {
        Constructor<?> constructor;
        boolean z3;
        boolean z4;
        boolean z5;
        String fullPackage;
        HashMap hashMap = f3624a;
        Integer num = (Integer) hashMap.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int i = 1;
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package r3 = cls.getPackage();
                String name = cls.getCanonicalName();
                if (r3 != null) {
                    fullPackage = r3.getName();
                } else {
                    fullPackage = "";
                }
                kotlin.jvm.internal.j.d(fullPackage, "fullPackage");
                if (fullPackage.length() != 0) {
                    kotlin.jvm.internal.j.d(name, "name");
                    name = name.substring(fullPackage.length() + 1);
                    kotlin.jvm.internal.j.d(name, "this as java.lang.String).substring(startIndex)");
                }
                kotlin.jvm.internal.j.d(name, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
                String concat = N2.n.L(name, ".", "_").concat("_LifecycleAdapter");
                if (fullPackage.length() != 0) {
                    concat = fullPackage + '.' + concat;
                }
                constructor = Class.forName(concat).getDeclaredConstructor(cls);
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                constructor = null;
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException(e4);
            }
            HashMap hashMap2 = f3625b;
            if (constructor != null) {
                hashMap2.put(cls, T.b.B(constructor));
            } else {
                C0294d c0294d = C0294d.f3599c;
                HashMap hashMap3 = c0294d.f3601b;
                Boolean bool = (Boolean) hashMap3.get(cls);
                if (bool != null) {
                    z3 = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 < length) {
                                if (((D) declaredMethods[i3].getAnnotation(D.class)) != null) {
                                    c0294d.a(cls, declaredMethods);
                                    z3 = true;
                                    break;
                                }
                                i3++;
                            } else {
                                hashMap3.put(cls, Boolean.FALSE);
                                z3 = false;
                                break;
                            }
                        }
                    } catch (NoClassDefFoundError e5) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e5);
                    }
                }
                if (!z3) {
                    Class superclass = cls.getSuperclass();
                    if (superclass != null && InterfaceC0308s.class.isAssignableFrom(superclass)) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        kotlin.jvm.internal.j.d(superclass, "superclass");
                        if (b(superclass) != 1) {
                            Object obj = hashMap2.get(superclass);
                            kotlin.jvm.internal.j.b(obj);
                            arrayList = new ArrayList((Collection) obj);
                        }
                    }
                    Class<?>[] interfaces = cls.getInterfaces();
                    kotlin.jvm.internal.j.d(interfaces, "klass.interfaces");
                    int length2 = interfaces.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 < length2) {
                            Class<?> intrface = interfaces[i4];
                            if (intrface != null && InterfaceC0308s.class.isAssignableFrom(intrface)) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z5) {
                                kotlin.jvm.internal.j.d(intrface, "intrface");
                                if (b(intrface) == 1) {
                                    break;
                                }
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                Object obj2 = hashMap2.get(intrface);
                                kotlin.jvm.internal.j.b(obj2);
                                arrayList.addAll((Collection) obj2);
                            }
                            i4++;
                        } else if (arrayList != null) {
                            hashMap2.put(cls, arrayList);
                        }
                    }
                }
            }
            i = 2;
        }
        hashMap.put(cls, Integer.valueOf(i));
        return i;
    }
}
