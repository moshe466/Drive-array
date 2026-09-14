package com.pichillilorenzo.flutter_inappwebview_android.service_worker;

import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.types.Disposable;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceRequestExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceResponseExt;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayInputStream;
import java.util.Map;
import t0.d;
import t0.h;
import t0.i;
import t0.j;
import u0.AbstractC0729g;
import u0.F;
import u0.v;

/* loaded from: classes.dex */
public class ServiceWorkerManager implements Disposable {
    protected static final String LOG_TAG = "ServiceWorkerManager";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_inappwebview_serviceworkercontroller";
    public static j serviceWorkerController;
    public ServiceWorkerChannelDelegate channelDelegate;
    public InAppWebViewFlutterPlugin plugin;

    /* loaded from: classes.dex */
    public static final class DummyServiceWorkerClientCompat extends h {
        static final h INSTANCE = new DummyServiceWorkerClientCompat();

        private DummyServiceWorkerClientCompat() {
        }

        @Override // t0.h
        public WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
            return null;
        }
    }

    public ServiceWorkerManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        this.channelDelegate = new ServiceWorkerChannelDelegate(this, new MethodChannel(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
    }

    private h dummyServiceWorkerClientCompat() {
        return DummyServiceWorkerClientCompat.INSTANCE;
    }

    public static void init() {
        if (serviceWorkerController == null && d.a("SERVICE_WORKER_BASIC_USAGE")) {
            serviceWorkerController = i.f6373a;
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        ServiceWorkerChannelDelegate serviceWorkerChannelDelegate = this.channelDelegate;
        if (serviceWorkerChannelDelegate != null) {
            serviceWorkerChannelDelegate.dispose();
            this.channelDelegate = null;
        }
        this.plugin = null;
    }

    public void setServiceWorkerClient(Boolean bool) {
        h hVar;
        j jVar = serviceWorkerController;
        if (jVar != null) {
            if (bool.booleanValue()) {
                hVar = dummyServiceWorkerClientCompat();
            } else {
                hVar = new h() { // from class: com.pichillilorenzo.flutter_inappwebview_android.service_worker.ServiceWorkerManager.1
                    @Override // t0.h
                    public WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
                        WebResourceResponseExt shouldInterceptRequest;
                        WebResourceRequestExt fromWebResourceRequest = WebResourceRequestExt.fromWebResourceRequest(webResourceRequest);
                        ServiceWorkerChannelDelegate serviceWorkerChannelDelegate = ServiceWorkerManager.this.channelDelegate;
                        ByteArrayInputStream byteArrayInputStream = null;
                        if (serviceWorkerChannelDelegate != null) {
                            try {
                                shouldInterceptRequest = serviceWorkerChannelDelegate.shouldInterceptRequest(fromWebResourceRequest);
                            } catch (InterruptedException e4) {
                                Log.e(ServiceWorkerManager.LOG_TAG, "", e4);
                                return null;
                            }
                        } else {
                            shouldInterceptRequest = null;
                        }
                        if (shouldInterceptRequest == null) {
                            return null;
                        }
                        String contentType = shouldInterceptRequest.getContentType();
                        String contentEncoding = shouldInterceptRequest.getContentEncoding();
                        byte[] data = shouldInterceptRequest.getData();
                        Map<String, String> headers = shouldInterceptRequest.getHeaders();
                        Integer statusCode = shouldInterceptRequest.getStatusCode();
                        String reasonPhrase = shouldInterceptRequest.getReasonPhrase();
                        if (data != null) {
                            byteArrayInputStream = new ByteArrayInputStream(data);
                        }
                        ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
                        if (statusCode != null && reasonPhrase != null) {
                            return new WebResourceResponse(contentType, contentEncoding, statusCode.intValue(), reasonPhrase, headers, byteArrayInputStream2);
                        }
                        return new WebResourceResponse(contentType, contentEncoding, byteArrayInputStream2);
                    }
                };
            }
            v vVar = (v) jVar;
            F.f6532h.getClass();
            if (hVar == null) {
                if (vVar.f6573a == null) {
                    vVar.f6573a = AbstractC0729g.g();
                }
                AbstractC0729g.p(vVar.f6573a, null);
            } else {
                if (vVar.f6573a == null) {
                    vVar.f6573a = AbstractC0729g.g();
                }
                AbstractC0729g.q(vVar.f6573a, hVar);
            }
        }
    }
}
