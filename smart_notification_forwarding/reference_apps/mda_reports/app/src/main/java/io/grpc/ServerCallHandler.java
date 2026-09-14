package io.grpc;

import io.grpc.ServerCall;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes2.dex */
public interface ServerCallHandler<RequestT, ResponseT> {
    ServerCall.Listener<RequestT> startCall(ServerCall<RequestT, ResponseT> serverCall, Metadata metadata);
}
