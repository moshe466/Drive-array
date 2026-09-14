package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.AbstractClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.Http2ClientStreamTransportState;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.internal.WritableBuffer;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.Header;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import okio.Buffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class OkHttpClientStream extends AbstractClientStream {
    public static final int ABSENT_ID = -1;
    private static final Buffer EMPTY_BUFFER = new Buffer();
    private final Attributes attributes;
    private String authority;
    private volatile int id;
    private final MethodDescriptor<?, ?> method;
    private Object outboundFlowState;
    private final Sink sink;
    private final TransportState state;
    private final StatsTraceContext statsTraceCtx;
    private boolean useGet;
    private final String userAgent;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class Sink implements AbstractClientStream.Sink {
        Sink() {
        }

        @Override // io.grpc.internal.AbstractClientStream.Sink
        public void cancel(Status status) {
            synchronized (OkHttpClientStream.this.state.lock) {
                OkHttpClientStream.this.state.cancel(status, true, null);
            }
        }

        @Override // io.grpc.internal.AbstractClientStream.Sink
        public void request(int i) {
            synchronized (OkHttpClientStream.this.state.lock) {
                OkHttpClientStream.this.state.requestMessagesFromDeframer(i);
            }
        }

        @Override // io.grpc.internal.AbstractClientStream.Sink
        public void writeFrame(WritableBuffer writableBuffer, boolean z, boolean z2, int i) {
            Buffer a;
            if (writableBuffer == null) {
                a = OkHttpClientStream.EMPTY_BUFFER;
            } else {
                a = ((OkHttpWritableBuffer) writableBuffer).a();
                int size = (int) a.size();
                if (size > 0) {
                    OkHttpClientStream.this.a(size);
                }
            }
            synchronized (OkHttpClientStream.this.state.lock) {
                OkHttpClientStream.this.state.sendBuffer(a, z, z2);
                OkHttpClientStream.this.e().reportMessageSent(i);
            }
        }

        @Override // io.grpc.internal.AbstractClientStream.Sink
        public void writeHeaders(Metadata metadata, byte[] bArr) {
            String str = "/" + OkHttpClientStream.this.method.getFullMethodName();
            if (bArr != null) {
                OkHttpClientStream.this.useGet = true;
                str = str + "?" + BaseEncoding.base64().encode(bArr);
            }
            synchronized (OkHttpClientStream.this.state.lock) {
                OkHttpClientStream.this.state.streamReady(metadata, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class TransportState extends Http2ClientStreamTransportState {

        @GuardedBy("lock")
        private boolean canStart;

        @GuardedBy("lock")
        private boolean cancelSent;
        private boolean flushPendingData;

        @GuardedBy("lock")
        private final ExceptionHandlingFrameWriter frameWriter;
        private final int initialWindowSize;
        private final Object lock;

        @GuardedBy("lock")
        private final OutboundFlowController outboundFlow;

        @GuardedBy("lock")
        private Buffer pendingData;
        private boolean pendingDataHasEndOfStream;

        @GuardedBy("lock")
        private int processedWindow;

        @GuardedBy("lock")
        private List<Header> requestHeaders;

        @GuardedBy("lock")
        private final OkHttpClientTransport transport;

        @GuardedBy("lock")
        private int window;

        public TransportState(int i, StatsTraceContext statsTraceContext, Object obj, ExceptionHandlingFrameWriter exceptionHandlingFrameWriter, OutboundFlowController outboundFlowController, OkHttpClientTransport okHttpClientTransport, int i2) {
            super(i, statsTraceContext, OkHttpClientStream.this.e());
            this.pendingData = new Buffer();
            this.pendingDataHasEndOfStream = false;
            this.flushPendingData = false;
            this.cancelSent = false;
            this.canStart = true;
            this.lock = Preconditions.checkNotNull(obj, "lock");
            this.frameWriter = exceptionHandlingFrameWriter;
            this.outboundFlow = outboundFlowController;
            this.transport = okHttpClientTransport;
            this.window = i2;
            this.processedWindow = i2;
            this.initialWindowSize = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @GuardedBy("lock")
        public void cancel(Status status, boolean z, Metadata metadata) {
            if (this.cancelSent) {
                return;
            }
            this.cancelSent = true;
            if (!this.canStart) {
                this.transport.a(OkHttpClientStream.this.id(), status, ClientStreamListener.RpcProgress.PROCESSED, z, ErrorCode.CANCEL, metadata);
                return;
            }
            this.transport.a(OkHttpClientStream.this);
            this.requestHeaders = null;
            this.pendingData.clear();
            this.canStart = false;
            if (metadata == null) {
                metadata = new Metadata();
            }
            transportReportStatus(status, true, metadata);
        }

        @GuardedBy("lock")
        private void onEndOfStream() {
            if (d()) {
                this.transport.a(OkHttpClientStream.this.id(), null, ClientStreamListener.RpcProgress.PROCESSED, false, null, null);
            } else {
                this.transport.a(OkHttpClientStream.this.id(), null, ClientStreamListener.RpcProgress.PROCESSED, false, ErrorCode.CANCEL, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @GuardedBy("lock")
        public void sendBuffer(Buffer buffer, boolean z, boolean z2) {
            if (this.cancelSent) {
                return;
            }
            if (!this.canStart) {
                Preconditions.checkState(OkHttpClientStream.this.id() != -1, "streamId should be set");
                this.outboundFlow.a(z, OkHttpClientStream.this.id(), buffer, z2);
            } else {
                this.pendingData.write(buffer, (int) buffer.size());
                this.pendingDataHasEndOfStream |= z;
                this.flushPendingData |= z2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @GuardedBy("lock")
        public void streamReady(Metadata metadata, String str) {
            this.requestHeaders = Headers.createRequestHeaders(metadata, str, OkHttpClientStream.this.authority, OkHttpClientStream.this.userAgent, OkHttpClientStream.this.useGet);
            this.transport.b(OkHttpClientStream.this);
        }

        @Override // io.grpc.internal.Http2ClientStreamTransportState
        @GuardedBy("lock")
        protected void a(Status status, boolean z, Metadata metadata) {
            cancel(status, z, metadata);
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        @GuardedBy("lock")
        public void bytesRead(int i) {
            this.processedWindow -= i;
            int i2 = this.processedWindow;
            float f = i2;
            int i3 = this.initialWindowSize;
            if (f <= i3 * 0.5f) {
                int i4 = i3 - i2;
                this.window += i4;
                this.processedWindow = i2 + i4;
                this.frameWriter.windowUpdate(OkHttpClientStream.this.id(), i4);
            }
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        @GuardedBy("lock")
        public void deframeFailed(Throwable th) {
            a(Status.fromThrowable(th), true, new Metadata());
        }

        @Override // io.grpc.internal.Http2ClientStreamTransportState, io.grpc.internal.AbstractClientStream.TransportState, io.grpc.internal.MessageDeframer.Listener
        @GuardedBy("lock")
        public void deframerClosed(boolean z) {
            onEndOfStream();
            super.deframerClosed(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.internal.AbstractStream.TransportState
        @GuardedBy("lock")
        public void onStreamAllocated() {
            super.onStreamAllocated();
            a().reportLocalStreamStarted();
        }

        @Override // io.grpc.internal.ApplicationThreadDeframer.TransportExecutor
        @GuardedBy("lock")
        public void runOnTransportThread(Runnable runnable) {
            synchronized (this.lock) {
                runnable.run();
            }
        }

        @GuardedBy("lock")
        public void start(int i) {
            Preconditions.checkState(OkHttpClientStream.this.id == -1, "the stream has been started with id %s", i);
            OkHttpClientStream.this.id = i;
            OkHttpClientStream.this.state.onStreamAllocated();
            if (this.canStart) {
                this.frameWriter.synStream(OkHttpClientStream.this.useGet, false, OkHttpClientStream.this.id, 0, this.requestHeaders);
                OkHttpClientStream.this.statsTraceCtx.clientOutboundHeaders();
                this.requestHeaders = null;
                if (this.pendingData.size() > 0) {
                    this.outboundFlow.a(this.pendingDataHasEndOfStream, OkHttpClientStream.this.id, this.pendingData, this.flushPendingData);
                }
                this.canStart = false;
            }
        }

        @GuardedBy("lock")
        public void transportDataReceived(Buffer buffer, boolean z) {
            this.window -= (int) buffer.size();
            if (this.window >= 0) {
                super.a(new OkHttpReadableBuffer(buffer), z);
            } else {
                this.frameWriter.rstStream(OkHttpClientStream.this.id(), ErrorCode.FLOW_CONTROL_ERROR);
                this.transport.a(OkHttpClientStream.this.id(), Status.INTERNAL.withDescription("Received data size exceeded our receiving window size"), ClientStreamListener.RpcProgress.PROCESSED, false, null, null);
            }
        }

        @GuardedBy("lock")
        public void transportHeadersReceived(List<Header> list, boolean z) {
            if (z) {
                c(Utils.convertTrailers(list));
            } else {
                b(Utils.convertHeaders(list));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OkHttpClientStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, ExceptionHandlingFrameWriter exceptionHandlingFrameWriter, OkHttpClientTransport okHttpClientTransport, OutboundFlowController outboundFlowController, Object obj, int i, int i2, String str, String str2, StatsTraceContext statsTraceContext, TransportTracer transportTracer, CallOptions callOptions) {
        super(new OkHttpWritableBufferAllocator(), statsTraceContext, transportTracer, metadata, callOptions, methodDescriptor.isSafe());
        this.id = -1;
        this.sink = new Sink();
        this.useGet = false;
        this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceContext, "statsTraceCtx");
        this.method = methodDescriptor;
        this.authority = str;
        this.userAgent = str2;
        this.attributes = okHttpClientTransport.getAttributes();
        this.state = new TransportState(i, statsTraceContext, obj, exceptionHandlingFrameWriter, outboundFlowController, okHttpClientTransport, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Object obj) {
        this.outboundFlowState = obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.AbstractClientStream, io.grpc.internal.AbstractStream
    public TransportState c() {
        return this.state;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.AbstractClientStream
    public Sink d() {
        return this.sink;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object g() {
        return this.outboundFlowState;
    }

    @Override // io.grpc.internal.ClientStream
    public Attributes getAttributes() {
        return this.attributes;
    }

    public MethodDescriptor.MethodType getType() {
        return this.method.getType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.useGet;
    }

    public int id() {
        return this.id;
    }

    @Override // io.grpc.internal.ClientStream
    public void setAuthority(String str) {
        this.authority = (String) Preconditions.checkNotNull(str, "authority");
    }
}
