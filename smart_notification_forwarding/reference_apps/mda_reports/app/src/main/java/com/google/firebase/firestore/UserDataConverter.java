package com.google.firebase.firestore;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.common.base.Preconditions;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.mutation.ArrayTransformOperation;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.model.mutation.NumericIncrementTransformOperation;
import com.google.firebase.firestore.model.mutation.ServerTimestampOperation;
import com.google.firebase.firestore.model.mutation.TransformOperation;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.BlobValue;
import com.google.firebase.firestore.model.value.BooleanValue;
import com.google.firebase.firestore.model.value.DoubleValue;
import com.google.firebase.firestore.model.value.GeoPointValue;
import com.google.firebase.firestore.model.value.IntegerValue;
import com.google.firebase.firestore.model.value.NullValue;
import com.google.firebase.firestore.model.value.NumberValue;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.model.value.ReferenceValue;
import com.google.firebase.firestore.model.value.StringValue;
import com.google.firebase.firestore.model.value.TimestampValue;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.CustomClassMapper;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class UserDataConverter {
    private final DatabaseId databaseId;

    public UserDataConverter(DatabaseId databaseId) {
        this.databaseId = databaseId;
    }

    private ObjectValue convertAndParseDocumentData(Object obj, UserData.ParseContext parseContext) {
        if (obj.getClass().isArray()) {
            throw new IllegalArgumentException("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was an array");
        }
        com.google.firebase.firestore.model.value.FieldValue parseData = parseData(CustomClassMapper.convertToPlainJavaTypes(obj), parseContext);
        if (parseData instanceof ObjectValue) {
            return (ObjectValue) parseData;
        }
        throw new IllegalArgumentException("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was of type: " + Util.typeName(obj));
    }

    private com.google.firebase.firestore.model.value.FieldValue convertAndParseFieldData(Object obj, UserData.ParseContext parseContext) {
        return parseData(CustomClassMapper.convertToPlainJavaTypes(obj), parseContext);
    }

    private List<com.google.firebase.firestore.model.value.FieldValue> parseArrayTransformElements(List<Object> list) {
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Argument);
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(convertAndParseFieldData(list.get(i), parseAccumulator.rootContext().childContext(i)));
        }
        return arrayList;
    }

    @Nullable
    private com.google.firebase.firestore.model.value.FieldValue parseData(Object obj, UserData.ParseContext parseContext) {
        if (obj instanceof Map) {
            return parseMap((Map) obj, parseContext);
        }
        if (obj instanceof FieldValue) {
            parseSentinelFieldValue((FieldValue) obj, parseContext);
            return null;
        }
        if (parseContext.getPath() != null) {
            parseContext.addToFieldMask(parseContext.getPath());
        }
        if (!(obj instanceof List)) {
            return parseScalarValue(obj, parseContext);
        }
        if (!parseContext.isArrayElement() || parseContext.getDataSource() == UserData.Source.ArrayArgument) {
            return parseList((List) obj, parseContext);
        }
        throw parseContext.createError("Nested arrays are not supported");
    }

    private <T> ArrayValue parseList(List<T> list, UserData.ParseContext parseContext) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<T> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.google.firebase.firestore.model.value.FieldValue parseData = parseData(it.next(), parseContext.childContext(i));
            if (parseData == null) {
                parseData = NullValue.nullValue();
            }
            arrayList.add(parseData);
            i++;
        }
        return ArrayValue.fromList(arrayList);
    }

    private <K, V> ObjectValue parseMap(Map<K, V> map, UserData.ParseContext parseContext) {
        HashMap hashMap = new HashMap();
        if (map.isEmpty()) {
            if (parseContext.getPath() != null && !parseContext.getPath().isEmpty()) {
                parseContext.addToFieldMask(parseContext.getPath());
            }
            return ObjectValue.emptyObject();
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (!(entry.getKey() instanceof String)) {
                throw parseContext.createError(String.format("Non-String Map key (%s) is not allowed", entry.getValue()));
            }
            String str = (String) entry.getKey();
            com.google.firebase.firestore.model.value.FieldValue parseData = parseData(entry.getValue(), parseContext.childContext(str));
            if (parseData != null) {
                hashMap.put(str, parseData);
            }
        }
        return ObjectValue.fromMap(hashMap);
    }

    @Nullable
    private com.google.firebase.firestore.model.value.FieldValue parseScalarValue(Object obj, UserData.ParseContext parseContext) {
        if (obj == null) {
            return NullValue.nullValue();
        }
        if (obj instanceof Integer) {
            return IntegerValue.valueOf(Long.valueOf(((Integer) obj).longValue()));
        }
        if (obj instanceof Long) {
            return IntegerValue.valueOf((Long) obj);
        }
        if (obj instanceof Float) {
            return DoubleValue.valueOf(Double.valueOf(((Float) obj).doubleValue()));
        }
        if (obj instanceof Double) {
            return DoubleValue.valueOf((Double) obj);
        }
        if (obj instanceof Boolean) {
            return BooleanValue.valueOf((Boolean) obj);
        }
        if (obj instanceof String) {
            return StringValue.valueOf((String) obj);
        }
        if (obj instanceof Date) {
            return TimestampValue.valueOf(new Timestamp((Date) obj));
        }
        if (obj instanceof Timestamp) {
            Timestamp timestamp = (Timestamp) obj;
            return TimestampValue.valueOf(new Timestamp(timestamp.getSeconds(), (timestamp.getNanoseconds() / 1000) * 1000));
        }
        if (obj instanceof GeoPoint) {
            return GeoPointValue.valueOf((GeoPoint) obj);
        }
        if (obj instanceof Blob) {
            return BlobValue.valueOf((Blob) obj);
        }
        if (obj instanceof DocumentReference) {
            DocumentReference documentReference = (DocumentReference) obj;
            if (documentReference.getFirestore() != null) {
                DatabaseId c = documentReference.getFirestore().c();
                if (!c.equals(this.databaseId)) {
                    throw parseContext.createError(String.format("Document reference is for database %s/%s but should be for database %s/%s", c.getProjectId(), c.getDatabaseId(), this.databaseId.getProjectId(), this.databaseId.getDatabaseId()));
                }
            }
            return ReferenceValue.valueOf(this.databaseId, documentReference.a());
        }
        if (obj.getClass().isArray()) {
            throw parseContext.createError("Arrays are not supported; use a List instead");
        }
        throw parseContext.createError("Unsupported type: " + Util.typeName(obj));
    }

    private void parseSentinelFieldValue(FieldValue fieldValue, UserData.ParseContext parseContext) {
        TransformOperation numericIncrementTransformOperation;
        com.google.firebase.firestore.model.FieldPath path;
        if (!parseContext.isWrite()) {
            throw parseContext.createError(String.format("%s() can only be used with set() and update()", fieldValue.a()));
        }
        if (parseContext.getPath() == null) {
            throw parseContext.createError(String.format("%s() is not currently supported inside arrays", fieldValue.a()));
        }
        if (fieldValue instanceof FieldValue.DeleteFieldValue) {
            if (parseContext.getDataSource() == UserData.Source.MergeSet) {
                parseContext.addToFieldMask(parseContext.getPath());
                return;
            } else {
                if (parseContext.getDataSource() != UserData.Source.Update) {
                    throw parseContext.createError("FieldValue.delete() can only be used with update() and set() with SetOptions.merge()");
                }
                Assert.hardAssert(parseContext.getPath().length() > 0, "FieldValue.delete() at the top level should have already been handled.", new Object[0]);
                throw parseContext.createError("FieldValue.delete() can only appear at the top level of your update data");
            }
        }
        if (fieldValue instanceof FieldValue.ServerTimestampFieldValue) {
            path = parseContext.getPath();
            numericIncrementTransformOperation = ServerTimestampOperation.getInstance();
        } else {
            if (fieldValue instanceof FieldValue.ArrayUnionFieldValue) {
                numericIncrementTransformOperation = new ArrayTransformOperation.Union(parseArrayTransformElements(((FieldValue.ArrayUnionFieldValue) fieldValue).b()));
            } else if (fieldValue instanceof FieldValue.ArrayRemoveFieldValue) {
                numericIncrementTransformOperation = new ArrayTransformOperation.Remove(parseArrayTransformElements(((FieldValue.ArrayRemoveFieldValue) fieldValue).b()));
            } else {
                if (!(fieldValue instanceof FieldValue.NumericIncrementFieldValue)) {
                    throw Assert.fail("Unknown FieldValue type: %s", Util.typeName(fieldValue));
                }
                numericIncrementTransformOperation = new NumericIncrementTransformOperation((NumberValue) parseQueryValue(((FieldValue.NumericIncrementFieldValue) fieldValue).b()));
            }
            path = parseContext.getPath();
        }
        parseContext.addToFieldTransforms(path, numericIncrementTransformOperation);
    }

    public UserData.ParsedSetData parseMergeData(Object obj, @Nullable FieldMask fieldMask) {
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.MergeSet);
        ObjectValue convertAndParseDocumentData = convertAndParseDocumentData(obj, parseAccumulator.rootContext());
        if (fieldMask == null) {
            return parseAccumulator.toMergeData(convertAndParseDocumentData);
        }
        for (com.google.firebase.firestore.model.FieldPath fieldPath : fieldMask.getMask()) {
            if (!parseAccumulator.contains(fieldPath)) {
                throw new IllegalArgumentException("Field '" + fieldPath.toString() + "' is specified in your field mask but not in your input data.");
            }
        }
        return parseAccumulator.toMergeData(convertAndParseDocumentData, fieldMask);
    }

    public com.google.firebase.firestore.model.value.FieldValue parseQueryValue(Object obj) {
        return parseQueryValue(obj, false);
    }

    public com.google.firebase.firestore.model.value.FieldValue parseQueryValue(Object obj, boolean z) {
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(z ? UserData.Source.ArrayArgument : UserData.Source.Argument);
        com.google.firebase.firestore.model.value.FieldValue convertAndParseFieldData = convertAndParseFieldData(obj, parseAccumulator.rootContext());
        Assert.hardAssert(convertAndParseFieldData != null, "Parsed data should not be null.", new Object[0]);
        Assert.hardAssert(parseAccumulator.getFieldTransforms().isEmpty(), "Field transforms should have been disallowed.", new Object[0]);
        return convertAndParseFieldData;
    }

    public UserData.ParsedSetData parseSetData(Object obj) {
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Set);
        return parseAccumulator.toSetData(convertAndParseDocumentData(obj, parseAccumulator.rootContext()));
    }

    public UserData.ParsedUpdateData parseUpdateData(List<Object> list) {
        Assert.hardAssert(list.size() % 2 == 0, "Expected fieldAndValues to contain an even number of elements", new Object[0]);
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Update);
        UserData.ParseContext rootContext = parseAccumulator.rootContext();
        ObjectValue emptyObject = ObjectValue.emptyObject();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Object next2 = it.next();
            boolean z = next instanceof String;
            Assert.hardAssert(z || (next instanceof FieldPath), "Expected argument to be String or FieldPath.", new Object[0]);
            com.google.firebase.firestore.model.FieldPath a = (z ? FieldPath.a((String) next) : (FieldPath) next).a();
            if (next2 instanceof FieldValue.DeleteFieldValue) {
                rootContext.addToFieldMask(a);
            } else {
                com.google.firebase.firestore.model.value.FieldValue convertAndParseFieldData = convertAndParseFieldData(next2, rootContext.childContext(a));
                if (convertAndParseFieldData != null) {
                    rootContext.addToFieldMask(a);
                    emptyObject = emptyObject.set(a, convertAndParseFieldData);
                }
            }
        }
        return parseAccumulator.toUpdateData(emptyObject);
    }

    public UserData.ParsedUpdateData parseUpdateData(Map<String, Object> map) {
        Preconditions.checkNotNull(map, "Provided update data must not be null.");
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Update);
        UserData.ParseContext rootContext = parseAccumulator.rootContext();
        ObjectValue emptyObject = ObjectValue.emptyObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            com.google.firebase.firestore.model.FieldPath a = FieldPath.a(entry.getKey()).a();
            Object value = entry.getValue();
            if (value instanceof FieldValue.DeleteFieldValue) {
                rootContext.addToFieldMask(a);
            } else {
                com.google.firebase.firestore.model.value.FieldValue convertAndParseFieldData = convertAndParseFieldData(value, rootContext.childContext(a));
                if (convertAndParseFieldData != null) {
                    rootContext.addToFieldMask(a);
                    emptyObject = emptyObject.set(a, convertAndParseFieldData);
                }
            }
        }
        return parseAccumulator.toUpdateData(emptyObject);
    }
}
