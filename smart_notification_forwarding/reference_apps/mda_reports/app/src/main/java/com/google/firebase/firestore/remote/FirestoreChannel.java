package com.google.firebase.firestore.remote;

import android.content.Context;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Util;
import io.grpc.ClientCall;
import io.grpc.ForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class FirestoreChannel {
    private static final String X_GOOG_API_CLIENT_VALUE = "gl-java/ fire/21.3.1 grpc/";
    private final AsyncQueue asyncQueue;
    private final GrpcCallProvider callProvider;
    private final CredentialsProvider credentialsProvider;
    private final GrpcMetadataProvider metadataProvider;
    private final String resourcePrefixValue;
    private static final Metadata.Key<String> X_GOOG_API_CLIENT_HEADER = Metadata.Key.of("x-goog-api-client", Metadata.ASCII_STRING_MARSHALLER);
    private static final Metadata.Key<String> RESOURCE_PREFIX_HEADER = Metadata.Key.of("google-cloud-resource-prefix", Metadata.ASCII_STRING_MARSHALLER);

    /* renamed from: com.google.firebase.firestore.remote.FirestoreChannel$1 */
    /* loaded from: classes2.dex */
    public class AnonymousClass1<RespT> extends ClientCall.Listener<RespT> {
        final /* synthetic */ IncomingStreamObserver a;
        final /* synthetic */ ClientCall[] b;

        AnonymousClass1(IncomingStreamObserver incomingStreamObserver, ClientCall[] clientCallArr) {
            r2 = incomingStreamObserver;
            r3 = clientCallArr;
        }

        @Override // io.grpc.ClientCall.Listener
        public void onClose(Status status, Metadata metadata) {
            try {
                r2.onClose(status);
            } catch (Throwable th) {
                FirestoreChannel.this.asyncQueue.panic(th);
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onHeaders(Metadata metadata) {
            try {
                r2.onHeaders(metadata);
            } catch (Throwable th) {
                FirestoreChannel.this.asyncQueue.panic(th);
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onMessage(RespT respt) {
            try {
                r2.onNext(respt);
                r3[0].request(1);
            } catch (Throwable th) {
                FirestoreChannel.this.asyncQueue.panic(th);
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onReady() {
        }
    }

    /* renamed from: com.google.firebase.firestore.remote.FirestoreChannel$2 */
    /* loaded from: classes2.dex */
    public class AnonymousClass2<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {
        final /* synthetic */ ClientCall[] a;
        final /* synthetic */ Task b;

        AnonymousClass2(ClientCall[] clientCallArr, Task task) {
            r2 = clientCallArr;
            r3 = task;
        }

        @Override // io.grpc.PartialForwardingClientCall
        public ClientCall<ReqT, RespT> a() {
            Assert.hardAssert(r2[0] != null, "ClientCall used before onOpen() callback", new Object[0]);
            return r2[0];
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public void halfClose() {
            OnSuccessListener onSuccessListener;
            if (r2[0] != null) {
                super.halfClose();
                return;
            }
            Task task = r3;
            Executor executor = FirestoreChannel.this.asyncQueue.getExecutor();
            onSuccessListener = FirestoreChannel$2$$Lambda$1.instance;
            task.addOnSuccessListener(executor, onSuccessListener);
        }
    }

    /* renamed from: com.google.firebase.firestore.remote.FirestoreChannel$3 */
    /* loaded from: classes2.dex */
    public class AnonymousClass3<RespT> extends ClientCall.Listener<RespT> {
        final /* synthetic */ List a;
        final /* synthetic */ ClientCall b;
        final /* synthetic */ TaskCompletionSource c;

        AnonymousClass3(List list, ClientCall clientCall, TaskCompletionSource taskCompletionSource) {
            r2 = list;
            r3 = clientCall;
            r4 = taskCompletionSource;
        }

        @Override // io.grpc.ClientCall.Listener
        public void onClose(Status status, Metadata metadata) {
            if (status.isOk()) {
                r4.setResult(r2);
            } else {
                r4.setException(FirestoreChannel.this.exceptionFromStatus(status));
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onMessage(RespT respt) {
            r2.add(respt);
            r3.request(1);
        }
    }

    /* renamed from: com.google.firebase.firestore.remote.FirestoreChannel$4 */
    /* loaded from: classes2.dex */
    public class AnonymousClass4<RespT> extends ClientCall.Listener<RespT> {
        final /* synthetic */ TaskCompletionSource a;

        AnonymousClass4(TaskCompletionSource taskCompletionSource) {
            r2 = taskCompletionSource;
        }

        @Override // io.grpc.ClientCall.Listener
        public void onClose(Status status, Metadata metadata) {
            if (!status.isOk()) {
                r2.setException(FirestoreChannel.this.exceptionFromStatus(status));
            } else {
                if (r2.getTask().isComplete()) {
                    return;
                }
                r2.setException(new FirebaseFirestoreException("Received onClose with status OK, but no message.", FirebaseFirestoreException.Code.INTERNAL));
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onMessage(RespT respt) {
            r2.setResult(respt);
        }
    }

    public FirestoreChannel(AsyncQueue asyncQueue, Context context, CredentialsProvider credentialsProvider, DatabaseInfo databaseInfo, GrpcMetadataProvider grpcMetadataProvider) {
        this.asyncQueue = asyncQueue;
        this.metadataProvider = grpcMetadataProvider;
        this.credentialsProvider = credentialsProvider;
        this.callProvider = new GrpcCallProvider(asyncQueue, context, databaseInfo, new FirestoreCallCredentials(credentialsProvider));
        DatabaseId databaseId = databaseInfo.getDatabaseId();
        this.resourcePrefixValue = String.format("projects/%s/databases/%s", databaseId.getProjectId(), databaseId.getDatabaseId());
    }

    public static /* synthetic */ void a(FirestoreChannel firestoreChannel, TaskCompletionSource taskCompletionSource, Object obj, Task task) {
        ClientCall clientCall = (ClientCall) task.getResult();
        clientCall.start(new ClientCall.Listener<RespT>() { // from class: com.google.firebase.firestore.remote.FirestoreChannel.4
            final /* synthetic */ TaskCompletionSource a;

            AnonymousClass4(TaskCompletionSource taskCompletionSource2) {
                r2 = taskCompletionSource2;
            }

            @Override // io.grpc.ClientCall.Listener
            public void onClose(Status status, Metadata metadata) {
                if (!status.isOk()) {
                    r2.setException(FirestoreChannel.this.exceptionFromStatus(status));
                } else {
                    if (r2.getTask().isComplete()) {
                        return;
                    }
                    r2.setException(new FirebaseFirestoreException("Received onClose with status OK, but no message.", FirebaseFirestoreException.Code.INTERNAL));
                }
            }

            @Override // io.grpc.ClientCall.Listener
            public void onMessage(RespT respt) {
                r2.setResult(respt);
            }
        }, firestoreChannel.requestHeaders());
        clientCall.request(2);
        clientCall.sendMessage(obj);
        clientCall.halfClose();
    }

    public static /* synthetic */ void a(FirestoreChannel firestoreChannel, ClientCall[] clientCallArr, IncomingStreamObserver incomingStreamObserver, Task task) {
        clientCallArr[0] = (ClientCall) task.getResult();
        clientCallArr[0].start(new ClientCall.Listener<RespT>() { // from class: com.google.firebase.firestore.remote.FirestoreChannel.1
            final /* synthetic */ IncomingStreamObserver a;
            final /* synthetic */ ClientCall[] b;

            AnonymousClass1(IncomingStreamObserver incomingStreamObserver2, ClientCall[] clientCallArr2) {
                r2 = incomingStreamObserver2;
                r3 = clientCallArr2;
            }

            @Override // io.grpc.ClientCall.Listener
            public void onClose(Status status, Metadata metadata) {
                try {
                    r2.onClose(status);
                } catch (Throwable th) {
                    FirestoreChannel.this.asyncQueue.panic(th);
                }
            }

            @Override // io.grpc.ClientCall.Listener
            public void onHeaders(Metadata metadata) {
                try {
                    r2.onHeaders(metadata);
                } catch (Throwable th) {
                    FirestoreChannel.this.asyncQueue.panic(th);
                }
            }

            @Override // io.grpc.ClientCall.Listener
            public void onMessage(RespT respt) {
                try {
                    r2.onNext(respt);
                    r3[0].request(1);
                } catch (Throwable th) {
                    FirestoreChannel.this.asyncQueue.panic(th);
                }
            }

            @Override // io.grpc.ClientCall.Listener
            public void onReady() {
            }
        }, firestoreChannel.requestHeaders());
        incomingStreamObserver2.onOpen();
        clientCallArr2[0].request(1);
    }

    public static /* synthetic */ void b(FirestoreChannel firestoreChannel, TaskCompletionSource taskCompletionSource, Object obj, Task task) {
        ClientCall clientCall = (ClientCall) task.getResult();
        clientCall.start(new ClientCall.Listener<RespT>() { // from class: com.google.firebase.firestore.remote.FirestoreChannel.3
            final /* synthetic */ List a;
            final /* synthetic */ ClientCall b;
            final /* synthetic */ TaskCompletionSource c;

            AnonymousClass3(List list, ClientCall clientCall2, TaskCompletionSource taskCompletionSource2) {
                r2 = list;
                r3 = clientCall2;
                r4 = taskCompletionSource2;
            }

            @Override // io.grpc.ClientCall.Listener
            public void onClose(Status status, Metadata metadata) {
                if (status.isOk()) {
                    r4.setResult(r2);
                } else {
                    r4.setException(FirestoreChannel.this.exceptionFromStatus(status));
                }
            }

            @Override // io.grpc.ClientCall.Listener
            public void onMessage(RespT respt) {
                r2.add(respt);
                r3.request(1);
            }
        }, firestoreChannel.requestHeaders());
        clientCall2.request(1);
        clientCall2.sendMessage(obj);
        clientCall2.halfClose();
    }

    public FirebaseFirestoreException exceptionFromStatus(Status status) {
        return Datastore.isMissingSslCiphers(status) ? new FirebaseFirestoreException("The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", FirebaseFirestoreException.Code.fromValue(status.getCode().value()), status.getCause()) : Util.exceptionFromStatus(status);
    }

    private Metadata requestHeaders() {
        Metadata metadata = new Metadata();
        metadata.put(X_GOOG_API_CLIENT_HEADER, X_GOOG_API_CLIENT_VALUE);
        metadata.put(RESOURCE_PREFIX_HEADER, this.resourcePrefixValue);
        GrpcMetadataProvider grpcMetadataProvider = this.metadataProvider;
        if (grpcMetadataProvider != null) {
            grpcMetadataProvider.updateMetadata(metadata);
        }
        return metadata;
    }

    public <ReqT, RespT> Task<RespT> a(MethodDescriptor<ReqT, RespT> methodDescriptor, ReqT reqt) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.callProvider.a(methodDescriptor).addOnCompleteListener(this.asyncQueue.getExecutor(), FirestoreChannel$$Lambda$3.lambdaFactory$(this, taskCompletionSource, reqt));
        return taskCompletionSource.getTask();
    }

    public <ReqT, RespT> ClientCall<ReqT, RespT> a(MethodDescriptor<ReqT, RespT> methodDescriptor, IncomingStreamObserver<RespT> incomingStreamObserver) {
        ClientCall[] clientCallArr = {null};
        Task<ClientCall<ReqT, RespT>> a = this.callProvider.a(methodDescriptor);
        a.addOnCompleteListener(this.asyncQueue.getExecutor(), FirestoreChannel$$Lambda$1.lambdaFactory$(this, clientCallArr, incomingStreamObserver));
        return new ForwardingClientCall<ReqT, RespT>() { // from class: com.google.firebase.firestore.remote.FirestoreChannel.2
            final /* synthetic */ ClientCall[] a;
            final /* synthetic */ Task b;

            AnonymousClass2(ClientCall[] clientCallArr2, Task a2) {
                r2 = clientCallArr2;
                r3 = a2;
            }

            @Override // io.grpc.PartialForwardingClientCall
            public ClientCall<ReqT, RespT> a() {
                Assert.hardAssert(r2[0] != null, "ClientCall used before onOpen() callback", new Object[0]);
                return r2[0];
            }

            @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
            public void halfClose() {
                OnSuccessListener onSuccessListener;
                if (r2[0] != null) {
                    super.halfClose();
                    return;
                }
                Task task = r3;
                Executor executor = FirestoreChannel.this.asyncQueue.getExecutor();
                onSuccessListener = FirestoreChannel$2$$Lambda$1.instance;
                task.addOnSuccessListener(executor, onSuccessListener);
            }
        };
    }

    public <ReqT, RespT> Task<List<RespT>> b(MethodDescriptor<ReqT, RespT> methodDescriptor, ReqT reqt) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.callProvider.a(methodDescriptor).addOnCompleteListener(this.asyncQueue.getExecutor(), FirestoreChannel$$Lambda$2.lambdaFactory$(this, taskCompletionSource, reqt));
        return taskCompletionSource.getTask();
    }

    public void invalidateToken() {
        this.credentialsProvider.invalidateToken();
    }

    public void shutdown() {
        this.callProvider.a();
    }
}
