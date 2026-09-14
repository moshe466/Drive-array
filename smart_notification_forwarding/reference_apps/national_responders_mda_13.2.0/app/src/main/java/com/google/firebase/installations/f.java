package com.google.firebase.installations;

import android.text.TextUtils;
import b2.p;
import com.google.firebase.installations.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import u4.d;
import u4.f;

/* loaded from: classes.dex */
public class f implements g {

    /* renamed from: m, reason: collision with root package name */
    private static final Object f7360m = new Object();

    /* renamed from: n, reason: collision with root package name */
    private static final ThreadFactory f7361n = new a();

    /* renamed from: a, reason: collision with root package name */
    private final o3.c f7362a;

    /* renamed from: b, reason: collision with root package name */
    private final u4.c f7363b;

    /* renamed from: c, reason: collision with root package name */
    private final t4.c f7364c;

    /* renamed from: d, reason: collision with root package name */
    private final o f7365d;

    /* renamed from: e, reason: collision with root package name */
    private final t4.b f7366e;

    /* renamed from: f, reason: collision with root package name */
    private final m f7367f;

    /* renamed from: g, reason: collision with root package name */
    private final Object f7368g;

    /* renamed from: h, reason: collision with root package name */
    private final ExecutorService f7369h;

    /* renamed from: i, reason: collision with root package name */
    private final ExecutorService f7370i;

    /* renamed from: j, reason: collision with root package name */
    private String f7371j;

    /* renamed from: k, reason: collision with root package name */
    private Set<s4.a> f7372k;

    /* renamed from: l, reason: collision with root package name */
    private final List<n> f7373l;

    /* loaded from: classes.dex */
    class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f7374a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f7374a.getAndIncrement())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7375a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f7376b;

        static {
            int[] iArr = new int[f.b.values().length];
            f7376b = iArr;
            try {
                iArr[f.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7376b[f.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7376b[f.b.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.b.values().length];
            f7375a = iArr2;
            try {
                iArr2[d.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7375a[d.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    f(ExecutorService executorService, o3.c cVar, u4.c cVar2, t4.c cVar3, o oVar, t4.b bVar, m mVar) {
        this.f7368g = new Object();
        this.f7372k = new HashSet();
        this.f7373l = new ArrayList();
        this.f7362a = cVar;
        this.f7363b = cVar2;
        this.f7364c = cVar3;
        this.f7365d = oVar;
        this.f7366e = bVar;
        this.f7367f = mVar;
        this.f7369h = executorService;
        this.f7370i = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f7361n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(o3.c cVar, r4.b<x4.i> bVar, r4.b<p4.f> bVar2) {
        this(new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f7361n), cVar, new u4.c(cVar.g(), bVar, bVar2), new t4.c(cVar), o.c(), new t4.b(cVar), new m());
    }

    private synchronized void A(t4.d dVar, t4.d dVar2) {
        if (this.f7372k.size() != 0 && !dVar.d().equals(dVar2.d())) {
            Iterator<s4.a> it = this.f7372k.iterator();
            while (it.hasNext()) {
                it.next().a(dVar2.d());
            }
        }
    }

    private z2.l<l> b() {
        z2.m mVar = new z2.m();
        d(new j(this.f7365d, mVar));
        return mVar.a();
    }

    private z2.l<String> c() {
        z2.m mVar = new z2.m();
        d(new k(mVar));
        return mVar.a();
    }

    private void d(n nVar) {
        synchronized (this.f7368g) {
            this.f7373l.add(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(boolean r3) {
        /*
            r2 = this;
            t4.d r0 = r2.n()
            boolean r1 = r0.i()     // Catch: com.google.firebase.installations.h -> L5c
            if (r1 != 0) goto L22
            boolean r1 = r0.l()     // Catch: com.google.firebase.installations.h -> L5c
            if (r1 == 0) goto L11
            goto L22
        L11:
            if (r3 != 0) goto L1d
            com.google.firebase.installations.o r3 = r2.f7365d     // Catch: com.google.firebase.installations.h -> L5c
            boolean r3 = r3.f(r0)     // Catch: com.google.firebase.installations.h -> L5c
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            return
        L1d:
            t4.d r3 = r2.h(r0)     // Catch: com.google.firebase.installations.h -> L5c
            goto L26
        L22:
            t4.d r3 = r2.w(r0)     // Catch: com.google.firebase.installations.h -> L5c
        L26:
            r2.q(r3)
            r2.A(r0, r3)
            boolean r0 = r3.k()
            if (r0 == 0) goto L39
            java.lang.String r0 = r3.d()
            r2.z(r0)
        L39:
            boolean r0 = r3.i()
            if (r0 == 0) goto L4a
            com.google.firebase.installations.h r3 = new com.google.firebase.installations.h
            com.google.firebase.installations.h$a r0 = com.google.firebase.installations.h.a.BAD_CONFIG
            r3.<init>(r0)
        L46:
            r2.x(r3)
            goto L5b
        L4a:
            boolean r0 = r3.j()
            if (r0 == 0) goto L58
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r0 = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."
            r3.<init>(r0)
            goto L46
        L58:
            r2.y(r3)
        L5b:
            return
        L5c:
            r3 = move-exception
            r2.x(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.f.f(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(boolean z10) {
        t4.d o10 = o();
        if (z10) {
            o10 = o10.p();
        }
        y(o10);
        this.f7370i.execute(e.a(this, z10));
    }

    private t4.d h(t4.d dVar) {
        u4.f e10 = this.f7363b.e(i(), dVar.d(), p(), dVar.f());
        int i10 = b.f7376b[e10.b().ordinal()];
        if (i10 == 1) {
            return dVar.o(e10.c(), e10.d(), this.f7365d.b());
        }
        if (i10 == 2) {
            return dVar.q("BAD CONFIG");
        }
        if (i10 != 3) {
            throw new h("Firebase Installations Service is unavailable. Please try again later.", h.a.UNAVAILABLE);
        }
        z(null);
        return dVar.r();
    }

    private synchronized String k() {
        return this.f7371j;
    }

    public static f l() {
        return m(o3.c.h());
    }

    public static f m(o3.c cVar) {
        p.b(cVar != null, "Null is not a valid value of FirebaseApp.");
        return (f) cVar.f(g.class);
    }

    private t4.d n() {
        t4.d c10;
        synchronized (f7360m) {
            com.google.firebase.installations.b a10 = com.google.firebase.installations.b.a(this.f7362a.g(), "generatefid.lock");
            try {
                c10 = this.f7364c.c();
            } finally {
                if (a10 != null) {
                    a10.b();
                }
            }
        }
        return c10;
    }

    private t4.d o() {
        t4.d c10;
        synchronized (f7360m) {
            com.google.firebase.installations.b a10 = com.google.firebase.installations.b.a(this.f7362a.g(), "generatefid.lock");
            try {
                c10 = this.f7364c.c();
                if (c10.j()) {
                    c10 = this.f7364c.a(c10.t(v(c10)));
                }
            } finally {
                if (a10 != null) {
                    a10.b();
                }
            }
        }
        return c10;
    }

    private void q(t4.d dVar) {
        synchronized (f7360m) {
            com.google.firebase.installations.b a10 = com.google.firebase.installations.b.a(this.f7362a.g(), "generatefid.lock");
            try {
                this.f7364c.a(dVar);
            } finally {
                if (a10 != null) {
                    a10.b();
                }
            }
        }
    }

    private void u() {
        p.h(j(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        p.h(p(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        p.h(i(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        p.b(o.h(j()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        p.b(o.g(i()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    private String v(t4.d dVar) {
        if ((!this.f7362a.i().equals("CHIME_ANDROID_SDK") && !this.f7362a.q()) || !dVar.m()) {
            return this.f7367f.a();
        }
        String f10 = this.f7366e.f();
        return TextUtils.isEmpty(f10) ? this.f7367f.a() : f10;
    }

    private t4.d w(t4.d dVar) {
        u4.d d10 = this.f7363b.d(i(), dVar.d(), p(), j(), (dVar.d() == null || dVar.d().length() != 11) ? null : this.f7366e.i());
        int i10 = b.f7375a[d10.e().ordinal()];
        if (i10 == 1) {
            return dVar.s(d10.c(), d10.d(), this.f7365d.b(), d10.b().c(), d10.b().d());
        }
        if (i10 == 2) {
            return dVar.q("BAD CONFIG");
        }
        throw new h("Firebase Installations Service is unavailable. Please try again later.", h.a.UNAVAILABLE);
    }

    private void x(Exception exc) {
        synchronized (this.f7368g) {
            Iterator<n> it = this.f7373l.iterator();
            while (it.hasNext()) {
                if (it.next().b(exc)) {
                    it.remove();
                }
            }
        }
    }

    private void y(t4.d dVar) {
        synchronized (this.f7368g) {
            Iterator<n> it = this.f7373l.iterator();
            while (it.hasNext()) {
                if (it.next().a(dVar)) {
                    it.remove();
                }
            }
        }
    }

    private synchronized void z(String str) {
        this.f7371j = str;
    }

    @Override // com.google.firebase.installations.g
    public z2.l<l> a(boolean z10) {
        u();
        z2.l<l> b10 = b();
        this.f7369h.execute(d.a(this, z10));
        return b10;
    }

    @Override // com.google.firebase.installations.g
    public z2.l<String> e() {
        u();
        String k10 = k();
        if (k10 != null) {
            return z2.o.e(k10);
        }
        z2.l<String> c10 = c();
        this.f7369h.execute(c.a(this));
        return c10;
    }

    String i() {
        return this.f7362a.j().b();
    }

    String j() {
        return this.f7362a.j().c();
    }

    String p() {
        return this.f7362a.j().e();
    }
}
