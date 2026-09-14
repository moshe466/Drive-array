package io.grpc;

import com.google.common.base.MoreObjects;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
abstract class PartialForwardingClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ClientCall<?, ?> a();

    @Override // io.grpc.ClientCall
    public void cancel(@Nullable String str, @Nullable Throwable th) {
        a().cancel(str, th);
    }

    @Override // io.grpc.ClientCall
    public Attributes getAttributes() {
        return a().getAttributes();
    }

    @Override // io.grpc.ClientCall
    public void halfClose() {
        a().halfClose();
    }

    @Override // io.grpc.ClientCall
    public boolean isReady() {
        return a().isReady();
    }

    @Override // io.grpc.ClientCall
    public void request(int i) {
        a().request(i);
    }

    @Override // io.grpc.ClientCall
    public void setMessageCompression(boolean z) {
        a().setMessageCompression(z);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", a()).toString();
    }
}
