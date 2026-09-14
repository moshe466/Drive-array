package io.flutter.util;

import D0.b;
import F0.AbstractC0008a;
import J.Z;
import J.a0;
import J.b0;
import J.c0;
import J.d0;
import J.e0;
import J.p0;
import J0.d;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowMetrics;
import e3.c;
import kotlin.jvm.internal.j;
import z0.l;
import z0.m;

/* loaded from: classes.dex */
public final class ViewUtils {

    /* loaded from: classes.dex */
    public interface DisplayUpdater {
        void updateDisplayMetrics(float f4, float f5, float f6);
    }

    /* loaded from: classes.dex */
    public interface ViewVisitor {
        boolean run(View view);
    }

    public static /* synthetic */ boolean b(Class[] clsArr, View view) {
        return lambda$hasChildViewOfType$1(clsArr, view);
    }

    public static void calculateMaximumDisplayMetrics(Context context, DisplayUpdater displayUpdater) {
        Rect rect;
        e0 z3;
        p0 _windowInsetsCompat;
        WindowMetrics maximumWindowMetrics;
        Activity activity = getActivity(context);
        if (activity != null) {
            l.f6837a.getClass();
            int i = m.f6838b;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30) {
                maximumWindowMetrics = ((WindowManager) activity.getSystemService(WindowManager.class)).getMaximumWindowMetrics();
                rect = maximumWindowMetrics.getBounds();
                j.d(rect, "wm.maximumWindowMetrics.bounds");
            } else {
                Object systemService = activity.getSystemService("window");
                j.c(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                Display display = ((WindowManager) systemService).getDefaultDisplay();
                j.d(display, "display");
                Point point = new Point();
                display.getRealSize(point);
                rect = new Rect(0, 0, point.x, point.y);
            }
            if (i3 >= 30) {
                if (i3 >= 30) {
                    _windowInsetsCompat = b.f108a.a(activity);
                } else {
                    throw new Exception("Incompatible SDK version");
                }
            } else {
                if (i3 >= 34) {
                    z3 = new d0();
                } else if (i3 >= 31) {
                    z3 = new c0();
                } else if (i3 >= 30) {
                    z3 = new b0();
                } else if (i3 >= 29) {
                    z3 = new a0();
                } else {
                    z3 = new Z();
                }
                _windowInsetsCompat = z3.b();
                j.d(_windowInsetsCompat, "{\n            WindowInse…ilder().build()\n        }");
            }
            int i4 = rect.left;
            int i5 = rect.top;
            int i6 = rect.right;
            int i7 = rect.bottom;
            if (i4 <= i6) {
                if (i5 <= i7) {
                    j.e(_windowInsetsCompat, "_windowInsetsCompat");
                    displayUpdater.updateDisplayMetrics(new Rect(i4, i5, i6, i7).width(), new Rect(i4, i5, i6, i7).height(), context.getResources().getDisplayMetrics().density);
                    return;
                }
                throw new IllegalArgumentException(AbstractC0008a.k("top must be less than or equal to bottom, top: ", i5, i7, ", bottom: ").toString());
            }
            throw new IllegalArgumentException(AbstractC0008a.k("Left must be less than or equal to right, left: ", i4, i6, ", right: ").toString());
        }
    }

    public static boolean childHasFocus(View view) {
        return traverseHierarchy(view, new c(7));
    }

    public static Activity getActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        return getActivity(((ContextWrapper) context).getBaseContext());
    }

    public static boolean hasChildViewOfType(View view, Class<? extends View>[] clsArr) {
        return traverseHierarchy(view, new d(clsArr, 24));
    }

    public static /* synthetic */ boolean lambda$hasChildViewOfType$1(Class[] clsArr, View view) {
        for (Class cls : clsArr) {
            if (cls.isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    public static boolean traverseHierarchy(View view, ViewVisitor viewVisitor) {
        if (view != null) {
            if (!viewVisitor.run(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        if (traverseHierarchy(viewGroup.getChildAt(i), viewVisitor)) {
                            return true;
                        }
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
