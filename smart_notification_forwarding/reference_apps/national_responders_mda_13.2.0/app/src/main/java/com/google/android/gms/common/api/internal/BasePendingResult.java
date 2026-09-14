package com.google.android.gms.common.api.internal;

import a2.g;
import a2.j;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
/* loaded from: classes.dex */
public abstract class BasePendingResult<R extends a2.j> extends a2.g<R> {

    /* renamed from: o */
    static final ThreadLocal f4756o = new h3();

    /* renamed from: p */
    public static final /* synthetic */ int f4757p = 0;

    /* renamed from: f */
    private a2.k f4763f;

    /* renamed from: h */
    private a2.j f4765h;

    /* renamed from: i */
    private Status f4766i;

    /* renamed from: j */
    private volatile boolean f4767j;

    /* renamed from: k */
    private boolean f4768k;

    /* renamed from: l */
    private boolean f4769l;

    /* renamed from: m */
    private b2.k f4770m;

    @KeepName
    private j3 mResultGuardian;

    /* renamed from: a */
    private final Object f4758a = new Object();

    /* renamed from: d */
    private final CountDownLatch f4761d = new CountDownLatch(1);

    /* renamed from: e */
    private final ArrayList f4762e = new ArrayList();

    /* renamed from: g */
    private final AtomicReference f4764g = new AtomicReference();

    /* renamed from: n */
    private boolean f4771n = false;

    /* renamed from: b */
    protected final a f4759b = new a(Looper.getMainLooper());

    /* renamed from: c */
    protected final WeakReference f4760c = new WeakReference(null);

    /* loaded from: classes.dex */
    public static class a<R extends a2.j> extends m2.n {
        public a(Looper looper) {
            super(looper);
        }

        public final void a(a2.k kVar, a2.j jVar) {
            int i10 = BasePendingResult.f4757p;
            sendMessage(obtainMessage(1, new Pair((a2.k) b2.p.k(kVar), jVar)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                Pair pair = (Pair) message.obj;
                a2.k kVar = (a2.k) pair.first;
                a2.j jVar = (a2.j) pair.second;
                try {
                    kVar.a(jVar);
                    return;
                } catch (RuntimeException e10) {
                    BasePendingResult.m(jVar);
                    throw e10;
                }
            }
            if (i10 == 2) {
                ((BasePendingResult) message.obj).e(Status.f4749m);
                return;
            }
            Log.wtf("BasePendingResult", "Don't know how to handle message: " + i10, new Exception());
        }
    }

    @Deprecated
    BasePendingResult() {
    }

    private final a2.j i() {
        a2.j jVar;
        synchronized (this.f4758a) {
            b2.p.o(!this.f4767j, "Result has already been consumed.");
            b2.p.o(g(), "Result is not ready.");
            jVar = this.f4765h;
            this.f4765h = null;
            this.f4763f = null;
            this.f4767j = true;
        }
        t2 t2Var = (t2) this.f4764g.getAndSet(null);
        if (t2Var != null) {
            t2Var.f4991a.f5018a.remove(this);
        }
        return (a2.j) b2.p.k(jVar);
    }

    private final void j(a2.j jVar) {
        this.f4765h = jVar;
        this.f4766i = jVar.c();
        this.f4770m = null;
        this.f4761d.countDown();
        if (this.f4768k) {
            this.f4763f = null;
        } else {
            a2.k kVar = this.f4763f;
            if (kVar != null) {
                this.f4759b.removeMessages(2);
                this.f4759b.a(kVar, i());
            } else if (this.f4765h instanceof a2.h) {
                this.mResultGuardian = new j3(this, null);
            }
        }
        ArrayList arrayList = this.f4762e;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((g.a) arrayList.get(i10)).a(this.f4766i);
        }
        this.f4762e.clear();
    }

    public static void m(a2.j jVar) {
        if (jVar instanceof a2.h) {
            try {
                ((a2.h) jVar).a();
            } catch (RuntimeException unused) {
                "Unable to release ".concat(String.valueOf(jVar));
            }
        }
    }

    @Override // a2.g
    public final void b(g.a aVar) {
        b2.p.b(aVar != null, "Callback cannot be null.");
        synchronized (this.f4758a) {
            if (g()) {
                aVar.a(this.f4766i);
            } else {
                this.f4762e.add(aVar);
            }
        }
    }

    public void c() {
        synchronized (this.f4758a) {
            if (!this.f4768k && !this.f4767j) {
                b2.k kVar = this.f4770m;
                if (kVar != null) {
                    try {
                        kVar.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                m(this.f4765h);
                this.f4768k = true;
                j(d(Status.f4750n));
            }
        }
    }

    public abstract R d(Status status);

    @Deprecated
    public final void e(Status status) {
        synchronized (this.f4758a) {
            if (!g()) {
                h(d(status));
                this.f4769l = true;
            }
        }
    }

    public final boolean f() {
        boolean z10;
        synchronized (this.f4758a) {
            z10 = this.f4768k;
        }
        return z10;
    }

    public final boolean g() {
        return this.f4761d.getCount() == 0;
    }

    public final void h(R r10) {
        synchronized (this.f4758a) {
            if (this.f4769l || this.f4768k) {
                m(r10);
                return;
            }
            g();
            b2.p.o(!g(), "Results have already been set");
            b2.p.o(!this.f4767j, "Result has already been consumed");
            j(r10);
        }
    }

    public final void l() {
        boolean z10 = true;
        if (!this.f4771n && !((Boolean) f4756o.get()).booleanValue()) {
            z10 = false;
        }
        this.f4771n = z10;
    }

    public final boolean n() {
        boolean f10;
        synchronized (this.f4758a) {
            if (((a2.f) this.f4760c.get()) == null || !this.f4771n) {
                c();
            }
            f10 = f();
        }
        return f10;
    }

    public final void o(t2 t2Var) {
        this.f4764g.set(t2Var);
    }
}
