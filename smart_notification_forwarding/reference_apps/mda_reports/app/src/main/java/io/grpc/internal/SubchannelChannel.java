package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Context;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientCallImpl;
import io.grpc.internal.ClientStreamListener;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
final class SubchannelChannel extends Channel {

    @VisibleForTesting
    static final Status a = Status.UNAVAILABLE.withDescription("Subchannel is NOT READY");

    @VisibleForTesting
    static final Status b = Status.UNAVAILABLE.withDescription("wait-for-ready RPC is not supported on Subchannel.asChannel()");
    private static final FailingClientTransport notReadyTransport = new FailingClientTransport(a, ClientStreamListener.RpcProgress.REFUSED);
    private final CallTracer callsTracer;
    private final ScheduledExecutorService deadlineCancellationExecutor;
    private final Executor executor;
    private final InternalSubchannel subchannel;
    private final ClientCallImpl.ClientTransportProvider transportProvider = new ClientCallImpl.ClientTransportProvider() { // from class: io.grpc.internal.SubchannelChannel.1
        @Override // io.grpc.internal.ClientCallImpl.ClientTransportProvider
        public ClientTransport get(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            ClientTransport e = SubchannelChannel.this.subchannel.e();
            return e == null ? SubchannelChannel.notReadyTransport : e;
        }

        @Override // io.grpc.internal.ClientCallImpl.ClientTransportProvider
        public <ReqT> ClientStream newRetriableStream(MethodDescriptor<ReqT, ?> methodDescriptor, CallOptions callOptions, Metadata metadata, Context context) {
            throw new UnsupportedOperationException("OobChannel should not create retriable streams");
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubchannelChannel(InternalSubchannel internalSubchannel, Executor executor, ScheduledExecutorService scheduledExecutorService, CallTracer callTracer) {
        this.subchannel = (InternalSubchannel) Preconditions.checkNotNull(internalSubchannel, "subchannel");
        this.executor = (Executor) Preconditions.checkNotNull(executor, "executor");
        this.deadlineCancellationExecutor = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService, "deadlineCancellationExecutor");
        this.callsTracer = (CallTracer) Preconditions.checkNotNull(callTracer, "callsTracer");
    }

    @Override // io.grpc.Channel
    public String authority() {
        return this.subchannel.b();
    }

    @Override // io.grpc.Channel
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
        final Executor executor = callOptions.getExecutor() == null ? this.executor : callOptions.getExecutor();
        return callOptions.isWaitForReady() ? new ClientCall<RequestT, ResponseT>(this) { // from class: io.grpc.internal.SubchannelChannel.2
            @Override // io.grpc.ClientCall
            public void cancel(String str, Throwable th) {
            }

            @Override // io.grpc.ClientCall
            public void halfClose() {
            }

            @Override // io.grpc.ClientCall
            public void request(int i) {
            }

            @Override // io.grpc.ClientCall
            public void sendMessage(RequestT requestt) {
            }

            @Override // io.grpc.ClientCall
            public void start(final ClientCall.Listener<ResponseT> listener, Metadata metadata) {
                executor.execute(new Runnable(this) { // from class: io.grpc.internal.SubchannelChannel.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        listener.onClose(SubchannelChannel.b, new Metadata());
                    }
                });
            }
        } : new ClientCallImpl(methodDescriptor, executor, callOptions.withOption(GrpcUtil.CALL_OPTIONS_RPC_OWNED_BY_BALANCER, Boolean.TRUE), this.transportProvider, this.deadlineCancellationExecutor, this.callsTracer, false);
    }
}
