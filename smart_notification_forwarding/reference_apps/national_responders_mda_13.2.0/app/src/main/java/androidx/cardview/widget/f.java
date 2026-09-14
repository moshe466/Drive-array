package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class f extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private float f1587a;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f1589c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f1590d;

    /* renamed from: e, reason: collision with root package name */
    private float f1591e;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f1594h;

    /* renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f1595i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f1596j;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1592f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1593g = true;

    /* renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f1597k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f1588b = new Paint(5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ColorStateList colorStateList, float f10) {
        this.f1587a = f10;
        e(colorStateList);
        this.f1589c = new RectF();
        this.f1590d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1594h = colorStateList;
        this.f1588b.setColor(colorStateList.getColorForState(getState(), this.f1594h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1589c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f1590d.set(rect);
        if (this.f1592f) {
            this.f1590d.inset((int) Math.ceil(g.c(this.f1591e, this.f1587a, this.f1593g)), (int) Math.ceil(g.d(this.f1591e, this.f1587a, this.f1593g)));
            this.f1589c.set(this.f1590d);
        }
    }

    public ColorStateList b() {
        return this.f1594h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f1591e;
    }

    public float d() {
        return this.f1587a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z10;
        Paint paint = this.f1588b;
        if (this.f1595i == null || paint.getColorFilter() != null) {
            z10 = false;
        } else {
            paint.setColorFilter(this.f1595i);
            z10 = true;
        }
        RectF rectF = this.f1589c;
        float f10 = this.f1587a;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (z10) {
            paint.setColorFilter(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(float f10, boolean z10, boolean z11) {
        if (f10 == this.f1591e && this.f1592f == z10 && this.f1593g == z11) {
            return;
        }
        this.f1591e = f10;
        this.f1592f = z10;
        this.f1593g = z11;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1590d, this.f1587a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(float f10) {
        if (f10 == this.f1587a) {
            return;
        }
        this.f1587a = f10;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f1596j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f1594h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1594h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z10 = colorForState != this.f1588b.getColor();
        if (z10) {
            this.f1588b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1596j;
        if (colorStateList2 == null || (mode = this.f1597k) == null) {
            return z10;
        }
        this.f1595i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f1588b.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1588b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f1596j = colorStateList;
        this.f1595i = a(colorStateList, this.f1597k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f1597k = mode;
        this.f1595i = a(this.f1596j, mode);
        invalidateSelf();
    }
}
