package com.groboot.mdaemergency.alwaysOn_Old.services;

import android.app.Service;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.groboot.mdaemergency.alwaysOn_Old.receivers.ScreenReceiver;
import com.groboot.mdaemergency.alwaysOn_Old.receivers.UnlockReceiver;
import com.groboot.mdaemergency.ptt.p;
import com.groboot.mdaemergency.ptt.s;
import com.groboot.mdaemergency.ui.main.SplashActivity;
import g5.e;
import i5.a;
import il.org.mda.health.R;
import java.lang.Thread;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import w6.r;

/* loaded from: classes.dex */
public class AlwaysOnOldMainService extends Service implements SensorEventListener {
    public static boolean A;
    public static boolean B;
    public static boolean C;
    public static final String[] D = {"android.intent.action.USER_PRESENT", "android.intent.action.ASSIST", "android.intent.action.PHONE_STATE", "android.intent.action.SHOW_ALARMS", "com.android.deskclock.ALARM_ALERT", "com.android.alarmclock.ALARM_ALERT", "com.samsung.sec.android.clockpackage.alarm.ALARM_ALERT", "com.htc.android.worldclock.ALARM_ALERT", "com.sonyericsson.alarm.ALARM_ALERT", "zte.com.cn.alarmclock.ALARM_ALERT", "com.motorola.blur.alarmclock.ALARM_ALERT", "com.urbandroid.sleep.alarmclock.ALARM_ALERT", "com.lge.alarm.alarmclocknew", "com.sec.android.app.clockpackage.alarm.ALARM_ALERT", "com.samsung.sec.android.clockpackage.alarm.ALARM_STARTED_IN_ALERT", "com.sec.android.app.clockpackage.SHOW_ALARMS", "com.samsung.sec.android.clockpackage.START_CLOCKPACKAGE"};

    /* renamed from: f, reason: collision with root package name */
    com.groboot.mdaemergency.ptt.m f7548f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f7549g;

    /* renamed from: j, reason: collision with root package name */
    private FrameLayout f7552j;

    /* renamed from: k, reason: collision with root package name */
    private Timer f7553k;

    /* renamed from: l, reason: collision with root package name */
    private WindowManager f7554l;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f7555m;

    /* renamed from: n, reason: collision with root package name */
    private View f7556n;

    /* renamed from: o, reason: collision with root package name */
    private WindowManager.LayoutParams f7557o;

    /* renamed from: p, reason: collision with root package name */
    private WindowManager.LayoutParams f7558p;

    /* renamed from: q, reason: collision with root package name */
    private PowerManager.WakeLock f7559q;

    /* renamed from: r, reason: collision with root package name */
    private UnlockReceiver f7560r;

    /* renamed from: s, reason: collision with root package name */
    private PowerManager.WakeLock f7561s;

    /* renamed from: t, reason: collision with root package name */
    private SensorManager f7562t;

    /* renamed from: u, reason: collision with root package name */
    private Handler f7563u;

    /* renamed from: y, reason: collision with root package name */
    private boolean f7567y;

    /* renamed from: z, reason: collision with root package name */
    boolean f7568z;

    /* renamed from: h, reason: collision with root package name */
    private boolean f7550h = true;

    /* renamed from: i, reason: collision with root package name */
    private int f7551i = 12000;

    /* renamed from: v, reason: collision with root package name */
    int f7564v = 1;

    /* renamed from: w, reason: collision with root package name */
    int f7565w = 2;

    /* renamed from: x, reason: collision with root package name */
    int f7566x = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends TimerTask {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean[] f7569f;

        a(boolean[] zArr) {
            this.f7569f = zArr;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.f7569f[0]) {
                AlwaysOnOldMainService.this.r();
            }
            this.f7569f[0] = !r0[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!AlwaysOnOldMainService.this.f7559q.isHeld() && !AlwaysOnOldMainService.this.f7549g) {
                AlwaysOnOldMainService.this.f7559q.acquire();
            }
            AlwaysOnOldMainService.this.f7556n.startAnimation(AnimationUtils.loadAnimation(AlwaysOnOldMainService.this.getApplicationContext(), R.anim.fade_in));
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlwaysOnOldMainService.this.f7555m.getWindowToken() != null) {
                AlwaysOnOldMainService.this.f7554l.removeView(AlwaysOnOldMainService.this.f7555m);
                AlwaysOnOldMainService.this.t(false, false, false);
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements Runnable {
        d(AlwaysOnOldMainService alwaysOnOldMainService) {
        }

        @Override // java.lang.Runnable
        public void run() {
            h5.a.f10462d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (i5.a.b(AlwaysOnOldMainService.this)) {
                    ((DevicePolicyManager) AlwaysOnOldMainService.this.getSystemService("device_policy")).lockNow();
                }
            } catch (SecurityException unused) {
                if (i5.a.b(AlwaysOnOldMainService.this)) {
                    ((DevicePolicyManager) AlwaysOnOldMainService.this.getSystemService("device_policy")).lockNow();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ SensorEvent f7574f;

        f(SensorEvent sensorEvent) {
            this.f7574f = sensorEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlwaysOnOldMainService.this.onSensorChanged(this.f7574f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!AlwaysOnOldMainService.this.f7550h) {
                AlwaysOnOldMainService.this.s();
            }
            if (AlwaysOnOldMainService.this.f7549g) {
                return;
            }
            AlwaysOnOldMainService.this.f7559q.acquire();
        }
    }

    /* loaded from: classes.dex */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlwaysOnOldMainService.this.f7559q.acquire();
            AlwaysOnOldMainService.this.f7559q.release();
        }
    }

    /* loaded from: classes.dex */
    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlwaysOnOldMainService.this.z();
            AlwaysOnOldMainService.A = true;
            AlwaysOnOldMainService.this.y();
        }
    }

    /* loaded from: classes.dex */
    class j implements Thread.UncaughtExceptionHandler {
        j() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            AlwaysOnOldMainService.this.q(th);
        }
    }

    /* loaded from: classes.dex */
    class k extends FrameLayout {
        k(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            AlwaysOnOldMainService alwaysOnOldMainService = AlwaysOnOldMainService.this;
            alwaysOnOldMainService.o(alwaysOnOldMainService.f7564v);
            return super.dispatchKeyEvent(keyEvent);
        }
    }

    /* loaded from: classes.dex */
    class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlwaysOnOldMainService.this.f7548f.f7873m.setVisibility(8);
        }
    }

    /* loaded from: classes.dex */
    class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlwaysOnOldMainService alwaysOnOldMainService = AlwaysOnOldMainService.this;
            alwaysOnOldMainService.o(alwaysOnOldMainService.f7564v);
            Intent intent = new Intent(AlwaysOnOldMainService.this.getApplicationContext(), (Class<?>) SplashActivity.class);
            intent.setFlags(268435456);
            intent.putExtra(com.groboot.mdaemergency.ptt.p.f7896v, "FloatViewService");
            intent.putExtra(com.groboot.mdaemergency.ptt.p.f7897w, com.groboot.mdaemergency.ptt.p.f7899y);
            AlwaysOnOldMainService.this.startActivity(intent);
        }
    }

    /* loaded from: classes.dex */
    class n implements p.b0 {
        n() {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void a() {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void b(com.groboot.mdaemergency.ptt.p pVar) {
            if (pVar == null) {
                return;
            }
            pVar.E(s.a.service, AlwaysOnOldMainService.this.p());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f7584f;

        o(int i10) {
            this.f7584f = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlwaysOnOldMainService alwaysOnOldMainService = AlwaysOnOldMainService.this;
            if (!alwaysOnOldMainService.f7568z) {
                alwaysOnOldMainService.o(alwaysOnOldMainService.f7564v);
            } else {
                alwaysOnOldMainService.f7568z = false;
                alwaysOnOldMainService.n(this.f7584f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p implements s {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.groboot.mdaemergency.ptt.a f7587f;

            a(com.groboot.mdaemergency.ptt.a aVar) {
                this.f7587f = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AlwaysOnOldMainService.this.f7548f.f7873m.setVisibility(0);
                    AlwaysOnOldMainService.this.f7548f.g(this.f7587f);
                } catch (Exception unused) {
                }
            }
        }

        p() {
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void a(String str) {
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public boolean b(com.groboot.mdaemergency.ptt.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("lock screen service :");
            sb2.append(aVar.f7788b.f15238d);
            AlwaysOnOldMainService.this.f7548f.f7873m.post(new a(aVar));
            return true;
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void c(com.groboot.mdaemergency.ptt.a aVar) {
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void d(p.a0 a0Var, p.a0 a0Var2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("status:");
            sb2.append(a0Var);
            AlwaysOnOldMainService alwaysOnOldMainService = AlwaysOnOldMainService.this;
            alwaysOnOldMainService.f7568z = true;
            alwaysOnOldMainService.f7548f.k();
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void e(w6.p pVar) {
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void f(com.groboot.mdaemergency.ptt.a aVar) {
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void g(r rVar) {
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void h(e.a aVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i10) {
        this.f7563u.postDelayed(new o(i10), i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(int i10) {
        if (i10 == this.f7564v) {
            A = true;
            y();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public s p() {
        return new p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.f7553k = new Timer();
        this.f7553k.schedule(new a(new boolean[]{true}), 0L, this.f7551i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z10, boolean z11, boolean z12) {
        AlphaAnimation alphaAnimation;
        if (z12 && z10) {
            if (!C) {
                new Handler().postDelayed(new b(), 300L);
            }
        } else if (z10) {
            boolean z13 = this.f7556n.getAlpha() == 1.0f;
            if (z11 && z13) {
                alphaAnimation = new AlphaAnimation(1.0f, 0.3f);
            } else if (!z11 && !z13) {
                alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
            }
            alphaAnimation.setDuration(17694722L);
            this.f7556n.startAnimation(alphaAnimation);
        }
        if (i5.a.d()) {
            Settings.System.canWrite(this);
        }
    }

    private void u() {
    }

    private void v(boolean z10) {
        if (this.f7558p == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2003, 65794, -2);
            this.f7558p = layoutParams;
            layoutParams.type = i5.a.f(getApplicationContext()) ? 2005 : 2010;
        }
        if (this.f7552j == null) {
            this.f7552j = new FrameLayout(this);
        }
        this.f7552j.setBackgroundColor(-16777216);
        this.f7552j.setForegroundGravity(17);
        try {
            if (z10) {
                if (!this.f7552j.isAttachedToWindow()) {
                    this.f7554l.addView(this.f7552j, this.f7558p);
                }
            } else if (this.f7552j.isAttachedToWindow()) {
                this.f7554l.removeView(this.f7552j);
            }
        } catch (IllegalStateException unused) {
        }
    }

    public static boolean w(Context context) {
        if (B) {
            return false;
        }
        if (h5.a.f10464f) {
            i5.a.g("Shouldn't start because", "Waiting for app");
            return false;
        }
        B = true;
        context.startService(new Intent(context, (Class<?>) AlwaysOnOldMainService.class));
        h5.a.f10459a = true;
        return true;
    }

    public static void x(Context context) {
        i5.a.g("Trying to stop, Main service is initialized", String.valueOf(B));
        context.stopService(new Intent(context, (Class<?>) AlwaysOnOldMainService.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        new Thread(new e()).start();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new j());
        h5.a.f10463e = true;
        PowerManager.WakeLock newWakeLock = ((PowerManager) getApplicationContext().getSystemService("power")).newWakeLock(268435482, "StayAwakeWakeLock");
        this.f7559q = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        A = false;
        this.f7554l = (WindowManager) getSystemService("window");
        setTheme(R.style.AppTheme);
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        k kVar = new k(this);
        this.f7555m = kVar;
        kVar.setBackgroundColor(-16777216);
        this.f7555m.setForegroundGravity(17);
        this.f7556n = (RelativeLayout) layoutInflater.inflate(R.layout.ptt_lockscreen_view, this.f7555m).findViewById(R.id.main_layout);
        this.f7548f = new com.groboot.mdaemergency.ptt.m(getApplicationContext(), this.f7556n, new l());
        this.f7555m.findViewById(R.id.btn_moveToApp).setOnClickListener(new m());
        if (com.groboot.mdaemergency.ptt.p.c0() == null || com.groboot.mdaemergency.ptt.p.c0().e0() == null) {
            this.f7548f.f7873m.setVisibility(8);
        } else {
            this.f7548f.f7873m.setVisibility(0);
            this.f7548f.g(com.groboot.mdaemergency.ptt.p.c0().e0());
        }
        u();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.f7556n.setLayoutParams(layoutParams);
        this.f7560r = new UnlockReceiver();
        IntentFilter intentFilter = new IntentFilter();
        for (String str : D) {
            intentFilter.addAction(str);
        }
        unregisterReceiver(this.f7560r);
        registerReceiver(this.f7560r, intentFilter);
        this.f7562t = (SensorManager) getSystemService("sensor");
        if (!i5.a.c() || i5.a.f(getApplicationContext())) {
            Sensor defaultSensor = this.f7562t.getDefaultSensor(8);
            if (defaultSensor != null) {
                this.f7562t.registerListener(this, defaultSensor, 2, 1000000);
            }
        } else {
            PowerManager.WakeLock newWakeLock2 = ((PowerManager) getSystemService("power")).newWakeLock(32, getPackageName() + " wakelock_holder");
            this.f7561s = newWakeLock2;
            newWakeLock2.acquire();
        }
        Sensor defaultSensor2 = i5.a.c() ? this.f7562t.getDefaultSensor(5, false) : this.f7562t.getDefaultSensor(5);
        if (defaultSensor2 != null) {
            this.f7562t.registerListener(this, defaultSensor2, (int) TimeUnit.SECONDS.toMicros(15L), 500000);
        }
        this.f7563u = new Handler();
        this.f7568z = false;
        n(40000);
        s();
        B = true;
        t(true, false, true);
        com.groboot.mdaemergency.ptt.p.d0(getApplicationContext(), new n());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        B = false;
        com.groboot.mdaemergency.ptt.p.c0().Q0(s.a.service);
        com.groboot.mdaemergency.ptt.p.c0().f1();
        this.f7559q.release();
        PowerManager.WakeLock wakeLock = this.f7561s;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.f7561s.release();
        }
        v(false);
        SensorManager sensorManager = this.f7562t;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        unregisterReceiver(this.f7560r);
        this.f7555m.setOnTouchListener(null);
        if (this.f7555m.getWindowToken() != null) {
            if (A) {
                a.C0198a.a(this.f7555m, new c());
            } else {
                t(false, false, false);
                this.f7554l.removeView(this.f7555m);
            }
        }
        this.f7553k.cancel();
        this.f7563u.removeCallbacksAndMessages(null);
        h5.a.f10459a = false;
        h5.a.f10463e = false;
        new Handler().postDelayed(new d(this), 15000L);
        Thread.setDefaultUncaughtExceptionHandler(null);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 5) {
            float[] fArr = sensorEvent.values;
            boolean z10 = fArr[0] < 2.0f;
            if ((!z10 || this.f7567y) && (z10 || !this.f7567y)) {
                return;
            }
            i5.a.g("Lights changed", String.valueOf(fArr[0]));
            t(true, z10, false);
            this.f7567y = z10;
            return;
        }
        if (type != 8) {
            return;
        }
        i5.a.g("proximity", String.valueOf(sensorEvent.values[0]));
        if (sensorEvent.values[0] < 1.0f) {
            this.f7559q.release();
            h5.a.f10459a = false;
            h5.a.f10460b = false;
            if (C) {
                v(true);
                z();
                return;
            }
            return;
        }
        v(false);
        if (!h5.a.f10460b) {
            new Handler().postDelayed(new f(sensorEvent), 200L);
            return;
        }
        if (!C) {
            ScreenReceiver.a(this, false);
        }
        h5.a.f10459a = true;
        new Handler().postDelayed(new g(), 500L);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (this.f7557o == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2003, 65794, -2);
            this.f7557o = layoutParams;
            boolean z10 = false;
            if (intent != null) {
                intent.getBooleanExtra("demo", false);
                WindowManager.LayoutParams layoutParams2 = this.f7557o;
                if (intent.getBooleanExtra("demo", false)) {
                    r1 = 2006;
                } else if (!i5.a.f(getApplicationContext())) {
                    r1 = 2010;
                }
                layoutParams2.type = r1;
            } else {
                layoutParams.type = i5.a.f(getApplicationContext()) ? 2005 : 2010;
            }
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this)) {
                Intent intent2 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName()));
                intent2.setFlags(268435456);
                if (i5.a.a(this, intent2)) {
                    startActivity(intent2);
                }
                return super.onStartCommand(intent, i10, i11);
            }
            this.f7554l.addView(this.f7555m, this.f7557o);
            if (intent != null && intent.getBooleanExtra("raise_to_wake", false)) {
                z10 = true;
            }
            this.f7549g = z10;
            if (z10) {
                this.f7563u.postDelayed(new h(), 100L);
                this.f7563u.postDelayed(new i(), 10000L);
            }
        }
        return super.onStartCommand(intent, i10, i11);
    }

    public void q(Throwable th) {
        Context applicationContext = getApplicationContext();
        th.printStackTrace();
        Toast.makeText(applicationContext, "UncaughtException: " + th.getMessage(), 0).show();
        t(false, false, false);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException unused) {
        }
    }

    public void y() {
        i5.a.g("Stopping service", "now");
        if (B) {
            stopSelf();
        } else {
            i5.a.g(AlwaysOnOldMainService.class.getSimpleName(), "Shouldn't kill the service: service wasn't initialized correctly");
        }
    }
}
