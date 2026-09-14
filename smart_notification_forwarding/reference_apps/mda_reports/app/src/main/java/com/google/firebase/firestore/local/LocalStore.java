package com.google.firebase.firestore.local;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.core.TargetIdGenerator;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.model.mutation.PatchMutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class LocalStore {
    private static final long RESUME_TOKEN_MAX_AGE_SECONDS = TimeUnit.MINUTES.toSeconds(5);
    private LocalDocumentsView localDocuments;
    private final ReferenceSet localViewReferences;
    private MutationQueue mutationQueue;
    private final Persistence persistence;
    private final QueryCache queryCache;
    private final SparseArray<QueryData> queryDataByTarget;
    private QueryEngine queryEngine;
    private final RemoteDocumentCache remoteDocuments;
    private final Map<Target, Integer> targetIdByTarget;
    private final TargetIdGenerator targetIdGenerator;

    /* loaded from: classes2.dex */
    public static class AllocateQueryHolder {
        QueryData a;
        int b;

        private AllocateQueryHolder() {
        }

        /* synthetic */ AllocateQueryHolder(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public LocalStore(Persistence persistence, QueryEngine queryEngine, User user) {
        Assert.hardAssert(persistence.isStarted(), "LocalStore was passed an unstarted persistence implementation", new Object[0]);
        this.persistence = persistence;
        this.queryCache = persistence.b();
        this.targetIdGenerator = TargetIdGenerator.forQueryCache(this.queryCache.getHighestTargetId());
        this.mutationQueue = persistence.a(user);
        this.remoteDocuments = persistence.c();
        this.localDocuments = new LocalDocumentsView(this.remoteDocuments, this.mutationQueue, persistence.a());
        this.queryEngine = queryEngine;
        queryEngine.setLocalDocumentsView(this.localDocuments);
        this.localViewReferences = new ReferenceSet();
        persistence.getReferenceDelegate().setInMemoryPins(this.localViewReferences);
        this.queryDataByTarget = new SparseArray<>();
        this.targetIdByTarget = new HashMap();
    }

    public static /* synthetic */ ImmutableSortedMap a(LocalStore localStore, int i) {
        MutationBatch lookupMutationBatch = localStore.mutationQueue.lookupMutationBatch(i);
        Assert.hardAssert(lookupMutationBatch != null, "Attempt to reject nonexistent batch!", new Object[0]);
        localStore.mutationQueue.removeMutationBatch(lookupMutationBatch);
        localStore.mutationQueue.performConsistencyCheck();
        return localStore.localDocuments.a(lookupMutationBatch.getKeys());
    }

    public static /* synthetic */ ImmutableSortedMap a(LocalStore localStore, MutationBatchResult mutationBatchResult) {
        MutationBatch batch = mutationBatchResult.getBatch();
        localStore.mutationQueue.acknowledgeBatch(batch, mutationBatchResult.getStreamToken());
        localStore.applyWriteToRemoteDocuments(mutationBatchResult);
        localStore.mutationQueue.performConsistencyCheck();
        return localStore.localDocuments.a(batch.getKeys());
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0133 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ com.google.firebase.database.collection.ImmutableSortedMap a(com.google.firebase.firestore.local.LocalStore r12, com.google.firebase.firestore.remote.RemoteEvent r13, com.google.firebase.firestore.model.SnapshotVersion r14) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.local.LocalStore.a(com.google.firebase.firestore.local.LocalStore, com.google.firebase.firestore.remote.RemoteEvent, com.google.firebase.firestore.model.SnapshotVersion):com.google.firebase.database.collection.ImmutableSortedMap");
    }

    public static /* synthetic */ LocalWriteResult a(LocalStore localStore, Set set, List list, Timestamp timestamp) {
        ImmutableSortedMap<DocumentKey, MaybeDocument> a = localStore.localDocuments.a(set);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Mutation mutation = (Mutation) it.next();
            ObjectValue extractBaseValue = mutation.extractBaseValue(a.get(mutation.getKey()));
            if (extractBaseValue != null) {
                arrayList.add(new PatchMutation(mutation.getKey(), extractBaseValue, extractBaseValue.getFieldMask(), Precondition.exists(true)));
            }
        }
        MutationBatch addMutationBatch = localStore.mutationQueue.addMutationBatch(timestamp, arrayList, list);
        return new LocalWriteResult(addMutationBatch.getBatchId(), addMutationBatch.applyToLocalDocumentSet(a));
    }

    public static /* synthetic */ void a(LocalStore localStore, AllocateQueryHolder allocateQueryHolder, Target target) {
        allocateQueryHolder.b = localStore.targetIdGenerator.nextId();
        allocateQueryHolder.a = new QueryData(target, allocateQueryHolder.b, localStore.persistence.getReferenceDelegate().getCurrentSequenceNumber(), QueryPurpose.LISTEN);
        localStore.queryCache.addQueryData(allocateQueryHolder.a);
    }

    public static /* synthetic */ void a(LocalStore localStore, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LocalViewChanges localViewChanges = (LocalViewChanges) it.next();
            int targetId = localViewChanges.getTargetId();
            localStore.localViewReferences.addReferences(localViewChanges.getAdded(), targetId);
            ImmutableSortedSet<DocumentKey> removed = localViewChanges.getRemoved();
            Iterator<DocumentKey> it2 = removed.iterator();
            while (it2.hasNext()) {
                localStore.persistence.getReferenceDelegate().removeReference(it2.next());
            }
            localStore.localViewReferences.removeReferences(removed, targetId);
            if (!localViewChanges.isFromCache()) {
                QueryData queryData = localStore.queryDataByTarget.get(targetId);
                Assert.hardAssert(queryData != null, "Can't set limbo-free snapshot version for unknown target: %s", Integer.valueOf(targetId));
                localStore.queryDataByTarget.put(targetId, queryData.withLastLimboFreeSnapshotVersion(queryData.getSnapshotVersion()));
            }
        }
    }

    private void applyWriteToRemoteDocuments(MutationBatchResult mutationBatchResult) {
        MutationBatch batch = mutationBatchResult.getBatch();
        for (DocumentKey documentKey : batch.getKeys()) {
            MaybeDocument maybeDocument = this.remoteDocuments.get(documentKey);
            SnapshotVersion snapshotVersion = mutationBatchResult.getDocVersions().get(documentKey);
            Assert.hardAssert(snapshotVersion != null, "docVersions should contain every doc in the write.", new Object[0]);
            if (maybeDocument == null || maybeDocument.getVersion().compareTo(snapshotVersion) < 0) {
                MaybeDocument applyToRemoteDocument = batch.applyToRemoteDocument(documentKey, maybeDocument, mutationBatchResult);
                if (applyToRemoteDocument == null) {
                    Assert.hardAssert(maybeDocument == null, "Mutation batch %s applied to document %s resulted in null.", batch, maybeDocument);
                } else {
                    this.remoteDocuments.add(applyToRemoteDocument, mutationBatchResult.getCommitVersion());
                }
            }
        }
        this.mutationQueue.removeMutationBatch(batch);
    }

    public static /* synthetic */ void b(LocalStore localStore, int i) {
        QueryData queryData = localStore.queryDataByTarget.get(i);
        Assert.hardAssert(queryData != null, "Tried to release nonexistent target: %s", Integer.valueOf(i));
        Iterator<DocumentKey> it = localStore.localViewReferences.removeReferencesForId(i).iterator();
        while (it.hasNext()) {
            localStore.persistence.getReferenceDelegate().removeReference(it.next());
        }
        localStore.persistence.getReferenceDelegate().removeTarget(queryData);
        localStore.queryDataByTarget.remove(i);
        localStore.targetIdByTarget.remove(queryData.getTarget());
    }

    private static boolean shouldPersistQueryData(QueryData queryData, QueryData queryData2, TargetChange targetChange) {
        Assert.hardAssert(!queryData2.getResumeToken().isEmpty(), "Attempted to persist query data with empty resume token", new Object[0]);
        return queryData.getResumeToken().isEmpty() || queryData2.getSnapshotVersion().getTimestamp().getSeconds() - queryData.getSnapshotVersion().getTimestamp().getSeconds() >= RESUME_TOKEN_MAX_AGE_SECONDS || (targetChange.getAddedDocuments().size() + targetChange.getModifiedDocuments().size()) + targetChange.getRemovedDocuments().size() > 0;
    }

    private void startMutationQueue() {
        this.persistence.a("Start MutationQueue", LocalStore$$Lambda$1.lambdaFactory$(this));
    }

    @Nullable
    @VisibleForTesting
    QueryData a(Target target) {
        Integer num = this.targetIdByTarget.get(target);
        return num != null ? this.queryDataByTarget.get(num.intValue()) : this.queryCache.getQueryData(target);
    }

    public ImmutableSortedMap<DocumentKey, MaybeDocument> acknowledgeBatch(MutationBatchResult mutationBatchResult) {
        return (ImmutableSortedMap) this.persistence.a("Acknowledge batch", LocalStore$$Lambda$3.lambdaFactory$(this, mutationBatchResult));
    }

    public QueryData allocateTarget(Target target) {
        int i;
        QueryData queryData = this.queryCache.getQueryData(target);
        if (queryData != null) {
            i = queryData.getTargetId();
        } else {
            AllocateQueryHolder allocateQueryHolder = new AllocateQueryHolder();
            this.persistence.a("Allocate target", LocalStore$$Lambda$8.lambdaFactory$(this, allocateQueryHolder, target));
            i = allocateQueryHolder.b;
            queryData = allocateQueryHolder.a;
        }
        if (this.queryDataByTarget.get(i) == null) {
            this.queryDataByTarget.put(i, queryData);
            this.targetIdByTarget.put(target, Integer.valueOf(i));
        }
        return queryData;
    }

    public ImmutableSortedMap<DocumentKey, MaybeDocument> applyRemoteEvent(RemoteEvent remoteEvent) {
        return (ImmutableSortedMap) this.persistence.a("Apply remote event", LocalStore$$Lambda$6.lambdaFactory$(this, remoteEvent, remoteEvent.getSnapshotVersion()));
    }

    public LruGarbageCollector.Results collectGarbage(LruGarbageCollector lruGarbageCollector) {
        return (LruGarbageCollector.Results) this.persistence.a("Collect garbage", LocalStore$$Lambda$10.lambdaFactory$(this, lruGarbageCollector));
    }

    public QueryResult executeQuery(Query query, boolean z) {
        QueryData a = a(query.toTarget());
        SnapshotVersion snapshotVersion = SnapshotVersion.NONE;
        ImmutableSortedSet<DocumentKey> emptyKeySet = DocumentKey.emptyKeySet();
        if (a != null) {
            snapshotVersion = a.getLastLimboFreeSnapshotVersion();
            emptyKeySet = this.queryCache.getMatchingKeysForTargetId(a.getTargetId());
        }
        QueryEngine queryEngine = this.queryEngine;
        if (!z) {
            snapshotVersion = SnapshotVersion.NONE;
        }
        return new QueryResult(queryEngine.getDocumentsMatchingQuery(query, snapshotVersion, z ? emptyKeySet : DocumentKey.emptyKeySet()), emptyKeySet);
    }

    public int getHighestUnacknowledgedBatchId() {
        return this.mutationQueue.getHighestUnacknowledgedBatchId();
    }

    public SnapshotVersion getLastRemoteSnapshotVersion() {
        return this.queryCache.getLastRemoteSnapshotVersion();
    }

    public ByteString getLastStreamToken() {
        return this.mutationQueue.getLastStreamToken();
    }

    @Nullable
    public MutationBatch getNextMutationBatch(int i) {
        return this.mutationQueue.getNextMutationBatchAfterBatchId(i);
    }

    public ImmutableSortedSet<DocumentKey> getRemoteDocumentKeys(int i) {
        return this.queryCache.getMatchingKeysForTargetId(i);
    }

    public ImmutableSortedMap<DocumentKey, MaybeDocument> handleUserChange(User user) {
        List<MutationBatch> allMutationBatches = this.mutationQueue.getAllMutationBatches();
        this.mutationQueue = this.persistence.a(user);
        startMutationQueue();
        List<MutationBatch> allMutationBatches2 = this.mutationQueue.getAllMutationBatches();
        this.localDocuments = new LocalDocumentsView(this.remoteDocuments, this.mutationQueue, this.persistence.a());
        this.queryEngine.setLocalDocumentsView(this.localDocuments);
        ImmutableSortedSet<DocumentKey> emptyKeySet = DocumentKey.emptyKeySet();
        Iterator it = Arrays.asList(allMutationBatches, allMutationBatches2).iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
                Iterator<Mutation> it3 = ((MutationBatch) it2.next()).getMutations().iterator();
                while (it3.hasNext()) {
                    emptyKeySet = emptyKeySet.insert(it3.next().getKey());
                }
            }
        }
        return this.localDocuments.a(emptyKeySet);
    }

    public void notifyLocalViewChanges(List<LocalViewChanges> list) {
        this.persistence.a("notifyLocalViewChanges", LocalStore$$Lambda$7.lambdaFactory$(this, list));
    }

    @Nullable
    public MaybeDocument readDocument(DocumentKey documentKey) {
        return this.localDocuments.a(documentKey);
    }

    public ImmutableSortedMap<DocumentKey, MaybeDocument> rejectBatch(int i) {
        return (ImmutableSortedMap) this.persistence.a("Reject batch", LocalStore$$Lambda$4.lambdaFactory$(this, i));
    }

    public void releaseTarget(int i) {
        this.persistence.a("Release target", LocalStore$$Lambda$9.lambdaFactory$(this, i));
    }

    public void setLastStreamToken(ByteString byteString) {
        this.persistence.a("Set stream token", LocalStore$$Lambda$5.lambdaFactory$(this, byteString));
    }

    public void start() {
        startMutationQueue();
    }

    public LocalWriteResult writeLocally(List<Mutation> list) {
        Timestamp now = Timestamp.now();
        HashSet hashSet = new HashSet();
        Iterator<Mutation> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getKey());
        }
        return (LocalWriteResult) this.persistence.a("Locally write mutations", LocalStore$$Lambda$2.lambdaFactory$(this, hashSet, list, now));
    }
}
