package io.grpc;

import io.grpc.MethodDescriptor;

@Internal
/* loaded from: classes2.dex */
public final class InternalClientInterceptors {
    public static <ReqT, RespT> ClientInterceptor wrapClientInterceptor(ClientInterceptor clientInterceptor, MethodDescriptor.Marshaller<ReqT> marshaller, MethodDescriptor.Marshaller<RespT> marshaller2) {
        return ClientInterceptors.a(clientInterceptor, marshaller, marshaller2);
    }
}
