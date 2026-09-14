package org.apache.tika.config;

import F0.AbstractC0008a;
import e0.a;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.tika.exception.TikaConfigException;

/* loaded from: classes.dex */
public class ParamField {
    public static final String DEFAULT = "#default";
    private static final Map<Class<?>, Class<?>> PRIMITIVE_MAP = new HashMap<Class<?>, Class<?>>() { // from class: org.apache.tika.config.ParamField.1
        {
            put(Integer.TYPE, Integer.class);
            put(Short.TYPE, Short.class);
            put(Boolean.TYPE, Boolean.class);
            put(Long.TYPE, Long.class);
            put(Float.TYPE, Float.class);
            put(Double.TYPE, Double.class);
        }
    };
    private java.lang.reflect.Field field;
    private final String name;
    private final boolean required;
    private Method setter;
    private final Class<?> type;

    public ParamField(AccessibleObject accessibleObject) {
        if (accessibleObject instanceof java.lang.reflect.Field) {
            this.field = (java.lang.reflect.Field) accessibleObject;
        } else {
            this.setter = (Method) accessibleObject;
        }
        Field field = (Field) accessibleObject.getAnnotation(Field.class);
        this.required = field.required();
        this.name = retrieveParamName(field);
        this.type = retrieveType();
    }

    private String retrieveParamName(Field field) {
        if (field.name().equals(DEFAULT)) {
            java.lang.reflect.Field field2 = this.field;
            if (field2 != null) {
                return field2.getName();
            }
            String name = this.setter.getName();
            if (name.startsWith("set") && name.length() > 3) {
                return AbstractC0008a.n(name.substring(3, 4).toLowerCase(Locale.ROOT), name.substring(4));
            }
            return this.setter.getName();
        }
        return field.name();
    }

    private Class retrieveType() {
        Class<?> cls;
        String str;
        java.lang.reflect.Field field = this.field;
        if (field != null) {
            cls = field.getType();
        } else {
            Class<?>[] parameterTypes = this.setter.getParameterTypes();
            if (parameterTypes.length != 1) {
                if (this.setter.getName().startsWith("get")) {
                    str = a.e("Invalid setter method. Must have one and only one parameter. Perhaps the annotation is misplaced on ", this.setter.getName(), " while a set'X' is expected?");
                } else {
                    str = "Invalid setter method. Must have one and only one parameter. ";
                }
                throw new TikaConfigException(str);
            }
            cls = parameterTypes[0];
        }
        if (cls.isPrimitive()) {
            Map<Class<?>, Class<?>> map = PRIMITIVE_MAP;
            if (map.containsKey(cls)) {
                return map.get(cls);
            }
            return cls;
        }
        return cls;
    }

    public void assignValue(Object obj, Object obj2) {
        java.lang.reflect.Field field = this.field;
        if (field != null) {
            field.set(obj, obj2);
        } else {
            this.setter.invoke(obj, obj2);
        }
    }

    public java.lang.reflect.Field getField() {
        return this.field;
    }

    public String getName() {
        return this.name;
    }

    public Method getSetter() {
        return this.setter;
    }

    public Class<?> getType() {
        return this.type;
    }

    public boolean isRequired() {
        return this.required;
    }

    public String toString() {
        return "ParamField{name='" + this.name + "', type=" + this.type + ", required=" + this.required + "}";
    }
}
