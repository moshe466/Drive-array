package io.flutter.embedding.engine.renderer;

import io.flutter.embedding.engine.renderer.FlutterRenderer;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5031a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5032b;

    public /* synthetic */ a(Object obj, int i) {
        this.f5031a = i;
        this.f5032b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5031a) {
            case 0:
                FlutterRenderer.ImageReaderSurfaceProducer.a((FlutterRenderer.ImageReaderSurfaceProducer) this.f5032b);
                return;
            default:
                FlutterRenderer.SurfaceTextureRegistryEntry.b((FlutterRenderer.SurfaceTextureRegistryEntry) this.f5032b);
                return;
        }
    }
}
