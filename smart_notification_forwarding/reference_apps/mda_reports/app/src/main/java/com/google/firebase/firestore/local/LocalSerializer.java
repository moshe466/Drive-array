package com.google.firebase.firestore.local;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.UnknownDocument;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.proto.MaybeDocument;
import com.google.firebase.firestore.proto.NoDocument;
import com.google.firebase.firestore.proto.Target;
import com.google.firebase.firestore.proto.UnknownDocument;
import com.google.firebase.firestore.proto.WriteBatch;
import com.google.firebase.firestore.remote.RemoteSerializer;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.v1.Document;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class LocalSerializer {
    private final RemoteSerializer rpcSerializer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.local.LocalSerializer$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b = new int[Target.TargetTypeCase.values().length];

        static {
            try {
                b[Target.TargetTypeCase.DOCUMENTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Target.TargetTypeCase.QUERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = new int[MaybeDocument.DocumentTypeCase.values().length];
            try {
                a[MaybeDocument.DocumentTypeCase.DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MaybeDocument.DocumentTypeCase.NO_DOCUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[MaybeDocument.DocumentTypeCase.UNKNOWN_DOCUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public LocalSerializer(RemoteSerializer remoteSerializer) {
        this.rpcSerializer = remoteSerializer;
    }

    private Document decodeDocument(com.google.firestore.v1.Document document, boolean z) {
        DocumentKey decodeKey = this.rpcSerializer.decodeKey(document.getName());
        SnapshotVersion decodeVersion = this.rpcSerializer.decodeVersion(document.getUpdateTime());
        Document.DocumentState documentState = z ? Document.DocumentState.COMMITTED_MUTATIONS : Document.DocumentState.SYNCED;
        RemoteSerializer remoteSerializer = this.rpcSerializer;
        remoteSerializer.getClass();
        return new Document(decodeKey, decodeVersion, documentState, document, LocalSerializer$$Lambda$1.lambdaFactory$(remoteSerializer));
    }

    private NoDocument decodeNoDocument(com.google.firebase.firestore.proto.NoDocument noDocument, boolean z) {
        return new NoDocument(this.rpcSerializer.decodeKey(noDocument.getName()), this.rpcSerializer.decodeVersion(noDocument.getReadTime()), z);
    }

    private UnknownDocument decodeUnknownDocument(com.google.firebase.firestore.proto.UnknownDocument unknownDocument) {
        return new UnknownDocument(this.rpcSerializer.decodeKey(unknownDocument.getName()), this.rpcSerializer.decodeVersion(unknownDocument.getVersion()));
    }

    private com.google.firestore.v1.Document encodeDocument(Document document) {
        Document.Builder newBuilder = com.google.firestore.v1.Document.newBuilder();
        newBuilder.setName(this.rpcSerializer.encodeKey(document.getKey()));
        Iterator<Map.Entry<String, FieldValue>> it = document.getData().getInternalValue().iterator();
        while (it.hasNext()) {
            Map.Entry<String, FieldValue> next = it.next();
            newBuilder.putFields(next.getKey(), this.rpcSerializer.encodeValue(next.getValue()));
        }
        newBuilder.setUpdateTime(this.rpcSerializer.encodeTimestamp(document.getVersion().getTimestamp()));
        return newBuilder.build();
    }

    private com.google.firebase.firestore.proto.NoDocument encodeNoDocument(NoDocument noDocument) {
        NoDocument.Builder newBuilder = com.google.firebase.firestore.proto.NoDocument.newBuilder();
        newBuilder.setName(this.rpcSerializer.encodeKey(noDocument.getKey()));
        newBuilder.setReadTime(this.rpcSerializer.encodeTimestamp(noDocument.getVersion().getTimestamp()));
        return newBuilder.build();
    }

    private com.google.firebase.firestore.proto.UnknownDocument encodeUnknownDocument(UnknownDocument unknownDocument) {
        UnknownDocument.Builder newBuilder = com.google.firebase.firestore.proto.UnknownDocument.newBuilder();
        newBuilder.setName(this.rpcSerializer.encodeKey(unknownDocument.getKey()));
        newBuilder.setVersion(this.rpcSerializer.encodeTimestamp(unknownDocument.getVersion().getTimestamp()));
        return newBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryData a(Target target) {
        com.google.firebase.firestore.core.Target decodeDocumentsTarget;
        int targetId = target.getTargetId();
        SnapshotVersion decodeVersion = this.rpcSerializer.decodeVersion(target.getSnapshotVersion());
        SnapshotVersion decodeVersion2 = this.rpcSerializer.decodeVersion(target.getLastLimboFreeSnapshotVersion());
        ByteString resumeToken = target.getResumeToken();
        long lastListenSequenceNumber = target.getLastListenSequenceNumber();
        int i = AnonymousClass1.b[target.getTargetTypeCase().ordinal()];
        if (i == 1) {
            decodeDocumentsTarget = this.rpcSerializer.decodeDocumentsTarget(target.getDocuments());
        } else {
            if (i != 2) {
                throw Assert.fail("Unknown targetType %d", target.getTargetTypeCase());
            }
            decodeDocumentsTarget = this.rpcSerializer.decodeQueryTarget(target.getQuery());
        }
        return new QueryData(decodeDocumentsTarget, targetId, lastListenSequenceNumber, QueryPurpose.LISTEN, decodeVersion, decodeVersion2, resumeToken);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.firebase.firestore.model.MaybeDocument a(MaybeDocument maybeDocument) {
        int i = AnonymousClass1.a[maybeDocument.getDocumentTypeCase().ordinal()];
        if (i == 1) {
            return decodeDocument(maybeDocument.getDocument(), maybeDocument.getHasCommittedMutations());
        }
        if (i == 2) {
            return decodeNoDocument(maybeDocument.getNoDocument(), maybeDocument.getHasCommittedMutations());
        }
        if (i == 3) {
            return decodeUnknownDocument(maybeDocument.getUnknownDocument());
        }
        throw Assert.fail("Unknown MaybeDocument %s", maybeDocument);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutationBatch a(WriteBatch writeBatch) {
        int batchId = writeBatch.getBatchId();
        Timestamp decodeTimestamp = this.rpcSerializer.decodeTimestamp(writeBatch.getLocalWriteTime());
        int baseWritesCount = writeBatch.getBaseWritesCount();
        ArrayList arrayList = new ArrayList(baseWritesCount);
        for (int i = 0; i < baseWritesCount; i++) {
            arrayList.add(this.rpcSerializer.decodeMutation(writeBatch.getBaseWrites(i)));
        }
        int writesCount = writeBatch.getWritesCount();
        ArrayList arrayList2 = new ArrayList(writesCount);
        for (int i2 = 0; i2 < writesCount; i2++) {
            arrayList2.add(this.rpcSerializer.decodeMutation(writeBatch.getWrites(i2)));
        }
        return new MutationBatch(batchId, decodeTimestamp, arrayList, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaybeDocument a(com.google.firebase.firestore.model.MaybeDocument maybeDocument) {
        boolean hasCommittedMutations;
        MaybeDocument.Builder newBuilder = MaybeDocument.newBuilder();
        if (maybeDocument instanceof com.google.firebase.firestore.model.NoDocument) {
            com.google.firebase.firestore.model.NoDocument noDocument = (com.google.firebase.firestore.model.NoDocument) maybeDocument;
            newBuilder.setNoDocument(encodeNoDocument(noDocument));
            hasCommittedMutations = noDocument.hasCommittedMutations();
        } else {
            if (!(maybeDocument instanceof com.google.firebase.firestore.model.Document)) {
                if (!(maybeDocument instanceof com.google.firebase.firestore.model.UnknownDocument)) {
                    throw Assert.fail("Unknown document type %s", maybeDocument.getClass().getCanonicalName());
                }
                newBuilder.setUnknownDocument(encodeUnknownDocument((com.google.firebase.firestore.model.UnknownDocument) maybeDocument));
                newBuilder.setHasCommittedMutations(true);
                return newBuilder.build();
            }
            com.google.firebase.firestore.model.Document document = (com.google.firebase.firestore.model.Document) maybeDocument;
            newBuilder.setDocument(document.getProto() != null ? document.getProto() : encodeDocument(document));
            hasCommittedMutations = document.hasCommittedMutations();
        }
        newBuilder.setHasCommittedMutations(hasCommittedMutations);
        return newBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Target a(QueryData queryData) {
        Assert.hardAssert(QueryPurpose.LISTEN.equals(queryData.getPurpose()), "Only queries with purpose %s may be stored, got %s", QueryPurpose.LISTEN, queryData.getPurpose());
        Target.Builder newBuilder = Target.newBuilder();
        newBuilder.setTargetId(queryData.getTargetId()).setLastListenSequenceNumber(queryData.getSequenceNumber()).setLastLimboFreeSnapshotVersion(this.rpcSerializer.encodeVersion(queryData.getLastLimboFreeSnapshotVersion())).setSnapshotVersion(this.rpcSerializer.encodeVersion(queryData.getSnapshotVersion())).setResumeToken(queryData.getResumeToken());
        com.google.firebase.firestore.core.Target target = queryData.getTarget();
        if (target.isDocumentQuery()) {
            newBuilder.setDocuments(this.rpcSerializer.encodeDocumentsTarget(target));
        } else {
            newBuilder.setQuery(this.rpcSerializer.encodeQueryTarget(target));
        }
        return newBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WriteBatch a(MutationBatch mutationBatch) {
        WriteBatch.Builder newBuilder = WriteBatch.newBuilder();
        newBuilder.setBatchId(mutationBatch.getBatchId());
        newBuilder.setLocalWriteTime(this.rpcSerializer.encodeTimestamp(mutationBatch.getLocalWriteTime()));
        Iterator<Mutation> it = mutationBatch.getBaseMutations().iterator();
        while (it.hasNext()) {
            newBuilder.addBaseWrites(this.rpcSerializer.encodeMutation(it.next()));
        }
        Iterator<Mutation> it2 = mutationBatch.getMutations().iterator();
        while (it2.hasNext()) {
            newBuilder.addWrites(this.rpcSerializer.encodeMutation(it2.next()));
        }
        return newBuilder.build();
    }
}
