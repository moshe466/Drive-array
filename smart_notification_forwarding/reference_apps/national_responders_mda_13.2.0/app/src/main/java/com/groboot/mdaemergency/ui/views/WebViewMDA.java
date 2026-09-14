package com.groboot.mdaemergency.ui.views;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.groboot.mdaemergency.PirateHttpsRequest;
import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.models.Address;
import com.groboot.mdaemergency.models.CalendarEvent;
import com.groboot.mdaemergency.models.CoronaBarcodePatient;
import com.groboot.mdaemergency.models.Message;
import com.groboot.mdaemergency.models.SerologyQuestionnaire;
import com.groboot.mdaemergency.ui.views.WebViewMDA;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.UUID;
import s5.d;
import w6.h0;
import w6.l0;
import w6.n0;

/* loaded from: classes.dex */
public class WebViewMDA extends WebView {

    /* renamed from: f, reason: collision with root package name */
    private String f8408f;

    /* renamed from: g, reason: collision with root package name */
    Message f8409g;

    /* renamed from: h, reason: collision with root package name */
    k f8410h;

    /* renamed from: i, reason: collision with root package name */
    i f8411i;

    /* renamed from: j, reason: collision with root package name */
    Context f8412j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnLongClickListener {
        a(WebViewMDA webViewMDA) {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends WebChromeClient {
        b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            String unused = WebViewMDA.this.f8408f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onGeolocationPermissionsShowPrompt origin:");
            sb2.append(str);
            WebViewMDA.this.f8410h.o(str, callback);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            String unused = WebViewMDA.this.f8408f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onJsAlert ");
            sb2.append(str2);
            WebViewMDA.this.f8410h.i(str2);
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            String unused = WebViewMDA.this.f8408f;
            boolean r10 = com.groboot.mdaemergency.a.r(WebViewMDA.this.f8412j);
            boolean l10 = com.groboot.mdaemergency.a.l(WebViewMDA.this.f8412j);
            if (r10 && l10) {
                permissionRequest.grant(permissionRequest.getResources());
            } else {
                com.groboot.mdaemergency.a.e((Activity) WebViewMDA.this.f8412j, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"});
                permissionRequest.deny();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            return WebViewMDA.this.f8410h.l(valueCallback, fileChooserParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends WebViewClient {

        /* loaded from: classes.dex */
        class a extends e5.a<Collection<CalendarEvent>> {
            a(c cVar) {
            }
        }

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(String str, String str2) {
            if (str != null) {
                WebViewMDA.this.k(str, str2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(String str, String str2) {
            WebViewMDA.this.k(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(String str, String str2) {
            if (str != null) {
                WebViewMDA.this.k(str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            String unused = WebViewMDA.this.f8408f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onPageFinished url:");
            sb2.append(str);
            Message message = WebViewMDA.this.f8409g;
            if (message != null && message.HtmlOpen == 2 && webView.getTitle() != null && !webView.getTitle().equals("about:blank") && !webView.getTitle().startsWith("https://") && !webView.getTitle().startsWith("http://") && !webView.getTitle().equals(l0.Q(str))) {
                String unused2 = WebViewMDA.this.f8408f;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("set title:");
                sb3.append(webView.getTitle());
                WebViewMDA.this.f8411i.a(webView.getTitle());
                WebViewMDA.this.loadUrl("javascript:function _0x4646(_0x32d055,_0x1be6ea){const _0x1ea25c=_0x1ea2();return _0x4646=function(_0x46466b,_0x3d70ec){_0x46466b=_0x46466b-0x89;let _0x467d74=_0x1ea25c[_0x46466b];return _0x467d74;},_0x4646(_0x32d055,_0x1be6ea);}(function(_0x4be998,_0x98f9e6){const _0x5b10fe=_0x4646,_0x46636d=_0x4be998();while(!![]){try{const _0x39c485=-parseInt(_0x5b10fe(0xa2))/0x1+-parseInt(_0x5b10fe(0x9a))/0x2+parseInt(_0x5b10fe(0x95))/0x3*(-parseInt(_0x5b10fe(0x8c))/0x4)+parseInt(_0x5b10fe(0x9d))/0x5+parseInt(_0x5b10fe(0x90))/0x6*(-parseInt(_0x5b10fe(0x96))/0x7)+parseInt(_0x5b10fe(0x97))/0x8+parseInt(_0x5b10fe(0x8f))/0x9;if(_0x39c485===_0x98f9e6)break;else _0x46636d['push'](_0x46636d['shift']());}catch(_0x49ba0e){_0x46636d['push'](_0x46636d['shift']());}}}(_0x1ea2,0x48693),(function(){const _0x1db48f=_0x4646;let _0x35ff59=(((((window[_0x1db48f(0x91)]['href'][_0x1db48f(0x8d)]('/')||[])['find'](_0x32d4b2=>_0x32d4b2[_0x1db48f(0x8a)]('token='))||'')[_0x1db48f(0x8d)]('&')||[])[0x0]||'')[_0x1db48f(0x8d)](_0x1db48f(0x94))||[])[0x1];!_0x35ff59?(_0x35ff59=(((document[_0x1db48f(0x89)][_0x1db48f(0x8d)](';')||[])[_0x1db48f(0x9f)](_0x14857a=>(_0x14857a||'')[_0x1db48f(0x8a)](_0x1db48f(0x99)))||'')[_0x1db48f(0x8d)]('=')||[null,null])[0x1],_0x35ff59&&(_0x35ff59=encodeURIComponent(_0x35ff59)[_0x1db48f(0x98)](/%../g,_0x37b54f=>_0x37b54f[_0x1db48f(0x92)]())+_0x1db48f(0x9b),window['Android'][_0x1db48f(0xa1)](_0x1db48f(0x8b)+document[_0x1db48f(0x9c)]('html')[0x0]['innerHTML']+_0x1db48f(0x93),window[_0x1db48f(0x91)]['href']+_0x1db48f(0xa3)+_0x35ff59))):window[_0x1db48f(0x9e)][_0x1db48f(0xa1)](_0x1db48f(0x8b)+document[_0x1db48f(0x9c)](_0x1db48f(0xa4))[0x0][_0x1db48f(0x8e)]+_0x1db48f(0x93),window[_0x1db48f(0x91)][_0x1db48f(0xa0)]);}()));function _0x1ea2(){const _0x276691=['716OVnczG','split','innerHTML','7467525vwGwzp','12ubtCwS','location','toLowerCase','</html>','token=','5445myyaZh','240989uGNZuS','2897920hYCYqe','replace','Token','723704zsSAVH','%3d','getElementsByTagName','688345wDBZUC','Android','find','href','PirateGetMessage','277448xvZSnx','?token=','html','cookie','includes','<html>'];_0x1ea2=function(){return _0x276691;};return _0x1ea2();}");
            }
            WebViewMDA.this.r(str);
            WebViewMDA.this.f8411i.b();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            k kVar;
            String unused = WebViewMDA.this.f8408f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("shouldOverrideUrlLoading url:");
            sb2.append(str);
            w6.e.a("url " + str);
            if (str.startsWith("mda://")) {
                final String queryParameter = str.contains("jsFunction") ? Uri.parse(str).getQueryParameter("jsFunction") : null;
                try {
                    if (str.startsWith("mda://click?id=")) {
                        String replace = str.replace("mda://click?id=", "");
                        w6.e.a("id " + replace);
                        WebViewMDA.this.m(replace);
                        return true;
                    }
                    if (str.contains("close=true")) {
                        WebViewMDA.this.f8411i.c();
                    }
                    Uri parse = Uri.parse(str);
                    if (str.startsWith("mda://home")) {
                        WebViewMDA.this.f8410h.a();
                    } else {
                        if (str.contains("navigate")) {
                            String queryParameter2 = parse.getQueryParameter("lat");
                            String queryParameter3 = parse.getQueryParameter("ln");
                            WebViewMDA webViewMDA = WebViewMDA.this;
                            Context context = webViewMDA.f8412j;
                            if (context != null) {
                                l0.P0(context, queryParameter2, queryParameter3);
                                Context context2 = WebViewMDA.this.f8412j;
                                if (context2 instanceof Activity) {
                                    ((Activity) context2).finish();
                                }
                                kVar = WebViewMDA.this.f8410h;
                                if (kVar != null) {
                                }
                                return true;
                            }
                            kVar = webViewMDA.f8410h;
                            kVar.u(queryParameter2, queryParameter3);
                            return true;
                        }
                        if (str.contains("ExternalUrl")) {
                            WebViewMDA.this.f8410h.s(parse.getQueryParameter("url"));
                            return true;
                        }
                        if (str.contains("openurl")) {
                            WebViewMDA.this.f8410h.s(parse.getQueryParameter("url"));
                            return true;
                        }
                        if (str.contains("uploadFile")) {
                            WebViewMDA.this.f8410h.x(new h0(parse), new j() { // from class: com.groboot.mdaemergency.ui.views.g
                                @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.j
                                public final void a(String str2) {
                                    WebViewMDA.c.this.d(queryParameter, str2);
                                }
                            });
                            return true;
                        }
                        if (str.contains("reportmessage")) {
                            String queryParameter4 = parse.getQueryParameter("data");
                            String queryParameter5 = str.contains("refresh=") ? parse.getQueryParameter("refresh") : "0";
                            WebViewMDA webViewMDA2 = WebViewMDA.this;
                            webViewMDA2.f8410h.p(webViewMDA2.f8409g, queryParameter4, queryParameter5);
                            return true;
                        }
                        if (str.contains("openPDF")) {
                            WebViewMDA.this.f8410h.f(parse.getQueryParameter("url"), parse.getQueryParameter("title"), l0.U(parse.getQueryParameter("opentype")));
                            return true;
                        }
                        if (str.contains("ptt")) {
                            WebViewMDA.this.f8410h.g((com.groboot.mdaemergency.ptt.a) new com.google.gson.e().i(parse.getQueryParameter("pttContact"), com.groboot.mdaemergency.ptt.a.class));
                            return true;
                        }
                        if (str.contains("openVideo")) {
                            WebViewMDA.this.f8410h.e(parse.getQueryParameter("url"), parse.getQueryParameter("title"), l0.U(parse.getQueryParameter("waitSeconds")), l0.U(parse.getQueryParameter("opentype")));
                            return true;
                        }
                        if (str.contains("ZoomMeeting")) {
                            String queryParameter6 = parse.getQueryParameter("displayName");
                            String queryParameter7 = parse.getQueryParameter("meetingId");
                            String queryParameter8 = parse.getQueryParameter("password");
                            if (l0.l0(queryParameter6)) {
                                queryParameter6 = "משתמש אפליקציה";
                            }
                            WebViewMDA.this.f8410h.h(queryParameter7, queryParameter6, queryParameter8);
                            return true;
                        }
                        if (str.contains("openTokSession")) {
                            WebViewMDA.this.f8410h.m(parse.getQueryParameter("sessionId"), parse.getQueryParameter("token"));
                            return true;
                        }
                        if (str.contains("closeOpenTokSession")) {
                            WebViewMDA.this.f8410h.k(parse.getQueryParameter("sessionId"));
                            return true;
                        }
                        if (str.contains("errorMessage")) {
                            Toast.makeText(WebViewMDA.this.getContext(), parse.getQueryParameter("text"), 1).show();
                            return true;
                        }
                        if (str.contains("openWowza")) {
                            WebViewMDA.this.f8410h.w(parse.getQueryParameter("token"), parse.getQueryParameter("application"), parse.getQueryParameter("module"), parse.getQueryParameter("function"), parse.getQueryParameter("stream"));
                            return true;
                        }
                        if (str.contains("calendarEvent")) {
                            String queryParameter9 = parse.getQueryParameter("action");
                            parse.getQueryParameter("calendarId");
                            ArrayList arrayList = (ArrayList) new com.google.gson.e().j(parse.getQueryParameter("events"), new a(this).e());
                            final String queryParameter10 = parse.getQueryParameter("callback");
                            if (queryParameter9.equals("insert")) {
                                w6.c.c((Activity) WebViewMDA.this.f8412j, arrayList, new j() { // from class: com.groboot.mdaemergency.ui.views.h
                                    @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.j
                                    public final void a(String str2) {
                                        WebViewMDA.c.this.e(queryParameter10, str2);
                                    }
                                });
                            }
                            return true;
                        }
                        if (str.contains("openFolder")) {
                            WebViewMDA.this.f8410h.d(parse.getQueryParameter("title"), parse.getQueryParameter("folder"));
                            return true;
                        }
                        if (str.contains("download")) {
                            String queryParameter11 = parse.getQueryParameter("url");
                            String queryParameter12 = parse.getQueryParameter("title");
                            String queryParameter13 = parse.getQueryParameter("fileName");
                            String queryParameter14 = parse.getQueryParameter("folder");
                            if (l0.l0(queryParameter14)) {
                                queryParameter14 = "MADA";
                            }
                            WebViewMDA.this.f8410h.j(queryParameter11, queryParameter12, queryParameter13, queryParameter14);
                            return true;
                        }
                        if (str.contains("scanQR")) {
                            WebViewMDA.this.f8410h.b(new j() { // from class: com.groboot.mdaemergency.ui.views.i
                                @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.j
                                public final void a(String str2) {
                                    WebViewMDA.c.this.f(queryParameter, str2);
                                }
                            });
                            return true;
                        }
                        if (str.substring(6, 9).equals("stt")) {
                            WebViewMDA.this.f8410h.q(parse.getQueryParameter("title"), parse.getQueryParameter("jsFunction"));
                            return true;
                        }
                        if (str.substring(6, 9).equals("tts")) {
                            WebViewMDA.this.f8410h.v(parse.getQueryParameter("text"));
                            return true;
                        }
                        if (str.contains("getLocation")) {
                            WebViewMDA.this.g(queryParameter);
                            return true;
                        }
                        if (str.contains("printBarcode")) {
                            CoronaBarcodePatient coronaBarcodePatient = new CoronaBarcodePatient();
                            coronaBarcodePatient.PatientFirstName = parse.getQueryParameter("name");
                            coronaBarcodePatient.PatientLastName = parse.getQueryParameter("lastName");
                            coronaBarcodePatient.IdNum = parse.getQueryParameter("idNum");
                            coronaBarcodePatient.phoneNumber = parse.getQueryParameter("phone");
                            coronaBarcodePatient.BirthDate = parse.getQueryParameter("bDate");
                            coronaBarcodePatient.hmo = l0.U(parse.getQueryParameter("hmo"));
                            coronaBarcodePatient.hmoName = parse.getQueryParameter("hmoName");
                            coronaBarcodePatient.sex = parse.getQueryParameter("sex");
                            coronaBarcodePatient.Location = parse.getQueryParameter("city");
                            coronaBarcodePatient.SubLocation = parse.getQueryParameter("street");
                            coronaBarcodePatient.HouseNum = parse.getQueryParameter("house");
                            coronaBarcodePatient.UnitType = l0.U(parse.getQueryParameter("unitType"));
                            coronaBarcodePatient.IDType = l0.U(parse.getQueryParameter("idType"));
                            coronaBarcodePatient.barcode = parse.getQueryParameter("barcode");
                            coronaBarcodePatient.updateSampleTakenData = parse.getQueryParameter("updateSampleTakenData");
                            if (l0.l0(coronaBarcodePatient.siteDescription)) {
                                coronaBarcodePatient.siteDescription = (coronaBarcodePatient.Location + " " + coronaBarcodePatient.SubLocation + " " + coronaBarcodePatient.HouseNum).trim();
                            }
                            WebViewMDA.this.o(coronaBarcodePatient, queryParameter);
                            return true;
                        }
                        if (str.contains("showQuestionnaireSerology")) {
                            WebViewMDA.this.f8410h.r(new SerologyQuestionnaire(UUID.fromString(parse.getQueryParameter("patientKey"))));
                            return true;
                        }
                    }
                } catch (Exception e10) {
                    String unused2 = WebViewMDA.this.f8408f;
                    e10.getMessage();
                    e10.fillInStackTrace();
                }
            } else if (str.startsWith("tel:")) {
                WebViewMDA.this.f8410h.c(Uri.parse(str));
                return true;
            }
            Message message = WebViewMDA.this.f8409g;
            if (message != null) {
                message.HtmlURL = str;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements n0.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CoronaBarcodePatient f8415a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8416b;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!l0.l0(d.this.f8415a.updateSampleTakenData)) {
                    com.groboot.mdaemergency.async.d v10 = com.groboot.mdaemergency.async.d.v();
                    d dVar = d.this;
                    v10.i0(WebViewMDA.this.f8412j, dVar.f8415a);
                }
                d dVar2 = d.this;
                WebViewMDA.this.k(dVar2.f8416b, dVar2.f8415a.barcode);
            }
        }

        d(CoronaBarcodePatient coronaBarcodePatient, String str) {
            this.f8415a = coronaBarcodePatient;
            this.f8416b = str;
        }

        @Override // w6.n0.d
        public void a(String str) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("666 ");
            sb2.append(str);
            WebViewMDA.this.k(this.f8416b, this.f8415a.barcode);
            l0.L0(WebViewMDA.this.f8412j, str, true);
        }

        @Override // w6.n0.d
        public void b() {
            new Handler(Looper.getMainLooper()).post(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f8419f;

        /* loaded from: classes.dex */
        class a implements d.w {
            a() {
            }

            @Override // com.groboot.mdaemergency.async.d.w
            public void a(String str) {
            }

            @Override // com.groboot.mdaemergency.async.d.w
            public void b(Message message) {
                WebViewMDA.this.n(message);
            }
        }

        e(String str) {
            this.f8419f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.groboot.mdaemergency.async.d.v().B((Activity) WebViewMDA.this.f8412j, this.f8419f, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements d.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8422a;

        f(String str) {
            this.f8422a = str;
        }

        @Override // s5.d.e
        public void a(Location location) {
        }

        @Override // s5.d.e
        public void b(Location location) {
            WebViewMDA.this.k(this.f8422a, new com.google.gson.e().r(new Address(location.getLatitude(), location.getLongitude())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements k {
        g(WebViewMDA webViewMDA) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void a() {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void b(j jVar) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void c(Uri uri) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void d(String str, String str2) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void e(String str, String str2, int i10, int i11) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void f(String str, String str2, int i10) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void g(com.groboot.mdaemergency.ptt.a aVar) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void h(String str, String str2, String str3) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void i(String str) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void j(String str, String str2, String str3, String str4) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void k(String str) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public boolean l(ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            return true;
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void m(String str, String str2) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void n(Message message) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void o(String str, GeolocationPermissions.Callback callback) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void p(Message message, String str, String str2) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void q(String str, String str2) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void r(SerologyQuestionnaire serologyQuestionnaire) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void s(String str) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void t(WebViewMDA webViewMDA) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void u(String str, String str2) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void v(String str) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void w(String str, String str2, String str3, String str4, String str5) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void x(h0 h0Var, j jVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements i {
        h(WebViewMDA webViewMDA) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.i
        public void a(String str) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.i
        public void b() {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.i
        public void c() {
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(String str);

        void b();

        void c();
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(String str);
    }

    /* loaded from: classes.dex */
    public interface k {
        void a();

        void b(j jVar);

        void c(Uri uri);

        void d(String str, String str2);

        void e(String str, String str2, int i10, int i11);

        void f(String str, String str2, int i10);

        void g(com.groboot.mdaemergency.ptt.a aVar);

        void h(String str, String str2, String str3);

        void i(String str);

        void j(String str, String str2, String str3, String str4);

        void k(String str);

        boolean l(ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams);

        void m(String str, String str2);

        void n(Message message);

        void o(String str, GeolocationPermissions.Callback callback);

        void p(Message message, String str, String str2);

        void q(String str, String str2);

        void r(SerologyQuestionnaire serologyQuestionnaire);

        void s(String str);

        void t(WebViewMDA webViewMDA);

        void u(String str, String str2);

        void v(String str);

        void w(String str, String str2, String str3, String str4, String str5);

        void x(h0 h0Var, j jVar);
    }

    public WebViewMDA(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8408f = "WebViewMDA";
        h(context);
    }

    private i e() {
        return new h(this);
    }

    private k f() {
        return new g(this);
    }

    private WebChromeClient getChromeClient() {
        return new b();
    }

    private WebViewClient getClient() {
        return new c();
    }

    private void h(Context context) {
        this.f8412j = context;
        this.f8410h = f();
        this.f8411i = e();
        getSettings().setCacheMode(2);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setAllowUniversalAccessFromFileURLs(true);
        getSettings().setAllowFileAccess(true);
        getSettings().setAllowFileAccessFromFileURLs(true);
        getSettings().setPluginState(WebSettings.PluginState.ON);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        getSettings().setDomStorageEnabled(true);
        getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 19) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
        addJavascriptInterface(new l(), "Android");
        setLongClickable(false);
        setOnLongClickListener(new a(this));
        CookieSyncManager.createInstance(context);
        if (i10 >= 19) {
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            if (i10 >= 21) {
                cookieManager.setAcceptThirdPartyCookies(this, true);
            }
        }
        setWebViewClient(getClient());
        setWebChromeClient(getChromeClient());
    }

    private void i() {
        String str;
        String str2;
        getSettings().setBuiltInZoomControls(this.f8409g.ZoomEnable);
        getSettings().setDisplayZoomControls(false);
        getSettings().setUseWideViewPort(this.f8409g.ZoomEnable);
        Message message = this.f8409g;
        int i10 = message.HtmlType;
        if ((i10 == 1 || i10 == 3) && (str = message.HtmlContent) != null && str.length() > 0) {
            loadDataWithBaseURL(null, this.f8409g.HtmlContent, "text/html", "UTF-8", null);
            return;
        }
        Message message2 = this.f8409g;
        if (message2.HtmlType != 2 || (str2 = message2.HtmlURL) == null || str2.length() <= 0) {
            return;
        }
        loadUrl(this.f8409g.HtmlURL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(j jVar, String str) {
        if (jVar != null) {
            jVar.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str) {
        new Thread(new e(str)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(CoronaBarcodePatient coronaBarcodePatient, String str) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!defaultAdapter.isEnabled()) {
            defaultAdapter.enable();
        }
        if (!n0.f(this.f8412j).m()) {
            l0.L0(this.f8412j, "יש להגדיר מדפסת", true);
            return;
        }
        d dVar = new d(coronaBarcodePatient, str);
        int j10 = g5.b.i(this.f8412j).j();
        if (j10 == 1) {
            n0.e().r(coronaBarcodePatient, dVar);
        } else {
            n0.e().q(coronaBarcodePatient, j10 == 2, dVar);
        }
    }

    private String p(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        if (!lowerCase.contains("incident.aspx") && !lowerCase.contains("firstresponder.aspx") && !lowerCase.contains("team.aspx")) {
            return str;
        }
        String queryParameter = Uri.parse(str).getQueryParameter("token");
        String b10 = cc.a.b(str, "?");
        CookieManager.getInstance().setCookie(b10, String.format("Token=%s", queryParameter));
        return b10;
    }

    public void g(String str) {
        if (str == null) {
            return;
        }
        s5.d.j().g((Activity) this.f8412j, new f(str));
    }

    public void k(String str, String str2) {
        l(str, str2, null);
    }

    public void l(String str, String str2, final j jVar) {
        String str3 = str + "('" + str2 + "');";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("javascript:");
        sb2.append(str3);
        if (Build.VERSION.SDK_INT >= 19) {
            evaluateJavascript(str3, new ValueCallback() { // from class: v6.p
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    WebViewMDA.j(WebViewMDA.j.this, (String) obj);
                }
            });
            return;
        }
        loadUrl("javascript:" + str);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("loadUrl:");
        sb2.append(str);
        super.loadUrl(p(str));
    }

    public void n(Message message) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("id:");
        sb2.append(message.MessageID);
        sb2.append(" openType:");
        sb2.append(message.HtmlOpen);
        k kVar = this.f8410h;
        if (kVar != null) {
            kVar.n(message);
        }
    }

    @Override // android.webkit.WebView
    public void onResume() {
        super.onResume();
    }

    public void q() {
        if (getUrl() != null) {
            r(getUrl());
        }
    }

    public void r(String str) {
        new SimpleDateFormat("E, dd LLL yyyy HH:mm:ss z", Locale.ENGLISH).format(l0.e0());
        String cookie = CookieManager.getInstance().getCookie(str);
        if (cookie == null) {
            return;
        }
        for (String str2 : cookie.split(";")) {
            String str3 = str2.split("=")[0];
        }
    }

    public void setActionHandler(i iVar) {
        this.f8411i = iVar;
    }

    public void setClickHandler(k kVar) {
        this.f8410h = kVar;
        if (kVar != null) {
            kVar.t(this);
        }
    }

    public void setMessage(Message message) {
        this.f8409g = message;
        i();
    }

    /* loaded from: classes.dex */
    public class l {
        public l() {
        }

        @JavascriptInterface
        public void showToast(String str) {
            a6.h.j(WebViewMDA.this.f8412j, str, true, null);
        }

        @JavascriptInterface
        public void PirateGetMessage(String str, String Url) {
            new Thread(new PirateHttpsRequest("html", str, "url", Url, true)).start();
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        new Thread(new PirateHttpsRequest("html", str2, "url", "http://wwww.loadDataWithBaseURL.com", true)).start();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("loadDataWithBaseURL data:");
        sb2.append(str2);
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }
}
