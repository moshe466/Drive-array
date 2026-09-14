package androidx.swiperefreshlayout.widget;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final RectF f3746a = new RectF();

    /* renamed from: b, reason: collision with root package name */
    public final Paint f3747b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f3748c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f3749d;

    /* renamed from: e, reason: collision with root package name */
    public float f3750e;

    /* renamed from: f, reason: collision with root package name */
    public float f3751f;

    /* renamed from: g, reason: collision with root package name */
    public float f3752g;

    /* renamed from: h, reason: collision with root package name */
    public float f3753h;
    public int[] i;

    /* renamed from: j, reason: collision with root package name */
    public int f3754j;

    /* renamed from: k, reason: collision with root package name */
    public float f3755k;

    /* renamed from: l, reason: collision with root package name */
    public float f3756l;

    /* renamed from: m, reason: collision with root package name */
    public float f3757m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3758n;

    /* renamed from: o, reason: collision with root package name */
    public Path f3759o;
    public float p;

    /* renamed from: q, reason: collision with root package name */
    public float f3760q;

    /* renamed from: r, reason: collision with root package name */
    public int f3761r;

    /* renamed from: s, reason: collision with root package name */
    public int f3762s;

    /* renamed from: t, reason: collision with root package name */
    public int f3763t;

    /* renamed from: u, reason: collision with root package name */
    public int f3764u;

    public d() {
        Paint paint = new Paint();
        this.f3747b = paint;
        Paint paint2 = new Paint();
        this.f3748c = paint2;
        Paint paint3 = new Paint();
        this.f3749d = paint3;
        this.f3750e = 0.0f;
        this.f3751f = 0.0f;
        this.f3752g = 0.0f;
        this.f3753h = 5.0f;
        this.p = 1.0f;
        this.f3763t = 255;
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint3.setColor(0);
    }

    public final void a(int i) {
        this.f3754j = i;
        this.f3764u = this.i[i];
    }
}
