package io.grpc;

import com.google.common.base.MoreObjects;
import io.grpc.ClientCall;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class PartialForwardingClientCallListener<RespT> extends ClientCall.Listener<RespT> {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ClientCall.Listener<?> a();

    @Override // io.grpc.ClientCall.Listener
    public void onClose(Status status, Metadata metadata) {
        a().onClose(status, metadata);
    }

    @Override // io.grpc.ClientCall.Listener
    public void onHeaders(Metadata metadata) {
        a().onHeaders(metadata);
    }

    @Override // io.grpc.ClientCall.Listener
    public void onReady() {
        a().onReady();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", a()).toString();
    }
}
