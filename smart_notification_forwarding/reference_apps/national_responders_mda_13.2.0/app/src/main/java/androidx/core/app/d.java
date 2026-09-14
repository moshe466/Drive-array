package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    protected static final Class<?> f2182a;

    /* renamed from: b, reason: collision with root package name */
    protected static final Field f2183b;

    /* renamed from: c, reason: collision with root package name */
    protected static final Field f2184c;

    /* renamed from: d, reason: collision with root package name */
    protected static final Method f2185d;

    /* renamed from: e, reason: collision with root package name */
    protected static final Method f2186e;

    /* renamed from: f, reason: collision with root package name */
    protected static final Method f2187f;

    /* renamed from: g, reason: collision with root package name */
    private static final Handler f2188g = new Handler(Looper.getMainLooper());

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ C0028d f2189f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Object f2190g;

        a(C0028d c0028d, Object obj) {
            this.f2189f = c0028d;
            this.f2190g = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2189f.f2195f = this.f2190g;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Application f2191f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ C0028d f2192g;

        b(Application application, C0028d c0028d) {
            this.f2191f = application;
            this.f2192g = c0028d;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2191f.unregisterActivityLifecycleCallbacks(this.f2192g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f2193f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Object f2194g;

        c(Object obj, Object obj2) {
            this.f2193f = obj;
            this.f2194g = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = d.f2185d;
                if (method != null) {
                    method.invoke(this.f2193f, this.f2194g, Boolean.FALSE, "AppCompat recreation");
                } else {
                    d.f2186e.invoke(this.f2193f, this.f2194g, Boolean.FALSE);
                }
            } catch (RuntimeException e10) {
                if (e10.getClass() == RuntimeException.class && e10.getMessage() != null && e10.getMessage().startsWith("Unable to stop")) {
                    throw e10;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: androidx.core.app.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C0028d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: f, reason: collision with root package name */
        Object f2195f;

        /* renamed from: g, reason: collision with root package name */
        private Activity f2196g;

        /* renamed from: h, reason: collision with root package name */
        private final int f2197h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f2198i = false;

        /* renamed from: j, reason: collision with root package name */
        private boolean f2199j = false;

        /* renamed from: k, reason: collision with root package name */
        private boolean f2200k = false;

        C0028d(Activity activity) {
            this.f2196g = activity;
            this.f2197h = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f2196g == activity) {
                this.f2196g = null;
                this.f2199j = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f2199j || this.f2200k || this.f2198i || !d.h(this.f2195f, this.f2197h, activity)) {
                return;
            }
            this.f2200k = true;
            this.f2195f = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f2196g == activity) {
                this.f2198i = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> a10 = a();
        f2182a = a10;
        f2183b = b();
        f2184c = f();
        f2185d = d(a10);
        f2186e = c(a10);
        f2187f = e(a10);
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 == 26 || i10 == 27;
    }

    protected static boolean h(Object obj, int i10, Activity activity) {
        try {
            Object obj2 = f2184c.get(activity);
            if (obj2 == obj && activity.hashCode() == i10) {
                f2188g.postAtFrontOfQueue(new c(f2183b.get(activity), obj2));
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f2187f == null) {
            return false;
        }
        if (f2186e == null && f2185d == null) {
            return false;
        }
        try {
            Object obj2 = f2184c.get(activity);
            if (obj2 == null || (obj = f2183b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            C0028d c0028d = new C0028d(activity);
            application.registerActivityLifecycleCallbacks(c0028d);
            Handler handler = f2188g;
            handler.post(new a(c0028d, obj2));
            try {
                if (g()) {
                    Method method = f2187f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, c0028d));
                return true;
            } catch (Throwable th) {
                f2188g.post(new b(application, c0028d));
                throw th;
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
