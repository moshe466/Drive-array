package y1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    int f15864a;

    /* renamed from: b, reason: collision with root package name */
    final Messenger f15865b;

    /* renamed from: c, reason: collision with root package name */
    s f15866c;

    /* renamed from: d, reason: collision with root package name */
    final Queue<u<?>> f15867d;

    /* renamed from: e, reason: collision with root package name */
    final SparseArray<u<?>> f15868e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ i f15869f;

    private j(i iVar) {
        this.f15869f = iVar;
        this.f15864a = 0;
        this.f15865b = new Messenger(new n2.e(Looper.getMainLooper(), new Handler.Callback(this) { // from class: y1.m

            /* renamed from: a, reason: collision with root package name */
            private final j f15871a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f15871a = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f15871a.d(message);
            }
        }));
        this.f15867d = new ArrayDeque();
        this.f15868e = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = this.f15869f.f15861b;
        scheduledExecutorService.execute(new Runnable(this) { // from class: y1.n

            /* renamed from: f, reason: collision with root package name */
            private final j f15872f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f15872f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                final u<?> poll;
                ScheduledExecutorService scheduledExecutorService2;
                Context context;
                final j jVar = this.f15872f;
                while (true) {
                    synchronized (jVar) {
                        if (jVar.f15864a != 2) {
                            return;
                        }
                        if (jVar.f15867d.isEmpty()) {
                            jVar.f();
                            return;
                        }
                        poll = jVar.f15867d.poll();
                        jVar.f15868e.put(poll.f15880a, poll);
                        scheduledExecutorService2 = jVar.f15869f.f15861b;
                        scheduledExecutorService2.schedule(new Runnable(jVar, poll) { // from class: y1.p

                            /* renamed from: f, reason: collision with root package name */
                            private final j f15875f;

                            /* renamed from: g, reason: collision with root package name */
                            private final u f15876g;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.f15875f = jVar;
                                this.f15876g = poll;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f15875f.b(this.f15876g.f15880a);
                            }
                        }, 30L, TimeUnit.SECONDS);
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String valueOf = String.valueOf(poll);
                        StringBuilder sb2 = new StringBuilder(valueOf.length() + 8);
                        sb2.append("Sending ");
                        sb2.append(valueOf);
                    }
                    context = jVar.f15869f.f15860a;
                    Messenger messenger = jVar.f15865b;
                    Message obtain = Message.obtain();
                    obtain.what = poll.f15882c;
                    obtain.arg1 = poll.f15880a;
                    obtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", poll.d());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", poll.f15883d);
                    obtain.setData(bundle);
                    try {
                        jVar.f15866c.a(obtain);
                    } catch (RemoteException e10) {
                        jVar.c(2, e10.getMessage());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void b(int i10) {
        u<?> uVar = this.f15868e.get(i10);
        if (uVar != null) {
            StringBuilder sb2 = new StringBuilder(31);
            sb2.append("Timing out request: ");
            sb2.append(i10);
            this.f15868e.remove(i10);
            uVar.c(new t(3, "Timed out waiting for response"));
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void c(int i10, String str) {
        Context context;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Disconnected: ".concat(valueOf);
            }
        }
        int i11 = this.f15864a;
        if (i11 == 0) {
            throw new IllegalStateException();
        }
        if (i11 != 1 && i11 != 2) {
            if (i11 == 3) {
                this.f15864a = 4;
                return;
            } else {
                if (i11 == 4) {
                    return;
                }
                int i12 = this.f15864a;
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown state: ");
                sb2.append(i12);
                throw new IllegalStateException(sb2.toString());
            }
        }
        Log.isLoggable("MessengerIpcClient", 2);
        this.f15864a = 4;
        f2.a b10 = f2.a.b();
        context = this.f15869f.f15860a;
        b10.c(context, this);
        t tVar = new t(i10, str);
        Iterator<u<?>> it = this.f15867d.iterator();
        while (it.hasNext()) {
            it.next().c(tVar);
        }
        this.f15867d.clear();
        for (int i13 = 0; i13 < this.f15868e.size(); i13++) {
            this.f15868e.valueAt(i13).c(tVar);
        }
        this.f15868e.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d(Message message) {
        int i10 = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb2 = new StringBuilder(41);
            sb2.append("Received response to request: ");
            sb2.append(i10);
        }
        synchronized (this) {
            u<?> uVar = this.f15868e.get(i10);
            if (uVar == null) {
                StringBuilder sb3 = new StringBuilder(50);
                sb3.append("Received response for unknown request: ");
                sb3.append(i10);
                return true;
            }
            this.f15868e.remove(i10);
            f();
            Bundle data = message.getData();
            if (data.getBoolean("unsupported", false)) {
                uVar.c(new t(4, "Not supported by GmsCore"));
            } else {
                uVar.a(data);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean e(u<?> uVar) {
        Context context;
        ScheduledExecutorService scheduledExecutorService;
        int i10 = this.f15864a;
        if (i10 == 0) {
            this.f15867d.add(uVar);
            b2.p.n(this.f15864a == 0);
            Log.isLoggable("MessengerIpcClient", 2);
            this.f15864a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            f2.a b10 = f2.a.b();
            context = this.f15869f.f15860a;
            if (b10.a(context, intent, this, 1)) {
                scheduledExecutorService = this.f15869f.f15861b;
                scheduledExecutorService.schedule(new Runnable(this) { // from class: y1.l

                    /* renamed from: f, reason: collision with root package name */
                    private final j f15870f;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f15870f = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f15870f.g();
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                c(0, "Unable to bind to service");
            }
            return true;
        }
        if (i10 == 1) {
            this.f15867d.add(uVar);
            return true;
        }
        if (i10 == 2) {
            this.f15867d.add(uVar);
            a();
            return true;
        }
        if (i10 != 3 && i10 != 4) {
            int i11 = this.f15864a;
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("Unknown state: ");
            sb2.append(i11);
            throw new IllegalStateException(sb2.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void f() {
        Context context;
        if (this.f15864a == 2 && this.f15867d.isEmpty() && this.f15868e.size() == 0) {
            Log.isLoggable("MessengerIpcClient", 2);
            this.f15864a = 3;
            f2.a b10 = f2.a.b();
            context = this.f15869f.f15860a;
            b10.c(context, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void g() {
        if (this.f15864a == 1) {
            c(1, "Timed out while binding");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = this.f15869f.f15861b;
        scheduledExecutorService.execute(new Runnable(this, iBinder) { // from class: y1.o

            /* renamed from: f, reason: collision with root package name */
            private final j f15873f;

            /* renamed from: g, reason: collision with root package name */
            private final IBinder f15874g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f15873f = this;
                this.f15874g = iBinder;
            }

            @Override // java.lang.Runnable
            public final void run() {
                j jVar = this.f15873f;
                IBinder iBinder2 = this.f15874g;
                synchronized (jVar) {
                    try {
                        if (iBinder2 == null) {
                            jVar.c(0, "Null service connection");
                            return;
                        }
                        try {
                            jVar.f15866c = new s(iBinder2);
                            jVar.f15864a = 2;
                            jVar.a();
                        } catch (RemoteException e10) {
                            jVar.c(0, e10.getMessage());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = this.f15869f.f15861b;
        scheduledExecutorService.execute(new Runnable(this) { // from class: y1.q

            /* renamed from: f, reason: collision with root package name */
            private final j f15877f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f15877f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f15877f.c(2, "Service disconnected");
            }
        });
    }
}
