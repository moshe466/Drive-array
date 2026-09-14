package io.grpc.util;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.GrpcAttributes;
import io.grpc.internal.ServiceConfigUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class RoundRobinLoadBalancer extends LoadBalancer {
    private ConnectivityState currentState;
    private final LoadBalancer.Helper helper;

    @Nullable
    private StickinessState stickinessState;

    @VisibleForTesting
    static final Attributes.Key<Ref<ConnectivityStateInfo>> a = Attributes.Key.create("state-info");
    static final Attributes.Key<Ref<LoadBalancer.Subchannel>> b = Attributes.Key.create("sticky-ref");
    private static final Status EMPTY_OK = Status.OK.withDescription("no subchannels ready");
    private final Map<EquivalentAddressGroup, LoadBalancer.Subchannel> subchannels = new HashMap();
    private RoundRobinPicker currentPicker = new EmptyPicker(EMPTY_OK);
    private final Random random = new Random();

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class EmptyPicker extends RoundRobinPicker {
        private final Status status;

        EmptyPicker(@Nonnull Status status) {
            super();
            this.status = (Status) Preconditions.checkNotNull(status, "status");
        }

        @Override // io.grpc.util.RoundRobinLoadBalancer.RoundRobinPicker
        boolean a(RoundRobinPicker roundRobinPicker) {
            if (roundRobinPicker instanceof EmptyPicker) {
                EmptyPicker emptyPicker = (EmptyPicker) roundRobinPicker;
                if (Objects.equal(this.status, emptyPicker.status) || (this.status.isOk() && emptyPicker.status.isOk())) {
                    return true;
                }
            }
            return false;
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return this.status.isOk() ? LoadBalancer.PickResult.withNoResult() : LoadBalancer.PickResult.withError(this.status);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class ReadyPicker extends RoundRobinPicker {
        private static final AtomicIntegerFieldUpdater<ReadyPicker> indexUpdater = AtomicIntegerFieldUpdater.newUpdater(ReadyPicker.class, FirebaseAnalytics.Param.INDEX);
        private volatile int index;
        private final List<LoadBalancer.Subchannel> list;

        @Nullable
        private final StickinessState stickinessState;

        ReadyPicker(List<LoadBalancer.Subchannel> list, int i, @Nullable StickinessState stickinessState) {
            super();
            Preconditions.checkArgument(!list.isEmpty(), "empty list");
            this.list = list;
            this.stickinessState = stickinessState;
            this.index = i - 1;
        }

        private LoadBalancer.Subchannel nextSubchannel() {
            int i;
            int size = this.list.size();
            int incrementAndGet = indexUpdater.incrementAndGet(this);
            if (incrementAndGet >= size) {
                i = incrementAndGet % size;
                indexUpdater.compareAndSet(this, incrementAndGet, i);
            } else {
                i = incrementAndGet;
            }
            return this.list.get(i);
        }

        @Override // io.grpc.util.RoundRobinLoadBalancer.RoundRobinPicker
        boolean a(RoundRobinPicker roundRobinPicker) {
            if (!(roundRobinPicker instanceof ReadyPicker)) {
                return false;
            }
            ReadyPicker readyPicker = (ReadyPicker) roundRobinPicker;
            return readyPicker == this || (this.stickinessState == readyPicker.stickinessState && this.list.size() == readyPicker.list.size() && new HashSet(this.list).containsAll(readyPicker.list));
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            LoadBalancer.Subchannel subchannel;
            String str;
            if (this.stickinessState == null || (str = (String) pickSubchannelArgs.getHeaders().get(this.stickinessState.a)) == null) {
                subchannel = null;
            } else {
                subchannel = this.stickinessState.a(str);
                if (subchannel == null || !RoundRobinLoadBalancer.a(subchannel)) {
                    subchannel = this.stickinessState.a(str, nextSubchannel());
                }
            }
            if (subchannel == null) {
                subchannel = nextSubchannel();
            }
            return LoadBalancer.PickResult.withSubchannel(subchannel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class Ref<T> {
        T a;

        Ref(T t) {
            this.a = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class RoundRobinPicker extends LoadBalancer.SubchannelPicker {
        private RoundRobinPicker() {
        }

        abstract boolean a(RoundRobinPicker roundRobinPicker);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class StickinessState {
        final Metadata.Key<String> a;
        final ConcurrentMap<String, Ref<LoadBalancer.Subchannel>> b = new ConcurrentHashMap();
        final Queue<String> c = new ConcurrentLinkedQueue();

        StickinessState(@Nonnull String str) {
            this.a = Metadata.Key.of(str, Metadata.ASCII_STRING_MARSHALLER);
        }

        private void addToEvictionQueue(String str) {
            String poll;
            while (this.b.size() >= 1000 && (poll = this.c.poll()) != null) {
                this.b.remove(poll);
            }
            this.c.add(str);
        }

        @Nullable
        LoadBalancer.Subchannel a(String str) {
            Ref<LoadBalancer.Subchannel> ref = this.b.get(str);
            if (ref != null) {
                return ref.a;
            }
            return null;
        }

        @Nonnull
        LoadBalancer.Subchannel a(String str, @Nonnull LoadBalancer.Subchannel subchannel) {
            Ref<LoadBalancer.Subchannel> putIfAbsent;
            Ref<LoadBalancer.Subchannel> ref = (Ref) subchannel.getAttributes().get(RoundRobinLoadBalancer.b);
            do {
                putIfAbsent = this.b.putIfAbsent(str, ref);
                if (putIfAbsent == null) {
                    addToEvictionQueue(str);
                    return subchannel;
                }
                LoadBalancer.Subchannel subchannel2 = putIfAbsent.a;
                if (subchannel2 != null && RoundRobinLoadBalancer.a(subchannel2)) {
                    return subchannel2;
                }
            } while (!this.b.replace(str, putIfAbsent, ref));
            return subchannel;
        }

        void a(LoadBalancer.Subchannel subchannel) {
            ((Ref) subchannel.getAttributes().get(RoundRobinLoadBalancer.b)).a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoundRobinLoadBalancer(LoadBalancer.Helper helper) {
        this.helper = (LoadBalancer.Helper) Preconditions.checkNotNull(helper, "helper");
    }

    static boolean a(LoadBalancer.Subchannel subchannel) {
        return getSubchannelStateInfoRef(subchannel).a.getState() == ConnectivityState.READY;
    }

    private static List<LoadBalancer.Subchannel> filterNonFailingSubchannels(Collection<LoadBalancer.Subchannel> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (LoadBalancer.Subchannel subchannel : collection) {
            if (a(subchannel)) {
                arrayList.add(subchannel);
            }
        }
        return arrayList;
    }

    private static Ref<ConnectivityStateInfo> getSubchannelStateInfoRef(LoadBalancer.Subchannel subchannel) {
        return (Ref) Preconditions.checkNotNull(subchannel.getAttributes().get(a), "STATE_INFO");
    }

    private static <T> Set<T> setsDifference(Set<T> set, Set<T> set2) {
        HashSet hashSet = new HashSet(set);
        hashSet.removeAll(set2);
        return hashSet;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, io.grpc.ConnectivityStateInfo] */
    private void shutdownSubchannel(LoadBalancer.Subchannel subchannel) {
        subchannel.shutdown();
        getSubchannelStateInfoRef(subchannel).a = ConnectivityStateInfo.forNonError(ConnectivityState.SHUTDOWN);
        StickinessState stickinessState = this.stickinessState;
        if (stickinessState != null) {
            stickinessState.a(subchannel);
        }
    }

    private static Set<EquivalentAddressGroup> stripAttrs(List<EquivalentAddressGroup> list) {
        HashSet hashSet = new HashSet(list.size());
        Iterator<EquivalentAddressGroup> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(new EquivalentAddressGroup(it.next().getAddresses()));
        }
        return hashSet;
    }

    private void updateBalancingState() {
        List<LoadBalancer.Subchannel> filterNonFailingSubchannels = filterNonFailingSubchannels(a());
        if (!filterNonFailingSubchannels.isEmpty()) {
            updateBalancingState(ConnectivityState.READY, new ReadyPicker(filterNonFailingSubchannels, this.random.nextInt(filterNonFailingSubchannels.size()), this.stickinessState));
            return;
        }
        boolean z = false;
        Status status = EMPTY_OK;
        Iterator<LoadBalancer.Subchannel> it = a().iterator();
        while (it.hasNext()) {
            ConnectivityStateInfo connectivityStateInfo = getSubchannelStateInfoRef(it.next()).a;
            if (connectivityStateInfo.getState() == ConnectivityState.CONNECTING || connectivityStateInfo.getState() == ConnectivityState.IDLE) {
                z = true;
            }
            if (status == EMPTY_OK || !status.isOk()) {
                status = connectivityStateInfo.getStatus();
            }
        }
        updateBalancingState(z ? ConnectivityState.CONNECTING : ConnectivityState.TRANSIENT_FAILURE, new EmptyPicker(status));
    }

    private void updateBalancingState(ConnectivityState connectivityState, RoundRobinPicker roundRobinPicker) {
        if (connectivityState == this.currentState && roundRobinPicker.a(this.currentPicker)) {
            return;
        }
        this.helper.updateBalancingState(connectivityState, roundRobinPicker);
        this.currentState = connectivityState;
        this.currentPicker = roundRobinPicker;
    }

    @VisibleForTesting
    Collection<LoadBalancer.Subchannel> a() {
        return this.subchannels.values();
    }

    @Override // io.grpc.LoadBalancer
    public void handleNameResolutionError(Status status) {
        ConnectivityState connectivityState = ConnectivityState.TRANSIENT_FAILURE;
        RoundRobinPicker roundRobinPicker = this.currentPicker;
        if (!(roundRobinPicker instanceof ReadyPicker)) {
            roundRobinPicker = new EmptyPicker(status);
        }
        updateBalancingState(connectivityState, roundRobinPicker);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [T, java.lang.Object, io.grpc.LoadBalancer$Subchannel] */
    @Override // io.grpc.LoadBalancer
    public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        String stickinessMetadataKeyFromServiceConfig;
        List<EquivalentAddressGroup> addresses = resolvedAddresses.getAddresses();
        Attributes attributes = resolvedAddresses.getAttributes();
        Set<EquivalentAddressGroup> keySet = this.subchannels.keySet();
        Set<EquivalentAddressGroup> stripAttrs = stripAttrs(addresses);
        Set<EquivalentAddressGroup> set = setsDifference(stripAttrs, keySet);
        Set set2 = setsDifference(keySet, stripAttrs);
        Map map = (Map) attributes.get(GrpcAttributes.NAME_RESOLVER_SERVICE_CONFIG);
        if (map != null && (stickinessMetadataKeyFromServiceConfig = ServiceConfigUtil.getStickinessMetadataKeyFromServiceConfig(map)) != null) {
            if (stickinessMetadataKeyFromServiceConfig.endsWith(Metadata.BINARY_HEADER_SUFFIX)) {
                this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.WARNING, "Binary stickiness header is not supported. The header \"{0}\" will be ignored", stickinessMetadataKeyFromServiceConfig);
            } else {
                StickinessState stickinessState = this.stickinessState;
                if (stickinessState == null || !stickinessState.a.name().equals(stickinessMetadataKeyFromServiceConfig)) {
                    this.stickinessState = new StickinessState(stickinessMetadataKeyFromServiceConfig);
                }
            }
        }
        for (EquivalentAddressGroup equivalentAddressGroup : set) {
            Attributes.Builder builder = Attributes.newBuilder().set(a, new Ref(ConnectivityStateInfo.forNonError(ConnectivityState.IDLE)));
            Ref ref = null;
            if (this.stickinessState != null) {
                Attributes.Key<Ref<LoadBalancer.Subchannel>> key = b;
                Ref ref2 = new Ref(null);
                builder.set(key, ref2);
                ref = ref2;
            }
            ?? r2 = (LoadBalancer.Subchannel) Preconditions.checkNotNull(this.helper.createSubchannel(equivalentAddressGroup, builder.build()), "subchannel");
            if (ref != null) {
                ref.a = r2;
            }
            this.subchannels.put(equivalentAddressGroup, r2);
            r2.requestConnection();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.subchannels.remove((EquivalentAddressGroup) it.next()));
        }
        updateBalancingState();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            shutdownSubchannel((LoadBalancer.Subchannel) it2.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.grpc.LoadBalancer
    public void handleSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
        StickinessState stickinessState;
        if (this.subchannels.get(subchannel.getAddresses()) != subchannel) {
            return;
        }
        if (connectivityStateInfo.getState() == ConnectivityState.SHUTDOWN && (stickinessState = this.stickinessState) != null) {
            stickinessState.a(subchannel);
        }
        if (connectivityStateInfo.getState() == ConnectivityState.IDLE) {
            subchannel.requestConnection();
        }
        getSubchannelStateInfoRef(subchannel).a = connectivityStateInfo;
        updateBalancingState();
    }

    @Override // io.grpc.LoadBalancer
    public void shutdown() {
        Iterator<LoadBalancer.Subchannel> it = a().iterator();
        while (it.hasNext()) {
            shutdownSubchannel(it.next());
        }
    }
}
