package io.grpc;

import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes2.dex */
public abstract class Server {
    public abstract void awaitTermination();

    public abstract boolean awaitTermination(long j, TimeUnit timeUnit);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    public List<ServerServiceDefinition> getImmutableServices() {
        return Collections.emptyList();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/5332")
    public List<? extends SocketAddress> getListenSockets() {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    public List<ServerServiceDefinition> getMutableServices() {
        return Collections.emptyList();
    }

    public int getPort() {
        return -1;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    public List<ServerServiceDefinition> getServices() {
        return Collections.emptyList();
    }

    public abstract boolean isShutdown();

    public abstract boolean isTerminated();

    public abstract Server shutdown();

    public abstract Server shutdownNow();

    public abstract Server start();
}
