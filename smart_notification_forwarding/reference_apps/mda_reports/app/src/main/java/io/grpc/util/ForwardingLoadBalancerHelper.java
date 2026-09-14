package io.grpc.util;

import com.google.common.base.MoreObjects;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.EquivalentAddressGroup;
import io.grpc.ExperimentalApi;
import io.grpc.LoadBalancer;
import io.grpc.ManagedChannel;
import io.grpc.NameResolver;
import io.grpc.SynchronizationContext;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
/* loaded from: classes2.dex */
public abstract class ForwardingLoadBalancerHelper extends LoadBalancer.Helper {
    protected abstract LoadBalancer.Helper a();

    @Override // io.grpc.LoadBalancer.Helper
    public ManagedChannel createOobChannel(EquivalentAddressGroup equivalentAddressGroup, String str) {
        return a().createOobChannel(equivalentAddressGroup, str);
    }

    @Override // io.grpc.LoadBalancer.Helper
    public ManagedChannel createResolvingOobChannel(String str) {
        return a().createResolvingOobChannel(str);
    }

    @Override // io.grpc.LoadBalancer.Helper
    public LoadBalancer.Subchannel createSubchannel(List<EquivalentAddressGroup> list, Attributes attributes) {
        return a().createSubchannel(list, attributes);
    }

    @Override // io.grpc.LoadBalancer.Helper
    public String getAuthority() {
        return a().getAuthority();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public ChannelLogger getChannelLogger() {
        return a().getChannelLogger();
    }

    @Override // io.grpc.LoadBalancer.Helper
    @Deprecated
    public NameResolver.Factory getNameResolverFactory() {
        return a().getNameResolverFactory();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public ScheduledExecutorService getScheduledExecutorService() {
        return a().getScheduledExecutorService();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public SynchronizationContext getSynchronizationContext() {
        return a().getSynchronizationContext();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public void refreshNameResolution() {
        a().refreshNameResolution();
    }

    @Override // io.grpc.LoadBalancer.Helper
    @Deprecated
    public void runSerialized(Runnable runnable) {
        a().runSerialized(runnable);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", a()).toString();
    }

    @Override // io.grpc.LoadBalancer.Helper
    public void updateBalancingState(ConnectivityState connectivityState, LoadBalancer.SubchannelPicker subchannelPicker) {
        a().updateBalancingState(connectivityState, subchannelPicker);
    }

    @Override // io.grpc.LoadBalancer.Helper
    public void updateOobChannelAddresses(ManagedChannel managedChannel, EquivalentAddressGroup equivalentAddressGroup) {
        a().updateOobChannelAddresses(managedChannel, equivalentAddressGroup);
    }

    @Override // io.grpc.LoadBalancer.Helper
    public void updateSubchannelAddresses(LoadBalancer.Subchannel subchannel, List<EquivalentAddressGroup> list) {
        a().updateSubchannelAddresses(subchannel, list);
    }
}
