package u0;

import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.IsomorphicObjectBoundaryInterface;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;

/* loaded from: classes.dex */
public final class q implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6566a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IsomorphicObjectBoundaryInterface f6567b;

    public /* synthetic */ q(IsomorphicObjectBoundaryInterface isomorphicObjectBoundaryInterface, int i) {
        this.f6566a = i;
        this.f6567b = isomorphicObjectBoundaryInterface;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, u0.r] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, u0.L] */
    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f6566a) {
            case 0:
                JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface = (JsReplyProxyBoundaryInterface) this.f6567b;
                ?? obj = new Object();
                obj.f6568a = jsReplyProxyBoundaryInterface;
                return obj;
            default:
                WebViewRendererBoundaryInterface webViewRendererBoundaryInterface = (WebViewRendererBoundaryInterface) this.f6567b;
                ?? obj2 = new Object();
                obj2.f6555a = webViewRendererBoundaryInterface;
                return obj2;
        }
    }
}
