package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@TargetApi(14)
/* loaded from: classes.dex */
public final class zzbax extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzbau {
    private static final float[] zzdzp = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private int height;
    private int width;
    private final float[] zzdza;
    private final zzbas zzdzq;
    private final float[] zzdzr;
    private final float[] zzdzs;
    private final float[] zzdzt;
    private final float[] zzdzu;
    private final float[] zzdzv;
    private final float[] zzdzw;
    private float zzdzx;
    private float zzdzy;
    private float zzdzz;
    private SurfaceTexture zzeaa;
    private SurfaceTexture zzeab;
    private int zzeac;
    private int zzead;
    private int zzeae;
    private FloatBuffer zzeaf;
    private final CountDownLatch zzeag;
    private final Object zzeah;
    private EGL10 zzeai;
    private EGLDisplay zzeaj;
    private EGLContext zzeak;
    private EGLSurface zzeal;
    private volatile boolean zzeam;
    private volatile boolean zzean;

    public zzbax(Context context) {
        super("SphericalVideoProcessor");
        this.zzeaf = ByteBuffer.allocateDirect(zzdzp.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzeaf.put(zzdzp).position(0);
        this.zzdza = new float[9];
        this.zzdzr = new float[9];
        this.zzdzs = new float[9];
        this.zzdzt = new float[9];
        this.zzdzu = new float[9];
        this.zzdzv = new float[9];
        this.zzdzw = new float[9];
        this.zzdzx = Float.NaN;
        this.zzdzq = new zzbas(context);
        this.zzdzq.a(this);
        this.zzeag = new CountDownLatch(1);
        this.zzeah = new Object();
    }

    private static void zza(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d = f;
        fArr[4] = (float) Math.cos(d);
        fArr[5] = (float) (-Math.sin(d));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d);
        fArr[8] = (float) Math.cos(d);
    }

    private static void zza(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    private static void zzb(float[] fArr, float f) {
        double d = f;
        fArr[0] = (float) Math.cos(d);
        fArr[1] = (float) (-Math.sin(d));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d);
        fArr[4] = (float) Math.cos(d);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static int zzc(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        zzfd("createShader");
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        zzfd("shaderSource");
        GLES20.glCompileShader(glCreateShader);
        zzfd("compileShader");
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        zzfd("getShaderiv");
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Could not compile shader ");
        sb.append(i);
        sb.append(":");
        Log.e("SphericalVideoRenderer", sb.toString());
        Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        zzfd("deleteShader");
        return 0;
    }

    private static void zzfd(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21);
            sb.append(str);
            sb.append(": glError ");
            sb.append(glGetError);
            Log.e("SphericalVideoRenderer", sb.toString());
        }
    }

    @VisibleForTesting
    private final boolean zzyh() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.zzeal;
        boolean z = false;
        if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
            z = this.zzeai.eglDestroySurface(this.zzeaj, this.zzeal) | this.zzeai.eglMakeCurrent(this.zzeaj, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT) | false;
            this.zzeal = null;
        }
        EGLContext eGLContext = this.zzeak;
        if (eGLContext != null) {
            z |= this.zzeai.eglDestroyContext(this.zzeaj, eGLContext);
            this.zzeak = null;
        }
        EGLDisplay eGLDisplay = this.zzeaj;
        if (eGLDisplay == null) {
            return z;
        }
        boolean eglTerminate = z | this.zzeai.eglTerminate(eGLDisplay);
        this.zzeaj = null;
        return eglTerminate;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzeae++;
        synchronized (this.zzeah) {
            this.zzeah.notifyAll();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01db A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00be  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1038
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbax.run():void");
    }

    public final void zza(SurfaceTexture surfaceTexture, int i, int i2) {
        this.width = i;
        this.height = i2;
        this.zzeab = surfaceTexture;
    }

    public final void zzb(float f, float f2) {
        float f3;
        float f4;
        float f5;
        int i = this.width;
        int i2 = this.height;
        float f6 = f * 1.7453293f;
        if (i > i2) {
            f3 = f6 / i;
            f4 = f2 * 1.7453293f;
            f5 = i;
        } else {
            f3 = f6 / i2;
            f4 = f2 * 1.7453293f;
            f5 = i2;
        }
        this.zzdzy -= f3;
        this.zzdzz -= f4 / f5;
        if (this.zzdzz < -1.5707964f) {
            this.zzdzz = -1.5707964f;
        }
        if (this.zzdzz > 1.5707964f) {
            this.zzdzz = 1.5707964f;
        }
    }

    public final void zzm(int i, int i2) {
        synchronized (this.zzeah) {
            this.width = i;
            this.height = i2;
            this.zzeam = true;
            this.zzeah.notifyAll();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbau
    public final void zztq() {
        synchronized (this.zzeah) {
            this.zzeah.notifyAll();
        }
    }

    public final void zzyf() {
        synchronized (this.zzeah) {
            this.zzean = true;
            this.zzeab = null;
            this.zzeah.notifyAll();
        }
    }

    public final SurfaceTexture zzyg() {
        if (this.zzeab == null) {
            return null;
        }
        try {
            this.zzeag.await();
        } catch (InterruptedException unused) {
        }
        return this.zzeaa;
    }
}
