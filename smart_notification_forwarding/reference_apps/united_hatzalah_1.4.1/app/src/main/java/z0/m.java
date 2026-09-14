package z0;

import J.Z;
import J.a0;
import J.b0;
import J.c0;
import J.d0;
import J.e0;
import J.p0;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.WindowManager;
import android.view.WindowMetrics;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import t2.AbstractC0708j;
import u0.AbstractC0732j;
import w0.C0746b;

/* loaded from: classes.dex */
public final class m implements l {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f6838b = 0;

    static {
        AbstractC0708j.V(1, 2, 4, 8, 16, 32, 64, 128);
    }

    public static k a(Activity activity) {
        Rect rect;
        int i;
        e0 z3;
        p0 b4;
        WindowMetrics currentWindowMetrics;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            currentWindowMetrics = ((WindowManager) activity.getSystemService(WindowManager.class)).getCurrentWindowMetrics();
            rect = currentWindowMetrics.getBounds();
            kotlin.jvm.internal.j.d(rect, "wm.currentWindowMetrics.bounds");
        } else if (i3 >= 29) {
            Configuration configuration = activity.getResources().getConfiguration();
            try {
                Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(configuration);
                Object invoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                kotlin.jvm.internal.j.c(invoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect = new Rect((Rect) invoke);
            } catch (IllegalAccessException unused) {
                rect = b(activity);
            } catch (NoSuchFieldException unused2) {
                rect = b(activity);
            } catch (NoSuchMethodException unused3) {
                rect = b(activity);
            } catch (InvocationTargetException unused4) {
                rect = b(activity);
            }
        } else if (i3 >= 28) {
            rect = b(activity);
        } else {
            rect = new Rect();
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            defaultDisplay.getRectSize(rect);
            if (!activity.isInMultiWindowMode()) {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                Resources resources = activity.getResources();
                int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
                if (identifier > 0) {
                    i = resources.getDimensionPixelSize(identifier);
                } else {
                    i = 0;
                }
                int i4 = rect.bottom + i;
                if (i4 == point.y) {
                    rect.bottom = i4;
                } else {
                    int i5 = rect.right + i;
                    if (i5 == point.x) {
                        rect.right = i5;
                    }
                }
            }
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 30) {
            if (i6 >= 30) {
                b4 = D0.b.f108a.a(activity);
            } else {
                throw new Exception("Incompatible SDK version");
            }
        } else {
            if (i6 >= 34) {
                z3 = new d0();
            } else if (i6 >= 31) {
                z3 = new c0();
            } else if (i6 >= 30) {
                z3 = new b0();
            } else if (i6 >= 29) {
                z3 = new a0();
            } else {
                z3 = new Z();
            }
            b4 = z3.b();
            kotlin.jvm.internal.j.d(b4, "{\n            WindowInse…ilder().build()\n        }");
        }
        return new k(new C0746b(rect), b4);
    }

    public static Rect b(Activity activity) {
        int safeInsetLeft;
        int safeInsetRight;
        int safeInsetTop;
        int safeInsetBottom;
        int safeInsetBottom2;
        int safeInsetRight2;
        int i;
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        DisplayCutout displayCutout = null;
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (activity.isInMultiWindowMode()) {
                Object invoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                kotlin.jvm.internal.j.c(invoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) invoke);
            } else {
                Object invoke2 = obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null);
                kotlin.jvm.internal.j.c(invoke2, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) invoke2);
            }
        } catch (IllegalAccessException unused) {
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        } catch (NoSuchFieldException unused2) {
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        } catch (NoSuchMethodException unused3) {
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        } catch (InvocationTargetException unused4) {
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        }
        Display currentDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        kotlin.jvm.internal.j.d(currentDisplay, "currentDisplay");
        currentDisplay.getRealSize(point);
        if (!activity.isInMultiWindowMode()) {
            Resources resources = activity.getResources();
            int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                i = resources.getDimensionPixelSize(identifier);
            } else {
                i = 0;
            }
            int i3 = rect.bottom + i;
            if (i3 == point.y) {
                rect.bottom = i3;
            } else {
                int i4 = rect.right + i;
                if (i4 == point.x) {
                    rect.right = i4;
                } else if (rect.left == i) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !activity.isInMultiWindowMode()) {
            try {
                Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(null);
                constructor.setAccessible(true);
                Object newInstance = constructor.newInstance(null);
                Method declaredMethod = currentDisplay.getClass().getDeclaredMethod("getDisplayInfo", newInstance.getClass());
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(currentDisplay, newInstance);
                Field declaredField2 = newInstance.getClass().getDeclaredField("displayCutout");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(newInstance);
                if (AbstractC0732j.f(obj2)) {
                    displayCutout = AbstractC0732j.a(obj2);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException unused5) {
            }
            if (displayCutout != null) {
                int i5 = rect.left;
                safeInsetLeft = displayCutout.getSafeInsetLeft();
                if (i5 == safeInsetLeft) {
                    rect.left = 0;
                }
                int i6 = point.x - rect.right;
                safeInsetRight = displayCutout.getSafeInsetRight();
                if (i6 == safeInsetRight) {
                    int i7 = rect.right;
                    safeInsetRight2 = displayCutout.getSafeInsetRight();
                    rect.right = safeInsetRight2 + i7;
                }
                int i8 = rect.top;
                safeInsetTop = displayCutout.getSafeInsetTop();
                if (i8 == safeInsetTop) {
                    rect.top = 0;
                }
                int i9 = point.y - rect.bottom;
                safeInsetBottom = displayCutout.getSafeInsetBottom();
                if (i9 == safeInsetBottom) {
                    int i10 = rect.bottom;
                    safeInsetBottom2 = displayCutout.getSafeInsetBottom();
                    rect.bottom = safeInsetBottom2 + i10;
                }
            }
        }
        return rect;
    }
}
