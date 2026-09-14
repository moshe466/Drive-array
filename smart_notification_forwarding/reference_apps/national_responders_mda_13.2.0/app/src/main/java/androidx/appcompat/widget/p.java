package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private final ImageView f1460a;

    /* renamed from: b, reason: collision with root package name */
    private w0 f1461b;

    /* renamed from: c, reason: collision with root package name */
    private w0 f1462c;

    /* renamed from: d, reason: collision with root package name */
    private w0 f1463d;

    /* renamed from: e, reason: collision with root package name */
    private int f1464e = 0;

    public p(ImageView imageView) {
        this.f1460a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f1463d == null) {
            this.f1463d = new w0();
        }
        w0 w0Var = this.f1463d;
        w0Var.a();
        ColorStateList a10 = androidx.core.widget.f.a(this.f1460a);
        if (a10 != null) {
            w0Var.f1537d = true;
            w0Var.f1534a = a10;
        }
        PorterDuff.Mode b10 = androidx.core.widget.f.b(this.f1460a);
        if (b10 != null) {
            w0Var.f1536c = true;
            w0Var.f1535b = b10;
        }
        if (!w0Var.f1537d && !w0Var.f1536c) {
            return false;
        }
        k.i(drawable, w0Var, this.f1460a.getDrawableState());
        return true;
    }

    private boolean l() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 > 21 ? this.f1461b != null : i10 == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f1460a.getDrawable() != null) {
            this.f1460a.getDrawable().setLevel(this.f1464e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.f1460a.getDrawable();
        if (drawable != null) {
            g0.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            w0 w0Var = this.f1462c;
            if (w0Var != null) {
                k.i(drawable, w0Var, this.f1460a.getDrawableState());
                return;
            }
            w0 w0Var2 = this.f1461b;
            if (w0Var2 != null) {
                k.i(drawable, w0Var2, this.f1460a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList d() {
        w0 w0Var = this.f1462c;
        if (w0Var != null) {
            return w0Var.f1534a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode e() {
        w0 w0Var = this.f1462c;
        if (w0Var != null) {
            return w0Var.f1535b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1460a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i10) {
        int n10;
        Context context = this.f1460a.getContext();
        int[] iArr = e.j.M;
        y0 v10 = y0.v(context, attributeSet, iArr, i10, 0);
        ImageView imageView = this.f1460a;
        androidx.core.view.a0.h0(imageView, imageView.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        try {
            Drawable drawable = this.f1460a.getDrawable();
            if (drawable == null && (n10 = v10.n(e.j.N, -1)) != -1 && (drawable = f.a.b(this.f1460a.getContext(), n10)) != null) {
                this.f1460a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                g0.b(drawable);
            }
            int i11 = e.j.O;
            if (v10.s(i11)) {
                androidx.core.widget.f.c(this.f1460a, v10.c(i11));
            }
            int i12 = e.j.P;
            if (v10.s(i12)) {
                androidx.core.widget.f.d(this.f1460a, g0.d(v10.k(i12, -1), null));
            }
        } finally {
            v10.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Drawable drawable) {
        this.f1464e = drawable.getLevel();
    }

    public void i(int i10) {
        if (i10 != 0) {
            Drawable b10 = f.a.b(this.f1460a.getContext(), i10);
            if (b10 != null) {
                g0.b(b10);
            }
            this.f1460a.setImageDrawable(b10);
        } else {
            this.f1460a.setImageDrawable(null);
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ColorStateList colorStateList) {
        if (this.f1462c == null) {
            this.f1462c = new w0();
        }
        w0 w0Var = this.f1462c;
        w0Var.f1534a = colorStateList;
        w0Var.f1537d = true;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(PorterDuff.Mode mode) {
        if (this.f1462c == null) {
            this.f1462c = new w0();
        }
        w0 w0Var = this.f1462c;
        w0Var.f1535b = mode;
        w0Var.f1536c = true;
        c();
    }
}
