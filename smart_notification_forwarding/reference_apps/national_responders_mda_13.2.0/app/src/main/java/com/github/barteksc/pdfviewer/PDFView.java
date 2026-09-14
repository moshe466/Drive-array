package com.github.barteksc.pdfviewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.a;
import com.shockwave.pdfium.util.Size;
import d1.h;
import d1.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class PDFView extends RelativeLayout {
    private static final String O = PDFView.class.getSimpleName();
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private PdfiumCore E;
    private f1.a F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private PaintFlagsDrawFilter L;
    private int M;
    private List<Integer> N;

    /* renamed from: f, reason: collision with root package name */
    private float f4553f;

    /* renamed from: g, reason: collision with root package name */
    private float f4554g;

    /* renamed from: h, reason: collision with root package name */
    private float f4555h;

    /* renamed from: i, reason: collision with root package name */
    com.github.barteksc.pdfviewer.b f4556i;

    /* renamed from: j, reason: collision with root package name */
    private com.github.barteksc.pdfviewer.a f4557j;

    /* renamed from: k, reason: collision with root package name */
    private com.github.barteksc.pdfviewer.d f4558k;

    /* renamed from: l, reason: collision with root package name */
    f f4559l;

    /* renamed from: m, reason: collision with root package name */
    private int f4560m;

    /* renamed from: n, reason: collision with root package name */
    private float f4561n;

    /* renamed from: o, reason: collision with root package name */
    private float f4562o;

    /* renamed from: p, reason: collision with root package name */
    private float f4563p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f4564q;

    /* renamed from: r, reason: collision with root package name */
    private d f4565r;

    /* renamed from: s, reason: collision with root package name */
    private com.github.barteksc.pdfviewer.c f4566s;

    /* renamed from: t, reason: collision with root package name */
    private final HandlerThread f4567t;

    /* renamed from: u, reason: collision with root package name */
    g f4568u;

    /* renamed from: v, reason: collision with root package name */
    private e f4569v;

    /* renamed from: w, reason: collision with root package name */
    d1.a f4570w;

    /* renamed from: x, reason: collision with root package name */
    private Paint f4571x;

    /* renamed from: y, reason: collision with root package name */
    private Paint f4572y;

    /* renamed from: z, reason: collision with root package name */
    private h1.b f4573z;

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        private final g1.a f4574a;

        /* renamed from: b, reason: collision with root package name */
        private int[] f4575b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f4576c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f4577d;

        /* renamed from: e, reason: collision with root package name */
        private d1.b f4578e;

        /* renamed from: f, reason: collision with root package name */
        private d1.b f4579f;

        /* renamed from: g, reason: collision with root package name */
        private d1.d f4580g;

        /* renamed from: h, reason: collision with root package name */
        private d1.c f4581h;

        /* renamed from: i, reason: collision with root package name */
        private d1.e f4582i;

        /* renamed from: j, reason: collision with root package name */
        private d1.g f4583j;

        /* renamed from: k, reason: collision with root package name */
        private h f4584k;

        /* renamed from: l, reason: collision with root package name */
        private i f4585l;

        /* renamed from: m, reason: collision with root package name */
        private d1.f f4586m;

        /* renamed from: n, reason: collision with root package name */
        private c1.b f4587n;

        /* renamed from: o, reason: collision with root package name */
        private int f4588o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f4589p;

        /* renamed from: q, reason: collision with root package name */
        private boolean f4590q;

        /* renamed from: r, reason: collision with root package name */
        private String f4591r;

        /* renamed from: s, reason: collision with root package name */
        private f1.a f4592s;

        /* renamed from: t, reason: collision with root package name */
        private boolean f4593t;

        /* renamed from: u, reason: collision with root package name */
        private int f4594u;

        /* renamed from: v, reason: collision with root package name */
        private h1.b f4595v;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f4575b != null) {
                    b bVar = b.this;
                    PDFView.this.y(bVar.f4574a, b.this.f4591r, b.this.f4575b);
                } else {
                    b bVar2 = b.this;
                    PDFView.this.x(bVar2.f4574a, b.this.f4591r);
                }
            }
        }

        private b(g1.a aVar) {
            this.f4575b = null;
            this.f4576c = true;
            this.f4577d = true;
            this.f4587n = new c1.a(PDFView.this);
            this.f4588o = 0;
            this.f4589p = false;
            this.f4590q = false;
            this.f4591r = null;
            this.f4592s = null;
            this.f4593t = true;
            this.f4594u = 0;
            this.f4595v = h1.b.WIDTH;
            this.f4574a = aVar;
        }

        public b d(int i10) {
            this.f4588o = i10;
            return this;
        }

        public void e() {
            PDFView.this.I();
            PDFView.this.f4570w.o(this.f4580g);
            PDFView.this.f4570w.n(this.f4581h);
            PDFView.this.f4570w.l(this.f4578e);
            PDFView.this.f4570w.m(this.f4579f);
            PDFView.this.f4570w.p(this.f4582i);
            PDFView.this.f4570w.r(this.f4583j);
            PDFView.this.f4570w.s(this.f4584k);
            PDFView.this.f4570w.t(this.f4585l);
            PDFView.this.f4570w.q(this.f4586m);
            PDFView.this.f4570w.k(this.f4587n);
            PDFView.this.setSwipeEnabled(this.f4576c);
            PDFView.this.n(this.f4577d);
            PDFView.this.setDefaultPage(this.f4588o);
            PDFView.this.setSwipeVertical(!this.f4589p);
            PDFView.this.l(this.f4590q);
            PDFView.this.setScrollHandle(this.f4592s);
            PDFView.this.m(this.f4593t);
            PDFView.this.setSpacing(this.f4594u);
            PDFView.this.setPageFitPolicy(this.f4595v);
            PDFView.this.post(new a());
        }

        public b f(d1.e eVar) {
            this.f4582i = eVar;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum c {
        NONE,
        START,
        END
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum d {
        DEFAULT,
        LOADED,
        SHOWN,
        ERROR
    }

    public PDFView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4553f = 1.0f;
        this.f4554g = 1.75f;
        this.f4555h = 3.0f;
        c cVar = c.NONE;
        this.f4561n = 0.0f;
        this.f4562o = 0.0f;
        this.f4563p = 1.0f;
        this.f4564q = true;
        this.f4565r = d.DEFAULT;
        this.f4570w = new d1.a();
        this.f4573z = h1.b.WIDTH;
        this.A = 0;
        this.B = true;
        this.C = true;
        this.D = true;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = true;
        this.L = new PaintFlagsDrawFilter(0, 3);
        this.M = 0;
        this.N = new ArrayList(10);
        this.f4567t = new HandlerThread("PDF renderer");
        if (isInEditMode()) {
            return;
        }
        this.f4556i = new com.github.barteksc.pdfviewer.b();
        com.github.barteksc.pdfviewer.a aVar = new com.github.barteksc.pdfviewer.a(this);
        this.f4557j = aVar;
        this.f4558k = new com.github.barteksc.pdfviewer.d(this, aVar);
        this.f4569v = new e(this);
        this.f4571x = new Paint();
        Paint paint = new Paint();
        this.f4572y = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.E = new PdfiumCore(context);
        setWillNotDraw(false);
    }

    private void j(Canvas canvas, e1.b bVar) {
        float l10;
        float N;
        RectF c10 = bVar.c();
        Bitmap d10 = bVar.d();
        if (d10.isRecycled()) {
            return;
        }
        a7.a m10 = this.f4559l.m(bVar.b());
        if (this.B) {
            N = this.f4559l.l(bVar.b(), this.f4563p);
            l10 = N(this.f4559l.h() - m10.b()) / 2.0f;
        } else {
            l10 = this.f4559l.l(bVar.b(), this.f4563p);
            N = N(this.f4559l.f() - m10.a()) / 2.0f;
        }
        canvas.translate(l10, N);
        Rect rect = new Rect(0, 0, d10.getWidth(), d10.getHeight());
        float N2 = N(c10.left * m10.b());
        float N3 = N(c10.top * m10.a());
        RectF rectF = new RectF((int) N2, (int) N3, (int) (N2 + N(c10.width() * m10.b())), (int) (N3 + N(c10.height() * m10.a())));
        float f10 = this.f4561n + l10;
        float f11 = this.f4562o + N;
        if (rectF.left + f10 < getWidth() && f10 + rectF.right > 0.0f && rectF.top + f11 < getHeight() && f11 + rectF.bottom > 0.0f) {
            canvas.drawBitmap(d10, rect, rectF, this.f4571x);
            if (h1.a.f10423a) {
                this.f4572y.setColor(bVar.b() % 2 == 0 ? -65536 : -16776961);
                canvas.drawRect(rectF, this.f4572y);
            }
        }
        canvas.translate(-l10, -N);
    }

    private void k(Canvas canvas, int i10, d1.b bVar) {
        float f10;
        if (bVar != null) {
            float f11 = 0.0f;
            if (this.B) {
                f10 = this.f4559l.l(i10, this.f4563p);
            } else {
                f11 = this.f4559l.l(i10, this.f4563p);
                f10 = 0.0f;
            }
            canvas.translate(f11, f10);
            a7.a m10 = this.f4559l.m(i10);
            bVar.a(canvas, N(m10.b()), N(m10.a()), i10);
            canvas.translate(-f11, -f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultPage(int i10) {
        this.A = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageFitPolicy(h1.b bVar) {
        this.f4573z = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollHandle(f1.a aVar) {
        this.F = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpacing(int i10) {
        this.M = h1.e.a(getContext(), i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSwipeVertical(boolean z10) {
        this.B = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(g1.a aVar, String str) {
        y(aVar, str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(g1.a aVar, String str, int[] iArr) {
        if (!this.f4564q) {
            throw new IllegalStateException("Don't call load on a PDF View without recycling it first.");
        }
        this.f4564q = false;
        com.github.barteksc.pdfviewer.c cVar = new com.github.barteksc.pdfviewer.c(aVar, str, iArr, this, this.E);
        this.f4566s = cVar;
        cVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(Throwable th) {
        this.f4565r = d.ERROR;
        d1.c j10 = this.f4570w.j();
        I();
        invalidate();
        if (j10 != null) {
            j10.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        float f10;
        int width;
        if (this.f4559l.n() == 0) {
            return;
        }
        if (this.B) {
            f10 = this.f4562o;
            width = getHeight();
        } else {
            f10 = this.f4561n;
            width = getWidth();
        }
        int j10 = this.f4559l.j(-(f10 - (width / 2.0f)), this.f4563p);
        if (j10 < 0 || j10 > this.f4559l.n() - 1 || j10 == getCurrentPage()) {
            C();
        } else {
            M(j10);
        }
    }

    public void C() {
        g gVar;
        if (this.f4559l == null || (gVar = this.f4568u) == null) {
            return;
        }
        gVar.removeMessages(1);
        this.f4556i.i();
        this.f4569v.i();
        J();
    }

    public void D(float f10, float f11) {
        E(this.f4561n + f10, this.f4562o + f11);
    }

    public void E(float f10, float f11) {
        F(f10, f11, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0078, code lost:
    
        if (r7 > r0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
    
        r0 = com.github.barteksc.pdfviewer.PDFView.c.START;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
    
        r0 = com.github.barteksc.pdfviewer.PDFView.c.NONE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f0, code lost:
    
        if (r6 > r0) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void F(float r6, float r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.PDFView.F(float, float, boolean):void");
    }

    public void G(e1.b bVar) {
        if (this.f4565r == d.LOADED) {
            this.f4565r = d.SHOWN;
            this.f4570w.f(this.f4559l.n());
        }
        if (bVar.e()) {
            this.f4556i.c(bVar);
        } else {
            this.f4556i.b(bVar);
        }
        J();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(b1.a aVar) {
        if (this.f4570w.d(aVar.a(), aVar.getCause())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot open page ");
        sb2.append(aVar.a());
        aVar.getCause();
    }

    public void I() {
        this.f4557j.i();
        this.f4558k.b();
        g gVar = this.f4568u;
        if (gVar != null) {
            gVar.f();
            this.f4568u.removeMessages(1);
        }
        com.github.barteksc.pdfviewer.c cVar = this.f4566s;
        if (cVar != null) {
            cVar.cancel(true);
        }
        this.f4556i.j();
        f1.a aVar = this.F;
        if (aVar != null && this.G) {
            aVar.d();
        }
        f fVar = this.f4559l;
        if (fVar != null) {
            fVar.b();
            this.f4559l = null;
        }
        this.f4568u = null;
        this.F = null;
        this.G = false;
        this.f4562o = 0.0f;
        this.f4561n = 0.0f;
        this.f4563p = 1.0f;
        this.f4564q = true;
        this.f4570w = new d1.a();
        this.f4565r = d.DEFAULT;
    }

    void J() {
        invalidate();
    }

    public void K() {
        R(this.f4553f);
    }

    public void L(float f10, boolean z10) {
        if (this.B) {
            F(this.f4561n, ((-this.f4559l.e(this.f4563p)) + getHeight()) * f10, z10);
        } else {
            F(((-this.f4559l.e(this.f4563p)) + getWidth()) * f10, this.f4562o, z10);
        }
        B();
    }

    void M(int i10) {
        if (this.f4564q) {
            return;
        }
        this.f4560m = this.f4559l.a(i10);
        C();
        if (this.F != null && !i()) {
            this.F.b(this.f4560m + 1);
        }
        this.f4570w.c(this.f4560m, this.f4559l.n());
    }

    public float N(float f10) {
        return f10 * this.f4563p;
    }

    public void O(float f10, PointF pointF) {
        P(this.f4563p * f10, pointF);
    }

    public void P(float f10, PointF pointF) {
        float f11 = f10 / this.f4563p;
        Q(f10);
        float f12 = this.f4561n * f11;
        float f13 = this.f4562o * f11;
        float f14 = pointF.x;
        float f15 = pointF.y;
        E(f12 + (f14 - (f14 * f11)), f13 + (f15 - (f11 * f15)));
    }

    public void Q(float f10) {
        this.f4563p = f10;
    }

    public void R(float f10) {
        this.f4557j.h(getWidth() / 2, getHeight() / 2, this.f4563p, f10);
    }

    public void S(float f10, float f11, float f12) {
        this.f4557j.h(f10, f11, this.f4563p, f12);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        if (this.B) {
            if (i10 >= 0 || this.f4561n >= 0.0f) {
                return i10 > 0 && this.f4561n + N(this.f4559l.h()) > ((float) getWidth());
            }
            return true;
        }
        if (i10 >= 0 || this.f4561n >= 0.0f) {
            return i10 > 0 && this.f4561n + this.f4559l.e(this.f4563p) > ((float) getWidth());
        }
        return true;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        if (this.B) {
            if (i10 >= 0 || this.f4562o >= 0.0f) {
                return i10 > 0 && this.f4562o + this.f4559l.e(this.f4563p) > ((float) getHeight());
            }
            return true;
        }
        if (i10 >= 0 || this.f4562o >= 0.0f) {
            return i10 > 0 && this.f4562o + N(this.f4559l.f()) > ((float) getHeight());
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (isInEditMode()) {
            return;
        }
        this.f4557j.c();
    }

    public int getCurrentPage() {
        return this.f4560m;
    }

    public float getCurrentXOffset() {
        return this.f4561n;
    }

    public float getCurrentYOffset() {
        return this.f4562o;
    }

    public a.c getDocumentMeta() {
        f fVar = this.f4559l;
        if (fVar == null) {
            return null;
        }
        return fVar.i();
    }

    public float getMaxZoom() {
        return this.f4555h;
    }

    public float getMidZoom() {
        return this.f4554g;
    }

    public float getMinZoom() {
        return this.f4553f;
    }

    public int getPageCount() {
        f fVar = this.f4559l;
        if (fVar == null) {
            return 0;
        }
        return fVar.n();
    }

    public h1.b getPageFitPolicy() {
        return this.f4573z;
    }

    public float getPositionOffset() {
        float f10;
        float e10;
        int width;
        if (this.B) {
            f10 = -this.f4562o;
            e10 = this.f4559l.e(this.f4563p);
            width = getHeight();
        } else {
            f10 = -this.f4561n;
            e10 = this.f4559l.e(this.f4563p);
            width = getWidth();
        }
        return h1.c.c(f10 / (e10 - width), 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f1.a getScrollHandle() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSpacingPx() {
        return this.M;
    }

    public List<a.C0138a> getTableOfContents() {
        f fVar = this.f4559l;
        return fVar == null ? Collections.emptyList() : fVar.d();
    }

    public float getZoom() {
        return this.f4563p;
    }

    public boolean h() {
        return this.J;
    }

    public boolean i() {
        float e10 = this.f4559l.e(1.0f);
        return this.B ? e10 < ((float) getHeight()) : e10 < ((float) getWidth());
    }

    public void l(boolean z10) {
        this.I = z10;
    }

    public void m(boolean z10) {
        this.K = z10;
    }

    void n(boolean z10) {
        this.D = z10;
    }

    public b o(File file) {
        return new b(new g1.b(file));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        I();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            return;
        }
        if (this.K) {
            canvas.setDrawFilter(this.L);
        }
        Drawable background = getBackground();
        if (background == null) {
            canvas.drawColor(-1);
        } else {
            background.draw(canvas);
        }
        if (!this.f4564q && this.f4565r == d.SHOWN) {
            float f10 = this.f4561n;
            float f11 = this.f4562o;
            canvas.translate(f10, f11);
            Iterator<e1.b> it = this.f4556i.g().iterator();
            while (it.hasNext()) {
                j(canvas, it.next());
            }
            for (e1.b bVar : this.f4556i.f()) {
                j(canvas, bVar);
                if (this.f4570w.i() != null && !this.N.contains(Integer.valueOf(bVar.b()))) {
                    this.N.add(Integer.valueOf(bVar.b()));
                }
            }
            Iterator<Integer> it2 = this.N.iterator();
            while (it2.hasNext()) {
                k(canvas, it2.next().intValue(), this.f4570w.i());
            }
            this.N.clear();
            k(canvas, this.f4560m, this.f4570w.h());
            canvas.translate(-f10, -f11);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        if (isInEditMode() || this.f4565r != d.SHOWN) {
            return;
        }
        this.f4557j.i();
        this.f4559l.v(new Size(i10, i11));
        if (this.B) {
            f10 = this.f4561n;
            f11 = -this.f4559l.l(this.f4560m, this.f4563p);
        } else {
            f10 = -this.f4559l.l(this.f4560m, this.f4563p);
            f11 = this.f4562o;
        }
        E(f10, f11);
        B();
    }

    public boolean p() {
        return this.I;
    }

    public boolean q() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        return this.D;
    }

    public boolean s() {
        return this.C;
    }

    public void setMaxZoom(float f10) {
        this.f4555h = f10;
    }

    public void setMidZoom(float f10) {
        this.f4554g = f10;
    }

    public void setMinZoom(float f10) {
        this.f4553f = f10;
    }

    public void setPositionOffset(float f10) {
        L(f10, true);
    }

    public void setSwipeEnabled(boolean z10) {
        this.C = z10;
    }

    public boolean t() {
        return this.B;
    }

    public boolean u() {
        return this.f4563p != this.f4553f;
    }

    public void v(int i10) {
        w(i10, false);
    }

    public void w(int i10, boolean z10) {
        f fVar = this.f4559l;
        if (fVar == null) {
            return;
        }
        int a10 = fVar.a(i10);
        float f10 = -this.f4559l.l(a10, this.f4563p);
        if (this.B) {
            if (z10) {
                this.f4557j.g(this.f4562o, f10);
            } else {
                E(this.f4561n, f10);
            }
        } else if (z10) {
            this.f4557j.f(this.f4561n, f10);
        } else {
            E(f10, this.f4562o);
        }
        M(a10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(f fVar) {
        this.f4565r = d.LOADED;
        this.f4559l = fVar;
        if (!this.f4567t.isAlive()) {
            this.f4567t.start();
        }
        g gVar = new g(this.f4567t.getLooper(), this);
        this.f4568u = gVar;
        gVar.e();
        f1.a aVar = this.F;
        if (aVar != null) {
            aVar.e(this);
            this.G = true;
        }
        this.f4558k.c();
        this.f4570w.b(fVar.n());
        w(this.A, false);
    }
}
