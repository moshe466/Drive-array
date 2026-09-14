package com.google.firebase.firestore.remote;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.Blob;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.core.Bound;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.local.QueryData;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.ArrayTransformOperation;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.model.mutation.FieldTransform;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.model.mutation.NumericIncrementTransformOperation;
import com.google.firebase.firestore.model.mutation.PatchMutation;
import com.google.firebase.firestore.model.mutation.ServerTimestampOperation;
import com.google.firebase.firestore.model.mutation.SetMutation;
import com.google.firebase.firestore.model.mutation.TransformMutation;
import com.google.firebase.firestore.model.mutation.TransformOperation;
import com.google.firebase.firestore.model.value.BlobValue;
import com.google.firebase.firestore.model.value.BooleanValue;
import com.google.firebase.firestore.model.value.DoubleValue;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.GeoPointValue;
import com.google.firebase.firestore.model.value.IntegerValue;
import com.google.firebase.firestore.model.value.NullValue;
import com.google.firebase.firestore.model.value.NumberValue;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.model.value.ReferenceValue;
import com.google.firebase.firestore.model.value.StringValue;
import com.google.firebase.firestore.model.value.TimestampValue;
import com.google.firebase.firestore.remote.WatchChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.Cursor;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentChange;
import com.google.firestore.v1.DocumentDelete;
import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.DocumentRemove;
import com.google.firestore.v1.DocumentTransform;
import com.google.firestore.v1.ListenResponse;
import com.google.firestore.v1.MapValue;
import com.google.firestore.v1.Precondition;
import com.google.firestore.v1.StructuredQuery;
import com.google.firestore.v1.Target;
import com.google.firestore.v1.TargetChange;
import com.google.firestore.v1.Value;
import com.google.firestore.v1.Write;
import com.google.firestore.v1.WriteResult;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import com.google.type.LatLng;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class RemoteSerializer {
    private final DatabaseId databaseId;
    private final String databaseName;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.remote.RemoteSerializer$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static final /* synthetic */ int[] d;
        static final /* synthetic */ int[] e;
        static final /* synthetic */ int[] f;
        static final /* synthetic */ int[] g;
        static final /* synthetic */ int[] h;
        static final /* synthetic */ int[] i;
        static final /* synthetic */ int[] j;
        static final /* synthetic */ int[] k;
        static final /* synthetic */ int[] l = new int[ListenResponse.ResponseTypeCase.values().length];

        static {
            try {
                l[ListenResponse.ResponseTypeCase.TARGET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                l[ListenResponse.ResponseTypeCase.DOCUMENT_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                l[ListenResponse.ResponseTypeCase.DOCUMENT_DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                l[ListenResponse.ResponseTypeCase.DOCUMENT_REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                l[ListenResponse.ResponseTypeCase.FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                l[ListenResponse.ResponseTypeCase.RESPONSETYPE_NOT_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            k = new int[TargetChange.TargetChangeType.values().length];
            try {
                k[TargetChange.TargetChangeType.NO_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                k[TargetChange.TargetChangeType.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                k[TargetChange.TargetChangeType.REMOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                k[TargetChange.TargetChangeType.CURRENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                k[TargetChange.TargetChangeType.RESET.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                k[TargetChange.TargetChangeType.UNRECOGNIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            j = new int[StructuredQuery.Direction.values().length];
            try {
                j[StructuredQuery.Direction.ASCENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                j[StructuredQuery.Direction.DESCENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            i = new int[StructuredQuery.FieldFilter.Operator.values().length];
            try {
                i[StructuredQuery.FieldFilter.Operator.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                i[StructuredQuery.FieldFilter.Operator.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                i[StructuredQuery.FieldFilter.Operator.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                i[StructuredQuery.FieldFilter.Operator.GREATER_THAN_OR_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                i[StructuredQuery.FieldFilter.Operator.GREATER_THAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                i[StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS.ordinal()] = 6;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                i[StructuredQuery.FieldFilter.Operator.IN.ordinal()] = 7;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                i[StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS_ANY.ordinal()] = 8;
            } catch (NoSuchFieldError unused22) {
            }
            h = new int[Filter.Operator.values().length];
            try {
                h[Filter.Operator.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                h[Filter.Operator.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                h[Filter.Operator.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                h[Filter.Operator.GREATER_THAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                h[Filter.Operator.GREATER_THAN_OR_EQUAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                h[Filter.Operator.ARRAY_CONTAINS.ordinal()] = 6;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                h[Filter.Operator.IN.ordinal()] = 7;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                h[Filter.Operator.ARRAY_CONTAINS_ANY.ordinal()] = 8;
            } catch (NoSuchFieldError unused30) {
            }
            g = new int[StructuredQuery.UnaryFilter.Operator.values().length];
            try {
                g[StructuredQuery.UnaryFilter.Operator.IS_NAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                g[StructuredQuery.UnaryFilter.Operator.IS_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused32) {
            }
            f = new int[StructuredQuery.Filter.FilterTypeCase.values().length];
            try {
                f[StructuredQuery.Filter.FilterTypeCase.COMPOSITE_FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f[StructuredQuery.Filter.FilterTypeCase.FIELD_FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f[StructuredQuery.Filter.FilterTypeCase.UNARY_FILTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused35) {
            }
            e = new int[QueryPurpose.values().length];
            try {
                e[QueryPurpose.LISTEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                e[QueryPurpose.EXISTENCE_FILTER_MISMATCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                e[QueryPurpose.LIMBO_RESOLUTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused38) {
            }
            d = new int[DocumentTransform.FieldTransform.TransformTypeCase.values().length];
            try {
                d[DocumentTransform.FieldTransform.TransformTypeCase.SET_TO_SERVER_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                d[DocumentTransform.FieldTransform.TransformTypeCase.APPEND_MISSING_ELEMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                d[DocumentTransform.FieldTransform.TransformTypeCase.REMOVE_ALL_FROM_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                d[DocumentTransform.FieldTransform.TransformTypeCase.INCREMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused42) {
            }
            c = new int[Precondition.ConditionTypeCase.values().length];
            try {
                c[Precondition.ConditionTypeCase.UPDATE_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                c[Precondition.ConditionTypeCase.EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                c[Precondition.ConditionTypeCase.CONDITIONTYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused45) {
            }
            b = new int[Write.OperationCase.values().length];
            try {
                b[Write.OperationCase.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                b[Write.OperationCase.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                b[Write.OperationCase.TRANSFORM.ordinal()] = 3;
            } catch (NoSuchFieldError unused48) {
            }
            a = new int[Value.ValueTypeCase.values().length];
            try {
                a[Value.ValueTypeCase.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                a[Value.ValueTypeCase.BOOLEAN_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                a[Value.ValueTypeCase.INTEGER_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                a[Value.ValueTypeCase.DOUBLE_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                a[Value.ValueTypeCase.TIMESTAMP_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                a[Value.ValueTypeCase.GEO_POINT_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                a[Value.ValueTypeCase.BYTES_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                a[Value.ValueTypeCase.REFERENCE_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                a[Value.ValueTypeCase.STRING_VALUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                a[Value.ValueTypeCase.ARRAY_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                a[Value.ValueTypeCase.MAP_VALUE.ordinal()] = 11;
            } catch (NoSuchFieldError unused59) {
            }
        }
    }

    public RemoteSerializer(DatabaseId databaseId) {
        this.databaseId = databaseId;
        this.databaseName = encodedDatabaseId(databaseId).canonicalString();
    }

    private List<FieldValue> decodeArrayTransformElements(ArrayValue arrayValue) {
        int valuesCount = arrayValue.getValuesCount();
        ArrayList arrayList = new ArrayList(valuesCount);
        for (int i = 0; i < valuesCount; i++) {
            arrayList.add(decodeValue(arrayValue.getValues(i)));
        }
        return arrayList;
    }

    private com.google.firebase.firestore.model.value.ArrayValue decodeArrayValue(ArrayValue arrayValue) {
        int valuesCount = arrayValue.getValuesCount();
        ArrayList arrayList = new ArrayList(valuesCount);
        for (int i = 0; i < valuesCount; i++) {
            arrayList.add(decodeValue(arrayValue.getValues(i)));
        }
        return com.google.firebase.firestore.model.value.ArrayValue.fromList(arrayList);
    }

    private Bound decodeBound(Cursor cursor) {
        int valuesCount = cursor.getValuesCount();
        ArrayList arrayList = new ArrayList(valuesCount);
        for (int i = 0; i < valuesCount; i++) {
            arrayList.add(decodeValue(cursor.getValues(i)));
        }
        return new Bound(arrayList, cursor.getBefore());
    }

    private FieldMask decodeDocumentMask(DocumentMask documentMask) {
        int fieldPathsCount = documentMask.getFieldPathsCount();
        HashSet hashSet = new HashSet(fieldPathsCount);
        for (int i = 0; i < fieldPathsCount; i++) {
            hashSet.add(FieldPath.fromServerFormat(documentMask.getFieldPaths(i)));
        }
        return FieldMask.fromSet(hashSet);
    }

    private Filter.Operator decodeFieldFilterOperator(StructuredQuery.FieldFilter.Operator operator) {
        switch (AnonymousClass1.i[operator.ordinal()]) {
            case 1:
                return Filter.Operator.LESS_THAN;
            case 2:
                return Filter.Operator.LESS_THAN_OR_EQUAL;
            case 3:
                return Filter.Operator.EQUAL;
            case 4:
                return Filter.Operator.GREATER_THAN_OR_EQUAL;
            case 5:
                return Filter.Operator.GREATER_THAN;
            case 6:
                return Filter.Operator.ARRAY_CONTAINS;
            case 7:
                return Filter.Operator.IN;
            case 8:
                return Filter.Operator.ARRAY_CONTAINS_ANY;
            default:
                throw Assert.fail("Unhandled FieldFilter.operator %d", operator);
        }
    }

    private FieldTransform decodeFieldTransform(DocumentTransform.FieldTransform fieldTransform) {
        int i = AnonymousClass1.d[fieldTransform.getTransformTypeCase().ordinal()];
        if (i == 1) {
            Assert.hardAssert(fieldTransform.getSetToServerValue() == DocumentTransform.FieldTransform.ServerValue.REQUEST_TIME, "Unknown transform setToServerValue: %s", fieldTransform.getSetToServerValue());
            return new FieldTransform(FieldPath.fromServerFormat(fieldTransform.getFieldPath()), ServerTimestampOperation.getInstance());
        }
        if (i == 2) {
            return new FieldTransform(FieldPath.fromServerFormat(fieldTransform.getFieldPath()), new ArrayTransformOperation.Union(decodeArrayTransformElements(fieldTransform.getAppendMissingElements())));
        }
        if (i == 3) {
            return new FieldTransform(FieldPath.fromServerFormat(fieldTransform.getFieldPath()), new ArrayTransformOperation.Remove(decodeArrayTransformElements(fieldTransform.getRemoveAllFromArray())));
        }
        if (i != 4) {
            throw Assert.fail("Unknown FieldTransform proto: %s", fieldTransform);
        }
        FieldValue decodeValue = decodeValue(fieldTransform.getIncrement());
        Assert.hardAssert(decodeValue instanceof NumberValue, "Expected NUMERIC_ADD transform to be of number type, but was %s", decodeValue.getClass().getCanonicalName());
        return new FieldTransform(FieldPath.fromServerFormat(fieldTransform.getFieldPath()), new NumericIncrementTransformOperation((NumberValue) decodeValue(fieldTransform.getIncrement())));
    }

    private List<Filter> decodeFilters(StructuredQuery.Filter filter) {
        List<StructuredQuery.Filter> singletonList;
        Filter a;
        if (filter.getFilterTypeCase() == StructuredQuery.Filter.FilterTypeCase.COMPOSITE_FILTER) {
            Assert.hardAssert(filter.getCompositeFilter().getOp() == StructuredQuery.CompositeFilter.Operator.AND, "Only AND-type composite filters are supported, got %d", filter.getCompositeFilter().getOp());
            singletonList = filter.getCompositeFilter().getFiltersList();
        } else {
            singletonList = Collections.singletonList(filter);
        }
        ArrayList arrayList = new ArrayList(singletonList.size());
        for (StructuredQuery.Filter filter2 : singletonList) {
            int i = AnonymousClass1.f[filter2.getFilterTypeCase().ordinal()];
            if (i == 1) {
                throw Assert.fail("Nested composite filters are not supported.", new Object[0]);
            }
            if (i == 2) {
                a = a(filter2.getFieldFilter());
            } else {
                if (i != 3) {
                    throw Assert.fail("Unrecognized Filter.filterType %d", filter2.getFilterTypeCase());
                }
                a = decodeUnaryFilter(filter2.getUnaryFilter());
            }
            arrayList.add(a);
        }
        return arrayList;
    }

    private Document decodeFoundDocument(BatchGetDocumentsResponse batchGetDocumentsResponse) {
        Assert.hardAssert(batchGetDocumentsResponse.getResultCase().equals(BatchGetDocumentsResponse.ResultCase.FOUND), "Tried to deserialize a found document from a missing document.", new Object[0]);
        DocumentKey decodeKey = decodeKey(batchGetDocumentsResponse.getFound().getName());
        SnapshotVersion decodeVersion = decodeVersion(batchGetDocumentsResponse.getFound().getUpdateTime());
        Assert.hardAssert(!decodeVersion.equals(SnapshotVersion.NONE), "Got a document response with no snapshot version", new Object[0]);
        return new Document(decodeKey, decodeVersion, Document.DocumentState.SYNCED, batchGetDocumentsResponse.getFound(), RemoteSerializer$$Lambda$1.lambdaFactory$(this));
    }

    private GeoPoint decodeGeoPoint(LatLng latLng) {
        return new GeoPoint(latLng.getLatitude(), latLng.getLongitude());
    }

    private ObjectValue decodeMapValue(MapValue mapValue) {
        return decodeFields(mapValue.getFieldsMap());
    }

    private NoDocument decodeMissingDocument(BatchGetDocumentsResponse batchGetDocumentsResponse) {
        Assert.hardAssert(batchGetDocumentsResponse.getResultCase().equals(BatchGetDocumentsResponse.ResultCase.MISSING), "Tried to deserialize a missing document from a found document.", new Object[0]);
        DocumentKey decodeKey = decodeKey(batchGetDocumentsResponse.getMissing());
        SnapshotVersion decodeVersion = decodeVersion(batchGetDocumentsResponse.getReadTime());
        Assert.hardAssert(!decodeVersion.equals(SnapshotVersion.NONE), "Got a no document response with no snapshot version", new Object[0]);
        return new NoDocument(decodeKey, decodeVersion, false);
    }

    private OrderBy decodeOrderBy(StructuredQuery.Order order) {
        OrderBy.Direction direction;
        FieldPath fromServerFormat = FieldPath.fromServerFormat(order.getField().getFieldPath());
        int i = AnonymousClass1.j[order.getDirection().ordinal()];
        if (i == 1) {
            direction = OrderBy.Direction.ASCENDING;
        } else {
            if (i != 2) {
                throw Assert.fail("Unrecognized direction %d", order.getDirection());
            }
            direction = OrderBy.Direction.DESCENDING;
        }
        return OrderBy.getInstance(direction, fromServerFormat);
    }

    private com.google.firebase.firestore.model.mutation.Precondition decodePrecondition(Precondition precondition) {
        int i = AnonymousClass1.c[precondition.getConditionTypeCase().ordinal()];
        if (i == 1) {
            return com.google.firebase.firestore.model.mutation.Precondition.updateTime(decodeVersion(precondition.getUpdateTime()));
        }
        if (i == 2) {
            return com.google.firebase.firestore.model.mutation.Precondition.exists(precondition.getExists());
        }
        if (i == 3) {
            return com.google.firebase.firestore.model.mutation.Precondition.NONE;
        }
        throw Assert.fail("Unknown precondition", new Object[0]);
    }

    private ResourcePath decodeQueryPath(String str) {
        ResourcePath decodeResourceName = decodeResourceName(str);
        return decodeResourceName.length() == 4 ? ResourcePath.EMPTY : extractLocalPathFromResourceName(decodeResourceName);
    }

    private ResourcePath decodeResourceName(String str) {
        ResourcePath fromString = ResourcePath.fromString(str);
        Assert.hardAssert(isValidResourceName(fromString), "Tried to deserialize invalid key %s", fromString);
        return fromString;
    }

    private Filter decodeUnaryFilter(StructuredQuery.UnaryFilter unaryFilter) {
        Filter.Operator operator;
        FieldValue fieldValue;
        FieldPath fromServerFormat = FieldPath.fromServerFormat(unaryFilter.getField().getFieldPath());
        int i = AnonymousClass1.g[unaryFilter.getOp().ordinal()];
        if (i == 1) {
            operator = Filter.Operator.EQUAL;
            fieldValue = DoubleValue.NaN;
        } else {
            if (i != 2) {
                throw Assert.fail("Unrecognized UnaryFilter.operator %d", unaryFilter.getOp());
            }
            operator = Filter.Operator.EQUAL;
            fieldValue = NullValue.nullValue();
        }
        return FieldFilter.create(fromServerFormat, operator, fieldValue);
    }

    private ArrayValue encodeArrayTransformElements(List<FieldValue> list) {
        ArrayValue.Builder newBuilder = ArrayValue.newBuilder();
        Iterator<FieldValue> it = list.iterator();
        while (it.hasNext()) {
            newBuilder.addValues(encodeValue(it.next()));
        }
        return newBuilder.build();
    }

    private ArrayValue encodeArrayValue(com.google.firebase.firestore.model.value.ArrayValue arrayValue) {
        List<FieldValue> internalValue = arrayValue.getInternalValue();
        ArrayValue.Builder newBuilder = ArrayValue.newBuilder();
        Iterator<FieldValue> it = internalValue.iterator();
        while (it.hasNext()) {
            newBuilder.addValues(encodeValue(it.next()));
        }
        return newBuilder.build();
    }

    private Cursor encodeBound(Bound bound) {
        Cursor.Builder newBuilder = Cursor.newBuilder();
        newBuilder.setBefore(bound.isBefore());
        Iterator<FieldValue> it = bound.getPosition().iterator();
        while (it.hasNext()) {
            newBuilder.addValues(encodeValue(it.next()));
        }
        return newBuilder.build();
    }

    private DocumentMask encodeDocumentMask(FieldMask fieldMask) {
        DocumentMask.Builder newBuilder = DocumentMask.newBuilder();
        Iterator<FieldPath> it = fieldMask.getMask().iterator();
        while (it.hasNext()) {
            newBuilder.addFieldPaths(it.next().canonicalString());
        }
        return newBuilder.build();
    }

    private StructuredQuery.FieldFilter.Operator encodeFieldFilterOperator(Filter.Operator operator) {
        switch (AnonymousClass1.h[operator.ordinal()]) {
            case 1:
                return StructuredQuery.FieldFilter.Operator.LESS_THAN;
            case 2:
                return StructuredQuery.FieldFilter.Operator.LESS_THAN_OR_EQUAL;
            case 3:
                return StructuredQuery.FieldFilter.Operator.EQUAL;
            case 4:
                return StructuredQuery.FieldFilter.Operator.GREATER_THAN;
            case 5:
                return StructuredQuery.FieldFilter.Operator.GREATER_THAN_OR_EQUAL;
            case 6:
                return StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS;
            case 7:
                return StructuredQuery.FieldFilter.Operator.IN;
            case 8:
                return StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS_ANY;
            default:
                throw Assert.fail("Unknown operator %d", operator);
        }
    }

    private StructuredQuery.FieldReference encodeFieldPath(FieldPath fieldPath) {
        return StructuredQuery.FieldReference.newBuilder().setFieldPath(fieldPath.canonicalString()).build();
    }

    private DocumentTransform.FieldTransform encodeFieldTransform(FieldTransform fieldTransform) {
        DocumentTransform.FieldTransform.Builder increment;
        TransformOperation operation = fieldTransform.getOperation();
        if (operation instanceof ServerTimestampOperation) {
            increment = DocumentTransform.FieldTransform.newBuilder().setFieldPath(fieldTransform.getFieldPath().canonicalString()).setSetToServerValue(DocumentTransform.FieldTransform.ServerValue.REQUEST_TIME);
        } else if (operation instanceof ArrayTransformOperation.Union) {
            increment = DocumentTransform.FieldTransform.newBuilder().setFieldPath(fieldTransform.getFieldPath().canonicalString()).setAppendMissingElements(encodeArrayTransformElements(((ArrayTransformOperation.Union) operation).getElements()));
        } else if (operation instanceof ArrayTransformOperation.Remove) {
            increment = DocumentTransform.FieldTransform.newBuilder().setFieldPath(fieldTransform.getFieldPath().canonicalString()).setRemoveAllFromArray(encodeArrayTransformElements(((ArrayTransformOperation.Remove) operation).getElements()));
        } else {
            if (!(operation instanceof NumericIncrementTransformOperation)) {
                throw Assert.fail("Unknown transform: %s", operation);
            }
            increment = DocumentTransform.FieldTransform.newBuilder().setFieldPath(fieldTransform.getFieldPath().canonicalString()).setIncrement(encodeValue(((NumericIncrementTransformOperation) operation).getOperand()));
        }
        return increment.build();
    }

    private StructuredQuery.Filter encodeFilters(List<Filter> list) {
        Object build;
        ArrayList arrayList = new ArrayList(list.size());
        for (Filter filter : list) {
            if (filter instanceof FieldFilter) {
                arrayList.add(a((FieldFilter) filter));
            }
        }
        if (list.size() == 1) {
            build = arrayList.get(0);
        } else {
            StructuredQuery.CompositeFilter.Builder newBuilder = StructuredQuery.CompositeFilter.newBuilder();
            newBuilder.setOp(StructuredQuery.CompositeFilter.Operator.AND);
            newBuilder.addAllFilters(arrayList);
            build = StructuredQuery.Filter.newBuilder().setCompositeFilter(newBuilder).build();
        }
        return (StructuredQuery.Filter) build;
    }

    private LatLng encodeGeoPoint(GeoPoint geoPoint) {
        return LatLng.newBuilder().setLatitude(geoPoint.getLatitude()).setLongitude(geoPoint.getLongitude()).build();
    }

    @Nullable
    private String encodeLabel(QueryPurpose queryPurpose) {
        int i = AnonymousClass1.e[queryPurpose.ordinal()];
        if (i == 1) {
            return null;
        }
        if (i == 2) {
            return "existence-filter-mismatch";
        }
        if (i == 3) {
            return "limbo-document";
        }
        throw Assert.fail("Unrecognized query purpose: %s", queryPurpose);
    }

    private MapValue encodeMapValue(ObjectValue objectValue) {
        MapValue.Builder newBuilder = MapValue.newBuilder();
        Iterator<Map.Entry<String, FieldValue>> it = objectValue.getInternalValue().iterator();
        while (it.hasNext()) {
            Map.Entry<String, FieldValue> next = it.next();
            newBuilder.putFields(next.getKey(), encodeValue(next.getValue()));
        }
        return newBuilder.build();
    }

    private StructuredQuery.Order encodeOrderBy(OrderBy orderBy) {
        StructuredQuery.Order.Builder newBuilder = StructuredQuery.Order.newBuilder();
        newBuilder.setDirection(orderBy.getDirection().equals(OrderBy.Direction.ASCENDING) ? StructuredQuery.Direction.ASCENDING : StructuredQuery.Direction.DESCENDING);
        newBuilder.setField(encodeFieldPath(orderBy.getField()));
        return newBuilder.build();
    }

    private Precondition encodePrecondition(com.google.firebase.firestore.model.mutation.Precondition precondition) {
        Precondition.Builder exists;
        Assert.hardAssert(!precondition.isNone(), "Can't serialize an empty precondition", new Object[0]);
        Precondition.Builder newBuilder = Precondition.newBuilder();
        if (precondition.getUpdateTime() != null) {
            exists = newBuilder.setUpdateTime(encodeVersion(precondition.getUpdateTime()));
        } else {
            if (precondition.getExists() == null) {
                throw Assert.fail("Unknown Precondition", new Object[0]);
            }
            exists = newBuilder.setExists(precondition.getExists().booleanValue());
        }
        return exists.build();
    }

    private String encodeQueryPath(ResourcePath resourcePath) {
        return encodeResourceName(this.databaseId, resourcePath);
    }

    private String encodeResourceName(DatabaseId databaseId, ResourcePath resourcePath) {
        return encodedDatabaseId(databaseId).append("documents").append(resourcePath).canonicalString();
    }

    private static ResourcePath encodedDatabaseId(DatabaseId databaseId) {
        return ResourcePath.fromSegments(Arrays.asList("projects", databaseId.getProjectId(), "databases", databaseId.getDatabaseId()));
    }

    private static ResourcePath extractLocalPathFromResourceName(ResourcePath resourcePath) {
        Assert.hardAssert(resourcePath.length() > 4 && resourcePath.getSegment(4).equals("documents"), "Tried to deserialize invalid key %s", resourcePath);
        return resourcePath.popFirst(5);
    }

    private Status fromStatus(com.google.rpc.Status status) {
        return Status.fromCodeValue(status.getCode()).withDescription(status.getMessage());
    }

    private static boolean isValidResourceName(ResourcePath resourcePath) {
        return resourcePath.length() >= 4 && resourcePath.getSegment(0).equals("projects") && resourcePath.getSegment(2).equals("databases");
    }

    @VisibleForTesting
    FieldFilter a(StructuredQuery.FieldFilter fieldFilter) {
        return FieldFilter.create(FieldPath.fromServerFormat(fieldFilter.getField().getFieldPath()), decodeFieldFilterOperator(fieldFilter.getOp()), decodeValue(fieldFilter.getValue()));
    }

    @VisibleForTesting
    StructuredQuery.Filter a(FieldFilter fieldFilter) {
        StructuredQuery.Filter.Builder fieldFilter2;
        StructuredQuery.UnaryFilter.Operator operator;
        if (fieldFilter.getOperator() == Filter.Operator.EQUAL) {
            StructuredQuery.UnaryFilter.Builder newBuilder = StructuredQuery.UnaryFilter.newBuilder();
            newBuilder.setField(encodeFieldPath(fieldFilter.getField()));
            if (fieldFilter.getValue().equals(DoubleValue.NaN)) {
                operator = StructuredQuery.UnaryFilter.Operator.IS_NAN;
            } else if (fieldFilter.getValue().equals(NullValue.nullValue())) {
                operator = StructuredQuery.UnaryFilter.Operator.IS_NULL;
            }
            newBuilder.setOp(operator);
            fieldFilter2 = StructuredQuery.Filter.newBuilder().setUnaryFilter(newBuilder);
            return fieldFilter2.build();
        }
        StructuredQuery.FieldFilter.Builder newBuilder2 = StructuredQuery.FieldFilter.newBuilder();
        newBuilder2.setField(encodeFieldPath(fieldFilter.getField()));
        newBuilder2.setOp(encodeFieldFilterOperator(fieldFilter.getOperator()));
        newBuilder2.setValue(encodeValue(fieldFilter.getValue()));
        fieldFilter2 = StructuredQuery.Filter.newBuilder().setFieldFilter(newBuilder2);
        return fieldFilter2.build();
    }

    public String databaseName() {
        return this.databaseName;
    }

    public Target decodeDocumentsTarget(Target.DocumentsTarget documentsTarget) {
        int documentsCount = documentsTarget.getDocumentsCount();
        Assert.hardAssert(documentsCount == 1, "DocumentsTarget contained other than 1 document %d", Integer.valueOf(documentsCount));
        return Query.atPath(decodeQueryPath(documentsTarget.getDocuments(0))).toTarget();
    }

    public ObjectValue decodeFields(Map<String, Value> map) {
        ObjectValue emptyObject = ObjectValue.emptyObject();
        for (Map.Entry<String, Value> entry : map.entrySet()) {
            emptyObject = emptyObject.set(FieldPath.fromSingleSegment(entry.getKey()), decodeValue(entry.getValue()));
        }
        return emptyObject;
    }

    public DocumentKey decodeKey(String str) {
        ResourcePath decodeResourceName = decodeResourceName(str);
        Assert.hardAssert(decodeResourceName.getSegment(1).equals(this.databaseId.getProjectId()), "Tried to deserialize key from different project.", new Object[0]);
        Assert.hardAssert(decodeResourceName.getSegment(3).equals(this.databaseId.getDatabaseId()), "Tried to deserialize key from different database.", new Object[0]);
        return DocumentKey.fromPath(extractLocalPathFromResourceName(decodeResourceName));
    }

    public MaybeDocument decodeMaybeDocument(BatchGetDocumentsResponse batchGetDocumentsResponse) {
        if (batchGetDocumentsResponse.getResultCase().equals(BatchGetDocumentsResponse.ResultCase.FOUND)) {
            return decodeFoundDocument(batchGetDocumentsResponse);
        }
        if (batchGetDocumentsResponse.getResultCase().equals(BatchGetDocumentsResponse.ResultCase.MISSING)) {
            return decodeMissingDocument(batchGetDocumentsResponse);
        }
        throw new IllegalArgumentException("Unknown result case: " + batchGetDocumentsResponse.getResultCase());
    }

    public Mutation decodeMutation(Write write) {
        com.google.firebase.firestore.model.mutation.Precondition decodePrecondition = write.hasCurrentDocument() ? decodePrecondition(write.getCurrentDocument()) : com.google.firebase.firestore.model.mutation.Precondition.NONE;
        int i = AnonymousClass1.b[write.getOperationCase().ordinal()];
        if (i == 1) {
            return write.hasUpdateMask() ? new PatchMutation(decodeKey(write.getUpdate().getName()), decodeFields(write.getUpdate().getFieldsMap()), decodeDocumentMask(write.getUpdateMask()), decodePrecondition) : new SetMutation(decodeKey(write.getUpdate().getName()), decodeFields(write.getUpdate().getFieldsMap()), decodePrecondition);
        }
        if (i == 2) {
            return new DeleteMutation(decodeKey(write.getDelete()), decodePrecondition);
        }
        if (i != 3) {
            throw Assert.fail("Unknown mutation operation: %d", write.getOperationCase());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<DocumentTransform.FieldTransform> it = write.getTransform().getFieldTransformsList().iterator();
        while (it.hasNext()) {
            arrayList.add(decodeFieldTransform(it.next()));
        }
        Boolean exists = decodePrecondition.getExists();
        Assert.hardAssert(exists != null && exists.booleanValue(), "Transforms only support precondition \"exists == true\"", new Object[0]);
        return new TransformMutation(decodeKey(write.getTransform().getDocument()), arrayList);
    }

    public MutationResult decodeMutationResult(WriteResult writeResult, SnapshotVersion snapshotVersion) {
        SnapshotVersion decodeVersion = decodeVersion(writeResult.getUpdateTime());
        if (!SnapshotVersion.NONE.equals(decodeVersion)) {
            snapshotVersion = decodeVersion;
        }
        ArrayList arrayList = null;
        int transformResultsCount = writeResult.getTransformResultsCount();
        if (transformResultsCount > 0) {
            arrayList = new ArrayList(transformResultsCount);
            for (int i = 0; i < transformResultsCount; i++) {
                arrayList.add(decodeValue(writeResult.getTransformResults(i)));
            }
        }
        return new MutationResult(snapshotVersion, arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.firebase.firestore.core.Target decodeQueryTarget(com.google.firestore.v1.Target.QueryTarget r15) {
        /*
            r14 = this;
            java.lang.String r0 = r15.getParent()
            com.google.firebase.firestore.model.ResourcePath r0 = r14.decodeQueryPath(r0)
            com.google.firestore.v1.StructuredQuery r15 = r15.getStructuredQuery()
            int r1 = r15.getFromCount()
            r2 = 0
            r3 = 0
            if (r1 <= 0) goto L37
            r4 = 1
            if (r1 != r4) goto L18
            goto L19
        L18:
            r4 = 0
        L19:
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r5 = "StructuredQuery.from with more than one collection is not supported."
            com.google.firebase.firestore.util.Assert.hardAssert(r4, r5, r1)
            com.google.firestore.v1.StructuredQuery$CollectionSelector r1 = r15.getFrom(r3)
            boolean r4 = r1.getAllDescendants()
            java.lang.String r1 = r1.getCollectionId()
            if (r4 == 0) goto L31
            r5 = r0
            r6 = r1
            goto L39
        L31:
            com.google.firebase.firestore.model.BasePath r0 = r0.append(r1)
            com.google.firebase.firestore.model.ResourcePath r0 = (com.google.firebase.firestore.model.ResourcePath) r0
        L37:
            r5 = r0
            r6 = r2
        L39:
            boolean r0 = r15.hasWhere()
            if (r0 == 0) goto L48
            com.google.firestore.v1.StructuredQuery$Filter r0 = r15.getWhere()
            java.util.List r0 = r14.decodeFilters(r0)
            goto L4c
        L48:
            java.util.List r0 = java.util.Collections.emptyList()
        L4c:
            r7 = r0
            int r0 = r15.getOrderByCount()
            if (r0 <= 0) goto L6a
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
        L58:
            if (r3 >= r0) goto L68
            com.google.firestore.v1.StructuredQuery$Order r4 = r15.getOrderBy(r3)
            com.google.firebase.firestore.core.OrderBy r4 = r14.decodeOrderBy(r4)
            r1.add(r4)
            int r3 = r3 + 1
            goto L58
        L68:
            r8 = r1
            goto L6f
        L6a:
            java.util.List r0 = java.util.Collections.emptyList()
            r8 = r0
        L6f:
            r0 = -1
            boolean r3 = r15.hasLimit()
            if (r3 == 0) goto L80
            com.google.protobuf.Int32Value r0 = r15.getLimit()
            int r0 = r0.getValue()
            long r0 = (long) r0
        L80:
            r9 = r0
            boolean r0 = r15.hasStartAt()
            if (r0 == 0) goto L91
            com.google.firestore.v1.Cursor r0 = r15.getStartAt()
            com.google.firebase.firestore.core.Bound r0 = r14.decodeBound(r0)
            r12 = r0
            goto L92
        L91:
            r12 = r2
        L92:
            boolean r0 = r15.hasEndAt()
            if (r0 == 0) goto La0
            com.google.firestore.v1.Cursor r15 = r15.getEndAt()
            com.google.firebase.firestore.core.Bound r2 = r14.decodeBound(r15)
        La0:
            r13 = r2
            com.google.firebase.firestore.core.Query r15 = new com.google.firebase.firestore.core.Query
            com.google.firebase.firestore.core.Query$LimitType r11 = com.google.firebase.firestore.core.Query.LimitType.LIMIT_TO_FIRST
            r4 = r15
            r4.<init>(r5, r6, r7, r8, r9, r11, r12, r13)
            com.google.firebase.firestore.core.Target r15 = r15.toTarget()
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.remote.RemoteSerializer.decodeQueryTarget(com.google.firestore.v1.Target$QueryTarget):com.google.firebase.firestore.core.Target");
    }

    public Timestamp decodeTimestamp(com.google.protobuf.Timestamp timestamp) {
        return new Timestamp(timestamp.getSeconds(), timestamp.getNanos());
    }

    public FieldValue decodeValue(Value value) {
        switch (AnonymousClass1.a[value.getValueTypeCase().ordinal()]) {
            case 1:
                return NullValue.nullValue();
            case 2:
                return BooleanValue.valueOf(Boolean.valueOf(value.getBooleanValue()));
            case 3:
                return IntegerValue.valueOf(Long.valueOf(value.getIntegerValue()));
            case 4:
                return DoubleValue.valueOf(Double.valueOf(value.getDoubleValue()));
            case 5:
                return TimestampValue.valueOf(decodeTimestamp(value.getTimestampValue()));
            case 6:
                return GeoPointValue.valueOf(decodeGeoPoint(value.getGeoPointValue()));
            case 7:
                return BlobValue.valueOf(Blob.fromByteString(value.getBytesValue()));
            case 8:
                ResourcePath decodeResourceName = decodeResourceName(value.getReferenceValue());
                return ReferenceValue.valueOf(DatabaseId.forDatabase(decodeResourceName.getSegment(1), decodeResourceName.getSegment(3)), DocumentKey.fromPath(extractLocalPathFromResourceName(decodeResourceName)));
            case 9:
                return StringValue.valueOf(value.getStringValue());
            case 10:
                return decodeArrayValue(value.getArrayValue());
            case 11:
                return decodeMapValue(value.getMapValue());
            default:
                throw Assert.fail("Unknown value %s", value);
        }
    }

    public SnapshotVersion decodeVersion(com.google.protobuf.Timestamp timestamp) {
        return (timestamp.getSeconds() == 0 && timestamp.getNanos() == 0) ? SnapshotVersion.NONE : new SnapshotVersion(decodeTimestamp(timestamp));
    }

    public SnapshotVersion decodeVersionFromListenResponse(ListenResponse listenResponse) {
        if (listenResponse.getResponseTypeCase() == ListenResponse.ResponseTypeCase.TARGET_CHANGE && listenResponse.getTargetChange().getTargetIdsCount() == 0) {
            return decodeVersion(listenResponse.getTargetChange().getReadTime());
        }
        return SnapshotVersion.NONE;
    }

    public WatchChange decodeWatchChange(ListenResponse listenResponse) {
        WatchChange.WatchTargetChangeType watchTargetChangeType;
        WatchChange watchTargetChange;
        int i = AnonymousClass1.l[listenResponse.getResponseTypeCase().ordinal()];
        Status status = null;
        if (i == 1) {
            com.google.firestore.v1.TargetChange targetChange = listenResponse.getTargetChange();
            int i2 = AnonymousClass1.k[targetChange.getTargetChangeType().ordinal()];
            if (i2 == 1) {
                watchTargetChangeType = WatchChange.WatchTargetChangeType.NoChange;
            } else if (i2 == 2) {
                watchTargetChangeType = WatchChange.WatchTargetChangeType.Added;
            } else if (i2 == 3) {
                watchTargetChangeType = WatchChange.WatchTargetChangeType.Removed;
                status = fromStatus(targetChange.getCause());
            } else if (i2 == 4) {
                watchTargetChangeType = WatchChange.WatchTargetChangeType.Current;
            } else {
                if (i2 != 5) {
                    throw new IllegalArgumentException("Unknown target change type");
                }
                watchTargetChangeType = WatchChange.WatchTargetChangeType.Reset;
            }
            watchTargetChange = new WatchChange.WatchTargetChange(watchTargetChangeType, targetChange.getTargetIdsList(), targetChange.getResumeToken(), status);
        } else {
            if (i == 2) {
                DocumentChange documentChange = listenResponse.getDocumentChange();
                List<Integer> targetIdsList = documentChange.getTargetIdsList();
                List<Integer> removedTargetIdsList = documentChange.getRemovedTargetIdsList();
                DocumentKey decodeKey = decodeKey(documentChange.getDocument().getName());
                SnapshotVersion decodeVersion = decodeVersion(documentChange.getDocument().getUpdateTime());
                Assert.hardAssert(!decodeVersion.equals(SnapshotVersion.NONE), "Got a document change without an update time", new Object[0]);
                Document document = new Document(decodeKey, decodeVersion, Document.DocumentState.SYNCED, documentChange.getDocument(), RemoteSerializer$$Lambda$2.lambdaFactory$(this));
                return new WatchChange.DocumentChange(targetIdsList, removedTargetIdsList, document.getKey(), document);
            }
            if (i == 3) {
                DocumentDelete documentDelete = listenResponse.getDocumentDelete();
                List<Integer> removedTargetIdsList2 = documentDelete.getRemovedTargetIdsList();
                NoDocument noDocument = new NoDocument(decodeKey(documentDelete.getDocument()), decodeVersion(documentDelete.getReadTime()), false);
                return new WatchChange.DocumentChange(Collections.emptyList(), removedTargetIdsList2, noDocument.getKey(), noDocument);
            }
            if (i != 4) {
                if (i != 5) {
                    throw new IllegalArgumentException("Unknown change type set");
                }
                com.google.firestore.v1.ExistenceFilter filter = listenResponse.getFilter();
                return new WatchChange.ExistenceFilterWatchChange(filter.getTargetId(), new ExistenceFilter(filter.getCount()));
            }
            DocumentRemove documentRemove = listenResponse.getDocumentRemove();
            watchTargetChange = new WatchChange.DocumentChange(Collections.emptyList(), documentRemove.getRemovedTargetIdsList(), decodeKey(documentRemove.getDocument()), null);
        }
        return watchTargetChange;
    }

    public com.google.firestore.v1.Document encodeDocument(DocumentKey documentKey, ObjectValue objectValue) {
        Document.Builder newBuilder = com.google.firestore.v1.Document.newBuilder();
        newBuilder.setName(encodeKey(documentKey));
        Iterator<Map.Entry<String, FieldValue>> it = objectValue.getInternalValue().iterator();
        while (it.hasNext()) {
            Map.Entry<String, FieldValue> next = it.next();
            newBuilder.putFields(next.getKey(), encodeValue(next.getValue()));
        }
        return newBuilder.build();
    }

    public Target.DocumentsTarget encodeDocumentsTarget(com.google.firebase.firestore.core.Target target) {
        Target.DocumentsTarget.Builder newBuilder = Target.DocumentsTarget.newBuilder();
        newBuilder.addDocuments(encodeQueryPath(target.getPath()));
        return newBuilder.build();
    }

    public String encodeKey(DocumentKey documentKey) {
        return encodeResourceName(this.databaseId, documentKey.getPath());
    }

    @Nullable
    public Map<String, String> encodeListenRequestLabels(QueryData queryData) {
        String encodeLabel = encodeLabel(queryData.getPurpose());
        if (encodeLabel == null) {
            return null;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("goog-listen-tags", encodeLabel);
        return hashMap;
    }

    public Write encodeMutation(Mutation mutation) {
        Write.Builder newBuilder = Write.newBuilder();
        if (mutation instanceof SetMutation) {
            newBuilder.setUpdate(encodeDocument(mutation.getKey(), ((SetMutation) mutation).getValue()));
        } else if (mutation instanceof PatchMutation) {
            PatchMutation patchMutation = (PatchMutation) mutation;
            newBuilder.setUpdate(encodeDocument(mutation.getKey(), patchMutation.getValue()));
            newBuilder.setUpdateMask(encodeDocumentMask(patchMutation.getMask()));
        } else if (mutation instanceof TransformMutation) {
            TransformMutation transformMutation = (TransformMutation) mutation;
            DocumentTransform.Builder newBuilder2 = DocumentTransform.newBuilder();
            newBuilder2.setDocument(encodeKey(transformMutation.getKey()));
            Iterator<FieldTransform> it = transformMutation.getFieldTransforms().iterator();
            while (it.hasNext()) {
                newBuilder2.addFieldTransforms(encodeFieldTransform(it.next()));
            }
            newBuilder.setTransform(newBuilder2);
        } else {
            if (!(mutation instanceof DeleteMutation)) {
                throw Assert.fail("unknown mutation type %s", mutation.getClass());
            }
            newBuilder.setDelete(encodeKey(mutation.getKey()));
        }
        if (!mutation.getPrecondition().isNone()) {
            newBuilder.setCurrentDocument(encodePrecondition(mutation.getPrecondition()));
        }
        return newBuilder.build();
    }

    public Target.QueryTarget encodeQueryTarget(com.google.firebase.firestore.core.Target target) {
        Target.QueryTarget.Builder newBuilder = Target.QueryTarget.newBuilder();
        StructuredQuery.Builder newBuilder2 = StructuredQuery.newBuilder();
        ResourcePath path = target.getPath();
        if (target.getCollectionGroup() != null) {
            Assert.hardAssert(path.length() % 2 == 0, "Collection Group queries should be within a document path or root.", new Object[0]);
            newBuilder.setParent(encodeQueryPath(path));
            StructuredQuery.CollectionSelector.Builder newBuilder3 = StructuredQuery.CollectionSelector.newBuilder();
            newBuilder3.setCollectionId(target.getCollectionGroup());
            newBuilder3.setAllDescendants(true);
            newBuilder2.addFrom(newBuilder3);
        } else {
            Assert.hardAssert(path.length() % 2 != 0, "Document queries with filters are not supported.", new Object[0]);
            newBuilder.setParent(encodeQueryPath(path.popLast()));
            StructuredQuery.CollectionSelector.Builder newBuilder4 = StructuredQuery.CollectionSelector.newBuilder();
            newBuilder4.setCollectionId(path.getLastSegment());
            newBuilder2.addFrom(newBuilder4);
        }
        if (target.getFilters().size() > 0) {
            newBuilder2.setWhere(encodeFilters(target.getFilters()));
        }
        Iterator<OrderBy> it = target.getOrderBy().iterator();
        while (it.hasNext()) {
            newBuilder2.addOrderBy(encodeOrderBy(it.next()));
        }
        if (target.hasLimit()) {
            newBuilder2.setLimit(Int32Value.newBuilder().setValue((int) target.getLimit()));
        }
        if (target.getStartAt() != null) {
            newBuilder2.setStartAt(encodeBound(target.getStartAt()));
        }
        if (target.getEndAt() != null) {
            newBuilder2.setEndAt(encodeBound(target.getEndAt()));
        }
        newBuilder.setStructuredQuery(newBuilder2);
        return newBuilder.build();
    }

    public com.google.firestore.v1.Target encodeTarget(QueryData queryData) {
        Target.Builder newBuilder = com.google.firestore.v1.Target.newBuilder();
        com.google.firebase.firestore.core.Target target = queryData.getTarget();
        if (target.isDocumentQuery()) {
            newBuilder.setDocuments(encodeDocumentsTarget(target));
        } else {
            newBuilder.setQuery(encodeQueryTarget(target));
        }
        newBuilder.setTargetId(queryData.getTargetId());
        newBuilder.setResumeToken(queryData.getResumeToken());
        return newBuilder.build();
    }

    public com.google.protobuf.Timestamp encodeTimestamp(Timestamp timestamp) {
        Timestamp.Builder newBuilder = com.google.protobuf.Timestamp.newBuilder();
        newBuilder.setSeconds(timestamp.getSeconds());
        newBuilder.setNanos(timestamp.getNanoseconds());
        return newBuilder.build();
    }

    public Value encodeValue(FieldValue fieldValue) {
        Value.Builder newBuilder = Value.newBuilder();
        if (fieldValue instanceof NullValue) {
            newBuilder.setNullValueValue(0);
        } else {
            Object value = fieldValue.value();
            Assert.hardAssert(value != null, "Encoded field value should not be null.", new Object[0]);
            if (fieldValue instanceof BooleanValue) {
                newBuilder.setBooleanValue(((Boolean) value).booleanValue());
            } else if (fieldValue instanceof IntegerValue) {
                newBuilder.setIntegerValue(((Long) value).longValue());
            } else if (fieldValue instanceof DoubleValue) {
                newBuilder.setDoubleValue(((Double) value).doubleValue());
            } else if (fieldValue instanceof StringValue) {
                newBuilder.setStringValue((String) value);
            } else if (fieldValue instanceof com.google.firebase.firestore.model.value.ArrayValue) {
                newBuilder.setArrayValue(encodeArrayValue((com.google.firebase.firestore.model.value.ArrayValue) fieldValue));
            } else if (fieldValue instanceof ObjectValue) {
                newBuilder.setMapValue(encodeMapValue((ObjectValue) fieldValue));
            } else if (fieldValue instanceof TimestampValue) {
                newBuilder.setTimestampValue(encodeTimestamp(((TimestampValue) fieldValue).getInternalValue()));
            } else if (fieldValue instanceof GeoPointValue) {
                newBuilder.setGeoPointValue(encodeGeoPoint((GeoPoint) value));
            } else if (fieldValue instanceof BlobValue) {
                newBuilder.setBytesValue(((Blob) value).toByteString());
            } else {
                if (!(fieldValue instanceof ReferenceValue)) {
                    throw Assert.fail("Can't serialize %s", fieldValue);
                }
                newBuilder.setReferenceValue(encodeResourceName(((ReferenceValue) fieldValue).getDatabaseId(), ((DocumentKey) value).getPath()));
            }
        }
        return newBuilder.build();
    }

    public com.google.protobuf.Timestamp encodeVersion(SnapshotVersion snapshotVersion) {
        return encodeTimestamp(snapshotVersion.getTimestamp());
    }
}
