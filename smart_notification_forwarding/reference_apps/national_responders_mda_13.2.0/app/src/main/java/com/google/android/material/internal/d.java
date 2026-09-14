package com.google.android.material.internal;

import a3.k;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.k0;

/* loaded from: classes.dex */
public class d extends k0 {

    /* renamed from: u, reason: collision with root package name */
    private Drawable f6918u;

    /* renamed from: v, reason: collision with root package name */
    private final Rect f6919v;

    /* renamed from: w, reason: collision with root package name */
    private final Rect f6920w;

    /* renamed from: x, reason: collision with root package name */
    private int f6921x;

    /* renamed from: y, reason: collision with root package name */
    protected boolean f6922y;

    /* renamed from: z, reason: collision with root package name */
    boolean f6923z;

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f6919v = new Rect();
        this.f6920w = new Rect();
        this.f6921x = 119;
        this.f6922y = true;
        this.f6923z = false;
        TypedArray h10 = f.h(context, attributeSet, k.f156k, i10, 0, new int[0]);
        this.f6921x = h10.getInt(k.f160m, this.f6921x);
        Drawable drawable = h10.getDrawable(k.f158l);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f6922y = h10.getBoolean(k.f162n, true);
        h10.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f6918u;
        if (drawable != null) {
            if (this.f6923z) {
                this.f6923z = false;
                Rect rect = this.f6919v;
                Rect rect2 = this.f6920w;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f6922y) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f6921x, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.f6918u;
        if (drawable != null) {
            drawable.setHotspot(f10, f11);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f6918u;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f6918u.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f6918u;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f6921x;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f6918u;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.k0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f6923z = z10 | this.f6923z;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f6923z = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f6918u;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f6918u);
            }
            this.f6918u = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f6921x == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i10) {
        if (this.f6921x != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f6921x = i10;
            if (i10 == 119 && this.f6918u != null) {
                this.f6918u.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f6918u;
    }
}
