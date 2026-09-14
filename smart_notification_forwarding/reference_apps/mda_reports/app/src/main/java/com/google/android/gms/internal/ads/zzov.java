package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzov extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {
    private zzddu zzaee;
    private final int[] zzbhf;
    private SurfaceTexture zzbhg;
    private Error zzbhh;
    private RuntimeException zzbhi;
    private zzot zzbhj;

    public zzov() {
        super("dummySurface");
        this.zzbhf = new int[1];
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        try {
            if (i != 1) {
                if (i == 2) {
                    this.zzbhg.updateTexImage();
                    return true;
                }
                if (i != 3) {
                    return true;
                }
                try {
                    try {
                        this.zzbhg.release();
                        this.zzbhj = null;
                        this.zzbhg = null;
                        GLES20.glDeleteTextures(1, this.zzbhf, 0);
                    } catch (Throwable th) {
                        this.zzbhj = null;
                        this.zzbhg = null;
                        GLES20.glDeleteTextures(1, this.zzbhf, 0);
                        throw th;
                    }
                } finally {
                    try {
                        return true;
                    } finally {
                    }
                }
                return true;
            }
            try {
                try {
                    boolean z = message.arg1 != 0;
                    EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                    zzoc.checkState(eglGetDisplay != null, "eglGetDisplay failed");
                    int[] iArr = new int[2];
                    zzoc.checkState(EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1), "eglInitialize failed");
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    int[] iArr2 = new int[1];
                    zzoc.checkState(EGL14.eglChooseConfig(eglGetDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) && iArr2[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, z ? new int[]{12440, 2, 12992, 1, 12344} : new int[]{12440, 2, 12344}, 0);
                    zzoc.checkState(eglCreateContext != null, "eglCreateContext failed");
                    EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, z ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                    zzoc.checkState(eglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
                    zzoc.checkState(EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext), "eglMakeCurrent failed");
                    GLES20.glGenTextures(1, this.zzbhf, 0);
                    this.zzbhg = new SurfaceTexture(this.zzbhf[0]);
                    this.zzbhg.setOnFrameAvailableListener(this);
                    this.zzbhj = new zzot(this, this.zzbhg, z);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e) {
                    Log.e("DummySurface", "Failed to initialize dummy surface", e);
                    this.zzbhh = e;
                    synchronized (this) {
                        notify();
                    }
                }
            } catch (RuntimeException e2) {
                Log.e("DummySurface", "Failed to initialize dummy surface", e2);
                this.zzbhi = e2;
                synchronized (this) {
                    notify();
                }
            }
            return true;
        } catch (Throwable th2) {
            synchronized (this) {
                notify();
                throw th2;
            }
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzaee.sendEmptyMessage(2);
    }

    public final void release() {
        this.zzaee.sendEmptyMessage(3);
    }

    public final zzot zzm(boolean z) {
        boolean z2;
        start();
        this.zzaee = new zzddu(getLooper(), this);
        synchronized (this) {
            z2 = false;
            this.zzaee.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            while (this.zzbhj == null && this.zzbhi == null && this.zzbhh == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzbhi;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = this.zzbhh;
        if (error == null) {
            return this.zzbhj;
        }
        throw error;
    }
}
