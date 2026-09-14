package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private final View f1303a;

    /* renamed from: d, reason: collision with root package name */
    private w0 f1306d;

    /* renamed from: e, reason: collision with root package name */
    private w0 f1307e;

    /* renamed from: f, reason: collision with root package name */
    private w0 f1308f;

    /* renamed from: c, reason: collision with root package name */
    private int f1305c = -1;

    /* renamed from: b, reason: collision with root package name */
    private final k f1304b = k.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(View view) {
        this.f1303a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f1308f == null) {
            this.f1308f = new w0();
        }
        w0 w0Var = this.f1308f;
        w0Var.a();
        ColorStateList p10 = androidx.core.view.a0.p(this.f1303a);
        if (p10 != null) {
            w0Var.f1537d = true;
            w0Var.f1534a = p10;
        }
        PorterDuff.Mode q10 = androidx.core.view.a0.q(this.f1303a);
        if (q10 != null) {
            w0Var.f1536c = true;
            w0Var.f1535b = q10;
        }
        if (!w0Var.f1537d && !w0Var.f1536c) {
            return false;
        }
        k.i(drawable, w0Var, this.f1303a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 > 21 ? this.f1306d != null : i10 == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.f1303a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            w0 w0Var = this.f1307e;
            if (w0Var != null) {
                k.i(background, w0Var, this.f1303a.getDrawableState());
                return;
            }
            w0 w0Var2 = this.f1306d;
            if (w0Var2 != null) {
                k.i(background, w0Var2, this.f1303a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        w0 w0Var = this.f1307e;
        if (w0Var != null) {
            return w0Var.f1534a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        w0 w0Var = this.f1307e;
        if (w0Var != null) {
            return w0Var.f1535b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i10) {
        Context context = this.f1303a.getContext();
        int[] iArr = e.j.f9101v3;
        y0 v10 = y0.v(context, attributeSet, iArr, i10, 0);
        View view = this.f1303a;
        androidx.core.view.a0.h0(view, view.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        try {
            int i11 = e.j.f9106w3;
            if (v10.s(i11)) {
                this.f1305c = v10.n(i11, -1);
                ColorStateList f10 = this.f1304b.f(this.f1303a.getContext(), this.f1305c);
                if (f10 != null) {
                    h(f10);
                }
            }
            int i12 = e.j.f9111x3;
            if (v10.s(i12)) {
                androidx.core.view.a0.o0(this.f1303a, v10.c(i12));
            }
            int i13 = e.j.f9116y3;
            if (v10.s(i13)) {
                androidx.core.view.a0.p0(this.f1303a, g0.d(v10.k(i13, -1), null));
            }
        } finally {
            v10.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f1305c = -1;
        h(null);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i10) {
        this.f1305c = i10;
        k kVar = this.f1304b;
        h(kVar != null ? kVar.f(this.f1303a.getContext(), i10) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1306d == null) {
                this.f1306d = new w0();
            }
            w0 w0Var = this.f1306d;
            w0Var.f1534a = colorStateList;
            w0Var.f1537d = true;
        } else {
            this.f1306d = null;
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.f1307e == null) {
            this.f1307e = new w0();
        }
        w0 w0Var = this.f1307e;
        w0Var.f1534a = colorStateList;
        w0Var.f1537d = true;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.f1307e == null) {
            this.f1307e = new w0();
        }
        w0 w0Var = this.f1307e;
        w0Var.f1535b = mode;
        w0Var.f1536c = true;
        b();
    }
}
