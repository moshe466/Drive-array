package com.groboot.mdaemergency.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.groboot.mdaemergency.alwaysOn.d;
import com.groboot.mdaemergency.services.MessageFloatViewService;
import e6.b;
import e6.c;
import java.util.ArrayList;
import v5.a;
import w6.l0;
import w6.m;

/* loaded from: classes.dex */
public class MessageFloatViewService extends Service implements b {

    /* renamed from: f, reason: collision with root package name */
    com.groboot.mdaemergency.ui.views.b f7984f;

    /* renamed from: g, reason: collision with root package name */
    com.groboot.mdaemergency.ui.views.b f7985g;

    /* renamed from: h, reason: collision with root package name */
    Handler f7986h;

    /* renamed from: i, reason: collision with root package name */
    Runnable f7987i = new Runnable() { // from class: z5.d
        @Override // java.lang.Runnable
        public final void run() {
            MessageFloatViewService.this.g();
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private c f7988j;

    private void f() {
        c cVar = this.f7988j;
        if (cVar != null) {
            cVar.g();
            this.f7988j = null;
        }
    }

    private static boolean i(Context context) {
        return Build.VERSION.SDK_INT <= 22 || Settings.canDrawOverlays(context);
    }

    public static boolean k(Context context, String str, boolean z10) {
        if (l0.l0(str) || !i(context)) {
            return false;
        }
        Intent intent = new Intent(context, (Class<?>) MessageFloatViewService.class);
        intent.putExtra("extra_MessageId", str);
        intent.putExtra("extra_AddToStack", z10);
        return l(context, intent);
    }

    private static boolean l(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
            return true;
        }
        context.startService(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void h() {
        Handler handler = this.f7986h;
        if (handler != null) {
            handler.removeCallbacks(this.f7987i);
            this.f7986h = null;
        }
        if (l0.j0(MessageFloatViewService.class, this)) {
            stopSelf();
        }
    }

    private void n() {
        Handler handler = this.f7986h;
        if (handler != null) {
            handler.removeCallbacks(this.f7987i);
            this.f7986h = null;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.f7986h = handler2;
        handler2.postDelayed(this.f7987i, m.z());
    }

    @Override // e6.b
    public void a() {
        h();
    }

    @Override // e6.b
    public void b(boolean z10, int i10, int i11) {
        if (z10) {
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this).edit();
        edit.putInt("last_position_x", i10);
        edit.putInt("last_position_y", i11);
        edit.apply();
    }

    @Override // e6.b
    public void c(int i10) {
    }

    public void j() {
        this.f7988j.m(17);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        startForeground(a.f14661a, a.a(getApplicationContext()));
    }

    @Override // android.app.Service
    public void onDestroy() {
        f();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        com.groboot.mdaemergency.ui.views.b bVar;
        ArrayList arrayList = new ArrayList();
        String stringExtra = intent.hasExtra("extra_MessageId") ? intent.getStringExtra("extra_MessageId") : null;
        boolean booleanExtra = intent.hasExtra("extra_AddToStack") ? intent.getBooleanExtra("extra_AddToStack", false) : false;
        if (intent.hasExtra("extra_listMessageId")) {
            arrayList = (ArrayList) intent.getSerializableExtra("extra_listMessageId");
        }
        if (stringExtra == null && (arrayList == null || arrayList.isEmpty())) {
            return 1;
        }
        if (this.f7988j != null && (bVar = this.f7984f) != null) {
            if (stringExtra != null) {
                bVar.f(stringExtra);
            } else if (arrayList != null && !arrayList.isEmpty()) {
                this.f7984f.e(arrayList);
            }
            n();
            j();
            return 1;
        }
        com.groboot.mdaemergency.ui.views.b bVar2 = new com.groboot.mdaemergency.ui.views.b(this, new d() { // from class: z5.c
            @Override // com.groboot.mdaemergency.alwaysOn.d
            public final void close() {
                MessageFloatViewService.this.h();
            }
        });
        this.f7984f = bVar2;
        bVar2.f(stringExtra);
        ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        c cVar = new c(this, this);
        this.f7988j = cVar;
        cVar.o(false);
        c.a aVar = new c.a();
        aVar.f9221i = false;
        aVar.f9215c = 0;
        aVar.f9216d = 0;
        j();
        this.f7988j.n(false);
        this.f7988j.e(booleanExtra ? this.f7984f : this.f7985g, aVar, null);
        n();
        return 1;
    }
}
