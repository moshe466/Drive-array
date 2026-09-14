package com.google.android.play.core.internal;

import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class q<StateT> {
    private final Set<StateUpdatedListener<StateT>> a = new HashSet();

    public final synchronized void a(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.a.add(stateUpdatedListener);
    }

    public final synchronized void a(StateT statet) {
        Iterator<StateUpdatedListener<StateT>> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onStateUpdate(statet);
        }
    }

    public final synchronized void b(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.a.remove(stateUpdatedListener);
    }
}
