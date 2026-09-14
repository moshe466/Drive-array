package qb;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.List;

/* loaded from: classes.dex */
public class c extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: f, reason: collision with root package name */
    private e f13607f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f13608g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f13609h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f13610i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f13611j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f13612k;

    /* renamed from: l, reason: collision with root package name */
    private Camera.PreviewCallback f13613l;

    /* renamed from: m, reason: collision with root package name */
    private float f13614m;

    /* renamed from: n, reason: collision with root package name */
    private Runnable f13615n;

    /* renamed from: o, reason: collision with root package name */
    Camera.AutoFocusCallback f13616o;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f13607f != null && c.this.f13609h && c.this.f13610i && c.this.f13611j) {
                c.this.i();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements Camera.AutoFocusCallback {
        b() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z10, Camera camera) {
            c.this.j();
        }
    }

    public c(Context context, e eVar, Camera.PreviewCallback previewCallback) {
        super(context);
        this.f13609h = true;
        this.f13610i = true;
        this.f13611j = false;
        this.f13612k = true;
        this.f13614m = 0.1f;
        this.f13615n = new a();
        this.f13616o = new b();
        h(eVar, previewCallback);
    }

    private void f(Camera.Size size) {
        Point g10 = g(new Point(getWidth(), getHeight()));
        float f10 = size.width / size.height;
        int i10 = g10.x;
        int i11 = g10.y;
        if (i10 / i11 > f10) {
            i10 = (int) (i11 * f10);
        } else {
            i11 = (int) (i10 / f10);
        }
        l(i10, i11);
    }

    private Point g(Point point) {
        return getDisplayOrientation() % 180 == 0 ? point : new Point(point.y, point.x);
    }

    private Camera.Size getOptimalPreviewSize() {
        e eVar = this.f13607f;
        Camera.Size size = null;
        if (eVar == null) {
            return null;
        }
        List<Camera.Size> supportedPreviewSizes = eVar.f13619a.getParameters().getSupportedPreviewSizes();
        int width = getWidth();
        int height = getHeight();
        if (f.a(getContext()) == 1) {
            height = width;
            width = height;
        }
        double d10 = width / height;
        if (supportedPreviewSizes == null) {
            return null;
        }
        double d11 = Double.MAX_VALUE;
        double d12 = Double.MAX_VALUE;
        for (Camera.Size size2 : supportedPreviewSizes) {
            if (Math.abs((size2.width / size2.height) - d10) <= this.f13614m && Math.abs(size2.height - height) < d12) {
                d12 = Math.abs(size2.height - height);
                size = size2;
            }
        }
        if (size == null) {
            for (Camera.Size size3 : supportedPreviewSizes) {
                if (Math.abs(size3.height - height) < d11) {
                    size = size3;
                    d11 = Math.abs(size3.height - height);
                }
            }
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f13608g.postDelayed(this.f13615n, 1000L);
    }

    private void l(int i10, int i11) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (getDisplayOrientation() % 180 != 0) {
            i11 = i10;
            i10 = i11;
        }
        if (this.f13612k) {
            float f10 = i10;
            float width = ((View) getParent()).getWidth() / f10;
            float f11 = i11;
            float height = ((View) getParent()).getHeight() / f11;
            if (width <= height) {
                width = height;
            }
            i10 = Math.round(f10 * width);
            i11 = Math.round(f11 * width);
        }
        layoutParams.width = i10;
        layoutParams.height = i11;
        setLayoutParams(layoutParams);
    }

    public int getDisplayOrientation() {
        int i10 = 0;
        if (this.f13607f == null) {
            return 0;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i11 = this.f13607f.f13620b;
        if (i11 == -1) {
            Camera.getCameraInfo(0, cameraInfo);
        } else {
            Camera.getCameraInfo(i11, cameraInfo);
        }
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation == 1) {
                i10 = 90;
            } else if (rotation == 2) {
                i10 = 180;
            } else if (rotation == 3) {
                i10 = 270;
            }
        }
        int i12 = cameraInfo.facing;
        int i13 = cameraInfo.orientation;
        return (i12 == 1 ? 360 - ((i13 + i10) % 360) : (i13 - i10) + 360) % 360;
    }

    public void h(e eVar, Camera.PreviewCallback previewCallback) {
        k(eVar, previewCallback);
        this.f13608g = new Handler();
        getHolder().addCallback(this);
        getHolder().setType(3);
    }

    public void i() {
        try {
            this.f13607f.f13619a.autoFocus(this.f13616o);
        } catch (RuntimeException unused) {
            j();
        }
    }

    public void k(e eVar, Camera.PreviewCallback previewCallback) {
        this.f13607f = eVar;
        this.f13613l = previewCallback;
    }

    public void m() {
        Camera.Size optimalPreviewSize = getOptimalPreviewSize();
        Camera.Parameters parameters = this.f13607f.f13619a.getParameters();
        parameters.setPreviewSize(optimalPreviewSize.width, optimalPreviewSize.height);
        this.f13607f.f13619a.setParameters(parameters);
        f(optimalPreviewSize);
    }

    public void n() {
        if (this.f13607f != null) {
            try {
                getHolder().addCallback(this);
                this.f13609h = true;
                m();
                this.f13607f.f13619a.setPreviewDisplay(getHolder());
                this.f13607f.f13619a.setDisplayOrientation(getDisplayOrientation());
                this.f13607f.f13619a.setOneShotPreviewCallback(this.f13613l);
                this.f13607f.f13619a.startPreview();
                if (this.f13610i) {
                    if (this.f13611j) {
                        i();
                    } else {
                        j();
                    }
                }
            } catch (Exception e10) {
                e10.toString();
            }
        }
    }

    public void o() {
        if (this.f13607f != null) {
            try {
                this.f13609h = false;
                getHolder().removeCallback(this);
                this.f13607f.f13619a.cancelAutoFocus();
                this.f13607f.f13619a.setOneShotPreviewCallback(null);
                this.f13607f.f13619a.stopPreview();
            } catch (Exception e10) {
                e10.toString();
            }
        }
    }

    public void setAspectTolerance(float f10) {
        this.f13614m = f10;
    }

    public void setAutoFocus(boolean z10) {
        if (this.f13607f == null || !this.f13609h || z10 == this.f13610i) {
            return;
        }
        this.f13610i = z10;
        if (!z10) {
            this.f13607f.f13619a.cancelAutoFocus();
        } else if (this.f13611j) {
            i();
        } else {
            j();
        }
    }

    public void setShouldScaleToFill(boolean z10) {
        this.f13612k = z10;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        o();
        n();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f13611j = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f13611j = false;
        o();
    }
}
