package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;

/* loaded from: classes2.dex */
abstract class ForwardingClientStreamListener implements ClientStreamListener {
    protected abstract ClientStreamListener a();

    @Override // io.grpc.internal.ClientStreamListener
    public void closed(Status status, Metadata metadata) {
        a().closed(status, metadata);
    }

    @Override // io.grpc.internal.ClientStreamListener
    public void closed(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata metadata) {
        a().closed(status, rpcProgress, metadata);
    }

    @Override // io.grpc.internal.ClientStreamListener
    public void headersRead(Metadata metadata) {
        a().headersRead(metadata);
    }

    @Override // io.grpc.internal.StreamListener
    public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
        a().messagesAvailable(messageProducer);
    }

    @Override // io.grpc.internal.StreamListener
    public void onReady() {
        a().onReady();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", a()).toString();
    }
}
