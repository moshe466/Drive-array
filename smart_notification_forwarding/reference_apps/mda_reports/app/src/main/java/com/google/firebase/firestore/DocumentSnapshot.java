package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.base.Preconditions;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.model.value.ReferenceValue;
import com.google.firebase.firestore.model.value.ServerTimestampValue;
import com.google.firebase.firestore.model.value.TimestampValue;
import com.google.firebase.firestore.util.CustomClassMapper;
import com.google.firebase.firestore.util.Logger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class DocumentSnapshot {

    @Nullable
    private final Document doc;
    private final FirebaseFirestore firestore;
    private final DocumentKey key;
    private final SnapshotMetadata metadata;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.DocumentSnapshot$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[ServerTimestampBehavior.values().length];

        static {
            try {
                a[ServerTimestampBehavior.PREVIOUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ServerTimestampBehavior.ESTIMATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class FieldValueOptions {
        final ServerTimestampBehavior a;
        final boolean b;

        private FieldValueOptions(ServerTimestampBehavior serverTimestampBehavior, boolean z) {
            this.a = serverTimestampBehavior;
            this.b = z;
        }

        /* synthetic */ FieldValueOptions(ServerTimestampBehavior serverTimestampBehavior, boolean z, AnonymousClass1 anonymousClass1) {
            this(serverTimestampBehavior, z);
        }
    }

    /* loaded from: classes2.dex */
    public enum ServerTimestampBehavior {
        NONE,
        ESTIMATE,
        PREVIOUS;

        static final ServerTimestampBehavior a = NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DocumentSnapshot(FirebaseFirestore firebaseFirestore, DocumentKey documentKey, @Nullable Document document, boolean z, boolean z2) {
        this.firestore = (FirebaseFirestore) Preconditions.checkNotNull(firebaseFirestore);
        this.key = (DocumentKey) Preconditions.checkNotNull(documentKey);
        this.doc = document;
        this.metadata = new SnapshotMetadata(z2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DocumentSnapshot a(FirebaseFirestore firebaseFirestore, Document document, boolean z, boolean z2) {
        return new DocumentSnapshot(firebaseFirestore, document.getKey(), document, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DocumentSnapshot a(FirebaseFirestore firebaseFirestore, DocumentKey documentKey, boolean z, boolean z2) {
        return new DocumentSnapshot(firebaseFirestore, documentKey, null, z, z2);
    }

    @Nullable
    private <T> T castTypedValue(Object obj, String str, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        throw new RuntimeException("Field '" + str + "' is not a " + cls.getName());
    }

    private List<Object> convertArray(ArrayValue arrayValue, FieldValueOptions fieldValueOptions) {
        ArrayList arrayList = new ArrayList(arrayValue.getInternalValue().size());
        Iterator<com.google.firebase.firestore.model.value.FieldValue> it = arrayValue.getInternalValue().iterator();
        while (it.hasNext()) {
            arrayList.add(convertValue(it.next(), fieldValueOptions));
        }
        return arrayList;
    }

    private Map<String, Object> convertObject(ObjectValue objectValue, FieldValueOptions fieldValueOptions) {
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<String, com.google.firebase.firestore.model.value.FieldValue>> it = objectValue.getInternalValue().iterator();
        while (it.hasNext()) {
            Map.Entry<String, com.google.firebase.firestore.model.value.FieldValue> next = it.next();
            hashMap.put(next.getKey(), convertValue(next.getValue(), fieldValueOptions));
        }
        return hashMap;
    }

    private Object convertReference(ReferenceValue referenceValue) {
        DocumentKey value = referenceValue.value();
        DatabaseId databaseId = referenceValue.getDatabaseId();
        DatabaseId c = this.firestore.c();
        if (!databaseId.equals(c)) {
            Logger.warn("DocumentSnapshot", "Document %s contains a document reference within a different database (%s/%s) which is not supported. It will be treated as a reference in the current database (%s/%s) instead.", value.getPath(), databaseId.getProjectId(), databaseId.getDatabaseId(), c.getProjectId(), c.getDatabaseId());
        }
        return new DocumentReference(value, this.firestore);
    }

    private Object convertServerTimestamp(ServerTimestampValue serverTimestampValue, FieldValueOptions fieldValueOptions) {
        int i = AnonymousClass1.a[fieldValueOptions.a.ordinal()];
        return i != 1 ? i != 2 ? serverTimestampValue.value() : serverTimestampValue.getLocalWriteTime() : serverTimestampValue.getPreviousValue();
    }

    private Object convertTimestamp(TimestampValue timestampValue, FieldValueOptions fieldValueOptions) {
        Timestamp value = timestampValue.value();
        return fieldValueOptions.b ? value : value.toDate();
    }

    @Nullable
    private Object convertValue(com.google.firebase.firestore.model.value.FieldValue fieldValue, FieldValueOptions fieldValueOptions) {
        return fieldValue instanceof ObjectValue ? convertObject((ObjectValue) fieldValue, fieldValueOptions) : fieldValue instanceof ArrayValue ? convertArray((ArrayValue) fieldValue, fieldValueOptions) : fieldValue instanceof ReferenceValue ? convertReference((ReferenceValue) fieldValue) : fieldValue instanceof TimestampValue ? convertTimestamp((TimestampValue) fieldValue, fieldValueOptions) : fieldValue instanceof ServerTimestampValue ? convertServerTimestamp((ServerTimestampValue) fieldValue, fieldValueOptions) : fieldValue.value();
    }

    @Nullable
    private Object getInternal(@NonNull com.google.firebase.firestore.model.FieldPath fieldPath, @NonNull FieldValueOptions fieldValueOptions) {
        com.google.firebase.firestore.model.value.FieldValue field;
        Document document = this.doc;
        if (document == null || (field = document.getField(fieldPath)) == null) {
            return null;
        }
        return convertValue(field, fieldValueOptions);
    }

    @Nullable
    private <T> T getTypedValue(String str, Class<T> cls) {
        Preconditions.checkNotNull(str, "Provided field must not be null.");
        return (T) castTypedValue(get(str, ServerTimestampBehavior.a), str, cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Document a() {
        return this.doc;
    }

    public boolean contains(@NonNull FieldPath fieldPath) {
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        Document document = this.doc;
        return (document == null || document.getField(fieldPath.a()) == null) ? false : true;
    }

    public boolean contains(@NonNull String str) {
        return contains(FieldPath.a(str));
    }

    public boolean equals(@Nullable Object obj) {
        Document document;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DocumentSnapshot)) {
            return false;
        }
        DocumentSnapshot documentSnapshot = (DocumentSnapshot) obj;
        return this.firestore.equals(documentSnapshot.firestore) && this.key.equals(documentSnapshot.key) && ((document = this.doc) != null ? document.equals(documentSnapshot.doc) : documentSnapshot.doc == null) && this.metadata.equals(documentSnapshot.metadata);
    }

    public boolean exists() {
        return this.doc != null;
    }

    @Nullable
    public Object get(@NonNull FieldPath fieldPath) {
        return get(fieldPath, ServerTimestampBehavior.a);
    }

    @Nullable
    public Object get(@NonNull FieldPath fieldPath, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        return getInternal(fieldPath.a(), new FieldValueOptions(serverTimestampBehavior, this.firestore.getFirestoreSettings().areTimestampsInSnapshotsEnabled(), null));
    }

    @Nullable
    public <T> T get(@NonNull FieldPath fieldPath, @NonNull Class<T> cls) {
        return (T) get(fieldPath, cls, ServerTimestampBehavior.a);
    }

    @Nullable
    public <T> T get(@NonNull FieldPath fieldPath, @NonNull Class<T> cls, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Object obj = get(fieldPath, serverTimestampBehavior);
        if (obj == null) {
            return null;
        }
        return (T) CustomClassMapper.convertToCustomClass(obj, cls, getReference());
    }

    @Nullable
    public Object get(@NonNull String str) {
        return get(FieldPath.a(str), ServerTimestampBehavior.a);
    }

    @Nullable
    public Object get(@NonNull String str, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        return get(FieldPath.a(str), serverTimestampBehavior);
    }

    @Nullable
    public <T> T get(@NonNull String str, @NonNull Class<T> cls) {
        return (T) get(FieldPath.a(str), cls, ServerTimestampBehavior.a);
    }

    @Nullable
    public <T> T get(@NonNull String str, @NonNull Class<T> cls, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        return (T) get(FieldPath.a(str), cls, serverTimestampBehavior);
    }

    @Nullable
    public Blob getBlob(@NonNull String str) {
        return (Blob) getTypedValue(str, Blob.class);
    }

    @Nullable
    public Boolean getBoolean(@NonNull String str) {
        return (Boolean) getTypedValue(str, Boolean.class);
    }

    @Nullable
    public Map<String, Object> getData() {
        return getData(ServerTimestampBehavior.a);
    }

    @Nullable
    public Map<String, Object> getData(@NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        Document document = this.doc;
        AnonymousClass1 anonymousClass1 = null;
        if (document == null) {
            return null;
        }
        return convertObject(document.getData(), new FieldValueOptions(serverTimestampBehavior, this.firestore.getFirestoreSettings().areTimestampsInSnapshotsEnabled(), anonymousClass1));
    }

    @Nullable
    public Date getDate(@NonNull String str) {
        return getDate(str, ServerTimestampBehavior.a);
    }

    @Nullable
    public Date getDate(@NonNull String str, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(str, "Provided field path must not be null.");
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        return (Date) castTypedValue(getInternal(FieldPath.a(str).a(), new FieldValueOptions(serverTimestampBehavior, false, null)), str, Date.class);
    }

    @Nullable
    public DocumentReference getDocumentReference(@NonNull String str) {
        return (DocumentReference) getTypedValue(str, DocumentReference.class);
    }

    @Nullable
    public Double getDouble(@NonNull String str) {
        Number number = (Number) getTypedValue(str, Number.class);
        if (number != null) {
            return Double.valueOf(number.doubleValue());
        }
        return null;
    }

    @Nullable
    public GeoPoint getGeoPoint(@NonNull String str) {
        return (GeoPoint) getTypedValue(str, GeoPoint.class);
    }

    @NonNull
    public String getId() {
        return this.key.getPath().getLastSegment();
    }

    @Nullable
    public Long getLong(@NonNull String str) {
        Number number = (Number) getTypedValue(str, Number.class);
        if (number != null) {
            return Long.valueOf(number.longValue());
        }
        return null;
    }

    @NonNull
    public SnapshotMetadata getMetadata() {
        return this.metadata;
    }

    @NonNull
    public DocumentReference getReference() {
        return new DocumentReference(this.key, this.firestore);
    }

    @Nullable
    public String getString(@NonNull String str) {
        return (String) getTypedValue(str, String.class);
    }

    @Nullable
    public Timestamp getTimestamp(@NonNull String str) {
        return getTimestamp(str, ServerTimestampBehavior.a);
    }

    @Nullable
    public Timestamp getTimestamp(@NonNull String str, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(str, "Provided field path must not be null.");
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        return (Timestamp) castTypedValue(getInternal(FieldPath.a(str).a(), new FieldValueOptions(serverTimestampBehavior, true, null)), str, Timestamp.class);
    }

    public int hashCode() {
        int hashCode = ((this.firestore.hashCode() * 31) + this.key.hashCode()) * 31;
        Document document = this.doc;
        return ((hashCode + (document != null ? document.hashCode() : 0)) * 31) + this.metadata.hashCode();
    }

    @Nullable
    public <T> T toObject(@NonNull Class<T> cls) {
        return (T) toObject(cls, ServerTimestampBehavior.a);
    }

    @Nullable
    public <T> T toObject(@NonNull Class<T> cls, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(cls, "Provided POJO type must not be null.");
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        Map<String, Object> data = getData(serverTimestampBehavior);
        if (data == null) {
            return null;
        }
        return (T) CustomClassMapper.convertToCustomClass(data, cls, getReference());
    }

    public String toString() {
        return "DocumentSnapshot{key=" + this.key + ", metadata=" + this.metadata + ", doc=" + this.doc + '}';
    }
}
