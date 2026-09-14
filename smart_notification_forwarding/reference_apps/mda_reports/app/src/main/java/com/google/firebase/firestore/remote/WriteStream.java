package com.google.firebase.firestore.remote;

import com.google.common.base.Preconditions;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.remote.Stream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firestore.v1.FirestoreGrpc;
import com.google.firestore.v1.WriteRequest;
import com.google.firestore.v1.WriteResponse;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class WriteStream extends AbstractStream<WriteRequest, WriteResponse, Callback> {
    public static final ByteString EMPTY_STREAM_TOKEN = ByteString.EMPTY;
    protected boolean c;
    private ByteString lastStreamToken;
    private final RemoteSerializer serializer;

    /* loaded from: classes2.dex */
    public interface Callback extends Stream.StreamCallback {
        void onHandshakeComplete();

        void onWriteResponse(SnapshotVersion snapshotVersion, List<MutationResult> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WriteStream(FirestoreChannel firestoreChannel, AsyncQueue asyncQueue, RemoteSerializer remoteSerializer, Callback callback) {
        super(firestoreChannel, FirestoreGrpc.getWriteMethod(), asyncQueue, AsyncQueue.TimerId.WRITE_STREAM_CONNECTION_BACKOFF, AsyncQueue.TimerId.WRITE_STREAM_IDLE, callback);
        this.c = false;
        this.lastStreamToken = EMPTY_STREAM_TOKEN;
        this.serializer = remoteSerializer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ByteString byteString) {
        this.lastStreamToken = (ByteString) Preconditions.checkNotNull(byteString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<Mutation> list) {
        Assert.hardAssert(isOpen(), "Writing mutations requires an opened stream", new Object[0]);
        Assert.hardAssert(this.c, "Handshake must be complete before writing mutations", new Object[0]);
        WriteRequest.Builder newBuilder = WriteRequest.newBuilder();
        Iterator<Mutation> it = list.iterator();
        while (it.hasNext()) {
            newBuilder.addWrites(this.serializer.encodeMutation(it.next()));
        }
        newBuilder.setStreamToken(this.lastStreamToken);
        a((WriteStream) newBuilder.build());
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    protected void b() {
        if (this.c) {
            a(Collections.emptyList());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteString c() {
        return this.lastStreamToken;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        Assert.hardAssert(isOpen(), "Writing handshake requires an opened stream", new Object[0]);
        Assert.hardAssert(!this.c, "Handshake already completed", new Object[0]);
        a((WriteStream) WriteRequest.newBuilder().setDatabase(this.serializer.databaseName()).build());
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public /* bridge */ /* synthetic */ void inhibitBackoff() {
        super.inhibitBackoff();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public /* bridge */ /* synthetic */ boolean isStarted() {
        return super.isStarted();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void onNext(WriteResponse writeResponse) {
        this.lastStreamToken = writeResponse.getStreamToken();
        if (!this.c) {
            this.c = true;
            ((Callback) this.b).onHandshakeComplete();
            return;
        }
        this.a.reset();
        SnapshotVersion decodeVersion = this.serializer.decodeVersion(writeResponse.getCommitTime());
        int writeResultsCount = writeResponse.getWriteResultsCount();
        ArrayList arrayList = new ArrayList(writeResultsCount);
        for (int i = 0; i < writeResultsCount; i++) {
            arrayList.add(this.serializer.decodeMutationResult(writeResponse.getWriteResults(i), decodeVersion));
        }
        ((Callback) this.b).onWriteResponse(decodeVersion, arrayList);
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public void start() {
        this.c = false;
        super.start();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }
}
