package s0;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d0 {

    /* renamed from: a, reason: collision with root package name */
    private static final h0 f13895a;

    /* renamed from: b, reason: collision with root package name */
    private static Field f13896b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f13897c;

    /* renamed from: d, reason: collision with root package name */
    static final Property<View, Float> f13898d;

    /* loaded from: classes.dex */
    static class a extends Property<View, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(d0.d(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            d0.h(view, f10.floatValue());
        }
    }

    /* loaded from: classes.dex */
    static class b extends Property<View, Rect> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return androidx.core.view.a0.r(view);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            androidx.core.view.a0.q0(view, rect);
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        f13895a = i10 >= 22 ? new g0() : i10 >= 21 ? new f0() : i10 >= 19 ? new e0() : new h0();
        f13898d = new a(Float.class, "translationAlpha");
        new b(Rect.class, "clipBounds");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        f13895a.a(view);
    }

    private static void b() {
        if (f13897c) {
            return;
        }
        try {
            Field declaredField = View.class.getDeclaredField("mViewFlags");
            f13896b = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        f13897c = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c0 c(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new b0(view) : a0.e(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float d(View view) {
        return f13895a.b(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l0 e(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new k0(view) : new j0(view.getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(View view) {
        f13895a.c(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(View view, int i10, int i11, int i12, int i13) {
        f13895a.d(view, i10, i11, i12, i13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(View view, float f10) {
        f13895a.e(view, f10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(View view, int i10) {
        b();
        Field field = f13896b;
        if (field != null) {
            try {
                f13896b.setInt(view, i10 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(View view, Matrix matrix) {
        f13895a.f(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(View view, Matrix matrix) {
        f13895a.g(view, matrix);
    }
}
