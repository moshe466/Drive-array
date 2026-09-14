package qb;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public abstract class a extends FrameLayout implements Camera.PreviewCallback {

    /* renamed from: f, reason: collision with root package name */
    private e f13582f;

    /* renamed from: g, reason: collision with root package name */
    private c f13583g;

    /* renamed from: h, reason: collision with root package name */
    private g f13584h;

    /* renamed from: i, reason: collision with root package name */
    private Rect f13585i;

    /* renamed from: j, reason: collision with root package name */
    private b f13586j;

    /* renamed from: k, reason: collision with root package name */
    private Boolean f13587k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f13588l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f13589m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f13590n;

    /* renamed from: o, reason: collision with root package name */
    private int f13591o;

    /* renamed from: p, reason: collision with root package name */
    private int f13592p;

    /* renamed from: q, reason: collision with root package name */
    private int f13593q;

    /* renamed from: r, reason: collision with root package name */
    private int f13594r;

    /* renamed from: s, reason: collision with root package name */
    private int f13595s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f13596t;

    /* renamed from: u, reason: collision with root package name */
    private int f13597u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f13598v;

    /* renamed from: w, reason: collision with root package name */
    private float f13599w;

    /* renamed from: x, reason: collision with root package name */
    private int f13600x;

    /* renamed from: y, reason: collision with root package name */
    private float f13601y;

    public a(Context context) {
        super(context);
        this.f13588l = true;
        this.f13589m = true;
        this.f13590n = true;
        this.f13591o = getResources().getColor(h.f13622b);
        this.f13592p = getResources().getColor(h.f13621a);
        this.f13593q = getResources().getColor(h.f13623c);
        this.f13594r = getResources().getInteger(i.f13625b);
        this.f13595s = getResources().getInteger(i.f13624a);
        this.f13596t = false;
        this.f13597u = 0;
        this.f13598v = false;
        this.f13599w = 1.0f;
        this.f13600x = 0;
        this.f13601y = 0.1f;
        d();
    }

    private void d() {
        this.f13584h = a(getContext());
    }

    protected g a(Context context) {
        j jVar = new j(context);
        jVar.setBorderColor(this.f13592p);
        jVar.setLaserColor(this.f13591o);
        jVar.setLaserEnabled(this.f13590n);
        jVar.setBorderStrokeWidth(this.f13594r);
        jVar.setBorderLineLength(this.f13595s);
        jVar.setMaskColor(this.f13593q);
        jVar.setBorderCornerRounded(this.f13596t);
        jVar.setBorderCornerRadius(this.f13597u);
        jVar.setSquareViewFinder(this.f13598v);
        jVar.setViewFinderOffset(this.f13600x);
        return jVar;
    }

    public synchronized Rect b(int i10, int i11) {
        if (this.f13585i == null) {
            Rect framingRect = this.f13584h.getFramingRect();
            int width = this.f13584h.getWidth();
            int height = this.f13584h.getHeight();
            if (framingRect != null && width != 0 && height != 0) {
                Rect rect = new Rect(framingRect);
                if (i10 < width) {
                    rect.left = (rect.left * i10) / width;
                    rect.right = (rect.right * i10) / width;
                }
                if (i11 < height) {
                    rect.top = (rect.top * i11) / height;
                    rect.bottom = (rect.bottom * i11) / height;
                }
                this.f13585i = rect;
            }
            return null;
        }
        return this.f13585i;
    }

    public byte[] c(byte[] bArr, Camera camera) {
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        int i10 = previewSize.width;
        int i11 = previewSize.height;
        int rotationCount = getRotationCount();
        if (rotationCount == 1 || rotationCount == 3) {
            int i12 = 0;
            while (i12 < rotationCount) {
                byte[] bArr2 = new byte[bArr.length];
                for (int i13 = 0; i13 < i11; i13++) {
                    for (int i14 = 0; i14 < i10; i14++) {
                        bArr2[(((i14 * i11) + i11) - i13) - 1] = bArr[(i13 * i10) + i14];
                    }
                }
                i12++;
                bArr = bArr2;
                int i15 = i10;
                i10 = i11;
                i11 = i15;
            }
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        c cVar = this.f13583g;
        if (cVar != null) {
            cVar.n();
        }
    }

    public void f() {
        g(d.b());
    }

    public void g(int i10) {
        if (this.f13586j == null) {
            this.f13586j = new b(this);
        }
        this.f13586j.b(i10);
    }

    public boolean getFlash() {
        e eVar = this.f13582f;
        return eVar != null && d.c(eVar.f13619a) && this.f13582f.f13619a.getParameters().getFlashMode().equals("torch");
    }

    public int getRotationCount() {
        return this.f13583g.getDisplayOrientation() / 90;
    }

    public void h() {
        if (this.f13582f != null) {
            this.f13583g.o();
            this.f13583g.k(null, null);
            this.f13582f.f13619a.release();
            this.f13582f = null;
        }
        b bVar = this.f13586j;
        if (bVar != null) {
            bVar.quit();
            this.f13586j = null;
        }
    }

    public void i() {
        c cVar = this.f13583g;
        if (cVar != null) {
            cVar.o();
        }
    }

    public void setAspectTolerance(float f10) {
        this.f13601y = f10;
    }

    public void setAutoFocus(boolean z10) {
        this.f13588l = z10;
        c cVar = this.f13583g;
        if (cVar != null) {
            cVar.setAutoFocus(z10);
        }
    }

    public void setBorderAlpha(float f10) {
        this.f13599w = f10;
        this.f13584h.setBorderAlpha(f10);
        this.f13584h.a();
    }

    public void setBorderColor(int i10) {
        this.f13592p = i10;
        this.f13584h.setBorderColor(i10);
        this.f13584h.a();
    }

    public void setBorderCornerRadius(int i10) {
        this.f13597u = i10;
        this.f13584h.setBorderCornerRadius(i10);
        this.f13584h.a();
    }

    public void setBorderLineLength(int i10) {
        this.f13595s = i10;
        this.f13584h.setBorderLineLength(i10);
        this.f13584h.a();
    }

    public void setBorderStrokeWidth(int i10) {
        this.f13594r = i10;
        this.f13584h.setBorderStrokeWidth(i10);
        this.f13584h.a();
    }

    public void setFlash(boolean z10) {
        String str;
        this.f13587k = Boolean.valueOf(z10);
        e eVar = this.f13582f;
        if (eVar == null || !d.c(eVar.f13619a)) {
            return;
        }
        Camera.Parameters parameters = this.f13582f.f13619a.getParameters();
        if (z10) {
            str = "torch";
            if (parameters.getFlashMode().equals("torch")) {
                return;
            }
        } else {
            str = "off";
            if (parameters.getFlashMode().equals("off")) {
                return;
            }
        }
        parameters.setFlashMode(str);
        this.f13582f.f13619a.setParameters(parameters);
    }

    public void setIsBorderCornerRounded(boolean z10) {
        this.f13596t = z10;
        this.f13584h.setBorderCornerRounded(z10);
        this.f13584h.a();
    }

    public void setLaserColor(int i10) {
        this.f13591o = i10;
        this.f13584h.setLaserColor(i10);
        this.f13584h.a();
    }

    public void setLaserEnabled(boolean z10) {
        this.f13590n = z10;
        this.f13584h.setLaserEnabled(z10);
        this.f13584h.a();
    }

    public void setMaskColor(int i10) {
        this.f13593q = i10;
        this.f13584h.setMaskColor(i10);
        this.f13584h.a();
    }

    public void setShouldScaleToFill(boolean z10) {
        this.f13589m = z10;
    }

    public void setSquareViewFinder(boolean z10) {
        this.f13598v = z10;
        this.f13584h.setSquareViewFinder(z10);
        this.f13584h.a();
    }

    public void setupCameraPreview(e eVar) {
        this.f13582f = eVar;
        if (eVar != null) {
            setupLayout(eVar);
            this.f13584h.a();
            Boolean bool = this.f13587k;
            if (bool != null) {
                setFlash(bool.booleanValue());
            }
            setAutoFocus(this.f13588l);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setupLayout(e eVar) {
        c cVar;
        removeAllViews();
        c cVar2 = new c(getContext(), eVar, this);
        this.f13583g = cVar2;
        cVar2.setAspectTolerance(this.f13601y);
        this.f13583g.setShouldScaleToFill(this.f13589m);
        if (this.f13589m) {
            cVar = this.f13583g;
        } else {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setGravity(17);
            relativeLayout.setBackgroundColor(-16777216);
            relativeLayout.addView(this.f13583g);
            cVar = relativeLayout;
        }
        addView(cVar);
        Object obj = this.f13584h;
        if (!(obj instanceof View)) {
            throw new IllegalArgumentException("IViewFinder object returned by 'createViewFinderView()' should be instance of android.view.View");
        }
        addView((View) obj);
    }
}
