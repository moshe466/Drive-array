package io.grpc.inprocess;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.base.Preconditions;
import io.grpc.ExperimentalApi;
import io.grpc.ServerStreamTracer;
import io.grpc.internal.AbstractServerImplBuilder;
import io.grpc.internal.FixedObjectPool;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.SharedResourcePool;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1783")
/* loaded from: classes2.dex */
public final class InProcessServerBuilder extends AbstractServerImplBuilder<InProcessServerBuilder> {
    final String l;
    int m = Integer.MAX_VALUE;
    ObjectPool<ScheduledExecutorService> n = SharedResourcePool.forResource(GrpcUtil.TIMER_SERVICE);

    private InProcessServerBuilder(String str) {
        this.l = (String) Preconditions.checkNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        b(false);
        a(false);
        handshakeTimeout(Long.MAX_VALUE, TimeUnit.SECONDS);
    }

    public static InProcessServerBuilder forName(String str) {
        return new InProcessServerBuilder(str);
    }

    public static InProcessServerBuilder forPort(int i) {
        throw new UnsupportedOperationException("call forName() instead");
    }

    public static String generateName() {
        return UUID.randomUUID().toString();
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder
    protected List<InProcessServer> a(List<? extends ServerStreamTracer.Factory> list) {
        return Collections.singletonList(new InProcessServer(this, list));
    }

    @Override // io.grpc.ServerBuilder
    public InProcessServerBuilder maxInboundMetadataSize(int i) {
        Preconditions.checkArgument(i > 0, "maxInboundMetadataSize must be > 0");
        this.m = i;
        return this;
    }

    public InProcessServerBuilder scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.n = new FixedObjectPool(Preconditions.checkNotNull(scheduledExecutorService, "scheduledExecutorService"));
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public InProcessServerBuilder useTransportSecurity(File file, File file2) {
        throw new UnsupportedOperationException("TLS not supported in InProcessServer");
    }
}
