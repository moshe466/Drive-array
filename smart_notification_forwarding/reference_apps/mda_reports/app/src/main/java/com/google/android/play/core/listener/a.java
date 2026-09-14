package com.google.android.play.core.listener;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.internal.ag;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class a<StateT> {
    protected final com.google.android.play.core.splitcompat.a a;
    private final IntentFilter b;
    private final Context c;
    private final Set<StateUpdatedListener<StateT>> d = new HashSet();
    private b e = null;
    private volatile boolean f = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(com.google.android.play.core.splitcompat.a aVar, IntentFilter intentFilter, Context context) {
        this.a = aVar;
        this.b = intentFilter;
        this.c = ag.a(context);
    }

    private final void a() {
        b bVar;
        if ((this.f || !this.d.isEmpty()) && this.e == null) {
            this.e = new b(this, (byte) 0);
            this.c.registerReceiver(this.e, this.b);
        }
        if (this.f || !this.d.isEmpty() || (bVar = this.e) == null) {
            return;
        }
        this.c.unregisterReceiver(bVar);
        this.e = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(Context context, Intent intent);

    public final synchronized void a(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.a.a("registerListener", new Object[0]);
        this.d.add(stateUpdatedListener);
        a();
    }

    public final synchronized void a(StateT statet) {
        Iterator it = new HashSet(this.d).iterator();
        while (it.hasNext()) {
            ((StateUpdatedListener) it.next()).onStateUpdate(statet);
        }
    }

    public final synchronized void a(boolean z) {
        this.f = true;
        a();
    }

    public final synchronized void b(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.a.a("unregisterListener", new Object[0]);
        this.d.remove(stateUpdatedListener);
        a();
    }
}
