package io.grpc;

import io.grpc.ClientCall;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public abstract class ForwardingClientCall<ReqT, RespT> extends PartialForwardingClientCall<ReqT, RespT> {

    /* loaded from: classes2.dex */
    public static abstract class SimpleForwardingClientCall<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {
        private final ClientCall<ReqT, RespT> delegate;

        /* JADX INFO: Access modifiers changed from: protected */
        public SimpleForwardingClientCall(ClientCall<ReqT, RespT> clientCall) {
            this.delegate = clientCall;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.PartialForwardingClientCall
        public ClientCall<ReqT, RespT> a() {
            return this.delegate;
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ void cancel(@Nullable String str, @Nullable Throwable th) {
            super.cancel(str, th);
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ Attributes getAttributes() {
            return super.getAttributes();
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ void halfClose() {
            super.halfClose();
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ boolean isReady() {
            return super.isReady();
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ void request(int i) {
            super.request(i);
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
        public /* bridge */ /* synthetic */ void setMessageCompression(boolean z) {
            super.setMessageCompression(z);
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ void cancel(@Nullable String str, @Nullable Throwable th) {
        super.cancel(str, th);
    }

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ Attributes getAttributes() {
        return super.getAttributes();
    }

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ void halfClose() {
        super.halfClose();
    }

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ boolean isReady() {
        return super.isReady();
    }

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ void request(int i) {
        super.request(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.grpc.ClientCall
    public void sendMessage(ReqT reqt) {
        a().sendMessage(reqt);
    }

    @Override // io.grpc.PartialForwardingClientCall, io.grpc.ClientCall
    public /* bridge */ /* synthetic */ void setMessageCompression(boolean z) {
        super.setMessageCompression(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.grpc.ClientCall
    public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
        a().start(listener, metadata);
    }

    @Override // io.grpc.PartialForwardingClientCall
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
