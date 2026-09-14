package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.Status;
import java.util.List;

/* loaded from: classes2.dex */
final class PickFirstLoadBalancer extends LoadBalancer {
    private final LoadBalancer.Helper helper;
    private LoadBalancer.Subchannel subchannel;

    /* renamed from: io.grpc.internal.PickFirstLoadBalancer$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[ConnectivityState.values().length];

        static {
            try {
                a[ConnectivityState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ConnectivityState.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ConnectivityState.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ConnectivityState.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    private static final class Picker extends LoadBalancer.SubchannelPicker {
        private final LoadBalancer.PickResult result;

        Picker(LoadBalancer.PickResult pickResult) {
            this.result = (LoadBalancer.PickResult) Preconditions.checkNotNull(pickResult, "result");
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return this.result;
        }
    }

    /* loaded from: classes2.dex */
    private static final class RequestConnectionPicker extends LoadBalancer.SubchannelPicker {
        private final LoadBalancer.Subchannel subchannel;

        RequestConnectionPicker(LoadBalancer.Subchannel subchannel) {
            this.subchannel = (LoadBalancer.Subchannel) Preconditions.checkNotNull(subchannel, "subchannel");
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            this.subchannel.requestConnection();
            return LoadBalancer.PickResult.withNoResult();
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public void requestConnection() {
            this.subchannel.requestConnection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PickFirstLoadBalancer(LoadBalancer.Helper helper) {
        this.helper = (LoadBalancer.Helper) Preconditions.checkNotNull(helper, "helper");
    }

    @Override // io.grpc.LoadBalancer
    public void handleNameResolutionError(Status status) {
        LoadBalancer.Subchannel subchannel = this.subchannel;
        if (subchannel != null) {
            subchannel.shutdown();
            this.subchannel = null;
        }
        this.helper.updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new Picker(LoadBalancer.PickResult.withError(status)));
    }

    @Override // io.grpc.LoadBalancer
    public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        List<EquivalentAddressGroup> addresses = resolvedAddresses.getAddresses();
        LoadBalancer.Subchannel subchannel = this.subchannel;
        if (subchannel != null) {
            this.helper.updateSubchannelAddresses(subchannel, addresses);
            return;
        }
        this.subchannel = this.helper.createSubchannel(addresses, Attributes.EMPTY);
        this.helper.updateBalancingState(ConnectivityState.CONNECTING, new Picker(LoadBalancer.PickResult.withSubchannel(this.subchannel)));
        this.subchannel.requestConnection();
    }

    @Override // io.grpc.LoadBalancer
    public void handleSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
        LoadBalancer.SubchannelPicker requestConnectionPicker;
        LoadBalancer.SubchannelPicker subchannelPicker;
        ConnectivityState state = connectivityStateInfo.getState();
        if (subchannel != this.subchannel || state == ConnectivityState.SHUTDOWN) {
            return;
        }
        int i = AnonymousClass1.a[state.ordinal()];
        if (i != 1) {
            if (i == 2) {
                subchannelPicker = new Picker(LoadBalancer.PickResult.withNoResult());
            } else if (i == 3) {
                requestConnectionPicker = new Picker(LoadBalancer.PickResult.withSubchannel(subchannel));
            } else {
                if (i != 4) {
                    throw new IllegalArgumentException("Unsupported state:" + state);
                }
                subchannelPicker = new Picker(LoadBalancer.PickResult.withError(connectivityStateInfo.getStatus()));
            }
            this.helper.updateBalancingState(state, subchannelPicker);
        }
        requestConnectionPicker = new RequestConnectionPicker(subchannel);
        subchannelPicker = requestConnectionPicker;
        this.helper.updateBalancingState(state, subchannelPicker);
    }

    @Override // io.grpc.LoadBalancer
    public void shutdown() {
        LoadBalancer.Subchannel subchannel = this.subchannel;
        if (subchannel != null) {
            subchannel.shutdown();
        }
    }
}
