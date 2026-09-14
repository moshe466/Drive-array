package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.ConnectivityState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: Access modifiers changed from: package-private */
@NotThreadSafe
/* loaded from: classes.dex */
public final class ConnectivityStateManager {
    private ArrayList<Listener> listeners = new ArrayList<>();
    private volatile ConnectivityState state = ConnectivityState.IDLE;

    /* loaded from: classes2.dex */
    private static final class Listener {
        final Runnable a;
        final Executor b;

        Listener(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.b = executor;
        }

        void a() {
            this.b.execute(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectivityState a() {
        ConnectivityState connectivityState = this.state;
        if (connectivityState != null) {
            return connectivityState;
        }
        throw new UnsupportedOperationException("Channel state API is not implemented");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@Nonnull ConnectivityState connectivityState) {
        Preconditions.checkNotNull(connectivityState, "newState");
        if (this.state == connectivityState || this.state == ConnectivityState.SHUTDOWN) {
            return;
        }
        this.state = connectivityState;
        if (this.listeners.isEmpty()) {
            return;
        }
        ArrayList<Listener> arrayList = this.listeners;
        this.listeners = new ArrayList<>();
        Iterator<Listener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Runnable runnable, Executor executor, ConnectivityState connectivityState) {
        Preconditions.checkNotNull(runnable, "callback");
        Preconditions.checkNotNull(executor, "executor");
        Preconditions.checkNotNull(connectivityState, FirebaseAnalytics.Param.SOURCE);
        Listener listener = new Listener(runnable, executor);
        if (this.state != connectivityState) {
            listener.a();
        } else {
            this.listeners.add(listener);
        }
    }
}
