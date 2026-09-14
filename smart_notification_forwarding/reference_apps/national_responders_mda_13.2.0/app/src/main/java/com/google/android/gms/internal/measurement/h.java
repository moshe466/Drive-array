package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class h {

    /* renamed from: i, reason: collision with root package name */
    private static volatile h f5346i = null;

    /* renamed from: j, reason: collision with root package name */
    private static Boolean f5347j = null;

    /* renamed from: k, reason: collision with root package name */
    private static String f5348k = "allow_remote_dynamite";

    /* renamed from: l, reason: collision with root package name */
    private static boolean f5349l = true;

    /* renamed from: a, reason: collision with root package name */
    private final String f5350a;

    /* renamed from: b, reason: collision with root package name */
    protected final g2.e f5351b;

    /* renamed from: c, reason: collision with root package name */
    private final ExecutorService f5352c;

    /* renamed from: d, reason: collision with root package name */
    private final u2.a f5353d;

    /* renamed from: e, reason: collision with root package name */
    private final List<Pair<v2.l, c>> f5354e;

    /* renamed from: f, reason: collision with root package name */
    private int f5355f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5356g;

    /* renamed from: h, reason: collision with root package name */
    private volatile qf f5357h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final long f5358f;

        /* renamed from: g, reason: collision with root package name */
        final long f5359g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f5360h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(h hVar) {
            this(true);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(boolean z10) {
            this.f5358f = h.this.f5351b.a();
            this.f5359g = h.this.f5351b.b();
            this.f5360h = z10;
        }

        abstract void a();

        protected void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f5356g) {
                b();
                return;
            }
            try {
                a();
            } catch (Exception e10) {
                h.this.m(e10, false, this.f5360h);
                b();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            h.this.j(new f0(this, bundle, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            h.this.j(new k0(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            h.this.j(new g0(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            h.this.j(new h0(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            of ofVar = new of();
            h.this.j(new i0(this, activity, ofVar));
            Bundle z10 = ofVar.z(50L);
            if (z10 != null) {
                bundle.putAll(z10);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            h.this.j(new e0(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            h.this.j(new j0(this, activity));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends com.google.android.gms.internal.measurement.b {

        /* renamed from: a, reason: collision with root package name */
        private final v2.l f5363a;

        c(v2.l lVar) {
            this.f5363a = lVar;
        }

        @Override // com.google.android.gms.internal.measurement.c
        public final void C(String str, String str2, Bundle bundle, long j10) {
            this.f5363a.a(str, str2, bundle, j10);
        }

        @Override // com.google.android.gms.internal.measurement.c
        public final int zza() {
            return System.identityHashCode(this.f5363a);
        }
    }

    private h(Context context, String str, String str2, String str3, Bundle bundle) {
        this.f5350a = (str == null || !E(str2, str3)) ? "FA" : str;
        this.f5351b = g2.h.d();
        this.f5352c = n7.a().a(new o(this), nf.f5509a);
        this.f5353d = new u2.a(this);
        this.f5354e = new ArrayList();
        if (!(!J(context) || Q())) {
            this.f5356g = true;
            return;
        }
        E(str2, str3);
        j(new k(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean E(String str, String str2) {
        return (str2 == null || str == null || Q()) ? false : true;
    }

    private static boolean J(Context context) {
        return v2.n.a(context, "google_app_id") != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int K(Context context) {
        return DynamiteModule.b(context, ModuleDescriptor.MODULE_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int M(Context context) {
        return DynamiteModule.a(context, ModuleDescriptor.MODULE_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void O(Context context) {
        synchronized (h.class) {
            try {
            } catch (Exception unused) {
                f5347j = Boolean.valueOf(f5349l);
            }
            if (f5347j != null) {
                return;
            }
            if (s(context, "app_measurement_internal_disable_startup_flags")) {
                f5347j = Boolean.valueOf(f5349l);
                return;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
            f5347j = Boolean.valueOf(sharedPreferences.getBoolean(f5348k, f5349l));
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(f5348k);
            edit.apply();
        }
    }

    private static boolean Q() {
        return true;
    }

    public static h a(Context context) {
        return b(context, null, null, null, null);
    }

    public static h b(Context context, String str, String str2, String str3, Bundle bundle) {
        b2.p.k(context);
        if (f5346i == null) {
            synchronized (h.class) {
                if (f5346i == null) {
                    f5346i = new h(context, str, str2, str3, bundle);
                }
            }
        }
        return f5346i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(a aVar) {
        this.f5352c.execute(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(Exception exc, boolean z10, boolean z11) {
        this.f5356g |= z10;
        if (!z10 && z11) {
            g(5, "Error with data collection. Data lost.", exc, null, null);
        }
    }

    private final void o(String str, String str2, Bundle bundle, boolean z10, boolean z11, Long l10) {
        j(new d0(this, l10, str, str2, bundle, z10, z11));
    }

    private static boolean s(Context context, String str) {
        Bundle bundle;
        b2.p.g(str);
        try {
            ApplicationInfo c10 = i2.c.a(context).c(context.getPackageName(), 128);
            if (c10 != null && (bundle = c10.metaData) != null) {
                return bundle.getBoolean(str);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public final String C() {
        of ofVar = new of();
        j(new s(this, ofVar));
        return ofVar.p(500L);
    }

    public final void D(String str) {
        j(new p(this, str));
    }

    public final int G(String str) {
        of ofVar = new of();
        j(new z(this, str, ofVar));
        Integer num = (Integer) of.n(ofVar.z(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final String H() {
        of ofVar = new of();
        j(new r(this, ofVar));
        return ofVar.p(50L);
    }

    public final long I() {
        of ofVar = new of();
        j(new u(this, ofVar));
        Long l10 = (Long) of.n(ofVar.z(500L), Long.class);
        if (l10 != null) {
            return l10.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.f5351b.a()).nextLong();
        int i10 = this.f5355f + 1;
        this.f5355f = i10;
        return nextLong + i10;
    }

    public final String L() {
        of ofVar = new of();
        j(new t(this, ofVar));
        return ofVar.p(500L);
    }

    public final String N() {
        of ofVar = new of();
        j(new x(this, ofVar));
        return ofVar.p(500L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final qf c(Context context, boolean z10) {
        try {
            return pf.asInterface(DynamiteModule.d(context, z10 ? DynamiteModule.f5134d : DynamiteModule.f5132b, ModuleDescriptor.MODULE_ID).c("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.a e10) {
            m(e10, true, false);
            return null;
        }
    }

    public final Map<String, Object> e(String str, String str2, boolean z10) {
        of ofVar = new of();
        j(new w(this, str, str2, z10, ofVar));
        Bundle z11 = ofVar.z(5000L);
        if (z11 == null || z11.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(z11.size());
        for (String str3 : z11.keySet()) {
            Object obj = z11.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final u2.a f() {
        return this.f5353d;
    }

    public final void g(int i10, String str, Object obj, Object obj2, Object obj3) {
        j(new y(this, false, 5, str, obj, null, null));
    }

    public final void h(Activity activity, String str, String str2) {
        j(new n(this, activity, str, str2));
    }

    public final void i(Bundle bundle) {
        j(new j(this, bundle));
    }

    public final void n(String str, String str2, Bundle bundle) {
        o(str, str2, bundle, true, true, null);
    }

    public final void p(String str, String str2, Object obj, boolean z10) {
        j(new c0(this, str, str2, obj, z10));
    }

    public final void q(v2.l lVar) {
        b2.p.k(lVar);
        synchronized (this.f5354e) {
            for (int i10 = 0; i10 < this.f5354e.size(); i10++) {
                if (lVar.equals(this.f5354e.get(i10).first)) {
                    return;
                }
            }
            c cVar = new c(lVar);
            this.f5354e.add(new Pair<>(lVar, cVar));
            if (this.f5357h != null) {
                try {
                    this.f5357h.registerOnMeasurementEventListener(cVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                }
            }
            j(new b0(this, cVar));
        }
    }

    public final void r(boolean z10) {
        j(new a0(this, z10));
    }

    public final List<Bundle> w(String str, String str2) {
        of ofVar = new of();
        j(new l(this, str, str2, ofVar));
        List<Bundle> list = (List) of.n(ofVar.z(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void y(String str) {
        j(new q(this, str));
    }

    public final void z(String str, String str2, Bundle bundle) {
        j(new m(this, str, str2, bundle));
    }
}
