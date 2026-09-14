package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.m;
import androidx.core.view.a0;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final Context f992a;

    /* renamed from: b, reason: collision with root package name */
    private final g f993b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f994c;

    /* renamed from: d, reason: collision with root package name */
    private final int f995d;

    /* renamed from: e, reason: collision with root package name */
    private final int f996e;

    /* renamed from: f, reason: collision with root package name */
    private View f997f;

    /* renamed from: g, reason: collision with root package name */
    private int f998g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f999h;

    /* renamed from: i, reason: collision with root package name */
    private m.a f1000i;

    /* renamed from: j, reason: collision with root package name */
    private k f1001j;

    /* renamed from: k, reason: collision with root package name */
    private PopupWindow.OnDismissListener f1002k;

    /* renamed from: l, reason: collision with root package name */
    private final PopupWindow.OnDismissListener f1003l;

    /* loaded from: classes.dex */
    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            l.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    public l(Context context, g gVar, View view, boolean z10, int i10) {
        this(context, gVar, view, z10, i10, 0);
    }

    public l(Context context, g gVar, View view, boolean z10, int i10, int i11) {
        this.f998g = 8388611;
        this.f1003l = new a();
        this.f992a = context;
        this.f993b = gVar;
        this.f997f = view;
        this.f994c = z10;
        this.f995d = i10;
        this.f996e = i11;
    }

    private k a() {
        Display defaultDisplay = ((WindowManager) this.f992a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            b.a(defaultDisplay, point);
        } else {
            defaultDisplay.getSize(point);
        }
        k dVar = Math.min(point.x, point.y) >= this.f992a.getResources().getDimensionPixelSize(e.d.f8891c) ? new d(this.f992a, this.f997f, this.f995d, this.f996e, this.f994c) : new q(this.f992a, this.f993b, this.f997f, this.f995d, this.f996e, this.f994c);
        dVar.l(this.f993b);
        dVar.u(this.f1003l);
        dVar.p(this.f997f);
        dVar.k(this.f1000i);
        dVar.r(this.f999h);
        dVar.s(this.f998g);
        return dVar;
    }

    private void l(int i10, int i11, boolean z10, boolean z11) {
        k c10 = c();
        c10.v(z11);
        if (z10) {
            if ((androidx.core.view.e.b(this.f998g, a0.z(this.f997f)) & 7) == 5) {
                i10 -= this.f997f.getWidth();
            }
            c10.t(i10);
            c10.w(i11);
            int i12 = (int) ((this.f992a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c10.q(new Rect(i10 - i12, i11 - i12, i10 + i12, i11 + i12));
        }
        c10.a();
    }

    public void b() {
        if (d()) {
            this.f1001j.dismiss();
        }
    }

    public k c() {
        if (this.f1001j == null) {
            this.f1001j = a();
        }
        return this.f1001j;
    }

    public boolean d() {
        k kVar = this.f1001j;
        return kVar != null && kVar.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.f1001j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f1002k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f997f = view;
    }

    public void g(boolean z10) {
        this.f999h = z10;
        k kVar = this.f1001j;
        if (kVar != null) {
            kVar.r(z10);
        }
    }

    public void h(int i10) {
        this.f998g = i10;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f1002k = onDismissListener;
    }

    public void j(m.a aVar) {
        this.f1000i = aVar;
        k kVar = this.f1001j;
        if (kVar != null) {
            kVar.k(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f997f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i10, int i11) {
        if (d()) {
            return true;
        }
        if (this.f997f == null) {
            return false;
        }
        l(i10, i11, true, true);
        return true;
    }
}
