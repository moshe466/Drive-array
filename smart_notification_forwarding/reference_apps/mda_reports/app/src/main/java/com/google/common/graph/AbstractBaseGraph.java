package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class AbstractBaseGraph<N> implements BaseGraph<N> {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class IncidentEdgeSet<N> extends AbstractSet<EndpointPair<N>> {
        protected final N a;
        protected final BaseGraph<N> b;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class Directed<N> extends IncidentEdgeSet<N> {
            private Directed(BaseGraph<N> baseGraph, N n) {
                super(baseGraph, n);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (!endpointPair.isOrdered()) {
                    return false;
                }
                Object source = endpointPair.source();
                Object target = endpointPair.target();
                return (this.a.equals(source) && this.b.successors((BaseGraph<N>) this.a).contains(target)) || (this.a.equals(target) && this.b.predecessors((BaseGraph<N>) this.a).contains(source));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(this.b.predecessors((BaseGraph<N>) this.a).iterator(), new Function<N, EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Directed.1
                    @Override // com.google.common.base.Function
                    public EndpointPair<N> apply(N n) {
                        return EndpointPair.ordered(n, Directed.this.a);
                    }

                    @Override // com.google.common.base.Function
                    public /* bridge */ /* synthetic */ Object apply(Object obj) {
                        return apply((AnonymousClass1) obj);
                    }
                }), Iterators.transform(Sets.difference(this.b.successors((BaseGraph<N>) this.a), ImmutableSet.of(this.a)).iterator(), new Function<N, EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Directed.2
                    @Override // com.google.common.base.Function
                    public EndpointPair<N> apply(N n) {
                        return EndpointPair.ordered(Directed.this.a, n);
                    }

                    @Override // com.google.common.base.Function
                    public /* bridge */ /* synthetic */ Object apply(Object obj) {
                        return apply((AnonymousClass2) obj);
                    }
                })));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return (this.b.inDegree(this.a) + this.b.outDegree(this.a)) - (this.b.successors((BaseGraph<N>) this.a).contains(this.a) ? 1 : 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class Undirected<N> extends IncidentEdgeSet<N> {
            private Undirected(BaseGraph<N> baseGraph, N n) {
                super(baseGraph, n);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (endpointPair.isOrdered()) {
                    return false;
                }
                Set<N> adjacentNodes = this.b.adjacentNodes(this.a);
                Object nodeU = endpointPair.nodeU();
                Object nodeV = endpointPair.nodeV();
                return (this.a.equals(nodeV) && adjacentNodes.contains(nodeU)) || (this.a.equals(nodeU) && adjacentNodes.contains(nodeV));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return Iterators.unmodifiableIterator(Iterators.transform(this.b.adjacentNodes(this.a).iterator(), new Function<N, EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Undirected.1
                    @Override // com.google.common.base.Function
                    public EndpointPair<N> apply(N n) {
                        return EndpointPair.unordered(Undirected.this.a, n);
                    }

                    @Override // com.google.common.base.Function
                    public /* bridge */ /* synthetic */ Object apply(Object obj) {
                        return apply((AnonymousClass1) obj);
                    }
                }));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.b.adjacentNodes(this.a).size();
            }
        }

        private IncidentEdgeSet(BaseGraph<N> baseGraph, N n) {
            this.b = baseGraph;
            this.a = n;
        }

        public static <N> IncidentEdgeSet<N> of(BaseGraph<N> baseGraph, N n) {
            return baseGraph.isDirected() ? new Directed(baseGraph, n) : new Undirected(baseGraph, n);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    protected long a() {
        long j = 0;
        while (nodes().iterator().hasNext()) {
            j += degree(r0.next());
        }
        Preconditions.checkState((1 & j) == 0);
        return j >>> 1;
    }

    @Override // com.google.common.graph.BaseGraph
    public int degree(N n) {
        int i;
        int size;
        if (isDirected()) {
            size = predecessors((AbstractBaseGraph<N>) n).size();
            i = successors((AbstractBaseGraph<N>) n).size();
        } else {
            Set<N> adjacentNodes = adjacentNodes(n);
            i = (allowsSelfLoops() && adjacentNodes.contains(n)) ? 1 : 0;
            size = adjacentNodes.size();
        }
        return IntMath.saturatedAdd(size, i);
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> edges() {
        return new AbstractSet<EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                return AbstractBaseGraph.this.isDirected() == endpointPair.isOrdered() && AbstractBaseGraph.this.nodes().contains(endpointPair.nodeU()) && AbstractBaseGraph.this.successors((AbstractBaseGraph) endpointPair.nodeU()).contains(endpointPair.nodeV());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return EndpointPairIterator.a(AbstractBaseGraph.this);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return Ints.saturatedCast(AbstractBaseGraph.this.a());
            }
        };
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N n, N n2) {
        Preconditions.checkNotNull(n);
        Preconditions.checkNotNull(n2);
        return nodes().contains(n) && successors((AbstractBaseGraph<N>) n).contains(n2);
    }

    @Override // com.google.common.graph.BaseGraph
    public int inDegree(N n) {
        return isDirected() ? predecessors((AbstractBaseGraph<N>) n).size() : degree(n);
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> incidentEdges(N n) {
        Preconditions.checkNotNull(n);
        Preconditions.checkArgument(nodes().contains(n), "Node %s is not an element of this graph.", n);
        return IncidentEdgeSet.of((BaseGraph) this, (Object) n);
    }

    @Override // com.google.common.graph.BaseGraph
    public int outDegree(N n) {
        return isDirected() ? successors((AbstractBaseGraph<N>) n).size() : degree(n);
    }
}
