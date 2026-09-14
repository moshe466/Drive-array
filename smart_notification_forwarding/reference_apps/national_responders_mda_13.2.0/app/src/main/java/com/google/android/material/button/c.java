package com.google.android.material.button;

import a3.k;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.core.view.a0;
import com.google.android.material.internal.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {

    /* renamed from: w, reason: collision with root package name */
    private static final boolean f6803w;

    /* renamed from: a, reason: collision with root package name */
    private final a f6804a;

    /* renamed from: b, reason: collision with root package name */
    private int f6805b;

    /* renamed from: c, reason: collision with root package name */
    private int f6806c;

    /* renamed from: d, reason: collision with root package name */
    private int f6807d;

    /* renamed from: e, reason: collision with root package name */
    private int f6808e;

    /* renamed from: f, reason: collision with root package name */
    private int f6809f;

    /* renamed from: g, reason: collision with root package name */
    private int f6810g;

    /* renamed from: h, reason: collision with root package name */
    private PorterDuff.Mode f6811h;

    /* renamed from: i, reason: collision with root package name */
    private ColorStateList f6812i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f6813j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f6814k;

    /* renamed from: o, reason: collision with root package name */
    private GradientDrawable f6818o;

    /* renamed from: p, reason: collision with root package name */
    private Drawable f6819p;

    /* renamed from: q, reason: collision with root package name */
    private GradientDrawable f6820q;

    /* renamed from: r, reason: collision with root package name */
    private Drawable f6821r;

    /* renamed from: s, reason: collision with root package name */
    private GradientDrawable f6822s;

    /* renamed from: t, reason: collision with root package name */
    private GradientDrawable f6823t;

    /* renamed from: u, reason: collision with root package name */
    private GradientDrawable f6824u;

    /* renamed from: l, reason: collision with root package name */
    private final Paint f6815l = new Paint(1);

    /* renamed from: m, reason: collision with root package name */
    private final Rect f6816m = new Rect();

    /* renamed from: n, reason: collision with root package name */
    private final RectF f6817n = new RectF();

    /* renamed from: v, reason: collision with root package name */
    private boolean f6825v = false;

    static {
        f6803w = Build.VERSION.SDK_INT >= 21;
    }

    public c(a aVar) {
        this.f6804a = aVar;
    }

    private Drawable a() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f6818o = gradientDrawable;
        gradientDrawable.setCornerRadius(this.f6809f + 1.0E-5f);
        this.f6818o.setColor(-1);
        Drawable q10 = androidx.core.graphics.drawable.a.q(this.f6818o);
        this.f6819p = q10;
        androidx.core.graphics.drawable.a.o(q10, this.f6812i);
        PorterDuff.Mode mode = this.f6811h;
        if (mode != null) {
            androidx.core.graphics.drawable.a.p(this.f6819p, mode);
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.f6820q = gradientDrawable2;
        gradientDrawable2.setCornerRadius(this.f6809f + 1.0E-5f);
        this.f6820q.setColor(-1);
        Drawable q11 = androidx.core.graphics.drawable.a.q(this.f6820q);
        this.f6821r = q11;
        androidx.core.graphics.drawable.a.o(q11, this.f6814k);
        return y(new LayerDrawable(new Drawable[]{this.f6819p, this.f6821r}));
    }

    @TargetApi(21)
    private Drawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f6822s = gradientDrawable;
        gradientDrawable.setCornerRadius(this.f6809f + 1.0E-5f);
        this.f6822s.setColor(-1);
        x();
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.f6823t = gradientDrawable2;
        gradientDrawable2.setCornerRadius(this.f6809f + 1.0E-5f);
        this.f6823t.setColor(0);
        this.f6823t.setStroke(this.f6810g, this.f6813j);
        InsetDrawable y10 = y(new LayerDrawable(new Drawable[]{this.f6822s, this.f6823t}));
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.f6824u = gradientDrawable3;
        gradientDrawable3.setCornerRadius(this.f6809f + 1.0E-5f);
        this.f6824u.setColor(-1);
        return new b(h3.a.a(this.f6814k), y10, this.f6824u);
    }

    private GradientDrawable t() {
        if (!f6803w || this.f6804a.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f6804a.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }

    private GradientDrawable u() {
        if (!f6803w || this.f6804a.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f6804a.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }

    private void w() {
        boolean z10 = f6803w;
        if (z10 && this.f6823t != null) {
            this.f6804a.setInternalBackground(b());
        } else {
            if (z10) {
                return;
            }
            this.f6804a.invalidate();
        }
    }

    private void x() {
        GradientDrawable gradientDrawable = this.f6822s;
        if (gradientDrawable != null) {
            androidx.core.graphics.drawable.a.o(gradientDrawable, this.f6812i);
            PorterDuff.Mode mode = this.f6811h;
            if (mode != null) {
                androidx.core.graphics.drawable.a.p(this.f6822s, mode);
            }
        }
    }

    private InsetDrawable y(Drawable drawable) {
        return new InsetDrawable(drawable, this.f6805b, this.f6807d, this.f6806c, this.f6808e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Canvas canvas) {
        if (canvas == null || this.f6813j == null || this.f6810g <= 0) {
            return;
        }
        this.f6816m.set(this.f6804a.getBackground().getBounds());
        RectF rectF = this.f6817n;
        float f10 = this.f6816m.left;
        int i10 = this.f6810g;
        rectF.set(f10 + (i10 / 2.0f) + this.f6805b, r1.top + (i10 / 2.0f) + this.f6807d, (r1.right - (i10 / 2.0f)) - this.f6806c, (r1.bottom - (i10 / 2.0f)) - this.f6808e);
        float f11 = this.f6809f - (this.f6810g / 2.0f);
        canvas.drawRoundRect(this.f6817n, f11, f11, this.f6815l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f6809f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList e() {
        return this.f6814k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.f6813j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f6810g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList h() {
        return this.f6812i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode i() {
        return this.f6811h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.f6825v;
    }

    public void k(TypedArray typedArray) {
        this.f6805b = typedArray.getDimensionPixelOffset(k.f166p, 0);
        this.f6806c = typedArray.getDimensionPixelOffset(k.f168q, 0);
        this.f6807d = typedArray.getDimensionPixelOffset(k.f170r, 0);
        this.f6808e = typedArray.getDimensionPixelOffset(k.f171s, 0);
        this.f6809f = typedArray.getDimensionPixelSize(k.f174v, 0);
        this.f6810g = typedArray.getDimensionPixelSize(k.E, 0);
        this.f6811h = g.b(typedArray.getInt(k.f173u, -1), PorterDuff.Mode.SRC_IN);
        this.f6812i = g3.a.a(this.f6804a.getContext(), typedArray, k.f172t);
        this.f6813j = g3.a.a(this.f6804a.getContext(), typedArray, k.D);
        this.f6814k = g3.a.a(this.f6804a.getContext(), typedArray, k.C);
        this.f6815l.setStyle(Paint.Style.STROKE);
        this.f6815l.setStrokeWidth(this.f6810g);
        Paint paint = this.f6815l;
        ColorStateList colorStateList = this.f6813j;
        paint.setColor(colorStateList != null ? colorStateList.getColorForState(this.f6804a.getDrawableState(), 0) : 0);
        int E = a0.E(this.f6804a);
        int paddingTop = this.f6804a.getPaddingTop();
        int D = a0.D(this.f6804a);
        int paddingBottom = this.f6804a.getPaddingBottom();
        this.f6804a.setInternalBackground(f6803w ? b() : a());
        a0.x0(this.f6804a, E + this.f6805b, paddingTop + this.f6807d, D + this.f6806c, paddingBottom + this.f6808e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(int i10) {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        boolean z10 = f6803w;
        if (z10 && (gradientDrawable2 = this.f6822s) != null) {
            gradientDrawable2.setColor(i10);
        } else {
            if (z10 || (gradientDrawable = this.f6818o) == null) {
                return;
            }
            gradientDrawable.setColor(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        this.f6825v = true;
        this.f6804a.setSupportBackgroundTintList(this.f6812i);
        this.f6804a.setSupportBackgroundTintMode(this.f6811h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i10) {
        GradientDrawable gradientDrawable;
        if (this.f6809f != i10) {
            this.f6809f = i10;
            boolean z10 = f6803w;
            if (!z10 || this.f6822s == null || this.f6823t == null || this.f6824u == null) {
                if (z10 || (gradientDrawable = this.f6818o) == null || this.f6820q == null) {
                    return;
                }
                float f10 = i10 + 1.0E-5f;
                gradientDrawable.setCornerRadius(f10);
                this.f6820q.setCornerRadius(f10);
                this.f6804a.invalidate();
                return;
            }
            if (Build.VERSION.SDK_INT == 21) {
                float f11 = i10 + 1.0E-5f;
                t().setCornerRadius(f11);
                u().setCornerRadius(f11);
            }
            float f12 = i10 + 1.0E-5f;
            this.f6822s.setCornerRadius(f12);
            this.f6823t.setCornerRadius(f12);
            this.f6824u.setCornerRadius(f12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f6814k != colorStateList) {
            this.f6814k = colorStateList;
            boolean z10 = f6803w;
            if (z10 && (this.f6804a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f6804a.getBackground()).setColor(colorStateList);
            } else {
                if (z10 || (drawable = this.f6821r) == null) {
                    return;
                }
                androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ColorStateList colorStateList) {
        if (this.f6813j != colorStateList) {
            this.f6813j = colorStateList;
            this.f6815l.setColor(colorStateList != null ? colorStateList.getColorForState(this.f6804a.getDrawableState(), 0) : 0);
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i10) {
        if (this.f6810g != i10) {
            this.f6810g = i10;
            this.f6815l.setStrokeWidth(i10);
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(ColorStateList colorStateList) {
        if (this.f6812i != colorStateList) {
            this.f6812i = colorStateList;
            if (f6803w) {
                x();
                return;
            }
            Drawable drawable = this.f6819p;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(PorterDuff.Mode mode) {
        if (this.f6811h != mode) {
            this.f6811h = mode;
            if (f6803w) {
                x();
                return;
            }
            Drawable drawable = this.f6819p;
            if (drawable == null || mode == null) {
                return;
            }
            androidx.core.graphics.drawable.a.p(drawable, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(int i10, int i11) {
        GradientDrawable gradientDrawable = this.f6824u;
        if (gradientDrawable != null) {
            gradientDrawable.setBounds(this.f6805b, this.f6807d, i11 - this.f6806c, i10 - this.f6808e);
        }
    }
}
