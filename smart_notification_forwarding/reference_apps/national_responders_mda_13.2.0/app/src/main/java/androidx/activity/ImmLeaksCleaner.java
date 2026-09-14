package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.h;
import androidx.lifecycle.l;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements androidx.lifecycle.j {

    /* renamed from: b, reason: collision with root package name */
    private static int f474b;

    /* renamed from: c, reason: collision with root package name */
    private static Field f475c;

    /* renamed from: d, reason: collision with root package name */
    private static Field f476d;

    /* renamed from: e, reason: collision with root package name */
    private static Field f477e;

    /* renamed from: a, reason: collision with root package name */
    private Activity f478a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmLeaksCleaner(Activity activity) {
        this.f478a = activity;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    private static void h() {
        try {
            f474b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f476d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f477e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f475c = declaredField3;
            declaredField3.setAccessible(true);
            f474b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.j
    public void d(l lVar, h.b bVar) {
        if (bVar != h.b.ON_DESTROY) {
            return;
        }
        if (f474b == 0) {
            h();
        }
        if (f474b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f478a.getSystemService("input_method");
            try {
                Object obj = f475c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f476d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f477e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (ClassCastException unused2) {
                    } catch (IllegalAccessException unused3) {
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
