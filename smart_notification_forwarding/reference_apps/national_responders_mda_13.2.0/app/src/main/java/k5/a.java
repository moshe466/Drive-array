package k5;

import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.Display;
import com.groboot.mdaemergency.alwaysOn_Old.receivers.ScreenReceiver;
import com.groboot.mdaemergency.alwaysOn_Old.services.AlwaysOnOldMainService;
import w6.m;

/* loaded from: classes.dex */
public class a extends Service implements SensorEventListener {

    /* renamed from: f, reason: collision with root package name */
    private BroadcastReceiver f11196f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f11197g = false;

    /* renamed from: h, reason: collision with root package name */
    private float f11198h = -2.14748365E9f;

    /* renamed from: i, reason: collision with root package name */
    private SensorManager f11199i;

    private void a() {
        ((NotificationManager) getApplicationContext().getSystemService("notification")).cancelAll();
    }

    private void c() {
        f();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        ScreenReceiver screenReceiver = new ScreenReceiver();
        this.f11196f = screenReceiver;
        registerReceiver(screenReceiver, intentFilter);
        this.f11197g = true;
    }

    public static void d(Context context) {
        Intent intent = new Intent(context, (Class<?>) a.class);
        context.stopService(intent);
        AlwaysOnOldMainService.x(context);
        if (m.K()) {
            context.startService(intent);
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        }
    }

    private void e() {
    }

    private void f() {
        if (this.f11197g) {
            try {
                try {
                    unregisterReceiver(this.f11196f);
                    if (this.f11196f.isOrderedBroadcast()) {
                        this.f11196f.abortBroadcast();
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } finally {
                this.f11197g = false;
            }
        }
    }

    boolean b() {
        if (!i5.a.c()) {
            return ((PowerManager) getSystemService("power")).isScreenOn();
        }
        for (Display display : ((DisplayManager) getSystemService("display")).getDisplays()) {
            if (display.getState() != 1) {
                return true;
            }
        }
        return false;
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
        startForeground(v5.a.f14661a, v5.a.a(getApplicationContext()));
        c();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        i5.a.h(a.class.getSimpleName(), "Starter Service destroyed");
        a();
        f();
        e();
        SensorManager sensorManager = this.f11199i;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this, sensorManager.getDefaultSensor(1));
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != 1 || b()) {
            return;
        }
        if (this.f11198h == -2.14748365E9f) {
            this.f11198h = sensorEvent.values[1];
        }
        float f10 = this.f11198h;
        float[] fArr = sensorEvent.values;
        float f11 = f10 - fArr[1];
        this.f11198h = fArr[1];
        if (f11 < -3.0f) {
            Intent intent = new Intent(this, (Class<?>) AlwaysOnOldMainService.class);
            intent.addFlags(268435456);
            intent.putExtra("raise_to_wake", true);
            startService(intent);
        }
    }
}
