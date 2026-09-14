package com.groboot.mdaemergency.async;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.gson.e;
import com.groboot.mdaemergency.async.FloatViewService;
import com.groboot.mdaemergency.ptt.p;
import com.groboot.mdaemergency.ui.main.SplashActivity;
import il.org.mda.health.R;
import w6.d0;
import w6.m;

/* loaded from: classes.dex */
public class FloatViewService extends Service implements e6.b {

    /* renamed from: g, reason: collision with root package name */
    static int f7591g = -1;

    /* renamed from: f, reason: collision with root package name */
    private e6.c f7592f;

    private void f() {
        e6.c cVar = this.f7592f;
        if (cVar != null) {
            cVar.g();
            this.f7592f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(com.groboot.mdaemergency.enums.d dVar, View view) {
        String str;
        String str2;
        Intent intent = new Intent(getApplicationContext(), (Class<?>) SplashActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("FloatViewType", dVar);
        if (dVar == com.groboot.mdaemergency.enums.d.PTT) {
            if (p.c0() == null || p.c0().e0() == null) {
                intent.putExtra(p.f7896v, "FloatViewService");
                str = p.f7897w;
                str2 = p.f7899y;
            } else {
                intent.putExtra(p.f7896v, new e().r(p.c0().e0()));
                str = p.f7897w;
                str2 = p.f7898x;
            }
            intent.putExtra(str, str2);
        }
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Context context) {
        int B;
        int i10;
        while (true) {
            B = m.B();
            if (B <= 0 || (i10 = f7591g) < 0 || i10 >= B) {
                break;
            }
            d0.a(1000L);
            f7591g++;
        }
        int i11 = f7591g;
        if (i11 < B || B <= 0 || i11 <= 0) {
            return;
        }
        l(context);
    }

    private void i() {
        e6.c cVar;
        int i10;
        String string = PreferenceManager.getDefaultSharedPreferences(this).getString("settings_display_mode", "");
        if ("Always".equals(string)) {
            cVar = this.f7592f;
            i10 = 1;
        } else if ("FullScreen".equals(string)) {
            cVar = this.f7592f;
            i10 = 3;
        } else {
            if (!"Hide".equals(string)) {
                return;
            }
            cVar = this.f7592f;
            i10 = 2;
        }
        cVar.k(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private e6.c.a j(android.util.DisplayMetrics r8) {
        /*
            r7 = this;
            e6.c$a r0 = new e6.c$a
            r0.<init>()
            android.content.SharedPreferences r1 = android.preference.PreferenceManager.getDefaultSharedPreferences(r7)
            java.lang.String r2 = "settings_shape"
            java.lang.String r3 = ""
            java.lang.String r2 = r1.getString(r2, r3)
            java.lang.String r4 = "Circle"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L1e
            r2 = 1065353216(0x3f800000, float:1.0)
        L1b:
            r0.f9213a = r2
            goto L2a
        L1e:
            java.lang.String r4 = "Rectangle"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L2a
            r2 = 1068827777(0x3fb50481, float:1.4142)
            goto L1b
        L2a:
            int r2 = r0.f9214b
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r4 = "settings_margin"
            java.lang.String r2 = r1.getString(r4, r2)
            int r2 = java.lang.Integer.parseInt(r2)
            r0.f9214b = r2
            java.lang.String r2 = "settings_move_direction"
            java.lang.String r2 = r1.getString(r2, r3)
            java.lang.String r4 = "Default"
            boolean r4 = r4.equals(r2)
            r5 = 0
            if (r4 == 0) goto L4e
            r0.f9219g = r5
            goto L6e
        L4e:
            java.lang.String r4 = "Left"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L5a
            r2 = 1
        L57:
            r0.f9219g = r2
            goto L6e
        L5a:
            java.lang.String r4 = "Right"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L64
            r2 = 2
            goto L57
        L64:
            java.lang.String r4 = "Fix"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L6e
            r2 = 3
            goto L57
        L6e:
            java.lang.String r2 = "settings_save_last_position"
            boolean r2 = r1.getBoolean(r2, r5)
            if (r2 == 0) goto L8b
            int r8 = r0.f9215c
            int r2 = r0.f9216d
            java.lang.String r3 = "last_position_x"
            int r8 = r1.getInt(r3, r8)
            r0.f9215c = r8
            java.lang.String r8 = "last_position_y"
            int r8 = r1.getInt(r8, r2)
        L88:
            r0.f9216d = r8
            goto Lc7
        L8b:
            java.lang.String r2 = "settings_init_x"
            java.lang.String r2 = r1.getString(r2, r3)
            java.lang.String r4 = "settings_init_y"
            java.lang.String r3 = r1.getString(r4, r3)
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto Lc7
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto Lc7
            r4 = 1111490560(0x42400000, float:48.0)
            r5 = 1090519040(0x41000000, float:8.0)
            float r6 = r8.density
            float r6 = r6 * r5
            float r6 = r6 + r4
            int r4 = (int) r6
            int r5 = r8.widthPixels
            float r5 = (float) r5
            float r2 = java.lang.Float.parseFloat(r2)
            float r5 = r5 * r2
            float r2 = (float) r4
            float r5 = r5 - r2
            int r4 = (int) r5
            r0.f9215c = r4
            int r8 = r8.heightPixels
            float r8 = (float) r8
            float r3 = java.lang.Float.parseFloat(r3)
            float r8 = r8 * r3
            float r8 = r8 - r2
            int r8 = (int) r8
            goto L88
        Lc7:
            boolean r8 = r0.f9221i
            java.lang.String r2 = "settings_animation"
            boolean r8 = r1.getBoolean(r2, r8)
            r0.f9221i = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.groboot.mdaemergency.async.FloatViewService.j(android.util.DisplayMetrics):e6.c$a");
    }

    public static boolean k(Context context, com.groboot.mdaemergency.enums.d dVar) {
        Intent intent = new Intent(context, (Class<?>) FloatViewService.class);
        intent.putExtra("FloatViewType", dVar);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 22 && !Settings.canDrawOverlays(context)) {
            return false;
        }
        if (i10 >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
        m(context);
        return true;
    }

    public static void l(Context context) {
        context.stopService(new Intent(context, (Class<?>) FloatViewService.class));
    }

    private static void m(final Context context) {
        if (m.B() <= 0) {
            return;
        }
        int i10 = f7591g;
        f7591g = 0;
        if (i10 >= 0) {
            return;
        }
        new Thread(new Runnable() { // from class: o5.c
            @Override // java.lang.Runnable
            public final void run() {
                FloatViewService.h(context);
            }
        }).start();
    }

    @Override // e6.b
    public void a() {
        stopSelf();
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

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Notification a10 = v5.a.a(getApplicationContext());
        if (a10 != null) {
            startForeground(v5.a.f14661a, a10);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        f();
        f7591g = -1;
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (this.f7592f != null) {
            return 1;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        LayoutInflater from = LayoutInflater.from(this);
        final com.groboot.mdaemergency.enums.d dVar = com.groboot.mdaemergency.enums.d.PTT;
        if (intent.hasExtra("FloatViewType")) {
            dVar = (com.groboot.mdaemergency.enums.d) intent.getSerializableExtra("FloatViewType");
        }
        View view = (RelativeLayout) from.inflate(R.layout.float_view_ptt, (ViewGroup) null, false);
        view.setOnClickListener(new View.OnClickListener() { // from class: o5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FloatViewService.this.g(dVar, view2);
            }
        });
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(256, 256, 2005, 8, -3);
        layoutParams.gravity = 51;
        ((ImageView) view.findViewById(R.id.img_floatIcon)).setImageResource(dVar.getImageRes());
        int applyDimension = (int) TypedValue.applyDimension(1, dVar.getImagePadding(), getResources().getDisplayMetrics());
        ((ImageView) view.findViewById(R.id.img_floatIcon)).setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
        view.setLayoutParams(layoutParams);
        e6.c cVar = new e6.c(this, this);
        this.f7592f = cVar;
        cVar.l(R.drawable.ic_trash_fixed);
        this.f7592f.j(R.drawable.ic_trash_action);
        i();
        this.f7592f.e(view, j(displayMetrics), null);
        return 3;
    }
}
