package com.google.firebase.firestore.util;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.Blob;
import com.google.firebase.firestore.DocumentId;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.IgnoreExtraProperties;
import com.google.firebase.firestore.PropertyName;
import com.google.firebase.firestore.ServerTimestamp;
import com.google.firebase.firestore.ThrowOnExtraProperties;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public class CustomClassMapper {
    private static final int MAX_DEPTH = 500;
    private static final ConcurrentMap<Class<?>, BeanMapper<?>> mappers = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class BeanMapper<T> {
        private final Class<T> clazz;
        private final Constructor<T> constructor;
        private final boolean throwOnUnknownProperties;
        private final boolean warnOnUnknownProperties;
        private final Map<String, String> properties = new HashMap();
        private final Map<String, Method> setters = new HashMap();
        private final Map<String, Method> getters = new HashMap();
        private final Map<String, Field> fields = new HashMap();
        private final HashSet<String> serverTimestamps = new HashSet<>();
        private final HashSet<String> documentIdPropertyNames = new HashSet<>();

        BeanMapper(Class<T> cls) {
            Constructor<T> constructor;
            this.clazz = cls;
            this.throwOnUnknownProperties = cls.isAnnotationPresent(ThrowOnExtraProperties.class);
            this.warnOnUnknownProperties = !cls.isAnnotationPresent(IgnoreExtraProperties.class);
            try {
                constructor = cls.getDeclaredConstructor(new Class[0]);
                constructor.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                constructor = null;
            }
            this.constructor = constructor;
            for (Method method : cls.getMethods()) {
                if (shouldIncludeGetter(method)) {
                    String propertyName = propertyName(method);
                    addProperty(propertyName);
                    method.setAccessible(true);
                    if (this.getters.containsKey(propertyName)) {
                        throw new RuntimeException("Found conflicting getters for name " + method.getName() + " on class " + cls.getName());
                    }
                    this.getters.put(propertyName, method);
                    applyGetterAnnotations(method);
                }
            }
            for (Field field : cls.getFields()) {
                if (shouldIncludeField(field)) {
                    addProperty(propertyName(field));
                    applyFieldAnnotations(field);
                }
            }
            Class<T> cls2 = cls;
            do {
                for (Method method2 : cls2.getDeclaredMethods()) {
                    if (shouldIncludeSetter(method2)) {
                        String propertyName2 = propertyName(method2);
                        String str = this.properties.get(propertyName2.toLowerCase(Locale.US));
                        if (str == null) {
                            continue;
                        } else {
                            if (!str.equals(propertyName2)) {
                                throw new RuntimeException("Found setter on " + cls2.getName() + " with invalid case-sensitive name: " + method2.getName());
                            }
                            Method method3 = this.setters.get(propertyName2);
                            if (method3 == null) {
                                method2.setAccessible(true);
                                this.setters.put(propertyName2, method2);
                                applySetterAnnotations(method2);
                            } else if (!isSetterOverride(method2, method3)) {
                                if (cls2 == cls) {
                                    throw new RuntimeException("Class " + cls.getName() + " has multiple setter overloads with name " + method2.getName());
                                }
                                throw new RuntimeException("Found conflicting setters with name: " + method2.getName() + " (conflicts with " + method3.getName() + " defined on " + method3.getDeclaringClass().getName() + ")");
                            }
                        }
                    }
                }
                for (Field field2 : cls2.getDeclaredFields()) {
                    String propertyName3 = propertyName(field2);
                    if (this.properties.containsKey(propertyName3.toLowerCase(Locale.US)) && !this.fields.containsKey(propertyName3)) {
                        field2.setAccessible(true);
                        this.fields.put(propertyName3, field2);
                        applyFieldAnnotations(field2);
                    }
                }
                cls2 = cls2.getSuperclass();
                if (cls2 == null) {
                    break;
                }
            } while (!cls2.equals(Object.class));
            if (this.properties.isEmpty()) {
                throw new RuntimeException("No properties to serialize found on class " + cls.getName());
            }
            Iterator<String> it = this.documentIdPropertyNames.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!this.setters.containsKey(next) && !this.fields.containsKey(next)) {
                    throw new RuntimeException("@DocumentId is annotated on property " + next + " of class " + cls.getName() + " but no field or public setter was found");
                }
            }
        }

        private void addProperty(String str) {
            String put = this.properties.put(str.toLowerCase(Locale.US), str);
            if (put == null || str.equals(put)) {
                return;
            }
            throw new RuntimeException("Found two getters or fields with conflicting case sensitivity for property: " + str.toLowerCase(Locale.US));
        }

        private static String annotatedName(AccessibleObject accessibleObject) {
            if (accessibleObject.isAnnotationPresent(PropertyName.class)) {
                return ((PropertyName) accessibleObject.getAnnotation(PropertyName.class)).value();
            }
            return null;
        }

        private void applyFieldAnnotations(Field field) {
            if (field.isAnnotationPresent(ServerTimestamp.class)) {
                Class<?> type = field.getType();
                if (type != Date.class && type != Timestamp.class) {
                    throw new IllegalArgumentException("Field " + field.getName() + " is annotated with @ServerTimestamp but is " + type + " instead of Date or Timestamp.");
                }
                this.serverTimestamps.add(propertyName(field));
            }
            if (field.isAnnotationPresent(DocumentId.class)) {
                ensureValidDocumentIdType("Field", "is", field.getType());
                this.documentIdPropertyNames.add(propertyName(field));
            }
        }

        private void applyGetterAnnotations(Method method) {
            if (method.isAnnotationPresent(ServerTimestamp.class)) {
                Class<?> returnType = method.getReturnType();
                if (returnType != Date.class && returnType != Timestamp.class) {
                    throw new IllegalArgumentException("Method " + method.getName() + " is annotated with @ServerTimestamp but returns " + returnType + " instead of Date or Timestamp.");
                }
                this.serverTimestamps.add(propertyName(method));
            }
            if (method.isAnnotationPresent(DocumentId.class)) {
                ensureValidDocumentIdType("Method", "returns", method.getReturnType());
                this.documentIdPropertyNames.add(propertyName(method));
            }
        }

        private void applySetterAnnotations(Method method) {
            if (method.isAnnotationPresent(ServerTimestamp.class)) {
                throw new IllegalArgumentException("Method " + method.getName() + " is annotated with @ServerTimestamp but should not be. @ServerTimestamp can only be applied to fields and getters, not setters.");
            }
            if (method.isAnnotationPresent(DocumentId.class)) {
                ensureValidDocumentIdType("Method", "accepts", method.getParameterTypes()[0]);
                this.documentIdPropertyNames.add(propertyName(method));
            }
        }

        private void ensureValidDocumentIdType(String str, String str2, Type type) {
            if (type == String.class || type == DocumentReference.class) {
                return;
            }
            throw new IllegalArgumentException(str + " is annotated with @DocumentId but " + str2 + " " + type + " instead of String or DocumentReference.");
        }

        private static boolean isSetterOverride(Method method, Method method2) {
            CustomClassMapper.hardAssert(method.getDeclaringClass().isAssignableFrom(method2.getDeclaringClass()), "Expected override from a base class");
            CustomClassMapper.hardAssert(method.getReturnType().equals(Void.TYPE), "Expected void return type");
            CustomClassMapper.hardAssert(method2.getReturnType().equals(Void.TYPE), "Expected void return type");
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?>[] parameterTypes2 = method2.getParameterTypes();
            CustomClassMapper.hardAssert(parameterTypes.length == 1, "Expected exactly one parameter");
            CustomClassMapper.hardAssert(parameterTypes2.length == 1, "Expected exactly one parameter");
            return method.getName().equals(method2.getName()) && parameterTypes[0].equals(parameterTypes2[0]);
        }

        private void populateDocumentIdProperties(Map<TypeVariable<Class<T>>, Type> map, DeserializeContext deserializeContext, T t, HashSet<String> hashSet) {
            Iterator<String> it = this.documentIdPropertyNames.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (hashSet.contains(next)) {
                    throw new RuntimeException("'" + next + "' was found from document " + deserializeContext.b.getPath() + ", cannot apply @DocumentId on this property for class " + this.clazz.getName());
                }
                ErrorPath a = deserializeContext.a.a(next);
                if (this.setters.containsKey(next)) {
                    Method method = this.setters.get(next);
                    Type[] genericParameterTypes = method.getGenericParameterTypes();
                    if (genericParameterTypes.length != 1) {
                        throw CustomClassMapper.deserializeError(a, "Setter does not have exactly one parameter");
                    }
                    if (resolveType(genericParameterTypes[0], map) == String.class) {
                        ApiUtil.a(method, t, deserializeContext.b.getId());
                    } else {
                        ApiUtil.a(method, t, deserializeContext.b);
                    }
                } else {
                    Field field = this.fields.get(next);
                    try {
                        field.set(t, field.getType() == String.class ? deserializeContext.b.getId() : deserializeContext.b);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String propertyName(Field field) {
            String annotatedName = annotatedName(field);
            return annotatedName != null ? annotatedName : field.getName();
        }

        private static String propertyName(Method method) {
            String annotatedName = annotatedName(method);
            return annotatedName != null ? annotatedName : serializedName(method.getName());
        }

        private Type resolveType(Type type, Map<TypeVariable<Class<T>>, Type> map) {
            if (!(type instanceof TypeVariable)) {
                return type;
            }
            Type type2 = map.get(type);
            if (type2 != null) {
                return type2;
            }
            throw new IllegalStateException("Could not resolve type " + type);
        }

        private static String serializedName(String str) {
            String str2 = null;
            for (String str3 : new String[]{"get", "set", "is"}) {
                if (str.startsWith(str3)) {
                    str2 = str3;
                }
            }
            if (str2 == null) {
                throw new IllegalArgumentException("Unknown Bean prefix for method: " + str);
            }
            char[] charArray = str.substring(str2.length()).toCharArray();
            for (int i = 0; i < charArray.length && Character.isUpperCase(charArray[i]); i++) {
                charArray[i] = Character.toLowerCase(charArray[i]);
            }
            return new String(charArray);
        }

        private static boolean shouldIncludeField(Field field) {
            return (field.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(field.getModifiers()) || Modifier.isStatic(field.getModifiers()) || Modifier.isTransient(field.getModifiers()) || field.isAnnotationPresent(Exclude.class)) ? false : true;
        }

        private static boolean shouldIncludeGetter(Method method) {
            return ((!method.getName().startsWith("get") && !method.getName().startsWith("is")) || method.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(method.getModifiers()) || Modifier.isStatic(method.getModifiers()) || method.getReturnType().equals(Void.TYPE) || method.getParameterTypes().length != 0 || method.isAnnotationPresent(Exclude.class)) ? false : true;
        }

        private static boolean shouldIncludeSetter(Method method) {
            return method.getName().startsWith("set") && !method.getDeclaringClass().equals(Object.class) && !Modifier.isStatic(method.getModifiers()) && method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 1 && !method.isAnnotationPresent(Exclude.class);
        }

        T a(Map<String, Object> map, DeserializeContext deserializeContext) {
            return a(map, Collections.emptyMap(), deserializeContext);
        }

        T a(Map<String, Object> map, Map<TypeVariable<Class<T>>, Type> map2, DeserializeContext deserializeContext) {
            Constructor<T> constructor = this.constructor;
            if (constructor == null) {
                throw CustomClassMapper.deserializeError(deserializeContext.a, "Class " + this.clazz.getName() + " does not define a no-argument constructor. If you are using ProGuard, make sure these constructors are not stripped");
            }
            T t = (T) ApiUtil.a(constructor);
            HashSet<String> hashSet = new HashSet<>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                ErrorPath a = deserializeContext.a.a(key);
                if (this.setters.containsKey(key)) {
                    Method method = this.setters.get(key);
                    Type[] genericParameterTypes = method.getGenericParameterTypes();
                    if (genericParameterTypes.length != 1) {
                        throw CustomClassMapper.deserializeError(a, "Setter does not have exactly one parameter");
                    }
                    ApiUtil.a(method, t, CustomClassMapper.deserializeToType(entry.getValue(), resolveType(genericParameterTypes[0], map2), deserializeContext.a(a)));
                } else if (this.fields.containsKey(key)) {
                    Field field = this.fields.get(key);
                    try {
                        field.set(t, CustomClassMapper.deserializeToType(entry.getValue(), resolveType(field.getGenericType(), map2), deserializeContext.a(a)));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    String str = "No setter/field for " + key + " found on class " + this.clazz.getName();
                    if (this.properties.containsKey(key.toLowerCase(Locale.US))) {
                        str = str + " (fields/setters are case sensitive!)";
                    }
                    if (this.throwOnUnknownProperties) {
                        throw new RuntimeException(str);
                    }
                    if (this.warnOnUnknownProperties) {
                        Logger.warn(CustomClassMapper.class.getSimpleName(), "%s", str);
                    }
                }
                hashSet.add(key);
            }
            populateDocumentIdProperties(map2, deserializeContext, t, hashSet);
            return t;
        }

        Map<String, Object> a(T t, ErrorPath errorPath) {
            Object obj;
            if (!this.clazz.isAssignableFrom(t.getClass())) {
                throw new IllegalArgumentException("Can't serialize object of class " + t.getClass() + " with BeanMapper for class " + this.clazz);
            }
            HashMap hashMap = new HashMap();
            for (String str : this.properties.values()) {
                if (!this.documentIdPropertyNames.contains(str)) {
                    if (this.getters.containsKey(str)) {
                        obj = ApiUtil.a(this.getters.get(str), t, new Object[0]);
                    } else {
                        Field field = this.fields.get(str);
                        if (field == null) {
                            throw new IllegalStateException("Bean property without field or getter: " + str);
                        }
                        try {
                            obj = field.get(t);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    hashMap.put(str, (this.serverTimestamps.contains(str) && obj == null) ? FieldValue.serverTimestamp() : CustomClassMapper.serialize(obj, errorPath.a(str)));
                }
            }
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class DeserializeContext {
        final ErrorPath a;
        final DocumentReference b;

        DeserializeContext(ErrorPath errorPath, DocumentReference documentReference) {
            this.a = errorPath;
            this.b = documentReference;
        }

        DeserializeContext a(ErrorPath errorPath) {
            return new DeserializeContext(errorPath, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ErrorPath {
        static final ErrorPath a = new ErrorPath(null, null, 0);
        private final int length;
        private final String name;
        private final ErrorPath parent;

        ErrorPath(ErrorPath errorPath, String str, int i) {
            this.parent = errorPath;
            this.name = str;
            this.length = i;
        }

        int a() {
            return this.length;
        }

        ErrorPath a(String str) {
            return new ErrorPath(this, str, this.length + 1);
        }

        public String toString() {
            int i = this.length;
            if (i == 0) {
                return "";
            }
            if (i == 1) {
                return this.name;
            }
            return this.parent.toString() + "." + this.name;
        }
    }

    private static <T> T convertBean(Object obj, Class<T> cls, DeserializeContext deserializeContext) {
        BeanMapper loadOrCreateBeanMapperForClass = loadOrCreateBeanMapperForClass(cls);
        if (obj instanceof Map) {
            return (T) loadOrCreateBeanMapperForClass.a(expectMap(obj, deserializeContext), deserializeContext);
        }
        throw deserializeError(deserializeContext.a, "Can't convert object of type " + obj.getClass().getName() + " to type " + cls.getName());
    }

    private static Blob convertBlob(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof Blob) {
            return (Blob) obj;
        }
        throw deserializeError(deserializeContext.a, "Failed to convert value of type " + obj.getClass().getName() + " to Blob");
    }

    private static Boolean convertBoolean(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        throw deserializeError(deserializeContext.a, "Failed to convert value of type " + obj.getClass().getName() + " to boolean");
    }

    private static Date convertDate(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Timestamp) {
            return ((Timestamp) obj).toDate();
        }
        throw deserializeError(deserializeContext.a, "Failed to convert value of type " + obj.getClass().getName() + " to Date");
    }

    private static DocumentReference convertDocumentReference(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof DocumentReference) {
            return (DocumentReference) obj;
        }
        throw deserializeError(deserializeContext.a, "Failed to convert value of type " + obj.getClass().getName() + " to DocumentReference");
    }

    private static Double convertDouble(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        }
        if (!(obj instanceof Long)) {
            if (obj instanceof Double) {
                return (Double) obj;
            }
            throw deserializeError(deserializeContext.a, "Failed to convert a value of type " + obj.getClass().getName() + " to double");
        }
        Long l = (Long) obj;
        Double valueOf = Double.valueOf(l.doubleValue());
        if (valueOf.longValue() == l.longValue()) {
            return valueOf;
        }
        throw deserializeError(deserializeContext.a, "Loss of precision while converting number to double: " + obj + ". Did you mean to use a 64-bit long instead?");
    }

    private static GeoPoint convertGeoPoint(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof GeoPoint) {
            return (GeoPoint) obj;
        }
        throw deserializeError(deserializeContext.a, "Failed to convert value of type " + obj.getClass().getName() + " to GeoPoint");
    }

    private static Integer convertInteger(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (!(obj instanceof Long) && !(obj instanceof Double)) {
            throw deserializeError(deserializeContext.a, "Failed to convert a value of type " + obj.getClass().getName() + " to int");
        }
        Number number = (Number) obj;
        double doubleValue = number.doubleValue();
        if (doubleValue >= -2.147483648E9d && doubleValue <= 2.147483647E9d) {
            return Integer.valueOf(number.intValue());
        }
        throw deserializeError(deserializeContext.a, "Numeric value out of 32-bit integer range: " + doubleValue + ". Did you mean to use a long or double instead of an int?");
    }

    private static Long convertLong(Object obj, DeserializeContext deserializeContext) {
        long longValue;
        if (obj instanceof Integer) {
            longValue = ((Integer) obj).longValue();
        } else {
            if (obj instanceof Long) {
                return (Long) obj;
            }
            if (!(obj instanceof Double)) {
                throw deserializeError(deserializeContext.a, "Failed to convert a value of type " + obj.getClass().getName() + " to long");
            }
            Double d = (Double) obj;
            if (d.doubleValue() < -9.223372036854776E18d || d.doubleValue() > 9.223372036854776E18d) {
                throw deserializeError(deserializeContext.a, "Numeric value out of 64-bit long range: " + d + ". Did you mean to use a double instead of a long?");
            }
            longValue = d.longValue();
        }
        return Long.valueOf(longValue);
    }

    private static String convertString(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof String) {
            return (String) obj;
        }
        throw deserializeError(deserializeContext.a, "Failed to convert value of type " + obj.getClass().getName() + " to String");
    }

    private static Timestamp convertTimestamp(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof Timestamp) {
            return (Timestamp) obj;
        }
        if (obj instanceof Date) {
            return new Timestamp((Date) obj);
        }
        throw deserializeError(deserializeContext.a, "Failed to convert value of type " + obj.getClass().getName() + " to Timestamp");
    }

    public static <T> T convertToCustomClass(Object obj, Class<T> cls, DocumentReference documentReference) {
        return (T) deserializeToClass(obj, cls, new DeserializeContext(ErrorPath.a, documentReference));
    }

    public static Object convertToPlainJavaTypes(Object obj) {
        return serialize(obj);
    }

    public static Map<String, Object> convertToPlainJavaTypes(Map<?, Object> map) {
        Object serialize = serialize(map);
        hardAssert(serialize instanceof Map);
        return (Map) serialize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RuntimeException deserializeError(ErrorPath errorPath, String str) {
        String str2 = "Could not deserialize object. " + str;
        if (errorPath.a() > 0) {
            str2 = str2 + " (found in field '" + errorPath.toString() + "')";
        }
        return new RuntimeException(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T deserializeToClass(Object obj, Class<T> cls, DeserializeContext deserializeContext) {
        if (obj == 0) {
            return null;
        }
        if (cls.isPrimitive() || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls) || Character.class.isAssignableFrom(cls)) {
            return (T) deserializeToPrimitive(obj, cls, deserializeContext);
        }
        if (String.class.isAssignableFrom(cls)) {
            return (T) convertString(obj, deserializeContext);
        }
        if (Date.class.isAssignableFrom(cls)) {
            return (T) convertDate(obj, deserializeContext);
        }
        if (Timestamp.class.isAssignableFrom(cls)) {
            return (T) convertTimestamp(obj, deserializeContext);
        }
        if (Blob.class.isAssignableFrom(cls)) {
            return (T) convertBlob(obj, deserializeContext);
        }
        if (GeoPoint.class.isAssignableFrom(cls)) {
            return (T) convertGeoPoint(obj, deserializeContext);
        }
        if (DocumentReference.class.isAssignableFrom(cls)) {
            return (T) convertDocumentReference(obj, deserializeContext);
        }
        if (cls.isArray()) {
            throw deserializeError(deserializeContext.a, "Converting to Arrays is not supported, please use Lists instead");
        }
        if (cls.getTypeParameters().length <= 0) {
            return cls.equals(Object.class) ? obj : cls.isEnum() ? (T) deserializeToEnum(obj, cls, deserializeContext) : (T) convertBean(obj, cls, deserializeContext);
        }
        throw deserializeError(deserializeContext.a, "Class " + cls.getName() + " has generic type parameters, please use GenericTypeIndicator instead");
    }

    private static <T> T deserializeToEnum(Object obj, Class<T> cls, DeserializeContext deserializeContext) {
        if (!(obj instanceof String)) {
            throw deserializeError(deserializeContext.a, "Expected a String while deserializing to enum " + cls + " but got a " + obj.getClass());
        }
        String str = (String) obj;
        for (Field field : cls.getFields()) {
            if (field.isEnumConstant() && str.equals(BeanMapper.propertyName(field))) {
                str = field.getName();
                break;
            }
        }
        try {
            return (T) Enum.valueOf(cls, str);
        } catch (IllegalArgumentException unused) {
            throw deserializeError(deserializeContext.a, "Could not find enum value of " + cls.getName() + " for value \"" + str + "\"");
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.List, T, java.util.ArrayList] */
    private static <T> T deserializeToParameterizedType(Object obj, ParameterizedType parameterizedType, DeserializeContext deserializeContext) {
        Class cls = (Class) parameterizedType.getRawType();
        int i = 0;
        if (List.class.isAssignableFrom(cls)) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (!(obj instanceof List)) {
                throw deserializeError(deserializeContext.a, "Expected a List, but got a " + obj.getClass());
            }
            List list = (List) obj;
            ?? r0 = (T) new ArrayList(list.size());
            while (i < list.size()) {
                r0.add(deserializeToType(list.get(i), type, deserializeContext.a(deserializeContext.a.a("[" + i + "]"))));
                i++;
            }
            return r0;
        }
        if (!Map.class.isAssignableFrom(cls)) {
            if (Collection.class.isAssignableFrom(cls)) {
                throw deserializeError(deserializeContext.a, "Collections are not supported, please use Lists instead");
            }
            Map<String, Object> expectMap = expectMap(obj, deserializeContext);
            BeanMapper loadOrCreateBeanMapperForClass = loadOrCreateBeanMapperForClass(cls);
            HashMap hashMap = new HashMap();
            TypeVariable<Class<T>>[] typeParameters = loadOrCreateBeanMapperForClass.clazz.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments.length != typeParameters.length) {
                throw new IllegalStateException("Mismatched lengths for type variables and actual types");
            }
            while (i < typeParameters.length) {
                hashMap.put(typeParameters[i], actualTypeArguments[i]);
                i++;
            }
            return (T) loadOrCreateBeanMapperForClass.a(expectMap, hashMap, deserializeContext);
        }
        Type type2 = parameterizedType.getActualTypeArguments()[0];
        Type type3 = parameterizedType.getActualTypeArguments()[1];
        if (!type2.equals(String.class)) {
            throw deserializeError(deserializeContext.a, "Only Maps with string keys are supported, but found Map with key type " + type2);
        }
        Map<String, Object> expectMap2 = expectMap(obj, deserializeContext);
        ?? r02 = (T) new HashMap();
        for (Map.Entry<String, Object> entry : expectMap2.entrySet()) {
            r02.put(entry.getKey(), deserializeToType(entry.getValue(), type3, deserializeContext.a(deserializeContext.a.a(entry.getKey()))));
        }
        return r02;
    }

    private static <T> T deserializeToPrimitive(Object obj, Class<T> cls, DeserializeContext deserializeContext) {
        if (Integer.class.isAssignableFrom(cls) || Integer.TYPE.isAssignableFrom(cls)) {
            return (T) convertInteger(obj, deserializeContext);
        }
        if (Boolean.class.isAssignableFrom(cls) || Boolean.TYPE.isAssignableFrom(cls)) {
            return (T) convertBoolean(obj, deserializeContext);
        }
        if (Double.class.isAssignableFrom(cls) || Double.TYPE.isAssignableFrom(cls)) {
            return (T) convertDouble(obj, deserializeContext);
        }
        if (Long.class.isAssignableFrom(cls) || Long.TYPE.isAssignableFrom(cls)) {
            return (T) convertLong(obj, deserializeContext);
        }
        if (Float.class.isAssignableFrom(cls) || Float.TYPE.isAssignableFrom(cls)) {
            return (T) Float.valueOf(convertDouble(obj, deserializeContext).floatValue());
        }
        throw deserializeError(deserializeContext.a, String.format("Deserializing values to %s is not supported", cls.getSimpleName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T deserializeToType(Object obj, Type type, DeserializeContext deserializeContext) {
        if (obj == null) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return (T) deserializeToParameterizedType(obj, (ParameterizedType) type, deserializeContext);
        }
        if (type instanceof Class) {
            return (T) deserializeToClass(obj, (Class) type, deserializeContext);
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length > 0) {
                throw deserializeError(deserializeContext.a, "Generic lower-bounded wildcard types are not supported");
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            hardAssert(upperBounds.length > 0, "Unexpected type bounds on wildcard " + type);
            return (T) deserializeToType(obj, upperBounds[0], deserializeContext);
        }
        if (type instanceof TypeVariable) {
            Type[] bounds = ((TypeVariable) type).getBounds();
            hardAssert(bounds.length > 0, "Unexpected type bounds on type variable " + type);
            return (T) deserializeToType(obj, bounds[0], deserializeContext);
        }
        if (type instanceof GenericArrayType) {
            throw deserializeError(deserializeContext.a, "Generic Arrays are not supported, please use Lists instead");
        }
        throw deserializeError(deserializeContext.a, "Unknown type encountered: " + type);
    }

    private static Map<String, Object> expectMap(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof Map) {
            return (Map) obj;
        }
        throw deserializeError(deserializeContext.a, "Expected a Map while deserializing, but got a " + obj.getClass());
    }

    private static void hardAssert(boolean z) {
        hardAssert(z, "Internal inconsistency");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hardAssert(boolean z, String str) {
        if (z) {
            return;
        }
        throw new RuntimeException("Hard assert failed: " + str);
    }

    private static <T> BeanMapper<T> loadOrCreateBeanMapperForClass(Class<T> cls) {
        BeanMapper<T> beanMapper = (BeanMapper) mappers.get(cls);
        if (beanMapper != null) {
            return beanMapper;
        }
        BeanMapper<T> beanMapper2 = new BeanMapper<>(cls);
        mappers.put(cls, beanMapper2);
        return beanMapper2;
    }

    private static <T> Object serialize(T t) {
        return serialize(t, ErrorPath.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Object serialize(T t, ErrorPath errorPath) {
        if (errorPath.a() > 500) {
            throw serializeError(errorPath, "Exceeded maximum depth of 500, which likely indicates there's an object cycle");
        }
        if (t == 0) {
            return null;
        }
        if (t instanceof Number) {
            if ((t instanceof Long) || (t instanceof Integer) || (t instanceof Double) || (t instanceof Float)) {
                return t;
            }
            throw serializeError(errorPath, String.format("Numbers of type %s are not supported, please use an int, long, float or double", t.getClass().getSimpleName()));
        }
        if ((t instanceof String) || (t instanceof Boolean)) {
            return t;
        }
        if (t instanceof Character) {
            throw serializeError(errorPath, "Characters are not supported, please use Strings");
        }
        if (t instanceof Map) {
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : ((Map) t).entrySet()) {
                Object key = entry.getKey();
                if (!(key instanceof String)) {
                    throw serializeError(errorPath, "Maps with non-string keys are not supported");
                }
                String str = (String) key;
                hashMap.put(str, serialize(entry.getValue(), errorPath.a(str)));
            }
            return hashMap;
        }
        if (!(t instanceof Collection)) {
            if (t.getClass().isArray()) {
                throw serializeError(errorPath, "Serializing Arrays is not supported, please use Lists instead");
            }
            if (!(t instanceof Enum)) {
                return ((t instanceof Date) || (t instanceof Timestamp) || (t instanceof GeoPoint) || (t instanceof Blob) || (t instanceof DocumentReference) || (t instanceof FieldValue)) ? t : loadOrCreateBeanMapperForClass(t.getClass()).a((BeanMapper) t, errorPath);
            }
            String name = ((Enum) t).name();
            try {
                return BeanMapper.propertyName(t.getClass().getField(name));
            } catch (NoSuchFieldException unused) {
                return name;
            }
        }
        if (!(t instanceof List)) {
            throw serializeError(errorPath, "Serializing Collections is not supported, please use Lists instead");
        }
        List list = (List) t;
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(serialize(list.get(i), errorPath.a("[" + i + "]")));
        }
        return arrayList;
    }

    private static IllegalArgumentException serializeError(ErrorPath errorPath, String str) {
        String str2 = "Could not serialize object. " + str;
        if (errorPath.a() > 0) {
            str2 = str2 + " (found in field '" + errorPath.toString() + "')";
        }
        return new IllegalArgumentException(str2);
    }
}
