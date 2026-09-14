package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
class a extends GradientDrawable {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f6992a = new Paint(1);

    /* renamed from: b, reason: collision with root package name */
    private final RectF f6993b;

    /* renamed from: c, reason: collision with root package name */
    private int f6994c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        h();
        this.f6993b = new RectF();
    }

    private void b(Canvas canvas) {
        if (i(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.f6994c);
    }

    private void c(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (i(callback)) {
            ((View) callback).setLayerType(2, null);
        } else {
            e(canvas);
        }
    }

    private void e(Canvas canvas) {
        this.f6994c = Build.VERSION.SDK_INT >= 21 ? canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null) : canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
    }

    private void h() {
        this.f6992a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f6992a.setColor(-1);
        this.f6992a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean i(Drawable.Callback callback) {
        return callback instanceof View;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return !this.f6993b.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        f(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        c(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f6993b, this.f6992a);
        b(canvas);
    }

    void f(float f10, float f11, float f12, float f13) {
        RectF rectF = this.f6993b;
        if (f10 == rectF.left && f11 == rectF.top && f12 == rectF.right && f13 == rectF.bottom) {
            return;
        }
        rectF.set(f10, f11, f12, f13);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(RectF rectF) {
        f(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
