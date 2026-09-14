package io.grpc.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.Decompressor;
import io.grpc.InternalStatus;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractStream;
import io.grpc.internal.MessageFramer;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public abstract class AbstractServerStream extends AbstractStream implements ServerStream, MessageFramer.Sink {
    private final MessageFramer framer;
    private boolean headersSent;
    private boolean outboundClosed;
    private final StatsTraceContext statsTraceCtx;

    /* loaded from: classes2.dex */
    protected interface Sink {
        void cancel(Status status);

        void request(int i);

        void writeFrame(@Nullable WritableBuffer writableBuffer, boolean z, int i);

        void writeHeaders(Metadata metadata);

        void writeTrailers(Metadata metadata, boolean z, Status status);
    }

    /* loaded from: classes2.dex */
    protected static abstract class TransportState extends AbstractStream.TransportState {

        @Nullable
        private Status closedStatus;
        private boolean deframerClosed;
        private Runnable deframerClosedTask;
        private boolean endOfStream;
        private boolean immediateCloseRequested;
        private ServerStreamListener listener;
        private boolean listenerClosed;
        private final StatsTraceContext statsTraceCtx;

        /* JADX INFO: Access modifiers changed from: private */
        public void closeListener(Status status) {
            TransportTracer a;
            boolean z = false;
            Preconditions.checkState((status.isOk() && this.closedStatus == null) ? false : true);
            if (this.listenerClosed) {
                return;
            }
            if (status.isOk()) {
                this.statsTraceCtx.streamClosed(this.closedStatus);
                a = a();
                z = this.closedStatus.isOk();
            } else {
                this.statsTraceCtx.streamClosed(status);
                a = a();
            }
            a.reportStreamClosed(z);
            this.listenerClosed = true;
            c();
            b().closed(status);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClosedStatus(Status status) {
            Preconditions.checkState(this.closedStatus == null, "closedStatus can only be set once");
            this.closedStatus = status;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.internal.AbstractStream.TransportState
        public ServerStreamListener b() {
            return this.listener;
        }

        public void complete() {
            if (this.deframerClosed) {
                this.deframerClosedTask = null;
                closeListener(Status.OK);
            } else {
                this.deframerClosedTask = new Runnable() { // from class: io.grpc.internal.AbstractServerStream.TransportState.2
                    @Override // java.lang.Runnable
                    public void run() {
                        TransportState.this.closeListener(Status.OK);
                    }
                };
                this.immediateCloseRequested = true;
                a(true);
            }
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void deframerClosed(boolean z) {
            this.deframerClosed = true;
            if (this.endOfStream) {
                if (!this.immediateCloseRequested && z) {
                    deframeFailed(Status.INTERNAL.withDescription("Encountered end-of-stream mid-frame").asRuntimeException());
                    this.deframerClosedTask = null;
                    return;
                }
                this.listener.halfClosed();
            }
            Runnable runnable = this.deframerClosedTask;
            if (runnable != null) {
                runnable.run();
                this.deframerClosedTask = null;
            }
        }

        public void inboundDataReceived(ReadableBuffer readableBuffer, boolean z) {
            Preconditions.checkState(!this.endOfStream, "Past end of stream");
            a(readableBuffer);
            if (z) {
                this.endOfStream = true;
                a(false);
            }
        }

        @Override // io.grpc.internal.AbstractStream.TransportState
        public final void onStreamAllocated() {
            super.onStreamAllocated();
            a().reportRemoteStreamStarted();
        }

        public final void setListener(ServerStreamListener serverStreamListener) {
            Preconditions.checkState(this.listener == null, "setListener should be called only once");
            this.listener = (ServerStreamListener) Preconditions.checkNotNull(serverStreamListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }

        public final void transportReportStatus(final Status status) {
            Preconditions.checkArgument(!status.isOk(), "status must not be OK");
            if (this.deframerClosed) {
                this.deframerClosedTask = null;
                closeListener(status);
            } else {
                this.deframerClosedTask = new Runnable() { // from class: io.grpc.internal.AbstractServerStream.TransportState.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TransportState.this.closeListener(status);
                    }
                };
                this.immediateCloseRequested = true;
                a(true);
            }
        }
    }

    private void addStatusToTrailers(Metadata metadata, Status status) {
        metadata.discardAll(InternalStatus.CODE_KEY);
        metadata.discardAll(InternalStatus.MESSAGE_KEY);
        metadata.put(InternalStatus.CODE_KEY, status);
        if (status.getDescription() != null) {
            metadata.put(InternalStatus.MESSAGE_KEY, status.getDescription());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.AbstractStream
    public final MessageFramer b() {
        return this.framer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.AbstractStream
    public abstract TransportState c();

    @Override // io.grpc.internal.ServerStream
    public final void cancel(Status status) {
        d().cancel(status);
    }

    @Override // io.grpc.internal.ServerStream
    public final void close(Status status, Metadata metadata) {
        Preconditions.checkNotNull(status, "status");
        Preconditions.checkNotNull(metadata, GrpcUtil.TE_TRAILERS);
        if (this.outboundClosed) {
            return;
        }
        this.outboundClosed = true;
        a();
        addStatusToTrailers(metadata, status);
        c().setClosedStatus(status);
        d().writeTrailers(metadata, this.headersSent, status);
    }

    protected abstract Sink d();

    @Override // io.grpc.internal.MessageFramer.Sink
    public final void deliverFrame(WritableBuffer writableBuffer, boolean z, boolean z2, int i) {
        Sink d = d();
        if (z) {
            z2 = false;
        }
        d.writeFrame(writableBuffer, z2, i);
    }

    @Override // io.grpc.internal.ServerStream
    public Attributes getAttributes() {
        return Attributes.EMPTY;
    }

    @Override // io.grpc.internal.ServerStream
    public String getAuthority() {
        return null;
    }

    @Override // io.grpc.internal.AbstractStream, io.grpc.internal.Stream
    public final boolean isReady() {
        return super.isReady();
    }

    @Override // io.grpc.internal.Stream
    public final void request(int i) {
        d().request(i);
    }

    @Override // io.grpc.internal.ServerStream
    public final void setDecompressor(Decompressor decompressor) {
        c().a((Decompressor) Preconditions.checkNotNull(decompressor, "decompressor"));
    }

    @Override // io.grpc.internal.ServerStream
    public final void setListener(ServerStreamListener serverStreamListener) {
        c().setListener(serverStreamListener);
    }

    @Override // io.grpc.internal.ServerStream
    public StatsTraceContext statsTraceContext() {
        return this.statsTraceCtx;
    }

    @Override // io.grpc.internal.ServerStream
    public final void writeHeaders(Metadata metadata) {
        Preconditions.checkNotNull(metadata, "headers");
        this.headersSent = true;
        d().writeHeaders(metadata);
    }
}
