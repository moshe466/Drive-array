package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
final class zzbas implements SensorEventListener {
    private final SensorManager zzdyv;
    private final Display zzdyx;

    @GuardedBy("sensorThreadLock")
    private float[] zzdza;
    private Handler zzdzb;
    private zzbau zzdzc;
    private final float[] zzdyy = new float[9];
    private final float[] zzdyz = new float[9];
    private final Object zzdyw = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbas(Context context) {
        this.zzdyv = (SensorManager) context.getSystemService("sensor");
        this.zzdyx = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private final void zzl(int i, int i2) {
        float[] fArr = this.zzdyz;
        float f = fArr[i];
        fArr[i] = fArr[i2];
        fArr[i2] = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        if (this.zzdzb != null) {
            return;
        }
        Sensor defaultSensor = this.zzdyv.getDefaultSensor(11);
        if (defaultSensor == null) {
            zzayu.zzex("No Sensor of TYPE_ROTATION_VECTOR");
            return;
        }
        HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
        handlerThread.start();
        this.zzdzb = new zzddu(handlerThread.getLooper());
        if (this.zzdyv.registerListener(this, defaultSensor, 0, this.zzdzb)) {
            return;
        }
        zzayu.zzex("SensorManager.registerListener failed.");
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzbau zzbauVar) {
        this.zzdzc = zzbauVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(float[] fArr) {
        synchronized (this.zzdyw) {
            if (this.zzdza == null) {
                return false;
            }
            System.arraycopy(this.zzdza, 0, fArr, 0, this.zzdza.length);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        if (this.zzdzb == null) {
            return;
        }
        this.zzdyv.unregisterListener(this);
        this.zzdzb.post(new zzbav(this));
        this.zzdzb = null;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] == 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f) {
            return;
        }
        synchronized (this.zzdyw) {
            if (this.zzdza == null) {
                this.zzdza = new float[9];
            }
        }
        SensorManager.getRotationMatrixFromVector(this.zzdyy, fArr);
        int rotation = this.zzdyx.getRotation();
        if (rotation == 1) {
            SensorManager.remapCoordinateSystem(this.zzdyy, 2, 129, this.zzdyz);
        } else if (rotation == 2) {
            SensorManager.remapCoordinateSystem(this.zzdyy, 129, 130, this.zzdyz);
        } else if (rotation != 3) {
            System.arraycopy(this.zzdyy, 0, this.zzdyz, 0, 9);
        } else {
            SensorManager.remapCoordinateSystem(this.zzdyy, 130, 1, this.zzdyz);
        }
        zzl(1, 3);
        zzl(2, 6);
        zzl(5, 7);
        synchronized (this.zzdyw) {
            System.arraycopy(this.zzdyz, 0, this.zzdza, 0, 9);
        }
        zzbau zzbauVar = this.zzdzc;
        if (zzbauVar != null) {
            zzbauVar.zztq();
        }
    }
}
