package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

@TargetApi(17)
/* loaded from: classes.dex */
public final class zzot extends Surface {
    private static boolean zzbhb;
    private static boolean zzbhc;
    private final boolean zzaxo;
    private final zzov zzbhd;
    private boolean zzbhe;

    private zzot(zzov zzovVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.zzbhd = zzovVar;
        this.zzaxo = z;
    }

    public static zzot zzc(Context context, boolean z) {
        if (zzoq.SDK_INT < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
        zzoc.checkState(!z || zzc(context));
        return new zzov().zzm(z);
    }

    public static synchronized boolean zzc(Context context) {
        boolean z;
        synchronized (zzot.class) {
            if (!zzbhc) {
                if (zzoq.SDK_INT >= 17) {
                    boolean z2 = false;
                    String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    if (eglQueryString != null && eglQueryString.contains("EGL_EXT_protected_content")) {
                        if (!(zzoq.SDK_INT == 24 && (zzoq.MODEL.startsWith("SM-G950") || zzoq.MODEL.startsWith("SM-G955")) && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) {
                            z2 = true;
                        }
                    }
                    zzbhb = z2;
                }
                zzbhc = true;
            }
            z = zzbhb;
        }
        return z;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.zzbhd) {
            if (!this.zzbhe) {
                this.zzbhd.release();
                this.zzbhe = true;
            }
        }
    }
}
