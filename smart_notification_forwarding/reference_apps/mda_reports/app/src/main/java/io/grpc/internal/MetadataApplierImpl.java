package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
final class MetadataApplierImpl extends CallCredentials.MetadataApplier {
    boolean a;
    DelayedStream b;
    private final CallOptions callOptions;
    private final MethodDescriptor<?, ?> method;
    private final Metadata origHeaders;

    @GuardedBy("lock")
    @Nullable
    private ClientStream returnedStream;
    private final ClientTransport transport;
    private final Object lock = new Object();
    private final Context ctx = Context.current();

    /* JADX INFO: Access modifiers changed from: package-private */
    public MetadataApplierImpl(ClientTransport clientTransport, MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
        this.transport = clientTransport;
        this.method = methodDescriptor;
        this.origHeaders = metadata;
        this.callOptions = callOptions;
    }

    private void finalizeWith(ClientStream clientStream) {
        Preconditions.checkState(!this.a, "already finalized");
        this.a = true;
        synchronized (this.lock) {
            if (this.returnedStream == null) {
                this.returnedStream = clientStream;
            } else {
                Preconditions.checkState(this.b != null, "delayedStream is null");
                this.b.a(clientStream);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientStream a() {
        synchronized (this.lock) {
            if (this.returnedStream != null) {
                return this.returnedStream;
            }
            this.b = new DelayedStream();
            DelayedStream delayedStream = this.b;
            this.returnedStream = delayedStream;
            return delayedStream;
        }
    }

    @Override // io.grpc.CallCredentials.MetadataApplier
    public void apply(Metadata metadata) {
        Preconditions.checkState(!this.a, "apply() or fail() already called");
        Preconditions.checkNotNull(metadata, "headers");
        this.origHeaders.merge(metadata);
        Context attach = this.ctx.attach();
        try {
            ClientStream newStream = this.transport.newStream(this.method, this.origHeaders, this.callOptions);
            this.ctx.detach(attach);
            finalizeWith(newStream);
        } catch (Throwable th) {
            this.ctx.detach(attach);
            throw th;
        }
    }

    @Override // io.grpc.CallCredentials.MetadataApplier
    public void fail(Status status) {
        Preconditions.checkArgument(!status.isOk(), "Cannot fail with OK status");
        Preconditions.checkState(!this.a, "apply() or fail() already called");
        finalizeWith(new FailingClientStream(status));
    }
}
