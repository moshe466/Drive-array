package J;

import android.graphics.Rect;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class Z extends e0 {

    /* renamed from: c, reason: collision with root package name */
    public static Field f965c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f966d = false;

    /* renamed from: e, reason: collision with root package name */
    public static Constructor f967e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f968f = false;

    /* renamed from: a, reason: collision with root package name */
    public WindowInsets f969a;

    /* renamed from: b, reason: collision with root package name */
    public A.c f970b;

    public Z() {
        this.f969a = e();
    }

    private static WindowInsets e() {
        if (!f966d) {
            try {
                f965c = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException unused) {
            }
            f966d = true;
        }
        Field field = f965c;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException unused2) {
            }
        }
        if (!f968f) {
            try {
                f967e = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException unused3) {
            }
            f968f = true;
        }
        Constructor constructor = f967e;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException unused4) {
            }
        }
        return null;
    }

    @Override // J.e0
    public p0 b() {
        a();
        p0 c4 = p0.c(this.f969a, null);
        m0 m0Var = c4.f1022a;
        m0Var.o(null);
        m0Var.q(this.f970b);
        return c4;
    }

    @Override // J.e0
    public void c(A.c cVar) {
        this.f970b = cVar;
    }

    @Override // J.e0
    public void d(A.c cVar) {
        WindowInsets windowInsets = this.f969a;
        if (windowInsets != null) {
            this.f969a = windowInsets.replaceSystemWindowInsets(cVar.f2a, cVar.f3b, cVar.f4c, cVar.f5d);
        }
    }

    public Z(p0 p0Var) {
        super(p0Var);
        this.f969a = p0Var.b();
    }
}
