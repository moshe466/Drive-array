package io.grpc.internal;

import io.grpc.LoadBalancer;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class AbstractSubchannel extends LoadBalancer.Subchannel {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public abstract ClientTransport a();
}
