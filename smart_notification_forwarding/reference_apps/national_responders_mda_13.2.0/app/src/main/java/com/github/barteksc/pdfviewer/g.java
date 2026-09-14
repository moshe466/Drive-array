package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends Handler {

    /* renamed from: f, reason: collision with root package name */
    private static final String f4663f = g.class.getName();

    /* renamed from: a, reason: collision with root package name */
    private PDFView f4664a;

    /* renamed from: b, reason: collision with root package name */
    private RectF f4665b;

    /* renamed from: c, reason: collision with root package name */
    private Rect f4666c;

    /* renamed from: d, reason: collision with root package name */
    private Matrix f4667d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f4668e;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ e1.b f4669f;

        a(e1.b bVar) {
            this.f4669f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f4664a.G(this.f4669f);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b1.a f4671f;

        b(b1.a aVar) {
            this.f4671f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f4664a.H(this.f4671f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        float f4673a;

        /* renamed from: b, reason: collision with root package name */
        float f4674b;

        /* renamed from: c, reason: collision with root package name */
        RectF f4675c;

        /* renamed from: d, reason: collision with root package name */
        int f4676d;

        /* renamed from: e, reason: collision with root package name */
        boolean f4677e;

        /* renamed from: f, reason: collision with root package name */
        int f4678f;

        /* renamed from: g, reason: collision with root package name */
        boolean f4679g;

        /* renamed from: h, reason: collision with root package name */
        boolean f4680h;

        c(g gVar, float f10, float f11, RectF rectF, int i10, boolean z10, int i11, boolean z11, boolean z12) {
            this.f4676d = i10;
            this.f4673a = f10;
            this.f4674b = f11;
            this.f4675c = rectF;
            this.f4677e = z10;
            this.f4678f = i11;
            this.f4679g = z11;
            this.f4680h = z12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Looper looper, PDFView pDFView) {
        super(looper);
        this.f4665b = new RectF();
        this.f4666c = new Rect();
        this.f4667d = new Matrix();
        this.f4668e = false;
        this.f4664a = pDFView;
    }

    private void c(int i10, int i11, RectF rectF) {
        this.f4667d.reset();
        float f10 = i10;
        float f11 = i11;
        this.f4667d.postTranslate((-rectF.left) * f10, (-rectF.top) * f11);
        this.f4667d.postScale(1.0f / rectF.width(), 1.0f / rectF.height());
        this.f4665b.set(0.0f, 0.0f, f10, f11);
        this.f4667d.mapRect(this.f4665b);
        this.f4665b.round(this.f4666c);
    }

    private e1.b d(c cVar) {
        f fVar = this.f4664a.f4559l;
        fVar.r(cVar.f4676d);
        int round = Math.round(cVar.f4673a);
        int round2 = Math.round(cVar.f4674b);
        if (round != 0 && round2 != 0 && !fVar.s(cVar.f4676d)) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(round, round2, cVar.f4679g ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                c(round, round2, cVar.f4675c);
                fVar.w(createBitmap, cVar.f4676d, this.f4666c, cVar.f4680h);
                return new e1.b(cVar.f4676d, createBitmap, cVar.f4675c, cVar.f4677e, cVar.f4678f);
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i10, float f10, float f11, RectF rectF, boolean z10, int i11, boolean z11, boolean z12) {
        sendMessage(obtainMessage(1, new c(this, f10, f11, rectF, i10, z10, i11, z11, z12)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f4668e = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f4668e = false;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            e1.b d10 = d((c) message.obj);
            if (d10 != null) {
                if (this.f4668e) {
                    this.f4664a.post(new a(d10));
                } else {
                    d10.d().recycle();
                }
            }
        } catch (b1.a e10) {
            this.f4664a.post(new b(e10));
        }
    }
}
