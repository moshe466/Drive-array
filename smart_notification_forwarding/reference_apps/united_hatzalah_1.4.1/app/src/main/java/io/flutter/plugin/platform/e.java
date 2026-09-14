package io.flutter.plugin.platform;

import android.view.SurfaceControl;
import android.view.ViewGroup;
import android.webkit.WebViewRenderProcess;

/* loaded from: classes.dex */
public abstract /* synthetic */ class e {
    public static /* bridge */ /* synthetic */ SurfaceControl e(SurfaceControl.Builder builder) {
        return builder.build();
    }

    public static /* bridge */ /* synthetic */ WebViewRenderProcess g(Object obj) {
        return (WebViewRenderProcess) obj;
    }

    public static /* bridge */ /* synthetic */ void i(SurfaceControl.Builder builder) {
        builder.setFormat(1);
    }

    public static /* bridge */ /* synthetic */ void n(ViewGroup viewGroup, boolean z3) {
        viewGroup.suppressLayout(z3);
    }

    public static /* bridge */ /* synthetic */ void u(SurfaceControl.Builder builder) {
        builder.setName("Flutter Overlay Surface");
    }

    public static /* bridge */ /* synthetic */ void x(SurfaceControl.Builder builder) {
        builder.setOpaque(false);
    }
}
