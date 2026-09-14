package com.google.firebase.firestore.remote;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.remote.WatchStream;
import com.google.firebase.firestore.remote.WriteStream;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.FirestoreGrpc;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;

/* loaded from: classes2.dex */
public class Datastore {
    static final Set<String> a = new HashSet(Arrays.asList("date", "x-google-backends", "x-google-netmon-label", "x-google-service", "x-google-gfe-request-trace"));
    private final FirestoreChannel channel;
    private final DatabaseInfo databaseInfo;
    private final RemoteSerializer serializer;
    private final AsyncQueue workerQueue;

    /* renamed from: com.google.firebase.firestore.remote.Datastore$1 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[FirebaseFirestoreException.Code.values().length];

        static {
            try {
                a[FirebaseFirestoreException.Code.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FirebaseFirestoreException.Code.CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FirebaseFirestoreException.Code.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FirebaseFirestoreException.Code.DEADLINE_EXCEEDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[FirebaseFirestoreException.Code.RESOURCE_EXHAUSTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[FirebaseFirestoreException.Code.INTERNAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[FirebaseFirestoreException.Code.UNAVAILABLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[FirebaseFirestoreException.Code.UNAUTHENTICATED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[FirebaseFirestoreException.Code.INVALID_ARGUMENT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[FirebaseFirestoreException.Code.NOT_FOUND.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[FirebaseFirestoreException.Code.ALREADY_EXISTS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[FirebaseFirestoreException.Code.PERMISSION_DENIED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[FirebaseFirestoreException.Code.FAILED_PRECONDITION.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[FirebaseFirestoreException.Code.ABORTED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[FirebaseFirestoreException.Code.OUT_OF_RANGE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[FirebaseFirestoreException.Code.UNIMPLEMENTED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[FirebaseFirestoreException.Code.DATA_LOSS.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public Datastore(DatabaseInfo databaseInfo, AsyncQueue asyncQueue, CredentialsProvider credentialsProvider, Context context, @Nullable GrpcMetadataProvider grpcMetadataProvider) {
        this.databaseInfo = databaseInfo;
        this.workerQueue = asyncQueue;
        this.serializer = new RemoteSerializer(databaseInfo.getDatabaseId());
        this.channel = new FirestoreChannel(asyncQueue, context, credentialsProvider, databaseInfo, grpcMetadataProvider);
    }

    public static /* synthetic */ List a(Datastore datastore, Task task) {
        if (!task.isSuccessful()) {
            if ((task.getException() instanceof FirebaseFirestoreException) && ((FirebaseFirestoreException) task.getException()).getCode() == FirebaseFirestoreException.Code.UNAUTHENTICATED) {
                datastore.channel.invalidateToken();
            }
            throw task.getException();
        }
        CommitResponse commitResponse = (CommitResponse) task.getResult();
        SnapshotVersion decodeVersion = datastore.serializer.decodeVersion(commitResponse.getCommitTime());
        int writeResultsCount = commitResponse.getWriteResultsCount();
        ArrayList arrayList = new ArrayList(writeResultsCount);
        for (int i = 0; i < writeResultsCount; i++) {
            arrayList.add(datastore.serializer.decodeMutationResult(commitResponse.getWriteResults(i), decodeVersion));
        }
        return arrayList;
    }

    public static /* synthetic */ List a(Datastore datastore, List list, Task task) {
        if (!task.isSuccessful() && (task.getException() instanceof FirebaseFirestoreException) && ((FirebaseFirestoreException) task.getException()).getCode() == FirebaseFirestoreException.Code.UNAUTHENTICATED) {
            datastore.channel.invalidateToken();
        }
        HashMap hashMap = new HashMap();
        Iterator it = ((List) task.getResult()).iterator();
        while (it.hasNext()) {
            MaybeDocument decodeMaybeDocument = datastore.serializer.decodeMaybeDocument((BatchGetDocumentsResponse) it.next());
            hashMap.put(decodeMaybeDocument.getKey(), decodeMaybeDocument);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add((MaybeDocument) hashMap.get((DocumentKey) it2.next()));
        }
        return arrayList;
    }

    public static boolean isMissingSslCiphers(Status status) {
        Status.Code code = status.getCode();
        Throwable cause = status.getCause();
        return Build.VERSION.SDK_INT < 21 && code.equals(Status.Code.UNAVAILABLE) && ((cause instanceof SSLHandshakeException) && cause.getMessage().contains("no ciphers available"));
    }

    public static boolean isPermanentError(FirebaseFirestoreException.Code code) {
        switch (AnonymousClass1.a[code.ordinal()]) {
            case 1:
                throw new IllegalArgumentException("Treated status OK as error");
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return false;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                return true;
            default:
                throw new IllegalArgumentException("Unknown gRPC status code: " + code);
        }
    }

    public static boolean isPermanentError(Status status) {
        return isPermanentError(FirebaseFirestoreException.Code.fromValue(status.getCode().value()));
    }

    public static boolean isPermanentWriteError(Status status) {
        return isPermanentError(status) && !status.getCode().equals(Status.Code.ABORTED);
    }

    public WatchStream a(WatchStream.Callback callback) {
        return new WatchStream(this.channel, this.workerQueue, this.serializer, callback);
    }

    public WriteStream a(WriteStream.Callback callback) {
        return new WriteStream(this.channel, this.workerQueue, this.serializer, callback);
    }

    public void a() {
        this.channel.shutdown();
    }

    public Task<List<MutationResult>> commit(List<Mutation> list) {
        CommitRequest.Builder newBuilder = CommitRequest.newBuilder();
        newBuilder.setDatabase(this.serializer.databaseName());
        Iterator<Mutation> it = list.iterator();
        while (it.hasNext()) {
            newBuilder.addWrites(this.serializer.encodeMutation(it.next()));
        }
        return this.channel.a((MethodDescriptor<MethodDescriptor<CommitRequest, CommitResponse>, RespT>) FirestoreGrpc.getCommitMethod(), (MethodDescriptor<CommitRequest, CommitResponse>) newBuilder.build()).continueWith(this.workerQueue.getExecutor(), Datastore$$Lambda$1.lambdaFactory$(this));
    }

    public Task<List<MaybeDocument>> lookup(List<DocumentKey> list) {
        BatchGetDocumentsRequest.Builder newBuilder = BatchGetDocumentsRequest.newBuilder();
        newBuilder.setDatabase(this.serializer.databaseName());
        Iterator<DocumentKey> it = list.iterator();
        while (it.hasNext()) {
            newBuilder.addDocuments(this.serializer.encodeKey(it.next()));
        }
        return this.channel.b(FirestoreGrpc.getBatchGetDocumentsMethod(), newBuilder.build()).continueWith(this.workerQueue.getExecutor(), Datastore$$Lambda$2.lambdaFactory$(this, list));
    }
}
