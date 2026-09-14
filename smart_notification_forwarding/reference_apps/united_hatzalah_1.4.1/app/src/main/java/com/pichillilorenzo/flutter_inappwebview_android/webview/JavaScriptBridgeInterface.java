package com.pichillilorenzo.flutter_inappwebview_android.webview;

import F0.AbstractC0008a;
import android.os.Handler;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.pichillilorenzo.flutter_inappwebview_android.print_job.PrintJobController;
import com.pichillilorenzo.flutter_inappwebview_android.print_job.PrintJobSettings;
import com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView;
import e0.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JavaScriptBridgeInterface {
    private static final String LOG_TAG = "JSBridgeInterface";
    private InAppWebView inAppWebView;

    public JavaScriptBridgeInterface(InAppWebView inAppWebView) {
        this.inAppWebView = inAppWebView;
    }

    @JavascriptInterface
    public void _callHandler(final String str, final String str2, final String str3) {
        if (this.inAppWebView == null) {
            return;
        }
        new Handler(this.inAppWebView.getWebViewLooper()).post(new Runnable() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.JavaScriptBridgeInterface.2
            @Override // java.lang.Runnable
            public void run() {
                String str4;
                if (JavaScriptBridgeInterface.this.inAppWebView != null) {
                    if (str.equals("onPrintRequest")) {
                        PrintJobSettings printJobSettings = new PrintJobSettings();
                        printJobSettings.handledByClient = Boolean.TRUE;
                        final String printCurrentPage = JavaScriptBridgeInterface.this.inAppWebView.printCurrentPage(printJobSettings);
                        if (JavaScriptBridgeInterface.this.inAppWebView != null && JavaScriptBridgeInterface.this.inAppWebView.channelDelegate != null) {
                            JavaScriptBridgeInterface.this.inAppWebView.channelDelegate.onPrintRequest(JavaScriptBridgeInterface.this.inAppWebView.getUrl(), printCurrentPage, new WebViewChannelDelegate.PrintRequestCallback() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.JavaScriptBridgeInterface.2.1
                                @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, io.flutter.plugin.common.MethodChannel.Result
                                public void error(String str5, String str6, Object obj) {
                                    StringBuilder i = a.i(str5, ", ");
                                    if (str6 == null) {
                                        str6 = "";
                                    }
                                    AbstractC0008a.B(i, str6, JavaScriptBridgeInterface.LOG_TAG);
                                    defaultBehaviour((Boolean) null);
                                }

                                @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
                                public void defaultBehaviour(Boolean bool) {
                                    PrintJobController printJobController;
                                    if (JavaScriptBridgeInterface.this.inAppWebView == null || JavaScriptBridgeInterface.this.inAppWebView.plugin == null || JavaScriptBridgeInterface.this.inAppWebView.plugin.printJobManager == null || (printJobController = JavaScriptBridgeInterface.this.inAppWebView.plugin.printJobManager.jobs.get(printCurrentPage)) == null) {
                                        return;
                                    }
                                    printJobController.disposeNoCancel();
                                }

                                @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
                                public boolean nonNullSuccess(Boolean bool) {
                                    return !bool.booleanValue();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (str.equals("callAsyncJavaScript")) {
                        try {
                            JSONObject jSONObject = new JSONArray(str3).getJSONObject(0);
                            String string = jSONObject.getString("resultUuid");
                            ValueCallback<String> valueCallback = JavaScriptBridgeInterface.this.inAppWebView.callAsyncJavaScriptCallbacks.get(string);
                            if (valueCallback != null) {
                                valueCallback.onReceiveValue(jSONObject.toString());
                                JavaScriptBridgeInterface.this.inAppWebView.callAsyncJavaScriptCallbacks.remove(string);
                                return;
                            }
                            return;
                        } catch (JSONException e4) {
                            Log.e(JavaScriptBridgeInterface.LOG_TAG, "", e4);
                            return;
                        }
                    }
                    if (str.equals("evaluateJavaScriptWithContentWorld")) {
                        try {
                            JSONObject jSONObject2 = new JSONArray(str3).getJSONObject(0);
                            String string2 = jSONObject2.getString("resultUuid");
                            ValueCallback<String> valueCallback2 = JavaScriptBridgeInterface.this.inAppWebView.evaluateJavaScriptContentWorldCallbacks.get(string2);
                            if (valueCallback2 != null) {
                                if (jSONObject2.has("value")) {
                                    str4 = jSONObject2.get("value").toString();
                                } else {
                                    str4 = "null";
                                }
                                valueCallback2.onReceiveValue(str4);
                                JavaScriptBridgeInterface.this.inAppWebView.evaluateJavaScriptContentWorldCallbacks.remove(string2);
                                return;
                            }
                            return;
                        } catch (JSONException e5) {
                            Log.e(JavaScriptBridgeInterface.LOG_TAG, "", e5);
                            return;
                        }
                    }
                    if (JavaScriptBridgeInterface.this.inAppWebView.channelDelegate != null) {
                        JavaScriptBridgeInterface.this.inAppWebView.channelDelegate.onCallJsHandler(str, str3, new WebViewChannelDelegate.CallJsHandlerCallback() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.JavaScriptBridgeInterface.2.2
                            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
                            public void defaultBehaviour(Object obj) {
                                if (JavaScriptBridgeInterface.this.inAppWebView == null) {
                                    return;
                                }
                                StringBuilder sb = new StringBuilder("if (window.flutter_inappwebview[");
                                sb.append(str2);
                                sb.append("] != null) { window.flutter_inappwebview[");
                                sb.append(str2);
                                sb.append("].resolve(");
                                sb.append(obj);
                                sb.append("); delete window.flutter_inappwebview[");
                                JavaScriptBridgeInterface.this.inAppWebView.evaluateJavascript(AbstractC0008a.u(sb, str2, "]; }"), null);
                            }

                            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, io.flutter.plugin.common.MethodChannel.Result
                            public void error(String str5, String str6, Object obj) {
                                String str7;
                                StringBuilder h2 = a.h(str5);
                                if (str6 != null) {
                                    str7 = ", ".concat(str6);
                                } else {
                                    str7 = "";
                                }
                                h2.append(str7);
                                String sb = h2.toString();
                                Log.e(JavaScriptBridgeInterface.LOG_TAG, sb);
                                if (JavaScriptBridgeInterface.this.inAppWebView == null) {
                                    return;
                                }
                                StringBuilder sb2 = new StringBuilder("if (window.flutter_inappwebview[");
                                sb2.append(str2);
                                sb2.append("] != null) { window.flutter_inappwebview[");
                                sb2.append(str2);
                                sb2.append("].reject(new Error(");
                                sb2.append(JSONObject.quote(sb));
                                sb2.append(")); delete window.flutter_inappwebview[");
                                JavaScriptBridgeInterface.this.inAppWebView.evaluateJavascript(AbstractC0008a.u(sb2, str2, "]; }"), null);
                            }
                        });
                    }
                }
            }
        });
    }

    @JavascriptInterface
    public void _hideContextMenu() {
        if (this.inAppWebView == null) {
            return;
        }
        new Handler(this.inAppWebView.getWebViewLooper()).post(new Runnable() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.JavaScriptBridgeInterface.1
            @Override // java.lang.Runnable
            public void run() {
                if (JavaScriptBridgeInterface.this.inAppWebView != null && JavaScriptBridgeInterface.this.inAppWebView.floatingContextMenu != null) {
                    JavaScriptBridgeInterface.this.inAppWebView.hideContextMenu();
                }
            }
        });
    }

    public void dispose() {
        this.inAppWebView = null;
    }
}
