package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
class ConfigurableNetwork<N, E> extends AbstractNetwork<N, E> {
    protected final MapIteratorCache<N, NetworkConnections<N, E>> a;
    private final boolean allowsParallelEdges;
    private final boolean allowsSelfLoops;
    protected final MapIteratorCache<E, N> b;
    private final ElementOrder<E> edgeOrder;
    private final boolean isDirected;
    private final ElementOrder<N> nodeOrder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConfigurableNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        this(networkBuilder, networkBuilder.c.a(networkBuilder.d.or((Optional<Integer>) 10).intValue()), networkBuilder.f.a(networkBuilder.g.or((Optional<Integer>) 20).intValue()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConfigurableNetwork(NetworkBuilder<? super N, ? super E> networkBuilder, Map<N, NetworkConnections<N, E>> map, Map<E, N> map2) {
        this.isDirected = networkBuilder.a;
        this.allowsParallelEdges = networkBuilder.e;
        this.allowsSelfLoops = networkBuilder.b;
        this.nodeOrder = (ElementOrder<N>) networkBuilder.c.a();
        this.edgeOrder = (ElementOrder<E>) networkBuilder.f.a();
        this.a = map instanceof TreeMap ? new MapRetrievalCache<>(map) : new MapIteratorCache<>(map);
        this.b = new MapIteratorCache<>(map2);
    }

    protected final NetworkConnections<N, E> a(N n) {
        NetworkConnections<N, E> networkConnections = this.a.get(n);
        if (networkConnections != null) {
            return networkConnections;
        }
        Preconditions.checkNotNull(n);
        throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", n));
    }

    @Override // com.google.common.graph.Network
    public Set<N> adjacentNodes(N n) {
        return a(n).adjacentNodes();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return this.allowsParallelEdges;
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    protected final N b(E e) {
        N n = this.b.get(e);
        if (n != null) {
            return n;
        }
        Preconditions.checkNotNull(e);
        throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", e));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean c(@NullableDecl E e) {
        return this.b.containsKey(e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean d(@NullableDecl N n) {
        return this.a.containsKey(n);
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<E> edgeOrder() {
        return this.edgeOrder;
    }

    @Override // com.google.common.graph.Network
    public Set<E> edges() {
        return this.b.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(N n, N n2) {
        NetworkConnections<N, E> a = a(n);
        if (!this.allowsSelfLoops && n == n2) {
            return ImmutableSet.of();
        }
        Preconditions.checkArgument(d(n2), "Node %s is not an element of this graph.", n2);
        return a.edgesConnecting(n2);
    }

    @Override // com.google.common.graph.Network
    public Set<E> inEdges(N n) {
        return a(n).inEdges();
    }

    @Override // com.google.common.graph.Network
    public Set<E> incidentEdges(N n) {
        return a(n).incidentEdges();
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> incidentNodes(E e) {
        N b = b(e);
        return EndpointPair.a(this, b, this.a.get(b).adjacentNode(e));
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return this.isDirected;
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    @Override // com.google.common.graph.Network
    public Set<N> nodes() {
        return this.a.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.Network
    public Set<E> outEdges(N n) {
        return a(n).outEdges();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors((ConfigurableNetwork<N, E>) obj);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N n) {
        return a(n).predecessors();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors((ConfigurableNetwork<N, E>) obj);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N n) {
        return a(n).successors();
    }
}
