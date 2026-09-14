package com.google.firebase.firestore.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.base.Function;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.v1.Value;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class Document extends MaybeDocument {
    private static final Comparator<Document> KEY_COMPARATOR;

    @Nullable
    private final Function<Value, FieldValue> converter;
    private final DocumentState documentState;

    @Nullable
    private Map<FieldPath, FieldValue> fieldValueCache;

    @Nullable
    private ObjectValue objectValue;

    @Nullable
    private final com.google.firestore.v1.Document proto;

    /* loaded from: classes2.dex */
    public enum DocumentState {
        LOCAL_MUTATIONS,
        COMMITTED_MUTATIONS,
        SYNCED
    }

    static {
        Comparator<Document> comparator;
        comparator = Document$$Lambda$1.instance;
        KEY_COMPARATOR = comparator;
    }

    public Document(DocumentKey documentKey, SnapshotVersion snapshotVersion, DocumentState documentState, ObjectValue objectValue) {
        super(documentKey, snapshotVersion);
        this.documentState = documentState;
        this.objectValue = objectValue;
        this.proto = null;
        this.converter = null;
    }

    public Document(DocumentKey documentKey, SnapshotVersion snapshotVersion, DocumentState documentState, com.google.firestore.v1.Document document, Function<Value, FieldValue> function) {
        super(documentKey, snapshotVersion);
        this.documentState = documentState;
        this.proto = document;
        this.converter = function;
    }

    public static Comparator<Document> keyComparator() {
        return KEY_COMPARATOR;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Document)) {
            return false;
        }
        Document document = (Document) obj;
        return getVersion().equals(document.getVersion()) && getKey().equals(document.getKey()) && this.documentState.equals(document.documentState) && getData().equals(document.getData());
    }

    @NonNull
    public ObjectValue getData() {
        if (this.objectValue == null) {
            Assert.hardAssert((this.proto == null || this.converter == null) ? false : true, "Expected proto and converter to be non-null", new Object[0]);
            ObjectValue emptyObject = ObjectValue.emptyObject();
            for (Map.Entry<String, Value> entry : this.proto.getFieldsMap().entrySet()) {
                emptyObject = emptyObject.set(FieldPath.fromSingleSegment(entry.getKey()), this.converter.apply(entry.getValue()));
            }
            this.objectValue = emptyObject;
            this.fieldValueCache = null;
        }
        return this.objectValue;
    }

    @Nullable
    public FieldValue getField(FieldPath fieldPath) {
        ObjectValue objectValue = this.objectValue;
        if (objectValue != null) {
            return objectValue.get(fieldPath);
        }
        Assert.hardAssert((this.proto == null || this.converter == null) ? false : true, "Expected proto and converter to be non-null", new Object[0]);
        Map map = this.fieldValueCache;
        if (map == null) {
            map = new ConcurrentHashMap();
            this.fieldValueCache = map;
        }
        FieldValue fieldValue = (FieldValue) map.get(fieldPath);
        if (fieldValue != null) {
            return fieldValue;
        }
        Value value = this.proto.getFieldsMap().get(fieldPath.getFirstSegment());
        for (int i = 1; value != null && i < fieldPath.length(); i++) {
            if (value.getValueTypeCase() != Value.ValueTypeCase.MAP_VALUE) {
                return null;
            }
            value = value.getMapValue().getFieldsMap().get(fieldPath.getSegment(i));
        }
        if (value == null) {
            return fieldValue;
        }
        FieldValue apply = this.converter.apply(value);
        map.put(fieldPath, apply);
        return apply;
    }

    @Nullable
    public Object getFieldValue(FieldPath fieldPath) {
        FieldValue field = getField(fieldPath);
        if (field == null) {
            return null;
        }
        return field.value();
    }

    @Nullable
    public com.google.firestore.v1.Document getProto() {
        return this.proto;
    }

    public boolean hasCommittedMutations() {
        return this.documentState.equals(DocumentState.COMMITTED_MUTATIONS);
    }

    public boolean hasLocalMutations() {
        return this.documentState.equals(DocumentState.LOCAL_MUTATIONS);
    }

    @Override // com.google.firebase.firestore.model.MaybeDocument
    public boolean hasPendingWrites() {
        return hasLocalMutations() || hasCommittedMutations();
    }

    public int hashCode() {
        return (((getKey().hashCode() * 31) + getVersion().hashCode()) * 31) + this.documentState.hashCode();
    }

    public String toString() {
        return "Document{key=" + getKey() + ", data=" + getData() + ", version=" + getVersion() + ", documentState=" + this.documentState.name() + '}';
    }
}
