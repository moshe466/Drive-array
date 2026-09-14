package com.google.common.graph;

import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class ForwardingNetwork<N, E> extends AbstractNetwork<N, E> {
    protected abstract Network<N, E> a();

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> adjacentEdges(E e) {
        return a().adjacentEdges(e);
    }

    @Override // com.google.common.graph.Network
    public Set<N> adjacentNodes(N n) {
        return a().adjacentNodes(n);
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return a().allowsParallelEdges();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return a().allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int degree(N n) {
        return a().degree(n);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public E edgeConnectingOrNull(N n, N n2) {
        return a().edgeConnectingOrNull(n, n2);
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<E> edgeOrder() {
        return a().edgeOrder();
    }

    @Override // com.google.common.graph.Network
    public Set<E> edges() {
        return a().edges();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(N n, N n2) {
        return a().edgesConnecting(n, n2);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public boolean hasEdgeConnecting(N n, N n2) {
        return a().hasEdgeConnecting(n, n2);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int inDegree(N n) {
        return a().inDegree(n);
    }

    @Override // com.google.common.graph.Network
    public Set<E> inEdges(N n) {
        return a().inEdges(n);
    }

    @Override // com.google.common.graph.Network
    public Set<E> incidentEdges(N n) {
        return a().incidentEdges(n);
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> incidentNodes(E e) {
        return a().incidentNodes(e);
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return a().isDirected();
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> nodeOrder() {
        return a().nodeOrder();
    }

    @Override // com.google.common.graph.Network
    public Set<N> nodes() {
        return a().nodes();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int outDegree(N n) {
        return a().outDegree(n);
    }

    @Override // com.google.common.graph.Network
    public Set<E> outEdges(N n) {
        return a().outEdges(n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors((ForwardingNetwork<N, E>) obj);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N n) {
        return a().predecessors((Network<N, E>) n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors((ForwardingNetwork<N, E>) obj);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N n) {
        return a().successors((Network<N, E>) n);
    }
}
