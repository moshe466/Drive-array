package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.ServerServiceDefinition;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class ServerInterceptors {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class InterceptCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
        private final ServerCallHandler<ReqT, RespT> callHandler;
        private final ServerInterceptor interceptor;

        private InterceptCallHandler(ServerInterceptor serverInterceptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
            this.interceptor = (ServerInterceptor) Preconditions.checkNotNull(serverInterceptor, "interceptor");
            this.callHandler = serverCallHandler;
        }

        public static <ReqT, RespT> InterceptCallHandler<ReqT, RespT> create(ServerInterceptor serverInterceptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
            return new InterceptCallHandler<>(serverInterceptor, serverCallHandler);
        }

        @Override // io.grpc.ServerCallHandler
        public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata) {
            return this.interceptor.interceptCall(serverCall, metadata, this.callHandler);
        }
    }

    private ServerInterceptors() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <OReqT, ORespT, WReqT, WRespT> ServerMethodDefinition<WReqT, WRespT> a(ServerMethodDefinition<OReqT, ORespT> serverMethodDefinition, MethodDescriptor<WReqT, WRespT> methodDescriptor) {
        return ServerMethodDefinition.create(methodDescriptor, wrapHandler(serverMethodDefinition.getServerCallHandler(), serverMethodDefinition.getMethodDescriptor(), methodDescriptor));
    }

    public static ServerServiceDefinition intercept(BindableService bindableService, List<? extends ServerInterceptor> list) {
        Preconditions.checkNotNull(bindableService, "bindableService");
        return intercept(bindableService.bindService(), list);
    }

    public static ServerServiceDefinition intercept(BindableService bindableService, ServerInterceptor... serverInterceptorArr) {
        Preconditions.checkNotNull(bindableService, "bindableService");
        return intercept(bindableService.bindService(), (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition intercept(ServerServiceDefinition serverServiceDefinition, List<? extends ServerInterceptor> list) {
        Preconditions.checkNotNull(serverServiceDefinition, "serviceDef");
        if (list.isEmpty()) {
            return serverServiceDefinition;
        }
        ServerServiceDefinition.Builder builder = ServerServiceDefinition.builder(serverServiceDefinition.getServiceDescriptor());
        Iterator<ServerMethodDefinition<?, ?>> it = serverServiceDefinition.getMethods().iterator();
        while (it.hasNext()) {
            wrapAndAddMethod(builder, it.next(), list);
        }
        return builder.build();
    }

    public static ServerServiceDefinition intercept(ServerServiceDefinition serverServiceDefinition, ServerInterceptor... serverInterceptorArr) {
        return intercept(serverServiceDefinition, (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition interceptForward(BindableService bindableService, List<? extends ServerInterceptor> list) {
        return interceptForward(bindableService.bindService(), list);
    }

    public static ServerServiceDefinition interceptForward(BindableService bindableService, ServerInterceptor... serverInterceptorArr) {
        return interceptForward(bindableService.bindService(), (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition interceptForward(ServerServiceDefinition serverServiceDefinition, List<? extends ServerInterceptor> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.reverse(arrayList);
        return intercept(serverServiceDefinition, arrayList);
    }

    public static ServerServiceDefinition interceptForward(ServerServiceDefinition serverServiceDefinition, ServerInterceptor... serverInterceptorArr) {
        return interceptForward(serverServiceDefinition, (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1712")
    public static ServerServiceDefinition useInputStreamMessages(ServerServiceDefinition serverServiceDefinition) {
        return useMarshalledMessages(serverServiceDefinition, new MethodDescriptor.Marshaller<InputStream>() { // from class: io.grpc.ServerInterceptors.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.MethodDescriptor.Marshaller
            public InputStream parse(InputStream inputStream) {
                return inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream);
            }

            @Override // io.grpc.MethodDescriptor.Marshaller
            public InputStream stream(InputStream inputStream) {
                return inputStream;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1712")
    public static <T> ServerServiceDefinition useMarshalledMessages(ServerServiceDefinition serverServiceDefinition, MethodDescriptor.Marshaller<T> marshaller) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ServerMethodDefinition<?, ?> serverMethodDefinition : serverServiceDefinition.getMethods()) {
            MethodDescriptor build = serverMethodDefinition.getMethodDescriptor().toBuilder(marshaller, marshaller).build();
            arrayList2.add(build);
            arrayList.add(a(serverMethodDefinition, build));
        }
        ServerServiceDefinition.Builder builder = ServerServiceDefinition.builder(new ServiceDescriptor(serverServiceDefinition.getServiceDescriptor().getName(), arrayList2));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            builder.addMethod((ServerMethodDefinition) it.next());
        }
        return builder.build();
    }

    private static <ReqT, RespT> void wrapAndAddMethod(ServerServiceDefinition.Builder builder, ServerMethodDefinition<ReqT, RespT> serverMethodDefinition, List<? extends ServerInterceptor> list) {
        ServerCallHandler<ReqT, RespT> serverCallHandler = serverMethodDefinition.getServerCallHandler();
        Iterator<? extends ServerInterceptor> it = list.iterator();
        while (it.hasNext()) {
            serverCallHandler = InterceptCallHandler.create(it.next(), serverCallHandler);
        }
        builder.addMethod(serverMethodDefinition.withServerCallHandler(serverCallHandler));
    }

    private static <OReqT, ORespT, WReqT, WRespT> ServerCallHandler<WReqT, WRespT> wrapHandler(final ServerCallHandler<OReqT, ORespT> serverCallHandler, final MethodDescriptor<OReqT, ORespT> methodDescriptor, final MethodDescriptor<WReqT, WRespT> methodDescriptor2) {
        return new ServerCallHandler<WReqT, WRespT>() { // from class: io.grpc.ServerInterceptors.2
            @Override // io.grpc.ServerCallHandler
            public ServerCall.Listener<WReqT> startCall(final ServerCall<WReqT, WRespT> serverCall, Metadata metadata) {
                final ServerCall.Listener startCall = serverCallHandler.startCall(new PartialForwardingServerCall<OReqT, ORespT>() { // from class: io.grpc.ServerInterceptors.2.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // io.grpc.PartialForwardingServerCall
                    public ServerCall<WReqT, WRespT> a() {
                        return serverCall;
                    }

                    @Override // io.grpc.ServerCall
                    public MethodDescriptor<OReqT, ORespT> getMethodDescriptor() {
                        return MethodDescriptor.this;
                    }

                    @Override // io.grpc.ServerCall
                    public void sendMessage(ORespT orespt) {
                        a().sendMessage(methodDescriptor2.parseResponse(MethodDescriptor.this.streamResponse(orespt)));
                    }
                }, metadata);
                return new PartialForwardingServerCallListener<WReqT>() { // from class: io.grpc.ServerInterceptors.2.2
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // io.grpc.PartialForwardingServerCallListener
                    public ServerCall.Listener<OReqT> a() {
                        return startCall;
                    }

                    @Override // io.grpc.ServerCall.Listener
                    public void onMessage(WReqT wreqt) {
                        a().onMessage(MethodDescriptor.this.parseRequest(methodDescriptor2.streamRequest(wreqt)));
                    }
                };
            }
        };
    }
}
