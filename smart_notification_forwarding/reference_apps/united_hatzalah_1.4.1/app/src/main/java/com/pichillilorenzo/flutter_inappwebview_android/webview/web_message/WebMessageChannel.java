package com.pichillilorenzo.flutter_inappwebview_android.webview.web_message;

import F0.AbstractC0008a;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.pichillilorenzo.flutter_inappwebview_android.types.Disposable;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebMessageCompatExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebMessagePort;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebMessagePortCompatExt;
import com.pichillilorenzo.flutter_inappwebview_android.webview.InAppWebViewInterface;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView;
import e0.a;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import t0.d;
import t0.n;
import t0.o;
import t0.p;
import t0.y;
import u0.AbstractC0728f;
import u0.C0721B;
import u0.F;
import u0.J;

/* loaded from: classes.dex */
public class WebMessageChannel implements Disposable {
    protected static final String LOG_TAG = "WebMessageChannel";
    public static final String METHOD_CHANNEL_NAME_PREFIX = "com.pichillilorenzo/flutter_inappwebview_web_message_channel_";
    public WebMessageChannelChannelDelegate channelDelegate;
    public final List<p> compatPorts;
    public String id;
    public final List<WebMessagePort> ports;
    public InAppWebViewInterface webView;

    public WebMessageChannel(String str, InAppWebViewInterface inAppWebViewInterface) {
        p[] pVarArr;
        this.id = str;
        this.channelDelegate = new WebMessageChannelChannelDelegate(this, new MethodChannel(inAppWebViewInterface.getPlugin().messenger, a.d(METHOD_CHANNEL_NAME_PREFIX, str)));
        if (inAppWebViewInterface instanceof InAppWebView) {
            Uri uri = y.f6390a;
            F.f6545w.getClass();
            android.webkit.WebMessagePort[] c4 = AbstractC0728f.c((InAppWebView) inAppWebViewInterface);
            if (c4 == null) {
                pVarArr = null;
            } else {
                p[] pVarArr2 = new p[c4.length];
                for (int i = 0; i < c4.length; i++) {
                    pVarArr2[i] = new C0721B(c4[i]);
                }
                pVarArr = pVarArr2;
            }
            this.compatPorts = new ArrayList(Arrays.asList(pVarArr));
            this.ports = new ArrayList();
        } else {
            this.ports = Arrays.asList(new WebMessagePort("port1", this), new WebMessagePort("port2", this));
            this.compatPorts = new ArrayList();
        }
        this.webView = inAppWebViewInterface;
    }

    public void closeForInAppWebView(Integer num, MethodChannel.Result result) {
        if (this.webView != null && this.compatPorts.size() > 0 && d.a("WEB_MESSAGE_PORT_CLOSE")) {
            try {
                C0721B c0721b = (C0721B) this.compatPorts.get(num.intValue());
                c0721b.getClass();
                F.f6542t.getClass();
                AbstractC0728f.a(c0721b.c());
                result.success(Boolean.TRUE);
                return;
            } catch (Exception e4) {
                result.error(LOG_TAG, e4.getMessage(), null);
                return;
            }
        }
        result.success(Boolean.TRUE);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        if (d.a("WEB_MESSAGE_PORT_CLOSE")) {
            Iterator<p> it = this.compatPorts.iterator();
            while (it.hasNext()) {
                try {
                    C0721B c0721b = (C0721B) it.next();
                    c0721b.getClass();
                    F.f6542t.getClass();
                    AbstractC0728f.a(c0721b.c());
                } catch (Exception unused) {
                }
            }
        }
        WebMessageChannelChannelDelegate webMessageChannelChannelDelegate = this.channelDelegate;
        if (webMessageChannelChannelDelegate != null) {
            webMessageChannelChannelDelegate.dispose();
            this.channelDelegate = null;
        }
        this.compatPorts.clear();
        this.webView = null;
    }

    public void initJsInstance(InAppWebViewInterface inAppWebViewInterface, final ValueCallback<WebMessageChannel> valueCallback) {
        if (inAppWebViewInterface != null) {
            inAppWebViewInterface.evaluateJavascript(AbstractC0008a.u(new StringBuilder("(function() {window.flutter_inappwebview._webMessageChannels['"), this.id, "'] = new MessageChannel();})();"), null, new ValueCallback<String>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.web_message.WebMessageChannel.1
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str) {
                    valueCallback.onReceiveValue(this);
                }
            });
        } else {
            valueCallback.onReceiveValue(this);
        }
    }

    public void onMessage(int i, WebMessageCompatExt webMessageCompatExt) {
        WebMessageChannelChannelDelegate webMessageChannelChannelDelegate = this.channelDelegate;
        if (webMessageChannelChannelDelegate != null) {
            webMessageChannelChannelDelegate.onMessage(i, webMessageCompatExt);
        }
    }

    public void postMessageForInAppWebView(Integer num, WebMessageCompatExt webMessageCompatExt, MethodChannel.Result result) {
        String str;
        if (this.webView != null && this.compatPorts.size() > 0 && d.a("WEB_MESSAGE_PORT_POST_MESSAGE")) {
            p pVar = this.compatPorts.get(num.intValue());
            ArrayList arrayList = new ArrayList();
            List<WebMessagePortCompatExt> ports = webMessageCompatExt.getPorts();
            if (ports != null) {
                for (WebMessagePortCompatExt webMessagePortCompatExt : ports) {
                    WebMessageChannel webMessageChannel = this.webView.getWebMessageChannels().get(webMessagePortCompatExt.getWebMessageChannelId());
                    if (webMessageChannel != null) {
                        arrayList.add(webMessageChannel.compatPorts.get(webMessagePortCompatExt.getIndex()));
                    }
                }
            }
            Object data = webMessageCompatExt.getData();
            try {
                if (d.a("WEB_MESSAGE_ARRAY_BUFFER") && data != null && webMessageCompatExt.getType() == 1) {
                    pVar.a(new n((byte[]) data, (p[]) arrayList.toArray(new p[0])));
                } else {
                    if (data != null) {
                        str = data.toString();
                    } else {
                        str = null;
                    }
                    pVar.a(new n(str, (p[]) arrayList.toArray(new p[0])));
                }
                result.success(Boolean.TRUE);
                return;
            } catch (Exception e4) {
                result.error(LOG_TAG, e4.getMessage(), null);
                return;
            }
        }
        result.success(Boolean.TRUE);
    }

    public void setWebMessageCallbackForInAppWebView(final int i, MethodChannel.Result result) {
        if (this.webView != null && this.compatPorts.size() > 0 && d.a("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK")) {
            p pVar = this.compatPorts.get(i);
            try {
                o oVar = new o() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.web_message.WebMessageChannel.2
                    @Override // t0.o
                    public void onMessage(p pVar2, n nVar) {
                        WebMessageCompatExt webMessageCompatExt;
                        WebMessageChannel webMessageChannel = this;
                        int i3 = i;
                        if (nVar != null) {
                            webMessageCompatExt = WebMessageCompatExt.fromMapWebMessageCompat(nVar);
                        } else {
                            webMessageCompatExt = null;
                        }
                        webMessageChannel.onMessage(i3, webMessageCompatExt);
                    }
                };
                C0721B c0721b = (C0721B) pVar;
                c0721b.getClass();
                if (F.f6544v.b()) {
                    c0721b.b().setWebMessageCallback(new m3.a(new J(oVar, 2)));
                } else {
                    AbstractC0728f.l(c0721b.c(), oVar);
                }
                result.success(Boolean.TRUE);
                return;
            } catch (Exception e4) {
                result.error(LOG_TAG, e4.getMessage(), null);
                return;
            }
        }
        result.success(Boolean.TRUE);
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("id", this.id);
        return hashMap;
    }
}
