package com.pichillilorenzo.flutter_inappwebview_android.proxy;

import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.ProxyRuleExt;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import t0.b;
import t0.d;
import t0.e;
import u0.C0724b;
import u0.F;
import u0.H;
import u0.s;

/* loaded from: classes.dex */
public class ProxyManager extends ChannelDelegateImpl {
    protected static final String LOG_TAG = "ProxyManager";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_inappwebview_proxycontroller";
    public static e proxyController;
    public InAppWebViewFlutterPlugin plugin;

    public ProxyManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        super(new MethodChannel(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
        this.plugin = inAppWebViewFlutterPlugin;
    }

    private void clearProxyOverride(final MethodChannel.Result result) {
        e eVar = proxyController;
        if (eVar != null) {
            Executor executor = new Executor() { // from class: com.pichillilorenzo.flutter_inappwebview_android.proxy.ProxyManager.3
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    runnable.run();
                }
            };
            Runnable runnable = new Runnable() { // from class: com.pichillilorenzo.flutter_inappwebview_android.proxy.ProxyManager.4
                @Override // java.lang.Runnable
                public void run() {
                    result.success(Boolean.TRUE);
                }
            };
            s sVar = (s) eVar;
            if (F.f6514E.b()) {
                if (sVar.f6569a == null) {
                    sVar.f6569a = H.f6549a.getProxyController();
                }
                sVar.f6569a.clearProxyOverride(runnable, executor);
                return;
            }
            throw F.a();
        }
    }

    public static void init() {
        if (proxyController == null && d.a("PROXY_OVERRIDE")) {
            if (d.a("PROXY_OVERRIDE")) {
                proxyController = d.f6372a;
                return;
            }
            throw new UnsupportedOperationException("Proxy override not supported");
        }
    }

    private void setProxyOverride(ProxySettings proxySettings, final MethodChannel.Result result) {
        boolean z3;
        if (proxyController != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = proxySettings.bypassRules.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next());
            }
            Iterator<String> it2 = proxySettings.directs.iterator();
            while (it2.hasNext()) {
                arrayList.add(new b(it2.next(), "direct://"));
            }
            for (ProxyRuleExt proxyRuleExt : proxySettings.proxyRules) {
                if (proxyRuleExt.getSchemeFilter() != null) {
                    arrayList.add(new b(proxyRuleExt.getSchemeFilter(), proxyRuleExt.getUrl()));
                } else {
                    arrayList.add(new b("*", proxyRuleExt.getUrl()));
                }
            }
            Boolean bool = proxySettings.bypassSimpleHostnames;
            if (bool != null && bool.booleanValue()) {
                arrayList2.add("<local>");
            }
            Boolean bool2 = proxySettings.removeImplicitRules;
            if (bool2 != null && bool2.booleanValue()) {
                arrayList2.add("<-loopback>");
            }
            if (proxySettings.reverseBypassEnabled != null && d.a("PROXY_OVERRIDE_REVERSE_BYPASS")) {
                z3 = proxySettings.reverseBypassEnabled.booleanValue();
            } else {
                z3 = false;
            }
            e eVar = proxyController;
            Executor executor = new Executor() { // from class: com.pichillilorenzo.flutter_inappwebview_android.proxy.ProxyManager.1
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    runnable.run();
                }
            };
            Runnable runnable = new Runnable() { // from class: com.pichillilorenzo.flutter_inappwebview_android.proxy.ProxyManager.2
                @Override // java.lang.Runnable
                public void run() {
                    result.success(Boolean.TRUE);
                }
            };
            s sVar = (s) eVar;
            sVar.getClass();
            C0724b c0724b = F.f6514E;
            C0724b c0724b2 = F.f6520K;
            List unmodifiableList = Collections.unmodifiableList(arrayList);
            String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, unmodifiableList.size(), 2);
            for (int i = 0; i < unmodifiableList.size(); i++) {
                strArr[i][0] = ((b) unmodifiableList.get(i)).f6370a;
                strArr[i][1] = ((b) unmodifiableList.get(i)).f6371b;
            }
            String[] strArr2 = (String[]) Collections.unmodifiableList(arrayList2).toArray(new String[0]);
            if (c0724b.b() && !z3) {
                if (sVar.f6569a == null) {
                    sVar.f6569a = H.f6549a.getProxyController();
                }
                sVar.f6569a.setProxyOverride(strArr, strArr2, runnable, executor);
            } else {
                if (c0724b.b() && c0724b2.b()) {
                    if (sVar.f6569a == null) {
                        sVar.f6569a = H.f6549a.getProxyController();
                    }
                    sVar.f6569a.setProxyOverride(strArr, strArr2, runnable, executor, z3);
                    return;
                }
                throw F.a();
            }
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.plugin = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        init();
        String str = methodCall.method;
        str.getClass();
        if (!str.equals("clearProxyOverride")) {
            if (!str.equals("setProxyOverride")) {
                result.notImplemented();
                return;
            }
            if (proxyController != null) {
                HashMap hashMap = (HashMap) methodCall.argument("settings");
                ProxySettings proxySettings = new ProxySettings();
                if (hashMap != null) {
                    proxySettings.parse2((Map<String, Object>) hashMap);
                }
                setProxyOverride(proxySettings, result);
                return;
            }
            result.success(Boolean.FALSE);
            return;
        }
        if (proxyController != null) {
            clearProxyOverride(result);
        } else {
            result.success(Boolean.FALSE);
        }
    }
}
