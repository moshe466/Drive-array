package io.grpc.stub;

import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ExperimentalApi;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class MetadataUtils {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class HeaderAttachingClientInterceptor implements ClientInterceptor {
        private final Metadata extraHeaders;

        /* loaded from: classes2.dex */
        private final class HeaderAttachingClientCall<ReqT, RespT> extends ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT> {
            HeaderAttachingClientCall(ClientCall<ReqT, RespT> clientCall) {
                super(clientCall);
            }

            @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
            public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
                metadata.merge(HeaderAttachingClientInterceptor.this.extraHeaders);
                super.start(listener, metadata);
            }
        }

        HeaderAttachingClientInterceptor(Metadata metadata) {
            this.extraHeaders = (Metadata) Preconditions.checkNotNull(metadata, "extraHeaders");
        }

        @Override // io.grpc.ClientInterceptor
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
            return new HeaderAttachingClientCall(channel.newCall(methodDescriptor, callOptions));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class MetadataCapturingClientInterceptor implements ClientInterceptor {
        final AtomicReference<Metadata> a;
        final AtomicReference<Metadata> b;

        /* loaded from: classes2.dex */
        private final class MetadataCapturingClientCall<ReqT, RespT> extends ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT> {

            /* loaded from: classes2.dex */
            private final class MetadataCapturingClientCallListener extends ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT> {
                MetadataCapturingClientCallListener(ClientCall.Listener<RespT> listener) {
                    super(listener);
                }

                @Override // io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener, io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
                public void onClose(Status status, Metadata metadata) {
                    MetadataCapturingClientInterceptor.this.b.set(metadata);
                    super.onClose(status, metadata);
                }

                @Override // io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener, io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
                public void onHeaders(Metadata metadata) {
                    MetadataCapturingClientInterceptor.this.a.set(metadata);
                    super.onHeaders(metadata);
                }
            }

            MetadataCapturingClientCall(ClientCall<ReqT, RespT> clientCall) {
                super(clientCall);
            }

            @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
            public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
                MetadataCapturingClientInterceptor.this.a.set(null);
                MetadataCapturingClientInterceptor.this.b.set(null);
                super.start(new MetadataCapturingClientCallListener(listener), metadata);
            }
        }

        MetadataCapturingClientInterceptor(AtomicReference<Metadata> atomicReference, AtomicReference<Metadata> atomicReference2) {
            this.a = (AtomicReference) Preconditions.checkNotNull(atomicReference, "headersCapture");
            this.b = (AtomicReference) Preconditions.checkNotNull(atomicReference2, "trailersCapture");
        }

        @Override // io.grpc.ClientInterceptor
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
            return new MetadataCapturingClientCall(channel.newCall(methodDescriptor, callOptions));
        }
    }

    private MetadataUtils() {
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1789")
    public static <T extends AbstractStub<T>> T attachHeaders(T t, Metadata metadata) {
        return (T) t.withInterceptors(newAttachHeadersInterceptor(metadata));
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1789")
    public static <T extends AbstractStub<T>> T captureMetadata(T t, AtomicReference<Metadata> atomicReference, AtomicReference<Metadata> atomicReference2) {
        return (T) t.withInterceptors(newCaptureMetadataInterceptor(atomicReference, atomicReference2));
    }

    public static ClientInterceptor newAttachHeadersInterceptor(Metadata metadata) {
        return new HeaderAttachingClientInterceptor(metadata);
    }

    public static ClientInterceptor newCaptureMetadataInterceptor(AtomicReference<Metadata> atomicReference, AtomicReference<Metadata> atomicReference2) {
        return new MetadataCapturingClientInterceptor(atomicReference, atomicReference2);
    }
}
