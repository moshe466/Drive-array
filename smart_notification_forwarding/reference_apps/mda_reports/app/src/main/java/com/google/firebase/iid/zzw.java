package com.google.firebase.iid;

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
import androidx.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzw implements ServiceConnection {

    @GuardedBy("this")
    int a;
    final Messenger b;
    zzaf c;

    @GuardedBy("this")
    final Queue<zzah<?>> d;

    @GuardedBy("this")
    final SparseArray<zzah<?>> e;
    final /* synthetic */ zzv f;

    private zzw(zzv zzvVar) {
        this.f = zzvVar;
        this.a = 0;
        this.b = new Messenger(new com.google.android.gms.internal.firebase_messaging.zze(Looper.getMainLooper(), new Handler.Callback(this) { // from class: com.google.firebase.iid.zzz
            private final zzw zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.zza.a(message);
            }
        }));
        this.d = new ArrayDeque();
        this.e = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = this.f.zzc;
        scheduledExecutorService.execute(new Runnable(this) { // from class: com.google.firebase.iid.zzaa
            private final zzw zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                final zzah<?> poll;
                ScheduledExecutorService scheduledExecutorService2;
                Context context;
                final zzw zzwVar = this.zza;
                while (true) {
                    synchronized (zzwVar) {
                        if (zzwVar.a != 2) {
                            return;
                        }
                        if (zzwVar.d.isEmpty()) {
                            zzwVar.b();
                            return;
                        }
                        poll = zzwVar.d.poll();
                        zzwVar.e.put(poll.a, poll);
                        scheduledExecutorService2 = zzwVar.f.zzc;
                        scheduledExecutorService2.schedule(new Runnable(zzwVar, poll) { // from class: com.google.firebase.iid.zzac
                            private final zzw zza;
                            private final zzah zzb;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.zza = zzwVar;
                                this.zzb = poll;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.a(this.zzb.a);
                            }
                        }, 30L, TimeUnit.SECONDS);
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String valueOf = String.valueOf(poll);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
                        sb.append("Sending ");
                        sb.append(valueOf);
                        Log.d("MessengerIpcClient", sb.toString());
                    }
                    context = zzwVar.f.zzb;
                    Messenger messenger = zzwVar.b;
                    Message obtain = Message.obtain();
                    obtain.what = poll.c;
                    obtain.arg1 = poll.a;
                    obtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", poll.a());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", poll.d);
                    obtain.setData(bundle);
                    try {
                        zzwVar.c.a(obtain);
                    } catch (RemoteException e) {
                        zzwVar.a(2, e.getMessage());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a(int i) {
        zzah<?> zzahVar = this.e.get(i);
        if (zzahVar != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i);
            Log.w("MessengerIpcClient", sb.toString());
            this.e.remove(i);
            zzahVar.a(new zzag(3, "Timed out waiting for response"));
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a(int i, String str) {
        Context context;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        int i2 = this.a;
        if (i2 == 0) {
            throw new IllegalStateException();
        }
        if (i2 != 1 && i2 != 2) {
            if (i2 == 3) {
                this.a = 4;
                return;
            } else {
                if (i2 == 4) {
                    return;
                }
                int i3 = this.a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
            }
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Unbinding service");
        }
        this.a = 4;
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        context = this.f.zzb;
        connectionTracker.unbindService(context, this);
        zzag zzagVar = new zzag(i, str);
        Iterator<zzah<?>> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a(zzagVar);
        }
        this.d.clear();
        for (int i4 = 0; i4 < this.e.size(); i4++) {
            this.e.valueAt(i4).a(zzagVar);
        }
        this.e.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(Message message) {
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(i);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (this) {
            zzah<?> zzahVar = this.e.get(i);
            if (zzahVar == null) {
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Received response for unknown request: ");
                sb2.append(i);
                Log.w("MessengerIpcClient", sb2.toString());
                return true;
            }
            this.e.remove(i);
            b();
            Bundle data = message.getData();
            if (data.getBoolean("unsupported", false)) {
                zzahVar.a(new zzag(4, "Not supported by GmsCore"));
            } else {
                zzahVar.a(data);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean a(zzah<?> zzahVar) {
        Context context;
        ScheduledExecutorService scheduledExecutorService;
        int i = this.a;
        if (i == 0) {
            this.d.add(zzahVar);
            Preconditions.checkState(this.a == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
            context = this.f.zzb;
            if (connectionTracker.bindService(context, intent, this, 1)) {
                scheduledExecutorService = this.f.zzc;
                scheduledExecutorService.schedule(new Runnable(this) { // from class: com.google.firebase.iid.zzy
                    private final zzw zza;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zza = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.c();
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                a(0, "Unable to bind to service");
            }
            return true;
        }
        if (i == 1) {
            this.d.add(zzahVar);
            return true;
        }
        if (i == 2) {
            this.d.add(zzahVar);
            a();
            return true;
        }
        if (i != 3 && i != 4) {
            int i2 = this.a;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i2);
            throw new IllegalStateException(sb.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void b() {
        Context context;
        if (this.a == 2 && this.d.isEmpty() && this.e.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.a = 3;
            ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
            context = this.f.zzb;
            connectionTracker.unbindService(context, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void c() {
        if (this.a == 1) {
            a(1, "Timed out while binding");
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        ScheduledExecutorService scheduledExecutorService;
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        scheduledExecutorService = this.f.zzc;
        scheduledExecutorService.execute(new Runnable(this, iBinder) { // from class: com.google.firebase.iid.zzab
            private final zzw zza;
            private final IBinder zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = iBinder;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzw zzwVar = this.zza;
                IBinder iBinder2 = this.zzb;
                synchronized (zzwVar) {
                    try {
                        if (iBinder2 == null) {
                            zzwVar.a(0, "Null service connection");
                            return;
                        }
                        try {
                            zzwVar.c = new zzaf(iBinder2);
                            zzwVar.a = 2;
                            zzwVar.a();
                        } catch (RemoteException e) {
                            zzwVar.a(0, e.getMessage());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        ScheduledExecutorService scheduledExecutorService;
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        scheduledExecutorService = this.f.zzc;
        scheduledExecutorService.execute(new Runnable(this) { // from class: com.google.firebase.iid.zzad
            private final zzw zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.a(2, "Service disconnected");
            }
        });
    }
}
