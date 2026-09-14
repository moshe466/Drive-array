package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private final Context f7200a;

    /* renamed from: b, reason: collision with root package name */
    private final o3.c f7201b;

    /* renamed from: c, reason: collision with root package name */
    private final s f7202c;

    /* renamed from: d, reason: collision with root package name */
    private final long f7203d = System.currentTimeMillis();

    /* renamed from: e, reason: collision with root package name */
    private n f7204e;

    /* renamed from: f, reason: collision with root package name */
    private n f7205f;

    /* renamed from: g, reason: collision with root package name */
    private k f7206g;

    /* renamed from: h, reason: collision with root package name */
    private final x f7207h;

    /* renamed from: i, reason: collision with root package name */
    private final u3.b f7208i;

    /* renamed from: j, reason: collision with root package name */
    private final t3.a f7209j;

    /* renamed from: k, reason: collision with root package name */
    private ExecutorService f7210k;

    /* renamed from: l, reason: collision with root package name */
    private i f7211l;

    /* renamed from: m, reason: collision with root package name */
    private s3.a f7212m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Callable<z2.l<Void>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f4.e f7213a;

        a(f4.e eVar) {
            this.f7213a = eVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public z2.l<Void> call() {
            return m.this.f(this.f7213a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ f4.e f7215f;

        b(f4.e eVar) {
            this.f7215f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.f(this.f7215f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Callable<Boolean> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            try {
                boolean d10 = m.this.f7204e.d();
                s3.b.f().b("Initialization marker file removed: " + d10);
                return Boolean.valueOf(d10);
            } catch (Exception e10) {
                s3.b.f().e("Problem encountered deleting Crashlytics initialization marker.", e10);
                return Boolean.FALSE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Callable<Boolean> {
        d() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            return Boolean.valueOf(m.this.f7206g.H());
        }
    }

    public m(o3.c cVar, x xVar, s3.a aVar, s sVar, u3.b bVar, t3.a aVar2, ExecutorService executorService) {
        this.f7201b = cVar;
        this.f7202c = sVar;
        this.f7200a = cVar.g();
        this.f7207h = xVar;
        this.f7212m = aVar;
        this.f7208i = bVar;
        this.f7209j = aVar2;
        this.f7210k = executorService;
        this.f7211l = new i(executorService);
    }

    private void d() {
        try {
            Boolean.TRUE.equals((Boolean) k0.a(this.f7211l.h(new d())));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z2.l<Void> f(f4.e eVar) {
        m();
        this.f7206g.B();
        try {
            this.f7208i.a(l.b(this));
            g4.e b10 = eVar.b();
            if (!b10.b().f9784a) {
                s3.b.f().b("Collection of crash reports disabled in Crashlytics settings.");
                return z2.o.d(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
            }
            if (!this.f7206g.R(b10.a().f9785a)) {
                s3.b.f().b("Could not finalize previous sessions.");
            }
            return this.f7206g.y0(1.0f, eVar.a());
        } catch (Exception e10) {
            s3.b.f().e("Crashlytics encountered a problem during asynchronous initialization.", e10);
            return z2.o.d(e10);
        } finally {
            l();
        }
    }

    private void h(f4.e eVar) {
        s3.b f10;
        String str;
        Future<?> submit = this.f7210k.submit(new b(eVar));
        s3.b.f().b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e10) {
            e = e10;
            f10 = s3.b.f();
            str = "Crashlytics was interrupted during initialization.";
            f10.e(str, e);
        } catch (ExecutionException e11) {
            e = e11;
            f10 = s3.b.f();
            str = "Problem encountered during Crashlytics initialization.";
            f10.e(str, e);
        } catch (TimeoutException e12) {
            e = e12;
            f10 = s3.b.f();
            str = "Crashlytics timed out during initialization.";
            f10.e(str, e);
        }
    }

    public static String i() {
        return "17.3.0";
    }

    static boolean j(String str, boolean z10) {
        if (z10) {
            return !h.B(str);
        }
        s3.b.f().b("Configured not to require a build ID.");
        return true;
    }

    boolean e() {
        return this.f7204e.c();
    }

    public z2.l<Void> g(f4.e eVar) {
        return k0.b(this.f7210k, new a(eVar));
    }

    public void k(String str) {
        this.f7206g.P0(System.currentTimeMillis() - this.f7203d, str);
    }

    void l() {
        this.f7211l.h(new c());
    }

    void m() {
        this.f7211l.b();
        this.f7204e.a();
        s3.b.f().b("Initialization marker file created.");
    }

    public boolean n(f4.e eVar) {
        String p10 = h.p(this.f7200a);
        s3.b.f().b("Mapping file ID is: " + p10);
        if (!j(p10, h.l(this.f7200a, "com.crashlytics.RequireBuildId", true))) {
            throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
        }
        String c10 = this.f7201b.j().c();
        try {
            s3.b.f().g("Initializing Crashlytics " + i());
            z3.i iVar = new z3.i(this.f7200a);
            this.f7205f = new n("crash_marker", iVar);
            this.f7204e = new n("initialization_marker", iVar);
            y3.c cVar = new y3.c();
            com.google.firebase.crashlytics.internal.common.b a10 = com.google.firebase.crashlytics.internal.common.b.a(this.f7200a, this.f7207h, c10, p10, new j4.a(this.f7200a));
            s3.b.f().b("Installer package name is: " + a10.f7072c);
            this.f7206g = new k(this.f7200a, this.f7211l, cVar, this.f7207h, this.f7202c, iVar, this.f7205f, a10, null, null, this.f7212m, this.f7209j, eVar);
            boolean e10 = e();
            d();
            this.f7206g.O(Thread.getDefaultUncaughtExceptionHandler(), eVar);
            if (!e10 || !h.c(this.f7200a)) {
                s3.b.f().b("Exception handling initialization successful");
                return true;
            }
            s3.b.f().b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
            h(eVar);
            return false;
        } catch (Exception e11) {
            s3.b.f().e("Crashlytics was not started due to an exception during initialization", e11);
            this.f7206g = null;
            return false;
        }
    }

    public void o(String str) {
        this.f7206g.x0(str);
    }
}
