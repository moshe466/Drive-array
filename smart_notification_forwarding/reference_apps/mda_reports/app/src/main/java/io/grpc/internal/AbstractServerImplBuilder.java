package io.grpc.internal;

import androidx.core.app.NotificationCompat;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.BinaryLog;
import io.grpc.BindableService;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.DecompressorRegistry;
import io.grpc.HandlerRegistry;
import io.grpc.InternalChannelz;
import io.grpc.InternalNotifyOnServerBuild;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServerStreamTracer;
import io.grpc.ServerTransportFilter;
import io.grpc.internal.AbstractServerImplBuilder;
import io.grpc.internal.CallTracer;
import io.grpc.internal.InternalHandlerRegistry;
import io.grpc.internal.TransportTracer;
import io.opencensus.trace.Tracing;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public abstract class AbstractServerImplBuilder<T extends AbstractServerImplBuilder<T>> extends ServerBuilder<T> {

    @Nullable
    private CensusStatsModule censusStatsOverride;

    @Nullable
    BinaryLog i;
    InternalChannelz j;
    CallTracer.Factory k;
    private static final ObjectPool<? extends Executor> DEFAULT_EXECUTOR_POOL = SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR);
    private static final HandlerRegistry DEFAULT_FALLBACK_REGISTRY = new DefaultFallbackRegistry();
    private static final DecompressorRegistry DEFAULT_DECOMPRESSOR_REGISTRY = DecompressorRegistry.getDefaultInstance();
    private static final CompressorRegistry DEFAULT_COMPRESSOR_REGISTRY = CompressorRegistry.getDefaultInstance();
    private static final long DEFAULT_HANDSHAKE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(120);
    final InternalHandlerRegistry.Builder a = new InternalHandlerRegistry.Builder();
    final List<ServerTransportFilter> b = new ArrayList();
    final List<ServerInterceptor> c = new ArrayList();
    private final List<InternalNotifyOnServerBuild> notifyOnBuildList = new ArrayList();
    private final List<ServerStreamTracer.Factory> streamTracerFactories = new ArrayList();
    HandlerRegistry d = DEFAULT_FALLBACK_REGISTRY;
    ObjectPool<? extends Executor> e = DEFAULT_EXECUTOR_POOL;
    DecompressorRegistry f = DEFAULT_DECOMPRESSOR_REGISTRY;
    CompressorRegistry g = DEFAULT_COMPRESSOR_REGISTRY;
    long h = DEFAULT_HANDSHAKE_TIMEOUT_MILLIS;
    private boolean statsEnabled = true;
    private boolean recordStartedRpcs = true;
    private boolean recordFinishedRpcs = true;
    private boolean recordRealTimeMetrics = false;
    private boolean tracingEnabled = true;

    /* loaded from: classes2.dex */
    private static final class DefaultFallbackRegistry extends HandlerRegistry {
        private DefaultFallbackRegistry() {
        }

        @Override // io.grpc.HandlerRegistry
        public List<ServerServiceDefinition> getServices() {
            return Collections.emptyList();
        }

        @Override // io.grpc.HandlerRegistry
        @Nullable
        public ServerMethodDefinition<?, ?> lookupMethod(String str, @Nullable String str2) {
            return null;
        }
    }

    public AbstractServerImplBuilder() {
        TransportTracer.getDefaultFactory();
        this.j = InternalChannelz.instance();
        this.k = CallTracer.getDefaultFactory();
    }

    public static ServerBuilder<?> forPort(int i) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    private T thisT() {
        return this;
    }

    @VisibleForTesting
    final List<? extends ServerStreamTracer.Factory> a() {
        ArrayList arrayList = new ArrayList();
        if (this.statsEnabled) {
            CensusStatsModule censusStatsModule = this.censusStatsOverride;
            if (censusStatsModule == null) {
                censusStatsModule = new CensusStatsModule(GrpcUtil.STOPWATCH_SUPPLIER, true, this.recordStartedRpcs, this.recordFinishedRpcs, this.recordRealTimeMetrics);
            }
            arrayList.add(censusStatsModule.b());
        }
        if (this.tracingEnabled) {
            arrayList.add(new CensusTracingModule(Tracing.getTracer(), Tracing.getPropagationComponent().getBinaryFormat()).b());
        }
        arrayList.addAll(this.streamTracerFactories);
        arrayList.trimToSize();
        return Collections.unmodifiableList(arrayList);
    }

    protected abstract List<? extends InternalServer> a(List<? extends ServerStreamTracer.Factory> list);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        this.recordFinishedRpcs = z;
    }

    @Override // io.grpc.ServerBuilder
    public final T addService(BindableService bindableService) {
        if (bindableService instanceof InternalNotifyOnServerBuild) {
            this.notifyOnBuildList.add((InternalNotifyOnServerBuild) bindableService);
        }
        return addService(((BindableService) Preconditions.checkNotNull(bindableService, "bindableService")).bindService());
    }

    @Override // io.grpc.ServerBuilder
    public final T addService(ServerServiceDefinition serverServiceDefinition) {
        this.a.a((ServerServiceDefinition) Preconditions.checkNotNull(serverServiceDefinition, NotificationCompat.CATEGORY_SERVICE));
        return thisT();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.grpc.ServerBuilder
    public final T addStreamTracerFactory(ServerStreamTracer.Factory factory) {
        this.streamTracerFactories.add(Preconditions.checkNotNull(factory, "factory"));
        return thisT();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.grpc.ServerBuilder
    public final T addTransportFilter(ServerTransportFilter serverTransportFilter) {
        this.b.add(Preconditions.checkNotNull(serverTransportFilter, "filter"));
        return thisT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(boolean z) {
        this.recordStartedRpcs = z;
    }

    @Override // io.grpc.ServerBuilder
    public final Server build() {
        ServerImpl serverImpl = new ServerImpl(this, a(a()), Context.ROOT);
        Iterator<InternalNotifyOnServerBuild> it = this.notifyOnBuildList.iterator();
        while (it.hasNext()) {
            it.next().notifyOnBuild(serverImpl);
        }
        return serverImpl;
    }

    @Override // io.grpc.ServerBuilder
    public final T compressorRegistry(@Nullable CompressorRegistry compressorRegistry) {
        if (compressorRegistry == null) {
            compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
        }
        this.g = compressorRegistry;
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public final T decompressorRegistry(@Nullable DecompressorRegistry decompressorRegistry) {
        if (decompressorRegistry == null) {
            decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
        }
        this.f = decompressorRegistry;
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public final T directExecutor() {
        return executor(MoreExecutors.directExecutor());
    }

    @Override // io.grpc.ServerBuilder
    public final T executor(@Nullable Executor executor) {
        this.e = executor != null ? new FixedObjectPool<>(executor) : DEFAULT_EXECUTOR_POOL;
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public final T fallbackHandlerRegistry(@Nullable HandlerRegistry handlerRegistry) {
        if (handlerRegistry == null) {
            handlerRegistry = DEFAULT_FALLBACK_REGISTRY;
        }
        this.d = handlerRegistry;
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public final T handshakeTimeout(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j > 0, "handshake timeout is %s, but must be positive", j);
        this.h = ((TimeUnit) Preconditions.checkNotNull(timeUnit, "unit")).toMillis(j);
        return thisT();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.grpc.ServerBuilder
    public final T intercept(ServerInterceptor serverInterceptor) {
        this.c.add(Preconditions.checkNotNull(serverInterceptor, "interceptor"));
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public final T setBinaryLog(@Nullable BinaryLog binaryLog) {
        this.i = binaryLog;
        return thisT();
    }

    @VisibleForTesting
    public final T setTransportTracerFactory(TransportTracer.Factory factory) {
        return thisT();
    }
}
