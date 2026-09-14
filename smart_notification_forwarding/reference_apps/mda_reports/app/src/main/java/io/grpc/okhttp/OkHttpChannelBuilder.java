package io.grpc.okhttp;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.ChannelLogger;
import io.grpc.ExperimentalApi;
import io.grpc.Internal;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.AtomicBackoff;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.internal.CipherSuite;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.Platform;
import io.grpc.okhttp.internal.TlsVersion;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1785")
/* loaded from: classes2.dex */
public class OkHttpChannelBuilder extends AbstractManagedChannelImplBuilder<OkHttpChannelBuilder> {
    public static final int DEFAULT_FLOW_CONTROL_WINDOW = 65535;
    private ConnectionSpec connectionSpec;
    private int flowControlWindow;
    private HostnameVerifier hostnameVerifier;
    private long keepAliveTimeNanos;
    private long keepAliveTimeoutNanos;
    private boolean keepAliveWithoutCalls;
    private int maxInboundMetadataSize;
    private NegotiationType negotiationType;
    private ScheduledExecutorService scheduledExecutorService;
    private SocketFactory socketFactory;
    private SSLSocketFactory sslSocketFactory;
    private Executor transportExecutor;

    @VisibleForTesting
    static final ConnectionSpec y = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).cipherSuites(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384).tlsVersions(TlsVersion.TLS_1_2).supportsTlsExtensions(true).build();
    private static final long AS_LARGE_AS_INFINITE = TimeUnit.DAYS.toNanos(1000);
    private static final SharedResourceHolder.Resource<Executor> SHARED_EXECUTOR = new SharedResourceHolder.Resource<Executor>() { // from class: io.grpc.okhttp.OkHttpChannelBuilder.1
        @Override // io.grpc.internal.SharedResourceHolder.Resource
        public void close(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }

        @Override // io.grpc.internal.SharedResourceHolder.Resource
        public Executor create() {
            return Executors.newCachedThreadPool(GrpcUtil.getThreadFactory("grpc-okhttp-%d", true));
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.grpc.okhttp.OkHttpChannelBuilder$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b = new int[NegotiationType.values().length];

        static {
            try {
                b[NegotiationType.PLAINTEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[NegotiationType.TLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = new int[io.grpc.okhttp.NegotiationType.values().length];
            try {
                a[io.grpc.okhttp.NegotiationType.TLS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[io.grpc.okhttp.NegotiationType.PLAINTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum NegotiationType {
        TLS,
        PLAINTEXT
    }

    @Internal
    /* loaded from: classes2.dex */
    static final class OkHttpTransportFactory implements ClientTransportFactory {
        private boolean closed;
        private final ConnectionSpec connectionSpec;
        private final boolean enableKeepAlive;
        private final Executor executor;
        private final int flowControlWindow;

        @Nullable
        private final HostnameVerifier hostnameVerifier;
        private final AtomicBackoff keepAliveTimeNanos;
        private final long keepAliveTimeoutNanos;
        private final boolean keepAliveWithoutCalls;
        private final int maxInboundMetadataSize;
        private final int maxMessageSize;
        private final SocketFactory socketFactory;

        @Nullable
        private final SSLSocketFactory sslSocketFactory;
        private final ScheduledExecutorService timeoutService;
        private final TransportTracer.Factory transportTracerFactory;
        private final boolean usingSharedExecutor;
        private final boolean usingSharedScheduler;

        private OkHttpTransportFactory(Executor executor, @Nullable ScheduledExecutorService scheduledExecutorService, @Nullable SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, ConnectionSpec connectionSpec, int i, boolean z, long j, long j2, int i2, boolean z2, int i3, TransportTracer.Factory factory) {
            Executor executor2 = executor;
            this.usingSharedScheduler = scheduledExecutorService == null;
            this.timeoutService = this.usingSharedScheduler ? (ScheduledExecutorService) SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE) : scheduledExecutorService;
            this.socketFactory = socketFactory;
            this.sslSocketFactory = sSLSocketFactory;
            this.hostnameVerifier = hostnameVerifier;
            this.connectionSpec = connectionSpec;
            this.maxMessageSize = i;
            this.enableKeepAlive = z;
            this.keepAliveTimeNanos = new AtomicBackoff("keepalive time nanos", j);
            this.keepAliveTimeoutNanos = j2;
            this.flowControlWindow = i2;
            this.keepAliveWithoutCalls = z2;
            this.maxInboundMetadataSize = i3;
            this.usingSharedExecutor = executor2 == null;
            this.transportTracerFactory = (TransportTracer.Factory) Preconditions.checkNotNull(factory, "transportTracerFactory");
            this.executor = this.usingSharedExecutor ? (Executor) SharedResourceHolder.get(OkHttpChannelBuilder.SHARED_EXECUTOR) : executor2;
        }

        @Override // io.grpc.internal.ClientTransportFactory, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.usingSharedScheduler) {
                SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.timeoutService);
            }
            if (this.usingSharedExecutor) {
                SharedResourceHolder.release(OkHttpChannelBuilder.SHARED_EXECUTOR, this.executor);
            }
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ScheduledExecutorService getScheduledExecutorService() {
            return this.timeoutService;
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ConnectionClientTransport newClientTransport(SocketAddress socketAddress, ClientTransportFactory.ClientTransportOptions clientTransportOptions, ChannelLogger channelLogger) {
            if (this.closed) {
                throw new IllegalStateException("The transport factory is closed.");
            }
            final AtomicBackoff.State state = this.keepAliveTimeNanos.getState();
            OkHttpClientTransport okHttpClientTransport = new OkHttpClientTransport((InetSocketAddress) socketAddress, clientTransportOptions.getAuthority(), clientTransportOptions.getUserAgent(), clientTransportOptions.getEagAttributes(), this.executor, this.socketFactory, this.sslSocketFactory, this.hostnameVerifier, this.connectionSpec, this.maxMessageSize, this.flowControlWindow, clientTransportOptions.getHttpConnectProxiedSocketAddress(), new Runnable(this) { // from class: io.grpc.okhttp.OkHttpChannelBuilder.OkHttpTransportFactory.1
                @Override // java.lang.Runnable
                public void run() {
                    state.backoff();
                }
            }, this.maxInboundMetadataSize, this.transportTracerFactory.create());
            if (this.enableKeepAlive) {
                okHttpClientTransport.a(true, state.get(), this.keepAliveTimeoutNanos, this.keepAliveWithoutCalls);
            }
            return okHttpClientTransport;
        }
    }

    private OkHttpChannelBuilder(String str) {
        super(str);
        this.connectionSpec = y;
        this.negotiationType = NegotiationType.TLS;
        this.keepAliveTimeNanos = Long.MAX_VALUE;
        this.keepAliveTimeoutNanos = GrpcUtil.DEFAULT_KEEPALIVE_TIMEOUT_NANOS;
        this.flowControlWindow = 65535;
        this.maxInboundMetadataSize = Integer.MAX_VALUE;
    }

    protected OkHttpChannelBuilder(String str, int i) {
        this(GrpcUtil.authorityFromHostAndPort(str, i));
    }

    public static OkHttpChannelBuilder forAddress(String str, int i) {
        return new OkHttpChannelBuilder(str, i);
    }

    public static OkHttpChannelBuilder forTarget(String str) {
        return new OkHttpChannelBuilder(str);
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder
    @Internal
    protected final ClientTransportFactory a() {
        return new OkHttpTransportFactory(this.transportExecutor, this.scheduledExecutorService, this.socketFactory, f(), this.hostnameVerifier, this.connectionSpec, e(), this.keepAliveTimeNanos != Long.MAX_VALUE, this.keepAliveTimeNanos, this.keepAliveTimeoutNanos, this.flowControlWindow, this.keepAliveWithoutCalls, this.maxInboundMetadataSize, this.t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder
    public int b() {
        int i = AnonymousClass2.b[this.negotiationType.ordinal()];
        if (i == 1) {
            return 80;
        }
        if (i == 2) {
            return GrpcUtil.DEFAULT_PORT_SSL;
        }
        throw new AssertionError(this.negotiationType + " not handled");
    }

    public final OkHttpChannelBuilder connectionSpec(com.squareup.okhttp.ConnectionSpec connectionSpec) {
        Preconditions.checkArgument(connectionSpec.isTls(), "plaintext ConnectionSpec is not accepted");
        this.connectionSpec = Utils.a(connectionSpec);
        return this;
    }

    @Deprecated
    public final OkHttpChannelBuilder enableKeepAlive(boolean z) {
        return keepAliveTime(z ? GrpcUtil.DEFAULT_KEEPALIVE_TIME_NANOS : Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }

    @Deprecated
    public final OkHttpChannelBuilder enableKeepAlive(boolean z, long j, TimeUnit timeUnit, long j2, TimeUnit timeUnit2) {
        return z ? keepAliveTime(j, timeUnit).keepAliveTimeout(j2, timeUnit2) : keepAliveTime(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }

    @VisibleForTesting
    @Nullable
    SSLSocketFactory f() {
        SSLContext sSLContext;
        int i = AnonymousClass2.b[this.negotiationType.ordinal()];
        if (i == 1) {
            return null;
        }
        if (i != 2) {
            throw new RuntimeException("Unknown negotiation type: " + this.negotiationType);
        }
        try {
            if (this.sslSocketFactory == null) {
                if (GrpcUtil.IS_RESTRICTED_APPENGINE) {
                    sSLContext = SSLContext.getInstance("TLS", Platform.get().getProvider());
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    trustManagerFactory.init((KeyStore) null);
                    sSLContext.init(null, trustManagerFactory.getTrustManagers(), SecureRandom.getInstance("SHA1PRNG", Platform.get().getProvider()));
                } else {
                    sSLContext = SSLContext.getInstance("Default", Platform.get().getProvider());
                }
                this.sslSocketFactory = sSLContext.getSocketFactory();
            }
            return this.sslSocketFactory;
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("TLS Provider failure", e);
        }
    }

    public OkHttpChannelBuilder flowControlWindow(int i) {
        Preconditions.checkState(i > 0, "flowControlWindow must be positive");
        this.flowControlWindow = i;
        return this;
    }

    public final OkHttpChannelBuilder hostnameVerifier(@Nullable HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public OkHttpChannelBuilder keepAliveTime(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j > 0, "keepalive time must be positive");
        this.keepAliveTimeNanos = timeUnit.toNanos(j);
        this.keepAliveTimeNanos = KeepAliveManager.clampKeepAliveTimeInNanos(this.keepAliveTimeNanos);
        if (this.keepAliveTimeNanos >= AS_LARGE_AS_INFINITE) {
            this.keepAliveTimeNanos = Long.MAX_VALUE;
        }
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public OkHttpChannelBuilder keepAliveTimeout(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j > 0, "keepalive timeout must be positive");
        this.keepAliveTimeoutNanos = timeUnit.toNanos(j);
        this.keepAliveTimeoutNanos = KeepAliveManager.clampKeepAliveTimeoutInNanos(this.keepAliveTimeoutNanos);
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public OkHttpChannelBuilder keepAliveWithoutCalls(boolean z) {
        this.keepAliveWithoutCalls = z;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public OkHttpChannelBuilder maxInboundMetadataSize(int i) {
        Preconditions.checkArgument(i > 0, "maxInboundMetadataSize must be > 0");
        this.maxInboundMetadataSize = i;
        return this;
    }

    @Deprecated
    public final OkHttpChannelBuilder negotiationType(io.grpc.okhttp.NegotiationType negotiationType) {
        NegotiationType negotiationType2;
        Preconditions.checkNotNull(negotiationType, "type");
        int i = AnonymousClass2.a[negotiationType.ordinal()];
        if (i == 1) {
            negotiationType2 = NegotiationType.TLS;
        } else {
            if (i != 2) {
                throw new AssertionError("Unknown negotiation type: " + negotiationType);
            }
            negotiationType2 = NegotiationType.PLAINTEXT;
        }
        this.negotiationType = negotiationType2;
        return this;
    }

    public final OkHttpChannelBuilder scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService, "scheduledExecutorService");
        return this;
    }

    public final OkHttpChannelBuilder socketFactory(@Nullable SocketFactory socketFactory) {
        this.socketFactory = socketFactory;
        return this;
    }

    public final OkHttpChannelBuilder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
        this.negotiationType = NegotiationType.TLS;
        return this;
    }

    public final OkHttpChannelBuilder transportExecutor(@Nullable Executor executor) {
        this.transportExecutor = executor;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final OkHttpChannelBuilder usePlaintext() {
        this.negotiationType = NegotiationType.PLAINTEXT;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    @Deprecated
    public final OkHttpChannelBuilder usePlaintext(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("Plaintext negotiation not currently supported");
        }
        negotiationType(io.grpc.okhttp.NegotiationType.PLAINTEXT);
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final OkHttpChannelBuilder useTransportSecurity() {
        this.negotiationType = NegotiationType.TLS;
        return this;
    }
}
