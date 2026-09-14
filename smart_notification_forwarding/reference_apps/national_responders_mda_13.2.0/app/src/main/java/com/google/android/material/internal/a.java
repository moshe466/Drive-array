package com.google.android.material.internal;

import android.R;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.y0;
import androidx.core.view.a0;
import e.j;

/* loaded from: classes.dex */
public final class a {
    private static final boolean T;
    private static final Paint U;
    private Paint A;
    private float B;
    private float C;
    private float D;
    private float E;
    private int[] F;
    private boolean G;
    private final TextPaint H;
    private final TextPaint I;
    private TimeInterpolator J;
    private TimeInterpolator K;
    private float L;
    private float M;
    private float N;
    private int O;
    private float P;
    private float Q;
    private float R;
    private int S;

    /* renamed from: a, reason: collision with root package name */
    private final View f6888a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f6889b;

    /* renamed from: c, reason: collision with root package name */
    private float f6890c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f6891d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f6892e;

    /* renamed from: f, reason: collision with root package name */
    private final RectF f6893f;

    /* renamed from: g, reason: collision with root package name */
    private int f6894g = 16;

    /* renamed from: h, reason: collision with root package name */
    private int f6895h = 16;

    /* renamed from: i, reason: collision with root package name */
    private float f6896i = 15.0f;

    /* renamed from: j, reason: collision with root package name */
    private float f6897j = 15.0f;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f6898k;

    /* renamed from: l, reason: collision with root package name */
    private ColorStateList f6899l;

    /* renamed from: m, reason: collision with root package name */
    private float f6900m;

    /* renamed from: n, reason: collision with root package name */
    private float f6901n;

    /* renamed from: o, reason: collision with root package name */
    private float f6902o;

    /* renamed from: p, reason: collision with root package name */
    private float f6903p;

    /* renamed from: q, reason: collision with root package name */
    private float f6904q;

    /* renamed from: r, reason: collision with root package name */
    private float f6905r;

    /* renamed from: s, reason: collision with root package name */
    private Typeface f6906s;

    /* renamed from: t, reason: collision with root package name */
    private Typeface f6907t;

    /* renamed from: u, reason: collision with root package name */
    private Typeface f6908u;

    /* renamed from: v, reason: collision with root package name */
    private CharSequence f6909v;

    /* renamed from: w, reason: collision with root package name */
    private CharSequence f6910w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f6911x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f6912y;

    /* renamed from: z, reason: collision with root package name */
    private Bitmap f6913z;

    static {
        T = Build.VERSION.SDK_INT < 18;
        U = null;
    }

    public a(View view) {
        this.f6888a = view;
        TextPaint textPaint = new TextPaint(129);
        this.H = textPaint;
        this.I = new TextPaint(textPaint);
        this.f6892e = new Rect();
        this.f6891d = new Rect();
        this.f6893f = new RectF();
    }

    private void I(float f10) {
        g(f10);
        boolean z10 = T && this.D != 1.0f;
        this.f6912y = z10;
        if (z10) {
            j();
        }
        a0.d0(this.f6888a);
    }

    private static int a(int i10, int i11, float f10) {
        float f11 = 1.0f - f10;
        return Color.argb((int) ((Color.alpha(i10) * f11) + (Color.alpha(i11) * f10)), (int) ((Color.red(i10) * f11) + (Color.red(i11) * f10)), (int) ((Color.green(i10) * f11) + (Color.green(i11) * f10)), (int) ((Color.blue(i10) * f11) + (Color.blue(i11) * f10)));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b() {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.a.b():void");
    }

    private void d() {
        f(this.f6890c);
    }

    private boolean e(CharSequence charSequence) {
        return (a0.z(this.f6888a) == 1 ? androidx.core.text.d.f2487b : androidx.core.text.d.f2486a).a(charSequence, 0, charSequence.length());
    }

    private void f(float f10) {
        TextPaint textPaint;
        int n10;
        r(f10);
        this.f6904q = u(this.f6902o, this.f6903p, f10, this.J);
        this.f6905r = u(this.f6900m, this.f6901n, f10, this.J);
        I(u(this.f6896i, this.f6897j, f10, this.K));
        if (this.f6899l != this.f6898k) {
            textPaint = this.H;
            n10 = a(o(), n(), f10);
        } else {
            textPaint = this.H;
            n10 = n();
        }
        textPaint.setColor(n10);
        this.H.setShadowLayer(u(this.P, this.L, f10, null), u(this.Q, this.M, f10, null), u(this.R, this.N, f10, null), a(this.S, this.O, f10));
        a0.d0(this.f6888a);
    }

    private void g(float f10) {
        boolean z10;
        float f11;
        boolean z11;
        if (this.f6909v == null) {
            return;
        }
        float width = this.f6892e.width();
        float width2 = this.f6891d.width();
        if (s(f10, this.f6897j)) {
            f11 = this.f6897j;
            this.D = 1.0f;
            Typeface typeface = this.f6908u;
            Typeface typeface2 = this.f6906s;
            if (typeface != typeface2) {
                this.f6908u = typeface2;
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            float f12 = this.f6896i;
            Typeface typeface3 = this.f6908u;
            Typeface typeface4 = this.f6907t;
            if (typeface3 != typeface4) {
                this.f6908u = typeface4;
                z10 = true;
            } else {
                z10 = false;
            }
            if (s(f10, f12)) {
                this.D = 1.0f;
            } else {
                this.D = f10 / this.f6896i;
            }
            float f13 = this.f6897j / this.f6896i;
            width = width2 * f13 > width ? Math.min(width / f13, width2) : width2;
            f11 = f12;
            z11 = z10;
        }
        if (width > 0.0f) {
            z11 = this.E != f11 || this.G || z11;
            this.E = f11;
            this.G = false;
        }
        if (this.f6910w == null || z11) {
            this.H.setTextSize(this.E);
            this.H.setTypeface(this.f6908u);
            this.H.setLinearText(this.D != 1.0f);
            CharSequence ellipsize = TextUtils.ellipsize(this.f6909v, this.H, width, TextUtils.TruncateAt.END);
            if (TextUtils.equals(ellipsize, this.f6910w)) {
                return;
            }
            this.f6910w = ellipsize;
            this.f6911x = e(ellipsize);
        }
    }

    private void h() {
        Bitmap bitmap = this.f6913z;
        if (bitmap != null) {
            bitmap.recycle();
            this.f6913z = null;
        }
    }

    private void j() {
        if (this.f6913z != null || this.f6891d.isEmpty() || TextUtils.isEmpty(this.f6910w)) {
            return;
        }
        f(0.0f);
        this.B = this.H.ascent();
        this.C = this.H.descent();
        TextPaint textPaint = this.H;
        CharSequence charSequence = this.f6910w;
        int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
        int round2 = Math.round(this.C - this.B);
        if (round <= 0 || round2 <= 0) {
            return;
        }
        this.f6913z = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f6913z);
        CharSequence charSequence2 = this.f6910w;
        canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, round2 - this.H.descent(), this.H);
        if (this.A == null) {
            this.A = new Paint(3);
        }
    }

    private int o() {
        int[] iArr = this.F;
        return iArr != null ? this.f6898k.getColorForState(iArr, 0) : this.f6898k.getDefaultColor();
    }

    private void q(TextPaint textPaint) {
        textPaint.setTextSize(this.f6897j);
        textPaint.setTypeface(this.f6906s);
    }

    private void r(float f10) {
        this.f6893f.left = u(this.f6891d.left, this.f6892e.left, f10, this.J);
        this.f6893f.top = u(this.f6900m, this.f6901n, f10, this.J);
        this.f6893f.right = u(this.f6891d.right, this.f6892e.right, f10, this.J);
        this.f6893f.bottom = u(this.f6891d.bottom, this.f6892e.bottom, f10, this.J);
    }

    private static boolean s(float f10, float f11) {
        return Math.abs(f10 - f11) < 0.001f;
    }

    private static float u(float f10, float f11, float f12, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f12 = timeInterpolator.getInterpolation(f12);
        }
        return b3.a.a(f10, f11, f12);
    }

    private Typeface w(int i10) {
        TypedArray obtainStyledAttributes = this.f6888a.getContext().obtainStyledAttributes(i10, new int[]{R.attr.fontFamily});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private static boolean y(Rect rect, int i10, int i11, int i12, int i13) {
        return rect.left == i10 && rect.top == i11 && rect.right == i12 && rect.bottom == i13;
    }

    public void A(int i10) {
        y0 t10 = y0.t(this.f6888a.getContext(), i10, j.f9110x2);
        int i11 = j.B2;
        if (t10.s(i11)) {
            this.f6899l = t10.c(i11);
        }
        if (t10.s(j.f9115y2)) {
            this.f6897j = t10.f(r1, (int) this.f6897j);
        }
        this.O = t10.k(j.E2, 0);
        this.M = t10.i(j.F2, 0.0f);
        this.N = t10.i(j.G2, 0.0f);
        this.L = t10.i(j.H2, 0.0f);
        t10.w();
        if (Build.VERSION.SDK_INT >= 16) {
            this.f6906s = w(i10);
        }
        x();
    }

    public void B(ColorStateList colorStateList) {
        if (this.f6899l != colorStateList) {
            this.f6899l = colorStateList;
            x();
        }
    }

    public void C(int i10) {
        if (this.f6895h != i10) {
            this.f6895h = i10;
            x();
        }
    }

    public void D(int i10, int i11, int i12, int i13) {
        if (y(this.f6891d, i10, i11, i12, i13)) {
            return;
        }
        this.f6891d.set(i10, i11, i12, i13);
        this.G = true;
        v();
    }

    public void E(ColorStateList colorStateList) {
        if (this.f6898k != colorStateList) {
            this.f6898k = colorStateList;
            x();
        }
    }

    public void F(int i10) {
        if (this.f6894g != i10) {
            this.f6894g = i10;
            x();
        }
    }

    public void G(float f10) {
        if (this.f6896i != f10) {
            this.f6896i = f10;
            x();
        }
    }

    public void H(float f10) {
        float a10 = v.a.a(f10, 0.0f, 1.0f);
        if (a10 != this.f6890c) {
            this.f6890c = a10;
            d();
        }
    }

    public void J(TimeInterpolator timeInterpolator) {
        this.J = timeInterpolator;
        x();
    }

    public final boolean K(int[] iArr) {
        this.F = iArr;
        if (!t()) {
            return false;
        }
        x();
        return true;
    }

    public void L(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f6909v)) {
            this.f6909v = charSequence;
            this.f6910w = null;
            h();
            x();
        }
    }

    public void M(TimeInterpolator timeInterpolator) {
        this.K = timeInterpolator;
        x();
    }

    public void N(Typeface typeface) {
        this.f6907t = typeface;
        this.f6906s = typeface;
        x();
    }

    public float c() {
        if (this.f6909v == null) {
            return 0.0f;
        }
        q(this.I);
        TextPaint textPaint = this.I;
        CharSequence charSequence = this.f6909v;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void i(Canvas canvas) {
        float ascent;
        int save = canvas.save();
        if (this.f6910w != null && this.f6889b) {
            float f10 = this.f6904q;
            float f11 = this.f6905r;
            boolean z10 = this.f6912y && this.f6913z != null;
            if (z10) {
                ascent = this.B * this.D;
            } else {
                ascent = this.H.ascent() * this.D;
                this.H.descent();
            }
            if (z10) {
                f11 += ascent;
            }
            float f12 = f11;
            float f13 = this.D;
            if (f13 != 1.0f) {
                canvas.scale(f13, f13, f10, f12);
            }
            if (z10) {
                canvas.drawBitmap(this.f6913z, f10, f12, this.A);
            } else {
                CharSequence charSequence = this.f6910w;
                canvas.drawText(charSequence, 0, charSequence.length(), f10, f12, this.H);
            }
        }
        canvas.restoreToCount(save);
    }

    public void k(RectF rectF) {
        boolean e10 = e(this.f6909v);
        Rect rect = this.f6892e;
        float c10 = !e10 ? rect.left : rect.right - c();
        rectF.left = c10;
        Rect rect2 = this.f6892e;
        rectF.top = rect2.top;
        rectF.right = !e10 ? c10 + c() : rect2.right;
        rectF.bottom = this.f6892e.top + m();
    }

    public ColorStateList l() {
        return this.f6899l;
    }

    public float m() {
        q(this.I);
        return -this.I.ascent();
    }

    public int n() {
        int[] iArr = this.F;
        return iArr != null ? this.f6899l.getColorForState(iArr, 0) : this.f6899l.getDefaultColor();
    }

    public float p() {
        return this.f6890c;
    }

    public final boolean t() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f6899l;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f6898k) != null && colorStateList.isStateful());
    }

    void v() {
        this.f6889b = this.f6892e.width() > 0 && this.f6892e.height() > 0 && this.f6891d.width() > 0 && this.f6891d.height() > 0;
    }

    public void x() {
        if (this.f6888a.getHeight() <= 0 || this.f6888a.getWidth() <= 0) {
            return;
        }
        b();
        d();
    }

    public void z(int i10, int i11, int i12, int i13) {
        if (y(this.f6892e, i10, i11, i12, i13)) {
            return;
        }
        this.f6892e.set(i10, i11, i12, i13);
        this.G = true;
        v();
    }
}
