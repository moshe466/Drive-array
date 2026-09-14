package v1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import b2.p;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import l2.e;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private z1.a f14603a;

    /* renamed from: b, reason: collision with root package name */
    private l2.d f14604b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f14605c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f14606d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private b f14607e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f14608f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f14609g;

    /* renamed from: h, reason: collision with root package name */
    private final long f14610h;

    /* renamed from: v1.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0300a {

        /* renamed from: a, reason: collision with root package name */
        private final String f14611a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f14612b;

        public C0300a(String str, boolean z10) {
            this.f14611a = str;
            this.f14612b = z10;
        }

        public final String a() {
            return this.f14611a;
        }

        public final boolean b() {
            return this.f14612b;
        }

        public final String toString() {
            String str = this.f14611a;
            boolean z10 = this.f14612b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 7);
            sb2.append("{");
            sb2.append(str);
            sb2.append("}");
            sb2.append(z10);
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends Thread {

        /* renamed from: f, reason: collision with root package name */
        private WeakReference<a> f14613f;

        /* renamed from: g, reason: collision with root package name */
        private long f14614g;

        /* renamed from: h, reason: collision with root package name */
        CountDownLatch f14615h = new CountDownLatch(1);

        /* renamed from: i, reason: collision with root package name */
        boolean f14616i = false;

        public b(a aVar, long j10) {
            this.f14613f = new WeakReference<>(aVar);
            this.f14614g = j10;
            start();
        }

        private final void a() {
            a aVar = this.f14613f.get();
            if (aVar != null) {
                aVar.a();
                this.f14616i = true;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (this.f14615h.await(this.f14614g, TimeUnit.MILLISECONDS)) {
                    return;
                }
                a();
            } catch (InterruptedException unused) {
                a();
            }
        }
    }

    private a(Context context, long j10, boolean z10, boolean z11) {
        Context applicationContext;
        p.k(context);
        if (z10 && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f14608f = context;
        this.f14605c = false;
        this.f14610h = j10;
        this.f14609g = z11;
    }

    public static C0300a b(Context context) {
        c cVar = new c(context);
        boolean a10 = cVar.a("gads:ad_id_app_context:enabled", false);
        float b10 = cVar.b("gads:ad_id_app_context:ping_ratio", 0.0f);
        String c10 = cVar.c("gads:ad_id_use_shared_preference:experiment_id", "");
        a aVar = new a(context, -1L, a10, cVar.a("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            aVar.h(false);
            C0300a c11 = aVar.c();
            aVar.i(c11, a10, b10, SystemClock.elapsedRealtime() - elapsedRealtime, c10, null);
            return c11;
        } finally {
        }
    }

    public static void d(boolean z10) {
    }

    private static l2.d e(Context context, z1.a aVar) {
        try {
            return e.i(aVar.a(10000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private static z1.a f(Context context, boolean z10) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int j10 = com.google.android.gms.common.c.h().j(context, com.google.android.gms.common.e.f5095a);
            if (j10 != 0 && j10 != 2) {
                throw new IOException("Google Play services not available");
            }
            String str = z10 ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
            z1.a aVar = new z1.a();
            Intent intent = new Intent(str);
            intent.setPackage("com.google.android.gms");
            try {
                if (f2.a.b().a(context, intent, aVar, 1)) {
                    return aVar;
                }
                throw new IOException("Connection failure");
            } catch (Throwable th) {
                throw new IOException(th);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            throw new z1.d(9);
        }
    }

    private final void g() {
        synchronized (this.f14606d) {
            b bVar = this.f14607e;
            if (bVar != null) {
                bVar.f14615h.countDown();
                try {
                    this.f14607e.join();
                } catch (InterruptedException unused) {
                }
            }
            if (this.f14610h > 0) {
                this.f14607e = new b(this, this.f14610h);
            }
        }
    }

    private final void h(boolean z10) {
        p.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f14605c) {
                a();
            }
            z1.a f10 = f(this.f14608f, this.f14609g);
            this.f14603a = f10;
            this.f14604b = e(this.f14608f, f10);
            this.f14605c = true;
            if (z10) {
                g();
            }
        }
    }

    private final boolean i(C0300a c0300a, boolean z10, float f10, long j10, String str, Throwable th) {
        if (Math.random() > f10) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("app_context", z10 ? "1" : "0");
        if (c0300a != null) {
            hashMap.put("limit_ad_tracking", c0300a.b() ? "1" : "0");
        }
        if (c0300a != null && c0300a.a() != null) {
            hashMap.put("ad_id_size", Integer.toString(c0300a.a().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j10));
        new v1.b(this, hashMap).start();
        return true;
    }

    public final void a() {
        p.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f14608f == null || this.f14603a == null) {
                return;
            }
            try {
                if (this.f14605c) {
                    f2.a.b().c(this.f14608f, this.f14603a);
                }
            } catch (Throwable unused) {
            }
            this.f14605c = false;
            this.f14604b = null;
            this.f14603a = null;
        }
    }

    public C0300a c() {
        C0300a c0300a;
        p.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.f14605c) {
                synchronized (this.f14606d) {
                    b bVar = this.f14607e;
                    if (bVar == null || !bVar.f14616i) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    h(false);
                    if (!this.f14605c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e10) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e10);
                }
            }
            p.k(this.f14603a);
            p.k(this.f14604b);
            try {
                c0300a = new C0300a(this.f14604b.e(), this.f14604b.Z(true));
            } catch (RemoteException unused) {
                throw new IOException("Remote exception");
            }
        }
        g();
        return c0300a;
    }

    protected void finalize() {
        a();
        super.finalize();
    }
}
