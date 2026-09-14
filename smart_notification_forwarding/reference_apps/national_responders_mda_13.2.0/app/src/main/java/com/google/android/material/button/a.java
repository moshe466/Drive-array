package com.google.android.material.button;

import a3.j;
import a3.k;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.f;
import androidx.core.view.a0;
import com.google.android.material.internal.g;

/* loaded from: classes.dex */
public class a extends f {

    /* renamed from: i, reason: collision with root package name */
    private final c f6795i;

    /* renamed from: j, reason: collision with root package name */
    private int f6796j;

    /* renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f6797k;

    /* renamed from: l, reason: collision with root package name */
    private ColorStateList f6798l;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f6799m;

    /* renamed from: n, reason: collision with root package name */
    private int f6800n;

    /* renamed from: o, reason: collision with root package name */
    private int f6801o;

    /* renamed from: p, reason: collision with root package name */
    private int f6802p;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a3.b.f97d);
    }

    public a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray h10 = com.google.android.material.internal.f.h(context, attributeSet, k.f164o, i10, j.f135c, new int[0]);
        this.f6796j = h10.getDimensionPixelSize(k.f177y, 0);
        this.f6797k = g.b(h10.getInt(k.B, -1), PorterDuff.Mode.SRC_IN);
        this.f6798l = g3.a.a(getContext(), h10, k.A);
        this.f6799m = g3.a.b(getContext(), h10, k.f175w);
        this.f6802p = h10.getInteger(k.f176x, 1);
        this.f6800n = h10.getDimensionPixelSize(k.f178z, 0);
        c cVar = new c(this);
        this.f6795i = cVar;
        cVar.k(h10);
        h10.recycle();
        setCompoundDrawablePadding(this.f6796j);
        c();
    }

    private boolean a() {
        return a0.z(this) == 1;
    }

    private boolean b() {
        c cVar = this.f6795i;
        return (cVar == null || cVar.j()) ? false : true;
    }

    private void c() {
        Drawable drawable = this.f6799m;
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.f6799m = mutate;
            androidx.core.graphics.drawable.a.o(mutate, this.f6798l);
            PorterDuff.Mode mode = this.f6797k;
            if (mode != null) {
                androidx.core.graphics.drawable.a.p(this.f6799m, mode);
            }
            int i10 = this.f6800n;
            if (i10 == 0) {
                i10 = this.f6799m.getIntrinsicWidth();
            }
            int i11 = this.f6800n;
            if (i11 == 0) {
                i11 = this.f6799m.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f6799m;
            int i12 = this.f6801o;
            drawable2.setBounds(i12, 0, i10 + i12, i11);
        }
        androidx.core.widget.j.i(this, this.f6799m, null, null, null);
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (b()) {
            return this.f6795i.d();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f6799m;
    }

    public int getIconGravity() {
        return this.f6802p;
    }

    public int getIconPadding() {
        return this.f6796j;
    }

    public int getIconSize() {
        return this.f6800n;
    }

    public ColorStateList getIconTint() {
        return this.f6798l;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f6797k;
    }

    public ColorStateList getRippleColor() {
        if (b()) {
            return this.f6795i.e();
        }
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (b()) {
            return this.f6795i.f();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (b()) {
            return this.f6795i.g();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.f, androidx.core.view.y
    public ColorStateList getSupportBackgroundTintList() {
        return b() ? this.f6795i.h() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.f, androidx.core.view.y
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return b() ? this.f6795i.i() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT >= 21 || !b()) {
            return;
        }
        this.f6795i.c(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.f, android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        c cVar;
        super.onLayout(z10, i10, i11, i12, i13);
        if (Build.VERSION.SDK_INT != 21 || (cVar = this.f6795i) == null) {
            return;
        }
        cVar.v(i13 - i11, i12 - i10);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f6799m == null || this.f6802p != 2) {
            return;
        }
        int measureText = (int) getPaint().measureText(getText().toString());
        int i12 = this.f6800n;
        if (i12 == 0) {
            i12 = this.f6799m.getIntrinsicWidth();
        }
        int measuredWidth = (((((getMeasuredWidth() - measureText) - a0.D(this)) - i12) - this.f6796j) - a0.E(this)) / 2;
        if (a()) {
            measuredWidth = -measuredWidth;
        }
        if (this.f6801o != measuredWidth) {
            this.f6801o = measuredWidth;
            c();
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        if (b()) {
            this.f6795i.l(i10);
        } else {
            super.setBackgroundColor(i10);
        }
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (b()) {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            this.f6795i.m();
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundResource(int i10) {
        setBackgroundDrawable(i10 != 0 ? f.a.b(getContext(), i10) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCornerRadius(int i10) {
        if (b()) {
            this.f6795i.n(i10);
        }
    }

    public void setCornerRadiusResource(int i10) {
        if (b()) {
            setCornerRadius(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f6799m != drawable) {
            this.f6799m = drawable;
            c();
        }
    }

    public void setIconGravity(int i10) {
        this.f6802p = i10;
    }

    public void setIconPadding(int i10) {
        if (this.f6796j != i10) {
            this.f6796j = i10;
            setCompoundDrawablePadding(i10);
        }
    }

    public void setIconResource(int i10) {
        setIcon(i10 != 0 ? f.a.b(getContext(), i10) : null);
    }

    public void setIconSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f6800n != i10) {
            this.f6800n = i10;
            c();
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f6798l != colorStateList) {
            this.f6798l = colorStateList;
            c();
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f6797k != mode) {
            this.f6797k = mode;
            c();
        }
    }

    public void setIconTintResource(int i10) {
        setIconTint(f.a.a(getContext(), i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (b()) {
            this.f6795i.o(colorStateList);
        }
    }

    public void setRippleColorResource(int i10) {
        if (b()) {
            setRippleColor(f.a.a(getContext(), i10));
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (b()) {
            this.f6795i.p(colorStateList);
        }
    }

    public void setStrokeColorResource(int i10) {
        if (b()) {
            setStrokeColor(f.a.a(getContext(), i10));
        }
    }

    public void setStrokeWidth(int i10) {
        if (b()) {
            this.f6795i.q(i10);
        }
    }

    public void setStrokeWidthResource(int i10) {
        if (b()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i10));
        }
    }

    @Override // androidx.appcompat.widget.f, androidx.core.view.y
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (b()) {
            this.f6795i.r(colorStateList);
        } else if (this.f6795i != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.f, androidx.core.view.y
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (b()) {
            this.f6795i.s(mode);
        } else if (this.f6795i != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }
}
