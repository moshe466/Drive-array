package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class g implements Handler.Callback {

    /* renamed from: r, reason: collision with root package name */
    public static final Status f4839r = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* renamed from: s, reason: collision with root package name */
    private static final Status f4840s = new Status(4, "The user must be signed in to make this API call.");

    /* renamed from: t, reason: collision with root package name */
    private static final Object f4841t = new Object();

    /* renamed from: u, reason: collision with root package name */
    private static g f4842u;

    /* renamed from: e, reason: collision with root package name */
    private b2.t f4847e;

    /* renamed from: f, reason: collision with root package name */
    private com.google.android.gms.common.internal.a f4848f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f4849g;

    /* renamed from: h, reason: collision with root package name */
    private final com.google.android.gms.common.b f4850h;

    /* renamed from: i, reason: collision with root package name */
    private final b2.j0 f4851i;

    /* renamed from: p, reason: collision with root package name */
    private final Handler f4858p;

    /* renamed from: q, reason: collision with root package name */
    private volatile boolean f4859q;

    /* renamed from: a, reason: collision with root package name */
    private long f4843a = 5000;

    /* renamed from: b, reason: collision with root package name */
    private long f4844b = 120000;

    /* renamed from: c, reason: collision with root package name */
    private long f4845c = 10000;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4846d = false;

    /* renamed from: j, reason: collision with root package name */
    private final AtomicInteger f4852j = new AtomicInteger(1);

    /* renamed from: k, reason: collision with root package name */
    private final AtomicInteger f4853k = new AtomicInteger(0);

    /* renamed from: l, reason: collision with root package name */
    private final Map f4854l = new ConcurrentHashMap(5, 0.75f, 1);

    /* renamed from: m, reason: collision with root package name */
    private c0 f4855m = null;

    /* renamed from: n, reason: collision with root package name */
    private final Set f4856n = new l.b();

    /* renamed from: o, reason: collision with root package name */
    private final Set f4857o = new l.b();

    private g(Context context, Looper looper, com.google.android.gms.common.b bVar) {
        this.f4859q = true;
        this.f4849g = context;
        m2.n nVar = new m2.n(looper, this);
        this.f4858p = nVar;
        this.f4850h = bVar;
        this.f4851i = new b2.j0(bVar);
        if (g2.i.a(context)) {
            this.f4859q = false;
        }
        nVar.sendMessage(nVar.obtainMessage(6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status h(b bVar, com.google.android.gms.common.a aVar) {
        return new Status(aVar, "API: " + bVar.b() + " is not available on this device. Connection failed with: " + String.valueOf(aVar));
    }

    private final l1 i(a2.e eVar) {
        b p10 = eVar.p();
        l1 l1Var = (l1) this.f4854l.get(p10);
        if (l1Var == null) {
            l1Var = new l1(this, eVar);
            this.f4854l.put(p10, l1Var);
        }
        if (l1Var.Q()) {
            this.f4857o.add(p10);
        }
        l1Var.F();
        return l1Var;
    }

    private final com.google.android.gms.common.internal.a j() {
        if (this.f4848f == null) {
            this.f4848f = b2.u.a(this.f4849g);
        }
        return this.f4848f;
    }

    private final void k() {
        b2.t tVar = this.f4847e;
        if (tVar != null) {
            if (tVar.g() > 0 || f()) {
                j().e(tVar);
            }
            this.f4847e = null;
        }
    }

    private final void l(z2.m mVar, int i10, a2.e eVar) {
        x1 b10;
        if (i10 == 0 || (b10 = x1.b(this, i10, eVar.p())) == null) {
            return;
        }
        z2.l a10 = mVar.a();
        final Handler handler = this.f4858p;
        handler.getClass();
        a10.b(new Executor() { // from class: com.google.android.gms.common.api.internal.f1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, b10);
    }

    public static g x(Context context) {
        g gVar;
        synchronized (f4841t) {
            if (f4842u == null) {
                f4842u = new g(context.getApplicationContext(), b2.i.c().getLooper(), com.google.android.gms.common.b.p());
            }
            gVar = f4842u;
        }
        return gVar;
    }

    public final z2.l A(a2.e eVar, l.a aVar, int i10) {
        z2.m mVar = new z2.m();
        l(mVar, i10, eVar);
        y2 y2Var = new y2(aVar, mVar);
        Handler handler = this.f4858p;
        handler.sendMessage(handler.obtainMessage(13, new b2(y2Var, this.f4853k.get(), eVar)));
        return mVar.a();
    }

    public final void F(a2.e eVar, int i10, d dVar) {
        v2 v2Var = new v2(i10, dVar);
        Handler handler = this.f4858p;
        handler.sendMessage(handler.obtainMessage(4, new b2(v2Var, this.f4853k.get(), eVar)));
    }

    public final void G(a2.e eVar, int i10, v vVar, z2.m mVar, u uVar) {
        l(mVar, vVar.d(), eVar);
        x2 x2Var = new x2(i10, vVar, mVar, uVar);
        Handler handler = this.f4858p;
        handler.sendMessage(handler.obtainMessage(4, new b2(x2Var, this.f4853k.get(), eVar)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void H(b2.n nVar, int i10, long j10, int i11) {
        Handler handler = this.f4858p;
        handler.sendMessage(handler.obtainMessage(18, new y1(nVar, i10, j10, i11)));
    }

    public final void I(com.google.android.gms.common.a aVar, int i10) {
        if (g(aVar, i10)) {
            return;
        }
        Handler handler = this.f4858p;
        handler.sendMessage(handler.obtainMessage(5, i10, 0, aVar));
    }

    public final void a() {
        Handler handler = this.f4858p;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void b(a2.e eVar) {
        Handler handler = this.f4858p;
        handler.sendMessage(handler.obtainMessage(7, eVar));
    }

    public final void c(c0 c0Var) {
        synchronized (f4841t) {
            if (this.f4855m != c0Var) {
                this.f4855m = c0Var;
                this.f4856n.clear();
            }
            this.f4856n.addAll(c0Var.t());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(c0 c0Var) {
        synchronized (f4841t) {
            if (this.f4855m == c0Var) {
                this.f4855m = null;
                this.f4856n.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f() {
        if (this.f4846d) {
            return false;
        }
        b2.r a10 = b2.q.b().a();
        if (a10 != null && !a10.l()) {
            return false;
        }
        int a11 = this.f4851i.a(this.f4849g, 203400000);
        return a11 == -1 || a11 == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g(com.google.android.gms.common.a aVar, int i10) {
        return this.f4850h.z(this.f4849g, aVar, i10);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        z2.m b10;
        Boolean valueOf;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        int i10 = message.what;
        l1 l1Var = null;
        switch (i10) {
            case 1:
                this.f4845c = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f4858p.removeMessages(12);
                for (b bVar5 : this.f4854l.keySet()) {
                    Handler handler = this.f4858p;
                    handler.sendMessageDelayed(handler.obtainMessage(12, bVar5), this.f4845c);
                }
                return true;
            case 2:
                c3 c3Var = (c3) message.obj;
                Iterator it = c3Var.a().iterator();
                while (true) {
                    if (it.hasNext()) {
                        b bVar6 = (b) it.next();
                        l1 l1Var2 = (l1) this.f4854l.get(bVar6);
                        if (l1Var2 == null) {
                            c3Var.b(bVar6, new com.google.android.gms.common.a(13), null);
                        } else if (l1Var2.P()) {
                            c3Var.b(bVar6, com.google.android.gms.common.a.f4739j, l1Var2.v().k());
                        } else {
                            com.google.android.gms.common.a t10 = l1Var2.t();
                            if (t10 != null) {
                                c3Var.b(bVar6, t10, null);
                            } else {
                                l1Var2.K(c3Var);
                                l1Var2.F();
                            }
                        }
                    }
                }
                return true;
            case 3:
                for (l1 l1Var3 : this.f4854l.values()) {
                    l1Var3.E();
                    l1Var3.F();
                }
                return true;
            case 4:
            case 8:
            case 13:
                b2 b2Var = (b2) message.obj;
                l1 l1Var4 = (l1) this.f4854l.get(b2Var.f4790c.p());
                if (l1Var4 == null) {
                    l1Var4 = i(b2Var.f4790c);
                }
                if (!l1Var4.Q() || this.f4853k.get() == b2Var.f4789b) {
                    l1Var4.G(b2Var.f4788a);
                } else {
                    b2Var.f4788a.a(f4839r);
                    l1Var4.M();
                }
                return true;
            case 5:
                int i11 = message.arg1;
                com.google.android.gms.common.a aVar = (com.google.android.gms.common.a) message.obj;
                Iterator it2 = this.f4854l.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        l1 l1Var5 = (l1) it2.next();
                        if (l1Var5.r() == i11) {
                            l1Var = l1Var5;
                        }
                    }
                }
                if (l1Var == null) {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i11 + " while trying to fail enqueued calls.", new Exception());
                } else if (aVar.g() == 13) {
                    l1.y(l1Var, new Status(17, "Error resolution was canceled by the user, original error message: " + this.f4850h.g(aVar.g()) + ": " + aVar.j()));
                } else {
                    l1.y(l1Var, h(l1.w(l1Var), aVar));
                }
                return true;
            case 6:
                if (this.f4849g.getApplicationContext() instanceof Application) {
                    c.c((Application) this.f4849g.getApplicationContext());
                    c.b().a(new g1(this));
                    if (!c.b().e(true)) {
                        this.f4845c = 300000L;
                    }
                }
                return true;
            case 7:
                i((a2.e) message.obj);
                return true;
            case 9:
                if (this.f4854l.containsKey(message.obj)) {
                    ((l1) this.f4854l.get(message.obj)).L();
                }
                return true;
            case 10:
                Iterator it3 = this.f4857o.iterator();
                while (it3.hasNext()) {
                    l1 l1Var6 = (l1) this.f4854l.remove((b) it3.next());
                    if (l1Var6 != null) {
                        l1Var6.M();
                    }
                }
                this.f4857o.clear();
                return true;
            case 11:
                if (this.f4854l.containsKey(message.obj)) {
                    ((l1) this.f4854l.get(message.obj)).N();
                }
                return true;
            case 12:
                if (this.f4854l.containsKey(message.obj)) {
                    ((l1) this.f4854l.get(message.obj)).a();
                }
                return true;
            case 14:
                d0 d0Var = (d0) message.obj;
                b a10 = d0Var.a();
                if (this.f4854l.containsKey(a10)) {
                    boolean O = l1.O((l1) this.f4854l.get(a10), false);
                    b10 = d0Var.b();
                    valueOf = Boolean.valueOf(O);
                } else {
                    b10 = d0Var.b();
                    valueOf = Boolean.FALSE;
                }
                b10.c(valueOf);
                return true;
            case 15:
                n1 n1Var = (n1) message.obj;
                Map map = this.f4854l;
                bVar = n1Var.f4935a;
                if (map.containsKey(bVar)) {
                    Map map2 = this.f4854l;
                    bVar2 = n1Var.f4935a;
                    l1.C((l1) map2.get(bVar2), n1Var);
                }
                return true;
            case 16:
                n1 n1Var2 = (n1) message.obj;
                Map map3 = this.f4854l;
                bVar3 = n1Var2.f4935a;
                if (map3.containsKey(bVar3)) {
                    Map map4 = this.f4854l;
                    bVar4 = n1Var2.f4935a;
                    l1.D((l1) map4.get(bVar4), n1Var2);
                }
                return true;
            case 17:
                k();
                return true;
            case 18:
                y1 y1Var = (y1) message.obj;
                if (y1Var.f5059c == 0) {
                    j().e(new b2.t(y1Var.f5058b, Arrays.asList(y1Var.f5057a)));
                } else {
                    b2.t tVar = this.f4847e;
                    if (tVar != null) {
                        List j10 = tVar.j();
                        if (tVar.g() != y1Var.f5058b || (j10 != null && j10.size() >= y1Var.f5060d)) {
                            this.f4858p.removeMessages(17);
                            k();
                        } else {
                            this.f4847e.l(y1Var.f5057a);
                        }
                    }
                    if (this.f4847e == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(y1Var.f5057a);
                        this.f4847e = new b2.t(y1Var.f5058b, arrayList);
                        Handler handler2 = this.f4858p;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), y1Var.f5059c);
                    }
                }
                return true;
            case 19:
                this.f4846d = false;
                return true;
            default:
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unknown message id: ");
                sb2.append(i10);
                return false;
        }
    }

    public final int m() {
        return this.f4852j.getAndIncrement();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final l1 w(b bVar) {
        return (l1) this.f4854l.get(bVar);
    }

    public final z2.l z(a2.e eVar, p pVar, x xVar, Runnable runnable) {
        z2.m mVar = new z2.m();
        l(mVar, pVar.e(), eVar);
        w2 w2Var = new w2(new c2(pVar, xVar, runnable), mVar);
        Handler handler = this.f4858p;
        handler.sendMessage(handler.obtainMessage(8, new b2(w2Var, this.f4853k.get(), eVar)));
        return mVar.a();
    }
}
