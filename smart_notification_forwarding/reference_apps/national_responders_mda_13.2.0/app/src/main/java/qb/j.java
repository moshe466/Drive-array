package qb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* loaded from: classes.dex */
public class j extends View implements g {

    /* renamed from: t, reason: collision with root package name */
    private static final int[] f13626t = {0, 64, 128, 192, 255, 192, 128, 64};

    /* renamed from: f, reason: collision with root package name */
    private Rect f13627f;

    /* renamed from: g, reason: collision with root package name */
    private int f13628g;

    /* renamed from: h, reason: collision with root package name */
    private final int f13629h;

    /* renamed from: i, reason: collision with root package name */
    private final int f13630i;

    /* renamed from: j, reason: collision with root package name */
    private final int f13631j;

    /* renamed from: k, reason: collision with root package name */
    private final int f13632k;

    /* renamed from: l, reason: collision with root package name */
    private final int f13633l;

    /* renamed from: m, reason: collision with root package name */
    protected Paint f13634m;

    /* renamed from: n, reason: collision with root package name */
    protected Paint f13635n;

    /* renamed from: o, reason: collision with root package name */
    protected Paint f13636o;

    /* renamed from: p, reason: collision with root package name */
    protected int f13637p;

    /* renamed from: q, reason: collision with root package name */
    protected boolean f13638q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f13639r;

    /* renamed from: s, reason: collision with root package name */
    private int f13640s;

    public j(Context context) {
        super(context);
        this.f13629h = getResources().getColor(h.f13622b);
        this.f13630i = getResources().getColor(h.f13623c);
        this.f13631j = getResources().getColor(h.f13621a);
        this.f13632k = getResources().getInteger(i.f13625b);
        this.f13633l = getResources().getInteger(i.f13624a);
        this.f13640s = 0;
        e();
    }

    private void e() {
        Paint paint = new Paint();
        this.f13634m = paint;
        paint.setColor(this.f13629h);
        this.f13634m.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f13635n = paint2;
        paint2.setColor(this.f13630i);
        Paint paint3 = new Paint();
        this.f13636o = paint3;
        paint3.setColor(this.f13631j);
        this.f13636o.setStyle(Paint.Style.STROKE);
        this.f13636o.setStrokeWidth(this.f13632k);
        this.f13636o.setAntiAlias(true);
        this.f13637p = this.f13633l;
    }

    @Override // qb.g
    public void a() {
        f();
        invalidate();
    }

    public void b(Canvas canvas) {
        Rect framingRect = getFramingRect();
        Paint paint = this.f13634m;
        int[] iArr = f13626t;
        paint.setAlpha(iArr[this.f13628g]);
        this.f13628g = (this.f13628g + 1) % iArr.length;
        int height = (framingRect.height() / 2) + framingRect.top;
        canvas.drawRect(framingRect.left + 2, height - 1, framingRect.right - 1, height + 2, this.f13634m);
        postInvalidateDelayed(80L, framingRect.left - 10, framingRect.top - 10, framingRect.right + 10, framingRect.bottom + 10);
    }

    public void c(Canvas canvas) {
        Rect framingRect = getFramingRect();
        Path path = new Path();
        path.moveTo(framingRect.left, framingRect.top + this.f13637p);
        path.lineTo(framingRect.left, framingRect.top);
        path.lineTo(framingRect.left + this.f13637p, framingRect.top);
        canvas.drawPath(path, this.f13636o);
        path.moveTo(framingRect.right, framingRect.top + this.f13637p);
        path.lineTo(framingRect.right, framingRect.top);
        path.lineTo(framingRect.right - this.f13637p, framingRect.top);
        canvas.drawPath(path, this.f13636o);
        path.moveTo(framingRect.right, framingRect.bottom - this.f13637p);
        path.lineTo(framingRect.right, framingRect.bottom);
        path.lineTo(framingRect.right - this.f13637p, framingRect.bottom);
        canvas.drawPath(path, this.f13636o);
        path.moveTo(framingRect.left, framingRect.bottom - this.f13637p);
        path.lineTo(framingRect.left, framingRect.bottom);
        path.lineTo(framingRect.left + this.f13637p, framingRect.bottom);
        canvas.drawPath(path, this.f13636o);
    }

    public void d(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Rect framingRect = getFramingRect();
        float f10 = width;
        canvas.drawRect(0.0f, 0.0f, f10, framingRect.top, this.f13635n);
        canvas.drawRect(0.0f, framingRect.top, framingRect.left, framingRect.bottom + 1, this.f13635n);
        canvas.drawRect(framingRect.right + 1, framingRect.top, f10, framingRect.bottom + 1, this.f13635n);
        canvas.drawRect(0.0f, framingRect.bottom + 1, f10, height, this.f13635n);
    }

    public synchronized void f() {
        int width;
        int i10;
        Point point = new Point(getWidth(), getHeight());
        int a10 = f.a(getContext());
        if (this.f13638q) {
            width = (int) ((a10 != 1 ? getHeight() : getWidth()) * 0.625f);
            i10 = width;
        } else if (a10 != 1) {
            int height = (int) (getHeight() * 0.625f);
            i10 = height;
            width = (int) (height * 1.4f);
        } else {
            width = (int) (getWidth() * 0.75f);
            i10 = (int) (width * 0.75f);
        }
        if (width > getWidth()) {
            width = getWidth() - 50;
        }
        if (i10 > getHeight()) {
            i10 = getHeight() - 50;
        }
        int i11 = (point.x - width) / 2;
        int i12 = (point.y - i10) / 2;
        int i13 = this.f13640s;
        this.f13627f = new Rect(i11 + i13, i12 + i13, (i11 + width) - i13, (i12 + i10) - i13);
    }

    @Override // qb.g
    public Rect getFramingRect() {
        return this.f13627f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (getFramingRect() == null) {
            return;
        }
        d(canvas);
        c(canvas);
        if (this.f13639r) {
            b(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        f();
    }

    @Override // qb.g
    public void setBorderAlpha(float f10) {
        this.f13636o.setAlpha((int) (f10 * 255.0f));
    }

    @Override // qb.g
    public void setBorderColor(int i10) {
        this.f13636o.setColor(i10);
    }

    @Override // qb.g
    public void setBorderCornerRadius(int i10) {
        this.f13636o.setPathEffect(new CornerPathEffect(i10));
    }

    @Override // qb.g
    public void setBorderCornerRounded(boolean z10) {
        Paint paint;
        Paint.Join join;
        if (z10) {
            paint = this.f13636o;
            join = Paint.Join.ROUND;
        } else {
            paint = this.f13636o;
            join = Paint.Join.BEVEL;
        }
        paint.setStrokeJoin(join);
    }

    @Override // qb.g
    public void setBorderLineLength(int i10) {
        this.f13637p = i10;
    }

    @Override // qb.g
    public void setBorderStrokeWidth(int i10) {
        this.f13636o.setStrokeWidth(i10);
    }

    @Override // qb.g
    public void setLaserColor(int i10) {
        this.f13634m.setColor(i10);
    }

    @Override // qb.g
    public void setLaserEnabled(boolean z10) {
        this.f13639r = z10;
    }

    @Override // qb.g
    public void setMaskColor(int i10) {
        this.f13635n.setColor(i10);
    }

    @Override // qb.g
    public void setSquareViewFinder(boolean z10) {
        this.f13638q = z10;
    }

    public void setViewFinderOffset(int i10) {
        this.f13640s = i10;
    }
}
