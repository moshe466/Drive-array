package io.grpc.util;

import com.google.common.base.MoreObjects;
import io.grpc.ClientStreamTracer;
import io.grpc.ExperimentalApi;
import io.grpc.Metadata;
import io.grpc.Status;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
/* loaded from: classes2.dex */
public abstract class ForwardingClientStreamTracer extends ClientStreamTracer {
    protected abstract ClientStreamTracer a();

    @Override // io.grpc.ClientStreamTracer
    public void inboundHeaders() {
        a().inboundHeaders();
    }

    @Override // io.grpc.StreamTracer
    public void inboundMessage(int i) {
        a().inboundMessage(i);
    }

    @Override // io.grpc.StreamTracer
    public void inboundMessageRead(int i, long j, long j2) {
        a().inboundMessageRead(i, j, j2);
    }

    @Override // io.grpc.ClientStreamTracer
    public void inboundTrailers(Metadata metadata) {
        a().inboundTrailers(metadata);
    }

    @Override // io.grpc.StreamTracer
    public void inboundUncompressedSize(long j) {
        a().inboundUncompressedSize(j);
    }

    @Override // io.grpc.StreamTracer
    public void inboundWireSize(long j) {
        a().inboundWireSize(j);
    }

    @Override // io.grpc.ClientStreamTracer
    public void outboundHeaders() {
        a().outboundHeaders();
    }

    @Override // io.grpc.StreamTracer
    public void outboundMessage(int i) {
        a().outboundMessage(i);
    }

    @Override // io.grpc.StreamTracer
    public void outboundMessageSent(int i, long j, long j2) {
        a().outboundMessageSent(i, j, j2);
    }

    @Override // io.grpc.StreamTracer
    public void outboundUncompressedSize(long j) {
        a().outboundUncompressedSize(j);
    }

    @Override // io.grpc.StreamTracer
    public void outboundWireSize(long j) {
        a().outboundWireSize(j);
    }

    @Override // io.grpc.StreamTracer
    public void streamClosed(Status status) {
        a().streamClosed(status);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", a()).toString();
    }
}
