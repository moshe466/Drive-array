package io.grpc;

import com.google.common.base.MoreObjects;
import io.grpc.ForwardingChannelBuilder;
import io.grpc.NameResolver;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/3363")
/* loaded from: classes2.dex */
public abstract class ForwardingChannelBuilder<T extends ForwardingChannelBuilder<T>> extends ManagedChannelBuilder<T> {
    public static ManagedChannelBuilder<?> forAddress(String str, int i) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    public static ManagedChannelBuilder<?> forTarget(String str) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    protected abstract ManagedChannelBuilder<?> a();

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannel build() {
        return a().build();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T compressorRegistry(CompressorRegistry compressorRegistry) {
        a().compressorRegistry(compressorRegistry);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T decompressorRegistry(DecompressorRegistry decompressorRegistry) {
        a().decompressorRegistry(decompressorRegistry);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T defaultLoadBalancingPolicy(String str) {
        a().defaultLoadBalancingPolicy(str);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T defaultServiceConfig(@Nullable Map<String, ?> map) {
        a().defaultServiceConfig(map);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public /* bridge */ /* synthetic */ ManagedChannelBuilder defaultServiceConfig(@Nullable Map map) {
        return defaultServiceConfig((Map<String, ?>) map);
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T directExecutor() {
        a().directExecutor();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T disableRetry() {
        a().disableRetry();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T disableServiceConfigLookUp() {
        a().disableServiceConfigLookUp();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T enableFullStreamDecompression() {
        a().enableFullStreamDecompression();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T enableRetry() {
        a().enableRetry();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T executor(Executor executor) {
        a().executor(executor);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T idleTimeout(long j, TimeUnit timeUnit) {
        a().idleTimeout(j, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T intercept(List<ClientInterceptor> list) {
        a().intercept(list);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T intercept(ClientInterceptor... clientInterceptorArr) {
        a().intercept(clientInterceptorArr);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public /* bridge */ /* synthetic */ ManagedChannelBuilder intercept(List list) {
        return intercept((List<ClientInterceptor>) list);
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T keepAliveTime(long j, TimeUnit timeUnit) {
        a().keepAliveTime(j, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T keepAliveTimeout(long j, TimeUnit timeUnit) {
        a().keepAliveTimeout(j, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T keepAliveWithoutCalls(boolean z) {
        a().keepAliveWithoutCalls(z);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T maxHedgedAttempts(int i) {
        a().maxHedgedAttempts(i);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T maxInboundMessageSize(int i) {
        a().maxInboundMessageSize(i);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T maxInboundMetadataSize(int i) {
        a().maxInboundMetadataSize(i);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T maxRetryAttempts(int i) {
        a().maxRetryAttempts(i);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T maxTraceEvents(int i) {
        a().maxTraceEvents(i);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T nameResolverFactory(NameResolver.Factory factory) {
        a().nameResolverFactory(factory);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T overrideAuthority(String str) {
        a().overrideAuthority(str);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T perRpcBufferLimit(long j) {
        a().perRpcBufferLimit(j);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T proxyDetector(ProxyDetector proxyDetector) {
        a().proxyDetector(proxyDetector);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T retryBufferSize(long j) {
        a().retryBufferSize(j);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T setBinaryLog(BinaryLog binaryLog) {
        a().setBinaryLog(binaryLog);
        return thisT();
    }

    protected final T thisT() {
        return this;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", a()).toString();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T usePlaintext() {
        a().usePlaintext();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    @Deprecated
    public T usePlaintext(boolean z) {
        a().usePlaintext(z);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T useTransportSecurity() {
        a().useTransportSecurity();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T userAgent(String str) {
        a().userAgent(str);
        return thisT();
    }
}
