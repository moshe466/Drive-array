package com.google.firebase.firestore.local;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.IndexRange;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.BooleanValue;
import com.google.firebase.firestore.model.value.DoubleValue;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class IndexedQueryEngine implements QueryEngine {
    private static final double HIGH_SELECTIVITY = 1.0d;
    private static final double LOW_SELECTIVITY = 0.5d;
    private static final List<Class> lowCardinalityTypes = Arrays.asList(BooleanValue.class, ArrayValue.class, ObjectValue.class);
    private final SQLiteCollectionIndex collectionIndex;
    private LocalDocumentsView localDocuments;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.local.IndexedQueryEngine$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Filter.Operator.values().length];

        static {
            try {
                a[Filter.Operator.EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Filter.Operator.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Filter.Operator.LESS_THAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Filter.Operator.GREATER_THAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Filter.Operator.GREATER_THAN_OR_EQUAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public IndexedQueryEngine(SQLiteCollectionIndex sQLiteCollectionIndex) {
        this.collectionIndex = sQLiteCollectionIndex;
    }

    @Nullable
    @VisibleForTesting
    static IndexRange a(Query query) {
        Filter filter = null;
        if (query.getFilters().isEmpty()) {
            if (query.getOrderBy().get(0).getField().equals(FieldPath.KEY_PATH)) {
                return null;
            }
            return IndexRange.builder().setFieldPath(query.getOrderBy().get(0).getField()).build();
        }
        double d = -1.0d;
        for (Filter filter2 : query.getFilters()) {
            double estimateFilterSelectivity = estimateFilterSelectivity(filter2);
            if (estimateFilterSelectivity > d) {
                filter = filter2;
                d = estimateFilterSelectivity;
            }
        }
        Assert.hardAssert(filter != null, "Filter should be defined", new Object[0]);
        return convertFilterToIndexRange(filter);
    }

    private static IndexRange convertFilterToIndexRange(Filter filter) {
        IndexRange.Builder fieldPath = IndexRange.builder().setFieldPath(filter.getField());
        if (filter instanceof FieldFilter) {
            FieldFilter fieldFilter = (FieldFilter) filter;
            FieldValue value = fieldFilter.getValue();
            int i = AnonymousClass1.a[fieldFilter.getOperator().ordinal()];
            if (i == 1) {
                fieldPath.setStart(value).setEnd(value);
            } else if (i == 2 || i == 3) {
                fieldPath.setEnd(value);
            } else {
                if (i != 4 && i != 5) {
                    throw Assert.fail("Unexpected operator in query filter", new Object[0]);
                }
                fieldPath.setStart(value);
            }
        }
        return fieldPath.build();
    }

    private static double estimateFilterSelectivity(Filter filter) {
        Assert.hardAssert(filter instanceof FieldFilter, "Filter type expected to be FieldFilter", new Object[0]);
        FieldFilter fieldFilter = (FieldFilter) filter;
        boolean equals = fieldFilter.getValue().equals(null);
        double d = HIGH_SELECTIVITY;
        if (equals || fieldFilter.getValue().equals(DoubleValue.NaN)) {
            return HIGH_SELECTIVITY;
        }
        double d2 = fieldFilter.getOperator().equals(Filter.Operator.EQUAL) ? 1.0d : 0.5d;
        if (lowCardinalityTypes.contains(fieldFilter.getValue().getClass())) {
            d = 0.5d;
        }
        return d * d2;
    }

    private ImmutableSortedMap<DocumentKey, Document> performCollectionQuery(Query query) {
        Assert.hardAssert(!query.isDocumentQuery(), "matchesCollectionQuery() called with document query.", new Object[0]);
        IndexRange a = a(query);
        if (a != null) {
            return performQueryUsingIndex(query, a);
        }
        Assert.hardAssert(query.getFilters().isEmpty(), "If there are any filters, we should be able to use an index.", new Object[0]);
        return this.localDocuments.a(query, SnapshotVersion.NONE);
    }

    private ImmutableSortedMap<DocumentKey, Document> performQueryUsingIndex(Query query, IndexRange indexRange) {
        ImmutableSortedMap<DocumentKey, Document> emptyDocumentMap = DocumentCollections.emptyDocumentMap();
        IndexCursor cursor = this.collectionIndex.getCursor(query.getPath(), indexRange);
        while (cursor.next()) {
            try {
                Document document = (Document) this.localDocuments.a(cursor.getDocumentKey());
                if (query.matches(document)) {
                    emptyDocumentMap = emptyDocumentMap.insert(cursor.getDocumentKey(), document);
                }
            } finally {
                cursor.close();
            }
        }
        return emptyDocumentMap;
    }

    @Override // com.google.firebase.firestore.local.QueryEngine
    public ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingQuery(Query query, SnapshotVersion snapshotVersion, ImmutableSortedSet<DocumentKey> immutableSortedSet) {
        Assert.hardAssert(this.localDocuments != null, "setLocalDocumentsView() not called", new Object[0]);
        return query.isDocumentQuery() ? this.localDocuments.a(query, SnapshotVersion.NONE) : performCollectionQuery(query);
    }

    @Override // com.google.firebase.firestore.local.QueryEngine
    public void handleDocumentChange(MaybeDocument maybeDocument, MaybeDocument maybeDocument2) {
        throw new RuntimeException("Not yet implemented.");
    }

    @Override // com.google.firebase.firestore.local.QueryEngine
    public void setLocalDocumentsView(LocalDocumentsView localDocumentsView) {
        this.localDocuments = localDocumentsView;
    }
}
