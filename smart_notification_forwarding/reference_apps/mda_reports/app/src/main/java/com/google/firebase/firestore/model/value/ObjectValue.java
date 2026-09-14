package com.google.firebase.firestore.model.value;

import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class ObjectValue extends FieldValue {
    private static final ObjectValue EMPTY_INSTANCE = new ObjectValue(ImmutableSortedMap.Builder.emptyMap(Util.comparator()));
    private final ImmutableSortedMap<String, FieldValue> internalValue;

    private ObjectValue(ImmutableSortedMap<String, FieldValue> immutableSortedMap) {
        this.internalValue = immutableSortedMap;
    }

    public static ObjectValue emptyObject() {
        return EMPTY_INSTANCE;
    }

    public static ObjectValue fromImmutableMap(ImmutableSortedMap<String, FieldValue> immutableSortedMap) {
        return immutableSortedMap.isEmpty() ? EMPTY_INSTANCE : new ObjectValue(immutableSortedMap);
    }

    public static ObjectValue fromMap(Map<String, FieldValue> map) {
        return fromImmutableMap(ImmutableSortedMap.Builder.fromMap(map, Util.comparator()));
    }

    private ObjectValue setChild(String str, FieldValue fieldValue) {
        return fromImmutableMap(this.internalValue.insert(str, fieldValue));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.firebase.firestore.model.value.FieldValue, java.lang.Comparable
    public int compareTo(FieldValue fieldValue) {
        if (!(fieldValue instanceof ObjectValue)) {
            return a(fieldValue);
        }
        Iterator<Map.Entry<String, FieldValue>> it = this.internalValue.iterator();
        Iterator<Map.Entry<String, FieldValue>> it2 = ((ObjectValue) fieldValue).internalValue.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<String, FieldValue> next = it.next();
            Map.Entry<String, FieldValue> next2 = it2.next();
            int compareTo = next.getKey().compareTo(next2.getKey());
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = next.getValue().compareTo(next2.getValue());
            if (compareTo2 != 0) {
                return compareTo2;
            }
        }
        return Util.compareBooleans(it.hasNext(), it2.hasNext());
    }

    public ObjectValue delete(FieldPath fieldPath) {
        Assert.hardAssert(!fieldPath.isEmpty(), "Cannot delete field for empty path on ObjectValue", new Object[0]);
        String firstSegment = fieldPath.getFirstSegment();
        if (fieldPath.length() == 1) {
            return fromImmutableMap(this.internalValue.remove(firstSegment));
        }
        FieldValue fieldValue = this.internalValue.get(firstSegment);
        return fieldValue instanceof ObjectValue ? setChild(firstSegment, ((ObjectValue) fieldValue).delete(fieldPath.popFirst())) : this;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public boolean equals(Object obj) {
        return (obj instanceof ObjectValue) && this.internalValue.equals(((ObjectValue) obj).internalValue);
    }

    @Nullable
    public FieldValue get(FieldPath fieldPath) {
        FieldValue fieldValue = this;
        for (int i = 0; i < fieldPath.length(); i++) {
            if (!(fieldValue instanceof ObjectValue)) {
                return null;
            }
            fieldValue = ((ObjectValue) fieldValue).internalValue.get(fieldPath.getSegment(i));
        }
        return fieldValue;
    }

    public FieldMask getFieldMask() {
        HashSet hashSet = new HashSet();
        Iterator<Map.Entry<String, FieldValue>> it = this.internalValue.iterator();
        while (it.hasNext()) {
            Map.Entry<String, FieldValue> next = it.next();
            FieldPath fromSingleSegment = FieldPath.fromSingleSegment(next.getKey());
            FieldValue value = next.getValue();
            if (value instanceof ObjectValue) {
                Set<FieldPath> mask = ((ObjectValue) value).getFieldMask().getMask();
                if (!mask.isEmpty()) {
                    Iterator<FieldPath> it2 = mask.iterator();
                    while (it2.hasNext()) {
                        hashSet.add(fromSingleSegment.append(it2.next()));
                    }
                }
            }
            hashSet.add(fromSingleSegment);
        }
        return FieldMask.fromSet(hashSet);
    }

    public ImmutableSortedMap<String, FieldValue> getInternalValue() {
        return this.internalValue;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int hashCode() {
        return this.internalValue.hashCode();
    }

    public ObjectValue set(FieldPath fieldPath, FieldValue fieldValue) {
        Assert.hardAssert(!fieldPath.isEmpty(), "Cannot set field for empty path on ObjectValue", new Object[0]);
        String firstSegment = fieldPath.getFirstSegment();
        if (fieldPath.length() == 1) {
            return setChild(firstSegment, fieldValue);
        }
        FieldValue fieldValue2 = this.internalValue.get(firstSegment);
        return setChild(firstSegment, (fieldValue2 instanceof ObjectValue ? (ObjectValue) fieldValue2 : emptyObject()).set(fieldPath.popFirst(), fieldValue));
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public String toString() {
        return this.internalValue.toString();
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int typeOrder() {
        return 9;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public Map<String, Object> value() {
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<String, FieldValue>> it = this.internalValue.iterator();
        while (it.hasNext()) {
            Map.Entry<String, FieldValue> next = it.next();
            hashMap.put(next.getKey(), next.getValue().value());
        }
        return hashMap;
    }
}
