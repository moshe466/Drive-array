package com.google.firebase.firestore.remote;

import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.OnlineState;
import com.google.firebase.firestore.core.Transaction;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.QueryData;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.remote.WatchChange;
import com.google.firebase.firestore.remote.WatchChangeAggregator;
import com.google.firebase.firestore.remote.WatchStream;
import com.google.firebase.firestore.remote.WriteStream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.ByteString;
import io.grpc.Status;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class RemoteStore implements WatchChangeAggregator.TargetMetadataProvider {
    private static final String LOG_TAG = "RemoteStore";
    private static final int MAX_PENDING_WRITES = 10;
    private final ConnectivityMonitor connectivityMonitor;
    private final Datastore datastore;
    private final LocalStore localStore;
    private final OnlineStateTracker onlineStateTracker;
    private final RemoteStoreCallback remoteStoreCallback;

    @Nullable
    private WatchChangeAggregator watchChangeAggregator;
    private final WatchStream watchStream;
    private final WriteStream writeStream;
    private boolean networkEnabled = false;
    private final Map<Integer, QueryData> listenTargets = new HashMap();
    private final Deque<MutationBatch> writePipeline = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.remote.RemoteStore$1 */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements WatchStream.Callback {
        AnonymousClass1() {
        }

        @Override // com.google.firebase.firestore.remote.Stream.StreamCallback
        public void onClose(Status status) {
            RemoteStore.this.handleWatchStreamClose(status);
        }

        @Override // com.google.firebase.firestore.remote.Stream.StreamCallback
        public void onOpen() {
            RemoteStore.this.handleWatchStreamOpen();
        }

        @Override // com.google.firebase.firestore.remote.WatchStream.Callback
        public void onWatchChange(SnapshotVersion snapshotVersion, WatchChange watchChange) {
            RemoteStore.this.handleWatchChange(snapshotVersion, watchChange);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.remote.RemoteStore$2 */
    /* loaded from: classes2.dex */
    public class AnonymousClass2 implements WriteStream.Callback {
        AnonymousClass2() {
        }

        @Override // com.google.firebase.firestore.remote.Stream.StreamCallback
        public void onClose(Status status) {
            RemoteStore.this.handleWriteStreamClose(status);
        }

        @Override // com.google.firebase.firestore.remote.WriteStream.Callback
        public void onHandshakeComplete() {
            RemoteStore.this.handleWriteStreamHandshakeComplete();
        }

        @Override // com.google.firebase.firestore.remote.Stream.StreamCallback
        public void onOpen() {
            RemoteStore.this.writeStream.e();
        }

        @Override // com.google.firebase.firestore.remote.WriteStream.Callback
        public void onWriteResponse(SnapshotVersion snapshotVersion, List<MutationResult> list) {
            RemoteStore.this.handleWriteStreamMutationResults(snapshotVersion, list);
        }
    }

    /* loaded from: classes2.dex */
    public interface RemoteStoreCallback {
        ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i);

        void handleOnlineStateChange(OnlineState onlineState);

        void handleRejectedListen(int i, Status status);

        void handleRejectedWrite(int i, Status status);

        void handleRemoteEvent(RemoteEvent remoteEvent);

        void handleSuccessfulWrite(MutationBatchResult mutationBatchResult);
    }

    public RemoteStore(RemoteStoreCallback remoteStoreCallback, LocalStore localStore, Datastore datastore, AsyncQueue asyncQueue, ConnectivityMonitor connectivityMonitor) {
        this.remoteStoreCallback = remoteStoreCallback;
        this.localStore = localStore;
        this.datastore = datastore;
        this.connectivityMonitor = connectivityMonitor;
        remoteStoreCallback.getClass();
        this.onlineStateTracker = new OnlineStateTracker(asyncQueue, RemoteStore$$Lambda$1.lambdaFactory$(remoteStoreCallback));
        this.watchStream = datastore.a(new WatchStream.Callback() { // from class: com.google.firebase.firestore.remote.RemoteStore.1
            AnonymousClass1() {
            }

            @Override // com.google.firebase.firestore.remote.Stream.StreamCallback
            public void onClose(Status status) {
                RemoteStore.this.handleWatchStreamClose(status);
            }

            @Override // com.google.firebase.firestore.remote.Stream.StreamCallback
            public void onOpen() {
                RemoteStore.this.handleWatchStreamOpen();
            }

            @Override // com.google.firebase.firestore.remote.WatchStream.Callback
            public void onWatchChange(SnapshotVersion snapshotVersion, WatchChange watchChange) {
                RemoteStore.this.handleWatchChange(snapshotVersion, watchChange);
            }
        });
        this.writeStream = datastore.a(new WriteStream.Callback() { // from class: com.google.firebase.firestore.remote.RemoteStore.2
            AnonymousClass2() {
            }

            @Override // com.google.firebase.firestore.remote.Stream.StreamCallback
            public void onClose(Status status) {
                RemoteStore.this.handleWriteStreamClose(status);
            }

            @Override // com.google.firebase.firestore.remote.WriteStream.Callback
            public void onHandshakeComplete() {
                RemoteStore.this.handleWriteStreamHandshakeComplete();
            }

            @Override // com.google.firebase.firestore.remote.Stream.StreamCallback
            public void onOpen() {
                RemoteStore.this.writeStream.e();
            }

            @Override // com.google.firebase.firestore.remote.WriteStream.Callback
            public void onWriteResponse(SnapshotVersion snapshotVersion, List<MutationResult> list) {
                RemoteStore.this.handleWriteStreamMutationResults(snapshotVersion, list);
            }
        });
        connectivityMonitor.addCallback(RemoteStore$$Lambda$2.lambdaFactory$(this, asyncQueue));
    }

    private void addToWritePipeline(MutationBatch mutationBatch) {
        Assert.hardAssert(canAddToWritePipeline(), "addToWritePipeline called when pipeline is full", new Object[0]);
        this.writePipeline.add(mutationBatch);
        if (this.writeStream.isOpen() && this.writeStream.d()) {
            this.writeStream.a(mutationBatch.getMutations());
        }
    }

    private boolean canAddToWritePipeline() {
        return canUseNetwork() && this.writePipeline.size() < 10;
    }

    private void cleanUpWatchStreamState() {
        this.watchChangeAggregator = null;
    }

    public static /* synthetic */ void d(RemoteStore remoteStore) {
        if (remoteStore.canUseNetwork()) {
            Logger.debug(LOG_TAG, "Restarting streams for network reachability change.", new Object[0]);
            remoteStore.restartNetwork();
        }
    }

    private void disableNetworkInternal() {
        this.watchStream.stop();
        this.writeStream.stop();
        if (!this.writePipeline.isEmpty()) {
            Logger.debug(LOG_TAG, "Stopping write stream with %d pending writes", Integer.valueOf(this.writePipeline.size()));
            this.writePipeline.clear();
        }
        cleanUpWatchStreamState();
    }

    public void handleWatchChange(SnapshotVersion snapshotVersion, WatchChange watchChange) {
        this.onlineStateTracker.a(OnlineState.ONLINE);
        Assert.hardAssert((this.watchStream == null || this.watchChangeAggregator == null) ? false : true, "WatchStream and WatchStreamAggregator should both be non-null", new Object[0]);
        boolean z = watchChange instanceof WatchChange.WatchTargetChange;
        WatchChange.WatchTargetChange watchTargetChange = z ? (WatchChange.WatchTargetChange) watchChange : null;
        if (watchTargetChange != null && watchTargetChange.getChangeType().equals(WatchChange.WatchTargetChangeType.Removed) && watchTargetChange.getCause() != null) {
            processTargetError(watchTargetChange);
            return;
        }
        if (watchChange instanceof WatchChange.DocumentChange) {
            this.watchChangeAggregator.handleDocumentChange((WatchChange.DocumentChange) watchChange);
        } else if (watchChange instanceof WatchChange.ExistenceFilterWatchChange) {
            this.watchChangeAggregator.handleExistenceFilter((WatchChange.ExistenceFilterWatchChange) watchChange);
        } else {
            Assert.hardAssert(z, "Expected watchChange to be an instance of WatchTargetChange", new Object[0]);
            this.watchChangeAggregator.handleTargetChange((WatchChange.WatchTargetChange) watchChange);
        }
        if (snapshotVersion.equals(SnapshotVersion.NONE) || snapshotVersion.compareTo(this.localStore.getLastRemoteSnapshotVersion()) < 0) {
            return;
        }
        raiseWatchSnapshot(snapshotVersion);
    }

    public void handleWatchStreamClose(Status status) {
        if (Status.OK.equals(status)) {
            Assert.hardAssert(!shouldStartWatchStream(), "Watch stream was stopped gracefully while still needed.", new Object[0]);
        }
        cleanUpWatchStreamState();
        if (!shouldStartWatchStream()) {
            this.onlineStateTracker.a(OnlineState.UNKNOWN);
        } else {
            this.onlineStateTracker.a(status);
            startWatchStream();
        }
    }

    public void handleWatchStreamOpen() {
        Iterator<QueryData> it = this.listenTargets.values().iterator();
        while (it.hasNext()) {
            sendWatchRequest(it.next());
        }
    }

    private void handleWriteError(Status status) {
        Assert.hardAssert(!status.isOk(), "Handling write error with status OK.", new Object[0]);
        if (Datastore.isPermanentWriteError(status)) {
            MutationBatch poll = this.writePipeline.poll();
            this.writeStream.inhibitBackoff();
            this.remoteStoreCallback.handleRejectedWrite(poll.getBatchId(), status);
            fillWritePipeline();
        }
    }

    private void handleWriteHandshakeError(Status status) {
        Assert.hardAssert(!status.isOk(), "Handling write error with status OK.", new Object[0]);
        if (Datastore.isPermanentError(status)) {
            Logger.debug(LOG_TAG, "RemoteStore error before completed handshake; resetting stream token %s: %s", Util.toDebugString(this.writeStream.c()), status);
            this.writeStream.a(WriteStream.EMPTY_STREAM_TOKEN);
            this.localStore.setLastStreamToken(WriteStream.EMPTY_STREAM_TOKEN);
        }
    }

    public void handleWriteStreamClose(Status status) {
        if (Status.OK.equals(status)) {
            Assert.hardAssert(!shouldStartWriteStream(), "Write stream was stopped gracefully while still needed.", new Object[0]);
        }
        if (!status.isOk() && !this.writePipeline.isEmpty()) {
            if (this.writeStream.d()) {
                handleWriteError(status);
            } else {
                handleWriteHandshakeError(status);
            }
        }
        if (shouldStartWriteStream()) {
            startWriteStream();
        }
    }

    public void handleWriteStreamHandshakeComplete() {
        this.localStore.setLastStreamToken(this.writeStream.c());
        Iterator<MutationBatch> it = this.writePipeline.iterator();
        while (it.hasNext()) {
            this.writeStream.a(it.next().getMutations());
        }
    }

    public void handleWriteStreamMutationResults(SnapshotVersion snapshotVersion, List<MutationResult> list) {
        this.remoteStoreCallback.handleSuccessfulWrite(MutationBatchResult.create(this.writePipeline.poll(), snapshotVersion, list, this.writeStream.c()));
        fillWritePipeline();
    }

    private void processTargetError(WatchChange.WatchTargetChange watchTargetChange) {
        Assert.hardAssert(watchTargetChange.getCause() != null, "Processing target error without a cause", new Object[0]);
        for (Integer num : watchTargetChange.getTargetIds()) {
            if (this.listenTargets.containsKey(num)) {
                this.listenTargets.remove(num);
                this.watchChangeAggregator.b(num.intValue());
                this.remoteStoreCallback.handleRejectedListen(num.intValue(), watchTargetChange.getCause());
            }
        }
    }

    private void raiseWatchSnapshot(SnapshotVersion snapshotVersion) {
        Assert.hardAssert(!snapshotVersion.equals(SnapshotVersion.NONE), "Can't raise event for unknown SnapshotVersion", new Object[0]);
        RemoteEvent createRemoteEvent = this.watchChangeAggregator.createRemoteEvent(snapshotVersion);
        for (Map.Entry<Integer, TargetChange> entry : createRemoteEvent.getTargetChanges().entrySet()) {
            TargetChange value = entry.getValue();
            if (!value.getResumeToken().isEmpty()) {
                int intValue = entry.getKey().intValue();
                QueryData queryData = this.listenTargets.get(Integer.valueOf(intValue));
                if (queryData != null) {
                    this.listenTargets.put(Integer.valueOf(intValue), queryData.withResumeToken(value.getResumeToken(), snapshotVersion));
                }
            }
        }
        Iterator<Integer> it = createRemoteEvent.getTargetMismatches().iterator();
        while (it.hasNext()) {
            int intValue2 = it.next().intValue();
            QueryData queryData2 = this.listenTargets.get(Integer.valueOf(intValue2));
            if (queryData2 != null) {
                this.listenTargets.put(Integer.valueOf(intValue2), queryData2.withResumeToken(ByteString.EMPTY, queryData2.getSnapshotVersion()));
                sendUnwatchRequest(intValue2);
                sendWatchRequest(new QueryData(queryData2.getTarget(), intValue2, queryData2.getSequenceNumber(), QueryPurpose.EXISTENCE_FILTER_MISMATCH));
            }
        }
        this.remoteStoreCallback.handleRemoteEvent(createRemoteEvent);
    }

    private void restartNetwork() {
        this.networkEnabled = false;
        disableNetworkInternal();
        this.onlineStateTracker.a(OnlineState.UNKNOWN);
        enableNetwork();
    }

    private void sendUnwatchRequest(int i) {
        this.watchChangeAggregator.a(i);
        this.watchStream.unwatchTarget(i);
    }

    private void sendWatchRequest(QueryData queryData) {
        this.watchChangeAggregator.a(queryData.getTargetId());
        this.watchStream.watchQuery(queryData);
    }

    private boolean shouldStartWatchStream() {
        return (!canUseNetwork() || this.watchStream.isStarted() || this.listenTargets.isEmpty()) ? false : true;
    }

    private boolean shouldStartWriteStream() {
        return (!canUseNetwork() || this.writeStream.isStarted() || this.writePipeline.isEmpty()) ? false : true;
    }

    private void startWatchStream() {
        Assert.hardAssert(shouldStartWatchStream(), "startWatchStream() called when shouldStartWatchStream() is false.", new Object[0]);
        this.watchChangeAggregator = new WatchChangeAggregator(this);
        this.watchStream.start();
        this.onlineStateTracker.a();
    }

    private void startWriteStream() {
        Assert.hardAssert(shouldStartWriteStream(), "startWriteStream() called when shouldStartWriteStream() is false.", new Object[0]);
        this.writeStream.start();
    }

    public boolean canUseNetwork() {
        return this.networkEnabled;
    }

    public Transaction createTransaction() {
        return new Transaction(this.datastore);
    }

    public void disableNetwork() {
        this.networkEnabled = false;
        disableNetworkInternal();
        this.onlineStateTracker.a(OnlineState.OFFLINE);
    }

    public void enableNetwork() {
        this.networkEnabled = true;
        if (canUseNetwork()) {
            this.writeStream.a(this.localStore.getLastStreamToken());
            if (shouldStartWatchStream()) {
                startWatchStream();
            } else {
                this.onlineStateTracker.a(OnlineState.UNKNOWN);
            }
            fillWritePipeline();
        }
    }

    public void fillWritePipeline() {
        int batchId = this.writePipeline.isEmpty() ? -1 : this.writePipeline.getLast().getBatchId();
        while (true) {
            if (!canAddToWritePipeline()) {
                break;
            }
            MutationBatch nextMutationBatch = this.localStore.getNextMutationBatch(batchId);
            if (nextMutationBatch != null) {
                addToWritePipeline(nextMutationBatch);
                batchId = nextMutationBatch.getBatchId();
            } else if (this.writePipeline.size() == 0) {
                this.writeStream.a();
            }
        }
        if (shouldStartWriteStream()) {
            startWriteStream();
        }
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator.TargetMetadataProvider
    @Nullable
    public QueryData getQueryDataForTarget(int i) {
        return this.listenTargets.get(Integer.valueOf(i));
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator.TargetMetadataProvider
    public ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i) {
        return this.remoteStoreCallback.getRemoteKeysForTarget(i);
    }

    public void handleCredentialChange() {
        if (canUseNetwork()) {
            Logger.debug(LOG_TAG, "Restarting streams for new credential.", new Object[0]);
            restartNetwork();
        }
    }

    public void listen(QueryData queryData) {
        Integer valueOf = Integer.valueOf(queryData.getTargetId());
        if (this.listenTargets.containsKey(valueOf)) {
            return;
        }
        this.listenTargets.put(valueOf, queryData);
        if (shouldStartWatchStream()) {
            startWatchStream();
        } else if (this.watchStream.isOpen()) {
            sendWatchRequest(queryData);
        }
    }

    public void shutdown() {
        Logger.debug(LOG_TAG, "Shutting down", new Object[0]);
        this.connectivityMonitor.shutdown();
        this.networkEnabled = false;
        disableNetworkInternal();
        this.datastore.a();
        this.onlineStateTracker.a(OnlineState.UNKNOWN);
    }

    public void start() {
        enableNetwork();
    }

    public void stopListening(int i) {
        Assert.hardAssert(this.listenTargets.remove(Integer.valueOf(i)) != null, "stopListening called on target no currently watched: %d", Integer.valueOf(i));
        if (this.watchStream.isOpen()) {
            sendUnwatchRequest(i);
        }
        if (this.listenTargets.isEmpty()) {
            if (this.watchStream.isOpen()) {
                this.watchStream.a();
            } else if (canUseNetwork()) {
                this.onlineStateTracker.a(OnlineState.UNKNOWN);
            }
        }
    }
}
