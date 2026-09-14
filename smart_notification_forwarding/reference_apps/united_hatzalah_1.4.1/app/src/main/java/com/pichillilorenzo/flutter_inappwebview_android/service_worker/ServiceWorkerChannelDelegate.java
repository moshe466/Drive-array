package com.pichillilorenzo.flutter_inappwebview_android.service_worker;

import com.pichillilorenzo.flutter_inappwebview_android.Util;
import com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.SyncBaseCallbackResultImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceRequestExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceResponseExt;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import t0.d;
import t0.j;
import u0.AbstractC0729g;
import u0.F;
import u0.v;
import u0.w;

/* loaded from: classes.dex */
public class ServiceWorkerChannelDelegate extends ChannelDelegateImpl {
    private ServiceWorkerManager serviceWorkerManager;

    /* loaded from: classes.dex */
    public static class ShouldInterceptRequestCallback extends BaseCallbackResultImpl<WebResourceResponseExt> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public WebResourceResponseExt decodeResult(Object obj) {
            return WebResourceResponseExt.fromMap((Map) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class SyncShouldInterceptRequestCallback extends SyncBaseCallbackResultImpl<WebResourceResponseExt> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public WebResourceResponseExt decodeResult(Object obj) {
            return new ShouldInterceptRequestCallback().decodeResult(obj);
        }
    }

    public ServiceWorkerChannelDelegate(ServiceWorkerManager serviceWorkerManager, MethodChannel methodChannel) {
        super(methodChannel);
        this.serviceWorkerManager = serviceWorkerManager;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.serviceWorkerManager = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        w wVar;
        ServiceWorkerManager.init();
        j jVar = ServiceWorkerManager.serviceWorkerController;
        if (jVar != null) {
            wVar = ((v) jVar).f6575c;
        } else {
            wVar = null;
        }
        String str = methodCall.method;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1332730774:
                if (str.equals("getAllowContentAccess")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1165005700:
                if (str.equals("setServiceWorkerClient")) {
                    c4 = 1;
                    break;
                }
                break;
            case -563397233:
                if (str.equals("getCacheMode")) {
                    c4 = 2;
                    break;
                }
                break;
            case 674894835:
                if (str.equals("getAllowFileAccess")) {
                    c4 = 3;
                    break;
                }
                break;
            case 985595395:
                if (str.equals("setCacheMode")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1083898794:
                if (str.equals("setBlockNetworkLoads")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1203480182:
                if (str.equals("setAllowContentAccess")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1594928487:
                if (str.equals("setAllowFileAccess")) {
                    c4 = 7;
                    break;
                }
                break;
            case 1694822198:
                if (str.equals("getBlockNetworkLoads")) {
                    c4 = '\b';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                if (wVar != null && d.a("SERVICE_WORKER_CONTENT_ACCESS")) {
                    F.f6533j.getClass();
                    result.success(Boolean.valueOf(AbstractC0729g.a(wVar.a())));
                    return;
                } else {
                    result.success(Boolean.FALSE);
                    return;
                }
            case 1:
                if (this.serviceWorkerManager != null) {
                    this.serviceWorkerManager.setServiceWorkerClient((Boolean) methodCall.argument("isNull"));
                    result.success(Boolean.TRUE);
                    return;
                }
                result.success(Boolean.FALSE);
                return;
            case 2:
                if (wVar != null && d.a("SERVICE_WORKER_CACHE_MODE")) {
                    F.i.getClass();
                    result.success(Integer.valueOf(AbstractC0729g.d(wVar.a())));
                    return;
                } else {
                    result.success(null);
                    return;
                }
            case 3:
                if (wVar != null && d.a("SERVICE_WORKER_FILE_ACCESS")) {
                    F.f6534k.getClass();
                    result.success(Boolean.valueOf(AbstractC0729g.b(wVar.a())));
                    return;
                } else {
                    result.success(Boolean.FALSE);
                    return;
                }
            case 4:
                if (wVar != null && d.a("SERVICE_WORKER_CACHE_MODE")) {
                    int intValue = ((Integer) methodCall.argument("mode")).intValue();
                    F.i.getClass();
                    AbstractC0729g.n(wVar.a(), intValue);
                }
                result.success(Boolean.TRUE);
                return;
            case 5:
                if (wVar != null && d.a("SERVICE_WORKER_BLOCK_NETWORK_LOADS")) {
                    boolean booleanValue = ((Boolean) methodCall.argument("flag")).booleanValue();
                    F.f6535l.getClass();
                    AbstractC0729g.m(wVar.a(), booleanValue);
                }
                result.success(Boolean.TRUE);
                return;
            case 6:
                if (wVar != null && d.a("SERVICE_WORKER_CONTENT_ACCESS")) {
                    boolean booleanValue2 = ((Boolean) methodCall.argument("allow")).booleanValue();
                    F.f6533j.getClass();
                    AbstractC0729g.k(wVar.a(), booleanValue2);
                }
                result.success(Boolean.TRUE);
                return;
            case 7:
                if (wVar != null && d.a("SERVICE_WORKER_FILE_ACCESS")) {
                    boolean booleanValue3 = ((Boolean) methodCall.argument("allow")).booleanValue();
                    F.f6534k.getClass();
                    AbstractC0729g.l(wVar.a(), booleanValue3);
                }
                result.success(Boolean.TRUE);
                return;
            case '\b':
                if (wVar != null && d.a("SERVICE_WORKER_BLOCK_NETWORK_LOADS")) {
                    F.f6535l.getClass();
                    result.success(Boolean.valueOf(AbstractC0729g.c(wVar.a())));
                    return;
                } else {
                    result.success(Boolean.FALSE);
                    return;
                }
            default:
                result.notImplemented();
                return;
        }
    }

    public void shouldInterceptRequest(WebResourceRequestExt webResourceRequestExt, ShouldInterceptRequestCallback shouldInterceptRequestCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("shouldInterceptRequest", webResourceRequestExt.toMap(), shouldInterceptRequestCallback);
    }

    public WebResourceResponseExt shouldInterceptRequest(WebResourceRequestExt webResourceRequestExt) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return null;
        }
        return (WebResourceResponseExt) Util.invokeMethodAndWaitResult(channel, "shouldInterceptRequest", webResourceRequestExt.toMap(), new SyncShouldInterceptRequestCallback());
    }
}
