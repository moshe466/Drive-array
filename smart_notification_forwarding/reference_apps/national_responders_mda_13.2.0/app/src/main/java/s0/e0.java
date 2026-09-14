package s0;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e0 extends h0 {

    /* renamed from: a, reason: collision with root package name */
    private static Method f13908a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f13909b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f13910c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f13911d;

    private void h() {
        if (f13911d) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
            f13910c = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        f13911d = true;
    }

    private void i() {
        if (f13909b) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
            f13908a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        f13909b = true;
    }

    @Override // s0.h0
    public void a(View view) {
    }

    @Override // s0.h0
    public float b(View view) {
        h();
        Method method = f13910c;
        if (method != null) {
            try {
                return ((Float) method.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e10) {
                throw new RuntimeException(e10.getCause());
            }
        }
        return super.b(view);
    }

    @Override // s0.h0
    public void c(View view) {
    }

    @Override // s0.h0
    public void e(View view, float f10) {
        i();
        Method method = f13908a;
        if (method == null) {
            view.setAlpha(f10);
            return;
        }
        try {
            method.invoke(view, Float.valueOf(f10));
        } catch (IllegalAccessException unused) {
        } catch (InvocationTargetException e10) {
            throw new RuntimeException(e10.getCause());
        }
    }
}
