package u0;

import android.webkit.ServiceWorkerWebSettings;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public ServiceWorkerWebSettings f6576a;

    public final ServiceWorkerWebSettings a() {
        if (this.f6576a == null) {
            J j2 = G.f6548a;
            this.f6576a = (ServiceWorkerWebSettings) ((WebkitToCompatConverterBoundaryInterface) j2.f6552b).convertServiceWorkerSettings(Proxy.getInvocationHandler(null));
        }
        return this.f6576a;
    }
}
