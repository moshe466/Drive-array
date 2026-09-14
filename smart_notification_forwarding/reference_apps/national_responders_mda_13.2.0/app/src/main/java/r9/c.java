package r9;

import ea.o;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Set;
import k9.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f13806a = new c();

    private c() {
    }

    private final pa.f a(Class<?> cls) {
        int i10 = 0;
        while (cls.isArray()) {
            i10++;
            cls = cls.getComponentType();
            y8.k.d(cls, "currentClass.componentType");
        }
        if (!cls.isPrimitive()) {
            la.a b10 = s9.b.b(cls);
            m9.c cVar = m9.c.f12055a;
            la.b b11 = b10.b();
            y8.k.d(b11, "javaClassId.asSingleFqName()");
            la.a n10 = cVar.n(b11);
            if (n10 != null) {
                b10 = n10;
            }
            return new pa.f(b10, i10);
        }
        if (y8.k.a(cls, Void.TYPE)) {
            la.a m10 = la.a.m(k.a.f11259e.l());
            y8.k.d(m10, "topLevel(StandardNames.FqNames.unit.toSafe())");
            return new pa.f(m10, i10);
        }
        k9.i primitiveType = sa.d.get(cls.getName()).getPrimitiveType();
        y8.k.d(primitiveType, "get(currentClass.name).primitiveType");
        if (i10 > 0) {
            la.a m11 = la.a.m(primitiveType.getArrayTypeFqName());
            y8.k.d(m11, "topLevel(primitiveType.arrayTypeFqName)");
            return new pa.f(m11, i10 - 1);
        }
        la.a m12 = la.a.m(primitiveType.getTypeFqName());
        y8.k.d(m12, "topLevel(primitiveType.typeFqName)");
        return new pa.f(m12, i10);
    }

    private final void c(Class<?> cls, o.d dVar) {
        Constructor<?>[] constructorArr;
        int i10;
        int i11;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        y8.k.d(declaredConstructors, "klass.declaredConstructors");
        int length = declaredConstructors.length;
        int i12 = 0;
        while (i12 < length) {
            Constructor<?> constructor = declaredConstructors[i12];
            int i13 = i12 + 1;
            la.e u10 = la.e.u("<init>");
            y8.k.d(u10, "special(\"<init>\")");
            n nVar = n.f13820a;
            y8.k.d(constructor, "constructor");
            o.e b10 = dVar.b(u10, nVar.a(constructor));
            if (b10 == null) {
                constructorArr = declaredConstructors;
                i10 = length;
                i11 = i13;
            } else {
                Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
                y8.k.d(declaredAnnotations, "constructor.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i14 = 0;
                while (i14 < length2) {
                    Annotation annotation = declaredAnnotations[i14];
                    i14++;
                    y8.k.d(annotation, "annotation");
                    f(b10, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                y8.k.d(parameterAnnotations, "parameterAnnotations");
                if (!(parameterAnnotations.length == 0)) {
                    int length3 = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length4 = parameterAnnotations.length;
                    int i15 = 0;
                    while (i15 < length4) {
                        Annotation[] annotationArr = parameterAnnotations[i15];
                        int i16 = i15 + 1;
                        y8.k.d(annotationArr, "annotations");
                        int length5 = annotationArr.length;
                        int i17 = 0;
                        while (i17 < length5) {
                            Annotation annotation2 = annotationArr[i17];
                            i17++;
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            Class<?> b11 = w8.a.b(w8.a.a(annotation2));
                            int i18 = length;
                            int i19 = i13;
                            la.a b12 = s9.b.b(b11);
                            int i20 = length3;
                            y8.k.d(annotation2, "annotation");
                            o.a b13 = b10.b(i15 + length3, b12, new b(annotation2));
                            if (b13 != null) {
                                h(b13, annotation2, b11);
                            }
                            length = i18;
                            declaredConstructors = constructorArr2;
                            i13 = i19;
                            length3 = i20;
                        }
                        i15 = i16;
                    }
                }
                constructorArr = declaredConstructors;
                i10 = length;
                i11 = i13;
                b10.a();
            }
            length = i10;
            declaredConstructors = constructorArr;
            i12 = i11;
        }
    }

    private final void d(Class<?> cls, o.d dVar) {
        Field[] declaredFields = cls.getDeclaredFields();
        y8.k.d(declaredFields, "klass.declaredFields");
        int length = declaredFields.length;
        int i10 = 0;
        while (i10 < length) {
            Field field = declaredFields[i10];
            i10++;
            la.e r10 = la.e.r(field.getName());
            y8.k.d(r10, "identifier(field.name)");
            n nVar = n.f13820a;
            y8.k.d(field, "field");
            o.c a10 = dVar.a(r10, nVar.b(field), null);
            if (a10 != null) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                y8.k.d(declaredAnnotations, "field.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i11 = 0;
                while (i11 < length2) {
                    Annotation annotation = declaredAnnotations[i11];
                    i11++;
                    y8.k.d(annotation, "annotation");
                    f(a10, annotation);
                }
                a10.a();
            }
        }
    }

    private final void e(Class<?> cls, o.d dVar) {
        Method[] methodArr;
        int i10;
        Method[] declaredMethods = cls.getDeclaredMethods();
        y8.k.d(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i11 = 0;
        while (i11 < length) {
            Method method = declaredMethods[i11];
            i11++;
            la.e r10 = la.e.r(method.getName());
            y8.k.d(r10, "identifier(method.name)");
            n nVar = n.f13820a;
            y8.k.d(method, "method");
            o.e b10 = dVar.b(r10, nVar.c(method));
            if (b10 == null) {
                methodArr = declaredMethods;
                i10 = length;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                y8.k.d(declaredAnnotations, "method.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i12 = 0;
                while (i12 < length2) {
                    Annotation annotation = declaredAnnotations[i12];
                    i12++;
                    y8.k.d(annotation, "annotation");
                    f(b10, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                y8.k.d(parameterAnnotations, "method.parameterAnnotations");
                int length3 = parameterAnnotations.length;
                int i13 = 0;
                while (i13 < length3) {
                    Annotation[] annotationArr = parameterAnnotations[i13];
                    int i14 = i13 + 1;
                    y8.k.d(annotationArr, "annotations");
                    int length4 = annotationArr.length;
                    int i15 = 0;
                    while (i15 < length4) {
                        Annotation annotation2 = annotationArr[i15];
                        i15++;
                        Class<?> b11 = w8.a.b(w8.a.a(annotation2));
                        Method[] methodArr2 = declaredMethods;
                        la.a b12 = s9.b.b(b11);
                        int i16 = length;
                        y8.k.d(annotation2, "annotation");
                        o.a b13 = b10.b(i13, b12, new b(annotation2));
                        if (b13 != null) {
                            h(b13, annotation2, b11);
                        }
                        declaredMethods = methodArr2;
                        length = i16;
                    }
                    i13 = i14;
                }
                methodArr = declaredMethods;
                i10 = length;
                b10.a();
            }
            declaredMethods = methodArr;
            length = i10;
        }
    }

    private final void f(o.c cVar, Annotation annotation) {
        Class<?> b10 = w8.a.b(w8.a.a(annotation));
        o.a c10 = cVar.c(s9.b.b(b10), new b(annotation));
        if (c10 == null) {
            return;
        }
        h(c10, annotation, b10);
    }

    private final void g(o.a aVar, la.e eVar, Object obj) {
        Set set;
        Class<?> cls = obj.getClass();
        if (y8.k.a(cls, Class.class)) {
            aVar.d(eVar, a((Class) obj));
            return;
        }
        set = i.f13813a;
        if (set.contains(cls)) {
            aVar.f(eVar, obj);
            return;
        }
        if (s9.b.h(cls)) {
            if (!cls.isEnum()) {
                cls = cls.getEnclosingClass();
            }
            y8.k.d(cls, "if (clazz.isEnum) clazz else clazz.enclosingClass");
            la.a b10 = s9.b.b(cls);
            la.e r10 = la.e.r(((Enum) obj).name());
            y8.k.d(r10, "identifier((value as Enum<*>).name)");
            aVar.b(eVar, b10, r10);
            return;
        }
        if (Annotation.class.isAssignableFrom(cls)) {
            Class<?>[] interfaces = cls.getInterfaces();
            y8.k.d(interfaces, "clazz.interfaces");
            Class<?> cls2 = (Class) m8.g.D(interfaces);
            y8.k.d(cls2, "annotationClass");
            o.a e10 = aVar.e(eVar, s9.b.b(cls2));
            if (e10 == null) {
                return;
            }
            h(e10, (Annotation) obj, cls2);
            return;
        }
        if (!cls.isArray()) {
            throw new UnsupportedOperationException("Unsupported annotation argument value (" + cls + "): " + obj);
        }
        o.b c10 = aVar.c(eVar);
        if (c10 == null) {
            return;
        }
        Class<?> componentType = cls.getComponentType();
        int i10 = 0;
        if (componentType.isEnum()) {
            y8.k.d(componentType, "componentType");
            la.a b11 = s9.b.b(componentType);
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            while (i10 < length) {
                Object obj2 = objArr[i10];
                i10++;
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                la.e r11 = la.e.r(((Enum) obj2).name());
                y8.k.d(r11, "identifier((element as Enum<*>).name)");
                c10.c(b11, r11);
            }
        } else {
            Object[] objArr2 = (Object[]) obj;
            if (y8.k.a(componentType, Class.class)) {
                int length2 = objArr2.length;
                while (i10 < length2) {
                    Object obj3 = objArr2[i10];
                    i10++;
                    Objects.requireNonNull(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                    c10.b(a((Class) obj3));
                }
            } else {
                int length3 = objArr2.length;
                while (i10 < length3) {
                    Object obj4 = objArr2[i10];
                    i10++;
                    c10.d(obj4);
                }
            }
        }
        c10.a();
    }

    private final void h(o.a aVar, Annotation annotation, Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        y8.k.d(declaredMethods, "annotationType.declaredMethods");
        int length = declaredMethods.length;
        int i10 = 0;
        while (i10 < length) {
            Method method = declaredMethods[i10];
            i10++;
            try {
                Object invoke = method.invoke(annotation, new Object[0]);
                y8.k.b(invoke);
                la.e r10 = la.e.r(method.getName());
                y8.k.d(r10, "identifier(method.name)");
                g(aVar, r10, invoke);
            } catch (IllegalAccessException unused) {
            }
        }
        aVar.a();
    }

    public final void b(Class<?> cls, o.c cVar) {
        y8.k.e(cls, "klass");
        y8.k.e(cVar, "visitor");
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        y8.k.d(declaredAnnotations, "klass.declaredAnnotations");
        int length = declaredAnnotations.length;
        int i10 = 0;
        while (i10 < length) {
            Annotation annotation = declaredAnnotations[i10];
            i10++;
            y8.k.d(annotation, "annotation");
            f(cVar, annotation);
        }
        cVar.a();
    }

    public final void i(Class<?> cls, o.d dVar) {
        y8.k.e(cls, "klass");
        y8.k.e(dVar, "memberVisitor");
        e(cls, dVar);
        c(cls, dVar);
        d(cls, dVar);
    }
}
