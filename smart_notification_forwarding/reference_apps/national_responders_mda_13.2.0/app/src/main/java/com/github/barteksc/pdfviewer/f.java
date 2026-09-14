package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseBooleanArray;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.a;
import com.shockwave.pdfium.util.Size;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class f {

    /* renamed from: q, reason: collision with root package name */
    private static final Object f4646q = new Object();

    /* renamed from: a, reason: collision with root package name */
    private com.shockwave.pdfium.a f4647a;

    /* renamed from: b, reason: collision with root package name */
    private PdfiumCore f4648b;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4657k;

    /* renamed from: l, reason: collision with root package name */
    private int f4658l;

    /* renamed from: o, reason: collision with root package name */
    private final h1.b f4661o;

    /* renamed from: p, reason: collision with root package name */
    private int[] f4662p;

    /* renamed from: c, reason: collision with root package name */
    private int f4649c = 0;

    /* renamed from: d, reason: collision with root package name */
    private List<Size> f4650d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private List<a7.a> f4651e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private SparseBooleanArray f4652f = new SparseBooleanArray();

    /* renamed from: g, reason: collision with root package name */
    private Size f4653g = new Size(0, 0);

    /* renamed from: h, reason: collision with root package name */
    private Size f4654h = new Size(0, 0);

    /* renamed from: i, reason: collision with root package name */
    private a7.a f4655i = new a7.a(0.0f, 0.0f);

    /* renamed from: j, reason: collision with root package name */
    private a7.a f4656j = new a7.a(0.0f, 0.0f);

    /* renamed from: m, reason: collision with root package name */
    private List<Float> f4659m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    private float f4660n = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PdfiumCore pdfiumCore, com.shockwave.pdfium.a aVar, h1.b bVar, Size size, int[] iArr, boolean z10, int i10) {
        this.f4657k = true;
        this.f4658l = 0;
        this.f4648b = pdfiumCore;
        this.f4647a = aVar;
        this.f4661o = bVar;
        this.f4662p = iArr;
        this.f4657k = z10;
        this.f4658l = i10;
        x(size);
    }

    private void t() {
        float f10 = 0.0f;
        for (a7.a aVar : this.f4651e) {
            f10 += this.f4657k ? aVar.a() : aVar.b();
        }
        this.f4660n = f10 + (this.f4658l * (this.f4651e.size() - 1));
    }

    private void u() {
        this.f4659m.clear();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < n(); i10++) {
            this.f4659m.add(Float.valueOf((this.f4658l * i10) + f10));
            a7.a aVar = this.f4651e.get(i10);
            f10 += this.f4657k ? aVar.a() : aVar.b();
        }
    }

    private void x(Size size) {
        int[] iArr = this.f4662p;
        this.f4649c = iArr != null ? iArr.length : this.f4648b.d(this.f4647a);
        for (int i10 = 0; i10 < this.f4649c; i10++) {
            Size f10 = this.f4648b.f(this.f4647a, c(i10));
            if (f10.b() > this.f4653g.b()) {
                this.f4653g = f10;
            }
            if (f10.a() > this.f4654h.a()) {
                this.f4654h = f10;
            }
            this.f4650d.add(f10);
        }
        v(size);
    }

    public int a(int i10) {
        int n10;
        if (i10 <= 0) {
            return 0;
        }
        int[] iArr = this.f4662p;
        if (iArr != null) {
            if (i10 >= iArr.length) {
                n10 = iArr.length;
                return n10 - 1;
            }
            return i10;
        }
        if (i10 >= n()) {
            n10 = n();
            return n10 - 1;
        }
        return i10;
    }

    public void b() {
        com.shockwave.pdfium.a aVar;
        PdfiumCore pdfiumCore = this.f4648b;
        if (pdfiumCore != null && (aVar = this.f4647a) != null) {
            pdfiumCore.a(aVar);
        }
        this.f4647a = null;
        this.f4662p = null;
    }

    public int c(int i10) {
        int i11;
        int[] iArr = this.f4662p;
        if (iArr == null) {
            i11 = i10;
        } else {
            if (i10 < 0 || i10 >= iArr.length) {
                return -1;
            }
            i11 = iArr[i10];
        }
        if (i11 < 0 || i10 >= n()) {
            return -1;
        }
        return i11;
    }

    public List<a.C0138a> d() {
        com.shockwave.pdfium.a aVar = this.f4647a;
        return aVar == null ? new ArrayList() : this.f4648b.g(aVar);
    }

    public float e(float f10) {
        return this.f4660n * f10;
    }

    public float f() {
        return g().a();
    }

    public a7.a g() {
        return this.f4657k ? this.f4656j : this.f4655i;
    }

    public float h() {
        return g().b();
    }

    public a.c i() {
        com.shockwave.pdfium.a aVar = this.f4647a;
        if (aVar == null) {
            return null;
        }
        return this.f4648b.b(aVar);
    }

    public int j(float f10, float f11) {
        Iterator<Float> it = this.f4659m.iterator();
        int i10 = 0;
        while (it.hasNext() && it.next().floatValue() * f11 < f10) {
            i10++;
        }
        int i11 = i10 - 1;
        if (i11 >= 0) {
            return i11;
        }
        return 0;
    }

    public List<a.b> k(int i10) {
        return this.f4648b.e(this.f4647a, c(i10));
    }

    public float l(int i10, float f10) {
        if (c(i10) < 0) {
            return 0.0f;
        }
        return this.f4659m.get(i10).floatValue() * f10;
    }

    public a7.a m(int i10) {
        return c(i10) < 0 ? new a7.a(0.0f, 0.0f) : this.f4651e.get(i10);
    }

    public int n() {
        return this.f4649c;
    }

    public a7.a o(int i10, float f10) {
        a7.a m10 = m(c(i10));
        return new a7.a(m10.b() * f10, m10.a() * f10);
    }

    public float p(int i10, float f10) {
        float f11;
        float a10;
        a7.a m10 = m(i10);
        if (this.f4657k) {
            f11 = h();
            a10 = m10.b();
        } else {
            f11 = f();
            a10 = m10.a();
        }
        return (f10 * (f11 - a10)) / 2.0f;
    }

    public RectF q(int i10, int i11, int i12, int i13, int i14, RectF rectF) {
        return this.f4648b.i(this.f4647a, c(i10), i11, i12, i13, i14, 0, rectF);
    }

    public boolean r(int i10) {
        int c10 = c(i10);
        if (c10 < 0) {
            return false;
        }
        synchronized (f4646q) {
            if (this.f4652f.indexOfKey(c10) >= 0) {
                return false;
            }
            try {
                this.f4648b.k(this.f4647a, c10);
                this.f4652f.put(c10, true);
                return true;
            } catch (Exception e10) {
                this.f4652f.put(c10, false);
                throw new b1.a(i10, e10);
            }
        }
    }

    public boolean s(int i10) {
        return !this.f4652f.get(c(i10), false);
    }

    public void v(Size size) {
        this.f4651e.clear();
        h1.d dVar = new h1.d(this.f4661o, this.f4653g, this.f4654h, size);
        this.f4656j = dVar.g();
        this.f4655i = dVar.f();
        Iterator<Size> it = this.f4650d.iterator();
        while (it.hasNext()) {
            this.f4651e.add(dVar.a(it.next()));
        }
        t();
        u();
    }

    public void w(Bitmap bitmap, int i10, Rect rect, boolean z10) {
        this.f4648b.m(this.f4647a, bitmap, c(i10), rect.left, rect.top, rect.width(), rect.height(), z10);
    }
}
