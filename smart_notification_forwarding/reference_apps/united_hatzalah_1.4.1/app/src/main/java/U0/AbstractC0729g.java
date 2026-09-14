package u0;

import android.content.Context;
import android.webkit.ServiceWorkerClient;
import android.webkit.ServiceWorkerController;
import android.webkit.ServiceWorkerWebSettings;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import java.io.File;

/* renamed from: u0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0729g {
    public static boolean a(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getAllowContentAccess();
    }

    public static boolean b(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getAllowFileAccess();
    }

    public static boolean c(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getBlockNetworkLoads();
    }

    public static int d(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getCacheMode();
    }

    public static File e(Context context) {
        return context.getDataDir();
    }

    public static int f(WebSettings webSettings) {
        return webSettings.getDisabledActionModeMenuItems();
    }

    public static ServiceWorkerController g() {
        return ServiceWorkerController.getInstance();
    }

    public static ServiceWorkerWebSettings h(ServiceWorkerController serviceWorkerController) {
        return serviceWorkerController.getServiceWorkerWebSettings();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [u0.w, java.lang.Object] */
    public static w i(ServiceWorkerController serviceWorkerController) {
        ServiceWorkerWebSettings h2 = h(serviceWorkerController);
        ?? obj = new Object();
        obj.f6576a = h2;
        return obj;
    }

    public static boolean j(WebResourceRequest webResourceRequest) {
        return webResourceRequest.isRedirect();
    }

    public static void k(ServiceWorkerWebSettings serviceWorkerWebSettings, boolean z3) {
        serviceWorkerWebSettings.setAllowContentAccess(z3);
    }

    public static void l(ServiceWorkerWebSettings serviceWorkerWebSettings, boolean z3) {
        serviceWorkerWebSettings.setAllowFileAccess(z3);
    }

    public static void m(ServiceWorkerWebSettings serviceWorkerWebSettings, boolean z3) {
        serviceWorkerWebSettings.setBlockNetworkLoads(z3);
    }

    public static void n(ServiceWorkerWebSettings serviceWorkerWebSettings, int i) {
        serviceWorkerWebSettings.setCacheMode(i);
    }

    public static void o(WebSettings webSettings, int i) {
        webSettings.setDisabledActionModeMenuItems(i);
    }

    public static void p(ServiceWorkerController serviceWorkerController, ServiceWorkerClient serviceWorkerClient) {
        serviceWorkerController.setServiceWorkerClient(serviceWorkerClient);
    }

    public static void q(ServiceWorkerController serviceWorkerController, t0.h hVar) {
        serviceWorkerController.setServiceWorkerClient(new o(hVar));
    }
}
