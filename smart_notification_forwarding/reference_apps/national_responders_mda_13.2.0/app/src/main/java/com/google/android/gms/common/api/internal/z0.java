package com.google.android.gms.common.api.internal;

import a2.a;
import a2.f;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class z0 extends a2.f implements t1 {

    /* renamed from: b, reason: collision with root package name */
    private final Lock f5064b;

    /* renamed from: c, reason: collision with root package name */
    private final b2.i0 f5065c;

    /* renamed from: e, reason: collision with root package name */
    private final int f5067e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f5068f;

    /* renamed from: g, reason: collision with root package name */
    private final Looper f5069g;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f5071i;

    /* renamed from: j, reason: collision with root package name */
    private long f5072j;

    /* renamed from: k, reason: collision with root package name */
    private long f5073k;

    /* renamed from: l, reason: collision with root package name */
    private final x0 f5074l;

    /* renamed from: m, reason: collision with root package name */
    private final com.google.android.gms.common.b f5075m;

    /* renamed from: n, reason: collision with root package name */
    s1 f5076n;

    /* renamed from: o, reason: collision with root package name */
    final Map f5077o;

    /* renamed from: p, reason: collision with root package name */
    Set f5078p;

    /* renamed from: q, reason: collision with root package name */
    final b2.e f5079q;

    /* renamed from: r, reason: collision with root package name */
    final Map f5080r;

    /* renamed from: s, reason: collision with root package name */
    final a.AbstractC0006a f5081s;

    /* renamed from: t, reason: collision with root package name */
    private final m f5082t;

    /* renamed from: u, reason: collision with root package name */
    private final ArrayList f5083u;

    /* renamed from: v, reason: collision with root package name */
    private Integer f5084v;

    /* renamed from: w, reason: collision with root package name */
    Set f5085w;

    /* renamed from: x, reason: collision with root package name */
    final u2 f5086x;

    /* renamed from: y, reason: collision with root package name */
    private final b2.h0 f5087y;

    /* renamed from: d, reason: collision with root package name */
    private v1 f5066d = null;

    /* renamed from: h, reason: collision with root package name */
    final Queue f5070h = new LinkedList();

    public z0(Context context, Lock lock, Looper looper, b2.e eVar, com.google.android.gms.common.b bVar, a.AbstractC0006a abstractC0006a, Map map, List list, List list2, Map map2, int i10, int i11, ArrayList arrayList) {
        this.f5072j = true != g2.d.a() ? 120000L : 10000L;
        this.f5073k = 5000L;
        this.f5078p = new HashSet();
        this.f5082t = new m();
        this.f5084v = null;
        this.f5085w = null;
        w0 w0Var = new w0(this);
        this.f5087y = w0Var;
        this.f5068f = context;
        this.f5064b = lock;
        this.f5065c = new b2.i0(looper, w0Var);
        this.f5069g = looper;
        this.f5074l = new x0(this, looper);
        this.f5075m = bVar;
        this.f5067e = i10;
        if (i10 >= 0) {
            this.f5084v = Integer.valueOf(i11);
        }
        this.f5080r = map;
        this.f5077o = map2;
        this.f5083u = arrayList;
        this.f5086x = new u2();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f5065c.f((f.b) it.next());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            this.f5065c.g((f.c) it2.next());
        }
        this.f5079q = eVar;
        this.f5081s = abstractC0006a;
    }

    public static int n(Iterable iterable, boolean z10) {
        Iterator it = iterable.iterator();
        boolean z11 = false;
        boolean z12 = false;
        while (it.hasNext()) {
            a.f fVar = (a.f) it.next();
            z11 |= fVar.r();
            z12 |= fVar.b();
        }
        if (z11) {
            return (z12 && z10) ? 2 : 1;
        }
        return 3;
    }

    static String p(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void q(z0 z0Var) {
        z0Var.f5064b.lock();
        try {
            if (z0Var.f5071i) {
                z0Var.u();
            }
        } finally {
            z0Var.f5064b.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void r(z0 z0Var) {
        z0Var.f5064b.lock();
        try {
            if (z0Var.s()) {
                z0Var.u();
            }
        } finally {
            z0Var.f5064b.unlock();
        }
    }

    private final void t(int i10) {
        v1 d1Var;
        Integer num = this.f5084v;
        if (num == null) {
            this.f5084v = Integer.valueOf(i10);
        } else if (num.intValue() != i10) {
            throw new IllegalStateException("Cannot use sign-in mode: " + p(i10) + ". Mode was already set to " + p(this.f5084v.intValue()));
        }
        if (this.f5066d != null) {
            return;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (a.f fVar : this.f5077o.values()) {
            z10 |= fVar.r();
            z11 |= fVar.b();
        }
        int intValue = this.f5084v.intValue();
        if (intValue == 1) {
            if (!z10) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            }
            if (z11) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
        } else if (intValue == 2 && z10) {
            d1Var = y.m(this.f5068f, this, this.f5064b, this.f5069g, this.f5075m, this.f5077o, this.f5079q, this.f5080r, this.f5081s, this.f5083u);
            this.f5066d = d1Var;
        }
        d1Var = new d1(this.f5068f, this, this.f5064b, this.f5069g, this.f5075m, this.f5077o, this.f5079q, this.f5080r, this.f5081s, this.f5083u, this);
        this.f5066d = d1Var;
    }

    private final void u() {
        this.f5065c.b();
        ((v1) b2.p.k(this.f5066d)).b();
    }

    @Override // com.google.android.gms.common.api.internal.t1
    public final void a(Bundle bundle) {
        while (!this.f5070h.isEmpty()) {
            g((d) this.f5070h.remove());
        }
        this.f5065c.d(bundle);
    }

    @Override // com.google.android.gms.common.api.internal.t1
    public final void b(int i10, boolean z10) {
        if (i10 == 1) {
            if (!z10 && !this.f5071i) {
                this.f5071i = true;
                if (this.f5076n == null && !g2.d.a()) {
                    try {
                        this.f5076n = this.f5075m.u(this.f5068f.getApplicationContext(), new y0(this));
                    } catch (SecurityException unused) {
                    }
                }
                x0 x0Var = this.f5074l;
                x0Var.sendMessageDelayed(x0Var.obtainMessage(1), this.f5072j);
                x0 x0Var2 = this.f5074l;
                x0Var2.sendMessageDelayed(x0Var2.obtainMessage(2), this.f5073k);
            }
            i10 = 1;
        }
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f5086x.f5018a.toArray(new BasePendingResult[0])) {
            basePendingResult.e(u2.f5017c);
        }
        this.f5065c.e(i10);
        this.f5065c.a();
        if (i10 == 2) {
            u();
        }
    }

    @Override // com.google.android.gms.common.api.internal.t1
    public final void c(com.google.android.gms.common.a aVar) {
        if (!this.f5075m.k(this.f5068f, aVar.g())) {
            s();
        }
        if (this.f5071i) {
            return;
        }
        this.f5065c.c(aVar);
        this.f5065c.a();
    }

    @Override // a2.f
    public final void d() {
        this.f5064b.lock();
        try {
            int i10 = 2;
            boolean z10 = false;
            if (this.f5067e >= 0) {
                b2.p.o(this.f5084v != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.f5084v;
                if (num == null) {
                    this.f5084v = Integer.valueOf(n(this.f5077o.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            int intValue = ((Integer) b2.p.k(this.f5084v)).intValue();
            this.f5064b.lock();
            if (intValue == 3 || intValue == 1) {
                i10 = intValue;
            } else if (intValue != 2) {
                i10 = intValue;
                b2.p.b(z10, "Illegal sign-in mode: " + i10);
                t(i10);
                u();
                this.f5064b.unlock();
            }
            z10 = true;
            b2.p.b(z10, "Illegal sign-in mode: " + i10);
            t(i10);
            u();
            this.f5064b.unlock();
        } catch (Throwable th) {
            throw th;
        } finally {
            this.f5064b.unlock();
        }
    }

    @Override // a2.f
    public final void e() {
        this.f5064b.lock();
        try {
            this.f5086x.b();
            v1 v1Var = this.f5066d;
            if (v1Var != null) {
                v1Var.c();
            }
            this.f5082t.d();
            for (d dVar : this.f5070h) {
                dVar.o(null);
                dVar.c();
            }
            this.f5070h.clear();
            if (this.f5066d != null) {
                s();
                this.f5065c.a();
            }
        } finally {
            this.f5064b.unlock();
        }
    }

    @Override // a2.f
    public final void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.f5068f);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.f5071i);
        printWriter.append(" mWorkQueue.size()=").print(this.f5070h.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f5086x.f5018a.size());
        v1 v1Var = this.f5066d;
        if (v1Var != null) {
            v1Var.d(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // a2.f
    public final <A extends a.b, T extends d<? extends a2.j, A>> T g(T t10) {
        a2.a<?> q10 = t10.q();
        b2.p.b(this.f5077o.containsKey(t10.r()), "GoogleApiClient is not configured to use " + (q10 != null ? q10.d() : "the API") + " required for this call.");
        this.f5064b.lock();
        try {
            v1 v1Var = this.f5066d;
            if (v1Var == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (this.f5071i) {
                this.f5070h.add(t10);
                while (!this.f5070h.isEmpty()) {
                    d dVar = (d) this.f5070h.remove();
                    this.f5086x.a(dVar);
                    dVar.v(Status.f4748l);
                }
            } else {
                t10 = (T) v1Var.f(t10);
            }
            return t10;
        } finally {
            this.f5064b.unlock();
        }
    }

    @Override // a2.f
    public final Looper h() {
        return this.f5069g;
    }

    @Override // a2.f
    public final void i(f.c cVar) {
        this.f5065c.g(cVar);
    }

    @Override // a2.f
    public final void j(f.c cVar) {
        this.f5065c.h(cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        if (r3 == false) goto L20;
     */
    @Override // a2.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(com.google.android.gms.common.api.internal.s2 r3) {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.f5064b
            r0.lock()
            java.util.Set r0 = r2.f5085w     // Catch: java.lang.Throwable -> L54
            java.lang.String r1 = "GoogleApiClientImpl"
            if (r0 != 0) goto L16
            java.lang.Exception r3 = new java.lang.Exception     // Catch: java.lang.Throwable -> L54
            r3.<init>()     // Catch: java.lang.Throwable -> L54
            java.lang.String r0 = "Attempted to remove pending transform when no transforms are registered."
        L12:
            android.util.Log.wtf(r1, r0, r3)     // Catch: java.lang.Throwable -> L54
            goto L47
        L16:
            boolean r3 = r0.remove(r3)     // Catch: java.lang.Throwable -> L54
            if (r3 != 0) goto L24
            java.lang.Exception r3 = new java.lang.Exception     // Catch: java.lang.Throwable -> L54
            r3.<init>()     // Catch: java.lang.Throwable -> L54
            java.lang.String r0 = "Failed to remove pending transform - this may lead to memory leaks!"
            goto L12
        L24:
            java.util.concurrent.locks.Lock r3 = r2.f5064b     // Catch: java.lang.Throwable -> L54
            r3.lock()     // Catch: java.lang.Throwable -> L54
            java.util.Set r3 = r2.f5085w     // Catch: java.lang.Throwable -> L4d
            if (r3 != 0) goto L33
            java.util.concurrent.locks.Lock r3 = r2.f5064b     // Catch: java.lang.Throwable -> L54
            r3.unlock()     // Catch: java.lang.Throwable -> L54
            goto L40
        L33:
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L4d
            r3 = r3 ^ 1
            java.util.concurrent.locks.Lock r0 = r2.f5064b     // Catch: java.lang.Throwable -> L54
            r0.unlock()     // Catch: java.lang.Throwable -> L54
            if (r3 != 0) goto L47
        L40:
            com.google.android.gms.common.api.internal.v1 r3 = r2.f5066d     // Catch: java.lang.Throwable -> L54
            if (r3 == 0) goto L47
            r3.a()     // Catch: java.lang.Throwable -> L54
        L47:
            java.util.concurrent.locks.Lock r3 = r2.f5064b
            r3.unlock()
            return
        L4d:
            r3 = move-exception
            java.util.concurrent.locks.Lock r0 = r2.f5064b     // Catch: java.lang.Throwable -> L54
            r0.unlock()     // Catch: java.lang.Throwable -> L54
            throw r3     // Catch: java.lang.Throwable -> L54
        L54:
            r3 = move-exception
            java.util.concurrent.locks.Lock r0 = r2.f5064b
            r0.unlock()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.z0.k(com.google.android.gms.common.api.internal.s2):void");
    }

    public final boolean m() {
        v1 v1Var = this.f5066d;
        return v1Var != null && v1Var.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String o() {
        StringWriter stringWriter = new StringWriter();
        f("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean s() {
        if (!this.f5071i) {
            return false;
        }
        this.f5071i = false;
        this.f5074l.removeMessages(2);
        this.f5074l.removeMessages(1);
        s1 s1Var = this.f5076n;
        if (s1Var != null) {
            s1Var.b();
            this.f5076n = null;
        }
        return true;
    }
}
