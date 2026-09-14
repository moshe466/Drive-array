package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Attributes;
import io.grpc.BinaryLog;
import io.grpc.ClientInterceptor;
import io.grpc.CompressorRegistry;
import io.grpc.DecompressorRegistry;
import io.grpc.EquivalentAddressGroup;
import io.grpc.InternalChannelz;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import io.grpc.NameResolverRegistry;
import io.grpc.ProxyDetector;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.ExponentialBackoffPolicy;
import io.grpc.internal.TransportTracer;
import io.opencensus.trace.Tracing;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public abstract class AbstractManagedChannelImplBuilder<T extends AbstractManagedChannelImplBuilder<T>> extends ManagedChannelBuilder<T> {
    private static final long DEFAULT_PER_RPC_BUFFER_LIMIT_IN_BYTES = 1048576;
    private static final long DEFAULT_RETRY_BUFFER_SIZE_IN_BYTES = 16777216;
    private static final String DIRECT_ADDRESS_SCHEME = "directaddress";
    ObjectPool<? extends Executor> a;
    final String b;

    @Nullable
    String c;

    @Nullable
    private CensusStatsModule censusStatsOverride;

    @VisibleForTesting
    @Nullable
    String d;

    @Nullable
    private final SocketAddress directServerAddress;
    String e;
    boolean f;
    DecompressorRegistry g;
    CompressorRegistry h;
    long i;
    private final List<ClientInterceptor> interceptors;
    int j;
    int k;
    long l;
    long m;
    private int maxInboundMessageSize;
    boolean n;
    private NameResolver.Factory nameResolverFactory;
    boolean o;
    InternalChannelz p;
    int q;

    @Nullable
    Map<String, ?> r;
    private boolean recordFinishedRpcs;
    private boolean recordRealTimeMetrics;
    private boolean recordStartedRpcs;
    boolean s;
    private boolean statsEnabled;
    protected TransportTracer.Factory t;
    private boolean tracingEnabled;

    @Nullable
    BinaryLog u;

    @Nullable
    ProxyDetector v;

    @VisibleForTesting
    static final long w = TimeUnit.MINUTES.toMillis(30);
    static final long x = TimeUnit.SECONDS.toMillis(1);
    private static final ObjectPool<? extends Executor> DEFAULT_EXECUTOR_POOL = SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR);
    private static final NameResolver.Factory DEFAULT_NAME_RESOLVER_FACTORY = NameResolverRegistry.getDefaultRegistry().asFactory();
    private static final DecompressorRegistry DEFAULT_DECOMPRESSOR_REGISTRY = DecompressorRegistry.getDefaultInstance();
    private static final CompressorRegistry DEFAULT_COMPRESSOR_REGISTRY = CompressorRegistry.getDefaultInstance();

    /* loaded from: classes2.dex */
    private static class DirectAddressNameResolverFactory extends NameResolver.Factory {
        final SocketAddress a;
        final String b;

        DirectAddressNameResolverFactory(SocketAddress socketAddress, String str) {
            this.a = socketAddress;
            this.b = str;
        }

        @Override // io.grpc.NameResolver.Factory
        public String getDefaultScheme() {
            return AbstractManagedChannelImplBuilder.DIRECT_ADDRESS_SCHEME;
        }

        @Override // io.grpc.NameResolver.Factory
        public NameResolver newNameResolver(URI uri, NameResolver.Args args) {
            return new NameResolver() { // from class: io.grpc.internal.AbstractManagedChannelImplBuilder.DirectAddressNameResolverFactory.1
                @Override // io.grpc.NameResolver
                public String getServiceAuthority() {
                    return DirectAddressNameResolverFactory.this.b;
                }

                @Override // io.grpc.NameResolver
                public void shutdown() {
                }

                @Override // io.grpc.NameResolver
                public void start(NameResolver.Listener2 listener2) {
                    listener2.onResult(NameResolver.ResolutionResult.newBuilder().setAddresses(Collections.singletonList(new EquivalentAddressGroup(DirectAddressNameResolverFactory.this.a))).setAttributes(Attributes.EMPTY).build());
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractManagedChannelImplBuilder(String str) {
        this.a = DEFAULT_EXECUTOR_POOL;
        this.interceptors = new ArrayList();
        this.nameResolverFactory = DEFAULT_NAME_RESOLVER_FACTORY;
        this.e = GrpcUtil.DEFAULT_LB_POLICY;
        this.g = DEFAULT_DECOMPRESSOR_REGISTRY;
        this.h = DEFAULT_COMPRESSOR_REGISTRY;
        this.i = w;
        this.j = 5;
        this.k = 5;
        this.l = DEFAULT_RETRY_BUFFER_SIZE_IN_BYTES;
        this.m = 1048576L;
        this.n = false;
        this.p = InternalChannelz.instance();
        this.s = true;
        this.t = TransportTracer.getDefaultFactory();
        this.maxInboundMessageSize = 4194304;
        this.statsEnabled = true;
        this.recordStartedRpcs = true;
        this.recordFinishedRpcs = true;
        this.recordRealTimeMetrics = false;
        this.tracingEnabled = true;
        this.b = (String) Preconditions.checkNotNull(str, "target");
        this.directServerAddress = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractManagedChannelImplBuilder(SocketAddress socketAddress, String str) {
        this.a = DEFAULT_EXECUTOR_POOL;
        this.interceptors = new ArrayList();
        this.nameResolverFactory = DEFAULT_NAME_RESOLVER_FACTORY;
        this.e = GrpcUtil.DEFAULT_LB_POLICY;
        this.g = DEFAULT_DECOMPRESSOR_REGISTRY;
        this.h = DEFAULT_COMPRESSOR_REGISTRY;
        this.i = w;
        this.j = 5;
        this.k = 5;
        this.l = DEFAULT_RETRY_BUFFER_SIZE_IN_BYTES;
        this.m = 1048576L;
        this.n = false;
        this.p = InternalChannelz.instance();
        this.s = true;
        this.t = TransportTracer.getDefaultFactory();
        this.maxInboundMessageSize = 4194304;
        this.statsEnabled = true;
        this.recordStartedRpcs = true;
        this.recordFinishedRpcs = true;
        this.recordRealTimeMetrics = false;
        this.tracingEnabled = true;
        this.b = a(socketAddress);
        this.directServerAddress = socketAddress;
        this.nameResolverFactory = new DirectAddressNameResolverFactory(socketAddress, str);
    }

    @VisibleForTesting
    static String a(SocketAddress socketAddress) {
        try {
            return new URI(DIRECT_ADDRESS_SCHEME, "", "/" + socketAddress, null).toString();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<?> checkListEntryTypes(List<?> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object obj : list) {
            if (obj == null) {
                obj = null;
            } else if (obj instanceof Map) {
                obj = checkMapEntryTypes((Map) obj);
            } else if (obj instanceof List) {
                obj = checkListEntryTypes((List) obj);
            } else if (!(obj instanceof String) && !(obj instanceof Double) && !(obj instanceof Boolean)) {
                throw new IllegalArgumentException("The entry '" + obj + "' is of type '" + obj.getClass() + "', which is not supported");
            }
            arrayList.add(obj);
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Nullable
    private static Map<String, ?> checkMapEntryTypes(@Nullable Map<?, ?> map) {
        Object checkMapEntryTypes;
        if (map == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Preconditions.checkArgument(entry.getKey() instanceof String, "The key of the entry '%s' is not of String type", entry);
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                linkedHashMap.put(str, null);
            } else {
                if (value instanceof Map) {
                    checkMapEntryTypes = checkMapEntryTypes((Map) value);
                } else if (value instanceof List) {
                    checkMapEntryTypes = checkListEntryTypes((List) value);
                } else {
                    if (!(value instanceof String) && !(value instanceof Double) && !(value instanceof Boolean)) {
                        throw new IllegalArgumentException("The value of the map entry '" + entry + "' is of type '" + value.getClass() + "', which is not supported");
                    }
                    linkedHashMap.put(str, value);
                }
                linkedHashMap.put(str, checkMapEntryTypes);
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static ManagedChannelBuilder<?> forAddress(String str, int i) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    public static ManagedChannelBuilder<?> forTarget(String str) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    private T thisT() {
        return this;
    }

    protected abstract ClientTransportFactory a();

    protected String a(String str) {
        return GrpcUtil.checkAuthority(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        this.recordFinishedRpcs = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b() {
        return GrpcUtil.DEFAULT_PORT_SSL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(boolean z) {
        this.recordStartedRpcs = z;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannel build() {
        return new ManagedChannelOrphanWrapper(new ManagedChannelImpl(this, a(), new ExponentialBackoffPolicy.Provider(), SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR), GrpcUtil.STOPWATCH_SUPPLIER, c(), TimeProvider.SYSTEM_TIME_PROVIDER));
    }

    @VisibleForTesting
    final List<ClientInterceptor> c() {
        ArrayList arrayList = new ArrayList(this.interceptors);
        this.o = false;
        if (this.statsEnabled) {
            this.o = true;
            CensusStatsModule censusStatsModule = this.censusStatsOverride;
            if (censusStatsModule == null) {
                censusStatsModule = new CensusStatsModule(GrpcUtil.STOPWATCH_SUPPLIER, true, this.recordStartedRpcs, this.recordFinishedRpcs, this.recordRealTimeMetrics);
            }
            arrayList.add(0, censusStatsModule.a());
        }
        if (this.tracingEnabled) {
            this.o = true;
            arrayList.add(0, new CensusTracingModule(Tracing.getTracer(), Tracing.getPropagationComponent().getBinaryFormat()).a());
        }
        return arrayList;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T compressorRegistry(CompressorRegistry compressorRegistry) {
        if (compressorRegistry == null) {
            compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
        }
        this.h = compressorRegistry;
        return thisT();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NameResolver.Factory d() {
        String str = this.d;
        return str == null ? this.nameResolverFactory : new OverrideAuthorityNameResolverFactory(this.nameResolverFactory, str);
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T decompressorRegistry(DecompressorRegistry decompressorRegistry) {
        if (decompressorRegistry == null) {
            decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
        }
        this.g = decompressorRegistry;
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T defaultLoadBalancingPolicy(String str) {
        Preconditions.checkState(this.directServerAddress == null, "directServerAddress is set (%s), which forbids the use of load-balancing policy", this.directServerAddress);
        Preconditions.checkArgument(str != null, "policy cannot be null");
        this.e = str;
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public /* bridge */ /* synthetic */ ManagedChannelBuilder defaultServiceConfig(@Nullable Map map) {
        return defaultServiceConfig((Map<String, ?>) map);
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T defaultServiceConfig(@Nullable Map<String, ?> map) {
        this.r = checkMapEntryTypes(map);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T directExecutor() {
        return executor(MoreExecutors.directExecutor());
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T disableRetry() {
        this.n = false;
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T disableServiceConfigLookUp() {
        this.s = false;
        return thisT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int e() {
        return this.maxInboundMessageSize;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T enableFullStreamDecompression() {
        this.f = true;
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T enableRetry() {
        this.n = true;
        this.statsEnabled = false;
        this.tracingEnabled = false;
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T executor(Executor executor) {
        if (executor != null) {
            this.a = new FixedObjectPool(executor);
        } else {
            this.a = DEFAULT_EXECUTOR_POOL;
        }
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T idleTimeout(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j > 0, "idle timeout is %s, but must be positive", j);
        this.i = timeUnit.toDays(j) >= 30 ? -1L : Math.max(timeUnit.toMillis(j), x);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public /* bridge */ /* synthetic */ ManagedChannelBuilder intercept(List list) {
        return intercept((List<ClientInterceptor>) list);
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T intercept(List<ClientInterceptor> list) {
        this.interceptors.addAll(list);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T intercept(ClientInterceptor... clientInterceptorArr) {
        return intercept(Arrays.asList(clientInterceptorArr));
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T maxHedgedAttempts(int i) {
        this.k = i;
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T maxInboundMessageSize(int i) {
        Preconditions.checkArgument(i >= 0, "negative max");
        this.maxInboundMessageSize = i;
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T maxRetryAttempts(int i) {
        this.j = i;
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T maxTraceEvents(int i) {
        Preconditions.checkArgument(i >= 0, "maxTraceEvents must be non-negative");
        this.q = i;
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T nameResolverFactory(NameResolver.Factory factory) {
        Preconditions.checkState(this.directServerAddress == null, "directServerAddress is set (%s), which forbids the use of NameResolverFactory", this.directServerAddress);
        if (factory == null) {
            factory = DEFAULT_NAME_RESOLVER_FACTORY;
        }
        this.nameResolverFactory = factory;
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T overrideAuthority(String str) {
        this.d = a(str);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T perRpcBufferLimit(long j) {
        Preconditions.checkArgument(j > 0, "per RPC buffer limit must be positive");
        this.m = j;
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T proxyDetector(@Nullable ProxyDetector proxyDetector) {
        this.v = proxyDetector;
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T retryBufferSize(long j) {
        Preconditions.checkArgument(j > 0, "retry buffer size must be positive");
        this.l = j;
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T setBinaryLog(BinaryLog binaryLog) {
        this.u = binaryLog;
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T userAgent(@Nullable String str) {
        this.c = str;
        return thisT();
    }
}
