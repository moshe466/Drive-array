package l;

import J.S;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.uh.sf.R;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5462a;

    /* renamed from: b, reason: collision with root package name */
    public final m f5463b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5464c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5465d;

    /* renamed from: e, reason: collision with root package name */
    public View f5466e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5468g;

    /* renamed from: h, reason: collision with root package name */
    public y f5469h;
    public u i;

    /* renamed from: j, reason: collision with root package name */
    public PopupWindow.OnDismissListener f5470j;

    /* renamed from: f, reason: collision with root package name */
    public int f5467f = 8388611;

    /* renamed from: k, reason: collision with root package name */
    public final v f5471k = new v(this);

    public x(Context context, m mVar, View view, boolean z3, int i, int i3) {
        this.f5462a = context;
        this.f5463b = mVar;
        this.f5466e = view;
        this.f5464c = z3;
        this.f5465d = i;
    }

    public final u a() {
        u viewOnKeyListenerC0501E;
        if (this.i == null) {
            Context context = this.f5462a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            w.a(defaultDisplay, point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                viewOnKeyListenerC0501E = new ViewOnKeyListenerC0509g(context, this.f5466e, this.f5465d, this.f5464c);
            } else {
                viewOnKeyListenerC0501E = new ViewOnKeyListenerC0501E(this.f5462a, this.f5463b, this.f5466e, this.f5465d, this.f5464c);
            }
            viewOnKeyListenerC0501E.k(this.f5463b);
            viewOnKeyListenerC0501E.q(this.f5471k);
            viewOnKeyListenerC0501E.m(this.f5466e);
            viewOnKeyListenerC0501E.f(this.f5469h);
            viewOnKeyListenerC0501E.n(this.f5468g);
            viewOnKeyListenerC0501E.o(this.f5467f);
            this.i = viewOnKeyListenerC0501E;
        }
        return this.i;
    }

    public final boolean b() {
        u uVar = this.i;
        if (uVar != null && uVar.a()) {
            return true;
        }
        return false;
    }

    public void c() {
        this.i = null;
        PopupWindow.OnDismissListener onDismissListener = this.f5470j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i, int i3, boolean z3, boolean z4) {
        u a2 = a();
        a2.r(z4);
        if (z3) {
            int i4 = this.f5467f;
            View view = this.f5466e;
            WeakHashMap weakHashMap = S.f954a;
            if ((Gravity.getAbsoluteGravity(i4, view.getLayoutDirection()) & 7) == 5) {
                i -= this.f5466e.getWidth();
            }
            a2.p(i);
            a2.s(i3);
            int i5 = (int) ((this.f5462a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a2.f5460a = new Rect(i - i5, i3 - i5, i + i5, i3 + i5);
        }
        a2.show();
    }
}
