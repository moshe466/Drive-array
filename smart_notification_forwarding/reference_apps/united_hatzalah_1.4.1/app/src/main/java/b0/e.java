package B0;

import F0.AbstractC0008a;
import J.Z;
import J.a0;
import J.b0;
import J.c0;
import J.d0;
import J.e0;
import J.p0;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.Rect;
import android.inputmethodservice.InputMethodService;
import android.os.Build;
import android.view.Display;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.window.extensions.layout.FoldingFeature;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;
import w0.C0746b;
import z0.k;
import z0.m;

/* loaded from: classes.dex */
public abstract class e {
    public static z0.c a(k kVar, FoldingFeature foldingFeature) {
        z0.b bVar;
        z0.b bVar2;
        int type = foldingFeature.getType();
        if (type != 1) {
            if (type == 2) {
                bVar = z0.b.i;
            } else {
                return null;
            }
        } else {
            bVar = z0.b.f6814h;
        }
        int state = foldingFeature.getState();
        if (state != 1) {
            if (state == 2) {
                bVar2 = z0.b.f6813g;
            } else {
                return null;
            }
        } else {
            bVar2 = z0.b.f6812f;
        }
        Rect bounds = foldingFeature.getBounds();
        j.d(bounds, "oemFeature.bounds");
        int i = bounds.left;
        int i3 = bounds.top;
        int i4 = bounds.right;
        int i5 = bounds.bottom;
        if (i <= i4) {
            if (i3 <= i5) {
                Rect a2 = kVar.f6835a.a();
                int i6 = i5 - i3;
                if (i6 != 0 || i4 - i != 0) {
                    int i7 = i4 - i;
                    if (i7 == a2.width() || i6 == a2.height()) {
                        if (i7 >= a2.width() || i6 >= a2.height()) {
                            if (i7 == a2.width() && i6 == a2.height()) {
                                return null;
                            }
                            Rect bounds2 = foldingFeature.getBounds();
                            j.d(bounds2, "oemFeature.bounds");
                            return new z0.c(new C0746b(bounds2), bVar, bVar2);
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            }
            throw new IllegalArgumentException(AbstractC0008a.k("top must be less than or equal to bottom, top: ", i3, i5, ", bottom: ").toString());
        }
        throw new IllegalArgumentException(AbstractC0008a.k("Left must be less than or equal to right, left: ", i, i4, ", right: ").toString());
    }

    public static z0.j b(Context context, WindowLayoutInfo info) {
        e0 z3;
        k kVar;
        WindowMetrics currentWindowMetrics;
        WindowInsets windowInsets;
        WindowMetrics currentWindowMetrics2;
        Rect bounds;
        j.e(info, "info");
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            int i3 = m.f6838b;
            if (i >= 30) {
                WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
                currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                windowInsets = currentWindowMetrics.getWindowInsets();
                p0 c4 = p0.c(windowInsets, null);
                currentWindowMetrics2 = windowManager.getCurrentWindowMetrics();
                bounds = currentWindowMetrics2.getBounds();
                j.d(bounds, "wm.currentWindowMetrics.bounds");
                kVar = new k(new C0746b(bounds), c4);
            } else {
                Context context2 = context;
                while (context2 instanceof ContextWrapper) {
                    boolean z4 = context2 instanceof Activity;
                    if (!z4 && !(context2 instanceof InputMethodService)) {
                        ContextWrapper contextWrapper = (ContextWrapper) context2;
                        if (contextWrapper.getBaseContext() != null) {
                            context2 = contextWrapper.getBaseContext();
                            j.d(context2, "iterator.baseContext");
                        }
                    }
                    if (z4) {
                        kVar = m.a((Activity) context);
                    } else if (context2 instanceof InputMethodService) {
                        Object systemService = context.getSystemService("window");
                        j.c(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
                        j.d(defaultDisplay, "wm.defaultDisplay");
                        Point point = new Point();
                        defaultDisplay.getRealSize(point);
                        Rect rect = new Rect(0, 0, point.x, point.y);
                        int i4 = Build.VERSION.SDK_INT;
                        if (i4 >= 34) {
                            z3 = new d0();
                        } else if (i4 >= 31) {
                            z3 = new c0();
                        } else if (i4 >= 30) {
                            z3 = new b0();
                        } else if (i4 >= 29) {
                            z3 = new a0();
                        } else {
                            z3 = new Z();
                        }
                        p0 b4 = z3.b();
                        j.d(b4, "Builder().build()");
                        kVar = new k(new C0746b(rect), b4);
                    } else {
                        throw new IllegalArgumentException(context + " is not a UiContext");
                    }
                }
                throw new IllegalArgumentException("Context " + context + " is not a UiContext");
            }
            return c(kVar, info);
        }
        if (i >= 29 && (context instanceof Activity)) {
            int i5 = m.f6838b;
            return c(m.a((Activity) context), info);
        }
        throw new UnsupportedOperationException("Display Features are only supported after Q. Display features for non-Activity contexts are not expected to be reported on devices running Q.");
    }

    public static z0.j c(k kVar, WindowLayoutInfo info) {
        z0.c cVar;
        j.e(info, "info");
        List<FoldingFeature> displayFeatures = info.getDisplayFeatures();
        j.d(displayFeatures, "info.displayFeatures");
        ArrayList arrayList = new ArrayList();
        for (FoldingFeature feature : displayFeatures) {
            if (feature instanceof FoldingFeature) {
                j.d(feature, "feature");
                cVar = a(kVar, feature);
            } else {
                cVar = null;
            }
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        return new z0.j(arrayList);
    }
}
