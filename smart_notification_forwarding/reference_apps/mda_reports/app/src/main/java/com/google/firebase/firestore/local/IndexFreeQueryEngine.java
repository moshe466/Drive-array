package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Logger;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class IndexFreeQueryEngine implements QueryEngine {
    private static final String LOG_TAG = "IndexFreeQueryEngine";
    private LocalDocumentsView localDocumentsView;

    private ImmutableSortedSet<Document> applyQuery(Query query, ImmutableSortedMap<DocumentKey, MaybeDocument> immutableSortedMap) {
        ImmutableSortedSet<Document> immutableSortedSet = new ImmutableSortedSet<>(Collections.emptyList(), query.comparator());
        Iterator<Map.Entry<DocumentKey, MaybeDocument>> it = immutableSortedMap.iterator();
        while (it.hasNext()) {
            MaybeDocument value = it.next().getValue();
            if (value instanceof Document) {
                Document document = (Document) value;
                if (query.matches(document)) {
                    immutableSortedSet = immutableSortedSet.insert(document);
                }
            }
        }
        return immutableSortedSet;
    }

    private ImmutableSortedMap<DocumentKey, Document> executeFullCollectionScan(Query query) {
        if (Logger.isDebugEnabled()) {
            Logger.debug(LOG_TAG, "Using full collection scan to execute query: %s", query.toString());
        }
        return this.localDocumentsView.a(query, SnapshotVersion.NONE);
    }

    private boolean needsRefill(Query.LimitType limitType, ImmutableSortedSet<Document> immutableSortedSet, ImmutableSortedSet<DocumentKey> immutableSortedSet2, SnapshotVersion snapshotVersion) {
        if (immutableSortedSet2.size() != immutableSortedSet.size()) {
            return true;
        }
        Document maxEntry = limitType == Query.LimitType.LIMIT_TO_FIRST ? immutableSortedSet.getMaxEntry() : immutableSortedSet.getMinEntry();
        if (maxEntry == null) {
            return false;
        }
        return maxEntry.hasPendingWrites() || maxEntry.getVersion().compareTo(snapshotVersion) > 0;
    }

    @Override // com.google.firebase.firestore.local.QueryEngine
    public ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingQuery(Query query, SnapshotVersion snapshotVersion, ImmutableSortedSet<DocumentKey> immutableSortedSet) {
        Assert.hardAssert(this.localDocumentsView != null, "setLocalDocumentsView() not called", new Object[0]);
        if (!query.matchesAllDocuments() && !snapshotVersion.equals(SnapshotVersion.NONE)) {
            ImmutableSortedSet<Document> applyQuery = applyQuery(query, this.localDocumentsView.a(immutableSortedSet));
            if ((query.hasLimitToFirst() || query.hasLimitToLast()) && needsRefill(query.getLimitType(), applyQuery, immutableSortedSet, snapshotVersion)) {
                return executeFullCollectionScan(query);
            }
            if (Logger.isDebugEnabled()) {
                Logger.debug(LOG_TAG, "Re-using previous result from %s to execute query: %s", snapshotVersion.toString(), query.toString());
            }
            ImmutableSortedMap<DocumentKey, Document> a = this.localDocumentsView.a(query, snapshotVersion);
            Iterator<Document> it = applyQuery.iterator();
            while (it.hasNext()) {
                Document next = it.next();
                a = a.insert(next.getKey(), next);
            }
            return a;
        }
        return executeFullCollectionScan(query);
    }

    @Override // com.google.firebase.firestore.local.QueryEngine
    public void handleDocumentChange(MaybeDocument maybeDocument, MaybeDocument maybeDocument2) {
    }

    @Override // com.google.firebase.firestore.local.QueryEngine
    public void setLocalDocumentsView(LocalDocumentsView localDocumentsView) {
        this.localDocumentsView = localDocumentsView;
    }
}
