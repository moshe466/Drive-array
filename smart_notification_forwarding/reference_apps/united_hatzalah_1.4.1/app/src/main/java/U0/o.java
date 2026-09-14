package u0;

import android.webkit.ServiceWorkerClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;

/* loaded from: classes.dex */
public final class o extends ServiceWorkerClient {

    /* renamed from: a, reason: collision with root package name */
    public final t0.h f6564a;

    public o(t0.h hVar) {
        this.f6564a = hVar;
    }

    @Override // android.webkit.ServiceWorkerClient
    public final WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
        return this.f6564a.shouldInterceptRequest(webResourceRequest);
    }
}
