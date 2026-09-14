package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
class ConfigurableValueGraph<N, V> extends AbstractValueGraph<N, V> {
    protected final MapIteratorCache<N, GraphConnections<N, V>> a;
    private final boolean allowsSelfLoops;
    protected long b;
    private final boolean isDirected;
    private final ElementOrder<N> nodeOrder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConfigurableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this(abstractGraphBuilder, abstractGraphBuilder.c.a(abstractGraphBuilder.d.or((Optional<Integer>) 10).intValue()), 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConfigurableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder, Map<N, GraphConnections<N, V>> map, long j) {
        this.isDirected = abstractGraphBuilder.a;
        this.allowsSelfLoops = abstractGraphBuilder.b;
        this.nodeOrder = (ElementOrder<N>) abstractGraphBuilder.c.a();
        this.a = map instanceof TreeMap ? new MapRetrievalCache<>(map) : new MapIteratorCache<>(map);
        Graphs.a(j);
        this.b = j;
    }

    @Override // com.google.common.graph.AbstractBaseGraph
    protected long a() {
        return this.b;
    }

    protected final GraphConnections<N, V> a(N n) {
        GraphConnections<N, V> graphConnections = this.a.get(n);
        if (graphConnections != null) {
            return graphConnections;
        }
        Preconditions.checkNotNull(n);
        throw new IllegalArgumentException("Node " + n + " is not an element of this graph.");
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> adjacentNodes(N n) {
        return a(n).adjacentNodes();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b(@NullableDecl N n) {
        return this.a.containsKey(n);
    }

    @Override // com.google.common.graph.ValueGraph
    @NullableDecl
    public V edgeValueOrDefault(N n, N n2, @NullableDecl V v) {
        Preconditions.checkNotNull(n);
        Preconditions.checkNotNull(n2);
        GraphConnections<N, V> graphConnections = this.a.get(n);
        V value = graphConnections == null ? null : graphConnections.value(n2);
        return value == null ? v : value;
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N n, N n2) {
        Preconditions.checkNotNull(n);
        Preconditions.checkNotNull(n2);
        GraphConnections<N, V> graphConnections = this.a.get(n);
        return graphConnections != null && graphConnections.successors().contains(n2);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean isDirected() {
        return this.isDirected;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> nodes() {
        return this.a.unmodifiableKeySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors((ConfigurableValueGraph<N, V>) obj);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N n) {
        return a(n).predecessors();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors((ConfigurableValueGraph<N, V>) obj);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N n) {
        return a(n).successors();
    }
}
