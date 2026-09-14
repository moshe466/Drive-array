package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.h;
import androidx.lifecycle.u;

/* loaded from: classes.dex */
public class t implements l {

    /* renamed from: n, reason: collision with root package name */
    private static final t f3218n = new t();

    /* renamed from: j, reason: collision with root package name */
    private Handler f3223j;

    /* renamed from: f, reason: collision with root package name */
    private int f3219f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f3220g = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3221h = true;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3222i = true;

    /* renamed from: k, reason: collision with root package name */
    private final m f3224k = new m(this);

    /* renamed from: l, reason: collision with root package name */
    private Runnable f3225l = new a();

    /* renamed from: m, reason: collision with root package name */
    u.a f3226m = new b();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t.this.i();
            t.this.j();
        }
    }

    /* loaded from: classes.dex */
    class b implements u.a {
        b() {
        }

        @Override // androidx.lifecycle.u.a
        public void a() {
        }

        @Override // androidx.lifecycle.u.a
        public void b() {
            t.this.c();
        }

        @Override // androidx.lifecycle.u.a
        public void c() {
            t.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends d {

        /* loaded from: classes.dex */
        class a extends d {
            a() {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                t.this.c();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                t.this.d();
            }
        }

        c() {
        }

        @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 29) {
                u.f(activity).h(t.this.f3226m);
            }
        }

        @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            t.this.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            t.this.g();
        }
    }

    private t() {
    }

    public static l k() {
        return f3218n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(Context context) {
        f3218n.h(context);
    }

    void a() {
        int i10 = this.f3220g - 1;
        this.f3220g = i10;
        if (i10 == 0) {
            this.f3223j.postDelayed(this.f3225l, 700L);
        }
    }

    @Override // androidx.lifecycle.l
    public h b() {
        return this.f3224k;
    }

    void c() {
        int i10 = this.f3220g + 1;
        this.f3220g = i10;
        if (i10 == 1) {
            if (!this.f3221h) {
                this.f3223j.removeCallbacks(this.f3225l);
            } else {
                this.f3224k.h(h.b.ON_RESUME);
                this.f3221h = false;
            }
        }
    }

    void d() {
        int i10 = this.f3219f + 1;
        this.f3219f = i10;
        if (i10 == 1 && this.f3222i) {
            this.f3224k.h(h.b.ON_START);
            this.f3222i = false;
        }
    }

    void g() {
        this.f3219f--;
        j();
    }

    void h(Context context) {
        this.f3223j = new Handler();
        this.f3224k.h(h.b.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new c());
    }

    void i() {
        if (this.f3220g == 0) {
            this.f3221h = true;
            this.f3224k.h(h.b.ON_PAUSE);
        }
    }

    void j() {
        if (this.f3219f == 0 && this.f3221h) {
            this.f3224k.h(h.b.ON_STOP);
            this.f3222i = true;
        }
    }
}
