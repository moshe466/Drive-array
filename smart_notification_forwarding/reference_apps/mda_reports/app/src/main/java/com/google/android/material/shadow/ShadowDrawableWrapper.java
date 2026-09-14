package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;

/* loaded from: classes.dex */
public class ShadowDrawableWrapper extends DrawableWrapper {
    static final double i = Math.cos(Math.toRadians(45.0d));
    final Paint a;
    private boolean addPaddingForCorners;
    final Paint b;
    final RectF c;
    float d;
    private boolean dirty;
    Path e;
    float f;
    float g;
    float h;
    private boolean printedShadowClipWarning;
    private float rotation;
    private final int shadowEndColor;
    private final int shadowMiddleColor;
    private final int shadowStartColor;

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.dirty = true;
        this.addPaddingForCorners = true;
        this.printedShadowClipWarning = false;
        this.shadowStartColor = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.shadowMiddleColor = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.shadowEndColor = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        this.a = new Paint(5);
        this.a.setStyle(Paint.Style.FILL);
        this.d = Math.round(f);
        this.c = new RectF();
        this.b = new Paint(this.a);
        this.b.setAntiAlias(false);
        setShadowSize(f2, f3);
    }

    private void buildComponents(Rect rect) {
        float f = this.f;
        float f2 = 1.5f * f;
        this.c.set(rect.left + f, rect.top + f2, rect.right - f, rect.bottom - f2);
        Drawable wrappedDrawable = getWrappedDrawable();
        RectF rectF = this.c;
        wrappedDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float f = this.d;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.g;
        rectF2.inset(-f2, -f2);
        Path path = this.e;
        if (path == null) {
            this.e = new Path();
        } else {
            path.reset();
        }
        this.e.setFillType(Path.FillType.EVEN_ODD);
        this.e.moveTo(-this.d, 0.0f);
        this.e.rLineTo(-this.g, 0.0f);
        this.e.arcTo(rectF2, 180.0f, 90.0f, false);
        this.e.arcTo(rectF, 270.0f, -90.0f, false);
        this.e.close();
        float f3 = -rectF2.top;
        if (f3 > 0.0f) {
            float f4 = this.d / f3;
            this.a.setShader(new RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, f4, ((1.0f - f4) / 2.0f) + f4, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.b.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.b.setAntiAlias(false);
    }

    public static float calculateHorizontalPadding(float f, float f2, boolean z) {
        if (!z) {
            return f;
        }
        double d = f;
        double d2 = 1.0d - i;
        double d3 = f2;
        Double.isNaN(d3);
        Double.isNaN(d);
        return (float) (d + (d2 * d3));
    }

    public static float calculateVerticalPadding(float f, float f2, boolean z) {
        float f3 = f * 1.5f;
        if (!z) {
            return f3;
        }
        double d = f3;
        double d2 = 1.0d - i;
        double d3 = f2;
        Double.isNaN(d3);
        Double.isNaN(d);
        return (float) (d + (d2 * d3));
    }

    private void drawShadow(Canvas canvas) {
        int i2;
        float f;
        int i3;
        float f2;
        float f3;
        float f4;
        int save = canvas.save();
        canvas.rotate(this.rotation, this.c.centerX(), this.c.centerY());
        float f5 = this.d;
        float f6 = (-f5) - this.g;
        float f7 = f5 * 2.0f;
        boolean z = this.c.width() - f7 > 0.0f;
        boolean z2 = this.c.height() - f7 > 0.0f;
        float f8 = this.h;
        float f9 = f5 / ((f8 - (0.5f * f8)) + f5);
        float f10 = f5 / ((f8 - (0.25f * f8)) + f5);
        float f11 = f5 / ((f8 - (f8 * 1.0f)) + f5);
        int save2 = canvas.save();
        RectF rectF = this.c;
        canvas.translate(rectF.left + f5, rectF.top + f5);
        canvas.scale(f9, f10);
        canvas.drawPath(this.e, this.a);
        if (z) {
            canvas.scale(1.0f / f9, 1.0f);
            i2 = save2;
            f = f11;
            i3 = save;
            f2 = f10;
            canvas.drawRect(0.0f, f6, this.c.width() - f7, -this.d, this.b);
        } else {
            i2 = save2;
            f = f11;
            i3 = save;
            f2 = f10;
        }
        canvas.restoreToCount(i2);
        int save3 = canvas.save();
        RectF rectF2 = this.c;
        canvas.translate(rectF2.right - f5, rectF2.bottom - f5);
        float f12 = f;
        canvas.scale(f9, f12);
        canvas.rotate(180.0f);
        canvas.drawPath(this.e, this.a);
        if (z) {
            canvas.scale(1.0f / f9, 1.0f);
            f3 = f2;
            f4 = f12;
            canvas.drawRect(0.0f, f6, this.c.width() - f7, (-this.d) + this.g, this.b);
        } else {
            f3 = f2;
            f4 = f12;
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF3 = this.c;
        canvas.translate(rectF3.left + f5, rectF3.bottom - f5);
        canvas.scale(f9, f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.e, this.a);
        if (z2) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f6, this.c.height() - f7, -this.d, this.b);
        }
        canvas.restoreToCount(save4);
        int save5 = canvas.save();
        RectF rectF4 = this.c;
        canvas.translate(rectF4.right - f5, rectF4.top + f5);
        float f13 = f3;
        canvas.scale(f9, f13);
        canvas.rotate(90.0f);
        canvas.drawPath(this.e, this.a);
        if (z2) {
            canvas.scale(1.0f / f13, 1.0f);
            canvas.drawRect(0.0f, f6, this.c.height() - f7, -this.d, this.b);
        }
        canvas.restoreToCount(save5);
        canvas.restoreToCount(i3);
    }

    private static int toEven(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.dirty) {
            buildComponents(getBounds());
            this.dirty = false;
        }
        drawShadow(canvas);
        super.draw(canvas);
    }

    public float getCornerRadius() {
        return this.d;
    }

    public float getMaxShadowSize() {
        return this.f;
    }

    public float getMinHeight() {
        float f = this.f;
        return (Math.max(f, this.d + ((f * 1.5f) / 2.0f)) * 2.0f) + (this.f * 1.5f * 2.0f);
    }

    public float getMinWidth() {
        float f = this.f;
        return (Math.max(f, this.d + (f / 2.0f)) * 2.0f) + (this.f * 2.0f);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(calculateVerticalPadding(this.f, this.d, this.addPaddingForCorners));
        int ceil2 = (int) Math.ceil(calculateHorizontalPadding(this.f, this.d, this.addPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public float getShadowSize() {
        return this.h;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.dirty = true;
    }

    public void setAddPaddingForCorners(boolean z) {
        this.addPaddingForCorners = z;
        invalidateSelf();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        super.setAlpha(i2);
        this.a.setAlpha(i2);
        this.b.setAlpha(i2);
    }

    public void setCornerRadius(float f) {
        float round = Math.round(f);
        if (this.d == round) {
            return;
        }
        this.d = round;
        this.dirty = true;
        invalidateSelf();
    }

    public void setMaxShadowSize(float f) {
        setShadowSize(this.h, f);
    }

    public final void setRotation(float f) {
        if (this.rotation != f) {
            this.rotation = f;
            invalidateSelf();
        }
    }

    public void setShadowSize(float f) {
        setShadowSize(f, this.f);
    }

    public void setShadowSize(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float even = toEven(f);
        float even2 = toEven(f2);
        if (even > even2) {
            if (!this.printedShadowClipWarning) {
                this.printedShadowClipWarning = true;
            }
            even = even2;
        }
        if (this.h == even && this.f == even2) {
            return;
        }
        this.h = even;
        this.f = even2;
        this.g = Math.round(even * 1.5f);
        this.dirty = true;
        invalidateSelf();
    }
}
