package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Verify;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.Deadline;
import io.grpc.MethodDescriptor;
import io.grpc.internal.HedgingPolicy;
import io.grpc.internal.ManagedChannelServiceConfig;
import io.grpc.internal.RetryPolicy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
final class ServiceConfigInterceptor implements ClientInterceptor {
    static final CallOptions.Key<RetryPolicy.Provider> b = CallOptions.Key.create("internal-retry-policy");
    static final CallOptions.Key<HedgingPolicy.Provider> c = CallOptions.Key.create("internal-hedging-policy");

    @VisibleForTesting
    final AtomicReference<ManagedChannelServiceConfig> a = new AtomicReference<>();
    private volatile boolean initComplete;
    private final int maxHedgedAttemptsLimit;
    private final int maxRetryAttemptsLimit;
    private final boolean retryEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceConfigInterceptor(boolean z, int i, int i2) {
        this.retryEnabled = z;
        this.maxRetryAttemptsLimit = i;
        this.maxHedgedAttemptsLimit = i2;
    }

    @CheckForNull
    private ManagedChannelServiceConfig.MethodInfo getMethodInfo(MethodDescriptor<?, ?> methodDescriptor) {
        ManagedChannelServiceConfig managedChannelServiceConfig = this.a.get();
        ManagedChannelServiceConfig.MethodInfo methodInfo = managedChannelServiceConfig != null ? managedChannelServiceConfig.b().get(methodDescriptor.getFullMethodName()) : null;
        if (methodInfo != null || managedChannelServiceConfig == null) {
            return methodInfo;
        }
        return managedChannelServiceConfig.a().get(methodDescriptor.getServiceName());
    }

    @VisibleForTesting
    HedgingPolicy a(MethodDescriptor<?, ?> methodDescriptor) {
        ManagedChannelServiceConfig.MethodInfo methodInfo = getMethodInfo(methodDescriptor);
        return methodInfo == null ? HedgingPolicy.d : methodInfo.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@Nullable Map<String, ?> map) {
        this.a.set(map == null ? new ManagedChannelServiceConfig(new HashMap(), new HashMap(), null, null) : ManagedChannelServiceConfig.a(map, this.retryEnabled, this.maxRetryAttemptsLimit, this.maxHedgedAttemptsLimit, null));
        this.initComplete = true;
    }

    @VisibleForTesting
    RetryPolicy b(MethodDescriptor<?, ?> methodDescriptor) {
        ManagedChannelServiceConfig.MethodInfo methodInfo = getMethodInfo(methodDescriptor);
        return methodInfo == null ? RetryPolicy.f : methodInfo.e;
    }

    @Override // io.grpc.ClientInterceptor
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(final MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
        if (this.retryEnabled) {
            if (this.initComplete) {
                final RetryPolicy b2 = b(methodDescriptor);
                final HedgingPolicy a = a((MethodDescriptor<?, ?>) methodDescriptor);
                Verify.verify(b2.equals(RetryPolicy.f) || a.equals(HedgingPolicy.d), "Can not apply both retry and hedging policy for the method '%s'", methodDescriptor);
                callOptions = callOptions.withOption(b, new RetryPolicy.Provider(this) { // from class: io.grpc.internal.ServiceConfigInterceptor.1ImmediateRetryPolicyProvider
                    @Override // io.grpc.internal.RetryPolicy.Provider
                    public RetryPolicy get() {
                        return b2;
                    }
                }).withOption(c, new HedgingPolicy.Provider(this) { // from class: io.grpc.internal.ServiceConfigInterceptor.1ImmediateHedgingPolicyProvider
                    @Override // io.grpc.internal.HedgingPolicy.Provider
                    public HedgingPolicy get() {
                        return a;
                    }
                });
            } else {
                callOptions = callOptions.withOption(b, new RetryPolicy.Provider() { // from class: io.grpc.internal.ServiceConfigInterceptor.1DelayedRetryPolicyProvider
                    @Override // io.grpc.internal.RetryPolicy.Provider
                    public RetryPolicy get() {
                        return !ServiceConfigInterceptor.this.initComplete ? RetryPolicy.f : ServiceConfigInterceptor.this.b(methodDescriptor);
                    }
                }).withOption(c, new HedgingPolicy.Provider() { // from class: io.grpc.internal.ServiceConfigInterceptor.1DelayedHedgingPolicyProvider
                    @Override // io.grpc.internal.HedgingPolicy.Provider
                    public HedgingPolicy get() {
                        if (!ServiceConfigInterceptor.this.initComplete) {
                            return HedgingPolicy.d;
                        }
                        HedgingPolicy a2 = ServiceConfigInterceptor.this.a(methodDescriptor);
                        Verify.verify(a2.equals(HedgingPolicy.d) || ServiceConfigInterceptor.this.b(methodDescriptor).equals(RetryPolicy.f), "Can not apply both retry and hedging policy for the method '%s'", methodDescriptor);
                        return a2;
                    }
                });
            }
        }
        ManagedChannelServiceConfig.MethodInfo methodInfo = getMethodInfo(methodDescriptor);
        if (methodInfo == null) {
            return channel.newCall(methodDescriptor, callOptions);
        }
        Long l = methodInfo.a;
        if (l != null) {
            Deadline after = Deadline.after(l.longValue(), TimeUnit.NANOSECONDS);
            Deadline deadline = callOptions.getDeadline();
            if (deadline == null || after.compareTo(deadline) < 0) {
                callOptions = callOptions.withDeadline(after);
            }
        }
        Boolean bool = methodInfo.b;
        if (bool != null) {
            callOptions = bool.booleanValue() ? callOptions.withWaitForReady() : callOptions.withoutWaitForReady();
        }
        if (methodInfo.c != null) {
            Integer maxInboundMessageSize = callOptions.getMaxInboundMessageSize();
            callOptions = callOptions.withMaxInboundMessageSize(maxInboundMessageSize != null ? Math.min(maxInboundMessageSize.intValue(), methodInfo.c.intValue()) : methodInfo.c.intValue());
        }
        if (methodInfo.d != null) {
            Integer maxOutboundMessageSize = callOptions.getMaxOutboundMessageSize();
            callOptions = callOptions.withMaxOutboundMessageSize(maxOutboundMessageSize != null ? Math.min(maxOutboundMessageSize.intValue(), methodInfo.d.intValue()) : methodInfo.d.intValue());
        }
        return channel.newCall(methodDescriptor, callOptions);
    }
}
