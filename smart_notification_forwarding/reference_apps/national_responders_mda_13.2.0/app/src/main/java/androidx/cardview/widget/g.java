package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class g extends Drawable {

    /* renamed from: q, reason: collision with root package name */
    private static final double f1598q = Math.cos(Math.toRadians(45.0d));

    /* renamed from: r, reason: collision with root package name */
    static a f1599r;

    /* renamed from: a, reason: collision with root package name */
    private final int f1600a;

    /* renamed from: c, reason: collision with root package name */
    private Paint f1602c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f1603d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f1604e;

    /* renamed from: f, reason: collision with root package name */
    private float f1605f;

    /* renamed from: g, reason: collision with root package name */
    private Path f1606g;

    /* renamed from: h, reason: collision with root package name */
    private float f1607h;

    /* renamed from: i, reason: collision with root package name */
    private float f1608i;

    /* renamed from: j, reason: collision with root package name */
    private float f1609j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f1610k;

    /* renamed from: m, reason: collision with root package name */
    private final int f1612m;

    /* renamed from: n, reason: collision with root package name */
    private final int f1613n;

    /* renamed from: l, reason: collision with root package name */
    private boolean f1611l = true;

    /* renamed from: o, reason: collision with root package name */
    private boolean f1614o = true;

    /* renamed from: p, reason: collision with root package name */
    private boolean f1615p = false;

    /* renamed from: b, reason: collision with root package name */
    private Paint f1601b = new Paint(5);

    /* loaded from: classes.dex */
    interface a {
        void a(Canvas canvas, RectF rectF, float f10, Paint paint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Resources resources, ColorStateList colorStateList, float f10, float f11, float f12) {
        this.f1612m = resources.getColor(k.b.f11104d);
        this.f1613n = resources.getColor(k.b.f11103c);
        this.f1600a = resources.getDimensionPixelSize(k.c.f11105a);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.f1602c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f1605f = (int) (f10 + 0.5f);
        this.f1604e = new RectF();
        Paint paint2 = new Paint(this.f1602c);
        this.f1603d = paint2;
        paint2.setAntiAlias(false);
        s(f11, f12);
    }

    private void a(Rect rect) {
        float f10 = this.f1607h;
        float f11 = 1.5f * f10;
        this.f1604e.set(rect.left + f10, rect.top + f11, rect.right - f10, rect.bottom - f11);
        b();
    }

    private void b() {
        float f10 = this.f1605f;
        RectF rectF = new RectF(-f10, -f10, f10, f10);
        RectF rectF2 = new RectF(rectF);
        float f11 = this.f1608i;
        rectF2.inset(-f11, -f11);
        Path path = this.f1606g;
        if (path == null) {
            this.f1606g = new Path();
        } else {
            path.reset();
        }
        this.f1606g.setFillType(Path.FillType.EVEN_ODD);
        this.f1606g.moveTo(-this.f1605f, 0.0f);
        this.f1606g.rLineTo(-this.f1608i, 0.0f);
        this.f1606g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f1606g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f1606g.close();
        float f12 = this.f1605f;
        float f13 = f12 / (this.f1608i + f12);
        Paint paint = this.f1602c;
        float f14 = this.f1605f + this.f1608i;
        int i10 = this.f1612m;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f14, new int[]{i10, i10, this.f1613n}, new float[]{0.0f, f13, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f1603d;
        float f15 = this.f1605f;
        float f16 = this.f1608i;
        int i11 = this.f1612m;
        paint2.setShader(new LinearGradient(0.0f, (-f15) + f16, 0.0f, (-f15) - f16, new int[]{i11, i11, this.f1613n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f1603d.setAntiAlias(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float c(float f10, float f11, boolean z10) {
        return z10 ? (float) (f10 + ((1.0d - f1598q) * f11)) : f10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float d(float f10, float f11, boolean z10) {
        float f12 = f10 * 1.5f;
        return z10 ? (float) (f12 + ((1.0d - f1598q) * f11)) : f12;
    }

    private void e(Canvas canvas) {
        float f10 = this.f1605f;
        float f11 = (-f10) - this.f1608i;
        float f12 = f10 + this.f1600a + (this.f1609j / 2.0f);
        float f13 = f12 * 2.0f;
        boolean z10 = this.f1604e.width() - f13 > 0.0f;
        boolean z11 = this.f1604e.height() - f13 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.f1604e;
        canvas.translate(rectF.left + f12, rectF.top + f12);
        canvas.drawPath(this.f1606g, this.f1602c);
        if (z10) {
            canvas.drawRect(0.0f, f11, this.f1604e.width() - f13, -this.f1605f, this.f1603d);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.f1604e;
        canvas.translate(rectF2.right - f12, rectF2.bottom - f12);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f1606g, this.f1602c);
        if (z10) {
            canvas.drawRect(0.0f, f11, this.f1604e.width() - f13, (-this.f1605f) + this.f1608i, this.f1603d);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.f1604e;
        canvas.translate(rectF3.left + f12, rectF3.bottom - f12);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f1606g, this.f1602c);
        if (z11) {
            canvas.drawRect(0.0f, f11, this.f1604e.height() - f13, -this.f1605f, this.f1603d);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.f1604e;
        canvas.translate(rectF4.right - f12, rectF4.top + f12);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f1606g, this.f1602c);
        if (z11) {
            canvas.drawRect(0.0f, f11, this.f1604e.height() - f13, -this.f1605f, this.f1603d);
        }
        canvas.restoreToCount(save4);
    }

    private void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1610k = colorStateList;
        this.f1601b.setColor(colorStateList.getColorForState(getState(), this.f1610k.getDefaultColor()));
    }

    private void s(float f10, float f11) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f10 + ". Must be >= 0");
        }
        if (f11 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f11 + ". Must be >= 0");
        }
        float t10 = t(f10);
        float t11 = t(f11);
        if (t10 > t11) {
            if (!this.f1615p) {
                this.f1615p = true;
            }
            t10 = t11;
        }
        if (this.f1609j == t10 && this.f1607h == t11) {
            return;
        }
        this.f1609j = t10;
        this.f1607h = t11;
        this.f1608i = (int) ((t10 * 1.5f) + this.f1600a + 0.5f);
        this.f1611l = true;
        invalidateSelf();
    }

    private int t(float f10) {
        int i10 = (int) (f10 + 0.5f);
        return i10 % 2 == 1 ? i10 - 1 : i10;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f1611l) {
            a(getBounds());
            this.f1611l = false;
        }
        canvas.translate(0.0f, this.f1609j / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.f1609j) / 2.0f);
        f1599r.a(canvas, this.f1604e, this.f1605f, this.f1601b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.f1610k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        return this.f1605f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(d(this.f1607h, this.f1605f, this.f1614o));
        int ceil2 = (int) Math.ceil(c(this.f1607h, this.f1605f, this.f1614o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Rect rect) {
        getPadding(rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.f1607h;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f1610k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        float f10 = this.f1607h;
        return (Math.max(f10, this.f1605f + this.f1600a + ((f10 * 1.5f) / 2.0f)) * 2.0f) + (((this.f1607h * 1.5f) + this.f1600a) * 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k() {
        float f10 = this.f1607h;
        return (Math.max(f10, this.f1605f + this.f1600a + (f10 / 2.0f)) * 2.0f) + ((this.f1607h + this.f1600a) * 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l() {
        return this.f1609j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(boolean z10) {
        this.f1614o = z10;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f1611l = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f1610k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f1601b.getColor() == colorForState) {
            return false;
        }
        this.f1601b.setColor(colorForState);
        this.f1611l = true;
        invalidateSelf();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f10 + ". Must be >= 0");
        }
        float f11 = (int) (f10 + 0.5f);
        if (this.f1605f == f11) {
            return;
        }
        this.f1605f = f11;
        this.f1611l = true;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(float f10) {
        s(this.f1609j, f10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(float f10) {
        s(f10, this.f1607h);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f1601b.setAlpha(i10);
        this.f1602c.setAlpha(i10);
        this.f1603d.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1601b.setColorFilter(colorFilter);
    }
}
