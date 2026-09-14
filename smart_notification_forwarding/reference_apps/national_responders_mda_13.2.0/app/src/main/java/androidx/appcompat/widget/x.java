package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* loaded from: classes.dex */
class x extends s {

    /* renamed from: d, reason: collision with root package name */
    private final SeekBar f1538d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f1539e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f1540f;

    /* renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f1541g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1542h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1543i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SeekBar seekBar) {
        super(seekBar);
        this.f1540f = null;
        this.f1541g = null;
        this.f1542h = false;
        this.f1543i = false;
        this.f1538d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f1539e;
        if (drawable != null) {
            if (this.f1542h || this.f1543i) {
                Drawable q10 = androidx.core.graphics.drawable.a.q(drawable.mutate());
                this.f1539e = q10;
                if (this.f1542h) {
                    androidx.core.graphics.drawable.a.o(q10, this.f1540f);
                }
                if (this.f1543i) {
                    androidx.core.graphics.drawable.a.p(this.f1539e, this.f1541g);
                }
                if (this.f1539e.isStateful()) {
                    this.f1539e.setState(this.f1538d.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.widget.s
    public void c(AttributeSet attributeSet, int i10) {
        super.c(attributeSet, i10);
        Context context = this.f1538d.getContext();
        int[] iArr = e.j.Q;
        y0 v10 = y0.v(context, attributeSet, iArr, i10, 0);
        SeekBar seekBar = this.f1538d;
        androidx.core.view.a0.h0(seekBar, seekBar.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        Drawable h10 = v10.h(e.j.R);
        if (h10 != null) {
            this.f1538d.setThumb(h10);
        }
        j(v10.g(e.j.S));
        int i11 = e.j.U;
        if (v10.s(i11)) {
            this.f1541g = g0.d(v10.k(i11, -1), this.f1541g);
            this.f1543i = true;
        }
        int i12 = e.j.T;
        if (v10.s(i12)) {
            this.f1540f = v10.c(i12);
            this.f1542h = true;
        }
        v10.w();
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        if (this.f1539e != null) {
            int max = this.f1538d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f1539e.getIntrinsicWidth();
                int intrinsicHeight = this.f1539e.getIntrinsicHeight();
                int i10 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i11 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f1539e.setBounds(-i10, -i11, i10, i11);
                float width = ((this.f1538d.getWidth() - this.f1538d.getPaddingLeft()) - this.f1538d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f1538d.getPaddingLeft(), this.f1538d.getHeight() / 2);
                for (int i12 = 0; i12 <= max; i12++) {
                    this.f1539e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.f1539e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1538d.getDrawableState())) {
            this.f1538d.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f1539e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.f1539e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1539e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1538d);
            androidx.core.graphics.drawable.a.m(drawable, androidx.core.view.a0.z(this.f1538d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1538d.getDrawableState());
            }
            f();
        }
        this.f1538d.invalidate();
    }
}
