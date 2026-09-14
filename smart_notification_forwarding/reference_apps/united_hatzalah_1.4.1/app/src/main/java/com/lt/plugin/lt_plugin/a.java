package com.lt.plugin.lt_plugin;

import android.view.Surface;
import android.view.SurfaceControl;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ Surface f(SurfaceControl surfaceControl) {
        return new Surface(surfaceControl);
    }

    public static /* synthetic */ SurfaceControl.Builder g() {
        return new SurfaceControl.Builder();
    }

    public static /* synthetic */ SurfaceControl.Transaction h() {
        return new SurfaceControl.Transaction();
    }

    public static /* bridge */ /* synthetic */ SurfaceControl.Transaction j(Object obj) {
        return (SurfaceControl.Transaction) obj;
    }

    public static /* synthetic */ void l() {
    }
}
