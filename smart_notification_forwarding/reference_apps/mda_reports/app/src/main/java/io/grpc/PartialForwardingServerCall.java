package io.grpc;

import com.google.common.base.MoreObjects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class PartialForwardingServerCall<ReqT, RespT> extends ServerCall<ReqT, RespT> {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ServerCall<?, ?> a();

    @Override // io.grpc.ServerCall
    public void close(Status status, Metadata metadata) {
        a().close(status, metadata);
    }

    @Override // io.grpc.ServerCall
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1779")
    public Attributes getAttributes() {
        return a().getAttributes();
    }

    @Override // io.grpc.ServerCall
    public String getAuthority() {
        return a().getAuthority();
    }

    @Override // io.grpc.ServerCall
    public boolean isCancelled() {
        return a().isCancelled();
    }

    @Override // io.grpc.ServerCall
    public boolean isReady() {
        return a().isReady();
    }

    @Override // io.grpc.ServerCall
    public void request(int i) {
        a().request(i);
    }

    @Override // io.grpc.ServerCall
    public void sendHeaders(Metadata metadata) {
        a().sendHeaders(metadata);
    }

    @Override // io.grpc.ServerCall
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public void setCompression(String str) {
        a().setCompression(str);
    }

    @Override // io.grpc.ServerCall
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1703")
    public void setMessageCompression(boolean z) {
        a().setMessageCompression(z);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", a()).toString();
    }
}
