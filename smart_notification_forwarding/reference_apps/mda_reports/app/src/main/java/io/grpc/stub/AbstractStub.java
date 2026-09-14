package io.grpc.stub;

import com.google.common.base.Preconditions;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.Deadline;
import io.grpc.ExperimentalApi;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@CheckReturnValue
/* loaded from: classes.dex */
public abstract class AbstractStub<S extends AbstractStub<S>> {
    private final CallOptions callOptions;
    private final Channel channel;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractStub(Channel channel) {
        this(channel, CallOptions.DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractStub(Channel channel, CallOptions callOptions) {
        this.channel = (Channel) Preconditions.checkNotNull(channel, "channel");
        this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions, "callOptions");
    }

    protected abstract S a(Channel channel, CallOptions callOptions);

    public final CallOptions getCallOptions() {
        return this.callOptions;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final S withCallCredentials(CallCredentials callCredentials) {
        return a(this.channel, this.callOptions.withCallCredentials(callCredentials));
    }

    @Deprecated
    public final S withChannel(Channel channel) {
        return a(channel, this.callOptions);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public final S withCompression(String str) {
        return a(this.channel, this.callOptions.withCompression(str));
    }

    public final S withDeadline(@Nullable Deadline deadline) {
        return a(this.channel, this.callOptions.withDeadline(deadline));
    }

    public final S withDeadlineAfter(long j, TimeUnit timeUnit) {
        return a(this.channel, this.callOptions.withDeadlineAfter(j, timeUnit));
    }

    public final S withExecutor(Executor executor) {
        return a(this.channel, this.callOptions.withExecutor(executor));
    }

    public final S withInterceptors(ClientInterceptor... clientInterceptorArr) {
        return a(ClientInterceptors.intercept(this.channel, clientInterceptorArr), this.callOptions);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2563")
    public final S withMaxInboundMessageSize(int i) {
        return a(this.channel, this.callOptions.withMaxInboundMessageSize(i));
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2563")
    public final S withMaxOutboundMessageSize(int i) {
        return a(this.channel, this.callOptions.withMaxOutboundMessageSize(i));
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1869")
    public final <T> S withOption(CallOptions.Key<T> key, T t) {
        return a(this.channel, this.callOptions.withOption(key, t));
    }

    public final S withWaitForReady() {
        return a(this.channel, this.callOptions.withWaitForReady());
    }
}
