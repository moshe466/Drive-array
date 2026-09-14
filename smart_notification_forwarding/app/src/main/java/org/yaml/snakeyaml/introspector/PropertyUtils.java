package org.yaml.snakeyaml.introspector;

import java.beans.FeatureDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.util.PlatformFeatureDetector;

/* loaded from: classes2.dex */
public class PropertyUtils {
    private static final String TRANSIENT = "transient";
    private boolean allowReadOnlyProperties;
    private BeanAccess beanAccess;
    private PlatformFeatureDetector platformFeatureDetector;
    private final Map<Class<?>, Map<String, Property>> propertiesCache;
    private final Map<Class<?>, Set<Property>> readableProperties;
    private boolean skipMissingProperties;

    public PropertyUtils() {
        this(new PlatformFeatureDetector());
    }

    PropertyUtils(PlatformFeatureDetector platformFeatureDetector) {
        this.propertiesCache = new HashMap();
        this.readableProperties = new HashMap();
        this.beanAccess = BeanAccess.DEFAULT;
        this.allowReadOnlyProperties = false;
        this.skipMissingProperties = false;
        this.platformFeatureDetector = platformFeatureDetector;
        if (platformFeatureDetector.isRunningOnAndroid()) {
            this.beanAccess = BeanAccess.FIELD;
        }
    }

    protected Map<String, Property> getPropertiesMap(Class<?> cls, BeanAccess beanAccess) {
        if (this.propertiesCache.containsKey(cls)) {
            return this.propertiesCache.get(cls);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean z = false;
        if (AnonymousClass1.$SwitchMap$org$yaml$snakeyaml$introspector$BeanAccess[beanAccess.ordinal()] != 1) {
            try {
                for (PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(cls).getPropertyDescriptors()) {
                    Method readMethod = propertyDescriptor.getReadMethod();
                    if ((readMethod == null || !readMethod.getName().equals("getClass")) && !isTransient(propertyDescriptor)) {
                        linkedHashMap.put(propertyDescriptor.getName(), new MethodProperty(propertyDescriptor));
                    }
                }
                boolean z2 = false;
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    for (Field field : cls2.getDeclaredFields()) {
                        int modifiers = field.getModifiers();
                        if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers)) {
                            if (Modifier.isPublic(modifiers)) {
                                linkedHashMap.put(field.getName(), new FieldProperty(field));
                            } else {
                                z2 = true;
                            }
                        }
                    }
                }
                z = z2;
            } catch (IntrospectionException e) {
                throw new YAMLException((Throwable) e);
            }
        } else {
            for (Class<?> cls3 = cls; cls3 != null; cls3 = cls3.getSuperclass()) {
                for (Field field2 : cls3.getDeclaredFields()) {
                    int modifiers2 = field2.getModifiers();
                    if (!Modifier.isStatic(modifiers2) && !Modifier.isTransient(modifiers2) && !linkedHashMap.containsKey(field2.getName())) {
                        linkedHashMap.put(field2.getName(), new FieldProperty(field2));
                    }
                }
            }
        }
        if (linkedHashMap.isEmpty() && z) {
            throw new YAMLException("No JavaBean properties found in " + cls.getName());
        }
        this.propertiesCache.put(cls, linkedHashMap);
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.yaml.snakeyaml.introspector.PropertyUtils$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$yaml$snakeyaml$introspector$BeanAccess;

        static {
            int[] iArr = new int[BeanAccess.values().length];
            $SwitchMap$org$yaml$snakeyaml$introspector$BeanAccess = iArr;
            try {
                iArr[BeanAccess.FIELD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private boolean isTransient(FeatureDescriptor featureDescriptor) {
        return Boolean.TRUE.equals(featureDescriptor.getValue(TRANSIENT));
    }

    public Set<Property> getProperties(Class<? extends Object> cls) {
        return getProperties(cls, this.beanAccess);
    }

    public Set<Property> getProperties(Class<? extends Object> cls, BeanAccess beanAccess) {
        if (this.readableProperties.containsKey(cls)) {
            return this.readableProperties.get(cls);
        }
        Set<Property> createPropertySet = createPropertySet(cls, beanAccess);
        this.readableProperties.put(cls, createPropertySet);
        return createPropertySet;
    }

    protected Set<Property> createPropertySet(Class<? extends Object> cls, BeanAccess beanAccess) {
        TreeSet treeSet = new TreeSet();
        for (Property property : getPropertiesMap(cls, beanAccess).values()) {
            if (property.isReadable() && (this.allowReadOnlyProperties || property.isWritable())) {
                treeSet.add(property);
            }
        }
        return treeSet;
    }

    public Property getProperty(Class<? extends Object> cls, String str) {
        return getProperty(cls, str, this.beanAccess);
    }

    public Property getProperty(Class<? extends Object> cls, String str, BeanAccess beanAccess) {
        Property property = getPropertiesMap(cls, beanAccess).get(str);
        if (property == null && this.skipMissingProperties) {
            property = new MissingProperty(str);
        }
        if (property != null) {
            return property;
        }
        throw new YAMLException("Unable to find property '" + str + "' on class: " + cls.getName());
    }

    public void setBeanAccess(BeanAccess beanAccess) {
        if (this.platformFeatureDetector.isRunningOnAndroid() && beanAccess != BeanAccess.FIELD) {
            throw new IllegalArgumentException("JVM is Android - only BeanAccess.FIELD is available");
        }
        if (this.beanAccess != beanAccess) {
            this.beanAccess = beanAccess;
            this.propertiesCache.clear();
            this.readableProperties.clear();
        }
    }

    public void setAllowReadOnlyProperties(boolean z) {
        if (this.allowReadOnlyProperties != z) {
            this.allowReadOnlyProperties = z;
            this.readableProperties.clear();
        }
    }

    public boolean isAllowReadOnlyProperties() {
        return this.allowReadOnlyProperties;
    }

    public void setSkipMissingProperties(boolean z) {
        if (this.skipMissingProperties != z) {
            this.skipMissingProperties = z;
            this.readableProperties.clear();
        }
    }

    public boolean isSkipMissingProperties() {
        return this.skipMissingProperties;
    }
}
