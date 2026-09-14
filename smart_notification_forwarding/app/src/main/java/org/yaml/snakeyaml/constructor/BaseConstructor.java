package org.yaml.snakeyaml.constructor;

import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.composer.Composer;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.CollectionNode;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes2.dex */
public abstract class BaseConstructor {
    protected static final Object NOT_INSTANTIATED_OBJECT = new Object();
    private boolean allowDuplicateKeys;
    protected Composer composer;
    final Map<Node, Object> constructedObjects;
    private boolean enumCaseSensitive;
    private boolean explicitPropertyUtils;
    protected LoaderOptions loadingConfig;
    private final ArrayList<RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>>> maps2fill;
    private PropertyUtils propertyUtils;
    private final Set<Node> recursiveObjects;
    protected Tag rootTag;
    private final ArrayList<RecursiveTuple<Set<Object>, Object>> sets2fill;
    protected final Map<Class<? extends Object>, TypeDescription> typeDefinitions;
    protected final Map<Tag, Class<? extends Object>> typeTags;
    private boolean wrappedToRootException;
    protected final Map<NodeId, Construct> yamlClassConstructors;
    protected final Map<Tag, Construct> yamlConstructors;
    protected final Map<String, Construct> yamlMultiConstructors;

    public BaseConstructor() {
        this(new LoaderOptions());
    }

    public BaseConstructor(LoaderOptions loaderOptions) {
        this.yamlClassConstructors = new EnumMap(NodeId.class);
        this.yamlConstructors = new HashMap();
        this.yamlMultiConstructors = new HashMap();
        this.allowDuplicateKeys = true;
        this.wrappedToRootException = false;
        this.enumCaseSensitive = false;
        this.constructedObjects = new HashMap();
        this.recursiveObjects = new HashSet();
        this.maps2fill = new ArrayList<>();
        this.sets2fill = new ArrayList<>();
        HashMap hashMap = new HashMap();
        this.typeDefinitions = hashMap;
        this.typeTags = new HashMap();
        this.rootTag = null;
        this.explicitPropertyUtils = false;
        hashMap.put(SortedMap.class, new TypeDescription(SortedMap.class, Tag.OMAP, TreeMap.class));
        hashMap.put(SortedSet.class, new TypeDescription(SortedSet.class, Tag.SET, TreeSet.class));
        this.loadingConfig = loaderOptions;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public boolean checkData() {
        return this.composer.checkNode();
    }

    public Object getData() throws NoSuchElementException {
        if (!this.composer.checkNode()) {
            throw new NoSuchElementException("No document is available.");
        }
        Node node = this.composer.getNode();
        Tag tag = this.rootTag;
        if (tag != null) {
            node.setTag(tag);
        }
        return constructDocument(node);
    }

    public Object getSingleData(Class<?> cls) {
        Node singleNode = this.composer.getSingleNode();
        if (singleNode != null && !Tag.NULL.equals(singleNode.getTag())) {
            if (Object.class != cls) {
                singleNode.setTag(new Tag((Class<? extends Object>) cls));
            } else {
                Tag tag = this.rootTag;
                if (tag != null) {
                    singleNode.setTag(tag);
                }
            }
            return constructDocument(singleNode);
        }
        return this.yamlConstructors.get(Tag.NULL).construct(singleNode);
    }

    protected final Object constructDocument(Node node) {
        try {
            try {
                Object constructObject = constructObject(node);
                fillRecursive();
                return constructObject;
            } catch (RuntimeException e) {
                if (this.wrappedToRootException && !(e instanceof YAMLException)) {
                    throw new YAMLException(e);
                }
                throw e;
            }
        } finally {
            this.constructedObjects.clear();
            this.recursiveObjects.clear();
        }
    }

    private void fillRecursive() {
        if (!this.maps2fill.isEmpty()) {
            Iterator<RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>>> it = this.maps2fill.iterator();
            while (it.hasNext()) {
                RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>> next = it.next();
                RecursiveTuple<Object, Object> _2 = next._2();
                next._1().put(_2._1(), _2._2());
            }
            this.maps2fill.clear();
        }
        if (this.sets2fill.isEmpty()) {
            return;
        }
        Iterator<RecursiveTuple<Set<Object>, Object>> it2 = this.sets2fill.iterator();
        while (it2.hasNext()) {
            RecursiveTuple<Set<Object>, Object> next2 = it2.next();
            next2._1().add(next2._2());
        }
        this.sets2fill.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object constructObject(Node node) {
        if (this.constructedObjects.containsKey(node)) {
            return this.constructedObjects.get(node);
        }
        return constructObjectNoCheck(node);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object constructObjectNoCheck(Node node) {
        if (this.recursiveObjects.contains(node)) {
            throw new ConstructorException(null, null, "found unconstructable recursive node", node.getStartMark());
        }
        this.recursiveObjects.add(node);
        Construct constructor = getConstructor(node);
        Object construct = this.constructedObjects.containsKey(node) ? this.constructedObjects.get(node) : constructor.construct(node);
        finalizeConstruction(node, construct);
        this.constructedObjects.put(node, construct);
        this.recursiveObjects.remove(node);
        if (node.isTwoStepsConstruction()) {
            constructor.construct2ndStep(node, construct);
        }
        return construct;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Construct getConstructor(Node node) {
        if (node.useClassConstructor()) {
            return this.yamlClassConstructors.get(node.getNodeId());
        }
        Construct construct = this.yamlConstructors.get(node.getTag());
        if (construct != null) {
            return construct;
        }
        for (String str : this.yamlMultiConstructors.keySet()) {
            if (node.getTag().startsWith(str)) {
                return this.yamlMultiConstructors.get(str);
            }
        }
        return this.yamlConstructors.get(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String constructScalar(ScalarNode scalarNode) {
        return scalarNode.getValue();
    }

    protected List<Object> createDefaultList(int i) {
        return new ArrayList(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Set<Object> createDefaultSet(int i) {
        return new LinkedHashSet(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<Object, Object> createDefaultMap(int i) {
        return new LinkedHashMap(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object createArray(Class<?> cls, int i) {
        return Array.newInstance(cls.getComponentType(), i);
    }

    protected Object finalizeConstruction(Node node, Object obj) {
        Class<? extends Object> type = node.getType();
        return this.typeDefinitions.containsKey(type) ? this.typeDefinitions.get(type).finalizeConstruction(obj) : obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object newInstance(Node node) {
        return newInstance(Object.class, node);
    }

    protected final Object newInstance(Class<?> cls, Node node) {
        return newInstance(cls, node, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object newInstance(Class<?> cls, Node node, boolean z) {
        Object newInstance;
        try {
            Class<? extends Object> type = node.getType();
            if (this.typeDefinitions.containsKey(type) && (newInstance = this.typeDefinitions.get(type).newInstance(node)) != null) {
                return newInstance;
            }
            if (z && cls.isAssignableFrom(type) && !Modifier.isAbstract(type.getModifiers())) {
                java.lang.reflect.Constructor<? extends Object> declaredConstructor = type.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(new Object[0]);
            }
            return NOT_INSTANTIATED_OBJECT;
        } catch (Exception e) {
            throw new YAMLException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Set<Object> newSet(CollectionNode<?> collectionNode) {
        Object newInstance = newInstance(Set.class, collectionNode);
        if (newInstance != NOT_INSTANTIATED_OBJECT) {
            return (Set) newInstance;
        }
        return createDefaultSet(collectionNode.getValue().size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Object> newList(SequenceNode sequenceNode) {
        Object newInstance = newInstance(List.class, sequenceNode);
        if (newInstance != NOT_INSTANTIATED_OBJECT) {
            return (List) newInstance;
        }
        return createDefaultList(sequenceNode.getValue().size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<Object, Object> newMap(MappingNode mappingNode) {
        Object newInstance = newInstance(Map.class, mappingNode);
        if (newInstance != NOT_INSTANTIATED_OBJECT) {
            return (Map) newInstance;
        }
        return createDefaultMap(mappingNode.getValue().size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<? extends Object> constructSequence(SequenceNode sequenceNode) {
        List<? extends Object> newList = newList(sequenceNode);
        constructSequenceStep2(sequenceNode, newList);
        return newList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Set<? extends Object> constructSet(SequenceNode sequenceNode) {
        Set<? extends Object> newSet = newSet(sequenceNode);
        constructSequenceStep2(sequenceNode, newSet);
        return newSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object constructArray(SequenceNode sequenceNode) {
        return constructArrayStep2(sequenceNode, createArray(sequenceNode.getType(), sequenceNode.getValue().size()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void constructSequenceStep2(SequenceNode sequenceNode, Collection<Object> collection) {
        Iterator<Node> it = sequenceNode.getValue().iterator();
        while (it.hasNext()) {
            collection.add(constructObject(it.next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public Object constructArrayStep2(SequenceNode sequenceNode, Object obj) {
        Class<?> componentType = sequenceNode.getType().getComponentType();
        int i = 0;
        for (Node node : sequenceNode.getValue()) {
            if (node.getType() == Object.class) {
                node.setType(componentType);
            }
            Object constructObject = constructObject(node);
            if (componentType.isPrimitive()) {
                if (constructObject == null) {
                    throw new NullPointerException("Unable to construct element value for " + node);
                }
                if (Byte.TYPE.equals(componentType)) {
                    Array.setByte(obj, i, ((Number) constructObject).byteValue());
                } else if (Short.TYPE.equals(componentType)) {
                    Array.setShort(obj, i, ((Number) constructObject).shortValue());
                } else if (Integer.TYPE.equals(componentType)) {
                    Array.setInt(obj, i, ((Number) constructObject).intValue());
                } else if (Long.TYPE.equals(componentType)) {
                    Array.setLong(obj, i, ((Number) constructObject).longValue());
                } else if (Float.TYPE.equals(componentType)) {
                    Array.setFloat(obj, i, ((Number) constructObject).floatValue());
                } else if (Double.TYPE.equals(componentType)) {
                    Array.setDouble(obj, i, ((Number) constructObject).doubleValue());
                } else if (Character.TYPE.equals(componentType)) {
                    Array.setChar(obj, i, ((Character) constructObject).charValue());
                } else if (Boolean.TYPE.equals(componentType)) {
                    Array.setBoolean(obj, i, ((Boolean) constructObject).booleanValue());
                } else {
                    throw new YAMLException("unexpected primitive type");
                }
            } else {
                Array.set(obj, i, constructObject);
            }
            i++;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Set<Object> constructSet(MappingNode mappingNode) {
        Set<Object> newSet = newSet(mappingNode);
        constructSet2ndStep(mappingNode, newSet);
        return newSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<Object, Object> constructMapping(MappingNode mappingNode) {
        Map<Object, Object> newMap = newMap(mappingNode);
        constructMapping2ndStep(mappingNode, newMap);
        return newMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void constructMapping2ndStep(MappingNode mappingNode, Map<Object, Object> map) {
        for (NodeTuple nodeTuple : mappingNode.getValue()) {
            Node keyNode = nodeTuple.getKeyNode();
            Node valueNode = nodeTuple.getValueNode();
            Object constructObject = constructObject(keyNode);
            if (constructObject != null) {
                try {
                    constructObject.hashCode();
                } catch (Exception e) {
                    throw new ConstructorException("while constructing a mapping", mappingNode.getStartMark(), "found unacceptable key " + constructObject, nodeTuple.getKeyNode().getStartMark(), e);
                }
            }
            Object constructObject2 = constructObject(valueNode);
            if (keyNode.isTwoStepsConstruction()) {
                if (this.loadingConfig.getAllowRecursiveKeys()) {
                    postponeMapFilling(map, constructObject, constructObject2);
                } else {
                    throw new YAMLException("Recursive key for mapping is detected but it is not configured to be allowed.");
                }
            } else {
                map.put(constructObject, constructObject2);
            }
        }
    }

    protected void postponeMapFilling(Map<Object, Object> map, Object obj, Object obj2) {
        this.maps2fill.add(0, new RecursiveTuple<>(map, new RecursiveTuple(obj, obj2)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void constructSet2ndStep(MappingNode mappingNode, Set<Object> set) {
        for (NodeTuple nodeTuple : mappingNode.getValue()) {
            Node keyNode = nodeTuple.getKeyNode();
            Object constructObject = constructObject(keyNode);
            if (constructObject != null) {
                try {
                    constructObject.hashCode();
                } catch (Exception e) {
                    throw new ConstructorException("while constructing a Set", mappingNode.getStartMark(), "found unacceptable key " + constructObject, nodeTuple.getKeyNode().getStartMark(), e);
                }
            }
            if (keyNode.isTwoStepsConstruction()) {
                postponeSetFilling(set, constructObject);
            } else {
                set.add(constructObject);
            }
        }
    }

    protected void postponeSetFilling(Set<Object> set, Object obj) {
        this.sets2fill.add(0, new RecursiveTuple<>(set, obj));
    }

    public void setPropertyUtils(PropertyUtils propertyUtils) {
        this.propertyUtils = propertyUtils;
        this.explicitPropertyUtils = true;
        Iterator<TypeDescription> it = this.typeDefinitions.values().iterator();
        while (it.hasNext()) {
            it.next().setPropertyUtils(propertyUtils);
        }
    }

    public final PropertyUtils getPropertyUtils() {
        if (this.propertyUtils == null) {
            this.propertyUtils = new PropertyUtils();
        }
        return this.propertyUtils;
    }

    public TypeDescription addTypeDescription(TypeDescription typeDescription) {
        if (typeDescription == null) {
            throw new NullPointerException("TypeDescription is required.");
        }
        this.typeTags.put(typeDescription.getTag(), typeDescription.getType());
        typeDescription.setPropertyUtils(getPropertyUtils());
        return this.typeDefinitions.put(typeDescription.getType(), typeDescription);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class RecursiveTuple<T, K> {
        private final T _1;
        private final K _2;

        public RecursiveTuple(T t, K k) {
            this._1 = t;
            this._2 = k;
        }

        public K _2() {
            return this._2;
        }

        public T _1() {
            return this._1;
        }
    }

    public final boolean isExplicitPropertyUtils() {
        return this.explicitPropertyUtils;
    }

    public boolean isAllowDuplicateKeys() {
        return this.allowDuplicateKeys;
    }

    public void setAllowDuplicateKeys(boolean z) {
        this.allowDuplicateKeys = z;
    }

    public boolean isWrappedToRootException() {
        return this.wrappedToRootException;
    }

    public void setWrappedToRootException(boolean z) {
        this.wrappedToRootException = z;
    }

    public boolean isEnumCaseSensitive() {
        return this.enumCaseSensitive;
    }

    public void setEnumCaseSensitive(boolean z) {
        this.enumCaseSensitive = z;
    }
}
