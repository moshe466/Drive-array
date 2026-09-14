package com.google.common.reflect;

import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;
import java.util.function.Function;
import n3.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c {

    /* loaded from: classes.dex */
    class a implements Function {
        a() {
        }

        @Override // java.util.function.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(Type type) {
            return EnumC0087c.CURRENT.typeName(type);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements GenericArrayType, Serializable {

        /* renamed from: f, reason: collision with root package name */
        private final Type f7045f;

        b(Type type) {
            this.f7045f = EnumC0087c.CURRENT.usedInGenericType(type);
        }

        public boolean equals(Object obj) {
            if (obj instanceof GenericArrayType) {
                return m3.c.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f7045f;
        }

        public int hashCode() {
            return this.f7045f.hashCode();
        }

        public String toString() {
            return String.valueOf(c.b(this.f7045f)).concat("[]");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: com.google.common.reflect.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class EnumC0087c {
        private static final /* synthetic */ EnumC0087c[] $VALUES;
        static final EnumC0087c CURRENT;
        public static final EnumC0087c JAVA6;
        public static final EnumC0087c JAVA7;
        public static final EnumC0087c JAVA8;
        public static final EnumC0087c JAVA9;

        /* renamed from: com.google.common.reflect.c$c$a */
        /* loaded from: classes.dex */
        enum a extends EnumC0087c {
            a(String str, int i10) {
                super(str, i10, null);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.c.EnumC0087c
            public GenericArrayType newArrayType(Type type) {
                return new b(type);
            }

            @Override // com.google.common.reflect.c.EnumC0087c
            Type usedInGenericType(Type type) {
                m3.d.h(type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                return cls.isArray() ? new b(cls.getComponentType()) : type;
            }
        }

        /* renamed from: com.google.common.reflect.c$c$b */
        /* loaded from: classes.dex */
        enum b extends EnumC0087c {
            b(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.reflect.c.EnumC0087c
            Type newArrayType(Type type) {
                return type instanceof Class ? c.a((Class) type) : new b(type);
            }

            @Override // com.google.common.reflect.c.EnumC0087c
            Type usedInGenericType(Type type) {
                return (Type) m3.d.h(type);
            }
        }

        /* renamed from: com.google.common.reflect.c$c$c, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        enum C0088c extends EnumC0087c {
            C0088c(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.reflect.c.EnumC0087c
            Type newArrayType(Type type) {
                return EnumC0087c.JAVA7.newArrayType(type);
            }

            @Override // com.google.common.reflect.c.EnumC0087c
            String typeName(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (IllegalAccessException e10) {
                    throw new RuntimeException(e10);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e11) {
                    throw new RuntimeException(e11);
                }
            }

            @Override // com.google.common.reflect.c.EnumC0087c
            Type usedInGenericType(Type type) {
                return EnumC0087c.JAVA7.usedInGenericType(type);
            }
        }

        /* renamed from: com.google.common.reflect.c$c$d */
        /* loaded from: classes.dex */
        enum d extends EnumC0087c {
            d(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.reflect.c.EnumC0087c
            boolean jdkTypeDuplicatesOwnerName() {
                return false;
            }

            @Override // com.google.common.reflect.c.EnumC0087c
            Type newArrayType(Type type) {
                return EnumC0087c.JAVA8.newArrayType(type);
            }

            @Override // com.google.common.reflect.c.EnumC0087c
            String typeName(Type type) {
                return EnumC0087c.JAVA8.typeName(type);
            }

            @Override // com.google.common.reflect.c.EnumC0087c
            Type usedInGenericType(Type type) {
                return EnumC0087c.JAVA8.usedInGenericType(type);
            }
        }

        /* renamed from: com.google.common.reflect.c$c$e */
        /* loaded from: classes.dex */
        class e extends com.google.common.reflect.a<Map.Entry<String, int[][]>> {
            e() {
            }
        }

        /* renamed from: com.google.common.reflect.c$c$f */
        /* loaded from: classes.dex */
        class f extends com.google.common.reflect.a<int[]> {
            f() {
            }
        }

        private static /* synthetic */ EnumC0087c[] $values() {
            return new EnumC0087c[]{JAVA6, JAVA7, JAVA8, JAVA9};
        }

        static {
            a aVar = new a("JAVA6", 0);
            JAVA6 = aVar;
            b bVar = new b("JAVA7", 1);
            JAVA7 = bVar;
            C0088c c0088c = new C0088c("JAVA8", 2);
            JAVA8 = c0088c;
            d dVar = new d("JAVA9", 3);
            JAVA9 = dVar;
            $VALUES = $values();
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                if (new e().a().toString().contains("java.util.Map.java.util.Map")) {
                    CURRENT = c0088c;
                    return;
                } else {
                    CURRENT = dVar;
                    return;
                }
            }
            if (new f().a() instanceof Class) {
                CURRENT = bVar;
            } else {
                CURRENT = aVar;
            }
        }

        private EnumC0087c(String str, int i10) {
        }

        /* synthetic */ EnumC0087c(String str, int i10, a aVar) {
            this(str, i10);
        }

        public static EnumC0087c valueOf(String str) {
            return (EnumC0087c) Enum.valueOf(EnumC0087c.class, str);
        }

        public static EnumC0087c[] values() {
            return (EnumC0087c[]) $VALUES.clone();
        }

        boolean jdkTypeDuplicatesOwnerName() {
            return true;
        }

        abstract Type newArrayType(Type type);

        String typeName(Type type) {
            return c.b(type);
        }

        abstract Type usedInGenericType(Type type);

        final g<Type> usedInGenericType(Type[] typeArr) {
            g.b s10 = g.s();
            for (Type type : typeArr) {
                s10.b(usedInGenericType(type));
            }
            return s10.c();
        }
    }

    static {
        new a();
        m3.b.a(", ").b("null");
    }

    static Class<?> a(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
