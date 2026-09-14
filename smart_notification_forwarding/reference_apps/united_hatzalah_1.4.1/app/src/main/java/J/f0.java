package J;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class f0 extends m0 {
    public static boolean i = false;

    /* renamed from: j, reason: collision with root package name */
    public static Method f983j;

    /* renamed from: k, reason: collision with root package name */
    public static Class f984k;

    /* renamed from: l, reason: collision with root package name */
    public static Field f985l;

    /* renamed from: m, reason: collision with root package name */
    public static Field f986m;

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets f987c;

    /* renamed from: d, reason: collision with root package name */
    public A.c[] f988d;

    /* renamed from: e, reason: collision with root package name */
    public A.c f989e;

    /* renamed from: f, reason: collision with root package name */
    public p0 f990f;

    /* renamed from: g, reason: collision with root package name */
    public A.c f991g;

    /* renamed from: h, reason: collision with root package name */
    public int f992h;

    public f0(p0 p0Var, WindowInsets windowInsets) {
        super(p0Var);
        this.f989e = null;
        this.f987c = windowInsets;
    }

    private A.c t() {
        p0 p0Var = this.f990f;
        if (p0Var != null) {
            return p0Var.f1022a.g();
        }
        return A.c.f1e;
    }

    private A.c u(View view) {
        if (Build.VERSION.SDK_INT < 30) {
            if (!i) {
                w();
            }
            Method method = f983j;
            if (method != null && f984k != null && f985l != null) {
                try {
                    Object invoke = method.invoke(view, null);
                    if (invoke != null) {
                        Rect rect = (Rect) f985l.get(f986m.get(invoke));
                        if (rect != null) {
                            return A.c.a(rect.left, rect.top, rect.right, rect.bottom);
                        }
                    }
                } catch (ReflectiveOperationException e4) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e4.getMessage(), e4);
                }
            }
            return null;
        }
        throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
    }

    private static void w() {
        try {
            f983j = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f984k = cls;
            f985l = cls.getDeclaredField("mVisibleInsets");
            f986m = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f985l.setAccessible(true);
            f986m.setAccessible(true);
        } catch (ReflectiveOperationException e4) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e4.getMessage(), e4);
        }
        i = true;
    }

    public static boolean y(int i3, int i4) {
        if ((i3 & 6) == (i4 & 6)) {
            return true;
        }
        return false;
    }

    @Override // J.m0
    public void d(View view) {
        A.c u3 = u(view);
        if (u3 == null) {
            u3 = A.c.f1e;
        }
        x(u3);
    }

    @Override // J.m0
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        if (!Objects.equals(this.f991g, f0Var.f991g) || !y(this.f992h, f0Var.f992h)) {
            return false;
        }
        return true;
    }

    @Override // J.m0
    public final A.c i() {
        if (this.f989e == null) {
            WindowInsets windowInsets = this.f987c;
            this.f989e = A.c.a(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f989e;
    }

    @Override // J.m0
    public p0 k(int i3, int i4, int i5, int i6) {
        e0 z3;
        p0 c4 = p0.c(this.f987c, null);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 34) {
            z3 = new d0(c4);
        } else if (i7 >= 31) {
            z3 = new c0(c4);
        } else if (i7 >= 30) {
            z3 = new b0(c4);
        } else if (i7 >= 29) {
            z3 = new a0(c4);
        } else {
            z3 = new Z(c4);
        }
        z3.d(p0.a(i(), i3, i4, i5, i6));
        z3.c(p0.a(g(), i3, i4, i5, i6));
        return z3.b();
    }

    @Override // J.m0
    public boolean m() {
        return this.f987c.isRound();
    }

    @Override // J.m0
    public boolean n(int i3) {
        for (int i4 = 1; i4 <= 512; i4 <<= 1) {
            if ((i3 & i4) != 0 && !v(i4)) {
                return false;
            }
        }
        return true;
    }

    @Override // J.m0
    public void o(A.c[] cVarArr) {
        this.f988d = cVarArr;
    }

    @Override // J.m0
    public void p(p0 p0Var) {
        this.f990f = p0Var;
    }

    @Override // J.m0
    public void r(int i3) {
        this.f992h = i3;
    }

    public A.c s(int i3, boolean z3) {
        int i4;
        C0121i e4;
        int i5;
        int i6;
        int i7;
        A.c cVar = A.c.f1e;
        int i8 = 0;
        if (i3 != 1) {
            A.c cVar2 = null;
            if (i3 != 2) {
                if (i3 != 8) {
                    if (i3 != 16) {
                        if (i3 != 32) {
                            if (i3 != 64) {
                                if (i3 == 128) {
                                    p0 p0Var = this.f990f;
                                    if (p0Var != null) {
                                        e4 = p0Var.f1022a.e();
                                    } else {
                                        e4 = e();
                                    }
                                    if (e4 != null) {
                                        int i9 = Build.VERSION.SDK_INT;
                                        if (i9 >= 28) {
                                            i5 = B.b.g(e4.f1003a);
                                        } else {
                                            i5 = 0;
                                        }
                                        if (i9 >= 28) {
                                            i6 = B.b.i(e4.f1003a);
                                        } else {
                                            i6 = 0;
                                        }
                                        if (i9 >= 28) {
                                            i7 = B.b.h(e4.f1003a);
                                        } else {
                                            i7 = 0;
                                        }
                                        if (i9 >= 28) {
                                            i8 = B.b.f(e4.f1003a);
                                        }
                                        return A.c.a(i5, i6, i7, i8);
                                    }
                                }
                            } else {
                                return j();
                            }
                        } else {
                            return f();
                        }
                    } else {
                        return h();
                    }
                } else {
                    A.c[] cVarArr = this.f988d;
                    if (cVarArr != null) {
                        cVar2 = cVarArr[3];
                    }
                    if (cVar2 != null) {
                        return cVar2;
                    }
                    A.c i10 = i();
                    A.c t3 = t();
                    int i11 = i10.f5d;
                    if (i11 > t3.f5d) {
                        return A.c.a(0, 0, 0, i11);
                    }
                    A.c cVar3 = this.f991g;
                    if (cVar3 != null && !cVar3.equals(cVar) && (i4 = this.f991g.f5d) > t3.f5d) {
                        return A.c.a(0, 0, 0, i4);
                    }
                }
            } else {
                if (z3) {
                    A.c t4 = t();
                    A.c g3 = g();
                    return A.c.a(Math.max(t4.f2a, g3.f2a), 0, Math.max(t4.f4c, g3.f4c), Math.max(t4.f5d, g3.f5d));
                }
                if ((this.f992h & 2) == 0) {
                    A.c i12 = i();
                    p0 p0Var2 = this.f990f;
                    if (p0Var2 != null) {
                        cVar2 = p0Var2.f1022a.g();
                    }
                    int i13 = i12.f5d;
                    if (cVar2 != null) {
                        i13 = Math.min(i13, cVar2.f5d);
                    }
                    return A.c.a(i12.f2a, 0, i12.f4c, i13);
                }
            }
        } else {
            if (z3) {
                return A.c.a(0, Math.max(t().f3b, i().f3b), 0, 0);
            }
            if ((this.f992h & 4) == 0) {
                return A.c.a(0, i().f3b, 0, 0);
            }
        }
        return cVar;
    }

    public boolean v(int i3) {
        if (i3 != 1 && i3 != 2) {
            if (i3 == 4) {
                return false;
            }
            if (i3 != 8 && i3 != 128) {
                return true;
            }
        }
        return !s(i3, false).equals(A.c.f1e);
    }

    public void x(A.c cVar) {
        this.f991g = cVar;
    }
}
