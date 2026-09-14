package io.grpc.util;

import com.google.common.base.MoreObjects;
import io.grpc.Attributes;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.ExperimentalApi;
import io.grpc.LoadBalancer;
import io.grpc.Status;
import java.util.List;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
/* loaded from: classes2.dex */
public abstract class ForwardingLoadBalancer extends LoadBalancer {
    protected abstract LoadBalancer a();

    @Override // io.grpc.LoadBalancer
    public boolean canHandleEmptyAddressListFromNameResolution() {
        return a().canHandleEmptyAddressListFromNameResolution();
    }

    @Override // io.grpc.LoadBalancer
    public void handleNameResolutionError(Status status) {
        a().handleNameResolutionError(status);
    }

    @Override // io.grpc.LoadBalancer
    @Deprecated
    public void handleResolvedAddressGroups(List<EquivalentAddressGroup> list, Attributes attributes) {
        a().handleResolvedAddressGroups(list, attributes);
    }

    @Override // io.grpc.LoadBalancer
    public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        a().handleResolvedAddresses(resolvedAddresses);
    }

    @Override // io.grpc.LoadBalancer
    public void handleSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
        a().handleSubchannelState(subchannel, connectivityStateInfo);
    }

    @Override // io.grpc.LoadBalancer
    public void shutdown() {
        a().shutdown();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", a()).toString();
    }
}
