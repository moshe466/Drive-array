package com.groboot.mdaemergency.ptt;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.Point;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.groboot.mdaemergency.ui.main.SplashActivity;
import il.org.mda.health.R;
import java.util.Date;
import java.util.Iterator;
import w6.d0;

/* loaded from: classes.dex */
public class PttFloatingWindow extends Service {

    /* renamed from: r, reason: collision with root package name */
    public static boolean f7753r;

    /* renamed from: f, reason: collision with root package name */
    WindowManager f7754f;

    /* renamed from: g, reason: collision with root package name */
    View f7755g;

    /* renamed from: h, reason: collision with root package name */
    View f7756h;

    /* renamed from: i, reason: collision with root package name */
    int f7757i;

    /* renamed from: j, reason: collision with root package name */
    int f7758j;

    /* renamed from: k, reason: collision with root package name */
    int f7759k;

    /* renamed from: l, reason: collision with root package name */
    Point f7760l;

    /* renamed from: m, reason: collision with root package name */
    Point f7761m;

    /* renamed from: p, reason: collision with root package name */
    long f7764p;

    /* renamed from: n, reason: collision with root package name */
    int[] f7762n = new int[20];

    /* renamed from: o, reason: collision with root package name */
    int f7763o = -1;

    /* renamed from: q, reason: collision with root package name */
    e f7765q = e.None;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {

        /* renamed from: f, reason: collision with root package name */
        private WindowManager.LayoutParams f7766f;

        /* renamed from: g, reason: collision with root package name */
        int f7767g;

        /* renamed from: h, reason: collision with root package name */
        int f7768h;

        /* renamed from: i, reason: collision with root package name */
        float f7769i;

        /* renamed from: j, reason: collision with root package name */
        float f7770j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ WindowManager.LayoutParams f7771k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ WindowManager.LayoutParams f7772l;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.groboot.mdaemergency.ptt.PttFloatingWindow$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0103a implements Runnable {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ f f7774f;

            /* renamed from: com.groboot.mdaemergency.ptt.PttFloatingWindow$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC0104a implements Runnable {
                RunnableC0104a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    PttFloatingWindow pttFloatingWindow = PttFloatingWindow.this;
                    pttFloatingWindow.f7754f.updateViewLayout(pttFloatingWindow.f7755g, aVar.f7766f);
                }
            }

            RunnableC0103a(f fVar) {
                this.f7774f = fVar;
            }

            private void a() {
                PttFloatingWindow pttFloatingWindow = PttFloatingWindow.this;
                pttFloatingWindow.f7763o = -1;
                pttFloatingWindow.f7762n = new int[20];
            }

            private int[] b() {
                int[] iArr = new int[20];
                int i10 = 0;
                for (int i11 = PttFloatingWindow.this.f7763o; i11 > 0; i11--) {
                    int[] iArr2 = PttFloatingWindow.this.f7762n;
                    int i12 = i11 - 1;
                    if (iArr2[i12] > 0) {
                        iArr[i10] = iArr2[i11] - iArr2[i12];
                        i10++;
                    }
                }
                int[] iArr3 = PttFloatingWindow.this.f7762n;
                if (iArr3[iArr3.length - 1] > 0) {
                    iArr[i10] = iArr3[0] - iArr3[iArr3.length - 1];
                    i10++;
                }
                int length = iArr3.length;
                while (true) {
                    length--;
                    PttFloatingWindow pttFloatingWindow = PttFloatingWindow.this;
                    if (length <= pttFloatingWindow.f7763o + 1) {
                        return iArr;
                    }
                    int[] iArr4 = pttFloatingWindow.f7762n;
                    int i13 = length - 1;
                    if (iArr4[i13] > 0) {
                        iArr[i10] = iArr4[length] - iArr4[i13];
                        i10++;
                    }
                }
            }

            private int c() {
                int[] b10 = b();
                int i10 = 0;
                for (int i11 : b10) {
                    i10 += i11;
                }
                return i10 / b10.length;
            }

            @Override // java.lang.Runnable
            public void run() {
                Point h10 = a.this.h();
                PttFloatingWindow pttFloatingWindow = PttFloatingWindow.this;
                int i10 = pttFloatingWindow.f7761m.x - pttFloatingWindow.f7757i;
                int c10 = c();
                a();
                int i11 = 0;
                while (true) {
                    f fVar = this.f7774f;
                    if (fVar == f.Right) {
                        if (h10.x >= i10) {
                            return;
                        }
                    } else if (h10.x <= 0) {
                        return;
                    }
                    a aVar = a.this;
                    f fVar2 = f.Left;
                    int i12 = h10.x;
                    if (fVar != fVar2) {
                        i12 = i10 - i12;
                    }
                    int o10 = aVar.o(i12);
                    i11++;
                    if (i11 < 8) {
                        o10 = i11 * 2;
                    }
                    if (this.f7774f == fVar2) {
                        o10 *= -1;
                    }
                    a.this.k("Slide", o10);
                    if (c10 != 0) {
                        a.this.l("Slide", c10);
                        c10 = (int) (c10 * 0.95d);
                    }
                    new Handler(Looper.getMainLooper()).post(new RunnableC0104a());
                    d0.a(16L);
                    h10 = a.this.h();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: com.groboot.mdaemergency.ptt.PttFloatingWindow$a$b$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC0105a implements Runnable {
                RunnableC0105a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    PttFloatingWindow pttFloatingWindow = PttFloatingWindow.this;
                    pttFloatingWindow.f7754f.updateViewLayout(pttFloatingWindow.f7755g, aVar.f7766f);
                }
            }

            /* renamed from: com.groboot.mdaemergency.ptt.PttFloatingWindow$a$b$b, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC0106b implements Runnable {
                RunnableC0106b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    PttFloatingWindow pttFloatingWindow = PttFloatingWindow.this;
                    pttFloatingWindow.f7754f.updateViewLayout(pttFloatingWindow.f7755g, aVar.f7766f);
                }
            }

            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Point h10 = a.this.h();
                Point g10 = a.this.g();
                int i10 = g10.x;
                PttFloatingWindow pttFloatingWindow = PttFloatingWindow.this;
                int i11 = pttFloatingWindow.f7759k;
                int i12 = pttFloatingWindow.f7757i;
                int i13 = i10 + ((i11 - i12) / 2);
                int i14 = g10.y + ((i11 - i12) / 2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("required_x:");
                sb2.append(i13);
                sb2.append(" required_y:");
                sb2.append(i14);
                int i15 = 7;
                while (true) {
                    int i16 = h10.x;
                    if (i16 != i13 || h10.y != i14) {
                        a aVar = a.this;
                        if (PttFloatingWindow.this.f7765q != e.Flying) {
                            break;
                        }
                        int o10 = aVar.o(i13 - i16);
                        int o11 = a.this.o(i14 - h10.y);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("speed_x:");
                        sb3.append(o10);
                        sb3.append(" speed_y:");
                        sb3.append(o11);
                        sb3.append(" loc.x");
                        sb3.append(h10.x);
                        sb3.append(" loc.y");
                        sb3.append(h10.y);
                        a.this.k("hide", o10);
                        a.this.l("hide", o11);
                        new Handler(Looper.getMainLooper()).post(new RunnableC0105a());
                        d0.a(i15);
                        i15 += 3;
                        h10 = a.this.h();
                    } else {
                        break;
                    }
                }
                d0.a(100L);
                Point g11 = a.this.g();
                int i17 = g11.x;
                a aVar2 = a.this;
                PttFloatingWindow pttFloatingWindow2 = PttFloatingWindow.this;
                int i18 = pttFloatingWindow2.f7759k;
                int i19 = pttFloatingWindow2.f7757i;
                int i20 = g11.y + ((i18 - i19) / 2);
                int i21 = (i17 + ((i18 - i19) / 2)) - h10.x;
                int i22 = i20 - h10.y;
                aVar2.k("hide", i21);
                a.this.l("hide", i22);
                new Handler(Looper.getMainLooper()).post(new RunnableC0106b());
                PttFloatingWindow.this.f7765q = e.Equals;
            }
        }

        a(WindowManager.LayoutParams layoutParams, WindowManager.LayoutParams layoutParams2) {
            this.f7771k = layoutParams;
            this.f7772l = layoutParams2;
            this.f7766f = layoutParams;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Point g() {
            int[] iArr = new int[2];
            PttFloatingWindow.this.f7756h.getLocationOnScreen(iArr);
            return new Point(iArr[0], iArr[1]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Point h() {
            int[] iArr = new int[2];
            PttFloatingWindow.this.f7755g.getLocationOnScreen(iArr);
            return new Point(iArr[0], iArr[1]);
        }

        private void i() {
            new Thread(new b()).start();
        }

        private void j(f fVar) {
            new Thread(new RunnableC0103a(fVar)).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(String str, int i10) {
            m(str, this.f7766f.x + i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(String str, int i10) {
            n(str, this.f7766f.y + i10);
        }

        private void m(String str, int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("updateP_");
            sb2.append(str);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("X ");
            sb3.append(this.f7766f.x);
            sb3.append(" --> ");
            sb3.append(i10);
            this.f7766f.x = i10;
        }

        private void n(String str, int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("updateP_");
            sb2.append(str);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Y ");
            sb3.append(this.f7766f.y);
            sb3.append(" --> ");
            sb3.append(i10);
            this.f7766f.y = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int o(int i10) {
            if (Math.abs(i10) < 6) {
                return i10;
            }
            int i11 = i10 / 2;
            if (i11 > 30) {
                return 30;
            }
            if (i11 < -30) {
                return -30;
            }
            return i11;
        }

        private e p() {
            int i10 = this.f7772l.x - this.f7766f.x;
            PttFloatingWindow pttFloatingWindow = PttFloatingWindow.this;
            int abs = Math.abs(i10 + ((pttFloatingWindow.f7759k - pttFloatingWindow.f7757i) / 2));
            int i11 = this.f7772l.y - this.f7766f.y;
            PttFloatingWindow pttFloatingWindow2 = PttFloatingWindow.this;
            int abs2 = Math.abs(i11 + ((pttFloatingWindow2.f7759k - pttFloatingWindow2.f7757i) / 2));
            PttFloatingWindow pttFloatingWindow3 = PttFloatingWindow.this;
            int i12 = pttFloatingWindow3.f7757i;
            int i13 = i12 * 2;
            if (abs > i13 || abs2 > i13) {
                return e.VeryFar;
            }
            if (abs > i12 || abs2 > i12) {
                return e.Far;
            }
            e eVar = pttFloatingWindow3.f7765q;
            e eVar2 = e.Equals;
            return eVar == eVar2 ? eVar2 : e.Near;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                PttFloatingWindow pttFloatingWindow = PttFloatingWindow.this;
                pttFloatingWindow.f7765q = e.None;
                pttFloatingWindow.f7756h.setVisibility(0);
                WindowManager.LayoutParams layoutParams = this.f7766f;
                this.f7767g = layoutParams.x;
                this.f7768h = layoutParams.y;
                this.f7769i = motionEvent.getRawX();
                this.f7770j = motionEvent.getRawY();
            } else if (action != 1) {
                if (action == 2) {
                    e eVar = PttFloatingWindow.this.f7765q;
                    e eVar2 = e.Flying;
                    if (eVar != eVar2) {
                        m("_MOVE", (int) (this.f7767g + (motionEvent.getRawX() - this.f7769i)));
                        n("_MOVE", (int) (this.f7768h + (motionEvent.getRawY() - this.f7770j)));
                        if (this.f7766f.x < 0) {
                            m("_MOVE", 0);
                        }
                        if (this.f7766f.y < 0) {
                            n("_MOVE", 0);
                        }
                        int i10 = this.f7766f.x;
                        PttFloatingWindow pttFloatingWindow2 = PttFloatingWindow.this;
                        int i11 = pttFloatingWindow2.f7761m.x;
                        int i12 = pttFloatingWindow2.f7757i;
                        if (i10 > i11 - i12) {
                            m("_MOVE", i11 - i12);
                        }
                        int i13 = this.f7766f.y;
                        PttFloatingWindow pttFloatingWindow3 = PttFloatingWindow.this;
                        int i14 = pttFloatingWindow3.f7761m.y;
                        int i15 = pttFloatingWindow3.f7757i;
                        if (i13 > i14 - i15) {
                            n("_MOVE", i14 - i15);
                        }
                        if (PttFloatingWindow.this.f7765q != e.Equals || p() == e.VeryFar) {
                            PttFloatingWindow pttFloatingWindow4 = PttFloatingWindow.this;
                            pttFloatingWindow4.f7754f.updateViewLayout(pttFloatingWindow4.f7755g, this.f7766f);
                            PttFloatingWindow.this.f7764p = new Date().getTime();
                            PttFloatingWindow pttFloatingWindow5 = PttFloatingWindow.this;
                            int i16 = pttFloatingWindow5.f7763o + 1;
                            pttFloatingWindow5.f7763o = i16;
                            int[] iArr = pttFloatingWindow5.f7762n;
                            if (i16 >= iArr.length) {
                                pttFloatingWindow5.f7763o = 0;
                            }
                            int i17 = pttFloatingWindow5.f7763o;
                            WindowManager.LayoutParams layoutParams2 = this.f7766f;
                            int i18 = layoutParams2.y;
                            iArr[i17] = i18;
                            if (pttFloatingWindow5.f7765q != eVar2) {
                                WindowManager.LayoutParams layoutParams3 = this.f7772l;
                                Point point = pttFloatingWindow5.f7760l;
                                int i19 = point.x;
                                layoutParams3.x = i19 + (((i19 - layoutParams2.x) / 10) * (-1));
                                int i20 = point.y;
                                layoutParams3.y = i20 + (((i20 - i18) / 10) * (-1));
                                pttFloatingWindow5.f7754f.updateViewLayout(pttFloatingWindow5.f7756h, layoutParams3);
                            }
                            int i21 = d.f7784a[p().ordinal()];
                            if (i21 == 1) {
                                PttFloatingWindow.this.f7756h.findViewById(R.id.v_red).setVisibility(0);
                                PttFloatingWindow.this.f7765q = eVar2;
                                i();
                            } else if (i21 == 2 || i21 == 3) {
                                PttFloatingWindow pttFloatingWindow6 = PttFloatingWindow.this;
                                pttFloatingWindow6.f7765q = e.None;
                                pttFloatingWindow6.f7756h.findViewById(R.id.v_red).setVisibility(8);
                            }
                        }
                    }
                }
            } else {
                if (p() == e.Equals) {
                    PttFloatingWindow pttFloatingWindow7 = PttFloatingWindow.this;
                    pttFloatingWindow7.f7754f.removeView(pttFloatingWindow7.f7756h);
                    PttFloatingWindow pttFloatingWindow8 = PttFloatingWindow.this;
                    pttFloatingWindow8.f7754f.removeView(pttFloatingWindow8.f7755g);
                    PttFloatingWindow.this.stopSelf();
                    return false;
                }
                PttFloatingWindow pttFloatingWindow9 = PttFloatingWindow.this;
                pttFloatingWindow9.f7765q = e.None;
                pttFloatingWindow9.f7756h.setVisibility(8);
                j(h().x > PttFloatingWindow.this.f7758j ? f.Right : f.Left);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(PttFloatingWindow.this.getApplicationContext(), (Class<?>) SplashActivity.class);
            intent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
            intent.addFlags(268435456);
            intent.putExtra(p.f7896v, "Windows");
            intent.putExtra(p.f7897w, p.f7899y);
            PttFloatingWindow.this.startActivity(intent);
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PttFloatingWindow.this.f7755g.setVisibility(0);
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PttFloatingWindow.this.f7755g.setVisibility(8);
            }
        }

        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Handler handler;
            Runnable bVar;
            while (PttFloatingWindow.f7753r) {
                if (PttFloatingWindow.this.a()) {
                    handler = new Handler(Looper.getMainLooper());
                    bVar = new a();
                } else {
                    handler = new Handler(Looper.getMainLooper());
                    bVar = new b();
                }
                handler.post(bVar);
                d0.a(4000L);
            }
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7784a;

        static {
            int[] iArr = new int[e.values().length];
            f7784a = iArr;
            try {
                iArr[e.Near.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7784a[e.Far.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7784a[e.VeryFar.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7784a[e.Equals.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum e {
        None,
        Near,
        Far,
        VeryFar,
        Flying,
        Equals
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum f {
        Right,
        Left
    }

    public boolean a() {
        Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses().iterator();
        return it.hasNext() && it.next().pkgList[0].equalsIgnoreCase("com.android.launcher");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f7753r = true;
        this.f7754f = (WindowManager) getSystemService("window");
        this.f7757i = (int) TypedValue.applyDimension(1, 64.0f, getResources().getDisplayMetrics());
        this.f7761m = new Point();
        this.f7754f.getDefaultDisplay().getSize(this.f7761m);
        this.f7758j = (this.f7761m.x - this.f7757i) / 2;
        this.f7755g = LayoutInflater.from(getApplicationContext()).inflate(R.layout.ptt_floating_window, (ViewGroup) null);
        int i10 = this.f7757i;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(i10, i10, 2005, 8, -3);
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.gravity = 51;
        this.f7754f.addView(this.f7755g, layoutParams);
        this.f7756h = LayoutInflater.from(getApplicationContext()).inflate(R.layout.ptt_floating_window_hide, (ViewGroup) null);
        this.f7759k = (int) TypedValue.applyDimension(1, 90.0f, getResources().getDisplayMetrics());
        int i11 = this.f7759k;
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i11, i11, 2005, 8, -3);
        layoutParams2.gravity = 51;
        Point point = this.f7761m;
        int i12 = point.x;
        int i13 = this.f7759k;
        Point point2 = new Point((i12 - i13) / 2, point.y - ((int) (i13 * 1.4d)));
        this.f7760l = point2;
        layoutParams2.x = point2.x;
        layoutParams2.y = point2.y;
        this.f7756h.setVisibility(8);
        this.f7754f.addView(this.f7756h, layoutParams2);
        this.f7755g.setOnTouchListener(new a(layoutParams, layoutParams2));
        this.f7755g.setOnClickListener(new b());
        new Thread(new c());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f7753r = false;
    }
}
