package u0;

import android.webkit.WebViewRenderProcess;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;

/* loaded from: classes.dex */
public final class L extends t0.z {

    /* renamed from: c, reason: collision with root package name */
    public static final WeakHashMap f6554c = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    public WebViewRendererBoundaryInterface f6555a;

    /* renamed from: b, reason: collision with root package name */
    public WeakReference f6556b;

    @Override // t0.z
    public final boolean a() {
        C0724b c0724b = F.y;
        if (c0724b.a()) {
            WebViewRenderProcess g3 = io.flutter.plugin.platform.e.g(this.f6556b.get());
            if (g3 != null && AbstractC0734l.g(g3)) {
                return true;
            }
            return false;
        }
        if (c0724b.b()) {
            return this.f6555a.terminate();
        }
        throw F.a();
    }
}
