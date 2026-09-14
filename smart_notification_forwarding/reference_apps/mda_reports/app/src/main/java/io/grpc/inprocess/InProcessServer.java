package io.grpc.inprocess;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.ServerStreamTracer;
import io.grpc.internal.InternalServer;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerListener;
import io.grpc.internal.ServerTransportListener;
import java.io.IOException;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes2.dex */
final class InProcessServer implements InternalServer {
    private static final ConcurrentMap<String, InProcessServer> registry = new ConcurrentHashMap();
    private ServerListener listener;
    private final int maxInboundMetadataSize;
    private final String name;
    private ScheduledExecutorService scheduler;
    private final ObjectPool<ScheduledExecutorService> schedulerPool;
    private boolean shutdown;
    private final List<ServerStreamTracer.Factory> streamTracerFactories;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InProcessServer(InProcessServerBuilder inProcessServerBuilder, List<? extends ServerStreamTracer.Factory> list) {
        this.name = inProcessServerBuilder.l;
        this.schedulerPool = inProcessServerBuilder.n;
        this.maxInboundMetadataSize = inProcessServerBuilder.m;
        this.streamTracerFactories = Collections.unmodifiableList((List) Preconditions.checkNotNull(list, "streamTracerFactories"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InProcessServer a(String str) {
        return registry.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.maxInboundMetadataSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ServerTransportListener a(InProcessTransport inProcessTransport) {
        if (this.shutdown) {
            return null;
        }
        return this.listener.transportCreated(inProcessTransport);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectPool<ScheduledExecutorService> b() {
        return this.schedulerPool;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ServerStreamTracer.Factory> c() {
        return this.streamTracerFactories;
    }

    @Override // io.grpc.internal.InternalServer
    public SocketAddress getListenSocketAddress() {
        return new InProcessSocketAddress(this.name);
    }

    @Override // io.grpc.internal.InternalServer
    public InternalInstrumented<InternalChannelz.SocketStats> getListenSocketStats() {
        return null;
    }

    @Override // io.grpc.internal.InternalServer
    public void shutdown() {
        if (!registry.remove(this.name, this)) {
            throw new AssertionError();
        }
        this.scheduler = this.schedulerPool.returnObject(this.scheduler);
        synchronized (this) {
            this.shutdown = true;
            this.listener.serverShutdown();
        }
    }

    @Override // io.grpc.internal.InternalServer
    public void start(ServerListener serverListener) {
        this.listener = serverListener;
        this.scheduler = this.schedulerPool.getObject();
        if (registry.putIfAbsent(this.name, this) == null) {
            return;
        }
        throw new IOException("name already registered: " + this.name);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).toString();
    }
}
