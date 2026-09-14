package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class EndpointPairIterator<N> extends AbstractIterator<EndpointPair<N>> {
    protected N a;
    protected Iterator<N> b;
    private final BaseGraph<N> graph;
    private final Iterator<N> nodeIterator;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Directed<N> extends EndpointPairIterator<N> {
        private Directed(BaseGraph<N> baseGraph) {
            super(baseGraph);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        public EndpointPair<N> computeNext() {
            while (!this.b.hasNext()) {
                if (!b()) {
                    return a();
                }
            }
            return EndpointPair.ordered(this.a, this.b.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Undirected<N> extends EndpointPairIterator<N> {
        private Set<N> visitedNodes;

        private Undirected(BaseGraph<N> baseGraph) {
            super(baseGraph);
            this.visitedNodes = Sets.newHashSetWithExpectedSize(baseGraph.nodes().size());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        public EndpointPair<N> computeNext() {
            while (true) {
                if (this.b.hasNext()) {
                    N next = this.b.next();
                    if (!this.visitedNodes.contains(next)) {
                        return EndpointPair.unordered(this.a, next);
                    }
                } else {
                    this.visitedNodes.add(this.a);
                    if (!b()) {
                        this.visitedNodes = null;
                        return a();
                    }
                }
            }
        }
    }

    private EndpointPairIterator(BaseGraph<N> baseGraph) {
        this.a = null;
        this.b = ImmutableSet.of().iterator();
        this.graph = baseGraph;
        this.nodeIterator = baseGraph.nodes().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <N> EndpointPairIterator<N> a(BaseGraph<N> baseGraph) {
        return baseGraph.isDirected() ? new Directed(baseGraph) : new Undirected(baseGraph);
    }

    protected final boolean b() {
        Preconditions.checkState(!this.b.hasNext());
        if (!this.nodeIterator.hasNext()) {
            return false;
        }
        this.a = this.nodeIterator.next();
        this.b = this.graph.successors((BaseGraph<N>) this.a).iterator();
        return true;
    }
}
