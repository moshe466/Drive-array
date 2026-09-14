package com.google.common.graph;

import com.google.common.base.Optional;

/* loaded from: classes2.dex */
abstract class AbstractGraphBuilder<N> {
    final boolean a;
    boolean b = false;
    ElementOrder<N> c = ElementOrder.insertion();
    Optional<Integer> d = Optional.absent();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractGraphBuilder(boolean z) {
        this.a = z;
    }
}
