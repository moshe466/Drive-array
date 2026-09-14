package com.github.barteksc.pdfviewer;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.shockwave.pdfium.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener {

    /* renamed from: f, reason: collision with root package name */
    private PDFView f4619f;

    /* renamed from: g, reason: collision with root package name */
    private a f4620g;

    /* renamed from: h, reason: collision with root package name */
    private GestureDetector f4621h;

    /* renamed from: i, reason: collision with root package name */
    private ScaleGestureDetector f4622i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4623j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4624k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4625l = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PDFView pDFView, a aVar) {
        this.f4619f = pDFView;
        this.f4620g = aVar;
        this.f4621h = new GestureDetector(pDFView.getContext(), this);
        this.f4622i = new ScaleGestureDetector(pDFView.getContext(), this);
        pDFView.setOnTouchListener(this);
    }

    private boolean a(float f10, float f11) {
        int p10;
        int l10;
        PDFView pDFView = this.f4619f;
        f fVar = pDFView.f4559l;
        float f12 = (-pDFView.getCurrentXOffset()) + f10;
        float f13 = (-this.f4619f.getCurrentYOffset()) + f11;
        int j10 = fVar.j(this.f4619f.t() ? f13 : f12, this.f4619f.getZoom());
        a7.a o10 = fVar.o(j10, this.f4619f.getZoom());
        if (this.f4619f.t()) {
            l10 = (int) fVar.p(j10, this.f4619f.getZoom());
            p10 = (int) fVar.l(j10, this.f4619f.getZoom());
        } else {
            p10 = (int) fVar.p(j10, this.f4619f.getZoom());
            l10 = (int) fVar.l(j10, this.f4619f.getZoom());
        }
        int i10 = l10;
        int i11 = p10;
        for (a.b bVar : fVar.k(j10)) {
            RectF q10 = fVar.q(j10, i10, i11, (int) o10.b(), (int) o10.a(), bVar.a());
            if (q10.contains(f12, f13)) {
                this.f4619f.f4570w.a(new e1.a(f10, f11, f12, f13, q10, bVar));
                return true;
            }
        }
        return false;
    }

    private void d() {
        f1.a scrollHandle = this.f4619f.getScrollHandle();
        if (scrollHandle == null || !scrollHandle.f()) {
            return;
        }
        scrollHandle.c();
    }

    private void e(MotionEvent motionEvent) {
        this.f4619f.C();
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f4625l = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f4625l = true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        PDFView pDFView;
        float x10;
        float y10;
        float maxZoom;
        if (!this.f4619f.r()) {
            return false;
        }
        if (this.f4619f.getZoom() < this.f4619f.getMidZoom()) {
            pDFView = this.f4619f;
            x10 = motionEvent.getX();
            y10 = motionEvent.getY();
            maxZoom = this.f4619f.getMidZoom();
        } else {
            if (this.f4619f.getZoom() >= this.f4619f.getMaxZoom()) {
                this.f4619f.K();
                return true;
            }
            pDFView = this.f4619f;
            x10 = motionEvent.getX();
            y10 = motionEvent.getY();
            maxZoom = this.f4619f.getMaxZoom();
        }
        pDFView.S(x10, y10, maxZoom);
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f4620g.j();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        float f12;
        float N;
        if (!this.f4619f.s()) {
            return false;
        }
        int currentXOffset = (int) this.f4619f.getCurrentXOffset();
        int currentYOffset = (int) this.f4619f.getCurrentYOffset();
        PDFView pDFView = this.f4619f;
        f fVar = pDFView.f4559l;
        if (pDFView.t()) {
            f12 = -(this.f4619f.N(fVar.h()) - this.f4619f.getWidth());
            N = fVar.e(this.f4619f.getZoom());
        } else {
            f12 = -(fVar.e(this.f4619f.getZoom()) - this.f4619f.getWidth());
            N = this.f4619f.N(fVar.f());
        }
        this.f4620g.e(currentXOffset, currentYOffset, (int) f10, (int) f11, (int) f12, 0, (int) (-(N - this.f4619f.getHeight())), 0);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
    
        if (r1 > r2) goto L4;
     */
    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onScale(android.view.ScaleGestureDetector r5) {
        /*
            r4 = this;
            float r0 = r5.getScaleFactor()
            com.github.barteksc.pdfviewer.PDFView r1 = r4.f4619f
            float r1 = r1.getZoom()
            float r1 = r1 * r0
            float r2 = h1.a.b.f10430b
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 >= 0) goto L1b
        L12:
            com.github.barteksc.pdfviewer.PDFView r0 = r4.f4619f
            float r0 = r0.getZoom()
            float r0 = r2 / r0
            goto L22
        L1b:
            float r2 = h1.a.b.f10429a
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L22
            goto L12
        L22:
            com.github.barteksc.pdfviewer.PDFView r1 = r4.f4619f
            android.graphics.PointF r2 = new android.graphics.PointF
            float r3 = r5.getFocusX()
            float r5 = r5.getFocusY()
            r2.<init>(r3, r5)
            r1.O(r0, r2)
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.d.onScale(android.view.ScaleGestureDetector):boolean");
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.f4624k = true;
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.f4619f.C();
        d();
        this.f4624k = false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        this.f4623j = true;
        if (this.f4619f.u() || this.f4619f.s()) {
            this.f4619f.D(-f10, -f11);
        }
        if (!this.f4624k || this.f4619f.h()) {
            this.f4619f.B();
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        f1.a scrollHandle;
        boolean g10 = this.f4619f.f4570w.g(motionEvent);
        boolean a10 = a(motionEvent.getX(), motionEvent.getY());
        if (!g10 && !a10 && (scrollHandle = this.f4619f.getScrollHandle()) != null && !this.f4619f.i()) {
            if (scrollHandle.f()) {
                scrollHandle.h();
            } else {
                scrollHandle.a();
            }
        }
        this.f4619f.performClick();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f4625l) {
            return false;
        }
        boolean z10 = this.f4621h.onTouchEvent(motionEvent) || this.f4622i.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && this.f4623j) {
            this.f4623j = false;
            e(motionEvent);
        }
        return z10;
    }
}
