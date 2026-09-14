package b2;

import a2.f;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class i0 implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private final h0 f4005a;

    /* renamed from: h, reason: collision with root package name */
    private final Handler f4012h;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList f4006b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList f4007c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList f4008d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f4009e = false;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicInteger f4010f = new AtomicInteger(0);

    /* renamed from: g, reason: collision with root package name */
    private boolean f4011g = false;

    /* renamed from: i, reason: collision with root package name */
    private final Object f4013i = new Object();

    public i0(Looper looper, h0 h0Var) {
        this.f4005a = h0Var;
        this.f4012h = new m2.n(looper, this);
    }

    public final void a() {
        this.f4009e = false;
        this.f4010f.incrementAndGet();
    }

    public final void b() {
        this.f4009e = true;
    }

    public final void c(com.google.android.gms.common.a aVar) {
        p.e(this.f4012h, "onConnectionFailure must only be called on the Handler thread");
        this.f4012h.removeMessages(1);
        synchronized (this.f4013i) {
            ArrayList arrayList = new ArrayList(this.f4008d);
            int i10 = this.f4010f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                f.c cVar = (f.c) it.next();
                if (this.f4009e && this.f4010f.get() == i10) {
                    if (this.f4008d.contains(cVar)) {
                        cVar.n(aVar);
                    }
                }
                return;
            }
        }
    }

    public final void d(Bundle bundle) {
        p.e(this.f4012h, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f4013i) {
            p.n(!this.f4011g);
            this.f4012h.removeMessages(1);
            this.f4011g = true;
            p.n(this.f4007c.isEmpty());
            ArrayList arrayList = new ArrayList(this.f4006b);
            int i10 = this.f4010f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                f.b bVar = (f.b) it.next();
                if (!this.f4009e || !this.f4005a.a() || this.f4010f.get() != i10) {
                    break;
                } else if (!this.f4007c.contains(bVar)) {
                    bVar.p(bundle);
                }
            }
            this.f4007c.clear();
            this.f4011g = false;
        }
    }

    public final void e(int i10) {
        p.e(this.f4012h, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f4012h.removeMessages(1);
        synchronized (this.f4013i) {
            this.f4011g = true;
            ArrayList arrayList = new ArrayList(this.f4006b);
            int i11 = this.f4010f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                f.b bVar = (f.b) it.next();
                if (!this.f4009e || this.f4010f.get() != i11) {
                    break;
                } else if (this.f4006b.contains(bVar)) {
                    bVar.i(i10);
                }
            }
            this.f4007c.clear();
            this.f4011g = false;
        }
    }

    public final void f(f.b bVar) {
        p.k(bVar);
        synchronized (this.f4013i) {
            if (this.f4006b.contains(bVar)) {
                String valueOf = String.valueOf(bVar);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("registerConnectionCallbacks(): listener ");
                sb2.append(valueOf);
                sb2.append(" is already registered");
            } else {
                this.f4006b.add(bVar);
            }
        }
        if (this.f4005a.a()) {
            Handler handler = this.f4012h;
            handler.sendMessage(handler.obtainMessage(1, bVar));
        }
    }

    public final void g(f.c cVar) {
        p.k(cVar);
        synchronized (this.f4013i) {
            if (this.f4008d.contains(cVar)) {
                String valueOf = String.valueOf(cVar);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("registerConnectionFailedListener(): listener ");
                sb2.append(valueOf);
                sb2.append(" is already registered");
            } else {
                this.f4008d.add(cVar);
            }
        }
    }

    public final void h(f.c cVar) {
        p.k(cVar);
        synchronized (this.f4013i) {
            if (!this.f4008d.remove(cVar)) {
                String valueOf = String.valueOf(cVar);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unregisterConnectionFailedListener(): listener ");
                sb2.append(valueOf);
                sb2.append(" not found");
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 1) {
            Log.wtf("GmsClientEvents", "Don't know how to handle message: " + i10, new Exception());
            return false;
        }
        f.b bVar = (f.b) message.obj;
        synchronized (this.f4013i) {
            if (this.f4009e && this.f4005a.a() && this.f4006b.contains(bVar)) {
                bVar.p(null);
            }
        }
        return true;
    }
}
