package com.groboot.mdaemergency;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.view.WindowManager;
import androidx.core.view.a0;
import com.groboot.mdaemergency.AlwaysOnService;
import com.groboot.mdaemergency.alwaysOn.AlwaysInActivity;
import com.groboot.mdaemergency.alwaysOn.b;
import com.groboot.mdaemergency.alwaysOn.c;
import com.groboot.mdaemergency.alwaysOn.e;
import g5.j;
import java.io.Serializable;
import java.util.Objects;
import p5.d;
import w6.l0;
import w6.m;
import y8.k;

/* loaded from: classes.dex */
public final class AlwaysOnService extends Service implements c {

    /* renamed from: i, reason: collision with root package name */
    private WindowManager.LayoutParams f7524i;

    /* renamed from: j, reason: collision with root package name */
    public WindowManager f7525j;

    /* renamed from: k, reason: collision with root package name */
    private b f7526k;

    /* renamed from: l, reason: collision with root package name */
    public Handler f7527l;

    /* renamed from: f, reason: collision with root package name */
    private String f7521f = "[AlwaysOnService]";

    /* renamed from: g, reason: collision with root package name */
    private String f7522g = k.j(d.f13074j, "[AlwaysOnService]");

    /* renamed from: h, reason: collision with root package name */
    private com.groboot.mdaemergency.alwaysOn.d f7523h = new a();

    /* renamed from: m, reason: collision with root package name */
    private Runnable f7528m = new Runnable() { // from class: g5.a
        @Override // java.lang.Runnable
        public final void run() {
            AlwaysOnService.b(AlwaysOnService.this);
        }
    };

    /* loaded from: classes.dex */
    public static final class a implements com.groboot.mdaemergency.alwaysOn.d {
        a() {
        }

        @Override // com.groboot.mdaemergency.alwaysOn.d
        public void close() {
            try {
                AlwaysOnService.this.i();
                AlwaysOnService.this.f().removeCallbacks(AlwaysOnService.this.d());
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AlwaysOnService alwaysOnService) {
        k.e(alwaysOnService, "this$0");
        if (l0.j0(AlwaysOnService.class, alwaysOnService)) {
            try {
                alwaysOnService.i();
            } catch (Exception unused) {
            }
        }
    }

    private final int c() {
        return j.f9852a.b(this) ? 2005 : 2010;
    }

    @Override // com.groboot.mdaemergency.alwaysOn.c
    public com.groboot.mdaemergency.alwaysOn.d B() {
        return this.f7523h;
    }

    public final Runnable d() {
        return this.f7528m;
    }

    public b e(e eVar) {
        return c.a.b(this, eVar);
    }

    public final Handler f() {
        Handler handler = this.f7527l;
        if (handler != null) {
            return handler;
        }
        k.o("handler");
        return null;
    }

    public b g(e eVar) {
        return c.a.c(this, eVar);
    }

    public final WindowManager h() {
        WindowManager windowManager = this.f7525j;
        if (windowManager != null) {
            return windowManager;
        }
        k.o("windowManager");
        return null;
    }

    public final void i() {
        b bVar = this.f7526k;
        if (bVar != null) {
            k.b(bVar);
            if (a0.R(bVar)) {
                h().removeViewImmediate(this.f7526k);
                this.f7526k = null;
            }
        }
    }

    public final void j(Handler handler) {
        k.e(handler, "<set-?>");
        this.f7527l = handler;
    }

    public final void k(WindowManager windowManager) {
        k.e(windowManager, "<set-?>");
        this.f7525j = windowManager;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        k.e(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        b e10;
        super.onStartCommand(intent, i10, i11);
        if (this.f7524i == null) {
            Object systemService = getSystemService("window");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            k((WindowManager) systemService);
            if (intent != null) {
                String str = AlwaysInActivity.E;
                if (intent.hasExtra(str)) {
                    if (this.f7526k != null) {
                        i();
                        f().removeCallbacks(this.f7528m);
                    }
                    Serializable serializableExtra = intent.getSerializableExtra(str);
                    Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.groboot.mdaemergency.alwaysOn.eAlwaysOnViewType");
                    e eVar = (e) serializableExtra;
                    if (eVar == e.TRAVEL_NOTIFICATION) {
                        e10 = g(eVar);
                    } else {
                        if (eVar == e.EXTERNAL_MESSAGE) {
                            e10 = e(eVar);
                        }
                        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(eVar.getWidth(this), eVar.getHeight(this), c(), 544, -3);
                        layoutParams.gravity = 17;
                        h().addView(this.f7526k, layoutParams);
                        j(new Handler());
                        f().postDelayed(this.f7528m, m.z());
                    }
                    this.f7526k = e10;
                    WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(eVar.getWidth(this), eVar.getHeight(this), c(), 544, -3);
                    layoutParams2.gravity = 17;
                    h().addView(this.f7526k, layoutParams2);
                    j(new Handler());
                    f().postDelayed(this.f7528m, m.z());
                }
            }
            return super.onStartCommand(intent, i10, i11);
        }
        return super.onStartCommand(intent, i10, i11);
    }

    @Override // com.groboot.mdaemergency.alwaysOn.c
    public b t(e eVar) {
        return c.a.a(this, eVar);
    }
}
