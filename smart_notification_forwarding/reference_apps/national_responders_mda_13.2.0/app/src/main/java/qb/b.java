package qb;

import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: classes.dex */
public class b extends HandlerThread {

    /* renamed from: f, reason: collision with root package name */
    private qb.a f13602f;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f13603f;

        /* renamed from: qb.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0281a implements Runnable {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Camera f13605f;

            RunnableC0281a(Camera camera) {
                this.f13605f = camera;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f13602f.setupCameraPreview(e.a(this.f13605f, a.this.f13603f));
            }
        }

        a(int i10) {
            this.f13603f = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            new Handler(Looper.getMainLooper()).post(new RunnableC0281a(d.a(this.f13603f)));
        }
    }

    public b(qb.a aVar) {
        super("CameraHandlerThread");
        this.f13602f = aVar;
        start();
    }

    public void b(int i10) {
        new Handler(getLooper()).post(new a(i10));
    }
}
