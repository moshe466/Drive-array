package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.BindableService;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import io.grpc.protobuf.lite.ProtoLiteUtils;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;
import io.grpc.stub.annotations.RpcMethod;

/* loaded from: classes2.dex */
public final class InAppMessagingSdkServingGrpc {
    private static final int METHODID_FETCH_ELIGIBLE_CAMPAIGNS = 0;
    public static final String SERVICE_NAME = "google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServing";
    private static volatile MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> getFetchEligibleCampaignsMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: classes2.dex */
    public static final class InAppMessagingSdkServingBlockingStub extends AbstractStub<InAppMessagingSdkServingBlockingStub> {
        private InAppMessagingSdkServingBlockingStub(Channel channel) {
            super(channel);
        }

        private InAppMessagingSdkServingBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.stub.AbstractStub
        public InAppMessagingSdkServingBlockingStub a(Channel channel, CallOptions callOptions) {
            return new InAppMessagingSdkServingBlockingStub(channel, callOptions);
        }

        public FetchEligibleCampaignsResponse fetchEligibleCampaigns(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest) {
            return (FetchEligibleCampaignsResponse) ClientCalls.blockingUnaryCall(getChannel(), InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod(), getCallOptions(), fetchEligibleCampaignsRequest);
        }
    }

    /* loaded from: classes2.dex */
    public static final class InAppMessagingSdkServingFutureStub extends AbstractStub<InAppMessagingSdkServingFutureStub> {
        private InAppMessagingSdkServingFutureStub(Channel channel) {
            super(channel);
        }

        private InAppMessagingSdkServingFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.stub.AbstractStub
        public InAppMessagingSdkServingFutureStub a(Channel channel, CallOptions callOptions) {
            return new InAppMessagingSdkServingFutureStub(channel, callOptions);
        }

        public ListenableFuture<FetchEligibleCampaignsResponse> fetchEligibleCampaigns(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod(), getCallOptions()), fetchEligibleCampaignsRequest);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class InAppMessagingSdkServingImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(InAppMessagingSdkServingGrpc.getServiceDescriptor()).addMethod(InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }

        public void fetchEligibleCampaigns(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest, StreamObserver<FetchEligibleCampaignsResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod(), streamObserver);
        }
    }

    /* loaded from: classes2.dex */
    public static final class InAppMessagingSdkServingStub extends AbstractStub<InAppMessagingSdkServingStub> {
        private InAppMessagingSdkServingStub(Channel channel) {
            super(channel);
        }

        private InAppMessagingSdkServingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.stub.AbstractStub
        public InAppMessagingSdkServingStub a(Channel channel, CallOptions callOptions) {
            return new InAppMessagingSdkServingStub(channel, callOptions);
        }

        public void fetchEligibleCampaigns(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest, StreamObserver<FetchEligibleCampaignsResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod(), getCallOptions()), fetchEligibleCampaignsRequest, streamObserver);
        }
    }

    /* loaded from: classes2.dex */
    private static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final InAppMessagingSdkServingImplBase serviceImpl;

        MethodHandlers(InAppMessagingSdkServingImplBase inAppMessagingSdkServingImplBase, int i) {
            this.serviceImpl = inAppMessagingSdkServingImplBase;
            this.methodId = i;
        }

        @Override // io.grpc.stub.ServerCalls.StreamingRequestMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.stub.ServerCalls.UnaryRequestMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            if (this.methodId != 0) {
                throw new AssertionError();
            }
            this.serviceImpl.fetchEligibleCampaigns((FetchEligibleCampaignsRequest) req, streamObserver);
        }
    }

    private InAppMessagingSdkServingGrpc() {
    }

    @RpcMethod(fullMethodName = "google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServing/FetchEligibleCampaigns", methodType = MethodDescriptor.MethodType.UNARY, requestType = FetchEligibleCampaignsRequest.class, responseType = FetchEligibleCampaignsResponse.class)
    public static MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> getFetchEligibleCampaignsMethod() {
        MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> methodDescriptor = getFetchEligibleCampaignsMethod;
        if (methodDescriptor == null) {
            synchronized (InAppMessagingSdkServingGrpc.class) {
                methodDescriptor = getFetchEligibleCampaignsMethod;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "FetchEligibleCampaigns")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(FetchEligibleCampaignsRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(FetchEligibleCampaignsResponse.getDefaultInstance())).build();
                    getFetchEligibleCampaignsMethod = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    public static ServiceDescriptor getServiceDescriptor() {
        ServiceDescriptor serviceDescriptor2 = serviceDescriptor;
        if (serviceDescriptor2 == null) {
            synchronized (InAppMessagingSdkServingGrpc.class) {
                serviceDescriptor2 = serviceDescriptor;
                if (serviceDescriptor2 == null) {
                    serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).addMethod(getFetchEligibleCampaignsMethod()).build();
                    serviceDescriptor = serviceDescriptor2;
                }
            }
        }
        return serviceDescriptor2;
    }

    public static InAppMessagingSdkServingBlockingStub newBlockingStub(Channel channel) {
        return new InAppMessagingSdkServingBlockingStub(channel);
    }

    public static InAppMessagingSdkServingFutureStub newFutureStub(Channel channel) {
        return new InAppMessagingSdkServingFutureStub(channel);
    }

    public static InAppMessagingSdkServingStub newStub(Channel channel) {
        return new InAppMessagingSdkServingStub(channel);
    }
}
