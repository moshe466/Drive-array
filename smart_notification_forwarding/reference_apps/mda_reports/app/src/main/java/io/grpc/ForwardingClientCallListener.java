package io.grpc;

import io.grpc.ClientCall;

/* loaded from: classes2.dex */
public abstract class ForwardingClientCallListener<RespT> extends PartialForwardingClientCallListener<RespT> {

    /* loaded from: classes2.dex */
    public static abstract class SimpleForwardingClientCallListener<RespT> extends ForwardingClientCallListener<RespT> {
        private final ClientCall.Listener<RespT> delegate;

        /* JADX INFO: Access modifiers changed from: protected */
        public SimpleForwardingClientCallListener(ClientCall.Listener<RespT> listener) {
            this.delegate = listener;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.PartialForwardingClientCallListener
        public ClientCall.Listener<RespT> a() {
            return this.delegate;
        }

        @Override // io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
        public /* bridge */ /* synthetic */ void onClose(Status status, Metadata metadata) {
            super.onClose(status, metadata);
        }

        @Override // io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
        public /* bridge */ /* synthetic */ void onHeaders(Metadata metadata) {
            super.onHeaders(metadata);
        }

        @Override // io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
        public /* bridge */ /* synthetic */ void onReady() {
            super.onReady();
        }

        @Override // io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    @Override // io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
    public /* bridge */ /* synthetic */ void onClose(Status status, Metadata metadata) {
        super.onClose(status, metadata);
    }

    @Override // io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
    public /* bridge */ /* synthetic */ void onHeaders(Metadata metadata) {
        super.onHeaders(metadata);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.grpc.ClientCall.Listener
    public void onMessage(RespT respt) {
        a().onMessage(respt);
    }

    @Override // io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
    public /* bridge */ /* synthetic */ void onReady() {
        super.onReady();
    }

    @Override // io.grpc.PartialForwardingClientCallListener
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
