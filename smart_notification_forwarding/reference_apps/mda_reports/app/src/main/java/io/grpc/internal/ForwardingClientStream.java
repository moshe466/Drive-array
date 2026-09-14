package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.Attributes;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Status;
import java.io.InputStream;

/* loaded from: classes2.dex */
abstract class ForwardingClientStream implements ClientStream {
    protected abstract ClientStream a();

    @Override // io.grpc.internal.ClientStream
    public void cancel(Status status) {
        a().cancel(status);
    }

    @Override // io.grpc.internal.Stream
    public void flush() {
        a().flush();
    }

    @Override // io.grpc.internal.ClientStream
    public Attributes getAttributes() {
        return a().getAttributes();
    }

    @Override // io.grpc.internal.ClientStream
    public void halfClose() {
        a().halfClose();
    }

    @Override // io.grpc.internal.Stream
    public boolean isReady() {
        return a().isReady();
    }

    @Override // io.grpc.internal.Stream
    public void request(int i) {
        a().request(i);
    }

    @Override // io.grpc.internal.ClientStream
    public void setAuthority(String str) {
        a().setAuthority(str);
    }

    @Override // io.grpc.internal.Stream
    public void setCompressor(Compressor compressor) {
        a().setCompressor(compressor);
    }

    @Override // io.grpc.internal.ClientStream
    public void setDeadline(Deadline deadline) {
        a().setDeadline(deadline);
    }

    @Override // io.grpc.internal.ClientStream
    public void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
        a().setDecompressorRegistry(decompressorRegistry);
    }

    @Override // io.grpc.internal.ClientStream
    public void setFullStreamDecompression(boolean z) {
        a().setFullStreamDecompression(z);
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxInboundMessageSize(int i) {
        a().setMaxInboundMessageSize(i);
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxOutboundMessageSize(int i) {
        a().setMaxOutboundMessageSize(i);
    }

    @Override // io.grpc.internal.Stream
    public void setMessageCompression(boolean z) {
        a().setMessageCompression(z);
    }

    @Override // io.grpc.internal.ClientStream
    public void start(ClientStreamListener clientStreamListener) {
        a().start(clientStreamListener);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", a()).toString();
    }

    @Override // io.grpc.internal.Stream
    public void writeMessage(InputStream inputStream) {
        a().writeMessage(inputStream);
    }
}
