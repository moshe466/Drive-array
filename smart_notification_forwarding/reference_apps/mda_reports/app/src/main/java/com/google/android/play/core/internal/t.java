package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class t<T extends IInterface> {
    private static final Map<String, Handler> a = Collections.synchronizedMap(new HashMap());
    private final Context b;
    private final com.google.android.play.core.splitcompat.a c;
    private final String d;
    private final List<r> e;
    private boolean f;
    private final Intent g;
    private final w<T> h;
    private final WeakReference<x> i;
    private final IBinder.DeathRecipient j;
    private ServiceConnection k;
    private T l;

    public t(Context context, com.google.android.play.core.splitcompat.a aVar, String str, Intent intent, w<T> wVar) {
        this(context, aVar, str, intent, wVar, null);
    }

    private t(Context context, com.google.android.play.core.splitcompat.a aVar, String str, Intent intent, w<T> wVar, x xVar) {
        this.e = new ArrayList();
        this.j = new IBinder.DeathRecipient(this) { // from class: com.google.android.play.core.internal.s
            private final t a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                this.a.c();
            }
        };
        this.b = context;
        this.c = aVar;
        this.d = str;
        this.g = intent;
        this.h = wVar;
        this.i = new WeakReference<>(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ServiceConnection a(t tVar, ServiceConnection serviceConnection) {
        tVar.k = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(t tVar, boolean z) {
        tVar.f = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(r rVar) {
        byte b = 0;
        if (this.l != null || this.f) {
            if (!this.f) {
                rVar.run();
                return;
            } else {
                this.c.a("Waiting to bind to the service.", new Object[0]);
                this.e.add(rVar);
                return;
            }
        }
        this.c.a("Initiate binding to the service.", new Object[0]);
        this.e.add(rVar);
        this.k = new z(this, b);
        this.f = true;
        if (this.b.bindService(this.g, this.k, 1)) {
            return;
        }
        this.c.a("Failed to bind to the service.", new Object[0]);
        this.f = false;
        Iterator<r> it = this.e.iterator();
        while (it.hasNext()) {
            com.google.android.play.core.tasks.h<?> b2 = it.next().b();
            if (b2 != null) {
                b2.a((Exception) new aa());
            }
        }
        this.e.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(r rVar) {
        d().post(rVar);
    }

    private final Handler d() {
        Handler handler;
        synchronized (a) {
            if (!a.containsKey(this.d)) {
                HandlerThread handlerThread = new HandlerThread(this.d, 10);
                handlerThread.start();
                a.put(this.d, new Handler(handlerThread.getLooper()));
            }
            handler = a.get(this.d);
        }
        return handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        this.c.a("linkToDeath", new Object[0]);
        try {
            this.l.asBinder().linkToDeath(this.j, 0);
        } catch (RemoteException e) {
            this.c.a(e, "linkToDeath failed", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        this.c.a("unlinkToDeath", new Object[0]);
        this.l.asBinder().unlinkToDeath(this.j, 0);
    }

    public final void a() {
        c(new u(this));
    }

    public final void a(r rVar) {
        c(new v(this, rVar.b(), rVar));
    }

    public final T b() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        this.c.a("reportBinderDeath", new Object[0]);
        x xVar = this.i.get();
        if (xVar != null) {
            this.c.a("calling onBinderDied", new Object[0]);
            xVar.a();
            return;
        }
        this.c.a("%s : Binder has died.", this.d);
        Iterator<r> it = this.e.iterator();
        while (it.hasNext()) {
            com.google.android.play.core.tasks.h<?> b = it.next().b();
            if (b != null) {
                b.a((Exception) (Build.VERSION.SDK_INT < 15 ? new RemoteException() : new RemoteException(String.valueOf(this.d).concat(" : Binder has died."))));
            }
        }
        this.e.clear();
    }
}
