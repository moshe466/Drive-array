package io.grpc.okhttp;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.net.HttpHeaders;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.http.StatusLine;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Grpc;
import io.grpc.HttpConnectProxiedSocketAddress;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.internal.ClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcAttributes;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.Http2Ping;
import io.grpc.internal.InUseStateAggregator;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.SerializingExecutor;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.ExceptionHandlingFrameWriter;
import io.grpc.okhttp.OkHttpClientStream;
import io.grpc.okhttp.OkHttpFrameLogger;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameReader;
import io.grpc.okhttp.internal.framed.FrameWriter;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.HeadersMode;
import io.grpc.okhttp.internal.framed.Http2;
import io.grpc.okhttp.internal.framed.Settings;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import okio.Timeout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class OkHttpClientTransport implements ConnectionClientTransport, ExceptionHandlingFrameWriter.TransportExceptionHandler {

    @VisibleForTesting
    @Nullable
    final HttpConnectProxiedSocketAddress a;
    private final InetSocketAddress address;
    private Attributes attributes;
    Runnable b;
    SettableFuture<Void> c;
    private ClientFrameHandler clientFrameHandler;
    private final ConnectionSpec connectionSpec;
    private int connectionUnacknowledgedBytesRead;
    private final String defaultAuthority;
    private boolean enableKeepAlive;
    private final Executor executor;

    @GuardedBy("lock")
    private ExceptionHandlingFrameWriter frameWriter;

    @GuardedBy("lock")
    private boolean goAwaySent;

    @GuardedBy("lock")
    private Status goAwayStatus;

    @GuardedBy("lock")
    private boolean hasStream;
    private HostnameVerifier hostnameVerifier;
    private final int initialWindowSize;
    private KeepAliveManager keepAliveManager;
    private long keepAliveTimeNanos;
    private long keepAliveTimeoutNanos;
    private boolean keepAliveWithoutCalls;
    private ManagedClientTransport.Listener listener;
    private final InternalLogId logId;
    private final int maxInboundMetadataSize;
    private final int maxMessageSize;
    private OutboundFlowController outboundFlow;

    @GuardedBy("lock")
    private Http2Ping ping;
    private ScheduledExecutorService scheduler;

    @GuardedBy("lock")
    private InternalChannelz.Security securityInfo;
    private final SerializingExecutor serializingExecutor;
    private Socket socket;
    private final SocketFactory socketFactory;
    private SSLSocketFactory sslSocketFactory;

    @GuardedBy("lock")
    private boolean stopped;
    private final Supplier<Stopwatch> stopwatchFactory;
    private OkHttpFrameLogger testFrameLogger;
    private FrameReader testFrameReader;
    private FrameWriter testFrameWriter;
    private final Runnable tooManyPingsRunnable;

    @GuardedBy("lock")
    private final TransportTracer transportTracer;
    private final String userAgent;
    private static final Map<ErrorCode, Status> ERROR_CODE_TO_STATUS = buildErrorCodeToStatusMap();
    private static final Logger log = Logger.getLogger(OkHttpClientTransport.class.getName());
    private static final OkHttpClientStream[] EMPTY_STREAM_ARRAY = new OkHttpClientStream[0];
    private final Random random = new Random();
    private final Object lock = new Object();

    @GuardedBy("lock")
    private final Map<Integer, OkHttpClientStream> streams = new HashMap();

    @GuardedBy("lock")
    private int maxConcurrentStreams = 0;

    @GuardedBy("lock")
    private final LinkedList<OkHttpClientStream> pendingStreams = new LinkedList<>();

    @GuardedBy("lock")
    private final InUseStateAggregator<OkHttpClientStream> inUseState = new InUseStateAggregator<OkHttpClientStream>() { // from class: io.grpc.okhttp.OkHttpClientTransport.1
        @Override // io.grpc.internal.InUseStateAggregator
        protected void a() {
            OkHttpClientTransport.this.listener.transportInUse(true);
        }

        @Override // io.grpc.internal.InUseStateAggregator
        protected void b() {
            OkHttpClientTransport.this.listener.transportInUse(false);
        }
    };

    @GuardedBy("lock")
    private int nextStreamId = 3;

    @VisibleForTesting
    /* loaded from: classes2.dex */
    class ClientFrameHandler implements FrameReader.Handler, Runnable {
        FrameReader a;
        boolean b;
        private final OkHttpFrameLogger logger;

        ClientFrameHandler(OkHttpClientTransport okHttpClientTransport, FrameReader frameReader) {
            this(frameReader, new OkHttpFrameLogger(Level.FINE, (Class<?>) OkHttpClientTransport.class));
        }

        @VisibleForTesting
        ClientFrameHandler(FrameReader frameReader, OkHttpFrameLogger okHttpFrameLogger) {
            this.b = true;
            this.a = frameReader;
            this.logger = okHttpFrameLogger;
        }

        private int headerBlockSize(List<Header> list) {
            long j = 0;
            for (int i = 0; i < list.size(); i++) {
                Header header = list.get(i);
                j += header.name.size() + 32 + header.value.size();
            }
            return (int) Math.min(j, 2147483647L);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void ackSettings() {
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) {
            this.logger.a(OkHttpFrameLogger.Direction.INBOUND, i, bufferedSource.buffer(), i2, z);
            OkHttpClientStream a = OkHttpClientTransport.this.a(i);
            if (a != null) {
                long j = i2;
                bufferedSource.require(j);
                Buffer buffer = new Buffer();
                buffer.write(bufferedSource.buffer(), j);
                synchronized (OkHttpClientTransport.this.lock) {
                    a.c().transportDataReceived(buffer, z);
                }
            } else {
                if (!OkHttpClientTransport.this.b(i)) {
                    OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received data for unknown stream: " + i);
                    return;
                }
                synchronized (OkHttpClientTransport.this.lock) {
                    OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.INVALID_STREAM);
                }
                bufferedSource.skip(i2);
            }
            OkHttpClientTransport.b(OkHttpClientTransport.this, i2);
            if (OkHttpClientTransport.this.connectionUnacknowledgedBytesRead >= OkHttpClientTransport.this.initialWindowSize * 0.5f) {
                synchronized (OkHttpClientTransport.this.lock) {
                    OkHttpClientTransport.this.frameWriter.windowUpdate(0, OkHttpClientTransport.this.connectionUnacknowledgedBytesRead);
                }
                OkHttpClientTransport.this.connectionUnacknowledgedBytesRead = 0;
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            this.logger.a(OkHttpFrameLogger.Direction.INBOUND, i, errorCode, byteString);
            if (errorCode == ErrorCode.ENHANCE_YOUR_CALM) {
                String utf8 = byteString.utf8();
                OkHttpClientTransport.log.log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", this, utf8));
                if ("too_many_pings".equals(utf8)) {
                    OkHttpClientTransport.this.tooManyPingsRunnable.run();
                }
            }
            Status augmentDescription = GrpcUtil.Http2Error.statusForCode(errorCode.httpCode).augmentDescription("Received Goaway");
            if (byteString.size() > 0) {
                augmentDescription = augmentDescription.augmentDescription(byteString.utf8());
            }
            OkHttpClientTransport.this.startGoAway(i, null, augmentDescription);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void headers(boolean z, boolean z2, int i, int i2, List<Header> list, HeadersMode headersMode) {
            Status status;
            int headerBlockSize;
            this.logger.a(OkHttpFrameLogger.Direction.INBOUND, i, list, z2);
            boolean z3 = true;
            if (OkHttpClientTransport.this.maxInboundMetadataSize == Integer.MAX_VALUE || (headerBlockSize = headerBlockSize(list)) <= OkHttpClientTransport.this.maxInboundMetadataSize) {
                status = null;
            } else {
                Status status2 = Status.RESOURCE_EXHAUSTED;
                Object[] objArr = new Object[3];
                objArr[0] = z2 ? "trailer" : "header";
                objArr[1] = Integer.valueOf(OkHttpClientTransport.this.maxInboundMetadataSize);
                objArr[2] = Integer.valueOf(headerBlockSize);
                status = status2.withDescription(String.format("Response %s metadata larger than %d: %d", objArr));
            }
            synchronized (OkHttpClientTransport.this.lock) {
                OkHttpClientStream okHttpClientStream = (OkHttpClientStream) OkHttpClientTransport.this.streams.get(Integer.valueOf(i));
                if (okHttpClientStream == null) {
                    if (OkHttpClientTransport.this.b(i)) {
                        OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.INVALID_STREAM);
                    }
                } else if (status == null) {
                    okHttpClientStream.c().transportHeadersReceived(list, z2);
                } else {
                    if (!z2) {
                        OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                    }
                    okHttpClientStream.c().transportReportStatus(status, false, new Metadata());
                }
                z3 = false;
            }
            if (z3) {
                OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received header for unknown stream: " + i);
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void ping(boolean z, int i, int i2) {
            Http2Ping http2Ping;
            long j = (i << 32) | (i2 & 4294967295L);
            this.logger.a(OkHttpFrameLogger.Direction.INBOUND, j);
            if (!z) {
                synchronized (OkHttpClientTransport.this.lock) {
                    OkHttpClientTransport.this.frameWriter.ping(true, i, i2);
                }
                return;
            }
            synchronized (OkHttpClientTransport.this.lock) {
                if (OkHttpClientTransport.this.ping == null) {
                    OkHttpClientTransport.log.warning("Received unexpected ping ack. No ping outstanding");
                } else if (OkHttpClientTransport.this.ping.payload() == j) {
                    http2Ping = OkHttpClientTransport.this.ping;
                    OkHttpClientTransport.this.ping = null;
                } else {
                    OkHttpClientTransport.log.log(Level.WARNING, String.format("Received unexpected ping ack. Expecting %d, got %d", Long.valueOf(OkHttpClientTransport.this.ping.payload()), Long.valueOf(j)));
                }
                http2Ping = null;
            }
            if (http2Ping != null) {
                http2Ping.complete();
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void priority(int i, int i2, int i3, boolean z) {
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void pushPromise(int i, int i2, List<Header> list) {
            this.logger.a(OkHttpFrameLogger.Direction.INBOUND, i, i2, list);
            synchronized (OkHttpClientTransport.this.lock) {
                OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.PROTOCOL_ERROR);
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            this.logger.a(OkHttpFrameLogger.Direction.INBOUND, i, errorCode);
            Status augmentDescription = OkHttpClientTransport.a(errorCode).augmentDescription("Rst Stream");
            OkHttpClientTransport.this.a(i, augmentDescription, errorCode == ErrorCode.REFUSED_STREAM ? ClientStreamListener.RpcProgress.REFUSED : ClientStreamListener.RpcProgress.PROCESSED, augmentDescription.getCode() == Status.Code.CANCELLED || augmentDescription.getCode() == Status.Code.DEADLINE_EXCEEDED, null, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            String name = Thread.currentThread().getName();
            if (!GrpcUtil.IS_RESTRICTED_APPENGINE) {
                Thread.currentThread().setName("OkHttpClientTransport");
            }
            while (this.a.nextFrame(this)) {
                try {
                    if (OkHttpClientTransport.this.keepAliveManager != null) {
                        OkHttpClientTransport.this.keepAliveManager.onDataReceived();
                    }
                } catch (Throwable th) {
                    try {
                        OkHttpClientTransport.this.startGoAway(0, ErrorCode.PROTOCOL_ERROR, Status.INTERNAL.withDescription("error in frame handler").withCause(th));
                        try {
                            this.a.close();
                        } catch (IOException e) {
                            OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
                        }
                        OkHttpClientTransport.this.listener.transportTerminated();
                        if (GrpcUtil.IS_RESTRICTED_APPENGINE) {
                            return;
                        }
                    } finally {
                    }
                }
            }
            OkHttpClientTransport.this.startGoAway(0, ErrorCode.INTERNAL_ERROR, Status.UNAVAILABLE.withDescription("End of stream or IOException"));
            try {
                this.a.close();
            } catch (IOException e2) {
                OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", (Throwable) e2);
            }
            OkHttpClientTransport.this.listener.transportTerminated();
            if (GrpcUtil.IS_RESTRICTED_APPENGINE) {
                return;
            }
            Thread.currentThread().setName(name);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void settings(boolean z, Settings settings) {
            boolean z2;
            this.logger.a(OkHttpFrameLogger.Direction.INBOUND, settings);
            synchronized (OkHttpClientTransport.this.lock) {
                if (OkHttpSettingsUtil.isSet(settings, 4)) {
                    OkHttpClientTransport.this.maxConcurrentStreams = OkHttpSettingsUtil.get(settings, 4);
                }
                if (OkHttpSettingsUtil.isSet(settings, 7)) {
                    z2 = OkHttpClientTransport.this.outboundFlow.a(OkHttpSettingsUtil.get(settings, 7));
                } else {
                    z2 = false;
                }
                if (this.b) {
                    OkHttpClientTransport.this.listener.transportReady();
                    this.b = false;
                }
                OkHttpClientTransport.this.frameWriter.ackSettings(settings);
                if (z2) {
                    OkHttpClientTransport.this.outboundFlow.b();
                }
                OkHttpClientTransport.this.startPendingStreams();
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void windowUpdate(int i, long j) {
            this.logger.a(OkHttpFrameLogger.Direction.INBOUND, i, j);
            if (j == 0) {
                if (i == 0) {
                    OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received 0 flow control window increment.");
                    return;
                } else {
                    OkHttpClientTransport.this.a(i, Status.INTERNAL.withDescription("Received 0 flow control window increment."), ClientStreamListener.RpcProgress.PROCESSED, false, ErrorCode.PROTOCOL_ERROR, null);
                    return;
                }
            }
            boolean z = false;
            synchronized (OkHttpClientTransport.this.lock) {
                if (i == 0) {
                    OkHttpClientTransport.this.outboundFlow.a(null, (int) j);
                    return;
                }
                OkHttpClientStream okHttpClientStream = (OkHttpClientStream) OkHttpClientTransport.this.streams.get(Integer.valueOf(i));
                if (okHttpClientStream != null) {
                    OkHttpClientTransport.this.outboundFlow.a(okHttpClientStream, (int) j);
                } else if (!OkHttpClientTransport.this.b(i)) {
                    z = true;
                }
                if (z) {
                    OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received window_update for unknown stream: " + i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OkHttpClientTransport(InetSocketAddress inetSocketAddress, String str, @Nullable String str2, Attributes attributes, Executor executor, @Nullable SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, ConnectionSpec connectionSpec, int i, int i2, @Nullable HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress, Runnable runnable, int i3, TransportTracer transportTracer) {
        this.address = (InetSocketAddress) Preconditions.checkNotNull(inetSocketAddress, "address");
        this.defaultAuthority = str;
        this.maxMessageSize = i;
        this.initialWindowSize = i2;
        this.executor = (Executor) Preconditions.checkNotNull(executor, "executor");
        this.serializingExecutor = new SerializingExecutor(executor);
        this.socketFactory = socketFactory == null ? SocketFactory.getDefault() : socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.connectionSpec = (ConnectionSpec) Preconditions.checkNotNull(connectionSpec, "connectionSpec");
        this.stopwatchFactory = GrpcUtil.STOPWATCH_SUPPLIER;
        this.userAgent = GrpcUtil.getGrpcUserAgent("okhttp", str2);
        this.a = httpConnectProxiedSocketAddress;
        this.tooManyPingsRunnable = (Runnable) Preconditions.checkNotNull(runnable, "tooManyPingsRunnable");
        this.maxInboundMetadataSize = i3;
        this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer);
        this.logId = InternalLogId.allocate((Class<?>) OkHttpClientTransport.class, inetSocketAddress.toString());
        this.attributes = Attributes.newBuilder().set(GrpcAttributes.ATTR_CLIENT_EAG_ATTRS, attributes).build();
        initTransportTracer();
    }

    @VisibleForTesting
    static Status a(ErrorCode errorCode) {
        Status status = ERROR_CODE_TO_STATUS.get(errorCode);
        if (status != null) {
            return status;
        }
        return Status.UNKNOWN.withDescription("Unknown http2 error code: " + errorCode.httpCode);
    }

    static /* synthetic */ int b(OkHttpClientTransport okHttpClientTransport, int i) {
        int i2 = okHttpClientTransport.connectionUnacknowledgedBytesRead + i;
        okHttpClientTransport.connectionUnacknowledgedBytesRead = i2;
        return i2;
    }

    private static Map<ErrorCode, Status> buildErrorCodeToStatusMap() {
        EnumMap enumMap = new EnumMap(ErrorCode.class);
        enumMap.put((EnumMap) ErrorCode.NO_ERROR, (ErrorCode) Status.INTERNAL.withDescription("No error: A GRPC status of OK should have been sent"));
        enumMap.put((EnumMap) ErrorCode.PROTOCOL_ERROR, (ErrorCode) Status.INTERNAL.withDescription("Protocol error"));
        enumMap.put((EnumMap) ErrorCode.INTERNAL_ERROR, (ErrorCode) Status.INTERNAL.withDescription("Internal error"));
        enumMap.put((EnumMap) ErrorCode.FLOW_CONTROL_ERROR, (ErrorCode) Status.INTERNAL.withDescription("Flow control error"));
        enumMap.put((EnumMap) ErrorCode.STREAM_CLOSED, (ErrorCode) Status.INTERNAL.withDescription("Stream closed"));
        enumMap.put((EnumMap) ErrorCode.FRAME_TOO_LARGE, (ErrorCode) Status.INTERNAL.withDescription("Frame too large"));
        enumMap.put((EnumMap) ErrorCode.REFUSED_STREAM, (ErrorCode) Status.UNAVAILABLE.withDescription("Refused stream"));
        enumMap.put((EnumMap) ErrorCode.CANCEL, (ErrorCode) Status.CANCELLED.withDescription("Cancelled"));
        enumMap.put((EnumMap) ErrorCode.COMPRESSION_ERROR, (ErrorCode) Status.INTERNAL.withDescription("Compression error"));
        enumMap.put((EnumMap) ErrorCode.CONNECT_ERROR, (ErrorCode) Status.INTERNAL.withDescription("Connect error"));
        enumMap.put((EnumMap) ErrorCode.ENHANCE_YOUR_CALM, (ErrorCode) Status.RESOURCE_EXHAUSTED.withDescription("Enhance your calm"));
        enumMap.put((EnumMap) ErrorCode.INADEQUATE_SECURITY, (ErrorCode) Status.PERMISSION_DENIED.withDescription("Inadequate security"));
        return Collections.unmodifiableMap(enumMap);
    }

    private Request createHttpProxyRequest(InetSocketAddress inetSocketAddress, String str, String str2) {
        HttpUrl build = new HttpUrl.Builder().scheme("https").host(inetSocketAddress.getHostName()).port(inetSocketAddress.getPort()).build();
        Request.Builder header = new Request.Builder().url(build).header(HttpHeaders.HOST, build.host() + ":" + build.port()).header("User-Agent", this.userAgent);
        if (str != null && str2 != null) {
            header.header("Proxy-Authorization", Credentials.basic(str, str2));
        }
        return header.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Socket createHttpProxySocket(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) {
        try {
            Socket createSocket = inetSocketAddress2.getAddress() != null ? this.socketFactory.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort()) : this.socketFactory.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
            createSocket.setTcpNoDelay(true);
            Source source = Okio.source(createSocket);
            BufferedSink buffer = Okio.buffer(Okio.sink(createSocket));
            Request createHttpProxyRequest = createHttpProxyRequest(inetSocketAddress, str, str2);
            HttpUrl httpUrl = createHttpProxyRequest.httpUrl();
            buffer.writeUtf8(String.format("CONNECT %s:%d HTTP/1.1", httpUrl.host(), Integer.valueOf(httpUrl.port()))).writeUtf8("\r\n");
            int size = createHttpProxyRequest.headers().size();
            for (int i = 0; i < size; i++) {
                buffer.writeUtf8(createHttpProxyRequest.headers().name(i)).writeUtf8(": ").writeUtf8(createHttpProxyRequest.headers().value(i)).writeUtf8("\r\n");
            }
            buffer.writeUtf8("\r\n");
            buffer.flush();
            StatusLine parse = StatusLine.parse(readUtf8LineStrictUnbuffered(source));
            do {
            } while (!readUtf8LineStrictUnbuffered(source).equals(""));
            if (parse.code >= 200 && parse.code < 300) {
                return createSocket;
            }
            Buffer buffer2 = new Buffer();
            try {
                createSocket.shutdownOutput();
                source.read(buffer2, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
            } catch (IOException e) {
                buffer2.writeUtf8("Unable to read body: " + e.toString());
            }
            try {
                createSocket.close();
            } catch (IOException unused) {
            }
            throw Status.UNAVAILABLE.withDescription(String.format("Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s", Integer.valueOf(parse.code), parse.message, buffer2.readUtf8())).asException();
        } catch (IOException e2) {
            throw Status.UNAVAILABLE.withDescription("Failed trying to connect with proxy").withCause(e2).asException();
        }
    }

    private Throwable getPingFailure() {
        synchronized (this.lock) {
            if (this.goAwayStatus != null) {
                return this.goAwayStatus.asException();
            }
            return Status.UNAVAILABLE.withDescription("Connection closed").asException();
        }
    }

    private void initTransportTracer() {
        synchronized (this.lock) {
            this.transportTracer.setFlowControlWindowReader(new TransportTracer.FlowControlReader() { // from class: io.grpc.okhttp.OkHttpClientTransport.2
                @Override // io.grpc.internal.TransportTracer.FlowControlReader
                public TransportTracer.FlowControlWindows read() {
                    TransportTracer.FlowControlWindows flowControlWindows;
                    synchronized (OkHttpClientTransport.this.lock) {
                        flowControlWindows = new TransportTracer.FlowControlWindows(-1L, OkHttpClientTransport.this.outboundFlow == null ? -1L : OkHttpClientTransport.this.outboundFlow.a(null, 0));
                    }
                    return flowControlWindows;
                }
            });
        }
    }

    private boolean isForTest() {
        return this.address == null;
    }

    @GuardedBy("lock")
    private void maybeClearInUse(OkHttpClientStream okHttpClientStream) {
        if (this.hasStream && this.pendingStreams.isEmpty() && this.streams.isEmpty()) {
            this.hasStream = false;
            KeepAliveManager keepAliveManager = this.keepAliveManager;
            if (keepAliveManager != null) {
                keepAliveManager.onTransportIdle();
            }
        }
        if (okHttpClientStream.shouldBeCountedForInUse()) {
            this.inUseState.updateObjectInUse(okHttpClientStream, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ErrorCode errorCode, String str) {
        startGoAway(0, errorCode, a(errorCode).augmentDescription(str));
    }

    private static String readUtf8LineStrictUnbuffered(Source source) {
        Buffer buffer = new Buffer();
        while (source.read(buffer, 1L) != -1) {
            if (buffer.getByte(buffer.size() - 1) == 10) {
                return buffer.readUtf8LineStrict();
            }
        }
        throw new EOFException("\\n not found: " + buffer.readByteString().hex());
    }

    @GuardedBy("lock")
    private void setInUse(OkHttpClientStream okHttpClientStream) {
        if (!this.hasStream) {
            this.hasStream = true;
            KeepAliveManager keepAliveManager = this.keepAliveManager;
            if (keepAliveManager != null) {
                keepAliveManager.onTransportActive();
            }
        }
        if (okHttpClientStream.shouldBeCountedForInUse()) {
            this.inUseState.updateObjectInUse(okHttpClientStream, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGoAway(int i, ErrorCode errorCode, Status status) {
        synchronized (this.lock) {
            if (this.goAwayStatus == null) {
                this.goAwayStatus = status;
                this.listener.transportShutdown(status);
            }
            if (errorCode != null && !this.goAwaySent) {
                this.goAwaySent = true;
                this.frameWriter.goAway(0, errorCode, new byte[0]);
            }
            Iterator<Map.Entry<Integer, OkHttpClientStream>> it = this.streams.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, OkHttpClientStream> next = it.next();
                if (next.getKey().intValue() > i) {
                    it.remove();
                    next.getValue().c().transportReportStatus(status, ClientStreamListener.RpcProgress.REFUSED, false, new Metadata());
                    maybeClearInUse(next.getValue());
                }
            }
            Iterator<OkHttpClientStream> it2 = this.pendingStreams.iterator();
            while (it2.hasNext()) {
                OkHttpClientStream next2 = it2.next();
                next2.c().transportReportStatus(status, ClientStreamListener.RpcProgress.REFUSED, true, new Metadata());
                maybeClearInUse(next2);
            }
            this.pendingStreams.clear();
            stopIfNecessary();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("lock")
    public boolean startPendingStreams() {
        boolean z = false;
        while (!this.pendingStreams.isEmpty() && this.streams.size() < this.maxConcurrentStreams) {
            startStream(this.pendingStreams.poll());
            z = true;
        }
        return z;
    }

    @GuardedBy("lock")
    private void startStream(OkHttpClientStream okHttpClientStream) {
        Preconditions.checkState(okHttpClientStream.id() == -1, "StreamId already assigned");
        this.streams.put(Integer.valueOf(this.nextStreamId), okHttpClientStream);
        setInUse(okHttpClientStream);
        okHttpClientStream.c().start(this.nextStreamId);
        if ((okHttpClientStream.getType() != MethodDescriptor.MethodType.UNARY && okHttpClientStream.getType() != MethodDescriptor.MethodType.SERVER_STREAMING) || okHttpClientStream.h()) {
            this.frameWriter.flush();
        }
        int i = this.nextStreamId;
        if (i < 2147483645) {
            this.nextStreamId = i + 2;
        } else {
            this.nextStreamId = Integer.MAX_VALUE;
            startGoAway(Integer.MAX_VALUE, ErrorCode.NO_ERROR, Status.UNAVAILABLE.withDescription("Stream ids exhausted"));
        }
    }

    @GuardedBy("lock")
    private void stopIfNecessary() {
        if (this.goAwayStatus == null || !this.streams.isEmpty() || !this.pendingStreams.isEmpty() || this.stopped) {
            return;
        }
        this.stopped = true;
        KeepAliveManager keepAliveManager = this.keepAliveManager;
        if (keepAliveManager != null) {
            keepAliveManager.onTransportTermination();
            this.scheduler = (ScheduledExecutorService) SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.scheduler);
        }
        Http2Ping http2Ping = this.ping;
        if (http2Ping != null) {
            http2Ping.failed(getPingFailure());
            this.ping = null;
        }
        if (!this.goAwaySent) {
            this.goAwaySent = true;
            this.frameWriter.goAway(0, ErrorCode.NO_ERROR, new byte[0]);
        }
        this.frameWriter.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OkHttpClientStream a(int i) {
        OkHttpClientStream okHttpClientStream;
        synchronized (this.lock) {
            okHttpClientStream = this.streams.get(Integer.valueOf(i));
        }
        return okHttpClientStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, @Nullable Status status, ClientStreamListener.RpcProgress rpcProgress, boolean z, @Nullable ErrorCode errorCode, @Nullable Metadata metadata) {
        synchronized (this.lock) {
            OkHttpClientStream remove = this.streams.remove(Integer.valueOf(i));
            if (remove != null) {
                if (errorCode != null) {
                    this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                }
                if (status != null) {
                    OkHttpClientStream.TransportState c = remove.c();
                    if (metadata == null) {
                        metadata = new Metadata();
                    }
                    c.transportReportStatus(status, rpcProgress, z, metadata);
                }
                if (!startPendingStreams()) {
                    stopIfNecessary();
                    maybeClearInUse(remove);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GuardedBy("lock")
    public void a(OkHttpClientStream okHttpClientStream) {
        this.pendingStreams.remove(okHttpClientStream);
        maybeClearInUse(okHttpClientStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, long j, long j2, boolean z2) {
        this.enableKeepAlive = z;
        this.keepAliveTimeNanos = j;
        this.keepAliveTimeoutNanos = j2;
        this.keepAliveWithoutCalls = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OkHttpClientStream[] a() {
        OkHttpClientStream[] okHttpClientStreamArr;
        synchronized (this.lock) {
            okHttpClientStreamArr = (OkHttpClientStream[]) this.streams.values().toArray(EMPTY_STREAM_ARRAY);
        }
        return okHttpClientStreamArr;
    }

    @VisibleForTesting
    String b() {
        URI authorityToUri = GrpcUtil.authorityToUri(this.defaultAuthority);
        return authorityToUri.getHost() != null ? authorityToUri.getHost() : this.defaultAuthority;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GuardedBy("lock")
    public void b(OkHttpClientStream okHttpClientStream) {
        if (this.goAwayStatus != null) {
            okHttpClientStream.c().transportReportStatus(this.goAwayStatus, ClientStreamListener.RpcProgress.REFUSED, true, new Metadata());
        } else if (this.streams.size() < this.maxConcurrentStreams) {
            startStream(okHttpClientStream);
        } else {
            this.pendingStreams.add(okHttpClientStream);
            setInUse(okHttpClientStream);
        }
    }

    boolean b(int i) {
        boolean z;
        synchronized (this.lock) {
            z = true;
            if (i >= this.nextStreamId || (i & 1) != 1) {
                z = false;
            }
        }
        return z;
    }

    @VisibleForTesting
    int c() {
        URI authorityToUri = GrpcUtil.authorityToUri(this.defaultAuthority);
        return authorityToUri.getPort() != -1 ? authorityToUri.getPort() : this.address.getPort();
    }

    @Override // io.grpc.internal.ConnectionClientTransport
    public Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.SocketStats> getStats() {
        SettableFuture create = SettableFuture.create();
        synchronized (this.lock) {
            if (this.socket == null) {
                create.set(new InternalChannelz.SocketStats(this.transportTracer.getStats(), null, null, new InternalChannelz.SocketOptions.Builder().build(), null));
            } else {
                create.set(new InternalChannelz.SocketStats(this.transportTracer.getStats(), this.socket.getLocalSocketAddress(), this.socket.getRemoteSocketAddress(), Utils.a(this.socket), this.securityInfo));
            }
        }
        return create;
    }

    @Override // io.grpc.internal.ClientTransport
    public /* bridge */ /* synthetic */ ClientStream newStream(MethodDescriptor methodDescriptor, Metadata metadata, CallOptions callOptions) {
        return newStream((MethodDescriptor<?, ?>) methodDescriptor, metadata, callOptions);
    }

    @Override // io.grpc.internal.ClientTransport
    public OkHttpClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
        Preconditions.checkNotNull(methodDescriptor, FirebaseAnalytics.Param.METHOD);
        Preconditions.checkNotNull(metadata, "headers");
        StatsTraceContext newClientContext = StatsTraceContext.newClientContext(callOptions, this.attributes, metadata);
        synchronized (this.lock) {
            try {
                try {
                    return new OkHttpClientStream(methodDescriptor, metadata, this.frameWriter, this, this.outboundFlow, this.lock, this.maxMessageSize, this.initialWindowSize, this.defaultAuthority, this.userAgent, newClientContext, this.transportTracer, callOptions);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // io.grpc.okhttp.ExceptionHandlingFrameWriter.TransportExceptionHandler
    public void onException(Throwable th) {
        Preconditions.checkNotNull(th, "failureCause");
        startGoAway(0, ErrorCode.INTERNAL_ERROR, Status.UNAVAILABLE.withCause(th));
    }

    @Override // io.grpc.internal.ClientTransport
    public void ping(ClientTransport.PingCallback pingCallback, Executor executor) {
        long nextLong;
        Http2Ping http2Ping;
        synchronized (this.lock) {
            boolean z = true;
            Preconditions.checkState(this.frameWriter != null);
            if (this.stopped) {
                Http2Ping.notifyFailed(pingCallback, executor, getPingFailure());
                return;
            }
            if (this.ping != null) {
                http2Ping = this.ping;
                nextLong = 0;
                z = false;
            } else {
                nextLong = this.random.nextLong();
                Stopwatch stopwatch = this.stopwatchFactory.get();
                stopwatch.start();
                Http2Ping http2Ping2 = new Http2Ping(nextLong, stopwatch);
                this.ping = http2Ping2;
                this.transportTracer.reportKeepAliveSent();
                http2Ping = http2Ping2;
            }
            if (z) {
                this.frameWriter.ping(false, (int) (nextLong >>> 32), (int) nextLong);
            }
            http2Ping.addCallback(pingCallback, executor);
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public void shutdown(Status status) {
        synchronized (this.lock) {
            if (this.goAwayStatus != null) {
                return;
            }
            this.goAwayStatus = status;
            this.listener.transportShutdown(this.goAwayStatus);
            stopIfNecessary();
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public void shutdownNow(Status status) {
        shutdown(status);
        synchronized (this.lock) {
            Iterator<Map.Entry<Integer, OkHttpClientStream>> it = this.streams.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, OkHttpClientStream> next = it.next();
                it.remove();
                next.getValue().c().transportReportStatus(status, false, new Metadata());
                maybeClearInUse(next.getValue());
            }
            Iterator<OkHttpClientStream> it2 = this.pendingStreams.iterator();
            while (it2.hasNext()) {
                OkHttpClientStream next2 = it2.next();
                next2.c().transportReportStatus(status, true, new Metadata());
                maybeClearInUse(next2);
            }
            this.pendingStreams.clear();
            stopIfNecessary();
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public Runnable start(ManagedClientTransport.Listener listener) {
        SerializingExecutor serializingExecutor;
        Runnable runnable;
        this.listener = (ManagedClientTransport.Listener) Preconditions.checkNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.enableKeepAlive) {
            this.scheduler = (ScheduledExecutorService) SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE);
            this.keepAliveManager = new KeepAliveManager(new KeepAliveManager.ClientKeepAlivePinger(this), this.scheduler, this.keepAliveTimeNanos, this.keepAliveTimeoutNanos, this.keepAliveWithoutCalls);
            this.keepAliveManager.onTransportStarted();
        }
        if (isForTest()) {
            synchronized (this.lock) {
                this.frameWriter = new ExceptionHandlingFrameWriter(this, this.testFrameWriter, this.testFrameLogger);
                this.outboundFlow = new OutboundFlowController(this, this.frameWriter, this.initialWindowSize);
            }
            serializingExecutor = this.serializingExecutor;
            runnable = new Runnable() { // from class: io.grpc.okhttp.OkHttpClientTransport.3
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable2 = OkHttpClientTransport.this.b;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                    OkHttpClientTransport okHttpClientTransport = OkHttpClientTransport.this;
                    okHttpClientTransport.clientFrameHandler = new ClientFrameHandler(okHttpClientTransport.testFrameReader, OkHttpClientTransport.this.testFrameLogger);
                    OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
                    synchronized (OkHttpClientTransport.this.lock) {
                        OkHttpClientTransport.this.maxConcurrentStreams = Integer.MAX_VALUE;
                        OkHttpClientTransport.this.startPendingStreams();
                    }
                    OkHttpClientTransport.this.c.set(null);
                }
            };
        } else {
            final AsyncSink a = AsyncSink.a(this.serializingExecutor, this);
            final Http2 http2 = new Http2();
            FrameWriter newWriter = http2.newWriter(Okio.buffer(a), true);
            synchronized (this.lock) {
                this.frameWriter = new ExceptionHandlingFrameWriter(this, newWriter);
                this.outboundFlow = new OutboundFlowController(this, this.frameWriter, this.initialWindowSize);
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.okhttp.OkHttpClientTransport.4
                @Override // java.lang.Runnable
                public void run() {
                    OkHttpClientTransport okHttpClientTransport;
                    ClientFrameHandler clientFrameHandler;
                    Socket createHttpProxySocket;
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                    BufferedSource buffer = Okio.buffer(new Source(this) { // from class: io.grpc.okhttp.OkHttpClientTransport.4.1
                        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                        public void close() {
                        }

                        @Override // okio.Source
                        public long read(Buffer buffer2, long j) {
                            return -1L;
                        }

                        @Override // okio.Source
                        public Timeout timeout() {
                            return Timeout.NONE;
                        }
                    });
                    SSLSession sSLSession = null;
                    try {
                        try {
                            try {
                                if (OkHttpClientTransport.this.a == null) {
                                    createHttpProxySocket = OkHttpClientTransport.this.socketFactory.createSocket(OkHttpClientTransport.this.address.getAddress(), OkHttpClientTransport.this.address.getPort());
                                } else {
                                    if (!(OkHttpClientTransport.this.a.getProxyAddress() instanceof InetSocketAddress)) {
                                        throw Status.INTERNAL.withDescription("Unsupported SocketAddress implementation " + OkHttpClientTransport.this.a.getProxyAddress().getClass()).asException();
                                    }
                                    createHttpProxySocket = OkHttpClientTransport.this.createHttpProxySocket(OkHttpClientTransport.this.a.getTargetAddress(), (InetSocketAddress) OkHttpClientTransport.this.a.getProxyAddress(), OkHttpClientTransport.this.a.getUsername(), OkHttpClientTransport.this.a.getPassword());
                                }
                                Socket socket = createHttpProxySocket;
                                Socket socket2 = socket;
                                if (OkHttpClientTransport.this.sslSocketFactory != null) {
                                    SSLSocket upgrade = OkHttpTlsUpgrader.upgrade(OkHttpClientTransport.this.sslSocketFactory, OkHttpClientTransport.this.hostnameVerifier, socket, OkHttpClientTransport.this.b(), OkHttpClientTransport.this.c(), OkHttpClientTransport.this.connectionSpec);
                                    sSLSession = upgrade.getSession();
                                    socket2 = upgrade;
                                }
                                socket2.setTcpNoDelay(true);
                                BufferedSource buffer2 = Okio.buffer(Okio.source(socket2));
                                a.a(Okio.sink(socket2), socket2);
                                OkHttpClientTransport.this.attributes = OkHttpClientTransport.this.attributes.toBuilder().set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, socket2.getRemoteSocketAddress()).set(Grpc.TRANSPORT_ATTR_LOCAL_ADDR, socket2.getLocalSocketAddress()).set(Grpc.TRANSPORT_ATTR_SSL_SESSION, sSLSession).set(GrpcAttributes.ATTR_SECURITY_LEVEL, sSLSession == null ? SecurityLevel.NONE : SecurityLevel.PRIVACY_AND_INTEGRITY).build();
                                OkHttpClientTransport okHttpClientTransport2 = OkHttpClientTransport.this;
                                okHttpClientTransport2.clientFrameHandler = new ClientFrameHandler(okHttpClientTransport2, http2.newReader(buffer2, true));
                                synchronized (OkHttpClientTransport.this.lock) {
                                    OkHttpClientTransport.this.socket = (Socket) Preconditions.checkNotNull(socket2, "socket");
                                    if (sSLSession != null) {
                                        OkHttpClientTransport.this.securityInfo = new InternalChannelz.Security(new InternalChannelz.Tls(sSLSession));
                                    }
                                }
                            } catch (StatusException e) {
                                OkHttpClientTransport.this.startGoAway(0, ErrorCode.INTERNAL_ERROR, e.getStatus());
                                okHttpClientTransport = OkHttpClientTransport.this;
                                clientFrameHandler = new ClientFrameHandler(okHttpClientTransport, http2.newReader(buffer, true));
                                okHttpClientTransport.clientFrameHandler = clientFrameHandler;
                            }
                        } catch (Exception e2) {
                            OkHttpClientTransport.this.onException(e2);
                            okHttpClientTransport = OkHttpClientTransport.this;
                            clientFrameHandler = new ClientFrameHandler(okHttpClientTransport, http2.newReader(buffer, true));
                            okHttpClientTransport.clientFrameHandler = clientFrameHandler;
                        }
                    } catch (Throwable th) {
                        OkHttpClientTransport okHttpClientTransport3 = OkHttpClientTransport.this;
                        okHttpClientTransport3.clientFrameHandler = new ClientFrameHandler(okHttpClientTransport3, http2.newReader(buffer, true));
                        throw th;
                    }
                }
            });
            try {
                synchronized (this.lock) {
                    this.frameWriter.connectionPreface();
                    this.frameWriter.settings(new Settings());
                }
                countDownLatch.countDown();
                serializingExecutor = this.serializingExecutor;
                runnable = new Runnable() { // from class: io.grpc.okhttp.OkHttpClientTransport.5
                    @Override // java.lang.Runnable
                    public void run() {
                        OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
                        synchronized (OkHttpClientTransport.this.lock) {
                            OkHttpClientTransport.this.maxConcurrentStreams = Integer.MAX_VALUE;
                            OkHttpClientTransport.this.startPendingStreams();
                        }
                    }
                };
            } catch (Throwable th) {
                countDownLatch.countDown();
                throw th;
            }
        }
        serializingExecutor.execute(runnable);
        return null;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add("address", this.address).toString();
    }
}
