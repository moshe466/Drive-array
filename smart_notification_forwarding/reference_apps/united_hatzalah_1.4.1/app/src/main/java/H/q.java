package h;

import J.InterfaceC0132u;
import J.S;
import J.Z;
import J.a0;
import J.b0;
import J.c0;
import J.d0;
import J.e0;
import J.m0;
import J.p0;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContextView;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.uh.sf.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import m.z1;

/* loaded from: classes.dex */
public final class q implements InterfaceC0132u, l.y {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f4844a;

    public /* synthetic */ q(y yVar) {
        this.f4844a = yVar;
    }

    public p0 a(View view, p0 p0Var) {
        int i;
        boolean z3;
        e0 z4;
        int i3;
        boolean z5;
        int i4;
        int i5;
        boolean z6;
        boolean z7;
        int color;
        p0 p0Var2 = p0Var;
        m0 m0Var = p0Var2.f1022a;
        int i6 = m0Var.i().f3b;
        y yVar = this.f4844a;
        Context context = yVar.f4912n;
        int i7 = m0Var.i().f3b;
        ActionBarContextView actionBarContextView = yVar.y;
        if (actionBarContextView != null && (actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) yVar.y.getLayoutParams();
            if (yVar.y.isShown()) {
                if (yVar.f4906f0 == null) {
                    yVar.f4906f0 = new Rect();
                    yVar.f4907g0 = new Rect();
                }
                Rect rect = yVar.f4906f0;
                Rect rect2 = yVar.f4907g0;
                rect.set(m0Var.i().f2a, m0Var.i().f3b, m0Var.i().f4c, m0Var.i().f5d);
                ViewGroup viewGroup = yVar.f4878D;
                Method method = z1.f5853a;
                if (method != null) {
                    try {
                        method.invoke(viewGroup, rect, rect2);
                    } catch (Exception unused) {
                    }
                }
                int i8 = rect.top;
                int i9 = rect.left;
                int i10 = rect.right;
                ViewGroup viewGroup2 = yVar.f4878D;
                WeakHashMap weakHashMap = S.f954a;
                p0 a2 = J.K.a(viewGroup2);
                if (a2 == null) {
                    i4 = 0;
                } else {
                    i4 = a2.f1022a.i().f2a;
                }
                if (a2 == null) {
                    i5 = 0;
                } else {
                    i5 = a2.f1022a.i().f4c;
                }
                if (marginLayoutParams.topMargin == i8 && marginLayoutParams.leftMargin == i9 && marginLayoutParams.rightMargin == i10) {
                    z6 = false;
                } else {
                    marginLayoutParams.topMargin = i8;
                    marginLayoutParams.leftMargin = i9;
                    marginLayoutParams.rightMargin = i10;
                    z6 = true;
                }
                if (i8 > 0 && yVar.f4880F == null) {
                    View view2 = new View(context);
                    yVar.f4880F = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = i4;
                    layoutParams.rightMargin = i5;
                    yVar.f4878D.addView(yVar.f4880F, -1, layoutParams);
                } else {
                    View view3 = yVar.f4880F;
                    if (view3 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
                        int i11 = marginLayoutParams2.height;
                        int i12 = marginLayoutParams.topMargin;
                        if (i11 != i12 || marginLayoutParams2.leftMargin != i4 || marginLayoutParams2.rightMargin != i5) {
                            marginLayoutParams2.height = i12;
                            marginLayoutParams2.leftMargin = i4;
                            marginLayoutParams2.rightMargin = i5;
                            yVar.f4880F.setLayoutParams(marginLayoutParams2);
                        }
                    }
                }
                View view4 = yVar.f4880F;
                if (view4 != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7 && view4.getVisibility() != 0) {
                    View view5 = yVar.f4880F;
                    if ((view5.getWindowSystemUiVisibility() & UserMetadata.MAX_INTERNAL_KEY_SIZE) != 0) {
                        color = context.getColor(R.color.abc_decor_view_status_guard_light);
                    } else {
                        color = context.getColor(R.color.abc_decor_view_status_guard);
                    }
                    view5.setBackgroundColor(color);
                }
                if (!yVar.f4885K && z7) {
                    i7 = 0;
                }
                z5 = z6;
                z3 = z7;
                i = 0;
            } else {
                i = 0;
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z3 = false;
                    z5 = true;
                } else {
                    z3 = false;
                    z5 = false;
                }
            }
            if (z5) {
                yVar.y.setLayoutParams(marginLayoutParams);
            }
        } else {
            i = 0;
            z3 = false;
        }
        View view6 = yVar.f4880F;
        if (view6 != null) {
            if (z3) {
                i3 = i;
            } else {
                i3 = 8;
            }
            view6.setVisibility(i3);
        }
        if (i6 != i7) {
            int i13 = m0Var.i().f2a;
            int i14 = m0Var.i().f4c;
            int i15 = m0Var.i().f5d;
            int i16 = Build.VERSION.SDK_INT;
            if (i16 >= 34) {
                z4 = new d0(p0Var2);
            } else if (i16 >= 31) {
                z4 = new c0(p0Var2);
            } else if (i16 >= 30) {
                z4 = new b0(p0Var2);
            } else if (i16 >= 29) {
                z4 = new a0(p0Var2);
            } else {
                z4 = new Z(p0Var2);
            }
            z4.d(A.c.a(i13, i7, i14, i15));
            p0Var2 = z4.b();
        }
        WeakHashMap weakHashMap2 = S.f954a;
        WindowInsets b4 = p0Var2.b();
        if (b4 != null) {
            WindowInsets b5 = J.H.b(view, b4);
            if (!b5.equals(b4)) {
                return p0.c(b5, view);
            }
            return p0Var2;
        }
        return p0Var2;
    }

    @Override // l.y
    public void b(l.m mVar, boolean z3) {
        boolean z4;
        int i;
        x xVar;
        l.m k4 = mVar.k();
        int i3 = 0;
        if (k4 != mVar) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            mVar = k4;
        }
        y yVar = this.f4844a;
        x[] xVarArr = yVar.f4889O;
        if (xVarArr != null) {
            i = xVarArr.length;
        } else {
            i = 0;
        }
        while (true) {
            if (i3 < i) {
                xVar = xVarArr[i3];
                if (xVar != null && xVar.f4864h == mVar) {
                    break;
                } else {
                    i3++;
                }
            } else {
                xVar = null;
                break;
            }
        }
        if (xVar != null) {
            if (z4) {
                yVar.q(xVar.f4857a, xVar, k4);
                yVar.s(xVar, true);
            } else {
                yVar.s(xVar, z3);
            }
        }
    }

    @Override // l.y
    public boolean d(l.m mVar) {
        Window.Callback callback;
        if (mVar == mVar.k()) {
            y yVar = this.f4844a;
            if (yVar.f4883I && (callback = yVar.f4913o.getCallback()) != null && !yVar.f4894T) {
                callback.onMenuOpened(108, mVar);
                return true;
            }
            return true;
        }
        return true;
    }
}
