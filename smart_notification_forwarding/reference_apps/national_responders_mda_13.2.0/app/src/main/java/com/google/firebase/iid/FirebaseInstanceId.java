package com.google.firebase.iid;

import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.firebase.iid.w;
import com.google.firebase.iid.y;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

@Deprecated
/* loaded from: classes.dex */
public class FirebaseInstanceId {

    /* renamed from: i, reason: collision with root package name */
    private static y f7259i;

    /* renamed from: k, reason: collision with root package name */
    static ScheduledExecutorService f7261k;

    /* renamed from: a, reason: collision with root package name */
    final Executor f7262a;

    /* renamed from: b, reason: collision with root package name */
    private final o3.c f7263b;

    /* renamed from: c, reason: collision with root package name */
    private final s f7264c;

    /* renamed from: d, reason: collision with root package name */
    private final p f7265d;

    /* renamed from: e, reason: collision with root package name */
    private final w f7266e;

    /* renamed from: f, reason: collision with root package name */
    private final com.google.firebase.installations.g f7267f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f7268g;

    /* renamed from: h, reason: collision with root package name */
    private static final long f7258h = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f7260j = Pattern.compile("\\AA[\\w-]{38}\\z");

    FirebaseInstanceId(o3.c cVar, s sVar, Executor executor, Executor executor2, r4.b<x4.i> bVar, r4.b<p4.f> bVar2, com.google.firebase.installations.g gVar) {
        this.f7268g = false;
        if (s.c(cVar) == null) {
            throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
        }
        synchronized (FirebaseInstanceId.class) {
            if (f7259i == null) {
                f7259i = new y(cVar.g());
            }
        }
        this.f7263b = cVar;
        this.f7264c = sVar;
        this.f7265d = new p(cVar, sVar, bVar, bVar2, gVar);
        this.f7262a = executor2;
        this.f7266e = new w(executor);
        this.f7267f = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseInstanceId(o3.c cVar, r4.b<x4.i> bVar, r4.b<p4.f> bVar2, com.google.firebase.installations.g gVar) {
        this(cVar, new s(cVar.g()), h.b(), h.b(), bVar, bVar2, gVar);
    }

    private void D() {
        if (F(p())) {
            C();
        }
    }

    private <T> T a(z2.l<T> lVar) {
        try {
            return (T) z2.o.b(lVar, 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (ExecutionException e10) {
            Throwable cause = e10.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    A();
                }
                throw ((IOException) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IOException(e10);
        }
    }

    private static <T> T b(z2.l<T> lVar) {
        b2.p.l(lVar, "Task must not be null");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        lVar.b(j.f7300f, new z2.f(countDownLatch) { // from class: com.google.firebase.iid.k

            /* renamed from: a, reason: collision with root package name */
            private final CountDownLatch f7301a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f7301a = countDownLatch;
            }

            @Override // z2.f
            public void a(z2.l lVar2) {
                this.f7301a.countDown();
            }
        });
        countDownLatch.await(30000L, TimeUnit.MILLISECONDS);
        return (T) l(lVar);
    }

    private static void d(o3.c cVar) {
        b2.p.h(cVar.j().e(), "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        b2.p.h(cVar.j().c(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        b2.p.h(cVar.j().b(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        b2.p.b(u(cVar.j().c()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        b2.p.b(t(cVar.j().b()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    @Keep
    public static FirebaseInstanceId getInstance(o3.c cVar) {
        d(cVar);
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) cVar.f(FirebaseInstanceId.class);
        b2.p.l(firebaseInstanceId, "Firebase Instance ID component is not present");
        return firebaseInstanceId;
    }

    public static FirebaseInstanceId i() {
        return getInstance(o3.c.h());
    }

    private z2.l<q> k(final String str, String str2) {
        final String z10 = z(str2);
        return z2.o.e(null).j(this.f7262a, new z2.c(this, str, z10) { // from class: com.google.firebase.iid.i

            /* renamed from: a, reason: collision with root package name */
            private final FirebaseInstanceId f7297a;

            /* renamed from: b, reason: collision with root package name */
            private final String f7298b;

            /* renamed from: c, reason: collision with root package name */
            private final String f7299c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f7297a = this;
                this.f7298b = str;
                this.f7299c = z10;
            }

            @Override // z2.c
            public Object a(z2.l lVar) {
                return this.f7297a.y(this.f7298b, this.f7299c, lVar);
            }
        });
    }

    private static <T> T l(z2.l<T> lVar) {
        if (lVar.p()) {
            return lVar.l();
        }
        if (lVar.n()) {
            throw new CancellationException("Task is already canceled");
        }
        if (lVar.o()) {
            throw new IllegalStateException(lVar.k());
        }
        throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
    }

    private String m() {
        return "[DEFAULT]".equals(this.f7263b.i()) ? "" : this.f7263b.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r() {
        return Log.isLoggable("FirebaseInstanceId", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3));
    }

    static boolean t(String str) {
        return f7260j.matcher(str).matches();
    }

    static boolean u(String str) {
        return str.contains(":");
    }

    private static String z(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    synchronized void A() {
        f7259i.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void B(boolean z10) {
        this.f7268g = z10;
    }

    synchronized void C() {
        if (this.f7268g) {
            return;
        }
        E(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void E(long j10) {
        e(new z(this, Math.min(Math.max(30L, j10 + j10), f7258h)), j10);
        this.f7268g = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F(y.a aVar) {
        return aVar == null || aVar.c(this.f7264c.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return o(s.c(this.f7263b), "*");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Runnable runnable, long j10) {
        synchronized (FirebaseInstanceId.class) {
            if (f7261k == null) {
                f7261k = new ScheduledThreadPoolExecutor(1, new h2.b("FirebaseInstanceId"));
            }
            f7261k.schedule(runnable, j10, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o3.c f() {
        return this.f7263b;
    }

    @Deprecated
    public String g() {
        d(this.f7263b);
        D();
        return h();
    }

    String h() {
        try {
            f7259i.i(this.f7263b.k());
            return (String) b(this.f7267f.e());
        } catch (InterruptedException e10) {
            throw new IllegalStateException(e10);
        }
    }

    @Deprecated
    public z2.l<q> j() {
        d(this.f7263b);
        return k(s.c(this.f7263b), "*");
    }

    @Deprecated
    public String n() {
        d(this.f7263b);
        y.a p10 = p();
        if (F(p10)) {
            C();
        }
        return y.a.b(p10);
    }

    @Deprecated
    public String o(String str, String str2) {
        d(this.f7263b);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((q) a(k(str, str2))).f();
        }
        throw new IOException("MAIN_THREAD");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y.a p() {
        return q(s.c(this.f7263b), "*");
    }

    y.a q(String str, String str2) {
        return f7259i.f(m(), str, str2);
    }

    public boolean s() {
        return this.f7264c.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ z2.l w(String str, String str2, String str3, String str4) {
        f7259i.h(m(), str, str2, str4, this.f7264c.a());
        return z2.o.e(new r(str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ z2.l x(final String str, final String str2, final String str3) {
        return this.f7265d.d(str, str2, str3).q(this.f7262a, new z2.k(this, str2, str3, str) { // from class: com.google.firebase.iid.m

            /* renamed from: a, reason: collision with root package name */
            private final FirebaseInstanceId f7306a;

            /* renamed from: b, reason: collision with root package name */
            private final String f7307b;

            /* renamed from: c, reason: collision with root package name */
            private final String f7308c;

            /* renamed from: d, reason: collision with root package name */
            private final String f7309d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f7306a = this;
                this.f7307b = str2;
                this.f7308c = str3;
                this.f7309d = str;
            }

            @Override // z2.k
            public z2.l a(Object obj) {
                return this.f7306a.w(this.f7307b, this.f7308c, this.f7309d, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ z2.l y(final String str, final String str2, z2.l lVar) {
        final String h10 = h();
        y.a q10 = q(str, str2);
        return !F(q10) ? z2.o.e(new r(h10, q10.f7339a)) : this.f7266e.a(str, str2, new w.a(this, h10, str, str2) { // from class: com.google.firebase.iid.l

            /* renamed from: a, reason: collision with root package name */
            private final FirebaseInstanceId f7302a;

            /* renamed from: b, reason: collision with root package name */
            private final String f7303b;

            /* renamed from: c, reason: collision with root package name */
            private final String f7304c;

            /* renamed from: d, reason: collision with root package name */
            private final String f7305d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f7302a = this;
                this.f7303b = h10;
                this.f7304c = str;
                this.f7305d = str2;
            }

            @Override // com.google.firebase.iid.w.a
            public z2.l start() {
                return this.f7302a.x(this.f7303b, this.f7304c, this.f7305d);
            }
        });
    }
}
