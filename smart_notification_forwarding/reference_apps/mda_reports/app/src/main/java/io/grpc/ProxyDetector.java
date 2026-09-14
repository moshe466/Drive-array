package io.grpc;

import java.net.SocketAddress;
import javax.annotation.Nullable;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/5279")
/* loaded from: classes2.dex */
public interface ProxyDetector {
    @Nullable
    ProxiedSocketAddress proxyFor(SocketAddress socketAddress);
}
