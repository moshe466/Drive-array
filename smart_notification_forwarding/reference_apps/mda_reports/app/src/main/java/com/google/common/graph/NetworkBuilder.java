package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

@Beta
/* loaded from: classes2.dex */
public final class NetworkBuilder<N, E> extends AbstractGraphBuilder<N> {
    boolean e;
    ElementOrder<? super E> f;
    Optional<Integer> g;

    private NetworkBuilder(boolean z) {
        super(z);
        this.e = false;
        this.f = ElementOrder.insertion();
        this.g = Optional.absent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N1 extends N, E1 extends E> NetworkBuilder<N1, E1> cast() {
        return this;
    }

    public static NetworkBuilder<Object, Object> directed() {
        return new NetworkBuilder<>(true);
    }

    public static <N, E> NetworkBuilder<N, E> from(Network<N, E> network) {
        return new NetworkBuilder(network.isDirected()).allowsParallelEdges(network.allowsParallelEdges()).allowsSelfLoops(network.allowsSelfLoops()).nodeOrder(network.nodeOrder()).edgeOrder(network.edgeOrder());
    }

    public static NetworkBuilder<Object, Object> undirected() {
        return new NetworkBuilder<>(false);
    }

    public NetworkBuilder<N, E> allowsParallelEdges(boolean z) {
        this.e = z;
        return this;
    }

    public NetworkBuilder<N, E> allowsSelfLoops(boolean z) {
        this.b = z;
        return this;
    }

    public <N1 extends N, E1 extends E> MutableNetwork<N1, E1> build() {
        return new ConfigurableMutableNetwork(this);
    }

    public <E1 extends E> NetworkBuilder<N, E1> edgeOrder(ElementOrder<E1> elementOrder) {
        NetworkBuilder<N, E1> networkBuilder = (NetworkBuilder<N, E1>) cast();
        networkBuilder.f = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return networkBuilder;
    }

    public NetworkBuilder<N, E> expectedEdgeCount(int i) {
        Graphs.a(i);
        this.g = Optional.of(Integer.valueOf(i));
        return this;
    }

    public NetworkBuilder<N, E> expectedNodeCount(int i) {
        Graphs.a(i);
        this.d = Optional.of(Integer.valueOf(i));
        return this;
    }

    public <N1 extends N> NetworkBuilder<N1, E> nodeOrder(ElementOrder<N1> elementOrder) {
        NetworkBuilder<N1, E> networkBuilder = (NetworkBuilder<N1, E>) cast();
        networkBuilder.c = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return networkBuilder;
    }
}
