package com.google.firebase.firestore.remote;

import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.local.QueryData;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.remote.WatchChange;
import com.google.firebase.firestore.util.Assert;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class WatchChangeAggregator {
    private final TargetMetadataProvider targetMetadataProvider;
    private final Map<Integer, TargetState> targetStates = new HashMap();
    private Map<DocumentKey, MaybeDocument> pendingDocumentUpdates = new HashMap();
    private Map<DocumentKey, Set<Integer>> pendingDocumentTargetMapping = new HashMap();
    private Set<Integer> pendingTargetResets = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.remote.WatchChangeAggregator$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[WatchChange.WatchTargetChangeType.values().length];

        static {
            try {
                a[WatchChange.WatchTargetChangeType.NoChange.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[WatchChange.WatchTargetChangeType.Added.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[WatchChange.WatchTargetChangeType.Removed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[WatchChange.WatchTargetChangeType.Current.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[WatchChange.WatchTargetChangeType.Reset.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface TargetMetadataProvider {
        @Nullable
        QueryData getQueryDataForTarget(int i);

        ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i);
    }

    public WatchChangeAggregator(TargetMetadataProvider targetMetadataProvider) {
        this.targetMetadataProvider = targetMetadataProvider;
    }

    private void addDocumentToTarget(int i, MaybeDocument maybeDocument) {
        if (isActiveTarget(i)) {
            ensureTargetState(i).a(maybeDocument.getKey(), targetContainsDocument(i, maybeDocument.getKey()) ? DocumentViewChange.Type.MODIFIED : DocumentViewChange.Type.ADDED);
            this.pendingDocumentUpdates.put(maybeDocument.getKey(), maybeDocument);
            ensureDocumentTargetMapping(maybeDocument.getKey()).add(Integer.valueOf(i));
        }
    }

    private Set<Integer> ensureDocumentTargetMapping(DocumentKey documentKey) {
        Set<Integer> set = this.pendingDocumentTargetMapping.get(documentKey);
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        this.pendingDocumentTargetMapping.put(documentKey, hashSet);
        return hashSet;
    }

    private TargetState ensureTargetState(int i) {
        TargetState targetState = this.targetStates.get(Integer.valueOf(i));
        if (targetState != null) {
            return targetState;
        }
        TargetState targetState2 = new TargetState();
        this.targetStates.put(Integer.valueOf(i), targetState2);
        return targetState2;
    }

    private int getCurrentDocumentCountForTarget(int i) {
        TargetChange h = ensureTargetState(i).h();
        return (this.targetMetadataProvider.getRemoteKeysForTarget(i).size() + h.getAddedDocuments().size()) - h.getRemovedDocuments().size();
    }

    private Collection<Integer> getTargetIds(WatchChange.WatchTargetChange watchTargetChange) {
        List<Integer> targetIds = watchTargetChange.getTargetIds();
        return !targetIds.isEmpty() ? targetIds : this.targetStates.keySet();
    }

    private boolean isActiveTarget(int i) {
        return queryDataForActiveTarget(i) != null;
    }

    @Nullable
    private QueryData queryDataForActiveTarget(int i) {
        TargetState targetState = this.targetStates.get(Integer.valueOf(i));
        if (targetState == null || !targetState.d()) {
            return this.targetMetadataProvider.getQueryDataForTarget(i);
        }
        return null;
    }

    private void removeDocumentFromTarget(int i, DocumentKey documentKey, @Nullable MaybeDocument maybeDocument) {
        if (isActiveTarget(i)) {
            TargetState ensureTargetState = ensureTargetState(i);
            if (targetContainsDocument(i, documentKey)) {
                ensureTargetState.a(documentKey, DocumentViewChange.Type.REMOVED);
            } else {
                ensureTargetState.a(documentKey);
            }
            ensureDocumentTargetMapping(documentKey).add(Integer.valueOf(i));
            if (maybeDocument != null) {
                this.pendingDocumentUpdates.put(documentKey, maybeDocument);
            }
        }
    }

    private void resetTarget(int i) {
        Assert.hardAssert((this.targetStates.get(Integer.valueOf(i)) == null || this.targetStates.get(Integer.valueOf(i)).d()) ? false : true, "Should only reset active targets", new Object[0]);
        this.targetStates.put(Integer.valueOf(i), new TargetState());
        Iterator<DocumentKey> it = this.targetMetadataProvider.getRemoteKeysForTarget(i).iterator();
        while (it.hasNext()) {
            removeDocumentFromTarget(i, it.next(), null);
        }
    }

    private boolean targetContainsDocument(int i, DocumentKey documentKey) {
        return this.targetMetadataProvider.getRemoteKeysForTarget(i).contains(documentKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        ensureTargetState(i).f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        this.targetStates.remove(Integer.valueOf(i));
    }

    public RemoteEvent createRemoteEvent(SnapshotVersion snapshotVersion) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, TargetState> entry : this.targetStates.entrySet()) {
            int intValue = entry.getKey().intValue();
            TargetState value = entry.getValue();
            QueryData queryDataForActiveTarget = queryDataForActiveTarget(intValue);
            if (queryDataForActiveTarget != null) {
                if (value.c() && queryDataForActiveTarget.getTarget().isDocumentQuery()) {
                    DocumentKey fromPath = DocumentKey.fromPath(queryDataForActiveTarget.getTarget().getPath());
                    if (this.pendingDocumentUpdates.get(fromPath) == null && !targetContainsDocument(intValue, fromPath)) {
                        removeDocumentFromTarget(intValue, fromPath, new NoDocument(fromPath, snapshotVersion, false));
                    }
                }
                if (value.b()) {
                    hashMap.put(Integer.valueOf(intValue), value.h());
                    value.a();
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry<DocumentKey, Set<Integer>> entry2 : this.pendingDocumentTargetMapping.entrySet()) {
            DocumentKey key = entry2.getKey();
            boolean z = true;
            Iterator<Integer> it = entry2.getValue().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                QueryData queryDataForActiveTarget2 = queryDataForActiveTarget(it.next().intValue());
                if (queryDataForActiveTarget2 != null && !queryDataForActiveTarget2.getPurpose().equals(QueryPurpose.LIMBO_RESOLUTION)) {
                    z = false;
                    break;
                }
            }
            if (z) {
                hashSet.add(key);
            }
        }
        RemoteEvent remoteEvent = new RemoteEvent(snapshotVersion, Collections.unmodifiableMap(hashMap), Collections.unmodifiableSet(this.pendingTargetResets), Collections.unmodifiableMap(this.pendingDocumentUpdates), Collections.unmodifiableSet(hashSet));
        this.pendingDocumentUpdates = new HashMap();
        this.pendingDocumentTargetMapping = new HashMap();
        this.pendingTargetResets = new HashSet();
        return remoteEvent;
    }

    public void handleDocumentChange(WatchChange.DocumentChange documentChange) {
        MaybeDocument newDocument = documentChange.getNewDocument();
        DocumentKey documentKey = documentChange.getDocumentKey();
        Iterator<Integer> it = documentChange.getUpdatedTargetIds().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (newDocument instanceof Document) {
                addDocumentToTarget(intValue, newDocument);
            } else if (newDocument instanceof NoDocument) {
                removeDocumentFromTarget(intValue, documentKey, newDocument);
            }
        }
        Iterator<Integer> it2 = documentChange.getRemovedTargetIds().iterator();
        while (it2.hasNext()) {
            removeDocumentFromTarget(it2.next().intValue(), documentKey, documentChange.getNewDocument());
        }
    }

    public void handleExistenceFilter(WatchChange.ExistenceFilterWatchChange existenceFilterWatchChange) {
        int targetId = existenceFilterWatchChange.getTargetId();
        int count = existenceFilterWatchChange.getExistenceFilter().getCount();
        QueryData queryDataForActiveTarget = queryDataForActiveTarget(targetId);
        if (queryDataForActiveTarget != null) {
            Target target = queryDataForActiveTarget.getTarget();
            if (!target.isDocumentQuery()) {
                if (getCurrentDocumentCountForTarget(targetId) != count) {
                    resetTarget(targetId);
                    this.pendingTargetResets.add(Integer.valueOf(targetId));
                    return;
                }
                return;
            }
            if (count != 0) {
                Assert.hardAssert(count == 1, "Single document existence filter with count: %d", Integer.valueOf(count));
            } else {
                DocumentKey fromPath = DocumentKey.fromPath(target.getPath());
                removeDocumentFromTarget(targetId, fromPath, new NoDocument(fromPath, SnapshotVersion.NONE, false));
            }
        }
    }

    public void handleTargetChange(WatchChange.WatchTargetChange watchTargetChange) {
        Iterator<Integer> it = getTargetIds(watchTargetChange).iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            TargetState ensureTargetState = ensureTargetState(intValue);
            int i = AnonymousClass1.a[watchTargetChange.getChangeType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    ensureTargetState.g();
                    if (!ensureTargetState.d()) {
                        ensureTargetState.a();
                    }
                } else if (i == 3) {
                    ensureTargetState.g();
                    if (!ensureTargetState.d()) {
                        b(intValue);
                    }
                    Assert.hardAssert(watchTargetChange.getCause() == null, "WatchChangeAggregator does not handle errored targets", new Object[0]);
                } else if (i != 4) {
                    if (i != 5) {
                        throw Assert.fail("Unknown target watch change state: %s", watchTargetChange.getChangeType());
                    }
                    if (isActiveTarget(intValue)) {
                        resetTarget(intValue);
                    }
                } else if (isActiveTarget(intValue)) {
                    ensureTargetState.e();
                }
                ensureTargetState.a(watchTargetChange.getResumeToken());
            } else if (isActiveTarget(intValue)) {
                ensureTargetState.a(watchTargetChange.getResumeToken());
            }
        }
    }
}
