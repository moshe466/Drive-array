package org.yaml.snakeyaml.constructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes2.dex */
public class Constructor extends SafeConstructor {
    public Constructor() {
        this((Class<? extends Object>) Object.class);
    }

    public Constructor(LoaderOptions loaderOptions) {
        this((Class<? extends Object>) Object.class, loaderOptions);
    }

    public Constructor(Class<? extends Object> cls) {
        this(new TypeDescription(checkRoot(cls)));
    }

    public Constructor(Class<? extends Object> cls, LoaderOptions loaderOptions) {
        this(new TypeDescription(checkRoot(cls)), loaderOptions);
    }

    private static Class<? extends Object> checkRoot(Class<? extends Object> cls) {
        if (cls != null) {
            return cls;
        }
        throw new NullPointerException("Root class must be provided.");
    }

    public Constructor(TypeDescription typeDescription) {
        this(typeDescription, null, new LoaderOptions());
    }

    public Constructor(TypeDescription typeDescription, LoaderOptions loaderOptions) {
        this(typeDescription, null, loaderOptions);
    }

    public Constructor(TypeDescription typeDescription, Collection<TypeDescription> collection) {
        this(typeDescription, collection, new LoaderOptions());
    }

    public Constructor(TypeDescription typeDescription, Collection<TypeDescription> collection, LoaderOptions loaderOptions) {
        super(loaderOptions);
        if (typeDescription == null) {
            throw new NullPointerException("Root type must be provided.");
        }
        this.yamlConstructors.put(null, new ConstructYamlObject());
        if (!Object.class.equals(typeDescription.getType())) {
            this.rootTag = new Tag(typeDescription.getType());
        }
        this.yamlClassConstructors.put(NodeId.scalar, new ConstructScalar());
        this.yamlClassConstructors.put(NodeId.mapping, new ConstructMapping());
        this.yamlClassConstructors.put(NodeId.sequence, new ConstructSequence());
        addTypeDescription(typeDescription);
        if (collection != null) {
            Iterator<TypeDescription> it = collection.iterator();
            while (it.hasNext()) {
                addTypeDescription(it.next());
            }
        }
    }

    public Constructor(String str) throws ClassNotFoundException {
        this((Class<? extends Object>) Class.forName(check(str)));
    }

    public Constructor(String str, LoaderOptions loaderOptions) throws ClassNotFoundException {
        this((Class<? extends Object>) Class.forName(check(str)), loaderOptions);
    }

    private static final String check(String str) {
        if (str == null) {
            throw new NullPointerException("Root type must be provided.");
        }
        if (str.trim().length() != 0) {
            return str;
        }
        throw new YAMLException("Root type must be provided.");
    }

    /* loaded from: classes2.dex */
    protected class ConstructMapping implements Construct {
        /* JADX INFO: Access modifiers changed from: protected */
        public ConstructMapping() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            MappingNode mappingNode = (MappingNode) node;
            if (Map.class.isAssignableFrom(node.getType())) {
                if (node.isTwoStepsConstruction()) {
                    return Constructor.this.newMap(mappingNode);
                }
                return Constructor.this.constructMapping(mappingNode);
            }
            if (Collection.class.isAssignableFrom(node.getType())) {
                if (node.isTwoStepsConstruction()) {
                    return Constructor.this.newSet(mappingNode);
                }
                return Constructor.this.constructSet(mappingNode);
            }
            Object newInstance = Constructor.this.newInstance(mappingNode);
            if (newInstance != BaseConstructor.NOT_INSTANTIATED_OBJECT) {
                return node.isTwoStepsConstruction() ? newInstance : constructJavaBean2ndStep(mappingNode, newInstance);
            }
            throw new ConstructorException(null, null, "Can't create an instance for " + mappingNode.getTag(), node.getStartMark());
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            if (Map.class.isAssignableFrom(node.getType())) {
                Constructor.this.constructMapping2ndStep((MappingNode) node, (Map) obj);
            } else if (Set.class.isAssignableFrom(node.getType())) {
                Constructor.this.constructSet2ndStep((MappingNode) node, (Set) obj);
            } else {
                constructJavaBean2ndStep((MappingNode) node, obj);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        public Object constructJavaBean2ndStep(MappingNode mappingNode, Object obj) {
            Property property;
            Object constructObject;
            Class<?>[] actualTypeArguments;
            Constructor.this.flattenMapping(mappingNode, true);
            Class<? extends Object> type = mappingNode.getType();
            for (NodeTuple nodeTuple : mappingNode.getValue()) {
                Node valueNode = nodeTuple.getValueNode();
                String str = (String) Constructor.this.constructObject(nodeTuple.getKeyNode());
                try {
                    TypeDescription typeDescription = Constructor.this.typeDefinitions.get(type);
                    if (typeDescription == null) {
                        property = getProperty(type, str);
                    } else {
                        property = typeDescription.getProperty(str);
                    }
                    if (!property.isWritable()) {
                        throw new YAMLException("No writable property '" + str + "' on class: " + type.getName());
                    }
                    valueNode.setType(property.getType());
                    if (!(typeDescription != null ? typeDescription.setupPropertyType(str, valueNode) : false) && valueNode.getNodeId() != NodeId.scalar && (actualTypeArguments = property.getActualTypeArguments()) != null && actualTypeArguments.length > 0) {
                        if (valueNode.getNodeId() == NodeId.sequence) {
                            ((SequenceNode) valueNode).setListType(actualTypeArguments[0]);
                        } else if (Map.class.isAssignableFrom(valueNode.getType())) {
                            MappingNode mappingNode2 = (MappingNode) valueNode;
                            mappingNode2.setTypes(actualTypeArguments[0], actualTypeArguments[1]);
                            mappingNode2.setUseClassConstructor(true);
                        } else if (Collection.class.isAssignableFrom(valueNode.getType())) {
                            Class<?> cls = actualTypeArguments[0];
                            MappingNode mappingNode3 = (MappingNode) valueNode;
                            mappingNode3.setOnlyKeyType(cls);
                            mappingNode3.setUseClassConstructor(true);
                        }
                    }
                    if (typeDescription != null) {
                        constructObject = newInstance(typeDescription, str, valueNode);
                    } else {
                        constructObject = Constructor.this.constructObject(valueNode);
                    }
                    if ((property.getType() == Float.TYPE || property.getType() == Float.class) && (constructObject instanceof Double)) {
                        constructObject = Float.valueOf(((Double) constructObject).floatValue());
                    }
                    if (property.getType() == String.class && Tag.BINARY.equals(valueNode.getTag()) && (constructObject instanceof byte[])) {
                        constructObject = new String((byte[]) constructObject);
                    }
                    if (typeDescription == null || !typeDescription.setProperty(obj, str, constructObject)) {
                        property.set(obj, constructObject);
                    }
                } catch (DuplicateKeyException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new ConstructorException("Cannot create property=" + str + " for JavaBean=" + obj, mappingNode.getStartMark(), e2.getMessage(), valueNode.getStartMark(), e2);
                }
            }
            return obj;
        }

        private Object newInstance(TypeDescription typeDescription, String str, Node node) {
            Object newInstance = typeDescription.newInstance(str, node);
            if (newInstance != null) {
                Constructor.this.constructedObjects.put(node, newInstance);
                return Constructor.this.constructObjectNoCheck(node);
            }
            return Constructor.this.constructObject(node);
        }

        protected Property getProperty(Class<? extends Object> cls, String str) {
            return Constructor.this.getPropertyUtils().getProperty(cls, str);
        }
    }

    /* loaded from: classes2.dex */
    protected class ConstructYamlObject implements Construct {
        protected ConstructYamlObject() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Construct getConstructor(Node node) {
            node.setType(Constructor.this.getClassForNode(node));
            return Constructor.this.yamlClassConstructors.get(node.getNodeId());
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            try {
                return getConstructor(node).construct(node);
            } catch (ConstructorException e) {
                throw e;
            } catch (Exception e2) {
                throw new ConstructorException(null, null, "Can't construct a java object for " + node.getTag() + "; exception=" + e2.getMessage(), node.getStartMark(), e2);
            }
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            try {
                getConstructor(node).construct2ndStep(node, obj);
            } catch (Exception e) {
                throw new ConstructorException(null, null, "Can't construct a second step for a java object for " + node.getTag() + "; exception=" + e.getMessage(), node.getStartMark(), e);
            }
        }
    }

    /* loaded from: classes2.dex */
    protected class ConstructScalar extends AbstractConstruct {
        protected ConstructScalar() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            Object obj;
            ScalarNode scalarNode = (ScalarNode) node;
            Class<? extends Object> type = scalarNode.getType();
            Object newInstance = Constructor.this.newInstance(type, scalarNode, false);
            if (newInstance != BaseConstructor.NOT_INSTANTIATED_OBJECT) {
                return newInstance;
            }
            if (type.isPrimitive() || type == String.class || Number.class.isAssignableFrom(type) || type == Boolean.class || Date.class.isAssignableFrom(type) || type == Character.class || type == BigInteger.class || type == BigDecimal.class || Enum.class.isAssignableFrom(type) || Tag.BINARY.equals(scalarNode.getTag()) || Calendar.class.isAssignableFrom(type) || type == UUID.class) {
                return constructStandardJavaInstance(type, scalarNode);
            }
            java.lang.reflect.Constructor<?> constructor = null;
            int i = 0;
            for (java.lang.reflect.Constructor<?> constructor2 : type.getDeclaredConstructors()) {
                if (constructor2.getParameterTypes().length == 1) {
                    i++;
                    constructor = constructor2;
                }
            }
            if (constructor == null) {
                throw new YAMLException("No single argument constructor found for " + type);
            }
            if (i == 1) {
                obj = constructStandardJavaInstance(constructor.getParameterTypes()[0], scalarNode);
            } else {
                String constructScalar = Constructor.this.constructScalar(scalarNode);
                try {
                    constructor = type.getDeclaredConstructor(String.class);
                    obj = constructScalar;
                } catch (Exception e) {
                    throw new YAMLException("Can't construct a java object for scalar " + scalarNode.getTag() + "; No String constructor found. Exception=" + e.getMessage(), e);
                }
            }
            try {
                constructor.setAccessible(true);
                return constructor.newInstance(obj);
            } catch (Exception e2) {
                throw new ConstructorException(null, null, "Can't construct a java object for scalar " + scalarNode.getTag() + "; exception=" + e2.getMessage(), scalarNode.getStartMark(), e2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:120:0x0217, code lost:
        
            if (r6 == java.lang.Float.TYPE) goto L112;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v52, types: [java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r6v54, types: [java.lang.Enum] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private java.lang.Object constructStandardJavaInstance(java.lang.Class r6, org.yaml.snakeyaml.nodes.ScalarNode r7) {
            /*
                Method dump skipped, instructions count: 641
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.constructor.Constructor.ConstructScalar.constructStandardJavaInstance(java.lang.Class, org.yaml.snakeyaml.nodes.ScalarNode):java.lang.Object");
        }
    }

    /* loaded from: classes2.dex */
    protected class ConstructSequence implements Construct {
        protected ConstructSequence() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            boolean z;
            SequenceNode sequenceNode = (SequenceNode) node;
            if (Set.class.isAssignableFrom(node.getType())) {
                if (node.isTwoStepsConstruction()) {
                    throw new YAMLException("Set cannot be recursive.");
                }
                return Constructor.this.constructSet(sequenceNode);
            }
            if (Collection.class.isAssignableFrom(node.getType())) {
                if (node.isTwoStepsConstruction()) {
                    return Constructor.this.newList(sequenceNode);
                }
                return Constructor.this.constructSequence(sequenceNode);
            }
            if (node.getType().isArray()) {
                if (node.isTwoStepsConstruction()) {
                    return Constructor.this.createArray(node.getType(), sequenceNode.getValue().size());
                }
                return Constructor.this.constructArray(sequenceNode);
            }
            ArrayList<java.lang.reflect.Constructor> arrayList = new ArrayList(sequenceNode.getValue().size());
            int i = 0;
            for (java.lang.reflect.Constructor<?> constructor : node.getType().getDeclaredConstructors()) {
                if (sequenceNode.getValue().size() == constructor.getParameterTypes().length) {
                    arrayList.add(constructor);
                }
            }
            if (!arrayList.isEmpty()) {
                if (arrayList.size() == 1) {
                    Object[] objArr = new Object[sequenceNode.getValue().size()];
                    java.lang.reflect.Constructor constructor2 = (java.lang.reflect.Constructor) arrayList.get(0);
                    for (Node node2 : sequenceNode.getValue()) {
                        node2.setType(constructor2.getParameterTypes()[i]);
                        objArr[i] = Constructor.this.constructObject(node2);
                        i++;
                    }
                    try {
                        constructor2.setAccessible(true);
                        return constructor2.newInstance(objArr);
                    } catch (Exception e) {
                        throw new YAMLException(e);
                    }
                }
                List<? extends Object> constructSequence = Constructor.this.constructSequence(sequenceNode);
                Class<?>[] clsArr = new Class[constructSequence.size()];
                Iterator<? extends Object> it = constructSequence.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    clsArr[i2] = it.next().getClass();
                    i2++;
                }
                for (java.lang.reflect.Constructor constructor3 : arrayList) {
                    Class<?>[] parameterTypes = constructor3.getParameterTypes();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= parameterTypes.length) {
                            z = true;
                            break;
                        }
                        if (!wrapIfPrimitive(parameterTypes[i3]).isAssignableFrom(clsArr[i3])) {
                            z = false;
                            break;
                        }
                        i3++;
                    }
                    if (z) {
                        try {
                            constructor3.setAccessible(true);
                            return constructor3.newInstance(constructSequence.toArray());
                        } catch (Exception e2) {
                            throw new YAMLException(e2);
                        }
                    }
                }
            }
            throw new YAMLException("No suitable constructor with " + String.valueOf(sequenceNode.getValue().size()) + " arguments found for " + node.getType());
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final Class<? extends Object> wrapIfPrimitive(Class<?> cls) {
            if (!cls.isPrimitive()) {
                return cls;
            }
            if (cls == Integer.TYPE) {
                return Integer.class;
            }
            if (cls == Float.TYPE) {
                return Float.class;
            }
            if (cls == Double.TYPE) {
                return Double.class;
            }
            if (cls == Boolean.TYPE) {
                return Boolean.class;
            }
            if (cls == Long.TYPE) {
                return Long.class;
            }
            if (cls == Character.TYPE) {
                return Character.class;
            }
            if (cls == Short.TYPE) {
                return Short.class;
            }
            if (cls == Byte.TYPE) {
                return Byte.class;
            }
            throw new YAMLException("Unexpected primitive " + cls);
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            SequenceNode sequenceNode = (SequenceNode) node;
            if (List.class.isAssignableFrom(node.getType())) {
                Constructor.this.constructSequenceStep2(sequenceNode, (List) obj);
            } else {
                if (node.getType().isArray()) {
                    Constructor.this.constructArrayStep2(sequenceNode, obj);
                    return;
                }
                throw new YAMLException("Immutable objects cannot be recursive.");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected Class<?> getClassForNode(Node node) {
        Class<? extends Object> cls = this.typeTags.get(node.getTag());
        if (cls != null) {
            return cls;
        }
        String className = node.getTag().getClassName();
        try {
            Class<?> classForName = getClassForName(className);
            this.typeTags.put(node.getTag(), classForName);
            return classForName;
        } catch (ClassNotFoundException unused) {
            throw new YAMLException("Class not found: " + className);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Class<?> getClassForName(String str) throws ClassNotFoundException {
        try {
            return Class.forName(str, true, Thread.currentThread().getContextClassLoader());
        } catch (ClassNotFoundException unused) {
            return Class.forName(str);
        }
    }
}
