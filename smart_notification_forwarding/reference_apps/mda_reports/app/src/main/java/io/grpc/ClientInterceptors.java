package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.ClientCall;
import io.grpc.MethodDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ClientInterceptors {
    private static final ClientCall<Object, Object> NOOP_CALL = new ClientCall<Object, Object>() { // from class: io.grpc.ClientInterceptors.2
        @Override // io.grpc.ClientCall
        public void cancel(String str, Throwable th) {
        }

        @Override // io.grpc.ClientCall
        public void halfClose() {
        }

        @Override // io.grpc.ClientCall
        public boolean isReady() {
            return false;
        }

        @Override // io.grpc.ClientCall
        public void request(int i) {
        }

        @Override // io.grpc.ClientCall
        public void sendMessage(Object obj) {
        }

        @Override // io.grpc.ClientCall
        public void start(ClientCall.Listener<Object> listener, Metadata metadata) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.grpc.ClientInterceptors$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements ClientInterceptor {
        final /* synthetic */ MethodDescriptor.Marshaller a;
        final /* synthetic */ MethodDescriptor.Marshaller b;
        final /* synthetic */ ClientInterceptor c;

        AnonymousClass1(MethodDescriptor.Marshaller marshaller, MethodDescriptor.Marshaller marshaller2, ClientInterceptor clientInterceptor) {
            this.a = marshaller;
            this.b = marshaller2;
            this.c = clientInterceptor;
        }

        @Override // io.grpc.ClientInterceptor
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(final MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
            final ClientCall<ReqT, RespT> interceptCall = this.c.interceptCall(methodDescriptor.toBuilder(this.a, this.b).build(), callOptions, channel);
            return new PartialForwardingClientCall<ReqT, RespT>() { // from class: io.grpc.ClientInterceptors.1.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // io.grpc.PartialForwardingClientCall
                public ClientCall<?, ?> a() {
                    return interceptCall;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.grpc.ClientCall
                public void sendMessage(ReqT reqt) {
                    interceptCall.sendMessage(AnonymousClass1.this.a.parse(methodDescriptor.getRequestMarshaller().stream(reqt)));
                }

                @Override // io.grpc.ClientCall
                public void start(final ClientCall.Listener<RespT> listener, Metadata metadata) {
                    interceptCall.start(new PartialForwardingClientCallListener<WRespT>() { // from class: io.grpc.ClientInterceptors.1.1.1
                        @Override // io.grpc.PartialForwardingClientCallListener
                        protected ClientCall.Listener<?> a() {
                            return listener;
                        }

                        @Override // io.grpc.ClientCall.Listener
                        public void onMessage(WRespT wrespt) {
                            listener.onMessage(methodDescriptor.getResponseMarshaller().parse(AnonymousClass1.this.b.stream(wrespt)));
                        }
                    }, metadata);
                }
            };
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class CheckedForwardingClientCall<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {
        private ClientCall<ReqT, RespT> delegate;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.PartialForwardingClientCall
        public final ClientCall<ReqT, RespT> a() {
            return this.delegate;
        }

        protected abstract void a(ClientCall.Listener<RespT> listener, Metadata metadata);

        @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
        public final void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
            try {
                a(listener, metadata);
            } catch (Exception e) {
                this.delegate = ClientInterceptors.NOOP_CALL;
                listener.onClose(Status.fromThrowable(e), new Metadata());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class InterceptorChannel extends Channel {
        private final Channel channel;
        private final ClientInterceptor interceptor;

        private InterceptorChannel(Channel channel, ClientInterceptor clientInterceptor) {
            this.channel = channel;
            this.interceptor = (ClientInterceptor) Preconditions.checkNotNull(clientInterceptor, "interceptor");
        }

        /* synthetic */ InterceptorChannel(Channel channel, ClientInterceptor clientInterceptor, AnonymousClass1 anonymousClass1) {
            this(channel, clientInterceptor);
        }

        @Override // io.grpc.Channel
        public String authority() {
            return this.channel.authority();
        }

        @Override // io.grpc.Channel
        public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
            return this.interceptor.interceptCall(methodDescriptor, callOptions, this.channel);
        }
    }

    private ClientInterceptors() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <WReqT, WRespT> ClientInterceptor a(ClientInterceptor clientInterceptor, MethodDescriptor.Marshaller<WReqT> marshaller, MethodDescriptor.Marshaller<WRespT> marshaller2) {
        return new AnonymousClass1(marshaller, marshaller2, clientInterceptor);
    }

    public static Channel intercept(Channel channel, List<? extends ClientInterceptor> list) {
        Preconditions.checkNotNull(channel, "channel");
        Iterator<? extends ClientInterceptor> it = list.iterator();
        while (it.hasNext()) {
            channel = new InterceptorChannel(channel, it.next(), null);
        }
        return channel;
    }

    public static Channel intercept(Channel channel, ClientInterceptor... clientInterceptorArr) {
        return intercept(channel, (List<? extends ClientInterceptor>) Arrays.asList(clientInterceptorArr));
    }

    public static Channel interceptForward(Channel channel, List<? extends ClientInterceptor> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.reverse(arrayList);
        return intercept(channel, arrayList);
    }

    public static Channel interceptForward(Channel channel, ClientInterceptor... clientInterceptorArr) {
        return interceptForward(channel, (List<? extends ClientInterceptor>) Arrays.asList(clientInterceptorArr));
    }
}
