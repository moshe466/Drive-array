package com.github.barteksc.pdfviewer;

import android.graphics.RectF;
import h1.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private PDFView f4626a;

    /* renamed from: b, reason: collision with root package name */
    private int f4627b;

    /* renamed from: c, reason: collision with root package name */
    private float f4628c;

    /* renamed from: d, reason: collision with root package name */
    private float f4629d;

    /* renamed from: e, reason: collision with root package name */
    private float f4630e;

    /* renamed from: f, reason: collision with root package name */
    private float f4631f;

    /* renamed from: g, reason: collision with root package name */
    private float f4632g;

    /* renamed from: h, reason: collision with root package name */
    private float f4633h;

    /* renamed from: i, reason: collision with root package name */
    private final RectF f4634i = new RectF(0.0f, 0.0f, 1.0f, 1.0f);

    /* renamed from: j, reason: collision with root package name */
    private final int f4635j;

    /* renamed from: k, reason: collision with root package name */
    private final c f4636k;

    /* renamed from: l, reason: collision with root package name */
    private final c f4637l;

    /* renamed from: m, reason: collision with root package name */
    private final b f4638m;

    /* renamed from: n, reason: collision with root package name */
    private final b f4639n;

    /* renamed from: o, reason: collision with root package name */
    private final b f4640o;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        int f4641a;

        /* renamed from: b, reason: collision with root package name */
        int f4642b;

        private b(e eVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        int f4643a;

        /* renamed from: b, reason: collision with root package name */
        int f4644b;

        /* renamed from: c, reason: collision with root package name */
        int f4645c;

        private c(e eVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PDFView pDFView) {
        this.f4636k = new c();
        this.f4637l = new c();
        this.f4638m = new b();
        this.f4639n = new b();
        this.f4640o = new b();
        this.f4626a = pDFView;
        this.f4635j = h1.e.a(pDFView.getContext(), h1.a.f10426d);
    }

    private void a(b bVar) {
        float f10 = 1.0f / bVar.f4642b;
        this.f4630e = f10;
        float f11 = 1.0f / bVar.f4641a;
        this.f4631f = f11;
        float f12 = h1.a.f10425c;
        this.f4632g = f12 / f10;
        this.f4633h = f12 / f11;
    }

    private c b(c cVar, b bVar, float f10, float f11, boolean z10) {
        float e10;
        float f12;
        int b10;
        float f13 = -h1.c.d(f10, 0.0f);
        float f14 = -h1.c.d(f11, 0.0f);
        float f15 = this.f4626a.t() ? f14 : f13;
        PDFView pDFView = this.f4626a;
        int j10 = pDFView.f4559l.j(f15, pDFView.getZoom());
        cVar.f4643a = j10;
        c(bVar, j10);
        PDFView pDFView2 = this.f4626a;
        a7.a o10 = pDFView2.f4559l.o(cVar.f4643a, pDFView2.getZoom());
        float a10 = o10.a() / bVar.f4641a;
        float b11 = o10.b() / bVar.f4642b;
        PDFView pDFView3 = this.f4626a;
        float p10 = pDFView3.f4559l.p(cVar.f4643a, pDFView3.getZoom());
        if (this.f4626a.t()) {
            PDFView pDFView4 = this.f4626a;
            e10 = Math.abs(f14 - pDFView4.f4559l.l(cVar.f4643a, pDFView4.getZoom())) / a10;
            f12 = h1.c.e(f13 - p10, 0.0f) / b11;
        } else {
            PDFView pDFView5 = this.f4626a;
            float abs = Math.abs(f13 - pDFView5.f4559l.l(cVar.f4643a, pDFView5.getZoom())) / b11;
            e10 = h1.c.e(f14 - p10, 0.0f) / a10;
            f12 = abs;
        }
        if (z10) {
            cVar.f4644b = h1.c.a(e10);
            b10 = h1.c.a(f12);
        } else {
            cVar.f4644b = h1.c.b(e10);
            b10 = h1.c.b(f12);
        }
        cVar.f4645c = b10;
        return cVar;
    }

    private void c(b bVar, int i10) {
        a7.a m10 = this.f4626a.f4559l.m(i10);
        float b10 = 1.0f / m10.b();
        float a10 = (h1.a.f10425c * (1.0f / m10.a())) / this.f4626a.getZoom();
        float zoom = (h1.a.f10425c * b10) / this.f4626a.getZoom();
        bVar.f4641a = h1.c.a(1.0f / a10);
        bVar.f4642b = h1.c.a(1.0f / zoom);
    }

    private boolean d(int i10, int i11, int i12, float f10, float f11) {
        float f12 = i12 * f10;
        float f13 = i11 * f11;
        float f14 = this.f4632g;
        float f15 = this.f4633h;
        float f16 = f12 + f10 > 1.0f ? 1.0f - f12 : f10;
        float f17 = f13 + f11 > 1.0f ? 1.0f - f13 : f11;
        float f18 = f14 * f16;
        float f19 = f15 * f17;
        RectF rectF = new RectF(f12, f13, f16 + f12, f17 + f13);
        if (f18 <= 0.0f || f19 <= 0.0f) {
            return false;
        }
        if (!this.f4626a.f4556i.k(i10, rectF, this.f4627b)) {
            PDFView pDFView = this.f4626a;
            pDFView.f4568u.b(i10, f18, f19, rectF, false, this.f4627b, pDFView.q(), this.f4626a.p());
        }
        this.f4627b++;
        return true;
    }

    private int e(int i10, int i11, int i12, int i13, int i14, int i15) {
        int i16 = 0;
        while (i11 <= i12) {
            for (int i17 = i13; i17 <= i14; i17++) {
                if (d(i10, i11, i17, this.f4630e, this.f4631f)) {
                    i16++;
                }
                if (i16 >= i15) {
                    return i16;
                }
            }
            i11++;
        }
        return i16;
    }

    private int f(c cVar, c cVar2, b bVar, int i10) {
        a(bVar);
        return e(cVar.f4643a, cVar.f4644b, cVar2.f4644b, cVar.f4645c, cVar2.f4645c, i10);
    }

    private int g(c cVar, b bVar, int i10) {
        a(bVar);
        if (this.f4626a.t()) {
            return e(cVar.f4643a, cVar.f4644b, bVar.f4641a - 1, 0, bVar.f4642b - 1, i10);
        }
        return e(cVar.f4643a, 0, bVar.f4641a - 1, cVar.f4645c, bVar.f4642b - 1, i10);
    }

    private int h(c cVar, b bVar, int i10) {
        a(bVar);
        if (this.f4626a.t()) {
            return e(cVar.f4643a, 0, cVar.f4644b, 0, bVar.f4642b - 1, i10);
        }
        return e(cVar.f4643a, 0, bVar.f4641a - 1, 0, cVar.f4645c, i10);
    }

    private void j(int i10) {
        a7.a m10 = this.f4626a.f4559l.m(i10);
        float b10 = m10.b() * h1.a.f10424b;
        float a10 = m10.a() * h1.a.f10424b;
        if (this.f4626a.f4556i.d(i10, this.f4634i)) {
            return;
        }
        PDFView pDFView = this.f4626a;
        pDFView.f4568u.b(i10, b10, a10, this.f4634i, true, 0, pDFView.q(), this.f4626a.p());
    }

    private void k() {
        int i10;
        int i11;
        int l10;
        float zoom = this.f4635j * this.f4626a.getZoom();
        float f10 = this.f4628c;
        float f11 = (-f10) + zoom;
        float width = ((-f10) - this.f4626a.getWidth()) - zoom;
        float f12 = this.f4629d;
        b(this.f4636k, this.f4638m, f11, (-f12) + zoom, false);
        b(this.f4637l, this.f4639n, width, ((-f12) - this.f4626a.getHeight()) - zoom, true);
        int i12 = this.f4636k.f4643a;
        while (true) {
            i10 = this.f4637l.f4643a;
            if (i12 > i10) {
                break;
            }
            j(i12);
            i12++;
        }
        int i13 = this.f4636k.f4643a;
        int i14 = (i10 - i13) + 1;
        int i15 = 0;
        while (true) {
            c cVar = this.f4637l;
            int i16 = cVar.f4643a;
            if (i13 > i16 || i15 >= (i11 = a.C0186a.f10427a)) {
                return;
            }
            c cVar2 = this.f4636k;
            if (i13 == cVar2.f4643a && i14 > 1) {
                l10 = g(cVar2, this.f4638m, i11 - i15);
            } else if (i13 == i16 && i14 > 1) {
                l10 = h(cVar, this.f4639n, i11 - i15);
            } else if (i14 == 1) {
                l10 = f(cVar2, cVar, this.f4638m, i11 - i15);
            } else {
                c(this.f4640o, i13);
                l10 = l(i13, this.f4640o, a.C0186a.f10427a - i15);
            }
            i15 += l10;
            i13++;
        }
    }

    private int l(int i10, b bVar, int i11) {
        a(bVar);
        return e(i10, 0, bVar.f4641a - 1, 0, bVar.f4642b - 1, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        this.f4627b = 1;
        this.f4628c = -h1.c.d(this.f4626a.getCurrentXOffset(), 0.0f);
        this.f4629d = -h1.c.d(this.f4626a.getCurrentYOffset(), 0.0f);
        k();
    }
}
