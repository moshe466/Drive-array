package J;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: b, reason: collision with root package name */
    public static final p0 f1021b;

    /* renamed from: a, reason: collision with root package name */
    public final m0 f1022a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            f1021b = l0.f1010s;
        } else if (i >= 30) {
            f1021b = j0.f1006r;
        } else {
            f1021b = m0.f1014b;
        }
    }

    public p0(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            this.f1022a = new l0(this, windowInsets);
            return;
        }
        if (i >= 31) {
            this.f1022a = new k0(this, windowInsets);
            return;
        }
        if (i >= 30) {
            this.f1022a = new j0(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.f1022a = new i0(this, windowInsets);
        } else if (i >= 28) {
            this.f1022a = new h0(this, windowInsets);
        } else {
            this.f1022a = new g0(this, windowInsets);
        }
    }

    public static A.c a(A.c cVar, int i, int i3, int i4, int i5) {
        int max = Math.max(0, cVar.f2a - i);
        int max2 = Math.max(0, cVar.f3b - i3);
        int max3 = Math.max(0, cVar.f4c - i4);
        int max4 = Math.max(0, cVar.f5d - i5);
        if (max == i && max2 == i3 && max3 == i4 && max4 == i5) {
            return cVar;
        }
        return A.c.a(max, max2, max3, max4);
    }

    public static p0 c(WindowInsets windowInsets, View view) {
        windowInsets.getClass();
        p0 p0Var = new p0(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap weakHashMap = S.f954a;
            p0 a2 = K.a(view);
            m0 m0Var = p0Var.f1022a;
            m0Var.p(a2);
            m0Var.d(view.getRootView());
            m0Var.r(view.getWindowSystemUiVisibility());
        }
        return p0Var;
    }

    public final WindowInsets b() {
        m0 m0Var = this.f1022a;
        if (m0Var instanceof f0) {
            return ((f0) m0Var).f987c;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p0)) {
            return false;
        }
        return Objects.equals(this.f1022a, ((p0) obj).f1022a);
    }

    public final int hashCode() {
        m0 m0Var = this.f1022a;
        if (m0Var == null) {
            return 0;
        }
        return m0Var.hashCode();
    }

    public p0() {
        this.f1022a = new m0(this);
    }
}
