package com.groboot.mdaemergency;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.google.firebase.crashlytics.c;
import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.ptt.PTTService;
import com.groboot.mdaemergency.services.GoogleTokenService;
import com.groboot.mdaemergency.ui.LockPatternActivity;
import com.groboot.mdaemergency.ui.main.MainActivity;
import com.groboot.mdaemergency.ui.main.SplashActivity;
import l5.b;
import w6.a0;
import w6.l0;
import w6.m;
import w6.n;
import w6.x;

/* loaded from: classes.dex */
public class MdaEmergencyApplication extends Application implements Application.ActivityLifecycleCallbacks {

    /* renamed from: g, reason: collision with root package name */
    public static String f7530g = "";

    /* renamed from: h, reason: collision with root package name */
    private static int f7531h;

    /* renamed from: i, reason: collision with root package name */
    private static final com.groboot.mdaemergency.enums.a f7532i = com.groboot.mdaemergency.enums.a.CREW;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f7533j = false;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f7534k = false;

    /* renamed from: l, reason: collision with root package name */
    private static MdaEmergencyApplication f7535l;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7536f;

    public static com.groboot.mdaemergency.enums.a a() {
        return f7532i;
    }

    public static synchronized Context b() {
        Context applicationContext;
        synchronized (MdaEmergencyApplication.class) {
            applicationContext = f7535l.getApplicationContext();
        }
        return applicationContext;
    }

    public static boolean c() {
        return f7531h > 0;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        a0.b(context);
        super.attachBaseContext(n.d(context, m.u().getCode()));
        if (Build.VERSION.SDK_INT < 22) {
            n0.a.l(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        f7531h--;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            if ((activity instanceof MainActivity) || (activity instanceof SplashActivity) || (activity instanceof LockPatternActivity)) {
                ((NotificationManager) getSystemService("notification")).cancelAll();
            }
            f7531h++;
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application
    public void onCreate() {
        f7535l = this;
        if (m.k() != null) {
            c.a().c("myAppUserId");
        }
        registerActivityLifecycleCallbacks(this);
        try {
            f7530g = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
        }
        b.a().c(this);
        m.c0(f7532i);
        d.P(getApplicationContext());
        s5.d.n(getApplicationContext());
        getApplicationContext();
        new o5.a().start();
        a0.g(getApplicationContext());
        x.M(getApplicationContext());
        l0.D0(getApplicationContext());
        p5.d.l(getApplicationContext());
        PTTService.j(getApplicationContext());
        GoogleTokenService.c(getApplicationContext());
        super.onCreate();
    }
}
