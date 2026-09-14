package io.grpc;

import com.google.common.base.MoreObjects;
import io.grpc.ServerCall;

/* loaded from: classes2.dex */
abstract class PartialForwardingServerCallListener<ReqT> extends ServerCall.Listener<ReqT> {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ServerCall.Listener<?> a();

    @Override // io.grpc.ServerCall.Listener
    public void onCancel() {
        a().onCancel();
    }

    @Override // io.grpc.ServerCall.Listener
    public void onComplete() {
        a().onComplete();
    }

    @Override // io.grpc.ServerCall.Listener
    public void onHalfClose() {
        a().onHalfClose();
    }

    @Override // io.grpc.ServerCall.Listener
    public void onReady() {
        a().onReady();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", a()).toString();
    }
}
